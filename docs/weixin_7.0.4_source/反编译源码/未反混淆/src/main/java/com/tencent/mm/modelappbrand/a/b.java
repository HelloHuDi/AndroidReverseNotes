package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final String fqf;
    private final Map<i, String> fpZ;
    private final Map<String, i> fqa;
    private final Map<Integer, String> fqb;
    private final d fqc;
    private final j fqd;
    private final g fqe;

    public interface i extends c {
        void abU();

        void mr();

        String wP();

        void x(Bitmap bitmap);
    }

    public interface j {
        void c(String str, Bitmap bitmap);

        void f(Bitmap bitmap);

        Bitmap kR(String str);
    }

    static final class l implements a {
        private final String fqA;
        boolean fqB;
        final g fqe;
        final b fqu;
        final String fqw;
        private final f fqx;
        private final j fqy;
        private final e fqz;

        /* synthetic */ l(String str, f fVar, b bVar, j jVar, g gVar, e eVar, String str2, byte b) {
            this(str, fVar, bVar, jVar, gVar, eVar, str2);
        }

        private l(String str, f fVar, b bVar, j jVar, g gVar, e eVar, String str2) {
            this.fqB = true;
            this.fqw = str;
            this.fqx = fVar;
            this.fqu = bVar;
            this.fqy = jVar;
            this.fqe = gVar;
            this.fqz = eVar;
            this.fqA = str2;
        }

        /* Access modifiers changed, original: final */
        public final String abY() {
            AppMethodBeat.i(77350);
            String as = b.as(this.fqA, abZ());
            AppMethodBeat.o(77350);
            return as;
        }

        /* Access modifiers changed, original: final */
        public final String abZ() {
            AppMethodBeat.i(77351);
            String b = b.b(this.fqw, this.fqx, this.fqz);
            AppMethodBeat.o(77351);
            return b;
        }

        /* Access modifiers changed, original: final */
        public final void aca() {
            AppMethodBeat.i(77352);
            try {
                Bitmap acb = acb();
                if (!(acb == null || acb.isRecycled())) {
                    this.fqu.fqc.pL(b.pG(this.fqw));
                    this.fqu.fqc.a(b.pG(this.fqw), this);
                    A(acb);
                    this.fqu.fqc.pJ(b.pG(this.fqw));
                }
                AppMethodBeat.o(77352);
            } catch (d e) {
                ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", e);
                this.fqu.fqc.pL(b.pG(this.fqw));
                this.fqu.fqc.pM(b.pG(this.fqw));
                A(null);
                if (e instanceof a) {
                    this.fqu.fqe.pI(b.pG(this.fqw));
                }
                AppMethodBeat.o(77352);
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " doIOJobImpl, io exp ", new Object[0]);
                this.fqu.fqc.pL(b.pG(this.fqw));
                this.fqu.fqc.a(b.pG(this.fqw), this);
                this.fqu.fqc.pJ(b.pG(this.fqw));
                AppMethodBeat.o(77352);
            }
        }

        public final void abV() {
            AppMethodBeat.i(77353);
            final Bitmap kR = this.fqy.kR(abZ());
            if (kR != null && !kR.isRecycled()) {
                ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", abZ());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(77345);
                        l.this.x(kR);
                        AppMethodBeat.o(77345);
                    }
                });
                AppMethodBeat.o(77353);
            } else if (this.fqu.fqc.pK(b.pG(this.fqw))) {
                d d = this.fqu.fqc;
                String pG = b.pG(this.fqw);
                if (!bo.isNullOrNil(pG)) {
                    List list = (List) d.fqs.get(pG);
                    if (list == null) {
                        list = new LinkedList();
                        d.fqs.put(pG, list);
                    }
                    list.add(this);
                }
                ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", b.pG(this.fqw));
                AppMethodBeat.o(77353);
            } else {
                d d2 = this.fqu.fqc;
                String pG2 = b.pG(this.fqw);
                if (!bo.isNullOrNil(pG2)) {
                    d2.fqt.put(pG2, Boolean.TRUE);
                }
                aca();
                AppMethodBeat.o(77353);
            }
        }

        public final void abW() {
            AppMethodBeat.i(77354);
            i iVar = (i) this.fqu.fqa.remove(abY());
            if (iVar != null) {
                this.fqu.fpZ.remove(iVar);
            }
            AppMethodBeat.o(77354);
        }

        /* Access modifiers changed, original: final */
        public final void x(Bitmap bitmap) {
            AppMethodBeat.i(77355);
            i iVar = (i) this.fqu.fqa.remove(abY());
            if (iVar != null) {
                iVar.x(bitmap);
                this.fqu.fpZ.remove(iVar);
            }
            AppMethodBeat.o(77355);
        }

        private Bitmap z(Bitmap bitmap) {
            AppMethodBeat.i(77356);
            Bitmap y = this.fqx.y(bitmap);
            AppMethodBeat.o(77356);
            return y;
        }

        private void A(Bitmap bitmap) {
            boolean z = false;
            AppMethodBeat.i(77357);
            String str = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            String str2 = "postLoadInWorkerThread bitmap ok %b";
            Object[] objArr = new Object[1];
            boolean z2 = (bitmap == null || bitmap.isRecycled()) ? false : true;
            objArr[0] = Boolean.valueOf(z2);
            ab.d(str, str2, objArr);
            if (!(this.fqx == null || bitmap == null || bitmap.isRecycled())) {
                Bitmap z3 = z(bitmap);
                ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", bitmap, z3);
                if (z3 != bitmap) {
                    this.fqy.f(bitmap);
                }
                bitmap = z3;
            }
            this.fqy.c(abZ(), bitmap);
            String str3 = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            str = "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b";
            Object[] objArr2 = new Object[2];
            objArr2[0] = bitmap;
            if (!(bitmap == null || bitmap.isRecycled())) {
                z = true;
            }
            objArr2[1] = Boolean.valueOf(z);
            ab.d(str3, str, objArr2);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(77347);
                    l lVar = l.this;
                    Bitmap bitmap = bitmap;
                    if (bitmap == null || bitmap.isRecycled()) {
                        ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", bitmap);
                        i iVar = (i) lVar.fqu.fqa.remove(lVar.abY());
                        if (iVar != null) {
                            iVar.mr();
                            lVar.fqu.fpZ.remove(iVar);
                        }
                        AppMethodBeat.o(77347);
                        return;
                    }
                    ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", bitmap);
                    lVar.x(bitmap);
                    AppMethodBeat.o(77347);
                }
            });
            AppMethodBeat.o(77357);
        }

        private Bitmap acb() {
            Bitmap bitmap = null;
            AppMethodBeat.i(77358);
            if (b.abT()) {
                InputStream openRead;
                if (this.fqw.startsWith("file://") || this.fqw.startsWith("wcf://")) {
                    try {
                        openRead = com.tencent.mm.vfs.e.openRead(this.fqw);
                    } catch (FileNotFoundException e) {
                        ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "load from local file %s", this.fqw);
                        AppMethodBeat.o(77358);
                    }
                } else {
                    openRead = this.fqe.openRead(b.pG(this.fqw));
                    if (openRead == null) {
                        ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", Boolean.valueOf(this.fqB));
                        if (this.fqB) {
                            com.tencent.mm.sdk.g.d.post(new Runnable() {
                                /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
                                /* JADX WARNING: Removed duplicated region for block: B:52:0x0101  */
                                /* JADX WARNING: Removed duplicated region for block: B:52:0x0101  */
                                /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
                                /* JADX WARNING: Removed duplicated region for block: B:52:0x0101  */
                                /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
                                /* JADX WARNING: Removed duplicated region for block: B:52:0x0101  */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void run() {
                                    Closeable bufferedInputStream;
                                    Throwable e;
                                    AppMethodBeat.i(77349);
                                    l lVar = l.this;
                                    HttpURLConnection httpURLConnection;
                                    Closeable pH;
                                    try {
                                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(lVar.fqw).openConnection();
                                        try {
                                            if (httpURLConnection2.getResponseCode() == 301 || httpURLConnection2.getResponseCode() == 302) {
                                                String headerField = httpURLConnection2.getHeaderField("Location");
                                                if (URLUtil.isAboutUrl(headerField) || !URLUtil.isNetworkUrl(headerField)) {
                                                    MalformedURLException malformedURLException = new MalformedURLException(String.format("Origin %s, Location %s", new Object[]{lVar.fqw, headerField}));
                                                    AppMethodBeat.o(77349);
                                                    throw malformedURLException;
                                                }
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable th) {
                                                }
                                                httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                                                httpURLConnection2.setInstanceFollowRedirects(false);
                                            }
                                            httpURLConnection = httpURLConnection2;
                                            try {
                                                pH = lVar.fqe.pH(b.pG(lVar.fqw));
                                                if (pH == null) {
                                                    bo.b(pH);
                                                    bo.b(null);
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                } else {
                                                    try {
                                                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        bufferedInputStream = null;
                                                        try {
                                                            ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", lVar.fqw);
                                                            lVar.fqe.pI(b.pG(lVar.fqw));
                                                            bo.b(pH);
                                                            bo.b(bufferedInputStream);
                                                            if (httpURLConnection != null) {
                                                            }
                                                            l.this.fqu.fqc.f(new Runnable() {
                                                                public final void run() {
                                                                    AppMethodBeat.i(77348);
                                                                    l.this.fqB = false;
                                                                    l.this.aca();
                                                                    AppMethodBeat.o(77348);
                                                                }
                                                            });
                                                            AppMethodBeat.o(77349);
                                                        } catch (Throwable e22) {
                                                            e = e22;
                                                            bo.b(pH);
                                                            bo.b(bufferedInputStream);
                                                            if (httpURLConnection != null) {
                                                            }
                                                            AppMethodBeat.o(77349);
                                                            throw e;
                                                        }
                                                    } catch (Throwable e222) {
                                                        e = e222;
                                                        bufferedInputStream = null;
                                                        bo.b(pH);
                                                        bo.b(bufferedInputStream);
                                                        if (httpURLConnection != null) {
                                                        }
                                                        AppMethodBeat.o(77349);
                                                        throw e;
                                                    }
                                                    try {
                                                        byte[] bArr = new byte[16384];
                                                        while (true) {
                                                            int read = bufferedInputStream.read(bArr, 0, 16384);
                                                            if (read == -1) {
                                                                break;
                                                            }
                                                            pH.write(bArr, 0, read);
                                                        }
                                                        pH.flush();
                                                        bo.b(pH);
                                                        bo.b(bufferedInputStream);
                                                        if (httpURLConnection != null) {
                                                            httpURLConnection.disconnect();
                                                        }
                                                    } catch (Exception e2222) {
                                                        e = e2222;
                                                        ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", lVar.fqw);
                                                        lVar.fqe.pI(b.pG(lVar.fqw));
                                                        bo.b(pH);
                                                        bo.b(bufferedInputStream);
                                                        if (httpURLConnection != null) {
                                                            httpURLConnection.disconnect();
                                                        }
                                                        l.this.fqu.fqc.f(/* anonymous class already generated */);
                                                        AppMethodBeat.o(77349);
                                                    }
                                                }
                                            } catch (Exception e22222) {
                                                e = e22222;
                                                pH = null;
                                                bufferedInputStream = null;
                                            } catch (Throwable e222222) {
                                                e = e222222;
                                                pH = null;
                                                bufferedInputStream = null;
                                                bo.b(pH);
                                                bo.b(bufferedInputStream);
                                                if (httpURLConnection != null) {
                                                }
                                                AppMethodBeat.o(77349);
                                                throw e;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            httpURLConnection = httpURLConnection2;
                                            pH = null;
                                            bufferedInputStream = null;
                                            ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", lVar.fqw);
                                            lVar.fqe.pI(b.pG(lVar.fqw));
                                            bo.b(pH);
                                            bo.b(bufferedInputStream);
                                            if (httpURLConnection != null) {
                                            }
                                            l.this.fqu.fqc.f(/* anonymous class already generated */);
                                            AppMethodBeat.o(77349);
                                        } catch (Throwable th2) {
                                            e = th2;
                                            httpURLConnection = httpURLConnection2;
                                            pH = null;
                                            bufferedInputStream = null;
                                            bo.b(pH);
                                            bo.b(bufferedInputStream);
                                            if (httpURLConnection != null) {
                                            }
                                            AppMethodBeat.o(77349);
                                            throw e;
                                        }
                                    } catch (Exception e2222222) {
                                        e = e2222222;
                                        httpURLConnection = null;
                                        pH = null;
                                        bufferedInputStream = null;
                                        ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", lVar.fqw);
                                        lVar.fqe.pI(b.pG(lVar.fqw));
                                        bo.b(pH);
                                        bo.b(bufferedInputStream);
                                        if (httpURLConnection != null) {
                                        }
                                        l.this.fqu.fqc.f(/* anonymous class already generated */);
                                        AppMethodBeat.o(77349);
                                    } catch (Throwable e22222222) {
                                        e = e22222222;
                                        httpURLConnection = null;
                                        pH = null;
                                        bufferedInputStream = null;
                                        bo.b(pH);
                                        bo.b(bufferedInputStream);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        AppMethodBeat.o(77349);
                                        throw e;
                                    }
                                    l.this.fqu.fqc.f(/* anonymous class already generated */);
                                    AppMethodBeat.o(77349);
                                }
                            }, "AppBrandSimpleImageLoaderDownloadThread");
                        } else {
                            this.fqu.fqc.pM(b.pG(this.fqw));
                            this.fqu.fqc.pL(b.pG(this.fqw));
                            b bVar = new b();
                            AppMethodBeat.o(77358);
                            throw bVar;
                        }
                    }
                }
                if (openRead != null) {
                    try {
                        bitmap = w(openRead);
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " decode ", new Object[0]);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", bitmap);
                        a aVar = new a();
                        AppMethodBeat.o(77358);
                        throw aVar;
                    }
                    ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", bitmap, Integer.valueOf(android.support.v4.a.a.c(bitmap) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), this.fqw);
                    AppMethodBeat.o(77358);
                } else {
                    AppMethodBeat.o(77358);
                }
                return bitmap;
            }
            ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
            c cVar = new c();
            AppMethodBeat.o(77358);
            throw cVar;
        }

        private Bitmap w(InputStream inputStream) {
            AppMethodBeat.i(77359);
            try {
                Bitmap v;
                if (this.fqz != null) {
                    v = this.fqz.v(inputStream);
                } else {
                    v = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                    bo.b(inputStream);
                    AppMethodBeat.o(77359);
                }
                return v;
            } finally {
                bo.b(inputStream);
                AppMethodBeat.o(77359);
            }
        }
    }

    static class k implements i {
        private final WeakReference<ImageView> aIp;
        private final b fqu;
        boolean fqv;
        final String key;

        /* synthetic */ k(ImageView imageView, b bVar, byte b) {
            this(imageView, bVar);
        }

        /* Access modifiers changed, original: final */
        public final ImageView getImageView() {
            AppMethodBeat.i(77340);
            ImageView imageView = (ImageView) this.aIp.get();
            AppMethodBeat.o(77340);
            return imageView;
        }

        private k(ImageView imageView, b bVar) {
            AppMethodBeat.i(77341);
            this.fqv = false;
            this.aIp = new WeakReference(imageView);
            this.fqu = bVar;
            this.key = "ImageView#" + imageView.hashCode();
            AppMethodBeat.o(77341);
        }

        private void abX() {
            AppMethodBeat.i(77342);
            if (this.aIp.get() != null) {
                this.fqu.fqb.remove(Integer.valueOf(((ImageView) this.aIp.get()).hashCode()));
            }
            AppMethodBeat.o(77342);
        }

        public void abU() {
        }

        public final void x(Bitmap bitmap) {
            AppMethodBeat.i(77343);
            abX();
            ImageView imageView = (ImageView) this.aIp.get();
            if (imageView != null) {
                if (!al.isMainThread()) {
                    ab.b("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
                }
                imageView.setImageDrawable(new e(imageView.getResources(), bitmap));
            }
            this.fqv = true;
            AppMethodBeat.o(77343);
        }

        public final void mr() {
            AppMethodBeat.i(77344);
            abX();
            AppMethodBeat.o(77344);
        }

        public final String wP() {
            return this.key;
        }
    }

    static final class a implements g {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final OutputStream pH(String str) {
            AppMethodBeat.i(77321);
            try {
                if (!(com.tencent.mm.vfs.e.tf(b.fqf) || new com.tencent.mm.vfs.b(b.fqf).isDirectory())) {
                    com.tencent.mm.vfs.e.deleteFile(b.fqf);
                    com.tencent.mm.vfs.e.tf(b.fqf);
                }
            } catch (Throwable th) {
                ab.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", th);
            }
            String str2 = b.fqf + str;
            final String str3 = str2 + ".wlock";
            com.tencent.mm.vfs.e.deleteFile(str3);
            com.tencent.mm.vfs.e.N(str3, true);
            com.tencent.mm.vfs.e.b(str3, new byte[1], 1);
            try {
                com.tencent.mm.vfs.e.deleteFile(str2);
                com.tencent.mm.vfs.e.N(str2, true);
                AnonymousClass1 anonymousClass1 = new BufferedOutputStream(com.tencent.mm.vfs.e.L(str2, false)) {
                    public final synchronized void flush() {
                        AppMethodBeat.i(77320);
                        super.flush();
                        com.tencent.mm.vfs.e.deleteFile(str3);
                        AppMethodBeat.o(77320);
                    }
                };
                AppMethodBeat.o(77321);
                return anonymousClass1;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openWrite fileName %s, parent exists[%b]", str, Boolean.valueOf(com.tencent.mm.vfs.e.ct(b.fqf)));
                AppMethodBeat.o(77321);
                return null;
            }
        }

        public final InputStream openRead(String str) {
            InputStream inputStream = null;
            AppMethodBeat.i(77322);
            String str2 = b.fqf + str;
            if (com.tencent.mm.vfs.e.ct(str2 + ".wlock")) {
                AppMethodBeat.o(77322);
            } else {
                try {
                    inputStream = com.tencent.mm.vfs.e.openRead(str2);
                    AppMethodBeat.o(77322);
                } catch (IOException e) {
                    ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", str, e);
                    AppMethodBeat.o(77322);
                }
            }
            return inputStream;
        }

        public final boolean pI(String str) {
            AppMethodBeat.i(77323);
            if (bo.isNullOrNil(str) || !com.tencent.mm.a.e.deleteFile(b.fqf + str)) {
                AppMethodBeat.o(77323);
                return false;
            }
            AppMethodBeat.o(77323);
            return true;
        }
    }

    public static final class c implements j {
        final com.tencent.mm.a.f<String, Reference<Bitmap>> fqo = new com.tencent.mm.a.h<String, Reference<Bitmap>>() {
            private final Map<Reference<Bitmap>, Integer> fqp = new ConcurrentHashMap();

            {
                AppMethodBeat.i(77324);
                AppMethodBeat.o(77324);
            }

            public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                String str;
                AppMethodBeat.i(77328);
                String str2 = (String) obj;
                Reference reference = (Reference) obj2;
                Reference reference2 = (Reference) obj3;
                String str3 = "MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache";
                String str4 = "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(c.this.fqo.size() / 10);
                objArr[1] = Integer.valueOf(c.this.fqo.maxSize() / 10);
                if (reference == null) {
                    str = "null-ref";
                } else {
                    str = reference.get();
                }
                objArr[2] = str;
                if (reference2 == null) {
                    str = "null-ref";
                } else {
                    str = reference2.get();
                }
                objArr[3] = str;
                ab.d(str3, str4, objArr);
                super.entryRemoved(z, str2, reference, reference2);
                Bitmap bitmap = reference == null ? null : (Bitmap) reference.get();
                if (bitmap != (reference2 == null ? null : (Bitmap) reference2.get())) {
                    c.this.f(bitmap);
                }
                this.fqp.remove(reference);
                AppMethodBeat.o(77328);
            }

            public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                AppMethodBeat.i(77327);
                Reference reference = (Reference) obj2;
                if (reference == null) {
                    AppMethodBeat.o(77327);
                    return 0;
                }
                Integer num = (Integer) this.fqp.get(reference);
                if (num == null || num.intValue() < 0) {
                    int i;
                    Bitmap bitmap = (Bitmap) reference.get();
                    if (bitmap == null || bitmap.isRecycled()) {
                        i = 0;
                    } else {
                        i = android.support.v4.a.a.c(bitmap);
                    }
                    this.fqp.put(reference, Integer.valueOf(i));
                    AppMethodBeat.o(77327);
                    return i;
                }
                int intValue = num.intValue();
                AppMethodBeat.o(77327);
                return intValue;
            }

            public final void clear() {
                AppMethodBeat.i(77325);
                ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
                super.clear();
                this.fqp.clear();
                AppMethodBeat.o(77325);
            }

            public final void a(com.tencent.mm.a.f.a<String, Reference<Bitmap>> aVar) {
                AppMethodBeat.i(77326);
                ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
                super.a(aVar);
                this.fqp.clear();
                AppMethodBeat.o(77326);
            }
        };

        public c() {
            AppMethodBeat.i(77329);
            AppMethodBeat.o(77329);
        }

        public final Bitmap kR(String str) {
            AppMethodBeat.i(77330);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77330);
                return null;
            }
            Reference reference = (Reference) this.fqo.get(str);
            if (reference == null) {
                AppMethodBeat.o(77330);
                return null;
            }
            Bitmap bitmap = (Bitmap) reference.get();
            if (bitmap == null || bitmap.isRecycled()) {
                this.fqo.remove(str);
                AppMethodBeat.o(77330);
                return null;
            }
            AppMethodBeat.o(77330);
            return bitmap;
        }

        public final void c(String str, Bitmap bitmap) {
            AppMethodBeat.i(77331);
            if (bo.isNullOrNil(str) || bitmap == null) {
                AppMethodBeat.o(77331);
                return;
            }
            ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", str, bitmap);
            this.fqo.put(str, new SoftReference(bitmap));
            AppMethodBeat.o(77331);
        }

        public final void f(Bitmap bitmap) {
            AppMethodBeat.i(77332);
            ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", bitmap);
            if (bitmap != null) {
                bitmap.isRecycled();
            }
            AppMethodBeat.o(77332);
        }
    }

    static final class d {
        private final ak fqr;
        final Map<String, List<a>> fqs;
        final Map<String, Boolean> fqt;

        interface a {
            void abV();

            void abW();
        }

        /* synthetic */ d(ak akVar, byte b) {
            this(akVar);
        }

        private d(ak akVar) {
            AppMethodBeat.i(77333);
            this.fqs = new HashMap();
            this.fqt = new HashMap();
            this.fqr = akVar;
            AppMethodBeat.o(77333);
        }

        /* Access modifiers changed, original: final */
        public final void pJ(String str) {
            AppMethodBeat.i(77334);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77334);
                return;
            }
            List<a> list = (List) this.fqs.remove(str);
            if (bo.ek(list)) {
                AppMethodBeat.o(77334);
                return;
            }
            for (a abV : list) {
                abV.abV();
            }
            AppMethodBeat.o(77334);
        }

        /* Access modifiers changed, original: final */
        public final boolean pK(String str) {
            AppMethodBeat.i(77335);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77335);
                return false;
            }
            boolean containsKey = this.fqt.containsKey(str);
            AppMethodBeat.o(77335);
            return containsKey;
        }

        /* Access modifiers changed, original: final */
        public final void pL(String str) {
            AppMethodBeat.i(77336);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77336);
                return;
            }
            this.fqt.remove(str);
            AppMethodBeat.o(77336);
        }

        /* Access modifiers changed, original: final */
        public final void a(String str, a aVar) {
            AppMethodBeat.i(77337);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77337);
                return;
            }
            List list = (List) this.fqs.get(str);
            if (list == null) {
                AppMethodBeat.o(77337);
                return;
            }
            list.remove(aVar);
            AppMethodBeat.o(77337);
        }

        /* Access modifiers changed, original: final */
        public final void pM(String str) {
            AppMethodBeat.i(77338);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77338);
                return;
            }
            List<a> list = (List) this.fqs.remove(str);
            if (!bo.ek(list)) {
                for (a abW : list) {
                    abW.abW();
                }
                list.clear();
            }
            AppMethodBeat.o(77338);
        }

        /* Access modifiers changed, original: final */
        public final void f(Runnable runnable) {
            AppMethodBeat.i(77339);
            this.fqr.post(runnable);
            AppMethodBeat.o(77339);
        }
    }

    public static class b implements i {
        public final void abU() {
        }

        public void x(Bitmap bitmap) {
        }

        public final void mr() {
        }

        public final String wP() {
            return "DefaultLoadTarget";
        }
    }

    static final class m {
        static final b fqG = new b();

        static {
            AppMethodBeat.i(77360);
            AppMethodBeat.o(77360);
        }
    }

    public interface e extends c {
        Bitmap v(InputStream inputStream);
    }

    public interface g {
        InputStream openRead(String str);

        OutputStream pH(String str);

        boolean pI(String str);
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$3 */
    public class AnonymousClass3 implements i {
        final /* synthetic */ h fqk;
        final /* synthetic */ String val$url;

        public AnonymousClass3(String str, h hVar) {
            this.val$url = str;
            this.fqk = hVar;
        }

        public final void abU() {
        }

        public final void x(Bitmap bitmap) {
            AppMethodBeat.i(77318);
            com.tencent.mm.plugin.appbrand.r.m.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(77317);
                    byte[] a = b.a(b.this, AnonymousClass3.this.val$url);
                    if (AnonymousClass3.this.fqk != null) {
                        AnonymousClass3.this.fqk.Q(a);
                    }
                    AppMethodBeat.o(77317);
                }
            });
            AppMethodBeat.o(77318);
        }

        public final void mr() {
            AppMethodBeat.i(77319);
            if (this.fqk != null) {
                this.fqk.Q(null);
            }
            AppMethodBeat.o(77319);
        }

        public final String wP() {
            return "BytesLoadTarget";
        }
    }

    public interface h {
        void Q(byte[] bArr);
    }

    public interface f extends c {
        String wP();

        Bitmap y(Bitmap bitmap);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    static /* synthetic */ String as(String str, String str2) {
        AppMethodBeat.i(77377);
        String ar = ar(str, str2);
        AppMethodBeat.o(77377);
        return ar;
    }

    static /* synthetic */ String b(String str, f fVar, e eVar) {
        AppMethodBeat.i(77378);
        String a = a(str, fVar, eVar);
        AppMethodBeat.o(77378);
        return a;
    }

    static /* synthetic */ String pG(String str) {
        AppMethodBeat.i(77379);
        String pE = pE(str);
        AppMethodBeat.o(77379);
        return pE;
    }

    public static b abR() {
        return m.fqG;
    }

    private b() {
        AppMethodBeat.i(77361);
        this.fpZ = new ConcurrentHashMap();
        this.fqa = new ConcurrentHashMap();
        this.fqb = new ConcurrentHashMap();
        this.fqd = new c();
        this.fqe = new a();
        this.fqc = new d(new ak(new al("AppBrandSimpleImageLoaderDiskIOHandlerThread").oAl.getLooper()), (byte) 0);
        AppMethodBeat.o(77361);
    }

    private void e(ImageView imageView) {
        AppMethodBeat.i(77362);
        if (imageView == null) {
            AppMethodBeat.o(77362);
            return;
        }
        String str = (String) this.fqb.get(Integer.valueOf(imageView.hashCode()));
        if (str == null) {
            AppMethodBeat.o(77362);
            return;
        }
        i iVar = (i) this.fqa.get(str);
        if (iVar == null) {
            AppMethodBeat.o(77362);
            return;
        }
        str = (String) this.fpZ.get(iVar);
        if (!bo.isNullOrNil(str)) {
            this.fqa.remove(str);
        }
        AppMethodBeat.o(77362);
    }

    public final Bitmap pB(String str) {
        AppMethodBeat.i(77363);
        Bitmap kR = this.fqd.kR(str);
        if (kR == null || kR.isRecycled()) {
            AppMethodBeat.o(77363);
            return null;
        }
        AppMethodBeat.o(77363);
        return kR;
    }

    public final Bitmap a(String str, e eVar) {
        Closeable openRead;
        Throwable e;
        AppMethodBeat.i(77364);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77364);
            return null;
        }
        String a = a(str, null, eVar);
        Bitmap kR = this.fqd.kR(a);
        if (kR != null) {
            AppMethodBeat.o(77364);
            return kR;
        }
        try {
            if (str.startsWith("file://")) {
                try {
                    openRead = com.tencent.mm.vfs.e.openRead(str);
                } catch (FileNotFoundException e2) {
                    ab.e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    bo.b(null);
                    AppMethodBeat.o(77364);
                    return null;
                }
            }
            openRead = this.fqe.openRead(pE(str));
            if (eVar != null) {
                try {
                    kR = eVar.v(openRead);
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                kR = com.tencent.mm.sdk.platformtools.d.decodeStream(openRead);
            }
            if (kR != null) {
                this.fqd.c(a, kR);
            }
            bo.b(openRead);
            AppMethodBeat.o(77364);
            return kR;
        } catch (Exception e4) {
            e = e4;
            openRead = null;
        } catch (Throwable th) {
            e = th;
            openRead = null;
            bo.b(openRead);
            AppMethodBeat.o(77364);
            throw e;
        }
        try {
            ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
            bo.b(openRead);
            AppMethodBeat.o(77364);
            return null;
        } catch (Throwable th2) {
            e = th2;
            bo.b(openRead);
            AppMethodBeat.o(77364);
            throw e;
        }
    }

    public final String pC(String str) {
        AppMethodBeat.i(77365);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77365);
            return null;
        }
        String a = a(new b(), str, null);
        AppMethodBeat.o(77365);
        return a;
    }

    public final String a(i iVar, String str, f fVar, e eVar) {
        String str2 = null;
        AppMethodBeat.i(77366);
        if (iVar == null) {
            AppMethodBeat.o(77366);
        } else if (bo.isNullOrNil(str)) {
            iVar.mr();
            AppMethodBeat.o(77366);
        } else {
            ab.d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", str);
            l lVar = new l(str, fVar, this, this.fqd, this.fqe, eVar, iVar.wP(), (byte) 0);
            str2 = lVar.abZ();
            final i iVar2 = iVar;
            final String str3 = str;
            final l lVar2 = lVar;
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(77315);
                    Bitmap pB = b.this.pB(str2);
                    if (pB != null) {
                        iVar2.x(pB);
                        ab.d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", str3, pB);
                        AppMethodBeat.o(77315);
                        return;
                    }
                    String abY = lVar2.abY();
                    b.this.fpZ.put(iVar2, abY);
                    b.this.fqa.put(abY, iVar2);
                    iVar2.abU();
                    l lVar = lVar2;
                    lVar.fqu.fqc.f(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(77346);
                            l.this.abV();
                            AppMethodBeat.o(77346);
                        }
                    });
                    AppMethodBeat.o(77315);
                }
            };
            if (al.isMainThread()) {
                anonymousClass1.run();
            } else {
                al.d(anonymousClass1);
            }
            AppMethodBeat.o(77366);
        }
        return str2;
    }

    public final String a(i iVar, String str, f fVar) {
        AppMethodBeat.i(77367);
        String a = a(iVar, str, fVar, null);
        AppMethodBeat.o(77367);
        return a;
    }

    public final String a(ImageView imageView, String str, int i, f fVar) {
        AppMethodBeat.i(77368);
        if (imageView == null) {
            AppMethodBeat.o(77368);
            return null;
        }
        String a = a(imageView, str, imageView.getContext().getResources().getDrawable(i), fVar);
        AppMethodBeat.o(77368);
        return a;
    }

    public final String a(ImageView imageView, String str, Drawable drawable, f fVar) {
        AppMethodBeat.i(77369);
        String a = a(imageView, str, drawable, fVar, null);
        AppMethodBeat.o(77369);
        return a;
    }

    public final String a(ImageView imageView, String str, final Drawable drawable, f fVar, e eVar) {
        String str2 = null;
        AppMethodBeat.i(77370);
        if (imageView == null) {
            AppMethodBeat.o(77370);
        } else {
            e(imageView);
            if (bo.isNullOrNil(str)) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
                AppMethodBeat.o(77370);
            } else {
                i anonymousClass2 = new k(imageView, this) {
                    public final void abU() {
                        AppMethodBeat.i(77316);
                        if (!(getImageView() == null || drawable == null)) {
                            getImageView().setImageDrawable(drawable);
                        }
                        AppMethodBeat.o(77316);
                    }
                };
                str2 = a(anonymousClass2, str, fVar, eVar);
                if (!anonymousClass2.fqv) {
                    this.fqb.put(Integer.valueOf(imageView.hashCode()), ar(anonymousClass2.key, str2));
                }
                AppMethodBeat.o(77370);
            }
        }
        return str2;
    }

    public final byte[] pD(String str) {
        Throwable e;
        byte[] bArr = null;
        AppMethodBeat.i(77371);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77371);
        } else {
            Closeable openRead;
            try {
                if (str.startsWith("file://")) {
                    try {
                        openRead = com.tencent.mm.vfs.e.openRead(str);
                    } catch (FileNotFoundException e2) {
                        ab.e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                        bo.b(bArr);
                        AppMethodBeat.o(77371);
                    }
                } else {
                    openRead = this.fqe.openRead(pE(str));
                }
                try {
                    bArr = com.tencent.luggage.g.i.k(openRead);
                    bo.b(openRead);
                    AppMethodBeat.o(77371);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
                        bo.b(openRead);
                        AppMethodBeat.o(77371);
                        return bArr;
                    } catch (Throwable th) {
                        e = th;
                        bo.b(openRead);
                        AppMethodBeat.o(77371);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                openRead = bArr;
            } catch (Throwable th2) {
                e = th2;
                openRead = bArr;
                bo.b(openRead);
                AppMethodBeat.o(77371);
                throw e;
            }
        }
        return bArr;
    }

    private static String ar(String str, String str2) {
        AppMethodBeat.i(77372);
        String str3 = str + str2;
        AppMethodBeat.o(77372);
        return str3;
    }

    private static String a(String str, f fVar, e eVar) {
        AppMethodBeat.i(77373);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (fVar != null) {
            stringBuilder.append("|transformation:");
            stringBuilder.append(fVar.wP());
        }
        if (eVar != null) {
            stringBuilder.append("|decoder:");
            stringBuilder.append(eVar.wP());
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(77373);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.i(77381);
        String str = com.tencent.mm.compatible.util.e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        fqf = str;
        com.tencent.mm.vfs.e.tf(str);
        AppMethodBeat.o(77381);
    }

    private static String pE(String str) {
        AppMethodBeat.i(77374);
        String str2 = null;
        if (!bo.isNullOrNil(str)) {
            str2 = com.tencent.mm.a.g.x(str.getBytes());
        }
        AppMethodBeat.o(77374);
        return str2;
    }

    public final void pF(String str) {
        AppMethodBeat.i(77375);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77375);
            return;
        }
        String pE = pE(str);
        if (this.fqc.pK(pE)) {
            AppMethodBeat.o(77375);
            return;
        }
        this.fqe.pI(pE);
        AppMethodBeat.o(77375);
    }

    static /* synthetic */ boolean abT() {
        AppMethodBeat.i(77380);
        boolean Mn = com.tencent.mm.compatible.util.f.Mn();
        AppMethodBeat.o(77380);
        return Mn;
    }
}
