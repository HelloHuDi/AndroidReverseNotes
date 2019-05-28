package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.subapp.c.e;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ap extends c {
    private f fQS;
    private a yJI;

    public final boolean dHk() {
        return false;
    }

    public final boolean aH(int i, boolean z) {
        if (i == -1879048190) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33396);
        if (view == null || view.getTag() == null) {
            view = new v(layoutInflater, R.layout.nr);
            view.setTag(new be().fk(view));
        }
        AppMethodBeat.o(33396);
        return view;
    }

    public final String b(a aVar, bi biVar) {
        AppMethodBeat.i(33397);
        String talkerUserName = aVar.getTalkerUserName();
        AppMethodBeat.o(33397);
        return talkerUserName;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean b(a aVar) {
        return false;
    }

    public final void a(c.a aVar, final int i, a aVar2, final bi biVar, String str) {
        String ae;
        Object obj;
        AppMethodBeat.i(33398);
        be beVar = (be) aVar;
        this.yJI = aVar2;
        j ma = am.dhN().ma(biVar.field_msgId);
        String str2 = biVar.field_content;
        b bVar = null;
        if (!(ma == null || str2 == null)) {
            bVar = b.X(str2, biVar.field_reserved);
        }
        e abk = e.abk(str2);
        if (!(abk == null || abk.ssY == 0)) {
            try {
                ae = h.ae(aVar2.yTx.getContext(), abk.ssY);
                CharSequence charSequence = "";
                if (ae != null && ae.length() > 0) {
                    String[] split = ae.split(";");
                    charSequence = charSequence + split[0].replace(" ", "");
                    if (split.length > 1) {
                        charSequence = charSequence + split[1];
                    }
                }
                if (!(bVar == null || bVar.description == null)) {
                    charSequence = charSequence + " " + bVar.description;
                }
                beVar.gnC.setText(charSequence);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", e, "", new Object[0]);
            }
        }
        ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + biVar.field_content);
        if (bo.isNullOrNil(biVar.field_imgPath) && abk.ste > 0) {
            aw.ZK();
            bi Q = c.XO().Q(biVar.field_talker, (long) abk.ste);
            if (!bo.isNullOrNil(Q.field_imgPath)) {
                ae = k.ug(r.Yz());
                if (com.tencent.mm.vfs.e.y(com.tencent.mm.plugin.subapp.c.h.by(Q.field_imgPath, false), com.tencent.mm.plugin.subapp.c.h.by(ae, false)) >= 0) {
                    biVar.jv(ae);
                    aw.ZK();
                    c.XO().a(biVar.field_msgId, biVar);
                }
            }
        }
        if (bo.isNullOrNil(biVar.field_imgPath) && abk != null && abk.csD != null && abk.csD.length() > 0 && abk.fgo > 0 && this.fQS == null) {
            str2 = k.ug(r.Yz());
            String by = com.tencent.mm.plugin.subapp.c.h.by(str2, false);
            if (bo.isNullOrNil(biVar.field_imgPath)) {
                biVar.jv(str2);
                aw.ZK();
                c.XO().a(biVar.field_msgId, biVar);
                ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + bVar.csD);
                com.tencent.mm.pluginsdk.model.app.b a = l.a(by, biVar.field_msgId, bVar.sdkVer, bVar.appId, bVar.csD, bVar.fgo);
                ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + a.field_mediaSvrId);
                if (a.field_mediaSvrId != null) {
                    p Rg = aw.Rg();
                    f anonymousClass1 = new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(33394);
                            ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + i + " errCode " + i2 + "  scene " + mVar.getType());
                            aw.Rg().b(221, ap.this.fQS);
                            ap.this.fQS = null;
                            AppMethodBeat.o(33394);
                        }
                    };
                    this.fQS = anonymousClass1;
                    Rg.a(221, anonymousClass1);
                    ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
                    aw.Rg().a(new com.tencent.mm.plugin.record.b.e(a), 0);
                }
            }
        }
        beVar.zjv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33395);
                if (bo.isNullOrNil(biVar.field_imgPath)) {
                    ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
                    AppMethodBeat.o(33395);
                    return;
                }
                d dFm = ((aj) ap.this.yJI.aF(aj.class)).dFm();
                int i = i;
                bi biVar = biVar;
                if (biVar != null) {
                    dFm.dBw();
                    aw.ZK();
                    Boolean bool = (Boolean) c.Ry().get(4115, null);
                    if (bool == null || !bool.booleanValue()) {
                        aw.ZK();
                        c.Ry().set(4115, Boolean.TRUE);
                        dFm.dBC();
                        dFm.yGR = t.a(dFm.cgL.yTx.getActivity(), dFm.context.getString(R.string.an2), 4000);
                    }
                    if (dFm.mfO.isPlaying() && biVar.field_msgId == dFm.yGO) {
                        dFm.dBB();
                        AppMethodBeat.o(33395);
                        return;
                    }
                    dFm.au(biVar);
                    if (biVar.field_isSend == 0 && !q.K(biVar)) {
                        dFm.Od(i + 1);
                    }
                    dFm.qn(true);
                }
                AppMethodBeat.o(33395);
            }
        });
        long j = biVar.field_msgId;
        d dFm = ((aj) this.yJI.aF(aj.class)).dFm();
        if (dFm.isPlaying() && dFm.yGO == j) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            beVar.zjv.setImageResource(R.drawable.vq);
        } else {
            beVar.zjv.setImageResource(R.drawable.vs);
        }
        beVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
        aw.ZK();
        if (c.isSDCardAvailable()) {
            beVar.jPL.setOnLongClickListener(c(aVar2));
        }
        AppMethodBeat.o(33398);
    }

    public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33399);
        int i = ((ay) view.getTag()).position;
        int aiL = l.aiL(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
        b me = b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
        if (me.fgo <= 0 || (me.fgo > 0 && aiL >= 100)) {
            contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
        }
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
        }
        AppMethodBeat.o(33399);
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bi biVar) {
        AppMethodBeat.i(33400);
        switch (menuItem.getItemId()) {
            case 111:
                Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                aVar.startActivity(intent);
                AppMethodBeat.o(33400);
                break;
            default:
                AppMethodBeat.o(33400);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bi biVar) {
        return true;
    }
}
