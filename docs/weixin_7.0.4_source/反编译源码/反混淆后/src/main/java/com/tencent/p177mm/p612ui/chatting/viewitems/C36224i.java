package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.C1244b;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26165ii;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.card.p352b.C38729h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.i */
public final class C36224i {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.i$b */
    public static class C36223b extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || (i != 452984881 && i != 520093745)) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32919);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969061);
                view.setTag(new C36226a().mo57096A(view, true));
            }
            AppMethodBeat.m2505o(32919);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32920);
            this.yJI = c46650a;
            C36226a c36226a = (C36226a) c5379a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (!(c36226a == null || X == null)) {
                c36226a.mo57097a(c46650a.yTx.getContext(), X, c7620bi.field_imgPath, this.kuU);
            }
            C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
            if (c5379a.jPL != null) {
                c5379a.jPL.setTag(c40814ay);
                c5379a.jPL.setOnClickListener(mo11022d(c46650a));
                if (this.kuU) {
                    c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
                    c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                }
            }
            AppMethodBeat.m2505o(32920);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32921);
            int i = ((C40814ay) view.getTag()).position;
            if (c7620bi.field_content == null) {
                AppMethodBeat.m2505o(32921);
                return true;
            }
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me == null) {
                AppMethodBeat.m2505o(32921);
                return true;
            }
            switch (me.type) {
                case 16:
                    if (me.fhD == 5 || me.fhD == 6 || me.fhD == 2) {
                        if (me.fhD != 2) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                        AppMethodBeat.m2505o(32921);
                        return false;
                    }
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                    AppMethodBeat.m2505o(32921);
                    return false;
            }
            AppMethodBeat.m2505o(32921);
            return true;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32922);
            String str;
            C8910b me;
            switch (menuItem.getItemId()) {
                case 103:
                    str = c7620bi.field_content;
                    if (str == null) {
                        AppMethodBeat.m2505o(32922);
                        break;
                    }
                    me = C8910b.m16064me(str);
                    if (me != null) {
                        switch (me.type) {
                            case 16:
                                C26165ii c26165ii = new C26165ii();
                                c26165ii.cDs.cDt = me.cDt;
                                c26165ii.cDs.cuQ = c7620bi.field_msgId;
                                c26165ii.cDs.cDu = c7620bi.field_talker;
                                C4879a.xxA.mo10055m(c26165ii);
                        }
                    }
                case 111:
                    str = C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend);
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", str);
                    me = C8910b.m16064me(str);
                    if (me == null || 16 != me.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(32922);
                    break;
                default:
                    AppMethodBeat.m2505o(32922);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32923);
            String str = c7620bi.field_content;
            if (str == null) {
                AppMethodBeat.m2505o(32923);
                return false;
            }
            C8910b me = C8910b.m16064me(str);
            if (me == null) {
                AppMethodBeat.m2505o(32923);
                return false;
            }
            switch (me.type) {
                case 16:
                    if (C5046bo.isNullOrNil(me.cDt)) {
                        AppMethodBeat.m2505o(32923);
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", me.cDt);
                    intent.putExtra("key_from_scene", me.fhD);
                    C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                    AppMethodBeat.m2505o(32923);
                    return true;
                case 34:
                    C38729h b = C38729h.m65694b(me);
                    if (1 < b.ver) {
                        String str2;
                        int i;
                        String B = C35799p.m58684B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                        PackageInfo packageInfo = C5378c.getPackageInfo(c46650a.yTx.getContext(), me.appId);
                        if (packageInfo == null) {
                            str2 = null;
                        } else {
                            str2 = packageInfo.versionName;
                        }
                        if (packageInfo == null) {
                            i = 0;
                        } else {
                            i = packageInfo.versionCode;
                        }
                        mo11008a(c46650a, B, B, str2, i, me.appId, true, c7620bi.field_msgId, c7620bi.field_msgSvrId, c7620bi);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", mo11017b(c46650a, c7620bi));
                        intent2.putExtra("key_biz_uin", b.fhF);
                        intent2.putExtra("key_order_id", b.fhG);
                        if (!(c7620bi.field_talker == null || c7620bi.field_talker.equals("") || !C1855t.m3896kH(c7620bi.field_talker))) {
                            intent2.putExtra("key_chatroom_name", c7620bi.field_talker);
                        }
                        C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    AppMethodBeat.m2505o(32923);
                    return true;
                default:
                    AppMethodBeat.m2505o(32923);
                    return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.i$c */
    public static class C36225c extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && (i == 452984881 || i == 520093745)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32924);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969098);
                view.setTag(new C36226a().mo57096A(view, false));
            }
            AppMethodBeat.m2505o(32924);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32925);
            this.yJI = c46650a;
            C36226a c36226a = (C36226a) c5379a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (!(c36226a == null || X == null)) {
                c36226a.mo57097a(c46650a.yTx.getContext(), X, c7620bi.field_imgPath, this.kuU);
            }
            c5379a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            if (this.kuU) {
                c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
                c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            }
            AppMethodBeat.m2505o(32925);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32926);
            int i = ((C40814ay) view.getTag()).position;
            if (c7620bi.field_content == null) {
                AppMethodBeat.m2505o(32926);
                return true;
            }
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me == null) {
                AppMethodBeat.m2505o(32926);
                return true;
            }
            switch (me.type) {
                case 16:
                    if (me.fhD == 5 || me.fhD == 6 || me.fhD == 2) {
                        if (me.fhD != 2) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                        AppMethodBeat.m2505o(32926);
                        return false;
                    }
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                    AppMethodBeat.m2505o(32926);
                    return false;
            }
            AppMethodBeat.m2505o(32926);
            return true;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32927);
            String str;
            C8910b me;
            switch (menuItem.getItemId()) {
                case 103:
                    str = c7620bi.field_content;
                    if (str == null) {
                        AppMethodBeat.m2505o(32927);
                        break;
                    }
                    me = C8910b.m16064me(str);
                    if (me != null) {
                        switch (me.type) {
                            case 16:
                                C26165ii c26165ii = new C26165ii();
                                c26165ii.cDs.cDt = me.cDt;
                                c26165ii.cDs.cuQ = c7620bi.field_msgId;
                                c26165ii.cDs.cDu = c7620bi.field_talker;
                                C4879a.xxA.mo10055m(c26165ii);
                        }
                    }
                case 111:
                    str = C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend);
                    Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", str);
                    me = C8910b.m16064me(str);
                    if (me == null || 16 != me.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(32927);
                    break;
                default:
                    AppMethodBeat.m2505o(32927);
                    break;
            }
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32928);
            String str = c7620bi.field_content;
            if (str == null) {
                AppMethodBeat.m2505o(32928);
                return false;
            }
            C8910b me = C8910b.m16064me(str);
            if (me == null) {
                AppMethodBeat.m2505o(32928);
                return false;
            }
            switch (me.type) {
                case 16:
                    if (C5046bo.isNullOrNil(me.cDt)) {
                        AppMethodBeat.m2505o(32928);
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", me.cDt);
                    intent.putExtra("key_from_scene", me.fhD);
                    C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                    AppMethodBeat.m2505o(32928);
                    return true;
                case 34:
                    C38729h b = C38729h.m65694b(me);
                    if (1 < b.ver) {
                        String str2;
                        int i;
                        String B = C35799p.m58684B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                        PackageInfo packageInfo = C5378c.getPackageInfo(c46650a.yTx.getContext(), me.appId);
                        if (packageInfo == null) {
                            str2 = null;
                        } else {
                            str2 = packageInfo.versionName;
                        }
                        if (packageInfo == null) {
                            i = 0;
                        } else {
                            i = packageInfo.versionCode;
                        }
                        mo11008a(c46650a, B, B, str2, i, me.appId, true, c7620bi.field_msgId, c7620bi.field_msgSvrId, c7620bi);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", mo11017b(c46650a, c7620bi));
                        intent2.putExtra("key_biz_uin", b.fhF);
                        intent2.putExtra("key_order_id", b.fhG);
                        if (!(c7620bi.field_talker == null || c7620bi.field_talker.equals("") || !C1855t.m3896kH(c7620bi.field_talker))) {
                            intent2.putExtra("key_chatroom_name", c7620bi.field_talker);
                        }
                        C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    AppMethodBeat.m2505o(32928);
                    return true;
                default:
                    AppMethodBeat.m2505o(32928);
                    return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.i$a */
    static class C36226a extends C5379a {
        public static final int zdB = (((int) C1338a.getDensity(C1244b.cdV.getApplication())) * 64);
        public TextView gnB;
        public TextView gnC;
        public TextView rGU;
        public MMImageView zbI;
        public int zcJ = 0;
        public boolean zdA;
        public View zdz;

        C36226a() {
        }

        static {
            AppMethodBeat.m2504i(32918);
            AppMethodBeat.m2505o(32918);
        }

        /* renamed from: A */
        public final C36226a mo57096A(View view, boolean z) {
            AppMethodBeat.m2504i(32916);
            super.mo11031eP(view);
            this.zdA = z;
            this.enf = (TextView) this.mRR.findViewById(2131820587);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = this.mRR.findViewById(2131820586);
            this.qkY = (TextView) this.mRR.findViewById(2131821102);
            this.zbI = (MMImageView) this.mRR.findViewById(2131822596);
            this.gnB = (TextView) this.mRR.findViewById(2131822597);
            this.gnC = (TextView) this.mRR.findViewById(2131822598);
            this.rGU = (TextView) this.mRR.findViewById(2131822599);
            this.zdz = this.mRR.findViewById(2131822595);
            this.zcJ = C5378c.m8145hV(C4996ah.getContext());
            AppMethodBeat.m2505o(32916);
            return this;
        }

        /* renamed from: a */
        public final void mo57097a(final Context context, C8910b c8910b, String str, boolean z) {
            AppMethodBeat.m2504i(32917);
            C5379a.m8170an(this.jPL, this.zcJ);
            C25815a ahp;
            String str2;
            ImageView imageView;
            C17927a c17927a;
            int i;
            switch (c8910b.type) {
                case 16:
                    this.gnB.setText(c8910b.description);
                    this.gnC.setText(c8910b.fhC);
                    this.zbI.setVisibility(0);
                    if (z) {
                        ahp = C32291o.ahp();
                        str2 = c8910b.thumburl;
                        imageView = this.zbI;
                        c17927a = new C17927a();
                        i = zdB;
                        c17927a = c17927a.mo33448ct(i, i);
                        c17927a.ePT = C1318a.app_attach_file_icon_webpage;
                        c17927a.eQf = true;
                        ahp.mo43766a(str2, imageView, c17927a.ahG());
                        AppMethodBeat.m2505o(32917);
                        return;
                    }
                    this.zbI.setImageResource(C25738R.drawable.ak9);
                    AppMethodBeat.m2505o(32917);
                    return;
                case 34:
                    if (c8910b.title == null || c8910b.title.length() <= 0) {
                        this.gnB.setVisibility(8);
                    } else {
                        this.gnB.setVisibility(0);
                        this.gnB.setText(c8910b.title);
                        if (C5046bo.isNullOrNil(c8910b.fhL)) {
                            this.gnB.setTextColor(context.getResources().getColor(C25738R.color.f11782h4));
                        } else {
                            this.gnB.setTextColor(C5046bo.m7530bS(c8910b.fhL, context.getResources().getColor(C25738R.color.f11782h4)));
                        }
                    }
                    this.gnC.setMaxLines(2);
                    this.gnC.setVisibility(0);
                    this.gnC.setText(c8910b.description);
                    if (C5046bo.isNullOrNil(c8910b.fhM)) {
                        this.gnC.setTextColor(context.getResources().getColor(C25738R.color.f12073rb));
                    } else {
                        this.gnC.setTextColor(C5046bo.m7530bS(c8910b.fhM, context.getResources().getColor(C25738R.color.f12073rb)));
                    }
                    if (C5046bo.isNullOrNil(c8910b.fhH)) {
                        this.rGU.setText(C25738R.string.als);
                    } else {
                        this.rGU.setText(c8910b.fhH);
                    }
                    if (!z) {
                        this.zbI.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), C25738R.drawable.ak9));
                        AppMethodBeat.m2505o(32917);
                        return;
                    } else if (C5046bo.isNullOrNil(c8910b.fhK)) {
                        final Bitmap a = C32291o.ahl().mo73087a(str, C1338a.getDensity(context), false);
                        if (a == null || a.isRecycled()) {
                            C25815a ahp2 = C32291o.ahp();
                            String str3 = c8910b.thumburl;
                            ImageView imageView2 = this.zbI;
                            C17927a c17927a2 = new C17927a();
                            int i2 = zdB;
                            c17927a2 = c17927a2.mo33448ct(i2, i2);
                            c17927a2.ePT = C1318a.app_attach_file_icon_webpage;
                            c17927a2.eQf = true;
                            ahp2.mo43766a(str3, imageView2, c17927a2.ahG());
                        } else {
                            this.zbI.setImageBitmap(C5056d.m7616a(a, false, (float) (a.getWidth() / 2)));
                        }
                        this.zdz.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            private boolean zcR = false;

                            public final boolean onPreDraw() {
                                AppMethodBeat.m2504i(32915);
                                if (this.zcR) {
                                    C36226a.this.zdz.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.m2505o(32915);
                                } else {
                                    C36226a.this.zdz.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.zcR = true;
                                    int fromDPToPix = C1338a.fromDPToPix(context, 24);
                                    Bitmap bitmap = a;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = C5056d.m7644au(context.getResources().getColor(C25738R.color.f11868k0), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap e = C5056d.m7660e(C5056d.m7639al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                    height = C36226a.this.zdz.getHeight();
                                    int width = C36226a.this.zdz.getWidth();
                                    if (height == 0) {
                                        height = C1338a.m2856al(context, C25738R.dimen.f10296x5);
                                    }
                                    if (width == 0) {
                                        width = C1338a.m2856al(context, C25738R.dimen.f10297x6);
                                    }
                                    if (C36226a.this.zdA) {
                                        bitmap = C5056d.m7614a(e, (int) C25738R.drawable.b0k, width, height);
                                    } else {
                                        bitmap = C5056d.m7614a(e, (int) C25738R.drawable.b0t, width, height);
                                    }
                                    C36226a.this.zdz.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                    AppMethodBeat.m2505o(32915);
                                }
                                return true;
                            }
                        });
                        AppMethodBeat.m2505o(32917);
                        return;
                    } else {
                        ahp = C32291o.ahp();
                        str2 = c8910b.thumburl;
                        imageView = this.zbI;
                        c17927a = new C17927a();
                        i = zdB;
                        c17927a = c17927a.mo33448ct(i, i);
                        c17927a.ePT = C1318a.app_attach_file_icon_webpage;
                        c17927a.eQf = true;
                        ahp.mo43766a(str2, imageView, c17927a.ahG());
                        ahp = C32291o.ahp();
                        str2 = c8910b.fhK;
                        imageView = new ImageView(context);
                        c17927a = new C17927a();
                        c17927a.ePH = true;
                        ahp.mo43767a(str2, imageView, c17927a.ahG(), new C9014g() {
                            /* renamed from: sH */
                            public final void mo7596sH(String str) {
                            }

                            /* renamed from: a */
                            public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                                return null;
                            }

                            /* renamed from: b */
                            public final void mo7595b(String str, View view, C37477b c37477b) {
                                AppMethodBeat.m2504i(32914);
                                if (c37477b.bitmap != null) {
                                    final Bitmap bitmap = c37477b.bitmap;
                                    C36226a.this.zdz.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                        public final boolean onPreDraw() {
                                            Bitmap a;
                                            AppMethodBeat.m2504i(32913);
                                            C36226a.this.zdz.getViewTreeObserver().removeOnPreDrawListener(this);
                                            int height = C36226a.this.zdz.getHeight();
                                            int width = C36226a.this.zdz.getWidth();
                                            if (height == 0) {
                                                height = C1338a.m2856al(context, C25738R.dimen.f10296x5);
                                            }
                                            if (width == 0) {
                                                width = C1338a.m2856al(context, C25738R.dimen.f10297x6);
                                            }
                                            if (C36226a.this.zdA) {
                                                a = C5056d.m7614a(bitmap, (int) C25738R.drawable.b0k, width, height);
                                            } else {
                                                a = C5056d.m7614a(bitmap, (int) C25738R.drawable.b0t, width, height);
                                            }
                                            C36226a.this.zdz.setBackgroundDrawable(new BitmapDrawable(a));
                                            AppMethodBeat.m2505o(32913);
                                            return true;
                                        }
                                    });
                                }
                                AppMethodBeat.m2505o(32914);
                            }
                        });
                        AppMethodBeat.m2505o(32917);
                        return;
                    }
                default:
                    this.gnB.setText(c8910b.description);
                    this.gnC.setText(c8910b.fhC);
                    this.zbI.setVisibility(0);
                    if (z) {
                        ahp = C32291o.ahp();
                        str2 = C32291o.ahl().mo73074I(str, true);
                        imageView = this.zbI;
                        c17927a = new C17927a();
                        c17927a.fHe = 1;
                        i = zdB;
                        c17927a = c17927a.mo33448ct(i, i);
                        c17927a.ePT = C1318a.app_attach_file_icon_webpage;
                        c17927a.eQf = true;
                        ahp.mo43766a(str2, imageView, c17927a.ahG());
                        AppMethodBeat.m2505o(32917);
                        return;
                    }
                    this.zbI.setImageResource(C25738R.drawable.ak9);
                    AppMethodBeat.m2505o(32917);
                    return;
            }
        }
    }
}
