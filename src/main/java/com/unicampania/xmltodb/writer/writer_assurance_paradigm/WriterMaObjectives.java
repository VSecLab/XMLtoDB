package com.unicampania.xmltodb.writer.writer_assurance_paradigm;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_paradigm.MaObjectivesPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterMaObjectives {
    public JdbcBatchItemWriter<AClass> writerMaObjectives(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO maobjectives(id, testo, ida) VALUES (?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new MaObjectivesPreparedStatementSetter());
        return writer;
    }
}
