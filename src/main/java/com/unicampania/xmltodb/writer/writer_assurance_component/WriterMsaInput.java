package com.unicampania.xmltodb.writer.writer_assurance_component;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component.MsaInputPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterMsaInput {
    public JdbcBatchItemWriter<AClass> writerMsaInput(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO msainput(id_msainput, testo, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id_msainput = ?");
        writer.setItemPreparedStatementSetter(new MsaInputPreparedStatementSetter());
        return writer;
    }
}


