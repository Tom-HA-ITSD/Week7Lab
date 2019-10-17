/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Role;
import java.util.List;
import models.User;

/**
 *
 * @author awarsyle
 */
public class RoleDB {
    public Role getRole(int roleID) throws SQLException {

        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.getConnection();

            Role role = null;
            String preparedQuery = "SELECT RoleID, RoleName FROM role_table WHERE RoleID=?";
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setInt(1, roleID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String roleName = rs.getString(2);
                role = new Role(roleID, roleName);
            }

            return role;
        } finally {
            connectionPool.freeConnection(connection);
        }
    }

    public List<Role> getAll() throws SQLException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.getConnection();
            Role role;
            ArrayList<Role> roles = new ArrayList<>();
            
            String preparedQuery = "SELECT RoleID, RoleName FROM role_table";
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int RoleID = rs.getInt(1);
                String RoleName = rs.getString(2);
                        
                role = new Role(RoleID, RoleName);
                roles.add(role);
            }

            return roles;
        } finally {
            connectionPool.freeConnection(connection);
        }
    }
}
