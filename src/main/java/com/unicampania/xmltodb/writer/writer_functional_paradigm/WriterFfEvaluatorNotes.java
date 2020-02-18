package com.unicampania.xmltodb.writer.writer_functional_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_fclass.FfEvaluatorNotesPreparedStatmentSetter;
import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterFfEvaluatorNotes {
    public JdbcBatchItemWriter<Fclass> writerFfEvaluatorNotes(DataSource dataSource) {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffevaluatornotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfEvaluatorNotesPreparedStatmentSetter());
        return writer;
    }
}
