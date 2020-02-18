package com.unicampania.xmltodb.writer.writer_assurance_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_paradigm.MaApplicationNotesPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterMaApplicationNotes {
    public JdbcBatchItemWriter<AClass> writerMaApplicationNotes(DataSource dataSource) {
        org.springframework.batch.item.database.JdbcBatchItemWriter<com.unicampania.xmltodb.model.assurance_paradigm.AClass> writer = new JdbcBatchItemWriter<com.unicampania.xmltodb.model.assurance_paradigm.AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO maapplicationnotes(id, testo, ida) VALUES (?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new MaApplicationNotesPreparedStatementSetter());
        return writer;
    }
}
