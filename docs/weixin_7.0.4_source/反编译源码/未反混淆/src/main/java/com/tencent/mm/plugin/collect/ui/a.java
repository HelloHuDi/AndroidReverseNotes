package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a extends BaseAdapter {
    List<com.tencent.mm.plugin.collect.model.a> kFl = new ArrayList();
    private Context mContext;

    static class a {
        TextView kEq;
        WalletTextView kFm;
        TextView kvI;

        public a(View view) {
            AppMethodBeat.i(41168);
            this.kvI = (TextView) view.findViewById(R.id.axr);
            this.kFm = (WalletTextView) view.findViewById(R.id.axs);
            this.kEq = (TextView) view.findViewById(R.id.axt);
            AppMethodBeat.o(41168);
        }
    }

    public a(Context context) {
        AppMethodBeat.i(41169);
        this.mContext = context;
        AppMethodBeat.o(41169);
    }

    public final int getCount() {
        AppMethodBeat.i(41170);
        int size = this.kFl.size();
        AppMethodBeat.o(41170);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(41171);
        Object obj = this.kFl.get(i);
        AppMethodBeat.o(41171);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(41172);
        if (view == null) {
            view = v.hu(this.mContext).inflate(R.layout.ou, viewGroup, false);
            view.setTag(new a(view));
        }
        com.tencent.mm.plugin.collect.model.a aVar = (com.tencent.mm.plugin.collect.model.a) this.kFl.get(i);
        a aVar2 = (a) view.getTag();
        aVar2.kvI.setText(new SimpleDateFormat(this.mContext.getString(R.string.ara)).format(new Date(aVar.timestamp * 1000)));
        aVar2.kFm.setText(e.tG(aVar.cuY));
        if (bo.isNullOrNil(aVar.desc)) {
            aVar2.kEq.setVisibility(8);
        } else {
            aVar2.kEq.setText(aVar.desc);
            aVar2.kEq.setVisibility(0);
        }
        AppMethodBeat.o(41172);
        return view;
    }
}
