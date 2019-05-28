package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g extends BaseAdapter {
    c kgW;
    List<b> khh;
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(88161);
        b sM = sM(i);
        AppMethodBeat.o(88161);
        return sM;
    }

    public final int getCount() {
        AppMethodBeat.i(88158);
        int size = this.khh.size();
        AppMethodBeat.o(88158);
        return size;
    }

    public final b sM(int i) {
        AppMethodBeat.i(88159);
        b bVar = (b) this.khh.get(i);
        AppMethodBeat.o(88159);
        return bVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(88160);
        View a = this.kgW.a(i, view, sM(i));
        AppMethodBeat.o(88160);
        return a;
    }
}
