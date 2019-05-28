package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ds;
import com.tencent.tencentmap.mapsdk.a.dt;
import navsns.RttResponse;

public class il extends hf {
    private static il a;

    public static synchronized il a() {
        il ilVar;
        synchronized (il.class) {
            AppMethodBeat.i(99849);
            if (a == null) {
                a = new il();
            }
            ilVar = a;
            AppMethodBeat.o(99849);
        }
        return ilVar;
    }

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.i(99850);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    bArr2 = a(a(b(), bArr));
                    AppMethodBeat.o(99850);
                    return bArr2;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(99850);
            }
        }
        AppMethodBeat.o(99850);
        return bArr2;
    }

    private RttResponse a(String str, byte[] bArr) {
        AppMethodBeat.i(99851);
        for (int i = 0; i < 3; i++) {
            try {
                dt a = ds.a().a(str, "sosomap navsns", bArr);
                if (!(a == null || a.a == null)) {
                    e eVar = new e();
                    eVar.a("UTF-8");
                    eVar.a(a.a);
                    RttResponse rttResponse = (RttResponse) eVar.b("res");
                    AppMethodBeat.o(99851);
                    return rttResponse;
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(99851);
        return null;
    }

    private byte[] a(RttResponse rttResponse) {
        if (rttResponse == null) {
            return null;
        }
        return rttResponse.result;
    }

    public String b() {
        return "https://tafrtt.map.qq.com/rttserverex/";
    }
}
