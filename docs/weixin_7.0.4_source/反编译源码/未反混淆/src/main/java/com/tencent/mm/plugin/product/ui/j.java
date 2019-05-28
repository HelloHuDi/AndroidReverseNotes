package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;

public final class j extends BaseAdapter {
    private Context mContext;
    m pjB;
    String pjC;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(44128);
        h AP = AP(i);
        AppMethodBeat.o(44128);
        return AP;
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.i(44124);
        if (this.pjB.phZ != null) {
            int size = this.pjB.phZ.size();
            AppMethodBeat.o(44124);
            return size;
        }
        AppMethodBeat.o(44124);
        return 0;
    }

    private h AP(int i) {
        AppMethodBeat.i(44125);
        h hVar = (h) this.pjB.phZ.get(i);
        AppMethodBeat.o(44125);
        return hVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        AppMethodBeat.i(44126);
        boolean z = AP(i).phS;
        AppMethodBeat.o(44126);
        return z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        AppMethodBeat.i(44127);
        h AP = AP(i);
        if (view == null || view.getTag() == null) {
            inflate = View.inflate(this.mContext, R.layout.alb, null);
        } else {
            inflate = view;
        }
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(AP.name);
        checkBox.setEnabled(AP.phS);
        checkBox.setChecked(AP.id.equals(this.pjC));
        if (!AP.phS) {
            inflate.setBackgroundResource(R.drawable.bex);
        } else if (AP.id.equals(this.pjC)) {
            inflate.setBackgroundResource(R.drawable.bez);
        } else {
            inflate.setBackgroundResource(R.drawable.bey);
        }
        inflate.setTag(new Pair(this.pjB.phX, AP.id));
        AppMethodBeat.o(44127);
        return inflate;
    }
}
