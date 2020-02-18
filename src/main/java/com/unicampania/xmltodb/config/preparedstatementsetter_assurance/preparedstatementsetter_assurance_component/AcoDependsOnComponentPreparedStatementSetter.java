package com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_component;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcoDependsOnComponentPreparedStatementSetter implements ItemPreparedStatementSetter<AClass> {
    @Override
    public void setValues(AClass aClass, PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < aClass.getAFamilies().size(); i++) {
            for (int j = 0; j < aClass.getAFamilies().get(i).getAComponentList().size(); j++) {
                for (int k = 0; k < aClass.getAFamilies().get(i).getAComponentList().get(j).getAcoDependsOnComponentList().size(); k++) {
                    preparedStatement.setString(1, String.valueOf(Math.random() * 23));
                    preparedStatement.setString(2, aClass.getAFamilies().get(i).getAComponentList().get(j).getAcoDependsOnComponentList().get(k).getAcomponent());
                    preparedStatement.setString(3, aClass.getId());
                    preparedStatement.setString(4, aClass.getAFamilies().get(i).getId_afamily());
                    preparedStatement.setString(5, String.valueOf(Math.random() * 23));
                    preparedStatement.addBatch();
                }

            }
        }
        preparedStatement.execute();
    }
}
