package com.unicampania.xmltodb.config.preparedstatementsetter_parasequence;

import com.unicampania.xmltodb.model.parasequence.Subclause;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubclausessPreparedStatementSetter implements ItemPreparedStatementSetter<Subclause> {
    @Override
    public void setValues(Subclause subclause, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, subclause.getId_subclauses());
        preparedStatement.setString(2, subclause.getTitle());
        if (subclause.getCombo() != null) {
            preparedStatement.setString(3, String.valueOf(subclause.getCombo()).replace("]","").replace("[",""));
            SubclausessPreparedStatementSetter subclausessPreparedStatementSetter = new SubclausessPreparedStatementSetter();
        } else {
            preparedStatement.setString(3, null);
        }
        preparedStatement.setString(4, subclause.getId_subclauses());
    }
}
