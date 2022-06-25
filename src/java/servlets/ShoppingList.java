package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author barab
 */
public class ShoppingList extends HttpServlet {

    private final String ATT_SHOPPING_ITEMS = "shoppingItems";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String item = request.getParameter("item");
        String itemForDel = request.getParameter("shoppingItem");
        
        
        ArrayList<String> list = (ArrayList<String>) session.getAttribute(ATT_SHOPPING_ITEMS);

        if (list == null) {
            list = new ArrayList<>();
        }

        if (action != null) {
            if (action.equals("Add") && item != null) {
                if(!item.equals("")){
                    list.add(item);                    
                    session.setAttribute(ATT_SHOPPING_ITEMS, list);
                }
            }if (action.equals("Delete") && itemForDel != null) {
                if(!itemForDel.equals("")){
                    list.remove(itemForDel);                    
                    session.setAttribute(ATT_SHOPPING_ITEMS, list);
                }
            }
            
        }

        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
        } else {

            String username = request.getParameter("username");

            if (username != null && !username.equals("")) {
                session.setAttribute("username", username);
            }

            if (session.getAttribute("username") != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return;
    }

}
