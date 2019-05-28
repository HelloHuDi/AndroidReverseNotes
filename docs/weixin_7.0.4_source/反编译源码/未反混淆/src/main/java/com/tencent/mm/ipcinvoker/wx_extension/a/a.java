package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.c;

public final class a {

    static class a implements i<IPCString, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(126209);
            IPCString iPCString = (IPCString) obj;
            if (g.RQ().eKi.eKC && g.RN().eJb) {
                c ll = com.tencent.mm.model.c.c.abi().ll(iPCString.value);
                Object bundle = new Bundle();
                bundle.putString("layerId", ll.field_layerId);
                bundle.putString("business", ll.field_business);
                bundle.putString("expId", ll.field_expId);
                bundle.putString("rawXML", ll.field_rawXML);
                bundle.putLong("startTime", ll.field_startTime);
                bundle.putLong("endTime", ll.field_endTime);
                bundle.putLong("sequence", ll.field_sequence);
                bundle.putInt("prioritylevel", ll.field_prioritylevel);
                bundle.putBoolean("needReport", ll.field_needReport);
                AppMethodBeat.o(126209);
                return bundle;
            }
            ab.e("MicroMsg.IPCInvokeTask_GetABTestItem", "kernel or account not ready.");
            AppMethodBeat.o(126209);
            return null;
        }
    }

    public static final class b {
        public static a eGM = new a();

        static {
            AppMethodBeat.i(126210);
            AppMethodBeat.o(126210);
        }
    }

    public static a PW() {
        return b.eGM;
    }

    public static c ll(String str) {
        AppMethodBeat.i(126211);
        c cVar;
        if (str.length() == 0) {
            ab.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", str);
            AppMethodBeat.o(126211);
            return null;
        } else if (!ah.bqo()) {
            Bundle bundle;
            try {
                bundle = (Bundle) f.a("com.tencent.mm", new IPCString(str), a.class);
            } catch (Exception e) {
                ab.e("MicroMsg.IPCNewABTest", "invokeSync e = %s", e);
                bundle = null;
            }
            if (bundle == null) {
                AppMethodBeat.o(126211);
                return null;
            }
            cVar = new c();
            cVar.field_layerId = bundle.getString("layerId");
            cVar.field_business = bundle.getString("business");
            cVar.field_expId = bundle.getString("expId");
            cVar.field_rawXML = bundle.getString("rawXML");
            cVar.field_startTime = bundle.getLong("startTime");
            cVar.field_endTime = bundle.getLong("endTime");
            cVar.field_sequence = bundle.getLong("sequence");
            cVar.field_prioritylevel = bundle.getInt("prioritylevel");
            cVar.field_needReport = bundle.getBoolean("needReport");
            AppMethodBeat.o(126211);
            return cVar;
        } else if (g.RQ().eKi.eKC && g.RN().eJb) {
            cVar = com.tencent.mm.model.c.c.abi().ll(str);
            AppMethodBeat.o(126211);
            return cVar;
        } else {
            ab.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
            AppMethodBeat.o(126211);
            return null;
        }
    }
}
