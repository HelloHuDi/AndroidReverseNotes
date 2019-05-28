package com.tencent.p177mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.protocal.protobuf.cdh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.modelstat.p */
public final class C26485p {

    /* renamed from: com.tencent.mm.modelstat.p$a */
    public enum C1876a {
        Chat(1),
        TalkChat(2),
        Sns(3);
        
        public int value;

        static {
            AppMethodBeat.m2505o(35588);
        }

        private C1876a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: a */
    public static void m42202a(String str, C32831d c32831d) {
        AppMethodBeat.m2504i(35589);
        if (c32831d == null) {
            AppMethodBeat.m2505o(35589);
            return;
        }
        C26485p.m42204b(str, c32831d);
        AppMethodBeat.m2505o(35589);
    }

    /* renamed from: b */
    public static void m42204b(String str, C32831d c32831d) {
        AppMethodBeat.m2504i(35590);
        if (C5046bo.isNullOrNil(str) || c32831d == null) {
            AppMethodBeat.m2505o(35590);
            return;
        }
        cdh tK = C26485p.m42205tK(str);
        c32831d.mo53400l("Source", (tK == null ? -1 : tK.cvd) + ",");
        c32831d.mo53400l("SnsStatExt", C26485p.m42200a(tK));
        AppMethodBeat.m2505o(35590);
    }

    /* renamed from: a */
    public static void m42203a(String str, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(35591);
        if (stringBuilder == null) {
            AppMethodBeat.m2505o(35591);
            return;
        }
        cdh tK = C26485p.m42205tK(str);
        stringBuilder.append(",").append(tK == null ? -1 : tK.cvd);
        stringBuilder.append(",").append(C26485p.m42200a(tK));
        AppMethodBeat.m2505o(35591);
    }

    /* renamed from: tK */
    public static cdh m42205tK(String str) {
        AppMethodBeat.m2504i(35592);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(35592);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        cdg cdg = new cdg();
        try {
            cdg.parseFrom(decode);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SnsStatExtUtil", "", e);
        }
        cdh cdh = cdg.xcS;
        AppMethodBeat.m2505o(35592);
        return cdh;
    }

    /* renamed from: a */
    public static String m42201a(String str, PString pString) {
        AppMethodBeat.m2504i(35593);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(35593);
            return str2;
        }
        byte[] decode = Base64.decode(str, 0);
        cdg cdg = new cdg();
        try {
            cdg.parseFrom(decode);
            str2 = cdg.xcS.xcW;
            String str3 = cdg.xcS.xcV;
            str2 = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[]{URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"), Integer.valueOf(cdg.xcS.cvd), URLEncoder.encode(C26485p.m42200a(cdg.xcS), "UTF-8")});
            pString.value = cdg.xcU == null ? "" : cdg.xcU.mVX;
            AppMethodBeat.m2505o(35593);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            str2 = "";
            AppMethodBeat.m2505o(35593);
            return str2;
        }
    }

    /* renamed from: a */
    public static String m42200a(cdh cdh) {
        String str;
        AppMethodBeat.m2504i(35594);
        if (cdh != null) {
            String str2 = cdh.xcW;
            str = "";
            if (!C5046bo.isNullOrNil(str2)) {
                String[] split = str2.split("\\|");
                if (split != null && split.length > 0) {
                    str = split[0];
                }
            }
            try {
                str = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[]{Integer.valueOf(cdh.xcX), URLEncoder.encode(str, "UTF-8"), cdh.xcV});
                AppMethodBeat.m2505o(35594);
                return str;
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7413e("MicroMsg.SnsStatExtUtil", "", e);
            }
        }
        str = "";
        AppMethodBeat.m2505o(35594);
        return str;
    }

    /* renamed from: I */
    public static String m42199I(C7620bi c7620bi) {
        AppMethodBeat.m2504i(35595);
        String str;
        if (c7620bi == null) {
            str = "";
            AppMethodBeat.m2505o(35595);
            return str;
        }
        str = null;
        if (c7620bi.bAA()) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me == null || C5046bo.isNullOrNil(me.cMn)) {
                str = "";
                AppMethodBeat.m2505o(35595);
                return str;
            }
            str = me.cMn;
        }
        if (c7620bi.bwt()) {
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            if (ut == null || C5046bo.isNullOrNil(ut.cMn)) {
                str = "";
                AppMethodBeat.m2505o(35595);
                return str;
            }
            str = ut.cMn;
        }
        AppMethodBeat.m2505o(35595);
        return str;
    }
}
