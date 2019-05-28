package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.sns.ui.TouchImageView */
public class TouchImageView extends ImageView {
    /* renamed from: a */
    private int f17902a = 90;
    /* renamed from: b */
    private int f17903b = 0;
    private boolean enable = true;
    /* renamed from: g */
    private int f17904g = 0;
    /* renamed from: r */
    private int f17905r = 0;
    private RectF rDW = new RectF();
    private Paint rDX = new Paint();
    C7306ak rgT;
    Runnable rgU;

    /* renamed from: com.tencent.mm.plugin.sns.ui.TouchImageView$2 */
    class C291672 implements OnTouchListener {
        C291672() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(39896);
            if (TouchImageView.this.enable) {
                TouchImageView touchImageView = TouchImageView.this;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        touchImageView.rgT.removeCallbacks(touchImageView.rgU);
                        break;
                    case 1:
                    case 3:
                        touchImageView.rgT.post(touchImageView.rgU);
                        break;
                }
                if (touchImageView.isClickable() || touchImageView.isLongClickable()) {
                    AppMethodBeat.m2505o(39896);
                    return false;
                }
                AppMethodBeat.m2505o(39896);
                return true;
            }
            AppMethodBeat.m2505o(39896);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.TouchImageView$1 */
    class C350871 implements Runnable {
        C350871() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39895);
            TouchImageView.this.setPressed(false);
            TouchImageView.this.invalidate();
            AppMethodBeat.m2505o(39895);
        }
    }

    public TouchImageView(Context context) {
        super(context);
        AppMethodBeat.m2504i(39897);
        init();
        AppMethodBeat.m2505o(39897);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39898);
        init();
        AppMethodBeat.m2505o(39898);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    private void init() {
        AppMethodBeat.m2504i(39899);
        this.rgT = new C7306ak();
        this.rgU = new C350871();
        super.setOnTouchListener(new C291672());
        AppMethodBeat.m2505o(39899);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(39900);
        super.onDraw(canvas);
        if (isPressed()) {
            this.rDW.left = (float) getPaddingLeft();
            this.rDW.top = (float) getPaddingTop();
            this.rDW.right = (float) (getWidth() - getPaddingRight());
            this.rDW.bottom = (float) (getHeight() - getPaddingBottom());
            this.rDX.setARGB(this.f17902a, this.f17905r, this.f17904g, this.f17903b);
            canvas.drawRoundRect(this.rDW, (float) (getWidth() / 10), (float) (getHeight() / 10), this.rDX);
        }
        AppMethodBeat.m2505o(39900);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(39901);
        Assert.assertTrue(false);
        AppMethodBeat.m2505o(39901);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(39902);
        super.onAttachedToWindow();
        C4990ab.m7410d("MicroMsg.MaskImageView", "onAttachedToWindow");
        AppMethodBeat.m2505o(39902);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(39903);
        super.onDetachedFromWindow();
        C4990ab.m7410d("MicroMsg.MaskImageView", "onDetachedFromWindow");
        AppMethodBeat.m2505o(39903);
    }
}
