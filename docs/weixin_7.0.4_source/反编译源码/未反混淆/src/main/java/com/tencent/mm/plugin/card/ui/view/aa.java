package com.tencent.mm.plugin.card.ui.view;

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
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class aa implements c {
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
        public TextView krv;
        public TextView krw;
        public TextView krx;
        public TextView kry;
        public TextView krz;
    }

    public aa(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.i(88794);
        this.mContext = context;
        this.khG = baseAdapter;
        this.knQ = this.mContext.getResources().getDimensionPixelSize(R.dimen.nj);
        this.khK = this.mContext.getResources().getDimensionPixelSize(R.dimen.lo);
        this.knR = this.mContext.getResources().getDimensionPixelOffset(R.dimen.vo);
        this.itemHeight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.vp);
        AppMethodBeat.o(88794);
    }

    public final void release() {
        AppMethodBeat.i(88795);
        this.mContext = null;
        this.khG = null;
        if (this.khO != null) {
            this.khO.clear();
        }
        AppMethodBeat.o(88795);
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        AppMethodBeat.i(88796);
        if (view == null) {
            View inflate;
            switch (this.khG.getItemViewType(i)) {
                case 0:
                    inflate = View.inflate(this.mContext, R.layout.jd, null);
                    TextView textView;
                    if (!bVar.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                        if (bVar.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                            textView = (TextView) inflate.findViewById(R.id.ah2);
                            if (textView != null) {
                                textView.setText(this.mContext.getString(R.string.af5));
                                break;
                            }
                        }
                    }
                    textView = (TextView) inflate.findViewById(R.id.ah2);
                    if (textView != null) {
                        textView.setText(this.mContext.getString(R.string.ai9));
                        break;
                    }
                    break;
                case 1:
                    inflate = View.inflate(this.mContext, R.layout.jb, null);
                    break;
                case 2:
                    inflate = View.inflate(this.mContext, R.layout.jg, null);
                    break;
                default:
                    inflate = View.inflate(this.mContext, R.layout.jb, null);
                    break;
            }
            aVar = new a();
            if (bVar.aZZ().equals("PRIVATE_TICKET_TITLE") || bVar.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                aVar.krv = (TextView) inflate.findViewById(R.id.ah2);
            } else if (bVar.aZH()) {
                aVar.krw = (TextView) inflate.findViewById(R.id.ah6);
                aVar.krx = (TextView) inflate.findViewById(R.id.ah7);
                aVar.kry = (TextView) inflate.findViewById(R.id.ah8);
                aVar.krz = (TextView) inflate.findViewById(R.id.ah9);
            } else {
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
            }
            inflate.setTag(aVar);
            view = inflate;
        } else {
            a aVar2 = (a) view.getTag();
            if (aVar2.krv != null) {
                if (bVar.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                    aVar2.krv.setText(this.mContext.getString(R.string.ai9));
                    aVar = aVar2;
                } else {
                    aVar2.krv.setText(this.mContext.getString(R.string.af5));
                }
            }
            aVar = aVar2;
        }
        if (aVar.khV != null) {
            aVar.khV.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.dx));
        }
        if (bVar.aZI()) {
            if (bVar.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                aVar.krv.setText(this.mContext.getString(R.string.ai9));
            } else if (bVar.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                aVar.krv.setText(this.mContext.getString(R.string.af5));
            } else if (bVar.aZH()) {
                LinkedList linkedList = bVar.aZV().vTW;
                aVar.krw.setText(((tm) linkedList.get(0)).kbW);
                aVar.kry.setText(((tm) linkedList.get(1)).kbW);
                linkedList = bVar.aZW().vSc;
                aVar.krz.setText(String.format(this.mContext.getString(R.string.aff), new Object[]{((tm) linkedList.get(0)).kbW}));
                if (linkedList.size() >= 2) {
                    aVar.krx.setText(((tm) linkedList.get(1)).kbW);
                }
            } else {
                ImageView imageView;
                if (this.khG.getItem(i) instanceof CardInfo) {
                    CardInfo cardInfo = (CardInfo) this.khG.getItem(i);
                    if (!(cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") || cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
                        CharSequence a;
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
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 < aVar.knT.getChildCount()) {
                                    this.khO.add((CardTagTextView) aVar.knT.getChildAt(i3));
                                    i2 = i3 + 1;
                                } else {
                                    CardTagTextView cardTagTextView;
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
                                }
                            }
                        } else {
                            aVar.knT.setVisibility(8);
                        }
                    }
                }
                aVar.khS.setVisibility(0);
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
                        m.a(imageView, R.drawable.azs, l.Hn(bVar.aZV().color));
                    } else {
                        m.a(this.mContext, imageView, bVar.aZV().vUe, this.mContext.getResources().getDimensionPixelSize(R.dimen.vx), l.Hn(bVar.aZV().color));
                    }
                } else {
                    aVar.knc.setVisibility(8);
                    aVar.khT.setVisibility(0);
                    m.a(aVar.khT, bVar.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(R.dimen.vx), (int) R.drawable.bcm, true);
                }
                if (bVar.aZD()) {
                    if (bo.isNullOrNil(bVar.aZW().vSm)) {
                        aVar.khS.setBackgroundDrawable(l.dI(l.Hn(bVar.aZV().color), this.knR));
                        aVar.knU.setVisibility(8);
                        aVar.knV.setVisibility(8);
                        aVar.knW.setVisibility(0);
                    } else {
                        aVar.khS.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.gp));
                        aVar.knU.setVisibility(0);
                        aVar.knV.setVisibility(0);
                        imageView = aVar.knU;
                        String str = bVar.aZW().vSm;
                        com.tencent.mm.at.a.a.c.a aVar3 = new com.tencent.mm.at.a.a.c.a();
                        aVar3.ePK = e.eSn;
                        o.ahq();
                        aVar3.ePY = null;
                        aVar3.ePJ = com.tencent.mm.plugin.card.model.m.Gz(str);
                        aVar3.ePH = true;
                        aVar3.eQa = true;
                        aVar3.ePF = true;
                        aVar3.ePT = R.drawable.gp;
                        aVar3.ePO = com.tencent.mm.bz.a.al(this.mContext, R.dimen.vp);
                        aVar3.ePN = com.tencent.mm.bz.a.gd(this.mContext);
                        o.ahp().a(str, imageView, aVar3.ahG());
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
            }
        } else if (!(bVar.aZZ().equals("PRIVATE_TICKET_TITLE") || bVar.aZZ().equals("PRIVATE_INVOICE_TITLE") || bVar.aZH())) {
            aVar.khT.setVisibility(8);
            aVar.khV.setVisibility(8);
            aVar.khU.setVisibility(8);
            aVar.knT.setVisibility(8);
            aVar.khY.setVisibility(0);
            aVar.khS.setBackgroundDrawable(l.dI(this.mContext.getResources().getColor(R.color.jb), this.knR));
            aVar.khY.setText(this.mContext.getResources().getString(R.string.agb));
        }
        if (!(bVar.aZZ().equals("PRIVATE_TICKET_TITLE") || bVar.aZZ().equals("PRIVATE_INVOICE_TITLE") || bVar.aZH())) {
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
        }
        AppMethodBeat.o(88796);
        return view;
    }

    public final void R(View view, int i) {
        AppMethodBeat.i(88797);
        ((com.tencent.mm.plugin.card.ui.l.a) view.getTag()).knS.setImageResource(i);
        AppMethodBeat.o(88797);
    }

    public final void S(View view, int i) {
        AppMethodBeat.i(88798);
        ((com.tencent.mm.plugin.card.ui.l.a) view.getTag()).knS.setVisibility(i);
        AppMethodBeat.o(88798);
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
        AppMethodBeat.i(88799);
        CardInfo cardInfo = (CardInfo) this.khG.getItem(i);
        if (cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") || cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            AppMethodBeat.o(88799);
            return;
        }
        a aVar = (a) view.getTag();
        aVar.knS.setTag(Integer.valueOf(i));
        aVar.knS.setOnClickListener(onClickListener);
        AppMethodBeat.o(88799);
    }
}
