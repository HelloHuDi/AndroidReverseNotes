package com.tencent.p177mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.lan_cs.Client */
public final class Client {
    public static C1746a eOt;

    /* renamed from: com.tencent.mm.lan_cs.Client$C2Java */
    public static class C2Java {
        public static void onRecv(String str, int i, byte[] bArr) {
            AppMethodBeat.m2504i(114644);
            if (Client.eOt != null) {
                Client.eOt.onRecv(str, i, bArr);
            }
            AppMethodBeat.m2505o(114644);
        }

        public static void onDisconnect(String str, int i) {
            AppMethodBeat.m2504i(114645);
            if (Client.eOt != null) {
                Client.eOt.mo5278SX();
            }
            AppMethodBeat.m2505o(114645);
        }
    }

    /* renamed from: com.tencent.mm.lan_cs.Client$Java2C */
    public static class Java2C {
        public static native void disconnect();

        public static native int send(String str, int i, byte[] bArr);
    }

    /* renamed from: com.tencent.mm.lan_cs.Client$a */
    public interface C1746a {
        /* renamed from: SX */
        void mo5278SX();

        void onRecv(String str, int i, byte[] bArr);
    }
}
