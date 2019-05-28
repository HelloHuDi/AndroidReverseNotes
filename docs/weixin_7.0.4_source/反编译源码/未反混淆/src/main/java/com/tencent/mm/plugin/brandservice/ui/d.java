package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.a.b;

public final class d extends com.tencent.mm.ui.base.sortview.a {
    private static b jKQ;
    String jKR;

    public static class a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView jKK;
    }

    public d(Object obj) {
        super(1, obj);
    }

    public final b aVY() {
        AppMethodBeat.i(13940);
        if (jKQ == null) {
            jKQ = new b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    return true;
                }

                public final View c(Context context, View view) {
                    AppMethodBeat.i(13937);
                    if (view == null) {
                        view = View.inflate(context, R.layout.aq4, null);
                    }
                    AppMethodBeat.o(13937);
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    AppMethodBeat.i(13938);
                    if (context == null || aVar == null || aVar2 == null) {
                        ab.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                        AppMethodBeat.o(13938);
                    } else if (!(aVar instanceof a)) {
                        ab.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
                        AppMethodBeat.o(13938);
                    } else if (aVar2 instanceof d) {
                        com.tencent.mm.plugin.brandservice.b.a.b(((a) aVar).jKK, ((d) aVar2).jKR);
                        AppMethodBeat.o(13938);
                    } else {
                        ab.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
                        AppMethodBeat.o(13938);
                    }
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                    AppMethodBeat.i(13939);
                    if (!(view == null || aVar == null || !(aVar instanceof a))) {
                        ((a) aVar).jKK = (TextView) view.findViewById(R.id.a42);
                    }
                    AppMethodBeat.o(13939);
                }
            };
        }
        b bVar = jKQ;
        AppMethodBeat.o(13940);
        return bVar;
    }

    public final com.tencent.mm.ui.base.sortview.a.a aVZ() {
        AppMethodBeat.i(13941);
        a aVar = new a();
        AppMethodBeat.o(13941);
        return aVar;
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        if (this.data instanceof String) {
            this.jKR = (String) this.data;
        }
    }
}
