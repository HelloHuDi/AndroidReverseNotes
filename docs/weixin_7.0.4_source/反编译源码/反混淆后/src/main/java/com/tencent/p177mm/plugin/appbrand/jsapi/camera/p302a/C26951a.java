package com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a.C19348b.C19349a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarResult;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a.a */
public final class C26951a extends C19348b {
    private Object cli = new Object();
    private QbarNative hHf;
    private volatile boolean hHg = false;
    private byte[] hHh;
    byte[] hHi;
    private String type;

    public C26951a(C19349a c19349a, String str) {
        super(c19349a);
        AppMethodBeat.m2504i(130973);
        this.type = str;
        AppMethodBeat.m2505o(130973);
    }

    /* JADX WARNING: Missing block: B:9:0x002b, code skipped:
            r11.hHf = new com.tencent.qbar.QbarNative();
            r1 = new java.util.HashSet();
     */
    /* JADX WARNING: Missing block: B:10:0x003e, code skipped:
            if (r0.contains("barcode") == false) goto L_0x0047;
     */
    /* JADX WARNING: Missing block: B:11:0x0040, code skipped:
            r1.add(java.lang.Integer.valueOf(1));
     */
    /* JADX WARNING: Missing block: B:13:0x004e, code skipped:
            if (r0.contains("qrcode") == false) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:14:0x0050, code skipped:
            r1.add(java.lang.Integer.valueOf(2));
     */
    /* JADX WARNING: Missing block: B:15:0x0057, code skipped:
            r1.add(java.lang.Integer.valueOf(4));
            r4 = new int[r1.size()];
            r5 = r1.iterator();
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:17:0x006d, code skipped:
            if (r5.hasNext() == false) goto L_0x0087;
     */
    /* JADX WARNING: Missing block: B:18:0x006f, code skipped:
            r0 = (java.lang.Integer) r5.next();
     */
    /* JADX WARNING: Missing block: B:19:0x0075, code skipped:
            if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Missing block: B:20:0x0077, code skipped:
            r3 = r1 + 1;
            r4[r1] = r0.intValue();
            r1 = r3;
     */
    /* JADX WARNING: Missing block: B:25:0x0087, code skipped:
            r0 = r11.hHf.mo49467a(0, "ANY", "UTF-8", com.tencent.qbar.C24245a.m37337iy(com.tencent.p177mm.sdk.platformtools.C4996ah.getContext()));
            com.tencent.qbar.C24245a.m37336a(r11.hHf);
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Init = [%d], SetReaders = [%d], version = [%s], readers: %s", java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r11.hHf.mo49469i(r4, r4.length)), com.tencent.qbar.QbarNative.getVersion(), java.util.Arrays.toString(r4));
     */
    /* JADX WARNING: Missing block: B:26:0x00cb, code skipped:
            if (r0 != 0) goto L_0x00cf;
     */
    /* JADX WARNING: Missing block: B:27:0x00cd, code skipped:
            if (r1 == 0) goto L_0x00e0;
     */
    /* JADX WARNING: Missing block: B:28:0x00cf, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative failed");
            m42904sI();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(130974);
     */
    /* JADX WARNING: Missing block: B:29:0x00e0, code skipped:
            r1 = r11.cli;
     */
    /* JADX WARNING: Missing block: B:30:0x00e2, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            r11.hHg = true;
     */
    /* JADX WARNING: Missing block: B:34:0x00e6, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:38:0x00ee, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(130974);
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init() {
        AppMethodBeat.m2504i(130974);
        C4990ab.m7416i("MicroMsg.appbrand.ScanQBarDecoder", "init");
        String str = this.type;
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    C4990ab.m7416i("MicroMsg.appbrand.ScanQBarDecoder", "the QbarDecoder is already init");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130974);
            }
        }
    }

    /* renamed from: b */
    public final boolean mo34510b(byte[] bArr, int i, int i2, int i3) {
        boolean z;
        AppMethodBeat.m2504i(130975);
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    C4990ab.m7410d("MicroMsg.appbrand.ScanQBarDecoder", "decode start");
                    int[] iArr = new int[]{i, i2};
                    if (this.hHh == null) {
                        this.hHh = new byte[(((i * i2) * 3) / 2)];
                        this.hHi = new byte[(i * i2)];
                        C4990ab.m7411d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((i * i2) * 3) / 2));
                    } else if (this.hHh.length != ((i * i2) * 3) / 2) {
                        this.hHh = null;
                        this.hHh = new byte[(((i * i2) * 3) / 2)];
                        this.hHi = null;
                        this.hHi = new byte[(i * i2)];
                        C4990ab.m7411d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((i * i2) * 3) / 2));
                    }
                    C4990ab.m7411d("MicroMsg.appbrand.ScanQBarDecoder", "onFrameData: %s, width: %s, height: %s cameraRotation:%d", bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (QbarNative.m49364a(this.hHh, iArr, bArr, i, i2, 0, 0, i, i2, i3) != 0) {
                        C4990ab.m7413e("MicroMsg.appbrand.ScanQBarDecoder", "decode isProOk %s", Integer.valueOf(QbarNative.m49364a(this.hHh, iArr, bArr, i, i2, 0, 0, i, i2, i3)));
                        z = false;
                        AppMethodBeat.m2505o(130975);
                    } else {
                        int z2;
                        System.arraycopy(this.hHh, 0, this.hHi, 0, this.hHi.length);
                        if (this.hHi != null) {
                            C4990ab.m7411d("MicroMsg.appbrand.ScanQBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", Integer.valueOf(this.hHi.length), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                        }
                        if (this.hHi != null) {
                            z2 = this.hHf.mo49473z(this.hHi, iArr[0], iArr[1]);
                            C4990ab.m7417i("MicroMsg.appbrand.ScanQBarDecoder", "after scanImage, result:%d", Integer.valueOf(z2));
                        } else {
                            z2 = -1;
                        }
                        if (z2 != 0) {
                            z = false;
                            AppMethodBeat.m2505o(130975);
                        } else {
                            List dPR = this.hHf.dPR();
                            if (dPR.size() == 0) {
                                z = false;
                                AppMethodBeat.m2505o(130975);
                            } else {
                                C4990ab.m7417i("MicroMsg.appbrand.ScanQBarDecoder", "GetResults size %d", Integer.valueOf(dPR.size()));
                                QBarResult qBarResult = (QBarResult) dPR.get(0);
                                C4990ab.m7417i("MicroMsg.appbrand.ScanQBarDecoder", "decode type:%s, sCharset: %s, data:%s", qBarResult.typeName, qBarResult.charset, qBarResult.data);
                                if (qBarResult == null || C5046bo.isNullOrNil(qBarResult.data)) {
                                    z = false;
                                    AppMethodBeat.m2505o(130975);
                                } else {
                                    String str = qBarResult.typeName;
                                    if (str.equals("QR_CODE") || str.equals("WX_CODE")) {
                                        mo34509b(qBarResult.data, 1, qBarResult.rawData);
                                        z = true;
                                        AppMethodBeat.m2505o(130975);
                                    } else {
                                        mo34509b(qBarResult.data, 2, null);
                                        z = true;
                                        AppMethodBeat.m2505o(130975);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.appbrand.ScanQBarDecoder", "not init");
                    z = false;
                }
            } finally {
                AppMethodBeat.m2505o(130975);
            }
        }
        return z;
    }

    public final void release() {
        AppMethodBeat.m2504i(130976);
        C4990ab.m7416i("MicroMsg.appbrand.ScanQBarDecoder", "release");
        m42904sI();
        AppMethodBeat.m2505o(130976);
    }

    /* renamed from: sI */
    private void m42904sI() {
        AppMethodBeat.m2504i(130977);
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    int release = this.hHf.release();
                    this.hHf = null;
                    this.hHg = false;
                    C4990ab.m7411d("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Release():%d", Integer.valueOf(release));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130977);
            }
        }
    }
}
