package com.tencent.p177mm.plugin.recharge.p491ui.form;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.recharge.model.C43420a;
import com.tencent.p177mm.plugin.recharge.model.C43421b;
import com.tencent.p177mm.plugin.recharge.p1655a.C46158a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.recharge.ui.form.d */
public final class C43426d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private Context mContext;
    public List<C43420a> pGC = new ArrayList();
    public boolean pGD = false;
    private List<C43420a> pGE;
    private String pGG;
    private AutoCompleteTextView pGt;
    private List<String[]> pGw;
    private C43423b pIT;
    public C43425d pIU = null;
    public C43422a pIV = null;
    private MallFormView pIg;

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$1 */
    class C288221 implements OnClickListener {
        C288221() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44403);
            C43426d.this.pGt.dismissDropDown();
            AppMethodBeat.m2505o(44403);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$2 */
    class C288232 implements OnClickListener {
        C288232() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44404);
            C46158a.cea().mo74109cK(null);
            C43426d.this.pIg.cey();
            C43426d.this.mo68977cK(new LinkedList());
            if (C43426d.this.pIV != null) {
                C43426d.this.pIV.cen();
            }
            AppMethodBeat.m2505o(44404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$3 */
    class C288243 implements OnClickListener {
        C288243() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44405);
            C43426d.this.pGt.dismissDropDown();
            C43426d.this.pIg.cex();
            AppMethodBeat.m2505o(44405);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$a */
    public interface C43422a {
        void cen();
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$b */
    class C43423b extends Filter {

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$b$1 */
        class C347901 implements Runnable {
            C347901() {
            }

            public final void run() {
                AppMethodBeat.m2504i(44406);
                C43426d.this.pGt.dismissDropDown();
                AppMethodBeat.m2505o(44406);
            }
        }

        private C43423b() {
        }

        /* synthetic */ C43423b(C43426d c43426d, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final|declared_synchronized */
        public final synchronized FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            AppMethodBeat.m2504i(44407);
            FilterResults filterResults2 = new FilterResults();
            ArrayList arrayList = new ArrayList();
            String ws = charSequence != null ? C43421b.m77507ws(charSequence.toString()) : "";
            if (!ws.equals(C43426d.this.pGG) || ws.equals("")) {
                boolean z;
                C43426d.this.pGG = ws;
                if (C43426d.this.pIg.asa()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    C4990ab.m7416i(C43426d.TAG, "performFiltering2 ".concat(String.valueOf(charSequence)));
                    C43420a cec = C46158a.cec();
                    if (cec == null || !ws.equals(cec.pFM)) {
                        if (C43426d.this.pGw == null || C43426d.this.pGw.isEmpty()) {
                            C43426d.this.pGw = C46482a.m87692cJ(C43426d.this.mContext);
                        }
                        if (C43426d.this.pGw != null) {
                            for (String[] strArr : C43426d.this.pGw) {
                                String ws2 = C43421b.m77507ws(strArr[2]);
                                int[] fJ = C43423b.m77508fJ(C43426d.this.pGG, ws2);
                                if (C43420a.pFK.equals(fJ)) {
                                    AppMethodBeat.m2505o(44407);
                                    filterResults = filterResults2;
                                    break;
                                } else if (!C43420a.pFL.equals(fJ) && arrayList.size() < 4) {
                                    C43420a c43420a = new C43420a(ws2, strArr[1], 1);
                                    c43420a.pFO = fJ;
                                    arrayList.add(c43420a);
                                }
                            }
                        }
                        for (C43420a c43420a2 : C46158a.cea().ceb()) {
                            int[] fJ2 = C43423b.m77508fJ(C43426d.this.pGG, C43421b.m77507ws(c43420a2.pFM));
                            if (C43420a.pFK.equals(fJ2)) {
                                AppMethodBeat.m2505o(44407);
                                filterResults = filterResults2;
                                break;
                            } else if (!C43420a.pFL.equals(fJ2) && arrayList.size() < 4) {
                                c43420a2.pFO = fJ2;
                                arrayList.add(c43420a2);
                            }
                        }
                        C4990ab.m7410d(C43426d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else {
                        AppMethodBeat.m2505o(44407);
                        filterResults = filterResults2;
                    }
                } else if (C5046bo.isNullOrNil(C43426d.this.pGG)) {
                    arrayList.addAll(C43426d.this.pGE);
                    z = false;
                } else {
                    C4990ab.m7416i(C43426d.TAG, "performFiltering1 ".concat(String.valueOf(charSequence)));
                    for (C43420a c43420a22 : C43426d.this.pGE) {
                        if (c43420a22.pFM.startsWith(C43426d.this.pGG)) {
                            arrayList.add(c43420a22);
                        }
                    }
                    z = false;
                }
                filterResults2.count = arrayList.size();
                filterResults2.values = arrayList;
                C43426d.this.pGD = z;
                if (arrayList.size() == 0) {
                    C43426d.this.pIg.pIQ = true;
                } else {
                    C43426d.this.pIg.pIQ = false;
                }
                AppMethodBeat.m2505o(44407);
                filterResults = filterResults2;
            } else {
                C43426d.this.pGt.post(new C347901());
                AppMethodBeat.m2505o(44407);
                filterResults = filterResults2;
            }
            return filterResults;
        }

        /* Access modifiers changed, original: protected|final */
        public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.m2504i(44408);
            if (filterResults.values == null) {
                C43426d.this.pGC = new ArrayList();
            } else {
                C43426d.this.pGC = (List) filterResults.values;
            }
            if (filterResults.count == 0) {
                C43426d.this.pIg.pIQ = true;
            } else {
                C43426d.this.pIg.pIQ = false;
            }
            C4990ab.m7416i(C43426d.TAG, "results.count " + filterResults.count);
            if (filterResults.count > 0) {
                C43426d.this.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(44408);
        }

        /* renamed from: fJ */
        private static int[] m77508fJ(String str, String str2) {
            AppMethodBeat.m2504i(44409);
            int[] iArr;
            if (str.equals(str2)) {
                iArr = C43420a.pFK;
                AppMethodBeat.m2505o(44409);
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
                    AppMethodBeat.m2505o(44409);
                    return iArr2;
                }
            }
            iArr = C43420a.pFL;
            AppMethodBeat.m2505o(44409);
            return iArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$c */
    class C43424c {
        TextView gtb;
        TextView pGK;
        ImageView pIY;

        private C43424c() {
        }

        /* synthetic */ C43424c(C43426d c43426d, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$d */
    public interface C43425d {
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(44417);
        C43420a BA = mo68976BA(i);
        AppMethodBeat.m2505o(44417);
        return BA;
    }

    public C43426d(MallFormView mallFormView, List<String[]> list) {
        AppMethodBeat.m2504i(44410);
        this.mContext = mallFormView.getContext();
        this.pIg = mallFormView;
        this.pGt = (AutoCompleteTextView) mallFormView.getContentEditText();
        this.pGw = list;
        AppMethodBeat.m2505o(44410);
    }

    /* renamed from: cK */
    public final synchronized void mo68977cK(List<C43420a> list) {
        AppMethodBeat.m2504i(44411);
        this.pGE = list;
        this.pGC.clear();
        this.pGD = false;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(44411);
    }

    public final Filter getFilter() {
        AppMethodBeat.m2504i(44412);
        C4990ab.m7410d(TAG, "getFilter");
        if (this.pIT == null) {
            this.pIT = new C43423b(this, (byte) 0);
        }
        C43423b c43423b = this.pIT;
        AppMethodBeat.m2505o(44412);
        return c43423b;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44413);
        int size;
        if (this.pGD) {
            size = this.pGC.size() + 2;
            AppMethodBeat.m2505o(44413);
            return size;
        } else if (this.pGC.size() > 0) {
            size = this.pGC.size() + 1;
            AppMethodBeat.m2505o(44413);
            return size;
        } else {
            AppMethodBeat.m2505o(44413);
            return 0;
        }
    }

    /* renamed from: BA */
    public final synchronized C43420a mo68976BA(int i) {
        C43420a c43420a = null;
        synchronized (this) {
            AppMethodBeat.m2504i(44414);
            if (this.pGD) {
                if (i == 0) {
                    AppMethodBeat.m2505o(44414);
                } else if (i <= this.pGC.size()) {
                    c43420a = (C43420a) this.pGC.get(i - 1);
                    AppMethodBeat.m2505o(44414);
                } else {
                    AppMethodBeat.m2505o(44414);
                }
            } else if (i < this.pGC.size()) {
                c43420a = (C43420a) this.pGC.get(i);
                AppMethodBeat.m2505o(44414);
            } else {
                AppMethodBeat.m2505o(44414);
            }
        }
        return c43420a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(44415);
        switch (getItemViewType(i)) {
            case 0:
                C43424c c43424c;
                if (view == null) {
                    view = View.inflate(this.mContext, 2130970472, null);
                    C43424c c43424c2 = new C43424c(this, (byte) 0);
                    c43424c2.pGK = (TextView) view.findViewById(2131826879);
                    c43424c2.gtb = (TextView) view.findViewById(2131826880);
                    c43424c2.pIY = (ImageView) view.findViewById(2131826878);
                    view.setTag(c43424c2);
                    c43424c = c43424c2;
                } else {
                    c43424c = (C43424c) view.getTag();
                }
                if (!(c43424c == null || c43424c.pIY == null)) {
                    if (i == 0) {
                        c43424c.pIY.setVisibility(0);
                    } else {
                        c43424c.pIY.setVisibility(8);
                    }
                }
                C43420a BA = mo68976BA(i);
                if (!(BA == null || c43424c == null || c43424c.pGK == null || c43424c.gtb == null)) {
                    String VB = C43421b.m77503VB(BA.pFM);
                    C4990ab.m7410d(TAG, "record.record " + VB + ", record.name " + BA.name + "，record.location " + BA.pFN);
                    if (C43420a.pFK.equals(BA.pFO)) {
                        c43424c.pGK.setTextSize(16.0f);
                        c43424c.pGK.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12092s0));
                        c43424c.gtb.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12092s0));
                        c43424c.pGK.setText(VB);
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
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(C25738R.color.f12260xs)), i22, i22 + 1, 34);
                            }
                        }
                        c43424c.pGK.setTextSize(24.0f);
                        c43424c.pGK.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12212w4));
                        c43424c.gtb.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12212w4));
                        c43424c.pGK.setText(spannableStringBuilder);
                    }
                    if (BA.name == null || C5046bo.isNullOrNil(BA.name.trim())) {
                        if (!C5046bo.isNullOrNil(BA.pFN)) {
                            c43424c.gtb.setText(this.mContext.getString(C25738R.string.fr7) + this.mContext.getString(C25738R.string.fqx, new Object[]{BA.pFN}));
                            break;
                        }
                        c43424c.gtb.setText(this.mContext.getString(C25738R.string.fr7));
                        break;
                    }
                    if (C5046bo.isNullOrNil(BA.pFN)) {
                        c43424c.gtb.setText(BA.name);
                    } else {
                        c43424c.gtb.setText(BA.name + this.mContext.getString(C25738R.string.fqx, new Object[]{BA.pFN}));
                    }
                    if (!BA.name.equals(this.mContext.getString(C25738R.string.fr5))) {
                        c43424c.gtb.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12208w0));
                        break;
                    }
                    c43424c.gtb.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12257xp));
                    break;
                }
                break;
            case 1:
                view = View.inflate(this.mContext, 2130970473, null);
                view.setOnClickListener(new C288232());
                break;
            case 2:
                view = View.inflate(this.mContext, 2130970471, null);
                view.setOnClickListener(new C288221());
                break;
            case 3:
                view = View.inflate(this.mContext, 2130970473, null);
                ((TextView) view.findViewById(2131826882)).setText(C25738R.string.cyb);
                view.setOnClickListener(new C288243());
                break;
        }
        AppMethodBeat.m2505o(44415);
        return view;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(44416);
        if (this.pGD) {
            if (i == 0) {
                AppMethodBeat.m2505o(44416);
                return 2;
            } else if (i <= this.pGC.size()) {
                AppMethodBeat.m2505o(44416);
                return 0;
            } else {
                AppMethodBeat.m2505o(44416);
                return 3;
            }
        } else if (i < this.pGC.size()) {
            AppMethodBeat.m2505o(44416);
            return 0;
        } else {
            AppMethodBeat.m2505o(44416);
            return 1;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }
}
