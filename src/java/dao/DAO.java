/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Feedback;
import entity.ItemCart;
import entity.Order;
import entity.Product;
import entity.TotalByMonth;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author duytr
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    //product
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query="select * from Product";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    //product
    public List<Product> getProductQuantity(){
        List<Product> list = new ArrayList<>();
        String query="select Top 12 * from Product order by Quantity";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    //productnew
     public List<Product> getProductNew(){
        List<Product> listNew = new ArrayList<>();
        String query="select top 12 * from Product order by ProductID desc";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                listNew.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return listNew;
    }
     //product by categoryid
     public List<Product> getProductByCId(String cid){
        List<Product> list = new ArrayList<>();
        String query="select * from Product\n" +
                        "where CategoryID = ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
     public List<Product> getProductByCId1(int cid){
        List<Product> list = new ArrayList<>();
        String query="select * from Product\n" +
                        "where CategoryID = ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
     //product by categoryid
     public Product getProductById(String pid){
        String query="select * from Product\n" +
                        "where ProductID = ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
     public Product getProductById2(int pid){
        String query="select * from Product\n" +
                        "where ProductID = ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    //account
     public Account login(String user, String pass){
         String query="select * from [User] where [user] = ? and pass = ?";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
            }
         } catch (Exception e) {
         }
         return null;
     }
     //checkAcc
     public Account checkAccExist(String user){
         String query="select * from [User] where [user] = ?";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();

            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
            }
         } catch (Exception e) {
         }
         return null;
     }
     //signup
     public void register(String user, String pass, String name,String mail,String phone){
         String query="insert into [User] values(?,?,0,?,?,?)";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, mail);
            ps.setString(5, phone);
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
    //category
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query="select * from Category";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    //search
    public List<Product> searchByName(String txtSearch){
        List<Product> list = new ArrayList<>();
        String query="select * from Product\n" +
                        "where [name] like ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txtSearch+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    //deleteProduct
    public void deleteProduct(String pid){
         String query="delete from Product where ProductID = ?";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
    //insertProduct
    public void insertProduct(String id, String name, String price, String image, String description, String quantity, String category){
         String query="INSERT INTO [dbo].[Product]\n" +
"           ([ProductID]\n" +
"           ,[Name]\n" +
"           ,[Price]\n" +
"           ,[Image]\n" +
"           ,[Description]\n" +
"           ,[Quantity]\n" +
"           ,[CategoryID]) VALUES(?,?,?,?,?,?,?)";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,price);
            ps.setString(4,price);
            ps.setString(5,description);
            ps.setString(6,quantity);
            ps.setString(7,category);
            
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
    //editProduct
    public void editProduct(String id, String name, String price, String image, String description, String quantity, String category){
         String query="UPDATE [dbo].[Product]\n" +
"   SET [ProductID] = ?\n" +
"      ,[Name] = ?\n" +
"      ,[Price] = ?\n" +
"      ,[Image] = ?\n" +
"      ,[Description] = ?\n" +
"      ,[Quantity] = ?\n" +
"      ,[CategoryID] = ? WHERE [ProductID] = ?";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,price);
            ps.setString(4,price);
            ps.setString(5,description);
            ps.setString(6,quantity);
            ps.setString(7,category);
             ps.setString(8,id);
            
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
    
    public void addOrder(Account c,Cart cart){
        String pattern = "dd-MM-yyyy";     
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("vi", "VI"));
String date = simpleDateFormat.format(new Date());
            //add order
            String query="insert into [Order] values(?,?,?)";
            try{
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, c.getId());
            ps.setDouble(3, cart.getTotalMoney());
            ps.executeUpdate();
            //lay id cua order vua add
            String query1="select top 1 OrderID from [Order] order by OrderID desc";
            
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query1);
            rs = ps.executeQuery();
            //add bang OrderDetail
            if(rs.next()){
                int oid=rs.getInt("OrderID");
                for(ItemCart i:cart.getItems()){
                    String query2="insert into [OrderLine] values(?,?,?,?)";
                    conn = new DBContext().connection;//mo ketnoi sql
                    ps = conn.prepareStatement(query2);
                    ps.setInt(1, oid);
                    ps.setInt(2, i.getProduct().getId());
                    ps.setInt(3, i.getQuantity());
                    ps.setDouble(4, i.getPrice());
                    ps.executeUpdate();
                }
            }
            //cap nhat lai so luong san pham
            String query3="update Product set Quantity=Quantity-? where ProductID=?";
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query3);
            for(ItemCart i:cart.getItems()){
                ps.setInt(1, i.getQuantity());
                ps.setInt(2, i.getProduct().getId());
                ps.executeUpdate();
            }
        }catch(SQLException e){
            
        }
    } 
    public void addOrder1(Account c,Cart cart){
            try{
            //lay id cua order vua add
            String query1="select top 1 id from [Order] order by OrderID desc";
            
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query1);
            rs = ps.executeQuery();
            //add bang OrderDetail
            if(rs.next()){
                int oid=rs.getInt("OrderID");
                for(ItemCart i:cart.getItems()){
                    String query2="insert into [OrderLine] values(?,?,?,?)";
                    conn = new DBContext().connection;//mo ketnoi sql
                    ps = conn.prepareStatement(query2);
                    ps.setInt(1, oid);
                    ps.setInt(2, i.getProduct().getId());
                    ps.setInt(3, i.getQuantity());
                    ps.setDouble(4, i.getPrice());
                    ps.executeUpdate();
                }
            }
            
        }catch(SQLException e){
            
        }
    } 
    public void addOrder2(Account c,Cart cart){
                       try{
            //cap nhat lai so luong san pham
            String query3="update Product set Quantity=Quantity-? where ProductID=?";
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query3);
            for(ItemCart i:cart.getItems()){
                ps.setInt(1, i.getQuantity());
                ps.setInt(2, i.getProduct().getId());
                ps.executeUpdate();
            }
        }catch(SQLException e){
            
        }
    }
    //feedbacks
     public void addFeedback(String name, String comment, String pid){
         LocalDate curDate=LocalDate.now();
        String date=curDate.toString();
         String query="insert into [Feedbacks] values(?,?,?,?)";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, comment);
            ps.setString(3, pid);
            ps.setString(4, date);
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
     public List<Feedback> getFeedbackByPid(String pid){
        List<Feedback> list = new ArrayList<>();
        String query="select * from Feedbacks where ProductID = ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,pid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Feedback(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
     //phan trang
     public List<Product> getListByPage(List<Product> list, int start, int end){
         ArrayList<Product> arr=new ArrayList<>();
         for (int i = start; i < end; i++) {
             arr.add(list.get(i));
         }
         return arr;
     }
     
     //filter
      public List<Product> searchByColor(String color){
        List<Product> list = new ArrayList<>();
        String query="select * from Product\n" +
                        "where [name] like ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+color+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
      
    public List<Product> getProductsByPrice(double from,double to) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\n"
                + "  where Price between ? and ? ";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setDouble(1, from);
            ps.setDouble(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    //user
    public List<Account> getAllAcc(){
        List<Account> list = new ArrayList<>();
        String query="select * from [User]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
     public void insertUser(String user, String pass, String isAdmin, String Name){
         String query="INSERT INTO [dbo].[User]\n" +
"           ([user]\n" +
"           ,[pass]\n" +
"           ,[isAdmin]\n" +
"           ,[Name])\n" + "VALUES(?,?,?,?)";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.setString(3,isAdmin);
            ps.setString(4,Name);
            
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
     public void deleteUser(String uid){
         String query="delete from [User] where UserID = ?";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
    //editProduct
    public void editUser(String user, String pass, String isAdmin, String Name,String UserID){
         String query="UPDATE [dbo].[User]\n" +
"   SET [user] = ?\n" +
"      ,[pass] = ?\n" +
"      ,[isAdmin] = ?\n" +
"      ,[Name] = ?\n" +
"       WHERE [UserID] = ?";
         try {
             conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.setString(3,isAdmin);
            ps.setString(4,Name);
            ps.setString(5,UserID);
            ps.executeUpdate();
         } catch (Exception e) {
         }
     }
    public Account getUserById(String uid){
        String query="select * from [User]\n" +
                        "where [UserID] = ?";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    //dashboard
    public List<TotalByMonth> getAllDate(){
        List<TotalByMonth> listMBD = new ArrayList<>();
        String query="select [date], SUM(totalmoney) as total from [Order] group by [date]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                listMBD.add(new TotalByMonth(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return listMBD;
    }
     public List<TotalByMonth> getOderByDay(){
        List<TotalByMonth> list = new ArrayList<>();
        String query="select [date], COUNT(OrderID) as totalO from [Order] group by [date]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new TotalByMonth(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    public TotalByMonth getTotal(){
        String query="select SUM(totalmoney) from [Order]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new TotalByMonth(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public TotalByMonth getTotalUser(){
        String query="select COUNT(UserID) from [User]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new TotalByMonth(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public TotalByMonth getTotalOrder(){
        String query="select COUNT(OrderID) from [Order]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new TotalByMonth(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public TotalByMonth getTotalProduct(){
        String query="select COUNT(ProductID) from [Product]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new TotalByMonth(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public List<Order> getAllOrder(){
        List<Order> list = new ArrayList<>();
        String query="select * from [Order]";
        try {
            conn = new DBContext().connection;//mo ketnoi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    
        public static void main(String[] args) {
         String pattern = "MM-dd-yyyy";     
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("vi", "VI"));
String date = simpleDateFormat.format(new Date());
System.out.println(date);


//        }
    }
}
