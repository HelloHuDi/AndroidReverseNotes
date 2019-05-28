package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p911q.C19678c;
import com.tencent.p177mm.protocal.protobuf.axr;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e.e */
public class C2060e extends C19678c<C10087f> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C10087f.fjX, "PredownloadIssueLaunchWxaAppResponse")};

    static {
        AppMethodBeat.m2504i(129515);
        AppMethodBeat.m2505o(129515);
    }

    public C2060e(C4927e c4927e) {
        super(c4927e, C10087f.fjX, "PredownloadIssueLaunchWxaAppResponse", C10087f.diI);
    }

    /* renamed from: a */
    public final boolean mo5825a(byte[] bArr, String str, List<Integer> list, long j, long j2) {
        AppMethodBeat.m2504i(129513);
        if (C5046bo.m7540cb(bArr) || C5046bo.isNullOrNil(str)) {
            C4990ab.m7417i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", str);
            AppMethodBeat.m2505o(129513);
            return false;
        } else if (C5046bo.m7548ek(list)) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", str);
            AppMethodBeat.m2505o(129513);
            return false;
        } else {
            boolean z = true;
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                C10087f c10087f = new C10087f();
                c10087f.field_appId = str;
                c10087f.field_scene = intValue2;
                boolean b = mo10102b(c10087f, new String[0]);
                c10087f.field_launchProtoBlob = bArr;
                c10087f.field_startTime = j;
                c10087f.field_endTime = j2;
                if (b) {
                    intValue2 = mo10103c(c10087f, new String[0]);
                } else {
                    intValue2 = mo10101b((C4925c) c10087f);
                }
                z = intValue2 & z;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", str, Integer.valueOf(list.size()), Boolean.valueOf(z));
            AppMethodBeat.m2505o(129513);
            return z;
        }
    }

    /* renamed from: az */
    public final Pair<axr, Long> mo5826az(String str, int i) {
        AppMethodBeat.m2504i(129514);
        Pair<axr, Long> create;
        try {
            long anT = C5046bo.anT();
            C10087f c10087f = new C10087f();
            c10087f.field_appId = str;
            c10087f.field_scene = i;
            if (mo10102b(c10087f, new String[0])) {
                C4990ab.m7417i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", str, Integer.valueOf(i), Long.valueOf(c10087f.field_startTime), Long.valueOf(c10087f.field_endTime));
                if (c10087f.field_startTime <= anT && anT <= c10087f.field_endTime) {
                    axr axr = new axr();
                    axr.parseFrom(c10087f.field_launchProtoBlob);
                    if (axr.wBJ.vYw.f1226wR.length > 0) {
                        Pair create2 = Pair.create(axr, Long.valueOf(c10087f.field_reportId));
                        AppMethodBeat.m2505o(129514);
                        return create2;
                    }
                    C4990ab.m7413e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", str, Integer.valueOf(i));
                }
            }
            create = Pair.create(null, Long.valueOf(-1));
            AppMethodBeat.m2505o(129514);
            return create;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", e, "get with appId(%s) scene(%d)", str, Integer.valueOf(i));
            create = Pair.create(null, Long.valueOf(-1));
            AppMethodBeat.m2505o(129514);
            return create;
        }
    }
}
