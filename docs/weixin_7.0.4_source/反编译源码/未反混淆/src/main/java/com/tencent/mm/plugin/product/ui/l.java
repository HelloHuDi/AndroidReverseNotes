package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.product.b.n.a;
import java.util.List;

public final class l extends BaseAdapter {
    private Context mContext;
    List<a> pjG;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(44136);
        a AR = AR(i);
        AppMethodBeat.o(44136);
        return AR;
    }

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.i(44133);
        if (this.pjG != null) {
            int size = this.pjG.size();
            AppMethodBeat.o(44133);
            return size;
        }
        AppMethodBeat.o(44133);
        return 0;
    }

    private a AR(int i) {
        AppMethodBeat.i(44134);
        a aVar = (a) this.pjG.get(i);
        AppMethodBeat.o(44134);
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        x.a aVar;
        AppMethodBeat.i(44135);
        a AR = AR(i);
        if (view == null || view.getTag() == null) {
            m mVar = new m();
            view = View.inflate(this.mContext, R.layout.ale, null);
            mVar.gne = (TextView) view.findViewById(R.id.dp5);
            mVar.iyo = (ImageView) view.findViewById(R.id.dp4);
            view.setTag(mVar);
            aVar = mVar;
        } else {
            m aVar2 = (m) view.getTag();
        }
        aVar2.pjH = AR;
        aVar2.gne.setText(AR.title);
        aVar2.iyo.setImageBitmap(x.a(new c(AR.iconUrl)));
        x.a(aVar2);
        AppMethodBeat.o(44135);
        return view;
    }
}
