/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import entity.Cart;
import entity.Category;
import entity.ItemCart;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duytr
 */
@WebServlet(name="FilterControl", urlPatterns={"/filter"})
public class FilterControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          String[] pp={"Under $50",
                     "$50-$100",
                     "$100-$200",
                     "$200-$500",
                     "Over $500"};
        boolean[] pb=new boolean[pp.length+1];
        String[] color={"Black",
                     "White",
                     "Red",
                     "Blue",
                     "Orange"};
        boolean[] cl=new boolean[color.length+1];
        DAO d = new DAO();
        //
        List<Product> listA=d.getAllProduct();
        List<Category> listC = d.getAllCategory();
        Cookie[] arr=request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o:arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
                }
            }
        }
        Cart cart=new Cart(txt, listA);
        List<ItemCart> listItem=cart.getItems();
        int n;
        if(listItem!=null){
            n=listItem.size();
        }else{
            n=0;
            }
        request.setAttribute("size", n);
        
        request.setAttribute("listCa", listC);
        //
        
        List<Product> products = new ArrayList<>();
        String cid_raw = request.getParameter("cid");
        String[] co = request.getParameterValues("cidd");
        String[] price = request.getParameterValues("price");
        int cid = 0;
        if (co != null) {
            String colo;
            for (int i = 0; i < co.length; i++) {
                List<Product> tempp = new ArrayList<>();
                if (co[i].equals("0")) {
                    products = d.getAllProduct();
                    cl[0] = true;
                    break;
                } else {
                    if (co[i].equals("1")) {
                        colo = "black";
                        tempp = d.searchByColor(colo);
                        products.addAll(tempp);
                        cl[1] = true;
                    }
                    if (co[i].equals("2")) {
                        colo = "white";
                        tempp = d.searchByColor(colo);
                        products.addAll(tempp);
                        cl[2] = true;
                    }
                    if (co[i].equals("3")) {
                        colo = "red";
                        tempp = d.searchByColor(colo);
                        products.addAll(tempp);
                        cl[3] = true;
                    }
                    if (co[i].equals("4")) {
                        colo = "blue";
                        tempp = d.searchByColor(colo);
                        products.addAll(tempp);
                        cl[4] = true;
                    }
                    if (co[i].equals("5")) {
                        colo = "orange";
                        tempp = d.searchByColor(colo);
                        products.addAll(tempp);
                        cl[5] = true;
                    }
                }
            }
        }
        if (price != null) {
            double from = 0, to = 0;
            for (int i = 0; i < price.length; i++) {
                List<Product> temp = new ArrayList<>();
                if (price[i].equals("0")) {
                    from = 0;
                    to = 50000;
                    products = d.getProductsByPrice(from, to);
                    pb[0] = true;
                    break;
                } else {
                    if (price[i].equals("1")) {
                        from = 0;
                        to = 50;
                        temp = d.getProductsByPrice(from, to);
                        products.addAll(temp);
                        pb[1] = true;
                    }
                    if (price[i].equals("2")) {
                        from = 50;
                        to = 100;
                        temp = d.getProductsByPrice(from, to);
                        products.addAll(temp);
                        pb[2] = true;
                    }
                    if (price[i].equals("3")) {
                        from = 100;
                        to = 200;
                        temp = d.getProductsByPrice(from, to);
                        products.addAll(temp);
                        pb[3] = true;
                    }
                    if (price[i].equals("4")) {
                        from = 200;
                        to = 500;
                        temp = d.getProductsByPrice(from, to);
                        products.addAll(temp);
                        pb[4] = true;
                    }
                    if (price[i].equals("5")) {
                        from = 500;
                        to = 50000;
                        temp = d.getProductsByPrice(from, to);
                        products.addAll(temp);
                        pb[5] = true;
                    }
                }
            }
        }
        if (price == null) {
            pb[0] = true;
        }
        if (co == null) {
            cl[0] = true;
        }
//        if (cid_raw == null) {
//            chid[0] = true;
//        }
//        if ((cidd_raw != null) && (cidd[0] != 0)) {
//            chid[0] = false;
//            for (int i = 1; i < chid.length; i++) {
//                if (ischeck(categories.get(i - 1).getId(), cidd)) {
//                    chid[i] = true;
//                } else {
//                    chid[i] = false;
//                }
//            }
//        }
//        request.setAttribute("data", categories);
        request.setAttribute("products", products);
        request.setAttribute("pp", pp);
//        request.setAttribute("key", key);
        request.setAttribute("pb", pb);
        request.setAttribute("color", color);
        request.setAttribute("cl", cl);
        request.setAttribute("cid", cid);
//        request.setAttribute("chid", chid);
        request.getRequestDispatcher("category.jsp").forward(request, response);

        }
    } 
    private boolean ischeck(int d, int[] id) {
        if (id == null) {
            return false;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == d) {
                    return true;
                }
            }
            return false;
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
