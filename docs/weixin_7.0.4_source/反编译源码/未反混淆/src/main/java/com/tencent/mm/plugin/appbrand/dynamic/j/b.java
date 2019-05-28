package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {

    public static class b implements i<ContentValues, Bundle> {
        private b() {
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            AppMethodBeat.i(10994);
            ContentValues contentValues = (ContentValues) obj;
            f auW = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.K(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auW();
            e a = b.a(contentValues);
            if (a == null || (a.xDa > 0 && auW.a(a))) {
                z = false;
            } else {
                z = auW.b((c) a);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("result", z);
            AppMethodBeat.o(10994);
            return bundle;
        }
    }

    static class a implements i<Bundle, ContentValues> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            e eVar;
            AppMethodBeat.i(10993);
            String string = ((Bundle) obj).getString("id");
            f auW = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.K(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auW();
            if (bo.isNullOrNil(string)) {
                eVar = null;
            } else {
                eVar = new e();
                eVar.field_id = string;
                if (!auW.b((c) eVar, "id")) {
                    eVar = null;
                }
            }
            if (eVar == null) {
                AppMethodBeat.o(10993);
                return null;
            }
            Object Hl = eVar.Hl();
            AppMethodBeat.o(10993);
            return Hl;
        }
    }

    public static e Am(String str) {
        AppMethodBeat.i(10995);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        e a = a((ContentValues) com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle, a.class));
        AppMethodBeat.o(10995);
        return a;
    }

    static e a(ContentValues contentValues) {
        AppMethodBeat.i(10996);
        if (contentValues != null) {
            e eVar = new e();
            eVar.field_id = contentValues.getAsString("id");
            eVar.field_appId = contentValues.getAsString("appId");
            eVar.field_cacheKey = contentValues.getAsString("cacheKey");
            eVar.field_updateTime = bo.c(contentValues.getAsLong("updateTime"));
            eVar.field_interval = bo.h(contentValues.getAsInteger("interval"));
            eVar.xDa = bo.c(contentValues.getAsLong("rowid"));
            AppMethodBeat.o(10996);
            return eVar;
        }
        AppMethodBeat.o(10996);
        return null;
    }
}
