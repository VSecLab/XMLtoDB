package com.unicampania.xmltodb.writer.writer_functional_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_fclass.FcoHierarchicalPreparedStatmentSetter;
import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterFcoHierarchical {
    public JdbcBatchItemWriter<Fclass> writerFcoHierarchical(DataSource dataSource) {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcohierarchical(fcomponent,idf) VALUES(?,?) ON DUPLICATE KEY UPDATE fcomponent = ?");
        writer.setItemPreparedStatementSetter(new FcoHierarchicalPreparedStatmentSetter());
        return writer;
    }
}
