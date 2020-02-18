package com.unicampania.xmltodb.writer.writer_assurance_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_paradigm.AClassPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAClass {

    public JdbcBatchItemWriter<AClass> writerAClass(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO aclass(id, name) VALUES(?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new AClassPreparedStatementSetter());
        return writer;
    }
}
