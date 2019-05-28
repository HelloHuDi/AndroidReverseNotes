package com.tencent.luggage.i.a;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkView;

public final class e extends XWalkExtendPluginClient {
    public a bSf;

    public e(XWalkView xWalkView) {
        super(xWalkView);
    }

    public final void onPluginReady(String str, int i, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(117326);
        super.onPluginReady(str, i, surfaceTexture);
        if (this.bSf != null) {
            this.bSf.onPluginReady(str, i, surfaceTexture);
        }
        AppMethodBeat.o(117326);
    }

    public final void onPluginDestroy(String str, int i) {
        AppMethodBeat.i(117327);
        super.onPluginDestroy(str, i);
        if (this.bSf != null) {
            this.bSf.onPluginDestroy(str, i);
        }
        AppMethodBeat.o(117327);
    }

    public final void onPluginTouch(String str, int i, MotionEvent motionEvent) {
        AppMethodBeat.i(117328);
        super.onPluginTouch(str, i, motionEvent);
        if (this.bSf != null) {
            this.bSf.onPluginTouch(str, i, motionEvent);
        }
        AppMethodBeat.o(117328);
    }

    public final void setPluginTextureScale(String str, int i, float f, float f2) {
        AppMethodBeat.i(117329);
        super.setPluginTextureScale(str, i, f, f2);
        AppMethodBeat.o(117329);
    }
}
