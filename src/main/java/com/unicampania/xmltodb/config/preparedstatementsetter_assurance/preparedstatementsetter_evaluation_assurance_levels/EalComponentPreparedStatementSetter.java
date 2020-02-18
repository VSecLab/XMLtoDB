package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_evaluation_assurance_levels;

import com.unicampania.xmltodb.model.evaluation_assurance_levels.Eal;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EalComponentPreparedStatementSetter implements ItemPreparedStatementSetter<Eal> {
    @Override
    public void setValues(Eal eal, PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < eal.getEalComponentList().size(); i++) {
            preparedStatement.setString(1, eal.getEalComponentList().get(i).getAcomponent());
            preparedStatement.setString(2, eal.getId_eal());
            preparedStatement.setString(3, eal.getEalComponentList().get(i).getAcomponent());
            preparedStatement.addBatch();
            preparedStatement.execute();
        }
    }
}
