package com.tencent.matrix.trace.e;

import android.os.Handler;

public class b {
    private Handler handler;

    public void a(String str, long j, int i) {
    }

    public Handler getHandler() {
        if (this.handler == null) {
            this.handler = new Handler(com.tencent.matrix.d.b.zL().getLooper());
        }
        return this.handler;
    }
}
