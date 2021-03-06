package ru.job4j.tracker;

/**
 * класс с параметрами заявки.
 */
public class Item {
    private String id;   //позиция в массиве.
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item() {
    }

    public Item(String name, String desc) {
        setName(name);
        setDesc(desc);
    }

    public Item(String name, String desc, long created) {
        setName(name);
        setDesc(desc);
        setCreated(created);
    }


    // Set
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
    // Get
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public long getCreated() {
        return created;
    }

    public String[] getComments() {
        return comments;
    }
}
