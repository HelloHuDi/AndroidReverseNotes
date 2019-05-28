package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.c;

public class Log {
    private static c m_log_callback = null;

    public static void SetLogCallBack(c cVar) {
        m_log_callback = cVar;
    }

    public static void f(String str, String str2) {
        AppMethodBeat.i(4183);
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
            AppMethodBeat.o(4183);
            return;
        }
        AppMethodBeat.o(4183);
    }

    public static void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(4184);
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
            AppMethodBeat.o(4184);
            return;
        }
        AppMethodBeat.o(4184);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(4185);
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
            AppMethodBeat.o(4185);
            return;
        }
        AppMethodBeat.o(4185);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(4186);
        if (m_log_callback != null) {
            m_log_callback.w(str, str2);
            AppMethodBeat.o(4186);
            return;
        }
        AppMethodBeat.o(4186);
    }

    public static void w(String str, String str2, Throwable th) {
        AppMethodBeat.i(4187);
        if (m_log_callback != null) {
            m_log_callback.w(str, str2);
            AppMethodBeat.o(4187);
            return;
        }
        AppMethodBeat.o(4187);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(4188);
        if (m_log_callback != null) {
            m_log_callback.i(str, str2);
            AppMethodBeat.o(4188);
            return;
        }
        AppMethodBeat.o(4188);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(4189);
        if (m_log_callback != null) {
            m_log_callback.d(str, str2);
            AppMethodBeat.o(4189);
            return;
        }
        AppMethodBeat.o(4189);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(4190);
        if (m_log_callback != null) {
            m_log_callback.v(str, str2);
            AppMethodBeat.o(4190);
            return;
        }
        AppMethodBeat.o(4190);
    }
}
