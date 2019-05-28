package com.tencent.p177mm.p186ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.ak.a */
public final class C1235a {
    private static int fyi = 0;
    private static int fyj = 0;

    /* renamed from: com.tencent.mm.ak.a$a */
    public static class C1236a {
        private static final C1177f<Integer, C1236a> emX = new C7598c(100);
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
            AppMethodBeat.m2504i(16426);
            AppMethodBeat.m2505o(16426);
        }

        /* renamed from: rE */
        public static final C1236a m2673rE(String str) {
            AppMethodBeat.m2504i(16425);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.BrandQALogic", "empty xml to parse");
                AppMethodBeat.m2505o(16425);
                return null;
            }
            int indexOf = str.indexOf("<qamsg");
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = str.hashCode();
            C1236a c1236a = (C1236a) emX.get(Integer.valueOf(hashCode));
            if (c1236a != null) {
                AppMethodBeat.m2505o(16425);
                return c1236a;
            }
            Map z = C5049br.m7595z(str, "qamsg");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.BrandQALogic", "parse msg failed");
                AppMethodBeat.m2505o(16425);
                return null;
            }
            try {
                C1236a c1236a2 = new C1236a();
                c1236a2.cEV = (String) z.get(".qamsg.$fromUser");
                c1236a2.fyk = (String) z.get(".qamsg.$fromNickname");
                c1236a2.toUser = (String) z.get(".qamsg.$title");
                c1236a2.fyl = (String) z.get(".qamsg.question.$id");
                c1236a2.fym = (String) z.get(".qamsg.question.$fromUser");
                c1236a2.fyn = (String) z.get(".qamsg.question.content");
                c1236a2.fyo = (String) z.get(".qamsg.answer.$id");
                c1236a2.fyp = (String) z.get(".qamsg.answer.$fromUser");
                c1236a2.fyq = (String) z.get(".qamsg.answer.content");
                c1236a2.fyo = (String) z.get(".qamsg.answer1.$id");
                c1236a2.fyr = (String) z.get(".qamsg.answer1.$fromUser");
                c1236a2.fys = (String) z.get(".qamsg.answer1.content");
                emX.mo4412k(Integer.valueOf(hashCode), c1236a2);
                AppMethodBeat.m2505o(16425);
                return c1236a2;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
                C4990ab.printErrStackTrace("MicroMsg.BrandQALogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(16425);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static String m2671a(C1236a c1236a) {
        AppMethodBeat.m2504i(16427);
        String str;
        if (c1236a == null) {
            str = "";
            AppMethodBeat.m2505o(16427);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(C5046bo.nullAsNil(c1236a.fys));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(C5046bo.nullAsNil(c1236a.fyq));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(C5046bo.nullAsNil(c1236a.fyn));
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(16427);
        return str;
    }

    /* renamed from: b */
    public static String m2672b(C1236a c1236a) {
        AppMethodBeat.m2504i(16428);
        StringBuilder stringBuilder = new StringBuilder("");
        if (!C1853r.m3858mG(c1236a.cEV)) {
            stringBuilder.append(c1236a.fyk);
            stringBuilder.append(": ");
        }
        String str = C5046bo.isNullOrNil(c1236a.fys) ? C5046bo.isNullOrNil(c1236a.fyq) ? c1236a.fyn : c1236a.fyq : c1236a.fys;
        stringBuilder.append(str);
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(16428);
        return str;
    }
}
