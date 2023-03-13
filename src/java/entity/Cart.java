/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author duytr
 */
import java.util.ArrayList;
import java.util.List;


public class Cart {
    private List<ItemCart> items;

    public Cart() {
        items=new ArrayList<>();
    }

    public List<ItemCart> getItems() {
        return items;
    }
    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }
    private ItemCart getItemById(int id){
        for(ItemCart i:items){
            if(i.getProduct().getId()==id){
                return i;
            }
        }
        return null;
    }
    public void addItem(ItemCart t){
        if(getItemById(t.getProduct().getId())!=null){
            ItemCart m=getItemById(t.getProduct().getId());
            m.setQuantity(m.getQuantity()+t.getQuantity());
        }else
            items.add(t);
    }
    public void removeItem(int id){
        if(getItemById(id)!=null){
            items.remove(getItemById(id));
        }
    }
    public double getTotalMoney(){
        double t=0;
        for(ItemCart i:items)
            t+=(i.getQuantity()*i.getPrice());
        return t;
    }
    private Product getProductById(int id,List<Product> list){
        for(Product i:list){
            if(i.getId()==id)
                return i;
        }
        return null;
    }
    public Cart(String txt,List<Product> list){
        items=new ArrayList<>();
        try{
        if(txt!=null && txt.length()!=0){
            String[] s=txt.split("/");//thay / cho dau ,
            for(String i:s){
                String[] n=i.split(":");
                int id=Integer.parseInt(n[0]);
                int quantity=Integer.parseInt(n[1]);
                Product p=getProductById(id, list);
                ItemCart t=new ItemCart(p, quantity, p.getPrice());
                addItem(t);
            }
        }
        }catch(NumberFormatException e){
            
        }
    }
    
}
