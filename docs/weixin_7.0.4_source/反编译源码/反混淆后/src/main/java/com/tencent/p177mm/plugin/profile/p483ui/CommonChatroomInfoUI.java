package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.contact.C36877m;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.MMBaseSelectContactUI;
import com.tencent.p177mm.p612ui.contact.p625a.C30656f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.profile.p483ui.C3629a.C3630a;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.profile.ui.CommonChatroomInfoUI */
public class CommonChatroomInfoUI extends MMBaseSelectContactUI {
    private C7616ad ehM;
    private C3629a pld;
    private C12842b ple;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(23324);
        super.mo7850Kh();
        String stringExtra = getIntent().getStringExtra("Select_Talker_Name");
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(stringExtra);
        AppMethodBeat.m2505o(23324);
    }

    public final void initView() {
        AppMethodBeat.m2504i(23325);
        super.initView();
        C3629a c3629a = this.pld;
        C20846i c20846i = new C20846i();
        c20846i.query = c3629a.ehM.field_username;
        c20846i.mEw = c3629a;
        c20846i.handler = c3629a.handler;
        c20846i.hbo = 6;
        c20846i.mEv = new C3630a();
        ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(23325);
    }

    public final boolean aow() {
        return true;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.m2504i(23326);
        String string;
        if (this.ehM.dtS == 1) {
            string = getString(C25738R.string.avc);
            AppMethodBeat.m2505o(23326);
            return string;
        } else if (this.ehM.dtS == 2) {
            string = getString(C25738R.string.avb);
            AppMethodBeat.m2505o(23326);
            return string;
        } else {
            string = getString(C25738R.string.avg);
            AppMethodBeat.m2505o(23326);
            return string;
        }
    }

    public final C40845o aoz() {
        AppMethodBeat.m2504i(23327);
        if (this.pld == null) {
            this.pld = new C3629a(this, this.scene, this.ehM);
        }
        C3629a c3629a = this.pld;
        AppMethodBeat.m2505o(23327);
        return c3629a;
    }

    public final C36877m aoA() {
        AppMethodBeat.m2504i(23328);
        if (this.ple == null) {
            this.ple = new C12842b(this, this.scene, this.ehM);
        }
        C12842b c12842b = this.ple;
        AppMethodBeat.m2505o(23328);
        return c12842b;
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(23329);
        C30656f c30656f = (C30656f) getContentLV().getAdapter().getItem(i);
        if (c30656f != null) {
            C25985d.m41473f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", c30656f.ehM.field_username).putExtra("finish_direct", true));
        }
        AppMethodBeat.m2505o(23329);
    }
}
