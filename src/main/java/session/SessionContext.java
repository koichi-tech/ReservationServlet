package session;

import jakarta.servlet.http.HttpSession;

public class SessionContext {
    // ThreadLocalでHttpSessionをスレッドごとに保持
    private static final ThreadLocal<HttpSession> sessionHolder = new ThreadLocal<>();

    // HttpSessionを設定するメソッド（Listenerから呼び出す）
    public static void setSession(HttpSession session) {
        sessionHolder.set(session);
    }

    // HttpSessionを取得するメソッド（普通のクラスから呼び出す）
    public static HttpSession getSession() {
        return sessionHolder.get();
    }

    // HttpSessionを削除するメソッド（Listenerから呼び出す。メモリリーク防止）
    public static void clear() {
        sessionHolder.remove();
    }
}
