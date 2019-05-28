package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.g;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.l;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.List;

public final class s {

    static class c implements l {
        private WeakReference<com.tencent.mm.ui.chatting.d.a> zei;

        c() {
        }

        /* Access modifiers changed, original: final */
        public final void k(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33061);
            this.zei = new WeakReference(aVar);
            ((g) aVar.aF(g.class)).a(this);
            AppMethodBeat.o(33061);
        }

        public final void dxx() {
        }

        public final void dxy() {
        }

        public final void dxz() {
        }

        public final void dxA() {
            AppMethodBeat.i(33062);
            ((k) com.tencent.mm.kernel.g.K(k.class)).abC();
            AppMethodBeat.o(33062);
        }

        public final void dxB() {
            AppMethodBeat.i(33063);
            ((k) com.tencent.mm.kernel.g.K(k.class)).abD();
            AppMethodBeat.o(33063);
        }

        public final void dxC() {
            AppMethodBeat.i(33064);
            ab.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
            if (this.zei == null) {
                AppMethodBeat.o(33064);
                return;
            }
            com.tencent.mm.ui.chatting.d.a aVar = (com.tencent.mm.ui.chatting.d.a) this.zei.get();
            if (aVar != null) {
                v.Zp().nV(e.bE(aVar));
                ((g) aVar.aF(g.class)).b(this);
                ((k) com.tencent.mm.kernel.g.K(k.class)).po(e.bE(aVar));
            }
            AppMethodBeat.o(33064);
        }

        public final void dxD() {
        }
    }

    static class d extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public static final int zej = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 240);
        public static final int zek = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), az.CTRL_INDEX);
        static com.tencent.mm.at.a.a.c zel;
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
        protected ImageView zcr;
        protected ImageView zcs;
        protected TextView zct;
        protected TextView zet;
        protected TextView zeu;

        d() {
        }

        static {
            AppMethodBeat.i(33066);
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePT = R.raw.app_brand_app_default_icon_for_tail;
            aVar.ct(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 20), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 20)).ePF = true;
            zel = aVar.ahG();
            AppMethodBeat.o(33066);
        }

        public final d C(View view, boolean z) {
            AppMethodBeat.i(33065);
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
            this.zcr = (ImageView) view.findViewById(R.id.apf);
            this.zcs = (ImageView) view.findViewById(R.id.ape);
            this.zct = (TextView) view.findViewById(R.id.apc);
            this.zcm = (TextView) view.findViewById(R.id.apd);
            this.zet = (TextView) view.findViewById(R.id.ar8);
            this.zcn = (ImageView) view.findViewById(R.id.apa);
            this.zco = (TextView) view.findViewById(R.id.apb);
            this.zcp = (TextView) view.findViewById(R.id.aph);
            this.zeu = (TextView) view.findViewById(R.id.ar9);
            AppMethodBeat.o(33065);
            return this;
        }
    }

    static class e {
        static String bE(Object obj) {
            AppMethodBeat.i(33067);
            String str = "WxaUpdatableMsg#" + n.bE(obj);
            AppMethodBeat.o(33067);
            return str;
        }
    }

    public static class b extends c implements com.tencent.mm.ui.chatting.s.n {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 587202609) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33055);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.na);
                view.setTag(new d().C(view, false));
            }
            AppMethodBeat.o(33055);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(33056);
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
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(X.fiP);
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
                str2 = o.ahl().c(biVar.field_imgPath, false, true);
                aVar.zcr.setImageBitmap(null);
                aVar.zcr.setVisibility(4);
                aVar.zcs.setVisibility(0);
                com.tencent.mm.modelappbrand.a.b.abR().a(new i() {
                    public final void abU() {
                    }

                    public final void x(Bitmap bitmap) {
                        AppMethodBeat.i(33052);
                        if (bitmap == null || bitmap.isRecycled()) {
                            aVar.zcr.setVisibility(4);
                            aVar.zcs.setVisibility(0);
                            AppMethodBeat.o(33052);
                            return;
                        }
                        aVar.zcr.setImageBitmap(bitmap);
                        aVar.zcr.setVisibility(0);
                        aVar.zcs.setVisibility(4);
                        AppMethodBeat.o(33052);
                    }

                    public final void mr() {
                    }

                    public final String wP() {
                        AppMethodBeat.i(33053);
                        String str = "CHAT#" + n.bE(this);
                        AppMethodBeat.o(33053);
                        return str;
                    }
                }, "file://".concat(String.valueOf(str2)), null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(240, az.CTRL_INDEX));
                aVar.zet.setVisibility(8);
                aVar.zet.setTag(bo.bc(X.fiV, ""));
                aVar.zeu.setVisibility(8);
                final com.tencent.mm.af.a aVar3 = (com.tencent.mm.af.a) X.X(com.tencent.mm.af.a.class);
                if (aVar3 != null && aVar3.ffb) {
                    String str3 = X.fiV;
                    com.tencent.mm.af.a.b pn = ((k) com.tencent.mm.kernel.g.K(k.class)).pn(str3);
                    s.a(aVar2, aVar, aVar3, pn);
                    s.a(aVar2, aVar, aVar3, X, pn);
                    int i2 = aVar3.ffi;
                    if (!(pn == null || pn.field_updatePeroid == 0)) {
                        i2 = pn.field_updatePeroid;
                    }
                    if (i2 > 0) {
                        ((k) com.tencent.mm.kernel.g.K(k.class)).a(e.bE(aVar2), X.fiQ, str3, i2, new com.tencent.mm.modelappbrand.k.a() {
                            public final void a(String str, cjk cjk) {
                                AppMethodBeat.i(33054);
                                ab.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", str, cjk.content);
                                if (aVar.zet == null) {
                                    ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                                    AppMethodBeat.o(33054);
                                    return;
                                }
                                String str2 = (String) aVar.zet.getTag();
                                if (bo.isNullOrNil(str2)) {
                                    ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                                    AppMethodBeat.o(33054);
                                    return;
                                }
                                if (str2.equals(str)) {
                                    aVar.zet.setVisibility(0);
                                    aVar.zet.setText(cjk.content);
                                    aVar.zet.setTextColor(bo.bS(cjk.wYm, aVar.zet.getCurrentTextColor()));
                                    if (cjk.state == 1) {
                                        com.tencent.mm.af.a.b pn = ((k) com.tencent.mm.kernel.g.K(k.class)).pn(str);
                                        if (pn != null && pn.field_btnState == 1) {
                                            if (bo.isNullOrNil(aVar3.ffh)) {
                                                aVar.zeu.setVisibility(8);
                                                AppMethodBeat.o(33054);
                                                return;
                                            }
                                            aVar.zeu.setVisibility(0);
                                            aVar.zeu.setText(aVar3.ffh);
                                        }
                                    }
                                }
                                AppMethodBeat.o(33054);
                            }
                        });
                    }
                }
            }
            aVar.jPL.setTag(ayVar);
            aVar.jPL.setOnClickListener(d(aVar2));
            com.tencent.mm.model.v.b y = v.Zp().y(e.bE(aVar2), true);
            c cVar = (c) y.get(CastExtraArgs.LISTENER, null);
            if (cVar == null) {
                cVar = new c();
                y.j(CastExtraArgs.LISTENER, cVar);
            }
            cVar.k(aVar2);
            if (this.kuU) {
                aVar.jPL.setOnLongClickListener(c(aVar2));
                aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            }
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (com.tencent.mm.ui.chatting.s.n) this);
            AppMethodBeat.o(33056);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33057);
            int i = ((ay) view.getTag()).position;
            if (biVar.field_content == null) {
                AppMethodBeat.o(33057);
            } else {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
                if (me == null) {
                    AppMethodBeat.o(33057);
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
                    AppMethodBeat.o(33057);
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33058);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = biVar.field_content;
                    if (str != null) {
                        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
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
                        AppMethodBeat.o(33058);
                        break;
                    }
                    AppMethodBeat.o(33058);
                    break;
                case 111:
                    b.a(aVar, biVar, b(aVar, biVar));
                    AppMethodBeat.o(33058);
                    break;
                default:
                    AppMethodBeat.o(33058);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33059);
            view.getTag();
            String str = biVar.field_content;
            if (str == null) {
                AppMethodBeat.o(33059);
                return false;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
            if (me == null) {
                AppMethodBeat.o(33059);
                return false;
            }
            f bT = com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, true);
            if (!(bT == null || bo.isNullOrNil(bT.field_appId))) {
                c.a(aVar, me, r.Yz(), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
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
            s.a(aVar, me);
            AppMethodBeat.o(33059);
            return true;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33060);
            if (biVar.bAA()) {
                com.tencent.mm.pluginsdk.model.app.l.al(biVar);
                bf.fm(biVar.field_msgId);
                aVar.qp(true);
                AppMethodBeat.o(33060);
                return;
            }
            AppMethodBeat.o(33060);
        }
    }

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 587202609) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33047);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mb);
                view.setTag(new d().C(view, true));
            }
            AppMethodBeat.o(33047);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(33048);
            this.yJI = aVar2;
            final d dVar = (d) aVar;
            j jVar = (j) aVar2.aF(j.class);
            jVar.be(biVar);
            jVar.bf(biVar);
            jVar.bg(biVar);
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                ab.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(biVar.field_msgId), str);
                X = null;
            }
            ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
            if (X != null) {
                List list;
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
                f dX = com.tencent.mm.pluginsdk.model.app.g.dX(X.appId, X.axy);
                if (dX != null) {
                    c.b(aVar2, X, biVar);
                }
                if (X.dJv == null || X.dJv.length() == 0) {
                    dVar.zbU.setVisibility(8);
                } else {
                    dVar.zbU.setVisibility(0);
                    b(aVar2, (View) dVar.zbU, (Object) ay.arL(X.dJv));
                }
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(X.fiP);
                dVar.zbX.setVisibility(0);
                dVar.zbO.setVisibility(8);
                dVar.zca.setVisibility(0);
                dVar.zbY.setVisibility(8);
                dVar.zco.setText(zb != null ? zb.field_nickname : X.cMh);
                str2 = zb != null ? zb.field_smallHeadURL : X.fjb;
                o.ahp().a(str2, dVar.zcn, d.zel);
                dVar.zcq.setVisibility(0);
                dVar.zcm.setVisibility(8);
                dVar.zcm.setText(X.description);
                dVar.zct.setText(X.title);
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
                str2 = o.ahl().c(biVar.field_imgPath, false, true);
                dVar.zcr.setImageBitmap(null);
                dVar.zcr.setVisibility(4);
                dVar.zcs.setVisibility(0);
                com.tencent.mm.modelappbrand.a.b.abR().a(new i() {
                    public final void abU() {
                    }

                    public final void x(Bitmap bitmap) {
                        AppMethodBeat.i(33044);
                        if (bitmap == null || bitmap.isRecycled()) {
                            dVar.zcr.setVisibility(4);
                            dVar.zcs.setVisibility(0);
                            AppMethodBeat.o(33044);
                            return;
                        }
                        dVar.zcr.setImageBitmap(bitmap);
                        dVar.zcr.setVisibility(0);
                        dVar.zcs.setVisibility(4);
                        AppMethodBeat.o(33044);
                    }

                    public final void mr() {
                    }

                    public final String wP() {
                        AppMethodBeat.i(33045);
                        String str = "CHAT#" + n.bE(this);
                        AppMethodBeat.o(33045);
                        return str;
                    }
                }, "file://".concat(String.valueOf(str2)), null, ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).cq(240, az.CTRL_INDEX));
                dVar.zet.setVisibility(8);
                dVar.zet.setTag(bo.bc(X.fiV, ""));
                dVar.zeu.setVisibility(8);
                final com.tencent.mm.af.a aVar3 = (com.tencent.mm.af.a) X.X(com.tencent.mm.af.a.class);
                if (aVar3 != null && aVar3.ffb) {
                    String str3 = X.fiV;
                    com.tencent.mm.af.a.b pn = ((k) com.tencent.mm.kernel.g.K(k.class)).pn(str3);
                    s.a(aVar2, dVar, aVar3, pn);
                    s.a(aVar2, dVar, aVar3, X, pn);
                    int i2 = aVar3.ffi;
                    if (!(pn == null || pn.field_updatePeroid == 0)) {
                        i2 = pn.field_updatePeroid;
                    }
                    if (i2 > 0) {
                        ((k) com.tencent.mm.kernel.g.K(k.class)).a(e.bE(aVar2), X.fiQ, str3, i2, new com.tencent.mm.modelappbrand.k.a() {
                            public final void a(String str, cjk cjk) {
                                AppMethodBeat.i(33046);
                                ab.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", str, cjk.content);
                                if (dVar.zet == null) {
                                    ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                                    AppMethodBeat.o(33046);
                                    return;
                                }
                                String str2 = (String) dVar.zet.getTag();
                                if (bo.isNullOrNil(str2)) {
                                    ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                                    AppMethodBeat.o(33046);
                                    return;
                                }
                                if (str2.equals(str)) {
                                    dVar.zet.setVisibility(0);
                                    dVar.zet.setText(cjk.content);
                                    dVar.zet.setTextColor(bo.bS(cjk.wYm, dVar.zet.getCurrentTextColor()));
                                    if (cjk.state == 1) {
                                        com.tencent.mm.af.a.b pn = ((k) com.tencent.mm.kernel.g.K(k.class)).pn(str);
                                        if (pn != null && pn.field_btnState == 1) {
                                            if (bo.isNullOrNil(aVar3.ffh)) {
                                                dVar.zeu.setVisibility(8);
                                                AppMethodBeat.o(33046);
                                                return;
                                            }
                                            dVar.zeu.setVisibility(0);
                                            dVar.zeu.setText(aVar3.ffh);
                                        }
                                    }
                                }
                                AppMethodBeat.o(33046);
                            }
                        });
                    }
                }
            }
            dVar.jPL.setTag(ayVar);
            dVar.jPL.setOnClickListener(d(aVar2));
            com.tencent.mm.model.v.b y = v.Zp().y(e.bE(aVar2), true);
            c cVar = (c) y.get(CastExtraArgs.LISTENER, null);
            if (cVar == null) {
                cVar = new c();
                y.j(CastExtraArgs.LISTENER, cVar);
            }
            cVar.k(aVar2);
            if (this.kuU) {
                dVar.jPL.setOnLongClickListener(c(aVar2));
                dVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            }
            AppMethodBeat.o(33048);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33049);
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
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(33049);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33050);
            switch (menuItem.getItemId()) {
                case 111:
                    b.a(aVar, biVar, b(aVar, biVar));
                    AppMethodBeat.o(33050);
                    break;
                default:
                    AppMethodBeat.o(33050);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33051);
            com.tencent.mm.modelstat.a.a(biVar, com.tencent.mm.modelstat.a.a.Click);
            if (biVar.field_content == null) {
                AppMethodBeat.o(33051);
                return false;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
            if (me == null) {
                AppMethodBeat.o(33051);
                return false;
            }
            f bT = com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, false);
            if (bT != null) {
                c.a(aVar, me, c.d(aVar, biVar), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", me.fiP, me.fiO, me.fiQ, me.url, Integer.valueOf(me.fiZ), me.fiS);
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
            s.a(aVar, me);
            AppMethodBeat.o(33051);
            return true;
        }
    }

    static /* synthetic */ void a(com.tencent.mm.ui.chatting.d.a aVar, d dVar, com.tencent.mm.af.a aVar2, com.tencent.mm.af.a.b bVar) {
        AppMethodBeat.i(33068);
        if (bVar != null && !bo.isNullOrNil(bVar.field_content)) {
            dVar.zet.setVisibility(0);
            dVar.zet.setText(bVar.field_content);
            dVar.zet.setTextColor(bo.bS(bVar.field_contentColor, aVar.yTx.getContext().getResources().getColor(R.color.w4)));
            AppMethodBeat.o(33068);
        } else if (bo.isNullOrNil(aVar2.ffc)) {
            dVar.zet.setVisibility(8);
            AppMethodBeat.o(33068);
        } else {
            dVar.zet.setVisibility(0);
            dVar.zet.setText(aVar2.ffc);
            dVar.zet.setTextColor(bo.bS(aVar2.ffd, aVar.yTx.getContext().getResources().getColor(R.color.w4)));
            AppMethodBeat.o(33068);
        }
    }

    static /* synthetic */ void a(com.tencent.mm.ui.chatting.d.a aVar, d dVar, com.tencent.mm.af.a aVar2, com.tencent.mm.af.j.b bVar, com.tencent.mm.af.a.b bVar2) {
        AppMethodBeat.i(33069);
        if (!(bVar2 == null || bVar2.field_btnState == 0)) {
            if (bVar2.field_btnState != 1) {
                if (bVar2.field_btnState == 2) {
                    dVar.zeu.setVisibility(0);
                    dVar.zeu.setText(aVar2.ffg);
                    AppMethodBeat.o(33069);
                    return;
                }
                AppMethodBeat.o(33069);
            } else if (bVar2.field_msgState != 1) {
                dVar.zeu.setVisibility(0);
                String replace = aVar2.ffe.replace("$button$", aVar2.fff);
                SpannableString spannableString = new SpannableString(replace);
                final String str = aVar2.ffg;
                final com.tencent.mm.af.j.b bVar3 = bVar;
                final d dVar2 = dVar;
                final com.tencent.mm.ui.chatting.d.a aVar3 = aVar;
                final com.tencent.mm.af.a aVar4 = aVar2;
                spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                    public final void onClickImp(View view) {
                        com.tencent.mm.g.b.a.cs.c cVar;
                        AppMethodBeat.i(33043);
                        ((k) com.tencent.mm.kernel.g.K(k.class)).T(bVar3.fiV, 2);
                        dVar2.zeu.setText(str);
                        cs hH = new cs().hE(bVar3.fiQ).hF(bVar3.fiO).hG(bVar3.fiV).hH(aVar3.getTalkerUserName());
                        if (aVar3.dFx()) {
                            cVar = com.tencent.mm.g.b.a.cs.c.YES;
                        } else {
                            cVar = com.tencent.mm.g.b.a.cs.c.NO;
                        }
                        hH.dhB = cVar;
                        hH.dhC = com.tencent.mm.g.b.a.cs.b.CLICKSUBSCRIBETV;
                        hH.cVR = 0;
                        cs Hk = hH.hI("").Hk();
                        Hk.dhE = com.tencent.mm.g.b.a.cs.d.DEFAULT;
                        Hk.dhG = com.tencent.mm.g.b.a.cs.a.hp(aVar4.ffa + 1000);
                        Hk.dhF = com.tencent.mm.g.b.a.cs.e.DEFAULT;
                        Hk.ajK();
                        AppMethodBeat.o(33043);
                    }
                }, replace.indexOf(aVar2.fff), replace.indexOf(aVar2.fff) + aVar2.fff.length(), 17);
                dVar.zeu.setMovementMethod(bc.getInstance());
                dVar.zeu.setText(spannableString);
                AppMethodBeat.o(33069);
                return;
            } else if (!bo.isNullOrNil(aVar2.ffh)) {
                dVar.zeu.setVisibility(0);
                dVar.zeu.setText(aVar2.ffh);
                AppMethodBeat.o(33069);
                return;
            }
        }
        dVar.zeu.setVisibility(8);
        AppMethodBeat.o(33069);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.chatting.d.a aVar, com.tencent.mm.af.j.b bVar) {
        com.tencent.mm.g.b.a.cs.d dVar;
        com.tencent.mm.af.a aVar2;
        int i;
        cs hH;
        com.tencent.mm.g.b.a.cs.c cVar;
        cs hI;
        cs Hk;
        AppMethodBeat.i(33070);
        com.tencent.mm.af.a.b pn = ((k) com.tencent.mm.kernel.g.K(k.class)).pn(bVar.fiV);
        com.tencent.mm.g.b.a.cs.d dVar2 = com.tencent.mm.g.b.a.cs.d.DEFAULT;
        com.tencent.mm.g.b.a.cs.e eVar = com.tencent.mm.g.b.a.cs.e.DEFAULT;
        if (pn != null) {
            if (pn.field_msgState == 1) {
                dVar2 = com.tencent.mm.g.b.a.cs.d.DONE;
            } else if (pn.field_msgState == 0) {
                dVar2 = com.tencent.mm.g.b.a.cs.d.DOING;
            }
            if (pn.field_btnState == 2) {
                eVar = com.tencent.mm.g.b.a.cs.e.SUBSCRIBE;
                dVar = dVar2;
            } else if (pn.field_btnState == 0 || pn.field_btnState == 1) {
                eVar = com.tencent.mm.g.b.a.cs.e.NOTSUBSCRIBE;
                dVar = dVar2;
            }
            aVar2 = (com.tencent.mm.af.a) bVar.X(com.tencent.mm.af.a.class);
            i = aVar2 == null ? aVar2.ffa : 0;
            hH = new cs().hE(bVar.fiQ).hF(bVar.fiO).hG(bVar.fiV).hH(aVar.getTalkerUserName());
            if (aVar.dFx()) {
                cVar = com.tencent.mm.g.b.a.cs.c.NO;
            } else {
                cVar = com.tencent.mm.g.b.a.cs.c.YES;
            }
            hH.dhB = cVar;
            hH.dhC = com.tencent.mm.g.b.a.cs.b.CLICKAPPMSG;
            hH.cVR = 0;
            hI = hH.hI("");
            hI.dhG = com.tencent.mm.g.b.a.cs.a.hp(i + 1000);
            Hk = hI.Hk();
            Hk.dhE = dVar;
            Hk.dhF = eVar;
            Hk.ajK();
            AppMethodBeat.o(33070);
        }
        dVar = dVar2;
        aVar2 = (com.tencent.mm.af.a) bVar.X(com.tencent.mm.af.a.class);
        if (aVar2 == null) {
        }
        hH = new cs().hE(bVar.fiQ).hF(bVar.fiO).hG(bVar.fiV).hH(aVar.getTalkerUserName());
        if (aVar.dFx()) {
        }
        hH.dhB = cVar;
        hH.dhC = com.tencent.mm.g.b.a.cs.b.CLICKAPPMSG;
        hH.cVR = 0;
        hI = hH.hI("");
        hI.dhG = com.tencent.mm.g.b.a.cs.a.hp(i + 1000);
        Hk = hI.Hk();
        Hk.dhE = dVar;
        Hk.dhF = eVar;
        Hk.ajK();
        AppMethodBeat.o(33070);
    }
}
