package com.tencent.matrix.a;

import android.app.Application;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.b.b;
import com.tencent.matrix.d.d;

public final class a extends b {
    public final com.tencent.matrix.a.a.a bUD;
    private c bUE;
    private boolean bUF;

    public final void init(Application application, com.tencent.matrix.b.c cVar) {
        super.init(application, cVar);
        com.tencent.matrix.a.c.a.setPackageName(application);
        com.tencent.matrix.a.c.a.ce(d.aD(application));
        this.bUE = new c(this);
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
        com.tencent.matrix.d.c.i("Matrix.BatteryCanaryPlugin", "onForeground:".concat(String.valueOf(z)), new Object[0]);
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
