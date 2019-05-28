package com.bumptech.glide.p086c.p088b.p089a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.c.b.a.k */
public final class C0748k implements C31925e {
    private static final Config aCG = Config.ARGB_8888;
    private final C0751l aCH;
    private final Set<Config> aCI;
    private final long aCJ;
    private final C0749a aCK;
    private long aCL;
    private int aCM;
    private int aCN;
    private int aCO;
    private int aCP;
    private long axz;

    /* renamed from: com.bumptech.glide.c.b.a.k$a */
    interface C0749a {
    }

    /* renamed from: com.bumptech.glide.c.b.a.k$b */
    static final class C0750b implements C0749a {
        C0750b() {
        }
    }

    private C0748k(long j, C0751l c0751l, Set<Config> set) {
        AppMethodBeat.m2504i(91944);
        this.aCJ = j;
        this.axz = j;
        this.aCH = c0751l;
        this.aCI = set;
        this.aCK = new C0750b();
        AppMethodBeat.m2505o(91944);
    }

    public C0748k(long j) {
        C0751l c31930n;
        if (VERSION.SDK_INT >= 19) {
            c31930n = new C31930n();
        } else {
            c31930n = new C25408c();
        }
        HashSet hashSet = new HashSet(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        this(j, c31930n, Collections.unmodifiableSet(hashSet));
        AppMethodBeat.m2504i(91945);
        AppMethodBeat.m2505o(91945);
    }

    /* renamed from: g */
    public final synchronized void mo2199g(Bitmap bitmap) {
        AppMethodBeat.m2504i(91946);
        if (bitmap == null) {
            NullPointerException nullPointerException = new NullPointerException("Bitmap must not be null");
            AppMethodBeat.m2505o(91946);
            throw nullPointerException;
        } else if (bitmap.isRecycled()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot pool recycled bitmap");
            AppMethodBeat.m2505o(91946);
            throw illegalStateException;
        } else if (bitmap.isMutable() && ((long) this.aCH.mo2207i(bitmap)) <= this.axz && this.aCI.contains(bitmap.getConfig())) {
            int i = this.aCH.mo2207i(bitmap);
            this.aCH.mo2205g(bitmap);
            this.aCO++;
            this.aCL = ((long) i) + this.aCL;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Put bitmap in pool=").append(this.aCH.mo2206h(bitmap));
            }
            dump();
            m1711p(this.axz);
            AppMethodBeat.m2505o(91946);
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Reject bitmap from pool, bitmap: ").append(this.aCH.mo2206h(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(this.aCI.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
            AppMethodBeat.m2505o(91946);
        }
    }

    /* renamed from: c */
    public final Bitmap mo2198c(int i, int i2, Config config) {
        AppMethodBeat.m2504i(91947);
        Bitmap i3 = m1709i(i, i2, config);
        if (i3 != null) {
            i3.eraseColor(0);
        } else {
            i3 = C0748k.createBitmap(i, i2, config);
        }
        AppMethodBeat.m2505o(91947);
        return i3;
    }

    /* renamed from: h */
    public final Bitmap mo2200h(int i, int i2, Config config) {
        AppMethodBeat.m2504i(91948);
        Bitmap i3 = m1709i(i, i2, config);
        if (i3 == null) {
            i3 = C0748k.createBitmap(i, i2, config);
        }
        AppMethodBeat.m2505o(91948);
        return i3;
    }

    private static Bitmap createBitmap(int i, int i2, Config config) {
        AppMethodBeat.m2504i(91949);
        if (config == null) {
            config = aCG;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        AppMethodBeat.m2505o(91949);
        return createBitmap;
    }

    /* renamed from: mO */
    public final void mo2201mO() {
        AppMethodBeat.m2504i(91951);
        Log.isLoggable("LruBitmapPool", 3);
        m1711p(0);
        AppMethodBeat.m2505o(91951);
    }

    @SuppressLint({"InlinedApi"})
    public final void trimMemory(int i) {
        AppMethodBeat.m2504i(91952);
        Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40) {
            mo2201mO();
            AppMethodBeat.m2505o(91952);
            return;
        }
        if (i >= 20 || i == 15) {
            m1711p(this.axz / 2);
        }
        AppMethodBeat.m2505o(91952);
    }

    /* renamed from: p */
    private synchronized void m1711p(long j) {
        AppMethodBeat.m2504i(91953);
        while (this.aCL > j) {
            Bitmap mP = this.aCH.mo2208mP();
            if (mP == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    m1710mT();
                }
                this.aCL = 0;
                AppMethodBeat.m2505o(91953);
            } else {
                this.aCL -= (long) this.aCH.mo2207i(mP);
                this.aCP++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    new StringBuilder("Evicting bitmap=").append(this.aCH.mo2206h(mP));
                }
                dump();
                mP.recycle();
            }
        }
        AppMethodBeat.m2505o(91953);
    }

    private void dump() {
        AppMethodBeat.m2504i(91954);
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m1710mT();
        }
        AppMethodBeat.m2505o(91954);
    }

    /* renamed from: mT */
    private void m1710mT() {
        AppMethodBeat.m2504i(91955);
        new StringBuilder("Hits=").append(this.aCM).append(", misses=").append(this.aCN).append(", puts=").append(this.aCO).append(", evictions=").append(this.aCP).append(", currentSize=").append(this.aCL).append(", maxSize=").append(this.axz).append("\nStrategy=").append(this.aCH);
        AppMethodBeat.m2505o(91955);
    }

    /* renamed from: i */
    private synchronized Bitmap m1709i(int i, int i2, Config config) {
        Bitmap c;
        AppMethodBeat.m2504i(91950);
        if (VERSION.SDK_INT < 26 || config != Config.HARDWARE) {
            c = this.aCH.mo2203c(i, i2, config != null ? config : aCG);
            if (c == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    new StringBuilder("Missing bitmap=").append(this.aCH.mo2204d(i, i2, config));
                }
                this.aCN++;
            } else {
                this.aCM++;
                this.aCL -= (long) this.aCH.mo2207i(c);
                c.setHasAlpha(true);
                if (VERSION.SDK_INT >= 19) {
                    c.setPremultiplied(true);
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Get bitmap=").append(this.aCH.mo2204d(i, i2, config));
            }
            dump();
            AppMethodBeat.m2505o(91950);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            AppMethodBeat.m2505o(91950);
            throw illegalArgumentException;
        }
        return c;
    }
}
