package com.tencent.mars.stn;

import com.tencent.mars.Mars;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class StnLogic {
    public static final int CONNECTED = 4;
    public static final int CONNECTTING = 3;
    public static int ECHECK_NEVER = 2;
    public static int ECHECK_NEXT = 1;
    public static int ECHECK_NOW = 0;
    public static final int GATEWAY_FAILED = 1;
    public static final int INVALID_TASK_ID = -1;
    public static final int NETWORK_UNAVAILABLE = 0;
    public static final int NETWORK_UNKNOWN = -1;
    public static int RESP_FAIL_HANDLE_DEFAULT = -1;
    public static int RESP_FAIL_HANDLE_NORMAL = 0;
    public static int RESP_FAIL_HANDLE_SESSION_TIMEOUT = -13;
    public static int RESP_FAIL_HANDLE_TASK_END = -14;
    public static final int SERVER_DOWN = 5;
    public static final int SERVER_FAILED = 2;
    private static final String TAG = "mars.StnLogic";
    private static ICallBack callBack = null;
    public static final int ectDial = 2;
    public static final int ectDns = 3;
    public static final int ectEnDecode = 7;
    public static final int ectFalse = 1;
    public static final int ectHttp = 5;
    public static final int ectLocal = 9;
    public static final int ectNetMsgXP = 6;
    public static final int ectOK = 0;
    public static final int ectServer = 8;
    public static final int ectSocket = 4;

    public interface ICallBack {
        public static final int BaseNetDetectEnd = 2;
        public static final int DetectConnectFail = 1;
        public static final int DetectConnectOK = 0;
        public static final int DetectEnd = 4;
        public static final int DetectLongLinkEnd = 0;
        public static final int DetectNotStart = 3;
        public static final int DetectShortLinkEnd = 1;
        public static final int DetectTimeout = 2;

        int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2);

        int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr);

        boolean isLogoned();

        boolean makesureAuthed();

        void networkAnalysisCallBack(int i, int i2, boolean z, String str);

        boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2);

        String[] onNewDns(String str);

        void onPush(int i, byte[] bArr);

        int onTaskEnd(int i, Object obj, int i2, int i3);

        void reportConnectInfo(int i, int i2);

        boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2);

        void requestDoSync();

        String[] requestNetCheckShortLinkHosts();
    }

    public static class Task {
        public static final int EBoth = 3;
        public static final int EFAST = 1;
        public static final int ELong = 2;
        public static final int ENORMAL = 0;
        public static final int EShort = 1;
        public static final int ETASK_PRIORITY_0 = 0;
        public static final int ETASK_PRIORITY_1 = 1;
        public static final int ETASK_PRIORITY_2 = 2;
        public static final int ETASK_PRIORITY_3 = 3;
        public static final int ETASK_PRIORITY_4 = 4;
        public static final int ETASK_PRIORITY_5 = 5;
        public static final int ETASK_PRIORITY_HIGHEST = 0;
        public static final int ETASK_PRIORITY_LOWEST = 5;
        public static final int ETASK_PRIORITY_NORMAL = 3;
        private static AtomicInteger ai = new AtomicInteger(0);
        public String cgi;
        public int channelSelect;
        public int channelStrategy;
        public int cmdID;
        public boolean limitFlow;
        public boolean limitFrequency;
        public boolean needAuthed;
        public boolean networkStatusSensitive;
        public int priority;
        public String reportArg;
        public int retryCount = -1;
        public boolean sendOnly;
        public int serverProcessCost;
        public ArrayList<String> shortLinkHostList;
        public int taskID = ai.incrementAndGet();
        public int totalTimeout;
        public Object userContext;

        public Task(int i, int i2, String str, ArrayList<String> arrayList) {
            this.channelSelect = i;
            this.cmdID = i2;
            this.cgi = str;
            this.shortLinkHostList = arrayList;
            this.sendOnly = false;
            this.needAuthed = true;
            this.limitFlow = true;
            this.limitFrequency = true;
            this.channelStrategy = 0;
            this.networkStatusSensitive = false;
            this.priority = 3;
            this.retryCount = -1;
            this.serverProcessCost = 0;
            this.totalTimeout = 0;
            this.userContext = null;
        }
    }

    public static native void clearTask();

    private static native ArrayList<String> getLoadLibraries();

    public static native boolean hasTask(int i);

    public static native void keepSignalling();

    public static native void makesureLongLinkConnected();

    public static native void redoTask();

    public static native void reset();

    public static native void setBackupIPs(String str, String[] strArr);

    public static native void setDebugIP(String str, String str2);

    public static native void setLonglinkSvrAddr(String str, int[] iArr, String str2);

    public static native void setProductID(short s);

    public static native void setShortlinkSvrAddr(int i, String str);

    public static native void setSignallingStrategy(long j, long j2);

    public static native boolean startNetworkAnalysis();

    public static native void startTask(Task task);

    public static native void stopSignalling();

    public static native void stopTask(int i);

    static {
        ArrayList loadLibraries;
        try {
            loadLibraries = getLoadLibraries();
        } catch (UnsatisfiedLinkError e) {
            loadLibraries = null;
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(loadLibraries, TAG);
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static void setLonglinkSvrAddr(String str, int[] iArr) {
        setLonglinkSvrAddr(str, iArr, null);
    }

    public static void setShortlinkSvrAddr(int i) {
        setShortlinkSvrAddr(i, null);
    }

    private static String exception2String(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static boolean makesureAuthed() {
        if (callBack == null) {
            return false;
        }
        return callBack.makesureAuthed();
    }

    private static String[] onNewDns(String str) {
        if (callBack == null) {
            return null;
        }
        return callBack.onNewDns(str);
    }

    private static void onPush(int i, byte[] bArr) {
        if (callBack != null) {
            callBack.onPush(i, bArr);
        }
    }

    private static boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        if (callBack == null) {
            return false;
        }
        return callBack.req2Buf(i, obj, byteArrayOutputStream, iArr, i2);
    }

    private static int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2) {
        if (callBack == null) {
            return RESP_FAIL_HANDLE_TASK_END;
        }
        return callBack.buf2Resp(i, obj, bArr, iArr, iArr2, i2);
    }

    private static int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int i2) {
        return 0;
    }

    private static int onTaskEnd(int i, Object obj, int i2, int i3) {
        if (callBack == null) {
            return 0;
        }
        return callBack.onTaskEnd(i, obj, i2, i3);
    }

    private static void trafficData(int i, int i2) {
    }

    private static void reportConnectStatus(int i, int i2) {
        if (callBack != null) {
            callBack.reportConnectInfo(i, i2);
        }
    }

    private static int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        if (callBack == null) {
            return ECHECK_NEVER;
        }
        return callBack.getLongLinkIdentifyCheckBuffer(byteArrayOutputStream, byteArrayOutputStream2, iArr);
    }

    private static boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        if (callBack == null) {
            return false;
        }
        return callBack.onLongLinkIdentifyResp(bArr, bArr2);
    }

    private static String[] requestNetCheckShortLinkHosts() {
        if (callBack == null) {
            return null;
        }
        return callBack.requestNetCheckShortLinkHosts();
    }

    public static void requestDoSync() {
        if (callBack != null) {
            callBack.requestDoSync();
        }
    }

    public static boolean isLogoned() {
        if (callBack == null) {
            return false;
        }
        return callBack.isLogoned();
    }

    private static void reportTaskProfile(String str) {
    }

    private static void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
        if (callBack != null) {
            callBack.networkAnalysisCallBack(i, i2, z, str);
        }
    }
}
