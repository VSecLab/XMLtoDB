package com.unicampania.xmltodb.writer.writer_assurance_component;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component.AcoHierarchicalPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAcoHierarchical {
    public JdbcBatchItemWriter<AClass> writerAcoHierarchical(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO acohierarchical(id_acohierarchical, acomponent, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id_acohierarchical = ?");
        writer.setItemPreparedStatementSetter(new AcoHierarchicalPreparedStatementSetter());
        return writer;
    }
}

