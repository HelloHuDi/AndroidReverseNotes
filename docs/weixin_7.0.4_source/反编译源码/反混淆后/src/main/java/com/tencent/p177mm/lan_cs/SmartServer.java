package com.tencent.p177mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.lan_cs.SmartServer */
public final class SmartServer {

    /* renamed from: com.tencent.mm.lan_cs.SmartServer$C2Java */
    public static class C2Java {
        public static void onSendProgressChange(String str, long j, long j2) {
        }

        public static void onSendSucc(String str) {
        }

        public static void onSendFail(String str, int i) {
        }
    }

    /* renamed from: com.tencent.mm.lan_cs.SmartServer$ServerFileInfo */
    public static class ServerFileInfo {
        public int betweenRequestTimeoutMs = -1;
        public String cgi = null;
        public String filePath = null;
        public int fileType = 0;
        public int idleTimeoutMs = -1;
        public int totalSendTimeoutMs = -1;
    }

    /* renamed from: com.tencent.mm.lan_cs.SmartServer$Java2C */
    public static class Java2C {
        public static native void addFileInfo(ServerFileInfo serverFileInfo);

        public static native int removeFileInfo(String str);

        private static native Object[] startSmartServer();

        public static native void stopSmartServer();

        static /* synthetic */ Object[] access$000() {
            AppMethodBeat.m2504i(114651);
            Object[] startSmartServer = Java2C.startSmartServer();
            AppMethodBeat.m2505o(114651);
            return startSmartServer;
        }
    }
}
