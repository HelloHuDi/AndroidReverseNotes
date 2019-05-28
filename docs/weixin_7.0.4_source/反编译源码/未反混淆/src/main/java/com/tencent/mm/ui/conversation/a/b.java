package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.ui.p;
import java.util.ArrayList;

public final class b extends p<c> {
    private ArrayList<c> gHf = new ArrayList();
    a zvR = null;

    public final /* bridge */ /* synthetic */ Object a(Object obj, Cursor cursor) {
        return null;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(34642);
        c Pz = Pz(i);
        AppMethodBeat.o(34642);
        return Pz;
    }

    public b(Context context) {
        super(context, null);
        AppMethodBeat.i(34636);
        KD();
        AppMethodBeat.o(34636);
    }

    public final void KD() {
        AppMethodBeat.i(34637);
        KC();
        AppMethodBeat.o(34637);
    }

    public final void KC() {
        AppMethodBeat.i(34638);
        this.gHf.clear();
        if (this.zvR == null) {
            AppMethodBeat.o(34638);
            return;
        }
        this.gHf.add(new c(this.zvR));
        notifyDataSetChanged();
        AppMethodBeat.o(34638);
    }

    public final int getCount() {
        AppMethodBeat.i(34639);
        int size = this.gHf.size();
        AppMethodBeat.o(34639);
        return size;
    }

    public final c Pz(int i) {
        AppMethodBeat.i(34640);
        c cVar = (c) this.gHf.get(i);
        AppMethodBeat.o(34640);
        return cVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        AppMethodBeat.i(34641);
        c cVar = (c) this.gHf.get(i);
        if (view == null) {
            view = View.inflate(this.context, R.layout.b5, null);
            d dVar2 = new d();
            dVar2.zvT = view;
            dVar2.zvU = (Button) view.findViewById(R.id.o5);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (cVar.a(dVar) != 0) {
            AppMethodBeat.o(34641);
            return null;
        }
        AppMethodBeat.o(34641);
        return view;
    }
}
