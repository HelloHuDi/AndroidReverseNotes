package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "PBCache")};

    static {
        AppMethodBeat.i(59420);
        AppMethodBeat.o(59420);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "PBCache", null);
    }

    public final byte[] NK(String str) {
        AppMethodBeat.i(59418);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59418);
            return null;
        }
        c aVar = new a();
        aVar.field_key = str;
        if (super.b(aVar, new String[0])) {
            byte[] bArr = aVar.field_value;
            AppMethodBeat.o(59418);
            return bArr;
        }
        AppMethodBeat.o(59418);
        return null;
    }

    public final boolean b(String str, a aVar) {
        boolean z = false;
        AppMethodBeat.i(59419);
        if (bo.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(59419);
        } else {
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (toByteArray == null || toByteArray.length == 0) {
                    AppMethodBeat.o(59419);
                } else {
                    c aVar2 = new a();
                    aVar2.field_key = str;
                    if (super.b(aVar2, new String[0])) {
                        aVar2.field_value = toByteArray;
                        z = super.c(aVar2, new String[0]);
                    } else {
                        aVar2.field_value = toByteArray;
                        z = super.b(aVar2);
                    }
                    if (!z) {
                        ab.e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
                    }
                    AppMethodBeat.o(59419);
                }
            } catch (IOException e) {
                ab.e("MicroMsg.PBCacheStorage", "Saving Failed: %s", e.getMessage());
                AppMethodBeat.o(59419);
            }
        }
        return z;
    }
}
