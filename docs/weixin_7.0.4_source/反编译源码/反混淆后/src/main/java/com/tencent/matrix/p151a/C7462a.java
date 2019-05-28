package com.tencent.matrix.p151a;

import android.app.Application;
import com.tencent.matrix.p151a.p152a.C1024a;
import com.tencent.matrix.p151a.p153b.C6280c;
import com.tencent.matrix.p151a.p154c.C1055a;
import com.tencent.matrix.p155b.C1061c;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1073d;

/* renamed from: com.tencent.matrix.a.a */
public final class C7462a extends C6283b {
    public final C1024a bUD;
    private C6280c bUE;
    private boolean bUF;

    public final void init(Application application, C1061c c1061c) {
        super.init(application, c1061c);
        C1055a.setPackageName(application);
        C1055a.m2334ce(C1073d.m2377aD(application));
        this.bUE = new C6280c(this);
    }

    public final synchronized void start() {
        if (!(isPluginStarted() || this.bUF)) {
            super.start();
            this.bUE.start();
        }
    }

    public final synchronized void stop() {
        this.bUF = false;
        if (isPluginStarted()) {
            super.stop();
            this.bUE.stop();
        }
    }

    public final void destroy() {
        super.destroy();
    }

    public final String getTag() {
        return "battery";
    }

    public final synchronized void onForeground(boolean z) {
        C1070c.m2368i("Matrix.BatteryCanaryPlugin", "onForeground:".concat(String.valueOf(z)), new Object[0]);
        super.onForeground(z);
        if (z && isPluginStarted()) {
            this.bUF = true;
            super.stop();
            this.bUE.stop();
        } else if (!z) {
            if (isPluginStoped() && this.bUF) {
                super.start();
                this.bUE.start();
            }
        }
    }
}
