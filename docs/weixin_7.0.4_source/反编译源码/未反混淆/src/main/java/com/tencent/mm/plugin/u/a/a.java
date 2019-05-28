package com.tencent.mm.plugin.u.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import com.tencent.qbar.QbarNative.QBarResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class a {
    Set<Integer> cJV;
    private Object cli = new Object();
    private boolean hHg = false;
    boolean mCancelled = false;
    private QbarNative pAk = new QbarNative();
    a pAl = null;
    long pAm = 0;

    public interface a {
        int a(d dVar);
    }

    class b extends AsyncTask<String, Integer, d> {
        b() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(80741);
            d E = E((String[]) objArr);
            AppMethodBeat.o(80741);
            return E;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(80740);
            d dVar = (d) obj;
            if (a.this.pAl != null) {
                a.this.pAl.a(dVar);
            }
            AppMethodBeat.o(80740);
        }

        private d E(String... strArr) {
            d dVar = null;
            AppMethodBeat.i(80739);
            ab.d("dktest", "doInBackground :".concat(String.valueOf(strArr)));
            if (strArr == null || strArr.length != 1) {
                AppMethodBeat.o(80739);
            } else {
                try {
                    a.this.pAm = System.currentTimeMillis();
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    dVar = a.this.Vu(strArr[0]);
                    ab.d("MicroMsg.scanner.DecodeFile", "time: " + aVar.Mr());
                } catch (OutOfMemoryError e) {
                    ab.e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.scanner.DecodeFile", e2, "decode failed due to Exception", "");
                }
                AppMethodBeat.o(80739);
            }
            return dVar;
        }
    }

    /* renamed from: com.tencent.mm.plugin.u.a.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ewB;

        AnonymousClass1(String str) {
            this.ewB = str;
        }

        public final void run() {
            AppMethodBeat.i(80738);
            new b().execute(new String[]{this.ewB});
            AppMethodBeat.o(80738);
        }
    }

    public a() {
        AppMethodBeat.i(80742);
        AppMethodBeat.o(80742);
    }

    public final d Vu(String str) {
        d dVar = null;
        AppMethodBeat.i(80743);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
            AppMethodBeat.o(80743);
        } else {
            Options amj = d.amj(str);
            if (amj != null) {
                amj.inJustDecodeBounds = false;
                amj.inPreferredConfig = Config.RGB_565;
                if (((long) ((amj.outWidth * amj.outHeight) * 8)) * 4 > 268435456) {
                    ab.i("MicroMsg.scanner.DecodeFile", "initial width %d, initial height %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                    amj.inSampleSize = 4;
                }
            }
            if (!this.mCancelled) {
                try {
                    Bitmap decodeFile = d.decodeFile(str, amj);
                    if (decodeFile == null) {
                        ab.e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
                        AppMethodBeat.o(80743);
                    } else {
                        boolean z;
                        dVar = P(decodeFile);
                        String str2 = "MicroMsg.scanner.DecodeFile";
                        String str3 = "decode result==null:%b";
                        Object[] objArr = new Object[1];
                        if (dVar == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        ab.d(str2, str3, objArr);
                        if (!(dVar == null || bo.isNullOrNil(dVar.result))) {
                            AppMethodBeat.o(80743);
                        }
                    }
                } catch (OutOfMemoryError e) {
                    ab.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", e.getMessage());
                }
            }
            AppMethodBeat.o(80743);
        }
        return dVar;
    }

    public final d P(Bitmap bitmap) {
        AppMethodBeat.i(80744);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d Q = Q(bitmap);
        m.pZK.cgJ();
        ab.d("MicroMsg.scanner.DecodeFile", "decode once time(ms):".concat(String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)));
        sI();
        AppMethodBeat.o(80744);
        return Q;
    }

    private d Q(Bitmap bitmap) {
        AppMethodBeat.i(80745);
        f fVar = new f(bitmap);
        if (fVar.chS() == null || fVar.width <= 0 || fVar.height <= 0) {
            AppMethodBeat.o(80745);
            return null;
        }
        d a = a(fVar, this.cJV);
        AppMethodBeat.o(80745);
        return a;
    }

    private int h(Set<Integer> set) {
        int i = 0;
        AppMethodBeat.i(80746);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.o(80746);
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
            ab.i("MicroMsg.scanner.DecodeFile", "QBarNative.SetReaders, readers:%s", Arrays.toString(iArr));
            synchronized (this.cli) {
                try {
                    i = this.pAk.i(iArr, iArr.length);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(80746);
                }
            }
        }
        return i;
    }

    private boolean i(Set<Integer> set) {
        AppMethodBeat.i(80747);
        if (!(this.hHg || set == null || set.isEmpty())) {
            int a = this.pAk.a(1, "ANY", "UTF-8", com.tencent.qbar.a.iy(ah.getContext()));
            m.pZK.qaa = set.contains(Integer.valueOf(3));
            ab.i("MicroMsg.scanner.DecodeFile", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", Integer.valueOf(a), Integer.valueOf(h(set)), QbarNative.getVersion());
            if (a == 0 && r2 == 0) {
                this.hHg = true;
            } else {
                ab.e("MicroMsg.scanner.DecodeFile", "QbarNative failed, releaseDecoder 1");
                AppMethodBeat.o(80747);
                return false;
            }
        }
        boolean z = this.hHg;
        AppMethodBeat.o(80747);
        return z;
    }

    private void sI() {
        AppMethodBeat.i(80748);
        ab.d("MicroMsg.scanner.DecodeFile", "releaseDecoder() start, hasInitQBar = %s", Boolean.valueOf(this.hHg));
        synchronized (this.cli) {
            try {
                if (this.hHg) {
                    int release = this.pAk.release();
                    this.pAk = null;
                    this.hHg = false;
                    ab.d("MicroMsg.scanner.DecodeFile", "QbarNative.Release() = [%s]", Integer.valueOf(release));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(80748);
            }
        }
        c.chQ();
    }

    /* JADX WARNING: Missing block: B:83:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private d a(f.a aVar, Set<Integer> set) {
        AppMethodBeat.i(80749);
        d dVar = new d();
        synchronized (this.cli) {
            boolean z;
            if (set != null) {
                try {
                    if (!(set.isEmpty() || i(set))) {
                        sI();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.scanner.DecodeFile", " Exception in directScanQRCodeImg() " + e.getMessage());
                    ab.printErrStackTrace("MicroMsg.scanner.DecodeFile", e, "", new Object[0]);
                    return dVar;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(80749);
                    return dVar;
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
                z = i(hashSet);
            }
            if (z) {
                int i;
                ab.d("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg, lumSrc==null:%b", Boolean.FALSE);
                if (aVar.chS() != null) {
                    ab.i("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg, lumSrc.getMatrix.length: %d, lumSrc.getWidth: %d, lumSrc.getHeight: %d", Integer.valueOf(aVar.chS().length), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height));
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (aVar.chS() == null || aVar.width * aVar.height != aVar.chS().length) {
                    i = -1;
                } else {
                    m.pZK.fc(aVar.width, aVar.height);
                    i = this.pAk.z(aVar.chS(), aVar.width, aVar.height);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ab.d("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg decode ScanImage %s, cost: %s", Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                m.pZK.jH(currentTimeMillis2 - currentTimeMillis);
                m.pZK.cgI();
                if (i != 0) {
                    ArrayList arrayList = new ArrayList();
                    this.pAk.t(arrayList, new ArrayList());
                    m.pZK.qab = arrayList;
                    AppMethodBeat.o(80749);
                    return null;
                }
                com.tencent.mm.model.v.b nV = v.Zp().nV("basescanui@datacenter");
                if (nV != null) {
                    int i2 = nV.getInt("key_basescanui_screen_x", 0);
                    int i3 = nV.getInt("key_basescanui_screen_y", 0);
                    QbarNative qbarNative = this.pAk;
                    qbarNative.SetCenterCoordinate(i2, i3, com.tencent.mm.bz.a.gd(ah.getContext()), com.tencent.mm.bz.a.ge(ah.getContext()), qbarNative.Aqx);
                    ab.i("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg x=%d,y=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
                m.pZK.cgH();
                m.pZK.jI(currentTimeMillis2 - currentTimeMillis);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                this.pAk.s(linkedList, linkedList2);
                if (linkedList.size() == 0) {
                    AppMethodBeat.o(80749);
                    return null;
                }
                ab.i("MicroMsg.scanner.DecodeFile", "GetResults size %d", Integer.valueOf(linkedList.size()));
                QBarResult qBarResult = (QBarResult) linkedList.get(0);
                QBarReportMsg qBarReportMsg = null;
                if (!bo.ek(linkedList2)) {
                    qBarReportMsg = (QBarReportMsg) linkedList2.get(0);
                }
                String str = "";
                if (qBarResult != null) {
                    if (!bo.isNullOrNil(qBarResult.data)) {
                        String str2 = qBarResult.typeName;
                        if (str2.equals("QR_CODE") || str2.equals("WX_CODE")) {
                            str = qBarResult.data;
                        } else {
                            str = str2 + "," + qBarResult.data;
                        }
                    }
                    dVar.result = str;
                    dVar.rawData = qBarResult.rawData;
                    dVar.cvn = r.Ws(qBarResult.typeName);
                    dVar.cvo = qBarReportMsg != null ? qBarReportMsg.qrcodeVersion : 0;
                    m.pZK.a(qBarResult.typeName, str, qBarResult.charset, qBarReportMsg, linkedList.size(), linkedList2);
                }
                AppMethodBeat.o(80749);
                return dVar;
            }
            sI();
            AppMethodBeat.o(80749);
            return null;
        }
    }
}
