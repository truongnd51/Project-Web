/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author duytr
 */
public class TotalByMonth {
    private String date;
    private int total;

    public TotalByMonth() {
    }

    public TotalByMonth(int total) {
        this.total = total;
    }
    

    public TotalByMonth(String date, int total) {
        this.date = date;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TotalByMonth{" + "date=" + date + ", total=" + total + '}';
    }
    
}
