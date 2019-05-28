package com.tencent.p177mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3159c;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3159c.C3160a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.fts.c */
public final class C12054c implements C3159c {
    private static int MAX_CACHE_SIZE = 32;
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private ConcurrentHashMap<String, C12057a> mAN;
    private Vector<String> mAO;
    private boolean mAP = true;
    private int mAQ = 0;
    private C7306ak[] mAR = new C7306ak[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> mAS = null;
    private ConcurrentHashMap<Long, byte[]> mAT = null;
    private C7306ak mAU = null;
    private Set<String> mAV;

    /* renamed from: com.tencent.mm.plugin.fts.c$b */
    class C12052b implements Runnable {
        private String cHg;
        private String cacheKey;
        private int height;
        private boolean mAZ;
        private C12053c mBa;
        private String url;
        private int width;

        public C12052b(String str, String str2, String str3, boolean z, int i, int i2, C12053c c12053c) {
            this.cacheKey = str;
            this.url = str2;
            this.cHg = str3;
            this.mBa = c12053c;
            this.mAZ = z;
            this.width = i;
            this.height = i2;
        }

        public final void run() {
            AppMethodBeat.m2504i(136525);
            C4990ab.m7411d("MicroMsg.FTS.FTSImageLoader", "Start to run load bitmap job %s", this.cacheKey);
            if (C5046bo.isNullOrNil(this.cHg)) {
                this.cHg = C12054c.m19963MR(this.cacheKey);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap U = C12054c.m19964U(this.cHg, this.width, this.height);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (U != null) {
                C4990ab.m7411d("MicroMsg.FTS.FTSImageLoader", "Found image in local %s | localPath %s | use time %d", this.url, this.cHg, Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                C12054c.m19968a(C12054c.this, this.cacheKey, this.cHg, U);
                this.mBa.mo23890aK(this.cacheKey, true);
                AppMethodBeat.m2505o(136525);
                return;
            }
            Bitmap a = C12054c.m19966a(C12054c.this, this.url, this.mAZ, this.width, this.height);
            long currentTimeMillis3 = System.currentTimeMillis();
            C4990ab.m7411d("MicroMsg.FTS.FTSImageLoader", "Get image from net %s | localPath %s | use time %d", this.url, this.cHg, Long.valueOf(currentTimeMillis3 - currentTimeMillis2));
            if (a != null) {
                C12054c.m19968a(C12054c.this, this.cacheKey, this.cHg, a);
                this.mBa.mo23890aK(this.cacheKey, true);
                AppMethodBeat.m2505o(136525);
                return;
            }
            this.mBa.mo23890aK(this.cacheKey, false);
            AppMethodBeat.m2505o(136525);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.c$c */
    interface C12053c {
        /* renamed from: aK */
        void mo23890aK(String str, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.fts.c$2 */
    class C120552 implements Runnable {
        C120552() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136522);
            Looper.prepare();
            C12054c.this.mAU = new C7306ak();
            Looper.loop();
            AppMethodBeat.m2505o(136522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.c$a */
    class C12057a {
        Bitmap bitmap;
        String cHg;

        C12057a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.c$d */
    class C12058d implements Runnable {
        private C12057a mBb;

        public C12058d(C12057a c12057a) {
            this.mBb = c12057a;
        }

        public final void run() {
            AppMethodBeat.m2504i(136526);
            C4990ab.m7410d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
            try {
                if (!new File(this.mBb.cHg).exists()) {
                    if (this.mBb.bitmap == null || this.mBb.bitmap.isRecycled()) {
                        C4990ab.m7410d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        C5056d.m7625a(this.mBb.bitmap, 100, CompressFormat.PNG, this.mBb.cHg, false);
                        C4990ab.m7411d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(136526);
                        return;
                    }
                }
                AppMethodBeat.m2505o(136526);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e, "", new Object[0]);
                AppMethodBeat.m2505o(136526);
            }
        }
    }

    public C12054c() {
        int i = 0;
        AppMethodBeat.m2504i(136527);
        C4990ab.m7416i("MicroMsg.FTS.FTSImageLoader", "create SearchImageLoader");
        if (C1443d.m3068iW(19)) {
            MAX_CACHE_SIZE = 64;
        } else {
            MAX_CACHE_SIZE = 32;
        }
        this.mAN = new ConcurrentHashMap();
        this.mAO = new Vector();
        this.mAS = new ConcurrentHashMap();
        this.mAT = new ConcurrentHashMap();
        this.mAV = Collections.synchronizedSet(new HashSet());
        while (i < 2) {
            if (this.mAR[i] == null) {
                C7305d.m12285a(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(136521);
                        Looper.prepare();
                        C12054c.this.mAR[i] = new C7306ak();
                        Looper.loop();
                        AppMethodBeat.m2505o(136521);
                    }
                }, "SearchImageLoader_loadImage_handler", 1).start();
            }
            i++;
        }
        C7305d.m12285a(new C120552(), "SearchImageLoader_saveImage_handler", 1).start();
        AppMethodBeat.m2505o(136527);
    }

    /* renamed from: a */
    public final void mo7427a(final Context context, final ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(136528);
        String a = mo7426a(imageView, str, str2, z, i, i2);
        if (this.mAP) {
            C12052b c12052b = new C12052b(a, str, str2, z, i, i2, new C12053c() {
                /* renamed from: aK */
                public final void mo23890aK(final String str, boolean z) {
                    AppMethodBeat.m2504i(136524);
                    C4990ab.m7419v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", str, Boolean.valueOf(z));
                    C12054c.this.mAV.remove(str);
                    if (z) {
                        final Bitmap a = C12054c.m19965a(C12054c.this, str);
                        if (str.equals(imageView.getTag())) {
                            C12054c.this.fbD.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(136523);
                                    if (str.equals(imageView.getTag())) {
                                        C3160a.m5397a(context.getResources(), a, imageView);
                                    }
                                    AppMethodBeat.m2505o(136523);
                                }
                            });
                        }
                        AppMethodBeat.m2505o(136524);
                        return;
                    }
                    AppMethodBeat.m2505o(136524);
                }
            });
            if (this.mAV.add(a)) {
                this.mAQ++;
                this.mAQ %= 2;
                this.mAR[this.mAQ].post(c12052b);
                AppMethodBeat.m2505o(136528);
                return;
            }
            C4990ab.m7419v("MicroMsg.FTS.FTSImageLoader", "cacheKey: %s | runningJobTask: %s", a, this.mAV.toString());
            AppMethodBeat.m2505o(136528);
            return;
        }
        AppMethodBeat.m2505o(136528);
    }

    /* renamed from: a */
    public final String mo7426a(ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(136529);
        String b = C12054c.m19971b(str, str2, z, i, i2);
        imageView.setTag(b);
        C4990ab.m7411d("MicroMsg.FTS.FTSImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", Integer.valueOf(imageView.hashCode()), b);
        AppMethodBeat.m2505o(136529);
        return b;
    }

    public final void bzV() {
        AppMethodBeat.m2504i(136530);
        C4990ab.m7410d("MicroMsg.FTS.FTSImageLoader", "stopLoadImageTask");
        for (int i = 0; i < 2; i++) {
            if (this.mAR[i] != null) {
                this.mAR[i].removeCallbacksAndMessages(null);
            }
        }
        AppMethodBeat.m2505o(136530);
    }

    public final void bzW() {
        AppMethodBeat.m2504i(136531);
        C4990ab.m7410d("MicroMsg.FTS.FTSImageLoader", "stopLoadImage");
        this.mAP = false;
        bzV();
        AppMethodBeat.m2505o(136531);
    }

    public final boolean bzX() {
        return this.mAP;
    }

    public final void bzY() {
        AppMethodBeat.m2504i(136532);
        C4990ab.m7410d("MicroMsg.FTS.FTSImageLoader", "startLoadImage");
        this.mAP = true;
        AppMethodBeat.m2505o(136532);
    }

    public final void bzZ() {
        AppMethodBeat.m2504i(136533);
        C4990ab.m7411d("MicroMsg.FTS.FTSImageLoader", "clearCacheAndTask %s", Integer.valueOf(this.mAN.size()));
        bzV();
        for (Entry key : this.mAN.entrySet()) {
            m19962MQ((String) key.getKey());
        }
        this.mAO.clear();
        this.mAV.clear();
        AppMethodBeat.m2505o(136533);
    }

    public final void bAa() {
        AppMethodBeat.m2504i(136534);
        bzZ();
        C4990ab.m7410d("MicroMsg.FTS.FTSImageLoader", "destoryLoader");
        for (int i = 0; i < 2; i++) {
            if (this.mAR[i] != null) {
                this.mAR[i].getLooper().quit();
            }
        }
        for (ByteArrayOutputStream close : this.mAS.values()) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
        this.mAS.clear();
        this.mAT.clear();
        this.mAU.getLooper().quit();
        AppMethodBeat.m2505o(136534);
    }

    /* renamed from: a */
    public final Bitmap mo7425a(String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(136535);
        Bitmap sB = m19974sB(C12054c.m19971b(str, str2, z, i, i2));
        AppMethodBeat.m2505o(136535);
        return sB;
    }

    /* renamed from: sB */
    private Bitmap m19974sB(String str) {
        AppMethodBeat.m2504i(136536);
        C12057a c12057a = (C12057a) this.mAN.get(str);
        if (!(c12057a == null || c12057a.bitmap == null || c12057a.bitmap.isRecycled())) {
            this.mAO.remove(str);
            this.mAO.add(0, str);
        }
        if (c12057a == null) {
            AppMethodBeat.m2505o(136536);
            return null;
        }
        Bitmap bitmap = c12057a.bitmap;
        AppMethodBeat.m2505o(136536);
        return bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        AppMethodBeat.m2504i(136537);
        bArr = (byte[]) this.mAT.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            this.mAT.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        AppMethodBeat.m2505o(136537);
        return bArr;
    }

    /* renamed from: b */
    private static String m19971b(String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(136538);
        String str3 = "fts_search_" + C1178g.m2591x((C5046bo.m7532bc(str, BuildConfig.COMMAND) + C5046bo.m7532bc(str2, BuildConfig.COMMAND) + z + i + "_" + i2).getBytes());
        AppMethodBeat.m2505o(136538);
        return str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0136 A:{SYNTHETIC, Splitter:B:57:0x0136} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private Bitmap m19970b(String str, boolean z, int i, int i2) {
        InputStream p;
        Throwable e;
        AppMethodBeat.m2504i(136539);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136539);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.mAS.get(Long.valueOf(Thread.currentThread().getId()));
        if (byteArrayOutputStream == null) {
            byteArrayOutputStream = new ByteArrayOutputStream(32768);
            this.mAS.put(Long.valueOf(Thread.currentThread().getId()), byteArrayOutputStream);
        }
        byteArrayOutputStream.reset();
        byte[] buffer = getBuffer();
        try {
            p = C1897b.m4022p(str, Downloads.MIN_WAIT_FOR_NETWORK, C1625i.sHCENCODEVIDEOTIMEOUT);
            if (p == null) {
                C4990ab.m7421w("MicroMsg.FTS.FTSImageLoader", "download %s error, can not open http stream", str);
                if (p != null) {
                    try {
                        p.close();
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(136539);
                return null;
            }
            Bitmap bQ;
            int i3 = 0;
            while (true) {
                try {
                    int read = p.read(buffer);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                    byteArrayOutputStream.write(buffer, 0, read);
                } catch (Exception e3) {
                    e = e3;
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (i <= 0 || i2 <= 0) {
                bQ = C5056d.m7652bQ(toByteArray);
            } else {
                bQ = C5056d.decodeByteArray(toByteArray, i, i2);
            }
            C4990ab.m7411d("MicroMsg.FTS.FTSImageLoader", "get url[%s] ok, bufSize[%d], bitmap size %d * %d", str, Integer.valueOf(i3), Integer.valueOf(bQ.getWidth()), Integer.valueOf(bQ.getHeight()));
            if (z) {
                bQ = C5056d.m7616a(bQ, true, (float) bQ.getWidth());
                if (p != null) {
                    try {
                        p.close();
                    } catch (IOException e4) {
                        C4990ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e4, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(136539);
                return bQ;
            }
            if (p != null) {
                try {
                    p.close();
                } catch (IOException e42) {
                    C4990ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e42, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(136539);
            return bQ;
        } catch (Exception e5) {
            e = e5;
            p = null;
        } catch (Throwable th) {
            e = th;
            p = null;
            if (p != null) {
                try {
                    p.close();
                } catch (IOException e422) {
                    C4990ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e422, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(136539);
            throw e;
        }
        try {
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FTS.FTSImageLoader", "get url:%s failed.", str);
            if (p != null) {
                try {
                    p.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(136539);
            return null;
        } catch (Throwable th2) {
            e = th2;
            if (p != null) {
            }
            AppMethodBeat.m2505o(136539);
            throw e;
        }
        AppMethodBeat.m2505o(136539);
        return null;
    }

    /* renamed from: MQ */
    private void m19962MQ(String str) {
        AppMethodBeat.m2504i(136540);
        C12057a c12057a = (C12057a) this.mAN.get(str);
        this.mAO.remove(str);
        this.mAN.remove(str);
        if (!(c12057a == null || c12057a.bitmap == null)) {
            if (!c12057a.bitmap.isRecycled()) {
                C4990ab.m7417i("MicroMsg.FTS.FTSImageLoader", "bitmap recycle %s", c12057a.bitmap);
                c12057a.bitmap.recycle();
            }
            c12057a.bitmap = null;
        }
        AppMethodBeat.m2505o(136540);
    }

    /* renamed from: MR */
    static /* synthetic */ String m19963MR(String str) {
        AppMethodBeat.m2504i(136542);
        String absolutePath = new File(new File(C43217c.m76863XW()), str).getAbsolutePath();
        AppMethodBeat.m2505o(136542);
        return absolutePath;
    }

    /* renamed from: U */
    static /* synthetic */ Bitmap m19964U(String str, int i, int i2) {
        AppMethodBeat.m2504i(136543);
        Bitmap vv;
        if (C5046bo.isNullOrNil(str) || !new File(str).exists()) {
            AppMethodBeat.m2505o(136543);
            return null;
        } else if (i <= 0 || i2 <= 0) {
            vv = C18764x.m29333vv(str);
            AppMethodBeat.m2505o(136543);
            return vv;
        } else {
            vv = C18764x.m29332q(str, i, i2);
            AppMethodBeat.m2505o(136543);
            return vv;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19968a(C12054c c12054c, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.m2504i(136544);
        if (c12054c.mAN.size() > MAX_CACHE_SIZE) {
            c12054c.m19962MQ((String) c12054c.mAO.lastElement());
        }
        C12057a c12057a = new C12057a();
        c12057a.cHg = str2;
        c12057a.bitmap = bitmap;
        c12054c.mAN.put(str, c12057a);
        if (!new File(c12057a.cHg).exists()) {
            c12054c.mAU.postDelayed(new C12058d(c12057a), 200);
        }
        AppMethodBeat.m2505o(136544);
    }
}
