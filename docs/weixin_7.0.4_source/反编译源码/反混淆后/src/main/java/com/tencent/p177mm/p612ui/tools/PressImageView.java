package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.tools.PressImageView */
public class PressImageView extends ImageView {
    /* renamed from: a */
    private int f1326a = 90;
    /* renamed from: b */
    private int f1327b = 0;
    /* renamed from: g */
    private int f1328g = 0;
    /* renamed from: r */
    private int f1329r = 0;
    private C7306ak rgT = new C7306ak();
    private Runnable rgU = new C55691();

    /* renamed from: com.tencent.mm.ui.tools.PressImageView$1 */
    class C55691 implements Runnable {
        C55691() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107746);
            PressImageView.this.setPressed(false);
            PressImageView.this.invalidate();
            AppMethodBeat.m2505o(107746);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.PressImageView$2 */
    class C55702 implements OnTouchListener {
        C55702() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(107747);
            switch (motionEvent.getAction()) {
                case 0:
                    view.setPressed(true);
                    view.invalidate();
                    PressImageView.this.rgT.removeCallbacks(PressImageView.this.rgU);
                    break;
                case 1:
                case 3:
                    PressImageView.this.rgT.post(PressImageView.this.rgU);
                    break;
            }
            if (PressImageView.this.isClickable() || PressImageView.this.isLongClickable()) {
                AppMethodBeat.m2505o(107747);
                return false;
            }
            AppMethodBeat.m2505o(107747);
            return true;
        }
    }

    public PressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107748);
        super.setOnTouchListener(new C55702());
        AppMethodBeat.m2505o(107748);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107749);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.f1326a, this.f1329r, this.f1328g, this.f1327b);
        }
        AppMethodBeat.m2505o(107749);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(107750);
        Assert.assertTrue(false);
        AppMethodBeat.m2505o(107750);
    }
}
