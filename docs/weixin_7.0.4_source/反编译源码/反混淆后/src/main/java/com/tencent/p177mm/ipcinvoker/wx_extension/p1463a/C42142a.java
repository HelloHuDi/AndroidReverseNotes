package com.tencent.p177mm.ipcinvoker.wx_extension.p1463a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.a.a */
public final class C42142a {

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.a.a$a */
    static class C32717a implements C45413i<IPCString, Bundle> {
        private C32717a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(126209);
            IPCString iPCString = (IPCString) obj;
            if (C1720g.m3537RQ().eKi.eKC && C1720g.m3534RN().eJb) {
                C5141c ll = C18624c.abi().mo17131ll(iPCString.value);
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
                AppMethodBeat.m2505o(126209);
                return bundle;
            }
            C4990ab.m7412e("MicroMsg.IPCInvokeTask_GetABTestItem", "kernel or account not ready.");
            AppMethodBeat.m2505o(126209);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.a.a$b */
    public static final class C32718b {
        public static C42142a eGM = new C42142a();

        static {
            AppMethodBeat.m2504i(126210);
            AppMethodBeat.m2505o(126210);
        }
    }

    /* renamed from: PW */
    public static C42142a m74294PW() {
        return C32718b.eGM;
    }

    /* renamed from: ll */
    public static C5141c m74295ll(String str) {
        AppMethodBeat.m2504i(126211);
        C5141c c5141c;
        if (str.length() == 0) {
            C4990ab.m7417i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", str);
            AppMethodBeat.m2505o(126211);
            return null;
        } else if (!C4996ah.bqo()) {
            Bundle bundle;
            try {
                bundle = (Bundle) C9549f.m17010a("com.tencent.mm", new IPCString(str), C32717a.class);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IPCNewABTest", "invokeSync e = %s", e);
                bundle = null;
            }
            if (bundle == null) {
                AppMethodBeat.m2505o(126211);
                return null;
            }
            c5141c = new C5141c();
            c5141c.field_layerId = bundle.getString("layerId");
            c5141c.field_business = bundle.getString("business");
            c5141c.field_expId = bundle.getString("expId");
            c5141c.field_rawXML = bundle.getString("rawXML");
            c5141c.field_startTime = bundle.getLong("startTime");
            c5141c.field_endTime = bundle.getLong("endTime");
            c5141c.field_sequence = bundle.getLong("sequence");
            c5141c.field_prioritylevel = bundle.getInt("prioritylevel");
            c5141c.field_needReport = bundle.getBoolean("needReport");
            AppMethodBeat.m2505o(126211);
            return c5141c;
        } else if (C1720g.m3537RQ().eKi.eKC && C1720g.m3534RN().eJb) {
            c5141c = C18624c.abi().mo17131ll(str);
            AppMethodBeat.m2505o(126211);
            return c5141c;
        } else {
            C4990ab.m7412e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
            AppMethodBeat.m2505o(126211);
            return null;
        }
    }
}
