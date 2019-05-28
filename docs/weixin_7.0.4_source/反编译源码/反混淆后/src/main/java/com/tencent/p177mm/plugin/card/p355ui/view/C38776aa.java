package com.tencent.p177mm.plugin.card.p355ui.view;

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
import com.tencent.p177mm.plugin.card.p355ui.C2782l.C2783a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42844j;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.widget.CardTagTextView;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.ui.view.aa */
public final class C38776aa implements C45773c {
    int itemHeight;
    private BaseAdapter khG;
    private int khK;
    protected LinkedList<CardTagTextView> khO = new LinkedList();
    private int knQ;
    int knR;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.card.ui.view.aa$a */
    public class C20196a {
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

    public C38776aa(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.m2504i(88794);
        this.mContext = context;
        this.khG = baseAdapter;
        this.knQ = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10017nj);
        this.khK = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
        this.knR = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f10247vo);
        this.itemHeight = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f10248vp);
        AppMethodBeat.m2505o(88794);
    }

    public final void release() {
        AppMethodBeat.m2504i(88795);
        this.mContext = null;
        this.khG = null;
        if (this.khO != null) {
            this.khO.clear();
        }
        AppMethodBeat.m2505o(88795);
    }

    /* renamed from: a */
    public final View mo6879a(int i, View view, C42837b c42837b) {
        C20196a c20196a;
        AppMethodBeat.m2504i(88796);
        if (view == null) {
            View inflate;
            switch (this.khG.getItemViewType(i)) {
                case 0:
                    inflate = View.inflate(this.mContext, 2130968949, null);
                    TextView textView;
                    if (!c42837b.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                        if (c42837b.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                            textView = (TextView) inflate.findViewById(2131822212);
                            if (textView != null) {
                                textView.setText(this.mContext.getString(C25738R.string.af5));
                                break;
                            }
                        }
                    }
                    textView = (TextView) inflate.findViewById(2131822212);
                    if (textView != null) {
                        textView.setText(this.mContext.getString(C25738R.string.ai9));
                        break;
                    }
                    break;
                case 1:
                    inflate = View.inflate(this.mContext, 2130968947, null);
                    break;
                case 2:
                    inflate = View.inflate(this.mContext, 2130968952, null);
                    break;
                default:
                    inflate = View.inflate(this.mContext, 2130968947, null);
                    break;
            }
            c20196a = new C20196a();
            if (c42837b.aZZ().equals("PRIVATE_TICKET_TITLE") || c42837b.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                c20196a.krv = (TextView) inflate.findViewById(2131822212);
            } else if (c42837b.aZH()) {
                c20196a.krw = (TextView) inflate.findViewById(2131822216);
                c20196a.krx = (TextView) inflate.findViewById(2131822217);
                c20196a.kry = (TextView) inflate.findViewById(2131822218);
                c20196a.krz = (TextView) inflate.findViewById(2131822219);
            } else {
                c20196a.khS = (RelativeLayout) inflate.findViewById(2131821912);
                c20196a.khT = (ImageView) inflate.findViewById(2131821914);
                c20196a.knc = inflate.findViewById(2131822208);
                c20196a.knd = (ImageView) inflate.findViewById(2131822209);
                c20196a.khU = (TextView) inflate.findViewById(2131821915);
                c20196a.khV = (TextView) inflate.findViewById(2131821917);
                c20196a.khY = (TextView) inflate.findViewById(2131821921);
                c20196a.knS = (ImageView) inflate.findViewById(2131822211);
                c20196a.knU = (ImageView) inflate.findViewById(2131822205);
                c20196a.knV = (ImageView) inflate.findViewById(2131822206);
                c20196a.knW = (ImageView) inflate.findViewById(2131822207);
                c20196a.knT = (LinearLayout) inflate.findViewById(2131822210);
            }
            inflate.setTag(c20196a);
            view = inflate;
        } else {
            C20196a c20196a2 = (C20196a) view.getTag();
            if (c20196a2.krv != null) {
                if (c42837b.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                    c20196a2.krv.setText(this.mContext.getString(C25738R.string.ai9));
                    c20196a = c20196a2;
                } else {
                    c20196a2.krv.setText(this.mContext.getString(C25738R.string.af5));
                }
            }
            c20196a = c20196a2;
        }
        if (c20196a.khV != null) {
            c20196a.khV.setTextSize(0, this.mContext.getResources().getDimension(C25738R.dimen.f9731dx));
        }
        if (c42837b.aZI()) {
            if (c42837b.aZZ().equals("PRIVATE_TICKET_TITLE")) {
                c20196a.krv.setText(this.mContext.getString(C25738R.string.ai9));
            } else if (c42837b.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
                c20196a.krv.setText(this.mContext.getString(C25738R.string.af5));
            } else if (c42837b.aZH()) {
                LinkedList linkedList = c42837b.aZV().vTW;
                c20196a.krw.setText(((C23446tm) linkedList.get(0)).kbW);
                c20196a.kry.setText(((C23446tm) linkedList.get(1)).kbW);
                linkedList = c42837b.aZW().vSc;
                c20196a.krz.setText(String.format(this.mContext.getString(C25738R.string.aff), new Object[]{((C23446tm) linkedList.get(0)).kbW}));
                if (linkedList.size() >= 2) {
                    c20196a.krx.setText(((C23446tm) linkedList.get(1)).kbW);
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
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 < c20196a.knT.getChildCount()) {
                                    this.khO.add((CardTagTextView) c20196a.knT.getChildAt(i3));
                                    i2 = i3 + 1;
                                } else {
                                    CardTagTextView cardTagTextView;
                                    c20196a.knT.removeAllViews();
                                    c20196a.knT.setVisibility(0);
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
                                    c20196a.knT.addView(cardTagTextView);
                                }
                            }
                        } else {
                            c20196a.knT.setVisibility(8);
                        }
                    }
                }
                c20196a.khS.setVisibility(0);
                c20196a.khT.setVisibility(0);
                c20196a.khV.setVisibility(0);
                c20196a.khY.setVisibility(8);
                c20196a.khU.setVisibility(0);
                c20196a.khU.setText(c42837b.aZV().kdg);
                c20196a.khV.setText(c42837b.aZV().title);
                if (c42837b.aZF()) {
                    c20196a.knc.setVisibility(0);
                    c20196a.khT.setVisibility(4);
                    imageView = c20196a.knd;
                    if (TextUtils.isEmpty(c42837b.aZV().vUe)) {
                        C45778m.m84643a(imageView, C25738R.drawable.azs, C38736l.m65701Hn(c42837b.aZV().color));
                    } else {
                        C45778m.m84641a(this.mContext, imageView, c42837b.aZV().vUe, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10255vx), C38736l.m65701Hn(c42837b.aZV().color));
                    }
                } else {
                    c20196a.knc.setVisibility(8);
                    c20196a.khT.setVisibility(0);
                    C45778m.m84644a(c20196a.khT, c42837b.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10255vx), (int) C25738R.drawable.bcm, true);
                }
                if (c42837b.aZD()) {
                    if (C5046bo.isNullOrNil(c42837b.aZW().vSm)) {
                        c20196a.khS.setBackgroundDrawable(C38736l.m65725dI(C38736l.m65701Hn(c42837b.aZV().color), this.knR));
                        c20196a.knU.setVisibility(8);
                        c20196a.knV.setVisibility(8);
                        c20196a.knW.setVisibility(0);
                    } else {
                        c20196a.khS.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.f6514gp));
                        c20196a.knU.setVisibility(0);
                        c20196a.knV.setVisibility(0);
                        imageView = c20196a.knU;
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
                        c20196a.knW.setVisibility(8);
                    }
                    c20196a.khU.setTextColor(this.mContext.getResources().getColor(C25738R.color.a69));
                    c20196a.khV.setTextColor(this.mContext.getResources().getColor(C25738R.color.a69));
                } else {
                    c20196a.knW.setVisibility(8);
                    c20196a.knU.setVisibility(8);
                    c20196a.knV.setVisibility(8);
                    c20196a.khS.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.f6514gp));
                    c20196a.khV.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11835is));
                    c20196a.khU.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11835is));
                }
            }
        } else if (!(c42837b.aZZ().equals("PRIVATE_TICKET_TITLE") || c42837b.aZZ().equals("PRIVATE_INVOICE_TITLE") || c42837b.aZH())) {
            c20196a.khT.setVisibility(8);
            c20196a.khV.setVisibility(8);
            c20196a.khU.setVisibility(8);
            c20196a.knT.setVisibility(8);
            c20196a.khY.setVisibility(0);
            c20196a.khS.setBackgroundDrawable(C38736l.m65725dI(this.mContext.getResources().getColor(C25738R.color.f11850jb), this.knR));
            c20196a.khY.setText(this.mContext.getResources().getString(C25738R.string.agb));
        }
        if (!(c42837b.aZZ().equals("PRIVATE_TICKET_TITLE") || c42837b.aZZ().equals("PRIVATE_INVOICE_TITLE") || c42837b.aZH())) {
            c42837b.aZV();
            LayoutParams layoutParams;
            if (i != this.khG.getCount() - 1 || c20196a.khS == null) {
                layoutParams = (LayoutParams) c20196a.khS.getLayoutParams();
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    c20196a.khS.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams = (LayoutParams) c20196a.khS.getLayoutParams();
                if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le)) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le);
                    c20196a.khS.setLayoutParams(layoutParams);
                }
            }
        }
        AppMethodBeat.m2505o(88796);
        return view;
    }

    /* renamed from: R */
    public final void mo6877R(View view, int i) {
        AppMethodBeat.m2504i(88797);
        ((C2783a) view.getTag()).knS.setImageResource(i);
        AppMethodBeat.m2505o(88797);
    }

    /* renamed from: S */
    public final void mo6878S(View view, int i) {
        AppMethodBeat.m2504i(88798);
        ((C2783a) view.getTag()).knS.setVisibility(i);
        AppMethodBeat.m2505o(88798);
    }

    /* renamed from: a */
    public final void mo6880a(View view, int i, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(88799);
        CardInfo cardInfo = (CardInfo) this.khG.getItem(i);
        if (cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") || cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            AppMethodBeat.m2505o(88799);
            return;
        }
        C20196a c20196a = (C20196a) view.getTag();
        c20196a.knS.setTag(Integer.valueOf(i));
        c20196a.knS.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(88799);
    }
}
