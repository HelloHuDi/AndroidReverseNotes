package com.tencent.matrix.trace.p174e;

import android.os.Handler;
import com.tencent.matrix.p157d.C1068b;

/* renamed from: com.tencent.matrix.trace.e.b */
public class C1153b {
    private Handler handler;

    /* renamed from: a */
    public void mo4386a(String str, long j, int i) {
    }

    public Handler getHandler() {
        if (this.handler == null) {
            this.handler = new Handler(C1068b.m2358zL().getLooper());
        }
        return this.handler;
    }
}
