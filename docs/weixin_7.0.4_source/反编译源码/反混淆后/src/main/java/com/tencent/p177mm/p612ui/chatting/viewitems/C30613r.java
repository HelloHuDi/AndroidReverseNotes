package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C18651l;
import com.tencent.p177mm.modelappbrand.C26436f;
import com.tencent.p177mm.modelappbrand.C32805ab;
import com.tencent.p177mm.modelappbrand.C36700ac;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.modelstat.C42219a;
import com.tencent.p177mm.modelstat.C42219a.C32832a;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C45138g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26165ii;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.C30719l;
import com.tencent.p177mm.p612ui.chatting.C40788j;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7336g;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5406b;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.r */
public final class C30613r {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.r$b */
    public static class C30614b extends C5378c implements C26436f, C5365n {
        private C32805ab hpp = new C36700ac((C26436f) this);
        private C46650a yJI;

        public C30614b() {
            AppMethodBeat.m2504i(33029);
            AppMethodBeat.m2505o(33029);
        }

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 553648177) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33030);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969096);
                C30616d B = new C30616d().mo48998B(view, false);
                View bS = ((C9687e) C1720g.m3528K(C9687e.class)).mo21018bS(view.getContext());
                B.zen = bS;
                B.zem.addView(bS, new LayoutParams(-1, -1));
                view.setTag(B);
            }
            AppMethodBeat.m2505o(33030);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(33031);
            c5379a = (C30616d) c5379a;
            this.yJI = c46650a;
            C36137j c36137j = (C36137j) c46650a.mo74857aF(C36137j.class);
            c36137j.mo57030bg(c7620bi);
            String str2 = c7620bi.field_content;
            c36137j.mo57028be(c7620bi);
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
            if (X != null) {
                CharSequence charSequence;
                c5379a.zbS.setVisibility(8);
                c5379a.zbR.setVisibility(8);
                c5379a.zbO.setVisibility(8);
                c5379a.zcq.setVisibility(8);
                WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(X.fiP);
                if (zb != null) {
                    charSequence = zb.field_nickname;
                } else {
                    Object charSequence2 = X.cMh;
                }
                str2 = zb != null ? zb.field_smallHeadURL : X.fjb;
                c5379a.zcq.setVisibility(0);
                c5379a.zcm.setVisibility(8);
                c5379a.zct.setText(X.title);
                c5379a.zcm.setText(X.description);
                c5379a.zco.setText(charSequence2);
                switch (X.fiZ) {
                    case 1:
                        c5379a.zcp.setText(C25738R.string.f9057o1);
                        break;
                    case 2:
                        c5379a.zcp.setText(C25738R.string.f9056o0);
                        break;
                    default:
                        c5379a.zcp.setText(C25738R.string.f8887i9);
                        break;
                }
                C32291o.ahp().mo43766a(str2, c5379a.zcn, C30616d.zel);
                if (C5378c.dHm()) {
                    C15612h c15612h = (C15612h) c46650a.mo74857aF(C15612h.class);
                    if (c7620bi.field_status == 2 && C5378c.m8136a(c15612h, c7620bi.field_msgId)) {
                        if (c5379a.zci != null) {
                            c5379a.zci.setVisibility(0);
                        }
                    } else if (c5379a.zci != null) {
                        c5379a.zci.setVisibility(8);
                    }
                    if (c5379a.pyf != null) {
                        c5379a.pyf.setVisibility(8);
                    }
                } else if (c5379a.pyf != null) {
                    c5379a.pyf.setVisibility(0);
                    if (c7620bi.field_status >= 2) {
                        c5379a.pyf.setVisibility(8);
                    }
                }
                C41728a c41728a = (C41728a) X.mo20333X(C41728a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", X.fiQ);
                bundle.putString("msg_id", c7620bi.field_msgId);
                bundle.putString("cache_key", c41728a != null ? c41728a.feZ : null);
                bundle.putString("msg_title", X.title);
                bundle.putString("msg_path", X.fiO);
                bundle.putInt("msg_pkg_type", X.fiZ);
                bundle.putInt("pkg_version", X.axy);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", c46650a.dFx() ? 1008 : 1007);
                bundle.putInt("view_init_width", C30616d.zej);
                bundle.putInt("view_init_height", C30616d.zek);
                c5379a.zen.setTag(c5379a);
                ((C9687e) C1720g.m3528K(C9687e.class)).mo21014a(C38496n.m65148bE(c46650a), c5379a.zen, bundle, this.hpp);
            }
            c5379a.jPL.setTag(c40814ay);
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            C32800b y = C37922v.m64076Zp().mo60676y(C38496n.m65148bE(c46650a), true);
            C30615c c30615c = (C30615c) y.get(CastExtraArgs.LISTENER, null);
            if (c30615c == null) {
                c30615c = new C30615c();
                y.mo53356j(CastExtraArgs.LISTENER, c30615c);
            }
            c30615c.mo48997k(c46650a);
            if (this.kuU) {
                c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            }
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33031);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33032);
            int i = ((C40814ay) view.getTag()).position;
            if (c7620bi.field_content == null) {
                AppMethodBeat.m2505o(33032);
            } else {
                C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                if (me == null) {
                    AppMethodBeat.m2505o(33032);
                } else {
                    if (C46494g.m87750i(C46494g.m87739bT(me.appId, false)) && !C40788j.m70653aA(c7620bi)) {
                        contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
                    }
                    if ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker)) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                    }
                    C9321dq c9321dq = new C9321dq();
                    c9321dq.cxc.cvx = c7620bi.field_msgId;
                    C4879a.xxA.mo10055m(c9321dq);
                    if (c9321dq.cxd.cwB || C5406b.m8211a(this.yJI.yTx.getContext(), me)) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                    }
                    if (!this.yJI.dFy()) {
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                    }
                    C18651l abz = ((C9687e) C1720g.m3528K(C9687e.class)).abz();
                    if (abz.abE() || abz.mo33916kR(me.fiZ)) {
                        contextMenu.add(i, C19394e.CTRL_INDEX, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.amf));
                        contextMenu.add(i, 132, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.ame));
                    }
                    AppMethodBeat.m2505o(33032);
                }
            }
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33033);
            C8910b me;
            switch (menuItem.getItemId()) {
                case 103:
                    String str = c7620bi.field_content;
                    if (str != null) {
                        me = C8910b.m16064me(str);
                        if (me != null) {
                            switch (me.type) {
                                case 16:
                                    C26165ii c26165ii = new C26165ii();
                                    c26165ii.cDs.cDt = me.cDt;
                                    c26165ii.cDs.cuQ = c7620bi.field_msgId;
                                    c26165ii.cDs.cDu = c7620bi.field_talker;
                                    C4879a.xxA.mo10055m(c26165ii);
                                    break;
                            }
                        }
                        AppMethodBeat.m2505o(33033);
                        break;
                    }
                    AppMethodBeat.m2505o(33033);
                    break;
                case 111:
                    C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
                    AppMethodBeat.m2505o(33033);
                    break;
                case 132:
                    ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33913bT(c46650a.yTx.getContext());
                    AppMethodBeat.m2505o(33033);
                    break;
                case C19394e.CTRL_INDEX /*133*/:
                    String str2 = c7620bi.field_content;
                    me = null;
                    if (str2 != null) {
                        me = C8910b.m16064me(str2);
                    }
                    if (me != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", me.fiQ);
                        bundle.putString("msg_id", c7620bi.field_msgId);
                        bundle.putInt("pkg_type", me.fiZ);
                        bundle.putInt("pkg_version", me.fiT);
                        ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33915e(c46650a.yTx.getContext(), bundle);
                        AppMethodBeat.m2505o(33033);
                        break;
                    }
                    AppMethodBeat.m2505o(33033);
                    break;
                default:
                    AppMethodBeat.m2505o(33033);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33034);
            view.getTag();
            String str = c7620bi.field_content;
            if (str == null) {
                AppMethodBeat.m2505o(33034);
                return false;
            }
            C8910b me = C8910b.m16064me(str);
            if (me == null) {
                AppMethodBeat.m2505o(33034);
                return false;
            }
            C40439f bT = C46494g.m87739bT(me.appId, true);
            if (!(bT == null || C5046bo.isNullOrNil(bT.field_appId))) {
                C5378c.m8132a(c46650a, me, C1853r.m3846Yz(), bT, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
            }
            C32628se c32628se = new C32628se();
            c32628se.cOf.appId = me.fiQ;
            c32628se.cOf.userName = me.fiP;
            c32628se.cOf.cOh = me.fiO;
            c32628se.cOf.cOi = me.fiZ;
            c32628se.cOf.cOk = me.fiS;
            c32628se.cOf.axy = me.fja;
            c32628se.cOf.cOl = me.fiZ != 0;
            str = me.fiU;
            StringBuilder stringBuilder;
            if (c46650a.dFx()) {
                c32628se.cOf.scene = 1008;
                stringBuilder = new StringBuilder(c46650a.getTalkerUserName());
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(mo11017b(c46650a, c7620bi));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                c32628se.cOf.cst = stringBuilder.toString();
            } else {
                c32628se.cOf.scene = 1007;
                stringBuilder = new StringBuilder(mo11017b(c46650a, c7620bi));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                c32628se.cOf.cst = stringBuilder.toString();
            }
            c32628se.cOf.cOn.bQh = c46650a.getTalkerUserName();
            c32628se.cOf.cOn.bQi = me.fiV;
            C4879a.xxA.mo10055m(c32628se);
            AppMethodBeat.m2505o(33034);
            return true;
        }

        /* renamed from: F */
        public final void mo9596F(View view, int i) {
            AppMethodBeat.m2504i(33035);
            Object tag = view.getTag();
            if (tag instanceof C30616d) {
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
                C30616d c30616d = (C30616d) tag;
                switch (i) {
                    case 0:
                        c30616d.iNB.setVisibility(0);
                        c30616d.iNB.dKS();
                        c30616d.zen.setVisibility(4);
                        c30616d.kuG.setVisibility(4);
                        AppMethodBeat.m2505o(33035);
                        return;
                    case 1:
                        c30616d.iNB.dKT();
                        c30616d.iNB.setVisibility(4);
                        c30616d.zen.setVisibility(4);
                        c30616d.kuG.setVisibility(0);
                        c30616d.kuG.setImageResource(C1318a.dynamic_page_res_not_found);
                        AppMethodBeat.m2505o(33035);
                        return;
                    case 4:
                        c30616d.iNB.dKT();
                        c30616d.iNB.setVisibility(4);
                        c30616d.zen.setVisibility(0);
                        c30616d.kuG.setVisibility(4);
                        AppMethodBeat.m2505o(33035);
                        return;
                    default:
                        c30616d.iNB.dKT();
                        c30616d.iNB.setVisibility(4);
                        c30616d.zen.setVisibility(4);
                        c30616d.kuG.setVisibility(0);
                        c30616d.kuG.setImageResource(C1318a.app_brand_share_page_cover_default);
                        AppMethodBeat.m2505o(33035);
                        return;
                }
            }
            AppMethodBeat.m2505o(33035);
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33036);
            if (c7620bi.bAA()) {
                C4733l.m7097al(c7620bi);
                C1829bf.m3748fm(c7620bi.field_msgId);
                c46650a.mo74882qp(true);
                AppMethodBeat.m2505o(33036);
                return;
            }
            AppMethodBeat.m2505o(33036);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.r$c */
    static class C30615c implements C30719l {
        private WeakReference<C46650a> zei;

        C30615c() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: k */
        public final void mo48997k(C46650a c46650a) {
            AppMethodBeat.m2504i(33037);
            this.zei = new WeakReference(c46650a);
            ((C7336g) c46650a.mo74857aF(C7336g.class)).mo15845a(this);
            AppMethodBeat.m2505o(33037);
        }

        public final void dxx() {
        }

        public final void dxy() {
        }

        public final void dxz() {
        }

        public final void dxA() {
            AppMethodBeat.m2504i(33038);
            if (this.zei == null) {
                AppMethodBeat.m2505o(33038);
                return;
            }
            C46650a c46650a = (C46650a) this.zei.get();
            if (c46650a != null) {
                ((C9687e) C1720g.m3528K(C9687e.class)).aby().mo44200pl(C38496n.m65148bE(c46650a));
            }
            AppMethodBeat.m2505o(33038);
        }

        public final void dxB() {
            AppMethodBeat.m2504i(33039);
            if (this.zei == null) {
                AppMethodBeat.m2505o(33039);
                return;
            }
            C46650a c46650a = (C46650a) this.zei.get();
            if (c46650a != null) {
                ((C9687e) C1720g.m3528K(C9687e.class)).aby().mo44199pk(C38496n.m65148bE(c46650a));
            }
            AppMethodBeat.m2505o(33039);
        }

        public final void dxC() {
            AppMethodBeat.m2504i(33040);
            C4990ab.m7416i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
            if (this.zei == null) {
                AppMethodBeat.m2505o(33040);
                return;
            }
            C46650a c46650a = (C46650a) this.zei.get();
            if (c46650a != null) {
                C37922v.m64076Zp().mo60674nV(C38496n.m65148bE(c46650a));
                ((C7336g) c46650a.mo74857aF(C7336g.class)).mo15846b(this);
                ((C9687e) C1720g.m3528K(C9687e.class)).mo21022pm(C38496n.m65148bE(c46650a));
            }
            AppMethodBeat.m2505o(33040);
        }

        public final void dxD() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.r$d */
    static class C30616d extends C5379a {
        public static final int zej = C1338a.fromDPToPix(C4996ah.getContext(), 240);
        public static final int zek = C1338a.fromDPToPix(C4996ah.getContext(), C33250az.CTRL_INDEX);
        static final C25814c zel;
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

        C30616d() {
        }

        static {
            AppMethodBeat.m2504i(33042);
            C17927a c17927a = new C17927a();
            c17927a.ePT = C1318a.app_brand_app_default_icon_for_tail;
            C17927a ct = c17927a.mo33448ct(C1338a.fromDPToPix(C4996ah.getContext(), 20), C1338a.fromDPToPix(C4996ah.getContext(), 20));
            ct.eQf = true;
            ct.ePH = true;
            ct.ePF = true;
            zel = c17927a.ahG();
            AppMethodBeat.m2505o(33042);
        }

        /* renamed from: B */
        public final C30616d mo48998B(View view, boolean z) {
            AppMethodBeat.m2504i(33041);
            super.mo11031eP(view);
            this.zbO = (ImageView) view.findViewById(2131822557);
            this.zbR = (ImageView) this.mRR.findViewById(2131822556);
            this.zbS = (ImageView) this.mRR.findViewById(2131822555);
            this.zbU = (TextView) view.findViewById(2131822454);
            this.zbW = (ImageView) view.findViewById(2131822558);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.zbV = (ChattingItemFooter) view.findViewById(2131822554);
            this.zbX = (LinearLayout) view.findViewById(2131822514);
            this.zbY = (ViewGroup) view.findViewById(2131822511);
            this.zbZ = (TextView) view.findViewById(2131822513);
            this.zca = (LinearLayout) view.findViewById(2131821893);
            this.jPL = view.findViewById(2131822515);
            if (!z) {
                this.zci = (ImageView) this.mRR.findViewById(2131822661);
                this.pyf = (ProgressBar) this.mRR.findViewById(2131822660);
            }
            this.zcq = (LinearLayout) view.findViewById(2131822516);
            this.iNB = (ThreeDotsLoadingView) view.findViewById(2131821325);
            this.kuG = (ImageView) view.findViewById(2131821842);
            this.zct = (TextView) view.findViewById(2131822519);
            this.zcm = (TextView) view.findViewById(2131822520);
            this.zcn = (ImageView) view.findViewById(2131822517);
            this.zco = (TextView) view.findViewById(2131822518);
            this.zcp = (TextView) view.findViewById(2131822524);
            this.zem = (ViewGroup) view.findViewById(2131822590);
            AppMethodBeat.m2505o(33041);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.r$a */
    public static class C30617a extends C5378c implements C26436f {
        private C32805ab hpp = new C36700ac((C26436f) this);
        private C46650a yJI;

        public C30617a() {
            AppMethodBeat.m2504i(33022);
            AppMethodBeat.m2505o(33022);
        }

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 553648177) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33023);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969059);
                C30616d B = new C30616d().mo48998B(view, true);
                View bS = ((C9687e) C1720g.m3528K(C9687e.class)).mo21018bS(view.getContext());
                B.zen = bS;
                B.zem.addView(bS, new LayoutParams(-1, -1));
                view.setTag(B);
            }
            AppMethodBeat.m2505o(33023);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(33024);
            this.yJI = c46650a;
            C30616d c30616d = (C30616d) c5379a;
            String str2 = c7620bi.field_content;
            C36137j c36137j = (C36137j) c46650a.mo74857aF(C36137j.class);
            c36137j.mo57028be(c7620bi);
            c36137j.mo57029bf(c7620bi);
            c36137j.mo57030bg(c7620bi);
            C4990ab.m7411d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", str);
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                C4990ab.m7413e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(c7620bi.field_msgId), str);
                X = null;
            }
            C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
            if (X != null) {
                List list;
                CharSequence charSequence;
                c30616d.zbS.setVisibility(8);
                c30616d.zbR.setVisibility(8);
                c30616d.zcq.setVisibility(8);
                C45138g c45138g = (C45138g) X.mo20333X(C45138g.class);
                ChattingItemFooter chattingItemFooter = c30616d.zbV;
                if (c45138g == null) {
                    list = null;
                } else {
                    list = c45138g.fgf;
                }
                if (chattingItemFooter.mo70214l(list, c7620bi.field_talker)) {
                    c30616d.jPL.setBackgroundResource(C25738R.drawable.f6559i4);
                } else {
                    c30616d.jPL.setBackgroundResource(C25738R.drawable.f6555i0);
                }
                C40439f dX = C46494g.m87742dX(X.appId, X.axy);
                if (dX != null) {
                    C5378c.m8138b(c46650a, X, c7620bi);
                }
                if (X.dJv == null || X.dJv.length() == 0) {
                    c30616d.zbU.setVisibility(8);
                } else {
                    c30616d.zbU.setVisibility(0);
                    mo11018b(c46650a, (View) c30616d.zbU, (Object) C40814ay.arL(X.dJv));
                }
                WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(X.fiP);
                c30616d.zbX.setVisibility(0);
                c30616d.zbO.setVisibility(8);
                c30616d.zca.setVisibility(0);
                c30616d.zbY.setVisibility(8);
                if (zb != null) {
                    charSequence = zb.field_nickname;
                } else {
                    Object charSequence2 = X.cMh;
                }
                str2 = zb != null ? zb.field_smallHeadURL : X.fjb;
                c30616d.zcq.setVisibility(0);
                c30616d.zcm.setVisibility(8);
                c30616d.zct.setText(X.title);
                c30616d.zcm.setText(X.description);
                c30616d.zco.setText(charSequence2);
                switch (X.fiZ) {
                    case 1:
                        c30616d.zcp.setText(C25738R.string.f9057o1);
                        break;
                    case 2:
                        c30616d.zcp.setText(C25738R.string.f9056o0);
                        break;
                    default:
                        c30616d.zcp.setText(C25738R.string.f8887i9);
                        break;
                }
                C32291o.ahp().mo43766a(str2, c30616d.zcn, C30616d.zel);
                if (c46650a.dFx()) {
                    c30616d.zbW.setVisibility(8);
                } else if (C46494g.m87749h(dX)) {
                    c30616d.zbW.setVisibility(0);
                    C5378c.m8140c(c46650a, c30616d.zbW, C40814ay.m70729a(X, c7620bi));
                } else {
                    c30616d.zbW.setVisibility(8);
                }
                C41728a c41728a = (C41728a) X.mo20333X(C41728a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", X.fiQ);
                bundle.putString("msg_id", c7620bi.field_msgId);
                bundle.putString("cache_key", c41728a != null ? c41728a.feZ : null);
                bundle.putString("msg_title", X.title);
                bundle.putString("msg_path", X.fiO);
                bundle.putInt("msg_pkg_type", X.fiZ);
                bundle.putInt("pkg_version", X.axy);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", c46650a.dFx() ? 1008 : 1007);
                bundle.putInt("view_init_width", C30616d.zej);
                bundle.putInt("view_init_height", C30616d.zek);
                c30616d.zen.setTag(c30616d);
                ((C9687e) C1720g.m3528K(C9687e.class)).mo21014a(C38496n.m65148bE(c46650a), c30616d.zen, bundle, this.hpp);
            }
            c30616d.jPL.setTag(c40814ay);
            c30616d.jPL.setOnClickListener(mo11022d(c46650a));
            C32800b y = C37922v.m64076Zp().mo60676y(C38496n.m65148bE(c46650a), true);
            C30615c c30615c = (C30615c) y.get(CastExtraArgs.LISTENER, null);
            if (c30615c == null) {
                c30615c = new C30615c();
                y.mo53356j(CastExtraArgs.LISTENER, c30615c);
            }
            c30615c.mo48997k(c46650a);
            if (this.kuU) {
                c30616d.jPL.setOnLongClickListener(mo11021c(c46650a));
            }
            AppMethodBeat.m2505o(33024);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33025);
            int i = ((C40814ay) view.getTag()).position;
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (C46494g.m87750i(C46494g.m87739bT(me.appId, false)) && !C40788j.m70653aA(c7620bi)) {
                if (me.type == 6) {
                    C30065b aiM = C4733l.aiM(me.csD);
                    if ((aiM == null || !C5406b.m8212e(c7620bi, aiM.field_fileFullPath)) && !c7620bi.dtH()) {
                        contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
                    }
                } else {
                    contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
                }
            }
            C9321dq c9321dq = new C9321dq();
            c9321dq.cxc.cvx = c7620bi.field_msgId;
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB || C5406b.m8211a(this.yJI.yTx.getContext(), me)) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
            }
            if (C1831bh.m3770o(c7620bi)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            C18651l abz = ((C9687e) C1720g.m3528K(C9687e.class)).abz();
            if (abz.abE() || abz.mo33916kR(me.fiZ)) {
                contextMenu.add(i, C19394e.CTRL_INDEX, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.amf));
                contextMenu.add(i, 132, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.ame));
            }
            AppMethodBeat.m2505o(33025);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33026);
            switch (menuItem.getItemId()) {
                case 111:
                    C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
                    AppMethodBeat.m2505o(33026);
                    break;
                case 132:
                    ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33913bT(c46650a.yTx.getContext());
                    AppMethodBeat.m2505o(33026);
                    break;
                case C19394e.CTRL_INDEX /*133*/:
                    String str = c7620bi.field_content;
                    C8910b c8910b = null;
                    if (str != null) {
                        c8910b = C8910b.m16064me(str);
                    }
                    if (c8910b != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", c8910b.fiQ);
                        bundle.putString("msg_id", c7620bi.field_msgId);
                        bundle.putInt("pkg_type", c8910b.fiZ);
                        bundle.putInt("pkg_version", c8910b.fiT);
                        ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33915e(c46650a.yTx.getContext(), bundle);
                        AppMethodBeat.m2505o(33026);
                        break;
                    }
                    AppMethodBeat.m2505o(33026);
                    break;
                default:
                    AppMethodBeat.m2505o(33026);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33027);
            C42219a.m74510a(c7620bi, C32832a.Click);
            if (c7620bi.field_content == null) {
                AppMethodBeat.m2505o(33027);
                return false;
            }
            C8910b me = C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me == null) {
                AppMethodBeat.m2505o(33027);
                return false;
            }
            C40439f bT = C46494g.m87739bT(me.appId, false);
            if (bT != null) {
                C5378c.m8132a(c46650a, me, C5378c.m8141d(c46650a, c7620bi), bT, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
            }
            C4990ab.m7417i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", me.fiP, me.fiO, me.fiQ, me.url, Integer.valueOf(me.fiZ), me.fiS);
            C32628se c32628se = new C32628se();
            c32628se.cOf.appId = me.fiQ;
            c32628se.cOf.userName = me.fiP;
            c32628se.cOf.cOh = me.fiO;
            c32628se.cOf.cOi = me.fiZ;
            c32628se.cOf.cOk = me.fiS;
            c32628se.cOf.axy = me.fja;
            c32628se.cOf.cOl = me.fiZ != 0;
            c32628se.cOf.cOn.bQh = c46650a.getTalkerUserName();
            c32628se.cOf.cOn.bQi = me.fiV;
            String str = me.fiU;
            StringBuilder stringBuilder;
            if (c46650a.dFx()) {
                c32628se.cOf.scene = 1008;
                stringBuilder = new StringBuilder(c46650a.getTalkerUserName());
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(mo11017b(c46650a, c7620bi));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                c32628se.cOf.cst = stringBuilder.toString();
            } else {
                c32628se.cOf.scene = 1007;
                stringBuilder = new StringBuilder(mo11017b(c46650a, c7620bi));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(str);
                c32628se.cOf.cst = stringBuilder.toString();
            }
            C4879a.xxA.mo10055m(c32628se);
            AppMethodBeat.m2505o(33027);
            return true;
        }

        /* renamed from: F */
        public final void mo9596F(View view, int i) {
            AppMethodBeat.m2504i(33028);
            Object tag = view.getTag();
            if (tag instanceof C30616d) {
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
                C30616d c30616d = (C30616d) tag;
                switch (i) {
                    case 0:
                        c30616d.iNB.setVisibility(0);
                        c30616d.iNB.dKS();
                        c30616d.kuG.setVisibility(4);
                        c30616d.zen.setVisibility(4);
                        AppMethodBeat.m2505o(33028);
                        return;
                    case 1:
                        c30616d.iNB.dKT();
                        c30616d.iNB.setVisibility(4);
                        c30616d.zen.setVisibility(4);
                        c30616d.kuG.setVisibility(0);
                        c30616d.kuG.setImageResource(C1318a.dynamic_page_res_not_found);
                        AppMethodBeat.m2505o(33028);
                        return;
                    case 4:
                        c30616d.iNB.dKT();
                        c30616d.iNB.setVisibility(4);
                        c30616d.zen.setVisibility(0);
                        c30616d.kuG.setVisibility(4);
                        AppMethodBeat.m2505o(33028);
                        return;
                    default:
                        c30616d.iNB.dKT();
                        c30616d.iNB.setVisibility(4);
                        c30616d.zen.setVisibility(4);
                        c30616d.kuG.setVisibility(0);
                        c30616d.kuG.setImageResource(C1318a.app_brand_share_page_cover_default);
                        AppMethodBeat.m2505o(33028);
                        return;
                }
            }
            AppMethodBeat.m2505o(33028);
        }
    }
}
