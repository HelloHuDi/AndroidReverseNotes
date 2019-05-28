package com.tencent.p177mm.plugin.card.sharecard.p354ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C45773c;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.card.widget.CardTagTextView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.protocal.protobuf.cgf;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.j */
public final class C38756j implements C45773c {
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

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.j$a */
    public class C11299a {
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

    public C38756j(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.m2504i(88207);
        this.mContext = context;
        this.khG = baseAdapter;
        this.khJ = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9981m7);
        this.khK = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
        this.khL.clear();
        this.khM.clear();
        this.khN.clear();
        AppMethodBeat.m2505o(88207);
    }

    public final void release() {
        AppMethodBeat.m2504i(88208);
        this.mContext = null;
        this.khG = null;
        if (this.khI > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(6);
            iDKey2.SetValue((long) ((int) (this.khH / this.khI)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            C7060h.pYm.mo8379b(arrayList, true);
        }
        if (this.khL.size() == this.khM.size() && this.khM.size() == this.khN.size() && this.khL.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.khL.size(); i++) {
                C7060h.pYm.mo8381e(13220, this.khN.get(i), this.khM.get(i), this.khL.get(i), Long.valueOf(currentTimeMillis));
            }
        }
        this.khL.clear();
        this.khM.clear();
        this.khN.clear();
        if (this.khO != null) {
            this.khO.clear();
        }
        AppMethodBeat.m2505o(88208);
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
    /* renamed from: a */
    public final View mo6879a(int i, View view, C42837b c42837b) {
        C11299a c11299a;
        Object obj;
        AppMethodBeat.m2504i(88209);
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = View.inflate(this.mContext, 2130968974, null);
            C11299a c11299a2 = new C11299a();
            c11299a2.khP = (LinearLayout) view.findViewById(2131822295);
            c11299a2.khQ = (TextView) view.findViewById(2131822293);
            c11299a2.khR = (TextView) view.findViewById(2131822294);
            c11299a2.khS = (RelativeLayout) view.findViewById(2131821912);
            c11299a2.khT = (ImageView) view.findViewById(2131821914);
            c11299a2.khU = (TextView) view.findViewById(2131821915);
            c11299a2.khV = (TextView) view.findViewById(2131821917);
            c11299a2.khZ = view.findViewById(2131822297);
            c11299a2.khW = (TextView) view.findViewById(2131821920);
            c11299a2.khX = (TextView) view.findViewById(2131822298);
            c11299a2.khY = (TextView) view.findViewById(2131821921);
            c11299a2.kia = (TextView) view.findViewById(2131822296);
            c11299a2.khW.setEllipsize(TruncateAt.MIDDLE);
            view.setTag(c11299a2);
            c11299a = c11299a2;
        } else {
            c11299a = (C11299a) view.getTag();
        }
        C42837b c42837b2 = (C42837b) this.khG.getItem(i);
        int bae = c42837b2.bae();
        if (C42856b.m76089sS(c42837b2.bae())) {
            if (i == 0) {
                if (!TextUtils.isEmpty(c42837b2.mo45426sN(bae))) {
                    obj = 1;
                    if (obj != null) {
                        c11299a.khQ.setVisibility(0);
                        c11299a.khQ.setText(c42837b2.mo45426sN(bae));
                        if (TextUtils.isEmpty(c42837b2.bad())) {
                            c11299a.khR.setVisibility(8);
                        } else {
                            c11299a.khR.setVisibility(0);
                            c11299a.khR.setText(c42837b2.bad());
                        }
                    } else {
                        c11299a.khQ.setVisibility(8);
                        c11299a.khR.setVisibility(8);
                        c11299a.khQ.setText("");
                    }
                    if (c42837b.aZI()) {
                        c11299a.khT.setVisibility(0);
                        c11299a.khU.setVisibility(0);
                        c11299a.khP.setVisibility(0);
                        c11299a.khV.setVisibility(0);
                        c11299a.kia.setVisibility(0);
                        c11299a.khZ.setVisibility(0);
                        c11299a.khW.setVisibility(0);
                        c11299a.khX.setVisibility(0);
                        c11299a.khY.setVisibility(8);
                        c11299a.khU.setText(c42837b.aZV().kdg);
                        if (!c42837b.aZF()) {
                            c11299a.khV.setText(c42837b.aZV().title);
                        } else if (c42837b.aZV().vTW != null && c42837b.aZV().vTW.size() == 1) {
                            c11299a.khV.setText(((C23446tm) c42837b.aZV().vTW.get(0)).title);
                        } else if (c42837b.aZV().vTW != null && c42837b.aZV().vTW.size() == 2) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(((C23446tm) c42837b.aZV().vTW.get(0)).title);
                            stringBuilder.append("-");
                            stringBuilder.append(((C23446tm) c42837b.aZV().vTW.get(1)).title);
                            c11299a.khV.setText(stringBuilder.toString());
                        }
                        C45778m.m84644a(c11299a.khT, c42837b.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10255vx), (int) C25738R.drawable.bcm, true);
                        c11299a.khU.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11835is));
                        String GB = C42856b.m76072GB(c42837b.baa());
                        if (TextUtils.isEmpty(GB)) {
                            c11299a.khX.setText("");
                        } else {
                            c11299a.khX.setText(GB);
                        }
                        CharSequence rt = C42856b.m76086rt(c42837b.baa());
                        boolean sS = C42856b.m76089sS(c42837b.bae());
                        if (!TextUtils.isEmpty(rt) && sS) {
                            c11299a.khW.setText(C44089j.m79294b(this.mContext, rt, this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f10016ni)));
                        } else if (TextUtils.isEmpty(c42837b.bab())) {
                            c11299a.khW.setText("");
                        } else {
                            if (TextUtils.isEmpty(C38736l.m65703Hp(c42837b.bab()))) {
                                c11299a.khW.setText("");
                            } else {
                                c11299a.khW.setText(C44089j.m79294b(this.mContext, this.mContext.getResources().getString(C25738R.string.ah6, new Object[]{GB}), this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f10016ni)));
                            }
                        }
                        int GC = C42856b.m76073GC(c42837b.baa());
                        if (GC <= 1 || !sS) {
                            c11299a.kia.setVisibility(8);
                        } else {
                            c11299a.kia.setText("X".concat(String.valueOf(GC)));
                            c11299a.kia.setVisibility(0);
                        }
                        if ((c42837b.aZV().vUp == null || C5046bo.m7548ek(c42837b.aZV().vUp.xjK)) && !C42856b.m76075GE(c42837b.baa())) {
                            c11299a.khP.setVisibility(8);
                        } else {
                            c11299a.khP.setVisibility(0);
                            GC = 0;
                            while (true) {
                                int i2 = GC;
                                if (i2 >= c11299a.khP.getChildCount()) {
                                    break;
                                }
                                this.khO.add((CardTagTextView) c11299a.khP.getChildAt(i2));
                                GC = i2 + 1;
                            }
                            c11299a.khP.removeAllViews();
                            if (C42856b.m76075GE(c42837b.baa())) {
                                CardTagTextView bbY = bbY();
                                bbY.setPadding(this.khK, this.khJ, this.khK, this.khJ);
                                bbY.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12266xy));
                                bbY.setText(this.mContext.getString(C25738R.string.ahg));
                                bbY.setTextSize(12.0f);
                                LayoutParams layoutParams = new LayoutParams(-2, -2);
                                layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le);
                                c11299a.khP.addView(bbY, layoutParams);
                            }
                            if (!(c42837b.aZV().vUp == null || C5046bo.m7548ek(c42837b.aZV().vUp.xjK))) {
                                Iterator it = c42837b.aZV().vUp.xjK.iterator();
                                while (it.hasNext()) {
                                    cgf cgf = (cgf) it.next();
                                    CardTagTextView bbY2 = bbY();
                                    bbY2.setPadding(this.khK, this.khJ, this.khK, this.khJ);
                                    bbY2.setTextColor(C38736l.m65701Hn(cgf.color));
                                    bbY2.setText(cgf.tag);
                                    bbY2.setTextSize(12.0f);
                                    c11299a.khP.addView(bbY2);
                                }
                            }
                        }
                    } else {
                        c11299a.khT.setVisibility(8);
                        c11299a.khU.setVisibility(8);
                        c11299a.khP.setVisibility(8);
                        c11299a.khV.setVisibility(8);
                        c11299a.kia.setVisibility(8);
                        c11299a.khZ.setVisibility(8);
                        c11299a.khW.setVisibility(8);
                        c11299a.khX.setVisibility(8);
                        c11299a.khY.setVisibility(0);
                        c11299a.khY.setText(this.mContext.getResources().getString(C25738R.string.agb));
                    }
                    LayoutParams layoutParams2;
                    if (i != this.khG.getCount() - 1 && c11299a.khS != null) {
                        layoutParams2 = (LayoutParams) c11299a.khS.getLayoutParams();
                        if (layoutParams2.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le)) {
                            layoutParams2.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le);
                            c11299a.khS.setLayoutParams(layoutParams2);
                        }
                    } else if (c11299a.khS != null) {
                        layoutParams2 = (LayoutParams) c11299a.khS.getLayoutParams();
                        if (layoutParams2.bottomMargin != 0) {
                            layoutParams2.bottomMargin = 0;
                            c11299a.khS.setLayoutParams(layoutParams2);
                        }
                    }
                    this.khH = (System.currentTimeMillis() - currentTimeMillis) + this.khH;
                    this.khI++;
                    if (!this.khM.contains(c42837b.aZZ())) {
                        this.khM.add(c42837b.aZZ());
                        this.khN.add(c42837b.baa());
                        this.khL.add(Integer.valueOf(i));
                    }
                    AppMethodBeat.m2505o(88209);
                    return view;
                }
            } else if (bae != ((C42837b) this.khG.getItem(i - 1)).bae()) {
                obj = 1;
                if (obj != null) {
                }
                if (c42837b.aZI()) {
                }
                if (i != this.khG.getCount() - 1) {
                }
                if (c11299a.khS != null) {
                }
                this.khH = (System.currentTimeMillis() - currentTimeMillis) + this.khH;
                this.khI++;
                if (this.khM.contains(c42837b.aZZ())) {
                }
                AppMethodBeat.m2505o(88209);
                return view;
            }
        }
        obj = null;
        if (obj != null) {
        }
        if (c42837b.aZI()) {
        }
        if (i != this.khG.getCount() - 1) {
        }
        if (c11299a.khS != null) {
        }
        this.khH = (System.currentTimeMillis() - currentTimeMillis) + this.khH;
        this.khI++;
        if (this.khM.contains(c42837b.aZZ())) {
        }
        AppMethodBeat.m2505o(88209);
        return view;
    }

    /* renamed from: R */
    public final void mo6877R(View view, int i) {
    }

    /* renamed from: S */
    public final void mo6878S(View view, int i) {
    }

    /* renamed from: a */
    public final void mo6880a(View view, int i, OnClickListener onClickListener) {
    }

    private CardTagTextView bbY() {
        AppMethodBeat.m2504i(88210);
        CardTagTextView cardTagTextView;
        if (this.khO.size() == 0) {
            cardTagTextView = new CardTagTextView(this.mContext);
            AppMethodBeat.m2505o(88210);
            return cardTagTextView;
        }
        cardTagTextView = (CardTagTextView) this.khO.removeFirst();
        AppMethodBeat.m2505o(88210);
        return cardTagTextView;
    }
}
