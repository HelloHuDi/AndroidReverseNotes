package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.k.i;
import a.k.k;
import a.k.u;
import a.k.v;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\t\u001a\u001a\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u0002H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0012"}, dWq = {"isMpArticleUrl", "", "", "(Ljava/lang/String;)Z", "isMpUrl", "clearShortUrl", "rawUrl", "appendStats", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"})
public final class m {
    public static final String FT(String str) {
        int i;
        Object subSequence;
        AppMethodBeat.i(14971);
        j.p(str, "rawUrl");
        String[] strArr = new String[]{"sessionid", "subscene", "scene", "ascene", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime"};
        String str2 = str;
        for (i = 0; i < 9; i++) {
            str2 = dh(str2, strArr[i]);
        }
        Object obj = new char[]{'?', '&'};
        j.p(str2, "receiver$0");
        j.p(obj, "chars");
        CharSequence charSequence = str2;
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            char charAt = charSequence.charAt(length);
            j.p(obj, "receiver$0");
            j.p(obj, "receiver$0");
            i = 0;
            while (i < 2) {
                if (charAt == obj[i]) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                subSequence = charSequence.subSequence(0, length + 1);
                break;
            }
        }
        charSequence = "";
        str2 = subSequence.toString();
        AppMethodBeat.o(14971);
        return str2;
    }

    public static final String a(String str, PreloadSession preloadSession) {
        AppMethodBeat.i(14972);
        j.p(str, "receiver$0");
        j.p(preloadSession, "session");
        if (v.a((CharSequence) str, (CharSequence) "mp.weixin.qq.com", false)) {
            int i;
            if (preloadSession.jSZ) {
                i = 1;
            } else {
                i = 0;
            }
            if (preloadSession.jTa) {
                i |= 2;
            }
            if (preloadSession.jTb) {
                i |= 4;
            }
            if (preloadSession.jTc) {
                i |= 8;
            }
            if (preloadSession.jTd) {
                i |= 16;
            }
            if (preloadSession.jTe) {
                i |= 32;
            }
            r1 = new String[8][];
            r1[0] = new String[]{"sessionid", String.valueOf(preloadSession.id)};
            r1[1] = new String[]{"subscene", String.valueOf(preloadSession.jSW)};
            r1[2] = new String[]{"scene", String.valueOf(preloadSession.jSu)};
            r1[3] = new String[]{"ascene", String.valueOf(preloadSession.jSX)};
            r1[4] = new String[]{"fasttmpl_type", String.valueOf(preloadSession.jSV)};
            r1[5] = new String[]{"fasttmpl_fullversion", preloadSession.jSY};
            r1[6] = new String[]{"fasttmpl_flag", String.valueOf(i)};
            r1[7] = new String[]{"realreporttime", String.valueOf(System.currentTimeMillis())};
            for (i = 0; i < 8; i++) {
                String[] strArr = r1[i];
                str = G(str, strArr[0], strArr[1]);
            }
            AppMethodBeat.o(14972);
        } else {
            AppMethodBeat.o(14972);
        }
        return str;
    }

    private static final k FU(String str) {
        AppMethodBeat.i(14973);
        k kVar = new k("(?<=" + str + "=).+?(?=&)");
        AppMethodBeat.o(14973);
        return kVar;
    }

    private static final k FV(String str) {
        AppMethodBeat.i(14974);
        k kVar = new k("(?<=[?|&])" + str + "=.+?(?:&|$)");
        AppMethodBeat.o(14974);
        return kVar;
    }

    public static final String dg(String str, String str2) {
        AppMethodBeat.i(14975);
        j.p(str, "receiver$0");
        j.p(str2, "param");
        i a = k.a(FU(str2), str);
        if (a != null) {
            String value = a.getValue();
            AppMethodBeat.o(14975);
            return value;
        }
        AppMethodBeat.o(14975);
        return null;
    }

    public static final boolean FC(String str) {
        AppMethodBeat.i(14976);
        j.p(str, "receiver$0");
        if (u.jb(str, "https://mp.weixin.qq.com/") || u.jb(str, "http://mp.weixin.qq.com/")) {
            AppMethodBeat.o(14976);
            return true;
        }
        AppMethodBeat.o(14976);
        return false;
    }

    public static final boolean FW(String str) {
        AppMethodBeat.i(14977);
        j.p(str, "receiver$0");
        if (u.jb(str, "https://mp.weixin.qq.com/s?") || u.jb(str, "http://mp.weixin.qq.com/s?")) {
            AppMethodBeat.o(14977);
            return true;
        }
        AppMethodBeat.o(14977);
        return false;
    }

    public static final String G(String str, String str2, String str3) {
        String str4;
        AppMethodBeat.i(14978);
        j.p(str, "receiver$0");
        j.p(str2, "param");
        j.p(str3, "value");
        List a = v.a((CharSequence) str, new String[]{"#"});
        String str5 = (String) a.get(0);
        if (v.a((CharSequence) str5, (CharSequence) "?", false)) {
            str4 = str5;
        } else {
            str4 = str5 + "?";
        }
        if (v.d((CharSequence) str4, (CharSequence) str2 + '=')) {
            str5 = FU(str2).c(str4, str3);
        } else {
            str5 = str4 + (u.jc(str4, "?") ? "" : "&") + str2 + '=' + str3;
        }
        if (a.size() > 1) {
            str5 = str5 + '#' + ((String) a.get(1));
            AppMethodBeat.o(14978);
            return str5;
        }
        AppMethodBeat.o(14978);
        return str5;
    }

    public static final String dh(String str, String str2) {
        AppMethodBeat.i(14979);
        j.p(str, "receiver$0");
        j.p(str2, "param");
        String c = FV(str2).c((String) v.a((CharSequence) str, new String[]{"#"}).get(0), "");
        AppMethodBeat.o(14979);
        return c;
    }
}
