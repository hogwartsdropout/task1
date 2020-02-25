package com.example.wfapp.handler;


import com.example.wfapp.model.Order;
import com.example.wfapp.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static reactor.core.publisher.Mono.from;
import static reactor.core.publisher.Mono.just;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

import java.util.UUID;

@Component
public class OrderHandler {
    @Autowired
    OrderRepo repo;

    public Mono<ServerResponse> get(ServerRequest request){
        final UUID id = UUID.fromString(request.pathVariable("id"));
        final Mono<Order> order = repo.findById(id);
        return order.flatMap(p -> ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(order,Order.class)))
                .switchIfEmpty(notFound().build());
    }
    public Mono<ServerResponse> add(ServerRequest request){
        final Mono<Order> orderToSave = request.bodyToMono(Order.class);
        final UUID id = UUID.randomUUID();
        return created(UriComponentsBuilder.fromPath("order/"+id).build().toUri())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(
                        orderToSave.map(p -> new Order(p,id)).flatMap(repo::save), Order.class));
    }
}
