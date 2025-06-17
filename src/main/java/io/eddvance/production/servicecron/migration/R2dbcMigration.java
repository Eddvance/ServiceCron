package io.eddvance.production.servicecron.migration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class R2dbcMigration {

    private static final Logger log = LoggerFactory.getLogger(R2dbcMigration.class);
    private final DatabaseClient databaseClient;

    public R2dbcMigration(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Mono<Void> migrate() {
        log.info("Création des tables...");

        String sql = """
                CREATE TABLE IF NOT EXISTS rate_history (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    rate DECIMAL(10,4) NOT NULL,
                    rate_time TIMESTAMP NOT NULL
                )
                """;

        return databaseClient.sql(sql)
                .then()
                .doOnSuccess(v -> log.info("✅ Table créée"));
    }
}