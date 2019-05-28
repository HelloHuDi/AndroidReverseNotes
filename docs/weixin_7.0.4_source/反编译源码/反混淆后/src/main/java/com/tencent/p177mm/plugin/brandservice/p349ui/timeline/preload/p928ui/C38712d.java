package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.d */
public final class C38712d {
    private static Map<String, Bundle> jUF = new HashMap();

    static {
        AppMethodBeat.m2504i(14424);
        AppMethodBeat.m2505o(14424);
    }

    /* renamed from: FZ */
    public static Bundle m65659FZ(String str) {
        AppMethodBeat.m2504i(14421);
        String Ga = C38712d.m65660Ga(str);
        if (jUF.containsKey(Ga)) {
            Bundle bundle = (Bundle) jUF.get(Ga);
            AppMethodBeat.m2505o(14421);
            return bundle;
        }
        AppMethodBeat.m2505o(14421);
        return null;
    }

    /* renamed from: m */
    public static void m65661m(String str, Bundle bundle) {
        AppMethodBeat.m2504i(14422);
        if (str == null) {
            AppMethodBeat.m2505o(14422);
            return;
        }
        jUF.put(C38712d.m65660Ga(str), bundle);
        AppMethodBeat.m2505o(14422);
    }

    /* renamed from: Ga */
    private static String m65660Ga(String str) {
        AppMethodBeat.m2504i(14423);
        int indexOf = str.indexOf("?");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(14423);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(14423);
        return str;
    }
}
