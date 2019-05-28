package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView extends MMTextureView implements SurfaceTextureListener {
    protected SurfaceTexture bsb;
    protected b sKO;
    private boolean sKP = false;

    public ObservableTextureView(Context context) {
        super(context);
        AppMethodBeat.i(50963);
        init();
        AppMethodBeat.o(50963);
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(50964);
        init();
        AppMethodBeat.o(50964);
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        AppMethodBeat.i(50965);
        setSurfaceTextureListener(this);
        this.bsb = getSurfaceTexture();
        AppMethodBeat.o(50965);
    }

    public boolean isAvailable() {
        return this.sKP;
    }

    public void setTextureChangeCallback(b bVar) {
        this.sKO = bVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(50966);
        ab.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        dAh();
        this.sKP = true;
        if (this.sKO != null) {
            this.sKO.e(surfaceTexture);
        }
        AppMethodBeat.o(50966);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(50967);
        ab.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
        AppMethodBeat.o(50967);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(50968);
        ab.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.sKP = false;
        AppMethodBeat.o(50968);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
