package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.s.e;

public final class aq extends c {
    private f fQS;
    private com.tencent.mm.ui.chatting.d.a yJI;
    private a zhT;

    class a extends e {
        public a(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33402);
            ay ayVar = (ay) view.getTag();
            aw.ZK();
            if (c.isSDCardAvailable()) {
                ((aj) this.yJI.aF(aj.class)).dFm().a(ayVar.position, ayVar.cKd);
                AppMethodBeat.o(33402);
                return;
            }
            t.hO(this.yJI.yTx.getContext());
            AppMethodBeat.o(33402);
        }
    }

    public final boolean dHk() {
        return false;
    }

    public final boolean aH(int i, boolean z) {
        if (i == -1879048191) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(33403);
        if (view == null || view.getTag() == null) {
            view = new v(layoutInflater, R.layout.ns);
            view.setTag(new bf().fl(view));
        }
        AppMethodBeat.o(33403);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, final int i, com.tencent.mm.ui.chatting.d.a aVar2, final bi biVar, String str) {
        AppMethodBeat.i(33404);
        bf bfVar = (bf) aVar;
        this.yJI = aVar2;
        j ma = am.dhN().ma(biVar.field_msgId);
        String str2 = biVar.field_content;
        b bVar = null;
        if (!(ma == null || str2 == null)) {
            bVar = b.X(str2, biVar.field_reserved);
        }
        if (bVar != null) {
            bfVar.gnC.setText(bVar.description);
        }
        ab.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + biVar.field_content);
        com.tencent.mm.plugin.subapp.c.e abk = com.tencent.mm.plugin.subapp.c.e.abk(str2);
        if (abk != null && abk.sta != null && abk.sta.length() > 0 && abk.stb > 0 && this.fQS == null && bVar != null && bo.isNullOrNil(biVar.field_imgPath)) {
            str2 = k.ug(r.Yz());
            String by = h.by(str2, false);
            biVar.jv(str2);
            aw.ZK();
            c.XO().a(biVar.field_msgId, biVar);
            final String a = l.a(by, biVar.field_msgId, bVar.sdkVer, bVar.appId, abk.sta, abk.stb, bVar.type, bVar.fgs);
            if (a != null) {
                p Rg = aw.Rg();
                f anonymousClass1 = new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(33401);
                        ab.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + i + " errCode " + i2 + "  scene " + mVar.getType());
                        boolean z = false;
                        if (com.tencent.mm.model.ao.a.flx != null) {
                            z = com.tencent.mm.model.ao.a.flx.fl(biVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((com.tencent.mm.plugin.record.b.e) mVar).getMediaId().equals(a)) {
                            ((aj) aq.this.yJI.aF(aj.class)).dFm().a(i, biVar);
                        }
                        aw.Rg().b(221, aq.this.fQS);
                        aq.this.fQS = null;
                        AppMethodBeat.o(33401);
                    }
                };
                this.fQS = anonymousClass1;
                Rg.a(221, anonymousClass1);
                m eVar = new com.tencent.mm.plugin.record.b.e(a);
                eVar.ceC();
                aw.Rg().a(eVar, 0);
            }
        }
        bfVar.gnC.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
        TextView textView = bfVar.gnC;
        if (this.zhT == null) {
            this.zhT = new a(this.yJI);
        }
        textView.setOnClickListener(this.zhT);
        aw.ZK();
        if (c.isSDCardAvailable()) {
            bfVar.gnC.setOnLongClickListener(c(aVar2));
        }
        AppMethodBeat.o(33404);
    }

    public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33405);
        int i = ((ay) view.getTag()).position;
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
        }
        AppMethodBeat.o(33405);
        return true;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        AppMethodBeat.i(33406);
        menuItem.getItemId();
        AppMethodBeat.o(33406);
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        return true;
    }
}
