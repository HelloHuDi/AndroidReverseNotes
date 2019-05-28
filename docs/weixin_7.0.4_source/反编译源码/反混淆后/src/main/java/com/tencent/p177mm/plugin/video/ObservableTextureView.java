package com.tencent.p177mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.video.ObservableTextureView */
public class ObservableTextureView extends MMTextureView implements SurfaceTextureListener {
    protected SurfaceTexture bsb;
    protected C35339b sKO;
    private boolean sKP = false;

    public ObservableTextureView(Context context) {
        super(context);
        AppMethodBeat.m2504i(50963);
        init();
        AppMethodBeat.m2505o(50963);
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(50964);
        init();
        AppMethodBeat.m2505o(50964);
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        AppMethodBeat.m2504i(50965);
        setSurfaceTextureListener(this);
        this.bsb = getSurfaceTexture();
        AppMethodBeat.m2505o(50965);
    }

    public boolean isAvailable() {
        return this.sKP;
    }

    public void setTextureChangeCallback(C35339b c35339b) {
        this.sKO = c35339b;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(50966);
        C4990ab.m7416i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        dAh();
        this.sKP = true;
        if (this.sKO != null) {
            this.sKO.mo30809e(surfaceTexture);
        }
        AppMethodBeat.m2505o(50966);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(50967);
        C4990ab.m7410d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
        AppMethodBeat.m2505o(50967);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(50968);
        C4990ab.m7416i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.sKP = false;
        AppMethodBeat.m2505o(50968);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
