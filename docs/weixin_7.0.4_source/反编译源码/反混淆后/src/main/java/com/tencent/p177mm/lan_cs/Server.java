package com.tencent.p177mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.lan_cs.Server */
public final class Server {
    public static C1747a eOu;

    /* renamed from: com.tencent.mm.lan_cs.Server$C2Java */
    public static class C2Java {
        public static void onSend(String str, int i, int i2) {
            AppMethodBeat.m2504i(114646);
            if (Server.eOu != null) {
                Server.eOu.mo5281jW(i2);
            }
            AppMethodBeat.m2505o(114646);
        }

        public static void onRecv(String str, int i, byte[] bArr) {
            AppMethodBeat.m2504i(114647);
            if (Server.eOu != null) {
                Server.eOu.onRecv(str, i, bArr);
            }
            AppMethodBeat.m2505o(114647);
        }

        public static void onConnect(String str, int i) {
            AppMethodBeat.m2504i(114648);
            if (Server.eOu != null) {
                Server.eOu.onConnect(str, i);
            }
            AppMethodBeat.m2505o(114648);
        }

        public static void onDisconnect(String str, int i) {
            AppMethodBeat.m2504i(114649);
            if (Server.eOu != null) {
                Server.eOu.mo5280SX();
            }
            AppMethodBeat.m2505o(114649);
        }
    }

    /* renamed from: com.tencent.mm.lan_cs.Server$Java2C */
    public static class Java2C {
        public static native int send(String str, int i, byte[] bArr);

        private static native Object[] start();

        public static native void stop();

        public static /* synthetic */ Object[] access$000() {
            AppMethodBeat.m2504i(114650);
            Object[] start = Java2C.start();
            AppMethodBeat.m2505o(114650);
            return start;
        }
    }

    /* renamed from: com.tencent.mm.lan_cs.Server$a */
    public interface C1747a {
        /* renamed from: SX */
        void mo5280SX();

        /* renamed from: jW */
        void mo5281jW(int i);

        void onConnect(String str, int i);

        void onRecv(String str, int i, byte[] bArr);
    }
}
