package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import com.tencent.qbar.QbarNative.QBarResult;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d extends b {
    private Object cli = new Object();
    private QbarNative hHf = new QbarNative();
    private boolean hHg = false;
    private byte[] hHh;
    private byte[] hHi;
    public volatile boolean isDecoding = false;
    public boolean ovx = true;
    public boolean qdM = false;
    public Set<Integer> qfh;
    public int qht;

    public d(a aVar, int i, boolean z) {
        super(aVar);
        AppMethodBeat.i(81381);
        this.qht = i;
        this.ovx = z;
        AppMethodBeat.o(81381);
    }

    private synchronized byte[] a(byte[] bArr, Point point, Rect rect, Point point2) {
        byte[] bArr2;
        AppMethodBeat.i(81382);
        if (bArr == null || bArr.length <= 0) {
            ab.w("MicroMsg.scanner.QBarDecoder", "prepareGrayData , data is null");
            bArr2 = null;
            AppMethodBeat.o(81382);
        } else {
            ab.i("MicroMsg.scanner.QBarDecoder", "resolution %s, coverage %s", point, rect);
            long currentTimeMillis = System.currentTimeMillis();
            Rect rect2 = new Rect();
            int width;
            int height;
            if (com.tencent.mm.compatible.e.d.Lt() || !this.ovx) {
                width = rect.width() % 4;
                height = rect.height() % 4;
                rect2.left = rect.left;
                rect2.right = rect.right - width;
                rect2.top = rect.top;
                rect2.bottom = rect.bottom - height;
                if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                    bArr2 = null;
                    AppMethodBeat.o(81382);
                }
            } else {
                rect2.left = (point.x / 2) - (rect.height() / 2);
                rect2.right = (point.x / 2) + (rect.height() / 2);
                rect2.top = (point.y / 2) - (rect.width() / 2);
                rect2.bottom = (point.y / 2) + (rect.width() / 2);
                if (rect2.left < 0) {
                    rect2.left = 0;
                }
                if (rect2.right > point.x - 1) {
                    rect2.right = point.x - 1;
                }
                if (rect2.top < 0) {
                    rect2.top = 0;
                }
                if (rect2.bottom > point.y - 1) {
                    rect2.bottom = point.y - 1;
                }
                width = rect2.width() % 4;
                height = rect2.height() % 4;
                if (width != 0) {
                    rect2.right -= width;
                }
                if (height != 0) {
                    rect2.bottom -= height;
                }
                if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                    bArr2 = null;
                    AppMethodBeat.o(81382);
                }
            }
            ab.i("MicroMsg.scanner.QBarDecoder", "targetRect %s", rect2);
            c cVar = new c(bArr, point.x, point.y, rect2);
            point2.x = cVar.width;
            point2.y = cVar.height;
            int i = 0;
            if (!com.tencent.mm.compatible.e.d.Lt()) {
                i = 90;
                point2.x = cVar.height;
                point2.y = cVar.width;
            }
            ab.d("MicroMsg.scanner.QBarDecoder", "rotate angle: ".concat(String.valueOf(i)));
            if (this.hHh == null) {
                this.hHh = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                this.hHi = new byte[(cVar.width * cVar.height)];
                ab.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((cVar.width * cVar.height) * 3) / 2));
            } else if (this.hHh.length != ((cVar.width * cVar.height) * 3) / 2) {
                this.hHh = null;
                this.hHh = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                this.hHi = null;
                this.hHi = new byte[(cVar.width * cVar.height)];
                ab.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((cVar.width * cVar.height) * 3) / 2));
            }
            if (QbarNative.a(this.hHh, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i) != 0) {
                ab.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", Integer.valueOf(QbarNative.a(this.hHh, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i)));
                bArr2 = null;
                AppMethodBeat.o(81382);
            } else {
                System.arraycopy(this.hHh, 0, this.hHi, 0, this.hHi.length);
                ab.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                bArr2 = this.hHi;
                AppMethodBeat.o(81382);
            }
        }
        return bArr2;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        AppMethodBeat.i(81383);
        Point point2 = new Point();
        byte[] a = a(bArr, point, rect, point2);
        if (a == null || a.length <= 0) {
            AppMethodBeat.o(81383);
            return false;
        }
        boolean b = b(a, point2);
        AppMethodBeat.o(81383);
        return b;
    }

    public final synchronized byte[] a(byte[] bArr, Point point, int i, Rect rect, Point point2) {
        byte[] bArr2;
        AppMethodBeat.i(81384);
        if (270 == i) {
            bArr2 = new byte[bArr.length];
            QbarNative.a(bArr2, bArr, point.x, point.y);
            bArr = new byte[bArr.length];
            QbarNative.a(bArr, bArr2, point.y, point.x);
            QbarNative.nativeRelease();
        }
        bArr2 = a(bArr, point, rect, point2);
        AppMethodBeat.o(81384);
        return bArr2;
    }

    public final void a(final byte[] bArr, final Point point) {
        AppMethodBeat.i(81385);
        com.tencent.mm.sdk.g.d.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(81380);
                if (d.a(d.this, bArr, point)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81378);
                            if (d.this.qhj != null) {
                                d.this.qhj.b(b.qhm, d.this.qhl, d.this.rawData, d.this.qhk, d.this.cvn, d.this.cvo);
                            }
                            AppMethodBeat.o(81378);
                        }
                    });
                    AppMethodBeat.o(81380);
                    return;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(81379);
                        if (d.this.qhj != null) {
                            d.this.qhj.jJ(d.this.qhn);
                        }
                        AppMethodBeat.o(81379);
                    }
                });
                AppMethodBeat.o(81380);
            }
        }, "scan_decode");
        AppMethodBeat.o(81385);
    }

    /* JADX WARNING: Missing block: B:72:0x02a7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(81386);
     */
    /* JADX WARNING: Missing block: B:89:?, code skipped:
            return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(byte[] bArr, Point point) {
        AppMethodBeat.i(81386);
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.scanner.QBarDecoder", "decode() start");
        if (this.isDecoding) {
            ab.e("MicroMsg.scanner.QBarDecoder", "is decoding, return false");
            AppMethodBeat.o(81386);
            return false;
        } else if (this.qdM) {
            ab.w("MicroMsg.scanner.QBarDecoder", "isReleasing, return false 1");
            AppMethodBeat.o(81386);
            return false;
        } else if (bArr == null) {
            ab.e("MicroMsg.scanner.QBarDecoder", "wrong args");
            AppMethodBeat.o(81386);
            return false;
        } else {
            synchronized (this.cli) {
                try {
                    boolean z;
                    this.isDecoding = true;
                    this.qhl = null;
                    this.cvo = 0;
                    this.cvn = 0;
                    m.pZK.cgI();
                    int i = this.qht;
                    if (this.hHg) {
                        z = this.hHg;
                    } else {
                        Set Ca = Ca(i);
                        if (!(this.hHg || Ca.isEmpty())) {
                            int a = this.hHf.a(0, "ANY", "UTF-8", com.tencent.qbar.a.iy(ah.getContext()));
                            com.tencent.qbar.a.a(this.hHf);
                            m.pZK.qaa = Ca.contains(Integer.valueOf(3));
                            ab.i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", Integer.valueOf(a), Integer.valueOf(h(Ca)), QbarNative.getVersion());
                            if (a == 0 && r2 == 0) {
                                this.hHg = true;
                            } else {
                                ab.e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
                                z = false;
                            }
                        }
                        z = this.hHg;
                    }
                    if (z) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ab.i("MicroMsg.scanner.QBarDecoder", "data len %d, image size %s", Integer.valueOf(bArr.length), point);
                        int z2 = this.hHf.z(bArr, point.x, point.y);
                        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                        QbarNative qbarNative = this.hHf;
                        QBarZoomInfo qBarZoomInfo = new QBarZoomInfo();
                        qbarNative.GetZoomInfo(qBarZoomInfo, qbarNative.Aqx);
                        ab.i("MicroMsg.scanner.QBarDecoder", "after scanImage, result:%d, isZoom %b, zoomFactor %f", Integer.valueOf(z2), Boolean.valueOf(qBarZoomInfo.isZoom), Float.valueOf(qBarZoomInfo.zoomFactor));
                        if (z2 < 0 && qBarZoomInfo.isZoom && this.qhj != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("zoom_action", 6);
                            bundle.putInt("zoom_type", 1);
                            bundle.putInt("zoom_scale", (int) (qBarZoomInfo.zoomFactor * 100.0f));
                            this.qhj.K(bundle);
                        }
                        m.pZK.fc(point.x, point.y);
                        m.pZK.cgJ();
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        m.pZK.jH(currentTimeMillis2);
                        ab.d("MicroMsg.scanner.QBarDecoder", "decode ScanImage %s, cost:%d", Integer.valueOf(z2), Long.valueOf(currentTimeMillis3));
                        if (z2 != 0) {
                            m mVar = m.pZK;
                            ArrayList arrayList = new ArrayList();
                            this.hHf.t(arrayList, new ArrayList());
                            mVar.qab = arrayList;
                            this.isDecoding = false;
                            AppMethodBeat.o(81386);
                            return false;
                        }
                        m.pZK.cgH();
                        m.pZK.jI(currentTimeMillis2);
                        LinkedList linkedList = new LinkedList();
                        LinkedList linkedList2 = new LinkedList();
                        this.hHf.s(linkedList, linkedList2);
                        if (linkedList.size() != 0) {
                            QBarResult qBarResult = (QBarResult) linkedList.get(0);
                            ab.i("MicroMsg.scanner.QBarDecoder", "decode size %d, type:%s, sCharset: %s, data:%s", Integer.valueOf(linkedList.size()), qBarResult.typeName, qBarResult.charset, qBarResult.data);
                            QBarReportMsg qBarReportMsg = null;
                            if (!bo.ek(linkedList2)) {
                                qBarReportMsg = (QBarReportMsg) linkedList2.get(0);
                            }
                            if (qBarResult != null) {
                                if (!bo.isNullOrNil(qBarResult.data)) {
                                    String str = qBarResult.typeName;
                                    if (str.equals("QR_CODE") || str.equals("WX_CODE")) {
                                        this.qhl = qBarResult.data;
                                        qhm = 1;
                                    } else {
                                        this.qhl = str + "," + qBarResult.data;
                                        qhm = 2;
                                    }
                                }
                                this.cvn = r.Ws(qBarResult.typeName);
                                this.cvo = qBarReportMsg != null ? qBarReportMsg.qrcodeVersion : 0;
                                this.rawData = qBarResult.rawData;
                                m.pZK.a(qBarResult.typeName, this.qhl, qBarResult.charset, qBarReportMsg, linkedList.size(), linkedList2);
                            }
                        }
                        this.isDecoding = false;
                        this.qhn = System.currentTimeMillis() - currentTimeMillis;
                        ab.i("MicroMsg.scanner.QBarDecoder", "decode() finish, resultText = [%s], cost:%d", this.qhl, Long.valueOf(this.qhn));
                        if (bo.isNullOrNil(this.qhl)) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        sI();
                        this.isDecoding = false;
                        AppMethodBeat.o(81386);
                        return false;
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.scanner.QBarDecoder", e, "decodeInternal error", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(81386);
                }
            }
        }
    }

    private static Set<Integer> Ca(int i) {
        AppMethodBeat.i(81387);
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
            hashSet.add(Integer.valueOf(3));
        } else if (i == 2) {
            hashSet.add(Integer.valueOf(1));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
        } else if (i == 0) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(1));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
            hashSet.add(Integer.valueOf(3));
        } else if (i == 3) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(3));
        }
        AppMethodBeat.o(81387);
        return hashSet;
    }

    public final void chT() {
        AppMethodBeat.i(81388);
        if (this.hHg) {
            Set set = this.qfh;
            if (set == null || set.isEmpty()) {
                set = Ca(this.qht);
            }
            h(set);
        }
        AppMethodBeat.o(81388);
    }

    private int h(Set<Integer> set) {
        int i = 0;
        AppMethodBeat.i(81389);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.o(81389);
        } else {
            int[] iArr = new int[set.size()];
            int i2 = 0;
            for (Integer num : set) {
                if (num != null) {
                    int i3 = i2 + 1;
                    iArr[i2] = num.intValue();
                    i2 = i3;
                }
            }
            ab.i("MicroMsg.scanner.QBarDecoder", "QBarNative.SetReaders, readers:%s", Arrays.toString(iArr));
            synchronized (this.cli) {
                try {
                    if (this.hHf != null) {
                        i = this.hHf.i(iArr, iArr.length);
                    } else {
                        AppMethodBeat.o(81389);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(81389);
                }
            }
        }
        return i;
    }

    public final void sI() {
        AppMethodBeat.i(81390);
        ab.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", Boolean.valueOf(this.hHg));
        this.qdM = true;
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    int release = this.hHf.release();
                    this.hHf = null;
                    this.hHg = false;
                    ab.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", Integer.valueOf(release));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81390);
            }
        }
        c.chQ();
    }

    public final void chP() {
        AppMethodBeat.i(81391);
        if (this.hHg) {
            sI();
            this.hHg = false;
        }
        this.qdM = false;
        this.isDecoding = false;
        this.hHf = new QbarNative();
        AppMethodBeat.o(81391);
    }
}
