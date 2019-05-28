package com.tencent.p177mm.modelappbrand.p873a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p058a.C44956a;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.modelappbrand.p873a.C42197d.C37933b;
import com.tencent.p177mm.modelappbrand.p873a.C42197d.C42198c;
import com.tencent.p177mm.modelappbrand.p873a.C42197d.C42199a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.modelappbrand.a.b */
public final class C37926b {
    private static final String fqf;
    private final Map<C9676i, String> fpZ;
    private final Map<String, C9676i> fqa;
    private final Map<Integer, String> fqb;
    private final C18648d fqc;
    private final C9677j fqd;
    private final C37925g fqe;

    /* renamed from: com.tencent.mm.modelappbrand.a.b$i */
    public interface C9676i extends C45442c {
        void abU();

        /* renamed from: mr */
        void mo6522mr();

        /* renamed from: wP */
        String mo6523wP();

        /* renamed from: x */
        void mo6524x(Bitmap bitmap);
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$j */
    public interface C9677j {
        /* renamed from: c */
        void mo20995c(String str, Bitmap bitmap);

        /* renamed from: f */
        void mo20996f(Bitmap bitmap);

        /* renamed from: kR */
        Bitmap mo20997kR(String str);
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$l */
    static final class C9680l implements C18649a {
        private final String fqA;
        boolean fqB;
        final C37925g fqe;
        final C37926b fqu;
        final String fqw;
        private final C37932f fqx;
        private final C9677j fqy;
        private final C37924e fqz;

        /* renamed from: com.tencent.mm.modelappbrand.a.b$l$2 */
        class C96812 implements Runnable {
            C96812() {
            }

            public final void run() {
                AppMethodBeat.m2504i(77346);
                C9680l.this.abV();
                AppMethodBeat.m2505o(77346);
            }
        }

        /* renamed from: com.tencent.mm.modelappbrand.a.b$l$4 */
        class C96834 implements Runnable {

            /* renamed from: com.tencent.mm.modelappbrand.a.b$l$4$1 */
            class C96791 implements Runnable {
                C96791() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(77348);
                    C9680l.this.fqB = false;
                    C9680l.this.aca();
                    AppMethodBeat.m2505o(77348);
                }
            }

            C96834() {
            }

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
                AppMethodBeat.m2504i(77349);
                C9680l c9680l = C9680l.this;
                HttpURLConnection httpURLConnection;
                Closeable pH;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(c9680l.fqw).openConnection();
                    try {
                        if (httpURLConnection2.getResponseCode() == 301 || httpURLConnection2.getResponseCode() == 302) {
                            String headerField = httpURLConnection2.getHeaderField("Location");
                            if (URLUtil.isAboutUrl(headerField) || !URLUtil.isNetworkUrl(headerField)) {
                                MalformedURLException malformedURLException = new MalformedURLException(String.format("Origin %s, Location %s", new Object[]{c9680l.fqw, headerField}));
                                AppMethodBeat.m2505o(77349);
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
                            pH = c9680l.fqe.mo33900pH(C37926b.m64097pG(c9680l.fqw));
                            if (pH == null) {
                                C5046bo.m7527b(pH);
                                C5046bo.m7527b(null);
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
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", c9680l.fqw);
                                        c9680l.fqe.mo33901pI(C37926b.m64097pG(c9680l.fqw));
                                        C5046bo.m7527b(pH);
                                        C5046bo.m7527b(bufferedInputStream);
                                        if (httpURLConnection != null) {
                                        }
                                        C9680l.this.fqu.fqc.mo33904f(new C96791());
                                        AppMethodBeat.m2505o(77349);
                                    } catch (Throwable e22) {
                                        e = e22;
                                        C5046bo.m7527b(pH);
                                        C5046bo.m7527b(bufferedInputStream);
                                        if (httpURLConnection != null) {
                                        }
                                        AppMethodBeat.m2505o(77349);
                                        throw e;
                                    }
                                } catch (Throwable e222) {
                                    e = e222;
                                    bufferedInputStream = null;
                                    C5046bo.m7527b(pH);
                                    C5046bo.m7527b(bufferedInputStream);
                                    if (httpURLConnection != null) {
                                    }
                                    AppMethodBeat.m2505o(77349);
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
                                    C5046bo.m7527b(pH);
                                    C5046bo.m7527b(bufferedInputStream);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } catch (Exception e2222) {
                                    e = e2222;
                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", c9680l.fqw);
                                    c9680l.fqe.mo33901pI(C37926b.m64097pG(c9680l.fqw));
                                    C5046bo.m7527b(pH);
                                    C5046bo.m7527b(bufferedInputStream);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    C9680l.this.fqu.fqc.mo33904f(new C96791());
                                    AppMethodBeat.m2505o(77349);
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
                            C5046bo.m7527b(pH);
                            C5046bo.m7527b(bufferedInputStream);
                            if (httpURLConnection != null) {
                            }
                            AppMethodBeat.m2505o(77349);
                            throw e;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        httpURLConnection = httpURLConnection2;
                        pH = null;
                        bufferedInputStream = null;
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", c9680l.fqw);
                        c9680l.fqe.mo33901pI(C37926b.m64097pG(c9680l.fqw));
                        C5046bo.m7527b(pH);
                        C5046bo.m7527b(bufferedInputStream);
                        if (httpURLConnection != null) {
                        }
                        C9680l.this.fqu.fqc.mo33904f(new C96791());
                        AppMethodBeat.m2505o(77349);
                    } catch (Throwable th2) {
                        e = th2;
                        httpURLConnection = httpURLConnection2;
                        pH = null;
                        bufferedInputStream = null;
                        C5046bo.m7527b(pH);
                        C5046bo.m7527b(bufferedInputStream);
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.m2505o(77349);
                        throw e;
                    }
                } catch (Exception e2222222) {
                    e = e2222222;
                    httpURLConnection = null;
                    pH = null;
                    bufferedInputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", c9680l.fqw);
                    c9680l.fqe.mo33901pI(C37926b.m64097pG(c9680l.fqw));
                    C5046bo.m7527b(pH);
                    C5046bo.m7527b(bufferedInputStream);
                    if (httpURLConnection != null) {
                    }
                    C9680l.this.fqu.fqc.mo33904f(new C96791());
                    AppMethodBeat.m2505o(77349);
                } catch (Throwable e22222222) {
                    e = e22222222;
                    httpURLConnection = null;
                    pH = null;
                    bufferedInputStream = null;
                    C5046bo.m7527b(pH);
                    C5046bo.m7527b(bufferedInputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(77349);
                    throw e;
                }
                C9680l.this.fqu.fqc.mo33904f(new C96791());
                AppMethodBeat.m2505o(77349);
            }
        }

        /* synthetic */ C9680l(String str, C37932f c37932f, C37926b c37926b, C9677j c9677j, C37925g c37925g, C37924e c37924e, String str2, byte b) {
            this(str, c37932f, c37926b, c9677j, c37925g, c37924e, str2);
        }

        private C9680l(String str, C37932f c37932f, C37926b c37926b, C9677j c9677j, C37925g c37925g, C37924e c37924e, String str2) {
            this.fqB = true;
            this.fqw = str;
            this.fqx = c37932f;
            this.fqu = c37926b;
            this.fqy = c9677j;
            this.fqe = c37925g;
            this.fqz = c37924e;
            this.fqA = str2;
        }

        /* Access modifiers changed, original: final */
        public final String abY() {
            AppMethodBeat.m2504i(77350);
            String as = C37926b.m64089as(this.fqA, abZ());
            AppMethodBeat.m2505o(77350);
            return as;
        }

        /* Access modifiers changed, original: final */
        public final String abZ() {
            AppMethodBeat.m2504i(77351);
            String b = C37926b.m64090b(this.fqw, this.fqx, this.fqz);
            AppMethodBeat.m2505o(77351);
            return b;
        }

        /* Access modifiers changed, original: final */
        public final void aca() {
            AppMethodBeat.m2504i(77352);
            try {
                Bitmap acb = acb();
                if (!(acb == null || acb.isRecycled())) {
                    this.fqu.fqc.mo33907pL(C37926b.m64097pG(this.fqw));
                    this.fqu.fqc.mo33903a(C37926b.m64097pG(this.fqw), this);
                    m17248A(acb);
                    this.fqu.fqc.mo33905pJ(C37926b.m64097pG(this.fqw));
                }
                AppMethodBeat.m2505o(77352);
            } catch (C42197d e) {
                C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", e);
                this.fqu.fqc.mo33907pL(C37926b.m64097pG(this.fqw));
                this.fqu.fqc.mo33908pM(C37926b.m64097pG(this.fqw));
                m17248A(null);
                if (e instanceof C42199a) {
                    this.fqu.fqe.mo33901pI(C37926b.m64097pG(this.fqw));
                }
                AppMethodBeat.m2505o(77352);
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " doIOJobImpl, io exp ", new Object[0]);
                this.fqu.fqc.mo33907pL(C37926b.m64097pG(this.fqw));
                this.fqu.fqc.mo33903a(C37926b.m64097pG(this.fqw), this);
                this.fqu.fqc.mo33905pJ(C37926b.m64097pG(this.fqw));
                AppMethodBeat.m2505o(77352);
            }
        }

        public final void abV() {
            AppMethodBeat.m2504i(77353);
            final Bitmap kR = this.fqy.mo20997kR(abZ());
            if (kR != null && !kR.isRecycled()) {
                C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", abZ());
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(77345);
                        C9680l.this.mo21005x(kR);
                        AppMethodBeat.m2505o(77345);
                    }
                });
                AppMethodBeat.m2505o(77353);
            } else if (this.fqu.fqc.mo33906pK(C37926b.m64097pG(this.fqw))) {
                C18648d d = this.fqu.fqc;
                String pG = C37926b.m64097pG(this.fqw);
                if (!C5046bo.isNullOrNil(pG)) {
                    List list = (List) d.fqs.get(pG);
                    if (list == null) {
                        list = new LinkedList();
                        d.fqs.put(pG, list);
                    }
                    list.add(this);
                }
                C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", C37926b.m64097pG(this.fqw));
                AppMethodBeat.m2505o(77353);
            } else {
                C18648d d2 = this.fqu.fqc;
                String pG2 = C37926b.m64097pG(this.fqw);
                if (!C5046bo.isNullOrNil(pG2)) {
                    d2.fqt.put(pG2, Boolean.TRUE);
                }
                aca();
                AppMethodBeat.m2505o(77353);
            }
        }

        public final void abW() {
            AppMethodBeat.m2504i(77354);
            C9676i c9676i = (C9676i) this.fqu.fqa.remove(abY());
            if (c9676i != null) {
                this.fqu.fpZ.remove(c9676i);
            }
            AppMethodBeat.m2505o(77354);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: x */
        public final void mo21005x(Bitmap bitmap) {
            AppMethodBeat.m2504i(77355);
            C9676i c9676i = (C9676i) this.fqu.fqa.remove(abY());
            if (c9676i != null) {
                c9676i.mo6524x(bitmap);
                this.fqu.fpZ.remove(c9676i);
            }
            AppMethodBeat.m2505o(77355);
        }

        /* renamed from: z */
        private Bitmap m17250z(Bitmap bitmap) {
            AppMethodBeat.m2504i(77356);
            Bitmap y = this.fqx.mo22474y(bitmap);
            AppMethodBeat.m2505o(77356);
            return y;
        }

        /* renamed from: A */
        private void m17248A(Bitmap bitmap) {
            boolean z = false;
            AppMethodBeat.m2504i(77357);
            String str = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            String str2 = "postLoadInWorkerThread bitmap ok %b";
            Object[] objArr = new Object[1];
            boolean z2 = (bitmap == null || bitmap.isRecycled()) ? false : true;
            objArr[0] = Boolean.valueOf(z2);
            C4990ab.m7411d(str, str2, objArr);
            if (!(this.fqx == null || bitmap == null || bitmap.isRecycled())) {
                Bitmap z3 = m17250z(bitmap);
                C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", bitmap, z3);
                if (z3 != bitmap) {
                    this.fqy.mo20996f(bitmap);
                }
                bitmap = z3;
            }
            this.fqy.mo20995c(abZ(), bitmap);
            String str3 = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            str = "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b";
            Object[] objArr2 = new Object[2];
            objArr2[0] = bitmap;
            if (!(bitmap == null || bitmap.isRecycled())) {
                z = true;
            }
            objArr2[1] = Boolean.valueOf(z);
            C4990ab.m7411d(str3, str, objArr2);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(77347);
                    C9680l c9680l = C9680l.this;
                    Bitmap bitmap = bitmap;
                    if (bitmap == null || bitmap.isRecycled()) {
                        C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", bitmap);
                        C9676i c9676i = (C9676i) c9680l.fqu.fqa.remove(c9680l.abY());
                        if (c9676i != null) {
                            c9676i.mo6522mr();
                            c9680l.fqu.fpZ.remove(c9676i);
                        }
                        AppMethodBeat.m2505o(77347);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", bitmap);
                    c9680l.mo21005x(bitmap);
                    AppMethodBeat.m2505o(77347);
                }
            });
            AppMethodBeat.m2505o(77357);
        }

        private Bitmap acb() {
            Bitmap bitmap = null;
            AppMethodBeat.m2504i(77358);
            if (C37926b.abT()) {
                InputStream openRead;
                if (this.fqw.startsWith("file://") || this.fqw.startsWith("wcf://")) {
                    try {
                        openRead = C5730e.openRead(this.fqw);
                    } catch (FileNotFoundException e) {
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "load from local file %s", this.fqw);
                        AppMethodBeat.m2505o(77358);
                    }
                } else {
                    openRead = this.fqe.openRead(C37926b.m64097pG(this.fqw));
                    if (openRead == null) {
                        C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", Boolean.valueOf(this.fqB));
                        if (this.fqB) {
                            C7305d.post(new C96834(), "AppBrandSimpleImageLoaderDownloadThread");
                        } else {
                            this.fqu.fqc.mo33908pM(C37926b.m64097pG(this.fqw));
                            this.fqu.fqc.mo33907pL(C37926b.m64097pG(this.fqw));
                            C37933b c37933b = new C37933b();
                            AppMethodBeat.m2505o(77358);
                            throw c37933b;
                        }
                    }
                }
                if (openRead != null) {
                    try {
                        bitmap = m17249w(openRead);
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " decode ", new Object[0]);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", bitmap);
                        C42199a c42199a = new C42199a();
                        AppMethodBeat.m2505o(77358);
                        throw c42199a;
                    }
                    C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", bitmap, Integer.valueOf(C44956a.m82246c(bitmap) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), this.fqw);
                    AppMethodBeat.m2505o(77358);
                } else {
                    AppMethodBeat.m2505o(77358);
                }
                return bitmap;
            }
            C4990ab.m7410d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
            C42198c c42198c = new C42198c();
            AppMethodBeat.m2505o(77358);
            throw c42198c;
        }

        /* renamed from: w */
        private Bitmap m17249w(InputStream inputStream) {
            AppMethodBeat.m2504i(77359);
            try {
                Bitmap v;
                if (this.fqz != null) {
                    v = this.fqz.mo34970v(inputStream);
                } else {
                    v = C5056d.decodeStream(inputStream);
                    C5046bo.m7527b(inputStream);
                    AppMethodBeat.m2505o(77359);
                }
                return v;
            } finally {
                C5046bo.m7527b(inputStream);
                AppMethodBeat.m2505o(77359);
            }
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$k */
    static class C16541k implements C9676i {
        private final WeakReference<ImageView> aIp;
        private final C37926b fqu;
        boolean fqv;
        final String key;

        /* synthetic */ C16541k(ImageView imageView, C37926b c37926b, byte b) {
            this(imageView, c37926b);
        }

        /* Access modifiers changed, original: final */
        public final ImageView getImageView() {
            AppMethodBeat.m2504i(77340);
            ImageView imageView = (ImageView) this.aIp.get();
            AppMethodBeat.m2505o(77340);
            return imageView;
        }

        private C16541k(ImageView imageView, C37926b c37926b) {
            AppMethodBeat.m2504i(77341);
            this.fqv = false;
            this.aIp = new WeakReference(imageView);
            this.fqu = c37926b;
            this.key = "ImageView#" + imageView.hashCode();
            AppMethodBeat.m2505o(77341);
        }

        private void abX() {
            AppMethodBeat.m2504i(77342);
            if (this.aIp.get() != null) {
                this.fqu.fqb.remove(Integer.valueOf(((ImageView) this.aIp.get()).hashCode()));
            }
            AppMethodBeat.m2505o(77342);
        }

        public void abU() {
        }

        /* renamed from: x */
        public final void mo6524x(Bitmap bitmap) {
            AppMethodBeat.m2504i(77343);
            abX();
            ImageView imageView = (ImageView) this.aIp.get();
            if (imageView != null) {
                if (!C5004al.isMainThread()) {
                    C4990ab.m7408b("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
                }
                imageView.setImageDrawable(new C42200e(imageView.getResources(), bitmap));
            }
            this.fqv = true;
            AppMethodBeat.m2505o(77343);
        }

        /* renamed from: mr */
        public final void mo6522mr() {
            AppMethodBeat.m2504i(77344);
            abX();
            AppMethodBeat.m2505o(77344);
        }

        /* renamed from: wP */
        public final String mo6523wP() {
            return this.key;
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$a */
    static final class C18645a implements C37925g {
        private C18645a() {
        }

        /* synthetic */ C18645a(byte b) {
            this();
        }

        /* renamed from: pH */
        public final OutputStream mo33900pH(String str) {
            AppMethodBeat.m2504i(77321);
            try {
                if (!(C5730e.m8643tf(C37926b.fqf) || new C5728b(C37926b.fqf).isDirectory())) {
                    C5730e.deleteFile(C37926b.fqf);
                    C5730e.m8643tf(C37926b.fqf);
                }
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", th);
            }
            String str2 = C37926b.fqf + str;
            final String str3 = str2 + ".wlock";
            C5730e.deleteFile(str3);
            C5730e.m8618N(str3, true);
            C5730e.m8624b(str3, new byte[1], 1);
            try {
                C5730e.deleteFile(str2);
                C5730e.m8618N(str2, true);
                C186461 c186461 = new BufferedOutputStream(C5730e.m8617L(str2, false)) {
                    public final synchronized void flush() {
                        AppMethodBeat.m2504i(77320);
                        super.flush();
                        C5730e.deleteFile(str3);
                        AppMethodBeat.m2505o(77320);
                    }
                };
                AppMethodBeat.m2505o(77321);
                return c186461;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openWrite fileName %s, parent exists[%b]", str, Boolean.valueOf(C5730e.m8628ct(C37926b.fqf)));
                AppMethodBeat.m2505o(77321);
                return null;
            }
        }

        public final InputStream openRead(String str) {
            InputStream inputStream = null;
            AppMethodBeat.m2504i(77322);
            String str2 = C37926b.fqf + str;
            if (C5730e.m8628ct(str2 + ".wlock")) {
                AppMethodBeat.m2505o(77322);
            } else {
                try {
                    inputStream = C5730e.openRead(str2);
                    AppMethodBeat.m2505o(77322);
                } catch (IOException e) {
                    C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", str, e);
                    AppMethodBeat.m2505o(77322);
                }
            }
            return inputStream;
        }

        /* renamed from: pI */
        public final boolean mo33901pI(String str) {
            AppMethodBeat.m2504i(77323);
            if (C5046bo.isNullOrNil(str) || !C1173e.deleteFile(C37926b.fqf + str)) {
                AppMethodBeat.m2505o(77323);
                return false;
            }
            AppMethodBeat.m2505o(77323);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$c */
    public static final class C18647c implements C9677j {
        final C1177f<String, Reference<Bitmap>> fqo = new C96751();

        /* renamed from: com.tencent.mm.modelappbrand.a.b$c$1 */
        class C96751 extends C6294h<String, Reference<Bitmap>> {
            private final Map<Reference<Bitmap>, Integer> fqp = new ConcurrentHashMap();

            C96751() {
                super(31457280);
                AppMethodBeat.m2504i(77324);
                AppMethodBeat.m2505o(77324);
            }

            public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                String str;
                AppMethodBeat.m2504i(77328);
                String str2 = (String) obj;
                Reference reference = (Reference) obj2;
                Reference reference2 = (Reference) obj3;
                String str3 = "MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache";
                String str4 = "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(C18647c.this.fqo.size() / 10);
                objArr[1] = Integer.valueOf(C18647c.this.fqo.maxSize() / 10);
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
                C4990ab.m7411d(str3, str4, objArr);
                super.entryRemoved(z, str2, reference, reference2);
                Bitmap bitmap = reference == null ? null : (Bitmap) reference.get();
                if (bitmap != (reference2 == null ? null : (Bitmap) reference2.get())) {
                    C18647c.this.mo20996f(bitmap);
                }
                this.fqp.remove(reference);
                AppMethodBeat.m2505o(77328);
            }

            public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                AppMethodBeat.m2504i(77327);
                Reference reference = (Reference) obj2;
                if (reference == null) {
                    AppMethodBeat.m2505o(77327);
                    return 0;
                }
                Integer num = (Integer) this.fqp.get(reference);
                if (num == null || num.intValue() < 0) {
                    int i;
                    Bitmap bitmap = (Bitmap) reference.get();
                    if (bitmap == null || bitmap.isRecycled()) {
                        i = 0;
                    } else {
                        i = C44956a.m82246c(bitmap);
                    }
                    this.fqp.put(reference, Integer.valueOf(i));
                    AppMethodBeat.m2505o(77327);
                    return i;
                }
                int intValue = num.intValue();
                AppMethodBeat.m2505o(77327);
                return intValue;
            }

            public final void clear() {
                AppMethodBeat.m2504i(77325);
                C4990ab.m7410d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
                super.clear();
                this.fqp.clear();
                AppMethodBeat.m2505o(77325);
            }

            /* renamed from: a */
            public final void mo4403a(C1174a<String, Reference<Bitmap>> c1174a) {
                AppMethodBeat.m2504i(77326);
                C4990ab.m7410d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
                super.mo4403a(c1174a);
                this.fqp.clear();
                AppMethodBeat.m2505o(77326);
            }
        }

        public C18647c() {
            AppMethodBeat.m2504i(77329);
            AppMethodBeat.m2505o(77329);
        }

        /* renamed from: kR */
        public final Bitmap mo20997kR(String str) {
            AppMethodBeat.m2504i(77330);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77330);
                return null;
            }
            Reference reference = (Reference) this.fqo.get(str);
            if (reference == null) {
                AppMethodBeat.m2505o(77330);
                return null;
            }
            Bitmap bitmap = (Bitmap) reference.get();
            if (bitmap == null || bitmap.isRecycled()) {
                this.fqo.remove(str);
                AppMethodBeat.m2505o(77330);
                return null;
            }
            AppMethodBeat.m2505o(77330);
            return bitmap;
        }

        /* renamed from: c */
        public final void mo20995c(String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(77331);
            if (C5046bo.isNullOrNil(str) || bitmap == null) {
                AppMethodBeat.m2505o(77331);
                return;
            }
            C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", str, bitmap);
            this.fqo.put(str, new SoftReference(bitmap));
            AppMethodBeat.m2505o(77331);
        }

        /* renamed from: f */
        public final void mo20996f(Bitmap bitmap) {
            AppMethodBeat.m2504i(77332);
            C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", bitmap);
            if (bitmap != null) {
                bitmap.isRecycled();
            }
            AppMethodBeat.m2505o(77332);
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$d */
    static final class C18648d {
        private final C7306ak fqr;
        final Map<String, List<C18649a>> fqs;
        final Map<String, Boolean> fqt;

        /* renamed from: com.tencent.mm.modelappbrand.a.b$d$a */
        interface C18649a {
            void abV();

            void abW();
        }

        /* synthetic */ C18648d(C7306ak c7306ak, byte b) {
            this(c7306ak);
        }

        private C18648d(C7306ak c7306ak) {
            AppMethodBeat.m2504i(77333);
            this.fqs = new HashMap();
            this.fqt = new HashMap();
            this.fqr = c7306ak;
            AppMethodBeat.m2505o(77333);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: pJ */
        public final void mo33905pJ(String str) {
            AppMethodBeat.m2504i(77334);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77334);
                return;
            }
            List<C18649a> list = (List) this.fqs.remove(str);
            if (C5046bo.m7548ek(list)) {
                AppMethodBeat.m2505o(77334);
                return;
            }
            for (C18649a abV : list) {
                abV.abV();
            }
            AppMethodBeat.m2505o(77334);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: pK */
        public final boolean mo33906pK(String str) {
            AppMethodBeat.m2504i(77335);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77335);
                return false;
            }
            boolean containsKey = this.fqt.containsKey(str);
            AppMethodBeat.m2505o(77335);
            return containsKey;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: pL */
        public final void mo33907pL(String str) {
            AppMethodBeat.m2504i(77336);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77336);
                return;
            }
            this.fqt.remove(str);
            AppMethodBeat.m2505o(77336);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo33903a(String str, C18649a c18649a) {
            AppMethodBeat.m2504i(77337);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77337);
                return;
            }
            List list = (List) this.fqs.get(str);
            if (list == null) {
                AppMethodBeat.m2505o(77337);
                return;
            }
            list.remove(c18649a);
            AppMethodBeat.m2505o(77337);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: pM */
        public final void mo33908pM(String str) {
            AppMethodBeat.m2504i(77338);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77338);
                return;
            }
            List<C18649a> list = (List) this.fqs.remove(str);
            if (!C5046bo.m7548ek(list)) {
                for (C18649a abW : list) {
                    abW.abW();
                }
                list.clear();
            }
            AppMethodBeat.m2505o(77338);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: f */
        public final void mo33904f(Runnable runnable) {
            AppMethodBeat.m2504i(77339);
            this.fqr.post(runnable);
            AppMethodBeat.m2505o(77339);
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$b */
    public static class C26433b implements C9676i {
        public final void abU() {
        }

        /* renamed from: x */
        public void mo6524x(Bitmap bitmap) {
        }

        /* renamed from: mr */
        public final void mo6522mr() {
        }

        /* renamed from: wP */
        public final String mo6523wP() {
            return "DefaultLoadTarget";
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$m */
    static final class C26434m {
        static final C37926b fqG = new C37926b();

        static {
            AppMethodBeat.m2504i(77360);
            AppMethodBeat.m2505o(77360);
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$e */
    public interface C37924e extends C45442c {
        /* renamed from: v */
        Bitmap mo34970v(InputStream inputStream);
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$g */
    public interface C37925g {
        InputStream openRead(String str);

        /* renamed from: pH */
        OutputStream mo33900pH(String str);

        /* renamed from: pI */
        boolean mo33901pI(String str);
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$3 */
    public class C379293 implements C9676i {
        final /* synthetic */ C37931h fqk;
        final /* synthetic */ String val$url;

        /* renamed from: com.tencent.mm.modelappbrand.a.b$3$1 */
        class C379301 implements Runnable {
            C379301() {
            }

            public final void run() {
                AppMethodBeat.m2504i(77317);
                byte[] a = C37926b.m64087a(C37926b.this, C379293.this.val$url);
                if (C379293.this.fqk != null) {
                    C379293.this.fqk.mo34800Q(a);
                }
                AppMethodBeat.m2505o(77317);
            }
        }

        public C379293(String str, C37931h c37931h) {
            this.val$url = str;
            this.fqk = c37931h;
        }

        public final void abU() {
        }

        /* renamed from: x */
        public final void mo6524x(Bitmap bitmap) {
            AppMethodBeat.m2504i(77318);
            C45673m.aNS().mo10302aa(new C379301());
            AppMethodBeat.m2505o(77318);
        }

        /* renamed from: mr */
        public final void mo6522mr() {
            AppMethodBeat.m2504i(77319);
            if (this.fqk != null) {
                this.fqk.mo34800Q(null);
            }
            AppMethodBeat.m2505o(77319);
        }

        /* renamed from: wP */
        public final String mo6523wP() {
            return "BytesLoadTarget";
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$h */
    public interface C37931h {
        /* renamed from: Q */
        void mo34800Q(byte[] bArr);
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$f */
    public interface C37932f extends C45442c {
        /* renamed from: wP */
        String mo6523wP();

        /* renamed from: y */
        Bitmap mo22474y(Bitmap bitmap);
    }

    /* synthetic */ C37926b(byte b) {
        this();
    }

    /* renamed from: as */
    static /* synthetic */ String m64089as(String str, String str2) {
        AppMethodBeat.m2504i(77377);
        String ar = C37926b.m64088ar(str, str2);
        AppMethodBeat.m2505o(77377);
        return ar;
    }

    /* renamed from: b */
    static /* synthetic */ String m64090b(String str, C37932f c37932f, C37924e c37924e) {
        AppMethodBeat.m2504i(77378);
        String a = C37926b.m64085a(str, c37932f, c37924e);
        AppMethodBeat.m2505o(77378);
        return a;
    }

    /* renamed from: pG */
    static /* synthetic */ String m64097pG(String str) {
        AppMethodBeat.m2504i(77379);
        String pE = C37926b.m64096pE(str);
        AppMethodBeat.m2505o(77379);
        return pE;
    }

    public static C37926b abR() {
        return C26434m.fqG;
    }

    private C37926b() {
        AppMethodBeat.m2504i(77361);
        this.fpZ = new ConcurrentHashMap();
        this.fqa = new ConcurrentHashMap();
        this.fqb = new ConcurrentHashMap();
        this.fqd = new C18647c();
        this.fqe = new C18645a();
        this.fqc = new C18648d(new C7306ak(new C5004al("AppBrandSimpleImageLoaderDiskIOHandlerThread").oAl.getLooper()), (byte) 0);
        AppMethodBeat.m2505o(77361);
    }

    /* renamed from: e */
    private void m64095e(ImageView imageView) {
        AppMethodBeat.m2504i(77362);
        if (imageView == null) {
            AppMethodBeat.m2505o(77362);
            return;
        }
        String str = (String) this.fqb.get(Integer.valueOf(imageView.hashCode()));
        if (str == null) {
            AppMethodBeat.m2505o(77362);
            return;
        }
        C9676i c9676i = (C9676i) this.fqa.get(str);
        if (c9676i == null) {
            AppMethodBeat.m2505o(77362);
            return;
        }
        str = (String) this.fpZ.get(c9676i);
        if (!C5046bo.isNullOrNil(str)) {
            this.fqa.remove(str);
        }
        AppMethodBeat.m2505o(77362);
    }

    /* renamed from: pB */
    public final Bitmap mo60687pB(String str) {
        AppMethodBeat.m2504i(77363);
        Bitmap kR = this.fqd.mo20997kR(str);
        if (kR == null || kR.isRecycled()) {
            AppMethodBeat.m2505o(77363);
            return null;
        }
        AppMethodBeat.m2505o(77363);
        return kR;
    }

    /* renamed from: a */
    public final Bitmap mo60681a(String str, C37924e c37924e) {
        Closeable openRead;
        Throwable e;
        AppMethodBeat.m2504i(77364);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77364);
            return null;
        }
        String a = C37926b.m64085a(str, null, c37924e);
        Bitmap kR = this.fqd.mo20997kR(a);
        if (kR != null) {
            AppMethodBeat.m2505o(77364);
            return kR;
        }
        try {
            if (str.startsWith("file://")) {
                try {
                    openRead = C5730e.openRead(str);
                } catch (FileNotFoundException e2) {
                    C4990ab.m7412e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    C5046bo.m7527b(null);
                    AppMethodBeat.m2505o(77364);
                    return null;
                }
            }
            openRead = this.fqe.openRead(C37926b.m64096pE(str));
            if (c37924e != null) {
                try {
                    kR = c37924e.mo34970v(openRead);
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                kR = C5056d.decodeStream(openRead);
            }
            if (kR != null) {
                this.fqd.mo20995c(a, kR);
            }
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(77364);
            return kR;
        } catch (Exception e4) {
            e = e4;
            openRead = null;
        } catch (Throwable th) {
            e = th;
            openRead = null;
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(77364);
            throw e;
        }
        try {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(77364);
            return null;
        } catch (Throwable th2) {
            e = th2;
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(77364);
            throw e;
        }
    }

    /* renamed from: pC */
    public final String mo60688pC(String str) {
        AppMethodBeat.m2504i(77365);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77365);
            return null;
        }
        String a = mo60685a(new C26433b(), str, null);
        AppMethodBeat.m2505o(77365);
        return a;
    }

    /* renamed from: a */
    public final String mo60686a(C9676i c9676i, String str, C37932f c37932f, C37924e c37924e) {
        String str2 = null;
        AppMethodBeat.m2504i(77366);
        if (c9676i == null) {
            AppMethodBeat.m2505o(77366);
        } else if (C5046bo.isNullOrNil(str)) {
            c9676i.mo6522mr();
            AppMethodBeat.m2505o(77366);
        } else {
            C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", str);
            C9680l c9680l = new C9680l(str, c37932f, this, this.fqd, this.fqe, c37924e, c9676i.mo6523wP(), (byte) 0);
            str2 = c9680l.abZ();
            final C9676i c9676i2 = c9676i;
            final String str3 = str;
            final C9680l c9680l2 = c9680l;
            C379271 c379271 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(77315);
                    Bitmap pB = C37926b.this.mo60687pB(str2);
                    if (pB != null) {
                        c9676i2.mo6524x(pB);
                        C4990ab.m7411d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", str3, pB);
                        AppMethodBeat.m2505o(77315);
                        return;
                    }
                    String abY = c9680l2.abY();
                    C37926b.this.fpZ.put(c9676i2, abY);
                    C37926b.this.fqa.put(abY, c9676i2);
                    c9676i2.abU();
                    C9680l c9680l = c9680l2;
                    c9680l.fqu.fqc.mo33904f(new C96812());
                    AppMethodBeat.m2505o(77315);
                }
            };
            if (C5004al.isMainThread()) {
                c379271.run();
            } else {
                C5004al.m7441d(c379271);
            }
            AppMethodBeat.m2505o(77366);
        }
        return str2;
    }

    /* renamed from: a */
    public final String mo60685a(C9676i c9676i, String str, C37932f c37932f) {
        AppMethodBeat.m2504i(77367);
        String a = mo60686a(c9676i, str, c37932f, null);
        AppMethodBeat.m2505o(77367);
        return a;
    }

    /* renamed from: a */
    public final String mo60682a(ImageView imageView, String str, int i, C37932f c37932f) {
        AppMethodBeat.m2504i(77368);
        if (imageView == null) {
            AppMethodBeat.m2505o(77368);
            return null;
        }
        String a = mo60683a(imageView, str, imageView.getContext().getResources().getDrawable(i), c37932f);
        AppMethodBeat.m2505o(77368);
        return a;
    }

    /* renamed from: a */
    public final String mo60683a(ImageView imageView, String str, Drawable drawable, C37932f c37932f) {
        AppMethodBeat.m2504i(77369);
        String a = mo60684a(imageView, str, drawable, c37932f, null);
        AppMethodBeat.m2505o(77369);
        return a;
    }

    /* renamed from: a */
    public final String mo60684a(ImageView imageView, String str, final Drawable drawable, C37932f c37932f, C37924e c37924e) {
        String str2 = null;
        AppMethodBeat.m2504i(77370);
        if (imageView == null) {
            AppMethodBeat.m2505o(77370);
        } else {
            m64095e(imageView);
            if (C5046bo.isNullOrNil(str)) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
                AppMethodBeat.m2505o(77370);
            } else {
                C9676i c379282 = new C16541k(imageView, this) {
                    public final void abU() {
                        AppMethodBeat.m2504i(77316);
                        if (!(getImageView() == null || drawable == null)) {
                            getImageView().setImageDrawable(drawable);
                        }
                        AppMethodBeat.m2505o(77316);
                    }
                };
                str2 = mo60686a(c379282, str, c37932f, c37924e);
                if (!c379282.fqv) {
                    this.fqb.put(Integer.valueOf(imageView.hashCode()), C37926b.m64088ar(c379282.key, str2));
                }
                AppMethodBeat.m2505o(77370);
            }
        }
        return str2;
    }

    /* renamed from: pD */
    public final byte[] mo60689pD(String str) {
        Throwable e;
        byte[] bArr = null;
        AppMethodBeat.m2504i(77371);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77371);
        } else {
            Closeable openRead;
            try {
                if (str.startsWith("file://")) {
                    try {
                        openRead = C5730e.openRead(str);
                    } catch (FileNotFoundException e2) {
                        C4990ab.m7412e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                        C5046bo.m7527b(bArr);
                        AppMethodBeat.m2505o(77371);
                    }
                } else {
                    openRead = this.fqe.openRead(C37926b.m64096pE(str));
                }
                try {
                    bArr = C32192i.m52510k(openRead);
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(77371);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
                        C5046bo.m7527b(openRead);
                        AppMethodBeat.m2505o(77371);
                        return bArr;
                    } catch (Throwable th) {
                        e = th;
                        C5046bo.m7527b(openRead);
                        AppMethodBeat.m2505o(77371);
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                openRead = bArr;
            } catch (Throwable th2) {
                e = th2;
                openRead = bArr;
                C5046bo.m7527b(openRead);
                AppMethodBeat.m2505o(77371);
                throw e;
            }
        }
        return bArr;
    }

    /* renamed from: ar */
    private static String m64088ar(String str, String str2) {
        AppMethodBeat.m2504i(77372);
        String str3 = str + str2;
        AppMethodBeat.m2505o(77372);
        return str3;
    }

    /* renamed from: a */
    private static String m64085a(String str, C37932f c37932f, C37924e c37924e) {
        AppMethodBeat.m2504i(77373);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (c37932f != null) {
            stringBuilder.append("|transformation:");
            stringBuilder.append(c37932f.mo6523wP());
        }
        if (c37924e != null) {
            stringBuilder.append("|decoder:");
            stringBuilder.append(c37924e.mo6523wP());
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(77373);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.m2504i(77381);
        String str = C6457e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        fqf = str;
        C5730e.m8643tf(str);
        AppMethodBeat.m2505o(77381);
    }

    /* renamed from: pE */
    private static String m64096pE(String str) {
        AppMethodBeat.m2504i(77374);
        String str2 = null;
        if (!C5046bo.isNullOrNil(str)) {
            str2 = C1178g.m2591x(str.getBytes());
        }
        AppMethodBeat.m2505o(77374);
        return str2;
    }

    /* renamed from: pF */
    public final void mo60690pF(String str) {
        AppMethodBeat.m2504i(77375);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77375);
            return;
        }
        String pE = C37926b.m64096pE(str);
        if (this.fqc.mo33906pK(pE)) {
            AppMethodBeat.m2505o(77375);
            return;
        }
        this.fqe.mo33901pI(pE);
        AppMethodBeat.m2505o(77375);
    }

    static /* synthetic */ boolean abT() {
        AppMethodBeat.m2504i(77380);
        boolean Mn = C1445f.m3070Mn();
        AppMethodBeat.m2505o(77380);
        return Mn;
    }
}
