package com.unicampania.xmltodb.writer.writer_assurance_component;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component.AComponentPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAComponent {
    public JdbcBatchItemWriter<AClass> writerAComponent(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO acomponent(id_acomponent, name, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id_acomponent = ?");
        writer.setItemPreparedStatementSetter(new AComponentPreparedStatementSetter());
        return writer;
    }
}
