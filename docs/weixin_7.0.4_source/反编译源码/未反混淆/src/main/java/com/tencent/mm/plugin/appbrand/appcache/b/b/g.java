package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class g extends a<Boolean, cxw> {
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        AppMethodBeat.i(129475);
        Boolean a = a(str, str2, (cxw) obj);
        AppMethodBeat.o(129475);
        return a;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ cxp bm(Object obj) {
        return ((cxw) obj).xsZ;
    }

    private static Boolean a(String str, String str2, cxw cxw) {
        AppMethodBeat.i(129474);
        String str3 = cxw.xto;
        Boolean bool;
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.o(129474);
            return bool;
        } else if (bo.ek(cxw.xkP)) {
            ab.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.o(129474);
            return bool;
        } else {
            try {
                byte[] decode = Base64.decode(str3, 0);
                axr axr = new axr();
                axr.parseFrom(decode);
                a aVar;
                if (axr.wBJ.vYw.wR.length == 0) {
                    ab.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", str, str2);
                    aVar = a.gWl;
                    a.z((long) cxw.xsZ.xsX, 105);
                    bool = Boolean.FALSE;
                    AppMethodBeat.o(129474);
                    return bool;
                }
                int i;
                aVar = a.gWl;
                a.z((long) cxw.xsZ.xsX, 104);
                LinkedList<Object> linkedList = cxw.xkP;
                long j = ((long) cxw.xtp) & 4294967295L;
                long j2 = ((long) cxw.xtq) & 4294967295L;
                String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueLaunch";
                String str5 = "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                if (linkedList == null) {
                    str3 = BuildConfig.COMMAND;
                } else if (bo.ek(linkedList)) {
                    str3 = "{}";
                } else {
                    StringBuilder stringBuilder = new StringBuilder("{");
                    for (Object obj : linkedList) {
                        stringBuilder.append(obj.toString()).append(',');
                    }
                    stringBuilder.append("}");
                    str3 = stringBuilder.toString();
                }
                objArr[2] = str3;
                objArr[3] = Long.valueOf(j);
                objArr[4] = Long.valueOf(j2);
                ab.i(str4, str5, objArr);
                boolean a = ((e) f.E(e.class)).a(decode, str2, linkedList, j, j2);
                aVar = a.gWl;
                int i2 = cxw.xsZ.xsX;
                if (a) {
                    i = 107;
                } else {
                    i = 108;
                }
                a.z((long) i2, (long) i);
                bool = Boolean.valueOf(a);
                AppMethodBeat.o(129474);
                return bool;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", e, "call[%s | %s], decode base64", str, str2);
                bool = Boolean.FALSE;
                AppMethodBeat.o(129474);
                return bool;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdIssueLaunch";
    }
}
