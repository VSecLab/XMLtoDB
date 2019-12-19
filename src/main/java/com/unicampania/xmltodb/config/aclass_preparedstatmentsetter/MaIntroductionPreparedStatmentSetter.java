package com.unicampania.xmltodb.config.aclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaIntroductionPreparedStatmentSetter implements ItemPreparedStatementSetter<AClass> {

    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {

        if (item.getMaIntroduction() != null) {
            if (item.getMaIntroduction().getP().size() == 0) {
                ps.setString(1, "");
                ps.setString(2, "");
                ps.setString(3, "");
                ps.setString(4, item.getId().toUpperCase());
                ps.setString(5, "");
            } else {
                for (int i = 0; i < item.getMaIntroduction().getP().size(); i++) {

                    ps.setString(1, item.getMaIntroduction().getP().get(i).getType().toUpperCase());
                    ps.setString(2, item.getId().concat(Integer.toString(i)).toUpperCase());
                    ps.setString(3, String.valueOf(item.getMaIntroduction()
                            .getP()
                            .get(i)
                            .getCombo())
                            .replace("[", "")
                            .replace("]", ""));
                    ps.setString(4, item.getId().toUpperCase());
                    ps.setString(5, item.getId().concat(Integer.toString(i)).toUpperCase());
                    ps.addBatch();
                }
            }
        }

        ps.setString(1, null);
        ps.setString(2, item.getId().concat("NULL"));
        ps.setString(3, null);
        ps.setString(4, null);
        ps.setString(5, item.getId().concat("NULL"));
    }
}

