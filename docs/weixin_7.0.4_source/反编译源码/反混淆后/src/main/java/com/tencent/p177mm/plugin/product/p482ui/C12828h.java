package com.tencent.p177mm.plugin.product.p482ui;

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
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.ui.h */
public final class C12828h extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<String> phg = null;
    private List<String> piX = null;
    Filter piY = new C36101();

    /* renamed from: com.tencent.mm.plugin.product.ui.h$1 */
    class C36101 extends Filter {
        C36101() {
        }

        /* Access modifiers changed, original: protected|final|declared_synchronized */
        public final synchronized void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.m2504i(44083);
            C12828h.this.phg = (List) filterResults.values;
            C12828h.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(44083);
        }

        /* Access modifiers changed, original: protected|final */
        public final FilterResults performFiltering(CharSequence charSequence) {
            AppMethodBeat.m2504i(44084);
            FilterResults filterResults = new FilterResults();
            ArrayList arrayList = new ArrayList();
            for (String str : C12828h.this.piX) {
                if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                    arrayList.add(str);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            AppMethodBeat.m2505o(44084);
            return filterResults;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.h$a */
    class C12829a {
        TextView piD;

        C12829a() {
        }
    }

    public C12828h(Context context) {
        AppMethodBeat.m2504i(44085);
        this.mContext = context;
        this.piX = C34676a.bZC().bZE().phg;
        AppMethodBeat.m2505o(44085);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44086);
        if (this.phg != null) {
            int size = this.phg.size();
            AppMethodBeat.m2505o(44086);
            return size;
        }
        AppMethodBeat.m2505o(44086);
        return 0;
    }

    private String getItem(int i) {
        AppMethodBeat.m2504i(44087);
        String str = (String) this.phg.get(i);
        AppMethodBeat.m2505o(44087);
        return str;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C12829a c12829a;
        AppMethodBeat.m2504i(44088);
        if (view == null) {
            C12829a c12829a2 = new C12829a();
            view = LayoutInflater.from(this.mContext).inflate(17367043, null);
            c12829a2.piD = (TextView) view.findViewById(16908308);
            view.setTag(c12829a2);
            c12829a = c12829a2;
        } else {
            c12829a = (C12829a) view.getTag();
        }
        c12829a.piD.setText(getItem(i));
        AppMethodBeat.m2505o(44088);
        return view;
    }

    public final Filter getFilter() {
        return this.piY;
    }
}
