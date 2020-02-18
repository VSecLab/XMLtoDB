package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_family;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AFamilyPreparedStatementSetter implements ItemPreparedStatementSetter<AClass> {

    @Override
    public void setValues(AClass aClass, PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < aClass.getAFamilies().size(); i++) {
            preparedStatement.setString(1, aClass.getAFamilies().get(i).getId_afamily());
            preparedStatement.setString(2, aClass.getAFamilies().get(i).getName());
            preparedStatement.setString(3, aClass.getId());
            preparedStatement.setString(4, aClass.getAFamilies().get(i).getId_afamily());
            preparedStatement.addBatch();
        }
    }
}
