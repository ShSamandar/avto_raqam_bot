package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.jdbc_database.BaseDatabase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AutoNumber extends Base{
    private String number;
    public AutoNumber(ResultSet resultSet){
        this.get(resultSet);
    }

    @Override
    protected void get(ResultSet resultSet) {
        try {
            this.number = resultSet.getString(   "number");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
