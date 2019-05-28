package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.sdk.platformtools.ab;

public abstract class d implements Runnable {
    public abstract void execute();

    public abstract String getName();

    public d() {
        ab.i("MicroMsg.WearBaseWorkerTask", "Create %s", getName());
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            execute();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WearBaseWorkerTask", e, "run task %s occur exception: %s", getName(), e.getMessage());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ab.i("MicroMsg.WearBaseWorkerTask", "execute %s | use time %d", getName(), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
    }
}
