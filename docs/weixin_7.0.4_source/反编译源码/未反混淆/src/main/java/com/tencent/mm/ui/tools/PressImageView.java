package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public class PressImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private int r = 0;
    private ak rgT = new ak();
    private Runnable rgU = new Runnable() {
        public final void run() {
            AppMethodBeat.i(107746);
            PressImageView.this.setPressed(false);
            PressImageView.this.invalidate();
            AppMethodBeat.o(107746);
        }
    };

    public PressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107748);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(107747);
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
                    AppMethodBeat.o(107747);
                    return false;
                }
                AppMethodBeat.o(107747);
                return true;
            }
        });
        AppMethodBeat.o(107748);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107749);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
        AppMethodBeat.o(107749);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(107750);
        Assert.assertTrue(false);
        AppMethodBeat.o(107750);
    }
}
