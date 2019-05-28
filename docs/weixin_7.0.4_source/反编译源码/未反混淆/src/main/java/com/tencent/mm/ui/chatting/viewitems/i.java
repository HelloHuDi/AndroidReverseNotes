package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class i {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || (i != 452984881 && i != 520093745)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32919);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.me);
                view.setTag(new a().A(view, true));
            }
            AppMethodBeat.o(32919);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32920);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (!(aVar3 == null || X == null)) {
                aVar3.a(aVar2.yTx.getContext(), X, biVar.field_imgPath, this.kuU);
            }
            ay ayVar = new ay(biVar, aVar2.dFx(), i, null, 0);
            if (aVar.jPL != null) {
                aVar.jPL.setTag(ayVar);
                aVar.jPL.setOnClickListener(d(aVar2));
                if (this.kuU) {
                    aVar.jPL.setOnLongClickListener(c(aVar2));
                    aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
                }
            }
            AppMethodBeat.o(32920);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32921);
            int i = ((ay) view.getTag()).position;
            if (biVar.field_content == null) {
                AppMethodBeat.o(32921);
                return true;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            if (me == null) {
                AppMethodBeat.o(32921);
                return true;
            }
            switch (me.type) {
                case 16:
                    if (me.fhD == 5 || me.fhD == 6 || me.fhD == 2) {
                        if (me.fhD != 2) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                        AppMethodBeat.o(32921);
                        return false;
                    }
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                    AppMethodBeat.o(32921);
                    return false;
            }
            AppMethodBeat.o(32921);
            return true;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32922);
            String str;
            com.tencent.mm.af.j.b me;
            switch (menuItem.getItemId()) {
                case 103:
                    str = biVar.field_content;
                    if (str == null) {
                        AppMethodBeat.o(32922);
                        break;
                    }
                    me = com.tencent.mm.af.j.b.me(str);
                    if (me != null) {
                        switch (me.type) {
                            case 16:
                                ii iiVar = new ii();
                                iiVar.cDs.cDt = me.cDt;
                                iiVar.cDs.cuQ = biVar.field_msgId;
                                iiVar.cDs.cDu = biVar.field_talker;
                                com.tencent.mm.sdk.b.a.xxA.m(iiVar);
                        }
                    }
                case 111:
                    str = bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend);
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", str);
                    me = com.tencent.mm.af.j.b.me(str);
                    if (me == null || 16 != me.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(32922);
                    break;
                default:
                    AppMethodBeat.o(32922);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32923);
            String str = biVar.field_content;
            if (str == null) {
                AppMethodBeat.o(32923);
                return false;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
            if (me == null) {
                AppMethodBeat.o(32923);
                return false;
            }
            switch (me.type) {
                case 16:
                    if (bo.isNullOrNil(me.cDt)) {
                        AppMethodBeat.o(32923);
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", me.cDt);
                    intent.putExtra("key_from_scene", me.fhD);
                    d.b(aVar.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                    AppMethodBeat.o(32923);
                    return true;
                case 34:
                    com.tencent.mm.plugin.card.b.h b = com.tencent.mm.plugin.card.b.h.b(me);
                    if (1 < b.ver) {
                        String str2;
                        int i;
                        String B = p.B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                        PackageInfo packageInfo = c.getPackageInfo(aVar.yTx.getContext(), me.appId);
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
                        a(aVar, B, B, str2, i, me.appId, true, biVar.field_msgId, biVar.field_msgSvrId, biVar);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", b(aVar, biVar));
                        intent2.putExtra("key_biz_uin", b.fhF);
                        intent2.putExtra("key_order_id", b.fhG);
                        if (!(biVar.field_talker == null || biVar.field_talker.equals("") || !t.kH(biVar.field_talker))) {
                            intent2.putExtra("key_chatroom_name", biVar.field_talker);
                        }
                        d.b(aVar.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    AppMethodBeat.o(32923);
                    return true;
                default:
                    AppMethodBeat.o(32923);
                    return false;
            }
        }
    }

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && (i == 452984881 || i == 520093745)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32924);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nd);
                view.setTag(new a().A(view, false));
            }
            AppMethodBeat.o(32924);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32925);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (!(aVar3 == null || X == null)) {
                aVar3.a(aVar2.yTx.getContext(), X, biVar.field_imgPath, this.kuU);
            }
            aVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, null, 0));
            aVar.jPL.setOnClickListener(d(aVar2));
            if (this.kuU) {
                aVar.jPL.setOnLongClickListener(c(aVar2));
                aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            }
            AppMethodBeat.o(32925);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32926);
            int i = ((ay) view.getTag()).position;
            if (biVar.field_content == null) {
                AppMethodBeat.o(32926);
                return true;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.yJI.dFx(), biVar.field_content, biVar.field_isSend));
            if (me == null) {
                AppMethodBeat.o(32926);
                return true;
            }
            switch (me.type) {
                case 16:
                    if (me.fhD == 5 || me.fhD == 6 || me.fhD == 2) {
                        if (me.fhD != 2) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                        AppMethodBeat.o(32926);
                        return false;
                    }
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
                    AppMethodBeat.o(32926);
                    return false;
            }
            AppMethodBeat.o(32926);
            return true;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32927);
            String str;
            com.tencent.mm.af.j.b me;
            switch (menuItem.getItemId()) {
                case 103:
                    str = biVar.field_content;
                    if (str == null) {
                        AppMethodBeat.o(32927);
                        break;
                    }
                    me = com.tencent.mm.af.j.b.me(str);
                    if (me != null) {
                        switch (me.type) {
                            case 16:
                                ii iiVar = new ii();
                                iiVar.cDs.cDt = me.cDt;
                                iiVar.cDs.cuQ = biVar.field_msgId;
                                iiVar.cDs.cDu = biVar.field_talker;
                                com.tencent.mm.sdk.b.a.xxA.m(iiVar);
                        }
                    }
                case 111:
                    str = bf.b(aVar.dFx(), biVar.field_content, biVar.field_isSend);
                    Intent intent = new Intent(aVar.yTx.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", str);
                    me = com.tencent.mm.af.j.b.me(str);
                    if (me == null || 16 != me.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                    aVar.startActivity(intent);
                    AppMethodBeat.o(32927);
                    break;
                default:
                    AppMethodBeat.o(32927);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32928);
            String str = biVar.field_content;
            if (str == null) {
                AppMethodBeat.o(32928);
                return false;
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
            if (me == null) {
                AppMethodBeat.o(32928);
                return false;
            }
            switch (me.type) {
                case 16:
                    if (bo.isNullOrNil(me.cDt)) {
                        AppMethodBeat.o(32928);
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", me.cDt);
                    intent.putExtra("key_from_scene", me.fhD);
                    d.b(aVar.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                    AppMethodBeat.o(32928);
                    return true;
                case 34:
                    com.tencent.mm.plugin.card.b.h b = com.tencent.mm.plugin.card.b.h.b(me);
                    if (1 < b.ver) {
                        String str2;
                        int i;
                        String B = p.B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                        PackageInfo packageInfo = c.getPackageInfo(aVar.yTx.getContext(), me.appId);
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
                        a(aVar, B, B, str2, i, me.appId, true, biVar.field_msgId, biVar.field_msgSvrId, biVar);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", b(aVar, biVar));
                        intent2.putExtra("key_biz_uin", b.fhF);
                        intent2.putExtra("key_order_id", b.fhG);
                        if (!(biVar.field_talker == null || biVar.field_talker.equals("") || !t.kH(biVar.field_talker))) {
                            intent2.putExtra("key_chatroom_name", biVar.field_talker);
                        }
                        d.b(aVar.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    AppMethodBeat.o(32928);
                    return true;
                default:
                    AppMethodBeat.o(32928);
                    return false;
            }
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public static final int zdB = (((int) com.tencent.mm.bz.a.getDensity(com.tencent.mm.app.b.cdV.getApplication())) * 64);
        public TextView gnB;
        public TextView gnC;
        public TextView rGU;
        public MMImageView zbI;
        public int zcJ = 0;
        public boolean zdA;
        public View zdz;

        a() {
        }

        static {
            AppMethodBeat.i(32918);
            AppMethodBeat.o(32918);
        }

        public final a A(View view, boolean z) {
            AppMethodBeat.i(32916);
            super.eP(view);
            this.zdA = z;
            this.enf = (TextView) this.mRR.findViewById(R.id.ag);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = this.mRR.findViewById(R.id.af);
            this.qkY = (TextView) this.mRR.findViewById(R.id.od);
            this.zbI = (MMImageView) this.mRR.findViewById(R.id.arf);
            this.gnB = (TextView) this.mRR.findViewById(R.id.arg);
            this.gnC = (TextView) this.mRR.findViewById(R.id.arh);
            this.rGU = (TextView) this.mRR.findViewById(R.id.ari);
            this.zdz = this.mRR.findViewById(R.id.are);
            this.zcJ = c.hV(ah.getContext());
            AppMethodBeat.o(32916);
            return this;
        }

        public final void a(final Context context, com.tencent.mm.af.j.b bVar, String str, boolean z) {
            AppMethodBeat.i(32917);
            com.tencent.mm.ui.chatting.viewitems.c.a.an(this.jPL, this.zcJ);
            com.tencent.mm.at.a.a ahp;
            String str2;
            ImageView imageView;
            com.tencent.mm.at.a.a.c.a aVar;
            int i;
            switch (bVar.type) {
                case 16:
                    this.gnB.setText(bVar.description);
                    this.gnC.setText(bVar.fhC);
                    this.zbI.setVisibility(0);
                    if (z) {
                        ahp = o.ahp();
                        str2 = bVar.thumburl;
                        imageView = this.zbI;
                        aVar = new com.tencent.mm.at.a.a.c.a();
                        i = zdB;
                        aVar = aVar.ct(i, i);
                        aVar.ePT = R.raw.app_attach_file_icon_webpage;
                        aVar.eQf = true;
                        ahp.a(str2, imageView, aVar.ahG());
                        AppMethodBeat.o(32917);
                        return;
                    }
                    this.zbI.setImageResource(R.drawable.ak9);
                    AppMethodBeat.o(32917);
                    return;
                case 34:
                    if (bVar.title == null || bVar.title.length() <= 0) {
                        this.gnB.setVisibility(8);
                    } else {
                        this.gnB.setVisibility(0);
                        this.gnB.setText(bVar.title);
                        if (bo.isNullOrNil(bVar.fhL)) {
                            this.gnB.setTextColor(context.getResources().getColor(R.color.h4));
                        } else {
                            this.gnB.setTextColor(bo.bS(bVar.fhL, context.getResources().getColor(R.color.h4)));
                        }
                    }
                    this.gnC.setMaxLines(2);
                    this.gnC.setVisibility(0);
                    this.gnC.setText(bVar.description);
                    if (bo.isNullOrNil(bVar.fhM)) {
                        this.gnC.setTextColor(context.getResources().getColor(R.color.rb));
                    } else {
                        this.gnC.setTextColor(bo.bS(bVar.fhM, context.getResources().getColor(R.color.rb)));
                    }
                    if (bo.isNullOrNil(bVar.fhH)) {
                        this.rGU.setText(R.string.als);
                    } else {
                        this.rGU.setText(bVar.fhH);
                    }
                    if (!z) {
                        this.zbI.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ak9));
                        AppMethodBeat.o(32917);
                        return;
                    } else if (bo.isNullOrNil(bVar.fhK)) {
                        final Bitmap a = o.ahl().a(str, com.tencent.mm.bz.a.getDensity(context), false);
                        if (a == null || a.isRecycled()) {
                            com.tencent.mm.at.a.a ahp2 = o.ahp();
                            String str3 = bVar.thumburl;
                            ImageView imageView2 = this.zbI;
                            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                            int i2 = zdB;
                            aVar2 = aVar2.ct(i2, i2);
                            aVar2.ePT = R.raw.app_attach_file_icon_webpage;
                            aVar2.eQf = true;
                            ahp2.a(str3, imageView2, aVar2.ahG());
                        } else {
                            this.zbI.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a, false, (float) (a.getWidth() / 2)));
                        }
                        this.zdz.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            private boolean zcR = false;

                            public final boolean onPreDraw() {
                                AppMethodBeat.i(32915);
                                if (this.zcR) {
                                    a.this.zdz.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.o(32915);
                                } else {
                                    a.this.zdz.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.zcR = true;
                                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 24);
                                    Bitmap bitmap = a;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = com.tencent.mm.sdk.platformtools.d.au(context.getResources().getColor(R.color.k0), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap e = com.tencent.mm.sdk.platformtools.d.e(com.tencent.mm.sdk.platformtools.d.al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                    height = a.this.zdz.getHeight();
                                    int width = a.this.zdz.getWidth();
                                    if (height == 0) {
                                        height = com.tencent.mm.bz.a.al(context, R.dimen.x5);
                                    }
                                    if (width == 0) {
                                        width = com.tencent.mm.bz.a.al(context, R.dimen.x6);
                                    }
                                    if (a.this.zdA) {
                                        bitmap = com.tencent.mm.sdk.platformtools.d.a(e, (int) R.drawable.b0k, width, height);
                                    } else {
                                        bitmap = com.tencent.mm.sdk.platformtools.d.a(e, (int) R.drawable.b0t, width, height);
                                    }
                                    a.this.zdz.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                    AppMethodBeat.o(32915);
                                }
                                return true;
                            }
                        });
                        AppMethodBeat.o(32917);
                        return;
                    } else {
                        ahp = o.ahp();
                        str2 = bVar.thumburl;
                        imageView = this.zbI;
                        aVar = new com.tencent.mm.at.a.a.c.a();
                        i = zdB;
                        aVar = aVar.ct(i, i);
                        aVar.ePT = R.raw.app_attach_file_icon_webpage;
                        aVar.eQf = true;
                        ahp.a(str2, imageView, aVar.ahG());
                        ahp = o.ahp();
                        str2 = bVar.fhK;
                        imageView = new ImageView(context);
                        aVar = new com.tencent.mm.at.a.a.c.a();
                        aVar.ePH = true;
                        ahp.a(str2, imageView, aVar.ahG(), new g() {
                            public final void sH(String str) {
                            }

                            public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                                return null;
                            }

                            public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                                AppMethodBeat.i(32914);
                                if (bVar.bitmap != null) {
                                    final Bitmap bitmap = bVar.bitmap;
                                    a.this.zdz.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                        public final boolean onPreDraw() {
                                            Bitmap a;
                                            AppMethodBeat.i(32913);
                                            a.this.zdz.getViewTreeObserver().removeOnPreDrawListener(this);
                                            int height = a.this.zdz.getHeight();
                                            int width = a.this.zdz.getWidth();
                                            if (height == 0) {
                                                height = com.tencent.mm.bz.a.al(context, R.dimen.x5);
                                            }
                                            if (width == 0) {
                                                width = com.tencent.mm.bz.a.al(context, R.dimen.x6);
                                            }
                                            if (a.this.zdA) {
                                                a = com.tencent.mm.sdk.platformtools.d.a(bitmap, (int) R.drawable.b0k, width, height);
                                            } else {
                                                a = com.tencent.mm.sdk.platformtools.d.a(bitmap, (int) R.drawable.b0t, width, height);
                                            }
                                            a.this.zdz.setBackgroundDrawable(new BitmapDrawable(a));
                                            AppMethodBeat.o(32913);
                                            return true;
                                        }
                                    });
                                }
                                AppMethodBeat.o(32914);
                            }
                        });
                        AppMethodBeat.o(32917);
                        return;
                    }
                default:
                    this.gnB.setText(bVar.description);
                    this.gnC.setText(bVar.fhC);
                    this.zbI.setVisibility(0);
                    if (z) {
                        ahp = o.ahp();
                        str2 = o.ahl().I(str, true);
                        imageView = this.zbI;
                        aVar = new com.tencent.mm.at.a.a.c.a();
                        aVar.fHe = 1;
                        i = zdB;
                        aVar = aVar.ct(i, i);
                        aVar.ePT = R.raw.app_attach_file_icon_webpage;
                        aVar.eQf = true;
                        ahp.a(str2, imageView, aVar.ahG());
                        AppMethodBeat.o(32917);
                        return;
                    }
                    this.zbI.setImageResource(R.drawable.ak9);
                    AppMethodBeat.o(32917);
                    return;
            }
        }
    }
}
