package com.tencent.smtt.sdk;

import com.tencent.f.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class bf implements a {
    final /* synthetic */ be a;

    bf(be beVar) {
        this.a = beVar;
    }

    public void onUserStateChanged() {
        AppMethodBeat.i(64622);
        this.a.a.c();
        AppMethodBeat.o(64622);
    }
}
