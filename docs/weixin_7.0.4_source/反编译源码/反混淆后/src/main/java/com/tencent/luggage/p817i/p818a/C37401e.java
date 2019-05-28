package com.tencent.luggage.p817i.p818a;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkView;

/* renamed from: com.tencent.luggage.i.a.e */
public final class C37401e extends XWalkExtendPluginClient {
    public C8875a bSf;

    public C37401e(XWalkView xWalkView) {
        super(xWalkView);
    }

    public final void onPluginReady(String str, int i, SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(117326);
        super.onPluginReady(str, i, surfaceTexture);
        if (this.bSf != null) {
            this.bSf.onPluginReady(str, i, surfaceTexture);
        }
        AppMethodBeat.m2505o(117326);
    }

    public final void onPluginDestroy(String str, int i) {
        AppMethodBeat.m2504i(117327);
        super.onPluginDestroy(str, i);
        if (this.bSf != null) {
            this.bSf.onPluginDestroy(str, i);
        }
        AppMethodBeat.m2505o(117327);
    }

    public final void onPluginTouch(String str, int i, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(117328);
        super.onPluginTouch(str, i, motionEvent);
        if (this.bSf != null) {
            this.bSf.onPluginTouch(str, i, motionEvent);
        }
        AppMethodBeat.m2505o(117328);
    }

    public final void setPluginTextureScale(String str, int i, float f, float f2) {
        AppMethodBeat.m2504i(117329);
        super.setPluginTextureScale(str, i, f, f2);
        AppMethodBeat.m2505o(117329);
    }
}
