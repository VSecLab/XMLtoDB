package com.unicampania.xmltodb.writer.writer_assurance_elements;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_elements.AeContentPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAeContent {
    public JdbcBatchItemWriter<AClass> writerAeContent(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO aecontent(id_aecontent, testo, ida, idf, id_acomponent) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE id_aecontent = ?");
        writer.setItemPreparedStatementSetter(new AeContentPreparedStatementSetter());
        return writer;
    }
}
