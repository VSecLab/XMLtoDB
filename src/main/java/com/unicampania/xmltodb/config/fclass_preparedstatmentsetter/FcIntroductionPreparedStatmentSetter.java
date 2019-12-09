package com.unicampania.xmltodb.config.fclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcIntroductionPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {


    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFcIntroduction().getP().size(); i++) {


            ps.setString(1, item.getFcIntroduction().getP().get(i).getType());
            ps.setString(2, item.getFcIntroduction().getP().get(i).getId_para().toUpperCase());
            ps.setString(3, String.valueOf(item.getFcIntroduction()
                    .getP()
                    .get(i)
                    .getCombo())
                    .replace("[", "")
                    .replace("]", ""));
            ps.setString(4, item.getId().toUpperCase());
            ps.setString(5, item.getFcIntroduction().getP().get(i).getId_para().toUpperCase());
            ps.addBatch();
        }
    }
}
