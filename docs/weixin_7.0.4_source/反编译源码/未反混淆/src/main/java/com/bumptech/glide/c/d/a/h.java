package com.bumptech.glide.c.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.c.b;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.g;
import com.bumptech.glide.c.i;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class h {
    public static final i<b> aFl = i.c("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.ayM);
    @Deprecated
    public static final i<g> aFm = g.aFh;
    public static final i<Boolean> aFn = i.c("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    public static final i<Boolean> aFo = i.Z("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
    private static final Set<String> aFp = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    static final a aFq = new a() {
        public final void ns() {
        }

        public final void a(e eVar, Bitmap bitmap) {
        }
    };
    private static final Set<com.bumptech.glide.c.f.a> aFr = Collections.unmodifiableSet(EnumSet.of(com.bumptech.glide.c.f.a.JPEG, com.bumptech.glide.c.f.a.PNG_A, com.bumptech.glide.c.f.a.PNG));
    private static final Queue<Options> aFs = j.dn(0);
    private final DisplayMetrics aDu;
    private final k aFt = k.nt();
    private final e awf;
    private final List<f> azH;
    private final com.bumptech.glide.c.b.a.b azx;

    public interface a {
        void a(e eVar, Bitmap bitmap);

        void ns();
    }

    static {
        AppMethodBeat.i(92231);
        AppMethodBeat.o(92231);
    }

    public h(List<f> list, DisplayMetrics displayMetrics, e eVar, com.bumptech.glide.c.b.a.b bVar) {
        AppMethodBeat.i(92223);
        this.azH = list;
        this.aDu = (DisplayMetrics) com.bumptech.glide.h.i.d(displayMetrics, "Argument must not be null");
        this.awf = (e) com.bumptech.glide.h.i.d(eVar, "Argument must not be null");
        this.azx = (com.bumptech.glide.c.b.a.b) com.bumptech.glide.h.i.d(bVar, "Argument must not be null");
        AppMethodBeat.o(92223);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a4 A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ab A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00cc A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010b A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x057d A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0123 A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0581 A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0132 A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135 A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x017f A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0228 A:{Catch:{ IOException -> 0x0562, all -> 0x02d8 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final u<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.c.j jVar, a aVar) {
        Object obj;
        long ok;
        int[] a;
        int i3;
        int i4;
        String str;
        Object obj2;
        int b;
        int di;
        boolean dj;
        int i5;
        com.bumptech.glide.c.f.a a2;
        e eVar;
        k kVar;
        Object obj3;
        boolean z;
        Bitmap b2;
        Bitmap bitmap;
        d a3;
        AppMethodBeat.i(92224);
        com.bumptech.glide.h.i.b(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.azx.a(65536, byte[].class);
        Options nr = nr();
        nr.inTempStorage = bArr;
        b bVar = (b) jVar.a(aFl);
        g gVar = (g) jVar.a(g.aFh);
        boolean booleanValue = ((Boolean) jVar.a(aFn)).booleanValue();
        if (jVar.a(aFo) != null) {
            if (((Boolean) jVar.a(aFo)).booleanValue()) {
                int i6;
                int ceil;
                int l;
                obj = 1;
                if (bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                    obj = null;
                }
                ok = com.bumptech.glide.h.e.ok();
                a = a(inputStream, nr, aVar, this.awf);
                i3 = a[0];
                i4 = a[1];
                str = nr.outMimeType;
                if (i3 != -1 || i4 == -1) {
                    obj2 = null;
                } else {
                    obj2 = obj;
                }
                b = g.b(this.azH, inputStream, this.azx);
                di = p.di(b);
                dj = p.dj(b);
                i5 = i != Integer.MIN_VALUE ? i3 : i;
                if (i2 != Integer.MIN_VALUE) {
                    i6 = i4;
                } else {
                    i6 = i2;
                }
                a2 = g.a(this.azH, inputStream, this.azx);
                eVar = this.awf;
                if (i3 <= 0 && i4 > 0) {
                    float l2;
                    if (di == 90 || di == 270) {
                        l2 = gVar.l(i4, i3, i5, i6);
                    } else {
                        l2 = gVar.l(i3, i4, i5, i6);
                    }
                    IllegalArgumentException illegalArgumentException;
                    if (l2 <= 0.0f) {
                        illegalArgumentException = new IllegalArgumentException("Cannot scale with factor: " + l2 + " from: " + gVar + ", source: [" + i3 + VideoMaterialUtil.CRAZYFACE_X + i4 + "], target: [" + i5 + VideoMaterialUtil.CRAZYFACE_X + i6 + "]");
                        AppMethodBeat.o(92224);
                        throw illegalArgumentException;
                    }
                    g.g nq = gVar.nq();
                    if (nq == null) {
                        illegalArgumentException = new IllegalArgumentException("Cannot round with null rounding");
                        AppMethodBeat.o(92224);
                        throw illegalArgumentException;
                    }
                    int i7;
                    di = i3 / ((int) (((double) (((float) i3) * l2)) + 0.5d));
                    int i8 = i4 / ((int) (((double) (((float) i4) * l2)) + 0.5d));
                    if (nq == g.g.MEMORY) {
                        di = Math.max(di, i8);
                    } else {
                        di = Math.min(di, i8);
                    }
                    if (VERSION.SDK_INT > 23 || !aFp.contains(nr.outMimeType)) {
                        di = Math.max(1, Integer.highestOneBit(di));
                        if (nq != g.g.MEMORY || ((float) di) >= 1.0f / l2) {
                            i7 = di;
                        } else {
                            i7 = di << 1;
                        }
                    } else {
                        i7 = 1;
                    }
                    nr.inSampleSize = i7;
                    if (a2 == com.bumptech.glide.c.f.a.JPEG) {
                        di = Math.min(i7, 8);
                        ceil = (int) Math.ceil((double) (((float) i3) / ((float) di)));
                        di = (int) Math.ceil((double) (((float) i4) / ((float) di)));
                        i8 = i7 / 8;
                        if (i8 > 0) {
                            ceil /= i8;
                            di /= i8;
                        }
                    } else if (a2 == com.bumptech.glide.c.f.a.PNG || a2 == com.bumptech.glide.c.f.a.PNG_A) {
                        ceil = (int) Math.floor((double) (((float) i3) / ((float) i7)));
                        di = (int) Math.floor((double) (((float) i4) / ((float) i7)));
                    } else if (a2 == com.bumptech.glide.c.f.a.WEBP || a2 == com.bumptech.glide.c.f.a.WEBP_A) {
                        if (VERSION.SDK_INT >= 24) {
                            ceil = Math.round(((float) i3) / ((float) i7));
                            di = Math.round(((float) i4) / ((float) i7));
                        } else {
                            ceil = (int) Math.floor((double) (((float) i3) / ((float) i7)));
                            di = (int) Math.floor((double) (((float) i4) / ((float) i7)));
                        }
                    } else if (i3 % i7 == 0 && i4 % i7 == 0) {
                        ceil = i3 / i7;
                        di = i4 / i7;
                    } else {
                        int[] a4 = a(inputStream, nr, aVar, eVar);
                        ceil = a4[0];
                        di = a4[1];
                    }
                    double l3 = (double) gVar.l(ceil, di, i5, i6);
                    if (VERSION.SDK_INT >= 19) {
                        l = l(l3);
                        int i9 = (int) ((((double) l) * l3) + 0.5d);
                        nr.inTargetDensity = (int) ((((double) i9) * (l3 / ((double) (((float) i9) / ((float) l))))) + 0.5d);
                        nr.inDensity = l(l3);
                    }
                    if (b(nr)) {
                        nr.inScaled = true;
                    } else {
                        nr.inTargetDensity = 0;
                        nr.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        new StringBuilder("Calculate scaling, source: [").append(i3).append(VideoMaterialUtil.CRAZYFACE_X).append(i4).append("], target: [").append(i5).append(VideoMaterialUtil.CRAZYFACE_X).append(i6).append("], power of two scaled: [").append(ceil).append(VideoMaterialUtil.CRAZYFACE_X).append(di).append("], exact scale factor: ").append(l2).append(", power of 2 sample size: ").append(i7).append(", adjusted scale factor: ").append(l3).append(", target density: ").append(nr.inTargetDensity).append(", density: ").append(nr.inDensity);
                    }
                } else if (Log.isLoggable("Downsampler", 3)) {
                    new StringBuilder("Unable to determine dimensions for: ").append(a2).append(" with target [").append(i5).append(VideoMaterialUtil.CRAZYFACE_X).append(i6).append("]");
                }
                kVar = this.aFt;
                if (obj2 != null || VERSION.SDK_INT < 26 || bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE || dj) {
                    obj3 = null;
                } else {
                    obj3 = (i5 < 128 || i6 < 128 || !kVar.nu()) ? null : 1;
                    if (obj3 != null) {
                        nr.inPreferredConfig = Config.HARDWARE;
                        nr.inMutable = false;
                    }
                }
                if (obj3 == null) {
                    if (bVar == b.PREFER_ARGB_8888 || bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE || VERSION.SDK_INT == 16) {
                        nr.inPreferredConfig = Config.ARGB_8888;
                    } else {
                        z = g.a(this.azH, inputStream, this.azx).aza;
                        nr.inPreferredConfig = z ? Config.ARGB_8888 : Config.RGB_565;
                        if (nr.inPreferredConfig == Config.RGB_565) {
                            nr.inDither = true;
                        }
                    }
                }
                if (VERSION.SDK_INT < 19) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (nr.inSampleSize == 1 || r4 != null) {
                    if (VERSION.SDK_INT < 19) {
                        z = true;
                    } else {
                        z = aFr.contains(a2);
                    }
                    if (z) {
                        if (i3 < 0 || i4 < 0 || !booleanValue || r4 == null) {
                            float f = b(nr) ? ((float) nr.inTargetDensity) / ((float) nr.inDensity) : 1.0f;
                            ceil = nr.inSampleSize;
                            i6 = (int) Math.ceil((double) (((float) i4) / ((float) ceil)));
                            di = Math.round(((float) ((int) Math.ceil((double) (((float) i3) / ((float) ceil))))) * f);
                            int round = Math.round(((float) i6) * f);
                            if (Log.isLoggable("Downsampler", 2)) {
                                new StringBuilder("Calculated target [").append(di).append(VideoMaterialUtil.CRAZYFACE_X).append(round).append("] for source [").append(i3).append(VideoMaterialUtil.CRAZYFACE_X).append(i4).append("], sampleSize: ").append(ceil).append(", targetDensity: ").append(nr.inTargetDensity).append(", density: ").append(nr.inDensity).append(", density multiplier: ").append(f);
                            }
                            l = round;
                        } else {
                            l = i6;
                            di = i5;
                        }
                        if (di > 0 && l > 0) {
                            eVar = this.awf;
                            Config config = null;
                            if (VERSION.SDK_INT >= 26) {
                                if (nr.inPreferredConfig != Config.HARDWARE) {
                                    config = nr.outConfig;
                                }
                            }
                            if (config == null) {
                                config = nr.inPreferredConfig;
                            }
                            nr.inBitmap = eVar.h(di, l, config);
                        }
                    }
                }
                b2 = b(inputStream, nr, aVar, this.awf);
                aVar.a(this.awf, b2);
                if (Log.isLoggable("Downsampler", 2)) {
                    new StringBuilder("Decoded ").append(j(b2)).append(" from [").append(i3).append(VideoMaterialUtil.CRAZYFACE_X).append(i4).append("] ").append(str).append(" with inBitmap ").append(j(nr.inBitmap)).append(" for [").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2).append("], sample size: ").append(nr.inSampleSize).append(", density: ").append(nr.inDensity).append(", target density: ").append(nr.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName()).append(", duration: ").append(com.bumptech.glide.h.e.q(ok));
                }
                bitmap = null;
                if (b2 != null) {
                    b2.setDensity(this.aDu.densityDpi);
                    bitmap = p.a(this.awf, b2, b);
                    if (!b2.equals(bitmap)) {
                        this.awf.g(b2);
                    }
                }
                a3 = d.a(bitmap, this.awf);
                c(nr);
                this.azx.put(bArr);
                AppMethodBeat.o(92224);
                return a3;
            }
        }
        obj = null;
        if (bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
        }
        try {
            ok = com.bumptech.glide.h.e.ok();
            a = a(inputStream, nr, aVar, this.awf);
            i3 = a[0];
            i4 = a[1];
            str = nr.outMimeType;
            if (i3 != -1) {
            }
            obj2 = null;
            b = g.b(this.azH, inputStream, this.azx);
            di = p.di(b);
            dj = p.dj(b);
            if (i != Integer.MIN_VALUE) {
            }
            if (i2 != Integer.MIN_VALUE) {
            }
            a2 = g.a(this.azH, inputStream, this.azx);
            eVar = this.awf;
            if (i3 <= 0) {
            }
            if (Log.isLoggable("Downsampler", 3)) {
            }
            kVar = this.aFt;
            if (obj2 != null) {
            }
            obj3 = null;
            if (obj3 == null) {
            }
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                new StringBuilder("Cannot determine whether the image has alpha or not from header, format ").append(bVar);
            }
            z = false;
        } catch (Throwable th) {
            c(nr);
            this.azx.put(bArr);
            AppMethodBeat.o(92224);
        }
        if (VERSION.SDK_INT < 19) {
        }
        if (VERSION.SDK_INT < 19) {
        }
        if (z) {
        }
        b2 = b(inputStream, nr, aVar, this.awf);
        aVar.a(this.awf, b2);
        if (Log.isLoggable("Downsampler", 2)) {
        }
        bitmap = null;
        if (b2 != null) {
        }
        a3 = d.a(bitmap, this.awf);
        c(nr);
        this.azx.put(bArr);
        AppMethodBeat.o(92224);
        return a3;
    }

    private static int l(double d) {
        AppMethodBeat.i(92225);
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        int round = (int) Math.round(2.147483647E9d * d);
        AppMethodBeat.o(92225);
        return round;
    }

    private static int[] a(InputStream inputStream, Options options, a aVar, e eVar) {
        AppMethodBeat.i(92226);
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        int[] iArr = new int[]{options.outWidth, options.outHeight};
        AppMethodBeat.o(92226);
        return iArr;
    }

    private static Bitmap b(InputStream inputStream, Options options, a aVar, e eVar) {
        Bitmap decodeStream;
        IOException iOException;
        AppMethodBeat.i(92227);
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            aVar.ns();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        p.nx().lock();
        try {
            decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            p.nx().unlock();
            if (options.inJustDecodeBounds) {
                inputStream.reset();
            }
            AppMethodBeat.o(92227);
        } catch (IOException e) {
            AppMethodBeat.o(92227);
            throw iOException;
        } catch (IllegalArgumentException e2) {
            iOException = new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + j(options.inBitmap), e2);
            Log.isLoggable("Downsampler", 3);
            if (options.inBitmap != null) {
                inputStream.reset();
                eVar.g(options.inBitmap);
                options.inBitmap = null;
                decodeStream = b(inputStream, options, aVar, eVar);
                p.nx().unlock();
                AppMethodBeat.o(92227);
            } else {
                AppMethodBeat.o(92227);
                throw iOException;
            }
        } catch (Throwable th) {
            p.nx().unlock();
            AppMethodBeat.o(92227);
        }
        return decodeStream;
    }

    private static boolean b(Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        AppMethodBeat.i(92228);
        if (bitmap == null) {
            AppMethodBeat.o(92228);
            return null;
        }
        String str = "[" + bitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + bitmap.getHeight() + "] " + bitmap.getConfig() + (VERSION.SDK_INT >= 19 ? " (" + bitmap.getAllocationByteCount() + ")" : "");
        AppMethodBeat.o(92228);
        return str;
    }

    private static synchronized Options nr() {
        Options options;
        synchronized (h.class) {
            AppMethodBeat.i(92229);
            synchronized (aFs) {
                try {
                    options = (Options) aFs.poll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(92229);
                    }
                }
            }
            if (options == null) {
                options = new Options();
                d(options);
            }
            AppMethodBeat.o(92229);
        }
        return options;
    }

    private static void c(Options options) {
        AppMethodBeat.i(92230);
        d(options);
        synchronized (aFs) {
            try {
                aFs.offer(options);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(92230);
            }
        }
    }

    private static void d(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
