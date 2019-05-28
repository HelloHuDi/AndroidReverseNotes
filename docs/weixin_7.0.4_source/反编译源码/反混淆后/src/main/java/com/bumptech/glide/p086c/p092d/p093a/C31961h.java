package com.bumptech.glide.p086c.p092d.p093a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.p086c.C0776f;
import com.bumptech.glide.p086c.C0776f.C0777a;
import com.bumptech.glide.p086c.C0778g;
import com.bumptech.glide.p086c.C17546i;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C37171b;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p086c.p092d.p093a.C31955g.C25442g;
import com.bumptech.glide.p095h.C31975e;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
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

/* renamed from: com.bumptech.glide.c.d.a.h */
public final class C31961h {
    public static final C17546i<C37171b> aFl = C17546i.m27397c("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", C37171b.ayM);
    @Deprecated
    public static final C17546i<C31955g> aFm = C31955g.aFh;
    public static final C17546i<Boolean> aFn = C17546i.m27397c("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    public static final C17546i<Boolean> aFo = C17546i.m27395Z("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
    private static final Set<String> aFp = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    static final C31960a aFq = new C07731();
    private static final Set<C0777a> aFr = Collections.unmodifiableSet(EnumSet.of(C0777a.JPEG, C0777a.PNG_A, C0777a.PNG));
    private static final Queue<Options> aFs = C45002j.m82420dn(0);
    private final DisplayMetrics aDu;
    private final C31962k aFt = C31962k.m51936nt();
    private final C31925e awf;
    private final List<C0776f> azH;
    private final C8515b azx;

    /* renamed from: com.bumptech.glide.c.d.a.h$1 */
    class C07731 implements C31960a {
        C07731() {
        }

        /* renamed from: ns */
        public final void mo2237ns() {
        }

        /* renamed from: a */
        public final void mo2236a(C31925e c31925e, Bitmap bitmap) {
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.h$a */
    public interface C31960a {
        /* renamed from: a */
        void mo2236a(C31925e c31925e, Bitmap bitmap);

        /* renamed from: ns */
        void mo2237ns();
    }

    static {
        AppMethodBeat.m2504i(92231);
        AppMethodBeat.m2505o(92231);
    }

    public C31961h(List<C0776f> list, DisplayMetrics displayMetrics, C31925e c31925e, C8515b c8515b) {
        AppMethodBeat.m2504i(92223);
        this.azH = list;
        this.aDu = (DisplayMetrics) C8561i.m15217d(displayMetrics, "Argument must not be null");
        this.awf = (C31925e) C8561i.m15217d(c31925e, "Argument must not be null");
        this.azx = (C8515b) C8561i.m15217d(c8515b, "Argument must not be null");
        AppMethodBeat.m2505o(92223);
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
    /* renamed from: a */
    public final C17526u<Bitmap> mo52067a(InputStream inputStream, int i, int i2, C31967j c31967j, C31960a c31960a) {
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
        C0777a a2;
        C31925e c31925e;
        C31962k c31962k;
        Object obj3;
        boolean z;
        Bitmap b2;
        Bitmap bitmap;
        C0771d a3;
        AppMethodBeat.m2504i(92224);
        C8561i.m15215b(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.azx.mo18608a(65536, byte[].class);
        Options nr = C31961h.m51934nr();
        nr.inTempStorage = bArr;
        C37171b c37171b = (C37171b) c31967j.mo52069a(aFl);
        C31955g c31955g = (C31955g) c31967j.mo52069a(C31955g.aFh);
        boolean booleanValue = ((Boolean) c31967j.mo52069a(aFn)).booleanValue();
        if (c31967j.mo52069a(aFo) != null) {
            if (((Boolean) c31967j.mo52069a(aFo)).booleanValue()) {
                int i6;
                int ceil;
                int l;
                obj = 1;
                if (c37171b == C37171b.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                    obj = null;
                }
                ok = C31975e.m51954ok();
                a = C31961h.m51927a(inputStream, nr, c31960a, this.awf);
                i3 = a[0];
                i4 = a[1];
                str = nr.outMimeType;
                if (i3 != -1 || i4 == -1) {
                    obj2 = null;
                } else {
                    obj2 = obj;
                }
                b = C0778g.m1773b(this.azH, inputStream, this.azx);
                di = C44996p.m82397di(b);
                dj = C44996p.m82398dj(b);
                i5 = i != Integer.MIN_VALUE ? i3 : i;
                if (i2 != Integer.MIN_VALUE) {
                    i6 = i4;
                } else {
                    i6 = i2;
                }
                a2 = C0778g.m1772a(this.azH, inputStream, this.azx);
                c31925e = this.awf;
                if (i3 <= 0 && i4 > 0) {
                    float l2;
                    if (di == 90 || di == 270) {
                        l2 = c31955g.mo31963l(i4, i3, i5, i6);
                    } else {
                        l2 = c31955g.mo31963l(i3, i4, i5, i6);
                    }
                    IllegalArgumentException illegalArgumentException;
                    if (l2 <= 0.0f) {
                        illegalArgumentException = new IllegalArgumentException("Cannot scale with factor: " + l2 + " from: " + c31955g + ", source: [" + i3 + VideoMaterialUtil.CRAZYFACE_X + i4 + "], target: [" + i5 + VideoMaterialUtil.CRAZYFACE_X + i6 + "]");
                        AppMethodBeat.m2505o(92224);
                        throw illegalArgumentException;
                    }
                    C25442g nq = c31955g.mo31964nq();
                    if (nq == null) {
                        illegalArgumentException = new IllegalArgumentException("Cannot round with null rounding");
                        AppMethodBeat.m2505o(92224);
                        throw illegalArgumentException;
                    }
                    int i7;
                    di = i3 / ((int) (((double) (((float) i3) * l2)) + 0.5d));
                    int i8 = i4 / ((int) (((double) (((float) i4) * l2)) + 0.5d));
                    if (nq == C25442g.MEMORY) {
                        di = Math.max(di, i8);
                    } else {
                        di = Math.min(di, i8);
                    }
                    if (VERSION.SDK_INT > 23 || !aFp.contains(nr.outMimeType)) {
                        di = Math.max(1, Integer.highestOneBit(di));
                        if (nq != C25442g.MEMORY || ((float) di) >= 1.0f / l2) {
                            i7 = di;
                        } else {
                            i7 = di << 1;
                        }
                    } else {
                        i7 = 1;
                    }
                    nr.inSampleSize = i7;
                    if (a2 == C0777a.JPEG) {
                        di = Math.min(i7, 8);
                        ceil = (int) Math.ceil((double) (((float) i3) / ((float) di)));
                        di = (int) Math.ceil((double) (((float) i4) / ((float) di)));
                        i8 = i7 / 8;
                        if (i8 > 0) {
                            ceil /= i8;
                            di /= i8;
                        }
                    } else if (a2 == C0777a.PNG || a2 == C0777a.PNG_A) {
                        ceil = (int) Math.floor((double) (((float) i3) / ((float) i7)));
                        di = (int) Math.floor((double) (((float) i4) / ((float) i7)));
                    } else if (a2 == C0777a.WEBP || a2 == C0777a.WEBP_A) {
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
                        int[] a4 = C31961h.m51927a(inputStream, nr, c31960a, c31925e);
                        ceil = a4[0];
                        di = a4[1];
                    }
                    double l3 = (double) c31955g.mo31963l(ceil, di, i5, i6);
                    if (VERSION.SDK_INT >= 19) {
                        l = C31961h.m51933l(l3);
                        int i9 = (int) ((((double) l) * l3) + 0.5d);
                        nr.inTargetDensity = (int) ((((double) i9) * (l3 / ((double) (((float) i9) / ((float) l))))) + 0.5d);
                        nr.inDensity = C31961h.m51933l(l3);
                    }
                    if (C31961h.m51929b(nr)) {
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
                c31962k = this.aFt;
                if (obj2 != null || VERSION.SDK_INT < 26 || c37171b == C37171b.PREFER_ARGB_8888_DISALLOW_HARDWARE || dj) {
                    obj3 = null;
                } else {
                    obj3 = (i5 < 128 || i6 < 128 || !c31962k.mo52068nu()) ? null : 1;
                    if (obj3 != null) {
                        nr.inPreferredConfig = Config.HARDWARE;
                        nr.inMutable = false;
                    }
                }
                if (obj3 == null) {
                    if (c37171b == C37171b.PREFER_ARGB_8888 || c37171b == C37171b.PREFER_ARGB_8888_DISALLOW_HARDWARE || VERSION.SDK_INT == 16) {
                        nr.inPreferredConfig = Config.ARGB_8888;
                    } else {
                        z = C0778g.m1772a(this.azH, inputStream, this.azx).aza;
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
                            float f = C31961h.m51929b(nr) ? ((float) nr.inTargetDensity) / ((float) nr.inDensity) : 1.0f;
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
                            c31925e = this.awf;
                            Config config = null;
                            if (VERSION.SDK_INT >= 26) {
                                if (nr.inPreferredConfig != Config.HARDWARE) {
                                    config = nr.outConfig;
                                }
                            }
                            if (config == null) {
                                config = nr.inPreferredConfig;
                            }
                            nr.inBitmap = c31925e.mo2200h(di, l, config);
                        }
                    }
                }
                b2 = C31961h.m51928b(inputStream, nr, c31960a, this.awf);
                c31960a.mo2236a(this.awf, b2);
                if (Log.isLoggable("Downsampler", 2)) {
                    new StringBuilder("Decoded ").append(C31961h.m51932j(b2)).append(" from [").append(i3).append(VideoMaterialUtil.CRAZYFACE_X).append(i4).append("] ").append(str).append(" with inBitmap ").append(C31961h.m51932j(nr.inBitmap)).append(" for [").append(i).append(VideoMaterialUtil.CRAZYFACE_X).append(i2).append("], sample size: ").append(nr.inSampleSize).append(", density: ").append(nr.inDensity).append(", target density: ").append(nr.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName()).append(", duration: ").append(C31975e.m51955q(ok));
                }
                bitmap = null;
                if (b2 != null) {
                    b2.setDensity(this.aDu.densityDpi);
                    bitmap = C44996p.m82396a(this.awf, b2, b);
                    if (!b2.equals(bitmap)) {
                        this.awf.mo2199g(b2);
                    }
                }
                a3 = C0771d.m1760a(bitmap, this.awf);
                C31961h.m51930c(nr);
                this.azx.put(bArr);
                AppMethodBeat.m2505o(92224);
                return a3;
            }
        }
        obj = null;
        if (c37171b == C37171b.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
        }
        try {
            ok = C31975e.m51954ok();
            a = C31961h.m51927a(inputStream, nr, c31960a, this.awf);
            i3 = a[0];
            i4 = a[1];
            str = nr.outMimeType;
            if (i3 != -1) {
            }
            obj2 = null;
            b = C0778g.m1773b(this.azH, inputStream, this.azx);
            di = C44996p.m82397di(b);
            dj = C44996p.m82398dj(b);
            if (i != Integer.MIN_VALUE) {
            }
            if (i2 != Integer.MIN_VALUE) {
            }
            a2 = C0778g.m1772a(this.azH, inputStream, this.azx);
            c31925e = this.awf;
            if (i3 <= 0) {
            }
            if (Log.isLoggable("Downsampler", 3)) {
            }
            c31962k = this.aFt;
            if (obj2 != null) {
            }
            obj3 = null;
            if (obj3 == null) {
            }
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                new StringBuilder("Cannot determine whether the image has alpha or not from header, format ").append(c37171b);
            }
            z = false;
        } catch (Throwable th) {
            C31961h.m51930c(nr);
            this.azx.put(bArr);
            AppMethodBeat.m2505o(92224);
        }
        if (VERSION.SDK_INT < 19) {
        }
        if (VERSION.SDK_INT < 19) {
        }
        if (z) {
        }
        b2 = C31961h.m51928b(inputStream, nr, c31960a, this.awf);
        c31960a.mo2236a(this.awf, b2);
        if (Log.isLoggable("Downsampler", 2)) {
        }
        bitmap = null;
        if (b2 != null) {
        }
        a3 = C0771d.m1760a(bitmap, this.awf);
        C31961h.m51930c(nr);
        this.azx.put(bArr);
        AppMethodBeat.m2505o(92224);
        return a3;
    }

    /* renamed from: l */
    private static int m51933l(double d) {
        AppMethodBeat.m2504i(92225);
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        int round = (int) Math.round(2.147483647E9d * d);
        AppMethodBeat.m2505o(92225);
        return round;
    }

    /* renamed from: a */
    private static int[] m51927a(InputStream inputStream, Options options, C31960a c31960a, C31925e c31925e) {
        AppMethodBeat.m2504i(92226);
        options.inJustDecodeBounds = true;
        C31961h.m51928b(inputStream, options, c31960a, c31925e);
        options.inJustDecodeBounds = false;
        int[] iArr = new int[]{options.outWidth, options.outHeight};
        AppMethodBeat.m2505o(92226);
        return iArr;
    }

    /* renamed from: b */
    private static Bitmap m51928b(InputStream inputStream, Options options, C31960a c31960a, C31925e c31925e) {
        Bitmap decodeStream;
        IOException iOException;
        AppMethodBeat.m2504i(92227);
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            c31960a.mo2237ns();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        C44996p.m82399nx().lock();
        try {
            decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            C44996p.m82399nx().unlock();
            if (options.inJustDecodeBounds) {
                inputStream.reset();
            }
            AppMethodBeat.m2505o(92227);
        } catch (IOException e) {
            AppMethodBeat.m2505o(92227);
            throw iOException;
        } catch (IllegalArgumentException e2) {
            iOException = new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + C31961h.m51932j(options.inBitmap), e2);
            Log.isLoggable("Downsampler", 3);
            if (options.inBitmap != null) {
                inputStream.reset();
                c31925e.mo2199g(options.inBitmap);
                options.inBitmap = null;
                decodeStream = C31961h.m51928b(inputStream, options, c31960a, c31925e);
                C44996p.m82399nx().unlock();
                AppMethodBeat.m2505o(92227);
            } else {
                AppMethodBeat.m2505o(92227);
                throw iOException;
            }
        } catch (Throwable th) {
            C44996p.m82399nx().unlock();
            AppMethodBeat.m2505o(92227);
        }
        return decodeStream;
    }

    /* renamed from: b */
    private static boolean m51929b(Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    @TargetApi(19)
    /* renamed from: j */
    private static String m51932j(Bitmap bitmap) {
        AppMethodBeat.m2504i(92228);
        if (bitmap == null) {
            AppMethodBeat.m2505o(92228);
            return null;
        }
        String str = "[" + bitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + bitmap.getHeight() + "] " + bitmap.getConfig() + (VERSION.SDK_INT >= 19 ? " (" + bitmap.getAllocationByteCount() + ")" : "");
        AppMethodBeat.m2505o(92228);
        return str;
    }

    /* renamed from: nr */
    private static synchronized Options m51934nr() {
        Options options;
        synchronized (C31961h.class) {
            AppMethodBeat.m2504i(92229);
            synchronized (aFs) {
                try {
                    options = (Options) aFs.poll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(92229);
                    }
                }
            }
            if (options == null) {
                options = new Options();
                C31961h.m51931d(options);
            }
            AppMethodBeat.m2505o(92229);
        }
        return options;
    }

    /* renamed from: c */
    private static void m51930c(Options options) {
        AppMethodBeat.m2504i(92230);
        C31961h.m51931d(options);
        synchronized (aFs) {
            try {
                aFs.offer(options);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(92230);
            }
        }
    }

    /* renamed from: d */
    private static void m51931d(Options options) {
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
