package com.example.gs.repo

import com.example.gs.model.Order
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepo extends CassandraRepository<Order,Long> {
}
