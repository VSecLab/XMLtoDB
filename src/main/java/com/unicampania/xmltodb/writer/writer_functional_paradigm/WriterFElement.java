package com.unicampania.xmltodb.writer.writer_functional_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_fclass.FEelementPreparedStatmentSetter;
import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterFElement {
    public JdbcBatchItemWriter<Fclass> writerFElement(DataSource dataSource) {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO felement(num,idr,id,text,idf) VALUES(?,?,?,?,?) ON DUPLICATE KEY UPDATE idr = ?");
        writer.setItemPreparedStatementSetter(new FEelementPreparedStatmentSetter());
        return writer;
    }
}
