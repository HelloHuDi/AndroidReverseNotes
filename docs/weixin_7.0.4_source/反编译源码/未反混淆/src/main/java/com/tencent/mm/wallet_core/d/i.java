package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.a;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i implements f, e {
    private a Ago;
    private b Agp;
    public HashMap<Integer, c> Agq;
    public String eHT;
    public HashSet<m> gIG = new HashSet();
    public HashSet<m> gIH = new HashSet();
    public Dialog gII = null;
    private Set<Integer> gIW = new HashSet();
    public Bundle mBundle;
    public Context mContext;
    private f nXS = null;

    public i(Context context, f fVar) {
        AppMethodBeat.i(49147);
        this.mContext = context;
        this.nXS = fVar;
        this.Ago = new a(this);
        this.Agp = new b(this);
        this.Agq = new HashMap();
        AppMethodBeat.o(49147);
    }

    public final void a(m mVar, boolean z) {
        AppMethodBeat.i(49148);
        s(mVar);
        this.gIG.add(mVar);
        if (z && (this.gII == null || !(this.gII == null || this.gII.isShowing()))) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            if (this.mContext == null) {
                ab.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", this);
                AppMethodBeat.o(49148);
                return;
            }
            this.gII = g.a(this.mContext, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(49139);
                    i.this.bLz();
                    AppMethodBeat.o(49139);
                }
            });
        }
        if (ae.gju && (mVar instanceof com.tencent.mm.wallet_core.tenpay.model.m) && (((com.tencent.mm.wallet_core.tenpay.model.m) mVar).getUri().contains("authen") || ((com.tencent.mm.wallet_core.tenpay.model.m) mVar).getUri().contains("verify"))) {
            ((com.tencent.mm.wallet_core.tenpay.model.m) mVar).dOq();
        }
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(mVar, 0);
        AppMethodBeat.o(49148);
    }

    public final void a(m mVar, boolean z, int i) {
        AppMethodBeat.i(49149);
        a(mVar, z, i, 0);
        AppMethodBeat.o(49149);
    }

    public final void a(m mVar, boolean z, int i, int i2) {
        AppMethodBeat.i(49150);
        String str = "MicroMsg.WalletNetSceneMgr";
        String str2 = "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s";
        Object[] objArr = new Object[7];
        objArr[0] = this;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = mVar;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(mVar.getType());
        objArr[5] = Boolean.valueOf(mVar instanceof com.tencent.mm.wallet_core.c.i);
        boolean z2 = this.gII == null || !(this.gII == null || this.gII.isShowing());
        objArr[6] = Boolean.valueOf(z2);
        ab.i(str, str2, objArr);
        s(mVar);
        this.gIH.add(mVar);
        if (z && (this.gII == null || !(this.gII == null || this.gII.isShowing()))) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            Context context;
            if (this.mContext == null) {
                ab.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                AppMethodBeat.o(49150);
                return;
            } else if (i == 1) {
                if (mVar instanceof com.tencent.mm.wallet_core.c.i) {
                    this.gII = g.a(this.mContext, false, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(49140);
                            if (i.this.gII != null && i.this.gIG.isEmpty()) {
                                i.this.gII.dismiss();
                                Iterator it = i.this.gIH.iterator();
                                while (it.hasNext()) {
                                    m mVar = (m) it.next();
                                    com.tencent.mm.kernel.g.RQ();
                                    com.tencent.mm.kernel.g.RO().eJo.c(mVar);
                                }
                                i.this.gIH.clear();
                            }
                            AppMethodBeat.o(49140);
                        }
                    });
                } else {
                    context = this.mContext;
                    this.mContext.getString(R.string.pl);
                    this.gII = h.b(context, this.mContext.getString(R.string.fop), false, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(49141);
                            if (i.this.gII != null && i.this.gIG.isEmpty()) {
                                i.this.gII.dismiss();
                                Iterator it = i.this.gIH.iterator();
                                while (it.hasNext()) {
                                    m mVar = (m) it.next();
                                    com.tencent.mm.kernel.g.RQ();
                                    com.tencent.mm.kernel.g.RO().eJo.c(mVar);
                                }
                                i.this.gIH.clear();
                            }
                            AppMethodBeat.o(49141);
                        }
                    });
                }
            } else if (i == 2) {
                context = this.mContext;
                this.mContext.getString(R.string.pl);
                this.gII = h.b(context, this.mContext.getString(R.string.fop), false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(49142);
                        if (i.this.gII != null && i.this.gIG.isEmpty()) {
                            i.this.gII.dismiss();
                            Iterator it = i.this.gIH.iterator();
                            while (it.hasNext()) {
                                m mVar = (m) it.next();
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RO().eJo.c(mVar);
                            }
                            i.this.gIH.clear();
                        }
                        AppMethodBeat.o(49142);
                    }
                });
            } else if (i == 3) {
                this.gII = g.d(this.mContext, "验证中", new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(49143);
                        if (i.this.gII != null && i.this.gIG.isEmpty()) {
                            i.this.gII.dismiss();
                            Iterator it = i.this.gIH.iterator();
                            while (it.hasNext()) {
                                m mVar = (m) it.next();
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RO().eJo.c(mVar);
                            }
                            i.this.gIH.clear();
                        }
                        AppMethodBeat.o(49143);
                    }
                });
            } else if (i == 4) {
                this.gII = g.a(this.mContext, false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(49144);
                        if (i.this.gII != null && i.this.gIG.isEmpty()) {
                            i.this.gII.dismiss();
                            Iterator it = i.this.gIH.iterator();
                            while (it.hasNext()) {
                                m mVar = (m) it.next();
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RO().eJo.c(mVar);
                            }
                            i.this.gIH.clear();
                        }
                        AppMethodBeat.o(49144);
                    }
                });
            } else {
                ab.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", Integer.valueOf(i));
                context = this.mContext;
                this.mContext.getString(R.string.pl);
                this.gII = h.b(context, this.mContext.getString(R.string.fop), false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(49145);
                        if (i.this.gII != null && i.this.gIG.isEmpty()) {
                            i.this.gII.dismiss();
                            Iterator it = i.this.gIH.iterator();
                            while (it.hasNext()) {
                                m mVar = (m) it.next();
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RO().eJo.c(mVar);
                            }
                            i.this.gIH.clear();
                        }
                        AppMethodBeat.o(49145);
                    }
                });
            }
        }
        if (ae.gju && (mVar instanceof com.tencent.mm.wallet_core.tenpay.model.m) && (((com.tencent.mm.wallet_core.tenpay.model.m) mVar).getUri().contains("authen") || ((com.tencent.mm.wallet_core.tenpay.model.m) mVar).getUri().contains("verify"))) {
            ((com.tencent.mm.wallet_core.tenpay.model.m) mVar).dOq();
        }
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(mVar, i2);
        str = "MicroMsg.WalletNetSceneMgr";
        str2 = "this %s scene url %s %s";
        objArr = new Object[3];
        objArr[0] = this;
        objArr[1] = mVar;
        objArr[2] = mVar.ftl == null ? "" : mVar.ftl.getUri();
        ab.i(str, str2, objArr);
        AppMethodBeat.o(49150);
    }

    public final void bLz() {
        m mVar;
        AppMethodBeat.i(49151);
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        Iterator it = this.gIG.iterator();
        while (it.hasNext()) {
            mVar = (m) it.next();
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.c(mVar);
        }
        it = this.gIH.iterator();
        while (it.hasNext()) {
            mVar = (m) it.next();
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.c(mVar);
        }
        this.gIG.clear();
        this.gIH.clear();
        AppMethodBeat.o(49151);
    }

    public final void nf(int i) {
        AppMethodBeat.i(49152);
        this.gIW.add(Integer.valueOf(i));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(i, (f) this);
        AppMethodBeat.o(49152);
    }

    public final void ng(int i) {
        AppMethodBeat.i(49153);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(i, (f) this);
        this.gIW.remove(Integer.valueOf(i));
        if (this.gIW.isEmpty()) {
            onDestroy();
        }
        AppMethodBeat.o(49153);
    }

    public final void bLB() {
        AppMethodBeat.i(138996);
        cNM();
        AppMethodBeat.o(138996);
    }

    private boolean k(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(49155);
        ab.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", this, mVar.toString());
        ab.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", this, Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(ae.gju));
        n nVar;
        if (!ae.gju || !(mVar instanceof n) || ((n) mVar).pOZ || ((n) mVar).cNK()) {
            if (mVar instanceof ITenpaySave) {
                ITenpaySave iTenpaySave = (ITenpaySave) mVar;
                if (iTenpaySave instanceof ITenpaySave) {
                    RetryPayInfo cMC = iTenpaySave.cMC();
                    if (cMC != null && cMC.bVy()) {
                        b.tfe = cMC;
                    }
                }
            }
            if (mVar instanceof n) {
                if (((n) mVar).pOZ) {
                    ab.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", mVar);
                    AppMethodBeat.o(49155);
                    return false;
                } else if (((n) mVar).cNK() && (mVar instanceof a)) {
                    ab.i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", this, Boolean.valueOf(!((n) mVar).AfM), Boolean.valueOf(((n) mVar).AgQ));
                    if (!((n) mVar).AgQ && !r0) {
                        AppMethodBeat.o(49155);
                        return false;
                    } else if (this.Agp.c((n) mVar)) {
                        AppMethodBeat.o(49155);
                        return true;
                    } else {
                        AppMethodBeat.o(49155);
                        return false;
                    }
                }
            }
            int type = mVar.getType();
            if (this.Agq != null) {
                c cVar = (c) this.Agq.get(Integer.valueOf(type));
                if (mVar instanceof d) {
                    if (((d) mVar).cfp()) {
                        AppMethodBeat.o(49155);
                        return false;
                    }
                    d dVar = (d) mVar;
                    ab.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", dVar);
                    cVar.Agl = dVar;
                    if (cVar.a(i, i2, dVar)) {
                        AppMethodBeat.o(49155);
                        return true;
                    }
                }
            }
            if (!(mVar instanceof n)) {
                AppMethodBeat.o(49155);
                return false;
            } else if (((n) mVar).cNK()) {
                AppMethodBeat.o(49155);
                return false;
            } else if (((n) mVar).pOZ) {
                ab.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
                AppMethodBeat.o(49155);
                return false;
            } else {
                boolean z;
                boolean z2;
                nVar = (n) mVar;
                a aVar = this.Ago;
                int i3 = r.cPI().mRetryCount;
                ab.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", Boolean.valueOf(nVar.dOs()), Integer.valueOf(aVar.Agj));
                if (!nVar.dOs() || aVar.Agj >= i3) {
                    z = false;
                } else {
                    z = true;
                }
                if (nVar.AfM) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                ab.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", this, Boolean.valueOf(z2), Boolean.valueOf(z));
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 13, 1);
                if (z2) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(965, 14, 1);
                }
                if (z || z2) {
                    ab.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", this);
                    this.Ago.a(nVar);
                    AppMethodBeat.o(49155);
                    return true;
                }
                AppMethodBeat.o(49155);
                return false;
            }
        }
        nVar = (n) mVar;
        ab.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
        this.Ago.a(nVar);
        AppMethodBeat.o(49155);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3;
        boolean z;
        AppMethodBeat.i(49156);
        if (this.gIH.contains(mVar)) {
            ab.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", this);
            if (k(i, i2, str, mVar)) {
                ab.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", this);
                AppMethodBeat.o(49156);
                return;
            }
            ab.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", this);
            this.gIH.remove(mVar);
            i3 = 1;
        } else if (this.gIG.contains(mVar)) {
            ab.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", this);
            if (k(i, i2, str, mVar)) {
                ab.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", this);
                AppMethodBeat.o(49156);
                return;
            }
            this.gIG.remove(mVar);
            ab.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", this);
            i3 = 1;
        } else {
            i3 = 0;
        }
        ab.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", this, Integer.valueOf(this.gIH.size()), Integer.valueOf(this.gIG.size()));
        if (this.gIH.isEmpty() && this.gIG.isEmpty()) {
            cNM();
            z = true;
        } else {
            z = false;
        }
        if (!(i3 == 0 || this.nXS == null)) {
            this.nXS.b(i, i2, str, mVar, z);
        }
        AppMethodBeat.o(49156);
    }

    public final void cNM() {
        AppMethodBeat.i(49157);
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.o(49157);
    }

    public final boolean bLA() {
        AppMethodBeat.i(49158);
        if (this.gIH.isEmpty() && this.gIG.isEmpty()) {
            AppMethodBeat.o(49158);
            return false;
        }
        AppMethodBeat.o(49158);
        return true;
    }

    private void onDestroy() {
        AppMethodBeat.i(49159);
        bLz();
        this.nXS = null;
        this.mContext = null;
        this.Ago.destory();
        this.Agp.destory();
        for (c bMO : this.Agq.values()) {
            bMO.bMO();
        }
        this.Agq.clear();
        AppMethodBeat.o(49159);
    }

    private void s(m mVar) {
        if (mVar != null && (mVar instanceof u)) {
            ((u) mVar).eHT = this.eHT;
            if (this.mBundle != null) {
                ((u) mVar).mBundle = this.mBundle;
            } else if (this.mContext instanceof WalletBaseUI) {
                ((u) mVar).mBundle = ((WalletBaseUI) this.mContext).mBundle;
            }
        }
    }
}
