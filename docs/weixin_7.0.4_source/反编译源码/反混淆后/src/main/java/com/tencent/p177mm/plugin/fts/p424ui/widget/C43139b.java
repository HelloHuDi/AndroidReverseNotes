package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.b */
public final class C43139b extends Drawable {
    private Paint aFY = new Paint(1);
    private Context context;
    int currentState = 2;
    private int mMA;
    private int mMB = 0;
    boolean mMC = false;
    private int mMD;
    int mME = 0;
    private int mMF = 0;
    private Drawable mMt;
    private Drawable mMu;
    private int mMv = 0;
    private int mMw = 0;
    private int mMx;
    private int mMy;
    private int mMz;

    public C43139b(Context context) {
        AppMethodBeat.m2504i(62159);
        this.context = context;
        this.mMv = C1338a.m2872i(context, C25738R.color.a61);
        this.mMw = C1338a.m2872i(context, C25738R.color.a69);
        this.mMt = context.getResources().getDrawable(C25738R.drawable.b6e);
        this.mMu = context.getResources().getDrawable(C25738R.drawable.b6f);
        this.mMB = C1338a.fromDPToPix(context, 24);
        this.mMx = C1338a.m2872i(context, C25738R.color.a42);
        this.mMA = C1338a.m2872i(context, C25738R.color.a43);
        this.mMD = C1338a.fromDPToPix(context, 47);
        this.mMy = C1338a.fromDPToPix(context, 47);
        this.mMz = C1338a.fromDPToPix(context, 60);
        this.mMF = 4;
        C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "waveStep %s", Integer.valueOf(this.mMF));
        AppMethodBeat.m2505o(62159);
    }

    public final void bBx() {
        AppMethodBeat.m2504i(62160);
        C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "readyState %s", Integer.valueOf(this.currentState));
        this.currentState = 2;
        this.mME = 0;
        invalidateSelf();
        AppMethodBeat.m2505o(62160);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(62161);
        if ((this.currentState == 6 || this.currentState == 7) && !C43139b.m76697j(canvas)) {
            int width = canvas.getWidth() >> 1;
            int height = canvas.getHeight() >> 1;
            this.aFY.setShader(null);
            this.aFY.setStyle(Style.FILL);
            this.aFY.setColor(this.mMx);
            if (this.currentState == 7) {
                if (this.mMC) {
                    this.mMD -= this.mMF;
                } else {
                    this.mMD += this.mMF;
                }
                this.mMD = Math.min(Math.max(this.mMy, this.mMD), this.mMz);
                canvas.drawCircle((float) width, (float) height, (float) this.mMD, this.aFY);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.mMy, this.aFY);
            }
        }
        if (this.currentState == 6 || this.currentState == 7) {
            m76696d(canvas, true);
        } else {
            m76696d(canvas, false);
        }
        if ((this.currentState == 6 || this.currentState == 7) && !C43139b.m76697j(canvas)) {
            this.aFY.setStyle(Style.FILL);
            this.aFY.setColor(this.mMA);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.mMB, this.aFY);
        }
        AppMethodBeat.m2505o(62161);
    }

    /* renamed from: d */
    private void m76696d(Canvas canvas, boolean z) {
        AppMethodBeat.m2504i(62162);
        if (this.mMt == null || C43139b.m76697j(canvas)) {
            AppMethodBeat.m2505o(62162);
            return;
        }
        Drawable drawable;
        int i;
        if (z) {
            drawable = this.mMu;
            i = this.mMv;
        } else {
            drawable = this.mMt;
            i = this.mMw;
        }
        int width = canvas.getWidth() / 2;
        int height = canvas.getHeight() / 2;
        int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
        int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
        this.aFY.setShader(null);
        this.aFY.setStyle(Style.FILL);
        this.aFY.setColor(i);
        canvas.drawCircle((float) width, (float) height, (float) this.mMB, this.aFY);
        drawable.setBounds(width - intrinsicWidth, height - intrinsicHeight, width + intrinsicWidth, height + intrinsicHeight);
        drawable.draw(canvas);
        AppMethodBeat.m2505o(62162);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.m2504i(62163);
        if (this.context == null) {
            AppMethodBeat.m2505o(62163);
            return 0;
        }
        int gd = C1338a.m2868gd(this.context);
        AppMethodBeat.m2505o(62163);
        return gd;
    }

    public final int getIntrinsicHeight() {
        return this.mMB * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    /* renamed from: j */
    private static boolean m76697j(Canvas canvas) {
        AppMethodBeat.m2504i(62164);
        if (canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0) {
            AppMethodBeat.m2505o(62164);
            return true;
        }
        AppMethodBeat.m2505o(62164);
        return false;
    }

    /* renamed from: wh */
    public static boolean m76698wh(int i) {
        if (i < 10) {
            return true;
        }
        return false;
    }
}
