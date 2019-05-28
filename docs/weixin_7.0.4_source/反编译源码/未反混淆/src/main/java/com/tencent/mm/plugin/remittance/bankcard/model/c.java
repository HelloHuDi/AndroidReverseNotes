package com.tencent.mm.plugin.remittance.bankcard.model;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<TransferRecordParcel> pLU;
    private List<TransferRecordParcel> pLV = new ArrayList();
    private List<Pair<Integer, Integer>> pLW = new ArrayList();
    private Filter pLX;

    class a extends Filter {
        List<TransferRecordParcel> pLY;

        private a() {
            AppMethodBeat.i(44500);
            this.pLY = new ArrayList();
            AppMethodBeat.o(44500);
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        public final FilterResults performFiltering(CharSequence charSequence) {
            AppMethodBeat.i(44501);
            this.pLY.clear();
            c.this.pLW.clear();
            ab.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", charSequence);
            for (TransferRecordParcel transferRecordParcel : c.this.pLU) {
                if (!bo.ac(charSequence) && transferRecordParcel.pMf.contains(charSequence)) {
                    int indexOf = transferRecordParcel.pMf.indexOf((String) charSequence);
                    ab.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", transferRecordParcel.pMf, Integer.valueOf(indexOf), Integer.valueOf(charSequence.length() + indexOf));
                    c.this.pLW.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(r3)));
                    this.pLY.add(transferRecordParcel);
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.count = this.pLY.size();
            filterResults.values = this.pLY;
            AppMethodBeat.o(44501);
            return filterResults;
        }

        /* Access modifiers changed, original: protected|final */
        public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.i(44502);
            c.this.pLV = (List) filterResults.values;
            ab.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", Integer.valueOf(c.this.pLV.size()));
            c.this.notifyDataSetChanged();
            AppMethodBeat.o(44502);
        }
    }

    class b {
        CdnImageView pMa;
        TextView pMb;
        TextView pMc;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }

    public c(Context context, List<TransferRecordParcel> list) {
        AppMethodBeat.i(44503);
        this.mContext = context;
        this.pLU = list;
        AppMethodBeat.o(44503);
    }

    public final int getCount() {
        AppMethodBeat.i(44504);
        int size = this.pLV.size();
        AppMethodBeat.o(44504);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(44505);
        Object obj = this.pLV.get(i);
        AppMethodBeat.o(44505);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(44506);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.fy, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.pMa = (CdnImageView) view.findViewById(R.id.a3r);
            bVar.pMb = (TextView) view.findViewById(R.id.a3s);
            bVar.pMc = (TextView) view.findViewById(R.id.a3t);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
        Pair pair = (Pair) this.pLW.get(i);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.w4));
        SpannableString spannableString = new SpannableString(transferRecordParcel.pMf);
        spannableString.setSpan(foregroundColorSpan, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 18);
        bVar2.pMa.setUrl(transferRecordParcel.pLH);
        bVar2.pMb.setText(spannableString);
        bVar2.pMc.setText(this.mContext.getString(R.string.a51, new Object[]{transferRecordParcel.nuL, transferRecordParcel.pMe}));
        AppMethodBeat.o(44506);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.i(44507);
        if (this.pLX == null) {
            this.pLX = new a(this, (byte) 0);
        }
        Filter filter = this.pLX;
        AppMethodBeat.o(44507);
        return filter;
    }
}
