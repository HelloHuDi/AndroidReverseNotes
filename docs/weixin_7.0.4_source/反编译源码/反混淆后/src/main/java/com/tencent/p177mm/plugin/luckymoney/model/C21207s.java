package com.tencent.p177mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import com.tencent.p177mm.wallet_core.p760d.C40932f;
import com.tencent.p177mm.wallet_core.p760d.C46722e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.s */
public final class C21207s implements C1202f, C46722e {
    private String eHT;
    HashSet<C1207m> gIG = new HashSet();
    HashSet<C1207m> gIH = new HashSet();
    private Set<Integer> gIW = new HashSet();
    private Context mContext;
    private C40932f nXS = null;
    C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.s$1 */
    class C33861 implements OnCancelListener {
        C33861() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42339);
            C21207s.this.bLz();
            AppMethodBeat.m2505o(42339);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.s$2 */
    class C33872 implements OnCancelListener {
        C33872() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42340);
            if (C21207s.this.tipDialog != null && C21207s.this.gIG.isEmpty()) {
                C21207s.this.tipDialog.dismiss();
                Iterator it = C21207s.this.gIH.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(c1207m);
                }
                C21207s.this.gIH.clear();
            }
            AppMethodBeat.m2505o(42340);
        }
    }

    public C21207s(Context context, C40932f c40932f) {
        AppMethodBeat.m2504i(42341);
        this.mContext = context;
        this.nXS = c40932f;
        AppMethodBeat.m2505o(42341);
    }

    /* renamed from: a */
    public final void mo36581a(C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(42342);
        m32552l(c1207m);
        this.gIG.add(c1207m);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = C30379h.m48458b(this.mContext, this.mContext.getString(C25738R.string.cn5), false, new C33861());
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c1207m, 0);
        AppMethodBeat.m2505o(42342);
    }

    /* renamed from: b */
    public final void mo36582b(C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(42343);
        C4990ab.m7410d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(z)));
        m32552l(c1207m);
        this.gIH.add(c1207m);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = C30379h.m48427a(this.mContext, 3, this.mContext.getString(C25738R.string.cn5), true, new C33872());
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c1207m, 0);
        AppMethodBeat.m2505o(42343);
    }

    public final void bLz() {
        C1207m c1207m;
        AppMethodBeat.m2504i(42344);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
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
        AppMethodBeat.m2505o(42344);
    }

    /* renamed from: nf */
    public final void mo36586nf(int i) {
        AppMethodBeat.m2504i(42345);
        this.gIW.add(Integer.valueOf(i));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(i, (C1202f) this);
        AppMethodBeat.m2505o(42345);
    }

    /* renamed from: ng */
    public final void mo36587ng(int i) {
        AppMethodBeat.m2504i(42346);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(i, (C1202f) this);
        this.gIW.remove(Integer.valueOf(i));
        if (this.gIW.isEmpty()) {
            bLz();
            this.nXS = null;
            this.mContext = null;
        }
        AppMethodBeat.m2505o(42346);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        Object obj;
        boolean z;
        AppMethodBeat.m2504i(42347);
        if (this.gIH.contains(c1207m)) {
            this.gIH.remove(c1207m);
            C4990ab.m7410d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            obj = 1;
        } else if (this.gIG.contains(c1207m)) {
            this.gIG.remove(c1207m);
            C4990ab.m7410d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            int obj2 = 1;
        } else {
            obj2 = null;
        }
        if (this.gIH.isEmpty() && this.gIG.isEmpty()) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            z = true;
        } else {
            z = false;
        }
        if (!(obj2 == null || this.nXS == null)) {
            this.nXS.mo24300b(i, i2, str, c1207m, z);
        }
        AppMethodBeat.m2505o(42347);
    }

    public final boolean bLA() {
        AppMethodBeat.m2504i(42348);
        if (this.gIH.isEmpty() && this.gIG.isEmpty()) {
            AppMethodBeat.m2505o(42348);
            return false;
        }
        AppMethodBeat.m2505o(42348);
        return true;
    }

    /* renamed from: l */
    private void m32552l(C1207m c1207m) {
        if (c1207m != null && (c1207m instanceof C36378u)) {
            ((C36378u) c1207m).eHT = this.eHT;
        }
    }

    public final void bLB() {
        AppMethodBeat.m2504i(42349);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(42349);
    }
}
