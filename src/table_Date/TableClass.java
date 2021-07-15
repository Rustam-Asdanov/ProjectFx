package table_Date;

import java.util.Date;

public class TableClass {
    private int id;
    private String human;
    private Date birthday;

    public TableClass(int id, String human, Date birthday) {
        this.id = id;
        this.human = human;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
