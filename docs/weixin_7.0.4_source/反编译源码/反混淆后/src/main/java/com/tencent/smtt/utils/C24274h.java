package com.tencent.smtt.utils;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.utils.h */
class C24274h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C44459e f4529a;

    C24274h(C44459e c44459e) {
        this.f4529a = c44459e;
    }

    public void run() {
        AppMethodBeat.m2504i(65199);
        Toast.makeText(this.f4529a.f17310b, "下载失败，请检查网络", 0).show();
        AppMethodBeat.m2505o(65199);
    }
}
