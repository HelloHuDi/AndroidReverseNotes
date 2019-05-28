package com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a;

import android.text.Html;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.a */
public final class C14724a {
    private static String TAG = "MicroMsg.ConvertHtmlToSpanned";
    private static C1177f<String, Spanned> uOH = new C7598c(30);
    public static Spanned uOI = null;

    static {
        AppMethodBeat.m2504i(26688);
        AppMethodBeat.m2505o(26688);
    }

    public static Spanned ahb(String str) {
        CharSequence str2;
        AppMethodBeat.m2504i(26686);
        if (str2 == null) {
            str2 = "";
        }
        String replaceAll = Pattern.compile(IOUtils.LINE_SEPARATOR_UNIX, 2).matcher(str2).replaceAll("<br/>");
        Spanned fromHtml = C14724a.fromHtml(replaceAll);
        uOH.put(replaceAll, fromHtml);
        AppMethodBeat.m2505o(26686);
        return fromHtml;
    }

    private static Spanned fromHtml(String str) {
        Spanned fromHtml;
        AppMethodBeat.m2504i(26687);
        if (!str.startsWith("<html>")) {
            str = "<html>".concat(String.valueOf(str));
        }
        if (!str.endsWith("</html>")) {
            str = str + "</html>";
        }
        try {
            uOI = null;
            fromHtml = Html.fromHtml(str, null, new C40375c());
        } catch (Throwable th) {
            if (uOI != null) {
                fromHtml = uOI;
            } else {
                fromHtml = null;
            }
        }
        if (fromHtml == null) {
            AppMethodBeat.m2505o(26687);
            return null;
        }
        int length = fromHtml.toString().length();
        if (length <= 1 || !fromHtml.toString().endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
            AppMethodBeat.m2505o(26687);
            return fromHtml;
        } else if (fromHtml.getSpans(length, length, ParagraphStyle.class).length > 0) {
            Spanned spanned = (Spanned) fromHtml.subSequence(0, length - 1);
            AppMethodBeat.m2505o(26687);
            return spanned;
        } else {
            AppMethodBeat.m2505o(26687);
            return fromHtml;
        }
    }
}
