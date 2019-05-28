package com.bumptech.glide.c.b.a;

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

public final class k implements e {
    private static final Config aCG = Config.ARGB_8888;
    private final l aCH;
    private final Set<Config> aCI;
    private final long aCJ;
    private final a aCK;
    private long aCL;
    private int aCM;
    private int aCN;
    private int aCO;
    private int aCP;
    private long axz;

    interface a {
    }

    static final class b implements a {
        b() {
        }
    }

    private k(long j, l lVar, Set<Config> set) {
        AppMethodBeat.i(91944);
        this.aCJ = j;
        this.axz = j;
        this.aCH = lVar;
        this.aCI = set;
        this.aCK = new b();
        AppMethodBeat.o(91944);
    }

    public k(long j) {
        l nVar;
        if (VERSION.SDK_INT >= 19) {
            nVar = new n();
        } else {
            nVar = new c();
        }
        HashSet hashSet = new HashSet(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        this(j, nVar, Collections.unmodifiableSet(hashSet));
        AppMethodBeat.i(91945);
        AppMethodBeat.o(91945);
    }

    public final synchronized void g(Bitmap bitmap) {
        AppMethodBeat.i(91946);
        if (bitmap == null) {
            NullPointerException nullPointerException = new NullPointerException("Bitmap must not be null");
            AppMethodBeat.o(91946);
            throw nullPointerException;
        } else if (bitmap.isRecycled()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot pool recycled bitmap");
            AppMethodBeat.o(91946);
            throw illegalStateException;
        } else if (bitmap.isMutable() && ((long) this.aCH.i(bitmap)) <= this.axz && this.aCI.contains(bitmap.getConfig())) {
            int i = this.aCH.i(bitmap);
            this.aCH.g(bitmap);
            this.aCO++;
            this.aCL = ((long) i) + this.aCL;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Put bitmap in pool=").append(this.aCH.h(bitmap));
            }
            dump();
            p(this.axz);
            AppMethodBeat.o(91946);
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Reject bitmap from pool, bitmap: ").append(this.aCH.h(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(this.aCI.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
            AppMethodBeat.o(91946);
        }
    }

    public final Bitmap c(int i, int i2, Config config) {
        AppMethodBeat.i(91947);
        Bitmap i3 = i(i, i2, config);
        if (i3 != null) {
            i3.eraseColor(0);
        } else {
            i3 = createBitmap(i, i2, config);
        }
        AppMethodBeat.o(91947);
        return i3;
    }

    public final Bitmap h(int i, int i2, Config config) {
        AppMethodBeat.i(91948);
        Bitmap i3 = i(i, i2, config);
        if (i3 == null) {
            i3 = createBitmap(i, i2, config);
        }
        AppMethodBeat.o(91948);
        return i3;
    }

    private static Bitmap createBitmap(int i, int i2, Config config) {
        AppMethodBeat.i(91949);
        if (config == null) {
            config = aCG;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        AppMethodBeat.o(91949);
        return createBitmap;
    }

    public final void mO() {
        AppMethodBeat.i(91951);
        Log.isLoggable("LruBitmapPool", 3);
        p(0);
        AppMethodBeat.o(91951);
    }

    @SuppressLint({"InlinedApi"})
    public final void trimMemory(int i) {
        AppMethodBeat.i(91952);
        Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40) {
            mO();
            AppMethodBeat.o(91952);
            return;
        }
        if (i >= 20 || i == 15) {
            p(this.axz / 2);
        }
        AppMethodBeat.o(91952);
    }

    private synchronized void p(long j) {
        AppMethodBeat.i(91953);
        while (this.aCL > j) {
            Bitmap mP = this.aCH.mP();
            if (mP == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    mT();
                }
                this.aCL = 0;
                AppMethodBeat.o(91953);
            } else {
                this.aCL -= (long) this.aCH.i(mP);
                this.aCP++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    new StringBuilder("Evicting bitmap=").append(this.aCH.h(mP));
                }
                dump();
                mP.recycle();
            }
        }
        AppMethodBeat.o(91953);
    }

    private void dump() {
        AppMethodBeat.i(91954);
        if (Log.isLoggable("LruBitmapPool", 2)) {
            mT();
        }
        AppMethodBeat.o(91954);
    }

    private void mT() {
        AppMethodBeat.i(91955);
        new StringBuilder("Hits=").append(this.aCM).append(", misses=").append(this.aCN).append(", puts=").append(this.aCO).append(", evictions=").append(this.aCP).append(", currentSize=").append(this.aCL).append(", maxSize=").append(this.axz).append("\nStrategy=").append(this.aCH);
        AppMethodBeat.o(91955);
    }

    private synchronized Bitmap i(int i, int i2, Config config) {
        Bitmap c;
        AppMethodBeat.i(91950);
        if (VERSION.SDK_INT < 26 || config != Config.HARDWARE) {
            c = this.aCH.c(i, i2, config != null ? config : aCG);
            if (c == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    new StringBuilder("Missing bitmap=").append(this.aCH.d(i, i2, config));
                }
                this.aCN++;
            } else {
                this.aCM++;
                this.aCL -= (long) this.aCH.i(c);
                c.setHasAlpha(true);
                if (VERSION.SDK_INT >= 19) {
                    c.setPremultiplied(true);
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Get bitmap=").append(this.aCH.d(i, i2, config));
            }
            dump();
            AppMethodBeat.o(91950);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            AppMethodBeat.o(91950);
            throw illegalArgumentException;
        }
        return c;
    }
}
