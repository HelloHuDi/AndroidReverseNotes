package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.e;
import java.util.Map;

public final class f {
    public static e a(e eVar) {
        AppMethodBeat.i(78196);
        if (eVar == null) {
            AppMethodBeat.o(78196);
            return null;
        } else if (eVar.agQ()) {
            e ly = o.ahl().ly(eVar.fDJ);
            if (ly == null) {
                AppMethodBeat.o(78196);
                return eVar;
            }
            AppMethodBeat.o(78196);
            return ly;
        } else {
            AppMethodBeat.o(78196);
            return eVar;
        }
    }

    public static boolean b(e eVar) {
        AppMethodBeat.i(78197);
        if (eVar == null) {
            AppMethodBeat.o(78197);
            return false;
        }
        int i = eVar.offset;
        int i2 = eVar.frO;
        long j = eVar.cKK;
        if (eVar.agQ()) {
            e ly = o.ahl().ly(eVar.fDJ);
            i = ly.offset;
            i2 = ly.frO;
            j = ly.cKK;
        }
        if (i2 == 0) {
            AppMethodBeat.o(78197);
            return true;
        } else if ((i != i2 || i2 == 0) && j == 0) {
            AppMethodBeat.o(78197);
            return false;
        } else {
            AppMethodBeat.o(78197);
            return true;
        }
    }

    public static String c(e eVar) {
        AppMethodBeat.i(78198);
        String str;
        if (eVar == null) {
            str = "";
            AppMethodBeat.o(78198);
            return str;
        } else if (eVar.agQ()) {
            e ly = o.ahl().ly(eVar.fDJ);
            if (ly == null) {
                str = "";
                AppMethodBeat.o(78198);
                return str;
            }
            str = ly.fDz;
            AppMethodBeat.o(78198);
            return str;
        } else {
            str = eVar.fDz;
            AppMethodBeat.o(78198);
            return str;
        }
    }

    public static String c(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(78199);
        String str5 = null;
        if (!bo.isNullOrNil(str)) {
            str5 = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[]{str, bo.nullAsNil(str2), bo.nullAsNil(str3), bo.nullAsNil(str4)});
        }
        AppMethodBeat.o(78199);
        return str5;
    }

    public static final a sg(String str) {
        AppMethodBeat.i(78200);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78200);
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map z = br.z(str, "msg");
        if (z == null) {
            ab.e("MicroMsg.ImgInfoLogic", "parseImg failed");
            AppMethodBeat.o(78200);
            return null;
        }
        a aVar = new a();
        aVar.appId = (String) z.get(".msg.appinfo.appid");
        aVar.mediaTagName = (String) z.get(".msg.appinfo.mediatagname");
        aVar.messageExt = (String) z.get(".msg.appinfo.messageext");
        aVar.messageAction = (String) z.get(".msg.appinfo.messageaction");
        AppMethodBeat.o(78200);
        return aVar;
    }

    public static String sh(String str) {
        AppMethodBeat.i(78201);
        if (e.ct(str)) {
            String x = g.x((str + "-" + e.asZ(str)).getBytes());
            AppMethodBeat.o(78201);
            return x;
        }
        AppMethodBeat.o(78201);
        return null;
    }
}
