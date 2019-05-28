package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.tools.MaskImageButton */
public class MaskImageButton extends ImageView {
    /* renamed from: a */
    private int f16216a;
    private Paint aFY;
    /* renamed from: b */
    private int f16217b;
    public Object eSe;
    /* renamed from: g */
    private int f16218g;
    /* renamed from: r */
    private int f16219r;
    private C7306ak rgT;
    private Runnable rgU;
    private RectF zGi;
    private int zGj;
    private int zGk;

    /* renamed from: com.tencent.mm.ui.tools.MaskImageButton$1 */
    class C159241 implements Runnable {
        C159241() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107741);
            MaskImageButton.this.setPressed(false);
            MaskImageButton.this.invalidate();
            AppMethodBeat.m2505o(107741);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MaskImageButton$2 */
    class C307562 implements OnTouchListener {
        C307562() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(107742);
            switch (motionEvent.getAction()) {
                case 0:
                    view.setPressed(true);
                    view.invalidate();
                    MaskImageButton.this.rgT.removeCallbacks(MaskImageButton.this.rgU);
                    break;
                case 1:
                case 3:
                    MaskImageButton.this.rgT.post(MaskImageButton.this.rgU);
                    break;
            }
            if (MaskImageButton.this.isClickable() || MaskImageButton.this.isLongClickable()) {
                AppMethodBeat.m2505o(107742);
                return false;
            }
            AppMethodBeat.m2505o(107742);
            return true;
        }
    }

    public MaskImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107743);
        this.zGi = new RectF();
        this.aFY = null;
        this.f16216a = 90;
        this.f16219r = 0;
        this.f16218g = 0;
        this.f16217b = 0;
        this.zGj = 0;
        this.zGk = 0;
        this.aFY = new Paint();
        this.aFY.setColor(Color.argb(this.f16216a, this.f16219r, this.f16218g, this.f16217b));
        this.rgT = new C7306ak(Looper.getMainLooper());
        this.rgU = new C159241();
        super.setOnTouchListener(new C307562());
        AppMethodBeat.m2505o(107743);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107744);
        super.onDraw(canvas);
        if (isPressed()) {
            this.zGi.set((float) (getPaddingLeft() + 0), (float) (getPaddingTop() + 0), (float) (this.zGj - getPaddingRight()), (float) (this.zGk - getPaddingBottom()));
            canvas.drawRoundRect(this.zGi, (float) (getMeasuredHeight() / 10), (float) (getMeasuredHeight() / 10), this.aFY);
        }
        AppMethodBeat.m2505o(107744);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107745);
        super.onMeasure(i, i2);
        this.zGj = getMeasuredWidth();
        this.zGk = getMeasuredHeight();
        AppMethodBeat.m2505o(107745);
    }
}
