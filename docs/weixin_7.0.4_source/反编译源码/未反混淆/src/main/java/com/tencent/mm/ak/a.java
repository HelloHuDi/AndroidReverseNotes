package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a {
    private static int fyi = 0;
    private static int fyj = 0;

    public static class a {
        private static final f<Integer, a> emX = new c(100);
        public String cEV;
        public String fyk;
        public String fyl;
        public String fym;
        public String fyn;
        public String fyo;
        public String fyp;
        public String fyq;
        public String fyr;
        public String fys;
        public String toUser;

        static {
            AppMethodBeat.i(16426);
            AppMethodBeat.o(16426);
        }

        public static final a rE(String str) {
            AppMethodBeat.i(16425);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.BrandQALogic", "empty xml to parse");
                AppMethodBeat.o(16425);
                return null;
            }
            int indexOf = str.indexOf("<qamsg");
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = str.hashCode();
            a aVar = (a) emX.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                AppMethodBeat.o(16425);
                return aVar;
            }
            Map z = br.z(str, "qamsg");
            if (z == null) {
                ab.e("MicroMsg.BrandQALogic", "parse msg failed");
                AppMethodBeat.o(16425);
                return null;
            }
            try {
                a aVar2 = new a();
                aVar2.cEV = (String) z.get(".qamsg.$fromUser");
                aVar2.fyk = (String) z.get(".qamsg.$fromNickname");
                aVar2.toUser = (String) z.get(".qamsg.$title");
                aVar2.fyl = (String) z.get(".qamsg.question.$id");
                aVar2.fym = (String) z.get(".qamsg.question.$fromUser");
                aVar2.fyn = (String) z.get(".qamsg.question.content");
                aVar2.fyo = (String) z.get(".qamsg.answer.$id");
                aVar2.fyp = (String) z.get(".qamsg.answer.$fromUser");
                aVar2.fyq = (String) z.get(".qamsg.answer.content");
                aVar2.fyo = (String) z.get(".qamsg.answer1.$id");
                aVar2.fyr = (String) z.get(".qamsg.answer1.$fromUser");
                aVar2.fys = (String) z.get(".qamsg.answer1.content");
                emX.k(Integer.valueOf(hashCode), aVar2);
                AppMethodBeat.o(16425);
                return aVar2;
            } catch (Exception e) {
                ab.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
                ab.printErrStackTrace("MicroMsg.BrandQALogic", e, "", new Object[0]);
                AppMethodBeat.o(16425);
                return null;
            }
        }
    }

    public static String a(a aVar) {
        AppMethodBeat.i(16427);
        String str;
        if (aVar == null) {
            str = "";
            AppMethodBeat.o(16427);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(bo.nullAsNil(aVar.fys));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bo.nullAsNil(aVar.fyq));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bo.nullAsNil(aVar.fyn));
        str = stringBuilder.toString();
        AppMethodBeat.o(16427);
        return str;
    }

    public static String b(a aVar) {
        AppMethodBeat.i(16428);
        StringBuilder stringBuilder = new StringBuilder("");
        if (!r.mG(aVar.cEV)) {
            stringBuilder.append(aVar.fyk);
            stringBuilder.append(": ");
        }
        String str = bo.isNullOrNil(aVar.fys) ? bo.isNullOrNil(aVar.fyq) ? aVar.fyn : aVar.fyq : aVar.fys;
        stringBuilder.append(str);
        str = stringBuilder.toString();
        AppMethodBeat.o(16428);
        return str;
    }
}
