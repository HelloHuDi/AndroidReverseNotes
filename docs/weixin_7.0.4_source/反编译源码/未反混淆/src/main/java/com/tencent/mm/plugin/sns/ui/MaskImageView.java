package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak;

public class MaskImageView extends TagImageView {
    private int a = 90;
    private int b = 0;
    private boolean enable = true;
    private int g = 0;
    private int r = 0;
    private ak rgT = new ak(Looper.getMainLooper());
    private Runnable rgU = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38307);
            MaskImageView.this.setPressed(false);
            MaskImageView.this.invalidate();
            AppMethodBeat.o(38307);
        }
    };

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38309);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(38308);
                if (MaskImageView.this.enable) {
                    boolean d = MaskImageView.this.d(view, motionEvent);
                    AppMethodBeat.o(38308);
                    return d;
                }
                AppMethodBeat.o(38308);
                return false;
            }
        });
        super.setContentDescription(getContext().getResources().getString(R.string.eld));
        AppMethodBeat.o(38309);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    public final boolean d(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(38310);
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
            AppMethodBeat.o(38310);
            return false;
        }
        AppMethodBeat.o(38310);
        return true;
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(38311);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
        AppMethodBeat.o(38311);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(38312);
        super.onAttachedToWindow();
        AppMethodBeat.o(38312);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(38313);
        super.onDetachedFromWindow();
        AppMethodBeat.o(38313);
    }
}
