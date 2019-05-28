package com.tencent.p177mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.plugin.scanner.p740a.C21682m;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qbar.C24245a;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import com.tencent.qbar.QbarNative.QBarResult;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.scanner.util.d */
public final class C13178d extends C3771b {
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

    public C13178d(C3772a c3772a, int i, boolean z) {
        super(c3772a);
        AppMethodBeat.m2504i(81381);
        this.qht = i;
        this.ovx = z;
        AppMethodBeat.m2505o(81381);
    }

    /* renamed from: a */
    private synchronized byte[] m21194a(byte[] bArr, Point point, Rect rect, Point point2) {
        byte[] bArr2;
        AppMethodBeat.m2504i(81382);
        if (bArr == null || bArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.scanner.QBarDecoder", "prepareGrayData , data is null");
            bArr2 = null;
            AppMethodBeat.m2505o(81382);
        } else {
            C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "resolution %s, coverage %s", point, rect);
            long currentTimeMillis = System.currentTimeMillis();
            Rect rect2 = new Rect();
            int width;
            int height;
            if (C32468d.m53154Lt() || !this.ovx) {
                width = rect.width() % 4;
                height = rect.height() % 4;
                rect2.left = rect.left;
                rect2.right = rect.right - width;
                rect2.top = rect.top;
                rect2.bottom = rect.bottom - height;
                if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                    bArr2 = null;
                    AppMethodBeat.m2505o(81382);
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
                    AppMethodBeat.m2505o(81382);
                }
            }
            C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "targetRect %s", rect2);
            C13177c c13177c = new C13177c(bArr, point.x, point.y, rect2);
            point2.x = c13177c.width;
            point2.y = c13177c.height;
            int i = 0;
            if (!C32468d.m53154Lt()) {
                i = 90;
                point2.x = c13177c.height;
                point2.y = c13177c.width;
            }
            C4990ab.m7410d("MicroMsg.scanner.QBarDecoder", "rotate angle: ".concat(String.valueOf(i)));
            if (this.hHh == null) {
                this.hHh = new byte[(((c13177c.width * c13177c.height) * 3) / 2)];
                this.hHi = new byte[(c13177c.width * c13177c.height)];
                C4990ab.m7411d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((c13177c.width * c13177c.height) * 3) / 2));
            } else if (this.hHh.length != ((c13177c.width * c13177c.height) * 3) / 2) {
                this.hHh = null;
                this.hHh = new byte[(((c13177c.width * c13177c.height) * 3) / 2)];
                this.hHi = null;
                this.hHi = new byte[(c13177c.width * c13177c.height)];
                C4990ab.m7411d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((c13177c.width * c13177c.height) * 3) / 2));
            }
            if (QbarNative.m49364a(this.hHh, new int[]{point2.x, point2.y}, bArr, point.x, point.y, c13177c.left, c13177c.top, c13177c.width, c13177c.height, i) != 0) {
                C4990ab.m7413e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", Integer.valueOf(QbarNative.m49364a(this.hHh, new int[]{point2.x, point2.y}, bArr, point.x, point.y, c13177c.left, c13177c.top, c13177c.width, c13177c.height, i)));
                bArr2 = null;
                AppMethodBeat.m2505o(81382);
            } else {
                System.arraycopy(this.hHh, 0, this.hHi, 0, this.hHi.length);
                C4990ab.m7411d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                bArr2 = this.hHi;
                AppMethodBeat.m2505o(81382);
            }
        }
        return bArr2;
    }

    /* renamed from: a */
    public final boolean mo8442a(byte[] bArr, Point point, Rect rect) {
        AppMethodBeat.m2504i(81383);
        Point point2 = new Point();
        byte[] a = m21194a(bArr, point, rect, point2);
        if (a == null || a.length <= 0) {
            AppMethodBeat.m2505o(81383);
            return false;
        }
        boolean b = m21195b(a, point2);
        AppMethodBeat.m2505o(81383);
        return b;
    }

    /* renamed from: a */
    public final synchronized byte[] mo25230a(byte[] bArr, Point point, int i, Rect rect, Point point2) {
        byte[] bArr2;
        AppMethodBeat.m2504i(81384);
        if (270 == i) {
            bArr2 = new byte[bArr.length];
            QbarNative.m49361a(bArr2, bArr, point.x, point.y);
            bArr = new byte[bArr.length];
            QbarNative.m49361a(bArr, bArr2, point.y, point.x);
            QbarNative.nativeRelease();
        }
        bArr2 = m21194a(bArr, point, rect, point2);
        AppMethodBeat.m2505o(81384);
        return bArr2;
    }

    /* renamed from: a */
    public final void mo25229a(final byte[] bArr, final Point point) {
        AppMethodBeat.m2504i(81385);
        C7305d.m12298f(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.scanner.util.d$1$2 */
            class C131802 implements Runnable {
                C131802() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(81379);
                    if (C13178d.this.qhj != null) {
                        C13178d.this.qhj.mo8430jJ(C13178d.this.qhn);
                    }
                    AppMethodBeat.m2505o(81379);
                }
            }

            /* renamed from: com.tencent.mm.plugin.scanner.util.d$1$1 */
            class C131811 implements Runnable {
                C131811() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(81378);
                    if (C13178d.this.qhj != null) {
                        C13178d.this.qhj.mo8421b(C3771b.qhm, C13178d.this.qhl, C13178d.this.rawData, C13178d.this.qhk, C13178d.this.cvn, C13178d.this.cvo);
                    }
                    AppMethodBeat.m2505o(81378);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(81380);
                if (C13178d.m21193a(C13178d.this, bArr, point)) {
                    C5004al.m7441d(new C131811());
                    AppMethodBeat.m2505o(81380);
                    return;
                }
                C5004al.m7441d(new C131802());
                AppMethodBeat.m2505o(81380);
            }
        }, "scan_decode");
        AppMethodBeat.m2505o(81385);
    }

    /* JADX WARNING: Missing block: B:72:0x02a7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(81386);
     */
    /* JADX WARNING: Missing block: B:89:?, code skipped:
            return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private boolean m21195b(byte[] bArr, Point point) {
        AppMethodBeat.m2504i(81386);
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7416i("MicroMsg.scanner.QBarDecoder", "decode() start");
        if (this.isDecoding) {
            C4990ab.m7412e("MicroMsg.scanner.QBarDecoder", "is decoding, return false");
            AppMethodBeat.m2505o(81386);
            return false;
        } else if (this.qdM) {
            C4990ab.m7420w("MicroMsg.scanner.QBarDecoder", "isReleasing, return false 1");
            AppMethodBeat.m2505o(81386);
            return false;
        } else if (bArr == null) {
            C4990ab.m7412e("MicroMsg.scanner.QBarDecoder", "wrong args");
            AppMethodBeat.m2505o(81386);
            return false;
        } else {
            synchronized (this.cli) {
                try {
                    boolean z;
                    this.isDecoding = true;
                    this.qhl = null;
                    this.cvo = 0;
                    this.cvn = 0;
                    C21682m.pZK.cgI();
                    int i = this.qht;
                    if (this.hHg) {
                        z = this.hHg;
                    } else {
                        Set Ca = C13178d.m21192Ca(i);
                        if (!(this.hHg || Ca.isEmpty())) {
                            int a = this.hHf.mo49467a(0, "ANY", "UTF-8", C24245a.m37337iy(C4996ah.getContext()));
                            C24245a.m37336a(this.hHf);
                            C21682m.pZK.qaa = Ca.contains(Integer.valueOf(3));
                            C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", Integer.valueOf(a), Integer.valueOf(m21196h(Ca)), QbarNative.getVersion());
                            if (a == 0 && r2 == 0) {
                                this.hHg = true;
                            } else {
                                C4990ab.m7412e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
                                z = false;
                            }
                        }
                        z = this.hHg;
                    }
                    if (z) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "data len %d, image size %s", Integer.valueOf(bArr.length), point);
                        int z2 = this.hHf.mo49473z(bArr, point.x, point.y);
                        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                        QbarNative qbarNative = this.hHf;
                        QBarZoomInfo qBarZoomInfo = new QBarZoomInfo();
                        qbarNative.GetZoomInfo(qBarZoomInfo, qbarNative.Aqx);
                        C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "after scanImage, result:%d, isZoom %b, zoomFactor %f", Integer.valueOf(z2), Boolean.valueOf(qBarZoomInfo.isZoom), Float.valueOf(qBarZoomInfo.zoomFactor));
                        if (z2 < 0 && qBarZoomInfo.isZoom && this.qhj != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("zoom_action", 6);
                            bundle.putInt("zoom_type", 1);
                            bundle.putInt("zoom_scale", (int) (qBarZoomInfo.zoomFactor * 100.0f));
                            this.qhj.mo8420K(bundle);
                        }
                        C21682m.pZK.mo37159fc(point.x, point.y);
                        C21682m.pZK.cgJ();
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        C21682m.pZK.mo37160jH(currentTimeMillis2);
                        C4990ab.m7411d("MicroMsg.scanner.QBarDecoder", "decode ScanImage %s, cost:%d", Integer.valueOf(z2), Long.valueOf(currentTimeMillis3));
                        if (z2 != 0) {
                            C21682m c21682m = C21682m.pZK;
                            ArrayList arrayList = new ArrayList();
                            this.hHf.mo49472t(arrayList, new ArrayList());
                            c21682m.qab = arrayList;
                            this.isDecoding = false;
                            AppMethodBeat.m2505o(81386);
                            return false;
                        }
                        C21682m.pZK.cgH();
                        C21682m.pZK.mo37161jI(currentTimeMillis2);
                        LinkedList linkedList = new LinkedList();
                        LinkedList linkedList2 = new LinkedList();
                        this.hHf.mo49471s(linkedList, linkedList2);
                        if (linkedList.size() != 0) {
                            QBarResult qBarResult = (QBarResult) linkedList.get(0);
                            C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "decode size %d, type:%s, sCharset: %s, data:%s", Integer.valueOf(linkedList.size()), qBarResult.typeName, qBarResult.charset, qBarResult.data);
                            QBarReportMsg qBarReportMsg = null;
                            if (!C5046bo.m7548ek(linkedList2)) {
                                qBarReportMsg = (QBarReportMsg) linkedList2.get(0);
                            }
                            if (qBarResult != null) {
                                if (!C5046bo.isNullOrNil(qBarResult.data)) {
                                    String str = qBarResult.typeName;
                                    if (str.equals("QR_CODE") || str.equals("WX_CODE")) {
                                        this.qhl = qBarResult.data;
                                        qhm = 1;
                                    } else {
                                        this.qhl = str + "," + qBarResult.data;
                                        qhm = 2;
                                    }
                                }
                                this.cvn = C28923r.m45942Ws(qBarResult.typeName);
                                this.cvo = qBarReportMsg != null ? qBarReportMsg.qrcodeVersion : 0;
                                this.rawData = qBarResult.rawData;
                                C21682m.pZK.mo37154a(qBarResult.typeName, this.qhl, qBarResult.charset, qBarReportMsg, linkedList.size(), linkedList2);
                            }
                        }
                        this.isDecoding = false;
                        this.qhn = System.currentTimeMillis() - currentTimeMillis;
                        C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "decode() finish, resultText = [%s], cost:%d", this.qhl, Long.valueOf(this.qhn));
                        if (C5046bo.isNullOrNil(this.qhl)) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        mo8444sI();
                        this.isDecoding = false;
                        AppMethodBeat.m2505o(81386);
                        return false;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.scanner.QBarDecoder", e, "decodeInternal error", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(81386);
                }
            }
        }
    }

    /* renamed from: Ca */
    private static Set<Integer> m21192Ca(int i) {
        AppMethodBeat.m2504i(81387);
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
        AppMethodBeat.m2505o(81387);
        return hashSet;
    }

    public final void chT() {
        AppMethodBeat.m2504i(81388);
        if (this.hHg) {
            Set set = this.qfh;
            if (set == null || set.isEmpty()) {
                set = C13178d.m21192Ca(this.qht);
            }
            m21196h(set);
        }
        AppMethodBeat.m2505o(81388);
    }

    /* renamed from: h */
    private int m21196h(Set<Integer> set) {
        int i = 0;
        AppMethodBeat.m2504i(81389);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.m2505o(81389);
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
            C4990ab.m7417i("MicroMsg.scanner.QBarDecoder", "QBarNative.SetReaders, readers:%s", Arrays.toString(iArr));
            synchronized (this.cli) {
                try {
                    if (this.hHf != null) {
                        i = this.hHf.mo49469i(iArr, iArr.length);
                    } else {
                        AppMethodBeat.m2505o(81389);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(81389);
                }
            }
        }
        return i;
    }

    /* renamed from: sI */
    public final void mo8444sI() {
        AppMethodBeat.m2504i(81390);
        C4990ab.m7411d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", Boolean.valueOf(this.hHg));
        this.qdM = true;
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    int release = this.hHf.release();
                    this.hHf = null;
                    this.hHg = false;
                    C4990ab.m7411d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", Integer.valueOf(release));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(81390);
            }
        }
        C13177c.chQ();
    }

    public final void chP() {
        AppMethodBeat.m2504i(81391);
        if (this.hHg) {
            mo8444sI();
            this.hHg = false;
        }
        this.qdM = false;
        this.isDecoding = false;
        this.hHf = new QbarNative();
        AppMethodBeat.m2505o(81391);
    }
}
