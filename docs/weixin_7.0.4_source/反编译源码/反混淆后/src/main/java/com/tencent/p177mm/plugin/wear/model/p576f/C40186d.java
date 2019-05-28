package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wear.model.f.d */
public abstract class C40186d implements Runnable {
    public abstract void execute();

    public abstract String getName();

    public C40186d() {
        C4990ab.m7417i("MicroMsg.WearBaseWorkerTask", "Create %s", getName());
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            execute();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WearBaseWorkerTask", e, "run task %s occur exception: %s", getName(), e.getMessage());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.WearBaseWorkerTask", "execute %s | use time %d", getName(), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
    }
}
