package com.tencent.p177mm.plugin.appbrand.game.p292b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a.C19224b;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.h */
public final class C38216h implements Comparator<C45966l> {
    public static final C38216h hri = new C38216h();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(130091);
        C45966l c45966l = (C45966l) obj;
        if (C42340f.avb() != null) {
            C19224b As = C42340f.avb().mo73360As(c45966l.mDx);
            if (As != null && As.field_isSync) {
                AppMethodBeat.m2505o(130091);
                return 1;
            }
        }
        AppMethodBeat.m2505o(130091);
        return -1;
    }

    static {
        AppMethodBeat.m2504i(130092);
        AppMethodBeat.m2505o(130092);
    }
}
