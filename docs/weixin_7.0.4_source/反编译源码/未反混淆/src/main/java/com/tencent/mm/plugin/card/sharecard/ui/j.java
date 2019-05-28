package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j implements c {
    private BaseAdapter khG;
    private long khH = 0;
    private long khI = 0;
    private int khJ;
    private int khK;
    private ArrayList<Integer> khL = new ArrayList();
    private ArrayList<String> khM = new ArrayList();
    private ArrayList<String> khN = new ArrayList();
    protected LinkedList<CardTagTextView> khO = new LinkedList();
    private Context mContext;

    public class a {
        public LinearLayout khP;
        public TextView khQ;
        public TextView khR;
        public RelativeLayout khS;
        public ImageView khT;
        public TextView khU;
        public TextView khV;
        public TextView khW;
        public TextView khX;
        public TextView khY;
        public View khZ;
        public TextView kia;
    }

    public j(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.i(88207);
        this.mContext = context;
        this.khG = baseAdapter;
        this.khJ = this.mContext.getResources().getDimensionPixelSize(R.dimen.m7);
        this.khK = this.mContext.getResources().getDimensionPixelSize(R.dimen.lo);
        this.khL.clear();
        this.khM.clear();
        this.khN.clear();
        AppMethodBeat.o(88207);
    }

    public final void release() {
        AppMethodBeat.i(88208);
        this.mContext = null;
        this.khG = null;
        if (this.khI > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(6);
            iDKey2.SetValue((long) ((int) (this.khH / this.khI)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.pYm.b(arrayList, true);
        }
        if (this.khL.size() == this.khM.size() && this.khM.size() == this.khN.size() && this.khL.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.khL.size(); i++) {
                h.pYm.e(13220, this.khN.get(i), this.khM.get(i), this.khL.get(i), Long.valueOf(currentTimeMillis));
            }
        }
        this.khL.clear();
        this.khM.clear();
        this.khN.clear();
        if (this.khO != null) {
            this.khO.clear();
        }
        AppMethodBeat.o(88208);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0456  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View a(int i, View view, b bVar) {
        a aVar;
        Object obj;
        AppMethodBeat.i(88209);
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.k2, null);
            a aVar2 = new a();
            aVar2.khP = (LinearLayout) view.findViewById(R.id.aja);
            aVar2.khQ = (TextView) view.findViewById(R.id.aj9);
            aVar2.khR = (TextView) view.findViewById(R.id.aj_);
            aVar2.khS = (RelativeLayout) view.findViewById(R.id.a9y);
            aVar2.khT = (ImageView) view.findViewById(R.id.a_0);
            aVar2.khU = (TextView) view.findViewById(R.id.a_1);
            aVar2.khV = (TextView) view.findViewById(R.id.a_3);
            aVar2.khZ = view.findViewById(R.id.ajc);
            aVar2.khW = (TextView) view.findViewById(R.id.a_6);
            aVar2.khX = (TextView) view.findViewById(R.id.ajd);
            aVar2.khY = (TextView) view.findViewById(R.id.a_7);
            aVar2.kia = (TextView) view.findViewById(R.id.ajb);
            aVar2.khW.setEllipsize(TruncateAt.MIDDLE);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b bVar2 = (b) this.khG.getItem(i);
        int bae = bVar2.bae();
        if (com.tencent.mm.plugin.card.sharecard.a.b.sS(bVar2.bae())) {
            if (i == 0) {
                if (!TextUtils.isEmpty(bVar2.sN(bae))) {
                    obj = 1;
                    if (obj != null) {
                        aVar.khQ.setVisibility(0);
                        aVar.khQ.setText(bVar2.sN(bae));
                        if (TextUtils.isEmpty(bVar2.bad())) {
                            aVar.khR.setVisibility(8);
                        } else {
                            aVar.khR.setVisibility(0);
                            aVar.khR.setText(bVar2.bad());
                        }
                    } else {
                        aVar.khQ.setVisibility(8);
                        aVar.khR.setVisibility(8);
                        aVar.khQ.setText("");
                    }
                    if (bVar.aZI()) {
                        aVar.khT.setVisibility(0);
                        aVar.khU.setVisibility(0);
                        aVar.khP.setVisibility(0);
                        aVar.khV.setVisibility(0);
                        aVar.kia.setVisibility(0);
                        aVar.khZ.setVisibility(0);
                        aVar.khW.setVisibility(0);
                        aVar.khX.setVisibility(0);
                        aVar.khY.setVisibility(8);
                        aVar.khU.setText(bVar.aZV().kdg);
                        if (!bVar.aZF()) {
                            aVar.khV.setText(bVar.aZV().title);
                        } else if (bVar.aZV().vTW != null && bVar.aZV().vTW.size() == 1) {
                            aVar.khV.setText(((tm) bVar.aZV().vTW.get(0)).title);
                        } else if (bVar.aZV().vTW != null && bVar.aZV().vTW.size() == 2) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(((tm) bVar.aZV().vTW.get(0)).title);
                            stringBuilder.append("-");
                            stringBuilder.append(((tm) bVar.aZV().vTW.get(1)).title);
                            aVar.khV.setText(stringBuilder.toString());
                        }
                        m.a(aVar.khT, bVar.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(R.dimen.vx), (int) R.drawable.bcm, true);
                        aVar.khU.setTextColor(this.mContext.getResources().getColor(R.color.is));
                        String GB = com.tencent.mm.plugin.card.sharecard.a.b.GB(bVar.baa());
                        if (TextUtils.isEmpty(GB)) {
                            aVar.khX.setText("");
                        } else {
                            aVar.khX.setText(GB);
                        }
                        CharSequence rt = com.tencent.mm.plugin.card.sharecard.a.b.rt(bVar.baa());
                        boolean sS = com.tencent.mm.plugin.card.sharecard.a.b.sS(bVar.bae());
                        if (!TextUtils.isEmpty(rt) && sS) {
                            aVar.khW.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, rt, this.mContext.getResources().getDimensionPixelOffset(R.dimen.ni)));
                        } else if (TextUtils.isEmpty(bVar.bab())) {
                            aVar.khW.setText("");
                        } else {
                            if (TextUtils.isEmpty(l.Hp(bVar.bab()))) {
                                aVar.khW.setText("");
                            } else {
                                aVar.khW.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, this.mContext.getResources().getString(R.string.ah6, new Object[]{GB}), this.mContext.getResources().getDimensionPixelOffset(R.dimen.ni)));
                            }
                        }
                        int GC = com.tencent.mm.plugin.card.sharecard.a.b.GC(bVar.baa());
                        if (GC <= 1 || !sS) {
                            aVar.kia.setVisibility(8);
                        } else {
                            aVar.kia.setText("X".concat(String.valueOf(GC)));
                            aVar.kia.setVisibility(0);
                        }
                        if ((bVar.aZV().vUp == null || bo.ek(bVar.aZV().vUp.xjK)) && !com.tencent.mm.plugin.card.sharecard.a.b.GE(bVar.baa())) {
                            aVar.khP.setVisibility(8);
                        } else {
                            aVar.khP.setVisibility(0);
                            GC = 0;
                            while (true) {
                                int i2 = GC;
                                if (i2 >= aVar.khP.getChildCount()) {
                                    break;
                                }
                                this.khO.add((CardTagTextView) aVar.khP.getChildAt(i2));
                                GC = i2 + 1;
                            }
                            aVar.khP.removeAllViews();
                            if (com.tencent.mm.plugin.card.sharecard.a.b.GE(bVar.baa())) {
                                CardTagTextView bbY = bbY();
                                bbY.setPadding(this.khK, this.khJ, this.khK, this.khJ);
                                bbY.setTextColor(this.mContext.getResources().getColor(R.color.xy));
                                bbY.setText(this.mContext.getString(R.string.ahg));
                                bbY.setTextSize(12.0f);
                                LayoutParams layoutParams = new LayoutParams(-2, -2);
                                layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.le);
                                aVar.khP.addView(bbY, layoutParams);
                            }
                            if (!(bVar.aZV().vUp == null || bo.ek(bVar.aZV().vUp.xjK))) {
                                Iterator it = bVar.aZV().vUp.xjK.iterator();
                                while (it.hasNext()) {
                                    cgf cgf = (cgf) it.next();
                                    CardTagTextView bbY2 = bbY();
                                    bbY2.setPadding(this.khK, this.khJ, this.khK, this.khJ);
                                    bbY2.setTextColor(l.Hn(cgf.color));
                                    bbY2.setText(cgf.tag);
                                    bbY2.setTextSize(12.0f);
                                    aVar.khP.addView(bbY2);
                                }
                            }
                        }
                    } else {
                        aVar.khT.setVisibility(8);
                        aVar.khU.setVisibility(8);
                        aVar.khP.setVisibility(8);
                        aVar.khV.setVisibility(8);
                        aVar.kia.setVisibility(8);
                        aVar.khZ.setVisibility(8);
                        aVar.khW.setVisibility(8);
                        aVar.khX.setVisibility(8);
                        aVar.khY.setVisibility(0);
                        aVar.khY.setText(this.mContext.getResources().getString(R.string.agb));
                    }
                    LayoutParams layoutParams2;
                    if (i != this.khG.getCount() - 1 && aVar.khS != null) {
                        layoutParams2 = (LayoutParams) aVar.khS.getLayoutParams();
                        if (layoutParams2.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.dimen.le)) {
                            layoutParams2.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.le);
                            aVar.khS.setLayoutParams(layoutParams2);
                        }
                    } else if (aVar.khS != null) {
                        layoutParams2 = (LayoutParams) aVar.khS.getLayoutParams();
                        if (layoutParams2.bottomMargin != 0) {
                            layoutParams2.bottomMargin = 0;
                            aVar.khS.setLayoutParams(layoutParams2);
                        }
                    }
                    this.khH = (System.currentTimeMillis() - currentTimeMillis) + this.khH;
                    this.khI++;
                    if (!this.khM.contains(bVar.aZZ())) {
                        this.khM.add(bVar.aZZ());
                        this.khN.add(bVar.baa());
                        this.khL.add(Integer.valueOf(i));
                    }
                    AppMethodBeat.o(88209);
                    return view;
                }
            } else if (bae != ((b) this.khG.getItem(i - 1)).bae()) {
                obj = 1;
                if (obj != null) {
                }
                if (bVar.aZI()) {
                }
                if (i != this.khG.getCount() - 1) {
                }
                if (aVar.khS != null) {
                }
                this.khH = (System.currentTimeMillis() - currentTimeMillis) + this.khH;
                this.khI++;
                if (this.khM.contains(bVar.aZZ())) {
                }
                AppMethodBeat.o(88209);
                return view;
            }
        }
        obj = null;
        if (obj != null) {
        }
        if (bVar.aZI()) {
        }
        if (i != this.khG.getCount() - 1) {
        }
        if (aVar.khS != null) {
        }
        this.khH = (System.currentTimeMillis() - currentTimeMillis) + this.khH;
        this.khI++;
        if (this.khM.contains(bVar.aZZ())) {
        }
        AppMethodBeat.o(88209);
        return view;
    }

    public final void R(View view, int i) {
    }

    public final void S(View view, int i) {
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
    }

    private CardTagTextView bbY() {
        AppMethodBeat.i(88210);
        CardTagTextView cardTagTextView;
        if (this.khO.size() == 0) {
            cardTagTextView = new CardTagTextView(this.mContext);
            AppMethodBeat.o(88210);
            return cardTagTextView;
        }
        cardTagTextView = (CardTagTextView) this.khO.removeFirst();
        AppMethodBeat.o(88210);
        return cardTagTextView;
    }
}
