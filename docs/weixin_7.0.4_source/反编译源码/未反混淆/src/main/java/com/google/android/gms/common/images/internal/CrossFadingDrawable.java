package com.google.android.gms.common.images.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CrossFadingDrawable extends Drawable implements Callback {
    private int mAlpha;
    private int mFrom;
    private boolean zzpl;
    private int zzpw;
    private long zzpx;
    private int zzpy;
    private int zzpz;
    private int zzqa;
    private boolean zzqb;
    private zzb zzqc;
    private Drawable zzqd;
    private Drawable zzqe;
    private boolean zzqf;
    private boolean zzqg;
    private boolean zzqh;
    private int zzqi;

    static final class zza extends Drawable {
        private static final zza zzqj = new zza();
        private static final zzb zzqk = new zzb();

        static {
            AppMethodBeat.i(61259);
            AppMethodBeat.o(61259);
        }

        private zza() {
        }

        public final void draw(Canvas canvas) {
        }

        public final ConstantState getConstantState() {
            return zzqk;
        }

        public final int getOpacity() {
            return -2;
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends ConstantState {
        int mChangingConfigurations;
        int zzql;

        zzb(zzb zzb) {
            AppMethodBeat.i(61260);
            if (zzb != null) {
                this.mChangingConfigurations = zzb.mChangingConfigurations;
                this.zzql = zzb.zzql;
            }
            AppMethodBeat.o(61260);
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(61261);
            CrossFadingDrawable crossFadingDrawable = new CrossFadingDrawable(this);
            AppMethodBeat.o(61261);
            return crossFadingDrawable;
        }
    }

    public CrossFadingDrawable(Drawable drawable, Drawable drawable2) {
        this(null);
        AppMethodBeat.i(61262);
        if (drawable == null) {
            drawable = zza.zzqj;
        }
        this.zzqd = drawable;
        drawable.setCallback(this);
        zzb zzb = this.zzqc;
        zzb.zzql |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = zza.zzqj;
        }
        this.zzqe = drawable2;
        drawable2.setCallback(this);
        zzb = this.zzqc;
        zzb.zzql |= drawable2.getChangingConfigurations();
        AppMethodBeat.o(61262);
    }

    CrossFadingDrawable(zzb zzb) {
        AppMethodBeat.i(61263);
        this.zzpw = 0;
        this.zzpz = 255;
        this.mAlpha = 0;
        this.zzpl = true;
        this.zzqc = new zzb(zzb);
        AppMethodBeat.o(61263);
    }

    public final boolean canConstantState() {
        boolean z;
        AppMethodBeat.i(61275);
        if (!this.zzqf) {
            z = (this.zzqd.getConstantState() == null || this.zzqe.getConstantState() == null) ? false : true;
            this.zzqg = z;
            this.zzqf = true;
        }
        z = this.zzqg;
        AppMethodBeat.o(61275);
        return z;
    }

    public final void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(61279);
        switch (this.zzpw) {
            case 1:
                this.zzpx = SystemClock.uptimeMillis();
                this.zzpw = 2;
                break;
            case 2:
                if (this.zzpx >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzpx)) / ((float) this.zzqa);
                    if (uptimeMillis < 1.0f) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.zzpw = 0;
                    }
                    this.mAlpha = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) this.zzpy)) + 0.0f);
                    break;
                }
                break;
        }
        i2 = i;
        i = this.mAlpha;
        boolean z = this.zzpl;
        Drawable drawable = this.zzqd;
        Drawable drawable2 = this.zzqe;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzpz) {
                drawable2.setAlpha(this.zzpz);
                drawable2.draw(canvas);
            }
            AppMethodBeat.o(61279);
            return;
        }
        if (z) {
            drawable.setAlpha(this.zzpz - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.zzpz);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzpz);
        }
        invalidateSelf();
        AppMethodBeat.o(61279);
    }

    public final int getChangingConfigurations() {
        AppMethodBeat.i(61267);
        int changingConfigurations = (super.getChangingConfigurations() | this.zzqc.mChangingConfigurations) | this.zzqc.zzql;
        AppMethodBeat.o(61267);
        return changingConfigurations;
    }

    public final ConstantState getConstantState() {
        AppMethodBeat.i(61273);
        if (canConstantState()) {
            this.zzqc.mChangingConfigurations = getChangingConfigurations();
            zzb zzb = this.zzqc;
            AppMethodBeat.o(61273);
            return zzb;
        }
        AppMethodBeat.o(61273);
        return null;
    }

    public final Drawable getEndDrawable() {
        return this.zzqe;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.i(61271);
        int max = Math.max(this.zzqd.getIntrinsicHeight(), this.zzqe.getIntrinsicHeight());
        AppMethodBeat.o(61271);
        return max;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(61270);
        int max = Math.max(this.zzqd.getIntrinsicWidth(), this.zzqe.getIntrinsicWidth());
        AppMethodBeat.o(61270);
        return max;
    }

    public final int getOpacity() {
        AppMethodBeat.i(61274);
        if (!this.zzqh) {
            this.zzqi = Drawable.resolveOpacity(this.zzqd.getOpacity(), this.zzqe.getOpacity());
            this.zzqh = true;
        }
        int i = this.zzqi;
        AppMethodBeat.o(61274);
        return i;
    }

    public final Drawable getStartDrawable() {
        return this.zzqd;
    }

    public final void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.i(61264);
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
        AppMethodBeat.o(61264);
    }

    public final Drawable mutate() {
        AppMethodBeat.i(61276);
        if (!this.zzqb && super.mutate() == this) {
            if (canConstantState()) {
                this.zzqd.mutate();
                this.zzqe.mutate();
                this.zzqb = true;
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
                AppMethodBeat.o(61276);
                throw illegalStateException;
            }
        }
        AppMethodBeat.o(61276);
        return this;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(61272);
        this.zzqd.setBounds(rect);
        this.zzqe.setBounds(rect);
        AppMethodBeat.o(61272);
    }

    public final void resetTransition() {
        AppMethodBeat.i(61278);
        this.mAlpha = 0;
        this.zzpw = 0;
        invalidateSelf();
        AppMethodBeat.o(61278);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        AppMethodBeat.i(61265);
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
        AppMethodBeat.o(61265);
    }

    public final void setAlpha(int i) {
        AppMethodBeat.i(61268);
        if (this.mAlpha == this.zzpz) {
            this.mAlpha = i;
        }
        this.zzpz = i;
        invalidateSelf();
        AppMethodBeat.o(61268);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(61269);
        this.zzqd.setColorFilter(colorFilter);
        this.zzqe.setColorFilter(colorFilter);
        AppMethodBeat.o(61269);
    }

    public final void setCrossFadeEnabled(boolean z) {
        this.zzpl = z;
    }

    public final void startTransition(int i) {
        AppMethodBeat.i(61277);
        this.mFrom = 0;
        this.zzpy = this.zzpz;
        this.mAlpha = 0;
        this.zzqa = i;
        this.zzpw = 1;
        invalidateSelf();
        AppMethodBeat.o(61277);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        AppMethodBeat.i(61266);
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
        AppMethodBeat.o(61266);
    }
}
