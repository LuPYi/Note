package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoteDAO;
import dao.NoteDAOImpl;

@WebServlet("/NoteServlet")
public class NoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoteDAO noteDAO;  // NoteDAO实例

    @Override
    public void init() {
        // 在Servlet初始化时创建NoteDAO实例
        noteDAO = new NoteDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求
        // 使用NoteDAO实例获取笔记数据
        List<String> notes = noteDAO.getAllNotes();

        // 将笔记数据设置为请求属性
        request.setAttribute("notes", notes);

        // 使用RequestDispatcher将请求分派到note.jsp页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/note.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 处理POST请求
        String newNoteTitle = request.getParameter("note-title");
        String newNoteContent = request.getParameter("note-content");

        // 使用NoteDAO实例将新笔记添加到数据库
        String newNote = "Title: " + newNoteTitle + "\nContent: " + newNoteContent;
        noteDAO.addNote(newNote);

        // 重定向到GET请求，显示更新后的笔记列表
        response.sendRedirect(request.getContextPath() + "/NoteServlet");
    }
}

