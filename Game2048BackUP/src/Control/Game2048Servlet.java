package Control;

import java.io.*;

import JavaCode.Game2048Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Game2048Servlet")
public class Game2048Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String buttonValue = request.getParameter("button");
		
		// 세션에서 배열 가져오기
        HttpSession session = request.getSession();
        int[] intArray = (int[]) session.getAttribute("intArray");
        
        // 세션에 없으면 16개의 정수 배열 생성
        if (intArray == null) {
        	int rand;
        	intArray = new int[18];
            for (int i = 0; i < 16; i++) {
                intArray[i] = 0;
            }
            rand = (int)(Math.random()*16);
        	intArray[rand] = 2;
        	rand = (int)(Math.random()*16);
        	intArray[rand] = 4;
        }
        
        Game2048Main game2048Main = new Game2048Main();
        
        if (buttonValue == null) {
        	tablePrint(response, intArray);
        }
        switch (buttonValue) {
        case "up":
        	intArray = game2048Main.turn(intArray, "w");
        	break;
        case "down":

        	intArray = game2048Main.turn(intArray, "s");
        	break;
        case "left":
        	intArray = game2048Main.turn(intArray, "a");
        	break;
        case "right":
        	intArray = game2048Main.turn(intArray, "d");
        	break;
        case "restart":
        	int rand;
        	intArray = new int[18];
            for (int i = 0; i < 18; i++) {
                intArray[i] = 0;
            }
            rand = (int)(Math.random()*16);
        	intArray[rand] = 2;
        	rand = (int)(Math.random()*16);
        	intArray[rand] = 4;
        	break;
        default:
        }
        if (intArray[0]==-1) {
        	scorePrint(response, intArray);
        } else {
        	// 세션에 배열 저장
            session.setAttribute("intArray", intArray);
            tablePrint(response, intArray);
        }
        
        
    }
	
	private void tablePrint(HttpServletResponse response, int[] intArray) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String str = "<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content = \"text/html;charset=UTF-8\">\r\n" + 
				"<title>2048</title>    \r\n" + 
				"	<style>\r\n" + 
				"         /* CSS 스타일 지정 */\r\n" + 
				"        table {\r\n" + 
				"         	margin-top: 50px; /* 위쪽 여백 설정 */\r\n" + 
				"		    margin-bottom: 50px; /* 아래쪽 여백 설정 */\r\n" + 
				"        	border: 1.5px solid black;\r\n" + 
				"            padding: ;\r\n" + 
				"            border-collapse: collapse; /* 테이블 셀 테두리 합치기 */\r\n" + 
				"            width: 50%; /* 테이블 전체 너비 */\r\n" + 
				"            height: 50vh\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        th, td {\r\n" + 
				"            border: 1.5px solid black; /* 셀 테두리 스타일 */\r\n" + 
				"            padding: 5px 15px; /* 셀 내부 여백 */\r\n" + 
				"            text-align: center; /* 가운데 정렬 */\r\n" + 
				"            font-size: 26px; /* 텍스트 크기 설정 */\r\n" + 
				"        }\r\n" + 
				"		tr:nth-child(even) td:nth-child(even),\r\n" + 
				"		tr:nth-child(odd) td:nth-child(odd) {\r\n" + 
				"		    background-color: #e0e0e0; /* 짝수 번째 행, 짝수 번째 열 */\r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		tr:nth-child(even) td:nth-child(odd),\r\n" + 
				"		tr:nth-child(odd) td:nth-child(even) {\r\n" + 
				"		    background-color: #f0f0f0; /* 짝수 번째 행, 홀수 번째 열 또는 홀수 번째 행, 짝수 번째 열 */\r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		button {\r\n" + 
				"			width: 100px; /* 테이블 전체 너비 */\r\n" + 
				"            height: 50px;\r\n" + 
				"            padding: 10px;\r\n" + 
				"            margin-bottom: 10px;\r\n" + 
				"            font-size: 20px;\r\n" + 
				"		}\r\n" + 
				"\r\n" + 
				"        \r\n" + 
				"    </style>\r\n" + 
				"    \r\n" + 
				"	<script>\r\n" + 
				"	   // 버튼 클릭 시 표의 값과 버튼 ID를 서블릿으로 전송하는 함수\r\n" + 
				"	   function buttonClick(buttonId) {}\r\n" + 
				"	       document.myGame.method = \"post\";\r\n" + 
				"	       document.myGame.action = \"Game2048Servlet\";\r\n" + 
				"	       document.myGame.submit();\r\n" + 
				"	   }\r\n" + 
				"	</script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<form name = 'myGame' method='post' action='Game2048Servlet' encType=\"UTF-8\">\r\n" + 
				"<center>\r\n" + 
				"    <table id=\"myTable\">\r\n" + 
				"        <tr>\r\n" + 
				"            <td>"+ intArray[0] +"</td>\r\n" + 
				"            <td>"+ intArray[1] +"</td>\r\n" + 
				"            <td>"+ intArray[2] +"</td>\r\n" + 
				"            <td>"+ intArray[3] +"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>"+ intArray[4] +"</td>\r\n" + 
				"            <td>"+ intArray[5] +"</td>\r\n" + 
				"            <td>"+ intArray[6] +"</td>\r\n" + 
				"            <td>"+ intArray[7] +"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>"+ intArray[8] +"</td>\r\n" + 
				"            <td>"+ intArray[9] +"</td>\r\n" + 
				"            <td>"+ intArray[10] +"</td>\r\n" + 
				"            <td>"+ intArray[11] +"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>"+ intArray[12] +"</td>\r\n" + 
				"            <td>"+ intArray[13] +"</td>\r\n" + 
				"            <td>"+ intArray[14] +"</td>\r\n" + 
				"            <td>"+ intArray[15] +"</td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>\r\n" + 
				"    <button id=\"up\" value=\"up\" name = \"button\" Onclick = \"buttonClick()\">up</button><br>\r\n" + 
				"    <button id=\"left\" value=\"left\" name = \"button\" Onclick = \"buttonClick()\">left</button>\r\n" + 
				"    <button id=\"down\" value=\"down\" name = \"button\" Onclick = \"buttonClick()\">down</button>\r\n" + 
				"    <button id=\"right\" value=\"right\" name = \"button\" Onclick = \"buttonClick()\">right</button>\r\n" + 
				"</center>\r\n" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>";
        out.print(str);
	}
	
	private void scorePrint(HttpServletResponse response, int[] intArray) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String str = "<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content = \"text/html;charset=UTF-8\">\r\n" + 
				"<title>2048</title>    \r\n" + 
				"	<style>\r\n" + 
				"         /* CSS 스타일 지정 */\r\n" + 
				"        table {\r\n" + 
				"         	margin-top: 50px; /* 위쪽 여백 설정 */\r\n" + 
				"		    margin-bottom: 50px; /* 아래쪽 여백 설정 */\r\n" + 
				"        	border: 1.5px solid black;\r\n" + 
				"            padding: ;\r\n" + 
				"            border-collapse: collapse; /* 테이블 셀 테두리 합치기 */\r\n" + 
				"            width: 50%; /* 테이블 전체 너비 */\r\n" + 
				"            height: 10vh\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        th, td {\r\n" + 
				"            border: 1.5px solid black; /* 셀 테두리 스타일 */\r\n" + 
				"            padding: 5px 15px; /* 셀 내부 여백 */\r\n" + 
				"            text-align: center; /* 가운데 정렬 */\r\n" + 
				"            font-size: 26px; /* 텍스트 크기 설정 */\r\n" + 
				"        }\r\n" + 
				"		tr:nth-child(odd) {\r\n" + 
				"		    background-color: #e0e0e0; \r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		tr:nth-child(even){\r\n" + 
				"		    background-color: #ffffff; \r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		button {\r\n" + 
				"			width: 150px; /* 테이블 전체 너비 */\r\n" + 
				"            height: 50px;\r\n" + 
				"            padding: 10px;\r\n" + 
				"            margin-bottom: 10px;\r\n" + 
				"            font-size: 20px;\r\n" + 
				"		}\r\n" + 
				"\r\n" + 
				"        \r\n" + 
				"    </style>\r\n" + 
				"    \r\n" + 
				"	<script>\r\n" + 
				"	   // 버튼 클릭 시 표의 값과 버튼 ID를 서블릿으로 전송하는 함수\r\n" + 
				"	   function buttonClick(buttonId) {}\r\n" + 
				"	       document.myGame.method = \"post\";\r\n" + 
				"	       document.myGame.action = \"Game2048Servlet\";\r\n" + 
				"	       document.myGame.submit();\r\n" + 
				"	   }\r\n" + 
				"	</script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<form name = 'myGame' method='post' action='Game2048Servlet' encType=\"UTF-8\">\r\n" + 
				"<center>\r\n" + 
				"    <table id=\"myTable\">\r\n" + 
				"        <tr>\r\n" + 
				"            <td>"+ "점수" +"</td>\r\n" + 
				"            <td>"+ "이동 횟수" +"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>"+ intArray[16] +"</td>\r\n" + 
				"            <td>"+ intArray[17] +"</td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>\r\n" + 
				"    <a href='/Game2048/Game2048Servlet?button=restart'; style=\"display: inline-block; padding: 10px 20px; background-color: #007BFF; color: white; text-align: center; text-decoration: none; border-radius: 5px;\">다시시작</a>" + 
				"</center>\r\n" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>";
        out.print(str);
	}
	
		
}


	
