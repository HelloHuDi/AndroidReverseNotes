package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.q;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class x {
    private static Vector<WeakReference<a>> ghp = new Vector();
    private static LinkedList<a> ghq = new LinkedList();

    enum b {
        ;
        
        private static DisplayMetrics ghw;
        private Map<String, c> ghs;
        private Map<String, WeakReference<Bitmap>> ght;
        private az ghu;
        private az ghv;

        static class a implements com.tencent.mm.sdk.platformtools.az.a {
            private Bitmap fru;
            private int ghy;
            private v ghz;

            public a(v vVar) {
                AppMethodBeat.i(79009);
                this.ghy = 0;
                this.fru = null;
                if (x.c(vVar)) {
                    this.ghz = vVar;
                    AppMethodBeat.o(79009);
                    return;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("from net, picture strategy here must be validity");
                AppMethodBeat.o(79009);
                throw illegalArgumentException;
            }

            /* JADX WARNING: Removed duplicated region for block: B:42:0x0141 A:{SYNTHETIC, Splitter:B:42:0x0141} */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x0146 A:{SYNTHETIC, Splitter:B:45:0x0146} */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x027d A:{SYNTHETIC, Splitter:B:78:0x027d} */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x0282 A:{SYNTHETIC, Splitter:B:81:0x0282} */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x0141 A:{SYNTHETIC, Splitter:B:42:0x0141} */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x0146 A:{SYNTHETIC, Splitter:B:45:0x0146} */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x027d A:{SYNTHETIC, Splitter:B:78:0x027d} */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x0282 A:{SYNTHETIC, Splitter:B:81:0x0282} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean acf() {
                Throwable e;
                AppMethodBeat.i(79010);
                if (this.ghz == null) {
                    ab.e("MicroMsg.MMPictureLogic", "picStrategy == null");
                    AppMethodBeat.o(79010);
                } else {
                    FileOutputStream fileOutputStream;
                    String contentType;
                    InputStream inputStream;
                    try {
                        this.ghz.anP();
                        File file = new File(this.ghz.anJ());
                        fileOutputStream = new FileOutputStream(file.getAbsolutePath() + "_tmp");
                        try {
                            u a = com.tencent.mm.network.b.a(this.ghz.anK(), null);
                            if (q.ahs() && q.sz(this.ghz.anK())) {
                                ab.d("MicroMsg.MMPictureLogic", "webp referer:%s", q.lH(d.vxo));
                                a.vc(contentType);
                            }
                            a.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                            a.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
                            a.setRequestMethod("GET");
                            if (com.tencent.mm.network.b.a(a) == 0) {
                                inputStream = a.getInputStream();
                            } else {
                                inputStream = null;
                            }
                            try {
                                contentType = a.connection.getContentType();
                                try {
                                    ab.d("MicroMsg.MMPictureLogic", "contentType:%s", contentType);
                                    if (inputStream == null) {
                                        ab.w("MicroMsg.MMPictureLogic", "download %s error, can not open http stream", this.ghz.anK());
                                        this.ghz.V(contentType, false);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e2) {
                                                ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e2));
                                            }
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e22) {
                                            ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e22));
                                        }
                                        AppMethodBeat.o(79010);
                                    } else {
                                        Bitmap a2;
                                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            this.ghy += read;
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        ab.i("MicroMsg.MMPictureLogic", "get url[%s] ok, bufSize[%d]", this.ghz.anK(), Integer.valueOf(this.ghy));
                                        this.ghz.V(contentType, true);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e222) {
                                                ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e222));
                                            }
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e2222) {
                                            ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e2222));
                                        }
                                        try {
                                            Bitmap vt;
                                            g.cz(file.getAbsolutePath() + "_tmp");
                                            com.tencent.mm.platformtools.v.b anI = this.ghz.anI();
                                            if (anI != null) {
                                                vt = anI.vt(file.getAbsolutePath() + "_tmp");
                                            } else {
                                                vt = b.vv(file.getAbsolutePath() + "_tmp");
                                            }
                                            if (vt != null) {
                                                a2 = this.ghz.a(vt, com.tencent.mm.platformtools.v.a.NET, file.getAbsolutePath() + "_tmp");
                                            } else {
                                                this.ghz.a(com.tencent.mm.platformtools.v.a.NET, contentType);
                                                a2 = null;
                                            }
                                            if (!(a2 == vt || vt.isRecycled())) {
                                                ab.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", vt.toString());
                                                vt.recycle();
                                            }
                                            b.a(b.ghr, this.ghz, a2);
                                            new File(file.getAbsolutePath() + "_tmp").delete();
                                        } catch (Exception e3) {
                                            ab.w("MicroMsg.MMPictureLogic", "update pic for %s, error", this.ghz.anK());
                                            ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e3));
                                            a2 = null;
                                        }
                                        this.fru = a2;
                                        AppMethodBeat.o(79010);
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    try {
                                        ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e));
                                        ab.w("MicroMsg.MMPictureLogic", "get url:%s failed.", this.ghz.anK());
                                        this.ghz.V(contentType, false);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e22222) {
                                                ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e22222));
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e222222) {
                                                ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e222222));
                                            }
                                        }
                                        AppMethodBeat.o(79010);
                                        return true;
                                    } catch (Throwable th) {
                                        e = th;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e5) {
                                                ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e5));
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e52) {
                                                ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e52));
                                            }
                                        }
                                        AppMethodBeat.o(79010);
                                        throw e;
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                contentType = null;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            contentType = null;
                            inputStream = null;
                            ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e));
                            ab.w("MicroMsg.MMPictureLogic", "get url:%s failed.", this.ghz.anK());
                            this.ghz.V(contentType, false);
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(79010);
                            return true;
                        } catch (Throwable th2) {
                            e = th2;
                            inputStream = null;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(79010);
                            throw e;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        contentType = null;
                        inputStream = null;
                        fileOutputStream = null;
                        ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e));
                        ab.w("MicroMsg.MMPictureLogic", "get url:%s failed.", this.ghz.anK());
                        this.ghz.V(contentType, false);
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(79010);
                        return true;
                    } catch (Throwable th3) {
                        e = th3;
                        inputStream = null;
                        fileOutputStream = null;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(79010);
                        throw e;
                    }
                }
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.i(79011);
                try {
                    com.tencent.mm.model.ao.a.flv.cm(this.ghy, 0);
                } catch (Exception e) {
                    ab.e("MicroMsg.MMPictureLogic", "exception:%s", bo.l(e));
                }
                b.a(b.ghr, this.ghz.anK(), this.ghz.anL(), this.fru);
                this.fru = null;
                AppMethodBeat.o(79011);
                return false;
            }
        }

        static class b implements com.tencent.mm.sdk.platformtools.az.a {
            public Bitmap fru;
            private v ghz;

            public b(v vVar) {
                AppMethodBeat.i(79012);
                this.fru = null;
                if (x.c(vVar)) {
                    this.ghz = vVar;
                    AppMethodBeat.o(79012);
                    return;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("from sdcard, picture strategy here must be validity");
                AppMethodBeat.o(79012);
                throw illegalArgumentException;
            }

            public final boolean acf() {
                boolean z = false;
                AppMethodBeat.i(79013);
                this.fru = b.vv(this.ghz.anJ());
                if (this.fru != null) {
                    this.fru = b.ghr.a(this.ghz, this.fru);
                }
                String str = "MicroMsg.MMPictureLogic";
                String str2 = "get url[%s] from[%s] result[%B]";
                Object[] objArr = new Object[3];
                objArr[0] = this.ghz.anK();
                objArr[1] = this.ghz.anJ();
                if (this.fru != null) {
                    z = true;
                }
                objArr[2] = Boolean.valueOf(z);
                ab.v(str, str2, objArr);
                AppMethodBeat.o(79013);
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.i(79014);
                if (this.fru == null) {
                    ab.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", this.ghz.anK());
                    if (b.ghr.ghu == null || b.ghr.ghu.dpg()) {
                        b.ghr.ghu = new az(1, "readerapp-pic-logic-download", 3);
                    }
                    b.ghr.ghu.e(new a(this.ghz));
                } else {
                    b.a(b.ghr, this.ghz.anK(), this.ghz.anL(), this.fru);
                    this.fru = null;
                }
                AppMethodBeat.o(79014);
                return false;
            }
        }

        static class c {
            boolean ghA;
            int ghB;
            int ghC;

            c() {
            }

            public final String toString() {
                AppMethodBeat.i(79015);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fail[").append(this.ghA).append("],");
                stringBuilder.append("tryTimes[").append(this.ghB).append("],");
                stringBuilder.append("lastTS[").append(this.ghC).append("]");
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(79015);
                return stringBuilder2;
            }
        }

        private b(String str) {
            AppMethodBeat.i(79018);
            this.ghs = new HashMap();
            this.ght = new HashMap();
            this.ghu = null;
            this.ghv = null;
            AppMethodBeat.o(79018);
        }

        static {
            ghw = null;
            AppMethodBeat.o(79030);
        }

        private Bitmap d(v vVar) {
            AppMethodBeat.i(79019);
            Assert.assertTrue("picture strategy here must be validity", x.c(vVar));
            String anK = vVar.anK();
            c cVar = (c) this.ghs.get(anK);
            if (cVar == null) {
                cVar = new c();
            }
            if (cVar.ghA) {
                if (cVar.ghB < 3) {
                    cVar.ghB++;
                } else if (bo.fp((long) cVar.ghC) < 120) {
                    ab.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", Integer.valueOf(120), anK);
                    AppMethodBeat.o(79019);
                    return null;
                } else {
                    cVar.ghB = 0;
                }
                cVar.ghA = false;
                cVar.ghC = (int) bo.anT();
                this.ghs.put(anK, cVar);
            } else if (bo.fp((long) cVar.ghC) < 120) {
                ab.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", Integer.valueOf(120), anK);
                AppMethodBeat.o(79019);
                return null;
            } else {
                cVar.ghB++;
                cVar.ghC = (int) bo.anT();
                this.ghs.put(anK, cVar);
            }
            if (vVar.anM()) {
                Bitmap vt;
                com.tencent.mm.platformtools.v.b anI = vVar.anI();
                if (anI != null) {
                    vt = anI.vt(vVar.anJ());
                } else {
                    vt = vv(vVar.anJ());
                }
                if (vt != null) {
                    vt = a(vVar, vt);
                    this.ghs.remove(anK);
                    AppMethodBeat.o(79019);
                    return vt;
                }
                if (this.ghu == null || this.ghu.dpg()) {
                    this.ghu = new az(1, "readerapp-pic-logic-download", 3);
                }
                this.ghu.e(new a(vVar));
                AppMethodBeat.o(79019);
                return null;
            }
            if (this.ghv == null || this.ghv.dpg()) {
                this.ghv = new az(1, "readerapp-pic-logic-reader", 1);
            }
            this.ghv.e(new b(vVar));
            AppMethodBeat.o(79019);
            return null;
        }

        /* Access modifiers changed, original: protected|final */
        public final Bitmap a(v vVar, Bitmap bitmap) {
            AppMethodBeat.i(79020);
            Assert.assertTrue("picture strategy here must be validity", x.c(vVar));
            if (bitmap != null) {
                Bitmap a = vVar.a(bitmap, com.tencent.mm.platformtools.v.a.DISK, vVar.anJ());
                if (!(a == bitmap || bitmap.isRecycled())) {
                    ab.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                b(vVar, a);
                bitmap = a;
            } else {
                vVar.a(com.tencent.mm.platformtools.v.a.DISK, null);
            }
            AppMethodBeat.o(79020);
            return bitmap;
        }

        private void b(v vVar, Bitmap bitmap) {
            AppMethodBeat.i(79021);
            Assert.assertTrue("picture strategy here must be validity", x.c(vVar));
            String cacheKey = vVar.getCacheKey();
            Bitmap bitmap2 = this.ght.containsKey(cacheKey) ? (Bitmap) ((WeakReference) this.ght.get(cacheKey)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.ght.remove(cacheKey);
                this.ght.put(cacheKey, new WeakReference(bitmap));
            }
            AppMethodBeat.o(79021);
        }

        private static DisplayMetrics anS() {
            AppMethodBeat.i(79022);
            if (ghw == null) {
                ghw = ah.getContext().getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = ghw;
            AppMethodBeat.o(79022);
            return displayMetrics;
        }

        public static Bitmap q(String str, int i, int i2) {
            AppMethodBeat.i(79023);
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.MMPictureLogic", "error input, path is null");
                AppMethodBeat.o(79023);
                return null;
            } else if (i <= 0 || i2 <= 0) {
                ab.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(79023);
                return null;
            } else {
                Bitmap ap = com.tencent.mm.sdk.platformtools.d.ap(str, i, i2);
                AppMethodBeat.o(79023);
                return ap;
            }
        }

        public static Bitmap vv(String str) {
            AppMethodBeat.i(79024);
            DisplayMetrics anS = anS();
            Bitmap q = q(str, anS.widthPixels, anS.heightPixels);
            AppMethodBeat.o(79024);
            return q;
        }

        public static Bitmap vw(String str) {
            AppMethodBeat.i(79025);
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.MMPictureLogic", "error input, path is null");
                AppMethodBeat.o(79025);
                return null;
            }
            Bitmap ap = com.tencent.mm.sdk.platformtools.d.ap(str, 0, 0);
            AppMethodBeat.o(79025);
            return ap;
        }
    }

    public interface a {
        void m(String str, Bitmap bitmap);
    }

    static {
        AppMethodBeat.i(79041);
        AppMethodBeat.o(79041);
    }

    public static boolean a(a aVar) {
        AppMethodBeat.i(79031);
        boolean add = ghp.add(new WeakReference(aVar));
        AppMethodBeat.o(79031);
        return add;
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(79032);
        ghq.remove(aVar);
        boolean add = ghq.add(aVar);
        AppMethodBeat.o(79032);
        return add;
    }

    public static boolean c(a aVar) {
        AppMethodBeat.i(79033);
        boolean remove = ghq.remove(aVar);
        AppMethodBeat.o(79033);
        return remove;
    }

    public static Bitmap a(v vVar) {
        AppMethodBeat.i(79034);
        Bitmap anO;
        if (!b(vVar)) {
            AppMethodBeat.o(79034);
            return null;
        } else if (!com.tencent.mm.kernel.g.RP().RB()) {
            anO = vVar.anO();
            AppMethodBeat.o(79034);
            return anO;
        } else if (vVar.anN()) {
            anO = b.a(b.ghr, vVar);
            AppMethodBeat.o(79034);
            return anO;
        } else {
            anO = b.b(b.ghr, vVar);
            AppMethodBeat.o(79034);
            return anO;
        }
    }

    public static Bitmap vv(String str) {
        AppMethodBeat.i(79035);
        Bitmap vv = b.vv(str);
        AppMethodBeat.o(79035);
        return vv;
    }

    public static Bitmap q(String str, int i, int i2) {
        AppMethodBeat.i(79036);
        Bitmap q = b.q(str, i, i2);
        AppMethodBeat.o(79036);
        return q;
    }

    public static Bitmap vw(String str) {
        AppMethodBeat.i(79037);
        Bitmap vw = b.vw(str);
        AppMethodBeat.o(79037);
        return vw;
    }

    private static boolean b(v vVar) {
        AppMethodBeat.i(79038);
        if (vVar == null || bo.isNullOrNil(vVar.anK())) {
            AppMethodBeat.o(79038);
            return false;
        }
        AppMethodBeat.o(79038);
        return true;
    }

    static /* synthetic */ void l(String str, Bitmap bitmap) {
        AppMethodBeat.i(79040);
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ghp.size()) {
                WeakReference weakReference = (WeakReference) ghp.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.m(str, bitmap);
                    } else {
                        vector.add(weakReference);
                    }
                }
                i = i2 + 1;
            } else {
                ghp.removeAll(vector);
                AppMethodBeat.o(79040);
                return;
            }
        }
    }
}
