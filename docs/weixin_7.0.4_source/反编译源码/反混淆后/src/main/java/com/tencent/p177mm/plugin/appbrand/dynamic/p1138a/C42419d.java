package com.tencent.p177mm.plugin.appbrand.dynamic.p1138a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C32806h;
import com.tencent.p177mm.modelappbrand.C37934g;
import com.tencent.p177mm.modelappbrand.C45447x;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.d */
public final class C42419d implements C37934g {
    /* renamed from: a */
    public final void mo60694a(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(10757);
        ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60846a(str, 10102, i, str2, str3);
        AppMethodBeat.m2505o(10757);
    }

    /* renamed from: a */
    public final boolean mo60695a(String str, int i, String str2, final C32806h c32806h) {
        AppMethodBeat.m2504i(10758);
        boolean b = C2055az.m4224b(str, 10102, i, str2, new C2057a() {
            private long totalLen;

            /* renamed from: bl */
            public final /* bridge */ /* synthetic */ void mo14966bl(Object obj) {
                this.totalLen = ((WxaPkgLoadProgress) obj).gUQ;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
                AppMethodBeat.m2504i(10756);
                if (c32806h != null) {
                    c32806h.mo38378a(C10067a.OK.equals(c10067a), this.totalLen);
                }
                AppMethodBeat.m2505o(10756);
            }
        });
        AppMethodBeat.m2505o(10758);
        return b;
    }

    /* renamed from: S */
    public final boolean mo60693S(String str, int i) {
        AppMethodBeat.m2504i(10759);
        Pair v = C19035as.m29615v(str, 10102, i);
        if (v == null || v.first != C19036a.gUI) {
            AppMethodBeat.m2505o(10759);
            return false;
        }
        AppMethodBeat.m2505o(10759);
        return true;
    }

    public final List<C45447x> abA() {
        List list = null;
        AppMethodBeat.m2504i(10760);
        C38105ax xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF();
        if (xF == null) {
            List list2 = Collections.EMPTY_LIST;
            AppMethodBeat.m2505o(10760);
            return list2;
        }
        StringBuilder stringBuilder = new StringBuilder("debugType");
        stringBuilder.append(" = 10102");
        Cursor a = xF.gVj.mo10105a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    C31281at c31281at = new C31281at();
                    c31281at.mo8995d(a);
                    list.add(c31281at);
                } while (a.moveToNext());
                a.close();
            } else {
                a.close();
            }
        }
        if (list == null || list.isEmpty()) {
            List<C45447x> emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(10760);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (C31281at c31281at2 : list) {
            C45447x c45447x = new C45447x();
            c45447x.csB = c31281at2.field_appId;
            c45447x.version = c31281at2.field_version;
            c45447x.cvZ = c31281at2.field_versionMd5;
            arrayList.add(c45447x);
        }
        AppMethodBeat.m2505o(10760);
        return arrayList;
    }
}
