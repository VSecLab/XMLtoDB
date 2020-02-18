package com.unicampania.xmltodb.writer.writer_assurance_elements;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_elements.AeDeveloperPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAeDeveloper {
    public JdbcBatchItemWriter<AClass> writerAeDeveloper(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO aedeveloper(id_aedeveloper, testo, ida, idf, id_acomponent) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE id_aedeveloper = ?");
        writer.setItemPreparedStatementSetter(new AeDeveloperPreparedStatementSetter());
        return writer;
    }
}
