package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.chatting.C36866d;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.plugin.subapp.p1039c.C22335h;
import com.tencent.p177mm.plugin.subapp.p1039c.C43667k;
import com.tencent.p177mm.plugin.subapp.p1039c.C46291e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ap */
public final class C23837ap extends C5378c {
    private C1202f fQS;
    private C46650a yJI;

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ap$1 */
    class C238381 implements C1202f {
        C238381() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(33394);
            C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + i + " errCode " + i2 + "  scene " + c1207m.getType());
            C9638aw.m17182Rg().mo14546b(221, C23837ap.this.fQS);
            C23837ap.this.fQS = null;
            AppMethodBeat.m2505o(33394);
        }
    }

    public final boolean dHk() {
        return false;
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == -1879048190) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33396);
        if (view == null || view.getTag() == null) {
            view = new C44341v(layoutInflater, 2130969113);
            view.setTag(new C36213be().mo57092fk(view));
        }
        AppMethodBeat.m2505o(33396);
        return view;
    }

    /* renamed from: b */
    public final String mo11017b(C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33397);
        String talkerUserName = c46650a.getTalkerUserName();
        AppMethodBeat.m2505o(33397);
        return talkerUserName;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final boolean mo11020b(C46650a c46650a) {
        return false;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, final int i, C46650a c46650a, final C7620bi c7620bi, String str) {
        String ae;
        Object obj;
        AppMethodBeat.m2504i(33398);
        C36213be c36213be = (C36213be) c5379a;
        this.yJI = c46650a;
        C8909j ma = C14877am.dhN().mo27204ma(c7620bi.field_msgId);
        String str2 = c7620bi.field_content;
        C8910b c8910b = null;
        if (!(ma == null || str2 == null)) {
            c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
        }
        C46291e abk = C46291e.abk(str2);
        if (!(abk == null || abk.ssY == 0)) {
            try {
                ae = C14835h.m23086ae(c46650a.yTx.getContext(), abk.ssY);
                CharSequence charSequence = "";
                if (ae != null && ae.length() > 0) {
                    String[] split = ae.split(";");
                    charSequence = charSequence + split[0].replace(" ", "");
                    if (split.length > 1) {
                        charSequence = charSequence + split[1];
                    }
                }
                if (!(c8910b == null || c8910b.description == null)) {
                    charSequence = charSequence + " " + c8910b.description;
                }
                c36213be.gnC.setText(charSequence);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", e, "", new Object[0]);
            }
        }
        C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + c7620bi.field_content);
        if (C5046bo.isNullOrNil(c7620bi.field_imgPath) && abk.ste > 0) {
            C9638aw.m17190ZK();
            C7620bi Q = C18628c.m29080XO().mo15241Q(c7620bi.field_talker, (long) abk.ste);
            if (!C5046bo.isNullOrNil(Q.field_imgPath)) {
                ae = C43667k.m78198ug(C1853r.m3846Yz());
                if (C5730e.m8644y(C22335h.m34031by(Q.field_imgPath, false), C22335h.m34031by(ae, false)) >= 0) {
                    c7620bi.mo14795jv(ae);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                }
            }
        }
        if (C5046bo.isNullOrNil(c7620bi.field_imgPath) && abk != null && abk.csD != null && abk.csD.length() > 0 && abk.fgo > 0 && this.fQS == null) {
            str2 = C43667k.m78198ug(C1853r.m3846Yz());
            String by = C22335h.m34031by(str2, false);
            if (C5046bo.isNullOrNil(c7620bi.field_imgPath)) {
                c7620bi.mo14795jv(str2);
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + c8910b.csD);
                C30065b a = C4733l.m7092a(by, c7620bi.field_msgId, c8910b.sdkVer, c8910b.appId, c8910b.csD, c8910b.fgo);
                C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + a.field_mediaSvrId);
                if (a.field_mediaSvrId != null) {
                    C6300p Rg = C9638aw.m17182Rg();
                    C1202f c238381 = new C238381();
                    this.fQS = c238381;
                    Rg.mo14539a(221, c238381);
                    C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
                    C9638aw.m17182Rg().mo14541a(new C43432e(a), 0);
                }
            }
        }
        c36213be.zjv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(33395);
                if (C5046bo.isNullOrNil(c7620bi.field_imgPath)) {
                    C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
                    AppMethodBeat.m2505o(33395);
                    return;
                }
                C36866d dFm = ((C15611aj) C23837ap.this.yJI.mo74857aF(C15611aj.class)).dFm();
                int i = i;
                C7620bi c7620bi = c7620bi;
                if (c7620bi != null) {
                    dFm.dBw();
                    C9638aw.m17190ZK();
                    Boolean bool = (Boolean) C18628c.m29072Ry().get(4115, null);
                    if (bool == null || !bool.booleanValue()) {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(4115, Boolean.TRUE);
                        dFm.dBC();
                        dFm.yGR = C23639t.m36486a(dFm.cgL.yTx.getActivity(), dFm.context.getString(C25738R.string.an2), 4000);
                    }
                    if (dFm.mfO.isPlaying() && c7620bi.field_msgId == dFm.yGO) {
                        dFm.dBB();
                        AppMethodBeat.m2505o(33395);
                        return;
                    }
                    dFm.mo58726au(c7620bi);
                    if (c7620bi.field_isSend == 0 && !C32850q.m53704K(c7620bi)) {
                        dFm.mo58723Od(i + 1);
                    }
                    dFm.mo58735qn(true);
                }
                AppMethodBeat.m2505o(33395);
            }
        });
        long j = c7620bi.field_msgId;
        C36866d dFm = ((C15611aj) this.yJI.mo74857aF(C15611aj.class)).dFm();
        if (dFm.isPlaying() && dFm.yGO == j) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            c36213be.zjv.setImageResource(C25738R.drawable.f6930vq);
        } else {
            c36213be.zjv.setImageResource(C25738R.drawable.f6932vs);
        }
        c36213be.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            c36213be.jPL.setOnLongClickListener(mo11021c(c46650a));
        }
        AppMethodBeat.m2505o(33398);
    }

    /* renamed from: a */
    public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33399);
        int i = ((C40814ay) view.getTag()).position;
        int aiL = C4733l.aiL(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
        C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
        if (me.fgo <= 0 || (me.fgo > 0 && aiL >= 100)) {
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
        }
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
        }
        AppMethodBeat.m2505o(33399);
        return true;
    }

    /* renamed from: a */
    public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33400);
        switch (menuItem.getItemId()) {
            case 111:
                Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                c46650a.startActivity(intent);
                AppMethodBeat.m2505o(33400);
                break;
            default:
                AppMethodBeat.m2505o(33400);
                break;
        }
        return false;
    }

    /* renamed from: b */
    public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
        return true;
    }
}
