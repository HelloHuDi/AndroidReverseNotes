package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    g(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    public void run() {
        AppMethodBeat.i(65198);
        this.b.e.setText("已下载" + this.a + "%");
        AppMethodBeat.o(65198);
    }
}
