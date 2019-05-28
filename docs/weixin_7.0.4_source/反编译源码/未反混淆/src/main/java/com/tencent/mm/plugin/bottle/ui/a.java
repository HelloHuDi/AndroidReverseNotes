package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;

final class a extends p<ak> implements b {
    private final MMActivity crP;
    protected g jJO;
    protected c jJP;
    protected f jJQ;
    protected d jJR = MMSlideDelView.getItemStatusCallBack();

    public static class a {
        public ImageView ejo;
        public TextView ejp;
        public ImageView iYg;
        public TextView jJT;
        public TextView jJU;
        public TextView jJV;
        public View jJW;
        public TextView jJX;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(18552);
        ak akVar = (ak) obj;
        if (akVar == null) {
            akVar = new ak();
        }
        akVar.jh("");
        akVar.ji("");
        akVar.d(cursor);
        AppMethodBeat.o(18552);
        return akVar;
    }

    public a(Context context, com.tencent.mm.ui.p.a aVar) {
        super(context, new ak());
        AppMethodBeat.i(18545);
        super.a(aVar);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(18545);
    }

    public final void KC() {
        AppMethodBeat.i(18546);
        aw.ZK();
        setCursor(com.tencent.mm.model.c.XR().dsP());
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(18546);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(f fVar) {
        this.jJQ = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.jJP = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.i(18547);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.o(18547);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        AppMethodBeat.i(18548);
        ak akVar = (ak) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            View view2 = (MMSlideDelView) View.inflate(this.crP, R.layout.g8, null);
            View inflate = View.inflate(this.crP, R.layout.azs, null);
            aVar2.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar2.ejp = (TextView) inflate.findViewById(R.id.b6e);
            aVar2.jJT = (TextView) inflate.findViewById(R.id.b6f);
            aVar2.jJU = (TextView) inflate.findViewById(R.id.b6g);
            aVar2.iYg = (ImageView) inflate.findViewById(R.id.ew3);
            aVar2.jJV = (TextView) inflate.findViewById(R.id.nf);
            aVar2.jJW = view2.findViewById(R.id.a4b);
            aVar2.jJX = (TextView) view2.findViewById(R.id.nu);
            view2.setView(inflate);
            view2.setPerformItemClickListener(this.jJO);
            view2.setGetViewPositionCallback(this.jJP);
            view2.setItemStatusCallBack(this.jJR);
            view2.setEnable(false);
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        aw.ZK();
        aVar.ejp.setText(E(com.tencent.mm.model.c.XM().aoO(akVar.field_username)));
        aVar.jJT.setText(akVar.field_status == 1 ? this.crP.getString(R.string.cw8) : h.c(this.crP, akVar.field_conversationTime, true));
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ejo, ad.aoC(akVar.field_username));
        aw.ZK();
        aVar.jJU.setText(j.b(this.crP, com.tencent.mm.model.c.XR().Cb().a(akVar.field_isSend, akVar.field_username, akVar.field_content, FB(akVar.field_msgType), this.crP), aVar.jJU.getTextSize()));
        aVar.jJU.setTextColor(com.tencent.mm.bz.a.h(this.crP, (int) R.color.a7x));
        if (FB(akVar.field_msgType) == 34 && akVar.field_isSend == 0 && !bo.isNullOrNil(akVar.field_content) && !new n(akVar.field_content).fWX) {
            aVar.jJU.setTextColor(com.tencent.mm.bz.a.h(this.crP, (int) R.color.a7y));
        }
        switch (akVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = R.raw.msg_state_sending;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = R.raw.msg_state_failed;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            aVar.iYg.setBackgroundResource(i2);
            aVar.iYg.setVisibility(0);
        } else {
            aVar.iYg.setVisibility(8);
        }
        aVar.jJW.setTag(akVar.field_username);
        aVar.jJW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18544);
                ab.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
                a.this.jJR.bIq();
                if (a.this.jJQ != null) {
                    a.this.jJQ.bN(view.getTag());
                }
                AppMethodBeat.o(18544);
            }
        });
        i2 = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (akVar.field_unReadCount > 100) {
            aVar.jJV.setText("...");
            aVar.jJV.setVisibility(0);
            ab.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (akVar.field_unReadCount > 0) {
            aVar.jJV.setText(akVar.field_unReadCount);
            aVar.jJV.setVisibility(0);
            ab.v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            aVar.jJV.setVisibility(4);
            ab.v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(R.drawable.a7q);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        AppMethodBeat.o(18548);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final String E(ad adVar) {
        AppMethodBeat.i(18549);
        String a = com.tencent.mm.plugin.bottle.a.c.a(this.crP, adVar);
        AppMethodBeat.o(18549);
        return a;
    }

    private static int FB(String str) {
        int i = 1;
        AppMethodBeat.i(18550);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(18550);
        return i;
    }

    public final void KD() {
        AppMethodBeat.i(18551);
        KC();
        AppMethodBeat.o(18551);
    }
}
