package session;

import jakarta.servlet.http.HttpSession;

public class UserInfoSession {

	    
	    public String getMailAddressFromSession() {
	        // SessionContext経由でHttpSessionを取得
	        HttpSession session = SessionContext.getSession();

	        if (session != null) {
	            // セッションに格納されている情報を取得
	            Object nameObj = session.getAttribute("mailAddress");
	            if (nameObj != null) {
	                return (String) nameObj;
	            }
	        }
	        return null;
	    }
	    
	    public void updateSessionData(String newData) {
	        HttpSession session = SessionContext.getSession();
	        if (session != null) {
	            session.setAttribute("lastAccess", newData);
	        }
	    }
	
}
