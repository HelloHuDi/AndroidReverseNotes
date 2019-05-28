package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.a.b;

public final class e extends com.tencent.mm.ui.base.sortview.a {
    private static b jKQ;
    int Lp;
    long jKV;
    String jKW;
    String jMq;

    public static class a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView iqU;
    }

    public e(long j, int i, String str) {
        super(2, null);
        this.jKV = j;
        this.jKW = str;
        this.Lp = i;
    }

    public final b aVY() {
        AppMethodBeat.i(14019);
        if (jKQ == null) {
            jKQ = new b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    AppMethodBeat.i(14015);
                    if (!(context == null || aVar == null)) {
                        int i = 0;
                        if (objArr != null && objArr.length >= 2 && (objArr[1] instanceof Integer)) {
                            i = ((Integer) objArr[1]).intValue();
                        }
                        e eVar = (e) aVar;
                        Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                        intent.putExtra("keyword", eVar.jKW);
                        intent.putExtra("businessType", eVar.jKV);
                        intent.putExtra("offset", eVar.Lp);
                        intent.putExtra("showEditText", true);
                        intent.putExtra("fromScene", i);
                        context.startActivity(intent);
                    }
                    AppMethodBeat.o(14015);
                    return true;
                }

                public final View c(Context context, View view) {
                    AppMethodBeat.i(14016);
                    if (view == null) {
                        view = View.inflate(context, R.layout.aq5, null);
                    }
                    AppMethodBeat.o(14016);
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    AppMethodBeat.i(14017);
                    if (context == null || aVar == null || aVar2 == null) {
                        ab.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                        AppMethodBeat.o(14017);
                    } else if (!(aVar instanceof a)) {
                        ab.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                        AppMethodBeat.o(14017);
                    } else if (aVar2 instanceof e) {
                        ((a) aVar).iqU.setText(((e) aVar2).jMq);
                        AppMethodBeat.o(14017);
                    } else {
                        ab.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                        AppMethodBeat.o(14017);
                    }
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                    AppMethodBeat.i(14018);
                    if (!(view == null || aVar == null || !(aVar instanceof a))) {
                        ((a) aVar).iqU = (TextView) view.findViewById(R.id.big);
                    }
                    AppMethodBeat.o(14018);
                }
            };
        }
        b bVar = jKQ;
        AppMethodBeat.o(14019);
        return bVar;
    }

    public final com.tencent.mm.ui.base.sortview.a.a aVZ() {
        AppMethodBeat.i(14020);
        a aVar = new a();
        AppMethodBeat.o(14020);
        return aVar;
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        this.jMq = "";
    }
}
