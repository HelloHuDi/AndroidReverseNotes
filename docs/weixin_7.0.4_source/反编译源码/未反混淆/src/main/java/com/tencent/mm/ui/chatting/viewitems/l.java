package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.e;

public final class l {

    public static final class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private final long zdV = 259200000;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 268435505) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32954);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m6);
                view.setTag(new a().eW(view));
            }
            AppMethodBeat.o(32954);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(32955);
            a aVar3 = (a) aVar;
            this.yJI = aVar2;
            ((j) aVar2.aF(j.class)).bg(biVar);
            com.tencent.mm.af.j.b bVar = null;
            String str2 = biVar.field_content;
            if (aVar2.dFx()) {
                int indexOf = biVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    str2 = biVar.field_content.substring(indexOf + 1);
                }
            }
            if (str2 != null) {
                bVar = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            }
            if (bVar != null) {
                f dX = g.dX(bVar.appId, bVar.axy);
                if (dX != null) {
                    c.b(aVar2, bVar, biVar);
                }
                str2 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? bVar.appName : dX.field_appName;
                if (bVar.appId == null || bVar.appId.length() <= 0 || !g.dg(str2)) {
                    aVar3.moL.setVisibility(8);
                } else {
                    aVar3.moL.setText(g.b(aVar2.yTx.getContext(), dX, str2));
                    aVar3.moL.setVisibility(0);
                    if (dX == null || !dX.xy()) {
                        c.a(aVar2, (View) aVar3.moL, bVar.appId);
                    } else {
                        c.a(aVar2, (View) aVar3.moL, biVar, bVar, dX.field_packageName, biVar.field_msgSvrId);
                    }
                    c.a(aVar2, aVar3.moL, bVar.appId);
                }
                if (bVar.dJv == null || bVar.dJv.length() == 0) {
                    aVar3.zbU.setVisibility(8);
                } else {
                    aVar3.zbU.setVisibility(0);
                    b(aVar2, (View) aVar3.zbU, (Object) ay.arL(bVar.dJv));
                }
                switch (bVar.type) {
                    case 2:
                        aVar3.mOX.setVisibility(0);
                        com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(bVar.csD);
                        String str3 = biVar.field_imgPath;
                        Boolean bool = Boolean.FALSE;
                        if (aiE != null) {
                            str3 = aiE.field_fileFullPath;
                            bool = Boolean.TRUE;
                        }
                        if (!o.ahl().a(aVar3.mOX, str3, bool.booleanValue(), com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), bVar.fgH, bVar.fgG, aVar3.mPb, (int) R.drawable.hj, 1, null)) {
                            if (this.kuU) {
                                aVar3.mOX.setImageResource(R.raw.chatfrom_bg_pic);
                            } else {
                                aVar3.mOX.setImageBitmap(BitmapFactory.decodeResource(aVar2.yTx.getMMResources(), R.drawable.hj));
                            }
                            final a aVar4 = aVar3;
                            aVar3.mOX.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(32952);
                                    aVar4.mOX.setLayoutParams(new LayoutParams(-2, -2));
                                    aVar4.mPb.setLayoutParams(new LayoutParams(aVar4.mOX.getWidth(), aVar4.mOX.getHeight()));
                                    AppMethodBeat.o(32952);
                                }
                            });
                            break;
                        }
                        break;
                }
                if (aVar2.dFx()) {
                    aVar3.zdU.setVisibility(8);
                } else if (g.h(dX)) {
                    aVar3.zdU.setVisibility(0);
                    aVar3.zbU.setVisibility(8);
                    c.c(aVar2, aVar3.zdU, ay.a(bVar, biVar));
                } else {
                    aVar3.zdU.setVisibility(8);
                }
            }
            aVar3.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            aVar3.jPL.setOnClickListener(d(aVar2));
            if (this.kuU) {
                aVar3.jPL.setOnLongClickListener(c(aVar2));
                aVar3.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            }
            AppMethodBeat.o(32955);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32956);
            if (view == null || biVar == null) {
                AppMethodBeat.o(32956);
            } else {
                int i = ((ay) view.getTag()).position;
                com.tencent.mm.pluginsdk.model.app.l.aiL(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
                if (g.i(g.bT(com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend)).appId, false))) {
                    contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
                }
                if (d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(R.string.dcq));
                }
                dq dqVar = new dq();
                dqVar.cxc.cvx = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                boolean o = g.o(this.yJI.yTx.getContext(), 2);
                if (dqVar.cxd.cwB || o) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                }
                if (biVar.field_status != 5) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(R.string.al9));
                    int[] iArr = new int[2];
                    if (view != null) {
                        width = view.getWidth();
                        height = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        height = 0;
                        width = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    add.setIntent(intent);
                }
                if (bh.o(biVar)) {
                    contextMenu.clear();
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                }
                AppMethodBeat.o(32956);
            }
            return true;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32958);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.af.j.b bVar = null;
                String b = bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend);
                if (b != null) {
                    bVar = com.tencent.mm.af.j.b.me(b);
                }
                if (bVar == null) {
                    ab.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
                    AppMethodBeat.o(32958);
                    return true;
                }
                int height;
                int i;
                int[] iArr = new int[2];
                if (view != null) {
                    view.getLocationInWindow(iArr);
                    int width = view.getWidth();
                    height = view.getHeight();
                    i = width;
                } else {
                    height = 0;
                    i = 0;
                }
                f bT = g.bT(bVar.appId, true);
                if (bT != null && bT.xy()) {
                    c.a(aVar, bVar, c.d(aVar, biVar), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
                }
                String str;
                if (bVar.csD != null && bVar.csD.length() > 0) {
                    com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(bVar.csD);
                    long j;
                    if (aiE != null && aiE.bCR()) {
                        b = aiE.field_fileFullPath;
                        if (!e.ct(b)) {
                            ab.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", b, Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
                            Intent intent = new Intent();
                            intent.setClassName(aVar.yTx.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                            intent.putExtra("clean_view_type", 1);
                            aVar.startActivity(intent);
                            AppMethodBeat.o(32958);
                            return true;
                        } else if (b == null || b.equals("") || !e.ct(b)) {
                            ab.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
                        } else {
                            String str2;
                            int i2;
                            Bundle bundle;
                            j = biVar.field_msgId;
                            long j2 = biVar.field_msgSvrId;
                            str = biVar.field_talker;
                            Intent intent2 = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
                            intent2.putExtra("img_gallery_msg_id", j);
                            intent2.putExtra("img_gallery_talker", str);
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", i);
                            intent2.putExtra("img_gallery_height", height);
                            String talkerUserName = this.yJI.getTalkerUserName();
                            String b2 = b(this.yJI, biVar);
                            Bundle bundle2 = new Bundle();
                            if (this.yJI.dFx()) {
                                str2 = "stat_scene";
                                i2 = 2;
                                bundle = bundle2;
                            } else {
                                str2 = "stat_scene";
                                if (t.mZ(talkerUserName)) {
                                    i2 = 7;
                                    bundle = bundle2;
                                } else {
                                    i2 = 1;
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str2, i2);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                            bundle2.putString("stat_chat_talker_username", talkerUserName);
                            bundle2.putString("stat_send_msg_user", b2);
                            intent2.putExtra("_stat_obj", bundle2);
                            this.yJI.startActivity(intent2);
                        }
                    } else if (biVar.field_isSend == 0) {
                        j = biVar.field_msgId;
                        Intent intent3 = new Intent();
                        intent3.setClassName(this.yJI.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent3.putExtra("app_msg_id", j);
                        this.yJI.startActivity(intent3);
                    }
                } else if (bVar.url != null && bVar.url.length() > 0) {
                    String str3;
                    int i3;
                    str = p.B(bVar.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    PackageInfo packageInfo = c.getPackageInfo(aVar.yTx.getContext(), bVar.appId);
                    if (packageInfo == null) {
                        str3 = null;
                    } else {
                        str3 = packageInfo.versionName;
                    }
                    if (packageInfo == null) {
                        i3 = 0;
                    } else {
                        i3 = packageInfo.versionCode;
                    }
                    a(aVar, str, str, str3, i3, bVar.appId, false, biVar.field_msgId, biVar.field_msgSvrId, biVar);
                }
                AppMethodBeat.o(32958);
                return true;
            }
            com.tencent.mm.ui.base.t.hO(aVar.yTx.getContext());
            AppMethodBeat.o(32958);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, final bi biVar) {
            com.tencent.mm.af.j.b me;
            String str = null;
            AppMethodBeat.i(32957);
            String str2 = biVar.field_content;
            if (str2 != null) {
                me = com.tencent.mm.af.j.b.me(str2);
            } else {
                me = null;
            }
            switch (menuItem.getItemId()) {
                case 111:
                    if (!(me == null || me.csD == null || me.csD.length() <= 0)) {
                        com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                        if (aiE != null) {
                            str = aiE.field_fileFullPath;
                        }
                    }
                    if (!biVar.dtH()) {
                        boolean z;
                        if (System.currentTimeMillis() - biVar.field_createTime <= 259200000 || (!bo.isNullOrNil(str) && e.ct(str))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            new ak().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(32953);
                                    com.tencent.mm.pluginsdk.model.app.l.a(biVar, null);
                                    AppMethodBeat.o(32953);
                                }
                            });
                            Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Msg_content", bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend));
                            intent.putExtra("Retr_Msg_Type", 16);
                            intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                            aVar.startActivity(intent);
                            AppMethodBeat.o(32957);
                            break;
                        }
                    }
                    ab.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
                    com.tencent.mm.ui.base.h.a(aVar.yTx.getContext(), aVar.yTx.getContext().getString(R.string.cdi), aVar.yTx.getContext().getString(R.string.tz), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(32957);
                    break;
                case 131:
                    l.a(aVar, menuItem, biVar);
                    AppMethodBeat.o(32957);
                    break;
                default:
                    AppMethodBeat.o(32957);
                    break;
            }
            return false;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        protected ImageView mOX;
        protected ImageView mPb;
        protected View mlI;
        protected TextView moL;
        protected TextView zbU;
        protected TextView zdT;
        protected ImageView zdU;

        a() {
        }

        public final a eW(View view) {
            AppMethodBeat.i(32951);
            super.eP(view);
            this.mOX = (ImageView) view.findViewById(R.id.apt);
            this.moL = (TextView) view.findViewById(R.id.aq0);
            this.zdT = (TextView) view.findViewById(R.id.at9);
            this.mlI = view.findViewById(R.id.at8);
            this.zbU = (TextView) view.findViewById(R.id.anl);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.zdU = (ImageView) view.findViewById(R.id.aqe);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.mPb = (ImageView) view.findViewById(R.id.aq_);
            AppMethodBeat.o(32951);
            return this;
        }
    }

    public static class c extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 268435505) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32960);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n5);
                view.setTag(new a().eW(view));
            }
            AppMethodBeat.o(32960);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(32961);
            aVar = (a) aVar;
            this.yJI = aVar2;
            ((j) aVar2.aF(j.class)).bg(biVar);
            com.tencent.mm.af.j.b bVar = null;
            String str2 = biVar.field_content;
            if (str2 != null) {
                bVar = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            }
            if (bVar != null) {
                f dX = g.dX(bVar.appId, bVar.axy);
                String str3 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? bVar.appName : dX.field_appName;
                if (bVar.appId == null || bVar.appId.length() <= 0 || !g.dg(str3)) {
                    aVar.moL.setVisibility(8);
                } else {
                    aVar.moL.setText(g.b(aVar2.yTx.getContext(), dX, str3));
                    aVar.moL.setVisibility(0);
                    if (dX == null || !dX.xy()) {
                        c.a(aVar2, (View) aVar.moL, bVar.appId);
                    } else {
                        c.a(aVar2, (View) aVar.moL, biVar, bVar, dX.field_packageName, biVar.field_msgSvrId);
                    }
                    c.a(aVar2, aVar.moL, bVar.appId);
                }
                switch (bVar.type) {
                    case 2:
                        aVar.mOX.setVisibility(0);
                        com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(bVar.csD);
                        String str4 = biVar.field_imgPath;
                        Boolean bool = Boolean.FALSE;
                        if (aiE != null) {
                            str4 = aiE.field_fileFullPath;
                            bool = Boolean.TRUE;
                        }
                        if (!o.ahl().a(aVar.mOX, str4, bool.booleanValue(), com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), bVar.fgJ, bVar.fgI, aVar.mPb, (int) R.drawable.hj, 0, null)) {
                            if (this.kuU) {
                                aVar.mOX.setImageResource(R.raw.chatfrom_bg_pic);
                            } else {
                                aVar.mOX.setImageBitmap(BitmapFactory.decodeResource(aVar2.yTx.getMMResources(), R.drawable.hj));
                            }
                            final com.tencent.mm.ui.chatting.viewitems.c.a aVar3 = aVar;
                            aVar.mOX.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(32959);
                                    aVar3.mOX.setLayoutParams(new LayoutParams(-2, -2));
                                    aVar3.mPb.setLayoutParams(new LayoutParams(aVar3.mOX.getWidth(), aVar3.mOX.getHeight()));
                                    AppMethodBeat.o(32959);
                                }
                            });
                            break;
                        }
                        break;
                }
            }
            aVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            aVar.jPL.setOnClickListener(d(aVar2));
            if (this.kuU) {
                aVar.jPL.setOnLongClickListener(c(aVar2));
                aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            }
            int aiL = com.tencent.mm.pluginsdk.model.app.l.aiL(str2);
            if (aiL == -1 || aiL >= 100 || bVar.fgo <= 0 || biVar.field_status == 5) {
                aVar.mlI.setVisibility(8);
                aVar.mOX.setAlpha(255);
                aVar.mOX.setBackgroundDrawable(null);
            } else {
                aVar.mlI.setVisibility(0);
                aVar.zdT.setText(aiL + "%");
                aVar.mOX.setAlpha(64);
                aVar.mOX.setBackgroundResource(R.drawable.anp);
            }
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            AppMethodBeat.o(32961);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32962);
            if (view == null) {
                ab.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
                AppMethodBeat.o(32962);
                return false;
            }
            ay ayVar = (ay) view.getTag();
            if (ayVar == null) {
                ab.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
                AppMethodBeat.o(32962);
                return false;
            }
            int i = ayVar.position;
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            if (me != null && g.i(g.bT(me.appId, false))) {
                contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(R.string.dr1));
            }
            if (d.afj("favorite")) {
                contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(R.string.dcq));
            }
            dq dqVar = new dq();
            dqVar.cxc.cvx = biVar.field_msgId;
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            boolean o = g.o(this.yJI.yTx.getContext(), 2);
            if (dqVar.cxd.cwB || o) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
            }
            if (biVar.field_status != 5) {
                int width;
                int height;
                MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(R.string.al9));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
            if (!biVar.drC() && biVar.dtA() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            }
            AppMethodBeat.o(32962);
            return true;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32964);
            aw.ZK();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.ui.base.t.hO(aVar.yTx.getContext());
                AppMethodBeat.o(32964);
                return true;
            } else if (view == null) {
                AppMethodBeat.o(32964);
                return true;
            } else {
                view.getTag();
                com.tencent.mm.af.j.b bVar = null;
                String str = biVar.field_content;
                if (str != null) {
                    bVar = com.tencent.mm.af.j.b.me(str);
                }
                if (bVar == null) {
                    ab.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
                    AppMethodBeat.o(32964);
                    return true;
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                f bT = g.bT(bVar.appId, false);
                if (bT != null) {
                    c.a(aVar, bVar, r.Yz(), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
                }
                String str2;
                if (bVar.csD != null && bVar.csD.length() > 0) {
                    com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(bVar.csD);
                    if (aiE != null) {
                        aw.ZK();
                        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                            com.tencent.mm.ui.base.t.hO(aVar.yTx.getContext());
                        } else if (biVar.field_isSend == 1) {
                            str = aiE.field_fileFullPath;
                            if (!e.ct(str)) {
                                ab.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
                                Intent intent = new Intent();
                                intent.setClassName(aVar.yTx.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                                intent.putExtra("clean_view_type", 1);
                                aVar.startActivity(intent);
                                AppMethodBeat.o(32964);
                                return true;
                            } else if (str == null || str.equals("") || !e.ct(str)) {
                                ab.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
                            } else {
                                String str3;
                                int i;
                                Bundle bundle;
                                long j = biVar.field_msgId;
                                long j2 = biVar.field_msgSvrId;
                                str2 = biVar.field_talker;
                                Intent intent2 = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
                                intent2.putExtra("img_gallery_msg_id", j);
                                intent2.putExtra("img_gallery_talker", str2);
                                intent2.putExtra("img_gallery_left", iArr[0]);
                                intent2.putExtra("img_gallery_top", iArr[1]);
                                intent2.putExtra("img_gallery_width", width);
                                intent2.putExtra("img_gallery_height", height);
                                String talkerUserName = this.yJI.getTalkerUserName();
                                String b = b(this.yJI, biVar);
                                Bundle bundle2 = new Bundle();
                                if (this.yJI.dFx()) {
                                    str3 = "stat_scene";
                                    i = 2;
                                    bundle = bundle2;
                                } else {
                                    str3 = "stat_scene";
                                    if (t.mZ(talkerUserName)) {
                                        i = 7;
                                        bundle = bundle2;
                                    } else {
                                        i = 1;
                                        bundle = bundle2;
                                    }
                                }
                                bundle.putInt(str3, i);
                                bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                                bundle2.putString("stat_chat_talker_username", talkerUserName);
                                bundle2.putString("stat_send_msg_user", b);
                                intent2.putExtra("_stat_obj", bundle2);
                                this.yJI.startActivity(intent2);
                            }
                        }
                        AppMethodBeat.o(32964);
                        return true;
                    }
                } else if (bVar.url != null && bVar.url.length() > 0) {
                    String str4;
                    int i2;
                    str2 = p.B(bVar.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    PackageInfo packageInfo = c.getPackageInfo(aVar.yTx.getContext(), bVar.appId);
                    if (packageInfo == null) {
                        str4 = null;
                    } else {
                        str4 = packageInfo.versionName;
                    }
                    if (packageInfo == null) {
                        i2 = 0;
                    } else {
                        i2 = packageInfo.versionCode;
                    }
                    a(aVar, str2, str2, str4, i2, bVar.appId, false, biVar.field_msgId, biVar.field_msgSvrId, biVar);
                }
                AppMethodBeat.o(32964);
                return false;
            }
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32965);
            if (biVar.bAA()) {
                com.tencent.mm.pluginsdk.model.app.l.al(biVar);
                bf.fm(biVar.field_msgId);
                aVar.qp(true);
                AppMethodBeat.o(32965);
                return;
            }
            AppMethodBeat.o(32965);
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            com.tencent.mm.af.j.b me;
            String str = null;
            AppMethodBeat.i(32963);
            String str2 = biVar.field_content;
            if (str2 != null) {
                me = com.tencent.mm.af.j.b.me(str2);
            } else {
                me = null;
            }
            switch (menuItem.getItemId()) {
                case 111:
                    if (!(me == null || me.csD == null || me.csD.length() <= 0)) {
                        com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                        if (aiE != null) {
                            str = aiE.field_fileFullPath;
                        }
                    }
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", biVar.field_content);
                    intent.putExtra("Retr_File_Name", str);
                    intent.putExtra("Retr_Msg_Type", 16);
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(32963);
                    break;
                case 131:
                    l.a(aVar, menuItem, biVar);
                    AppMethodBeat.o(32963);
                    break;
                default:
                    AppMethodBeat.o(32963);
                    break;
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean a(com.tencent.mm.ui.chatting.d.a aVar, MenuItem menuItem, bi biVar) {
        AppMethodBeat.i(32966);
        switch (menuItem.getItemId()) {
            case 131:
                ab.i("MicroMsg.ChattingItemAppMsgImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    ab.e("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    AppMethodBeat.o(32966);
                    return true;
                }
                Object obj;
                com.tencent.mm.at.e eVar;
                com.tencent.mm.at.e fI;
                String q;
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = new int[]{intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (!aVar.dFw()) {
                    if (!((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn()) {
                        obj = null;
                        if (obj != null) {
                            str = biVar.field_talker;
                        }
                        eVar = null;
                        if (biVar.field_msgId > 0) {
                            eVar = o.ahl().fJ(biVar.field_msgId);
                        }
                        if ((eVar != null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                            fI = o.ahl().fI(biVar.field_msgSvrId);
                        } else {
                            fI = eVar;
                        }
                        q = fI != null ? "" : o.ahl().q(fI.fDz, "", "");
                        if (fI != null || fI.status == -1 || biVar.field_status == 5) {
                            ab.e("MicroMsg.ChattingItemAppMsgImg", "raw img not get successfully ,msgId:%s", Long.valueOf(biVar.field_msgId));
                        } else {
                            ab.i("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(biVar.field_msgId), q);
                            com.tencent.mm.ui.chatting.viewitems.ad.c.a(aVar, biVar, biVar.field_msgId, biVar.field_msgSvrId, biVar.field_talker, str, iArr, intExtra, intExtra2, true);
                        }
                        AppMethodBeat.o(32966);
                        return true;
                    }
                }
                obj = 1;
                if (obj != null) {
                }
                eVar = null;
                if (biVar.field_msgId > 0) {
                }
                if (eVar != null) {
                    break;
                }
                fI = o.ahl().fI(biVar.field_msgSvrId);
                if (fI != null) {
                }
                if (fI != null) {
                    break;
                }
                ab.e("MicroMsg.ChattingItemAppMsgImg", "raw img not get successfully ,msgId:%s", Long.valueOf(biVar.field_msgId));
                AppMethodBeat.o(32966);
                return true;
            default:
                AppMethodBeat.o(32966);
                return false;
        }
    }
}
