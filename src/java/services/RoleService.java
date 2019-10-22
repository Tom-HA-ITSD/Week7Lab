package services;

import dataaccess.RoleDB;
import java.util.ArrayList;
import java.util.List;
import models.Role;

public class RoleService {
    
    public Role getRole(int roleID) throws Exception {
        RoleDB db = new RoleDB();
        Role role = db.getRole(roleID);
        return role;
    }
    
    public List<Role> getAll() throws Exception {
        RoleDB db = new RoleDB();
        ArrayList<Role> roleList = (ArrayList<Role>) db.getAll();
        ArrayList<Role> activeRoles = new ArrayList<>();
        
        for (int i = 0; i < roleList.size(); i++) {
            activeRoles.add(roleList.get(i));
        }
        return activeRoles;
    }
    
    public int update(int roleID, String roleName) throws Exception {
        RoleDB db = new RoleDB();
        Role role = new Role(roleID, roleName);
        int i = db.update(role);
        return i;
    }
    
    public boolean delete(int roleID) throws Exception {
        RoleDB db = new RoleDB();
        Role role = db.getRole(roleID);
        boolean b = db.delete(role);
        return b;
    }
    
    public int insert(int roleID, String roleName) throws Exception {
        RoleDB db = new RoleDB();
        Role role = new Role(roleID, roleName);
        int i = db.insert(role);
        return i;
    }
}
