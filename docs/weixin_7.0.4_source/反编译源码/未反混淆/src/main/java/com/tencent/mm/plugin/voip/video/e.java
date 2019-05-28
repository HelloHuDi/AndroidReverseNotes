package com.tencent.mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class e implements SurfaceTextureListener {
    int mWidth = 320;
    public MMTextureView mdt;
    private final String sZV = "DecodeTextureView";
    public SurfaceTexture sZW;
    int sZX = 240;

    public e() {
        AppMethodBeat.i(5057);
        ab.d("DecodeTextureView", "steve:  new DecodeTextureView instance");
        AppMethodBeat.o(5057);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(5058);
        ab.i("DecodeTextureView", "onSurfaceTextureAvailable size=" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + ", st=" + surfaceTexture);
        if (this.sZW == null) {
            this.sZW = surfaceTexture;
            v2protocal.sVL = new Surface(surfaceTexture);
            ab.i("DecodeTextureView", "steve: pass decoder surface successfully!");
            v2protocal.a(this);
        }
        AppMethodBeat.o(5058);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(5059);
        ab.d("DecodeTextureView", "onSurfaceTextureSizeChanged size=" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + ", st=" + surfaceTexture);
        AppMethodBeat.o(5059);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(5060);
        ab.i("DecodeTextureView", "onSurfaceTextureDestroyed st=".concat(String.valueOf(surfaceTexture)));
        if (this.sZW == null) {
            AppMethodBeat.o(5060);
            return true;
        }
        AppMethodBeat.o(5060);
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
