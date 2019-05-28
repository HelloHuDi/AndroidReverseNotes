package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends a<com.tencent.mm.plugin.wenote.ui.nativenote.b.a> {
    private final String TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    private k uSJ;
    private g uUi;

    public c(k kVar) {
        AppMethodBeat.i(27143);
        this.uSJ = kVar;
        this.uUi = new g();
        AppMethodBeat.o(27143);
    }

    private synchronized void a(com.tencent.mm.plugin.wenote.ui.nativenote.b.a aVar, int i) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(27144);
            com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(i);
            if (Ke == null || Ke.getType() != aVar.dfW()) {
                String str = "MicroMsg.Note.NoteRecyclerViewAdapter";
                String str2 = "onBindViewHolder, item is null %b, position is %d";
                Object[] objArr = new Object[2];
                if (Ke != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(i);
                ab.e(str, str2, objArr);
                AppMethodBeat.o(27144);
            } else {
                aVar.a(Ke, i, Ke.getType());
                AppMethodBeat.o(27144);
            }
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(27145);
        com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(i);
        if (Ke != null) {
            int type = Ke.getType();
            AppMethodBeat.o(27145);
            return type;
        }
        ab.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", Integer.valueOf(i));
        AppMethodBeat.o(27145);
        return 0;
    }

    public final int getItemCount() {
        AppMethodBeat.i(27146);
        int size = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().size();
        AppMethodBeat.o(27146);
        return size;
    }
}
