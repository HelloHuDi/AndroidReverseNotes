package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Html;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.regex.Pattern;

public final class a {
    private static String TAG = "MicroMsg.ConvertHtmlToSpanned";
    private static f<String, Spanned> uOH = new c(30);
    public static Spanned uOI = null;

    static {
        AppMethodBeat.i(26688);
        AppMethodBeat.o(26688);
    }

    public static Spanned ahb(String str) {
        CharSequence str2;
        AppMethodBeat.i(26686);
        if (str2 == null) {
            str2 = "";
        }
        String replaceAll = Pattern.compile(IOUtils.LINE_SEPARATOR_UNIX, 2).matcher(str2).replaceAll("<br/>");
        Spanned fromHtml = fromHtml(replaceAll);
        uOH.put(replaceAll, fromHtml);
        AppMethodBeat.o(26686);
        return fromHtml;
    }

    private static Spanned fromHtml(String str) {
        Spanned fromHtml;
        AppMethodBeat.i(26687);
        if (!str.startsWith("<html>")) {
            str = "<html>".concat(String.valueOf(str));
        }
        if (!str.endsWith("</html>")) {
            str = str + "</html>";
        }
        try {
            uOI = null;
            fromHtml = Html.fromHtml(str, null, new c());
        } catch (Throwable th) {
            if (uOI != null) {
                fromHtml = uOI;
            } else {
                fromHtml = null;
            }
        }
        if (fromHtml == null) {
            AppMethodBeat.o(26687);
            return null;
        }
        int length = fromHtml.toString().length();
        if (length <= 1 || !fromHtml.toString().endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
            AppMethodBeat.o(26687);
            return fromHtml;
        } else if (fromHtml.getSpans(length, length, ParagraphStyle.class).length > 0) {
            Spanned spanned = (Spanned) fromHtml.subSequence(0, length - 1);
            AppMethodBeat.o(26687);
            return spanned;
        } else {
            AppMethodBeat.o(26687);
            return fromHtml;
        }
    }
}
