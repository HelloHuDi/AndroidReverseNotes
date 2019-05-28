package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.o;

public final class ar {

    public static class d extends a {
        public final /* bridge */ /* synthetic */ String b(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33414);
            String b = super.b(aVar, biVar);
            AppMethodBeat.o(33414);
            return b;
        }

        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.i(33413);
            boolean dHk = super.dHk();
            AppMethodBeat.o(33413);
            return dHk;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 53) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33411);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mp);
                view.setTag(new i().fe(view));
            }
            AppMethodBeat.o(33411);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33412);
            i.a((i) aVar, biVar, true, i, aVar2, l(aVar2), c(aVar2));
            AppMethodBeat.o(33412);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class e extends b {
        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.i(33417);
            boolean dHk = super.dHk();
            AppMethodBeat.o(33417);
            return dHk;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 53) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33415);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nn);
                view.setTag(new i().fe(view));
            }
            AppMethodBeat.o(33415);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33416);
            i.a((i) aVar, biVar, false, i, aVar2, l(aVar2), c(aVar2));
            AppMethodBeat.o(33416);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    static abstract class b extends c {
        protected h zhX;

        b() {
        }

        /* Access modifiers changed, original: protected|final */
        public final h l(com.tencent.mm.ui.chatting.d.a aVar) {
            if (this.zhX == null) {
                this.zhX = new h(aVar);
            }
            return this.zhX;
        }

        public boolean dHk() {
            return true;
        }
    }

    static abstract class a extends c {
        protected h zhX;

        a() {
        }

        /* Access modifiers changed, original: protected|final */
        public final h l(com.tencent.mm.ui.chatting.d.a aVar) {
            if (this.zhX == null) {
                this.zhX = new h(aVar);
            }
            return this.zhX;
        }

        public String b(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return aVar.getTalkerUserName();
        }

        public boolean dHk() {
            return false;
        }
    }

    public static class c extends a {
        public final /* bridge */ /* synthetic */ String b(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33410);
            String b = super.b(aVar, biVar);
            AppMethodBeat.o(33410);
            return b;
        }

        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.i(33409);
            boolean dHk = super.dHk();
            AppMethodBeat.o(33409);
            return dHk;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 50) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33407);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mo);
                view.setTag(new i().fe(view));
            }
            AppMethodBeat.o(33407);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33408);
            i.a((i) aVar, biVar, true, i, aVar2, l(aVar2), c(aVar2));
            AppMethodBeat.o(33408);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class f extends c {
        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (i == 52) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33418);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(R.layout.nt, null);
                view.setTag(new i().fe(view));
            }
            AppMethodBeat.o(33418);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33419);
            aVar.enf.setVisibility(0);
            aVar.enf.setText(com.tencent.mm.pluginsdk.f.h.p(aVar2.yTx.getContext(), biVar.field_createTime));
            AppMethodBeat.o(33419);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }
    }

    public static class g extends b {
        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.i(33422);
            boolean dHk = super.dHk();
            AppMethodBeat.o(33422);
            return dHk;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 50) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33420);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nm);
                view.setTag(new i().fe(view));
            }
            AppMethodBeat.o(33420);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33421);
            i.a((i) aVar, biVar, false, i, aVar2, l(aVar2), c(aVar2));
            AppMethodBeat.o(33421);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }
    }

    static final class i extends com.tencent.mm.ui.chatting.viewitems.c.a {
        TextView zfC;
        View zia = null;

        i() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a fe(View view) {
            AppMethodBeat.i(33428);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zfC = (TextView) view.findViewById(R.id.asd);
            this.jPL = view.findViewById(R.id.ap9);
            this.zia = view.findViewById(R.id.asc);
            this.zby = (ImageView) view.findViewById(R.id.asb);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            AppMethodBeat.o(33428);
            return this;
        }

        public static void a(i iVar, bi biVar, boolean z, int i, com.tencent.mm.ui.chatting.d.a aVar, h hVar, OnLongClickListener onLongClickListener) {
            AppMethodBeat.i(33429);
            if (iVar == null) {
                AppMethodBeat.o(33429);
                return;
            }
            if (iVar.zby != null) {
                iVar.zby.setVisibility(biVar.field_status == 6 ? 8 : 0);
            }
            iVar.jPL.setTag(new ay(biVar, aVar.dFx(), i, null, 0));
            iVar.jPL.setOnClickListener(hVar);
            iVar.jPL.setOnLongClickListener(onLongClickListener);
            iVar.jPL.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
            String str = biVar.dqJ;
            if (!bo.isNullOrNil(str)) {
                iVar.zfC.setText(str);
            } else if (z) {
                iVar.zfC.setText(R.string.f41);
            } else {
                iVar.zfC.setText(R.string.f42);
            }
            if (iVar.zia == null) {
                AppMethodBeat.o(33429);
            } else if (biVar.field_content.equals(bi.xZb) || kE(biVar.field_content)) {
                iVar.zia.setBackgroundResource(R.raw.voip_voicecall);
                AppMethodBeat.o(33429);
            } else {
                if (biVar.field_content.equals(bi.xZc) || kD(biVar.field_content)) {
                    if (z) {
                        iVar.zia.setBackgroundResource(R.raw.voip_videocall);
                        AppMethodBeat.o(33429);
                        return;
                    }
                    iVar.zia.setBackgroundResource(R.raw.voip_videocall_to);
                }
                AppMethodBeat.o(33429);
            }
        }

        private static boolean kE(String str) {
            AppMethodBeat.i(33430);
            ui uiVar = new ui();
            uiVar.cQx.cAd = 1;
            uiVar.cQx.content = str;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            if (uiVar.cQy.type == 3) {
                AppMethodBeat.o(33430);
                return true;
            }
            AppMethodBeat.o(33430);
            return false;
        }

        private static boolean kD(String str) {
            AppMethodBeat.i(33431);
            ui uiVar = new ui();
            uiVar.cQx.cAd = 1;
            uiVar.cQx.content = str;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            if (uiVar.cQy.type == 2) {
                AppMethodBeat.o(33431);
                return true;
            }
            AppMethodBeat.o(33431);
            return false;
        }
    }

    public static class h extends com.tencent.mm.ui.chatting.s.e {
        static /* synthetic */ void a(h hVar, ay ayVar) {
            AppMethodBeat.i(33427);
            hVar.a(ayVar);
            AppMethodBeat.o(33427);
        }

        public h(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            int i;
            AppMethodBeat.i(33425);
            final ay ayVar = (ay) view.getTag();
            String str = biVar.field_content;
            ui uiVar = new ui();
            uiVar.cQx.cAd = 1;
            uiVar.cQx.content = str;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            if (uiVar.cQy.type == 2) {
                i = 1;
            } else {
                i = 0;
            }
            uh uhVar;
            if (i != 0 || biVar.field_content.equals(bi.xZc)) {
                if (!com.tencent.mm.r.a.bH(this.yJI.yTx.getContext())) {
                    uhVar = new uh();
                    com.tencent.mm.sdk.b.a.xxA.m(uhVar);
                    if (ayVar.cKd.field_talker.equals(uhVar.cQt.talker) || !(uhVar.cQt.cQv || uhVar.cQt.cQw)) {
                        sz szVar = new sz();
                        szVar.cPf.cPh = true;
                        com.tencent.mm.sdk.b.a.xxA.m(szVar);
                        str = szVar.cPg.cPj;
                        if (ah.isNullOrNil(str)) {
                            a(ayVar);
                        } else {
                            ab.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(str)));
                            com.tencent.mm.ui.base.h.d(this.yJI.yTx.getContext(), this.yJI.yTx.getContext().getString(R.string.euf), "", this.yJI.yTx.getContext().getString(R.string.s6), this.yJI.yTx.getContext().getString(R.string.or), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(33423);
                                    sz szVar = new sz();
                                    szVar.cPf.cPi = true;
                                    com.tencent.mm.sdk.b.a.xxA.m(szVar);
                                    h.a(h.this, ayVar);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(33423);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(33424);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(33424);
                                }
                            });
                            AppMethodBeat.o(33425);
                            return;
                        }
                    }
                    Toast.makeText(this.yJI.yTx.getContext(), uhVar.cQt.cQu ? R.string.ac6 : R.string.ac7, 0).show();
                    ab.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
                    AppMethodBeat.o(33425);
                    return;
                }
                AppMethodBeat.o(33425);
                return;
            }
            str = biVar.field_content;
            uiVar = new ui();
            uiVar.cQx.cAd = 1;
            uiVar.cQx.content = str;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            if (uiVar.cQy.type == 3) {
                i = 1;
            } else {
                i = 0;
            }
            if ((i != 0 || biVar.field_content.equals(bi.xZb)) && !com.tencent.mm.r.a.bH(this.yJI.yTx.getContext())) {
                uhVar = new uh();
                com.tencent.mm.sdk.b.a.xxA.m(uhVar);
                if (ayVar.cKd.field_talker.equals(uhVar.cQt.talker) || !(uhVar.cQt.cQv || uhVar.cQt.cQw)) {
                    ayVar.cKd.setStatus(6);
                    aw.ZK();
                    com.tencent.mm.model.c.XO().a(ayVar.cKd.field_msgId, ayVar.cKd);
                    ((o) this.yJI.aF(o.class)).dEb();
                    ui uiVar2 = new ui();
                    uiVar2.cQx.cAd = 5;
                    uiVar2.cQx.talker = ayVar.cKd.field_talker;
                    uiVar2.cQx.context = this.yJI.yTx.getContext();
                    uiVar2.cQx.cQs = 4;
                    com.tencent.mm.sdk.b.a.xxA.m(uiVar2);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Integer.valueOf(2);
                    if (ayVar.cKd.dqJ == null || ayVar.cKd.dqJ.length() <= 0) {
                        i = 1;
                    } else {
                        i = 3;
                    }
                    objArr[2] = Integer.valueOf(i);
                    hVar.e(11033, objArr);
                } else {
                    Toast.makeText(this.yJI.yTx.getContext(), uhVar.cQt.cQu ? R.string.ac6 : R.string.ac7, 0).show();
                    ab.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
                    AppMethodBeat.o(33425);
                    return;
                }
            }
            AppMethodBeat.o(33425);
        }

        private void a(ay ayVar) {
            int i;
            AppMethodBeat.i(33426);
            ayVar.cKd.setStatus(6);
            aw.ZK();
            com.tencent.mm.model.c.XO().a(ayVar.cKd.field_msgId, ayVar.cKd);
            ((o) this.yJI.aF(o.class)).dEb();
            ui uiVar = new ui();
            uiVar.cQx.cAd = 5;
            uiVar.cQx.talker = ayVar.cKd.field_talker;
            uiVar.cQx.context = this.yJI.yTx.getContext();
            uiVar.cQx.cQs = 2;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(3);
            objArr[1] = Integer.valueOf(1);
            if (ayVar.cKd.dqJ == null || ayVar.cKd.dqJ.length() <= 0) {
                i = 1;
            } else {
                i = 3;
            }
            objArr[2] = Integer.valueOf(i);
            hVar.e(11033, objArr);
            AppMethodBeat.o(33426);
        }
    }
}
