package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;

public class RemoteDebugMoveView extends FrameLayout {
    int hkc;
    int hkd;
    float hke;
    float hkf;
    float hkg;
    float hkh;

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(101855);
        super.onConfigurationChanged(configuration);
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            private int counter = 0;

            public final void onGlobalLayout() {
                AppMethodBeat.i(101853);
                int i = this.counter + 1;
                this.counter = i;
                if (i < 2) {
                    AppMethodBeat.o(101853);
                    return;
                }
                RemoteDebugMoveView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                RemoteDebugMoveView.this.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(101852);
                        if (RemoteDebugMoveView.this.getParent() instanceof View) {
                            View view = (View) RemoteDebugMoveView.this.getParent();
                            RemoteDebugMoveView.this.hkc = view.getMeasuredWidth();
                            RemoteDebugMoveView.this.hkd = view.getMeasuredHeight();
                            float max = Math.max(0.0f, Math.min((float) (RemoteDebugMoveView.this.hkc - RemoteDebugMoveView.this.getWidth()), RemoteDebugMoveView.this.getX()));
                            float max2 = Math.max(0.0f, Math.min((float) (RemoteDebugMoveView.this.hkd - RemoteDebugMoveView.this.getHeight()), RemoteDebugMoveView.this.getY()));
                            RemoteDebugMoveView.this.setX(max);
                            RemoteDebugMoveView.this.setY(max2);
                            RemoteDebugMoveView.this.requestLayout();
                        }
                        AppMethodBeat.o(101852);
                    }
                });
                AppMethodBeat.o(101853);
            }
        });
        AppMethodBeat.o(101855);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101856);
        switch (motionEvent.getAction()) {
            case 0:
                this.hke = motionEvent.getRawX();
                this.hkf = motionEvent.getRawY();
                break;
            case 2:
                this.hkg = motionEvent.getRawX();
                this.hkh = motionEvent.getRawY();
                float x = getX() + (this.hkg - this.hke);
                if (0.0f < x && x < ((float) (this.hkc - getWidth()))) {
                    setX(x);
                }
                x = this.hkh - this.hkf;
                float height = (float) (this.hkd - getHeight());
                float y = getY() + x;
                if ((0.0f < y && y < height) || ((y <= 0.0f && x > 0.0f) || (y >= height && x < 0.0f))) {
                    setY(y);
                }
                this.hke = this.hkg;
                this.hkf = this.hkh;
                break;
        }
        AppMethodBeat.o(101856);
        return true;
    }

    static /* synthetic */ int b(RemoteDebugMoveView remoteDebugMoveView) {
        AppMethodBeat.i(101857);
        int width = remoteDebugMoveView.getWidth();
        if (width > 0) {
            AppMethodBeat.o(101857);
            return width;
        }
        width = a.fromDPToPix(remoteDebugMoveView.getContext(), 200);
        AppMethodBeat.o(101857);
        return width;
    }
}
