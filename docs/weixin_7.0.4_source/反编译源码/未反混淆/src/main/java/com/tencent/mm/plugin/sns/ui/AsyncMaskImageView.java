package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public class AsyncMaskImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private boolean enable = true;
    private int g = 0;
    private int r = 0;
    ak rgT = new ak();
    Runnable rgU = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38129);
            AsyncMaskImageView.this.setPressed(false);
            AsyncMaskImageView.this.invalidate();
            AppMethodBeat.o(38129);
        }
    };

    public AsyncMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38131);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(38130);
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
                        AppMethodBeat.o(38130);
                        return false;
                    }
                    AppMethodBeat.o(38130);
                    return true;
                }
                AppMethodBeat.o(38130);
                return false;
            }
        });
        AppMethodBeat.o(38131);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(38132);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
        AppMethodBeat.o(38132);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(38133);
        Assert.assertTrue(false);
        AppMethodBeat.o(38133);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(38134);
        super.onAttachedToWindow();
        ab.d("MicroMsg.MaskImageView", "onAttachedToWindow");
        AppMethodBeat.o(38134);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(38135);
        super.onDetachedFromWindow();
        ab.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
        AppMethodBeat.o(38135);
    }
}
