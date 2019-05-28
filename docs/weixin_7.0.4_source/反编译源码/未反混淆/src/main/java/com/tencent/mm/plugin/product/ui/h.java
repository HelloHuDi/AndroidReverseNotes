package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class h extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<String> phg = null;
    private List<String> piX = null;
    Filter piY = new Filter() {
        /* Access modifiers changed, original: protected|final|declared_synchronized */
        public final synchronized void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.i(44083);
            h.this.phg = (List) filterResults.values;
            h.this.notifyDataSetChanged();
            AppMethodBeat.o(44083);
        }

        /* Access modifiers changed, original: protected|final */
        public final FilterResults performFiltering(CharSequence charSequence) {
            AppMethodBeat.i(44084);
            FilterResults filterResults = new FilterResults();
            ArrayList arrayList = new ArrayList();
            for (String str : h.this.piX) {
                if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                    arrayList.add(str);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            AppMethodBeat.o(44084);
            return filterResults;
        }
    };

    class a {
        TextView piD;

        a() {
        }
    }

    public h(Context context) {
        AppMethodBeat.i(44085);
        this.mContext = context;
        this.piX = com.tencent.mm.plugin.product.a.a.bZC().bZE().phg;
        AppMethodBeat.o(44085);
    }

    public final int getCount() {
        AppMethodBeat.i(44086);
        if (this.phg != null) {
            int size = this.phg.size();
            AppMethodBeat.o(44086);
            return size;
        }
        AppMethodBeat.o(44086);
        return 0;
    }

    private String getItem(int i) {
        AppMethodBeat.i(44087);
        String str = (String) this.phg.get(i);
        AppMethodBeat.o(44087);
        return str;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(44088);
        if (view == null) {
            a aVar2 = new a();
            view = LayoutInflater.from(this.mContext).inflate(17367043, null);
            aVar2.piD = (TextView) view.findViewById(16908308);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.piD.setText(getItem(i));
        AppMethodBeat.o(44088);
        return view;
    }

    public final Filter getFilter() {
        return this.piY;
    }
}
