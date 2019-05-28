package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class e extends c<f> {
    public static final String[] fjY = new String[]{j.a(f.fjX, "PredownloadIssueLaunchWxaAppResponse")};

    static {
        AppMethodBeat.i(129515);
        AppMethodBeat.o(129515);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, f.fjX, "PredownloadIssueLaunchWxaAppResponse", f.diI);
    }

    public final boolean a(byte[] bArr, String str, List<Integer> list, long j, long j2) {
        AppMethodBeat.i(129513);
        if (bo.cb(bArr) || bo.isNullOrNil(str)) {
            ab.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", str);
            AppMethodBeat.o(129513);
            return false;
        } else if (bo.ek(list)) {
            ab.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", str);
            AppMethodBeat.o(129513);
            return false;
        } else {
            boolean z = true;
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                f fVar = new f();
                fVar.field_appId = str;
                fVar.field_scene = intValue2;
                boolean b = b(fVar, new String[0]);
                fVar.field_launchProtoBlob = bArr;
                fVar.field_startTime = j;
                fVar.field_endTime = j2;
                if (b) {
                    intValue2 = c(fVar, new String[0]);
                } else {
                    intValue2 = b((com.tencent.mm.sdk.e.c) fVar);
                }
                z = intValue2 & z;
            }
            ab.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", str, Integer.valueOf(list.size()), Boolean.valueOf(z));
            AppMethodBeat.o(129513);
            return z;
        }
    }

    public final Pair<axr, Long> az(String str, int i) {
        AppMethodBeat.i(129514);
        Pair<axr, Long> create;
        try {
            long anT = bo.anT();
            f fVar = new f();
            fVar.field_appId = str;
            fVar.field_scene = i;
            if (b(fVar, new String[0])) {
                ab.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", str, Integer.valueOf(i), Long.valueOf(fVar.field_startTime), Long.valueOf(fVar.field_endTime));
                if (fVar.field_startTime <= anT && anT <= fVar.field_endTime) {
                    axr axr = new axr();
                    axr.parseFrom(fVar.field_launchProtoBlob);
                    if (axr.wBJ.vYw.wR.length > 0) {
                        Pair create2 = Pair.create(axr, Long.valueOf(fVar.field_reportId));
                        AppMethodBeat.o(129514);
                        return create2;
                    }
                    ab.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", str, Integer.valueOf(i));
                }
            }
            create = Pair.create(null, Long.valueOf(-1));
            AppMethodBeat.o(129514);
            return create;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", e, "get with appId(%s) scene(%d)", str, Integer.valueOf(i));
            create = Pair.create(null, Long.valueOf(-1));
            AppMethodBeat.o(129514);
            return create;
        }
    }
}
