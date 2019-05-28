package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class bh {
    public static int fmN = 0;

    public static void A(String str, boolean z) {
        AppMethodBeat.i(77813);
        if ("bizflag".equals(str)) {
            if (z) {
                fmN |= 1;
                AppMethodBeat.o(77813);
                return;
            }
            fmN &= -2;
        }
        AppMethodBeat.o(77813);
    }

    public static String aad() {
        AppMethodBeat.i(77814);
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
        AppMethodBeat.o(77814);
        return stringBuilder2;
    }

    public static int n(bi biVar) {
        AppMethodBeat.i(77815);
        if (biVar == null) {
            AppMethodBeat.o(77815);
            return 0;
        }
        int i;
        Map z = br.z(biVar.dqJ, "msgsource");
        if (z != null) {
            String str = (String) z.get(".msgsource.bizflag");
            if (!bo.isNullOrNil(str)) {
                i = bo.getInt(str, 0);
                AppMethodBeat.o(77815);
                return i;
            }
        }
        i = 0;
        AppMethodBeat.o(77815);
        return i;
    }

    public static String aae() {
        AppMethodBeat.i(77816);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bo.nullAsNil(aad()));
        if (stringBuilder.length() > 0) {
            stringBuilder.insert(0, "<msgsource>");
            stringBuilder.append("</msgsource>");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(77816);
            return stringBuilder2;
        }
        AppMethodBeat.o(77816);
        return null;
    }

    public static boolean o(bi biVar) {
        AppMethodBeat.i(77817);
        if (!(biVar == null || bo.isNullOrNil(biVar.dqJ))) {
            Map z = br.z(biVar.dqJ, "msgsource");
            if (z != null && bo.ank((String) z.get(".msgsource.sec_msg_node.sfn")) == 1) {
                AppMethodBeat.o(77817);
                return true;
            }
        }
        AppMethodBeat.o(77817);
        return false;
    }

    public static void p(bi biVar) {
        AppMethodBeat.i(77818);
        if (!(biVar == null || bo.isNullOrNil(biVar.dqJ))) {
            Map z = br.z(biVar.dqJ, "msgsource");
            if (z != null && bo.ank((String) z.get(".msgsource.sec_msg_node.sfn")) == 1) {
                try {
                    String substring = biVar.dqJ.substring(biVar.dqJ.indexOf("<sec_msg_node"), (biVar.dqJ.indexOf("</sec_msg_node") + 12) + 2);
                    ab.i("MicroMsg.MsgSourceHelper", substring);
                    if (!bo.isNullOrNil(substring)) {
                        biVar.ix(biVar.dqJ.replace(substring, substring.replace(substring.substring(substring.indexOf("<sfn"), (substring.indexOf("</sfn") + 3) + 2), "<sfn>0<sfn/>")));
                    }
                    AppMethodBeat.o(77818);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MsgSourceHelper", e, "resetShareForbidden msg exception", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(77818);
    }

    public static boolean q(bi biVar) {
        AppMethodBeat.i(77819);
        if (!(biVar == null || bo.isNullOrNil(biVar.dqJ))) {
            Map z = br.z(biVar.dqJ, "msgsource");
            if (z != null && bo.ank((String) z.get(".msgsource.sec_msg_node.fd")) == 1) {
                AppMethodBeat.o(77819);
                return true;
            }
        }
        AppMethodBeat.o(77819);
        return false;
    }

    public static String r(bi biVar) {
        String str;
        AppMethodBeat.i(77820);
        if (!(biVar == null || bo.isNullOrNil(biVar.dqJ))) {
            Map z = br.z(biVar.dqJ, "msgsource");
            if (z != null) {
                str = (String) z.get(".msgsource.sec_msg_node.show-h5");
                if (!bo.isNullOrNil(str)) {
                    AppMethodBeat.o(77820);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.o(77820);
        return str;
    }

    public static String s(bi biVar) {
        String str;
        AppMethodBeat.i(77821);
        if (!(biVar == null || bo.isNullOrNil(biVar.dqJ))) {
            Map z = br.z(biVar.dqJ, "msgsource");
            if (z != null) {
                str = (String) z.get(".msgsource.sec_msg_node.share-tip-url");
                if (!bo.isNullOrNil(str)) {
                    AppMethodBeat.o(77821);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.o(77821);
        return str;
    }

    public static int t(bi biVar) {
        AppMethodBeat.i(77822);
        if (!(biVar == null || bo.isNullOrNil(biVar.dqJ))) {
            Map z = br.z(biVar.dqJ, "msgsource");
            if (z != null) {
                int ank = bo.ank((String) z.get(".msgsource.sec_msg_node.clip-len"));
                AppMethodBeat.o(77822);
                return ank;
            }
        }
        AppMethodBeat.o(77822);
        return 0;
    }

    public static void a(bi biVar, int i, int i2, String str, int i3, String str2) {
        AppMethodBeat.i(77823);
        if (biVar != null) {
            String str3 = biVar.dqJ;
            if (bo.isNullOrNil(str3) || !str3.trim().startsWith("<msgsource>")) {
                str3 = "<msgsource></msgsource>";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<sec_msg_node>");
            stringBuilder.append("<sfn>").append(i).append("</sfn>");
            stringBuilder.append("<fd>").append(i2).append("</fd>");
            stringBuilder.append("<show-h5>").append(bo.nullAsNil(str)).append("</show-h5>");
            stringBuilder.append("<clip-len>").append(i3).append("</clip-len>");
            stringBuilder.append("<share-tip-url>").append(bo.nullAsNil(str2)).append("</share-tip-url>");
            stringBuilder.append("</sec_msg_node>");
            biVar.ix(str3.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", stringBuilder.toString() + "</msgsource>"));
            ((j) g.K(j.class)).bOr().b(biVar.field_msgSvrId, biVar);
        }
        AppMethodBeat.o(77823);
    }

    public static String aaf() {
        AppMethodBeat.i(77824);
        String str = (String) g.RP().Ry().get(70, null);
        if (!bo.isNullOrNil(str)) {
            g.RP().Ry().set(70, (Object) "");
        }
        ab.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append(bo.nullAsNil(str));
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
        AppMethodBeat.o(77824);
        return str;
    }

    public static void oG(String str) {
        AppMethodBeat.i(77825);
        ab.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", str, "");
        AppMethodBeat.o(77825);
    }
}
