package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sns.ui.MaskImageView */
public class MaskImageView extends TagImageView {
    /* renamed from: a */
    private int f2933a = 90;
    /* renamed from: b */
    private int f2934b = 0;
    private boolean enable = true;
    /* renamed from: g */
    private int f2935g = 0;
    /* renamed from: r */
    private int f2936r = 0;
    private C7306ak rgT = new C7306ak(Looper.getMainLooper());
    private Runnable rgU = new C134831();

    /* renamed from: com.tencent.mm.plugin.sns.ui.MaskImageView$1 */
    class C134831 implements Runnable {
        C134831() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38307);
            MaskImageView.this.setPressed(false);
            MaskImageView.this.invalidate();
            AppMethodBeat.m2505o(38307);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.MaskImageView$2 */
    class C134842 implements OnTouchListener {
        C134842() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(38308);
            if (MaskImageView.this.enable) {
                boolean d = MaskImageView.this.mo25657d(view, motionEvent);
                AppMethodBeat.m2505o(38308);
                return d;
            }
            AppMethodBeat.m2505o(38308);
            return false;
        }
    }

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38309);
        super.setOnTouchListener(new C134842());
        super.setContentDescription(getContext().getResources().getString(C25738R.string.eld));
        AppMethodBeat.m2505o(38309);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    /* renamed from: d */
    public final boolean mo25657d(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(38310);
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                this.rgT.removeCallbacks(this.rgU);
                break;
            case 1:
            case 3:
                this.rgT.post(this.rgU);
                break;
        }
        if (isClickable() || isLongClickable()) {
            AppMethodBeat.m2505o(38310);
            return false;
        }
        AppMethodBeat.m2505o(38310);
        return true;
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(38311);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.f2933a, this.f2936r, this.f2935g, this.f2934b);
        }
        AppMethodBeat.m2505o(38311);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(38312);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(38312);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(38313);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(38313);
    }
}
