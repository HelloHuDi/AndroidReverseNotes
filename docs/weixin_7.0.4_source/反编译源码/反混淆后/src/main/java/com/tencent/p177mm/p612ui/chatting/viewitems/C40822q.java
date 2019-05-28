package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.chatting.C40788j;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5382c;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5406b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.q */
public final class C40822q {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.q$a */
    public static class C30612a extends C5378c {
        private C46650a yJI;
        private C40823c zeg;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 687865905) {
                return false;
            }
            return true;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33009);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969074);
                view.setTag(new C40821d().mo64363fb(view));
            }
            AppMethodBeat.m2505o(33009);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33010);
            this.yJI = c46650a;
            C40821d c40821d = (C40821d) c5379a;
            if (this.zeg == null) {
                this.zeg = new C40823c(this.yJI, this);
            }
            C40821d.m70752a(c40821d, i, c46650a, c7620bi, false, this.zeg, mo11021c(c46650a));
            AppMethodBeat.m2505o(33010);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33011);
            boolean a = C40822q.m70754a(this.yJI, contextMenu, view, c7620bi);
            AppMethodBeat.m2505o(33011);
            return a;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33012);
            if (menuItem.getItemId() == 111) {
                if (C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend)) != null) {
                    C7060h.pYm.mo8381e(16979, r0.fiQ, r0.fiO, Integer.valueOf(0), Integer.valueOf(2));
                }
                C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
            }
            AppMethodBeat.m2505o(33012);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.q$b */
    public static class C40820b extends C5378c implements C5365n {
        private C46650a yJI;
        private C40823c zeg;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 687865905) {
                return true;
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33013);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969110);
                view.setTag(new C40821d().mo64363fb(view));
            }
            AppMethodBeat.m2505o(33013);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33014);
            this.yJI = c46650a;
            C5379a c5379a2 = (C40821d) c5379a;
            if (this.zeg == null) {
                this.zeg = new C40823c(this.yJI, this);
            }
            C40821d.m70752a(c5379a2, i, c46650a, c7620bi, true, this.zeg, mo11021c(c46650a));
            mo11007a(i, c5379a2, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(33014);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33015);
            boolean a = C40822q.m70754a(this.yJI, contextMenu, view, c7620bi);
            AppMethodBeat.m2505o(33015);
            return a;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33016);
            if (menuItem.getItemId() == 111) {
                if (C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend)) != null) {
                    C7060h.pYm.mo8381e(16979, r0.fiQ, r0.fiO, Integer.valueOf(0), Integer.valueOf(2));
                }
                C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
            }
            AppMethodBeat.m2505o(33016);
            return false;
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33017);
            if (c7620bi.bAA()) {
                C4733l.m7097al(c7620bi);
                C1829bf.m3748fm(c7620bi.field_msgId);
                c46650a.mo74882qp(true);
            }
            AppMethodBeat.m2505o(33017);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.q$d */
    static class C40821d extends C5379a {
        public ImageView iYg;
        public TextView moL;
        public ProgressBar progressBar;
        public ImageView zdN;
        public ImageView zeh;

        C40821d() {
        }

        /* renamed from: fb */
        public final C5379a mo64363fb(View view) {
            AppMethodBeat.m2504i(33019);
            super.mo11031eP(view);
            this.zdN = (ImageView) view.findViewById(2131822578);
            this.zeh = (ImageView) view.findViewById(2131822553);
            this.jPL = view.findViewById(2131822515);
            this.iYg = (ImageView) view.findViewById(2131822581);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.moL = (TextView) view.findViewById(2131822543);
            this.progressBar = (ProgressBar) view.findViewById(2131822674);
            this.zby = (ImageView) view.findViewById(2131822629);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            AppMethodBeat.m2505o(33019);
            return this;
        }

        @SuppressLint({"ResourceType"})
        /* renamed from: a */
        public static void m70752a(C40821d c40821d, int i, C46650a c46650a, C7620bi c7620bi, boolean z, C40823c c40823c, C5382c c5382c) {
            AppMethodBeat.m2504i(33020);
            C8910b me = C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me == null) {
                C4990ab.m7420w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
                AppMethodBeat.m2505o(33020);
                return;
            }
            C40439f dX = C46494g.m87742dX(me.appId, me.axy);
            String str = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? me.appName : dX.field_appName;
            if (me.appId == null || me.appId.length() <= 0 || !C5378c.m8142dg(str)) {
                c40821d.moL.setVisibility(8);
            } else {
                c40821d.moL.setText(C46494g.m87733b(c46650a.yTx.getContext(), dX, str));
                c40821d.moL.setVisibility(0);
                C5378c.m8130a(c46650a, c40821d.moL, me.appId);
            }
            c40821d.iYg.setImageDrawable(C1338a.m2864g(c46650a.yTx.getContext(), C1318a.shortvideo_play_btn));
            if (c40821d.progressBar != null) {
                c40821d.progressBar.setVisibility(8);
            }
            String c = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
            C4990ab.m7417i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", c7620bi.field_imgPath, c);
            Bitmap a = C32291o.ahl().mo73086a(c, C1338a.getDensity(c46650a.yTx.getContext()), c46650a.yTx.getContext(), (int) C25738R.drawable.b0p);
            if (a == null || a.isRecycled()) {
                C4990ab.m7416i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
                c40821d.zeh.setLayoutParams(new LayoutParams(0, 0));
                int fromDPToPix = C1338a.fromDPToPix(c46650a.yTx.getContext(), 85);
                int al = C1338a.m2856al(c46650a.yTx.getContext(), C25738R.dimen.f9745eb);
                c40821d.zdN.setImageBitmap(C5056d.m7614a(C5056d.m7644au(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12081rn), fromDPToPix, al), (int) C25738R.drawable.b0p, fromDPToPix, al));
                c40821d.zdN.setLayoutParams(new LayoutParams(fromDPToPix, al));
                c40821d.zeh.setLayoutParams(new LayoutParams(fromDPToPix, al));
            } else {
                c40821d.zdN.setImageBitmap(a);
                c40821d.zdN.setLayoutParams(new LayoutParams(a.getWidth(), a.getHeight()));
                c40821d.zeh.setLayoutParams(new LayoutParams(a.getWidth(), a.getHeight()));
            }
            if (z) {
                if (c7620bi.field_status == 5 || c7620bi.field_status == 2) {
                    if (c40821d.progressBar != null) {
                        c40821d.progressBar.setVisibility(8);
                    }
                } else if (c40821d.progressBar != null) {
                    c40821d.progressBar.setVisibility(0);
                }
            }
            c40821d.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, c7620bi.field_talker, 0));
            c40821d.jPL.setOnClickListener(c40823c);
            c40821d.jPL.setOnLongClickListener(c5382c);
            c40821d.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            C7060h.pYm.mo8381e(16979, me.fiQ, me.fiO, Integer.valueOf(0), Integer.valueOf(0));
            C37926b.abR().mo60688pC("file://".concat(String.valueOf(c)));
            C41728a c41728a = (C41728a) me.mo20333X(C41728a.class);
            if (!(c41728a == null || C5046bo.isNullOrNil(c41728a.appThumbUrl))) {
                C37926b.abR().mo60688pC(c41728a.appThumbUrl);
            }
            AppMethodBeat.m2505o(33020);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.q$c */
    static class C40823c extends C23812e {
        private C5378c zbA;

        public C40823c(C46650a c46650a, C5378c c5378c) {
            super(c46650a);
            this.zbA = c5378c;
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33018);
            C8910b me = C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me == null) {
                C4990ab.m7420w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
                AppMethodBeat.m2505o(33018);
            } else if (C5046bo.isNullOrNil(me.fiQ) && C5046bo.isNullOrNil(me.fiP)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", C35799p.m58684B(me.url, c46650a.dFx() ? "groupmessage" : "singlemessage"));
                intent.putExtra("webpageTitle", me.title);
                intent.putExtra("shortUrl", me.url);
                C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(33018);
            } else {
                String str;
                int i;
                Bundle bundle;
                String talkerUserName = c46650a.getTalkerUserName();
                String b = this.zbA.mo11017b(c46650a, c7620bi);
                Bundle bundle2 = new Bundle();
                if (c46650a.dFx()) {
                    str = "stat_scene";
                    i = 2;
                    bundle = bundle2;
                } else {
                    str = "stat_scene";
                    if (C1855t.m3913mZ(talkerUserName)) {
                        i = 7;
                        bundle = bundle2;
                    } else {
                        i = 1;
                        bundle = bundle2;
                    }
                }
                bundle.putInt(str, i);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                bundle2.putString("stat_chat_talker_username", talkerUserName);
                bundle2.putString("stat_send_msg_user", b);
                C40439f dX = C46494g.m87742dX(me.appId, me.axy);
                String str2 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? me.appName : dX.field_appName;
                bundle2.putString("stat_weishi_app_name", str2);
                bundle2.putString("stat_app_id", me.appId);
                bundle2.putString("stat_weishi_source_username", me.cMg);
                C41728a c41728a = (C41728a) me.mo20333X(C41728a.class);
                String str3 = "stat_weishi_from_opensdk";
                boolean z = c41728a != null && c41728a.ffp == 1;
                bundle2.putBoolean(str3, z);
                bundle2.putString("stat_weishi_msg_img_path", c7620bi.field_imgPath);
                bundle2.putString("stat_weishi_thumb_path", C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true));
                bundle2.putString("stat_weishi_thumb_url", c41728a != null ? c41728a.appThumbUrl : null);
                C7060h.pYm.mo8381e(16979, me.fiQ, me.fiO, Integer.valueOf(0), Integer.valueOf(1));
                C4990ab.m7417i("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, appbrandAppId:%s, appBrandUsername:%s", me.fiQ, me.fiP);
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68050a(c46650a.yTx.getContext(), talkerUserName, b, c46650a.dFx(), me, bundle2);
                AppMethodBeat.m2505o(33018);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m70754a(C46650a c46650a, ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33021);
        int i = ((C40814ay) view.getTag()).position;
        C8910b me = C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
        if (me == null) {
            C4990ab.m7420w("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, content is null");
        } else if (!C46494g.m87750i(C46494g.m87739bT(me.appId, false)) || C40788j.m70653aA(c7620bi)) {
            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, do not show transmit menu");
        } else {
            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, show transmit menu");
            contextMenu.add(i, 111, 0, view.getContext().getString(C25738R.string.dr1));
        }
        AppMethodBeat.m2505o(33021);
        return true;
    }
}
