package com.tencent.p177mm.plugin.mall.p451ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.mall.p1489b.C34508a;
import com.tencent.p177mm.plugin.mall.p450a.C43288j;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C46367d;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.mall.ui.b */
public final class C39355b extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private SparseArray<String> okS = null;
    private int okT;
    C28479d olA;
    private boolean olB = true;
    private int olC = 0;
    private int olD = 0;
    private boolean olE = false;
    private boolean olF = false;
    private final int olw = 3;
    private final int olx = 9;
    private final int oly = 3;
    List<ArrayList<C28478c>> olz = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.mall.ui.b$1 */
    class C34431 implements OnClickListener {
        C34431() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43135);
            C39355b.this.olB = !C39355b.this.olB;
            C39355b.this.olF = true;
            C39355b.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(43135);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.b$b */
    class C28477b {
        LinearLayout olU;
        TextView olV;
        View olW;
        View olX;
        View olY;
        ImageView olZ;
        TextView oma;
        View omb = null;
        View omc;

        C28477b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.b$c */
    class C28478c {
        MallFunction omd;
        int ome;

        C28478c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.b$d */
    public interface C28479d {
        /* renamed from: a */
        void mo36636a(int i, MallFunction mallFunction);
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.b$a */
    class C39354a {
        public View olJ = null;
        public ImageView olK = null;
        public ImageView olL = null;
        public TextView olM = null;
        public TextView olN = null;
        public String olO = null;
        public String olP = null;
        public ImageView olQ = null;
        public ImageView olR = null;
        public ImageView olS = null;
        public ImageView olT = null;

        C39354a() {
        }
    }

    public C39355b(Context context, int i) {
        AppMethodBeat.m2504i(43137);
        this.mContext = context;
        this.okT = i;
        this.mInflater = LayoutInflater.from(this.mContext);
        AppMethodBeat.m2505o(43137);
    }

    /* renamed from: J */
    public final void mo62243J(ArrayList<MallFunction> arrayList) {
        AppMethodBeat.m2504i(43138);
        this.olz.clear();
        if (arrayList != null) {
            int i;
            int i2;
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList arrayList2 = new ArrayList();
                i = 0;
                while (i < 3 && i3 + i < arrayList.size()) {
                    int i4 = i3 + i;
                    if (i > 0) {
                        i2 = (i3 + i) - 1;
                        if (i2 >= 0 && ((MallFunction) arrayList.get(i2)).type != ((MallFunction) arrayList.get(i4)).type) {
                            break;
                        }
                    }
                    C28478c c28478c = new C28478c();
                    c28478c.ome = i3 + i;
                    c28478c.omd = (MallFunction) arrayList.get(i3 + i);
                    arrayList2.add(c28478c);
                    i++;
                }
                if (arrayList2.size() > 0) {
                    this.olz.add(arrayList2);
                }
                i3 += i;
            }
            this.olC = 0;
            this.olD = 0;
            i = -1;
            for (ArrayList arrayList3 : this.olz) {
                if (arrayList3.size() > 0) {
                    if (i != -1 && i != ((C28478c) arrayList3.get(0)).omd.type) {
                        break;
                    }
                    this.olC += arrayList3.size();
                    this.olD++;
                    i2 = ((C28478c) arrayList3.get(0)).omd.type;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            this.olD--;
        }
        this.okS = C43288j.bMV().mo68836yl(this.okT).okS;
        this.olE = bMZ();
        C4990ab.m7417i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", Boolean.valueOf(this.olE));
        notifyDataSetChanged();
        AppMethodBeat.m2505o(43138);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(43139);
        int size = this.olz.size();
        AppMethodBeat.m2505o(43139);
        return size;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* renamed from: yn */
    private boolean m67119yn(int i) {
        boolean z;
        AppMethodBeat.m2504i(43140);
        if (this.olC > 9) {
            int i2 = 0;
            for (int i3 = 0; i3 <= i; i3++) {
                i2 += ((ArrayList) this.olz.get(i3)).size();
            }
            int i4 = this.olD > 3 ? 3 : this.olD;
            if (i2 >= 9) {
                if (this.olB && i == i4) {
                    z = true;
                    AppMethodBeat.m2505o(43140);
                    return z;
                } else if (i == this.olD && !this.olB) {
                    z = true;
                    AppMethodBeat.m2505o(43140);
                    return z;
                }
            }
        }
        z = false;
        AppMethodBeat.m2505o(43140);
        return z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        boolean z;
        int i3;
        C28477b c28477b;
        int i4 = 3;
        AppMethodBeat.m2504i(43141);
        boolean yn = m67119yn(i);
        if (this.olC > 9) {
            if (this.olD <= 3) {
                i4 = this.olD;
            }
            i2 = i4;
        } else {
            i2 = -1;
        }
        if (yn || i + 1 >= this.olz.size()) {
            z = false;
        } else {
            z = m67119yn(i + 1);
        }
        if (yn) {
            i3 = 1;
        } else if (z) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (view == null) {
            C28477b c28477b2 = new C28477b();
            view = this.mInflater.inflate(2130970024, viewGroup, false);
            c28477b2.olU = (LinearLayout) view.findViewById(2131825740);
            c28477b2.olV = (TextView) view.findViewById(2131825739);
            c28477b2.olW = view.findViewById(2131821128);
            c28477b2.olX = view.findViewById(2131825738);
            c28477b2.olY = view.findViewById(2131825741);
            c28477b2.oma = (TextView) view.findViewById(2131825742);
            c28477b2.olZ = (ImageView) view.findViewById(2131825743);
            c28477b2.omb = view.findViewById(2131825744);
            c28477b2.omc = view.findViewById(2131825745);
            c28477b2.olY.setOnClickListener(new C34431());
            view.setTag(c28477b2);
            c28477b = c28477b2;
        } else {
            c28477b = (C28477b) view.getTag();
        }
        if (yn) {
            c28477b.olV.setVisibility(8);
            c28477b.olW.setVisibility(8);
            c28477b.olX.setVisibility(8);
            c28477b.olY.setVisibility(0);
            c28477b.olZ.setImageResource(C1318a.wallet_arrow_down);
            c28477b.oma.setText(this.mContext.getString(C25738R.string.cwl));
            if (!this.olE || this.olF) {
                c28477b.omb.setVisibility(8);
            } else {
                c28477b.omb.setVisibility(0);
            }
            if (this.olB) {
                c28477b.olU.setVisibility(8);
                c28477b.oma.setText(this.mContext.getString(C25738R.string.cwl));
            } else {
                c28477b.olU.setVisibility(0);
                m67108a(i, c28477b, i3);
                c28477b.olZ.setImageResource(C1318a.wallet_arrow_up);
                c28477b.oma.setText(this.mContext.getString(C25738R.string.cwk));
            }
        } else if (i2 <= 0 || !this.olB || i < i2 || i > this.olD) {
            c28477b.olU.setVisibility(0);
            m67108a(i, c28477b, i3);
            c28477b.olY.setVisibility(8);
            c28477b.omb.setVisibility(8);
        } else {
            c28477b.olU.setVisibility(8);
            c28477b.olY.setVisibility(8);
            c28477b.omb.setVisibility(8);
            c28477b.olV.setVisibility(8);
            c28477b.olW.setVisibility(8);
            c28477b.olX.setVisibility(8);
        }
        if (i == getCount() - 1) {
            c28477b.omc.setBackgroundColor(C46068c.bNr());
            c28477b.omc.setVisibility(0);
        } else {
            c28477b.omc.setVisibility(8);
        }
        AppMethodBeat.m2505o(43141);
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m67108a(int i, C28477b c28477b, int i2) {
        int i3;
        int i4;
        AppMethodBeat.m2504i(43142);
        List list = (List) this.olz.get(i);
        list.get(0);
        Object obj;
        if (list.size() > 0) {
            Object i42;
            i3 = ((C28478c) list.get(0)).omd.type;
            String yo = m67120yo(i3);
            obj = null;
            if (!C5046bo.isNullOrNil(yo)) {
                if (i == 0) {
                    obj = 1;
                } else if (((ArrayList) this.olz.get(i - 1)).size() > 0 && i3 != ((C28478c) ((ArrayList) this.olz.get(i - 1)).get(0)).omd.type) {
                    int i5 = 1;
                }
                if (i == this.olz.size() - 1) {
                    i42 = 1;
                } else if (i3 != ((C28478c) ((ArrayList) this.olz.get(i + 1)).get(0)).omd.type) {
                    i42 = 1;
                }
                if (obj == null) {
                    c28477b.olV.setText(yo);
                    c28477b.olV.setVisibility(0);
                    c28477b.olW.setVisibility(8);
                    c28477b.olX.setVisibility(0);
                    c28477b.olV.setMinHeight(C43291a.bMY());
                    c28477b.olX.setBackgroundColor(C46068c.bNr());
                    obj = i42;
                } else {
                    c28477b.olV.setVisibility(8);
                    c28477b.olW.setVisibility(8);
                    c28477b.olX.setVisibility(8);
                    obj = i42;
                }
            }
            i42 = null;
            if (obj == null) {
            }
        } else {
            c28477b.olV.setVisibility(8);
            c28477b.olW.setVisibility(8);
            c28477b.olX.setVisibility(8);
            obj = null;
        }
        LinearLayout linearLayout = c28477b.olU;
        linearLayout.setFocusable(true);
        i42 = 0;
        while (true) {
            i3 = i42;
            if (i3 < 3) {
                View view;
                View p;
                C39354a c39354a;
                if (i3 >= linearLayout.getChildCount() || linearLayout.getChildAt(i3) == null) {
                    p = m67118p(linearLayout);
                    if (i3 < list.size()) {
                        m67109a(p, (C28478c) list.get(i3), i3, i2);
                    } else {
                        p.setFocusable(true);
                        c39354a = (C39354a) p.getTag();
                        c39354a.olJ.setVisibility(4);
                        p.setOnClickListener(null);
                        p.setEnabled(false);
                        p.setClickable(false);
                        C39355b.m67110a(c39354a);
                    }
                    linearLayout.addView(p, new LayoutParams(-2, C43291a.bMW(), 1.0f));
                    view = p;
                } else {
                    p = linearLayout.getChildAt(i3);
                    p.setVisibility(0);
                    if (i3 < list.size()) {
                        m67109a(p, (C28478c) list.get(i3), i3, i2);
                        view = p;
                    } else {
                        linearLayout.getChildAt(i3).setFocusable(true);
                        linearLayout.getChildAt(i3).setOnClickListener(null);
                        c39354a = (C39354a) linearLayout.getChildAt(i3).getTag();
                        c39354a.olJ.setVisibility(4);
                        p.setEnabled(false);
                        p.setClickable(false);
                        C39355b.m67110a(c39354a);
                        view = p;
                    }
                }
                if (i2 == 0 && r2 != null) {
                    if (i3 == 0) {
                        view.setBackground(this.mContext.getResources().getDrawable(C25738R.drawable.f6863tm));
                    } else if (i3 != 1) {
                        view.setBackground(this.mContext.getResources().getDrawable(C25738R.drawable.f6864tn));
                    }
                    i42 = i3 + 1;
                }
                view.setBackground(this.mContext.getResources().getDrawable(C25738R.drawable.f6865to));
                i42 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(43142);
                return;
            }
        }
    }

    /* renamed from: p */
    private View m67118p(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43143);
        C39354a c39354a = new C39354a();
        View inflate = this.mInflater.inflate(2130970030, viewGroup, false);
        c39354a.olJ = inflate.findViewById(2131825759);
        c39354a.olK = (ImageView) inflate.findViewById(2131825762);
        c39354a.olM = (TextView) inflate.findViewById(2131825763);
        c39354a.olN = (TextView) inflate.findViewById(2131825764);
        c39354a.olL = (ImageView) inflate.findViewById(2131825760);
        c39354a.olQ = (ImageView) inflate.findViewById(2131825086);
        c39354a.olR = (ImageView) inflate.findViewById(2131825766);
        c39354a.olS = (ImageView) inflate.findViewById(2131825132);
        c39354a.olT = (ImageView) inflate.findViewById(2131825765);
        inflate.setTag(c39354a);
        AppMethodBeat.m2505o(43143);
        return inflate;
    }

    /* renamed from: a */
    private static void m67110a(C39354a c39354a) {
        AppMethodBeat.m2504i(43144);
        c39354a.olQ.setVisibility(0);
        c39354a.olR.setVisibility(4);
        c39354a.olS.setVisibility(4);
        c39354a.olT.setVisibility(4);
        AppMethodBeat.m2505o(43144);
    }

    /* renamed from: a */
    private static void m67111a(C39354a c39354a, int i, int i2) {
        AppMethodBeat.m2504i(43145);
        c39354a.olT.setVisibility(4);
        if (i == 0) {
            c39354a.olR.setVisibility(0);
        } else if (i == 1) {
            c39354a.olR.setVisibility(0);
        } else if (i == 2) {
            c39354a.olR.setVisibility(4);
        }
        if (i2 == 0) {
            c39354a.olQ.setVisibility(0);
            c39354a.olS.setVisibility(4);
            AppMethodBeat.m2505o(43145);
        } else if (i2 == 1) {
            c39354a.olQ.setVisibility(4);
            c39354a.olS.setVisibility(0);
            AppMethodBeat.m2505o(43145);
        } else {
            c39354a.olQ.setVisibility(0);
            c39354a.olS.setVisibility(0);
            AppMethodBeat.m2505o(43145);
        }
    }

    private boolean bMZ() {
        AppMethodBeat.m2504i(43146);
        if (this.olz.size() > 3) {
            ArrayList arrayList = (ArrayList) this.olz.get(3);
            if (arrayList != null && arrayList.size() > 0) {
                int i = ((C28478c) arrayList.get(0)).omd.type;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C28478c c28478c = (C28478c) it.next();
                    if (c28478c.omd.type != i) {
                        break;
                    } else if (C39355b.m67114a(c28478c.omd)) {
                        AppMethodBeat.m2505o(43146);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(43146);
        return false;
    }

    /* renamed from: a */
    public static boolean m67114a(MallFunction mallFunction) {
        AppMethodBeat.m2504i(43147);
        if (mallFunction.tDn == null || C5046bo.isNullOrNil(mallFunction.tDn.tDv) || !C39355b.m67116b(mallFunction) || C46367d.cQX().acK(mallFunction.pFP) == null) {
            AppMethodBeat.m2505o(43147);
            return false;
        }
        AppMethodBeat.m2505o(43147);
        return true;
    }

    /* renamed from: a */
    private void m67109a(View view, C28478c c28478c, int i, int i2) {
        AppMethodBeat.m2504i(43148);
        if (view == null) {
            AppMethodBeat.m2505o(43148);
            return;
        }
        C39354a c39354a = (C39354a) view.getTag();
        final MallFunction mallFunction = c28478c.omd;
        final int i3 = c28478c.ome;
        c39354a.olP = mallFunction.olP;
        c39354a.olO = mallFunction.olO;
        C34508a.m56567d(c39354a.olK, c39354a.olO, C1318a.mall_index_icon_default);
        c39354a.olM.setText(mallFunction.cOI);
        c39354a.olL.setVisibility(8);
        if (mallFunction.tDn == null || C5046bo.isNullOrNil(mallFunction.tDn.tDv) || !C39355b.m67116b(mallFunction)) {
            if (mallFunction.tDn == null || mallFunction.tDn.tDA != 1) {
                c39354a.olN.setText("");
                c39354a.olN.setVisibility(4);
            } else {
                c39354a.olN.setText(mallFunction.tDn.tDv);
                c39354a.olN.setVisibility(0);
            }
            c39354a.olL.setImageBitmap(null);
            c39354a.olL.setVisibility(8);
        } else {
            if (C46367d.cQX().acK(mallFunction.pFP) != null) {
                C4990ab.m7420w("MicroMsg.FunctionListAdapter", "show the news : " + C46367d.cQX().acK(mallFunction.pFP).tDv);
                c39354a.olN.setText(mallFunction.tDn.tDv);
                c39354a.olN.setVisibility(0);
            } else {
                c39354a.olN.setVisibility(4);
            }
            C34508a.m56568n(c39354a.olL, c39354a.olP);
            c39354a.olL.setVisibility(0);
        }
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(43136);
                C4990ab.m7418v("MicroMsg.FunctionListAdapter", "on Click");
                if (C39355b.this.olA != null) {
                    C39355b.this.olA.mo36636a(i3, mallFunction);
                }
                AppMethodBeat.m2505o(43136);
            }
        });
        c39354a.olJ.setVisibility(0);
        view.setEnabled(true);
        view.setClickable(true);
        C39355b.m67111a(c39354a, i, i2);
        AppMethodBeat.m2505o(43148);
    }

    /* renamed from: b */
    private static boolean m67116b(MallFunction mallFunction) {
        AppMethodBeat.m2504i(43149);
        MallNews acK = C46367d.cQX().acK(mallFunction.pFP);
        if (acK == null || C5046bo.isNullOrNil(acK.ssr) || !acK.ssr.equals(mallFunction.tDn.ssr)) {
            C4990ab.m7411d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", mallFunction.tDn.ssr, mallFunction.cOI);
            C46367d.cQX().mo74580b(mallFunction.tDn);
            AppMethodBeat.m2505o(43149);
            return true;
        } else if (acK == null) {
            AppMethodBeat.m2505o(43149);
            return false;
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(acK.tDt)) {
            C4990ab.m7410d("MicroMsg.FunctionListAdapter", "still old news and should show");
            AppMethodBeat.m2505o(43149);
            return true;
        } else {
            C4990ab.m7410d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            AppMethodBeat.m2505o(43149);
            return false;
        }
    }

    /* renamed from: yo */
    private String m67120yo(int i) {
        AppMethodBeat.m2504i(43150);
        if (this.okS == null) {
            AppMethodBeat.m2505o(43150);
            return null;
        }
        String str = (String) this.okS.get(i);
        AppMethodBeat.m2505o(43150);
        return str;
    }
}
