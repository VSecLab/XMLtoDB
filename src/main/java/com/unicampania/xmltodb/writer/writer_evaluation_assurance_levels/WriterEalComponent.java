package com.unicampania.xmltodb.writer.writer_evaluation_assurance_levels;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_evaluation_assurance_levels.EalComponentPreparedStatementSetter;
import com.unicampania.xmltodb.model.evaluation_assurance_levels.Eal;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterEalComponent {
    public JdbcBatchItemWriter<Eal> writerEalComponent(DataSource dataSource) {
        JdbcBatchItemWriter<Eal> writer = new JdbcBatchItemWriter<Eal>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ealcomponent(acomponent, id_eal) VALUES (?,?) ON DUPLICATE KEY UPDATE acomponent = ?");
        writer.setItemPreparedStatementSetter(new EalComponentPreparedStatementSetter());
        return writer;
    }
}
