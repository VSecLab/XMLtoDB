package com.unicampania.xmltodb.writer.writer_evaluation_assurance_levels;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_evaluation_assurance_levels.EalPreparedStatementSetter;
import com.unicampania.xmltodb.model.evaluation_assurance_levels.Eal;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterEAL {
    public JdbcBatchItemWriter<Eal> writerEAL(DataSource dataSource) {
        JdbcBatchItemWriter<Eal> writer = new JdbcBatchItemWriter<Eal>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO eal(id_eal, name) VALUES (?,?) ON DUPLICATE KEY UPDATE id_eal = ?");
        writer.setItemPreparedStatementSetter(new EalPreparedStatementSetter());
        return writer;
    }
}
