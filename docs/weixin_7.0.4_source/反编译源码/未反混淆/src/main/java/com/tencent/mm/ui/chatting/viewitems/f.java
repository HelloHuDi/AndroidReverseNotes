package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;

public final class f {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 536870961) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32878);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m2);
                view.setTag(new a().eT(view));
            }
            AppMethodBeat.o(32878);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32879);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                f.a(aVar.jPL, X, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
                aVar3.zde.setTypeface(Typeface.defaultFromStyle(0));
                aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.nc);
                aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.wn);
                com.tencent.mm.af.b bVar = (com.tencent.mm.af.b) X.X(com.tencent.mm.af.b.class);
                CharSequence charSequence = biVar.field_isSend == 1 ? bVar.ffB : bVar.ffA;
                if (bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    aVar3.zde.setSingleLine(false);
                    aVar3.zde.setMaxLines(3);
                } else {
                    aVar3.zde.setSingleLine(true);
                }
                aVar3.zde.setText(j.b(aVar2.yTx.getContext(), charSequence, aVar3.zdj));
                aVar3.zde.setTextSize(0, (float) aVar3.zdj);
                if (!bo.isNullOrNil(bVar.ffC)) {
                    aVar3.zde.setTextColor(Color.parseColor(bVar.ffC));
                }
                aVar3.zdf.setText(biVar.field_isSend == 1 ? bVar.ffF : bVar.ffG);
                if (!bo.isNullOrNil(bVar.ffH)) {
                    aVar3.zdf.setTextColor(Color.parseColor(bVar.ffH));
                }
                aVar3.zdg.setText(biVar.field_isSend == 1 ? bVar.ffD : bVar.ffE);
                aVar3.zdd.setImageBitmap(null);
                if (!bo.isNullOrNil(bVar.ffv)) {
                    com.tencent.mm.at.a.a.c.a aVar4 = new com.tencent.mm.at.a.a.c.a();
                    aw.ZK();
                    aVar4.ePK = com.tencent.mm.model.c.XX();
                    aVar4.ePH = true;
                    aVar4.ePZ = true;
                    o.ahp().a(bVar.ffv, aVar3.zdd, aVar4.ahG());
                }
            }
            aVar.jPL.setOnClickListener(d(aVar2));
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            aVar.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.o(32879);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32880);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            AppMethodBeat.o(32880);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32881);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(32881);
                    return true;
                default:
                    AppMethodBeat.o(32881);
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32882);
            String str = biVar.field_content;
            com.tencent.mm.af.j.b bVar = null;
            if (str != null) {
                bVar = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            }
            if (bVar != null) {
                ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
                String queryParameter = Uri.parse(((com.tencent.mm.af.b) bVar.X(com.tencent.mm.af.b.class)).ffu).getQueryParameter("cardNo");
                Intent intent = new Intent();
                intent.putExtra("key_is_payer", false);
                intent.putExtra("key_card_no", queryParameter);
                d.b(aVar.yTx.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
                com.tencent.mm.plugin.report.service.h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }
            AppMethodBeat.o(32882);
            return true;
        }
    }

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 536870961) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32884);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n2);
                view.setTag(new a().eT(view));
            }
            AppMethodBeat.o(32884);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32885);
            this.yJI = aVar2;
            a aVar3 = (a) aVar;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                f.a(aVar.jPL, X, "MicroMsg.ChattingItemAppMsgC2CTo", true);
                aVar3.zde.setTypeface(Typeface.defaultFromStyle(0));
                aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.nc);
                aVar2.yTx.getContext().getResources().getDimensionPixelSize(R.dimen.wn);
                com.tencent.mm.af.b bVar = (com.tencent.mm.af.b) X.X(com.tencent.mm.af.b.class);
                CharSequence charSequence = biVar.field_isSend == 1 ? bVar.ffB : bVar.ffA;
                if (bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    aVar3.zde.setSingleLine(false);
                    aVar3.zde.setMaxLines(3);
                } else {
                    aVar3.zde.setSingleLine(true);
                }
                aVar3.zde.setText(j.b(aVar2.yTx.getContext(), charSequence, aVar3.zdj));
                aVar3.zde.setTextSize(0, (float) aVar3.zdj);
                if (!bo.isNullOrNil(bVar.ffC)) {
                    aVar3.zde.setTextColor(Color.parseColor(bVar.ffC));
                }
                aVar3.zdf.setText(biVar.field_isSend == 1 ? bVar.ffF : bVar.ffG);
                if (!bo.isNullOrNil(bVar.ffH)) {
                    aVar3.zdf.setTextColor(Color.parseColor(bVar.ffH));
                }
                aVar3.zdg.setText(biVar.field_isSend == 1 ? bVar.ffD : bVar.ffE);
                aVar3.zdd.setImageBitmap(null);
                if (!bo.isNullOrNil(bVar.ffv)) {
                    com.tencent.mm.at.a.a.c.a aVar4 = new com.tencent.mm.at.a.a.c.a();
                    aw.ZK();
                    aVar4.ePK = com.tencent.mm.model.c.XX();
                    aVar4.ePH = true;
                    aVar4.ePZ = true;
                    o.ahp().a(bVar.ffv, aVar3.zdd, aVar4.ahG());
                }
            }
            aVar.jPL.setOnClickListener(d(aVar2));
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            aVar.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.o(32885);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32886);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            AppMethodBeat.o(32886);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32887);
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
                                AppMethodBeat.i(32883);
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
                                AppMethodBeat.o(32883);
                            }
                        };
                        com.tencent.mm.ui.base.h.d(context, string, string2, string3, string4, anonymousClass1, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                    AppMethodBeat.o(32887);
                    return true;
                default:
                    AppMethodBeat.o(32887);
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32888);
            String str = biVar.field_content;
            com.tencent.mm.af.j.b bVar = null;
            if (str != null) {
                bVar = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
            }
            if (bVar != null) {
                ab.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
                String queryParameter = Uri.parse(((com.tencent.mm.af.b) bVar.X(com.tencent.mm.af.b.class)).ffs).getQueryParameter("cardNo");
                Intent intent = new Intent();
                intent.putExtra("key_is_payer", true);
                intent.putExtra("key_card_no", queryParameter);
                d.b(aVar.yTx.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
            }
            AppMethodBeat.o(32888);
            return true;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public int maxSize = 0;
        public int zcJ = 0;
        public ImageView zdd;
        public TextView zde;
        public TextView zdf;
        public TextView zdg;
        public int zdj = 0;

        a() {
        }

        public final a eT(View view) {
            AppMethodBeat.i(32877);
            super.eP(view);
            this.enf = (TextView) this.mRR.findViewById(R.id.ag);
            this.moo = (CheckBox) this.mRR.findViewById(R.id.a_);
            this.iVh = this.mRR.findViewById(R.id.af);
            this.qkY = (TextView) this.mRR.findViewById(R.id.od);
            this.zdd = (ImageView) this.mRR.findViewById(R.id.aqi);
            this.zde = (TextView) this.mRR.findViewById(R.id.aqj);
            this.zdf = (TextView) this.mRR.findViewById(R.id.aqk);
            this.zdg = (TextView) this.mRR.findViewById(R.id.aql);
            this.jPL = (LinearLayout) this.mRR.findViewById(R.id.ap9);
            this.zcJ = c.hV(ah.getContext());
            this.zdj = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.ef);
            this.maxSize = (int) (((float) com.tencent.mm.bz.a.am(ah.getContext(), R.dimen.ef)) * 1.45f);
            AppMethodBeat.o(32877);
            return this;
        }
    }

    static Drawable aq(Bitmap bitmap) {
        AppMethodBeat.i(32889);
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(ah.getResources(), bitmap, ninePatchChunk, new Rect(), null);
            ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.o(32889);
            return ninePatchDrawable;
        }
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        AppMethodBeat.o(32889);
        return bitmapDrawable;
    }

    static /* synthetic */ void a(View view, com.tencent.mm.af.j.b bVar, String str, boolean z) {
        AppMethodBeat.i(32890);
        if (bVar != null) {
            com.tencent.mm.af.b bVar2 = (com.tencent.mm.af.b) bVar.X(com.tencent.mm.af.b.class);
            String str2 = z ? bVar2.ffJ : bVar2.ffL;
            if (!bo.isNullOrNil(str2)) {
                ab.i(str, "get background name: %s", str2);
                int identifier = view.getResources().getIdentifier(str2, "drawable", ah.getPackageName());
                if (identifier > 0) {
                    view.setBackgroundResource(identifier);
                    AppMethodBeat.o(32890);
                    return;
                }
            }
            String str3 = z ? bVar2.ffK : bVar2.ffM;
            if (!bo.isNullOrNil(str3)) {
                ab.i(str, "get background url: %s", str3);
                Bitmap sB = o.ahp().sB(str3);
                if (sB != null) {
                    view.setBackground(aq(sB));
                    AppMethodBeat.o(32890);
                    return;
                }
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aw.ZK();
                aVar.ePK = com.tencent.mm.model.c.XX();
                aVar.ePH = true;
                aVar.ePF = true;
                aVar.ePZ = false;
                com.tencent.mm.at.a.a.c ahG = aVar.ahG();
                view.setTag(R.id.byc, str3);
                o.ahp().a(str3, null, ahG, new i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(32876);
                        if (bitmap != null && str.equals(view.getTag(R.id.byc))) {
                            view.setBackground(f.aq(bitmap));
                        }
                        AppMethodBeat.o(32876);
                    }
                });
            }
        }
        if (z) {
            view.setBackgroundResource(R.drawable.c2csendermsgnodebg);
            AppMethodBeat.o(32890);
            return;
        }
        view.setBackgroundResource(R.drawable.c2creceivermsgnodebg);
        AppMethodBeat.o(32890);
    }
}
