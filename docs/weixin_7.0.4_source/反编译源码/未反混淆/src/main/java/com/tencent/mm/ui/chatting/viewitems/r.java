package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.List;

public final class r {

    public static class b extends c implements f, n {
        private ab hpp = new ac((f) this);
        private com.tencent.mm.ui.chatting.d.a yJI;

        public b() {
            AppMethodBeat.i(33029);
            AppMethodBeat.o(33029);
        }

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 553648177) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33030);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nb);
                d B = new d().B(view, false);
                View bS = ((e) g.K(e.class)).bS(view.getContext());
                B.zen = bS;
                B.zem.addView(bS, new LayoutParams(-1, -1));
                view.setTag(B);
            }
            AppMethodBeat.o(33030);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(33031);
            aVar = (d) aVar;
            this.yJI = aVar2;
            j jVar = (j) aVar2.aF(j.class);
            jVar.bg(biVar);
            String str2 = biVar.field_content;
            jVar.be(biVar);
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
            if (X != null) {
                CharSequence charSequence;
                aVar.zbS.setVisibility(8);
                aVar.zbR.setVisibility(8);
                aVar.zbO.setVisibility(8);
                aVar.zcq.setVisibility(8);
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(X.fiP);
                if (zb != null) {
                    charSequence = zb.field_nickname;
                } else {
                    Object charSequence2 = X.cMh;
                }
                str2 = zb != null ? zb.field_smallHeadURL : X.fjb;
                aVar.zcq.setVisibility(0);
                aVar.zcm.setVisibility(8);
                aVar.zct.setText(X.title);
                aVar.zcm.setText(X.description);
                aVar.zco.setText(charSequence2);
                switch (X.fiZ) {
                    case 1:
                        aVar.zcp.setText(R.string.o1);
                        break;
                    case 2:
                        aVar.zcp.setText(R.string.o0);
                        break;
                    default:
                        aVar.zcp.setText(R.string.i9);
                        break;
                }
                o.ahp().a(str2, aVar.zcn, d.zel);
                if (c.dHm()) {
                    h hVar = (h) aVar2.aF(h.class);
                    if (biVar.field_status == 2 && c.a(hVar, biVar.field_msgId)) {
                        if (aVar.zci != null) {
                            aVar.zci.setVisibility(0);
                        }
                    } else if (aVar.zci != null) {
                        aVar.zci.setVisibility(8);
                    }
                    if (aVar.pyf != null) {
                        aVar.pyf.setVisibility(8);
                    }
                } else if (aVar.pyf != null) {
                    aVar.pyf.setVisibility(0);
                    if (biVar.field_status >= 2) {
                        aVar.pyf.setVisibility(8);
                    }
                }
                com.tencent.mm.af.a aVar3 = (com.tencent.mm.af.a) X.X(com.tencent.mm.af.a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", X.fiQ);
                bundle.putString("msg_id", biVar.field_msgId);
                bundle.putString("cache_key", aVar3 != null ? aVar3.feZ : null);
                bundle.putString("msg_title", X.title);
                bundle.putString("msg_path", X.fiO);
                bundle.putInt("msg_pkg_type", X.fiZ);
                bundle.putInt("pkg_version", X.axy);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", aVar2.dFx() ? 1008 : 1007);
                bundle.putInt("view_init_width", d.zej);
                bundle.putInt("view_init_height", d.zek);
                aVar.zen.setTag(aVar);
                ((e) g.K(e.class)).a(com.tencent.mm.plugin.appbrand.r.n.bE(aVar2), aVar.zen, bundle, this.hpp);
            }
            aVar.jPL.setTag(ayVar);
            aVar.jPL.setOnClickListener(d(aVar2));
            com.tencent.mm.model.v.b y = v.Zp().y(com.tencent.mm.plugin.appbrand.r.n.bE(aVar2), true);
            c cVar = (c) y.get(CastExtraArgs.LISTENER, null);
            if (cVar == null) {
                cVar = new c();
                y.j(CastExtraArgs.LISTENER, cVar);
            }
            cVar.k(aVar2);
            if (this.kuU) {
                aVar.jPL.setOnLongClickListener(c(aVar2));
            }
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33031);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33032);
            int i = ((ay) view.getTag()).position;
            if (biVar.field_content == null) {
                AppMethodBeat.o(33032);
            } else {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
                if (me == null) {
                    AppMethodBeat.o(33032);
                } else {
                    if (com.tencent.mm.pluginsdk.model.app.g.i(com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, false)) && !com.tencent.mm.ui.chatting.j.aA(biVar)) {
                        contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
                    }
                    if ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker)) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                    }
                    dq dqVar = new dq();
                    dqVar.cxc.cvx = biVar.field_msgId;
                    com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                    if (dqVar.cxd.cwB || b.a(this.yJI.yTx.getContext(), me)) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                    }
                    l abz = ((e) g.K(e.class)).abz();
                    if (abz.abE() || abz.kR(me.fiZ)) {
                        contextMenu.add(i, com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX, 0, this.yJI.yTx.getMMResources().getString(R.string.amf));
                        contextMenu.add(i, 132, 0, this.yJI.yTx.getMMResources().getString(R.string.ame));
                    }
                    AppMethodBeat.o(33032);
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33033);
            com.tencent.mm.af.j.b me;
            switch (menuItem.getItemId()) {
                case 103:
                    String str = biVar.field_content;
                    if (str != null) {
                        me = com.tencent.mm.af.j.b.me(str);
                        if (me != null) {
                            switch (me.type) {
                                case 16:
                                    ii iiVar = new ii();
                                    iiVar.cDs.cDt = me.cDt;
                                    iiVar.cDs.cuQ = biVar.field_msgId;
                                    iiVar.cDs.cDu = biVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xxA.m(iiVar);
                                    break;
                            }
                        }
                        AppMethodBeat.o(33033);
                        break;
                    }
                    AppMethodBeat.o(33033);
                    break;
                case 111:
                    b.a(aVar, biVar, b(aVar, biVar));
                    AppMethodBeat.o(33033);
                    break;
                case 132:
                    ((e) g.K(e.class)).abz().bT(aVar.yTx.getContext());
                    AppMethodBeat.o(33033);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX /*133*/:
                    String str2 = biVar.field_content;
                    me = null;
                    if (str2 != null) {
                        me = com.tencent.mm.af.j.b.me(str2);
                    }
                    if (me != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", me.fiQ);
                        bundle.putString("msg_id", biVar.field_msgId);
                        bundle.putInt("pkg_type", me.fiZ);
                        bundle.putInt("pkg_version", me.fiT);
                        ((e) g.K(e.class)).abz().e(aVar.yTx.getContext(), bundle);
                        AppMethodBeat.o(33033);
                        break;
                    }
                    AppMethodBeat.o(33033);
                    break;
                default:
                    AppMethodBeat.o(33033);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33034);
            view.getTag();
            String str = biVar.field_content;
            if (str == null) {
                AppMethodBeat.o(33034);
                return false;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
            if (me == null) {
                AppMethodBeat.o(33034);
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, true);
            if (!(bT == null || bo.isNullOrNil(bT.field_appId))) {
                c.a(aVar, me, com.tencent.mm.model.r.Yz(), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            se seVar = new se();
            seVar.cOf.appId = me.fiQ;
            seVar.cOf.userName = me.fiP;
            seVar.cOf.cOh = me.fiO;
            seVar.cOf.cOi = me.fiZ;
            seVar.cOf.cOk = me.fiS;
            seVar.cOf.axy = me.fja;
            seVar.cOf.cOl = me.fiZ != 0;
            str = me.fiU;
            StringBuilder stringBuilder;
            if (aVar.dFx()) {
                seVar.cOf.scene = 1008;
                stringBuilder = new StringBuilder(aVar.getTalkerUserName());
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(b(aVar, biVar));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                seVar.cOf.cst = stringBuilder.toString();
            } else {
                seVar.cOf.scene = 1007;
                stringBuilder = new StringBuilder(b(aVar, biVar));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                seVar.cOf.cst = stringBuilder.toString();
            }
            seVar.cOf.cOn.bQh = aVar.getTalkerUserName();
            seVar.cOf.cOn.bQi = me.fiV;
            com.tencent.mm.sdk.b.a.xxA.m(seVar);
            AppMethodBeat.o(33034);
            return true;
        }

        public final void F(View view, int i) {
            AppMethodBeat.i(33035);
            Object tag = view.getTag();
            if (tag instanceof d) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
                d dVar = (d) tag;
                switch (i) {
                    case 0:
                        dVar.iNB.setVisibility(0);
                        dVar.iNB.dKS();
                        dVar.zen.setVisibility(4);
                        dVar.kuG.setVisibility(4);
                        AppMethodBeat.o(33035);
                        return;
                    case 1:
                        dVar.iNB.dKT();
                        dVar.iNB.setVisibility(4);
                        dVar.zen.setVisibility(4);
                        dVar.kuG.setVisibility(0);
                        dVar.kuG.setImageResource(R.raw.dynamic_page_res_not_found);
                        AppMethodBeat.o(33035);
                        return;
                    case 4:
                        dVar.iNB.dKT();
                        dVar.iNB.setVisibility(4);
                        dVar.zen.setVisibility(0);
                        dVar.kuG.setVisibility(4);
                        AppMethodBeat.o(33035);
                        return;
                    default:
                        dVar.iNB.dKT();
                        dVar.iNB.setVisibility(4);
                        dVar.zen.setVisibility(4);
                        dVar.kuG.setVisibility(0);
                        dVar.kuG.setImageResource(R.raw.app_brand_share_page_cover_default);
                        AppMethodBeat.o(33035);
                        return;
                }
            }
            AppMethodBeat.o(33035);
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33036);
            if (biVar.bAA()) {
                com.tencent.mm.pluginsdk.model.app.l.al(biVar);
                bf.fm(biVar.field_msgId);
                aVar.qp(true);
                AppMethodBeat.o(33036);
                return;
            }
            AppMethodBeat.o(33036);
        }
    }

    static class c implements com.tencent.mm.ui.l {
        private WeakReference<com.tencent.mm.ui.chatting.d.a> zei;

        c() {
        }

        /* Access modifiers changed, original: final */
        public final void k(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33037);
            this.zei = new WeakReference(aVar);
            ((com.tencent.mm.ui.chatting.c.b.g) aVar.aF(com.tencent.mm.ui.chatting.c.b.g.class)).a(this);
            AppMethodBeat.o(33037);
        }

        public final void dxx() {
        }

        public final void dxy() {
        }

        public final void dxz() {
        }

        public final void dxA() {
            AppMethodBeat.i(33038);
            if (this.zei == null) {
                AppMethodBeat.o(33038);
                return;
            }
            com.tencent.mm.ui.chatting.d.a aVar = (com.tencent.mm.ui.chatting.d.a) this.zei.get();
            if (aVar != null) {
                ((e) g.K(e.class)).aby().pl(com.tencent.mm.plugin.appbrand.r.n.bE(aVar));
            }
            AppMethodBeat.o(33038);
        }

        public final void dxB() {
            AppMethodBeat.i(33039);
            if (this.zei == null) {
                AppMethodBeat.o(33039);
                return;
            }
            com.tencent.mm.ui.chatting.d.a aVar = (com.tencent.mm.ui.chatting.d.a) this.zei.get();
            if (aVar != null) {
                ((e) g.K(e.class)).aby().pk(com.tencent.mm.plugin.appbrand.r.n.bE(aVar));
            }
            AppMethodBeat.o(33039);
        }

        public final void dxC() {
            AppMethodBeat.i(33040);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
            if (this.zei == null) {
                AppMethodBeat.o(33040);
                return;
            }
            com.tencent.mm.ui.chatting.d.a aVar = (com.tencent.mm.ui.chatting.d.a) this.zei.get();
            if (aVar != null) {
                v.Zp().nV(com.tencent.mm.plugin.appbrand.r.n.bE(aVar));
                ((com.tencent.mm.ui.chatting.c.b.g) aVar.aF(com.tencent.mm.ui.chatting.c.b.g.class)).b(this);
                ((e) g.K(e.class)).pm(com.tencent.mm.plugin.appbrand.r.n.bE(aVar));
            }
            AppMethodBeat.o(33040);
        }

        public final void dxD() {
        }
    }

    static class d extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public static final int zej = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 240);
        public static final int zek = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), az.CTRL_INDEX);
        static final com.tencent.mm.at.a.a.c zel;
        protected ThreeDotsLoadingView iNB;
        protected ImageView kuG;
        protected ImageView zbO;
        protected ImageView zbR;
        protected ImageView zbS;
        protected TextView zbU;
        protected ChattingItemFooter zbV;
        protected ImageView zbW;
        protected LinearLayout zbX;
        protected ViewGroup zbY;
        protected TextView zbZ;
        protected LinearLayout zca;
        ImageView zci;
        protected TextView zcm;
        protected ImageView zcn;
        protected TextView zco;
        protected TextView zcp;
        protected LinearLayout zcq;
        protected TextView zct;
        protected ViewGroup zem;
        protected View zen;

        d() {
        }

        static {
            AppMethodBeat.i(33042);
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePT = R.raw.app_brand_app_default_icon_for_tail;
            com.tencent.mm.at.a.a.c.a ct = aVar.ct(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 20), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 20));
            ct.eQf = true;
            ct.ePH = true;
            ct.ePF = true;
            zel = aVar.ahG();
            AppMethodBeat.o(33042);
        }

        public final d B(View view, boolean z) {
            AppMethodBeat.i(33041);
            super.eP(view);
            this.zbO = (ImageView) view.findViewById(R.id.aqd);
            this.zbR = (ImageView) this.mRR.findViewById(R.id.aqc);
            this.zbS = (ImageView) this.mRR.findViewById(R.id.aqb);
            this.zbU = (TextView) view.findViewById(R.id.anl);
            this.zbW = (ImageView) view.findViewById(R.id.aqe);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.zbV = (ChattingItemFooter) view.findViewById(R.id.aqa);
            this.zbX = (LinearLayout) view.findViewById(R.id.ap8);
            this.zbY = (ViewGroup) view.findViewById(R.id.ap5);
            this.zbZ = (TextView) view.findViewById(R.id.ap7);
            this.zca = (LinearLayout) view.findViewById(R.id.a9f);
            this.jPL = view.findViewById(R.id.ap9);
            if (!z) {
                this.zci = (ImageView) this.mRR.findViewById(R.id.at7);
                this.pyf = (ProgressBar) this.mRR.findViewById(R.id.at6);
            }
            this.zcq = (LinearLayout) view.findViewById(R.id.ap_);
            this.iNB = (ThreeDotsLoadingView) view.findViewById(R.id.ue);
            this.kuG = (ImageView) view.findViewById(R.id.a82);
            this.zct = (TextView) view.findViewById(R.id.apc);
            this.zcm = (TextView) view.findViewById(R.id.apd);
            this.zcn = (ImageView) view.findViewById(R.id.apa);
            this.zco = (TextView) view.findViewById(R.id.apb);
            this.zcp = (TextView) view.findViewById(R.id.aph);
            this.zem = (ViewGroup) view.findViewById(R.id.ar_);
            AppMethodBeat.o(33041);
            return this;
        }
    }

    public static class a extends c implements f {
        private ab hpp = new ac((f) this);
        private com.tencent.mm.ui.chatting.d.a yJI;

        public a() {
            AppMethodBeat.i(33022);
            AppMethodBeat.o(33022);
        }

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 553648177) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33023);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mc);
                d B = new d().B(view, true);
                View bS = ((e) g.K(e.class)).bS(view.getContext());
                B.zen = bS;
                B.zem.addView(bS, new LayoutParams(-1, -1));
                view.setTag(B);
            }
            AppMethodBeat.o(33023);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(33024);
            this.yJI = aVar2;
            d dVar = (d) aVar;
            String str2 = biVar.field_content;
            j jVar = (j) aVar2.aF(j.class);
            jVar.be(biVar);
            jVar.bf(biVar);
            jVar.bg(biVar);
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", str);
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(biVar.field_msgId), str);
                X = null;
            }
            ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
            if (X != null) {
                List list;
                CharSequence charSequence;
                dVar.zbS.setVisibility(8);
                dVar.zbR.setVisibility(8);
                dVar.zcq.setVisibility(8);
                com.tencent.mm.af.g gVar = (com.tencent.mm.af.g) X.X(com.tencent.mm.af.g.class);
                ChattingItemFooter chattingItemFooter = dVar.zbV;
                if (gVar == null) {
                    list = null;
                } else {
                    list = gVar.fgf;
                }
                if (chattingItemFooter.l(list, biVar.field_talker)) {
                    dVar.jPL.setBackgroundResource(R.drawable.i4);
                } else {
                    dVar.jPL.setBackgroundResource(R.drawable.i0);
                }
                com.tencent.mm.pluginsdk.model.app.f dX = com.tencent.mm.pluginsdk.model.app.g.dX(X.appId, X.axy);
                if (dX != null) {
                    c.b(aVar2, X, biVar);
                }
                if (X.dJv == null || X.dJv.length() == 0) {
                    dVar.zbU.setVisibility(8);
                } else {
                    dVar.zbU.setVisibility(0);
                    b(aVar2, (View) dVar.zbU, (Object) ay.arL(X.dJv));
                }
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(X.fiP);
                dVar.zbX.setVisibility(0);
                dVar.zbO.setVisibility(8);
                dVar.zca.setVisibility(0);
                dVar.zbY.setVisibility(8);
                if (zb != null) {
                    charSequence = zb.field_nickname;
                } else {
                    Object charSequence2 = X.cMh;
                }
                str2 = zb != null ? zb.field_smallHeadURL : X.fjb;
                dVar.zcq.setVisibility(0);
                dVar.zcm.setVisibility(8);
                dVar.zct.setText(X.title);
                dVar.zcm.setText(X.description);
                dVar.zco.setText(charSequence2);
                switch (X.fiZ) {
                    case 1:
                        dVar.zcp.setText(R.string.o1);
                        break;
                    case 2:
                        dVar.zcp.setText(R.string.o0);
                        break;
                    default:
                        dVar.zcp.setText(R.string.i9);
                        break;
                }
                o.ahp().a(str2, dVar.zcn, d.zel);
                if (aVar2.dFx()) {
                    dVar.zbW.setVisibility(8);
                } else if (com.tencent.mm.pluginsdk.model.app.g.h(dX)) {
                    dVar.zbW.setVisibility(0);
                    c.c(aVar2, dVar.zbW, ay.a(X, biVar));
                } else {
                    dVar.zbW.setVisibility(8);
                }
                com.tencent.mm.af.a aVar3 = (com.tencent.mm.af.a) X.X(com.tencent.mm.af.a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", X.fiQ);
                bundle.putString("msg_id", biVar.field_msgId);
                bundle.putString("cache_key", aVar3 != null ? aVar3.feZ : null);
                bundle.putString("msg_title", X.title);
                bundle.putString("msg_path", X.fiO);
                bundle.putInt("msg_pkg_type", X.fiZ);
                bundle.putInt("pkg_version", X.axy);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", aVar2.dFx() ? 1008 : 1007);
                bundle.putInt("view_init_width", d.zej);
                bundle.putInt("view_init_height", d.zek);
                dVar.zen.setTag(dVar);
                ((e) g.K(e.class)).a(com.tencent.mm.plugin.appbrand.r.n.bE(aVar2), dVar.zen, bundle, this.hpp);
            }
            dVar.jPL.setTag(ayVar);
            dVar.jPL.setOnClickListener(d(aVar2));
            com.tencent.mm.model.v.b y = v.Zp().y(com.tencent.mm.plugin.appbrand.r.n.bE(aVar2), true);
            c cVar = (c) y.get(CastExtraArgs.LISTENER, null);
            if (cVar == null) {
                cVar = new c();
                y.j(CastExtraArgs.LISTENER, cVar);
            }
            cVar.k(aVar2);
            if (this.kuU) {
                dVar.jPL.setOnLongClickListener(c(aVar2));
            }
            AppMethodBeat.o(33024);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33025);
            int i = ((ay) view.getTag()).position;
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            if (com.tencent.mm.pluginsdk.model.app.g.i(com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, false)) && !com.tencent.mm.ui.chatting.j.aA(biVar)) {
                if (me.type == 6) {
                    com.tencent.mm.pluginsdk.model.app.b aiM = com.tencent.mm.pluginsdk.model.app.l.aiM(me.csD);
                    if ((aiM == null || !b.e(biVar, aiM.field_fileFullPath)) && !biVar.dtH()) {
                        contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
                    }
                } else {
                    contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
                }
            }
            dq dqVar = new dq();
            dqVar.cxc.cvx = biVar.field_msgId;
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            if (dqVar.cxd.cwB || b.a(this.yJI.yTx.getContext(), me)) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
            }
            if (bh.o(biVar)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            l abz = ((e) g.K(e.class)).abz();
            if (abz.abE() || abz.kR(me.fiZ)) {
                contextMenu.add(i, com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX, 0, this.yJI.yTx.getMMResources().getString(R.string.amf));
                contextMenu.add(i, 132, 0, this.yJI.yTx.getMMResources().getString(R.string.ame));
            }
            AppMethodBeat.o(33025);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33026);
            switch (menuItem.getItemId()) {
                case 111:
                    b.a(aVar, biVar, b(aVar, biVar));
                    AppMethodBeat.o(33026);
                    break;
                case 132:
                    ((e) g.K(e.class)).abz().bT(aVar.yTx.getContext());
                    AppMethodBeat.o(33026);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX /*133*/:
                    String str = biVar.field_content;
                    com.tencent.mm.af.j.b bVar = null;
                    if (str != null) {
                        bVar = com.tencent.mm.af.j.b.me(str);
                    }
                    if (bVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", bVar.fiQ);
                        bundle.putString("msg_id", biVar.field_msgId);
                        bundle.putInt("pkg_type", bVar.fiZ);
                        bundle.putInt("pkg_version", bVar.fiT);
                        ((e) g.K(e.class)).abz().e(aVar.yTx.getContext(), bundle);
                        AppMethodBeat.o(33026);
                        break;
                    }
                    AppMethodBeat.o(33026);
                    break;
                default:
                    AppMethodBeat.o(33026);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33027);
            com.tencent.mm.modelstat.a.a(biVar, com.tencent.mm.modelstat.a.a.Click);
            if (biVar.field_content == null) {
                AppMethodBeat.o(33027);
                return false;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
            if (me == null) {
                AppMethodBeat.o(33027);
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, false);
            if (bT != null) {
                c.a(aVar, me, c.d(aVar, biVar), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", me.fiP, me.fiO, me.fiQ, me.url, Integer.valueOf(me.fiZ), me.fiS);
            se seVar = new se();
            seVar.cOf.appId = me.fiQ;
            seVar.cOf.userName = me.fiP;
            seVar.cOf.cOh = me.fiO;
            seVar.cOf.cOi = me.fiZ;
            seVar.cOf.cOk = me.fiS;
            seVar.cOf.axy = me.fja;
            seVar.cOf.cOl = me.fiZ != 0;
            seVar.cOf.cOn.bQh = aVar.getTalkerUserName();
            seVar.cOf.cOn.bQi = me.fiV;
            String str = me.fiU;
            StringBuilder stringBuilder;
            if (aVar.dFx()) {
                seVar.cOf.scene = 1008;
                stringBuilder = new StringBuilder(aVar.getTalkerUserName());
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(b(aVar, biVar));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                seVar.cOf.cst = stringBuilder.toString();
            } else {
                seVar.cOf.scene = 1007;
                stringBuilder = new StringBuilder(b(aVar, biVar));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                seVar.cOf.cst = stringBuilder.toString();
            }
            com.tencent.mm.sdk.b.a.xxA.m(seVar);
            AppMethodBeat.o(33027);
            return true;
        }

        public final void F(View view, int i) {
            AppMethodBeat.i(33028);
            Object tag = view.getTag();
            if (tag instanceof d) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
                d dVar = (d) tag;
                switch (i) {
                    case 0:
                        dVar.iNB.setVisibility(0);
                        dVar.iNB.dKS();
                        dVar.kuG.setVisibility(4);
                        dVar.zen.setVisibility(4);
                        AppMethodBeat.o(33028);
                        return;
                    case 1:
                        dVar.iNB.dKT();
                        dVar.iNB.setVisibility(4);
                        dVar.zen.setVisibility(4);
                        dVar.kuG.setVisibility(0);
                        dVar.kuG.setImageResource(R.raw.dynamic_page_res_not_found);
                        AppMethodBeat.o(33028);
                        return;
                    case 4:
                        dVar.iNB.dKT();
                        dVar.iNB.setVisibility(4);
                        dVar.zen.setVisibility(0);
                        dVar.kuG.setVisibility(4);
                        AppMethodBeat.o(33028);
                        return;
                    default:
                        dVar.iNB.dKT();
                        dVar.iNB.setVisibility(4);
                        dVar.zen.setVisibility(4);
                        dVar.kuG.setVisibility(0);
                        dVar.kuG.setImageResource(R.raw.app_brand_share_page_cover_default);
                        AppMethodBeat.o(33028);
                        return;
                }
            }
            AppMethodBeat.o(33028);
        }
    }
}
