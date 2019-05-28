package com.tencent.smtt.utils;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.utils.f */
class C44460f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C44459e f17315a;

    C44460f(C44459e c44459e) {
        this.f17315a = c44459e;
    }

    public void run() {
        AppMethodBeat.m2504i(65197);
        Toast.makeText(this.f17315a.f17310b, "下载成功", 0).show();
        this.f17315a.f17311c.setVisibility(4);
        this.f17315a.f17314f.mo70634a(this.f17315a.f17312d, this.f17315a.f17309a, this.f17315a.f17310b, C44458d.f17306c);
        AppMethodBeat.m2505o(65197);
    }
}
