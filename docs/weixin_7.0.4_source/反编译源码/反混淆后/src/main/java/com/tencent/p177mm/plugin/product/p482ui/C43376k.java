package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.product.p481b.C12813n;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.ui.k */
public final class C43376k extends BaseAdapter {
    private Context mContext;
    List<C12813n> pjD;
    OnItemClickListener pjw;

    /* renamed from: com.tencent.mm.plugin.product.ui.k$a */
    class C39498a {
        public C43377l pjE = null;
        public TextView pjx = null;
        public MaxGridView pjy = null;

        C39498a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(44132);
        C12813n AQ = m77405AQ(i);
        AppMethodBeat.m2505o(44132);
        return AQ;
    }

    public C43376k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44129);
        if (this.pjD != null) {
            int size = this.pjD.size();
            AppMethodBeat.m2505o(44129);
            return size;
        }
        AppMethodBeat.m2505o(44129);
        return 0;
    }

    /* renamed from: AQ */
    private C12813n m77405AQ(int i) {
        AppMethodBeat.m2504i(44130);
        C12813n c12813n = (C12813n) this.pjD.get(i);
        AppMethodBeat.m2505o(44130);
        return c12813n;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C39498a c39498a;
        AppMethodBeat.m2504i(44131);
        C12813n AQ = m77405AQ(i);
        if (view == null || view.getTag() == null) {
            C39498a c39498a2 = new C39498a();
            view = View.inflate(this.mContext, 2130970399, null);
            c39498a2.pjx = (TextView) view.findViewById(2131826617);
            c39498a2.pjy = (MaxGridView) view.findViewById(2131826618);
            c39498a2.pjE = new C43377l(this.mContext);
            view.setTag(c39498a2);
            c39498a = c39498a2;
        } else {
            c39498a = (C39498a) view.getTag();
        }
        c39498a.pjx.setText(AQ.name);
        c39498a.pjy.setOnItemClickListener(this.pjw);
        c39498a.pjE.pjG = AQ.phz;
        c39498a.pjE.notifyDataSetChanged();
        c39498a.pjy.setAdapter(c39498a.pjE);
        AppMethodBeat.m2505o(44131);
        return view;
    }
}
