package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Server {
    public static a eOu;

    public static class C2Java {
        public static void onSend(String str, int i, int i2) {
            AppMethodBeat.i(114646);
            if (Server.eOu != null) {
                Server.eOu.jW(i2);
            }
            AppMethodBeat.o(114646);
        }

        public static void onRecv(String str, int i, byte[] bArr) {
            AppMethodBeat.i(114647);
            if (Server.eOu != null) {
                Server.eOu.onRecv(str, i, bArr);
            }
            AppMethodBeat.o(114647);
        }

        public static void onConnect(String str, int i) {
            AppMethodBeat.i(114648);
            if (Server.eOu != null) {
                Server.eOu.onConnect(str, i);
            }
            AppMethodBeat.o(114648);
        }

        public static void onDisconnect(String str, int i) {
            AppMethodBeat.i(114649);
            if (Server.eOu != null) {
                Server.eOu.SX();
            }
            AppMethodBeat.o(114649);
        }
    }

    public static class Java2C {
        public static native int send(String str, int i, byte[] bArr);

        private static native Object[] start();

        public static native void stop();

        public static /* synthetic */ Object[] access$000() {
            AppMethodBeat.i(114650);
            Object[] start = start();
            AppMethodBeat.o(114650);
            return start;
        }
    }

    public interface a {
        void SX();

        void jW(int i);

        void onConnect(String str, int i);

        void onRecv(String str, int i, byte[] bArr);
    }
}
