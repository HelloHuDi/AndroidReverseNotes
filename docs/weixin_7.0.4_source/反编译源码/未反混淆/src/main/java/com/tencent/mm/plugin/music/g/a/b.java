package com.tencent.mm.plugin.music.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class b implements IMediaHTTPService {
    public final IMediaHTTPConnection makeHTTPConnection() {
        AppMethodBeat.i(137685);
        Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
        a aVar = new a();
        AppMethodBeat.o(137685);
        return aVar;
    }
}
