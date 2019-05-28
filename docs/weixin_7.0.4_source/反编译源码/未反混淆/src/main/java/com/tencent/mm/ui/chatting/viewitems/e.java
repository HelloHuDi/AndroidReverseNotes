package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.va;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.f;

public final class e {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 436207665) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32870);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n2);
                view.setTag(new a().eS(view));
            }
            AppMethodBeat.o(32870);
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
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32871);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            if (aVar3.zdk == biVar.field_msgId) {
                aVar3.zdl = true;
            } else {
                aVar3.zdl = false;
            }
            aVar3.zdk = biVar.field_msgId;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                TextView textView;
                int i2;
                int w;
                com.tencent.mm.af.c cVar = (com.tencent.mm.af.c) X.X(com.tencent.mm.af.c.class);
                boolean equals = "1001".equals(X.fhY);
                va vaVar = new va();
                if (!(bo.isNullOrNil(X.fhZ) || equals)) {
                    vaVar.cRQ.cRS = X.fhZ;
                    com.tencent.mm.sdk.b.a.xxA.m(vaVar);
                }
                com.tencent.mm.ui.chatting.viewitems.c.a.an(aVar3.jPL, aVar3.zcJ);
                if ("1001".equals(X.fhY)) {
                    aVar3.jPL.setBackgroundResource(f.c(X, biVar.field_isSend == 1));
                    aVar3.zde.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    aVar3.jPL.setBackgroundResource(f.v(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1));
                    aVar3.zde.setTypeface(Typeface.defaultFromStyle(1));
                    aVar3.zdj = aVar3.zdj > aVar3.maxSize ? aVar3.maxSize : aVar3.zdj;
                }
                com.tencent.mm.bz.a.fromDPToPix(aVar2.yTx.getContext(), 13);
                aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.lo);
                aVar3.jPL.setPadding(0, 0, 0, 0);
                CharSequence charSequence = biVar.field_isSend == 1 ? X.fhT : X.fhS;
                if (bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    aVar3.zde.setSingleLine(false);
                    aVar3.zde.setMaxLines(3);
                } else {
                    aVar3.zde.setSingleLine(true);
                }
                aVar3.zde.setText(j.b(aVar2.yTx.getContext(), charSequence, aVar3.zdj));
                aVar3.zde.setTextSize(0, (float) aVar3.zdj);
                if (equals) {
                    boolean z;
                    textView = aVar3.zdf;
                    Context context = aVar2.yTx.getContext();
                    if (biVar.field_isSend == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    charSequence = j.b(context, f.b(X, z), aVar3.zdf.getTextSize());
                } else if (bo.isNullOrNil(X.fhZ)) {
                    textView = aVar3.zdf;
                    charSequence = biVar.field_isSend == 1 ? X.fhU : X.fhV;
                } else {
                    charSequence = f.a(vaVar.cRR.cRT, vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1, aVar2.dFx());
                    if (bo.isNullOrNil(charSequence)) {
                        aVar3.zdf.setVisibility(8);
                        charSequence = X.fhW;
                        if (bo.isNullOrNil(charSequence)) {
                            charSequence = X.title;
                        }
                        aVar3.zdg.setText(charSequence);
                        i2 = 0;
                        if (!bo.isNullOrNil(cVar.ffN)) {
                            o.ahp().a("", aVar3.zdd);
                            i2 = aVar2.yTx.getMMResources().getIdentifier(cVar.ffN, "drawable", ah.getPackageName());
                            if (i2 <= 0) {
                                i2 = aVar2.yTx.getMMResources().getIdentifier(cVar.ffN, "raw", ah.getPackageName());
                            }
                        }
                        ab.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            ab.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
                            aVar3.zdd.setImageResource(i2);
                        }
                        if ("1001".equals(X.fhY)) {
                            w = f.w(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1);
                        } else {
                            w = f.a(X, biVar.field_isSend == 1);
                        }
                        if (w <= 0) {
                            ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
                            aVar3.zdd.setImageResource(w);
                        } else if (i2 <= 0) {
                            ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
                            str2 = X.fhR;
                            if (bo.isNullOrNil(str2)) {
                                str2 = X.thumburl;
                            }
                            aVar3.zdd.setImageBitmap(null);
                            if (!bo.isNullOrNil(str2)) {
                                com.tencent.mm.at.a.a.c.a aVar4 = new com.tencent.mm.at.a.a.c.a();
                                aw.ZK();
                                aVar4.ePK = com.tencent.mm.model.c.XX();
                                aVar4.ePH = true;
                                aVar4.ePZ = true;
                                o.ahp().a(str2, aVar3.zdd, aVar4.ahG());
                            }
                        }
                        i2 = -1;
                        if (!bo.isNullOrNil(cVar.ffO)) {
                            i2 = aVar2.yTx.getMMResources().getIdentifier(cVar.ffO, "drawable", ah.getPackageName());
                        }
                        ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            aVar3.jPL.setBackgroundResource(i2);
                        }
                        e.a(aVar3, cVar, false, f.x(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend != 1), aVar2.getTalkerUserName());
                    } else {
                        textView = aVar3.zdf;
                    }
                }
                textView.setText(charSequence);
                aVar3.zdf.setVisibility(0);
                charSequence = X.fhW;
                if (bo.isNullOrNil(charSequence)) {
                }
                aVar3.zdg.setText(charSequence);
                i2 = 0;
                if (bo.isNullOrNil(cVar.ffN)) {
                }
                ab.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if ("1001".equals(X.fhY)) {
                }
                if (w <= 0) {
                }
                i2 = -1;
                if (bo.isNullOrNil(cVar.ffO)) {
                }
                ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if (biVar.field_isSend != 1) {
                }
                e.a(aVar3, cVar, false, f.x(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend != 1), aVar2.getTalkerUserName());
            }
            aVar.jPL.setOnClickListener(d(aVar2));
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            aVar.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.o(32871);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32872);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            AppMethodBeat.o(32872);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32873);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = biVar.field_content;
                    com.tencent.mm.af.j.b bVar = null;
                    if (str != null) {
                        bVar = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
                    }
                    if (bVar != null) {
                        final String str2 = biVar.field_talker;
                        final String str3 = bVar.fhS;
                        final String str4 = bVar.fhT;
                        final String str5 = bVar.fhU;
                        final String str6 = bVar.fhV;
                        final String str7 = bVar.fhQ;
                        final String str8 = bVar.fhX;
                        final String str9 = bVar.fhY;
                        Context context = aVar.yTx.getContext();
                        String string = aVar.yTx.getMMResources().getString(R.string.anu);
                        String string2 = aVar.yTx.getMMResources().getString(R.string.t6);
                        String string3 = aVar.yTx.getMMResources().getString(R.string.anv);
                        String string4 = aVar.yTx.getMMResources().getString(R.string.or);
                        final com.tencent.mm.ui.chatting.d.a aVar2 = aVar;
                        AnonymousClass1 anonymousClass1 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(32869);
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
                                d.b(aVar2.yTx.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
                                AppMethodBeat.o(32869);
                            }
                        };
                        com.tencent.mm.ui.base.h.d(context, string, string2, string3, string4, anonymousClass1, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                    AppMethodBeat.o(32873);
                    return true;
                default:
                    AppMethodBeat.o(32873);
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32874);
            String str = biVar.field_content;
            if (str != null) {
                X = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                String str2 = bo.isNullOrNil(X.fhQ) ? X.url : X.fhQ;
                ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", Boolean.valueOf(bo.isNullOrNil(str2)), Boolean.valueOf(bo.isNullOrNil(X.fih)));
                Intent intent;
                Intent intent2;
                if (bo.isNullOrNil(X.fhZ)) {
                    if (!bo.isNullOrNil(X.fih)) {
                        ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", X.fih, Integer.valueOf(X.fii), X.cEV);
                        intent = new Intent();
                        intent.putExtra("bill_no", X.fih);
                        intent.putExtra("launcher_user_name", X.cEV);
                        intent.putExtra("enter_scene", 1);
                        intent.putExtra("chatroom", aVar.getTalkerUserName());
                        d.b(aVar.yTx.getContext(), "aa", ".ui.PaylistAAUI", intent);
                        com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(4), Integer.valueOf(1));
                    } else if (!(bo.isNullOrNil(str2) || bo.isNullOrNil(str2))) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                } else if (X.fhZ.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                    intent = new Intent();
                    intent.putExtra("key_way", 1);
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_username", aVar.getTalkerUserName());
                    intent.putExtra("key_static_from_scene", 100002);
                    d.b(aVar.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                } else if (X.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    Intent intent3 = new Intent();
                    X.X(com.tencent.mm.af.d.class);
                    intent3.putExtra("key_way", aVar.dFx() ? 0 : 1);
                    intent3.putExtra("key_native_url", X.fhZ);
                    intent3.putExtra("key_username", aVar.getTalkerUserName());
                    intent3.putExtra("key_cropname", ((com.tencent.mm.af.c) X.X(com.tencent.mm.af.c.class)).ffQ);
                    d.b(aVar.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", intent3);
                } else {
                    ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + X.fhZ + ", go webview:" + str2);
                    if (!bo.isNullOrNil(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                }
            }
            AppMethodBeat.o(32874);
            return true;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
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

        a() {
        }

        public final a eS(View view) {
            AppMethodBeat.i(32863);
            super.eP(view);
            this.enf = (TextView) this.mRR.findViewById(R.id.ag);
            this.moo = (CheckBox) this.mRR.findViewById(R.id.a_);
            this.iVh = this.mRR.findViewById(R.id.af);
            this.qkY = (TextView) this.mRR.findViewById(R.id.od);
            this.zdd = (ImageView) this.mRR.findViewById(R.id.aqi);
            this.zde = (TextView) this.mRR.findViewById(R.id.aqj);
            this.zdf = (TextView) this.mRR.findViewById(R.id.aqk);
            this.zdg = (TextView) this.mRR.findViewById(R.id.aql);
            this.jPL = this.mRR.findViewById(R.id.ap9);
            this.ohc = (ImageView) this.mRR.findViewById(R.id.aqf);
            this.zdh = (TextView) this.mRR.findViewById(R.id.aqm);
            this.zdi = (ImageView) this.mRR.findViewById(R.id.aqg);
            this.zcJ = c.hV(ah.getContext());
            this.zdj = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.ef);
            this.maxSize = (int) (((float) com.tencent.mm.bz.a.am(ah.getContext(), R.dimen.ef)) * 1.45f);
            AppMethodBeat.o(32863);
            return this;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 436207665) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32864);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m2);
                view.setTag(new a().eS(view));
            }
            AppMethodBeat.o(32864);
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
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32865);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            if (aVar3.zdk == biVar.field_msgId) {
                aVar3.zdl = true;
            } else {
                aVar3.zdl = false;
            }
            aVar3.zdk = biVar.field_msgId;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                TextView textView;
                int i2;
                int w;
                com.tencent.mm.af.c cVar = (com.tencent.mm.af.c) X.X(com.tencent.mm.af.c.class);
                boolean equals = "1001".equals(X.fhY);
                va vaVar = new va();
                if (!(bo.isNullOrNil(X.fhZ) || equals)) {
                    vaVar.cRQ.cRS = X.fhZ;
                    com.tencent.mm.sdk.b.a.xxA.m(vaVar);
                }
                com.tencent.mm.ui.chatting.viewitems.c.a.an(aVar3.jPL, aVar3.zcJ);
                if ("1001".equals(X.fhY)) {
                    aVar3.jPL.setBackgroundResource(f.c(X, biVar.field_isSend == 1));
                    aVar3.zde.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    aVar3.jPL.setBackgroundResource(f.v(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1));
                    aVar3.zde.setTypeface(Typeface.defaultFromStyle(1));
                    aVar3.zdj = aVar3.zdj > aVar3.maxSize ? aVar3.maxSize : aVar3.zdj;
                }
                aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.nc);
                aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.wn);
                aVar3.jPL.setPadding(0, 0, 0, 0);
                CharSequence charSequence = biVar.field_isSend == 1 ? X.fhT : X.fhS;
                if (bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    aVar3.zde.setSingleLine(false);
                    aVar3.zde.setMaxLines(3);
                } else {
                    aVar3.zde.setSingleLine(true);
                }
                aVar3.zde.setText(j.b(aVar2.yTx.getContext(), charSequence, aVar3.zdj));
                aVar3.zde.setTextSize(0, (float) aVar3.zdj);
                if (equals) {
                    textView = aVar3.zdf;
                    charSequence = j.b(aVar2.yTx.getContext(), f.b(X, biVar.field_isSend == 1), aVar3.zdf.getTextSize());
                } else if (bo.isNullOrNil(X.fhZ)) {
                    textView = aVar3.zdf;
                    charSequence = biVar.field_isSend == 1 ? X.fhU : X.fhV;
                } else {
                    charSequence = f.a(vaVar.cRR.cRT, vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1, aVar2.dFx());
                    if (bo.isNullOrNil(charSequence)) {
                        aVar3.zdf.setVisibility(8);
                        charSequence = X.fhW;
                        if (bo.isNullOrNil(charSequence)) {
                            charSequence = X.title;
                        }
                        aVar3.zdg.setText(charSequence);
                        i2 = 0;
                        if (!bo.isNullOrNil(cVar.ffN)) {
                            o.ahp().a("", aVar3.zdd);
                            i2 = aVar2.yTx.getMMResources().getIdentifier(cVar.ffN, "drawable", ah.getPackageName());
                            if (i2 <= 0) {
                                i2 = aVar2.yTx.getMMResources().getIdentifier(cVar.ffN, "raw", ah.getPackageName());
                            }
                        }
                        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
                            aVar3.zdd.setImageResource(i2);
                        }
                        if ("1001".equals(X.fhY)) {
                            w = f.w(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1);
                        } else {
                            w = f.a(X, biVar.field_isSend == 1);
                        }
                        if (w <= 0) {
                            ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
                            aVar3.zdd.setImageResource(w);
                        } else if (i2 <= 0) {
                            ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
                            str2 = X.fhR;
                            if (bo.isNullOrNil(str2)) {
                                str2 = X.thumburl;
                            }
                            aVar3.zdd.setImageBitmap(null);
                            if (!bo.isNullOrNil(str2)) {
                                com.tencent.mm.at.a.a.c.a aVar4 = new com.tencent.mm.at.a.a.c.a();
                                aw.ZK();
                                aVar4.ePK = com.tencent.mm.model.c.XX();
                                aVar4.ePH = true;
                                aVar4.ePZ = true;
                                o.ahp().a(str2, aVar3.zdd, aVar4.ahG());
                            }
                        }
                        i2 = -1;
                        if (!bo.isNullOrNil(cVar.ffO)) {
                            i2 = aVar2.yTx.getMMResources().getIdentifier(cVar.ffO, "drawable", ah.getPackageName());
                        }
                        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", Integer.valueOf(i2));
                        if (i2 > 0) {
                            aVar3.jPL.setBackgroundResource(i2);
                        }
                        e.a(aVar3, cVar, true, f.x(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend != 1), aVar2.getTalkerUserName());
                    } else {
                        textView = aVar3.zdf;
                    }
                }
                textView.setText(charSequence);
                aVar3.zdf.setVisibility(0);
                charSequence = X.fhW;
                if (bo.isNullOrNil(charSequence)) {
                }
                aVar3.zdg.setText(charSequence);
                i2 = 0;
                if (bo.isNullOrNil(cVar.ffN)) {
                }
                ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if ("1001".equals(X.fhY)) {
                }
                if (w <= 0) {
                }
                i2 = -1;
                if (bo.isNullOrNil(cVar.ffO)) {
                }
                ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                }
                if (biVar.field_isSend != 1) {
                }
                e.a(aVar3, cVar, true, f.x(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend != 1), aVar2.getTalkerUserName());
            }
            aVar.jPL.setOnClickListener(d(aVar2));
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            aVar.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.o(32865);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32866);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            AppMethodBeat.o(32866);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32867);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(32867);
                    return true;
                default:
                    AppMethodBeat.o(32867);
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32868);
            String str = biVar.field_content;
            if (str != null) {
                X = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                String str2 = bo.isNullOrNil(X.fhQ) ? X.url : X.fhQ;
                ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", Boolean.valueOf(bo.isNullOrNil(str2)), Boolean.valueOf(bo.isNullOrNil(X.fih)));
                Intent intent;
                Intent intent2;
                if (bo.isNullOrNil(X.fhZ)) {
                    if (!bo.isNullOrNil(X.fih)) {
                        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", X.fih, Integer.valueOf(X.fii), X.cEV);
                        intent = new Intent();
                        intent.putExtra("bill_no", X.fih);
                        intent.putExtra("launcher_user_name", X.cEV);
                        intent.putExtra("enter_scene", 1);
                        intent.putExtra("chatroom", aVar.getTalkerUserName());
                        d.b(aVar.yTx.getContext(), "aa", ".ui.PaylistAAUI", intent);
                        if (f.e(X).vzW == 2) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(4), Integer.valueOf(2));
                        } else {
                            com.tencent.mm.plugin.report.service.h.pYm.e(13721, Integer.valueOf(4), Integer.valueOf(3));
                        }
                    } else if (!bo.isNullOrNil(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                } else if (X.fhZ.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                    intent = new Intent();
                    intent.putExtra("key_way", 1);
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_username", aVar.getTalkerUserName());
                    intent.putExtra("key_static_from_scene", 100002);
                    d.b(aVar.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                } else if (X.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    Intent intent3 = new Intent();
                    X.X(com.tencent.mm.af.d.class);
                    intent3.putExtra("key_way", aVar.dFx() ? 0 : 1);
                    intent3.putExtra("key_native_url", X.fhZ);
                    intent3.putExtra("key_username", aVar.getTalkerUserName());
                    intent3.putExtra("key_cropname", ((com.tencent.mm.af.c) X.X(com.tencent.mm.af.c.class)).ffQ);
                    d.b(aVar.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", intent3);
                } else {
                    ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + X.fhZ + ", go webview:" + str2);
                    if (!bo.isNullOrNil(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                }
            }
            AppMethodBeat.o(32868);
            return true;
        }
    }

    static /* synthetic */ void a(final a aVar, final com.tencent.mm.af.c cVar, final boolean z, int i, String str) {
        AppMethodBeat.i(32875);
        if (bo.isNullOrNil(cVar.ffQ)) {
            aVar.zdh.setText("");
        } else {
            g.K(com.tencent.mm.plugin.luckymoney.a.a.class);
            aVar.zdh.setText(cVar.ffQ);
        }
        if (bo.isNullOrNil(z ? cVar.ffT : cVar.ffR)) {
            aVar.zdi.setVisibility(8);
            aVar.ohc.setVisibility(8);
            aVar.ohc.setImageBitmap(null);
        } else {
            if (i > 0) {
                aVar.zdi.setImageResource(i);
                aVar.zdi.setVisibility(0);
                aVar.ohc.setVisibility(0);
            }
            if (!aVar.zdl) {
                aVar.ohc.setImageBitmap(null);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32862);
                        int height = aVar.jPL.getHeight() - com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 20);
                        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 168);
                        atb atb = new atb();
                        atb.cuu = cVar.cuu;
                        atb.wwQ = new atc();
                        atb.wwQ.wwV = z ? cVar.ffT : cVar.ffR;
                        atb.wwQ.wwY = z ? cVar.ffU : cVar.ffS;
                        ((com.tencent.mm.plugin.luckymoney.a.a) g.K(com.tencent.mm.plugin.luckymoney.a.a.class)).a(aVar.ohc, height, fromDPToPix, atb, z);
                        AppMethodBeat.o(32862);
                    }
                });
                com.tencent.mm.plugin.report.service.h.pYm.e(16598, Integer.valueOf(1), cVar.ffQ, r0, str);
                com.tencent.mm.plugin.report.service.h.pYm.k(991, 12, 1);
                AppMethodBeat.o(32875);
                return;
            }
        }
        AppMethodBeat.o(32875);
    }
}
