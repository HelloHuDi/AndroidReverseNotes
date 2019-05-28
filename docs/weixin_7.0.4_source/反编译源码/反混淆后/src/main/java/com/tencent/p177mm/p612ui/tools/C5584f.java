package com.tencent.p177mm.p612ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.ui.tools.f */
public class C5584f implements InputFilter {
    private int jeY;
    private C5583a jeZ;

    /* renamed from: com.tencent.mm.ui.tools.f$a */
    public enum C5583a {
        MODE_CHINESE_AS_1,
        MODE_CHINESE_AS_2;

        static {
            AppMethodBeat.m2505o(67857);
        }
    }

    public C5584f(int i, C5583a c5583a) {
        this.jeY = i;
        this.jeZ = c5583a;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        AppMethodBeat.m2504i(67858);
        if (C5584f.m8384a(spanned.toString(), this.jeZ) + C5584f.m8384a(charSequence.toString(), this.jeZ) > this.jeY) {
            String str = "";
            AppMethodBeat.m2505o(67858);
            return str;
        }
        AppMethodBeat.m2505o(67858);
        return charSequence;
    }

    /* renamed from: a */
    public static int m8384a(String str, C5583a c5583a) {
        AppMethodBeat.m2504i(67859);
        int ash;
        if (c5583a == C5583a.MODE_CHINESE_AS_1) {
            ash = C5584f.ash(str);
            AppMethodBeat.m2505o(67859);
            return ash;
        } else if (c5583a == C5583a.MODE_CHINESE_AS_2) {
            ash = C5584f.asg(str);
            AppMethodBeat.m2505o(67859);
            return ash;
        } else {
            AppMethodBeat.m2505o(67859);
            return 0;
        }
    }

    public static int asg(String str) {
        AppMethodBeat.m2504i(67860);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(67860);
            return 0;
        }
        int length = (str.length() + C5584f.asi(str)) + C5584f.asj(str);
        AppMethodBeat.m2505o(67860);
        return length;
    }

    private static int ash(String str) {
        AppMethodBeat.m2504i(67861);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(67861);
            return 0;
        }
        int length = str.length();
        AppMethodBeat.m2505o(67861);
        return length;
    }

    public static int asi(String str) {
        AppMethodBeat.m2504i(67862);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(67862);
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                i++;
            }
        }
        AppMethodBeat.m2505o(67862);
        return i;
    }

    private static int asj(String str) {
        int i = 0;
        AppMethodBeat.m2504i(67863);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(67863);
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
                i = str.length() - (C5584f.asi(str) + i3);
                AppMethodBeat.m2505o(67863);
                return i;
            }
        }
    }

    /* renamed from: bP */
    public static int m8385bP(int i, String str) {
        AppMethodBeat.m2504i(67864);
        int round;
        if (C4988aa.don()) {
            round = Math.round(((float) (i - Math.round((float) C5584f.asg(str)))) / 2.0f);
            AppMethodBeat.m2505o(67864);
            return round;
        }
        round = i - C5584f.asg(str);
        AppMethodBeat.m2505o(67864);
        return round;
    }

    /* renamed from: bQ */
    public static int m8386bQ(int i, String str) {
        AppMethodBeat.m2504i(67865);
        int round;
        if (C4988aa.don()) {
            round = Math.round(((float) (Math.round((float) C5584f.asg(str)) - i)) / 2.0f);
            AppMethodBeat.m2505o(67865);
            return round;
        }
        round = C5584f.asg(str) - i;
        AppMethodBeat.m2505o(67865);
        return round;
    }
}
