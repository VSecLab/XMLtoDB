package com.unicampania.xmltodb.writer.writer_functional_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_fclass.ListItemPreparedStatmentSetter;
import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterListItem {
    public JdbcBatchItemWriter<Fclass> writerListItem(DataSource dataSource) {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO listitems(task_id,id,text,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new ListItemPreparedStatmentSetter());
        return writer;
    }
}
