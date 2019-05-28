package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.sns.ui.AsyncMaskImageView */
public class AsyncMaskImageView extends ImageView {
    /* renamed from: a */
    private int f2928a = 90;
    /* renamed from: b */
    private int f2929b = 0;
    private boolean enable = true;
    /* renamed from: g */
    private int f2930g = 0;
    /* renamed from: r */
    private int f2931r = 0;
    C7306ak rgT = new C7306ak();
    Runnable rgU = new C134811();

    /* renamed from: com.tencent.mm.plugin.sns.ui.AsyncMaskImageView$2 */
    class C134802 implements OnTouchListener {
        C134802() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(38130);
            if (AsyncMaskImageView.this.enable) {
                AsyncMaskImageView asyncMaskImageView = AsyncMaskImageView.this;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        asyncMaskImageView.rgT.removeCallbacks(asyncMaskImageView.rgU);
                        break;
                    case 1:
                    case 3:
                        asyncMaskImageView.rgT.post(asyncMaskImageView.rgU);
                        break;
                }
                if (asyncMaskImageView.isClickable() || asyncMaskImageView.isLongClickable()) {
                    AppMethodBeat.m2505o(38130);
                    return false;
                }
                AppMethodBeat.m2505o(38130);
                return true;
            }
            AppMethodBeat.m2505o(38130);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.AsyncMaskImageView$1 */
    class C134811 implements Runnable {
        C134811() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38129);
            AsyncMaskImageView.this.setPressed(false);
            AsyncMaskImageView.this.invalidate();
            AppMethodBeat.m2505o(38129);
        }
    }

    public AsyncMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38131);
        super.setOnTouchListener(new C134802());
        AppMethodBeat.m2505o(38131);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(38132);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.f2928a, this.f2931r, this.f2930g, this.f2929b);
        }
        AppMethodBeat.m2505o(38132);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(38133);
        Assert.assertTrue(false);
        AppMethodBeat.m2505o(38133);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(38134);
        super.onAttachedToWindow();
        C4990ab.m7410d("MicroMsg.MaskImageView", "onAttachedToWindow");
        AppMethodBeat.m2505o(38134);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(38135);
        super.onDetachedFromWindow();
        C4990ab.m7410d("MicroMsg.MaskImageView", "onDetachedFromWindow");
        AppMethodBeat.m2505o(38135);
    }
}
