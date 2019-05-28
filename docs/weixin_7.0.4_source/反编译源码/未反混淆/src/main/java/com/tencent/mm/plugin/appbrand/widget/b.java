package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.io;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements d {
    public final AppBrandRecentView a(Context context, com.tencent.mm.plugin.appbrand.widget.recentview.d.b bVar, a aVar) {
        AppMethodBeat.i(133646);
        LayoutParams layoutParams;
        if (bVar == com.tencent.mm.plugin.appbrand.widget.recentview.d.b.TYPE_CONVERSATION) {
            ConversationAppBrandRecentView conversationAppBrandRecentView = new ConversationAppBrandRecentView(context);
            conversationAppBrandRecentView.setSceneFactory(aVar);
            layoutParams = new LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.sv));
            conversationAppBrandRecentView.setPadding(0, (int) context.getResources().getDimension(R.dimen.sx), 0, 0);
            conversationAppBrandRecentView.setLayoutParams(layoutParams);
            AppMethodBeat.o(133646);
            return conversationAppBrandRecentView;
        } else if (bVar == com.tencent.mm.plugin.appbrand.widget.recentview.d.b.TYPE_MENU) {
            AppBrandRecentView menuAppBrandRecentView = new MenuAppBrandRecentView(context);
            menuAppBrandRecentView.setSceneFactory(aVar);
            layoutParams = new LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.sv));
            menuAppBrandRecentView.setPadding(0, (int) context.getResources().getDimension(R.dimen.sx), 0, 0);
            menuAppBrandRecentView.setLayoutParams(layoutParams);
            AppMethodBeat.o(133646);
            return menuAppBrandRecentView;
        } else {
            AppMethodBeat.o(133646);
            return null;
        }
    }

    public final void aOC() {
        AppMethodBeat.i(133647);
        ab.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", Integer.valueOf(300), Integer.valueOf(8));
        if (((h) g.RM().Rn()).SG()) {
            io ioVar = new io();
            ioVar.cDH.delay = 300;
            ioVar.cDH.type = 8;
            com.tencent.mm.sdk.b.a.xxA.m(ioVar);
        }
        AppMethodBeat.o(133647);
    }

    public final com.tencent.mm.plugin.appbrand.widget.recentview.b aOD() {
        AppMethodBeat.i(133648);
        com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
        AppMethodBeat.o(133648);
        return bVar;
    }

    public final HeaderContainer df(Context context) {
        AppMethodBeat.i(133649);
        AppBrandDesktopContainer appBrandDesktopContainer = new AppBrandDesktopContainer(context);
        AppMethodBeat.o(133649);
        return appBrandDesktopContainer;
    }

    public final com.tencent.mm.plugin.appbrand.widget.header.b a(Context context, ListView listView, HeaderContainer headerContainer) {
        AppMethodBeat.i(133650);
        com.tencent.mm.plugin.appbrand.widget.desktop.a aVar = new com.tencent.mm.plugin.appbrand.widget.desktop.a(context, listView, headerContainer);
        AppMethodBeat.o(133650);
        return aVar;
    }

    public final void aOE() {
        AppMethodBeat.i(133651);
        com.tencent.mm.plugin.appbrand.widget.desktop.b.aPg();
        AppMethodBeat.o(133651);
    }

    public final boolean aOF() {
        AppMethodBeat.i(133652);
        boolean aPe = com.tencent.mm.plugin.appbrand.widget.desktop.b.aPe();
        AppMethodBeat.o(133652);
        return aPe;
    }

    public final View dg(Context context) {
        AppMethodBeat.i(133653);
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = new DynamicBackgroundGLSurfaceView(context, (byte) 0);
        AppMethodBeat.o(133653);
        return dynamicBackgroundGLSurfaceView;
    }
}
