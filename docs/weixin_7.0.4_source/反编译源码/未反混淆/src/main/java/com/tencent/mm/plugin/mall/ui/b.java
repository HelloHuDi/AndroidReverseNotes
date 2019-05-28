package com.tencent.mm.plugin.mall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private SparseArray<String> okS = null;
    private int okT;
    d olA;
    private boolean olB = true;
    private int olC = 0;
    private int olD = 0;
    private boolean olE = false;
    private boolean olF = false;
    private final int olw = 3;
    private final int olx = 9;
    private final int oly = 3;
    List<ArrayList<c>> olz = new ArrayList();

    class b {
        LinearLayout olU;
        TextView olV;
        View olW;
        View olX;
        View olY;
        ImageView olZ;
        TextView oma;
        View omb = null;
        View omc;

        b() {
        }
    }

    class c {
        MallFunction omd;
        int ome;

        c() {
        }
    }

    public interface d {
        void a(int i, MallFunction mallFunction);
    }

    class a {
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

        a() {
        }
    }

    public b(Context context, int i) {
        AppMethodBeat.i(43137);
        this.mContext = context;
        this.okT = i;
        this.mInflater = LayoutInflater.from(this.mContext);
        AppMethodBeat.o(43137);
    }

    public final void J(ArrayList<MallFunction> arrayList) {
        AppMethodBeat.i(43138);
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
                    c cVar = new c();
                    cVar.ome = i3 + i;
                    cVar.omd = (MallFunction) arrayList.get(i3 + i);
                    arrayList2.add(cVar);
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
                    if (i != -1 && i != ((c) arrayList3.get(0)).omd.type) {
                        break;
                    }
                    this.olC += arrayList3.size();
                    this.olD++;
                    i2 = ((c) arrayList3.get(0)).omd.type;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            this.olD--;
        }
        this.okS = j.bMV().yl(this.okT).okS;
        this.olE = bMZ();
        ab.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", Boolean.valueOf(this.olE));
        notifyDataSetChanged();
        AppMethodBeat.o(43138);
    }

    public final int getCount() {
        AppMethodBeat.i(43139);
        int size = this.olz.size();
        AppMethodBeat.o(43139);
        return size;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    private boolean yn(int i) {
        boolean z;
        AppMethodBeat.i(43140);
        if (this.olC > 9) {
            int i2 = 0;
            for (int i3 = 0; i3 <= i; i3++) {
                i2 += ((ArrayList) this.olz.get(i3)).size();
            }
            int i4 = this.olD > 3 ? 3 : this.olD;
            if (i2 >= 9) {
                if (this.olB && i == i4) {
                    z = true;
                    AppMethodBeat.o(43140);
                    return z;
                } else if (i == this.olD && !this.olB) {
                    z = true;
                    AppMethodBeat.o(43140);
                    return z;
                }
            }
        }
        z = false;
        AppMethodBeat.o(43140);
        return z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        boolean z;
        int i3;
        b bVar;
        int i4 = 3;
        AppMethodBeat.i(43141);
        boolean yn = yn(i);
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
            z = yn(i + 1);
        }
        if (yn) {
            i3 = 1;
        } else if (z) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (view == null) {
            b bVar2 = new b();
            view = this.mInflater.inflate(R.layout.abb, viewGroup, false);
            bVar2.olU = (LinearLayout) view.findViewById(R.id.d2g);
            bVar2.olV = (TextView) view.findViewById(R.id.d2f);
            bVar2.olW = view.findViewById(R.id.p3);
            bVar2.olX = view.findViewById(R.id.d2e);
            bVar2.olY = view.findViewById(R.id.d2h);
            bVar2.oma = (TextView) view.findViewById(R.id.d2i);
            bVar2.olZ = (ImageView) view.findViewById(R.id.d2j);
            bVar2.omb = view.findViewById(R.id.d2k);
            bVar2.omc = view.findViewById(R.id.d2l);
            bVar2.olY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43135);
                    b.this.olB = !b.this.olB;
                    b.this.olF = true;
                    b.this.notifyDataSetChanged();
                    AppMethodBeat.o(43135);
                }
            });
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (yn) {
            bVar.olV.setVisibility(8);
            bVar.olW.setVisibility(8);
            bVar.olX.setVisibility(8);
            bVar.olY.setVisibility(0);
            bVar.olZ.setImageResource(R.raw.wallet_arrow_down);
            bVar.oma.setText(this.mContext.getString(R.string.cwl));
            if (!this.olE || this.olF) {
                bVar.omb.setVisibility(8);
            } else {
                bVar.omb.setVisibility(0);
            }
            if (this.olB) {
                bVar.olU.setVisibility(8);
                bVar.oma.setText(this.mContext.getString(R.string.cwl));
            } else {
                bVar.olU.setVisibility(0);
                a(i, bVar, i3);
                bVar.olZ.setImageResource(R.raw.wallet_arrow_up);
                bVar.oma.setText(this.mContext.getString(R.string.cwk));
            }
        } else if (i2 <= 0 || !this.olB || i < i2 || i > this.olD) {
            bVar.olU.setVisibility(0);
            a(i, bVar, i3);
            bVar.olY.setVisibility(8);
            bVar.omb.setVisibility(8);
        } else {
            bVar.olU.setVisibility(8);
            bVar.olY.setVisibility(8);
            bVar.omb.setVisibility(8);
            bVar.olV.setVisibility(8);
            bVar.olW.setVisibility(8);
            bVar.olX.setVisibility(8);
        }
        if (i == getCount() - 1) {
            bVar.omc.setBackgroundColor(c.bNr());
            bVar.omc.setVisibility(0);
        } else {
            bVar.omc.setVisibility(8);
        }
        AppMethodBeat.o(43141);
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i, b bVar, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(43142);
        List list = (List) this.olz.get(i);
        list.get(0);
        Object obj;
        if (list.size() > 0) {
            Object i42;
            i3 = ((c) list.get(0)).omd.type;
            String yo = yo(i3);
            obj = null;
            if (!bo.isNullOrNil(yo)) {
                if (i == 0) {
                    obj = 1;
                } else if (((ArrayList) this.olz.get(i - 1)).size() > 0 && i3 != ((c) ((ArrayList) this.olz.get(i - 1)).get(0)).omd.type) {
                    int i5 = 1;
                }
                if (i == this.olz.size() - 1) {
                    i42 = 1;
                } else if (i3 != ((c) ((ArrayList) this.olz.get(i + 1)).get(0)).omd.type) {
                    i42 = 1;
                }
                if (obj == null) {
                    bVar.olV.setText(yo);
                    bVar.olV.setVisibility(0);
                    bVar.olW.setVisibility(8);
                    bVar.olX.setVisibility(0);
                    bVar.olV.setMinHeight(a.bMY());
                    bVar.olX.setBackgroundColor(c.bNr());
                    obj = i42;
                } else {
                    bVar.olV.setVisibility(8);
                    bVar.olW.setVisibility(8);
                    bVar.olX.setVisibility(8);
                    obj = i42;
                }
            }
            i42 = null;
            if (obj == null) {
            }
        } else {
            bVar.olV.setVisibility(8);
            bVar.olW.setVisibility(8);
            bVar.olX.setVisibility(8);
            obj = null;
        }
        LinearLayout linearLayout = bVar.olU;
        linearLayout.setFocusable(true);
        i42 = 0;
        while (true) {
            i3 = i42;
            if (i3 < 3) {
                View view;
                View p;
                a aVar;
                if (i3 >= linearLayout.getChildCount() || linearLayout.getChildAt(i3) == null) {
                    p = p(linearLayout);
                    if (i3 < list.size()) {
                        a(p, (c) list.get(i3), i3, i2);
                    } else {
                        p.setFocusable(true);
                        aVar = (a) p.getTag();
                        aVar.olJ.setVisibility(4);
                        p.setOnClickListener(null);
                        p.setEnabled(false);
                        p.setClickable(false);
                        a(aVar);
                    }
                    linearLayout.addView(p, new LayoutParams(-2, a.bMW(), 1.0f));
                    view = p;
                } else {
                    p = linearLayout.getChildAt(i3);
                    p.setVisibility(0);
                    if (i3 < list.size()) {
                        a(p, (c) list.get(i3), i3, i2);
                        view = p;
                    } else {
                        linearLayout.getChildAt(i3).setFocusable(true);
                        linearLayout.getChildAt(i3).setOnClickListener(null);
                        aVar = (a) linearLayout.getChildAt(i3).getTag();
                        aVar.olJ.setVisibility(4);
                        p.setEnabled(false);
                        p.setClickable(false);
                        a(aVar);
                        view = p;
                    }
                }
                if (i2 == 0 && r2 != null) {
                    if (i3 == 0) {
                        view.setBackground(this.mContext.getResources().getDrawable(R.drawable.tm));
                    } else if (i3 != 1) {
                        view.setBackground(this.mContext.getResources().getDrawable(R.drawable.tn));
                    }
                    i42 = i3 + 1;
                }
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.to));
                i42 = i3 + 1;
            } else {
                AppMethodBeat.o(43142);
                return;
            }
        }
    }

    private View p(ViewGroup viewGroup) {
        AppMethodBeat.i(43143);
        a aVar = new a();
        View inflate = this.mInflater.inflate(R.layout.abh, viewGroup, false);
        aVar.olJ = inflate.findViewById(R.id.d2z);
        aVar.olK = (ImageView) inflate.findViewById(R.id.d32);
        aVar.olM = (TextView) inflate.findViewById(R.id.d33);
        aVar.olN = (TextView) inflate.findViewById(R.id.d34);
        aVar.olL = (ImageView) inflate.findViewById(R.id.d30);
        aVar.olQ = (ImageView) inflate.findViewById(R.id.ckr);
        aVar.olR = (ImageView) inflate.findViewById(R.id.d36);
        aVar.olS = (ImageView) inflate.findViewById(R.id.cm0);
        aVar.olT = (ImageView) inflate.findViewById(R.id.d35);
        inflate.setTag(aVar);
        AppMethodBeat.o(43143);
        return inflate;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(43144);
        aVar.olQ.setVisibility(0);
        aVar.olR.setVisibility(4);
        aVar.olS.setVisibility(4);
        aVar.olT.setVisibility(4);
        AppMethodBeat.o(43144);
    }

    private static void a(a aVar, int i, int i2) {
        AppMethodBeat.i(43145);
        aVar.olT.setVisibility(4);
        if (i == 0) {
            aVar.olR.setVisibility(0);
        } else if (i == 1) {
            aVar.olR.setVisibility(0);
        } else if (i == 2) {
            aVar.olR.setVisibility(4);
        }
        if (i2 == 0) {
            aVar.olQ.setVisibility(0);
            aVar.olS.setVisibility(4);
            AppMethodBeat.o(43145);
        } else if (i2 == 1) {
            aVar.olQ.setVisibility(4);
            aVar.olS.setVisibility(0);
            AppMethodBeat.o(43145);
        } else {
            aVar.olQ.setVisibility(0);
            aVar.olS.setVisibility(0);
            AppMethodBeat.o(43145);
        }
    }

    private boolean bMZ() {
        AppMethodBeat.i(43146);
        if (this.olz.size() > 3) {
            ArrayList arrayList = (ArrayList) this.olz.get(3);
            if (arrayList != null && arrayList.size() > 0) {
                int i = ((c) arrayList.get(0)).omd.type;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.omd.type != i) {
                        break;
                    } else if (a(cVar.omd)) {
                        AppMethodBeat.o(43146);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(43146);
        return false;
    }

    public static boolean a(MallFunction mallFunction) {
        AppMethodBeat.i(43147);
        if (mallFunction.tDn == null || bo.isNullOrNil(mallFunction.tDn.tDv) || !b(mallFunction) || com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().acK(mallFunction.pFP) == null) {
            AppMethodBeat.o(43147);
            return false;
        }
        AppMethodBeat.o(43147);
        return true;
    }

    private void a(View view, c cVar, int i, int i2) {
        AppMethodBeat.i(43148);
        if (view == null) {
            AppMethodBeat.o(43148);
            return;
        }
        a aVar = (a) view.getTag();
        final MallFunction mallFunction = cVar.omd;
        final int i3 = cVar.ome;
        aVar.olP = mallFunction.olP;
        aVar.olO = mallFunction.olO;
        com.tencent.mm.plugin.mall.b.a.d(aVar.olK, aVar.olO, R.raw.mall_index_icon_default);
        aVar.olM.setText(mallFunction.cOI);
        aVar.olL.setVisibility(8);
        if (mallFunction.tDn == null || bo.isNullOrNil(mallFunction.tDn.tDv) || !b(mallFunction)) {
            if (mallFunction.tDn == null || mallFunction.tDn.tDA != 1) {
                aVar.olN.setText("");
                aVar.olN.setVisibility(4);
            } else {
                aVar.olN.setText(mallFunction.tDn.tDv);
                aVar.olN.setVisibility(0);
            }
            aVar.olL.setImageBitmap(null);
            aVar.olL.setVisibility(8);
        } else {
            if (com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().acK(mallFunction.pFP) != null) {
                ab.w("MicroMsg.FunctionListAdapter", "show the news : " + com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().acK(mallFunction.pFP).tDv);
                aVar.olN.setText(mallFunction.tDn.tDv);
                aVar.olN.setVisibility(0);
            } else {
                aVar.olN.setVisibility(4);
            }
            com.tencent.mm.plugin.mall.b.a.n(aVar.olL, aVar.olP);
            aVar.olL.setVisibility(0);
        }
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43136);
                ab.v("MicroMsg.FunctionListAdapter", "on Click");
                if (b.this.olA != null) {
                    b.this.olA.a(i3, mallFunction);
                }
                AppMethodBeat.o(43136);
            }
        });
        aVar.olJ.setVisibility(0);
        view.setEnabled(true);
        view.setClickable(true);
        a(aVar, i, i2);
        AppMethodBeat.o(43148);
    }

    private static boolean b(MallFunction mallFunction) {
        AppMethodBeat.i(43149);
        MallNews acK = com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().acK(mallFunction.pFP);
        if (acK == null || bo.isNullOrNil(acK.ssr) || !acK.ssr.equals(mallFunction.tDn.ssr)) {
            ab.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", mallFunction.tDn.ssr, mallFunction.cOI);
            com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().b(mallFunction.tDn);
            AppMethodBeat.o(43149);
            return true;
        } else if (acK == null) {
            AppMethodBeat.o(43149);
            return false;
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(acK.tDt)) {
            ab.d("MicroMsg.FunctionListAdapter", "still old news and should show");
            AppMethodBeat.o(43149);
            return true;
        } else {
            ab.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            AppMethodBeat.o(43149);
            return false;
        }
    }

    private String yo(int i) {
        AppMethodBeat.i(43150);
        if (this.okS == null) {
            AppMethodBeat.o(43150);
            return null;
        }
        String str = (String) this.okS.get(i);
        AppMethodBeat.o(43150);
        return str;
    }
}
