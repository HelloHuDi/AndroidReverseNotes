package com.tencent.mm.plugin.wenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class b {
    public static ArrayList<String> ahg(String str) {
        AppMethodBeat.i(26977);
        if (bo.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(26977);
            return null;
        }
        String[] split = Pattern.compile(IOUtils.LINE_SEPARATOR_UNIX, 2).matcher(Pattern.compile("<div></div>", 2).matcher(Pattern.compile("</object>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("<object[^>]*>", 2).matcher(Pattern.compile("<div><object[^>]*></object></div>", 2).matcher(str).replaceAll("<object>")).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#")).replaceAll("#WNNoteNode#<ThisisNoteNodeHrObj>#WNNoteNode#")).replaceAll("")).replaceAll("")).replaceAll("").replaceAll("<br>", "<br/>").trim().split("#WNNoteNode#");
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : split) {
            String str22;
            if (str22.length() > 0) {
                str22 = str22.replace("</div>", "<div>");
                int i = -1;
                if (str22.endsWith("<div>")) {
                    i = str22.lastIndexOf("<div>");
                }
                if (i > 0) {
                    str22 = str22.substring(0, i);
                }
                arrayList.add(str22.replace("<div><br/>", "<div>"));
            }
        }
        AppMethodBeat.o(26977);
        return arrayList;
    }

    public static String ahh(String str) {
        AppMethodBeat.i(26978);
        if (bo.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(26978);
            return str;
        }
        str = Pattern.compile("&nbsp;", 2).matcher(Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("</wx-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(str).replaceAll(IOUtils.LINE_SEPARATOR_UNIX)).replaceAll("")).replaceAll(IOUtils.LINE_SEPARATOR_UNIX)).replaceAll(IOUtils.LINE_SEPARATOR_UNIX)).replaceAll(IOUtils.LINE_SEPARATOR_UNIX)).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll(" ");
        AppMethodBeat.o(26978);
        return str;
    }

    public static boolean ahi(String str) {
        AppMethodBeat.i(26979);
        String str2 = "<br/>";
        int length = str2.length();
        if (bo.isNullOrNil(str) || str.length() < length) {
            AppMethodBeat.o(26979);
            return false;
        }
        int i = 0;
        while (i < str.length()) {
            int i2 = i + length;
            if (i2 > str.length()) {
                AppMethodBeat.o(26979);
                return false;
            } else if (str2.equalsIgnoreCase(str.substring(i, i2))) {
                i = i2;
            } else {
                AppMethodBeat.o(26979);
                return false;
            }
        }
        AppMethodBeat.o(26979);
        return true;
    }

    public static String ahj(String str) {
        AppMethodBeat.i(26980);
        String ahh = ahh(Pattern.compile("<object[^>]*>", 2).matcher(str).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
        if (bo.isNullOrNil(ahh) || ahh.length() == 0) {
            AppMethodBeat.o(26980);
            return ahh;
        }
        ahh = Pattern.compile("\\s*|\t|\r|\n").matcher(ahh).replaceAll("");
        AppMethodBeat.o(26980);
        return ahh;
    }
}
