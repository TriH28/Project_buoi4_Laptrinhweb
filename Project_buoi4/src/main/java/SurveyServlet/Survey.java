package SurveyServlet;

import model.SurveyResult;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/survey")
public class Survey extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Đọc Unicode đúng cho POST (đặt TRƯỚC getParameter)
    request.setCharacterEncoding("UTF-8");

    // Lấy tham số
    String firstName = nv(request, "firstName");
    String lastName  = nv(request, "lastName");
    String email     = nv(request, "email");
    String dob       = nv(request, "dob");
    String heardFrom = nv(request, "heardFrom");
    boolean wantsUpdates = request.getParameter("wantsUpdates") != null;
    boolean emailOK      = request.getParameter("emailOK") != null;

    // Nếu sau này cho chọn nhiều kênh liên hệ: dùng getParameterValues
    String contactViaText = nv(request, "contactVia");

    // Tạo Model (có escape HTML cơ bản để an toàn khi hiển thị)
    SurveyResult result = new SurveyResult(
        esc(firstName), esc(lastName), esc(email), esc(dob),
        esc(heardFrom), wantsUpdates, emailOK, esc(contactViaText)
    );

    // Đặt dữ liệu lên request và forward sang View (JSP)
    request.setAttribute("result", result);
    request.getRequestDispatcher("/WEB-INF/views/surveyResult.jsp")
           .forward(request, response);
  }

  private static String nv(HttpServletRequest req, String name) {
    String v = req.getParameter(name);
    return v == null ? "" : v;
  }
  private static String esc(String s) {
    if (s == null) return "";
    return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
            .replace("\"","&quot;").replace("'","&#x27;");
  }
}
