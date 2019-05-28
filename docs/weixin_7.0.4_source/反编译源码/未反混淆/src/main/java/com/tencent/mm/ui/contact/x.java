package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import java.util.List;

public final class x extends o implements b {
    private Cursor gnQ;
    private int pUv;
    private List<String> zor;
    private int zos;
    private boolean zot;
    private int zou;

    public x(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list) {
        this(mMBaseSelectContactUI, list, true, false, false, 0);
    }

    public x(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, boolean z3, int i) {
        super(mMBaseSelectContactUI, list, z, z2);
        AppMethodBeat.i(105257);
        this.zou = 0;
        ab.i("MicroMsg.RecentConversationAdapter", "create!");
        this.zot = z3;
        this.zou = i;
        Km();
        ((j) g.K(j.class)).XR().a(this);
        AppMethodBeat.o(105257);
    }

    private void Km() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(105258);
        ab.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        if (s.hr(this.zou, 4)) {
            this.gnQ = ((j) g.K(j.class)).XR().a(t.fkU, this.elZ, this.znm, "");
        } else if (s.hr(this.zou, 16)) {
            this.gnQ = ((j) g.K(j.class)).XR().a(t.fkW, this.elZ, this.znm, "");
        } else {
            this.gnQ = ((j) g.K(j.class)).XR().a(t.fkP, this.elZ, this.znm, "");
        }
        if (this.zot) {
            i = 2;
        } else {
            i = 0;
        }
        if (this.zor != null) {
            i2 = this.zor.size();
        }
        this.zos = i2;
        this.pUv = i + this.zos;
        clearCache();
        AppMethodBeat.o(105258);
    }

    public final int getCount() {
        AppMethodBeat.i(105259);
        int i = this.pUv + 1;
        if (this.gnQ != null) {
            i += this.gnQ.getCount();
        }
        AppMethodBeat.o(105259);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a mP(int i) {
        a hVar;
        a aVar = null;
        AppMethodBeat.i(105260);
        if (this.pUv > this.zos) {
            if (i == this.zos) {
                hVar = new h(i);
                hVar.mKQ = this.zmV.getActivity().getResources().getString(R.string.e1p);
            } else if (i == this.zos + 1) {
                hVar = new com.tencent.mm.ui.contact.a.b(i);
                String string = this.zmV.getActivity().getResources().getString(R.string.e1p);
                hVar.resId = R.raw.default_servicebrand_contact;
                hVar.bCu = string;
            }
            if (i != this.pUv) {
                aVar = new h(i);
                aVar.mKQ = this.zmV.getActivity().getResources().getString(R.string.e1a);
            } else if (i < this.zos) {
                if (this.zor != null && i >= 0 && i < this.zor.size()) {
                    aVar = new com.tencent.mm.ui.contact.a.b(i);
                    aVar.username = (String) this.zor.get(i);
                }
            } else if (i <= this.pUv || !this.gnQ.moveToPosition((i - this.pUv) - 1)) {
                ab.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
                aVar = hVar;
            } else {
                aVar = new f(i);
                ak akVar = new ak();
                akVar.d(this.gnQ);
                g.RQ();
                aVar.ehM = ((j) g.K(j.class)).XM().aoI(akVar.field_username);
                if (aVar.ehM == null) {
                    g.RQ();
                    aVar.ehM = ((j) g.K(j.class)).XM().aoN(akVar.field_username);
                }
                aVar.zmW = clI();
            }
            AppMethodBeat.o(105260);
            return aVar;
        }
        hVar = null;
        if (i != this.pUv) {
        }
        AppMethodBeat.o(105260);
        return aVar;
    }

    public final void finish() {
        AppMethodBeat.i(105261);
        super.finish();
        ab.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        ((j) g.K(j.class)).XR().b(this);
        AppMethodBeat.o(105261);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(105262);
        Km();
        notifyDataSetChanged();
        AppMethodBeat.o(105262);
    }
}
