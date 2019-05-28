package com.tencent.p177mm.plugin.p543u.p544a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.scanner.p740a.C21682m;
import com.tencent.p177mm.plugin.scanner.util.C13177c;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.plugin.scanner.util.C39638f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.qbar.C24245a;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import com.tencent.qbar.QbarNative.QBarResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import p699f.C6094a;

/* renamed from: com.tencent.mm.plugin.u.a.a */
public final class C35333a {
    Set<Integer> cJV;
    private Object cli = new Object();
    private boolean hHg = false;
    boolean mCancelled = false;
    private QbarNative pAk = new QbarNative();
    C14011a pAl = null;
    long pAm = 0;

    /* renamed from: com.tencent.mm.plugin.u.a.a$a */
    public interface C14011a {
        /* renamed from: a */
        int mo26244a(C4264d c4264d);
    }

    /* renamed from: com.tencent.mm.plugin.u.a.a$b */
    class C29475b extends AsyncTask<String, Integer, C4264d> {
        C29475b() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(80741);
            C4264d E = m46788E((String[]) objArr);
            AppMethodBeat.m2505o(80741);
            return E;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(80740);
            C4264d c4264d = (C4264d) obj;
            if (C35333a.this.pAl != null) {
                C35333a.this.pAl.mo26244a(c4264d);
            }
            AppMethodBeat.m2505o(80740);
        }

        /* renamed from: E */
        private C4264d m46788E(String... strArr) {
            C4264d c4264d = null;
            AppMethodBeat.m2504i(80739);
            C4990ab.m7410d("dktest", "doInBackground :".concat(String.valueOf(strArr)));
            if (strArr == null || strArr.length != 1) {
                AppMethodBeat.m2505o(80739);
            } else {
                try {
                    C35333a.this.pAm = System.currentTimeMillis();
                    C1446a c1446a = new C1446a();
                    c4264d = C35333a.this.mo56079Vu(strArr[0]);
                    C4990ab.m7410d("MicroMsg.scanner.DecodeFile", "time: " + c1446a.mo4908Mr());
                } catch (OutOfMemoryError e) {
                    C4990ab.m7412e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.scanner.DecodeFile", e2, "decode failed due to Exception", "");
                }
                AppMethodBeat.m2505o(80739);
            }
            return c4264d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.u.a.a$1 */
    class C353321 implements Runnable {
        final /* synthetic */ String ewB;

        C353321(String str) {
            this.ewB = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(80738);
            new C29475b().execute(new String[]{this.ewB});
            AppMethodBeat.m2505o(80738);
        }
    }

    public C35333a() {
        AppMethodBeat.m2504i(80742);
        AppMethodBeat.m2505o(80742);
    }

    /* renamed from: Vu */
    public final C4264d mo56079Vu(String str) {
        C4264d c4264d = null;
        AppMethodBeat.m2504i(80743);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
            AppMethodBeat.m2505o(80743);
        } else {
            Options amj = C5056d.amj(str);
            if (amj != null) {
                amj.inJustDecodeBounds = false;
                amj.inPreferredConfig = Config.RGB_565;
                if (((long) ((amj.outWidth * amj.outHeight) * 8)) * 4 > 268435456) {
                    C4990ab.m7417i("MicroMsg.scanner.DecodeFile", "initial width %d, initial height %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                    amj.inSampleSize = 4;
                }
            }
            if (!this.mCancelled) {
                try {
                    Bitmap decodeFile = C5056d.decodeFile(str, amj);
                    if (decodeFile == null) {
                        C4990ab.m7412e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
                        AppMethodBeat.m2505o(80743);
                    } else {
                        boolean z;
                        c4264d = mo56078P(decodeFile);
                        String str2 = "MicroMsg.scanner.DecodeFile";
                        String str3 = "decode result==null:%b";
                        Object[] objArr = new Object[1];
                        if (c4264d == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        C4990ab.m7411d(str2, str3, objArr);
                        if (!(c4264d == null || C5046bo.isNullOrNil(c4264d.result))) {
                            AppMethodBeat.m2505o(80743);
                        }
                    }
                } catch (OutOfMemoryError e) {
                    C4990ab.m7413e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(80743);
        }
        return c4264d;
    }

    /* renamed from: P */
    public final C4264d mo56078P(Bitmap bitmap) {
        AppMethodBeat.m2504i(80744);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C4264d Q = m57998Q(bitmap);
        C21682m.pZK.cgJ();
        C4990ab.m7410d("MicroMsg.scanner.DecodeFile", "decode once time(ms):".concat(String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)));
        m58002sI();
        AppMethodBeat.m2505o(80744);
        return Q;
    }

    /* renamed from: Q */
    private C4264d m57998Q(Bitmap bitmap) {
        AppMethodBeat.m2504i(80745);
        C39638f c39638f = new C39638f(bitmap);
        if (c39638f.chS() == null || c39638f.width <= 0 || c39638f.height <= 0) {
            AppMethodBeat.m2505o(80745);
            return null;
        }
        C4264d a = m57999a(c39638f, this.cJV);
        AppMethodBeat.m2505o(80745);
        return a;
    }

    /* renamed from: h */
    private int m58000h(Set<Integer> set) {
        int i = 0;
        AppMethodBeat.m2504i(80746);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.m2505o(80746);
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
            C4990ab.m7417i("MicroMsg.scanner.DecodeFile", "QBarNative.SetReaders, readers:%s", Arrays.toString(iArr));
            synchronized (this.cli) {
                try {
                    i = this.pAk.mo49469i(iArr, iArr.length);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(80746);
                }
            }
        }
        return i;
    }

    /* renamed from: i */
    private boolean m58001i(Set<Integer> set) {
        AppMethodBeat.m2504i(80747);
        if (!(this.hHg || set == null || set.isEmpty())) {
            int a = this.pAk.mo49467a(1, "ANY", "UTF-8", C24245a.m37337iy(C4996ah.getContext()));
            C21682m.pZK.qaa = set.contains(Integer.valueOf(3));
            C4990ab.m7417i("MicroMsg.scanner.DecodeFile", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", Integer.valueOf(a), Integer.valueOf(m58000h(set)), QbarNative.getVersion());
            if (a == 0 && r2 == 0) {
                this.hHg = true;
            } else {
                C4990ab.m7412e("MicroMsg.scanner.DecodeFile", "QbarNative failed, releaseDecoder 1");
                AppMethodBeat.m2505o(80747);
                return false;
            }
        }
        boolean z = this.hHg;
        AppMethodBeat.m2505o(80747);
        return z;
    }

    /* renamed from: sI */
    private void m58002sI() {
        AppMethodBeat.m2504i(80748);
        C4990ab.m7411d("MicroMsg.scanner.DecodeFile", "releaseDecoder() start, hasInitQBar = %s", Boolean.valueOf(this.hHg));
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    int release = this.pAk.release();
                    this.pAk = null;
                    this.hHg = false;
                    C4990ab.m7411d("MicroMsg.scanner.DecodeFile", "QbarNative.Release() = [%s]", Integer.valueOf(release));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(80748);
            }
        }
        C13177c.chQ();
    }

    /* JADX WARNING: Missing block: B:83:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private C4264d m57999a(C6094a c6094a, Set<Integer> set) {
        AppMethodBeat.m2504i(80749);
        C4264d c4264d = new C4264d();
        synchronized (this.cli) {
            boolean z;
            if (set != null) {
                try {
                    if (!(set.isEmpty() || m58001i(set))) {
                        m58002sI();
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.scanner.DecodeFile", " Exception in directScanQRCodeImg() " + e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.scanner.DecodeFile", e, "", new Object[0]);
                    return c4264d;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(80749);
                    return c4264d;
                }
            }
            if (this.hHg) {
                z = this.hHg;
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(1));
                hashSet.add(Integer.valueOf(4));
                hashSet.add(Integer.valueOf(3));
                z = m58001i(hashSet);
            }
            if (z) {
                int i;
                C4990ab.m7411d("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg, lumSrc==null:%b", Boolean.FALSE);
                if (c6094a.chS() != null) {
                    C4990ab.m7417i("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg, lumSrc.getMatrix.length: %d, lumSrc.getWidth: %d, lumSrc.getHeight: %d", Integer.valueOf(c6094a.chS().length), Integer.valueOf(c6094a.width), Integer.valueOf(c6094a.height));
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (c6094a.chS() == null || c6094a.width * c6094a.height != c6094a.chS().length) {
                    i = -1;
                } else {
                    C21682m.pZK.mo37159fc(c6094a.width, c6094a.height);
                    i = this.pAk.mo49473z(c6094a.chS(), c6094a.width, c6094a.height);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                C4990ab.m7411d("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg decode ScanImage %s, cost: %s", Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                C21682m.pZK.mo37160jH(currentTimeMillis2 - currentTimeMillis);
                C21682m.pZK.cgI();
                if (i != 0) {
                    ArrayList arrayList = new ArrayList();
                    this.pAk.mo49472t(arrayList, new ArrayList());
                    C21682m.pZK.qab = arrayList;
                    AppMethodBeat.m2505o(80749);
                    return null;
                }
                C32800b nV = C37922v.m64076Zp().mo60674nV("basescanui@datacenter");
                if (nV != null) {
                    int i2 = nV.getInt("key_basescanui_screen_x", 0);
                    int i3 = nV.getInt("key_basescanui_screen_y", 0);
                    QbarNative qbarNative = this.pAk;
                    qbarNative.SetCenterCoordinate(i2, i3, C1338a.m2868gd(C4996ah.getContext()), C1338a.m2869ge(C4996ah.getContext()), qbarNative.Aqx);
                    C4990ab.m7417i("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg x=%d,y=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
                C21682m.pZK.cgH();
                C21682m.pZK.mo37161jI(currentTimeMillis2 - currentTimeMillis);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                this.pAk.mo49471s(linkedList, linkedList2);
                if (linkedList.size() == 0) {
                    AppMethodBeat.m2505o(80749);
                    return null;
                }
                C4990ab.m7417i("MicroMsg.scanner.DecodeFile", "GetResults size %d", Integer.valueOf(linkedList.size()));
                QBarResult qBarResult = (QBarResult) linkedList.get(0);
                QBarReportMsg qBarReportMsg = null;
                if (!C5046bo.m7548ek(linkedList2)) {
                    qBarReportMsg = (QBarReportMsg) linkedList2.get(0);
                }
                String str = "";
                if (qBarResult != null) {
                    if (!C5046bo.isNullOrNil(qBarResult.data)) {
                        String str2 = qBarResult.typeName;
                        if (str2.equals("QR_CODE") || str2.equals("WX_CODE")) {
                            str = qBarResult.data;
                        } else {
                            str = str2 + "," + qBarResult.data;
                        }
                    }
                    c4264d.result = str;
                    c4264d.rawData = qBarResult.rawData;
                    c4264d.cvn = C28923r.m45942Ws(qBarResult.typeName);
                    c4264d.cvo = qBarReportMsg != null ? qBarReportMsg.qrcodeVersion : 0;
                    C21682m.pZK.mo37154a(qBarResult.typeName, str, qBarResult.charset, qBarReportMsg, linkedList.size(), linkedList2);
                }
                AppMethodBeat.m2505o(80749);
                return c4264d;
            }
            m58002sI();
            AppMethodBeat.m2505o(80749);
            return null;
        }
    }
}
