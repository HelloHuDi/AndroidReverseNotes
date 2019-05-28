package com.tencent.p177mm.udp.libmmudp;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;
import java.nio.ByteBuffer;

@Keep
/* renamed from: com.tencent.mm.udp.libmmudp.UdpNative */
public class UdpNative {
    public static int NOT_BIND_ERROR = VError.ERROR_FACE_MODEL_INIT;
    public static int NOT_CREATE_ERROR = VError.ERROR_FACE_TXT_INIT;
    public static int NOT_INIT_ERROR = -1000;
    public static int SEND_BUFFER_ERROR = VError.ERROR_DETECTOR_INSTANCE_INIT;
    private static boolean initCallBackFlag = false;
    private static boolean initFlag = false;
    private static C5164a mAppBrandNetworkUdpCallback;
    private static C5165b mNativeCallBackInterface;
    private static UdpNative udpNative;

    /* renamed from: com.tencent.mm.udp.libmmudp.UdpNative$a */
    public interface C5164a {
    }

    /* renamed from: com.tencent.mm.udp.libmmudp.UdpNative$b */
    public interface C5165b {
        /* renamed from: xe */
        void mo10621xe(String str);
    }

    /* renamed from: com.tencent.mm.udp.libmmudp.UdpNative$1 */
    static /* synthetic */ class C154501 {
        static final /* synthetic */ int[] ydS = new int[C23526b.values().length];

        static {
            AppMethodBeat.m2504i(96562);
            try {
                ydS[C23526b.enmMBUdpSocketStatusError.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ydS[C23526b.enmMBUdpSocketStatusclose.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ydS[C23526b.enmMBUdpSocketStatuslistening.ordinal()] = 3;
                AppMethodBeat.m2505o(96562);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(96562);
            }
        }
    }

    public native int bindMBUdpSocket(int i, int i2, String str);

    public native int closeMBUdpSocket(int i);

    public native int createMBUdpSocket(int i);

    public native void destoryBindingUdp();

    public native void destoryMBUdpSocket();

    public native void initBindingUdp(long j, long j2);

    public native int initCallBack(String str, String str2);

    public native void initMBUdpSocket(String str, String str2, String str3, String str4);

    public native int sendMBUdpSocketBuffer(int i, int i2, String str, byte[] bArr, int i3, int i4);

    public native int sendMBUdpSocketText(int i, int i2, String str, String str2);

    public native void serviceReceive(String str, int i);

    public native void testBindingUdp();

    public native void updateNativeInterface();

    public static UdpNative instance() {
        AppMethodBeat.m2504i(96563);
        if (udpNative == null) {
            udpNative = new UdpNative();
        }
        UdpNative udpNative = udpNative;
        AppMethodBeat.m2505o(96563);
        return udpNative;
    }

    public boolean hasInit() {
        return initCallBackFlag;
    }

    public void destoryUdp() {
        AppMethodBeat.m2504i(96564);
        if (initCallBackFlag) {
            initCallBackFlag = false;
            destoryBindingUdp();
        }
        AppMethodBeat.m2505o(96564);
    }

    public void InitMBUdpSocket(C5164a c5164a) {
        AppMethodBeat.m2504i(96565);
        if (!initFlag) {
            initMBUdpSocket("onMBUdpSocketEvent", "(Ljava/lang/String;II)V", "onMBUdpSocketMessage", "(Ljava/lang/String;Ljava/lang/String;[BIIII)V");
            initFlag = true;
            mAppBrandNetworkUdpCallback = c5164a;
        }
        AppMethodBeat.m2505o(96565);
    }

    public int InitCallBack(C5165b c5165b) {
        AppMethodBeat.m2504i(96566);
        int i = -1;
        if (!initCallBackFlag) {
            i = initCallBack("onCallBackEvent", "(Ljava/lang/String;)V");
            if (i == 0) {
                initCallBackFlag = true;
                mNativeCallBackInterface = c5165b;
            }
        }
        AppMethodBeat.m2505o(96566);
        return i;
    }

    public int SendMBUdpSocket(int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(96567);
        int SendMBUdpSocket = SendMBUdpSocket(i, i2, str, ByteBuffer.wrap(str2.getBytes("UTF8")), 0, str2.length());
        AppMethodBeat.m2505o(96567);
        return SendMBUdpSocket;
    }

    public int SendMBUdpSocket(int i, int i2, String str, ByteBuffer byteBuffer, int i3, int i4) {
        AppMethodBeat.m2504i(96568);
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        int length = bArr.length;
        int sendMBUdpSocketBuffer;
        if (i3 <= 0 || i3 >= length) {
            sendMBUdpSocketBuffer = sendMBUdpSocketBuffer(i, i2, str, bArr, 0, length);
            AppMethodBeat.m2505o(96568);
            return sendMBUdpSocketBuffer;
        }
        length -= i3;
        try {
            bArr = subByte(bArr, i3, length);
            if (i4 <= 0 || i4 >= length) {
                sendMBUdpSocketBuffer = sendMBUdpSocketBuffer(i, i2, str, bArr, i3, length);
                AppMethodBeat.m2505o(96568);
                return sendMBUdpSocketBuffer;
            }
            sendMBUdpSocketBuffer = sendMBUdpSocketBuffer(i, i2, str, bArr, i3, i4);
            AppMethodBeat.m2505o(96568);
            return sendMBUdpSocketBuffer;
        } catch (Exception e) {
            sendMBUdpSocketBuffer = SEND_BUFFER_ERROR;
            AppMethodBeat.m2505o(96568);
            return sendMBUdpSocketBuffer;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMBUdpSocketMessage(String str, String str2, byte[] bArr, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected */
    public void onMBUdpSocketEvent(String str, int i, int i2) {
        AppMethodBeat.m2504i(96569);
        C23526b c23526b = C23526b.values()[i];
        int[] iArr = C154501.ydS;
        c23526b.ordinal();
        AppMethodBeat.m2505o(96569);
    }

    /* Access modifiers changed, original: protected */
    public void onCallBackEvent(String str) {
        AppMethodBeat.m2504i(96570);
        mNativeCallBackInterface.mo10621xe(str);
        AppMethodBeat.m2505o(96570);
    }

    private byte[] subByte(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(96571);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        AppMethodBeat.m2505o(96571);
        return bArr2;
    }
}
