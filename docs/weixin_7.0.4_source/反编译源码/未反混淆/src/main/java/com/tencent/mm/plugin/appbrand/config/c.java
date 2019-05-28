package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends j<b> {
    public static final String[] fjY = new String[]{j.a(b.fjX, "AppBrandCommonKVData")};
    public final e gTC;

    static {
        AppMethodBeat.i(101788);
        AppMethodBeat.o(101788);
    }

    public c(e eVar) {
        super(eVar, b.fjX, "AppBrandCommonKVData", null);
        this.gTC = eVar;
    }

    public final boolean bG(String str, String str2) {
        AppMethodBeat.i(101784);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101784);
            return false;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        bVar.field_value = str2;
        if (!bo.isNullOrNil(bVar.field_value)) {
            boolean a = super.a(bVar);
            AppMethodBeat.o(101784);
            return a;
        } else if (super.a(bVar, new String[0])) {
            AppMethodBeat.o(101784);
            return false;
        } else {
            AppMethodBeat.o(101784);
            return true;
        }
    }

    public final String get(String str, String str2) {
        AppMethodBeat.i(101785);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101785);
            return str2;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        if (super.b(bVar, new String[0])) {
            str2 = bVar.field_value;
            AppMethodBeat.o(101785);
            return str2;
        }
        AppMethodBeat.o(101785);
        return str2;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(101786);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101786);
            return false;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        bVar.field_value = get(str, "");
        if (TextUtils.isEmpty(bVar.field_value) || super.a(bVar, new String[0])) {
            AppMethodBeat.o(101786);
            return true;
        }
        AppMethodBeat.o(101786);
        return false;
    }

    public final void yW(String str) {
        AppMethodBeat.i(101787);
        super.hY("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandCommonKVData", "key", str}));
        AppMethodBeat.o(101787);
    }
}
