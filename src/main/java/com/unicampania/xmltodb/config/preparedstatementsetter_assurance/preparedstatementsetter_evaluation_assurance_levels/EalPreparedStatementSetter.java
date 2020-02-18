package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_evaluation_assurance_levels;

import com.unicampania.xmltodb.model.evaluation_assurance_levels.Eal;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EalPreparedStatementSetter implements ItemPreparedStatementSetter<Eal> {
    @Override
    public void setValues(Eal eal, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, eal.getId_eal());
        preparedStatement.setString(2, eal.getName());
        preparedStatement.setString(3, eal.getId_eal());
    }
}
