package com.unicampania.xmltodb.writer.writer_parasequence;

import com.unicampania.xmltodb.config.preparedstatementsetter_parasequence.XrefPreparedStatmentSetter;
import com.unicampania.xmltodb.model.parasequence.Xref;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterXref {
    public JdbcBatchItemWriter<Xref> writerXref(DataSource dataSource) {
        JdbcBatchItemWriter<Xref> writer = new JdbcBatchItemWriter<Xref>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO xref(id_xref, showw, ida) VALUES (?,?,?) ON DUPLICATE KEY UPDATE id_xref = ?");
        writer.setItemPreparedStatementSetter(new XrefPreparedStatmentSetter());
        return writer;
    }
}
