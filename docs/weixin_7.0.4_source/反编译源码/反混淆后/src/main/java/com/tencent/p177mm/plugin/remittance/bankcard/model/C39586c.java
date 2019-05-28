package com.tencent.p177mm.plugin.remittance.bankcard.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.c */
public final class C39586c extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<TransferRecordParcel> pLU;
    private List<TransferRecordParcel> pLV = new ArrayList();
    private List<Pair<Integer, Integer>> pLW = new ArrayList();
    private Filter pLX;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.c$a */
    class C39587a extends Filter {
        List<TransferRecordParcel> pLY;

        private C39587a() {
            AppMethodBeat.m2504i(44500);
            this.pLY = new ArrayList();
            AppMethodBeat.m2505o(44500);
        }

        /* synthetic */ C39587a(C39586c c39586c, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        public final FilterResults performFiltering(CharSequence charSequence) {
            AppMethodBeat.m2504i(44501);
            this.pLY.clear();
            C39586c.this.pLW.clear();
            C4990ab.m7411d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", charSequence);
            for (TransferRecordParcel transferRecordParcel : C39586c.this.pLU) {
                if (!C5046bo.m7519ac(charSequence) && transferRecordParcel.pMf.contains(charSequence)) {
                    int indexOf = transferRecordParcel.pMf.indexOf((String) charSequence);
                    C4990ab.m7417i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", transferRecordParcel.pMf, Integer.valueOf(indexOf), Integer.valueOf(charSequence.length() + indexOf));
                    C39586c.this.pLW.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(r3)));
                    this.pLY.add(transferRecordParcel);
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.count = this.pLY.size();
            filterResults.values = this.pLY;
            AppMethodBeat.m2505o(44501);
            return filterResults;
        }

        /* Access modifiers changed, original: protected|final */
        public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.m2504i(44502);
            C39586c.this.pLV = (List) filterResults.values;
            C4990ab.m7417i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", Integer.valueOf(C39586c.this.pLV.size()));
            C39586c.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(44502);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.c$b */
    class C39588b {
        CdnImageView pMa;
        TextView pMb;
        TextView pMc;

        private C39588b() {
        }

        /* synthetic */ C39588b(C39586c c39586c, byte b) {
            this();
        }
    }

    public C39586c(Context context, List<TransferRecordParcel> list) {
        AppMethodBeat.m2504i(44503);
        this.mContext = context;
        this.pLU = list;
        AppMethodBeat.m2505o(44503);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44504);
        int size = this.pLV.size();
        AppMethodBeat.m2505o(44504);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(44505);
        Object obj = this.pLV.get(i);
        AppMethodBeat.m2505o(44505);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(44506);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130968822, viewGroup, false);
            C39588b c39588b = new C39588b(this, (byte) 0);
            c39588b.pMa = (CdnImageView) view.findViewById(2131821683);
            c39588b.pMb = (TextView) view.findViewById(2131821684);
            c39588b.pMc = (TextView) view.findViewById(2131821685);
            view.setTag(c39588b);
        }
        C39588b c39588b2 = (C39588b) view.getTag();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
        Pair pair = (Pair) this.pLW.get(i);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(C25738R.color.f12212w4));
        SpannableString spannableString = new SpannableString(transferRecordParcel.pMf);
        spannableString.setSpan(foregroundColorSpan, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 18);
        c39588b2.pMa.setUrl(transferRecordParcel.pLH);
        c39588b2.pMb.setText(spannableString);
        c39588b2.pMc.setText(this.mContext.getString(C25738R.string.a51, new Object[]{transferRecordParcel.nuL, transferRecordParcel.pMe}));
        AppMethodBeat.m2505o(44506);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.m2504i(44507);
        if (this.pLX == null) {
            this.pLX = new C39587a(this, (byte) 0);
        }
        Filter filter = this.pLX;
        AppMethodBeat.m2505o(44507);
        return filter;
    }
}
