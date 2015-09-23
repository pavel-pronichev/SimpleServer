package main;


import java.util.HashMap;

/**
 * Created by skyrex on 20.09.15.
 */
public class AccauntService {
    private HashMap<String,UserProfile> users = new HashMap<String, UserProfile>();
    private HashMap<String, UserProfile> sessions = new HashMap<String, UserProfile>();

    public boolean addUser(String name, UserProfile userProfile){
        if(users.containsKey(name)){
            return false;
        }
        else {
            users.put(name,userProfile);
            return true;
        }
    }

    public UserProfile getUser(String userName){
        return users.get(userName);
    }

    public void addSession(String sessionId, UserProfile userProfile){
        sessions.put(sessionId,userProfile);
    }

    public UserProfile getSession(String sessionId){
        return sessions.get(sessionId);
    }


}
