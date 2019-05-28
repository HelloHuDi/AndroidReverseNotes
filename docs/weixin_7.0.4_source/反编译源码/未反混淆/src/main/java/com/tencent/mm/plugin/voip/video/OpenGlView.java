package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public class OpenGlView extends GLSurfaceView {
    private static String TAG = "OpenGlView";
    public boolean iXr;
    public boolean taZ;
    public boolean tba;
    public int tbb;
    private int tbc;
    private int tbd;
    public boolean tbe;
    WeakReference<OpenGlRender> tbf;

    public void gb(int i, int i2) {
        AppMethodBeat.i(5083);
        setLayoutParams(new LayoutParams(i, i2));
        this.tbc = i;
        this.tbd = i2;
        AppMethodBeat.o(5083);
    }

    public OpenGlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(5084);
        this.taZ = false;
        this.tba = true;
        this.iXr = false;
        this.tbb = 1;
        this.tbc = 0;
        this.tbd = 0;
        this.tbe = false;
        this.tbb = OpenGlRender.getGLVersion();
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        if (this.tbb == 2) {
            setEGLContextFactory(new c());
            setEGLConfigChooser(new b(5, 6, 5, 0));
        }
        AppMethodBeat.o(5084);
    }

    public void setRenderer(OpenGlRender openGlRender) {
        AppMethodBeat.i(5085);
        this.tbf = new WeakReference(openGlRender);
        super.setRenderer(openGlRender);
        setRenderMode(0);
        AppMethodBeat.o(5085);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(5086);
        ab.i(TAG, "surfaceCreated");
        super.surfaceCreated(surfaceHolder);
        OpenGlRender openGlRender = (OpenGlRender) this.tbf.get();
        ab.i(OpenGlRender.TAG, "%s surfaceCreated", Integer.valueOf(openGlRender.hashCode()));
        openGlRender.Init(OpenGlRender.getGLVersion(), new WeakReference(openGlRender), openGlRender.mRenderMode);
        openGlRender.setParam(openGlRender.mBrightness, openGlRender.mContrast, openGlRender.mSaturation, openGlRender.mRenderMode);
        openGlRender.setMode(((OpenGlView) openGlRender.taG.get()).getWidth(), ((OpenGlView) openGlRender.taG.get()).getHeight(), 0, openGlRender.mRenderMode);
        openGlRender.taD = true;
        openGlRender.taz = true;
        AppMethodBeat.o(5086);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(5087);
        ab.i(TAG, "surfaceDestroyed");
        OpenGlRender openGlRender = (OpenGlRender) this.tbf.get();
        ab.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", Integer.valueOf(openGlRender.mRenderMode));
        openGlRender.taz = false;
        openGlRender.Uninit(openGlRender.mRenderMode);
        ab.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
        openGlRender.tax = 0;
        openGlRender.taE = 0;
        openGlRender.taF = 0;
        if (openGlRender.taR != null) {
            openGlRender.taR.destroy();
        }
        super.surfaceDestroyed(surfaceHolder);
        AppMethodBeat.o(5087);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(5088);
        ab.i(TAG, "surfaceChanged, format: %s, w: %s, h: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        AppMethodBeat.o(5088);
    }

    public void onPause() {
        AppMethodBeat.i(5089);
        super.onPause();
        AppMethodBeat.o(5089);
    }

    public void onResume() {
        AppMethodBeat.i(5090);
        super.onResume();
        AppMethodBeat.o(5090);
    }

    public final void cLK() {
        AppMethodBeat.i(5091);
        this.taZ = true;
        requestRender();
        AppMethodBeat.o(5091);
    }

    public void gc(int i, int i2) {
    }
}
