package com.unicampania.xmltodb.writer.writer_functional_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_fclass.SubClauseParaPreparedStatmentSetter;
import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterSubClausePara {
    public JdbcBatchItemWriter<Fclass> writerSubClausePara(DataSource dataSource) {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO subclausepara(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new SubClauseParaPreparedStatmentSetter());
        return writer;
    }
}
