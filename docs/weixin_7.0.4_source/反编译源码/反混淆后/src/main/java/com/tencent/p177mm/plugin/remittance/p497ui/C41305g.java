package com.tencent.p177mm.plugin.remittance.p497ui;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C15819h;
import com.tencent.p177mm.p612ui.contact.p625a.C30656f;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7617ak;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.ui.g */
public final class C41305g extends C40845o implements C4937b {
    private int fromScene;
    private Cursor gnQ;
    int pUu;
    int pUv;
    private List<String> pUw;
    private int pUx = 0;

    public C41305g(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, int i) {
        super(mMBaseSelectContactUI, list2, true, false);
        AppMethodBeat.m2504i(44986);
        this.pUw = list;
        this.fromScene = i;
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "create!");
        m71946Km();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10118a(this);
        AppMethodBeat.m2505o(44986);
    }

    /* renamed from: Km */
    private void m71946Km() {
        int i;
        Cursor ex;
        List list;
        AppMethodBeat.m2504i(44987);
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "resetData");
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
            C1720g.m3537RQ();
            ex = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15761ex(this.pUw);
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
            ex = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15770a(C1855t.fkQ, list, this.znm, "");
        } else {
            ex = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15770a(C1855t.fkU, list, this.znm, "");
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
        AppMethodBeat.m2505o(44987);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        C5445a c15819h;
        AppMethodBeat.m2504i(44988);
        if (i == this.pUv || i == this.pUu) {
            c15819h = new C15819h(i);
            if (i == this.pUu) {
                if (this.fromScene == 1) {
                    c15819h.mKQ = this.zmV.getActivity().getResources().getString(C25738R.string.f8673bn);
                } else {
                    c15819h.mKQ = this.zmV.getActivity().getResources().getString(C25738R.string.dq0);
                }
            } else if (i == this.pUv) {
                c15819h.mKQ = this.zmV.getActivity().getResources().getString(C25738R.string.fsw);
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
                C4990ab.m7413e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", Integer.valueOf(i));
                i2 = i;
            }
            if (this.gnQ.moveToPosition(i2)) {
                C5445a c30656f = new C30656f(i);
                C7617ak c7617ak = new C7617ak();
                c7617ak.mo8995d(this.gnQ);
                C1720g.m3537RQ();
                c30656f.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(c7617ak.field_username);
                if (c30656f.ehM == null) {
                    C1720g.m3537RQ();
                    c30656f.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(c7617ak.field_username);
                }
                c15819h = c30656f;
            } else {
                c15819h = null;
            }
        }
        AppMethodBeat.m2505o(44988);
        return c15819h;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44989);
        int count = this.gnQ.getCount() + this.pUx;
        AppMethodBeat.m2505o(44989);
        return count;
    }

    public final void finish() {
        AppMethodBeat.m2504i(44990);
        super.finish();
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10121b(this);
        AppMethodBeat.m2505o(44990);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(44991);
        m71946Km();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(44991);
    }
}
