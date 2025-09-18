package ru.practicum.stat.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.practicum.stat.server.model.Requests;
import ru.practicum.stat.server.model.Response;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<Requests, Integer> {

    @Query("SELECT new ru.practicum.stat.server.model.Response(" +
           "r.application, r.uri, COUNT(r.ip)) " +
           "FROM Requests r " +
           "WHERE r.moment BETWEEN :start AND :end " +
           "GROUP BY r.application, r.uri " +
           "ORDER BY COUNT(r.ip) DESC")
    List<Response> findAll(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("SELECT new ru.practicum.stat.server.model.Response(" +
           "r.application, r.uri, COUNT(DISTINCT r.ip)) " +
           "FROM Requests r " +
           "WHERE r.moment BETWEEN :start AND :end " +
           "GROUP BY r.application, r.uri " +
           "ORDER BY COUNT(DISTINCT r.ip) DESC")
    List<Response> findAllUnique(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("SELECT new ru.practicum.stat.server.model.Response(" +
           "r.application, r.uri, COUNT(r.ip)) " +
           "FROM Requests r " +
           "WHERE r.moment BETWEEN :start AND :end " +
           "AND r.uri IN :uris " +
           "GROUP BY r.application, r.uri " +
           "ORDER BY COUNT(r.ip) DESC")
    List<Response> findUris(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end,
            @Param("uris") List<String> uris
    );

    @Query("SELECT new ru.practicum.stat.server.model.Response(" +
           "r.application, r.uri, COUNT(DISTINCT r.ip)) " +
           "FROM Requests r " +
           "WHERE r.moment BETWEEN :start AND :end " +
           "AND r.uri IN :uris " +
           "GROUP BY r.application, r.uri " +
           "ORDER BY COUNT(DISTINCT r.ip) DESC")
    List<Response> findUrisUnique(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end,
            @Param("uris") List<String> uris
    );
}
