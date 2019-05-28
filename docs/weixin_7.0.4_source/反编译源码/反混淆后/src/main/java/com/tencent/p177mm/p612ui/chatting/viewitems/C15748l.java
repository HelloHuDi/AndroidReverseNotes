package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.viewitems.C15717ad.C15715c;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.l */
public final class C15748l {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.l$b */
    public static final class C15749b extends C5378c {
        private C46650a yJI;
        private final long zdV = 259200000;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.l$b$2 */
        class C157502 implements OnClickListener {
            C157502() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 268435505) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32954);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969052);
                view.setTag(new C15752a().mo27965eW(view));
            }
            AppMethodBeat.m2505o(32954);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32955);
            C15752a c15752a = (C15752a) c5379a;
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57030bg(c7620bi);
            C8910b c8910b = null;
            String str2 = c7620bi.field_content;
            if (c46650a.dFx()) {
                int indexOf = c7620bi.field_content.indexOf(58);
                if (indexOf != -1) {
                    str2 = c7620bi.field_content.substring(indexOf + 1);
                }
            }
            if (str2 != null) {
                c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
            }
            if (c8910b != null) {
                C40439f dX = C46494g.m87742dX(c8910b.appId, c8910b.axy);
                if (dX != null) {
                    C5378c.m8138b(c46650a, c8910b, c7620bi);
                }
                str2 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? c8910b.appName : dX.field_appName;
                if (c8910b.appId == null || c8910b.appId.length() <= 0 || !C46494g.m87743dg(str2)) {
                    c15752a.moL.setVisibility(8);
                } else {
                    c15752a.moL.setText(C46494g.m87733b(c46650a.yTx.getContext(), dX, str2));
                    c15752a.moL.setVisibility(0);
                    if (dX == null || !dX.mo63847xy()) {
                        C5378c.m8126a(c46650a, (View) c15752a.moL, c8910b.appId);
                    } else {
                        C5378c.m8124a(c46650a, (View) c15752a.moL, c7620bi, c8910b, dX.field_packageName, c7620bi.field_msgSvrId);
                    }
                    C5378c.m8130a(c46650a, c15752a.moL, c8910b.appId);
                }
                if (c8910b.dJv == null || c8910b.dJv.length() == 0) {
                    c15752a.zbU.setVisibility(8);
                } else {
                    c15752a.zbU.setVisibility(0);
                    mo11018b(c46650a, (View) c15752a.zbU, (Object) C40814ay.arL(c8910b.dJv));
                }
                switch (c8910b.type) {
                    case 2:
                        c15752a.mOX.setVisibility(0);
                        C30065b aiE = C14877am.aUq().aiE(c8910b.csD);
                        String str3 = c7620bi.field_imgPath;
                        Boolean bool = Boolean.FALSE;
                        if (aiE != null) {
                            str3 = aiE.field_fileFullPath;
                            bool = Boolean.TRUE;
                        }
                        if (!C32291o.ahl().mo73098a(c15752a.mOX, str3, bool.booleanValue(), C1338a.getDensity(c46650a.yTx.getContext()), c8910b.fgH, c8910b.fgG, c15752a.mPb, (int) C25738R.drawable.f6539hj, 1, null)) {
                            if (this.kuU) {
                                c15752a.mOX.setImageResource(C1318a.chatfrom_bg_pic);
                            } else {
                                c15752a.mOX.setImageBitmap(BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.f6539hj));
                            }
                            final C15752a c15752a2 = c15752a;
                            c15752a.mOX.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(32952);
                                    c15752a2.mOX.setLayoutParams(new LayoutParams(-2, -2));
                                    c15752a2.mPb.setLayoutParams(new LayoutParams(c15752a2.mOX.getWidth(), c15752a2.mOX.getHeight()));
                                    AppMethodBeat.m2505o(32952);
                                }
                            });
                            break;
                        }
                        break;
                }
                if (c46650a.dFx()) {
                    c15752a.zdU.setVisibility(8);
                } else if (C46494g.m87749h(dX)) {
                    c15752a.zdU.setVisibility(0);
                    c15752a.zbU.setVisibility(8);
                    C5378c.m8140c(c46650a, c15752a.zdU, C40814ay.m70729a(c8910b, c7620bi));
                } else {
                    c15752a.zdU.setVisibility(8);
                }
            }
            c15752a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c15752a.jPL.setOnClickListener(mo11022d(c46650a));
            if (this.kuU) {
                c15752a.jPL.setOnLongClickListener(mo11021c(c46650a));
                c15752a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            }
            AppMethodBeat.m2505o(32955);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32956);
            if (view == null || c7620bi == null) {
                AppMethodBeat.m2505o(32956);
            } else {
                int i = ((C40814ay) view.getTag()).position;
                C4733l.aiL(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                if (C46494g.m87750i(C46494g.m87739bT(C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend)).appId, false))) {
                    contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
                }
                if (C25985d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dcq));
                }
                C9321dq c9321dq = new C9321dq();
                c9321dq.cxc.cvx = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c9321dq);
                boolean o = C46494g.m87754o(this.yJI.yTx.getContext(), 2);
                if (c9321dq.cxd.cwB || o) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                }
                if (c7620bi.field_status != 5) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(C25738R.string.al9));
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
                if (C1831bh.m3770o(c7620bi)) {
                    contextMenu.clear();
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                }
                AppMethodBeat.m2505o(32956);
            }
            return true;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32958);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C8910b c8910b = null;
                String b = C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend);
                if (b != null) {
                    c8910b = C8910b.m16064me(b);
                }
                if (c8910b == null) {
                    C4990ab.m7412e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
                    AppMethodBeat.m2505o(32958);
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
                C40439f bT = C46494g.m87739bT(c8910b.appId, true);
                if (bT != null && bT.mo63847xy()) {
                    C5378c.m8132a(c46650a, c8910b, C5378c.m8141d(c46650a, c7620bi), bT, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
                }
                String str;
                if (c8910b.csD != null && c8910b.csD.length() > 0) {
                    C30065b aiE = C14877am.aUq().aiE(c8910b.csD);
                    long j;
                    if (aiE != null && aiE.bCR()) {
                        b = aiE.field_fileFullPath;
                        if (!C5730e.m8628ct(b)) {
                            C4990ab.m7417i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", b, Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
                            Intent intent = new Intent();
                            intent.setClassName(c46650a.yTx.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                            intent.putExtra("clean_view_type", 1);
                            c46650a.startActivity(intent);
                            AppMethodBeat.m2505o(32958);
                            return true;
                        } else if (b == null || b.equals("") || !C5730e.m8628ct(b)) {
                            C4990ab.m7410d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
                        } else {
                            String str2;
                            int i2;
                            Bundle bundle;
                            j = c7620bi.field_msgId;
                            long j2 = c7620bi.field_msgSvrId;
                            str = c7620bi.field_talker;
                            Intent intent2 = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
                            intent2.putExtra("img_gallery_msg_id", j);
                            intent2.putExtra("img_gallery_talker", str);
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", i);
                            intent2.putExtra("img_gallery_height", height);
                            String talkerUserName = this.yJI.getTalkerUserName();
                            String b2 = mo11017b(this.yJI, c7620bi);
                            Bundle bundle2 = new Bundle();
                            if (this.yJI.dFx()) {
                                str2 = "stat_scene";
                                i2 = 2;
                                bundle = bundle2;
                            } else {
                                str2 = "stat_scene";
                                if (C1855t.m3913mZ(talkerUserName)) {
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
                    } else if (c7620bi.field_isSend == 0) {
                        j = c7620bi.field_msgId;
                        Intent intent3 = new Intent();
                        intent3.setClassName(this.yJI.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent3.putExtra("app_msg_id", j);
                        this.yJI.startActivity(intent3);
                    }
                } else if (c8910b.url != null && c8910b.url.length() > 0) {
                    String str3;
                    int i3;
                    str = C35799p.m58684B(c8910b.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    PackageInfo packageInfo = C5378c.getPackageInfo(c46650a.yTx.getContext(), c8910b.appId);
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
                    mo11008a(c46650a, str, str, str3, i3, c8910b.appId, false, c7620bi.field_msgId, c7620bi.field_msgSvrId, c7620bi);
                }
                AppMethodBeat.m2505o(32958);
                return true;
            }
            C23639t.m36492hO(c46650a.yTx.getContext());
            AppMethodBeat.m2505o(32958);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, final C7620bi c7620bi) {
            C8910b me;
            String str = null;
            AppMethodBeat.m2504i(32957);
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                me = C8910b.m16064me(str2);
            } else {
                me = null;
            }
            switch (menuItem.getItemId()) {
                case 111:
                    if (!(me == null || me.csD == null || me.csD.length() <= 0)) {
                        C30065b aiE = C14877am.aUq().aiE(me.csD);
                        if (aiE != null) {
                            str = aiE.field_fileFullPath;
                        }
                    }
                    if (!c7620bi.dtH()) {
                        boolean z;
                        if (System.currentTimeMillis() - c7620bi.field_createTime <= 259200000 || (!C5046bo.isNullOrNil(str) && C5730e.m8628ct(str))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            new C7306ak().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(32953);
                                    C4733l.m7095a(c7620bi, null);
                                    AppMethodBeat.m2505o(32953);
                                }
                            });
                            Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Msg_content", C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                            intent.putExtra("Retr_Msg_Type", 16);
                            intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                            c46650a.startActivity(intent);
                            AppMethodBeat.m2505o(32957);
                            break;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
                    C30379h.m48438a(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.cdi), c46650a.yTx.getContext().getString(C25738R.string.f9238tz), new C157502());
                    AppMethodBeat.m2505o(32957);
                    break;
                case 131:
                    C15748l.m24071a(c46650a, menuItem, c7620bi);
                    AppMethodBeat.m2505o(32957);
                    break;
                default:
                    AppMethodBeat.m2505o(32957);
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.l$a */
    static class C15752a extends C5379a {
        protected ImageView mOX;
        protected ImageView mPb;
        protected View mlI;
        protected TextView moL;
        protected TextView zbU;
        protected TextView zdT;
        protected ImageView zdU;

        C15752a() {
        }

        /* renamed from: eW */
        public final C15752a mo27965eW(View view) {
            AppMethodBeat.m2504i(32951);
            super.mo11031eP(view);
            this.mOX = (ImageView) view.findViewById(2131822536);
            this.moL = (TextView) view.findViewById(2131822543);
            this.zdT = (TextView) view.findViewById(2131822663);
            this.mlI = view.findViewById(2131822662);
            this.zbU = (TextView) view.findViewById(2131822454);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.zdU = (ImageView) view.findViewById(2131822558);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.mPb = (ImageView) view.findViewById(2131822553);
            AppMethodBeat.m2505o(32951);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.l$c */
    public static class C15753c extends C5378c implements C5365n {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 268435505) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32960);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969089);
                view.setTag(new C15752a().mo27965eW(view));
            }
            AppMethodBeat.m2505o(32960);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32961);
            c5379a = (C15752a) c5379a;
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57030bg(c7620bi);
            C8910b c8910b = null;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
            }
            if (c8910b != null) {
                C40439f dX = C46494g.m87742dX(c8910b.appId, c8910b.axy);
                String str3 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? c8910b.appName : dX.field_appName;
                if (c8910b.appId == null || c8910b.appId.length() <= 0 || !C46494g.m87743dg(str3)) {
                    c5379a.moL.setVisibility(8);
                } else {
                    c5379a.moL.setText(C46494g.m87733b(c46650a.yTx.getContext(), dX, str3));
                    c5379a.moL.setVisibility(0);
                    if (dX == null || !dX.mo63847xy()) {
                        C5378c.m8126a(c46650a, (View) c5379a.moL, c8910b.appId);
                    } else {
                        C5378c.m8124a(c46650a, (View) c5379a.moL, c7620bi, c8910b, dX.field_packageName, c7620bi.field_msgSvrId);
                    }
                    C5378c.m8130a(c46650a, c5379a.moL, c8910b.appId);
                }
                switch (c8910b.type) {
                    case 2:
                        c5379a.mOX.setVisibility(0);
                        C30065b aiE = C14877am.aUq().aiE(c8910b.csD);
                        String str4 = c7620bi.field_imgPath;
                        Boolean bool = Boolean.FALSE;
                        if (aiE != null) {
                            str4 = aiE.field_fileFullPath;
                            bool = Boolean.TRUE;
                        }
                        if (!C32291o.ahl().mo73098a(c5379a.mOX, str4, bool.booleanValue(), C1338a.getDensity(c46650a.yTx.getContext()), c8910b.fgJ, c8910b.fgI, c5379a.mPb, (int) C25738R.drawable.f6539hj, 0, null)) {
                            if (this.kuU) {
                                c5379a.mOX.setImageResource(C1318a.chatfrom_bg_pic);
                            } else {
                                c5379a.mOX.setImageBitmap(BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.f6539hj));
                            }
                            final C5379a c5379a2 = c5379a;
                            c5379a.mOX.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(32959);
                                    c5379a2.mOX.setLayoutParams(new LayoutParams(-2, -2));
                                    c5379a2.mPb.setLayoutParams(new LayoutParams(c5379a2.mOX.getWidth(), c5379a2.mOX.getHeight()));
                                    AppMethodBeat.m2505o(32959);
                                }
                            });
                            break;
                        }
                        break;
                }
            }
            c5379a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            if (this.kuU) {
                c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
                c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            }
            int aiL = C4733l.aiL(str2);
            if (aiL == -1 || aiL >= 100 || c8910b.fgo <= 0 || c7620bi.field_status == 5) {
                c5379a.mlI.setVisibility(8);
                c5379a.mOX.setAlpha(255);
                c5379a.mOX.setBackgroundDrawable(null);
            } else {
                c5379a.mlI.setVisibility(0);
                c5379a.zdT.setText(aiL + "%");
                c5379a.mOX.setAlpha(64);
                c5379a.mOX.setBackgroundResource(C25738R.drawable.anp);
            }
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(32961);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32962);
            if (view == null) {
                C4990ab.m7412e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
                AppMethodBeat.m2505o(32962);
                return false;
            }
            C40814ay c40814ay = (C40814ay) view.getTag();
            if (c40814ay == null) {
                C4990ab.m7412e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
                AppMethodBeat.m2505o(32962);
                return false;
            }
            int i = c40814ay.position;
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me != null && C46494g.m87750i(C46494g.m87739bT(me.appId, false))) {
                contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
            }
            if (C25985d.afj("favorite")) {
                contextMenu.add(i, 116, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dcq));
            }
            C9321dq c9321dq = new C9321dq();
            c9321dq.cxc.cvx = c7620bi.field_msgId;
            C4879a.xxA.mo10055m(c9321dq);
            boolean o = C46494g.m87754o(this.yJI.yTx.getContext(), 2);
            if (c9321dq.cxd.cwB || o) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
            }
            if (c7620bi.field_status != 5) {
                int width;
                int height;
                MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(C25738R.string.al9));
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
            if (!c7620bi.drC() && c7620bi.dtA() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32962);
            return true;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32964);
            C9638aw.m17190ZK();
            if (!C18628c.isSDCardAvailable()) {
                C23639t.m36492hO(c46650a.yTx.getContext());
                AppMethodBeat.m2505o(32964);
                return true;
            } else if (view == null) {
                AppMethodBeat.m2505o(32964);
                return true;
            } else {
                view.getTag();
                C8910b c8910b = null;
                String str = c7620bi.field_content;
                if (str != null) {
                    c8910b = C8910b.m16064me(str);
                }
                if (c8910b == null) {
                    C4990ab.m7412e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
                    AppMethodBeat.m2505o(32964);
                    return true;
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                C40439f bT = C46494g.m87739bT(c8910b.appId, false);
                if (bT != null) {
                    C5378c.m8132a(c46650a, c8910b, C1853r.m3846Yz(), bT, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
                }
                String str2;
                if (c8910b.csD != null && c8910b.csD.length() > 0) {
                    C30065b aiE = C14877am.aUq().aiE(c8910b.csD);
                    if (aiE != null) {
                        C9638aw.m17190ZK();
                        if (!C18628c.isSDCardAvailable()) {
                            C23639t.m36492hO(c46650a.yTx.getContext());
                        } else if (c7620bi.field_isSend == 1) {
                            str = aiE.field_fileFullPath;
                            if (!C5730e.m8628ct(str)) {
                                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
                                Intent intent = new Intent();
                                intent.setClassName(c46650a.yTx.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                                intent.putExtra("clean_view_type", 1);
                                c46650a.startActivity(intent);
                                AppMethodBeat.m2505o(32964);
                                return true;
                            } else if (str == null || str.equals("") || !C5730e.m8628ct(str)) {
                                C4990ab.m7410d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
                            } else {
                                String str3;
                                int i;
                                Bundle bundle;
                                long j = c7620bi.field_msgId;
                                long j2 = c7620bi.field_msgSvrId;
                                str2 = c7620bi.field_talker;
                                Intent intent2 = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
                                intent2.putExtra("img_gallery_msg_id", j);
                                intent2.putExtra("img_gallery_talker", str2);
                                intent2.putExtra("img_gallery_left", iArr[0]);
                                intent2.putExtra("img_gallery_top", iArr[1]);
                                intent2.putExtra("img_gallery_width", width);
                                intent2.putExtra("img_gallery_height", height);
                                String talkerUserName = this.yJI.getTalkerUserName();
                                String b = mo11017b(this.yJI, c7620bi);
                                Bundle bundle2 = new Bundle();
                                if (this.yJI.dFx()) {
                                    str3 = "stat_scene";
                                    i = 2;
                                    bundle = bundle2;
                                } else {
                                    str3 = "stat_scene";
                                    if (C1855t.m3913mZ(talkerUserName)) {
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
                        AppMethodBeat.m2505o(32964);
                        return true;
                    }
                } else if (c8910b.url != null && c8910b.url.length() > 0) {
                    String str4;
                    int i2;
                    str2 = C35799p.m58684B(c8910b.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    PackageInfo packageInfo = C5378c.getPackageInfo(c46650a.yTx.getContext(), c8910b.appId);
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
                    mo11008a(c46650a, str2, str2, str4, i2, c8910b.appId, false, c7620bi.field_msgId, c7620bi.field_msgSvrId, c7620bi);
                }
                AppMethodBeat.m2505o(32964);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32965);
            if (c7620bi.bAA()) {
                C4733l.m7097al(c7620bi);
                C1829bf.m3748fm(c7620bi.field_msgId);
                c46650a.mo74882qp(true);
                AppMethodBeat.m2505o(32965);
                return;
            }
            AppMethodBeat.m2505o(32965);
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            C8910b me;
            String str = null;
            AppMethodBeat.m2504i(32963);
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                me = C8910b.m16064me(str2);
            } else {
                me = null;
            }
            switch (menuItem.getItemId()) {
                case 111:
                    if (!(me == null || me.csD == null || me.csD.length() <= 0)) {
                        C30065b aiE = C14877am.aUq().aiE(me.csD);
                        if (aiE != null) {
                            str = aiE.field_fileFullPath;
                        }
                    }
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", c7620bi.field_content);
                    intent.putExtra("Retr_File_Name", str);
                    intent.putExtra("Retr_Msg_Type", 16);
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(32963);
                    break;
                case 131:
                    C15748l.m24071a(c46650a, menuItem, c7620bi);
                    AppMethodBeat.m2505o(32963);
                    break;
                default:
                    AppMethodBeat.m2505o(32963);
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
    /* renamed from: a */
    static /* synthetic */ boolean m24071a(C46650a c46650a, MenuItem menuItem, C7620bi c7620bi) {
        AppMethodBeat.m2504i(32966);
        switch (menuItem.getItemId()) {
            case 131:
                C4990ab.m7416i("MicroMsg.ChattingItemAppMsgImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    C4990ab.m7412e("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    AppMethodBeat.m2505o(32966);
                    return true;
                }
                Object obj;
                C25822e c25822e;
                C25822e fI;
                String q;
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = new int[]{intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (!c46650a.dFw()) {
                    if (!((C36135d) c46650a.mo74857aF(C36135d.class)).dDn()) {
                        obj = null;
                        if (obj != null) {
                            str = c7620bi.field_talker;
                        }
                        c25822e = null;
                        if (c7620bi.field_msgId > 0) {
                            c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                        }
                        if ((c25822e != null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                            fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                        } else {
                            fI = c25822e;
                        }
                        q = fI != null ? "" : C32291o.ahl().mo73118q(fI.fDz, "", "");
                        if (fI != null || fI.status == -1 || c7620bi.field_status == 5) {
                            C4990ab.m7413e("MicroMsg.ChattingItemAppMsgImg", "raw img not get successfully ,msgId:%s", Long.valueOf(c7620bi.field_msgId));
                        } else {
                            C4990ab.m7417i("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(c7620bi.field_msgId), q);
                            C15715c.m24015a(c46650a, c7620bi, c7620bi.field_msgId, c7620bi.field_msgSvrId, c7620bi.field_talker, str, iArr, intExtra, intExtra2, true);
                        }
                        AppMethodBeat.m2505o(32966);
                        return true;
                    }
                }
                obj = 1;
                if (obj != null) {
                }
                c25822e = null;
                if (c7620bi.field_msgId > 0) {
                }
                if (c25822e != null) {
                    break;
                }
                fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                if (fI != null) {
                }
                if (fI != null) {
                    break;
                }
                C4990ab.m7413e("MicroMsg.ChattingItemAppMsgImg", "raw img not get successfully ,msgId:%s", Long.valueOf(c7620bi.field_msgId));
                AppMethodBeat.m2505o(32966);
                return true;
            default:
                AppMethodBeat.m2505o(32966);
                return false;
        }
    }
}
