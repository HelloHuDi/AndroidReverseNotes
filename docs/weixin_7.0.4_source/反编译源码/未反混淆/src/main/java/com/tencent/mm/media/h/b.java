package com.tencent.mm.media.h;

import a.f.b.j;
import a.l;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13})
public final class b implements OnFrameAvailableListener {
    private final /* synthetic */ a.f.a.b eZc;

    public b(a.f.a.b bVar) {
        this.eZc = bVar;
    }

    public final /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(13086);
        j.o(this.eZc.am(surfaceTexture), "invoke(...)");
        AppMethodBeat.o(13086);
    }
}
