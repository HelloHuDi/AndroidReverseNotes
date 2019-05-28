package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;

@e(c.class)
public interface d extends com.tencent.mm.kernel.c.a {

    public interface a {
        LocalUsageInfo aJZ();
    }

    public enum b {
        TYPE_MENU,
        TYPE_CONVERSATION;

        static {
            AppMethodBeat.o(114948);
        }
    }

    com.tencent.mm.plugin.appbrand.widget.header.b a(Context context, ListView listView, HeaderContainer headerContainer);

    AppBrandRecentView a(Context context, b bVar, a aVar);

    void aOC();

    b aOD();

    void aOE();

    boolean aOF();

    HeaderContainer df(Context context);

    View dg(Context context);
}
