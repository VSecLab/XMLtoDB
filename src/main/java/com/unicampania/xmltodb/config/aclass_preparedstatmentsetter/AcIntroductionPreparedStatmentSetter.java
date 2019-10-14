package com.unicampania.xmltodb.config.aclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.aclass.AClass;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcIntroductionPreparedStatmentSetter implements ItemPreparedStatementSetter<AClass> {


    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {



        for (int i = 0; i < item.getAcIntroduction().getP().size(); i++) {

            ps.setString(1, item.getAcIntroduction().getP().get(i).getType());
            ps.setString(2, item.getId().concat(Integer.toString(i)));
            ps.setString(3, String.valueOf(item.getAcIntroduction()
                    .getP().get(i)
                    .getValue())
                    .replace("[", "")
                    .replace("]", ""));
            ps.setString(4, item.getId());
            ps.setString(5, item.getId().concat(Integer.toString(i)));
            ps.addBatch();
        }
    }
}
