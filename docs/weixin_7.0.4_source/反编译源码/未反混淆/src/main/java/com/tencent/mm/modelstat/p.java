package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p {

    public enum a {
        Chat(1),
        TalkChat(2),
        Sns(3);
        
        public int value;

        static {
            AppMethodBeat.o(35588);
        }

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(String str, d dVar) {
        AppMethodBeat.i(35589);
        if (dVar == null) {
            AppMethodBeat.o(35589);
            return;
        }
        b(str, dVar);
        AppMethodBeat.o(35589);
    }

    public static void b(String str, d dVar) {
        AppMethodBeat.i(35590);
        if (bo.isNullOrNil(str) || dVar == null) {
            AppMethodBeat.o(35590);
            return;
        }
        cdh tK = tK(str);
        dVar.l("Source", (tK == null ? -1 : tK.cvd) + ",");
        dVar.l("SnsStatExt", a(tK));
        AppMethodBeat.o(35590);
    }

    public static void a(String str, StringBuilder stringBuilder) {
        AppMethodBeat.i(35591);
        if (stringBuilder == null) {
            AppMethodBeat.o(35591);
            return;
        }
        cdh tK = tK(str);
        stringBuilder.append(",").append(tK == null ? -1 : tK.cvd);
        stringBuilder.append(",").append(a(tK));
        AppMethodBeat.o(35591);
    }

    public static cdh tK(String str) {
        AppMethodBeat.i(35592);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(35592);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        cdg cdg = new cdg();
        try {
            cdg.parseFrom(decode);
        } catch (Exception e) {
            ab.e("MicroMsg.SnsStatExtUtil", "", e);
        }
        cdh cdh = cdg.xcS;
        AppMethodBeat.o(35592);
        return cdh;
    }

    public static String a(String str, PString pString) {
        AppMethodBeat.i(35593);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(35593);
            return str2;
        }
        byte[] decode = Base64.decode(str, 0);
        cdg cdg = new cdg();
        try {
            cdg.parseFrom(decode);
            str2 = cdg.xcS.xcW;
            String str3 = cdg.xcS.xcV;
            str2 = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[]{URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"), Integer.valueOf(cdg.xcS.cvd), URLEncoder.encode(a(cdg.xcS), "UTF-8")});
            pString.value = cdg.xcU == null ? "" : cdg.xcU.mVX;
            AppMethodBeat.o(35593);
            return str2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            str2 = "";
            AppMethodBeat.o(35593);
            return str2;
        }
    }

    public static String a(cdh cdh) {
        String str;
        AppMethodBeat.i(35594);
        if (cdh != null) {
            String str2 = cdh.xcW;
            str = "";
            if (!bo.isNullOrNil(str2)) {
                String[] split = str2.split("\\|");
                if (split != null && split.length > 0) {
                    str = split[0];
                }
            }
            try {
                str = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[]{Integer.valueOf(cdh.xcX), URLEncoder.encode(str, "UTF-8"), cdh.xcV});
                AppMethodBeat.o(35594);
                return str;
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.SnsStatExtUtil", "", e);
            }
        }
        str = "";
        AppMethodBeat.o(35594);
        return str;
    }

    public static String I(bi biVar) {
        AppMethodBeat.i(35595);
        String str;
        if (biVar == null) {
            str = "";
            AppMethodBeat.o(35595);
            return str;
        }
        str = null;
        if (biVar.bAA()) {
            b me = b.me(biVar.field_content);
            if (me == null || bo.isNullOrNil(me.cMn)) {
                str = "";
                AppMethodBeat.o(35595);
                return str;
            }
            str = me.cMn;
        }
        if (biVar.bwt()) {
            s ut = u.ut(biVar.field_imgPath);
            if (ut == null || bo.isNullOrNil(ut.cMn)) {
                str = "";
                AppMethodBeat.o(35595);
                return str;
            }
            str = ut.cMn;
        }
        AppMethodBeat.o(35595);
        return str;
    }
}
