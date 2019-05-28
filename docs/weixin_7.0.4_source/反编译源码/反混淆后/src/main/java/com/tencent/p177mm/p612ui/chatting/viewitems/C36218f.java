package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C25746b;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.f */
public final class C36218f {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.f$1 */
    static class C157421 implements C1282i {
        C157421() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(32876);
            if (bitmap != null && str.equals(view.getTag(2131824220))) {
                view.setBackground(C36218f.m59607aq(bitmap));
            }
            AppMethodBeat.m2505o(32876);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.f$b */
    public static class C30608b extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 536870961) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32878);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969048);
                view.setTag(new C31502a().mo51427eT(view));
            }
            AppMethodBeat.m2505o(32878);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32879);
            this.yJI = c46650a;
            C31502a c31502a = (C31502a) c5379a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                C36218f.m59606a(c5379a.jPL, X, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
                c31502a.zde.setTypeface(Typeface.defaultFromStyle(0));
                c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
                c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10279wn);
                C25746b c25746b = (C25746b) X.mo20333X(C25746b.class);
                CharSequence charSequence = c7620bi.field_isSend == 1 ? c25746b.ffB : c25746b.ffA;
                if (C5046bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    c31502a.zde.setSingleLine(false);
                    c31502a.zde.setMaxLines(3);
                } else {
                    c31502a.zde.setSingleLine(true);
                }
                c31502a.zde.setText(C44089j.m79294b(c46650a.yTx.getContext(), charSequence, c31502a.zdj));
                c31502a.zde.setTextSize(0, (float) c31502a.zdj);
                if (!C5046bo.isNullOrNil(c25746b.ffC)) {
                    c31502a.zde.setTextColor(Color.parseColor(c25746b.ffC));
                }
                c31502a.zdf.setText(c7620bi.field_isSend == 1 ? c25746b.ffF : c25746b.ffG);
                if (!C5046bo.isNullOrNil(c25746b.ffH)) {
                    c31502a.zdf.setTextColor(Color.parseColor(c25746b.ffH));
                }
                c31502a.zdg.setText(c7620bi.field_isSend == 1 ? c25746b.ffD : c25746b.ffE);
                c31502a.zdd.setImageBitmap(null);
                if (!C5046bo.isNullOrNil(c25746b.ffv)) {
                    C17927a c17927a = new C17927a();
                    C9638aw.m17190ZK();
                    c17927a.ePK = C18628c.m29089XX();
                    c17927a.ePH = true;
                    c17927a.ePZ = true;
                    C32291o.ahp().mo43766a(c25746b.ffv, c31502a.zdd, c17927a.ahG());
                }
            }
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c5379a.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.m2505o(32879);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32880);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32880);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32881);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.m2505o(32881);
                    return true;
                default:
                    AppMethodBeat.m2505o(32881);
                    return false;
            }
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32882);
            String str = c7620bi.field_content;
            C8910b c8910b = null;
            if (str != null) {
                c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
            }
            if (c8910b != null) {
                C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
                String queryParameter = Uri.parse(((C25746b) c8910b.mo20333X(C25746b.class)).ffu).getQueryParameter("cardNo");
                Intent intent = new Intent();
                intent.putExtra("key_is_payer", false);
                intent.putExtra("key_card_no", queryParameter);
                C25985d.m41467b(c46650a.yTx.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
                C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }
            AppMethodBeat.m2505o(32882);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.f$c */
    public static class C30609c extends C5378c {
        private C46650a yJI;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.f$c$2 */
        class C238492 implements OnClickListener {
            C238492() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 536870961) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32884);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969086);
                view.setTag(new C31502a().mo51427eT(view));
            }
            AppMethodBeat.m2505o(32884);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32885);
            this.yJI = c46650a;
            C31502a c31502a = (C31502a) c5379a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            if (X != null) {
                C36218f.m59606a(c5379a.jPL, X, "MicroMsg.ChattingItemAppMsgC2CTo", true);
                c31502a.zde.setTypeface(Typeface.defaultFromStyle(0));
                c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
                c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10279wn);
                C25746b c25746b = (C25746b) X.mo20333X(C25746b.class);
                CharSequence charSequence = c7620bi.field_isSend == 1 ? c25746b.ffB : c25746b.ffA;
                if (C5046bo.isNullOrNil(charSequence)) {
                    charSequence = X.description;
                    c31502a.zde.setSingleLine(false);
                    c31502a.zde.setMaxLines(3);
                } else {
                    c31502a.zde.setSingleLine(true);
                }
                c31502a.zde.setText(C44089j.m79294b(c46650a.yTx.getContext(), charSequence, c31502a.zdj));
                c31502a.zde.setTextSize(0, (float) c31502a.zdj);
                if (!C5046bo.isNullOrNil(c25746b.ffC)) {
                    c31502a.zde.setTextColor(Color.parseColor(c25746b.ffC));
                }
                c31502a.zdf.setText(c7620bi.field_isSend == 1 ? c25746b.ffF : c25746b.ffG);
                if (!C5046bo.isNullOrNil(c25746b.ffH)) {
                    c31502a.zdf.setTextColor(Color.parseColor(c25746b.ffH));
                }
                c31502a.zdg.setText(c7620bi.field_isSend == 1 ? c25746b.ffD : c25746b.ffE);
                c31502a.zdd.setImageBitmap(null);
                if (!C5046bo.isNullOrNil(c25746b.ffv)) {
                    C17927a c17927a = new C17927a();
                    C9638aw.m17190ZK();
                    c17927a.ePK = C18628c.m29089XX();
                    c17927a.ePH = true;
                    c17927a.ePZ = true;
                    C32291o.ahp().mo43766a(c25746b.ffv, c31502a.zdd, c17927a.ahG());
                }
            }
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c5379a.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.m2505o(32885);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32886);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32886);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32887);
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
                        C238481 c238481 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(32883);
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
                                AppMethodBeat.m2505o(32883);
                            }
                        };
                        C30379h.m48466d(context, string, string2, string3, string4, c238481, new C238492());
                    }
                    AppMethodBeat.m2505o(32887);
                    return true;
                default:
                    AppMethodBeat.m2505o(32887);
                    return false;
            }
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32888);
            String str = c7620bi.field_content;
            C8910b c8910b = null;
            if (str != null) {
                c8910b = C8910b.m16058X(str, c7620bi.field_reserved);
            }
            if (c8910b != null) {
                C4990ab.m7416i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
                String queryParameter = Uri.parse(((C25746b) c8910b.mo20333X(C25746b.class)).ffs).getQueryParameter("cardNo");
                Intent intent = new Intent();
                intent.putExtra("key_is_payer", true);
                intent.putExtra("key_card_no", queryParameter);
                C25985d.m41467b(c46650a.yTx.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
            }
            AppMethodBeat.m2505o(32888);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.f$a */
    static class C31502a extends C5379a {
        public int maxSize = 0;
        public int zcJ = 0;
        public ImageView zdd;
        public TextView zde;
        public TextView zdf;
        public TextView zdg;
        public int zdj = 0;

        C31502a() {
        }

        /* renamed from: eT */
        public final C31502a mo51427eT(View view) {
            AppMethodBeat.m2504i(32877);
            super.mo11031eP(view);
            this.enf = (TextView) this.mRR.findViewById(2131820587);
            this.moo = (CheckBox) this.mRR.findViewById(2131820580);
            this.iVh = this.mRR.findViewById(2131820586);
            this.qkY = (TextView) this.mRR.findViewById(2131821102);
            this.zdd = (ImageView) this.mRR.findViewById(2131822562);
            this.zde = (TextView) this.mRR.findViewById(2131822563);
            this.zdf = (TextView) this.mRR.findViewById(2131822564);
            this.zdg = (TextView) this.mRR.findViewById(2131822565);
            this.jPL = (LinearLayout) this.mRR.findViewById(2131822515);
            this.zcJ = C5378c.m8145hV(C4996ah.getContext());
            this.zdj = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9749ef);
            this.maxSize = (int) (((float) C1338a.m2857am(C4996ah.getContext(), C25738R.dimen.f9749ef)) * 1.45f);
            AppMethodBeat.m2505o(32877);
            return this;
        }
    }

    /* renamed from: aq */
    static Drawable m59607aq(Bitmap bitmap) {
        AppMethodBeat.m2504i(32889);
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(C4996ah.getResources(), bitmap, ninePatchChunk, new Rect(), null);
            ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.m2505o(32889);
            return ninePatchDrawable;
        }
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        AppMethodBeat.m2505o(32889);
        return bitmapDrawable;
    }

    /* renamed from: a */
    static /* synthetic */ void m59606a(View view, C8910b c8910b, String str, boolean z) {
        AppMethodBeat.m2504i(32890);
        if (c8910b != null) {
            C25746b c25746b = (C25746b) c8910b.mo20333X(C25746b.class);
            String str2 = z ? c25746b.ffJ : c25746b.ffL;
            if (!C5046bo.isNullOrNil(str2)) {
                C4990ab.m7417i(str, "get background name: %s", str2);
                int identifier = view.getResources().getIdentifier(str2, "drawable", C4996ah.getPackageName());
                if (identifier > 0) {
                    view.setBackgroundResource(identifier);
                    AppMethodBeat.m2505o(32890);
                    return;
                }
            }
            String str3 = z ? c25746b.ffK : c25746b.ffM;
            if (!C5046bo.isNullOrNil(str3)) {
                C4990ab.m7417i(str, "get background url: %s", str3);
                Bitmap sB = C32291o.ahp().mo43776sB(str3);
                if (sB != null) {
                    view.setBackground(C36218f.m59607aq(sB));
                    AppMethodBeat.m2505o(32890);
                    return;
                }
                C17927a c17927a = new C17927a();
                C9638aw.m17190ZK();
                c17927a.ePK = C18628c.m29089XX();
                c17927a.ePH = true;
                c17927a.ePF = true;
                c17927a.ePZ = false;
                C25814c ahG = c17927a.ahG();
                view.setTag(2131824220, str3);
                C32291o.ahp().mo43768a(str3, null, ahG, new C157421());
            }
        }
        if (z) {
            view.setBackgroundResource(C25738R.drawable.c2csendermsgnodebg);
            AppMethodBeat.m2505o(32890);
            return;
        }
        view.setBackgroundResource(C25738R.drawable.c2creceivermsgnodebg);
        AppMethodBeat.m2505o(32890);
    }
}
