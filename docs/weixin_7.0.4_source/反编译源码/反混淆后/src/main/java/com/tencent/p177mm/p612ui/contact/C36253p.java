package com.tencent.p177mm.p612ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C8954i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p612ui.bizchat.C30407a;
import com.tencent.p177mm.p612ui.contact.C36877m.C36878a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.p */
public final class C36253p extends C23923q {
    private Cursor gnQ;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private String jMp;
    private String query;
    private C36878a zmU;
    private List<String> znn = null;

    public C36253p(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, 0);
        AppMethodBeat.m2504i(105225);
        this.jMp = str;
        C4990ab.m7416i("MicroMsg.MMSearchContactAdapter", "Create!");
        m59686Kh();
        AppMethodBeat.m2505o(105225);
    }

    /* renamed from: a */
    public final void mo49041a(C36878a c36878a) {
        this.zmU = c36878a;
    }

    /* renamed from: ci */
    public final void mo39697ci(String str, boolean z) {
        AppMethodBeat.m2504i(105226);
        if (this.zmU != null) {
            this.zmU.mo28008w(str, getCount(), z);
        }
        AppMethodBeat.m2505o(105226);
    }

    /* renamed from: Kh */
    private void m59686Kh() {
        AppMethodBeat.m2504i(105227);
        C4990ab.m7416i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.query = null;
        clearCache();
        AppMethodBeat.m2505o(105227);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(105228);
        if (this.gnQ == null) {
            AppMethodBeat.m2505o(105228);
            return 0;
        }
        int count = this.gnQ.getCount();
        AppMethodBeat.m2505o(105228);
        return count;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(105229);
        C5445a c5445a = null;
        if (i < 0 || !this.gnQ.moveToPosition(i)) {
            C4990ab.m7413e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            C5445a c30407a = new C30407a(i);
            C45142c c45142c = new C45142c();
            c45142c.mo8995d(this.gnQ);
            if (c30407a.jMj == -1) {
                c30407a.jMj = c45142c.field_bizChatLocalId;
                if (c45142c.isGroup()) {
                    c30407a.gnx = c45142c.field_chatName;
                    c30407a.yDO = c45142c.field_headImageUrl;
                    c30407a.username = c45142c.field_brandUserName;
                } else {
                    C45143j cH = ((C8954i) C1720g.m3528K(C8954i.class)).mo20408cH(c45142c.field_bizChatServId);
                    if (cH != null) {
                        c30407a.gnx = cH.field_userName;
                        c30407a.yDO = cH.field_headImageUrl;
                        c30407a.username = cH.field_brandUserName;
                    }
                }
                if (C5046bo.m7519ac(c30407a.gnx)) {
                    c30407a.gnx = this.zmV.getActivity().getResources().getString(C25738R.string.e1q);
                }
                if (C5046bo.isNullOrNil(c30407a.username)) {
                    c30407a.username = c45142c.field_brandUserName;
                }
            }
            c5445a = c30407a;
        }
        AppMethodBeat.m2505o(105229);
        return c5445a;
    }

    public final void finish() {
        AppMethodBeat.m2504i(105230);
        super.finish();
        C4990ab.m7416i("MicroMsg.MMSearchContactAdapter", "finish!");
        m59686Kh();
        AppMethodBeat.m2505o(105230);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final boolean mo39696c(C5445a c5445a) {
        return true;
    }
}
