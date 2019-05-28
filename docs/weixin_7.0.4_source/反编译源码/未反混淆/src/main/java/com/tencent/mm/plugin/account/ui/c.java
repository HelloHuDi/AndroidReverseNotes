package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private List<String> gAm;
    private ArrayList<String> gAn;
    private a gAo;
    private String gAp;
    private Context mContext;
    private final Object mLock = new Object();

    static class b {
        public TextView exj;

        b() {
        }
    }

    class a extends Filter {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final FilterResults performFiltering(CharSequence charSequence) {
            int i = 0;
            AppMethodBeat.i(124717);
            FilterResults filterResults = new FilterResults();
            if (c.this.gAn == null) {
                synchronized (c.this.mLock) {
                    try {
                        c.this.gAn = new ArrayList(c.this.gAm);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(124717);
                        }
                    }
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (c.this.mLock) {
                    try {
                        ArrayList arrayList = new ArrayList(c.this.gAn);
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(124717);
                        }
                    }
                }
            } else {
                String str;
                ArrayList a;
                int size;
                ArrayList arrayList2;
                String toLowerCase = charSequence.toString().toLowerCase();
                String str2 = "";
                if (c.this.gAp != null && c.this.gAp.length() > 0) {
                    String[] split = toLowerCase.split(c.this.gAp);
                    if (split != null && split.length > 1) {
                        str2 = split[0] + c.this.gAp;
                        str = split[1];
                        a = c.this.gAn;
                        size = a.size();
                        arrayList2 = new ArrayList(size);
                        while (i < size) {
                            toLowerCase = (String) a.get(i);
                            if (toLowerCase.toString().toLowerCase().startsWith(str)) {
                                arrayList2.add(str2 + toLowerCase);
                            }
                            i++;
                        }
                        filterResults.values = arrayList2;
                        filterResults.count = arrayList2.size();
                    }
                }
                str = toLowerCase;
                a = c.this.gAn;
                size = a.size();
                arrayList2 = new ArrayList(size);
                while (i < size) {
                }
                filterResults.values = arrayList2;
                filterResults.count = arrayList2.size();
            }
            AppMethodBeat.o(124717);
            return filterResults;
        }

        /* Access modifiers changed, original: protected|final */
        public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.i(124718);
            c.this.gAm = (List) filterResults.values;
            if (filterResults.count > 0) {
                c.this.notifyDataSetChanged();
                AppMethodBeat.o(124718);
                return;
            }
            c.this.notifyDataSetInvalidated();
            AppMethodBeat.o(124718);
        }
    }

    public c(Context context, String[] strArr, String str) {
        AppMethodBeat.i(124719);
        this.mContext = context;
        this.gAm = Arrays.asList(strArr);
        this.gAp = str;
        AppMethodBeat.o(124719);
    }

    public final int getCount() {
        AppMethodBeat.i(124720);
        int size = this.gAm.size();
        AppMethodBeat.o(124720);
        return size;
    }

    private String getItem(int i) {
        AppMethodBeat.i(124721);
        String str = (String) this.gAm.get(i);
        AppMethodBeat.o(124721);
        return str;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(124722);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.f2, null);
            b bVar2 = new b();
            bVar2.exj = (TextView) view.findViewById(R.id.a0_);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.exj.setText(getItem(i));
        view.setBackgroundResource(R.drawable.k5);
        AppMethodBeat.o(124722);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.i(124723);
        if (this.gAo == null) {
            this.gAo = new a(this, (byte) 0);
        }
        a aVar = this.gAo;
        AppMethodBeat.o(124723);
        return aVar;
    }
}
