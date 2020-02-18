package com.unicampania.xmltodb.writer.writer_evaluation_assurance_levels;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_evaluation_assurance_levels.EalAssuranceComponentsPreparedStatementSetter;
import com.unicampania.xmltodb.model.evaluation_assurance_levels.Eal;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterEalAssuranceComponents {
    public JdbcBatchItemWriter<Eal> writerEalAssuranceComponents(DataSource dataSource) {
        JdbcBatchItemWriter<Eal> writer = new JdbcBatchItemWriter<Eal>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ealassurancecomponents(id_ealassurancecomponents, testo, id_eal) VALUES (?,?,?) ON DUPLICATE KEY UPDATE id_ealassurancecomponents = ?");
        writer.setItemPreparedStatementSetter(new EalAssuranceComponentsPreparedStatementSetter());
        return writer;
    }
}
