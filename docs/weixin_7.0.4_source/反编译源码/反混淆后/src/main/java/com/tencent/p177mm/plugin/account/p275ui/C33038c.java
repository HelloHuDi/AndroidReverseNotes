package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.ui.c */
public final class C33038c extends BaseAdapter implements Filterable {
    private List<String> gAm;
    private ArrayList<String> gAn;
    private C33039a gAo;
    private String gAp;
    private Context mContext;
    private final Object mLock = new Object();

    /* renamed from: com.tencent.mm.plugin.account.ui.c$b */
    static class C26652b {
        public TextView exj;

        C26652b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.c$a */
    class C33039a extends Filter {
        private C33039a() {
        }

        /* synthetic */ C33039a(C33038c c33038c, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final FilterResults performFiltering(CharSequence charSequence) {
            int i = 0;
            AppMethodBeat.m2504i(124717);
            FilterResults filterResults = new FilterResults();
            if (C33038c.this.gAn == null) {
                synchronized (C33038c.this.mLock) {
                    try {
                        C33038c.this.gAn = new ArrayList(C33038c.this.gAm);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(124717);
                        }
                    }
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (C33038c.this.mLock) {
                    try {
                        ArrayList arrayList = new ArrayList(C33038c.this.gAn);
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(124717);
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
                if (C33038c.this.gAp != null && C33038c.this.gAp.length() > 0) {
                    String[] split = toLowerCase.split(C33038c.this.gAp);
                    if (split != null && split.length > 1) {
                        str2 = split[0] + C33038c.this.gAp;
                        str = split[1];
                        a = C33038c.this.gAn;
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
                a = C33038c.this.gAn;
                size = a.size();
                arrayList2 = new ArrayList(size);
                while (i < size) {
                }
                filterResults.values = arrayList2;
                filterResults.count = arrayList2.size();
            }
            AppMethodBeat.m2505o(124717);
            return filterResults;
        }

        /* Access modifiers changed, original: protected|final */
        public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AppMethodBeat.m2504i(124718);
            C33038c.this.gAm = (List) filterResults.values;
            if (filterResults.count > 0) {
                C33038c.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(124718);
                return;
            }
            C33038c.this.notifyDataSetInvalidated();
            AppMethodBeat.m2505o(124718);
        }
    }

    public C33038c(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(124719);
        this.mContext = context;
        this.gAm = Arrays.asList(strArr);
        this.gAp = str;
        AppMethodBeat.m2505o(124719);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(124720);
        int size = this.gAm.size();
        AppMethodBeat.m2505o(124720);
        return size;
    }

    private String getItem(int i) {
        AppMethodBeat.m2504i(124721);
        String str = (String) this.gAm.get(i);
        AppMethodBeat.m2505o(124721);
        return str;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C26652b c26652b;
        AppMethodBeat.m2504i(124722);
        if (view == null) {
            view = View.inflate(this.mContext, 2130968789, null);
            C26652b c26652b2 = new C26652b();
            c26652b2.exj = (TextView) view.findViewById(2131821554);
            view.setTag(c26652b2);
            c26652b = c26652b2;
        } else {
            c26652b = (C26652b) view.getTag();
        }
        c26652b.exj.setText(getItem(i));
        view.setBackgroundResource(C25738R.drawable.f6623k5);
        AppMethodBeat.m2505o(124722);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.m2504i(124723);
        if (this.gAo == null) {
            this.gAo = new C33039a(this, (byte) 0);
        }
        C33039a c33039a = this.gAo;
        AppMethodBeat.m2505o(124723);
        return c33039a;
    }
}
