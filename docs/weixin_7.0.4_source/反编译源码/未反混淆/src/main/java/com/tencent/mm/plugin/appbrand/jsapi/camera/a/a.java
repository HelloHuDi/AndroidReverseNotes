package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarResult;
import java.util.List;

public final class a extends b {
    private Object cli = new Object();
    private QbarNative hHf;
    private volatile boolean hHg = false;
    private byte[] hHh;
    byte[] hHi;
    private String type;

    public a(com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.a aVar, String str) {
        super(aVar);
        AppMethodBeat.i(130973);
        this.type = str;
        AppMethodBeat.o(130973);
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
            r0 = r11.hHf.a(0, "ANY", "UTF-8", com.tencent.qbar.a.iy(com.tencent.mm.sdk.platformtools.ah.getContext()));
            com.tencent.qbar.a.a(r11.hHf);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Init = [%d], SetReaders = [%d], version = [%s], readers: %s", java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r11.hHf.i(r4, r4.length)), com.tencent.qbar.QbarNative.getVersion(), java.util.Arrays.toString(r4));
     */
    /* JADX WARNING: Missing block: B:26:0x00cb, code skipped:
            if (r0 != 0) goto L_0x00cf;
     */
    /* JADX WARNING: Missing block: B:27:0x00cd, code skipped:
            if (r1 == 0) goto L_0x00e0;
     */
    /* JADX WARNING: Missing block: B:28:0x00cf, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative failed");
            sI();
            com.tencent.matrix.trace.core.AppMethodBeat.o(130974);
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(130974);
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init() {
        AppMethodBeat.i(130974);
        ab.i("MicroMsg.appbrand.ScanQBarDecoder", "init");
        String str = this.type;
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    ab.i("MicroMsg.appbrand.ScanQBarDecoder", "the QbarDecoder is already init");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130974);
            }
        }
    }

    public final boolean b(byte[] bArr, int i, int i2, int i3) {
        boolean z;
        AppMethodBeat.i(130975);
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    ab.d("MicroMsg.appbrand.ScanQBarDecoder", "decode start");
                    int[] iArr = new int[]{i, i2};
                    if (this.hHh == null) {
                        this.hHh = new byte[(((i * i2) * 3) / 2)];
                        this.hHi = new byte[(i * i2)];
                        ab.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((i * i2) * 3) / 2));
                    } else if (this.hHh.length != ((i * i2) * 3) / 2) {
                        this.hHh = null;
                        this.hHh = new byte[(((i * i2) * 3) / 2)];
                        this.hHi = null;
                        this.hHi = new byte[(i * i2)];
                        ab.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((i * i2) * 3) / 2));
                    }
                    ab.d("MicroMsg.appbrand.ScanQBarDecoder", "onFrameData: %s, width: %s, height: %s cameraRotation:%d", bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (QbarNative.a(this.hHh, iArr, bArr, i, i2, 0, 0, i, i2, i3) != 0) {
                        ab.e("MicroMsg.appbrand.ScanQBarDecoder", "decode isProOk %s", Integer.valueOf(QbarNative.a(this.hHh, iArr, bArr, i, i2, 0, 0, i, i2, i3)));
                        z = false;
                        AppMethodBeat.o(130975);
                    } else {
                        int z2;
                        System.arraycopy(this.hHh, 0, this.hHi, 0, this.hHi.length);
                        if (this.hHi != null) {
                            ab.d("MicroMsg.appbrand.ScanQBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", Integer.valueOf(this.hHi.length), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                        }
                        if (this.hHi != null) {
                            z2 = this.hHf.z(this.hHi, iArr[0], iArr[1]);
                            ab.i("MicroMsg.appbrand.ScanQBarDecoder", "after scanImage, result:%d", Integer.valueOf(z2));
                        } else {
                            z2 = -1;
                        }
                        if (z2 != 0) {
                            z = false;
                            AppMethodBeat.o(130975);
                        } else {
                            List dPR = this.hHf.dPR();
                            if (dPR.size() == 0) {
                                z = false;
                                AppMethodBeat.o(130975);
                            } else {
                                ab.i("MicroMsg.appbrand.ScanQBarDecoder", "GetResults size %d", Integer.valueOf(dPR.size()));
                                QBarResult qBarResult = (QBarResult) dPR.get(0);
                                ab.i("MicroMsg.appbrand.ScanQBarDecoder", "decode type:%s, sCharset: %s, data:%s", qBarResult.typeName, qBarResult.charset, qBarResult.data);
                                if (qBarResult == null || bo.isNullOrNil(qBarResult.data)) {
                                    z = false;
                                    AppMethodBeat.o(130975);
                                } else {
                                    String str = qBarResult.typeName;
                                    if (str.equals("QR_CODE") || str.equals("WX_CODE")) {
                                        b(qBarResult.data, 1, qBarResult.rawData);
                                        z = true;
                                        AppMethodBeat.o(130975);
                                    } else {
                                        b(qBarResult.data, 2, null);
                                        z = true;
                                        AppMethodBeat.o(130975);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    ab.e("MicroMsg.appbrand.ScanQBarDecoder", "not init");
                    z = false;
                }
            } finally {
                AppMethodBeat.o(130975);
            }
        }
        return z;
    }

    public final void release() {
        AppMethodBeat.i(130976);
        ab.i("MicroMsg.appbrand.ScanQBarDecoder", "release");
        sI();
        AppMethodBeat.o(130976);
    }

    private void sI() {
        AppMethodBeat.i(130977);
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    int release = this.hHf.release();
                    this.hHf = null;
                    this.hHg = false;
                    ab.d("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Release():%d", Integer.valueOf(release));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130977);
            }
        }
    }
}
