package com.tencent.p177mm.platformtools;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
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

/* renamed from: com.tencent.mm.platformtools.x */
public final class C18764x {
    private static Vector<WeakReference<C18765a>> ghp = new Vector();
    private static LinkedList<C18765a> ghq = new LinkedList();

    /* renamed from: com.tencent.mm.platformtools.x$b */
    enum C18762b {
        ;
        
        private static DisplayMetrics ghw;
        private Map<String, C18763c> ghs;
        private Map<String, WeakReference<Bitmap>> ght;
        private C23498az ghu;
        private C23498az ghv;

        /* renamed from: com.tencent.mm.platformtools.x$b$a */
        static class C18760a implements C23499a {
            private Bitmap fru;
            private int ghy;
            private C9791v ghz;

            public C18760a(C9791v c9791v) {
                AppMethodBeat.m2504i(79009);
                this.ghy = 0;
                this.fru = null;
                if (C18764x.m29329c(c9791v)) {
                    this.ghz = c9791v;
                    AppMethodBeat.m2505o(79009);
                    return;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("from net, picture strategy here must be validity");
                AppMethodBeat.m2505o(79009);
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
                AppMethodBeat.m2504i(79010);
                if (this.ghz == null) {
                    C4990ab.m7412e("MicroMsg.MMPictureLogic", "picStrategy == null");
                    AppMethodBeat.m2505o(79010);
                } else {
                    FileOutputStream fileOutputStream;
                    String contentType;
                    InputStream inputStream;
                    try {
                        this.ghz.anP();
                        File file = new File(this.ghz.anJ());
                        fileOutputStream = new FileOutputStream(file.getAbsolutePath() + "_tmp");
                        try {
                            C1936u a = C1897b.m4020a(this.ghz.anK(), null);
                            if (C41764q.ahs() && C41764q.m73704sz(this.ghz.anK())) {
                                C4990ab.m7411d("MicroMsg.MMPictureLogic", "webp referer:%s", C41764q.m73700lH(C7243d.vxo));
                                a.mo5661vc(contentType);
                            }
                            a.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                            a.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                            a.setRequestMethod("GET");
                            if (C1897b.m4017a(a) == 0) {
                                inputStream = a.getInputStream();
                            } else {
                                inputStream = null;
                            }
                            try {
                                contentType = a.connection.getContentType();
                                try {
                                    C4990ab.m7411d("MicroMsg.MMPictureLogic", "contentType:%s", contentType);
                                    if (inputStream == null) {
                                        C4990ab.m7421w("MicroMsg.MMPictureLogic", "download %s error, can not open http stream", this.ghz.anK());
                                        this.ghz.mo9516V(contentType, false);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e2) {
                                                C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e2));
                                            }
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e22) {
                                            C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e22));
                                        }
                                        AppMethodBeat.m2505o(79010);
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
                                        C4990ab.m7417i("MicroMsg.MMPictureLogic", "get url[%s] ok, bufSize[%d]", this.ghz.anK(), Integer.valueOf(this.ghy));
                                        this.ghz.mo9516V(contentType, true);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e222) {
                                                C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e222));
                                            }
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e2222) {
                                            C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e2222));
                                        }
                                        try {
                                            Bitmap vt;
                                            C1178g.m2587cz(file.getAbsolutePath() + "_tmp");
                                            C9792b anI = this.ghz.anI();
                                            if (anI != null) {
                                                vt = anI.mo9528vt(file.getAbsolutePath() + "_tmp");
                                            } else {
                                                vt = C18762b.m29322vv(file.getAbsolutePath() + "_tmp");
                                            }
                                            if (vt != null) {
                                                a2 = this.ghz.mo9517a(vt, C9793a.NET, file.getAbsolutePath() + "_tmp");
                                            } else {
                                                this.ghz.mo9518a(C9793a.NET, contentType);
                                                a2 = null;
                                            }
                                            if (!(a2 == vt || vt.isRecycled())) {
                                                C4990ab.m7417i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", vt.toString());
                                                vt.recycle();
                                            }
                                            C18762b.m29316a(C18762b.ghr, this.ghz, a2);
                                            new File(file.getAbsolutePath() + "_tmp").delete();
                                        } catch (Exception e3) {
                                            C4990ab.m7421w("MicroMsg.MMPictureLogic", "update pic for %s, error", this.ghz.anK());
                                            C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e3));
                                            a2 = null;
                                        }
                                        this.fru = a2;
                                        AppMethodBeat.m2505o(79010);
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    try {
                                        C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e));
                                        C4990ab.m7421w("MicroMsg.MMPictureLogic", "get url:%s failed.", this.ghz.anK());
                                        this.ghz.mo9516V(contentType, false);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e22222) {
                                                C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e22222));
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e222222) {
                                                C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e222222));
                                            }
                                        }
                                        AppMethodBeat.m2505o(79010);
                                        return true;
                                    } catch (Throwable th) {
                                        e = th;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e5) {
                                                C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e5));
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e52) {
                                                C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e52));
                                            }
                                        }
                                        AppMethodBeat.m2505o(79010);
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
                            C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e));
                            C4990ab.m7421w("MicroMsg.MMPictureLogic", "get url:%s failed.", this.ghz.anK());
                            this.ghz.mo9516V(contentType, false);
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(79010);
                            return true;
                        } catch (Throwable th2) {
                            e = th2;
                            inputStream = null;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(79010);
                            throw e;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        contentType = null;
                        inputStream = null;
                        fileOutputStream = null;
                        C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e));
                        C4990ab.m7421w("MicroMsg.MMPictureLogic", "get url:%s failed.", this.ghz.anK());
                        this.ghz.mo9516V(contentType, false);
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(79010);
                        return true;
                    } catch (Throwable th3) {
                        e = th3;
                        inputStream = null;
                        fileOutputStream = null;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(79010);
                        throw e;
                    }
                }
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.m2504i(79011);
                try {
                    C26417a.flv.mo44184cm(this.ghy, 0);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMPictureLogic", "exception:%s", C5046bo.m7574l(e));
                }
                C18762b.m29317a(C18762b.ghr, this.ghz.anK(), this.ghz.anL(), this.fru);
                this.fru = null;
                AppMethodBeat.m2505o(79011);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.platformtools.x$b$b */
        static class C18761b implements C23499a {
            public Bitmap fru;
            private C9791v ghz;

            public C18761b(C9791v c9791v) {
                AppMethodBeat.m2504i(79012);
                this.fru = null;
                if (C18764x.m29329c(c9791v)) {
                    this.ghz = c9791v;
                    AppMethodBeat.m2505o(79012);
                    return;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("from sdcard, picture strategy here must be validity");
                AppMethodBeat.m2505o(79012);
                throw illegalArgumentException;
            }

            public final boolean acf() {
                boolean z = false;
                AppMethodBeat.m2504i(79013);
                this.fru = C18762b.m29322vv(this.ghz.anJ());
                if (this.fru != null) {
                    this.fru = C18762b.ghr.mo34037a(this.ghz, this.fru);
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
                C4990ab.m7419v(str, str2, objArr);
                AppMethodBeat.m2505o(79013);
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.m2504i(79014);
                if (this.fru == null) {
                    C4990ab.m7411d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", this.ghz.anK());
                    if (C18762b.ghr.ghu == null || C18762b.ghr.ghu.dpg()) {
                        C18762b.ghr.ghu = new C23498az(1, "readerapp-pic-logic-download", 3);
                    }
                    C18762b.ghr.ghu.mo39163e(new C18760a(this.ghz));
                } else {
                    C18762b.m29317a(C18762b.ghr, this.ghz.anK(), this.ghz.anL(), this.fru);
                    this.fru = null;
                }
                AppMethodBeat.m2505o(79014);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.platformtools.x$b$c */
        static class C18763c {
            boolean ghA;
            int ghB;
            int ghC;

            C18763c() {
            }

            public final String toString() {
                AppMethodBeat.m2504i(79015);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fail[").append(this.ghA).append("],");
                stringBuilder.append("tryTimes[").append(this.ghB).append("],");
                stringBuilder.append("lastTS[").append(this.ghC).append("]");
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.m2505o(79015);
                return stringBuilder2;
            }
        }

        private C18762b(String str) {
            AppMethodBeat.m2504i(79018);
            this.ghs = new HashMap();
            this.ght = new HashMap();
            this.ghu = null;
            this.ghv = null;
            AppMethodBeat.m2505o(79018);
        }

        static {
            ghw = null;
            AppMethodBeat.m2505o(79030);
        }

        /* renamed from: d */
        private Bitmap m29320d(C9791v c9791v) {
            AppMethodBeat.m2504i(79019);
            Assert.assertTrue("picture strategy here must be validity", C18764x.m29329c(c9791v));
            String anK = c9791v.anK();
            C18763c c18763c = (C18763c) this.ghs.get(anK);
            if (c18763c == null) {
                c18763c = new C18763c();
            }
            if (c18763c.ghA) {
                if (c18763c.ghB < 3) {
                    c18763c.ghB++;
                } else if (C5046bo.m7549fp((long) c18763c.ghC) < 120) {
                    C4990ab.m7421w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", Integer.valueOf(120), anK);
                    AppMethodBeat.m2505o(79019);
                    return null;
                } else {
                    c18763c.ghB = 0;
                }
                c18763c.ghA = false;
                c18763c.ghC = (int) C5046bo.anT();
                this.ghs.put(anK, c18763c);
            } else if (C5046bo.m7549fp((long) c18763c.ghC) < 120) {
                C4990ab.m7411d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", Integer.valueOf(120), anK);
                AppMethodBeat.m2505o(79019);
                return null;
            } else {
                c18763c.ghB++;
                c18763c.ghC = (int) C5046bo.anT();
                this.ghs.put(anK, c18763c);
            }
            if (c9791v.anM()) {
                Bitmap vt;
                C9792b anI = c9791v.anI();
                if (anI != null) {
                    vt = anI.mo9528vt(c9791v.anJ());
                } else {
                    vt = C18762b.m29322vv(c9791v.anJ());
                }
                if (vt != null) {
                    vt = mo34037a(c9791v, vt);
                    this.ghs.remove(anK);
                    AppMethodBeat.m2505o(79019);
                    return vt;
                }
                if (this.ghu == null || this.ghu.dpg()) {
                    this.ghu = new C23498az(1, "readerapp-pic-logic-download", 3);
                }
                this.ghu.mo39163e(new C18760a(c9791v));
                AppMethodBeat.m2505o(79019);
                return null;
            }
            if (this.ghv == null || this.ghv.dpg()) {
                this.ghv = new C23498az(1, "readerapp-pic-logic-reader", 1);
            }
            this.ghv.mo39163e(new C18761b(c9791v));
            AppMethodBeat.m2505o(79019);
            return null;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final Bitmap mo34037a(C9791v c9791v, Bitmap bitmap) {
            AppMethodBeat.m2504i(79020);
            Assert.assertTrue("picture strategy here must be validity", C18764x.m29329c(c9791v));
            if (bitmap != null) {
                Bitmap a = c9791v.mo9517a(bitmap, C9793a.DISK, c9791v.anJ());
                if (!(a == bitmap || bitmap.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                m29319b(c9791v, a);
                bitmap = a;
            } else {
                c9791v.mo9518a(C9793a.DISK, null);
            }
            AppMethodBeat.m2505o(79020);
            return bitmap;
        }

        /* renamed from: b */
        private void m29319b(C9791v c9791v, Bitmap bitmap) {
            AppMethodBeat.m2504i(79021);
            Assert.assertTrue("picture strategy here must be validity", C18764x.m29329c(c9791v));
            String cacheKey = c9791v.getCacheKey();
            Bitmap bitmap2 = this.ght.containsKey(cacheKey) ? (Bitmap) ((WeakReference) this.ght.get(cacheKey)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.ght.remove(cacheKey);
                this.ght.put(cacheKey, new WeakReference(bitmap));
            }
            AppMethodBeat.m2505o(79021);
        }

        private static DisplayMetrics anS() {
            AppMethodBeat.m2504i(79022);
            if (ghw == null) {
                ghw = C4996ah.getContext().getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = ghw;
            AppMethodBeat.m2505o(79022);
            return displayMetrics;
        }

        /* renamed from: q */
        public static Bitmap m29321q(String str, int i, int i2) {
            AppMethodBeat.m2504i(79023);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.MMPictureLogic", "error input, path is null");
                AppMethodBeat.m2505o(79023);
                return null;
            } else if (i <= 0 || i2 <= 0) {
                C4990ab.m7421w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(79023);
                return null;
            } else {
                Bitmap ap = C5056d.m7642ap(str, i, i2);
                AppMethodBeat.m2505o(79023);
                return ap;
            }
        }

        /* renamed from: vv */
        public static Bitmap m29322vv(String str) {
            AppMethodBeat.m2504i(79024);
            DisplayMetrics anS = C18762b.anS();
            Bitmap q = C18762b.m29321q(str, anS.widthPixels, anS.heightPixels);
            AppMethodBeat.m2505o(79024);
            return q;
        }

        /* renamed from: vw */
        public static Bitmap m29323vw(String str) {
            AppMethodBeat.m2504i(79025);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.MMPictureLogic", "error input, path is null");
                AppMethodBeat.m2505o(79025);
                return null;
            }
            Bitmap ap = C5056d.m7642ap(str, 0, 0);
            AppMethodBeat.m2505o(79025);
            return ap;
        }
    }

    /* renamed from: com.tencent.mm.platformtools.x$a */
    public interface C18765a {
        /* renamed from: m */
        void mo8136m(String str, Bitmap bitmap);
    }

    static {
        AppMethodBeat.m2504i(79041);
        AppMethodBeat.m2505o(79041);
    }

    /* renamed from: a */
    public static boolean m29326a(C18765a c18765a) {
        AppMethodBeat.m2504i(79031);
        boolean add = ghp.add(new WeakReference(c18765a));
        AppMethodBeat.m2505o(79031);
        return add;
    }

    /* renamed from: b */
    public static boolean m29328b(C18765a c18765a) {
        AppMethodBeat.m2504i(79032);
        ghq.remove(c18765a);
        boolean add = ghq.add(c18765a);
        AppMethodBeat.m2505o(79032);
        return add;
    }

    /* renamed from: c */
    public static boolean m29330c(C18765a c18765a) {
        AppMethodBeat.m2504i(79033);
        boolean remove = ghq.remove(c18765a);
        AppMethodBeat.m2505o(79033);
        return remove;
    }

    /* renamed from: a */
    public static Bitmap m29325a(C9791v c9791v) {
        AppMethodBeat.m2504i(79034);
        Bitmap anO;
        if (!C18764x.m29327b(c9791v)) {
            AppMethodBeat.m2505o(79034);
            return null;
        } else if (!C1720g.m3536RP().mo5229RB()) {
            anO = c9791v.anO();
            AppMethodBeat.m2505o(79034);
            return anO;
        } else if (c9791v.anN()) {
            anO = C18762b.m29313a(C18762b.ghr, c9791v);
            AppMethodBeat.m2505o(79034);
            return anO;
        } else {
            anO = C18762b.m29318b(C18762b.ghr, c9791v);
            AppMethodBeat.m2505o(79034);
            return anO;
        }
    }

    /* renamed from: vv */
    public static Bitmap m29333vv(String str) {
        AppMethodBeat.m2504i(79035);
        Bitmap vv = C18762b.m29322vv(str);
        AppMethodBeat.m2505o(79035);
        return vv;
    }

    /* renamed from: q */
    public static Bitmap m29332q(String str, int i, int i2) {
        AppMethodBeat.m2504i(79036);
        Bitmap q = C18762b.m29321q(str, i, i2);
        AppMethodBeat.m2505o(79036);
        return q;
    }

    /* renamed from: vw */
    public static Bitmap m29334vw(String str) {
        AppMethodBeat.m2504i(79037);
        Bitmap vw = C18762b.m29323vw(str);
        AppMethodBeat.m2505o(79037);
        return vw;
    }

    /* renamed from: b */
    private static boolean m29327b(C9791v c9791v) {
        AppMethodBeat.m2504i(79038);
        if (c9791v == null || C5046bo.isNullOrNil(c9791v.anK())) {
            AppMethodBeat.m2505o(79038);
            return false;
        }
        AppMethodBeat.m2505o(79038);
        return true;
    }

    /* renamed from: l */
    static /* synthetic */ void m29331l(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(79040);
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ghp.size()) {
                WeakReference weakReference = (WeakReference) ghp.get(i2);
                if (weakReference != null) {
                    C18765a c18765a = (C18765a) weakReference.get();
                    if (c18765a != null) {
                        c18765a.mo8136m(str, bitmap);
                    } else {
                        vector.add(weakReference);
                    }
                }
                i = i2 + 1;
            } else {
                ghp.removeAll(vector);
                AppMethodBeat.m2505o(79040);
                return;
            }
        }
    }
}
