package com.tencent.p177mm.plugin.fts.p419a;

import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.fts.a.b */
public abstract class C24765b implements C20848k {
    public boolean aGx;
    private boolean bZq;

    /* renamed from: Pq */
    public abstract boolean mo23883Pq();

    public abstract boolean onCreate();

    public C24765b() {
        C4990ab.m7417i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", getName());
    }

    public final boolean isCreated() {
        return this.bZq;
    }

    public final synchronized void create() {
        C4990ab.m7417i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", getName(), Boolean.valueOf(this.bZq));
        if (!this.bZq && onCreate()) {
            C4990ab.m7416i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
            this.bZq = true;
        }
    }

    public final void destroy() {
        C4990ab.m7417i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", getName(), Boolean.valueOf(this.aGx), Boolean.valueOf(this.bZq));
        if (!this.aGx && this.bZq && mo23883Pq()) {
            C4990ab.m7416i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
            this.aGx = true;
        }
    }

    /* renamed from: a */
    public void mo36116a(String str, C45966l c45966l, int i, HashMap<String, String> hashMap) {
    }

    public void addSOSHistory(String str) {
    }

    public void deleteSOSHistory(String str) {
    }

    public void deleteSOSHistory() {
    }

    /* renamed from: a */
    public C28106a mo23884a(C20846i c20846i) {
        return null;
    }
}
