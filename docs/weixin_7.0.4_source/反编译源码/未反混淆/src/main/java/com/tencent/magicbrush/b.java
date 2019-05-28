package com.tencent.magicbrush;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import com.tencent.magicbrush.MBRuntime.IMBEventListener;
import com.tencent.magicbrush.a.a;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public final class b extends FrameLayout {
    public MBRuntime bSv;
    private JsTouchEventHandler bSw;
    private com.tencent.magicbrush.c.b bSx = new com.tencent.magicbrush.c.b(getContext());

    public b(Context context) {
        super(context);
        AppMethodBeat.i(115839);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        addView(this.bSx);
        AppMethodBeat.o(115839);
    }

    public final void setMBRuntime(MBRuntime mBRuntime) {
        AppMethodBeat.i(115840);
        this.bSv = mBRuntime;
        this.bSw = new JsTouchEventHandler(mBRuntime);
        this.bSx.setMBRuntime(mBRuntime);
        AppMethodBeat.o(115840);
    }

    public final void setSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        AppMethodBeat.i(115841);
        this.bSx.setCustomSurfaceTextureListener(surfaceTextureListener);
        AppMethodBeat.o(115841);
    }

    public final MBRuntime getMBRuntime() {
        return this.bSv;
    }

    public final void setTransparentBackground(boolean z) {
        AppMethodBeat.i(115842);
        if (z) {
            setBackground(null);
            AppMethodBeat.o(115842);
            return;
        }
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(115842);
    }

    public final com.tencent.magicbrush.c.b getTextureView() {
        return this.bSx;
    }

    public final void registerEventListener(IMBEventListener iMBEventListener) {
        AppMethodBeat.i(115843);
        this.bSv.registerEventListener(iMBEventListener);
        AppMethodBeat.o(115843);
    }

    public final void setUserPreferedFps(double d) {
        AppMethodBeat.i(115844);
        this.bSv.setUserPreferredFps(d);
        AppMethodBeat.o(115844);
    }

    public final a getCurrentFps() {
        AppMethodBeat.i(115845);
        a currentFps = this.bSv.getCurrentFps();
        AppMethodBeat.o(115845);
        return currentFps;
    }

    public final void yx() {
        AppMethodBeat.i(115846);
        this.bSv.resume();
        AppMethodBeat.o(115846);
    }

    public final void yy() {
        AppMethodBeat.i(115847);
        this.bSv.pause();
        AppMethodBeat.o(115847);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        AppMethodBeat.i(115848);
        if (this.bSw != null) {
            JsTouchEventHandler jsTouchEventHandler = this.bSw;
            jsTouchEventHandler.fS(motionEvent.getPointerCount());
            int n = JsTouchEventHandler.n(motionEvent);
            if (n != -1) {
                int i2;
                int pointerCount = motionEvent.getPointerCount();
                for (i2 = 0; i2 < pointerCount; i2++) {
                    jsTouchEventHandler.bSF.put(motionEvent.getPointerId(i2));
                    jsTouchEventHandler.bSG.put(motionEvent.getX(i2) / jsTouchEventHandler.mDensity);
                    jsTouchEventHandler.bSG.put(motionEvent.getY(i2) / jsTouchEventHandler.mDensity);
                }
                i2 = JsTouchEventHandler.n(motionEvent);
                if (n != 1) {
                    i = motionEvent.getActionIndex();
                }
                jsTouchEventHandler.bSv.notifyTouchEvent(jsTouchEventHandler.nativeCreateTouchEvent(i2, i, pointerCount, jsTouchEventHandler.bSF, jsTouchEventHandler.bSG, motionEvent.getEventTime()), jsTouchEventHandler.bSH);
            }
        }
        AppMethodBeat.o(115848);
        return true;
    }
}
