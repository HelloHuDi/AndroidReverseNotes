package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p201az.C32325e;
import com.tencent.p177mm.p612ui.chatting.C36121ak;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36136e;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.C23927z;
import com.tencent.p177mm.p612ui.contact.SelectContactUI;
import com.tencent.p177mm.p612ui.transmit.SelectConversationUI;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;

@C15590a(dFp = C36136e.class)
/* renamed from: com.tencent.mm.ui.chatting.c.d */
public class C44815d extends C44291a implements C36136e {
    /* renamed from: bb */
    public final boolean mo57025bb(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31238);
        if (c7620bi.dtw()) {
            if (!this.cgL.getTalkerUserName().equals("medianote")) {
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C32325e(c7620bi.field_talker, c7620bi.field_msgSvrId));
            }
            C36121ak.m59481aW(c7620bi);
            this.cgL.mo74882qp(true);
            AppMethodBeat.m2505o(31238);
            return true;
        }
        AppMethodBeat.m2505o(31238);
        return false;
    }

    public final void dDD() {
        AppMethodBeat.m2504i(31239);
        Intent intent = new Intent(this.cgL.yTx.getContext(), SelectContactUI.class);
        if (C7616ad.aox(this.cgL.getTalkerUserName()) || C1855t.m3903mP(this.cgL.getTalkerUserName())) {
            intent.putExtra("list_attr", C15830s.m24190C(C15830s.znI, 1, 16777216));
        } else {
            intent.putExtra("list_attr", C15830s.m24190C(C15830s.znI, 2048, 16777216));
        }
        intent.putExtra("list_type", 4);
        intent.putExtra("received_card_name", this.cgL.getTalkerUserName());
        intent.putExtra("block_contact", this.cgL.getTalkerUserName());
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", this.cgL.yTx.getMMResources().getString(C25738R.string.f8782eu));
        this.cgL.yTx.startActivityForResult(intent, 223);
        AppMethodBeat.m2505o(31239);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31240);
        super.onActivityResult(i, i2, intent);
        final String stringExtra;
        String mJ;
        String string;
        switch (i) {
            case 223:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("be_send_card_name");
                    if (this.cgL.dFx()) {
                        C7616ad.aox(stringExtra);
                    }
                    mJ = C1854s.m3866mJ(stringExtra);
                    final String stringExtra2 = intent.getStringExtra("received_card_name");
                    final boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    C23273a c23273a = new C23273a(this.cgL.yTx.getContext());
                    C41730b.m73490a(stringExtra, true, -1);
                    C9638aw.m17190ZK();
                    C7616ad aoM = C18628c.m29078XM().aoM(stringExtra);
                    if (C1855t.m3897kv(aoM.field_verifyFlag)) {
                        string = this.cgL.yTx.getResources().getString(C25738R.string.f9146qx);
                    } else if (C7616ad.aox(stringExtra)) {
                        string = SelectConversationUI.m39127c(C4996ah.getContext(), aoM);
                    } else {
                        string = this.cgL.yTx.getResources().getString(C25738R.string.f9147qy);
                    }
                    c23273a.mo38972cx(stringExtra2).ajC(new StringBuffer(string).append(mJ).toString()).mo38977h(Boolean.TRUE).mo38965KQ(C25738R.string.f9221tf).mo38966a(new C30111a() {
                        /* renamed from: a */
                        public final void mo6399a(boolean z, String str, int i) {
                            AppMethodBeat.m2504i(31237);
                            C44815d.this.cgL.aqX();
                            if (z) {
                                C12519g.bOk().mo46462q(stringExtra, stringExtra2, booleanExtra);
                                C12519g.bOk().mo46461eZ(str, stringExtra2);
                            }
                            AppMethodBeat.m2505o(31237);
                        }
                    }).gud.show();
                }
                AppMethodBeat.m2505o(31240);
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
        AppMethodBeat.m2505o(31240);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31241);
        Intent intent = this.cgL.yTx.getContext().getIntent();
        String stringExtra = intent.getStringExtra("Chat_User");
        String stringExtra2 = intent.getStringExtra("send_card_username");
        if (!C5046bo.isNullOrNil(stringExtra2)) {
            boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
            String stringExtra3 = intent.getStringExtra("send_card_edittext");
            if (booleanExtra) {
                C9638aw.m17182Rg().mo14541a(new C26451h(C5046bo.m7532bc(stringExtra, ""), C23927z.arT(stringExtra2), C7616ad.aox(stringExtra2) ? 66 : 42), 0);
            } else {
                ArrayList P = C5046bo.m7508P(C5046bo.m7532bc(stringExtra, "").split(","));
                String arT = C23927z.arT(stringExtra2);
                for (int i = 0; i < P.size(); i++) {
                    int i2;
                    String str = (String) P.get(i);
                    if (C7616ad.aox(stringExtra2)) {
                        i2 = 66;
                    } else {
                        i2 = 42;
                    }
                    C9638aw.m17182Rg().mo14541a(new C26451h(str, arT, i2), 0);
                }
            }
            if (stringExtra3 != null) {
                C12519g.bOk().mo46461eZ(stringExtra3, stringExtra);
            }
        }
        AppMethodBeat.m2505o(31241);
    }
}
