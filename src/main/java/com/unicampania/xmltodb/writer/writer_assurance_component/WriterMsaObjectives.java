package com.unicampania.xmltodb.writer.writer_assurance_component;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component.MsaObjectivesPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterMsaObjectives {
    public JdbcBatchItemWriter<AClass> writerMsaObjectives(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO msaobjectives(id_msaobjectives, testo, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id_msaobjectives = ?");
        writer.setItemPreparedStatementSetter(new MsaObjectivesPreparedStatementSetter());
        return writer;
    }
}

