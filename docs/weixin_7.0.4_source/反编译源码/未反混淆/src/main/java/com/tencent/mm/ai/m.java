package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public abstract class m {
    public boolean bqV = false;
    public e ftf;
    protected long ftg = bo.yz();
    protected int fth = -1;
    private s fti;
    f ftj;
    public boolean ftk;
    public q ftl;
    private int limit = -99;
    int priority = 0;

    public enum a {
        EStatusCheckFailed,
        EReachMaxLimit;

        static {
            AppMethodBeat.o(58166);
        }
    }

    public enum b {
        EUnchecked,
        EOk,
        EFailed;

        static {
            AppMethodBeat.o(58169);
        }
    }

    public abstract int a(e eVar, f fVar);

    public abstract int getType();

    public final void reset() {
        this.ftg = bo.yz();
        this.fth = -1;
        this.limit = -99;
    }

    /* Access modifiers changed, original: protected */
    public void a(a aVar) {
    }

    /* Access modifiers changed, original: protected */
    public b b(q qVar) {
        return b.EUnchecked;
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
    public final e acL() {
        return this.ftf;
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(e eVar) {
        this.ftg = bo.yz();
        this.ftf = eVar;
    }

    public boolean acM() {
        return acn() == 1;
    }

    /* Access modifiers changed, original: protected */
    public int a(e eVar, final q qVar, k kVar) {
        c(eVar);
        this.ftl = qVar;
        final k a = bi.a(kVar);
        int aag = bi.aag();
        if (aag != 0) {
            return aag;
        }
        if (this.limit == -99) {
            this.limit = acn();
            ab.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.limit);
        }
        if (acn() > 1) {
            switch (b(qVar)) {
                case EUnchecked:
                    Assert.assertTrue("scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri() + ", CHECK NOW", false);
                    break;
                case EFailed:
                    ab.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri());
                    this.limit--;
                    a(a.EStatusCheckFailed);
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
            ab.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + acn());
            a(a.EReachMaxLimit);
            this.fth = -1;
            return this.fth;
        }
        this.limit--;
        u uVar = new u(qVar);
        if (!(this.fti == null || acK())) {
            this.fti.cancel();
        }
        this.fti = new s(qVar, a, this, this.ftj, eVar);
        this.fth = eVar.a(uVar, this.fti);
        ab.i("MicroMsg.NetSceneBase", "dispatcher send, %s", Integer.valueOf(this.fth));
        if (this.fth < 0) {
            ab.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.fth), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
            new ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(58162);
                    ab.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(m.this.fth), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                    a.a(-1, 3, -1, "send to network failed", qVar, null);
                    ab.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(m.this.fth), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                    AppMethodBeat.o(58162);
                }
            });
            return 99999999;
        }
        s sVar = this.fti;
        sVar.handler.postDelayed(sVar.ftX, 330000);
        return this.fth;
    }

    public final q acN() {
        return this.ftl;
    }

    public final int acO() {
        return this.ftl == null ? 0 : this.ftl.hashCode();
    }

    /* Access modifiers changed, original: protected */
    public void cancel() {
        ab.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", Integer.valueOf(this.fth), Integer.valueOf(hashCode()), Integer.valueOf(getType()));
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
    public boolean a(m mVar) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean b(m mVar) {
        return false;
    }

    public String getInfo() {
        return "";
    }
}
