package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.u;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;
import java.util.LinkedList;

public final class ae {

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected c zga;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 48) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33250);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mi);
                view.setTag(new d().z(view, true));
            }
            AppMethodBeat.o(33250);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33251);
            this.yJI = aVar2;
            d dVar = (d) aVar;
            if (this.zga == null) {
                this.zga = new c(aVar2);
            }
            d.a(dVar, biVar, true, i, aVar2, this.zga, c(aVar2));
            AppMethodBeat.o(33251);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33252);
            if (biVar.getType() == 48) {
                int i = ((ay) view.getTag()).position;
                contextMenu.add(i, com.tencent.view.d.MIC_SketchMark, 0, view.getContext().getString(R.string.dr1));
                if (f.aeA() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                }
                if (com.tencent.mm.bp.d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                }
                dq dqVar = new dq();
                dqVar.cxc.cvx = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                if (dqVar.cxd.cwB || g.ad(this.yJI.yTx.getContext(), biVar.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                }
            }
            AppMethodBeat.o(33252);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33253);
            switch (menuItem.getItemId()) {
                case com.tencent.view.d.MIC_SketchMark /*127*/:
                    if (biVar.bAC()) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(biVar);
                        k.a(aVar.yTx.getContext(), linkedList, aVar.dFx(), aVar.sRl.field_username, null);
                    }
                    AppMethodBeat.o(33253);
                    return true;
                case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                    Intent intent = new Intent(aVar.yTx.getContext(), ChattingSendDataToDeviceUI.class);
                    intent.putExtra("exdevice_open_scene_type", 1);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.yTx.getContext().startActivity(intent);
                    AppMethodBeat.o(33253);
                    return true;
                default:
                    AppMethodBeat.o(33253);
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }
    }

    public static class b extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;
        protected c zga;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 48) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33254);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nh);
                view.setTag(new d().z(view, false));
            }
            AppMethodBeat.o(33254);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33255);
            this.yJI = aVar2;
            d dVar = (d) aVar;
            if (this.zga == null) {
                this.zga = new c(aVar2);
            }
            d.a(dVar, biVar, false, i, aVar2, this.zga, c(aVar2));
            aVar = (d) aVar;
            if (c.dHm()) {
                if (biVar.field_status == 2 && c.a((h) aVar2.aF(h.class), biVar.field_msgId)) {
                    if (aVar.zci != null) {
                        aVar.zci.setVisibility(0);
                    }
                } else if (aVar.zci != null) {
                    aVar.zci.setVisibility(8);
                }
            }
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33255);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33256);
            if (biVar.getType() == 48) {
                int i = ((ay) view.getTag()).position;
                if (biVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                }
                contextMenu.add(i, com.tencent.view.d.MIC_SketchMark, 0, view.getContext().getString(R.string.dr1));
                if (f.aeA() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                }
                if (com.tencent.mm.bp.d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                }
                dq dqVar = new dq();
                dqVar.cxc.cvx = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                if (dqVar.cxd.cwB || g.ad(this.yJI.yTx.getContext(), biVar.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                }
                if (!biVar.drC() && biVar.bAC() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                }
            }
            AppMethodBeat.o(33256);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33257);
            switch (menuItem.getItemId()) {
                case com.tencent.view.d.MIC_SketchMark /*127*/:
                    if (biVar.bAC()) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(biVar);
                        k.a(aVar.yTx.getContext(), linkedList, aVar.dFx(), aVar.sRl.field_username, null);
                    }
                    AppMethodBeat.o(33257);
                    return true;
                default:
                    AppMethodBeat.o(33257);
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33258);
            biVar.dtJ();
            aw.ZK();
            com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
            ((u) aVar.aF(u.class)).bb(biVar);
            AppMethodBeat.o(33258);
        }
    }

    public static class c extends e {
        public c(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            String trim;
            com.tencent.mm.storage.bi.b Ro;
            jj jjVar;
            String str;
            Intent intent;
            AppMethodBeat.i(33260);
            bi biVar2 = ((ay) view.getTag()).cKd;
            String str2 = biVar2.field_content;
            int i = biVar2.field_isSend == 0 ? 1 : 0;
            String str3 = "";
            if (i != 0) {
                str3 = biVar2.field_talker;
            }
            if (!(!t.kH(biVar2.field_talker) || i == 0 || ((com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm())) {
                i = bf.ox(str2);
                if (i != -1) {
                    str3 = str2.substring(0, i).trim();
                    trim = str2.substring(i + 1).trim();
                    aw.ZK();
                    Ro = com.tencent.mm.model.c.XO().Ro(trim);
                    if (ah.isNullOrNil(str3) && t.kH(str3)) {
                        trim = "";
                    } else {
                        trim = str3;
                    }
                    jjVar = new jj();
                    jjVar.cEF.cEA = 1;
                    jjVar.cEF.csG = biVar2;
                    com.tencent.mm.sdk.b.a.xxA.m(jjVar);
                    str = jjVar.cEG.cBp;
                    if (ah.isNullOrNil(Ro.eUu) || Ro.dub()) {
                        intent = new Intent();
                        intent.putExtra("kMsgId", biVar2.field_msgId);
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", Ro.nJu);
                        intent.putExtra("kwebmap_lng", Ro.nJv);
                        intent.putExtra("kwebmap_scale", Ro.cED);
                        intent.putExtra("kPoiName", Ro.eUu);
                        intent.putExtra("kisUsername", s.mJ(trim));
                        intent.putExtra("Kwebmap_locaion", str);
                        aw.ZK();
                        intent.putExtra("kimg_path", com.tencent.mm.model.c.XW());
                        intent.putExtra("map_talker_name", biVar2.field_talker);
                        intent.putExtra("view_type_key", 0);
                        intent.putExtra("kwebmap_from_to", true);
                        intent.putExtra("kPoi_url", Ro.vaO);
                        intent.putExtra("kPoiid", Ro.nJB);
                        intent.putExtra("soso_street_view_url", ah.bc(biVar2.field_reserved, ""));
                        com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(2), "");
                        com.tencent.mm.bp.d.a(this.yJI.yTv, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 2002, new com.tencent.mm.bp.d.a() {
                            public final void onActivityResult(int i, int i2, Intent intent) {
                                AppMethodBeat.i(33259);
                                switch (i) {
                                    case 2002:
                                        if (intent != null) {
                                            if (intent.getBooleanExtra("kfavorite", false)) {
                                                cl clVar = new cl();
                                                com.tencent.mm.pluginsdk.model.e.a(clVar, intent);
                                                clVar.cvA.fragment = c.this.yJI.yTx;
                                                clVar.cvA.cvH = 42;
                                                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                                break;
                                            }
                                        }
                                        ab.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", Integer.valueOf(i), Integer.valueOf(i2));
                                        AppMethodBeat.o(33259);
                                        return;
                                        break;
                                }
                                AppMethodBeat.o(33259);
                            }
                        });
                        AppMethodBeat.o(33260);
                    }
                    ab.w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", Ro.eUu, Boolean.valueOf(Ro.dub()));
                    AppMethodBeat.o(33260);
                    return;
                }
            }
            trim = str2;
            aw.ZK();
            Ro = com.tencent.mm.model.c.XO().Ro(trim);
            if (ah.isNullOrNil(str3)) {
            }
            trim = str3;
            jjVar = new jj();
            jjVar.cEF.cEA = 1;
            jjVar.cEF.csG = biVar2;
            com.tencent.mm.sdk.b.a.xxA.m(jjVar);
            str = jjVar.cEG.cBp;
            if (ah.isNullOrNil(Ro.eUu)) {
            }
            intent = new Intent();
            intent.putExtra("kMsgId", biVar2.field_msgId);
            intent.putExtra("map_view_type", 1);
            intent.putExtra("kwebmap_slat", Ro.nJu);
            intent.putExtra("kwebmap_lng", Ro.nJv);
            intent.putExtra("kwebmap_scale", Ro.cED);
            intent.putExtra("kPoiName", Ro.eUu);
            intent.putExtra("kisUsername", s.mJ(trim));
            intent.putExtra("Kwebmap_locaion", str);
            aw.ZK();
            intent.putExtra("kimg_path", com.tencent.mm.model.c.XW());
            intent.putExtra("map_talker_name", biVar2.field_talker);
            intent.putExtra("view_type_key", 0);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kPoi_url", Ro.vaO);
            intent.putExtra("kPoiid", Ro.nJB);
            intent.putExtra("soso_street_view_url", ah.bc(biVar2.field_reserved, ""));
            com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(2), "");
            com.tencent.mm.bp.d.a(this.yJI.yTv, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 2002, /* anonymous class already generated */);
            AppMethodBeat.o(33260);
        }
    }

    static class d extends com.tencent.mm.ui.chatting.viewitems.c.a {
        ImageView zci;
        TextView zfC;
        LinearLayout zgc;
        TextView zgd;
        ProgressBar zge;
        ImageView zgf;
        ProgressBar zgg;
        ImageView zgh;

        d() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            AppMethodBeat.i(33261);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zfC = (TextView) view.findViewById(R.id.art);
            this.zgd = (TextView) view.findViewById(R.id.ars);
            this.zgc = (LinearLayout) view.findViewById(R.id.arr);
            this.zge = (ProgressBar) view.findViewById(R.id.afz);
            this.jPL = view.findViewById(R.id.ap9);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.zgf = (ImageView) view.findViewById(R.id.arv);
            this.zgg = (ProgressBar) view.findViewById(R.id.aru);
            this.zgh = (ImageView) view.findViewById(R.id.arw);
            if (!z) {
                this.zby = (ImageView) view.findViewById(R.id.asb);
                this.zci = (ImageView) view.findViewById(R.id.at7);
            }
            this.zgd.setTextSize(1, 16.0f);
            this.zfC.setTextSize(1, 12.0f);
            AppMethodBeat.o(33261);
            return this;
        }

        public static void a(d dVar, bi biVar, boolean z, int i, com.tencent.mm.ui.chatting.d.a aVar, c cVar, OnLongClickListener onLongClickListener) {
            AppMethodBeat.i(33262);
            if (dVar == null) {
                AppMethodBeat.o(33262);
                return;
            }
            dVar.zgc.setVisibility(8);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), 236);
            int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), 90);
            dVar.zgd.setMaxLines(1);
            dVar.zfC.setMaxLines(1);
            dVar.zfC.setText("");
            if (com.tencent.mm.bp.d.afj(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION)) {
                ab.d("MicroMsg.LocationItemHolder", "plugin found!");
                jj jjVar = new jj();
                jjVar.cEF.cEA = 1;
                jjVar.cEF.csG = biVar;
                com.tencent.mm.sdk.b.a.xxA.m(jjVar);
                String str = jjVar.cEG.cBp;
                String str2 = jjVar.cEG.cEI;
                if ((str != null || b(str2, aVar)) && ((str == null || !str.equals("") || b(str2, aVar)) && (str == null || !str.equals("err_not_started")))) {
                    dVar.zgg.setVisibility(8);
                    dVar.zgc.setVisibility(0);
                    ab.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(str)));
                    if (b(str2, aVar)) {
                        dVar.zgd.setVisibility(0);
                        dVar.zgd.setText(str2);
                        if (str == null || str.equals("")) {
                            dVar.zfC.setVisibility(8);
                        } else {
                            dVar.zfC.setVisibility(0);
                            dVar.zfC.setText(str);
                        }
                    } else {
                        dVar.zgd.setMaxLines(2);
                        dVar.zgd.setText(String.valueOf(str));
                        dVar.zfC.setVisibility(8);
                    }
                } else {
                    ab.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
                    dVar.zgg.setVisibility(8);
                    dVar.zgc.setVisibility(0);
                    dVar.zgd.setText(R.string.cn7);
                    dVar.zfC.setText("");
                }
            } else {
                dVar.zge.setVisibility(0);
                dVar.zgc.setVisibility(8);
            }
            dVar.zgf.setImageBitmap(o.ahl().g(fromDPToPix, fromDPToPix2, z));
            ie ieVar = new ie();
            ieVar.cDf.csG = biVar;
            ieVar.cDf.w = fromDPToPix;
            ieVar.cDf.h = fromDPToPix2;
            ieVar.cDf.cDk = R.drawable.bbi;
            ieVar.cDf.cDh = dVar.zgf;
            ieVar.cDf.cDj = dVar.zge;
            ieVar.cDf.cDi = dVar.zgh;
            com.tencent.mm.sdk.b.a.xxA.m(ieVar);
            dVar.jPL.setTag(new ay(biVar, aVar.dFx(), i, null, 0));
            dVar.jPL.setOnClickListener(cVar);
            dVar.jPL.setOnLongClickListener(onLongClickListener);
            dVar.jPL.setOnTouchListener(((h) aVar.aF(h.class)).dCZ());
            AppMethodBeat.o(33262);
        }

        private static boolean b(String str, com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33263);
            if (str == null || str.equals("") || str.equals(aVar.yTx.getMMResources().getString(R.string.cnn))) {
                AppMethodBeat.o(33263);
                return false;
            }
            AppMethodBeat.o(33263);
            return true;
        }
    }
}
