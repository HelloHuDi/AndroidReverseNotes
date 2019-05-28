package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C17872c;
import com.tencent.p177mm.p181af.C8908d;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45378va;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C15642f;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.protocal.protobuf.atc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.e */
public final class C36215e {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.e$c */
    public static class C23845c extends C5378c {
        private C46650a yJI;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.e$c$2 */
        class C238462 implements OnClickListener {
            C238462() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 436207665) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32870);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969086);
                view.setTag(new C36216a().mo57094eS(view));
            }
            AppMethodBeat.m2505o(32870);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0116  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x015f  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x02b2  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0178  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x02c8  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0184  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x019b  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x01c3  */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x030c  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x01d5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32871);
            this.yJI = c46650a;
            C36216a c36216a = (C36216a) c5379a;
            if (c36216a.zdk == c7620bi.field_msgId) {
                c36216a.zdl = true;
            } else {
                c36216a.zdl = false;
            }
            c36216a.zdk = c7620bi.field_msgId;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                TextView textView;
                int i2;
                int w;
                C17872c c17872c = (C17872c) X.mo20333X(C17872c.class);
                boolean equals = "1001".equals(X.fhY);
                C45378va c45378va = new C45378va();
                if (!(C5046bo.isNullOrNil(X.fhZ) || equals)) {
                    c45378va.cRQ.cRS = X.fhZ;
                    C4879a.xxA.mo10055m(c45378va);
                }
                C5379a.m8170an(c36216a.jPL, c36216a.zcJ);
                if ("1001".equals(X.fhY)) {
                    c36216a.jPL.setBackgroundResource(C15642f.m23931c(X, c7620bi.field_isSend == 1));
                    c36216a.zde.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    c36216a.jPL.setBackgroundResource(C15642f.m23934v(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1));
                    c36216a.zde.setTypeface(Typeface.defaultFromStyle(1));
                    c36216a.zdj = c36216a.zdj > c36216a.maxSize ? c36216a.maxSize : c36216a.zdj;
                }
                C1338a.fromDPToPix(c46650a.yTx.getContext(), 13);
                c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
                c36216a.jPL.setPadding(0, 0, 0, 0);
                CharSequence charSequence = c7620bi.field_isSend == 1 ? X.fhT : X.fhS;
                if (C5046bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    c36216a.zde.setSingleLine(false);
                    c36216a.zde.setMaxLines(3);
                } else {
                    c36216a.zde.setSingleLine(true);
                }
                c36216a.zde.setText(C44089j.m79294b(c46650a.yTx.getContext(), charSequence, c36216a.zdj));
                c36216a.zde.setTextSize(0, (float) c36216a.zdj);
                if (equals) {
                    boolean z;
                    textView = c36216a.zdf;
                    Context context = c46650a.yTx.getContext();
                    if (c7620bi.field_isSend == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    charSequence = C44089j.m79293b(context, C15642f.m23930b(X, z), c36216a.zdf.getTextSize());
                } else if (C5046bo.isNullOrNil(X.fhZ)) {
                    textView = c36216a.zdf;
                    charSequence = c7620bi.field_isSend == 1 ? X.fhU : X.fhV;
                } else {
                    charSequence = C15642f.m23929a(c45378va.cRR.cRT, c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1, c46650a.dFx());
                    if (C5046bo.isNullOrNil(charSequence)) {
                        c36216a.zdf.setVisibility(8);
                        charSequence = X.fhW;
                        if (C5046bo.isNullOrNil(charSequence)) {
                            charSequence = X.title;
                        }
                        c36216a.zdg.setText(charSequence);
                        i2 = 0;
                        if (!C5046bo.isNullOrNil(c17872c.ffN)) {
                            C32291o.ahp().mo43765a("", c36216a.zdd);
                            i2 = c46650a.yTx.getMMResources().getIdentifier(c17872c.ffN, "drawable", C4996ah.getPackageName());
                            if (i2 <= 0) {
                                i2 = c46650a.yTx.getMMResources().getIdentifier(c17872c.ffN, "raw", C4996ah.getPackageName());
                            }
                        }
                        C4990ab.m7419v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            C4990ab.m7418v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
                            c36216a.zdd.setImageResource(i2);
                        }
                        if ("1001".equals(X.fhY)) {
                            w = C15642f.m23935w(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1);
                        } else {
                            w = C15642f.m23928a(X, c7620bi.field_isSend == 1);
                        }
                        if (w <= 0) {
                            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
                            c36216a.zdd.setImageResource(w);
                        } else if (i2 <= 0) {
                            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
                            str2 = X.fhR;
                            if (C5046bo.isNullOrNil(str2)) {
                                str2 = X.thumburl;
                            }
                            c36216a.zdd.setImageBitmap(null);
                            if (!C5046bo.isNullOrNil(str2)) {
                                C17927a c17927a = new C17927a();
                                C9638aw.m17190ZK();
                                c17927a.ePK = C18628c.m29089XX();
                                c17927a.ePH = true;
                                c17927a.ePZ = true;
                                C32291o.ahp().mo43766a(str2, c36216a.zdd, c17927a.ahG());
                            }
                        }
                        i2 = -1;
                        if (!C5046bo.isNullOrNil(c17872c.ffO)) {
                            i2 = c46650a.yTx.getMMResources().getIdentifier(c17872c.ffO, "drawable", C4996ah.getPackageName());
                        }
                        C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            c36216a.jPL.setBackgroundResource(i2);
                        }
                        C36215e.m59598a(c36216a, c17872c, false, C15642f.m23936x(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend != 1), c46650a.getTalkerUserName());
                    } else {
                        textView = c36216a.zdf;
                    }
                }
                textView.setText(charSequence);
                c36216a.zdf.setVisibility(0);
                charSequence = X.fhW;
                if (C5046bo.isNullOrNil(charSequence)) {
                }
                c36216a.zdg.setText(charSequence);
                i2 = 0;
                if (C5046bo.isNullOrNil(c17872c.ffN)) {
                }
                C4990ab.m7419v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if ("1001".equals(X.fhY)) {
                }
                if (w <= 0) {
                }
                i2 = -1;
                if (C5046bo.isNullOrNil(c17872c.ffO)) {
                }
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if (c7620bi.field_isSend != 1) {
                }
                C36215e.m59598a(c36216a, c17872c, false, C15642f.m23936x(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend != 1), c46650a.getTalkerUserName());
            }
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c5379a.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.m2505o(32871);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32872);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32872);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32873);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = c7620bi.field_content;
                    C8910b c8910b = null;
                    if (str != null) {
                        c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
                    }
                    if (c8910b != null) {
                        final String str2 = c7620bi.field_talker;
                        final String str3 = c8910b.fhS;
                        final String str4 = c8910b.fhT;
                        final String str5 = c8910b.fhU;
                        final String str6 = c8910b.fhV;
                        final String str7 = c8910b.fhQ;
                        final String str8 = c8910b.fhX;
                        final String str9 = c8910b.fhY;
                        Context context = c46650a.yTx.getContext();
                        String string = c46650a.yTx.getMMResources().getString(C25738R.string.anu);
                        String string2 = c46650a.yTx.getMMResources().getString(C25738R.string.f9213t6);
                        String string3 = c46650a.yTx.getMMResources().getString(C25738R.string.anv);
                        String string4 = c46650a.yTx.getMMResources().getString(C25738R.string.f9076or);
                        final C46650a c46650a2 = c46650a;
                        C238471 c238471 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(32869);
                                Intent intent = new Intent();
                                intent.putExtra("key_scene", 1);
                                intent.putExtra("key_receiver", str2);
                                intent.putExtra("key_receivertitle", str3);
                                intent.putExtra("key_sendertitle", str4);
                                intent.putExtra("key_sender_des", str5);
                                intent.putExtra("key_receiver_des", str6);
                                intent.putExtra("key_url", str7);
                                intent.putExtra("key_templateid", str8);
                                intent.putExtra("key_sceneid", str9);
                                C25985d.m41467b(c46650a2.yTx.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
                                AppMethodBeat.m2505o(32869);
                            }
                        };
                        C30379h.m48466d(context, string, string2, string3, string4, c238471, new C238462());
                    }
                    AppMethodBeat.m2505o(32873);
                    return true;
                default:
                    AppMethodBeat.m2505o(32873);
                    return false;
            }
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            C8910b X;
            AppMethodBeat.m2504i(32874);
            String str = c7620bi.field_content;
            if (str != null) {
                X = C8910b.m16058X(str, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                String str2 = C5046bo.isNullOrNil(X.fhQ) ? X.url : X.fhQ;
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", Boolean.valueOf(C5046bo.isNullOrNil(str2)), Boolean.valueOf(C5046bo.isNullOrNil(X.fih)));
                Intent intent;
                Intent intent2;
                if (C5046bo.isNullOrNil(X.fhZ)) {
                    if (!C5046bo.isNullOrNil(X.fih)) {
                        C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", X.fih, Integer.valueOf(X.fii), X.cEV);
                        intent = new Intent();
                        intent.putExtra("bill_no", X.fih);
                        intent.putExtra("launcher_user_name", X.cEV);
                        intent.putExtra("enter_scene", 1);
                        intent.putExtra("chatroom", c46650a.getTalkerUserName());
                        C25985d.m41467b(c46650a.yTx.getContext(), "aa", ".ui.PaylistAAUI", intent);
                        C7060h.pYm.mo8381e(13721, Integer.valueOf(4), Integer.valueOf(1));
                    } else if (!(C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str2))) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                } else if (X.fhZ.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                    intent = new Intent();
                    intent.putExtra("key_way", 1);
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_username", c46650a.getTalkerUserName());
                    intent.putExtra("key_static_from_scene", 100002);
                    C25985d.m41467b(c46650a.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                } else if (X.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    Intent intent3 = new Intent();
                    X.mo20333X(C8908d.class);
                    intent3.putExtra("key_way", c46650a.dFx() ? 0 : 1);
                    intent3.putExtra("key_native_url", X.fhZ);
                    intent3.putExtra("key_username", c46650a.getTalkerUserName());
                    intent3.putExtra("key_cropname", ((C17872c) X.mo20333X(C17872c.class)).ffQ);
                    C25985d.m41467b(c46650a.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", intent3);
                } else {
                    C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + X.fhZ + ", go webview:" + str2);
                    if (!C5046bo.isNullOrNil(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                }
            }
            AppMethodBeat.m2505o(32874);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.e$a */
    static class C36216a extends C5379a {
        public int maxSize = 0;
        public ImageView ohc;
        public int zcJ = 0;
        public ImageView zdd;
        public TextView zde;
        public TextView zdf;
        public TextView zdg;
        public TextView zdh;
        public ImageView zdi;
        public int zdj = 0;
        public long zdk;
        public boolean zdl;

        C36216a() {
        }

        /* renamed from: eS */
        public final C36216a mo57094eS(View view) {
            AppMethodBeat.m2504i(32863);
            super.mo11031eP(view);
            this.enf = (TextView) this.mRR.findViewById(2131820587);
            this.moo = (CheckBox) this.mRR.findViewById(2131820580);
            this.iVh = this.mRR.findViewById(2131820586);
            this.qkY = (TextView) this.mRR.findViewById(2131821102);
            this.zdd = (ImageView) this.mRR.findViewById(2131822562);
            this.zde = (TextView) this.mRR.findViewById(2131822563);
            this.zdf = (TextView) this.mRR.findViewById(2131822564);
            this.zdg = (TextView) this.mRR.findViewById(2131822565);
            this.jPL = this.mRR.findViewById(2131822515);
            this.ohc = (ImageView) this.mRR.findViewById(2131822559);
            this.zdh = (TextView) this.mRR.findViewById(2131822566);
            this.zdi = (ImageView) this.mRR.findViewById(2131822560);
            this.zcJ = C5378c.m8145hV(C4996ah.getContext());
            this.zdj = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9749ef);
            this.maxSize = (int) (((float) C1338a.m2857am(C4996ah.getContext(), C25738R.dimen.f9749ef)) * 1.45f);
            AppMethodBeat.m2505o(32863);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.e$b */
    public static class C36217b extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 436207665) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32864);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969048);
                view.setTag(new C36216a().mo57094eS(view));
            }
            AppMethodBeat.m2505o(32864);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x010b  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x011b  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0164  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x02b7  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x017d  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x02cd  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0189  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x01a0  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x01c8  */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0311  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x01da  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32865);
            this.yJI = c46650a;
            C36216a c36216a = (C36216a) c5379a;
            if (c36216a.zdk == c7620bi.field_msgId) {
                c36216a.zdl = true;
            } else {
                c36216a.zdl = false;
            }
            c36216a.zdk = c7620bi.field_msgId;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                TextView textView;
                int i2;
                int w;
                C17872c c17872c = (C17872c) X.mo20333X(C17872c.class);
                boolean equals = "1001".equals(X.fhY);
                C45378va c45378va = new C45378va();
                if (!(C5046bo.isNullOrNil(X.fhZ) || equals)) {
                    c45378va.cRQ.cRS = X.fhZ;
                    C4879a.xxA.mo10055m(c45378va);
                }
                C5379a.m8170an(c36216a.jPL, c36216a.zcJ);
                if ("1001".equals(X.fhY)) {
                    c36216a.jPL.setBackgroundResource(C15642f.m23931c(X, c7620bi.field_isSend == 1));
                    c36216a.zde.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    c36216a.jPL.setBackgroundResource(C15642f.m23934v(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1));
                    c36216a.zde.setTypeface(Typeface.defaultFromStyle(1));
                    c36216a.zdj = c36216a.zdj > c36216a.maxSize ? c36216a.maxSize : c36216a.zdj;
                }
                c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
                c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10279wn);
                c36216a.jPL.setPadding(0, 0, 0, 0);
                CharSequence charSequence = c7620bi.field_isSend == 1 ? X.fhT : X.fhS;
                if (C5046bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    c36216a.zde.setSingleLine(false);
                    c36216a.zde.setMaxLines(3);
                } else {
                    c36216a.zde.setSingleLine(true);
                }
                c36216a.zde.setText(C44089j.m79294b(c46650a.yTx.getContext(), charSequence, c36216a.zdj));
                c36216a.zde.setTextSize(0, (float) c36216a.zdj);
                if (equals) {
                    textView = c36216a.zdf;
                    charSequence = C44089j.m79293b(c46650a.yTx.getContext(), C15642f.m23930b(X, c7620bi.field_isSend == 1), c36216a.zdf.getTextSize());
                } else if (C5046bo.isNullOrNil(X.fhZ)) {
                    textView = c36216a.zdf;
                    charSequence = c7620bi.field_isSend == 1 ? X.fhU : X.fhV;
                } else {
                    charSequence = C15642f.m23929a(c45378va.cRR.cRT, c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1, c46650a.dFx());
                    if (C5046bo.isNullOrNil(charSequence)) {
                        c36216a.zdf.setVisibility(8);
                        charSequence = X.fhW;
                        if (C5046bo.isNullOrNil(charSequence)) {
                            charSequence = X.title;
                        }
                        c36216a.zdg.setText(charSequence);
                        i2 = 0;
                        if (!C5046bo.isNullOrNil(c17872c.ffN)) {
                            C32291o.ahp().mo43765a("", c36216a.zdd);
                            i2 = c46650a.yTx.getMMResources().getIdentifier(c17872c.ffN, "drawable", C4996ah.getPackageName());
                            if (i2 <= 0) {
                                i2 = c46650a.yTx.getMMResources().getIdentifier(c17872c.ffN, "raw", C4996ah.getPackageName());
                            }
                        }
                        C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
                            c36216a.zdd.setImageResource(i2);
                        }
                        if ("1001".equals(X.fhY)) {
                            w = C15642f.m23935w(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1);
                        } else {
                            w = C15642f.m23928a(X, c7620bi.field_isSend == 1);
                        }
                        if (w <= 0) {
                            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
                            c36216a.zdd.setImageResource(w);
                        } else if (i2 <= 0) {
                            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
                            str2 = X.fhR;
                            if (C5046bo.isNullOrNil(str2)) {
                                str2 = X.thumburl;
                            }
                            c36216a.zdd.setImageBitmap(null);
                            if (!C5046bo.isNullOrNil(str2)) {
                                C17927a c17927a = new C17927a();
                                C9638aw.m17190ZK();
                                c17927a.ePK = C18628c.m29089XX();
                                c17927a.ePH = true;
                                c17927a.ePZ = true;
                                C32291o.ahp().mo43766a(str2, c36216a.zdd, c17927a.ahG());
                            }
                        }
                        i2 = -1;
                        if (!C5046bo.isNullOrNil(c17872c.ffO)) {
                            i2 = c46650a.yTx.getMMResources().getIdentifier(c17872c.ffO, "drawable", C4996ah.getPackageName());
                        }
                        C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            c36216a.jPL.setBackgroundResource(i2);
                        }
                        C36215e.m59598a(c36216a, c17872c, true, C15642f.m23936x(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend != 1), c46650a.getTalkerUserName());
                    } else {
                        textView = c36216a.zdf;
                    }
                }
                textView.setText(charSequence);
                c36216a.zdf.setVisibility(0);
                charSequence = X.fhW;
                if (C5046bo.isNullOrNil(charSequence)) {
                }
                c36216a.zdg.setText(charSequence);
                i2 = 0;
                if (C5046bo.isNullOrNil(c17872c.ffN)) {
                }
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if ("1001".equals(X.fhY)) {
                }
                if (w <= 0) {
                }
                i2 = -1;
                if (C5046bo.isNullOrNil(c17872c.ffO)) {
                }
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if (c7620bi.field_isSend != 1) {
                }
                C36215e.m59598a(c36216a, c17872c, true, C15642f.m23936x(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend != 1), c46650a.getTalkerUserName());
            }
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c5379a.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.m2505o(32865);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32866);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32866);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32867);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.m2505o(32867);
                    return true;
                default:
                    AppMethodBeat.m2505o(32867);
                    return false;
            }
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            C8910b X;
            AppMethodBeat.m2504i(32868);
            String str = c7620bi.field_content;
            if (str != null) {
                X = C8910b.m16058X(str, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                String str2 = C5046bo.isNullOrNil(X.fhQ) ? X.url : X.fhQ;
                C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", Boolean.valueOf(C5046bo.isNullOrNil(str2)), Boolean.valueOf(C5046bo.isNullOrNil(X.fih)));
                Intent intent;
                Intent intent2;
                if (C5046bo.isNullOrNil(X.fhZ)) {
                    if (!C5046bo.isNullOrNil(X.fih)) {
                        C4990ab.m7417i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", X.fih, Integer.valueOf(X.fii), X.cEV);
                        intent = new Intent();
                        intent.putExtra("bill_no", X.fih);
                        intent.putExtra("launcher_user_name", X.cEV);
                        intent.putExtra("enter_scene", 1);
                        intent.putExtra("chatroom", c46650a.getTalkerUserName());
                        C25985d.m41467b(c46650a.yTx.getContext(), "aa", ".ui.PaylistAAUI", intent);
                        if (C15642f.m23933e(X).vzW == 2) {
                            C7060h.pYm.mo8381e(13721, Integer.valueOf(4), Integer.valueOf(2));
                        } else {
                            C7060h.pYm.mo8381e(13721, Integer.valueOf(4), Integer.valueOf(3));
                        }
                    } else if (!C5046bo.isNullOrNil(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                } else if (X.fhZ.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                    intent = new Intent();
                    intent.putExtra("key_way", 1);
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_username", c46650a.getTalkerUserName());
                    intent.putExtra("key_static_from_scene", 100002);
                    C25985d.m41467b(c46650a.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                } else if (X.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    Intent intent3 = new Intent();
                    X.mo20333X(C8908d.class);
                    intent3.putExtra("key_way", c46650a.dFx() ? 0 : 1);
                    intent3.putExtra("key_native_url", X.fhZ);
                    intent3.putExtra("key_username", c46650a.getTalkerUserName());
                    intent3.putExtra("key_cropname", ((C17872c) X.mo20333X(C17872c.class)).ffQ);
                    C25985d.m41467b(c46650a.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", intent3);
                } else {
                    C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + X.fhZ + ", go webview:" + str2);
                    if (!C5046bo.isNullOrNil(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                }
            }
            AppMethodBeat.m2505o(32868);
            return true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m59598a(final C36216a c36216a, final C17872c c17872c, final boolean z, int i, String str) {
        AppMethodBeat.m2504i(32875);
        if (C5046bo.isNullOrNil(c17872c.ffQ)) {
            c36216a.zdh.setText("");
        } else {
            C1720g.m3528K(C12405a.class);
            c36216a.zdh.setText(c17872c.ffQ);
        }
        if (C5046bo.isNullOrNil(z ? c17872c.ffT : c17872c.ffR)) {
            c36216a.zdi.setVisibility(8);
            c36216a.ohc.setVisibility(8);
            c36216a.ohc.setImageBitmap(null);
        } else {
            if (i > 0) {
                c36216a.zdi.setImageResource(i);
                c36216a.zdi.setVisibility(0);
                c36216a.ohc.setVisibility(0);
            }
            if (!c36216a.zdl) {
                c36216a.ohc.setImageBitmap(null);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(32862);
                        int height = c36216a.jPL.getHeight() - C1338a.fromDPToPix(C4996ah.getContext(), 20);
                        int fromDPToPix = C1338a.fromDPToPix(C4996ah.getContext(), 168);
                        atb atb = new atb();
                        atb.cuu = c17872c.cuu;
                        atb.wwQ = new atc();
                        atb.wwQ.wwV = z ? c17872c.ffT : c17872c.ffR;
                        atb.wwQ.wwY = z ? c17872c.ffU : c17872c.ffS;
                        ((C12405a) C1720g.m3528K(C12405a.class)).mo24253a(c36216a.ohc, height, fromDPToPix, atb, z);
                        AppMethodBeat.m2505o(32862);
                    }
                });
                C7060h.pYm.mo8381e(16598, Integer.valueOf(1), c17872c.ffQ, r0, str);
                C7060h.pYm.mo15419k(991, 12, 1);
                AppMethodBeat.m2505o(32875);
                return;
            }
        }
        AppMethodBeat.m2505o(32875);
    }
}
