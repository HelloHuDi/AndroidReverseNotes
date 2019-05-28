package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.model.bh */
public final class C1831bh {
    public static int fmN = 0;

    /* renamed from: A */
    public static void m3767A(String str, boolean z) {
        AppMethodBeat.m2504i(77813);
        if ("bizflag".equals(str)) {
            if (z) {
                fmN |= 1;
                AppMethodBeat.m2505o(77813);
                return;
            }
            fmN &= -2;
        }
        AppMethodBeat.m2505o(77813);
    }

    public static String aad() {
        AppMethodBeat.m2504i(77814);
        StringBuilder stringBuilder = new StringBuilder();
        if (fmN != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(fmN);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(77814);
        return stringBuilder2;
    }

    /* renamed from: n */
    public static int m3769n(C7620bi c7620bi) {
        AppMethodBeat.m2504i(77815);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(77815);
            return 0;
        }
        int i;
        Map z = C5049br.m7595z(c7620bi.dqJ, "msgsource");
        if (z != null) {
            String str = (String) z.get(".msgsource.bizflag");
            if (!C5046bo.isNullOrNil(str)) {
                i = C5046bo.getInt(str, 0);
                AppMethodBeat.m2505o(77815);
                return i;
            }
        }
        i = 0;
        AppMethodBeat.m2505o(77815);
        return i;
    }

    public static String aae() {
        AppMethodBeat.m2504i(77816);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C5046bo.nullAsNil(C1831bh.aad()));
        if (stringBuilder.length() > 0) {
            stringBuilder.insert(0, "<msgsource>");
            stringBuilder.append("</msgsource>");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(77816);
            return stringBuilder2;
        }
        AppMethodBeat.m2505o(77816);
        return null;
    }

    /* renamed from: o */
    public static boolean m3770o(C7620bi c7620bi) {
        AppMethodBeat.m2504i(77817);
        if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.dqJ))) {
            Map z = C5049br.m7595z(c7620bi.dqJ, "msgsource");
            if (z != null && C5046bo.ank((String) z.get(".msgsource.sec_msg_node.sfn")) == 1) {
                AppMethodBeat.m2505o(77817);
                return true;
            }
        }
        AppMethodBeat.m2505o(77817);
        return false;
    }

    /* renamed from: p */
    public static void m3772p(C7620bi c7620bi) {
        AppMethodBeat.m2504i(77818);
        if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.dqJ))) {
            Map z = C5049br.m7595z(c7620bi.dqJ, "msgsource");
            if (z != null && C5046bo.ank((String) z.get(".msgsource.sec_msg_node.sfn")) == 1) {
                try {
                    String substring = c7620bi.dqJ.substring(c7620bi.dqJ.indexOf("<sec_msg_node"), (c7620bi.dqJ.indexOf("</sec_msg_node") + 12) + 2);
                    C4990ab.m7416i("MicroMsg.MsgSourceHelper", substring);
                    if (!C5046bo.isNullOrNil(substring)) {
                        c7620bi.mo14791ix(c7620bi.dqJ.replace(substring, substring.replace(substring.substring(substring.indexOf("<sfn"), (substring.indexOf("</sfn") + 3) + 2), "<sfn>0<sfn/>")));
                    }
                    AppMethodBeat.m2505o(77818);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MsgSourceHelper", e, "resetShareForbidden msg exception", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(77818);
    }

    /* renamed from: q */
    public static boolean m3773q(C7620bi c7620bi) {
        AppMethodBeat.m2504i(77819);
        if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.dqJ))) {
            Map z = C5049br.m7595z(c7620bi.dqJ, "msgsource");
            if (z != null && C5046bo.ank((String) z.get(".msgsource.sec_msg_node.fd")) == 1) {
                AppMethodBeat.m2505o(77819);
                return true;
            }
        }
        AppMethodBeat.m2505o(77819);
        return false;
    }

    /* renamed from: r */
    public static String m3774r(C7620bi c7620bi) {
        String str;
        AppMethodBeat.m2504i(77820);
        if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.dqJ))) {
            Map z = C5049br.m7595z(c7620bi.dqJ, "msgsource");
            if (z != null) {
                str = (String) z.get(".msgsource.sec_msg_node.show-h5");
                if (!C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(77820);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.m2505o(77820);
        return str;
    }

    /* renamed from: s */
    public static String m3775s(C7620bi c7620bi) {
        String str;
        AppMethodBeat.m2504i(77821);
        if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.dqJ))) {
            Map z = C5049br.m7595z(c7620bi.dqJ, "msgsource");
            if (z != null) {
                str = (String) z.get(".msgsource.sec_msg_node.share-tip-url");
                if (!C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(77821);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.m2505o(77821);
        return str;
    }

    /* renamed from: t */
    public static int m3776t(C7620bi c7620bi) {
        AppMethodBeat.m2504i(77822);
        if (!(c7620bi == null || C5046bo.isNullOrNil(c7620bi.dqJ))) {
            Map z = C5049br.m7595z(c7620bi.dqJ, "msgsource");
            if (z != null) {
                int ank = C5046bo.ank((String) z.get(".msgsource.sec_msg_node.clip-len"));
                AppMethodBeat.m2505o(77822);
                return ank;
            }
        }
        AppMethodBeat.m2505o(77822);
        return 0;
    }

    /* renamed from: a */
    public static void m3768a(C7620bi c7620bi, int i, int i2, String str, int i3, String str2) {
        AppMethodBeat.m2504i(77823);
        if (c7620bi != null) {
            String str3 = c7620bi.dqJ;
            if (C5046bo.isNullOrNil(str3) || !str3.trim().startsWith("<msgsource>")) {
                str3 = "<msgsource></msgsource>";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<sec_msg_node>");
            stringBuilder.append("<sfn>").append(i).append("</sfn>");
            stringBuilder.append("<fd>").append(i2).append("</fd>");
            stringBuilder.append("<show-h5>").append(C5046bo.nullAsNil(str)).append("</show-h5>");
            stringBuilder.append("<clip-len>").append(i3).append("</clip-len>");
            stringBuilder.append("<share-tip-url>").append(C5046bo.nullAsNil(str2)).append("</share-tip-url>");
            stringBuilder.append("</sec_msg_node>");
            c7620bi.mo14791ix(str3.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", stringBuilder.toString() + "</msgsource>"));
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7620bi.field_msgSvrId, c7620bi);
        }
        AppMethodBeat.m2505o(77823);
    }

    public static String aaf() {
        AppMethodBeat.m2504i(77824);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(70, null);
        if (!C5046bo.isNullOrNil(str)) {
            C1720g.m3536RP().mo5239Ry().set(70, (Object) "");
        }
        C4990ab.m7411d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append(C5046bo.nullAsNil(str));
        if (fmN != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(fmN);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        stringBuilder.append("</msgsource>");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(77824);
        return str;
    }

    /* renamed from: oG */
    public static void m3771oG(String str) {
        AppMethodBeat.m2504i(77825);
        C4990ab.m7417i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", str, "");
        AppMethodBeat.m2505o(77825);
    }
}
