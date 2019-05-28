package com.tencent.mm.udp.libmmudp;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;
import java.nio.ByteBuffer;

@Keep
public class UdpNative {
    public static int NOT_BIND_ERROR = VError.ERROR_FACE_MODEL_INIT;
    public static int NOT_CREATE_ERROR = VError.ERROR_FACE_TXT_INIT;
    public static int NOT_INIT_ERROR = -1000;
    public static int SEND_BUFFER_ERROR = VError.ERROR_DETECTOR_INSTANCE_INIT;
    private static boolean initCallBackFlag = false;
    private static boolean initFlag = false;
    private static a mAppBrandNetworkUdpCallback;
    private static b mNativeCallBackInterface;
    private static UdpNative udpNative;

    public interface a {
    }

    public interface b {
        void xe(String str);
    }

    /* renamed from: com.tencent.mm.udp.libmmudp.UdpNative$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ydS = new int[b.values().length];

        static {
            AppMethodBeat.i(96562);
            try {
                ydS[b.enmMBUdpSocketStatusError.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ydS[b.enmMBUdpSocketStatusclose.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ydS[b.enmMBUdpSocketStatuslistening.ordinal()] = 3;
                AppMethodBeat.o(96562);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(96562);
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
        AppMethodBeat.i(96563);
        if (udpNative == null) {
            udpNative = new UdpNative();
        }
        UdpNative udpNative = udpNative;
        AppMethodBeat.o(96563);
        return udpNative;
    }

    public boolean hasInit() {
        return initCallBackFlag;
    }

    public void destoryUdp() {
        AppMethodBeat.i(96564);
        if (initCallBackFlag) {
            initCallBackFlag = false;
            destoryBindingUdp();
        }
        AppMethodBeat.o(96564);
    }

    public void InitMBUdpSocket(a aVar) {
        AppMethodBeat.i(96565);
        if (!initFlag) {
            initMBUdpSocket("onMBUdpSocketEvent", "(Ljava/lang/String;II)V", "onMBUdpSocketMessage", "(Ljava/lang/String;Ljava/lang/String;[BIIII)V");
            initFlag = true;
            mAppBrandNetworkUdpCallback = aVar;
        }
        AppMethodBeat.o(96565);
    }

    public int InitCallBack(b bVar) {
        AppMethodBeat.i(96566);
        int i = -1;
        if (!initCallBackFlag) {
            i = initCallBack("onCallBackEvent", "(Ljava/lang/String;)V");
            if (i == 0) {
                initCallBackFlag = true;
                mNativeCallBackInterface = bVar;
            }
        }
        AppMethodBeat.o(96566);
        return i;
    }

    public int SendMBUdpSocket(int i, int i2, String str, String str2) {
        AppMethodBeat.i(96567);
        int SendMBUdpSocket = SendMBUdpSocket(i, i2, str, ByteBuffer.wrap(str2.getBytes("UTF8")), 0, str2.length());
        AppMethodBeat.o(96567);
        return SendMBUdpSocket;
    }

    public int SendMBUdpSocket(int i, int i2, String str, ByteBuffer byteBuffer, int i3, int i4) {
        AppMethodBeat.i(96568);
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        int length = bArr.length;
        int sendMBUdpSocketBuffer;
        if (i3 <= 0 || i3 >= length) {
            sendMBUdpSocketBuffer = sendMBUdpSocketBuffer(i, i2, str, bArr, 0, length);
            AppMethodBeat.o(96568);
            return sendMBUdpSocketBuffer;
        }
        length -= i3;
        try {
            bArr = subByte(bArr, i3, length);
            if (i4 <= 0 || i4 >= length) {
                sendMBUdpSocketBuffer = sendMBUdpSocketBuffer(i, i2, str, bArr, i3, length);
                AppMethodBeat.o(96568);
                return sendMBUdpSocketBuffer;
            }
            sendMBUdpSocketBuffer = sendMBUdpSocketBuffer(i, i2, str, bArr, i3, i4);
            AppMethodBeat.o(96568);
            return sendMBUdpSocketBuffer;
        } catch (Exception e) {
            sendMBUdpSocketBuffer = SEND_BUFFER_ERROR;
            AppMethodBeat.o(96568);
            return sendMBUdpSocketBuffer;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMBUdpSocketMessage(String str, String str2, byte[] bArr, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected */
    public void onMBUdpSocketEvent(String str, int i, int i2) {
        AppMethodBeat.i(96569);
        b bVar = b.values()[i];
        int[] iArr = AnonymousClass1.ydS;
        bVar.ordinal();
        AppMethodBeat.o(96569);
    }

    /* Access modifiers changed, original: protected */
    public void onCallBackEvent(String str) {
        AppMethodBeat.i(96570);
        mNativeCallBackInterface.xe(str);
        AppMethodBeat.o(96570);
    }

    private byte[] subByte(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(96571);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        AppMethodBeat.o(96571);
        return bArr2;
    }
}
