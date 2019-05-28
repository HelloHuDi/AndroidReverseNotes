package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;

public class CommonChatroomInfoUI extends MMBaseSelectContactUI {
    private ad ehM;
    private a pld;
    private b ple;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void Kh() {
        AppMethodBeat.i(23324);
        super.Kh();
        String stringExtra = getIntent().getStringExtra("Select_Talker_Name");
        aw.ZK();
        this.ehM = c.XM().aoO(stringExtra);
        AppMethodBeat.o(23324);
    }

    public final void initView() {
        AppMethodBeat.i(23325);
        super.initView();
        a aVar = this.pld;
        i iVar = new i();
        iVar.query = aVar.ehM.field_username;
        iVar.mEw = aVar;
        iVar.handler = aVar.handler;
        iVar.hbo = 6;
        iVar.mEv = new a();
        ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(23325);
    }

    public final boolean aow() {
        return true;
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.i(23326);
        String string;
        if (this.ehM.dtS == 1) {
            string = getString(R.string.avc);
            AppMethodBeat.o(23326);
            return string;
        } else if (this.ehM.dtS == 2) {
            string = getString(R.string.avb);
            AppMethodBeat.o(23326);
            return string;
        } else {
            string = getString(R.string.avg);
            AppMethodBeat.o(23326);
            return string;
        }
    }

    public final o aoz() {
        AppMethodBeat.i(23327);
        if (this.pld == null) {
            this.pld = new a(this, this.scene, this.ehM);
        }
        a aVar = this.pld;
        AppMethodBeat.o(23327);
        return aVar;
    }

    public final m aoA() {
        AppMethodBeat.i(23328);
        if (this.ple == null) {
            this.ple = new b(this, this.scene, this.ehM);
        }
        b bVar = this.ple;
        AppMethodBeat.o(23328);
        return bVar;
    }

    public final void mO(int i) {
        AppMethodBeat.i(23329);
        f fVar = (f) getContentLV().getAdapter().getItem(i);
        if (fVar != null) {
            d.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", fVar.ehM.field_username).putExtra("finish_direct", true));
        }
        AppMethodBeat.o(23329);
    }
}
