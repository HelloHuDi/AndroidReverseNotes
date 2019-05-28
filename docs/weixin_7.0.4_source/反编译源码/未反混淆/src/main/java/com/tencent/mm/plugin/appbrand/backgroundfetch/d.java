package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public class d extends j<c> {
    public static final String[] fjY = new String[]{j.a(c.hcb, "AppBrandBackgroundFetchData")};

    public d(e eVar) {
        super(eVar, c.hcb, "AppBrandBackgroundFetchData", null);
    }

    static {
        AppMethodBeat.i(129776);
        AppMethodBeat.o(129776);
    }

    /* JADX WARNING: Missing block: B:6:0x0049, code skipped:
            if (super.b((com.tencent.mm.sdk.e.c) r0, "username", "fetchType") != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(String str, int i, String str2, String str3, String str4, int i2, long j) {
        AppMethodBeat.i(129771);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129771);
            return true;
        }
        c cVar;
        c cVar2 = new c();
        cVar2.field_username = str;
        cVar2.field_fetchType = i;
        cVar2.field_data = str2;
        cVar2.field_path = str3;
        cVar2.field_query = str4;
        cVar2.field_scene = i2;
        cVar2.field_updateTime = j;
        if (!bo.isNullOrNil(str)) {
            cVar = new c();
            cVar.field_username = str;
            cVar.field_fetchType = i;
        }
        cVar = null;
        boolean b;
        if (cVar == null) {
            b = super.b(cVar2);
            AppMethodBeat.o(129771);
            return b;
        }
        b = super.c(cVar2, "username", "fetchType");
        AppMethodBeat.o(129771);
        return b;
    }

    private AppBrandBackgroundFetchDataParcel aP(String str, int i) {
        AppMethodBeat.i(129772);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129772);
            return null;
        }
        c cVar = new c();
        cVar.field_username = str;
        cVar.field_fetchType = i;
        if (super.b(cVar, "username", "fetchType")) {
            AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            appBrandBackgroundFetchDataParcel.username = cVar.field_username;
            appBrandBackgroundFetchDataParcel.hca = cVar.field_fetchType;
            appBrandBackgroundFetchDataParcel.path = cVar.field_path;
            appBrandBackgroundFetchDataParcel.query = cVar.field_query;
            appBrandBackgroundFetchDataParcel.data = cVar.field_data;
            appBrandBackgroundFetchDataParcel.scene = cVar.field_scene;
            appBrandBackgroundFetchDataParcel.updateTime = cVar.field_updateTime;
            AppMethodBeat.o(129772);
            return appBrandBackgroundFetchDataParcel;
        }
        AppMethodBeat.o(129772);
        return null;
    }

    public final boolean ao(String str, int i) {
        AppMethodBeat.i(129773);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129773);
            return true;
        }
        c cVar = new c();
        cVar.field_username = str;
        cVar.field_fetchType = i;
        boolean a = super.a(cVar, "username", "fetchType");
        AppMethodBeat.o(129773);
        return a;
    }

    public final long aQ(String str, int i) {
        AppMethodBeat.i(129774);
        AppBrandBackgroundFetchDataParcel aP = aP(str, i);
        if (aP != null) {
            long j = aP.updateTime;
            AppMethodBeat.o(129774);
            return j;
        }
        AppMethodBeat.o(129774);
        return 0;
    }

    public final AppBrandBackgroundFetchDataParcel aR(String str, int i) {
        AppMethodBeat.i(129775);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129775);
            return null;
        }
        AppBrandBackgroundFetchDataParcel aP = aP(p.zo(str), i);
        AppMethodBeat.o(129775);
        return aP;
    }
}
