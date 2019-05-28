package com.tencent.p177mm.p612ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.contact.p625a.C15819h;
import com.tencent.p177mm.p612ui.contact.p625a.C30656f;
import com.tencent.p177mm.p612ui.contact.p625a.C46672b;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7617ak;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.x */
public final class C41349x extends C40845o implements C4937b {
    private Cursor gnQ;
    private int pUv;
    private List<String> zor;
    private int zos;
    private boolean zot;
    private int zou;

    public C41349x(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list) {
        this(mMBaseSelectContactUI, list, true, false, false, 0);
    }

    public C41349x(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, boolean z3, int i) {
        super(mMBaseSelectContactUI, list, z, z2);
        AppMethodBeat.m2504i(105257);
        this.zou = 0;
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "create!");
        this.zot = z3;
        this.zou = i;
        m72108Km();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10118a(this);
        AppMethodBeat.m2505o(105257);
    }

    /* renamed from: Km */
    private void m72108Km() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(105258);
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        if (C15830s.m24192hr(this.zou, 4)) {
            this.gnQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15770a(C1855t.fkU, this.elZ, this.znm, "");
        } else if (C15830s.m24192hr(this.zou, 16)) {
            this.gnQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15770a(C1855t.fkW, this.elZ, this.znm, "");
        } else {
            this.gnQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15770a(C1855t.fkP, this.elZ, this.znm, "");
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
        AppMethodBeat.m2505o(105258);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(105259);
        int i = this.pUv + 1;
        if (this.gnQ != null) {
            i += this.gnQ.getCount();
        }
        AppMethodBeat.m2505o(105259);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        C5445a c15819h;
        C5445a c5445a = null;
        AppMethodBeat.m2504i(105260);
        if (this.pUv > this.zos) {
            if (i == this.zos) {
                c15819h = new C15819h(i);
                c15819h.mKQ = this.zmV.getActivity().getResources().getString(C25738R.string.e1p);
            } else if (i == this.zos + 1) {
                c15819h = new C46672b(i);
                String string = this.zmV.getActivity().getResources().getString(C25738R.string.e1p);
                c15819h.resId = C1318a.default_servicebrand_contact;
                c15819h.bCu = string;
            }
            if (i != this.pUv) {
                c5445a = new C15819h(i);
                c5445a.mKQ = this.zmV.getActivity().getResources().getString(C25738R.string.e1a);
            } else if (i < this.zos) {
                if (this.zor != null && i >= 0 && i < this.zor.size()) {
                    c5445a = new C46672b(i);
                    c5445a.username = (String) this.zor.get(i);
                }
            } else if (i <= this.pUv || !this.gnQ.moveToPosition((i - this.pUv) - 1)) {
                C4990ab.m7413e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
                c5445a = c15819h;
            } else {
                c5445a = new C30656f(i);
                C7617ak c7617ak = new C7617ak();
                c7617ak.mo8995d(this.gnQ);
                C1720g.m3537RQ();
                c5445a.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(c7617ak.field_username);
                if (c5445a.ehM == null) {
                    C1720g.m3537RQ();
                    c5445a.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(c7617ak.field_username);
                }
                c5445a.zmW = clI();
            }
            AppMethodBeat.m2505o(105260);
            return c5445a;
        }
        c15819h = null;
        if (i != this.pUv) {
        }
        AppMethodBeat.m2505o(105260);
        return c5445a;
    }

    public final void finish() {
        AppMethodBeat.m2504i(105261);
        super.finish();
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10121b(this);
        AppMethodBeat.m2505o(105261);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(105262);
        m72108Km();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(105262);
    }
}
