package com.tencent.p177mm.media.p255h;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13})
/* renamed from: com.tencent.mm.media.h.b */
public final class C45431b implements OnFrameAvailableListener {
    private final /* synthetic */ C17126b eZc;

    public C45431b(C17126b c17126b) {
        this.eZc = c17126b;
    }

    public final /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(13086);
        C25052j.m39375o(this.eZc.mo50am(surfaceTexture), "invoke(...)");
        AppMethodBeat.m2505o(13086);
    }
}
