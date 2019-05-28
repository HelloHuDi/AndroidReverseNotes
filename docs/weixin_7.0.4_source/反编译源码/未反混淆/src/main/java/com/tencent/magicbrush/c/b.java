package com.tencent.magicbrush.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends TextureView implements SurfaceTextureListener {
    protected MBRuntime bSv = null;
    private SurfaceTextureListener bUy;

    public final void setCustomSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        this.bUy = surfaceTextureListener;
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(115998);
        c.i("MagicBrush.MBTextureView", "MBRendererView construct", new Object[0]);
        super.setSurfaceTextureListener(this);
        AppMethodBeat.o(115998);
    }

    public final void setMBRuntime(MBRuntime mBRuntime) {
        AppMethodBeat.i(115999);
        c.i("MagicBrush.MBTextureView", "MBRendererView setMBRuntime", new Object[0]);
        this.bSv = mBRuntime;
        this.bSv.setMBRuntimeView(this);
        AppMethodBeat.o(115999);
    }

    public final MBRuntime getMBRuntime() {
        return this.bSv;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(116000);
        super.onAttachedToWindow();
        c.i("MagicBrush.MBTextureView", "MBRendererView.onAttachedToWindow", new Object[0]);
        AppMethodBeat.o(116000);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(116001);
        super.onDetachedFromWindow();
        c.i("MagicBrush.MBTextureView", "MBRendererView.onDetachedFromWindow", new Object[0]);
        AppMethodBeat.o(116001);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(116002);
        c.i("MagicBrush.MBTextureView", "onSurfaceTextureAvailable() called with: surface = [" + surfaceTexture + "], width = [" + i + "], height = [" + i2 + "]", new Object[0]);
        this.bSv.notifyWindowAvailable(surfaceTexture, i, i2);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
        AppMethodBeat.o(116002);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(116003);
        c.i("MagicBrush.MBTextureView", "onSurfaceTextureSizeChanged() called with: surface = [" + surfaceTexture + "], width = [" + i + "], height = [" + i2 + "]", new Object[0]);
        this.bSv.notifyWindowChanged(surfaceTexture, i, i2);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
        AppMethodBeat.o(116003);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(116004);
        c.i("MagicBrush.MBTextureView", "onSurfaceTextureDestroyed() called with: surface = [" + surfaceTexture + "]", new Object[0]);
        this.bSv.notifyWindowDestroyed(surfaceTexture);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureDestroyed(surfaceTexture);
        }
        AppMethodBeat.o(116004);
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(116005);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureUpdated(surfaceTexture);
        }
        AppMethodBeat.o(116005);
    }
}
