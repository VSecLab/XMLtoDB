package com.unicampania.xmltodb.writer.writer_assurance_component;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component.AcoObjectivesPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAcoObjectives {
    public JdbcBatchItemWriter<AClass> writerAcoObjectives(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO acoobjectives(id_acoobjectives, testo, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id_acoobjectives = ?");
        writer.setItemPreparedStatementSetter(new AcoObjectivesPreparedStatementSetter());
        return writer;
    }
}
