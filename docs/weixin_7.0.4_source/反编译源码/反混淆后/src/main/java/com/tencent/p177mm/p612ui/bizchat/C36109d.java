package com.tencent.p177mm.p612ui.bizchat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C15819h;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.bizchat.d */
public final class C36109d extends C40845o implements C4937b {
    private Cursor gnQ;
    private String jMp;
    private int pUv;

    public C36109d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        AppMethodBeat.m2504i(30242);
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "create!");
        this.jMp = str;
        m59442Km();
        AppMethodBeat.m2505o(30242);
    }

    /* renamed from: Km */
    private void m59442Km() {
        AppMethodBeat.m2504i(30243);
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        this.gnQ = C41747z.aeU().mo60345rn(this.jMp);
        this.pUv = 0;
        AppMethodBeat.m2505o(30243);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(30244);
        int count = this.gnQ.getCount() + 1;
        AppMethodBeat.m2505o(30244);
        return count;
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(30245);
        C5445a c5445a = null;
        if (i == this.pUv) {
            c5445a = new C15819h(i);
            c5445a.mKQ = this.zmV.getActivity().getResources().getString(C25738R.string.e1t);
        } else if (i <= this.pUv || !this.gnQ.moveToPosition((i - this.pUv) - 1)) {
            C4990ab.m7413e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            c5445a = new C30407a(i);
            C32232a c32232a = new C32232a();
            c32232a.mo8995d(this.gnQ);
            if (c5445a.jMj == -1) {
                c5445a.jMj = c32232a.field_bizChatId;
                C45142c aK = C41747z.aeT().mo60349aK(c32232a.field_bizChatId);
                if (aK.isGroup()) {
                    c5445a.gnx = aK.field_chatName;
                    c5445a.yDO = aK.field_headImageUrl;
                    c5445a.username = aK.field_brandUserName;
                } else {
                    C45143j cH = C41747z.aeV().mo60356cH(aK.field_bizChatServId);
                    if (cH != null) {
                        c5445a.gnx = cH.field_userName;
                        c5445a.yDO = cH.field_headImageUrl;
                        c5445a.username = cH.field_brandUserName;
                    }
                }
                if (C5046bo.m7519ac(c5445a.gnx)) {
                    c5445a.gnx = this.zmV.getActivity().getResources().getString(C25738R.string.dso);
                }
                if (C5046bo.isNullOrNil(c5445a.username)) {
                    c5445a.username = c32232a.field_brandUserName;
                }
            }
        }
        AppMethodBeat.m2505o(30245);
        return c5445a;
    }

    public final void finish() {
        AppMethodBeat.m2504i(30246);
        super.finish();
        C4990ab.m7416i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.m2505o(30246);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(30247);
        m59442Km();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(30247);
    }
}
