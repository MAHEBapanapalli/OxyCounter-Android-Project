package com.example.oxycounter;

public class OxygenFlow {
    private int id;
    private String type;
    private String count;
    private String catogery;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCatogery() {
        return catogery;
    }

    public void setCatogery(String catogery) {
        this.catogery = catogery;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IncomeModal{" +
                "type='" + type + '\'' +
                ", count='" + count + '\'' +
                ", catogery='" + catogery + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
