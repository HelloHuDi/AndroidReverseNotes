package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.utils.g */
class C44461g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f17316a;
    /* renamed from: b */
    final /* synthetic */ C44459e f17317b;

    C44461g(C44459e c44459e, int i) {
        this.f17317b = c44459e;
        this.f17316a = i;
    }

    public void run() {
        AppMethodBeat.m2504i(65198);
        this.f17317b.f17313e.setText("已下载" + this.f17316a + "%");
        AppMethodBeat.m2505o(65198);
    }
}
