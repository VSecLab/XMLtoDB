package com.unicampania.xmltodb.writer.writer_functional_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_fclass.FcoDependenciesPreparedStatmentSetter;
import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterFcoDependencies {
    public JdbcBatchItemWriter<Fclass> writerFcoDependencies(DataSource dataSource) {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcodependencies(id, fcomponent,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoDependenciesPreparedStatmentSetter());
        return writer;
    }
}

