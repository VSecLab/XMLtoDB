package com.unicampania.xmltodb.writer.writer_assurance_family;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_family.AfLevellingCriteriaPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAfLevellingCriteria {
    public JdbcBatchItemWriter<AClass> writerAfLevellingCriteria(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO aflevellingcriteria(id, testo, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new AfLevellingCriteriaPreparedStatementSetter());
        return writer;
    }
}
