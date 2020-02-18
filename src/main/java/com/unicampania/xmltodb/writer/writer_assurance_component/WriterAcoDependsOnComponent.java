package com.unicampania.xmltodb.writer.writer_assurance_component;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component.AcoDependsOnComponentPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAcoDependsOnComponent {
    public JdbcBatchItemWriter<AClass> writerAcoDependsOnComponent(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO acodependsoncomponent(id_acodependsoncomponent, acomponent, ida, idf) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id_acodependsoncomponent = ?");
        writer.setItemPreparedStatementSetter(new AcoDependsOnComponentPreparedStatementSetter());
        return writer;
    }
}

