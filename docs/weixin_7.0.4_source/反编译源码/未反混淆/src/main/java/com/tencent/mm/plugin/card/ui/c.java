package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.p;

public class c extends p<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    private com.tencent.mm.plugin.card.base.c kgW;
    private a kiz;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(88245);
        obj = (CardInfo) obj;
        if (obj == null) {
            obj = new CardInfo();
        }
        if (cursor.isClosed()) {
            ab.e("MicroMsg.CardAdapter", "cursor is closed!");
            AppMethodBeat.o(88245);
        } else {
            obj.d(cursor);
            AppMethodBeat.o(88245);
        }
        return obj;
    }

    public c(Context context, a aVar) {
        super(context, new CardInfo());
        AppMethodBeat.i(88240);
        this.kiz = aVar;
        pN(true);
        this.kgW = new l(context, this);
        AppMethodBeat.o(88240);
    }

    public void KC() {
        AppMethodBeat.i(88241);
        ab.v("MicroMsg.CardAdapter", "resetCursor");
        bIf();
        Cursor a = am.baW().a(this.kiz);
        if (a != null) {
            this.count = a.getCount();
            ab.v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(a);
        notifyDataSetChanged();
        AppMethodBeat.o(88241);
    }

    public void KD() {
        AppMethodBeat.i(88242);
        bIf();
        KC();
        AppMethodBeat.o(88242);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(88243);
        View a = this.kgW.a(i, view, (CardInfo) getItem(i));
        AppMethodBeat.o(88243);
        return a;
    }

    public void release() {
        AppMethodBeat.i(88244);
        bIf();
        this.kgW.release();
        this.kgW = null;
        AppMethodBeat.o(88244);
    }
}
