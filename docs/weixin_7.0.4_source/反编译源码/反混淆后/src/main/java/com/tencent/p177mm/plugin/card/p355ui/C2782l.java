package com.tencent.p177mm.plugin.card.p355ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C45773c;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42844j;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.widget.CardTagTextView;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.ui.l */
public final class C2782l implements C45773c {
    int itemHeight;
    private BaseAdapter khG;
    private int khK;
    protected LinkedList<CardTagTextView> khO = new LinkedList();
    private int knQ;
    int knR;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.card.ui.l$a */
    public class C2783a {
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

    public C2782l(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.m2504i(88665);
        this.mContext = context;
        this.khG = baseAdapter;
        this.knQ = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10017nj);
        this.khK = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
        this.knR = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f10247vo);
        this.itemHeight = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f10248vp);
        AppMethodBeat.m2505o(88665);
    }

    public final void release() {
        AppMethodBeat.m2504i(88666);
        this.mContext = null;
        this.khG = null;
        if (this.khO != null) {
            this.khO.clear();
        }
        AppMethodBeat.m2505o(88666);
    }

    /* renamed from: a */
    public final View mo6879a(int i, View view, C42837b c42837b) {
        C2783a c2783a;
        AppMethodBeat.m2504i(88667);
        if (view == null) {
            View inflate;
            TextView textView;
            if (c42837b.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                inflate = View.inflate(this.mContext, 2130968949, null);
                textView = (TextView) inflate.findViewById(2131822212);
                if (textView != null) {
                    textView.setText(this.mContext.getString(C25738R.string.ai9));
                }
            } else if (c42837b.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                inflate = View.inflate(this.mContext, 2130968949, null);
                textView = (TextView) inflate.findViewById(2131822212);
                if (textView != null) {
                    textView.setText(this.mContext.getString(C25738R.string.af5));
                }
            } else {
                inflate = View.inflate(this.mContext, 2130968947, null);
            }
            c2783a = new C2783a();
            c2783a.khS = (RelativeLayout) inflate.findViewById(2131821912);
            c2783a.khT = (ImageView) inflate.findViewById(2131821914);
            c2783a.knc = inflate.findViewById(2131822208);
            c2783a.knd = (ImageView) inflate.findViewById(2131822209);
            c2783a.khU = (TextView) inflate.findViewById(2131821915);
            c2783a.khV = (TextView) inflate.findViewById(2131821917);
            c2783a.khY = (TextView) inflate.findViewById(2131821921);
            c2783a.knS = (ImageView) inflate.findViewById(2131822211);
            c2783a.knU = (ImageView) inflate.findViewById(2131822205);
            c2783a.knV = (ImageView) inflate.findViewById(2131822206);
            c2783a.knW = (ImageView) inflate.findViewById(2131822207);
            c2783a.knT = (LinearLayout) inflate.findViewById(2131822210);
            inflate.setTag(c2783a);
            view = inflate;
        } else {
            c2783a = (C2783a) view.getTag();
        }
        if (c2783a.khV != null) {
            c2783a.khV.setTextSize(0, this.mContext.getResources().getDimension(C25738R.dimen.f9731dx));
        }
        if (this.khG.getItem(i) instanceof CardInfo) {
            CharSequence a;
            CardInfo cardInfo = (CardInfo) this.khG.getItem(i);
            Object obj = null;
            if (cardInfo.field_stickyIndex % 10 != 0) {
                if (cardInfo.field_stickyIndex > 0) {
                    obj = 1;
                    a = C42844j.m76050a(this.mContext, cardInfo.field_stickyIndex, cardInfo);
                }
                a = null;
            } else {
                if (!C5046bo.isNullOrNil(cardInfo.field_label_wording)) {
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
                    if (i3 >= c2783a.knT.getChildCount()) {
                        break;
                    }
                    this.khO.add((CardTagTextView) c2783a.knT.getChildAt(i3));
                    i2 = i3 + 1;
                }
                c2783a.knT.removeAllViews();
                c2783a.knT.setVisibility(0);
                if (this.khO.size() == 0) {
                    cardTagTextView = new CardTagTextView(this.mContext);
                } else {
                    cardTagTextView = (CardTagTextView) this.khO.removeFirst();
                }
                cardTagTextView.setPadding(this.khK, this.knQ, this.khK, this.knQ);
                cardTagTextView.setGravity(17);
                cardTagTextView.setMinWidth(this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10253vu));
                cardTagTextView.setMinHeight(this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10252vt));
                if (cardInfo.aZD()) {
                    cardTagTextView.setTextColor(C1338a.m2872i(this.mContext, C25738R.color.a69));
                    cardTagTextView.setFillColor(C1338a.m2872i(this.mContext, C25738R.color.f11851jc));
                } else {
                    cardTagTextView.setTextColor(C1338a.m2872i(this.mContext, C25738R.color.f12123t7));
                    cardTagTextView.setFillColor(0);
                }
                cardTagTextView.setText(a2);
                cardTagTextView.setTextSize(1, 10.0f);
                c2783a.knT.addView(cardTagTextView);
            } else {
                c2783a.knT.setVisibility(8);
            }
        }
        if (c42837b.aZI()) {
            ImageView imageView;
            c2783a.khT.setVisibility(0);
            c2783a.khV.setVisibility(0);
            c2783a.khY.setVisibility(8);
            c2783a.khU.setVisibility(0);
            c2783a.khU.setText(c42837b.aZV().kdg);
            c2783a.khV.setText(c42837b.aZV().title);
            if (c42837b.aZF()) {
                c2783a.knc.setVisibility(0);
                c2783a.khT.setVisibility(4);
                imageView = c2783a.knd;
                if (TextUtils.isEmpty(c42837b.aZV().vUe)) {
                    C45778m.m84643a(imageView, C25738R.drawable.azs, C38736l.m65701Hn(c42837b.aZV().color));
                } else {
                    C45778m.m84641a(this.mContext, imageView, c42837b.aZV().vUe, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10255vx), C38736l.m65701Hn(c42837b.aZV().color));
                }
            } else {
                c2783a.knc.setVisibility(8);
                c2783a.khT.setVisibility(0);
                C45778m.m84644a(c2783a.khT, c42837b.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10255vx), (int) C25738R.drawable.bcm, true);
            }
            if (c42837b.aZD()) {
                if (C5046bo.isNullOrNil(c42837b.aZW().vSm)) {
                    c2783a.khS.setBackgroundDrawable(C38736l.m65725dI(C38736l.m65701Hn(c42837b.aZV().color), this.knR));
                    c2783a.knU.setVisibility(8);
                    c2783a.knV.setVisibility(8);
                    c2783a.knW.setVisibility(0);
                } else {
                    c2783a.khS.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.f6514gp));
                    c2783a.knU.setVisibility(0);
                    c2783a.knV.setVisibility(0);
                    imageView = c2783a.knU;
                    String str = c42837b.aZW().vSm;
                    C17927a c17927a = new C17927a();
                    c17927a.ePK = C6457e.eSn;
                    C32291o.ahq();
                    c17927a.ePY = null;
                    c17927a.ePJ = C33770m.m55183Gz(str);
                    c17927a.ePH = true;
                    c17927a.eQa = true;
                    c17927a.ePF = true;
                    c17927a.ePT = C25738R.drawable.f6514gp;
                    c17927a.ePO = C1338a.m2856al(this.mContext, C25738R.dimen.f10248vp);
                    c17927a.ePN = C1338a.m2868gd(this.mContext);
                    C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
                    imageView.setImageMatrix(new Matrix());
                    c2783a.knW.setVisibility(8);
                }
                c2783a.khU.setTextColor(this.mContext.getResources().getColor(C25738R.color.a69));
                c2783a.khV.setTextColor(this.mContext.getResources().getColor(C25738R.color.a69));
            } else {
                c2783a.knW.setVisibility(8);
                c2783a.knU.setVisibility(8);
                c2783a.knV.setVisibility(8);
                c2783a.khS.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.f6514gp));
                c2783a.khV.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11835is));
                c2783a.khU.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11835is));
            }
        } else {
            c2783a.khT.setVisibility(8);
            c2783a.khV.setVisibility(8);
            c2783a.khU.setVisibility(8);
            c2783a.knT.setVisibility(8);
            c2783a.khY.setVisibility(0);
            c2783a.khS.setBackgroundDrawable(C38736l.m65725dI(this.mContext.getResources().getColor(C25738R.color.f11850jb), this.knR));
            c2783a.khY.setText(this.mContext.getResources().getString(C25738R.string.agb));
        }
        c42837b.aZV();
        LayoutParams layoutParams;
        if (i != this.khG.getCount() - 1 || c2783a.khS == null) {
            layoutParams = (LayoutParams) c2783a.khS.getLayoutParams();
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                c2783a.khS.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams = (LayoutParams) c2783a.khS.getLayoutParams();
            if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le)) {
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le);
                c2783a.khS.setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.m2505o(88667);
        return view;
    }

    /* renamed from: R */
    public final void mo6877R(View view, int i) {
        AppMethodBeat.m2504i(88668);
        ((C2783a) view.getTag()).knS.setImageResource(i);
        AppMethodBeat.m2505o(88668);
    }

    /* renamed from: S */
    public final void mo6878S(View view, int i) {
        AppMethodBeat.m2504i(88669);
        ((C2783a) view.getTag()).knS.setVisibility(i);
        AppMethodBeat.m2505o(88669);
    }

    /* renamed from: a */
    public final void mo6880a(View view, int i, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(88670);
        C2783a c2783a = (C2783a) view.getTag();
        c2783a.knS.setTag(Integer.valueOf(i));
        c2783a.knS.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(88670);
    }
}
