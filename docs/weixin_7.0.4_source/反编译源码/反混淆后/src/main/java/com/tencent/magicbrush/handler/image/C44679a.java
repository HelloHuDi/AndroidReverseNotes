package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.C17841a;
import com.tencent.magicbrush.handler.image.IMBImageHandler.C25718a;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.magicbrush.p1456b.C32195a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.magicbrush.handler.image.a */
public final class C44679a implements IMBImageHandler {
    private MBRuntime bSv;
    private List<C32205d> bUb;
    private C32205d bUc;
    private boolean bUd = false;
    private ConcurrentLinkedQueue<String> bUe = null;
    public C32204a bUf = null;

    /* renamed from: com.tencent.magicbrush.handler.image.a$b */
    static class C1013b extends C32205d {
        public C1013b(IMBImageHandler iMBImageHandler) {
            super(iMBImageHandler);
        }

        /* renamed from: bZ */
        private static int m2282bZ(String str) {
            int i = 14;
            AppMethodBeat.m2504i(115963);
            if (str == null) {
                AppMethodBeat.m2505o(115963);
                return 0;
            } else if (str.startsWith("data:image/")) {
                if (str.startsWith("jpeg", 11)) {
                    i = 15;
                } else if (!(str.startsWith("png", 11) || str.startsWith("gif", 11))) {
                    AppMethodBeat.m2505o(115963);
                    return 0;
                }
                if (str.startsWith(";base64,", i)) {
                    i += 8;
                    AppMethodBeat.m2505o(115963);
                    return i;
                }
                AppMethodBeat.m2505o(115963);
                return 0;
            } else {
                AppMethodBeat.m2505o(115963);
                return 0;
            }
        }

        /* renamed from: ca */
        public final boolean mo4024ca(String str) {
            AppMethodBeat.m2504i(115964);
            if (C1013b.m2282bZ(str) > 0) {
                AppMethodBeat.m2505o(115964);
                return true;
            }
            AppMethodBeat.m2505o(115964);
            return false;
        }

        /* renamed from: cb */
        public final InputStream mo4025cb(String str) {
            AppMethodBeat.m2504i(115965);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str.substring(C1013b.m2282bZ(str)), 2));
            AppMethodBeat.m2505o(115965);
            return byteArrayInputStream;
        }
    }

    /* renamed from: com.tencent.magicbrush.handler.image.a$c */
    static class C1014c extends C32205d {
        public C1014c(IMBImageHandler iMBImageHandler) {
            super(iMBImageHandler);
        }

        /* renamed from: ca */
        public final boolean mo4024ca(String str) {
            AppMethodBeat.m2504i(115966);
            if (str == null || !(str.startsWith("http://") || str.startsWith("https://"))) {
                AppMethodBeat.m2505o(115966);
                return false;
            }
            AppMethodBeat.m2505o(115966);
            return true;
        }

        /* renamed from: cb */
        public final InputStream mo4025cb(String str) {
            InputStream bufferedInputStream;
            AppMethodBeat.m2504i(115967);
            try {
                bufferedInputStream = new BufferedInputStream(new URL(str).openStream());
            } catch (Exception e) {
                C17837c.m27915e("HttpDecoder", "fetch error failed. path = [%s], error = [%s]", str, e.toString());
                bufferedInputStream = null;
            }
            AppMethodBeat.m2505o(115967);
            return bufferedInputStream;
        }
    }

    /* renamed from: com.tencent.magicbrush.handler.image.a$a */
    public interface C32204a {
        /* renamed from: a */
        IBitmap mo44642a(String str, InputStream inputStream);

        void destroy();
    }

    /* renamed from: com.tencent.magicbrush.handler.image.a$d */
    public static abstract class C32205d {
        IMBImageHandler bUg;

        /* renamed from: ca */
        public abstract boolean mo4024ca(String str);

        /* renamed from: cb */
        public abstract InputStream mo4025cb(String str);

        public C32205d(IMBImageHandler iMBImageHandler) {
            this.bUg = iMBImageHandler;
        }
    }

    /* renamed from: com.tencent.magicbrush.handler.image.a$e */
    static class C37421e implements Runnable {
        private String bUh;
        private volatile boolean bUi = false;
        private WeakReference<MBRuntime> bUj;
        private WeakReference<C44679a> bUk;
        private final C31257a bUl = new C31257a();

        /* renamed from: com.tencent.magicbrush.handler.image.a$e$a */
        public static class C31257a implements C25718a {
            /* renamed from: ag */
            public final void mo43565ag(Object obj) {
                AppMethodBeat.m2504i(115968);
                if (obj != null) {
                    ((IBitmap) obj).recycle();
                }
                AppMethodBeat.m2505o(115968);
            }
        }

        C37421e(MBRuntime mBRuntime, C44679a c44679a, String str) {
            AppMethodBeat.m2504i(115969);
            this.bUh = str;
            this.bUj = new WeakReference(mBRuntime);
            this.bUk = new WeakReference(c44679a);
            AppMethodBeat.m2505o(115969);
        }

        public final void run() {
            AppMethodBeat.m2504i(115970);
            if (this.bUi) {
                AppMethodBeat.m2505o(115970);
            } else if (this.bUk.get() == null) {
                AppMethodBeat.m2505o(115970);
            } else {
                IBitmap loadBitmapSync = ((C44679a) this.bUk.get()).loadBitmapSync(this.bUh);
                if (this.bUi) {
                    if (loadBitmapSync != null) {
                        loadBitmapSync.recycle();
                    }
                    AppMethodBeat.m2505o(115970);
                    return;
                }
                MBRuntime mBRuntime = (MBRuntime) this.bUj.get();
                if (mBRuntime == null || this.bUi) {
                    if (loadBitmapSync != null) {
                        loadBitmapSync.recycle();
                    }
                    AppMethodBeat.m2505o(115970);
                    return;
                }
                mBRuntime.notifyImageDecoded(this.bUh, loadBitmapSync, this.bUl);
                AppMethodBeat.m2505o(115970);
            }
        }
    }

    public C44679a(MBRuntime mBRuntime, C17841a c17841a) {
        AppMethodBeat.m2504i(115971);
        if (c17841a == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DefaultImageHandlerImpl accept null parameter");
            AppMethodBeat.m2505o(115971);
            throw illegalArgumentException;
        }
        this.bSv = mBRuntime;
        this.bUb = new LinkedList();
        mo71705a(new C1014c(this), false);
        mo71705a(new C1013b(this), false);
        AppMethodBeat.m2505o(115971);
    }

    public final void init() {
    }

    public final void release() {
        AppMethodBeat.m2504i(115972);
        synchronized (this) {
            try {
                if (this.bUf != null) {
                    this.bUf.destroy();
                    this.bUf = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115972);
            }
        }
    }

    public final Bitmap getBitmap(int i, int i2) {
        AppMethodBeat.m2504i(115973);
        Bitmap bK = C32195a.m52520yJ().bUr.mo52851bK(i, i2);
        AppMethodBeat.m2505o(115973);
        return bK;
    }

    /* renamed from: fU */
    private static CompressFormat m81214fU(int i) {
        switch (i) {
            case 1:
                return CompressFormat.WEBP;
            case 2:
                return CompressFormat.JPEG;
            default:
                return CompressFormat.PNG;
        }
    }

    /* renamed from: Z */
    private static int m81213Z(float f) {
        if (f < 0.0f || f > 1.0f) {
            f = 0.92f;
        }
        return (int) (100.0f * f);
    }

    public final String encodeToBase64(Bitmap bitmap, int i, float f) {
        AppMethodBeat.m2504i(115974);
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(115974);
            return null;
        }
        CompressFormat fU = C44679a.m81214fU(i);
        int Z = C44679a.m81213Z(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean compress = bitmap.compress(fU, Z, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            C17837c.m27915e("MagicBrush.DefaultImageHandlerImpl", "base64_encode IOException e %s", e.toString());
            compress = false;
        }
        if (!compress || byteArrayOutputStream.size() <= 0) {
            C17837c.m27915e("MagicBrush.DefaultImageHandlerImpl", "base64_encode Bitmap compress error.", new Object[0]);
            AppMethodBeat.m2505o(115974);
            return null;
        }
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        AppMethodBeat.m2505o(115974);
        return encodeToString;
    }

    public final byte[] encodeToBuffer(Bitmap bitmap, int i, float f) {
        AppMethodBeat.m2504i(115975);
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(115975);
            return null;
        }
        CompressFormat fU = C44679a.m81214fU(i);
        int Z = C44679a.m81213Z(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean compress = bitmap.compress(fU, Z, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            C17837c.m27915e("MagicBrush.DefaultImageHandlerImpl", "encodeToBuffer IOException e %s", e.toString());
            compress = false;
        }
        if (!compress || byteArrayOutputStream.size() <= 0) {
            C17837c.m27915e("MagicBrush.DefaultImageHandlerImpl", "encodeToBuffer Bitmap compress error.", new Object[0]);
            AppMethodBeat.m2505o(115975);
            return null;
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(115975);
        return toByteArray;
    }

    public final void releaseBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(115976);
        if (bitmap == null) {
            AppMethodBeat.m2505o(115976);
            return;
        }
        C17837c.m27916i("MagicBrush.DefaultImageHandlerImpl", "recycle because releaseBitmap", new Object[0]);
        bitmap.recycle();
        AppMethodBeat.m2505o(115976);
    }

    public final IBitmap loadBitmapSync(String str) {
        AppMethodBeat.m2504i(115977);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(115977);
            return null;
        }
        C32205d c32205d;
        for (C32205d c32205d2 : this.bUb) {
            if (c32205d2.mo4024ca(str)) {
                break;
            }
        }
        C32205d c32205d22 = null;
        if (c32205d22 == null) {
            c32205d = this.bUc;
        } else {
            c32205d = c32205d22;
        }
        if (c32205d == null) {
            C17837c.m27915e("MagicBrush.DefaultImageHandlerImpl", "No fit decoder found for %s", str);
            AppMethodBeat.m2505o(115977);
            return null;
        }
        IBitmap a;
        try {
            synchronized (this) {
                if (this.bUd) {
                    if (this.bUe == null) {
                        this.bUe = new ConcurrentLinkedQueue();
                    }
                    this.bUe.add(str);
                }
            }
            InputStream cb = c32205d.mo4025cb(str);
            C32204a c32204a = ((C44679a) c32205d.bUg).bUf;
            a = c32204a == null ? null : c32204a.mo44642a(str, cb);
        } catch (Exception e) {
            C17837c.m27915e("MagicBrush.DefaultImageHandlerImpl", "ImageDecoder(%s) decode path[%s] error %s", c32205d, str, e.toString());
            a = null;
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(115977);
            }
        }
        AppMethodBeat.m2505o(115977);
        return a;
    }

    public final void loadBitmapAsync(String str) {
        AppMethodBeat.m2504i(115978);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(115978);
            return;
        }
        C37422b.bUm.bUo.execute(new C37421e(this.bSv, this, str));
        AppMethodBeat.m2505o(115978);
    }

    /* renamed from: a */
    public final void mo71705a(C32205d c32205d, boolean z) {
        AppMethodBeat.m2504i(115979);
        if (z) {
            this.bUc = c32205d;
            AppMethodBeat.m2505o(115979);
            return;
        }
        this.bUb.add(c32205d);
        AppMethodBeat.m2505o(115979);
    }
}
