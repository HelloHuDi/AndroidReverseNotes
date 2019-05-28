package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b implements f {
    HashSet<m> gIG = new HashSet();
    HashSet<m> gIH = new HashSet();
    Dialog gII = null;
    private a gIV = null;
    private Set<Integer> gIW = new HashSet();
    private Context mContext;

    public b(Context context, a aVar) {
        AppMethodBeat.i(16779);
        this.mContext = context;
        this.gIV = aVar;
        AppMethodBeat.o(16779);
    }

    public final void nf(int i) {
        AppMethodBeat.i(16781);
        this.gIW.add(Integer.valueOf(i));
        aw.Rg().a(i, (f) this);
        AppMethodBeat.o(16781);
    }

    public final void ng(int i) {
        AppMethodBeat.i(16782);
        aw.Rg().b(i, (f) this);
        this.gIW.remove(Integer.valueOf(i));
        if (this.gIW.isEmpty()) {
            if (this.gII != null) {
                this.gII.dismiss();
                this.gII = null;
            }
            Iterator it = this.gIG.iterator();
            while (it.hasNext()) {
                aw.Rg().c((m) it.next());
            }
            it = this.gIH.iterator();
            while (it.hasNext()) {
                aw.Rg().c((m) it.next());
            }
            this.gIG.clear();
            this.gIH.clear();
            this.gIV = null;
            this.mContext = null;
        }
        AppMethodBeat.o(16782);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        Object obj = 1;
        AppMethodBeat.i(16783);
        if (this.gIH.contains(mVar)) {
            this.gIH.remove(mVar);
            ab.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.gIG.contains(mVar)) {
            this.gIG.remove(mVar);
            ab.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            obj = null;
        }
        if (this.gIH.isEmpty() && this.gIG.isEmpty() && this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        if (!(obj == null || this.gIV == null)) {
            this.gIV.d(i, i2, str, mVar);
        }
        AppMethodBeat.o(16783);
    }

    public final void g(m mVar) {
        AppMethodBeat.i(16780);
        ab.d("MicroMsg.WalletNetSceneMgr", "isShowProgress true");
        this.gIH.add(mVar);
        if (this.gII == null || !(this.gII == null || this.gII.isShowing())) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            this.gII = h.b(this.mContext, "", true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(16778);
                    if (b.this.gII != null && b.this.gIG.isEmpty()) {
                        b.this.gII.dismiss();
                        Iterator it = b.this.gIH.iterator();
                        while (it.hasNext()) {
                            aw.Rg().c((m) it.next());
                        }
                        b.this.gIH.clear();
                    }
                    AppMethodBeat.o(16778);
                }
            });
        }
        aw.Rg().a(mVar, 0);
        AppMethodBeat.o(16780);
    }
}
