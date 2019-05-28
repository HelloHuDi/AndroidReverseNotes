package com.tencent.magicbrush;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import com.tencent.magicbrush.C1000a.C1001a;
import com.tencent.magicbrush.MBRuntime.IMBEventListener;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import com.tencent.magicbrush.p149c.C1006b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.magicbrush.b */
public final class C32197b extends FrameLayout {
    public MBRuntime bSv;
    private JsTouchEventHandler bSw;
    private C1006b bSx = new C1006b(getContext());

    public C32197b(Context context) {
        super(context);
        AppMethodBeat.m2504i(115839);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        addView(this.bSx);
        AppMethodBeat.m2505o(115839);
    }

    public final void setMBRuntime(MBRuntime mBRuntime) {
        AppMethodBeat.m2504i(115840);
        this.bSv = mBRuntime;
        this.bSw = new JsTouchEventHandler(mBRuntime);
        this.bSx.setMBRuntime(mBRuntime);
        AppMethodBeat.m2505o(115840);
    }

    public final void setSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        AppMethodBeat.m2504i(115841);
        this.bSx.setCustomSurfaceTextureListener(surfaceTextureListener);
        AppMethodBeat.m2505o(115841);
    }

    public final MBRuntime getMBRuntime() {
        return this.bSv;
    }

    public final void setTransparentBackground(boolean z) {
        AppMethodBeat.m2504i(115842);
        if (z) {
            setBackground(null);
            AppMethodBeat.m2505o(115842);
            return;
        }
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.m2505o(115842);
    }

    public final C1006b getTextureView() {
        return this.bSx;
    }

    public final void registerEventListener(IMBEventListener iMBEventListener) {
        AppMethodBeat.m2504i(115843);
        this.bSv.registerEventListener(iMBEventListener);
        AppMethodBeat.m2505o(115843);
    }

    public final void setUserPreferedFps(double d) {
        AppMethodBeat.m2504i(115844);
        this.bSv.setUserPreferredFps(d);
        AppMethodBeat.m2505o(115844);
    }

    public final C1001a getCurrentFps() {
        AppMethodBeat.m2504i(115845);
        C1001a currentFps = this.bSv.getCurrentFps();
        AppMethodBeat.m2505o(115845);
        return currentFps;
    }

    /* renamed from: yx */
    public final void mo52862yx() {
        AppMethodBeat.m2504i(115846);
        this.bSv.resume();
        AppMethodBeat.m2505o(115846);
    }

    /* renamed from: yy */
    public final void mo52863yy() {
        AppMethodBeat.m2504i(115847);
        this.bSv.pause();
        AppMethodBeat.m2505o(115847);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        AppMethodBeat.m2504i(115848);
        if (this.bSw != null) {
            JsTouchEventHandler jsTouchEventHandler = this.bSw;
            jsTouchEventHandler.mo33015fS(motionEvent.getPointerCount());
            int n = JsTouchEventHandler.m27923n(motionEvent);
            if (n != -1) {
                int i2;
                int pointerCount = motionEvent.getPointerCount();
                for (i2 = 0; i2 < pointerCount; i2++) {
                    jsTouchEventHandler.bSF.put(motionEvent.getPointerId(i2));
                    jsTouchEventHandler.bSG.put(motionEvent.getX(i2) / jsTouchEventHandler.mDensity);
                    jsTouchEventHandler.bSG.put(motionEvent.getY(i2) / jsTouchEventHandler.mDensity);
                }
                i2 = JsTouchEventHandler.m27923n(motionEvent);
                if (n != 1) {
                    i = motionEvent.getActionIndex();
                }
                jsTouchEventHandler.bSv.notifyTouchEvent(jsTouchEventHandler.nativeCreateTouchEvent(i2, i, pointerCount, jsTouchEventHandler.bSF, jsTouchEventHandler.bSG, motionEvent.getEventTime()), jsTouchEventHandler.bSH);
            }
        }
        AppMethodBeat.m2505o(115848);
        return true;
    }
}
