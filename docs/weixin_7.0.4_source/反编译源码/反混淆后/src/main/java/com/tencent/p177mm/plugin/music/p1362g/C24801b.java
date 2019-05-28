package com.tencent.p177mm.plugin.music.p1362g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C45139e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;

/* renamed from: com.tencent.mm.plugin.music.g.b */
public final class C24801b implements IDataSourceFactory {
    public C45139e fqV;

    public C24801b(C45139e c45139e) {
        this.fqV = c45139e;
    }

    public final IDataSource createDataSource() {
        AppMethodBeat.m2504i(137674);
        C46100a c46100a = new C46100a(this.fqV);
        AppMethodBeat.m2505o(137674);
        return c46100a;
    }

    public final INativeDataSource createNativeDataSource() {
        return null;
    }
}
