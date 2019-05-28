package com.tencent.ttpic.baseutils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public class StringUtils {
    public static String removeNoisyChar(String str) {
        AppMethodBeat.i(49792);
        String replaceAll = str.replaceAll("[/~!@#$%^&*\\(\\)_+\\{\\}:<>?\\[\\],./;'`\\-=\\|／～！＠＃＄％＾＆＊（）＿＋｛｝：＜＞？［］，。．／；＇`－＝｜、]+", "");
        AppMethodBeat.o(49792);
        return replaceAll;
    }

    public static String removeEmoji(String str) {
        AppMethodBeat.i(49793);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(49793);
            return str2;
        }
        str2 = str.replaceAll("\\[em\\].*?\\[/em\\]", "");
        AppMethodBeat.o(49793);
        return str2;
    }

    public static String removeUTF8Emoji(String str) {
        AppMethodBeat.i(49794);
        HashSet<Character> hashSet = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            int type = Character.getType(str.charAt(i));
            if (type == 19 || type == 28) {
                hashSet.add(Character.valueOf(str.charAt(i)));
            }
        }
        for (Character valueOf : hashSet) {
            str = str.replace(String.valueOf(valueOf), "");
        }
        AppMethodBeat.o(49794);
        return str;
    }
}
