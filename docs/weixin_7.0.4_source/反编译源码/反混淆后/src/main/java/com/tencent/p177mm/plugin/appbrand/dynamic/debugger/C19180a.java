package com.tencent.p177mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.p854d.C37867c;
import com.tencent.p177mm.modelappbrand.LogInfo;
import com.tencent.p177mm.p652z.p653c.C30909e.C30910a;
import com.tencent.p177mm.plugin.appbrand.wxawidget.console.C11067b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.debugger.a */
public final class C19180a {
    private static C30910a hmG = new C21441();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.debugger.a$1 */
    static class C21441 implements C30910a {
        C21441() {
        }

        /* renamed from: I */
        public final void mo5961I(String str, int i) {
            AppMethodBeat.m2504i(10803);
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putInt("status", i);
            C9549f.m17012a("com.tencent.mm", bundle, C19181a.class, null);
            AppMethodBeat.m2505o(10803);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.debugger.a$a */
    static class C19181a implements C37866a<Bundle, Bundle> {
        private C19181a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10804);
            Bundle bundle = (Bundle) obj;
            C42423b.m75142I(bundle.getString("id"), bundle.getInt("status"));
            AppMethodBeat.m2505o(10804);
        }
    }

    static {
        AppMethodBeat.m2504i(10806);
        AppMethodBeat.m2505o(10806);
    }

    /* renamed from: c */
    public static void m29836c(String str, ArrayList<LogInfo> arrayList) {
        AppMethodBeat.m2504i(10805);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putParcelableArrayList("logList", arrayList);
        C37867c.m63901PT().mo60591k(C11067b.jpG.getClass().getName(), bundle);
        AppMethodBeat.m2505o(10805);
    }

    public static C30910a azQ() {
        return hmG;
    }
}
