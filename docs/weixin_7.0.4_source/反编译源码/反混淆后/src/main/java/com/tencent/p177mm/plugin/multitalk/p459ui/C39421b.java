package com.tencent.p177mm.plugin.multitalk.p459ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.contact.C23923q;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C21335a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.b */
public final class C39421b extends C23923q {
    private String chatroomName;
    private String[] gnP;
    private Cursor gnQ;
    private String query;

    public C39421b(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        AppMethodBeat.m2504i(54177);
        this.chatroomName = str;
        List oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(this.chatroomName);
        if (oe != null) {
            this.gnP = C5046bo.m7547ej(oe);
        }
        AppMethodBeat.m2505o(54177);
    }

    /* renamed from: a */
    public final void mo24874a(String str, int[] iArr, boolean z) {
        AppMethodBeat.m2504i(54178);
        C4990ab.m7417i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", str);
        clearCache();
        this.query = str;
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        if (!(C5046bo.isNullOrNil(this.query) || this.gnP == null)) {
            this.gnQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15705a(this.gnP, "@all.chatroom", this.query, null, null);
        }
        notifyDataSetChanged();
        mo39697ci(str, true);
        AppMethodBeat.m2505o(54178);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(54179);
        C5445a c5445a = null;
        if (this.gnQ.moveToPosition(i)) {
            C7616ad c7616ad = new C7616ad();
            c7616ad.mo8995d(this.gnQ);
            c5445a = new C21335a(i);
            c5445a.ehM = c7616ad;
            c5445a.zmW = clI();
            c5445a.query = this.query;
        }
        AppMethodBeat.m2505o(54179);
        return c5445a;
    }

    public final void finish() {
        AppMethodBeat.m2504i(54180);
        super.finish();
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.m2505o(54180);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(54181);
        if (this.gnQ == null) {
            AppMethodBeat.m2505o(54181);
            return 0;
        }
        int count = this.gnQ.getCount();
        AppMethodBeat.m2505o(54181);
        return count;
    }
}
