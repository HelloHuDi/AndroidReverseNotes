package com.tencent.smtt.utils;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

class h implements Runnable {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public void run() {
        AppMethodBeat.i(65199);
        Toast.makeText(this.a.b, "下载失败，请检查网络", 0).show();
        AppMethodBeat.o(65199);
    }
}
