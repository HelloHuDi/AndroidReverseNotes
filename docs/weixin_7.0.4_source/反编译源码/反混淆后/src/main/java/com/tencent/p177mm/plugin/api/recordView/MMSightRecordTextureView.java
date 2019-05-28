package com.tencent.p177mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.api.recordView.MMSightRecordTextureView */
class MMSightRecordTextureView extends MMTextureView implements SurfaceTextureListener {
    private int fcn;
    private int fco;
    private C33058d gLH;
    private C10043c gLI;

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(76328);
        setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(76328);
    }

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(76329);
        setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(76329);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(76330);
        C4990ab.m7417i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2));
        this.fcn = i;
        this.fco = i2;
        this.gLH = new C33058d();
        this.gLI = new C10043c(surfaceTexture, this.gLH);
        this.gLH.mo53622cM(i, i2);
        this.gLI.needRender = true;
        this.gLI.start();
        AppMethodBeat.m2505o(76330);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(76331);
        C4990ab.m7417i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2));
        this.fcn = i;
        this.fco = i2;
        this.gLH.mo53622cM(i, i2);
        AppMethodBeat.m2505o(76331);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(76332);
        this.gLI.needRender = false;
        try {
            this.gLI.join();
        } catch (InterruptedException e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", e, "onSurfaceTextureDestroyed error: %s", e.getMessage());
        }
        this.gLI = null;
        AppMethodBeat.m2505o(76332);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
