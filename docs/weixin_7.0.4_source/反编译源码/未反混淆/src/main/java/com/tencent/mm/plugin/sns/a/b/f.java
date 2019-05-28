package com.tencent.mm.plugin.sns.a.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class f {
    public static void a(String str, d dVar) {
        AppMethodBeat.i(35711);
        n YS = af.cnF().YS(str);
        if (YS != null) {
            TimeLineObject cqu = YS.cqu();
            if (cqu != null) {
                p.a(cqu.rjC, dVar);
                AppMethodBeat.o(35711);
                return;
            }
            ab.v("SnsAdExtUtil", "timeLineObject null, snsId %s", str);
            AppMethodBeat.o(35711);
            return;
        }
        ab.v("SnsAdExtUtil", "snsInfo null, snsId %s", str);
        AppMethodBeat.o(35711);
    }

    public static String a(long j, Object... objArr) {
        AppMethodBeat.i(35712);
        af.cnz();
        StringBuilder stringBuilder = new StringBuilder(i.s(objArr));
        a(j, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(35712);
        return stringBuilder2;
    }

    public static void a(long j, StringBuilder stringBuilder) {
        AppMethodBeat.i(35713);
        e ku = af.cnI().ku(j);
        if (ku != null) {
            TimeLineObject cqu = ku.cqu();
            if (cqu != null) {
                p.a(cqu.rjC, stringBuilder);
                AppMethodBeat.o(35713);
                return;
            }
            ab.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", Long.valueOf(j));
            stringBuilder.append(",,");
            AppMethodBeat.o(35713);
            return;
        }
        ab.v("SnsAdExtUtil", "l snsInfo null, snsId %d", Long.valueOf(j));
        stringBuilder.append(",,");
        AppMethodBeat.o(35713);
    }

    public static String a(TimeLineObject timeLineObject) {
        AppMethodBeat.i(35714);
        if (timeLineObject != null) {
            String WW = WW(timeLineObject.rjC);
            AppMethodBeat.o(35714);
            return WW;
        }
        ab.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
        AppMethodBeat.o(35714);
        return null;
    }

    private static String WW(String str) {
        AppMethodBeat.i(35715);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(35715);
            return str2;
        }
        byte[] decode = Base64.decode(str, 0);
        cdg cdg = new cdg();
        try {
            cdg.parseFrom(decode);
            str2 = p.a(cdg.xcS);
            AppMethodBeat.o(35715);
            return str2;
        } catch (IOException e) {
            ab.e("SnsAdExtUtil", "", e);
            str2 = "";
            AppMethodBeat.o(35715);
            return str2;
        }
    }
}
