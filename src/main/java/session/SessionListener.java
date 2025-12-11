package session;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebListener
public class SessionListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // リクエスト開始時に呼ばれる
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        
        // セッションを取得（なければnull。falseを指定）
        HttpSession session = request.getSession(false); 
        
        if (session != null) {
            // ThreadLocalにセッションをセット
            SessionContext.setSession(session);
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // リクエスト終了時に呼ばれる
        // ThreadLocalに保持したセッションを必ずクリアする
        SessionContext.clear();
    }
}
