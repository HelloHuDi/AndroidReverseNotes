package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private Context mContext;
    public List<com.tencent.mm.plugin.recharge.model.a> pGC = new ArrayList();
    public boolean pGD = false;
    private List<com.tencent.mm.plugin.recharge.model.a> pGE;
    private String pGG;
    private AutoCompleteTextView pGt;
    private List<String[]> pGw;
    private b pIT;
    public d pIU = null;
    public a pIV = null;
    private MallFormView pIg;

    public interface a {
        void cen();
    }

    class b extends Filter {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final|declared_synchronized */
        public final synchronized FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            AppMethodBeat.i(44407);
            FilterResults filterResults2 = new FilterResults();
            ArrayList arrayList = new ArrayList();
            String ws = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.ws(charSequence.toString()) : "";
            if (!ws.equals(d.this.pGG) || ws.equals("")) {
                boolean z;
                d.this.pGG = ws;
                if (d.this.pIg.asa()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ab.i(d.TAG, "performFiltering2 ".concat(String.valueOf(charSequence)));
                    com.tencent.mm.plugin.recharge.model.a cec = com.tencent.mm.plugin.recharge.a.a.cec();
                    if (cec == null || !ws.equals(cec.pFM)) {
                        if (d.this.pGw == null || d.this.pGw.isEmpty()) {
                            d.this.pGw = com.tencent.mm.pluginsdk.a.cJ(d.this.mContext);
                        }
                        if (d.this.pGw != null) {
                            for (String[] strArr : d.this.pGw) {
                                String ws2 = com.tencent.mm.plugin.recharge.model.b.ws(strArr[2]);
                                int[] fJ = fJ(d.this.pGG, ws2);
                                if (com.tencent.mm.plugin.recharge.model.a.pFK.equals(fJ)) {
                                    AppMethodBeat.o(44407);
                                    filterResults = filterResults2;
                                    break;
                                } else if (!com.tencent.mm.plugin.recharge.model.a.pFL.equals(fJ) && arrayList.size() < 4) {
                                    com.tencent.mm.plugin.recharge.model.a aVar = new com.tencent.mm.plugin.recharge.model.a(ws2, strArr[1], 1);
                                    aVar.pFO = fJ;
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        for (com.tencent.mm.plugin.recharge.model.a aVar2 : com.tencent.mm.plugin.recharge.a.a.cea().ceb()) {
                            int[] fJ2 = fJ(d.this.pGG, com.tencent.mm.plugin.recharge.model.b.ws(aVar2.pFM));
                            if (com.tencent.mm.plugin.recharge.model.a.pFK.equals(fJ2)) {
                                AppMethodBeat.o(44407);
                                filterResults = filterResults2;
                                break;
                            } else if (!com.tencent.mm.plugin.recharge.model.a.pFL.equals(fJ2) && arrayList.size() < 4) {
                                aVar2.pFO = fJ2;
                                arrayList.add(aVar2);
                            }
                        }
                        ab.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else {
                        AppMethodBeat.o(44407);
                        filterResults = filterResults2;
                    }
                } else if (bo.isNullOrNil(d.this.pGG)) {
                    arrayList.addAll(d.this.pGE);
                    z = false;
                } else {
                    ab.i(d.TAG, "performFiltering1 ".concat(String.valueOf(charSequence)));
                    for (com.tencent.mm.plugin.recharge.model.a aVar22 : d.this.pGE) {
                        if (aVar22.pFM.startsWith(d.this.pGG)) {
                            arrayList.add(aVar22);
                        }
                    }
                    z = false;
                }
                filterResults2.count = arrayList.size();
                filterResults2.values = arrayList;
                d.this.pGD = z;
                if (arrayList.size() == 0) {
                    d.this.pIg.pIQ = true;
                } else {
                    d.this.pIg.pIQ = false;
                }
                AppMethodBeat.o(44407);
                filterResults = filterResults2;
            } else {
                d.this.pGt.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(44406);
                        d.this.pGt.dismissDropDown();
                        AppMethodBeat.o(44406);
                    }
                });
                AppMethodBeat.o(44407);
                filterResults = filterResults2;
            }
            return filterResults;
        }

        /* Access modifiers changed, original: protected|final */
        public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.i(44408);
            if (filterResults.values == null) {
                d.this.pGC = new ArrayList();
            } else {
                d.this.pGC = (List) filterResults.values;
            }
            if (filterResults.count == 0) {
                d.this.pIg.pIQ = true;
            } else {
                d.this.pIg.pIQ = false;
            }
            ab.i(d.TAG, "results.count " + filterResults.count);
            if (filterResults.count > 0) {
                d.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(44408);
        }

        private static int[] fJ(String str, String str2) {
            AppMethodBeat.i(44409);
            int[] iArr;
            if (str.equals(str2)) {
                iArr = com.tencent.mm.plugin.recharge.model.a.pFK;
                AppMethodBeat.o(44409);
                return iArr;
            }
            if (str2 != null && str.length() == str2.length()) {
                int i = 0;
                int[] iArr2 = new int[]{-1, -1};
                for (int length = str.length() - 1; length > 0; length--) {
                    if (str2.charAt(length) != str.charAt(length)) {
                        i++;
                        if (i > 2) {
                            break;
                        }
                        iArr2[i - 1] = length;
                    }
                }
                if (i <= 2) {
                    AppMethodBeat.o(44409);
                    return iArr2;
                }
            }
            iArr = com.tencent.mm.plugin.recharge.model.a.pFL;
            AppMethodBeat.o(44409);
            return iArr;
        }
    }

    class c {
        TextView gtb;
        TextView pGK;
        ImageView pIY;

        private c() {
        }

        /* synthetic */ c(d dVar, byte b) {
            this();
        }
    }

    public interface d {
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(44417);
        com.tencent.mm.plugin.recharge.model.a BA = BA(i);
        AppMethodBeat.o(44417);
        return BA;
    }

    public d(MallFormView mallFormView, List<String[]> list) {
        AppMethodBeat.i(44410);
        this.mContext = mallFormView.getContext();
        this.pIg = mallFormView;
        this.pGt = (AutoCompleteTextView) mallFormView.getContentEditText();
        this.pGw = list;
        AppMethodBeat.o(44410);
    }

    public final synchronized void cK(List<com.tencent.mm.plugin.recharge.model.a> list) {
        AppMethodBeat.i(44411);
        this.pGE = list;
        this.pGC.clear();
        this.pGD = false;
        notifyDataSetChanged();
        AppMethodBeat.o(44411);
    }

    public final Filter getFilter() {
        AppMethodBeat.i(44412);
        ab.d(TAG, "getFilter");
        if (this.pIT == null) {
            this.pIT = new b(this, (byte) 0);
        }
        b bVar = this.pIT;
        AppMethodBeat.o(44412);
        return bVar;
    }

    public final int getCount() {
        AppMethodBeat.i(44413);
        int size;
        if (this.pGD) {
            size = this.pGC.size() + 2;
            AppMethodBeat.o(44413);
            return size;
        } else if (this.pGC.size() > 0) {
            size = this.pGC.size() + 1;
            AppMethodBeat.o(44413);
            return size;
        } else {
            AppMethodBeat.o(44413);
            return 0;
        }
    }

    public final synchronized com.tencent.mm.plugin.recharge.model.a BA(int i) {
        com.tencent.mm.plugin.recharge.model.a aVar = null;
        synchronized (this) {
            AppMethodBeat.i(44414);
            if (this.pGD) {
                if (i == 0) {
                    AppMethodBeat.o(44414);
                } else if (i <= this.pGC.size()) {
                    aVar = (com.tencent.mm.plugin.recharge.model.a) this.pGC.get(i - 1);
                    AppMethodBeat.o(44414);
                } else {
                    AppMethodBeat.o(44414);
                }
            } else if (i < this.pGC.size()) {
                aVar = (com.tencent.mm.plugin.recharge.model.a) this.pGC.get(i);
                AppMethodBeat.o(44414);
            } else {
                AppMethodBeat.o(44414);
            }
        }
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(44415);
        switch (getItemViewType(i)) {
            case 0:
                c cVar;
                if (view == null) {
                    view = View.inflate(this.mContext, R.layout.ane, null);
                    c cVar2 = new c(this, (byte) 0);
                    cVar2.pGK = (TextView) view.findViewById(R.id.dw9);
                    cVar2.gtb = (TextView) view.findViewById(R.id.dw_);
                    cVar2.pIY = (ImageView) view.findViewById(R.id.dw8);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!(cVar == null || cVar.pIY == null)) {
                    if (i == 0) {
                        cVar.pIY.setVisibility(0);
                    } else {
                        cVar.pIY.setVisibility(8);
                    }
                }
                com.tencent.mm.plugin.recharge.model.a BA = BA(i);
                if (!(BA == null || cVar == null || cVar.pGK == null || cVar.gtb == null)) {
                    String VB = com.tencent.mm.plugin.recharge.model.b.VB(BA.pFM);
                    ab.d(TAG, "record.record " + VB + ", record.name " + BA.name + "，record.location " + BA.pFN);
                    if (com.tencent.mm.plugin.recharge.model.a.pFK.equals(BA.pFO)) {
                        cVar.pGK.setTextSize(16.0f);
                        cVar.pGK.setTextColor(this.mContext.getResources().getColor(R.color.s0));
                        cVar.gtb.setTextColor(this.mContext.getResources().getColor(R.color.s0));
                        cVar.pGK.setText(VB);
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(VB);
                        for (int i2 : BA.pFO) {
                            int i22;
                            if (i22 >= 0) {
                                if (i22 >= 7) {
                                    i22 += 2;
                                } else if (i22 >= 3) {
                                    i22++;
                                }
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.xs)), i22, i22 + 1, 34);
                            }
                        }
                        cVar.pGK.setTextSize(24.0f);
                        cVar.pGK.setTextColor(this.mContext.getResources().getColor(R.color.w4));
                        cVar.gtb.setTextColor(this.mContext.getResources().getColor(R.color.w4));
                        cVar.pGK.setText(spannableStringBuilder);
                    }
                    if (BA.name == null || bo.isNullOrNil(BA.name.trim())) {
                        if (!bo.isNullOrNil(BA.pFN)) {
                            cVar.gtb.setText(this.mContext.getString(R.string.fr7) + this.mContext.getString(R.string.fqx, new Object[]{BA.pFN}));
                            break;
                        }
                        cVar.gtb.setText(this.mContext.getString(R.string.fr7));
                        break;
                    }
                    if (bo.isNullOrNil(BA.pFN)) {
                        cVar.gtb.setText(BA.name);
                    } else {
                        cVar.gtb.setText(BA.name + this.mContext.getString(R.string.fqx, new Object[]{BA.pFN}));
                    }
                    if (!BA.name.equals(this.mContext.getString(R.string.fr5))) {
                        cVar.gtb.setTextColor(this.mContext.getResources().getColor(R.color.w0));
                        break;
                    }
                    cVar.gtb.setTextColor(this.mContext.getResources().getColor(R.color.xp));
                    break;
                }
                break;
            case 1:
                view = View.inflate(this.mContext, R.layout.anf, null);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44404);
                        com.tencent.mm.plugin.recharge.a.a.cea().cK(null);
                        d.this.pIg.cey();
                        d.this.cK(new LinkedList());
                        if (d.this.pIV != null) {
                            d.this.pIV.cen();
                        }
                        AppMethodBeat.o(44404);
                    }
                });
                break;
            case 2:
                view = View.inflate(this.mContext, R.layout.and, null);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44403);
                        d.this.pGt.dismissDropDown();
                        AppMethodBeat.o(44403);
                    }
                });
                break;
            case 3:
                view = View.inflate(this.mContext, R.layout.anf, null);
                ((TextView) view.findViewById(R.id.dwb)).setText(R.string.cyb);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44405);
                        d.this.pGt.dismissDropDown();
                        d.this.pIg.cex();
                        AppMethodBeat.o(44405);
                    }
                });
                break;
        }
        AppMethodBeat.o(44415);
        return view;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(44416);
        if (this.pGD) {
            if (i == 0) {
                AppMethodBeat.o(44416);
                return 2;
            } else if (i <= this.pGC.size()) {
                AppMethodBeat.o(44416);
                return 0;
            } else {
                AppMethodBeat.o(44416);
                return 3;
            }
        } else if (i < this.pGC.size()) {
            AppMethodBeat.o(44416);
            return 0;
        } else {
            AppMethodBeat.o(44416);
            return 1;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }
}
