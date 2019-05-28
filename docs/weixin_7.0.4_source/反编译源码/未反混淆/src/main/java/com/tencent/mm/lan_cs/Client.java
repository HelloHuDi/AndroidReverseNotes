package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Client {
    public static a eOt;

    public static class C2Java {
        public static void onRecv(String str, int i, byte[] bArr) {
            AppMethodBeat.i(114644);
            if (Client.eOt != null) {
                Client.eOt.onRecv(str, i, bArr);
            }
            AppMethodBeat.o(114644);
        }

        public static void onDisconnect(String str, int i) {
            AppMethodBeat.i(114645);
            if (Client.eOt != null) {
                Client.eOt.SX();
            }
            AppMethodBeat.o(114645);
        }
    }

    public static class Java2C {
        public static native void disconnect();

        public static native int send(String str, int i, byte[] bArr);
    }

    public interface a {
        void SX();

        void onRecv(String str, int i, byte[] bArr);
    }
}
