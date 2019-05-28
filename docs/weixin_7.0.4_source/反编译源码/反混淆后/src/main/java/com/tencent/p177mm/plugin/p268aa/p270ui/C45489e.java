package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.contact.C23923q;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.ui.e */
public final class C45489e extends C23923q {
    private String chatroomName;
    private String[] gnP;
    private Cursor gnQ;
    private String query;

    public C45489e(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        AppMethodBeat.m2504i(40770);
        this.chatroomName = str;
        List oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(this.chatroomName);
        if (oe != null) {
            this.gnP = C5046bo.m7547ej(oe);
        }
        AppMethodBeat.m2505o(40770);
    }

    /* renamed from: a */
    public final void mo24874a(String str, int[] iArr, boolean z) {
        AppMethodBeat.m2504i(40771);
        C4990ab.m7417i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", str);
        clearCache();
        this.query = str;
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        if (!(C5046bo.isNullOrNil(this.query) || this.gnP == null)) {
            C1720g.m3537RQ();
            this.gnQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15705a(this.gnP, "@all.chatroom", this.query, null, null);
        }
        notifyDataSetChanged();
        mo39697ci(str, true);
        AppMethodBeat.m2505o(40771);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(40772);
        C5445a c5445a = null;
        if (this.gnQ.moveToPosition(i)) {
            C7616ad c7616ad = new C7616ad();
            c7616ad.mo8995d(this.gnQ);
            c5445a = new C40843e(i);
            c5445a.ehM = c7616ad;
            c5445a.zmW = true;
        }
        AppMethodBeat.m2505o(40772);
        return c5445a;
    }

    public final void finish() {
        AppMethodBeat.m2504i(40773);
        super.finish();
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.m2505o(40773);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(40774);
        if (this.gnQ == null) {
            AppMethodBeat.m2505o(40774);
            return 0;
        }
        int count = this.gnQ.getCount();
        AppMethodBeat.m2505o(40774);
        return count;
    }
}
