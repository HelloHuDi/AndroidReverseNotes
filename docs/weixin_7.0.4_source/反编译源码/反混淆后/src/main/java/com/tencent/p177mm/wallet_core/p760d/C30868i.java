package com.tencent.p177mm.wallet_core.p760d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.tenpay.model.C30875n;
import com.tencent.p177mm.wallet_core.tenpay.model.C40942a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.mm.wallet_core.d.i */
public final class C30868i implements C1202f, C46722e {
    private C16082a Ago;
    private C7371b Agp;
    public HashMap<Integer, C30863c> Agq;
    public String eHT;
    public HashSet<C1207m> gIG = new HashSet();
    public HashSet<C1207m> gIH = new HashSet();
    public Dialog gII = null;
    private Set<Integer> gIW = new HashSet();
    public Bundle mBundle;
    public Context mContext;
    private C40932f nXS = null;

    /* renamed from: com.tencent.mm.wallet_core.d.i$1 */
    class C160841 implements OnCancelListener {
        C160841() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49139);
            C30868i.this.bLz();
            AppMethodBeat.m2505o(49139);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.d.i$2 */
    class C160852 implements OnCancelListener {
        C160852() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49140);
            if (C30868i.this.gII != null && C30868i.this.gIG.isEmpty()) {
                C30868i.this.gII.dismiss();
                Iterator it = C30868i.this.gIH.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c1207m);
                }
                C30868i.this.gIH.clear();
            }
            AppMethodBeat.m2505o(49140);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.d.i$3 */
    class C160863 implements OnCancelListener {
        C160863() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49141);
            if (C30868i.this.gII != null && C30868i.this.gIG.isEmpty()) {
                C30868i.this.gII.dismiss();
                Iterator it = C30868i.this.gIH.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c1207m);
                }
                C30868i.this.gIH.clear();
            }
            AppMethodBeat.m2505o(49141);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.d.i$8 */
    public class C308678 implements OnCancelListener {
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49146);
            C30868i.this.bLz();
            AppMethodBeat.m2505o(49146);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.d.i$5 */
    class C308695 implements OnCancelListener {
        C308695() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49143);
            if (C30868i.this.gII != null && C30868i.this.gIG.isEmpty()) {
                C30868i.this.gII.dismiss();
                Iterator it = C30868i.this.gIH.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c1207m);
                }
                C30868i.this.gIH.clear();
            }
            AppMethodBeat.m2505o(49143);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.d.i$7 */
    class C308707 implements OnCancelListener {
        C308707() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49145);
            if (C30868i.this.gII != null && C30868i.this.gIG.isEmpty()) {
                C30868i.this.gII.dismiss();
                Iterator it = C30868i.this.gIH.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c1207m);
                }
                C30868i.this.gIH.clear();
            }
            AppMethodBeat.m2505o(49145);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.d.i$4 */
    class C308714 implements OnCancelListener {
        C308714() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49142);
            if (C30868i.this.gII != null && C30868i.this.gIG.isEmpty()) {
                C30868i.this.gII.dismiss();
                Iterator it = C30868i.this.gIH.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c1207m);
                }
                C30868i.this.gIH.clear();
            }
            AppMethodBeat.m2505o(49142);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.d.i$6 */
    class C308726 implements OnCancelListener {
        C308726() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49144);
            if (C30868i.this.gII != null && C30868i.this.gIG.isEmpty()) {
                C30868i.this.gII.dismiss();
                Iterator it = C30868i.this.gIH.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c1207m);
                }
                C30868i.this.gIH.clear();
            }
            AppMethodBeat.m2505o(49144);
        }
    }

    public C30868i(Context context, C40932f c40932f) {
        AppMethodBeat.m2504i(49147);
        this.mContext = context;
        this.nXS = c40932f;
        this.Ago = new C16082a(this);
        this.Agp = new C7371b(this);
        this.Agq = new HashMap();
        AppMethodBeat.m2505o(49147);
    }

    /* renamed from: a */
    public final void mo36581a(C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(49148);
        m49267s(c1207m);
        this.gIG.add(c1207m);
        if (z && (this.gII == null || !(this.gII == null || this.gII.isShowing()))) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            if (this.mContext == null) {
                C4990ab.m7421w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", this);
                AppMethodBeat.m2505o(49148);
                return;
            }
            this.gII = C30901g.m49317a(this.mContext, false, new C160841());
        }
        if (C1947ae.gju && (c1207m instanceof C5749m) && (((C5749m) c1207m).getUri().contains("authen") || ((C5749m) c1207m).getUri().contains("verify"))) {
            ((C5749m) c1207m).dOq();
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c1207m, 0);
        AppMethodBeat.m2505o(49148);
    }

    /* renamed from: a */
    public final void mo49367a(C1207m c1207m, boolean z, int i) {
        AppMethodBeat.m2504i(49149);
        mo49368a(c1207m, z, i, 0);
        AppMethodBeat.m2505o(49149);
    }

    /* renamed from: a */
    public final void mo49368a(C1207m c1207m, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(49150);
        String str = "MicroMsg.WalletNetSceneMgr";
        String str2 = "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s";
        Object[] objArr = new Object[7];
        objArr[0] = this;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = c1207m;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(c1207m.getType());
        objArr[5] = Boolean.valueOf(c1207m instanceof C44426i);
        boolean z2 = this.gII == null || !(this.gII == null || this.gII.isShowing());
        objArr[6] = Boolean.valueOf(z2);
        C4990ab.m7417i(str, str2, objArr);
        m49267s(c1207m);
        this.gIH.add(c1207m);
        if (z && (this.gII == null || !(this.gII == null || this.gII.isShowing()))) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            Context context;
            if (this.mContext == null) {
                C4990ab.m7420w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                AppMethodBeat.m2505o(49150);
                return;
            } else if (i == 1) {
                if (c1207m instanceof C44426i) {
                    this.gII = C30901g.m49317a(this.mContext, false, new C160852());
                } else {
                    context = this.mContext;
                    this.mContext.getString(C25738R.string.f9104pl);
                    this.gII = C30379h.m48458b(context, this.mContext.getString(C25738R.string.fop), false, new C160863());
                }
            } else if (i == 2) {
                context = this.mContext;
                this.mContext.getString(C25738R.string.f9104pl);
                this.gII = C30379h.m48458b(context, this.mContext.getString(C25738R.string.fop), false, new C308714());
            } else if (i == 3) {
                this.gII = C30901g.m49319d(this.mContext, "验证中", new C308695());
            } else if (i == 4) {
                this.gII = C30901g.m49317a(this.mContext, false, new C308726());
            } else {
                C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", Integer.valueOf(i));
                context = this.mContext;
                this.mContext.getString(C25738R.string.f9104pl);
                this.gII = C30379h.m48458b(context, this.mContext.getString(C25738R.string.fop), false, new C308707());
            }
        }
        if (C1947ae.gju && (c1207m instanceof C5749m) && (((C5749m) c1207m).getUri().contains("authen") || ((C5749m) c1207m).getUri().contains("verify"))) {
            ((C5749m) c1207m).dOq();
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c1207m, i2);
        str = "MicroMsg.WalletNetSceneMgr";
        str2 = "this %s scene url %s %s";
        objArr = new Object[3];
        objArr[0] = this;
        objArr[1] = c1207m;
        objArr[2] = c1207m.ftl == null ? "" : c1207m.ftl.getUri();
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(49150);
    }

    public final void bLz() {
        C1207m c1207m;
        AppMethodBeat.m2504i(49151);
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        Iterator it = this.gIG.iterator();
        while (it.hasNext()) {
            c1207m = (C1207m) it.next();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c(c1207m);
        }
        it = this.gIH.iterator();
        while (it.hasNext()) {
            c1207m = (C1207m) it.next();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c(c1207m);
        }
        this.gIG.clear();
        this.gIH.clear();
        AppMethodBeat.m2505o(49151);
    }

    /* renamed from: nf */
    public final void mo49372nf(int i) {
        AppMethodBeat.m2504i(49152);
        this.gIW.add(Integer.valueOf(i));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(i, (C1202f) this);
        AppMethodBeat.m2505o(49152);
    }

    /* renamed from: ng */
    public final void mo49373ng(int i) {
        AppMethodBeat.m2504i(49153);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(i, (C1202f) this);
        this.gIW.remove(Integer.valueOf(i));
        if (this.gIW.isEmpty()) {
            onDestroy();
        }
        AppMethodBeat.m2505o(49153);
    }

    public final void bLB() {
        AppMethodBeat.m2504i(138996);
        cNM();
        AppMethodBeat.m2505o(138996);
    }

    /* renamed from: k */
    private boolean m49266k(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(49155);
        C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", this, c1207m.toString());
        C4990ab.m7411d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", this, Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(C1947ae.gju));
        C30875n c30875n;
        if (!C1947ae.gju || !(c1207m instanceof C30875n) || ((C30875n) c1207m).pOZ || ((C30875n) c1207m).cNK()) {
            if (c1207m instanceof ITenpaySave) {
                ITenpaySave iTenpaySave = (ITenpaySave) c1207m;
                if (iTenpaySave instanceof ITenpaySave) {
                    RetryPayInfo cMC = iTenpaySave.cMC();
                    if (cMC != null && cMC.bVy()) {
                        C7371b.tfe = cMC;
                    }
                }
            }
            if (c1207m instanceof C30875n) {
                if (((C30875n) c1207m).pOZ) {
                    C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", c1207m);
                    AppMethodBeat.m2505o(49155);
                    return false;
                } else if (((C30875n) c1207m).cNK() && (c1207m instanceof C40942a)) {
                    C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", this, Boolean.valueOf(!((C30875n) c1207m).AfM), Boolean.valueOf(((C30875n) c1207m).AgQ));
                    if (!((C30875n) c1207m).AgQ && !r0) {
                        AppMethodBeat.m2505o(49155);
                        return false;
                    } else if (this.Agp.mo15901c((C30875n) c1207m)) {
                        AppMethodBeat.m2505o(49155);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(49155);
                        return false;
                    }
                }
            }
            int type = c1207m.getType();
            if (this.Agq != null) {
                C30863c c30863c = (C30863c) this.Agq.get(Integer.valueOf(type));
                if (c1207m instanceof C24157d) {
                    if (((C24157d) c1207m).cfp()) {
                        AppMethodBeat.m2505o(49155);
                        return false;
                    }
                    C24157d c24157d = (C24157d) c1207m;
                    C4990ab.m7417i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", c24157d);
                    c30863c.Agl = c24157d;
                    if (c30863c.mo25117a(i, i2, c24157d)) {
                        AppMethodBeat.m2505o(49155);
                        return true;
                    }
                }
            }
            if (!(c1207m instanceof C30875n)) {
                AppMethodBeat.m2505o(49155);
                return false;
            } else if (((C30875n) c1207m).cNK()) {
                AppMethodBeat.m2505o(49155);
                return false;
            } else if (((C30875n) c1207m).pOZ) {
                C4990ab.m7416i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
                AppMethodBeat.m2505o(49155);
                return false;
            } else {
                boolean z;
                boolean z2;
                c30875n = (C30875n) c1207m;
                C16082a c16082a = this.Ago;
                int i3 = C14241r.cPI().mRetryCount;
                C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", Boolean.valueOf(c30875n.dOs()), Integer.valueOf(c16082a.Agj));
                if (!c30875n.dOs() || c16082a.Agj >= i3) {
                    z = false;
                } else {
                    z = true;
                }
                if (c30875n.AfM) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                C4990ab.m7411d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", this, Boolean.valueOf(z2), Boolean.valueOf(z));
                C7060h.pYm.mo15419k(965, 13, 1);
                if (z2) {
                    C7060h.pYm.mo15419k(965, 14, 1);
                }
                if (z || z2) {
                    C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", this);
                    this.Ago.mo28513a(c30875n);
                    AppMethodBeat.m2505o(49155);
                    return true;
                }
                AppMethodBeat.m2505o(49155);
                return false;
            }
        }
        c30875n = (C30875n) c1207m;
        C4990ab.m7416i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
        this.Ago.mo28513a(c30875n);
        AppMethodBeat.m2505o(49155);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3;
        boolean z;
        AppMethodBeat.m2504i(49156);
        if (this.gIH.contains(c1207m)) {
            C4990ab.m7411d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", this);
            if (m49266k(i, i2, str, c1207m)) {
                C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", this);
                AppMethodBeat.m2505o(49156);
                return;
            }
            C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", this);
            this.gIH.remove(c1207m);
            i3 = 1;
        } else if (this.gIG.contains(c1207m)) {
            C4990ab.m7411d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", this);
            if (m49266k(i, i2, str, c1207m)) {
                C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", this);
                AppMethodBeat.m2505o(49156);
                return;
            }
            this.gIG.remove(c1207m);
            C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", this);
            i3 = 1;
        } else {
            i3 = 0;
        }
        C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", this, Integer.valueOf(this.gIH.size()), Integer.valueOf(this.gIG.size()));
        if (this.gIH.isEmpty() && this.gIG.isEmpty()) {
            cNM();
            z = true;
        } else {
            z = false;
        }
        if (!(i3 == 0 || this.nXS == null)) {
            this.nXS.mo24300b(i, i2, str, c1207m, z);
        }
        AppMethodBeat.m2505o(49156);
    }

    public final void cNM() {
        AppMethodBeat.m2504i(49157);
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.m2505o(49157);
    }

    public final boolean bLA() {
        AppMethodBeat.m2504i(49158);
        if (this.gIH.isEmpty() && this.gIG.isEmpty()) {
            AppMethodBeat.m2505o(49158);
            return false;
        }
        AppMethodBeat.m2505o(49158);
        return true;
    }

    private void onDestroy() {
        AppMethodBeat.m2504i(49159);
        bLz();
        this.nXS = null;
        this.mContext = null;
        this.Ago.destory();
        this.Agp.destory();
        for (C30863c bMO : this.Agq.values()) {
            bMO.bMO();
        }
        this.Agq.clear();
        AppMethodBeat.m2505o(49159);
    }

    /* renamed from: s */
    private void m49267s(C1207m c1207m) {
        if (c1207m != null && (c1207m instanceof C36378u)) {
            ((C36378u) c1207m).eHT = this.eHT;
            if (this.mBundle != null) {
                ((C36378u) c1207m).mBundle = this.mBundle;
            } else if (this.mContext instanceof WalletBaseUI) {
                ((C36378u) c1207m).mBundle = ((WalletBaseUI) this.mContext).mBundle;
            }
        }
    }
}
