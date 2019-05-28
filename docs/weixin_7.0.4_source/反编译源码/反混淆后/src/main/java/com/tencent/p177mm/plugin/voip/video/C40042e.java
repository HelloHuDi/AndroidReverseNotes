package com.tencent.p177mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.voip.video.e */
public final class C40042e implements SurfaceTextureListener {
    int mWidth = 320;
    public MMTextureView mdt;
    private final String sZV = "DecodeTextureView";
    public SurfaceTexture sZW;
    int sZX = 240;

    public C40042e() {
        AppMethodBeat.m2504i(5057);
        C4990ab.m7410d("DecodeTextureView", "steve:  new DecodeTextureView instance");
        AppMethodBeat.m2505o(5057);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(5058);
        C4990ab.m7416i("DecodeTextureView", "onSurfaceTextureAvailable size=" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + ", st=" + surfaceTexture);
        if (this.sZW == null) {
            this.sZW = surfaceTexture;
            v2protocal.sVL = new Surface(surfaceTexture);
            C4990ab.m7416i("DecodeTextureView", "steve: pass decoder surface successfully!");
            v2protocal.m68581a(this);
        }
        AppMethodBeat.m2505o(5058);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(5059);
        C4990ab.m7410d("DecodeTextureView", "onSurfaceTextureSizeChanged size=" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + ", st=" + surfaceTexture);
        AppMethodBeat.m2505o(5059);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(5060);
        C4990ab.m7416i("DecodeTextureView", "onSurfaceTextureDestroyed st=".concat(String.valueOf(surfaceTexture)));
        if (this.sZW == null) {
            AppMethodBeat.m2505o(5060);
            return true;
        }
        AppMethodBeat.m2505o(5060);
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
