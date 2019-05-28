package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;

public final class q {

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private c zeg;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 687865905) {
                return false;
            }
            return true;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33009);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mq);
                view.setTag(new d().fb(view));
            }
            AppMethodBeat.o(33009);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33010);
            this.yJI = aVar2;
            d dVar = (d) aVar;
            if (this.zeg == null) {
                this.zeg = new c(this.yJI, this);
            }
            d.a(dVar, i, aVar2, biVar, false, this.zeg, c(aVar2));
            AppMethodBeat.o(33010);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33011);
            boolean a = q.a(this.yJI, contextMenu, view, biVar);
            AppMethodBeat.o(33011);
            return a;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33012);
            if (menuItem.getItemId() == 111) {
                if (com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend)) != null) {
                    h.pYm.e(16979, r0.fiQ, r0.fiO, Integer.valueOf(0), Integer.valueOf(2));
                }
                b.a(aVar, biVar, b(aVar, biVar));
            }
            AppMethodBeat.o(33012);
            return false;
        }
    }

    public static class b extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private c zeg;

        /* Access modifiers changed, original: final */
        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 687865905) {
                return true;
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33013);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.no);
                view.setTag(new d().fb(view));
            }
            AppMethodBeat.o(33013);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33014);
            this.yJI = aVar2;
            com.tencent.mm.ui.chatting.viewitems.c.a aVar3 = (d) aVar;
            if (this.zeg == null) {
                this.zeg = new c(this.yJI, this);
            }
            d.a(aVar3, i, aVar2, biVar, true, this.zeg, c(aVar2));
            a(i, aVar3, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(33014);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33015);
            boolean a = q.a(this.yJI, contextMenu, view, biVar);
            AppMethodBeat.o(33015);
            return a;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33016);
            if (menuItem.getItemId() == 111) {
                if (com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend)) != null) {
                    h.pYm.e(16979, r0.fiQ, r0.fiO, Integer.valueOf(0), Integer.valueOf(2));
                }
                b.a(aVar, biVar, b(aVar, biVar));
            }
            AppMethodBeat.o(33016);
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33017);
            if (biVar.bAA()) {
                l.al(biVar);
                bf.fm(biVar.field_msgId);
                aVar.qp(true);
            }
            AppMethodBeat.o(33017);
        }
    }

    static class d extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public ImageView iYg;
        public TextView moL;
        public ProgressBar progressBar;
        public ImageView zdN;
        public ImageView zeh;

        d() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a fb(View view) {
            AppMethodBeat.i(33019);
            super.eP(view);
            this.zdN = (ImageView) view.findViewById(R.id.aqy);
            this.zeh = (ImageView) view.findViewById(R.id.aq_);
            this.jPL = view.findViewById(R.id.ap9);
            this.iYg = (ImageView) view.findViewById(R.id.ar1);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.moL = (TextView) view.findViewById(R.id.aq0);
            this.progressBar = (ProgressBar) view.findViewById(R.id.atj);
            this.zby = (ImageView) view.findViewById(R.id.asb);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            AppMethodBeat.o(33019);
            return this;
        }

        @SuppressLint({"ResourceType"})
        public static void a(d dVar, int i, com.tencent.mm.ui.chatting.d.a aVar, bi biVar, boolean z, c cVar, com.tencent.mm.ui.chatting.viewitems.c.c cVar2) {
            AppMethodBeat.i(33020);
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
            if (me == null) {
                ab.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
                AppMethodBeat.o(33020);
                return;
            }
            f dX = g.dX(me.appId, me.axy);
            String str = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? me.appName : dX.field_appName;
            if (me.appId == null || me.appId.length() <= 0 || !c.dg(str)) {
                dVar.moL.setVisibility(8);
            } else {
                dVar.moL.setText(g.b(aVar.yTx.getContext(), dX, str));
                dVar.moL.setVisibility(0);
                c.a(aVar, dVar.moL, me.appId);
            }
            dVar.iYg.setImageDrawable(com.tencent.mm.bz.a.g(aVar.yTx.getContext(), R.raw.shortvideo_play_btn));
            if (dVar.progressBar != null) {
                dVar.progressBar.setVisibility(8);
            }
            String c = o.ahl().c(biVar.field_imgPath, false, true);
            ab.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", biVar.field_imgPath, c);
            Bitmap a = o.ahl().a(c, com.tencent.mm.bz.a.getDensity(aVar.yTx.getContext()), aVar.yTx.getContext(), (int) R.drawable.b0p);
            if (a == null || a.isRecycled()) {
                ab.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
                dVar.zeh.setLayoutParams(new LayoutParams(0, 0));
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), 85);
                int al = com.tencent.mm.bz.a.al(aVar.yTx.getContext(), R.dimen.eb);
                dVar.zdN.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.au(aVar.yTx.getContext().getResources().getColor(R.color.rn), fromDPToPix, al), (int) R.drawable.b0p, fromDPToPix, al));
                dVar.zdN.setLayoutParams(new LayoutParams(fromDPToPix, al));
                dVar.zeh.setLayoutParams(new LayoutParams(fromDPToPix, al));
            } else {
                dVar.zdN.setImageBitmap(a);
                dVar.zdN.setLayoutParams(new LayoutParams(a.getWidth(), a.getHeight()));
                dVar.zeh.setLayoutParams(new LayoutParams(a.getWidth(), a.getHeight()));
            }
            if (z) {
                if (biVar.field_status == 5 || biVar.field_status == 2) {
                    if (dVar.progressBar != null) {
                        dVar.progressBar.setVisibility(8);
                    }
                } else if (dVar.progressBar != null) {
                    dVar.progressBar.setVisibility(0);
                }
            }
            dVar.jPL.setTag(new ay(biVar, aVar.dFx(), i, biVar.field_talker, 0));
            dVar.jPL.setOnClickListener(cVar);
            dVar.jPL.setOnLongClickListener(cVar2);
            dVar.jPL.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h) aVar.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCZ());
            h.pYm.e(16979, me.fiQ, me.fiO, Integer.valueOf(0), Integer.valueOf(0));
            com.tencent.mm.modelappbrand.a.b.abR().pC("file://".concat(String.valueOf(c)));
            com.tencent.mm.af.a aVar2 = (com.tencent.mm.af.a) me.X(com.tencent.mm.af.a.class);
            if (!(aVar2 == null || bo.isNullOrNil(aVar2.appThumbUrl))) {
                com.tencent.mm.modelappbrand.a.b.abR().pC(aVar2.appThumbUrl);
            }
            AppMethodBeat.o(33020);
        }
    }

    static class c extends e {
        private c zbA;

        public c(com.tencent.mm.ui.chatting.d.a aVar, c cVar) {
            super(aVar);
            this.zbA = cVar;
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33018);
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
            if (me == null) {
                ab.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
                AppMethodBeat.o(33018);
            } else if (bo.isNullOrNil(me.fiQ) && bo.isNullOrNil(me.fiP)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", p.B(me.url, aVar.dFx() ? "groupmessage" : "singlemessage"));
                intent.putExtra("webpageTitle", me.title);
                intent.putExtra("shortUrl", me.url);
                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(33018);
            } else {
                String str;
                int i;
                Bundle bundle;
                String talkerUserName = aVar.getTalkerUserName();
                String b = this.zbA.b(aVar, biVar);
                Bundle bundle2 = new Bundle();
                if (aVar.dFx()) {
                    str = "stat_scene";
                    i = 2;
                    bundle = bundle2;
                } else {
                    str = "stat_scene";
                    if (t.mZ(talkerUserName)) {
                        i = 7;
                        bundle = bundle2;
                    } else {
                        i = 1;
                        bundle = bundle2;
                    }
                }
                bundle.putInt(str, i);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
                bundle2.putString("stat_chat_talker_username", talkerUserName);
                bundle2.putString("stat_send_msg_user", b);
                f dX = g.dX(me.appId, me.axy);
                String str2 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? me.appName : dX.field_appName;
                bundle2.putString("stat_weishi_app_name", str2);
                bundle2.putString("stat_app_id", me.appId);
                bundle2.putString("stat_weishi_source_username", me.cMg);
                com.tencent.mm.af.a aVar2 = (com.tencent.mm.af.a) me.X(com.tencent.mm.af.a.class);
                String str3 = "stat_weishi_from_opensdk";
                boolean z = aVar2 != null && aVar2.ffp == 1;
                bundle2.putBoolean(str3, z);
                bundle2.putString("stat_weishi_msg_img_path", biVar.field_imgPath);
                bundle2.putString("stat_weishi_thumb_path", o.ahl().c(biVar.field_imgPath, false, true));
                bundle2.putString("stat_weishi_thumb_url", aVar2 != null ? aVar2.appThumbUrl : null);
                h.pYm.e(16979, me.fiQ, me.fiO, Integer.valueOf(0), Integer.valueOf(1));
                ab.i("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, appbrandAppId:%s, appBrandUsername:%s", me.fiQ, me.fiP);
                ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(aVar.yTx.getContext(), talkerUserName, b, aVar.dFx(), me, bundle2);
                AppMethodBeat.o(33018);
            }
        }
    }

    static /* synthetic */ boolean a(com.tencent.mm.ui.chatting.d.a aVar, ContextMenu contextMenu, View view, bi biVar) {
        AppMethodBeat.i(33021);
        int i = ((ay) view.getTag()).position;
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
        if (me == null) {
            ab.w("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, content is null");
        } else if (!g.i(g.bT(me.appId, false)) || j.aA(biVar)) {
            ab.i("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, do not show transmit menu");
        } else {
            ab.i("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, show transmit menu");
            contextMenu.add(i, 111, 0, view.getContext().getString(R.string.dr1));
        }
        AppMethodBeat.o(33021);
        return true;
    }
}
