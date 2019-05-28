package com.tencent.p177mm.plugin.appbrand.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p230g.p231a.C42009io;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C16701a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C2545b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d.C11049a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d.C11050b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b */
public final class C38572b implements C11048d {
    /* renamed from: a */
    public final AppBrandRecentView mo22744a(Context context, C11050b c11050b, C11049a c11049a) {
        AppMethodBeat.m2504i(133646);
        LayoutParams layoutParams;
        if (c11050b == C11050b.TYPE_CONVERSATION) {
            ConversationAppBrandRecentView conversationAppBrandRecentView = new ConversationAppBrandRecentView(context);
            conversationAppBrandRecentView.setSceneFactory(c11049a);
            layoutParams = new LayoutParams(-1, (int) context.getResources().getDimension(C25738R.dimen.f10166sv));
            conversationAppBrandRecentView.setPadding(0, (int) context.getResources().getDimension(C25738R.dimen.f10167sx), 0, 0);
            conversationAppBrandRecentView.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(133646);
            return conversationAppBrandRecentView;
        } else if (c11050b == C11050b.TYPE_MENU) {
            AppBrandRecentView menuAppBrandRecentView = new MenuAppBrandRecentView(context);
            menuAppBrandRecentView.setSceneFactory(c11049a);
            layoutParams = new LayoutParams(-1, (int) context.getResources().getDimension(C25738R.dimen.f10166sv));
            menuAppBrandRecentView.setPadding(0, (int) context.getResources().getDimension(C25738R.dimen.f10167sx), 0, 0);
            menuAppBrandRecentView.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(133646);
            return menuAppBrandRecentView;
        } else {
            AppMethodBeat.m2505o(133646);
            return null;
        }
    }

    public final void aOC() {
        AppMethodBeat.m2504i(133647);
        C4990ab.m7417i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", Integer.valueOf(300), Integer.valueOf(8));
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C42009io c42009io = new C42009io();
            c42009io.cDH.delay = 300;
            c42009io.cDH.type = 8;
            C4879a.xxA.mo10055m(c42009io);
        }
        AppMethodBeat.m2505o(133647);
    }

    public final C19916b aOD() {
        AppMethodBeat.m2504i(133648);
        C19916b c19916b = new C19916b();
        AppMethodBeat.m2505o(133648);
        return c19916b;
    }

    /* renamed from: df */
    public final HeaderContainer mo22749df(Context context) {
        AppMethodBeat.m2504i(133649);
        AppBrandDesktopContainer appBrandDesktopContainer = new AppBrandDesktopContainer(context);
        AppMethodBeat.m2505o(133649);
        return appBrandDesktopContainer;
    }

    /* renamed from: a */
    public final C10985b mo22743a(Context context, ListView listView, HeaderContainer headerContainer) {
        AppMethodBeat.m2504i(133650);
        C16701a c16701a = new C16701a(context, listView, headerContainer);
        AppMethodBeat.m2505o(133650);
        return c16701a;
    }

    public final void aOE() {
        AppMethodBeat.m2504i(133651);
        C2545b.aPg();
        AppMethodBeat.m2505o(133651);
    }

    public final boolean aOF() {
        AppMethodBeat.m2504i(133652);
        boolean aPe = C2545b.aPe();
        AppMethodBeat.m2505o(133652);
        return aPe;
    }

    /* renamed from: dg */
    public final View mo22750dg(Context context) {
        AppMethodBeat.m2504i(133653);
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = new DynamicBackgroundGLSurfaceView(context, (byte) 0);
        AppMethodBeat.m2505o(133653);
        return dynamicBackgroundGLSurfaceView;
    }
}
