package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.c */
public final class C44783c extends C43884a {
    public C44783c() {
        super(12);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        AppMethodBeat.m2504i(6425);
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 2);
        intent.putExtra("key_fav_item_id", c24905d.bPP.getLong("fav_local_id", -1));
        C39037b.m66371b(context, ".ui.FavTagEditUI", intent);
        C7060h.pYm.mo15419k(982, 1, 1);
        AppMethodBeat.m2505o(6425);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6424);
        boolean z = c24905d.bPP.getBoolean("is_favorite_item", false);
        boolean z2 = c24905d.bPP.getBoolean("key_detail_can_delete", true);
        if (z && z2) {
            c44273l.mo70049a(12, context.getString(C25738R.string.bnm), (int) C1318a.bottomsheet_icon_addtag);
        }
        AppMethodBeat.m2505o(6424);
    }
}
