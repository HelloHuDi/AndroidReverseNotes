package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class w extends j<v> {
    public static final String[] fnj = new String[]{j.a(v.ccO, "GamePBCache")};

    static {
        AppMethodBeat.i(111357);
        AppMethodBeat.o(111357);
    }

    public w(e eVar) {
        super(eVar, v.ccO, "GamePBCache", null);
    }

    public final byte[] NK(String str) {
        AppMethodBeat.i(111354);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111354);
            return null;
        } else if (aa.dor().equals(e.bDX())) {
            c vVar = new v();
            vVar.field_key = str;
            if (super.b(vVar, new String[0])) {
                byte[] bArr = vVar.field_value;
                AppMethodBeat.o(111354);
                return bArr;
            }
            AppMethodBeat.o(111354);
            return null;
        } else {
            AppMethodBeat.o(111354);
            return null;
        }
    }

    public final boolean b(String str, a aVar) {
        boolean z = false;
        AppMethodBeat.i(111355);
        if (bo.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(111355);
            return z;
        }
        try {
            z = w(str, aVar.toByteArray());
            AppMethodBeat.o(111355);
            return z;
        } catch (IOException e) {
            ab.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", e.getMessage());
            AppMethodBeat.o(111355);
            return z;
        }
    }

    public final boolean w(String str, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.i(111356);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(111356);
        } else {
            c vVar = new v();
            vVar.field_key = str;
            if (super.b(vVar, new String[0])) {
                vVar.field_value = bArr;
                z = super.c(vVar, new String[0]);
            } else {
                vVar.field_value = bArr;
                z = super.b(vVar);
            }
            if (!z) {
                ab.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
            }
            AppMethodBeat.o(111356);
        }
        return z;
    }
}
