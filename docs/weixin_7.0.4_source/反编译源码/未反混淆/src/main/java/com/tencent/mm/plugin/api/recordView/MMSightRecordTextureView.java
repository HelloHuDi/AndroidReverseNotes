package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView extends MMTextureView implements SurfaceTextureListener {
    private int fcn;
    private int fco;
    private d gLH;
    private c gLI;

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(76328);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(76328);
    }

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(76329);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(76329);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(76330);
        ab.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2));
        this.fcn = i;
        this.fco = i2;
        this.gLH = new d();
        this.gLI = new c(surfaceTexture, this.gLH);
        this.gLH.cM(i, i2);
        this.gLI.needRender = true;
        this.gLI.start();
        AppMethodBeat.o(76330);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(76331);
        ab.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2));
        this.fcn = i;
        this.fco = i2;
        this.gLH.cM(i, i2);
        AppMethodBeat.o(76331);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(76332);
        this.gLI.needRender = false;
        try {
            this.gLI.join();
        } catch (InterruptedException e) {
            ab.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", e, "onSurfaceTextureDestroyed error: %s", e.getMessage());
        }
        this.gLI = null;
        AppMethodBeat.o(76332);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
