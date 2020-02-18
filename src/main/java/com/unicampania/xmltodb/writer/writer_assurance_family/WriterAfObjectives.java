package com.unicampania.xmltodb.writer.writer_assurance_family;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_family.AfObjectivesPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAfObjectives {
    public JdbcBatchItemWriter<AClass> writerAfObjectives(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO afobjectives(id, testo, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new AfObjectivesPreparedStatementSetter());
        return writer;
    }
}
