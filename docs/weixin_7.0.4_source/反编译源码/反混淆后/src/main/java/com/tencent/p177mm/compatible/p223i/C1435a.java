package com.tencent.p177mm.compatible.p223i;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.i.a */
public final class C1435a {
    /* renamed from: a */
    public static void m3060a(MenuItem menuItem, String str) {
        AppMethodBeat.m2504i(93054);
        if (menuItem == null) {
            C4990ab.m7420w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
            AppMethodBeat.m2505o(93054);
        } else if (menuItem.getTitleCondensed() == null) {
            C4990ab.m7421w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", str);
            menuItem.setTitleCondensed("");
            AppMethodBeat.m2505o(93054);
        } else if (menuItem.getTitleCondensed() instanceof String) {
            AppMethodBeat.m2505o(93054);
        } else {
            C4990ab.m7421w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", str, menuItem.getTitleCondensed().getClass().getName(), menuItem.getTitleCondensed());
            menuItem.setTitleCondensed(menuItem.getTitleCondensed().toString());
            AppMethodBeat.m2505o(93054);
        }
    }
}
