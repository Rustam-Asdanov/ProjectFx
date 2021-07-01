package sampleTwo;

public class Friends {
    private String name;
    private String surname;
    private String friend_boy;
    private String friend_girl;

    public Friends( String name, String surname, String friend_boy, String friend_girl) {
        this.name = name;
        this.surname = surname;
        this.friend_boy = friend_boy;
        this.friend_girl = friend_girl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFriend_boy() {
        return friend_boy;
    }

    public void setFriend_boy(String friend_boy) {
        this.friend_boy = friend_boy;
    }

    public String getFriend_girl() {
        return friend_girl;
    }

    public void setFriend_girl(String friend_girl) {
        this.friend_girl = friend_girl;
    }
}
