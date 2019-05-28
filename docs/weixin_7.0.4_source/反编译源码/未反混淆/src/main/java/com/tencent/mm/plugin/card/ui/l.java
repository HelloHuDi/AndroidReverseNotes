package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class l implements c {
    int itemHeight;
    private BaseAdapter khG;
    private int khK;
    protected LinkedList<CardTagTextView> khO = new LinkedList();
    private int knQ;
    int knR;
    private Context mContext;

    public class a {
        public RelativeLayout khS;
        public ImageView khT;
        public TextView khU;
        public TextView khV;
        public TextView khY;
        public ImageView knS;
        public LinearLayout knT;
        public ImageView knU;
        public ImageView knV;
        public ImageView knW;
        public View knc;
        public ImageView knd;
    }

    public l(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.i(88665);
        this.mContext = context;
        this.khG = baseAdapter;
        this.knQ = this.mContext.getResources().getDimensionPixelSize(R.dimen.nj);
        this.khK = this.mContext.getResources().getDimensionPixelSize(R.dimen.lo);
        this.knR = this.mContext.getResources().getDimensionPixelOffset(R.dimen.vo);
        this.itemHeight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.vp);
        AppMethodBeat.o(88665);
    }

    public final void release() {
        AppMethodBeat.i(88666);
        this.mContext = null;
        this.khG = null;
        if (this.khO != null) {
            this.khO.clear();
        }
        AppMethodBeat.o(88666);
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        AppMethodBeat.i(88667);
        if (view == null) {
            View inflate;
            TextView textView;
            if (bVar.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                inflate = View.inflate(this.mContext, R.layout.jd, null);
                textView = (TextView) inflate.findViewById(R.id.ah2);
                if (textView != null) {
                    textView.setText(this.mContext.getString(R.string.ai9));
                }
            } else if (bVar.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                inflate = View.inflate(this.mContext, R.layout.jd, null);
                textView = (TextView) inflate.findViewById(R.id.ah2);
                if (textView != null) {
                    textView.setText(this.mContext.getString(R.string.af5));
                }
            } else {
                inflate = View.inflate(this.mContext, R.layout.jb, null);
            }
            aVar = new a();
            aVar.khS = (RelativeLayout) inflate.findViewById(R.id.a9y);
            aVar.khT = (ImageView) inflate.findViewById(R.id.a_0);
            aVar.knc = inflate.findViewById(R.id.agy);
            aVar.knd = (ImageView) inflate.findViewById(R.id.agz);
            aVar.khU = (TextView) inflate.findViewById(R.id.a_1);
            aVar.khV = (TextView) inflate.findViewById(R.id.a_3);
            aVar.khY = (TextView) inflate.findViewById(R.id.a_7);
            aVar.knS = (ImageView) inflate.findViewById(R.id.ah1);
            aVar.knU = (ImageView) inflate.findViewById(R.id.agv);
            aVar.knV = (ImageView) inflate.findViewById(R.id.agw);
            aVar.knW = (ImageView) inflate.findViewById(R.id.agx);
            aVar.knT = (LinearLayout) inflate.findViewById(R.id.ah0);
            inflate.setTag(aVar);
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.khV != null) {
            aVar.khV.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.dx));
        }
        if (this.khG.getItem(i) instanceof CardInfo) {
            CharSequence a;
            CardInfo cardInfo = (CardInfo) this.khG.getItem(i);
            Object obj = null;
            if (cardInfo.field_stickyIndex % 10 != 0) {
                if (cardInfo.field_stickyIndex > 0) {
                    obj = 1;
                    a = j.a(this.mContext, cardInfo.field_stickyIndex, cardInfo);
                }
                a = null;
            } else {
                if (!bo.isNullOrNil(cardInfo.field_label_wording)) {
                    obj = 1;
                    Object a2 = cardInfo.field_label_wording;
                }
                a2 = null;
            }
            if (obj != null) {
                CardTagTextView cardTagTextView;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= aVar.knT.getChildCount()) {
                        break;
                    }
                    this.khO.add((CardTagTextView) aVar.knT.getChildAt(i3));
                    i2 = i3 + 1;
                }
                aVar.knT.removeAllViews();
                aVar.knT.setVisibility(0);
                if (this.khO.size() == 0) {
                    cardTagTextView = new CardTagTextView(this.mContext);
                } else {
                    cardTagTextView = (CardTagTextView) this.khO.removeFirst();
                }
                cardTagTextView.setPadding(this.khK, this.knQ, this.khK, this.knQ);
                cardTagTextView.setGravity(17);
                cardTagTextView.setMinWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.vu));
                cardTagTextView.setMinHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.vt));
                if (cardInfo.aZD()) {
                    cardTagTextView.setTextColor(com.tencent.mm.bz.a.i(this.mContext, R.color.a69));
                    cardTagTextView.setFillColor(com.tencent.mm.bz.a.i(this.mContext, R.color.jc));
                } else {
                    cardTagTextView.setTextColor(com.tencent.mm.bz.a.i(this.mContext, R.color.t7));
                    cardTagTextView.setFillColor(0);
                }
                cardTagTextView.setText(a2);
                cardTagTextView.setTextSize(1, 10.0f);
                aVar.knT.addView(cardTagTextView);
            } else {
                aVar.knT.setVisibility(8);
            }
        }
        if (bVar.aZI()) {
            ImageView imageView;
            aVar.khT.setVisibility(0);
            aVar.khV.setVisibility(0);
            aVar.khY.setVisibility(8);
            aVar.khU.setVisibility(0);
            aVar.khU.setText(bVar.aZV().kdg);
            aVar.khV.setText(bVar.aZV().title);
            if (bVar.aZF()) {
                aVar.knc.setVisibility(0);
                aVar.khT.setVisibility(4);
                imageView = aVar.knd;
                if (TextUtils.isEmpty(bVar.aZV().vUe)) {
                    m.a(imageView, R.drawable.azs, com.tencent.mm.plugin.card.d.l.Hn(bVar.aZV().color));
                } else {
                    m.a(this.mContext, imageView, bVar.aZV().vUe, this.mContext.getResources().getDimensionPixelSize(R.dimen.vx), com.tencent.mm.plugin.card.d.l.Hn(bVar.aZV().color));
                }
            } else {
                aVar.knc.setVisibility(8);
                aVar.khT.setVisibility(0);
                m.a(aVar.khT, bVar.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(R.dimen.vx), (int) R.drawable.bcm, true);
            }
            if (bVar.aZD()) {
                if (bo.isNullOrNil(bVar.aZW().vSm)) {
                    aVar.khS.setBackgroundDrawable(com.tencent.mm.plugin.card.d.l.dI(com.tencent.mm.plugin.card.d.l.Hn(bVar.aZV().color), this.knR));
                    aVar.knU.setVisibility(8);
                    aVar.knV.setVisibility(8);
                    aVar.knW.setVisibility(0);
                } else {
                    aVar.khS.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.gp));
                    aVar.knU.setVisibility(0);
                    aVar.knV.setVisibility(0);
                    imageView = aVar.knU;
                    String str = bVar.aZW().vSm;
                    com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                    aVar2.ePK = e.eSn;
                    o.ahq();
                    aVar2.ePY = null;
                    aVar2.ePJ = com.tencent.mm.plugin.card.model.m.Gz(str);
                    aVar2.ePH = true;
                    aVar2.eQa = true;
                    aVar2.ePF = true;
                    aVar2.ePT = R.drawable.gp;
                    aVar2.ePO = com.tencent.mm.bz.a.al(this.mContext, R.dimen.vp);
                    aVar2.ePN = com.tencent.mm.bz.a.gd(this.mContext);
                    o.ahp().a(str, imageView, aVar2.ahG());
                    imageView.setImageMatrix(new Matrix());
                    aVar.knW.setVisibility(8);
                }
                aVar.khU.setTextColor(this.mContext.getResources().getColor(R.color.a69));
                aVar.khV.setTextColor(this.mContext.getResources().getColor(R.color.a69));
            } else {
                aVar.knW.setVisibility(8);
                aVar.knU.setVisibility(8);
                aVar.knV.setVisibility(8);
                aVar.khS.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.gp));
                aVar.khV.setTextColor(this.mContext.getResources().getColor(R.color.is));
                aVar.khU.setTextColor(this.mContext.getResources().getColor(R.color.is));
            }
        } else {
            aVar.khT.setVisibility(8);
            aVar.khV.setVisibility(8);
            aVar.khU.setVisibility(8);
            aVar.knT.setVisibility(8);
            aVar.khY.setVisibility(0);
            aVar.khS.setBackgroundDrawable(com.tencent.mm.plugin.card.d.l.dI(this.mContext.getResources().getColor(R.color.jb), this.knR));
            aVar.khY.setText(this.mContext.getResources().getString(R.string.agb));
        }
        bVar.aZV();
        LayoutParams layoutParams;
        if (i != this.khG.getCount() - 1 || aVar.khS == null) {
            layoutParams = (LayoutParams) aVar.khS.getLayoutParams();
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                aVar.khS.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams = (LayoutParams) aVar.khS.getLayoutParams();
            if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.dimen.le)) {
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.le);
                aVar.khS.setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(88667);
        return view;
    }

    public final void R(View view, int i) {
        AppMethodBeat.i(88668);
        ((a) view.getTag()).knS.setImageResource(i);
        AppMethodBeat.o(88668);
    }

    public final void S(View view, int i) {
        AppMethodBeat.i(88669);
        ((a) view.getTag()).knS.setVisibility(i);
        AppMethodBeat.o(88669);
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
        AppMethodBeat.i(88670);
        a aVar = (a) view.getTag();
        aVar.knS.setTag(Integer.valueOf(i));
        aVar.knS.setOnClickListener(onClickListener);
        AppMethodBeat.o(88670);
    }
}
