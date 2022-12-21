package org.example.jdbc_database;

import org.example.model.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDatabase extends BaseDatabase<UserRole>{

    public boolean addUserRole(
            int userId,
            int roleId
    ) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery(
                            "select add_user_role(" + userId + ", " + roleId + ")"
                    );

            return resultSet.getBoolean(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnections(connection,statement);
        }
    }


    @Override
    public List<UserRole> getList() {
        Connection connection = null;
        Statement statement = null;
        List<UserRole> userRoleList = new ArrayList<>();
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery(
                            "select * from user_role");

            while (resultSet.next()){
                userRoleList.add(new UserRole(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnections(connection,statement);
        }
        return userRoleList;
    }

    @Override
    public List<UserRole> getPaginationList(int page, int length) {
        return null;
    }
}
