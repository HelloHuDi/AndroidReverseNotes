package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.ui.base.l;

public final class c extends a {
    public c() {
        super(12);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6425);
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 2);
        intent.putExtra("key_fav_item_id", dVar.bPP.getLong("fav_local_id", -1));
        b.b(context, ".ui.FavTagEditUI", intent);
        h.pYm.k(982, 1, 1);
        AppMethodBeat.o(6425);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6424);
        boolean z = dVar.bPP.getBoolean("is_favorite_item", false);
        boolean z2 = dVar.bPP.getBoolean("key_detail_can_delete", true);
        if (z && z2) {
            lVar.a(12, context.getString(R.string.bnm), (int) R.raw.bottomsheet_icon_addtag);
        }
        AppMethodBeat.o(6424);
    }
}
