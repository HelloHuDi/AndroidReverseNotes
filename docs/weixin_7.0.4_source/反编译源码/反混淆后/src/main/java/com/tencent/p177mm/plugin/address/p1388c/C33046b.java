package com.tencent.p177mm.plugin.address.p1388c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.address.c.b */
public final class C33046b implements C1202f {
    HashSet<C1207m> gIG = new HashSet();
    HashSet<C1207m> gIH = new HashSet();
    Dialog gII = null;
    private C26685a gIV = null;
    private Set<Integer> gIW = new HashSet();
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.address.c.b$1 */
    class C330471 implements OnCancelListener {
        C330471() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(16778);
            if (C33046b.this.gII != null && C33046b.this.gIG.isEmpty()) {
                C33046b.this.gII.dismiss();
                Iterator it = C33046b.this.gIH.iterator();
                while (it.hasNext()) {
                    C9638aw.m17182Rg().mo14547c((C1207m) it.next());
                }
                C33046b.this.gIH.clear();
            }
            AppMethodBeat.m2505o(16778);
        }
    }

    public C33046b(Context context, C26685a c26685a) {
        AppMethodBeat.m2504i(16779);
        this.mContext = context;
        this.gIV = c26685a;
        AppMethodBeat.m2505o(16779);
    }

    /* renamed from: nf */
    public final void mo53606nf(int i) {
        AppMethodBeat.m2504i(16781);
        this.gIW.add(Integer.valueOf(i));
        C9638aw.m17182Rg().mo14539a(i, (C1202f) this);
        AppMethodBeat.m2505o(16781);
    }

    /* renamed from: ng */
    public final void mo53607ng(int i) {
        AppMethodBeat.m2504i(16782);
        C9638aw.m17182Rg().mo14546b(i, (C1202f) this);
        this.gIW.remove(Integer.valueOf(i));
        if (this.gIW.isEmpty()) {
            if (this.gII != null) {
                this.gII.dismiss();
                this.gII = null;
            }
            Iterator it = this.gIG.iterator();
            while (it.hasNext()) {
                C9638aw.m17182Rg().mo14547c((C1207m) it.next());
            }
            it = this.gIH.iterator();
            while (it.hasNext()) {
                C9638aw.m17182Rg().mo14547c((C1207m) it.next());
            }
            this.gIG.clear();
            this.gIH.clear();
            this.gIV = null;
            this.mContext = null;
        }
        AppMethodBeat.m2505o(16782);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        Object obj = 1;
        AppMethodBeat.m2504i(16783);
        if (this.gIH.contains(c1207m)) {
            this.gIH.remove(c1207m);
            C4990ab.m7410d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.gIG.contains(c1207m)) {
            this.gIG.remove(c1207m);
            C4990ab.m7410d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            obj = null;
        }
        if (this.gIH.isEmpty() && this.gIG.isEmpty() && this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        if (!(obj == null || this.gIV == null)) {
            this.gIV.mo44444d(i, i2, str, c1207m);
        }
        AppMethodBeat.m2505o(16783);
    }

    /* renamed from: g */
    public final void mo53605g(C1207m c1207m) {
        AppMethodBeat.m2504i(16780);
        C4990ab.m7410d("MicroMsg.WalletNetSceneMgr", "isShowProgress true");
        this.gIH.add(c1207m);
        if (this.gII == null || !(this.gII == null || this.gII.isShowing())) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            this.gII = C30379h.m48458b(this.mContext, "", true, new C330471());
        }
        C9638aw.m17182Rg().mo14541a(c1207m, 0);
        AppMethodBeat.m2505o(16780);
    }
}
