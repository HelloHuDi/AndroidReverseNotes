package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1833bi;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ai.m */
public abstract class C1207m {
    public boolean bqV = false;
    public C1902e ftf;
    protected long ftg = C5046bo.m7588yz();
    protected int fth = -1;
    private C7474s fti;
    C1202f ftj;
    public boolean ftk;
    public C1929q ftl;
    private int limit = -99;
    int priority = 0;

    /* renamed from: com.tencent.mm.ai.m$a */
    public enum C1205a {
        EStatusCheckFailed,
        EReachMaxLimit;

        static {
            AppMethodBeat.m2505o(58166);
        }
    }

    /* renamed from: com.tencent.mm.ai.m$b */
    public enum C1206b {
        EUnchecked,
        EOk,
        EFailed;

        static {
            AppMethodBeat.m2505o(58169);
        }
    }

    /* renamed from: a */
    public abstract int mo4456a(C1902e c1902e, C1202f c1202f);

    public abstract int getType();

    public final void reset() {
        this.ftg = C5046bo.m7588yz();
        this.fth = -1;
        this.limit = -99;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo4458a(C1205a c1205a) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public C1206b mo4468b(C1929q c1929q) {
        return C1206b.EUnchecked;
    }

    public boolean acI() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int acn() {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public boolean acJ() {
        return this.limit <= 0;
    }

    /* Access modifiers changed, original: protected */
    public boolean acK() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final C1902e acL() {
        return this.ftf;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo4470c(C1902e c1902e) {
        this.ftg = C5046bo.m7588yz();
        this.ftf = c1902e;
    }

    public boolean acM() {
        return acn() == 1;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public int mo4457a(C1902e c1902e, final C1929q c1929q, C1918k c1918k) {
        mo4470c(c1902e);
        this.ftl = c1929q;
        final C1918k a = C1833bi.m3777a(c1918k);
        int aag = C1833bi.aag();
        if (aag != 0) {
            return aag;
        }
        if (this.limit == -99) {
            this.limit = acn();
            C4990ab.m7416i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.limit);
        }
        if (acn() > 1) {
            switch (mo4468b(c1929q)) {
                case EUnchecked:
                    Assert.assertTrue("scene security verification not passed, type=" + c1929q.getType() + ", uri=" + c1929q.getUri() + ", CHECK NOW", false);
                    break;
                case EFailed:
                    C4990ab.m7412e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + c1929q.getType() + ", uri=" + c1929q.getUri());
                    this.limit--;
                    mo4458a(C1205a.EStatusCheckFailed);
                    this.fth = -1;
                    return this.fth;
                case EOk:
                    break;
                default:
                    Assert.assertTrue("invalid security verification status", false);
                    break;
            }
        }
        if (acJ()) {
            C4990ab.m7412e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + acn());
            mo4458a(C1205a.EReachMaxLimit);
            this.fth = -1;
            return this.fth;
        }
        this.limit--;
        C7476u c7476u = new C7476u(c1929q);
        if (!(this.fti == null || acK())) {
            this.fti.cancel();
        }
        this.fti = new C7474s(c1929q, a, this, this.ftj, c1902e);
        this.fth = c1902e.mo5518a(c7476u, this.fti);
        C4990ab.m7417i("MicroMsg.NetSceneBase", "dispatcher send, %s", Integer.valueOf(this.fth));
        if (this.fth < 0) {
            C4990ab.m7417i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.fth), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(c1929q.getType()));
            new C7306ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(58162);
                    C4990ab.m7417i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(C1207m.this.fth), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(c1929q.getType()));
                    a.mo4498a(-1, 3, -1, "send to network failed", c1929q, null);
                    C4990ab.m7417i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(C1207m.this.fth), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(c1929q.getType()));
                    AppMethodBeat.m2505o(58162);
                }
            });
            return 99999999;
        }
        C7474s c7474s = this.fti;
        c7474s.handler.postDelayed(c7474s.ftX, 330000);
        return this.fth;
    }

    public final C1929q acN() {
        return this.ftl;
    }

    public final int acO() {
        return this.ftl == null ? 0 : this.ftl.hashCode();
    }

    /* Access modifiers changed, original: protected */
    public void cancel() {
        C4990ab.m7417i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", Integer.valueOf(this.fth), Integer.valueOf(hashCode()), Integer.valueOf(getType()));
        this.bqV = true;
        if (this.fti != null) {
            this.fti.cancel();
        }
        if (this.fth != -1 && this.ftf != null) {
            int i = this.fth;
            this.fth = -1;
            this.ftf.cancel(i);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo4459a(C1207m c1207m) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo4469b(C1207m c1207m) {
        return false;
    }

    public String getInfo() {
        return "";
    }
}
