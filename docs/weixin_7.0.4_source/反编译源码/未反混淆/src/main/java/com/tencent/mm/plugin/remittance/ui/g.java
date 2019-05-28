package com.tencent.mm.plugin.remittance.ui;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class g extends o implements b {
    private int fromScene;
    private Cursor gnQ;
    int pUu;
    int pUv;
    private List<String> pUw;
    private int pUx = 0;

    public g(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, int i) {
        super(mMBaseSelectContactUI, list2, true, false);
        AppMethodBeat.i(44986);
        this.pUw = list;
        this.fromScene = i;
        ab.i("MicroMsg.RecentConversationAdapter", "create!");
        Km();
        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().a(this);
        AppMethodBeat.o(44986);
    }

    private void Km() {
        int i;
        Cursor ex;
        List list;
        AppMethodBeat.i(44987);
        ab.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        this.pUx = 0;
        ArrayList arrayList = new ArrayList();
        this.pUu = -1;
        this.pUv = -1;
        if (this.pUw == null || this.pUw.size() <= 0) {
            i = 0;
        } else {
            com.tencent.mm.kernel.g.RQ();
            ex = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().ex(this.pUw);
            arrayList.add(ex);
            int count = ex.getCount();
            if (count > 0) {
                this.pUu = this.zmV.getContentLV().getHeaderViewsCount();
                this.pUx++;
                i = count;
            } else {
                this.pUu = -1;
                i = count;
            }
        }
        List list2 = this.elZ;
        if (list2 != null) {
            list2.addAll(this.pUw);
            list = list2;
        } else {
            list = this.pUw;
        }
        if (this.fromScene == 1) {
            ex = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().a(t.fkQ, list, this.znm, "");
        } else {
            ex = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().a(t.fkU, list, this.znm, "");
        }
        if (ex.getCount() > 0) {
            this.pUx++;
            if (i > 0) {
                this.pUv = (i + this.pUu) + 1;
            } else {
                this.pUv = this.zmV.getContentLV().getHeaderViewsCount();
            }
        } else {
            this.pUv = -1;
        }
        arrayList.add(ex);
        this.gnQ = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        AppMethodBeat.o(44987);
    }

    public final a mP(int i) {
        a hVar;
        AppMethodBeat.i(44988);
        if (i == this.pUv || i == this.pUu) {
            hVar = new h(i);
            if (i == this.pUu) {
                if (this.fromScene == 1) {
                    hVar.mKQ = this.zmV.getActivity().getResources().getString(R.string.bn);
                } else {
                    hVar.mKQ = this.zmV.getActivity().getResources().getString(R.string.dq0);
                }
            } else if (i == this.pUv) {
                hVar.mKQ = this.zmV.getActivity().getResources().getString(R.string.fsw);
            }
        } else {
            int i2;
            if (this.pUx == 2) {
                if (i > this.pUv) {
                    i2 = i - 2;
                } else {
                    i2 = i - 1;
                }
            } else if (this.pUx == 1) {
                i2 = i - 1;
            } else {
                ab.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", Integer.valueOf(i));
                i2 = i;
            }
            if (this.gnQ.moveToPosition(i2)) {
                a fVar = new f(i);
                ak akVar = new ak();
                akVar.d(this.gnQ);
                com.tencent.mm.kernel.g.RQ();
                fVar.ehM = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoI(akVar.field_username);
                if (fVar.ehM == null) {
                    com.tencent.mm.kernel.g.RQ();
                    fVar.ehM = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoN(akVar.field_username);
                }
                hVar = fVar;
            } else {
                hVar = null;
            }
        }
        AppMethodBeat.o(44988);
        return hVar;
    }

    public final int getCount() {
        AppMethodBeat.i(44989);
        int count = this.gnQ.getCount() + this.pUx;
        AppMethodBeat.o(44989);
        return count;
    }

    public final void finish() {
        AppMethodBeat.i(44990);
        super.finish();
        ab.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().b(this);
        AppMethodBeat.o(44990);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(44991);
        Km();
        notifyDataSetChanged();
        AppMethodBeat.o(44991);
    }
}
