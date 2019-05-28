package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.plugin.collect.model.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    List<h> kFl = new ArrayList();
    private Context mContext;

    static class a {
        TextView kEq;
        WalletTextView kFm;
        TextView kFn;
        TextView kvI;

        public a(View view) {
            AppMethodBeat.i(41178);
            this.kvI = (TextView) view.findViewById(R.id.axy);
            this.kFn = (TextView) view.findViewById(R.id.axz);
            this.kFm = (WalletTextView) view.findViewById(R.id.ay0);
            this.kEq = (TextView) view.findViewById(R.id.ay1);
            AppMethodBeat.o(41178);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(41185);
        h tI = tI(i);
        AppMethodBeat.o(41185);
        return tI;
    }

    public b(Context context) {
        AppMethodBeat.i(41179);
        this.mContext = context;
        AppMethodBeat.o(41179);
    }

    public final int getCount() {
        AppMethodBeat.i(41180);
        int size = this.kFl.size();
        AppMethodBeat.o(41180);
        return size;
    }

    public final h tI(int i) {
        AppMethodBeat.i(41181);
        h hVar = (h) this.kFl.get(i);
        AppMethodBeat.o(41181);
        return hVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(41182);
        if (view == null) {
            view = v.hu(this.mContext).inflate(R.layout.ow, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        h tI = tI(i);
        aVar.kvI.setText(e.a(this.mContext, tI.kCc, tI.type));
        aVar.kFm.setText(e.tG(tI.kCe));
        aVar.kEq.setText(this.mContext.getString(R.string.arm, new Object[]{Integer.valueOf(tI.kCd)}));
        AppMethodBeat.o(41182);
        return view;
    }

    public final void setData(List<h> list) {
        AppMethodBeat.i(41183);
        this.kFl.clear();
        this.kFl.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.o(41183);
    }

    public final void bp(List<h> list) {
        AppMethodBeat.i(41184);
        this.kFl.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.o(41184);
    }
}
