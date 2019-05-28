package com.tencent.matrix.iocanary;

import android.app.Application;
import com.tencent.matrix.b.b;
import com.tencent.matrix.b.c;
import com.tencent.matrix.iocanary.core.IOCanaryCore;

public final class a extends b {
    private IOCanaryCore bWj;
    public final com.tencent.matrix.iocanary.a.a mIOConfig;

    public a(com.tencent.matrix.iocanary.a.a aVar) {
        this.mIOConfig = aVar;
    }

    public final void init(Application application, c cVar) {
        super.init(application, cVar);
        com.tencent.matrix.iocanary.c.a.setPackageName(application);
        this.bWj = new IOCanaryCore(this);
    }

    public final void start() {
        super.start();
        this.bWj.start();
    }

    public final void stop() {
        super.stop();
        this.bWj.stop();
    }

    public final void destroy() {
        super.destroy();
    }

    public final String getTag() {
        return "io";
    }
}
