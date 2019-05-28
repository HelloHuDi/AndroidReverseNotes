package com.tencent.p177mm.plugin.music.p1362g.p1493a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;

/* renamed from: com.tencent.mm.plugin.music.g.a.b */
public final class C39437b implements IMediaHTTPService {
    public final IMediaHTTPConnection makeHTTPConnection() {
        AppMethodBeat.m2504i(137685);
        Logger.m71025i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
        C34584a c34584a = new C34584a();
        AppMethodBeat.m2505o(137685);
        return c34584a;
    }
}
