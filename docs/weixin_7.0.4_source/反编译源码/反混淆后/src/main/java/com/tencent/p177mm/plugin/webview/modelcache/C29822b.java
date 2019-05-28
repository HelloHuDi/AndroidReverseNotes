package com.tencent.p177mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.b */
public final class C29822b {

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.b$a */
    public enum C29823a {
        HTTP(1),
        HTTPS(2);
        
        final int bJt;

        static {
            AppMethodBeat.m2505o(6828);
        }

        private C29823a(int i) {
            this.bJt = i;
        }

        /* renamed from: IJ */
        public static boolean m47279IJ(int i) {
            return (HTTP.bJt & i) > 0;
        }

        /* renamed from: IK */
        public static boolean m47280IK(int i) {
            return (HTTPS.bJt & i) > 0;
        }

        public static int cYk() {
            return HTTP.bJt | 0;
        }

        /* renamed from: IL */
        public static int m47281IL(int i) {
            return HTTPS.bJt | i;
        }

        public static String toString(int i) {
            AppMethodBeat.m2504i(6827);
            String str = "[ %s | %s ]";
            Object[] objArr = new Object[2];
            objArr[0] = C29823a.m47279IJ(i) ? "http" : "-";
            objArr[1] = C29823a.m47280IK(i) ? "https" : "-";
            String format = String.format(str, objArr);
            AppMethodBeat.m2505o(6827);
            return format;
        }
    }
}
