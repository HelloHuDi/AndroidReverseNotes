package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.C45446k;
import com.tencent.p177mm.modelappbrand.C45446k.C26437a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.modelstat.C42219a;
import com.tencent.p177mm.modelstat.C42219a.C32832a;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C45138g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p181af.p1175a.C17871b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26165ii;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18452c;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18453d;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18454e;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C26289b;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C26290a;
import com.tencent.p177mm.p612ui.C30719l;
import com.tencent.p177mm.p612ui.chatting.C40788j;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7336g;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5406b;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.protocal.protobuf.cjk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.s */
public final class C23859s {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.s$c */
    static class C23856c implements C30719l {
        private WeakReference<C46650a> zei;

        C23856c() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: k */
        public final void mo39644k(C46650a c46650a) {
            AppMethodBeat.m2504i(33061);
            this.zei = new WeakReference(c46650a);
            ((C7336g) c46650a.mo74857aF(C7336g.class)).mo15845a(this);
            AppMethodBeat.m2505o(33061);
        }

        public final void dxx() {
        }

        public final void dxy() {
        }

        public final void dxz() {
        }

        public final void dxA() {
            AppMethodBeat.m2504i(33062);
            ((C45446k) C1720g.m3528K(C45446k.class)).abC();
            AppMethodBeat.m2505o(33062);
        }

        public final void dxB() {
            AppMethodBeat.m2504i(33063);
            ((C45446k) C1720g.m3528K(C45446k.class)).abD();
            AppMethodBeat.m2505o(33063);
        }

        public final void dxC() {
            AppMethodBeat.m2504i(33064);
            C4990ab.m7416i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
            if (this.zei == null) {
                AppMethodBeat.m2505o(33064);
                return;
            }
            C46650a c46650a = (C46650a) this.zei.get();
            if (c46650a != null) {
                C37922v.m64076Zp().mo60674nV(C23858e.m36742bE(c46650a));
                ((C7336g) c46650a.mo74857aF(C7336g.class)).mo15846b(this);
                ((C45446k) C1720g.m3528K(C45446k.class)).mo60979po(C23858e.m36742bE(c46650a));
            }
            AppMethodBeat.m2505o(33064);
        }

        public final void dxD() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.s$d */
    static class C23857d extends C5379a {
        public static final int zej = C1338a.fromDPToPix(C4996ah.getContext(), 240);
        public static final int zek = C1338a.fromDPToPix(C4996ah.getContext(), C33250az.CTRL_INDEX);
        static C25814c zel;
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

        C23857d() {
        }

        static {
            AppMethodBeat.m2504i(33066);
            C17927a c17927a = new C17927a();
            c17927a.ePT = C1318a.app_brand_app_default_icon_for_tail;
            c17927a.mo33448ct(C1338a.fromDPToPix(C4996ah.getContext(), 20), C1338a.fromDPToPix(C4996ah.getContext(), 20)).ePF = true;
            zel = c17927a.ahG();
            AppMethodBeat.m2505o(33066);
        }

        /* renamed from: C */
        public final C23857d mo39645C(View view, boolean z) {
            AppMethodBeat.m2504i(33065);
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
            this.zcr = (ImageView) view.findViewById(2131822522);
            this.zcs = (ImageView) view.findViewById(2131822521);
            this.zct = (TextView) view.findViewById(2131822519);
            this.zcm = (TextView) view.findViewById(2131822520);
            this.zet = (TextView) view.findViewById(2131822588);
            this.zcn = (ImageView) view.findViewById(2131822517);
            this.zco = (TextView) view.findViewById(2131822518);
            this.zcp = (TextView) view.findViewById(2131822524);
            this.zeu = (TextView) view.findViewById(2131822589);
            AppMethodBeat.m2505o(33065);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.s$e */
    static class C23858e {
        /* renamed from: bE */
        static String m36742bE(Object obj) {
            AppMethodBeat.m2504i(33067);
            String str = "WxaUpdatableMsg#" + C38496n.m65148bE(obj);
            AppMethodBeat.m2505o(33067);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.s$b */
    public static class C23861b extends C5378c implements C5365n {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 587202609) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33055);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969095);
                view.setTag(new C23857d().mo39645C(view, false));
            }
            AppMethodBeat.m2505o(33055);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(33056);
            c5379a = (C23857d) c5379a;
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
                C32291o.ahp().mo43766a(str2, c5379a.zcn, C23857d.zel);
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
                str2 = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                c5379a.zcr.setImageBitmap(null);
                c5379a.zcr.setVisibility(4);
                c5379a.zcs.setVisibility(0);
                C37926b.abR().mo60686a(new C9676i() {
                    public final void abU() {
                    }

                    /* renamed from: x */
                    public final void mo6524x(Bitmap bitmap) {
                        AppMethodBeat.m2504i(33052);
                        if (bitmap == null || bitmap.isRecycled()) {
                            c5379a.zcr.setVisibility(4);
                            c5379a.zcs.setVisibility(0);
                            AppMethodBeat.m2505o(33052);
                            return;
                        }
                        c5379a.zcr.setImageBitmap(bitmap);
                        c5379a.zcr.setVisibility(0);
                        c5379a.zcs.setVisibility(4);
                        AppMethodBeat.m2505o(33052);
                    }

                    /* renamed from: mr */
                    public final void mo6522mr() {
                    }

                    /* renamed from: wP */
                    public final String mo6523wP() {
                        AppMethodBeat.m2504i(33053);
                        String str = "CHAT#" + C38496n.m65148bE(this);
                        AppMethodBeat.m2505o(33053);
                        return str;
                    }
                }, "file://".concat(String.valueOf(str2)), null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(240, C33250az.CTRL_INDEX));
                c5379a.zet.setVisibility(8);
                c5379a.zet.setTag(C5046bo.m7532bc(X.fiV, ""));
                c5379a.zeu.setVisibility(8);
                final C41728a c41728a = (C41728a) X.mo20333X(C41728a.class);
                if (c41728a != null && c41728a.ffb) {
                    String str3 = X.fiV;
                    C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(str3);
                    C23859s.m36744a(c46650a, c5379a, c41728a, pn);
                    C23859s.m36745a(c46650a, c5379a, c41728a, X, pn);
                    int i2 = c41728a.ffi;
                    if (!(pn == null || pn.field_updatePeroid == 0)) {
                        i2 = pn.field_updatePeroid;
                    }
                    if (i2 > 0) {
                        ((C45446k) C1720g.m3528K(C45446k.class)).mo60974a(C23858e.m36742bE(c46650a), X.fiQ, str3, i2, new C26437a() {
                            /* renamed from: a */
                            public final void mo27967a(String str, cjk cjk) {
                                AppMethodBeat.m2504i(33054);
                                C4990ab.m7411d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", str, cjk.content);
                                if (c5379a.zet == null) {
                                    C4990ab.m7420w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                                    AppMethodBeat.m2505o(33054);
                                    return;
                                }
                                String str2 = (String) c5379a.zet.getTag();
                                if (C5046bo.isNullOrNil(str2)) {
                                    C4990ab.m7420w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                                    AppMethodBeat.m2505o(33054);
                                    return;
                                }
                                if (str2.equals(str)) {
                                    c5379a.zet.setVisibility(0);
                                    c5379a.zet.setText(cjk.content);
                                    c5379a.zet.setTextColor(C5046bo.m7530bS(cjk.wYm, c5379a.zet.getCurrentTextColor()));
                                    if (cjk.state == 1) {
                                        C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(str);
                                        if (pn != null && pn.field_btnState == 1) {
                                            if (C5046bo.isNullOrNil(c41728a.ffh)) {
                                                c5379a.zeu.setVisibility(8);
                                                AppMethodBeat.m2505o(33054);
                                                return;
                                            }
                                            c5379a.zeu.setVisibility(0);
                                            c5379a.zeu.setText(c41728a.ffh);
                                        }
                                    }
                                }
                                AppMethodBeat.m2505o(33054);
                            }
                        });
                    }
                }
            }
            c5379a.jPL.setTag(c40814ay);
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            C32800b y = C37922v.m64076Zp().mo60676y(C23858e.m36742bE(c46650a), true);
            C23856c c23856c = (C23856c) y.get(CastExtraArgs.LISTENER, null);
            if (c23856c == null) {
                c23856c = new C23856c();
                y.mo53356j(CastExtraArgs.LISTENER, c23856c);
            }
            c23856c.mo39644k(c46650a);
            if (this.kuU) {
                c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
                c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            }
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33056);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33057);
            int i = ((C40814ay) view.getTag()).position;
            if (c7620bi.field_content == null) {
                AppMethodBeat.m2505o(33057);
            } else {
                C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                if (me == null) {
                    AppMethodBeat.m2505o(33057);
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
                    AppMethodBeat.m2505o(33057);
                }
            }
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33058);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = c7620bi.field_content;
                    if (str != null) {
                        C8910b me = C8910b.m16064me(str);
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
                        AppMethodBeat.m2505o(33058);
                        break;
                    }
                    AppMethodBeat.m2505o(33058);
                    break;
                case 111:
                    C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
                    AppMethodBeat.m2505o(33058);
                    break;
                default:
                    AppMethodBeat.m2505o(33058);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33059);
            view.getTag();
            String str = c7620bi.field_content;
            if (str == null) {
                AppMethodBeat.m2505o(33059);
                return false;
            }
            C8910b me = C8910b.m16064me(str);
            if (me == null) {
                AppMethodBeat.m2505o(33059);
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
            C23859s.m36743a(c46650a, me);
            AppMethodBeat.m2505o(33059);
            return true;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33060);
            if (c7620bi.bAA()) {
                C4733l.m7097al(c7620bi);
                C1829bf.m3748fm(c7620bi.field_msgId);
                c46650a.mo74882qp(true);
                AppMethodBeat.m2505o(33060);
                return;
            }
            AppMethodBeat.m2505o(33060);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.s$a */
    public static class C23864a extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 587202609) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33047);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969058);
                view.setTag(new C23857d().mo39645C(view, true));
            }
            AppMethodBeat.m2505o(33047);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(33048);
            this.yJI = c46650a;
            final C23857d c23857d = (C23857d) c5379a;
            C36137j c36137j = (C36137j) c46650a.mo74857aF(C36137j.class);
            c36137j.mo57028be(c7620bi);
            c36137j.mo57029bf(c7620bi);
            c36137j.mo57030bg(c7620bi);
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                C4990ab.m7413e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(c7620bi.field_msgId), str);
                X = null;
            }
            C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
            if (X != null) {
                List list;
                c23857d.zbS.setVisibility(8);
                c23857d.zbR.setVisibility(8);
                c23857d.zcq.setVisibility(8);
                C45138g c45138g = (C45138g) X.mo20333X(C45138g.class);
                ChattingItemFooter chattingItemFooter = c23857d.zbV;
                if (c45138g == null) {
                    list = null;
                } else {
                    list = c45138g.fgf;
                }
                if (chattingItemFooter.mo70214l(list, c7620bi.field_talker)) {
                    c23857d.jPL.setBackgroundResource(C25738R.drawable.f6559i4);
                } else {
                    c23857d.jPL.setBackgroundResource(C25738R.drawable.f6555i0);
                }
                C40439f dX = C46494g.m87742dX(X.appId, X.axy);
                if (dX != null) {
                    C5378c.m8138b(c46650a, X, c7620bi);
                }
                if (X.dJv == null || X.dJv.length() == 0) {
                    c23857d.zbU.setVisibility(8);
                } else {
                    c23857d.zbU.setVisibility(0);
                    mo11018b(c46650a, (View) c23857d.zbU, (Object) C40814ay.arL(X.dJv));
                }
                WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(X.fiP);
                c23857d.zbX.setVisibility(0);
                c23857d.zbO.setVisibility(8);
                c23857d.zca.setVisibility(0);
                c23857d.zbY.setVisibility(8);
                c23857d.zco.setText(zb != null ? zb.field_nickname : X.cMh);
                str2 = zb != null ? zb.field_smallHeadURL : X.fjb;
                C32291o.ahp().mo43766a(str2, c23857d.zcn, C23857d.zel);
                c23857d.zcq.setVisibility(0);
                c23857d.zcm.setVisibility(8);
                c23857d.zcm.setText(X.description);
                c23857d.zct.setText(X.title);
                switch (X.fiZ) {
                    case 1:
                        c23857d.zcp.setText(C25738R.string.f9057o1);
                        break;
                    case 2:
                        c23857d.zcp.setText(C25738R.string.f9056o0);
                        break;
                    default:
                        c23857d.zcp.setText(C25738R.string.f8887i9);
                        break;
                }
                C32291o.ahp().mo43766a(str2, c23857d.zcn, C23857d.zel);
                if (c46650a.dFx()) {
                    c23857d.zbW.setVisibility(8);
                } else if (C46494g.m87749h(dX)) {
                    c23857d.zbW.setVisibility(0);
                    C5378c.m8140c(c46650a, c23857d.zbW, C40814ay.m70729a(X, c7620bi));
                } else {
                    c23857d.zbW.setVisibility(8);
                }
                str2 = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                c23857d.zcr.setImageBitmap(null);
                c23857d.zcr.setVisibility(4);
                c23857d.zcs.setVisibility(0);
                C37926b.abR().mo60686a(new C9676i() {
                    public final void abU() {
                    }

                    /* renamed from: x */
                    public final void mo6524x(Bitmap bitmap) {
                        AppMethodBeat.m2504i(33044);
                        if (bitmap == null || bitmap.isRecycled()) {
                            c23857d.zcr.setVisibility(4);
                            c23857d.zcs.setVisibility(0);
                            AppMethodBeat.m2505o(33044);
                            return;
                        }
                        c23857d.zcr.setImageBitmap(bitmap);
                        c23857d.zcr.setVisibility(0);
                        c23857d.zcs.setVisibility(4);
                        AppMethodBeat.m2505o(33044);
                    }

                    /* renamed from: mr */
                    public final void mo6522mr() {
                    }

                    /* renamed from: wP */
                    public final String mo6523wP() {
                        AppMethodBeat.m2504i(33045);
                        String str = "CHAT#" + C38496n.m65148bE(this);
                        AppMethodBeat.m2505o(33045);
                        return str;
                    }
                }, "file://".concat(String.valueOf(str2)), null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(240, C33250az.CTRL_INDEX));
                c23857d.zet.setVisibility(8);
                c23857d.zet.setTag(C5046bo.m7532bc(X.fiV, ""));
                c23857d.zeu.setVisibility(8);
                final C41728a c41728a = (C41728a) X.mo20333X(C41728a.class);
                if (c41728a != null && c41728a.ffb) {
                    String str3 = X.fiV;
                    C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(str3);
                    C23859s.m36744a(c46650a, c23857d, c41728a, pn);
                    C23859s.m36745a(c46650a, c23857d, c41728a, X, pn);
                    int i2 = c41728a.ffi;
                    if (!(pn == null || pn.field_updatePeroid == 0)) {
                        i2 = pn.field_updatePeroid;
                    }
                    if (i2 > 0) {
                        ((C45446k) C1720g.m3528K(C45446k.class)).mo60974a(C23858e.m36742bE(c46650a), X.fiQ, str3, i2, new C26437a() {
                            /* renamed from: a */
                            public final void mo27967a(String str, cjk cjk) {
                                AppMethodBeat.m2504i(33046);
                                C4990ab.m7411d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", str, cjk.content);
                                if (c23857d.zet == null) {
                                    C4990ab.m7420w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                                    AppMethodBeat.m2505o(33046);
                                    return;
                                }
                                String str2 = (String) c23857d.zet.getTag();
                                if (C5046bo.isNullOrNil(str2)) {
                                    C4990ab.m7420w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                                    AppMethodBeat.m2505o(33046);
                                    return;
                                }
                                if (str2.equals(str)) {
                                    c23857d.zet.setVisibility(0);
                                    c23857d.zet.setText(cjk.content);
                                    c23857d.zet.setTextColor(C5046bo.m7530bS(cjk.wYm, c23857d.zet.getCurrentTextColor()));
                                    if (cjk.state == 1) {
                                        C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(str);
                                        if (pn != null && pn.field_btnState == 1) {
                                            if (C5046bo.isNullOrNil(c41728a.ffh)) {
                                                c23857d.zeu.setVisibility(8);
                                                AppMethodBeat.m2505o(33046);
                                                return;
                                            }
                                            c23857d.zeu.setVisibility(0);
                                            c23857d.zeu.setText(c41728a.ffh);
                                        }
                                    }
                                }
                                AppMethodBeat.m2505o(33046);
                            }
                        });
                    }
                }
            }
            c23857d.jPL.setTag(c40814ay);
            c23857d.jPL.setOnClickListener(mo11022d(c46650a));
            C32800b y = C37922v.m64076Zp().mo60676y(C23858e.m36742bE(c46650a), true);
            C23856c c23856c = (C23856c) y.get(CastExtraArgs.LISTENER, null);
            if (c23856c == null) {
                c23856c = new C23856c();
                y.mo53356j(CastExtraArgs.LISTENER, c23856c);
            }
            c23856c.mo39644k(c46650a);
            if (this.kuU) {
                c23857d.jPL.setOnLongClickListener(mo11021c(c46650a));
                c23857d.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            }
            AppMethodBeat.m2505o(33048);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33049);
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
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(33049);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33050);
            switch (menuItem.getItemId()) {
                case 111:
                    C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
                    AppMethodBeat.m2505o(33050);
                    break;
                default:
                    AppMethodBeat.m2505o(33050);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33051);
            C42219a.m74510a(c7620bi, C32832a.Click);
            if (c7620bi.field_content == null) {
                AppMethodBeat.m2505o(33051);
                return false;
            }
            C8910b me = C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me == null) {
                AppMethodBeat.m2505o(33051);
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
            C23859s.m36743a(c46650a, me);
            AppMethodBeat.m2505o(33051);
            return true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m36744a(C46650a c46650a, C23857d c23857d, C41728a c41728a, C17871b c17871b) {
        AppMethodBeat.m2504i(33068);
        if (c17871b != null && !C5046bo.isNullOrNil(c17871b.field_content)) {
            c23857d.zet.setVisibility(0);
            c23857d.zet.setText(c17871b.field_content);
            c23857d.zet.setTextColor(C5046bo.m7530bS(c17871b.field_contentColor, c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12212w4)));
            AppMethodBeat.m2505o(33068);
        } else if (C5046bo.isNullOrNil(c41728a.ffc)) {
            c23857d.zet.setVisibility(8);
            AppMethodBeat.m2505o(33068);
        } else {
            c23857d.zet.setVisibility(0);
            c23857d.zet.setText(c41728a.ffc);
            c23857d.zet.setTextColor(C5046bo.m7530bS(c41728a.ffd, c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12212w4)));
            AppMethodBeat.m2505o(33068);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m36745a(C46650a c46650a, C23857d c23857d, C41728a c41728a, C8910b c8910b, C17871b c17871b) {
        AppMethodBeat.m2504i(33069);
        if (!(c17871b == null || c17871b.field_btnState == 0)) {
            if (c17871b.field_btnState != 1) {
                if (c17871b.field_btnState == 2) {
                    c23857d.zeu.setVisibility(0);
                    c23857d.zeu.setText(c41728a.ffg);
                    AppMethodBeat.m2505o(33069);
                    return;
                }
                AppMethodBeat.m2505o(33069);
            } else if (c17871b.field_msgState != 1) {
                c23857d.zeu.setVisibility(0);
                String replace = c41728a.ffe.replace("$button$", c41728a.fff);
                SpannableString spannableString = new SpannableString(replace);
                final String str = c41728a.ffg;
                final C8910b c8910b2 = c8910b;
                final C23857d c23857d2 = c23857d;
                final C46650a c46650a2 = c46650a;
                final C41728a c41728a2 = c41728a;
                spannableString.setSpan(new C34529a() {
                    public final void onClickImp(View view) {
                        C18452c c18452c;
                        AppMethodBeat.m2504i(33043);
                        ((C45446k) C1720g.m3528K(C45446k.class)).mo60973T(c8910b2.fiV, 2);
                        c23857d2.zeu.setText(str);
                        C26288cs hH = new C26288cs().mo44049hE(c8910b2.fiQ).mo44050hF(c8910b2.fiO).mo44051hG(c8910b2.fiV).mo44052hH(c46650a2.getTalkerUserName());
                        if (c46650a2.dFx()) {
                            c18452c = C18452c.YES;
                        } else {
                            c18452c = C18452c.NO;
                        }
                        hH.dhB = c18452c;
                        hH.dhC = C26289b.CLICKSUBSCRIBETV;
                        hH.cVR = 0;
                        C26288cs Hk = hH.mo44053hI("").mo44048Hk();
                        Hk.dhE = C18453d.DEFAULT;
                        Hk.dhG = C26290a.m41777hp(c41728a2.ffa + 1000);
                        Hk.dhF = C18454e.DEFAULT;
                        Hk.ajK();
                        AppMethodBeat.m2505o(33043);
                    }
                }, replace.indexOf(c41728a.fff), replace.indexOf(c41728a.fff) + c41728a.fff.length(), 17);
                c23857d.zeu.setMovementMethod(C40815bc.getInstance());
                c23857d.zeu.setText(spannableString);
                AppMethodBeat.m2505o(33069);
                return;
            } else if (!C5046bo.isNullOrNil(c41728a.ffh)) {
                c23857d.zeu.setVisibility(0);
                c23857d.zeu.setText(c41728a.ffh);
                AppMethodBeat.m2505o(33069);
                return;
            }
        }
        c23857d.zeu.setVisibility(8);
        AppMethodBeat.m2505o(33069);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m36743a(C46650a c46650a, C8910b c8910b) {
        C18453d c18453d;
        C41728a c41728a;
        int i;
        C26288cs hH;
        C18452c c18452c;
        C26288cs hI;
        C26288cs Hk;
        AppMethodBeat.m2504i(33070);
        C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(c8910b.fiV);
        C18453d c18453d2 = C18453d.DEFAULT;
        C18454e c18454e = C18454e.DEFAULT;
        if (pn != null) {
            if (pn.field_msgState == 1) {
                c18453d2 = C18453d.DONE;
            } else if (pn.field_msgState == 0) {
                c18453d2 = C18453d.DOING;
            }
            if (pn.field_btnState == 2) {
                c18454e = C18454e.SUBSCRIBE;
                c18453d = c18453d2;
            } else if (pn.field_btnState == 0 || pn.field_btnState == 1) {
                c18454e = C18454e.NOTSUBSCRIBE;
                c18453d = c18453d2;
            }
            c41728a = (C41728a) c8910b.mo20333X(C41728a.class);
            i = c41728a == null ? c41728a.ffa : 0;
            hH = new C26288cs().mo44049hE(c8910b.fiQ).mo44050hF(c8910b.fiO).mo44051hG(c8910b.fiV).mo44052hH(c46650a.getTalkerUserName());
            if (c46650a.dFx()) {
                c18452c = C18452c.NO;
            } else {
                c18452c = C18452c.YES;
            }
            hH.dhB = c18452c;
            hH.dhC = C26289b.CLICKAPPMSG;
            hH.cVR = 0;
            hI = hH.mo44053hI("");
            hI.dhG = C26290a.m41777hp(i + 1000);
            Hk = hI.mo44048Hk();
            Hk.dhE = c18453d;
            Hk.dhF = c18454e;
            Hk.ajK();
            AppMethodBeat.m2505o(33070);
        }
        c18453d = c18453d2;
        c41728a = (C41728a) c8910b.mo20333X(C41728a.class);
        if (c41728a == null) {
        }
        hH = new C26288cs().mo44049hE(c8910b.fiQ).mo44050hF(c8910b.fiO).mo44051hG(c8910b.fiV).mo44052hH(c46650a.getTalkerUserName());
        if (c46650a.dFx()) {
        }
        hH.dhB = c18452c;
        hH.dhC = C26289b.CLICKAPPMSG;
        hH.cVR = 0;
        hI = hH.mo44053hI("");
        hI.dhG = C26290a.m41777hp(i + 1000);
        Hk = hI.mo44048Hk();
        Hk.dhE = c18453d;
        Hk.dhF = c18454e;
        Hk.ajK();
        AppMethodBeat.m2505o(33070);
    }
}
