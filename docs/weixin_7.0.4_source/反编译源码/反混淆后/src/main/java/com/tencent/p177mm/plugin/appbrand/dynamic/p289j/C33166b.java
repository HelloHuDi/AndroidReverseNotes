package com.tencent.p177mm.plugin.appbrand.dynamic.p289j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.widget.C44718e;
import com.tencent.p177mm.plugin.appbrand.widget.C45716f;
import com.tencent.p177mm.plugin.appbrand.widget.p1473a.C33574a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.b */
public final class C33166b {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.b$b */
    public static class C19199b implements C45413i<ContentValues, Bundle> {
        private C19199b() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(10994);
            ContentValues contentValues = (ContentValues) obj;
            C45716f auW = ((C33574a) C1720g.m3528K(C33574a.class)).auW();
            C44718e a = C33166b.m54216a(contentValues);
            if (a == null || (a.xDa > 0 && auW.mo10099a(a))) {
                z = false;
            } else {
                z = auW.mo10101b((C4925c) a);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("result", z);
            AppMethodBeat.m2505o(10994);
            return bundle;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.b$a */
    static class C33165a implements C45413i<Bundle, ContentValues> {
        private C33165a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            C44718e c44718e;
            AppMethodBeat.m2504i(10993);
            String string = ((Bundle) obj).getString("id");
            C45716f auW = ((C33574a) C1720g.m3528K(C33574a.class)).auW();
            if (C5046bo.isNullOrNil(string)) {
                c44718e = null;
            } else {
                c44718e = new C44718e();
                c44718e.field_id = string;
                if (!auW.mo10102b((C4925c) c44718e, "id")) {
                    c44718e = null;
                }
            }
            if (c44718e == null) {
                AppMethodBeat.m2505o(10993);
                return null;
            }
            Object Hl = c44718e.mo10098Hl();
            AppMethodBeat.m2505o(10993);
            return Hl;
        }
    }

    /* renamed from: Am */
    public static C44718e m54215Am(String str) {
        AppMethodBeat.m2504i(10995);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        C44718e a = C33166b.m54216a((ContentValues) C9549f.m17010a("com.tencent.mm", bundle, C33165a.class));
        AppMethodBeat.m2505o(10995);
        return a;
    }

    /* renamed from: a */
    static C44718e m54216a(ContentValues contentValues) {
        AppMethodBeat.m2504i(10996);
        if (contentValues != null) {
            C44718e c44718e = new C44718e();
            c44718e.field_id = contentValues.getAsString("id");
            c44718e.field_appId = contentValues.getAsString("appId");
            c44718e.field_cacheKey = contentValues.getAsString("cacheKey");
            c44718e.field_updateTime = C5046bo.m7534c(contentValues.getAsLong("updateTime"));
            c44718e.field_interval = C5046bo.m7567h(contentValues.getAsInteger("interval"));
            c44718e.xDa = C5046bo.m7534c(contentValues.getAsLong("rowid"));
            AppMethodBeat.m2505o(10996);
            return c44718e;
        }
        AppMethodBeat.m2505o(10996);
        return null;
    }
}
