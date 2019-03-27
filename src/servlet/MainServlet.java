package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * テストサーブレット
 */
@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {
  /**
   * シリアルバージョンUID
   */
  private static final long serialVersionUID = 1L;
  /**
   * get
   */
  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    final PrintWriter writer = response.getWriter();
    writer.append("<!DOCTYPE html>");
    writer.append("<html>");
    writer.append("<head>");
    writer.append("<meta charset=\"UTF-8\" />");
    writer.append("<title>Hello Servlet</title>");
    writer.append("</head>");
    writer.append("<body>");
    writer.append("<div>Hello Servlet</div>");
    writer.append("<input type=\"text\" />");
    writer.append("</body>");
    writer.append("</html>");
    writer.flush();
  }
}

