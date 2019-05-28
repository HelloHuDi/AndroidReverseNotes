package com.tencent.p177mm.plugin.gif;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.gif.e */
public final class C3273e extends C34323b {
    /* renamed from: Hx */
    private final Rect f1267Hx = new Rect();
    private C7306ak lda = new C7306ak(Looper.getMainLooper());
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
    private final Runnable noW = new C32752();
    private final Runnable noX = new C32741();
    private volatile boolean npd = false;
    private int npe;
    private int npf;
    private int[] npg;
    private Bitmap nph = null;
    private boolean npi = false;
    boolean npj = true;
    private String npk;
    int npl = 0;
    private C39243k npm;

    /* renamed from: com.tencent.mm.plugin.gif.e$1 */
    class C32741 implements Runnable {
        C32741() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62408);
            if (SystemClock.uptimeMillis() >= C3273e.this.noP) {
                C3273e.this.invalidateSelf();
            }
            AppMethodBeat.m2505o(62408);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gif.e$2 */
    class C32752 implements Runnable {
        C32752() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62409);
            if (C3273e.this.npm != null) {
                C3273e.this.npm;
            }
            AppMethodBeat.m2505o(62409);
        }
    }

    public C3273e(Context context, boolean z, boolean z2, int i, int[] iArr, String str) {
        AppMethodBeat.m2504i(62410);
        this.mContext = context;
        this.mResources = this.mContext.getResources();
        this.npi = false;
        this.mIsPlaying = z;
        this.npj = z2;
        this.npk = str;
        this.npf = i;
        this.npg = iArr;
        if (z) {
            this.nph = m5602wQ(this.npg[0]);
        } else {
            this.nph = m5602wQ(m5598Oy(str));
        }
        this.mWidth = this.nph.getWidth();
        this.mHeight = this.nph.getHeight();
        if (this.npg.length == 3) {
            this.npe = 300;
        } else {
            this.npe = 100;
        }
        this.npl = 0;
        AppMethodBeat.m2505o(62410);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(62411);
        if (this.noG) {
            this.f1267Hx.set(getBounds());
            this.noE = ((float) this.f1267Hx.width()) / ((float) this.mWidth);
            this.noF = ((float) this.f1267Hx.height()) / ((float) this.mHeight);
            this.noG = false;
        }
        if (this.mPaint.getShader() == null) {
            canvas.scale(this.noE, this.noF);
            if (this.npi) {
                this.nph = m5602wQ(this.npf);
                if (!(this.nph == null || this.nph.isRecycled())) {
                    canvas.drawBitmap(this.nph, 0.0f, 0.0f, this.mPaint);
                    AppMethodBeat.m2505o(62411);
                    return;
                }
            } else if (this.mIsPlaying) {
                this.nph = m5602wQ(this.npg[this.lfO]);
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
                    m5601k(this.noX, (long) this.npe);
                    AppMethodBeat.m2505o(62411);
                    return;
                }
                this.mIsPlaying = false;
                m5601k(this.noX, (long) this.npe);
                m5601k(this.noW, 0);
                AppMethodBeat.m2505o(62411);
                return;
            } else {
                this.nph = m5602wQ(m5598Oy(this.npk));
                if (!(this.nph == null || this.nph.isRecycled())) {
                    canvas.drawBitmap(this.nph, 0.0f, 0.0f, this.mPaint);
                    AppMethodBeat.m2505o(62411);
                    return;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
        canvas.drawRect(this.f1267Hx, this.mPaint);
        AppMethodBeat.m2505o(62411);
    }

    /* renamed from: k */
    private void m5601k(Runnable runnable, long j) {
        AppMethodBeat.m2504i(62412);
        this.noP = SystemClock.uptimeMillis() + j;
        if (this.lda != null) {
            this.lda.postDelayed(runnable, j);
        }
        AppMethodBeat.m2505o(62412);
    }

    public final int getIntrinsicHeight() {
        return this.mHeight;
    }

    public final int getIntrinsicWidth() {
        return this.mWidth;
    }

    public final void setAlpha(int i) {
        AppMethodBeat.m2504i(62413);
        this.mPaint.setAlpha(i);
        AppMethodBeat.m2505o(62413);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.m2504i(62414);
        this.mPaint.setColorFilter(colorFilter);
        AppMethodBeat.m2505o(62414);
    }

    public final int getOpacity() {
        return -2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.m2504i(62415);
        super.onBoundsChange(rect);
        this.noG = true;
        AppMethodBeat.m2505o(62415);
    }

    public final void start() {
        AppMethodBeat.m2504i(62416);
        this.npd = true;
        this.lda.post(this.noX);
        AppMethodBeat.m2505o(62416);
    }

    public final void stop() {
        this.npd = false;
    }

    public final boolean isRunning() {
        return this.npd;
    }

    /* renamed from: wQ */
    private Bitmap m5602wQ(int i) {
        AppMethodBeat.m2504i(62417);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mResources, i);
        AppMethodBeat.m2505o(62417);
        return decodeResource;
    }

    /* renamed from: Oy */
    private int m5598Oy(String str) {
        AppMethodBeat.m2504i(62418);
        int identifier = this.mResources.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
        AppMethodBeat.m2505o(62418);
        return identifier;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(62419);
        this.npm = null;
        super.finalize();
        AppMethodBeat.m2505o(62419);
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
