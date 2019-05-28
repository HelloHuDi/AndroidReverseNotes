package com.tencent.matrix.iocanary;

import android.app.Application;
import com.tencent.matrix.iocanary.core.IOCanaryCore;
import com.tencent.matrix.iocanary.p158a.C1075a;
import com.tencent.matrix.iocanary.p160c.C1080a;
import com.tencent.matrix.p155b.C1061c;
import com.tencent.matrix.p155b.C6283b;

/* renamed from: com.tencent.matrix.iocanary.a */
public final class C7463a extends C6283b {
    private IOCanaryCore bWj;
    public final C1075a mIOConfig;

    public C7463a(C1075a c1075a) {
        this.mIOConfig = c1075a;
    }

    public final void init(Application application, C1061c c1061c) {
        super.init(application, c1061c);
        C1080a.setPackageName(application);
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
