package Lab2.HeartRate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class UserDataManager {
    
    private String userdatafile;

    // method for finding and accessing file
    public UserDataManager(String filename) {
        this.userdatafile = filename;
        // check if the file exists, if not, create it
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error creating or accessing the file: " + e.getMessage());
            e.printStackTrace();
        }
    } // end of UserDataManger

    // saves user data
    public void saveUserData(ArrayList<UserInfo> users) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(userdatafile))) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end of saveUserData

    // loads user data
    @SuppressWarnings("unchecked") // the compiler doesn't like the fact that there's no type safty for the Object class
    public ArrayList<UserInfo> loadUserData() {
        ArrayList<UserInfo> users = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(userdatafile))) {
            Object obj = inputStream.readObject();
            if (obj instanceof ArrayList<?>) {
                users = (ArrayList<UserInfo>) obj;
            } else {
                System.out.println("Error: Unexpected data format.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    } // end of loadUserData
} // end of class