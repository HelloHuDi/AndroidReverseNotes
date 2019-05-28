package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.d.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class s implements f, e {
    private String eHT;
    HashSet<m> gIG = new HashSet();
    HashSet<m> gIH = new HashSet();
    private Set<Integer> gIW = new HashSet();
    private Context mContext;
    private com.tencent.mm.wallet_core.d.f nXS = null;
    p tipDialog = null;

    public s(Context context, com.tencent.mm.wallet_core.d.f fVar) {
        AppMethodBeat.i(42341);
        this.mContext = context;
        this.nXS = fVar;
        AppMethodBeat.o(42341);
    }

    public final void a(m mVar, boolean z) {
        AppMethodBeat.i(42342);
        l(mVar);
        this.gIG.add(mVar);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.b(this.mContext, this.mContext.getString(R.string.cn5), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(42339);
                    s.this.bLz();
                    AppMethodBeat.o(42339);
                }
            });
        }
        g.RQ();
        g.RO().eJo.a(mVar, 0);
        AppMethodBeat.o(42342);
    }

    public final void b(m mVar, boolean z) {
        AppMethodBeat.i(42343);
        ab.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(z)));
        l(mVar);
        this.gIH.add(mVar);
        if (z && (this.tipDialog == null || !(this.tipDialog == null || this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, 3, this.mContext.getString(R.string.cn5), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(42340);
                    if (s.this.tipDialog != null && s.this.gIG.isEmpty()) {
                        s.this.tipDialog.dismiss();
                        Iterator it = s.this.gIH.iterator();
                        while (it.hasNext()) {
                            m mVar = (m) it.next();
                            g.RQ();
                            g.RO().eJo.c(mVar);
                        }
                        s.this.gIH.clear();
                    }
                    AppMethodBeat.o(42340);
                }
            });
        }
        g.RQ();
        g.RO().eJo.a(mVar, 0);
        AppMethodBeat.o(42343);
    }

    public final void bLz() {
        m mVar;
        AppMethodBeat.i(42344);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        Iterator it = this.gIG.iterator();
        while (it.hasNext()) {
            mVar = (m) it.next();
            g.RQ();
            g.RO().eJo.c(mVar);
        }
        it = this.gIH.iterator();
        while (it.hasNext()) {
            mVar = (m) it.next();
            g.RQ();
            g.RO().eJo.c(mVar);
        }
        this.gIG.clear();
        this.gIH.clear();
        AppMethodBeat.o(42344);
    }

    public final void nf(int i) {
        AppMethodBeat.i(42345);
        this.gIW.add(Integer.valueOf(i));
        g.RQ();
        g.RO().eJo.a(i, (f) this);
        AppMethodBeat.o(42345);
    }

    public final void ng(int i) {
        AppMethodBeat.i(42346);
        g.RQ();
        g.RO().eJo.b(i, (f) this);
        this.gIW.remove(Integer.valueOf(i));
        if (this.gIW.isEmpty()) {
            bLz();
            this.nXS = null;
            this.mContext = null;
        }
        AppMethodBeat.o(42346);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        Object obj;
        boolean z;
        AppMethodBeat.i(42347);
        if (this.gIH.contains(mVar)) {
            this.gIH.remove(mVar);
            ab.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            obj = 1;
        } else if (this.gIG.contains(mVar)) {
            this.gIG.remove(mVar);
            ab.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
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
            this.nXS.b(i, i2, str, mVar, z);
        }
        AppMethodBeat.o(42347);
    }

    public final boolean bLA() {
        AppMethodBeat.i(42348);
        if (this.gIH.isEmpty() && this.gIG.isEmpty()) {
            AppMethodBeat.o(42348);
            return false;
        }
        AppMethodBeat.o(42348);
        return true;
    }

    private void l(m mVar) {
        if (mVar != null && (mVar instanceof u)) {
            ((u) mVar).eHT = this.eHT;
        }
    }

    public final void bLB() {
        AppMethodBeat.i(42349);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(42349);
    }
}
