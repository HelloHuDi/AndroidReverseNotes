package com.tencent.mm.plugin.exdevice.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.service.a;
import com.tencent.mm.plugin.exdevice.service.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class C2JavaExDevice {
    private static final String TAG = "MicroMsg.exdevice.C2JavaExDevice";

    public static void C2Java_onTaskEnd(long j, int i, int i2, String str, byte[] bArr) {
        AppMethodBeat.i(19071);
        a.c(j, i, i2, str);
        AppMethodBeat.o(19071);
    }

    public static void C2Java_onStateChange(long j, int i, int i2, int i3) {
        AppMethodBeat.i(19072);
        a.b(j, i, i2, i3);
        AppMethodBeat.o(19072);
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        AppMethodBeat.i(19073);
        a.onDeviceRequest(j, s, s2, bArr, i);
        AppMethodBeat.o(19073);
    }

    public static void createSession(long j, long j2) {
        AppMethodBeat.i(19074);
        b.createSession(j, j2);
        AppMethodBeat.o(19074);
    }

    public static boolean sendData(long j, byte[] bArr) {
        AppMethodBeat.i(19075);
        boolean sendData = b.sendData(j, bArr);
        AppMethodBeat.o(19075);
        return sendData;
    }

    public static boolean connect(long j) {
        AppMethodBeat.i(19076);
        boolean connect = b.connect(j);
        AppMethodBeat.o(19076);
        return connect;
    }

    public static void destroySession(long j) {
        AppMethodBeat.i(19077);
        b.destroySession(j);
        AppMethodBeat.o(19077);
    }

    public static void onAirKissCallback(int i, int i2) {
        AppMethodBeat.i(19078);
        ab.v(TAG, "onAirKissCallback(errType : %d, errCode : %d)", Integer.valueOf(i), Integer.valueOf(i2));
        j.boN().h(0, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(19078);
    }

    public static void onReceiveWCLanDeviceDiscPackage(byte[] bArr) {
        AppMethodBeat.i(19079);
        String str = TAG;
        String str2 = "onReceiveWCLanDeviceDiscPackage, dataLen(%d).";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        j.boN().h(10, bArr);
        AppMethodBeat.o(19079);
    }

    public static void onWCLanDeviceUdpError(int i) {
        AppMethodBeat.i(19080);
        ab.i(TAG, "onWCLanDeviceUdpError, errCode(%d).", Integer.valueOf(i));
        j.boN().h(11, Integer.valueOf(i));
        AppMethodBeat.o(19080);
    }

    public static void onWCLanReceiveResponse(int i, byte[] bArr) {
        AppMethodBeat.i(19081);
        String str = TAG;
        String str2 = "onWCLanReceiveResponse, cmdId(%d), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        j.boN().h(12, Integer.valueOf(i), bArr);
        AppMethodBeat.o(19081);
    }

    public static void onWCLanDeviceConnectStateNotify(String str, int i) {
        AppMethodBeat.i(19082);
        ab.i(TAG, "onWCLanDeviceConnectStateNotify, devclassinfo(%s), stateCode(%d).", str, Integer.valueOf(i));
        j.boN().h(13, str, Integer.valueOf(i));
        AppMethodBeat.o(19082);
    }

    public static void onReceiveWCLanDeviceProfile(byte[] bArr) {
        AppMethodBeat.i(19083);
        String str = TAG;
        String str2 = "onReceiveWCLanDeviceProfile, data(%d).";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        j.boN().h(14, bArr);
        AppMethodBeat.o(19083);
    }

    public static void onWCLanFileTransferUpdate(int i, byte[] bArr) {
        AppMethodBeat.i(19084);
        String str = TAG;
        String str2 = "onWCLanFileTransferUpdate, cmdId(%d), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        j.boN().h(15, Integer.valueOf(i), bArr);
        AppMethodBeat.o(19084);
    }

    public static void onWCLanReceiveNotify(String str, byte[] bArr) {
        AppMethodBeat.i(19085);
        String str2 = TAG;
        String str3 = "onWCLanReceiveNotify, devclassinfo(%s), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str2, str3, objArr);
        j.boN().h(16, str, bArr);
        AppMethodBeat.o(19085);
    }
}
