package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f implements InputFilter {
    private int jeY;
    private a jeZ;

    public enum a {
        MODE_CHINESE_AS_1,
        MODE_CHINESE_AS_2;

        static {
            AppMethodBeat.o(67857);
        }
    }

    public f(int i, a aVar) {
        this.jeY = i;
        this.jeZ = aVar;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        AppMethodBeat.i(67858);
        if (a(spanned.toString(), this.jeZ) + a(charSequence.toString(), this.jeZ) > this.jeY) {
            String str = "";
            AppMethodBeat.o(67858);
            return str;
        }
        AppMethodBeat.o(67858);
        return charSequence;
    }

    public static int a(String str, a aVar) {
        AppMethodBeat.i(67859);
        int ash;
        if (aVar == a.MODE_CHINESE_AS_1) {
            ash = ash(str);
            AppMethodBeat.o(67859);
            return ash;
        } else if (aVar == a.MODE_CHINESE_AS_2) {
            ash = asg(str);
            AppMethodBeat.o(67859);
            return ash;
        } else {
            AppMethodBeat.o(67859);
            return 0;
        }
    }

    public static int asg(String str) {
        AppMethodBeat.i(67860);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(67860);
            return 0;
        }
        int length = (str.length() + asi(str)) + asj(str);
        AppMethodBeat.o(67860);
        return length;
    }

    private static int ash(String str) {
        AppMethodBeat.i(67861);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(67861);
            return 0;
        }
        int length = str.length();
        AppMethodBeat.o(67861);
        return length;
    }

    public static int asi(String str) {
        AppMethodBeat.i(67862);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(67862);
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                i++;
            }
        }
        AppMethodBeat.o(67862);
        return i;
    }

    private static int asj(String str) {
        int i = 0;
        AppMethodBeat.i(67863);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(67863);
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt >= 0 && charAt <= 127) {
                    i3++;
                }
                i = i3;
                i2++;
            } else {
                i = str.length() - (asi(str) + i3);
                AppMethodBeat.o(67863);
                return i;
            }
        }
    }

    public static int bP(int i, String str) {
        AppMethodBeat.i(67864);
        int round;
        if (aa.don()) {
            round = Math.round(((float) (i - Math.round((float) asg(str)))) / 2.0f);
            AppMethodBeat.o(67864);
            return round;
        }
        round = i - asg(str);
        AppMethodBeat.o(67864);
        return round;
    }

    public static int bQ(int i, String str) {
        AppMethodBeat.i(67865);
        int round;
        if (aa.don()) {
            round = Math.round(((float) (Math.round((float) asg(str)) - i)) / 2.0f);
            AppMethodBeat.o(67865);
            return round;
        }
        round = asg(str) - i;
        AppMethodBeat.o(67865);
        return round;
    }
}
