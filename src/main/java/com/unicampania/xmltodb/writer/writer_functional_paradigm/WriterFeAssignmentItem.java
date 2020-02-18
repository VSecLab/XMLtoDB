package com.unicampania.xmltodb.writer.writer_functional_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_fclass.FeAssignmentitemPreparedStatmentSetter;
import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterFeAssignmentItem {
    public JdbcBatchItemWriter<Fclass> writerFeAssignmentItem(DataSource dataSource) {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO feassignmentitem(idr,text,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE idr = ?");
        writer.setItemPreparedStatementSetter(new FeAssignmentitemPreparedStatmentSetter());
        return writer;
    }
}
