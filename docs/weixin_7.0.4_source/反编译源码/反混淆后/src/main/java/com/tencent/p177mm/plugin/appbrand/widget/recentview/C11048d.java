package com.tencent.p177mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1679e;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.p1468a.C38095c;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;

@C1679e(C38095c.class)
/* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.d */
public interface C11048d extends C1694a {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.d$a */
    public interface C11049a {
        LocalUsageInfo aJZ();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.d$b */
    public enum C11050b {
        TYPE_MENU,
        TYPE_CONVERSATION;

        static {
            AppMethodBeat.m2505o(114948);
        }
    }

    /* renamed from: a */
    C10985b mo22743a(Context context, ListView listView, HeaderContainer headerContainer);

    /* renamed from: a */
    AppBrandRecentView mo22744a(Context context, C11050b c11050b, C11049a c11049a);

    void aOC();

    C19916b aOD();

    void aOE();

    boolean aOF();

    /* renamed from: df */
    HeaderContainer mo22749df(Context context);

    /* renamed from: dg */
    View mo22750dg(Context context);
}
