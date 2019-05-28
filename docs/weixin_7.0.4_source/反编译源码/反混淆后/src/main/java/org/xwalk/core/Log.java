package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.C6036c;

public class Log {
    private static C6036c m_log_callback = null;

    public static void SetLogCallBack(C6036c c6036c) {
        m_log_callback = c6036c;
    }

    /* renamed from: f */
    public static void m81048f(String str, String str2) {
        AppMethodBeat.m2504i(4183);
        if (m_log_callback != null) {
            m_log_callback.mo4778e(str, str2);
            AppMethodBeat.m2505o(4183);
            return;
        }
        AppMethodBeat.m2505o(4183);
    }

    /* renamed from: e */
    public static void m81047e(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(4184);
        if (m_log_callback != null) {
            m_log_callback.mo4778e(str, str2);
            AppMethodBeat.m2505o(4184);
            return;
        }
        AppMethodBeat.m2505o(4184);
    }

    /* renamed from: e */
    public static void m81046e(String str, String str2) {
        AppMethodBeat.m2504i(4185);
        if (m_log_callback != null) {
            m_log_callback.mo4778e(str, str2);
            AppMethodBeat.m2505o(4185);
            return;
        }
        AppMethodBeat.m2505o(4185);
    }

    /* renamed from: w */
    public static void m81051w(String str, String str2) {
        AppMethodBeat.m2504i(4186);
        if (m_log_callback != null) {
            m_log_callback.mo4781w(str, str2);
            AppMethodBeat.m2505o(4186);
            return;
        }
        AppMethodBeat.m2505o(4186);
    }

    /* renamed from: w */
    public static void m81052w(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(4187);
        if (m_log_callback != null) {
            m_log_callback.mo4781w(str, str2);
            AppMethodBeat.m2505o(4187);
            return;
        }
        AppMethodBeat.m2505o(4187);
    }

    /* renamed from: i */
    public static void m81049i(String str, String str2) {
        AppMethodBeat.m2504i(4188);
        if (m_log_callback != null) {
            m_log_callback.mo4779i(str, str2);
            AppMethodBeat.m2505o(4188);
            return;
        }
        AppMethodBeat.m2505o(4188);
    }

    /* renamed from: d */
    public static void m81045d(String str, String str2) {
        AppMethodBeat.m2504i(4189);
        if (m_log_callback != null) {
            m_log_callback.mo4777d(str, str2);
            AppMethodBeat.m2505o(4189);
            return;
        }
        AppMethodBeat.m2505o(4189);
    }

    /* renamed from: v */
    public static void m81050v(String str, String str2) {
        AppMethodBeat.m2504i(4190);
        if (m_log_callback != null) {
            m_log_callback.mo4780v(str, str2);
            AppMethodBeat.m2505o(4190);
            return;
        }
        AppMethodBeat.m2505o(4190);
    }
}
