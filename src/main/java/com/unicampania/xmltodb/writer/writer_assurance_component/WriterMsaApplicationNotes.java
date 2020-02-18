package com.unicampania.xmltodb.writer.writer_assurance_component;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component.MsaApplicationNotesPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterMsaApplicationNotes {
    public JdbcBatchItemWriter<AClass> writerMsaApplicationNotes(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO msaapplicationnotes(id_msaapplicationnotes, testo, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id_msaapplicationnotes = ?");
        writer.setItemPreparedStatementSetter(new MsaApplicationNotesPreparedStatementSetter());
        return writer;
    }
}
