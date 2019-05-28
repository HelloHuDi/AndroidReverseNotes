package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.PreloadSession;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C25274k;
import p000a.p051k.C31820v;
import p000a.p051k.C6163u;
import p000a.p051k.C8305i;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\t\u001a\u001a\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u0002H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0012"}, dWq = {"isMpArticleUrl", "", "", "(Ljava/lang/String;)Z", "isMpUrl", "clearShortUrl", "rawUrl", "appendStats", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.m */
public final class C27540m {
    /* renamed from: FT */
    public static final String m43704FT(String str) {
        int i;
        Object subSequence;
        AppMethodBeat.m2504i(14971);
        C25052j.m39376p(str, "rawUrl");
        String[] strArr = new String[]{"sessionid", "subscene", "scene", "ascene", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime"};
        String str2 = str;
        for (i = 0; i < 9; i++) {
            str2 = C27540m.m43711dh(str2, strArr[i]);
        }
        Object obj = new char[]{'?', '&'};
        C25052j.m39376p(str2, "receiver$0");
        C25052j.m39376p(obj, "chars");
        CharSequence charSequence = str2;
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            char charAt = charSequence.charAt(length);
            C25052j.m39376p(obj, "receiver$0");
            C25052j.m39376p(obj, "receiver$0");
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
        AppMethodBeat.m2505o(14971);
        return str2;
    }

    /* renamed from: a */
    public static final String m43709a(String str, PreloadSession preloadSession) {
        AppMethodBeat.m2504i(14972);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(preloadSession, "session");
        if (C31820v.m51526a((CharSequence) str, (CharSequence) "mp.weixin.qq.com", false)) {
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
            r1[0] = new String[]{"sessionid", String.valueOf(preloadSession.f4371id)};
            r1[1] = new String[]{"subscene", String.valueOf(preloadSession.jSW)};
            r1[2] = new String[]{"scene", String.valueOf(preloadSession.jSu)};
            r1[3] = new String[]{"ascene", String.valueOf(preloadSession.jSX)};
            r1[4] = new String[]{"fasttmpl_type", String.valueOf(preloadSession.jSV)};
            r1[5] = new String[]{"fasttmpl_fullversion", preloadSession.jSY};
            r1[6] = new String[]{"fasttmpl_flag", String.valueOf(i)};
            r1[7] = new String[]{"realreporttime", String.valueOf(System.currentTimeMillis())};
            for (i = 0; i < 8; i++) {
                String[] strArr = r1[i];
                str = C27540m.m43708G(str, strArr[0], strArr[1]);
            }
            AppMethodBeat.m2505o(14972);
        } else {
            AppMethodBeat.m2505o(14972);
        }
        return str;
    }

    /* renamed from: FU */
    private static final C25274k m43705FU(String str) {
        AppMethodBeat.m2504i(14973);
        C25274k c25274k = new C25274k("(?<=" + str + "=).+?(?=&)");
        AppMethodBeat.m2505o(14973);
        return c25274k;
    }

    /* renamed from: FV */
    private static final C25274k m43706FV(String str) {
        AppMethodBeat.m2504i(14974);
        C25274k c25274k = new C25274k("(?<=[?|&])" + str + "=.+?(?:&|$)");
        AppMethodBeat.m2505o(14974);
        return c25274k;
    }

    /* renamed from: dg */
    public static final String m43710dg(String str, String str2) {
        AppMethodBeat.m2504i(14975);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "param");
        C8305i a = C25274k.m39839a(C27540m.m43705FU(str2), str);
        if (a != null) {
            String value = a.getValue();
            AppMethodBeat.m2505o(14975);
            return value;
        }
        AppMethodBeat.m2505o(14975);
        return null;
    }

    /* renamed from: FC */
    public static final boolean m43703FC(String str) {
        AppMethodBeat.m2504i(14976);
        C25052j.m39376p(str, "receiver$0");
        if (C6163u.m9839jb(str, "https://mp.weixin.qq.com/") || C6163u.m9839jb(str, "http://mp.weixin.qq.com/")) {
            AppMethodBeat.m2505o(14976);
            return true;
        }
        AppMethodBeat.m2505o(14976);
        return false;
    }

    /* renamed from: FW */
    public static final boolean m43707FW(String str) {
        AppMethodBeat.m2504i(14977);
        C25052j.m39376p(str, "receiver$0");
        if (C6163u.m9839jb(str, "https://mp.weixin.qq.com/s?") || C6163u.m9839jb(str, "http://mp.weixin.qq.com/s?")) {
            AppMethodBeat.m2505o(14977);
            return true;
        }
        AppMethodBeat.m2505o(14977);
        return false;
    }

    /* renamed from: G */
    public static final String m43708G(String str, String str2, String str3) {
        String str4;
        AppMethodBeat.m2504i(14978);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "param");
        C25052j.m39376p(str3, "value");
        List a = C31820v.m51524a((CharSequence) str, new String[]{"#"});
        String str5 = (String) a.get(0);
        if (C31820v.m51526a((CharSequence) str5, (CharSequence) "?", false)) {
            str4 = str5;
        } else {
            str4 = str5 + "?";
        }
        if (C31820v.m51540d((CharSequence) str4, (CharSequence) str2 + '=')) {
            str5 = C27540m.m43705FU(str2).mo42120c(str4, str3);
        } else {
            str5 = str4 + (C6163u.m9840jc(str4, "?") ? "" : "&") + str2 + '=' + str3;
        }
        if (a.size() > 1) {
            str5 = str5 + '#' + ((String) a.get(1));
            AppMethodBeat.m2505o(14978);
            return str5;
        }
        AppMethodBeat.m2505o(14978);
        return str5;
    }

    /* renamed from: dh */
    public static final String m43711dh(String str, String str2) {
        AppMethodBeat.m2504i(14979);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "param");
        String c = C27540m.m43706FV(str2).mo42120c((String) C31820v.m51524a((CharSequence) str, new String[]{"#"}).get(0), "");
        AppMethodBeat.m2505o(14979);
        return c;
    }
}
