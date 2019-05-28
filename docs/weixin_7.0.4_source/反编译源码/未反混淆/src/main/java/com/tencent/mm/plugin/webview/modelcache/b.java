package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {

    public enum a {
        HTTP(1),
        HTTPS(2);
        
        final int bJt;

        static {
            AppMethodBeat.o(6828);
        }

        private a(int i) {
            this.bJt = i;
        }

        public static boolean IJ(int i) {
            return (HTTP.bJt & i) > 0;
        }

        public static boolean IK(int i) {
            return (HTTPS.bJt & i) > 0;
        }

        public static int cYk() {
            return HTTP.bJt | 0;
        }

        public static int IL(int i) {
            return HTTPS.bJt | i;
        }

        public static String toString(int i) {
            AppMethodBeat.i(6827);
            String str = "[ %s | %s ]";
            Object[] objArr = new Object[2];
            objArr[0] = IJ(i) ? "http" : "-";
            objArr[1] = IK(i) ? "https" : "-";
            String format = String.format(str, objArr);
            AppMethodBeat.o(6827);
            return format;
        }
    }
}
