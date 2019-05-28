package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.e;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.z;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import java.util.ArrayList;

@a(dFp = e.class)
public class d extends a implements e {
    public final boolean bb(bi biVar) {
        AppMethodBeat.i(31238);
        if (biVar.dtw()) {
            if (!this.cgL.getTalkerUserName().equals("medianote")) {
                aw.ZK();
                c.XL().c(new com.tencent.mm.az.e(biVar.field_talker, biVar.field_msgSvrId));
            }
            ak.aW(biVar);
            this.cgL.qp(true);
            AppMethodBeat.o(31238);
            return true;
        }
        AppMethodBeat.o(31238);
        return false;
    }

    public final void dDD() {
        AppMethodBeat.i(31239);
        Intent intent = new Intent(this.cgL.yTx.getContext(), SelectContactUI.class);
        if (ad.aox(this.cgL.getTalkerUserName()) || t.mP(this.cgL.getTalkerUserName())) {
            intent.putExtra("list_attr", s.C(s.znI, 1, 16777216));
        } else {
            intent.putExtra("list_attr", s.C(s.znI, 2048, 16777216));
        }
        intent.putExtra("list_type", 4);
        intent.putExtra("received_card_name", this.cgL.getTalkerUserName());
        intent.putExtra("block_contact", this.cgL.getTalkerUserName());
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", this.cgL.yTx.getMMResources().getString(R.string.eu));
        this.cgL.yTx.startActivityForResult(intent, 223);
        AppMethodBeat.o(31239);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31240);
        super.onActivityResult(i, i2, intent);
        final String stringExtra;
        String mJ;
        String string;
        switch (i) {
            case 223:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("be_send_card_name");
                    if (this.cgL.dFx()) {
                        ad.aox(stringExtra);
                    }
                    mJ = com.tencent.mm.model.s.mJ(stringExtra);
                    final String stringExtra2 = intent.getStringExtra("received_card_name");
                    final boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    g.a aVar = new g.a(this.cgL.yTx.getContext());
                    b.a(stringExtra, true, -1);
                    aw.ZK();
                    ad aoM = c.XM().aoM(stringExtra);
                    if (t.kv(aoM.field_verifyFlag)) {
                        string = this.cgL.yTx.getResources().getString(R.string.qx);
                    } else if (ad.aox(stringExtra)) {
                        string = SelectConversationUI.c(ah.getContext(), aoM);
                    } else {
                        string = this.cgL.yTx.getResources().getString(R.string.qy);
                    }
                    aVar.cx(stringExtra2).ajC(new StringBuffer(string).append(mJ).toString()).h(Boolean.TRUE).KQ(R.string.tf).a(new q.a() {
                        public final void a(boolean z, String str, int i) {
                            AppMethodBeat.i(31237);
                            d.this.cgL.aqX();
                            if (z) {
                                com.tencent.mm.plugin.messenger.a.g.bOk().q(stringExtra, stringExtra2, booleanExtra);
                                com.tencent.mm.plugin.messenger.a.g.bOk().eZ(str, stringExtra2);
                            }
                            AppMethodBeat.o(31237);
                        }
                    }).gud.show();
                }
                AppMethodBeat.o(31240);
                return;
            case 224:
                if (i2 == -1 && intent != null) {
                    string = intent.getStringExtra("be_send_card_name");
                    stringExtra = intent.getStringExtra("received_card_name");
                    mJ = intent.getStringExtra("custom_send_text");
                    boolean booleanExtra2 = intent.getBooleanExtra("Is_Chatroom", false);
                    Intent intent2 = new Intent(this.cgL.yTx.getContext(), ChattingUI.class);
                    intent2.putExtra("Chat_User", stringExtra);
                    intent2.putExtra("send_card_username", string);
                    intent2.putExtra("send_card_edittext", mJ);
                    intent2.putExtra("Is_Chatroom", booleanExtra2);
                    this.cgL.yTx.startActivity(intent2);
                    break;
                }
        }
        AppMethodBeat.o(31240);
    }

    public final void dxx() {
        AppMethodBeat.i(31241);
        Intent intent = this.cgL.yTx.getContext().getIntent();
        String stringExtra = intent.getStringExtra("Chat_User");
        String stringExtra2 = intent.getStringExtra("send_card_username");
        if (!bo.isNullOrNil(stringExtra2)) {
            boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
            String stringExtra3 = intent.getStringExtra("send_card_edittext");
            if (booleanExtra) {
                aw.Rg().a(new h(bo.bc(stringExtra, ""), z.arT(stringExtra2), ad.aox(stringExtra2) ? 66 : 42), 0);
            } else {
                ArrayList P = bo.P(bo.bc(stringExtra, "").split(","));
                String arT = z.arT(stringExtra2);
                for (int i = 0; i < P.size(); i++) {
                    int i2;
                    String str = (String) P.get(i);
                    if (ad.aox(stringExtra2)) {
                        i2 = 66;
                    } else {
                        i2 = 42;
                    }
                    aw.Rg().a(new h(str, arT, i2), 0);
                }
            }
            if (stringExtra3 != null) {
                com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra3, stringExtra);
            }
        }
        AppMethodBeat.o(31241);
    }
}
