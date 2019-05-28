package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.b.n;
import java.util.List;

public final class k extends BaseAdapter {
    private Context mContext;
    List<n> pjD;
    OnItemClickListener pjw;

    class a {
        public l pjE = null;
        public TextView pjx = null;
        public MaxGridView pjy = null;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(44132);
        n AQ = AQ(i);
        AppMethodBeat.o(44132);
        return AQ;
    }

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.i(44129);
        if (this.pjD != null) {
            int size = this.pjD.size();
            AppMethodBeat.o(44129);
            return size;
        }
        AppMethodBeat.o(44129);
        return 0;
    }

    private n AQ(int i) {
        AppMethodBeat.i(44130);
        n nVar = (n) this.pjD.get(i);
        AppMethodBeat.o(44130);
        return nVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(44131);
        n AQ = AQ(i);
        if (view == null || view.getTag() == null) {
            a aVar2 = new a();
            view = View.inflate(this.mContext, R.layout.alf, null);
            aVar2.pjx = (TextView) view.findViewById(R.id.dp6);
            aVar2.pjy = (MaxGridView) view.findViewById(R.id.dp7);
            aVar2.pjE = new l(this.mContext);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pjx.setText(AQ.name);
        aVar.pjy.setOnItemClickListener(this.pjw);
        aVar.pjE.pjG = AQ.phz;
        aVar.pjE.notifyDataSetChanged();
        aVar.pjy.setAdapter(aVar.pjE);
        AppMethodBeat.o(44131);
        return view;
    }
}
