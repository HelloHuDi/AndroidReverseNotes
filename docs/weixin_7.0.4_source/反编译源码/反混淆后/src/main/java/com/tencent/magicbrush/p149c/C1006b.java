package com.tencent.magicbrush.p149c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.c.b */
public final class C1006b extends TextureView implements SurfaceTextureListener {
    protected MBRuntime bSv = null;
    private SurfaceTextureListener bUy;

    public final void setCustomSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        this.bUy = surfaceTextureListener;
    }

    public C1006b(Context context) {
        super(context);
        AppMethodBeat.m2504i(115998);
        C17837c.m27916i("MagicBrush.MBTextureView", "MBRendererView construct", new Object[0]);
        super.setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(115998);
    }

    public final void setMBRuntime(MBRuntime mBRuntime) {
        AppMethodBeat.m2504i(115999);
        C17837c.m27916i("MagicBrush.MBTextureView", "MBRendererView setMBRuntime", new Object[0]);
        this.bSv = mBRuntime;
        this.bSv.setMBRuntimeView(this);
        AppMethodBeat.m2505o(115999);
    }

    public final MBRuntime getMBRuntime() {
        return this.bSv;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(116000);
        super.onAttachedToWindow();
        C17837c.m27916i("MagicBrush.MBTextureView", "MBRendererView.onAttachedToWindow", new Object[0]);
        AppMethodBeat.m2505o(116000);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(116001);
        super.onDetachedFromWindow();
        C17837c.m27916i("MagicBrush.MBTextureView", "MBRendererView.onDetachedFromWindow", new Object[0]);
        AppMethodBeat.m2505o(116001);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(116002);
        C17837c.m27916i("MagicBrush.MBTextureView", "onSurfaceTextureAvailable() called with: surface = [" + surfaceTexture + "], width = [" + i + "], height = [" + i2 + "]", new Object[0]);
        this.bSv.notifyWindowAvailable(surfaceTexture, i, i2);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
        AppMethodBeat.m2505o(116002);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(116003);
        C17837c.m27916i("MagicBrush.MBTextureView", "onSurfaceTextureSizeChanged() called with: surface = [" + surfaceTexture + "], width = [" + i + "], height = [" + i2 + "]", new Object[0]);
        this.bSv.notifyWindowChanged(surfaceTexture, i, i2);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
        AppMethodBeat.m2505o(116003);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(116004);
        C17837c.m27916i("MagicBrush.MBTextureView", "onSurfaceTextureDestroyed() called with: surface = [" + surfaceTexture + "]", new Object[0]);
        this.bSv.notifyWindowDestroyed(surfaceTexture);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureDestroyed(surfaceTexture);
        }
        AppMethodBeat.m2505o(116004);
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(116005);
        if (this.bUy != null) {
            this.bUy.onSurfaceTextureUpdated(surfaceTexture);
        }
        AppMethodBeat.m2505o(116005);
    }
}
