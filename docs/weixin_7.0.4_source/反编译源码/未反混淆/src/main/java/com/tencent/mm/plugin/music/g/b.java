package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;

public final class b implements IDataSourceFactory {
    public e fqV;

    public b(e eVar) {
        this.fqV = eVar;
    }

    public final IDataSource createDataSource() {
        AppMethodBeat.i(137674);
        a aVar = new a(this.fqV);
        AppMethodBeat.o(137674);
        return aVar;
    }

    public final INativeDataSource createNativeDataSource() {
        return null;
    }
}
