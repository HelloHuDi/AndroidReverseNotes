package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g extends BaseAdapter {
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(88545);
            int intValue = ((Integer) view.getTag()).intValue();
            g gVar = g.this;
            if (((Boolean) gVar.kmd.get(intValue)).booleanValue()) {
                gVar.kmd.set(intValue, Boolean.FALSE);
            } else {
                gVar.kmd.set(intValue, Boolean.TRUE);
            }
            gVar.notifyDataSetChanged();
            AppMethodBeat.o(88545);
        }
    };
    private boolean kdc = true;
    c kgW;
    List<CardInfo> khh = new ArrayList();
    private boolean kmc = false;
    List<Boolean> kmd = new ArrayList();
    a kme;
    Context mContext;

    public interface a {
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(88550);
        CardInfo sY = sY(i);
        AppMethodBeat.o(88550);
        return sY;
    }

    public g(Context context) {
        AppMethodBeat.i(88546);
        this.kgW = new l(context, this);
        this.mContext = context;
        AppMethodBeat.o(88546);
    }

    public final int getCount() {
        AppMethodBeat.i(88547);
        int size = this.khh.size();
        AppMethodBeat.o(88547);
        return size;
    }

    public final CardInfo sY(int i) {
        AppMethodBeat.i(88548);
        CardInfo cardInfo = (CardInfo) this.khh.get(i);
        AppMethodBeat.o(88548);
        return cardInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(88549);
        b sY = sY(i);
        sY.kdc = this.kdc;
        View a = this.kgW.a(i, view, sY);
        if (this.kmc && sY.aZI()) {
            this.kgW.S(a, 0);
            if (((Boolean) this.kmd.get(i)).booleanValue()) {
                this.kgW.R(a, R.drawable.g9);
            } else {
                this.kgW.R(a, R.drawable.g_);
            }
            this.kgW.a(a, i, this.gKK);
        } else {
            this.kgW.S(a, 8);
        }
        AppMethodBeat.o(88549);
        return a;
    }
}
