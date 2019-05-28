package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.j */
public final class C22937j extends View {
    int mHeight;
    private Bitmap mMaskBitmap;
    private Paint mPaint = new Paint();
    int mWidth;
    private Bitmap uyO;
    private Canvas uyP;
    private Paint uyQ = new Paint();
    private Rect uyR;
    private RectF uyS;
    private int uyT;
    int uyU;
    int uyV;
    int uyW;
    int uyX = -1;
    boolean uyY;
    private AnimatorListenerAdapter uyZ;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.j$2 */
    class C145902 extends AnimatorListenerAdapter {
        C145902() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8180);
            if (C22937j.this.uyZ != null) {
                C22937j.this.uyZ.onAnimationEnd(animator);
            }
            C22937j.this.setVisibility(8);
            if (!(C22937j.this.mMaskBitmap == null || C22937j.this.mMaskBitmap.isRecycled())) {
                C4990ab.m7417i("MicroMsg.TransformToBagAniMask", "bitmap recycle %s", C22937j.this.mMaskBitmap.toString());
                C22937j.this.mMaskBitmap.recycle();
            }
            AppMethodBeat.m2505o(8180);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.j$1 */
    class C229381 implements AnimatorUpdateListener {
        C229381() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(8179);
            C22937j.this.uyT = ((Integer) valueAnimator.getAnimatedValue("canvasTranslationX")).intValue();
            C22937j.this.uyS.left = (float) ((Integer) valueAnimator.getAnimatedValue("translationX")).intValue();
            C22937j.this.uyS.top = (float) ((Integer) valueAnimator.getAnimatedValue("translationY")).intValue();
            C22937j.this.uyS.right = (((Float) valueAnimator.getAnimatedValue("scaleX")).floatValue() * ((float) C22937j.this.mWidth)) + C22937j.this.uyS.left;
            C22937j.this.uyS.bottom = (((Float) valueAnimator.getAnimatedValue("scaleY")).floatValue() * ((float) C22937j.this.mHeight)) + C22937j.this.uyS.top;
            C22937j.this.postInvalidate();
            AppMethodBeat.m2505o(8179);
        }
    }

    public C22937j(Context context, Bitmap bitmap) {
        super(context);
        AppMethodBeat.m2504i(8181);
        this.uyQ.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.uyO = bitmap;
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.uyR = new Rect(0, 0, this.mWidth, this.mHeight);
        this.mMaskBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
        this.uyP = new Canvas(this.mMaskBitmap);
        this.uyS = new RectF();
        this.uyS.left = 0.0f;
        this.uyS.top = 0.0f;
        this.uyS.right = (float) this.mWidth;
        this.uyS.bottom = (float) this.mHeight;
        C4990ab.m7416i("MicroMsg.TransformToBagAniMask", String.format("init: mWidth:%d mHeight:%d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)}));
        AppMethodBeat.m2505o(8181);
    }

    public final void setContentStartPosX(int i) {
        this.uyX = i;
    }

    public final void setListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.uyZ = animatorListenerAdapter;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(8182);
        canvas.save();
        if (this.uyY) {
            canvas.translate((float) this.uyT, 0.0f);
        }
        canvas.clipRect(this.uyS);
        canvas.drawBitmap(this.uyO, this.uyR, this.uyR, this.mPaint);
        canvas.restore();
        AppMethodBeat.m2505o(8182);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(8183);
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.mWidth, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(this.mHeight, ErrorDialogData.SUPPRESSED));
        AppMethodBeat.m2505o(8183);
    }
}
