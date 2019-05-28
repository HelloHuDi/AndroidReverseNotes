package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public abstract class b implements k {
    public boolean aGx;
    private boolean bZq;

    public abstract boolean Pq();

    public abstract boolean onCreate();

    public b() {
        ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", getName());
    }

    public final boolean isCreated() {
        return this.bZq;
    }

    public final synchronized void create() {
        ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.bZq));
        if (!this.bZq && onCreate()) {
            ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
            this.bZq = true;
        }
    }

    public final void destroy() {
        ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", getName(), Boolean.valueOf(this.aGx), Boolean.valueOf(this.bZq));
        if (!this.aGx && this.bZq && Pq()) {
            ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
            this.aGx = true;
        }
    }

    public void a(String str, l lVar, int i, HashMap<String, String> hashMap) {
    }

    public void addSOSHistory(String str) {
    }

    public void deleteSOSHistory(String str) {
    }

    public void deleteSOSHistory() {
    }

    public a a(i iVar) {
        return null;
    }
}
