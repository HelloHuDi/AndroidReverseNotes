package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class c implements com.tencent.mm.plugin.fts.a.d.c {
    private static int MAX_CACHE_SIZE = 32;
    private ak fbD = new ak(Looper.getMainLooper());
    private ConcurrentHashMap<String, a> mAN;
    private Vector<String> mAO;
    private boolean mAP = true;
    private int mAQ = 0;
    private ak[] mAR = new ak[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> mAS = null;
    private ConcurrentHashMap<Long, byte[]> mAT = null;
    private ak mAU = null;
    private Set<String> mAV;

    class b implements Runnable {
        private String cHg;
        private String cacheKey;
        private int height;
        private boolean mAZ;
        private c mBa;
        private String url;
        private int width;

        public b(String str, String str2, String str3, boolean z, int i, int i2, c cVar) {
            this.cacheKey = str;
            this.url = str2;
            this.cHg = str3;
            this.mBa = cVar;
            this.mAZ = z;
            this.width = i;
            this.height = i2;
        }

        public final void run() {
            AppMethodBeat.i(136525);
            ab.d("MicroMsg.FTS.FTSImageLoader", "Start to run load bitmap job %s", this.cacheKey);
            if (bo.isNullOrNil(this.cHg)) {
                this.cHg = c.MR(this.cacheKey);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap U = c.U(this.cHg, this.width, this.height);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (U != null) {
                ab.d("MicroMsg.FTS.FTSImageLoader", "Found image in local %s | localPath %s | use time %d", this.url, this.cHg, Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                c.a(c.this, this.cacheKey, this.cHg, U);
                this.mBa.aK(this.cacheKey, true);
                AppMethodBeat.o(136525);
                return;
            }
            Bitmap a = c.a(c.this, this.url, this.mAZ, this.width, this.height);
            long currentTimeMillis3 = System.currentTimeMillis();
            ab.d("MicroMsg.FTS.FTSImageLoader", "Get image from net %s | localPath %s | use time %d", this.url, this.cHg, Long.valueOf(currentTimeMillis3 - currentTimeMillis2));
            if (a != null) {
                c.a(c.this, this.cacheKey, this.cHg, a);
                this.mBa.aK(this.cacheKey, true);
                AppMethodBeat.o(136525);
                return;
            }
            this.mBa.aK(this.cacheKey, false);
            AppMethodBeat.o(136525);
        }
    }

    interface c {
        void aK(String str, boolean z);
    }

    class a {
        Bitmap bitmap;
        String cHg;

        a() {
        }
    }

    class d implements Runnable {
        private a mBb;

        public d(a aVar) {
            this.mBb = aVar;
        }

        public final void run() {
            AppMethodBeat.i(136526);
            ab.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
            try {
                if (!new File(this.mBb.cHg).exists()) {
                    if (this.mBb.bitmap == null || this.mBb.bitmap.isRecycled()) {
                        ab.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.mm.sdk.platformtools.d.a(this.mBb.bitmap, 100, CompressFormat.PNG, this.mBb.cHg, false);
                        ab.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(136526);
                        return;
                    }
                }
                AppMethodBeat.o(136526);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e, "", new Object[0]);
                AppMethodBeat.o(136526);
            }
        }
    }

    public c() {
        int i = 0;
        AppMethodBeat.i(136527);
        ab.i("MicroMsg.FTS.FTSImageLoader", "create SearchImageLoader");
        if (com.tencent.mm.compatible.util.d.iW(19)) {
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
                com.tencent.mm.sdk.g.d.a(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136521);
                        Looper.prepare();
                        c.this.mAR[i] = new ak();
                        Looper.loop();
                        AppMethodBeat.o(136521);
                    }
                }, "SearchImageLoader_loadImage_handler", 1).start();
            }
            i++;
        }
        com.tencent.mm.sdk.g.d.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136522);
                Looper.prepare();
                c.this.mAU = new ak();
                Looper.loop();
                AppMethodBeat.o(136522);
            }
        }, "SearchImageLoader_saveImage_handler", 1).start();
        AppMethodBeat.o(136527);
    }

    public final void a(final Context context, final ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.i(136528);
        String a = a(imageView, str, str2, z, i, i2);
        if (this.mAP) {
            b bVar = new b(a, str, str2, z, i, i2, new c() {
                public final void aK(final String str, boolean z) {
                    AppMethodBeat.i(136524);
                    ab.v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", str, Boolean.valueOf(z));
                    c.this.mAV.remove(str);
                    if (z) {
                        final Bitmap a = c.a(c.this, str);
                        if (str.equals(imageView.getTag())) {
                            c.this.fbD.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(136523);
                                    if (str.equals(imageView.getTag())) {
                                        com.tencent.mm.plugin.fts.a.d.c.a.a(context.getResources(), a, imageView);
                                    }
                                    AppMethodBeat.o(136523);
                                }
                            });
                        }
                        AppMethodBeat.o(136524);
                        return;
                    }
                    AppMethodBeat.o(136524);
                }
            });
            if (this.mAV.add(a)) {
                this.mAQ++;
                this.mAQ %= 2;
                this.mAR[this.mAQ].post(bVar);
                AppMethodBeat.o(136528);
                return;
            }
            ab.v("MicroMsg.FTS.FTSImageLoader", "cacheKey: %s | runningJobTask: %s", a, this.mAV.toString());
            AppMethodBeat.o(136528);
            return;
        }
        AppMethodBeat.o(136528);
    }

    public final String a(ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.i(136529);
        String b = b(str, str2, z, i, i2);
        imageView.setTag(b);
        ab.d("MicroMsg.FTS.FTSImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", Integer.valueOf(imageView.hashCode()), b);
        AppMethodBeat.o(136529);
        return b;
    }

    public final void bzV() {
        AppMethodBeat.i(136530);
        ab.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImageTask");
        for (int i = 0; i < 2; i++) {
            if (this.mAR[i] != null) {
                this.mAR[i].removeCallbacksAndMessages(null);
            }
        }
        AppMethodBeat.o(136530);
    }

    public final void bzW() {
        AppMethodBeat.i(136531);
        ab.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImage");
        this.mAP = false;
        bzV();
        AppMethodBeat.o(136531);
    }

    public final boolean bzX() {
        return this.mAP;
    }

    public final void bzY() {
        AppMethodBeat.i(136532);
        ab.d("MicroMsg.FTS.FTSImageLoader", "startLoadImage");
        this.mAP = true;
        AppMethodBeat.o(136532);
    }

    public final void bzZ() {
        AppMethodBeat.i(136533);
        ab.d("MicroMsg.FTS.FTSImageLoader", "clearCacheAndTask %s", Integer.valueOf(this.mAN.size()));
        bzV();
        for (Entry key : this.mAN.entrySet()) {
            MQ((String) key.getKey());
        }
        this.mAO.clear();
        this.mAV.clear();
        AppMethodBeat.o(136533);
    }

    public final void bAa() {
        AppMethodBeat.i(136534);
        bzZ();
        ab.d("MicroMsg.FTS.FTSImageLoader", "destoryLoader");
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
        AppMethodBeat.o(136534);
    }

    public final Bitmap a(String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.i(136535);
        Bitmap sB = sB(b(str, str2, z, i, i2));
        AppMethodBeat.o(136535);
        return sB;
    }

    private Bitmap sB(String str) {
        AppMethodBeat.i(136536);
        a aVar = (a) this.mAN.get(str);
        if (!(aVar == null || aVar.bitmap == null || aVar.bitmap.isRecycled())) {
            this.mAO.remove(str);
            this.mAO.add(0, str);
        }
        if (aVar == null) {
            AppMethodBeat.o(136536);
            return null;
        }
        Bitmap bitmap = aVar.bitmap;
        AppMethodBeat.o(136536);
        return bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        AppMethodBeat.i(136537);
        bArr = (byte[]) this.mAT.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            this.mAT.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        AppMethodBeat.o(136537);
        return bArr;
    }

    private static String b(String str, String str2, boolean z, int i, int i2) {
        AppMethodBeat.i(136538);
        String str3 = "fts_search_" + g.x((bo.bc(str, BuildConfig.COMMAND) + bo.bc(str2, BuildConfig.COMMAND) + z + i + "_" + i2).getBytes());
        AppMethodBeat.o(136538);
        return str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0136 A:{SYNTHETIC, Splitter:B:57:0x0136} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Bitmap b(String str, boolean z, int i, int i2) {
        InputStream p;
        Throwable e;
        AppMethodBeat.i(136539);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136539);
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
            p = com.tencent.mm.network.b.p(str, Downloads.MIN_WAIT_FOR_NETWORK, i.sHCENCODEVIDEOTIMEOUT);
            if (p == null) {
                ab.w("MicroMsg.FTS.FTSImageLoader", "download %s error, can not open http stream", str);
                if (p != null) {
                    try {
                        p.close();
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(136539);
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
                bQ = com.tencent.mm.sdk.platformtools.d.bQ(toByteArray);
            } else {
                bQ = com.tencent.mm.sdk.platformtools.d.decodeByteArray(toByteArray, i, i2);
            }
            ab.d("MicroMsg.FTS.FTSImageLoader", "get url[%s] ok, bufSize[%d], bitmap size %d * %d", str, Integer.valueOf(i3), Integer.valueOf(bQ.getWidth()), Integer.valueOf(bQ.getHeight()));
            if (z) {
                bQ = com.tencent.mm.sdk.platformtools.d.a(bQ, true, (float) bQ.getWidth());
                if (p != null) {
                    try {
                        p.close();
                    } catch (IOException e4) {
                        ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e4, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(136539);
                return bQ;
            }
            if (p != null) {
                try {
                    p.close();
                } catch (IOException e42) {
                    ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e42, "", new Object[0]);
                }
            }
            AppMethodBeat.o(136539);
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
                    ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e422, "", new Object[0]);
                }
            }
            AppMethodBeat.o(136539);
            throw e;
        }
        try {
            ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e, "", new Object[0]);
            ab.w("MicroMsg.FTS.FTSImageLoader", "get url:%s failed.", str);
            if (p != null) {
                try {
                    p.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.o(136539);
            return null;
        } catch (Throwable th2) {
            e = th2;
            if (p != null) {
            }
            AppMethodBeat.o(136539);
            throw e;
        }
        AppMethodBeat.o(136539);
        return null;
    }

    private void MQ(String str) {
        AppMethodBeat.i(136540);
        a aVar = (a) this.mAN.get(str);
        this.mAO.remove(str);
        this.mAN.remove(str);
        if (!(aVar == null || aVar.bitmap == null)) {
            if (!aVar.bitmap.isRecycled()) {
                ab.i("MicroMsg.FTS.FTSImageLoader", "bitmap recycle %s", aVar.bitmap);
                aVar.bitmap.recycle();
            }
            aVar.bitmap = null;
        }
        AppMethodBeat.o(136540);
    }

    static /* synthetic */ String MR(String str) {
        AppMethodBeat.i(136542);
        String absolutePath = new File(new File(com.tencent.mm.plugin.i.c.XW()), str).getAbsolutePath();
        AppMethodBeat.o(136542);
        return absolutePath;
    }

    static /* synthetic */ Bitmap U(String str, int i, int i2) {
        AppMethodBeat.i(136543);
        Bitmap vv;
        if (bo.isNullOrNil(str) || !new File(str).exists()) {
            AppMethodBeat.o(136543);
            return null;
        } else if (i <= 0 || i2 <= 0) {
            vv = x.vv(str);
            AppMethodBeat.o(136543);
            return vv;
        } else {
            vv = x.q(str, i, i2);
            AppMethodBeat.o(136543);
            return vv;
        }
    }

    static /* synthetic */ void a(c cVar, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(136544);
        if (cVar.mAN.size() > MAX_CACHE_SIZE) {
            cVar.MQ((String) cVar.mAO.lastElement());
        }
        a aVar = new a();
        aVar.cHg = str2;
        aVar.bitmap = bitmap;
        cVar.mAN.put(str, aVar);
        if (!new File(aVar.cHg).exists()) {
            cVar.mAU.postDelayed(new d(aVar), 200);
        }
        AppMethodBeat.o(136544);
    }
}
