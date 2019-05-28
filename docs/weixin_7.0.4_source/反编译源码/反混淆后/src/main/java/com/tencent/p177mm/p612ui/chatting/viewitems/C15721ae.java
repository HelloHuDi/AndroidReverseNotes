package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37735ie;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45335jj;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46644u;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.view.C31128d;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ae */
public final class C15721ae {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ae$a */
    public static class C7340a extends C5378c {
        private C46650a yJI;
        protected C15719c zga;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 48) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33250);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969065);
                view.setTag(new C15722d().mo27951z(view, true));
            }
            AppMethodBeat.m2505o(33250);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33251);
            this.yJI = c46650a;
            C15722d c15722d = (C15722d) c5379a;
            if (this.zga == null) {
                this.zga = new C15719c(c46650a);
            }
            C15722d.m24032a(c15722d, c7620bi, true, i, c46650a, this.zga, mo11021c(c46650a));
            AppMethodBeat.m2505o(33251);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33252);
            if (c7620bi.getType() == 48) {
                int i = ((C40814ay) view.getTag()).position;
                contextMenu.add(i, C31128d.MIC_SketchMark, 0, view.getContext().getString(C25738R.string.dr1));
                if (C17903f.aeA() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                }
                if (C25985d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                }
                C9321dq c9321dq = new C9321dq();
                c9321dq.cxc.cvx = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c9321dq);
                if (c9321dq.cxd.cwB || C46494g.m87731ad(this.yJI.yTx.getContext(), c7620bi.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                }
            }
            AppMethodBeat.m2505o(33252);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33253);
            switch (menuItem.getItemId()) {
                case C31128d.MIC_SketchMark /*127*/:
                    if (c7620bi.bAC()) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(c7620bi);
                        C46660k.m88358a(c46650a.yTx.getContext(), linkedList, c46650a.dFx(), c46650a.sRl.field_username, null);
                    }
                    AppMethodBeat.m2505o(33253);
                    return true;
                case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                    Intent intent = new Intent(c46650a.yTx.getContext(), ChattingSendDataToDeviceUI.class);
                    intent.putExtra("exdevice_open_scene_type", 1);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.yTx.getContext().startActivity(intent);
                    AppMethodBeat.m2505o(33253);
                    return true;
                default:
                    AppMethodBeat.m2505o(33253);
                    return false;
            }
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ae$b */
    public static class C7341b extends C5378c implements C5365n {
        private C46650a yJI;
        protected C15719c zga;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 48) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33254);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969102);
                view.setTag(new C15722d().mo27951z(view, false));
            }
            AppMethodBeat.m2505o(33254);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33255);
            this.yJI = c46650a;
            C15722d c15722d = (C15722d) c5379a;
            if (this.zga == null) {
                this.zga = new C15719c(c46650a);
            }
            C15722d.m24032a(c15722d, c7620bi, false, i, c46650a, this.zga, mo11021c(c46650a));
            c5379a = (C15722d) c5379a;
            if (C5378c.dHm()) {
                if (c7620bi.field_status == 2 && C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                    if (c5379a.zci != null) {
                        c5379a.zci.setVisibility(0);
                    }
                } else if (c5379a.zci != null) {
                    c5379a.zci.setVisibility(8);
                }
            }
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33255);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33256);
            if (c7620bi.getType() == 48) {
                int i = ((C40814ay) view.getTag()).position;
                if (c7620bi.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                }
                contextMenu.add(i, C31128d.MIC_SketchMark, 0, view.getContext().getString(C25738R.string.dr1));
                if (C17903f.aeA() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                }
                if (C25985d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                }
                C9321dq c9321dq = new C9321dq();
                c9321dq.cxc.cvx = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c9321dq);
                if (c9321dq.cxd.cwB || C46494g.m87731ad(this.yJI.yTx.getContext(), c7620bi.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                }
                if (!c7620bi.drC() && c7620bi.bAC() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                }
            }
            AppMethodBeat.m2505o(33256);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33257);
            switch (menuItem.getItemId()) {
                case C31128d.MIC_SketchMark /*127*/:
                    if (c7620bi.bAC()) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(c7620bi);
                        C46660k.m88358a(c46650a.yTx.getContext(), linkedList, c46650a.dFx(), c46650a.sRl.field_username, null);
                    }
                    AppMethodBeat.m2505o(33257);
                    return true;
                default:
                    AppMethodBeat.m2505o(33257);
                    return false;
            }
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33258);
            c7620bi.dtJ();
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            ((C46644u) c46650a.mo74857aF(C46644u.class)).mo10961bb(c7620bi);
            AppMethodBeat.m2505o(33258);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ae$c */
    public static class C15719c extends C23812e {

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.ae$c$1 */
        class C157201 implements C25987a {
            C157201() {
            }

            public final void onActivityResult(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(33259);
                switch (i) {
                    case 2002:
                        if (intent != null) {
                            if (intent.getBooleanExtra("kfavorite", false)) {
                                C45316cl c45316cl = new C45316cl();
                                C40443e.m69370a(c45316cl, intent);
                                c45316cl.cvA.fragment = C15719c.this.yJI.yTx;
                                c45316cl.cvA.cvH = 42;
                                C4879a.xxA.mo10055m(c45316cl);
                                break;
                            }
                        }
                        C4990ab.m7413e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", Integer.valueOf(i), Integer.valueOf(i2));
                        AppMethodBeat.m2505o(33259);
                        return;
                        break;
                }
                AppMethodBeat.m2505o(33259);
            }
        }

        public C15719c(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            String trim;
            C5136b Ro;
            C45335jj c45335jj;
            String str;
            Intent intent;
            AppMethodBeat.m2504i(33260);
            C7620bi c7620bi2 = ((C40814ay) view.getTag()).cKd;
            String str2 = c7620bi2.field_content;
            int i = c7620bi2.field_isSend == 0 ? 1 : 0;
            String str3 = "";
            if (i != 0) {
                str3 = c7620bi2.field_talker;
            }
            if (!(!C1855t.m3896kH(c7620bi2.field_talker) || i == 0 || ((C36135d) this.yJI.mo74857aF(C36135d.class)).dDm())) {
                i = C1829bf.m3761ox(str2);
                if (i != -1) {
                    str3 = str2.substring(0, i).trim();
                    trim = str2.substring(i + 1).trim();
                    C9638aw.m17190ZK();
                    Ro = C18628c.m29080XO().mo15261Ro(trim);
                    if (C42252ah.isNullOrNil(str3) && C1855t.m3896kH(str3)) {
                        trim = "";
                    } else {
                        trim = str3;
                    }
                    c45335jj = new C45335jj();
                    c45335jj.cEF.cEA = 1;
                    c45335jj.cEF.csG = c7620bi2;
                    C4879a.xxA.mo10055m(c45335jj);
                    str = c45335jj.cEG.cBp;
                    if (C42252ah.isNullOrNil(Ro.eUu) || Ro.dub()) {
                        intent = new Intent();
                        intent.putExtra("kMsgId", c7620bi2.field_msgId);
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", Ro.nJu);
                        intent.putExtra("kwebmap_lng", Ro.nJv);
                        intent.putExtra("kwebmap_scale", Ro.cED);
                        intent.putExtra("kPoiName", Ro.eUu);
                        intent.putExtra("kisUsername", C1854s.m3866mJ(trim));
                        intent.putExtra("Kwebmap_locaion", str);
                        C9638aw.m17190ZK();
                        intent.putExtra("kimg_path", C18628c.m29088XW());
                        intent.putExtra("map_talker_name", c7620bi2.field_talker);
                        intent.putExtra("view_type_key", 0);
                        intent.putExtra("kwebmap_from_to", true);
                        intent.putExtra("kPoi_url", Ro.vaO);
                        intent.putExtra("kPoiid", Ro.nJB);
                        intent.putExtra("soso_street_view_url", C42252ah.m74607bc(c7620bi2.field_reserved, ""));
                        C7060h.pYm.mo8381e(12809, Integer.valueOf(2), "");
                        C25985d.m41459a(this.yJI.yTv, C8741b.LOCATION, ".ui.RedirectUI", intent, 2002, new C157201());
                        AppMethodBeat.m2505o(33260);
                    }
                    C4990ab.m7421w("MicroMsg.LocationClickListener", "invalid poi: %s, %s", Ro.eUu, Boolean.valueOf(Ro.dub()));
                    AppMethodBeat.m2505o(33260);
                    return;
                }
            }
            trim = str2;
            C9638aw.m17190ZK();
            Ro = C18628c.m29080XO().mo15261Ro(trim);
            if (C42252ah.isNullOrNil(str3)) {
            }
            trim = str3;
            c45335jj = new C45335jj();
            c45335jj.cEF.cEA = 1;
            c45335jj.cEF.csG = c7620bi2;
            C4879a.xxA.mo10055m(c45335jj);
            str = c45335jj.cEG.cBp;
            if (C42252ah.isNullOrNil(Ro.eUu)) {
            }
            intent = new Intent();
            intent.putExtra("kMsgId", c7620bi2.field_msgId);
            intent.putExtra("map_view_type", 1);
            intent.putExtra("kwebmap_slat", Ro.nJu);
            intent.putExtra("kwebmap_lng", Ro.nJv);
            intent.putExtra("kwebmap_scale", Ro.cED);
            intent.putExtra("kPoiName", Ro.eUu);
            intent.putExtra("kisUsername", C1854s.m3866mJ(trim));
            intent.putExtra("Kwebmap_locaion", str);
            C9638aw.m17190ZK();
            intent.putExtra("kimg_path", C18628c.m29088XW());
            intent.putExtra("map_talker_name", c7620bi2.field_talker);
            intent.putExtra("view_type_key", 0);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kPoi_url", Ro.vaO);
            intent.putExtra("kPoiid", Ro.nJB);
            intent.putExtra("soso_street_view_url", C42252ah.m74607bc(c7620bi2.field_reserved, ""));
            C7060h.pYm.mo8381e(12809, Integer.valueOf(2), "");
            C25985d.m41459a(this.yJI.yTv, C8741b.LOCATION, ".ui.RedirectUI", intent, 2002, new C157201());
            AppMethodBeat.m2505o(33260);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ae$d */
    static class C15722d extends C5379a {
        ImageView zci;
        TextView zfC;
        LinearLayout zgc;
        TextView zgd;
        ProgressBar zge;
        ImageView zgf;
        ProgressBar zgg;
        ImageView zgh;

        C15722d() {
        }

        /* renamed from: z */
        public final C5379a mo27951z(View view, boolean z) {
            AppMethodBeat.m2504i(33261);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zfC = (TextView) view.findViewById(2131822610);
            this.zgd = (TextView) view.findViewById(2131822609);
            this.zgc = (LinearLayout) view.findViewById(2131822608);
            this.zge = (ProgressBar) view.findViewById(2131822172);
            this.jPL = view.findViewById(2131822515);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.zgf = (ImageView) view.findViewById(2131822612);
            this.zgg = (ProgressBar) view.findViewById(2131822611);
            this.zgh = (ImageView) view.findViewById(2131822613);
            if (!z) {
                this.zby = (ImageView) view.findViewById(2131822629);
                this.zci = (ImageView) view.findViewById(2131822661);
            }
            this.zgd.setTextSize(1, 16.0f);
            this.zfC.setTextSize(1, 12.0f);
            AppMethodBeat.m2505o(33261);
            return this;
        }

        /* renamed from: a */
        public static void m24032a(C15722d c15722d, C7620bi c7620bi, boolean z, int i, C46650a c46650a, C15719c c15719c, OnLongClickListener onLongClickListener) {
            AppMethodBeat.m2504i(33262);
            if (c15722d == null) {
                AppMethodBeat.m2505o(33262);
                return;
            }
            c15722d.zgc.setVisibility(8);
            int fromDPToPix = C1338a.fromDPToPix(c46650a.yTx.getContext(), 236);
            int fromDPToPix2 = C1338a.fromDPToPix(c46650a.yTx.getContext(), 90);
            c15722d.zgd.setMaxLines(1);
            c15722d.zfC.setMaxLines(1);
            c15722d.zfC.setText("");
            if (C25985d.afj(C8741b.LOCATION)) {
                C4990ab.m7410d("MicroMsg.LocationItemHolder", "plugin found!");
                C45335jj c45335jj = new C45335jj();
                c45335jj.cEF.cEA = 1;
                c45335jj.cEF.csG = c7620bi;
                C4879a.xxA.mo10055m(c45335jj);
                String str = c45335jj.cEG.cBp;
                String str2 = c45335jj.cEG.cEI;
                if ((str != null || C15722d.m24033b(str2, c46650a)) && ((str == null || !str.equals("") || C15722d.m24033b(str2, c46650a)) && (str == null || !str.equals("err_not_started")))) {
                    c15722d.zgg.setVisibility(8);
                    c15722d.zgc.setVisibility(0);
                    C4990ab.m7410d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(str)));
                    if (C15722d.m24033b(str2, c46650a)) {
                        c15722d.zgd.setVisibility(0);
                        c15722d.zgd.setText(str2);
                        if (str == null || str.equals("")) {
                            c15722d.zfC.setVisibility(8);
                        } else {
                            c15722d.zfC.setVisibility(0);
                            c15722d.zfC.setText(str);
                        }
                    } else {
                        c15722d.zgd.setMaxLines(2);
                        c15722d.zgd.setText(String.valueOf(str));
                        c15722d.zfC.setVisibility(8);
                    }
                } else {
                    C4990ab.m7410d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
                    c15722d.zgg.setVisibility(8);
                    c15722d.zgc.setVisibility(0);
                    c15722d.zgd.setText(C25738R.string.cn7);
                    c15722d.zfC.setText("");
                }
            } else {
                c15722d.zge.setVisibility(0);
                c15722d.zgc.setVisibility(8);
            }
            c15722d.zgf.setImageBitmap(C32291o.ahl().mo73114g(fromDPToPix, fromDPToPix2, z));
            C37735ie c37735ie = new C37735ie();
            c37735ie.cDf.csG = c7620bi;
            c37735ie.cDf.f16122w = fromDPToPix;
            c37735ie.cDf.f16121h = fromDPToPix2;
            c37735ie.cDf.cDk = C25738R.drawable.bbi;
            c37735ie.cDf.cDh = c15722d.zgf;
            c37735ie.cDf.cDj = c15722d.zge;
            c37735ie.cDf.cDi = c15722d.zgh;
            C4879a.xxA.mo10055m(c37735ie);
            c15722d.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c15722d.jPL.setOnClickListener(c15719c);
            c15722d.jPL.setOnLongClickListener(onLongClickListener);
            c15722d.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            AppMethodBeat.m2505o(33262);
        }

        /* renamed from: b */
        private static boolean m24033b(String str, C46650a c46650a) {
            AppMethodBeat.m2504i(33263);
            if (str == null || str.equals("") || str.equals(c46650a.yTx.getMMResources().getString(C25738R.string.cnn))) {
                AppMethodBeat.m2505o(33263);
                return false;
            }
            AppMethodBeat.m2505o(33263);
            return true;
        }
    }
}
