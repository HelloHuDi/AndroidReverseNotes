package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.magicbrush.MBRuntime;
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

public final class a implements IMBImageHandler {
    private MBRuntime bSv;
    private List<d> bUb;
    private d bUc;
    private boolean bUd = false;
    private ConcurrentLinkedQueue<String> bUe = null;
    public a bUf = null;

    static class b extends d {
        public b(IMBImageHandler iMBImageHandler) {
            super(iMBImageHandler);
        }

        private static int bZ(String str) {
            int i = 14;
            AppMethodBeat.i(115963);
            if (str == null) {
                AppMethodBeat.o(115963);
                return 0;
            } else if (str.startsWith("data:image/")) {
                if (str.startsWith("jpeg", 11)) {
                    i = 15;
                } else if (!(str.startsWith("png", 11) || str.startsWith("gif", 11))) {
                    AppMethodBeat.o(115963);
                    return 0;
                }
                if (str.startsWith(";base64,", i)) {
                    i += 8;
                    AppMethodBeat.o(115963);
                    return i;
                }
                AppMethodBeat.o(115963);
                return 0;
            } else {
                AppMethodBeat.o(115963);
                return 0;
            }
        }

        public final boolean ca(String str) {
            AppMethodBeat.i(115964);
            if (bZ(str) > 0) {
                AppMethodBeat.o(115964);
                return true;
            }
            AppMethodBeat.o(115964);
            return false;
        }

        public final InputStream cb(String str) {
            AppMethodBeat.i(115965);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str.substring(bZ(str)), 2));
            AppMethodBeat.o(115965);
            return byteArrayInputStream;
        }
    }

    static class c extends d {
        public c(IMBImageHandler iMBImageHandler) {
            super(iMBImageHandler);
        }

        public final boolean ca(String str) {
            AppMethodBeat.i(115966);
            if (str == null || !(str.startsWith("http://") || str.startsWith("https://"))) {
                AppMethodBeat.o(115966);
                return false;
            }
            AppMethodBeat.o(115966);
            return true;
        }

        public final InputStream cb(String str) {
            InputStream bufferedInputStream;
            AppMethodBeat.i(115967);
            try {
                bufferedInputStream = new BufferedInputStream(new URL(str).openStream());
            } catch (Exception e) {
                com.tencent.magicbrush.a.c.c.e("HttpDecoder", "fetch error failed. path = [%s], error = [%s]", str, e.toString());
                bufferedInputStream = null;
            }
            AppMethodBeat.o(115967);
            return bufferedInputStream;
        }
    }

    public interface a {
        IBitmap a(String str, InputStream inputStream);

        void destroy();
    }

    public static abstract class d {
        IMBImageHandler bUg;

        public abstract boolean ca(String str);

        public abstract InputStream cb(String str);

        public d(IMBImageHandler iMBImageHandler) {
            this.bUg = iMBImageHandler;
        }
    }

    static class e implements Runnable {
        private String bUh;
        private volatile boolean bUi = false;
        private WeakReference<MBRuntime> bUj;
        private WeakReference<a> bUk;
        private final a bUl = new a();

        public static class a implements com.tencent.magicbrush.handler.image.IMBImageHandler.a {
            public final void ag(Object obj) {
                AppMethodBeat.i(115968);
                if (obj != null) {
                    ((IBitmap) obj).recycle();
                }
                AppMethodBeat.o(115968);
            }
        }

        e(MBRuntime mBRuntime, a aVar, String str) {
            AppMethodBeat.i(115969);
            this.bUh = str;
            this.bUj = new WeakReference(mBRuntime);
            this.bUk = new WeakReference(aVar);
            AppMethodBeat.o(115969);
        }

        public final void run() {
            AppMethodBeat.i(115970);
            if (this.bUi) {
                AppMethodBeat.o(115970);
            } else if (this.bUk.get() == null) {
                AppMethodBeat.o(115970);
            } else {
                IBitmap loadBitmapSync = ((a) this.bUk.get()).loadBitmapSync(this.bUh);
                if (this.bUi) {
                    if (loadBitmapSync != null) {
                        loadBitmapSync.recycle();
                    }
                    AppMethodBeat.o(115970);
                    return;
                }
                MBRuntime mBRuntime = (MBRuntime) this.bUj.get();
                if (mBRuntime == null || this.bUi) {
                    if (loadBitmapSync != null) {
                        loadBitmapSync.recycle();
                    }
                    AppMethodBeat.o(115970);
                    return;
                }
                mBRuntime.notifyImageDecoded(this.bUh, loadBitmapSync, this.bUl);
                AppMethodBeat.o(115970);
            }
        }
    }

    public a(MBRuntime mBRuntime, com.tencent.magicbrush.handler.a aVar) {
        AppMethodBeat.i(115971);
        if (aVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DefaultImageHandlerImpl accept null parameter");
            AppMethodBeat.o(115971);
            throw illegalArgumentException;
        }
        this.bSv = mBRuntime;
        this.bUb = new LinkedList();
        a(new c(this), false);
        a(new b(this), false);
        AppMethodBeat.o(115971);
    }

    public final void init() {
    }

    public final void release() {
        AppMethodBeat.i(115972);
        synchronized (this) {
            try {
                if (this.bUf != null) {
                    this.bUf.destroy();
                    this.bUf = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115972);
            }
        }
    }

    public final Bitmap getBitmap(int i, int i2) {
        AppMethodBeat.i(115973);
        Bitmap bK = com.tencent.magicbrush.b.a.yJ().bUr.bK(i, i2);
        AppMethodBeat.o(115973);
        return bK;
    }

    private static CompressFormat fU(int i) {
        switch (i) {
            case 1:
                return CompressFormat.WEBP;
            case 2:
                return CompressFormat.JPEG;
            default:
                return CompressFormat.PNG;
        }
    }

    private static int Z(float f) {
        if (f < 0.0f || f > 1.0f) {
            f = 0.92f;
        }
        return (int) (100.0f * f);
    }

    public final String encodeToBase64(Bitmap bitmap, int i, float f) {
        AppMethodBeat.i(115974);
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || bitmap.isRecycled()) {
            AppMethodBeat.o(115974);
            return null;
        }
        CompressFormat fU = fU(i);
        int Z = Z(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean compress = bitmap.compress(fU, Z, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            com.tencent.magicbrush.a.c.c.e("MagicBrush.DefaultImageHandlerImpl", "base64_encode IOException e %s", e.toString());
            compress = false;
        }
        if (!compress || byteArrayOutputStream.size() <= 0) {
            com.tencent.magicbrush.a.c.c.e("MagicBrush.DefaultImageHandlerImpl", "base64_encode Bitmap compress error.", new Object[0]);
            AppMethodBeat.o(115974);
            return null;
        }
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        AppMethodBeat.o(115974);
        return encodeToString;
    }

    public final byte[] encodeToBuffer(Bitmap bitmap, int i, float f) {
        AppMethodBeat.i(115975);
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || bitmap.isRecycled()) {
            AppMethodBeat.o(115975);
            return null;
        }
        CompressFormat fU = fU(i);
        int Z = Z(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean compress = bitmap.compress(fU, Z, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            com.tencent.magicbrush.a.c.c.e("MagicBrush.DefaultImageHandlerImpl", "encodeToBuffer IOException e %s", e.toString());
            compress = false;
        }
        if (!compress || byteArrayOutputStream.size() <= 0) {
            com.tencent.magicbrush.a.c.c.e("MagicBrush.DefaultImageHandlerImpl", "encodeToBuffer Bitmap compress error.", new Object[0]);
            AppMethodBeat.o(115975);
            return null;
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(115975);
        return toByteArray;
    }

    public final void releaseBitmap(Bitmap bitmap) {
        AppMethodBeat.i(115976);
        if (bitmap == null) {
            AppMethodBeat.o(115976);
            return;
        }
        com.tencent.magicbrush.a.c.c.i("MagicBrush.DefaultImageHandlerImpl", "recycle because releaseBitmap", new Object[0]);
        bitmap.recycle();
        AppMethodBeat.o(115976);
    }

    public final IBitmap loadBitmapSync(String str) {
        AppMethodBeat.i(115977);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115977);
            return null;
        }
        d dVar;
        for (d dVar2 : this.bUb) {
            if (dVar2.ca(str)) {
                break;
            }
        }
        d dVar22 = null;
        if (dVar22 == null) {
            dVar = this.bUc;
        } else {
            dVar = dVar22;
        }
        if (dVar == null) {
            com.tencent.magicbrush.a.c.c.e("MagicBrush.DefaultImageHandlerImpl", "No fit decoder found for %s", str);
            AppMethodBeat.o(115977);
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
            InputStream cb = dVar.cb(str);
            a aVar = ((a) dVar.bUg).bUf;
            a = aVar == null ? null : aVar.a(str, cb);
        } catch (Exception e) {
            com.tencent.magicbrush.a.c.c.e("MagicBrush.DefaultImageHandlerImpl", "ImageDecoder(%s) decode path[%s] error %s", dVar, str, e.toString());
            a = null;
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(115977);
            }
        }
        AppMethodBeat.o(115977);
        return a;
    }

    public final void loadBitmapAsync(String str) {
        AppMethodBeat.i(115978);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115978);
            return;
        }
        b.bUm.bUo.execute(new e(this.bSv, this, str));
        AppMethodBeat.o(115978);
    }

    public final void a(d dVar, boolean z) {
        AppMethodBeat.i(115979);
        if (z) {
            this.bUc = dVar;
            AppMethodBeat.o(115979);
            return;
        }
        this.bUb.add(dVar);
        AppMethodBeat.o(115979);
    }
}
