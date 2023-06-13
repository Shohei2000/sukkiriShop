package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.RegisterLogic;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String age1 = request.getParameter("age");
		int age = Integer.parseInt(age1);

		//新規登録の実行
		Account account = new Account(userId, pass, mail, name, age);
		RegisterLogic bo = new RegisterLogic();
		boolean result = bo.execute(account);

		//新規登録処理の成否によって処理を分岐
		if(result) { // 新規登録成功時

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerOK.jsp");
			dispatcher.forward(request, response);

		}else { //新規登録失敗時
			//リダイレクト
			response.sendRedirect("/sukkiriShop/register.jsp");
		}


	}
}