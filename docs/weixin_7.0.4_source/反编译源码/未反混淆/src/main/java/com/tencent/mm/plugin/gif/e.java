package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class e extends b {
    private final Rect Hx = new Rect();
    private ak lda = new ak(Looper.getMainLooper());
    int lfO = 0;
    private Context mContext;
    private int mHeight;
    boolean mIsPlaying = true;
    private final Paint mPaint = new Paint(6);
    private Resources mResources;
    private int mWidth;
    private float noE = 1.0f;
    private float noF = 1.0f;
    private boolean noG;
    private long noP = 0;
    private final Runnable noW = new Runnable() {
        public final void run() {
            AppMethodBeat.i(62409);
            if (e.this.npm != null) {
                e.this.npm;
            }
            AppMethodBeat.o(62409);
        }
    };
    private final Runnable noX = new Runnable() {
        public final void run() {
            AppMethodBeat.i(62408);
            if (SystemClock.uptimeMillis() >= e.this.noP) {
                e.this.invalidateSelf();
            }
            AppMethodBeat.o(62408);
        }
    };
    private volatile boolean npd = false;
    private int npe;
    private int npf;
    private int[] npg;
    private Bitmap nph = null;
    private boolean npi = false;
    boolean npj = true;
    private String npk;
    int npl = 0;
    private k npm;

    public e(Context context, boolean z, boolean z2, int i, int[] iArr, String str) {
        AppMethodBeat.i(62410);
        this.mContext = context;
        this.mResources = this.mContext.getResources();
        this.npi = false;
        this.mIsPlaying = z;
        this.npj = z2;
        this.npk = str;
        this.npf = i;
        this.npg = iArr;
        if (z) {
            this.nph = wQ(this.npg[0]);
        } else {
            this.nph = wQ(Oy(str));
        }
        this.mWidth = this.nph.getWidth();
        this.mHeight = this.nph.getHeight();
        if (this.npg.length == 3) {
            this.npe = 300;
        } else {
            this.npe = 100;
        }
        this.npl = 0;
        AppMethodBeat.o(62410);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(62411);
        if (this.noG) {
            this.Hx.set(getBounds());
            this.noE = ((float) this.Hx.width()) / ((float) this.mWidth);
            this.noF = ((float) this.Hx.height()) / ((float) this.mHeight);
            this.noG = false;
        }
        if (this.mPaint.getShader() == null) {
            canvas.scale(this.noE, this.noF);
            if (this.npi) {
                this.nph = wQ(this.npf);
                if (!(this.nph == null || this.nph.isRecycled())) {
                    canvas.drawBitmap(this.nph, 0.0f, 0.0f, this.mPaint);
                    AppMethodBeat.o(62411);
                    return;
                }
            } else if (this.mIsPlaying) {
                this.nph = wQ(this.npg[this.lfO]);
                if (!(this.nph == null || this.nph.isRecycled())) {
                    canvas.drawBitmap(this.nph, 0.0f, 0.0f, this.mPaint);
                }
                this.lfO++;
                if (this.npl < 3) {
                    if (this.lfO >= this.npg.length) {
                        this.lfO = 0;
                        if (this.npj) {
                            this.npl++;
                        } else {
                            this.npl = 0;
                        }
                    }
                    k(this.noX, (long) this.npe);
                    AppMethodBeat.o(62411);
                    return;
                }
                this.mIsPlaying = false;
                k(this.noX, (long) this.npe);
                k(this.noW, 0);
                AppMethodBeat.o(62411);
                return;
            } else {
                this.nph = wQ(Oy(this.npk));
                if (!(this.nph == null || this.nph.isRecycled())) {
                    canvas.drawBitmap(this.nph, 0.0f, 0.0f, this.mPaint);
                    AppMethodBeat.o(62411);
                    return;
                }
            }
        }
        ab.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
        canvas.drawRect(this.Hx, this.mPaint);
        AppMethodBeat.o(62411);
    }

    private void k(Runnable runnable, long j) {
        AppMethodBeat.i(62412);
        this.noP = SystemClock.uptimeMillis() + j;
        if (this.lda != null) {
            this.lda.postDelayed(runnable, j);
        }
        AppMethodBeat.o(62412);
    }

    public final int getIntrinsicHeight() {
        return this.mHeight;
    }

    public final int getIntrinsicWidth() {
        return this.mWidth;
    }

    public final void setAlpha(int i) {
        AppMethodBeat.i(62413);
        this.mPaint.setAlpha(i);
        AppMethodBeat.o(62413);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(62414);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.o(62414);
    }

    public final int getOpacity() {
        return -2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(62415);
        super.onBoundsChange(rect);
        this.noG = true;
        AppMethodBeat.o(62415);
    }

    public final void start() {
        AppMethodBeat.i(62416);
        this.npd = true;
        this.lda.post(this.noX);
        AppMethodBeat.o(62416);
    }

    public final void stop() {
        this.npd = false;
    }

    public final boolean isRunning() {
        return this.npd;
    }

    private Bitmap wQ(int i) {
        AppMethodBeat.i(62417);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mResources, i);
        AppMethodBeat.o(62417);
        return decodeResource;
    }

    private int Oy(String str) {
        AppMethodBeat.i(62418);
        int identifier = this.mResources.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
        AppMethodBeat.o(62418);
        return identifier;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(62419);
        this.npm = null;
        super.finalize();
        AppMethodBeat.o(62419);
    }

    public final void recycle() {
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void resume() {
    }
}
