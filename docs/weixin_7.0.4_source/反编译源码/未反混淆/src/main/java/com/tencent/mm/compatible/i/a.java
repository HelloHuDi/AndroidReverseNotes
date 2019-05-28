package com.tencent.mm.compatible.i;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static void a(MenuItem menuItem, String str) {
        AppMethodBeat.i(93054);
        if (menuItem == null) {
            ab.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
            AppMethodBeat.o(93054);
        } else if (menuItem.getTitleCondensed() == null) {
            ab.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", str);
            menuItem.setTitleCondensed("");
            AppMethodBeat.o(93054);
        } else if (menuItem.getTitleCondensed() instanceof String) {
            AppMethodBeat.o(93054);
        } else {
            ab.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", str, menuItem.getTitleCondensed().getClass().getName(), menuItem.getTitleCondensed());
            menuItem.setTitleCondensed(menuItem.getTitleCondensed().toString());
            AppMethodBeat.o(93054);
        }
    }
}
