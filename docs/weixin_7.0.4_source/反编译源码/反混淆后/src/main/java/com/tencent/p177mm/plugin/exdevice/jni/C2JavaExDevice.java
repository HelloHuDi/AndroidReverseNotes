package com.tencent.p177mm.plugin.exdevice.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C38956j;
import com.tencent.p177mm.plugin.exdevice.service.C34039a;
import com.tencent.p177mm.plugin.exdevice.service.C34044b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.jni.C2JavaExDevice */
public final class C2JavaExDevice {
    private static final String TAG = "MicroMsg.exdevice.C2JavaExDevice";

    public static void C2Java_onTaskEnd(long j, int i, int i2, String str, byte[] bArr) {
        AppMethodBeat.m2504i(19071);
        C34039a.m55770c(j, i, i2, str);
        AppMethodBeat.m2505o(19071);
    }

    public static void C2Java_onStateChange(long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(19072);
        C34039a.m55768b(j, i, i2, i3);
        AppMethodBeat.m2505o(19072);
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        AppMethodBeat.m2504i(19073);
        C34039a.onDeviceRequest(j, s, s2, bArr, i);
        AppMethodBeat.m2505o(19073);
    }

    public static void createSession(long j, long j2) {
        AppMethodBeat.m2504i(19074);
        C34044b.createSession(j, j2);
        AppMethodBeat.m2505o(19074);
    }

    public static boolean sendData(long j, byte[] bArr) {
        AppMethodBeat.m2504i(19075);
        boolean sendData = C34044b.sendData(j, bArr);
        AppMethodBeat.m2505o(19075);
        return sendData;
    }

    public static boolean connect(long j) {
        AppMethodBeat.m2504i(19076);
        boolean connect = C34044b.connect(j);
        AppMethodBeat.m2505o(19076);
        return connect;
    }

    public static void destroySession(long j) {
        AppMethodBeat.m2504i(19077);
        C34044b.destroySession(j);
        AppMethodBeat.m2505o(19077);
    }

    public static void onAirKissCallback(int i, int i2) {
        AppMethodBeat.m2504i(19078);
        C4990ab.m7419v(TAG, "onAirKissCallback(errType : %d, errCode : %d)", Integer.valueOf(i), Integer.valueOf(i2));
        C38956j.boN().mo61838h(0, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(19078);
    }

    public static void onReceiveWCLanDeviceDiscPackage(byte[] bArr) {
        AppMethodBeat.m2504i(19079);
        String str = TAG;
        String str2 = "onReceiveWCLanDeviceDiscPackage, dataLen(%d).";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        C38956j.boN().mo61838h(10, bArr);
        AppMethodBeat.m2505o(19079);
    }

    public static void onWCLanDeviceUdpError(int i) {
        AppMethodBeat.m2504i(19080);
        C4990ab.m7417i(TAG, "onWCLanDeviceUdpError, errCode(%d).", Integer.valueOf(i));
        C38956j.boN().mo61838h(11, Integer.valueOf(i));
        AppMethodBeat.m2505o(19080);
    }

    public static void onWCLanReceiveResponse(int i, byte[] bArr) {
        AppMethodBeat.m2504i(19081);
        String str = TAG;
        String str2 = "onWCLanReceiveResponse, cmdId(%d), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        C38956j.boN().mo61838h(12, Integer.valueOf(i), bArr);
        AppMethodBeat.m2505o(19081);
    }

    public static void onWCLanDeviceConnectStateNotify(String str, int i) {
        AppMethodBeat.m2504i(19082);
        C4990ab.m7417i(TAG, "onWCLanDeviceConnectStateNotify, devclassinfo(%s), stateCode(%d).", str, Integer.valueOf(i));
        C38956j.boN().mo61838h(13, str, Integer.valueOf(i));
        AppMethodBeat.m2505o(19082);
    }

    public static void onReceiveWCLanDeviceProfile(byte[] bArr) {
        AppMethodBeat.m2504i(19083);
        String str = TAG;
        String str2 = "onReceiveWCLanDeviceProfile, data(%d).";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        C38956j.boN().mo61838h(14, bArr);
        AppMethodBeat.m2505o(19083);
    }

    public static void onWCLanFileTransferUpdate(int i, byte[] bArr) {
        AppMethodBeat.m2504i(19084);
        String str = TAG;
        String str2 = "onWCLanFileTransferUpdate, cmdId(%d), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        C38956j.boN().mo61838h(15, Integer.valueOf(i), bArr);
        AppMethodBeat.m2505o(19084);
    }

    public static void onWCLanReceiveNotify(String str, byte[] bArr) {
        AppMethodBeat.m2504i(19085);
        String str2 = TAG;
        String str3 = "onWCLanReceiveNotify, devclassinfo(%s), data(%d).";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str2, str3, objArr);
        C38956j.boN().mo61838h(16, str, bArr);
        AppMethodBeat.m2505o(19085);
    }
}
