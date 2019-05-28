package com.tencent.p177mm.pluginsdk.p1079f;

import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.pluginsdk.f.g */
public final class C46486g {
    /* renamed from: a */
    public static CharSequence m87705a(CharSequence charSequence, Time time) {
        AppMethodBeat.m2504i(79453);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a;
            int length2;
            int i2 = 1;
            char charAt = spannableStringBuilder.charAt(i);
            if (charAt == '\'') {
                a = C46486g.m87704a(spannableStringBuilder, i, length);
                length2 = spannableStringBuilder.length();
            } else {
                CharSequence aMPMString;
                while (i + i2 < length && spannableStringBuilder.charAt(i + i2) == charAt) {
                    i2++;
                }
                switch (charAt) {
                    case 'A':
                        aMPMString = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'E':
                        aMPMString = DateUtils.getDayOfWeekString(time.weekDay + 1, i2 < 4 ? 20 : 10);
                        break;
                    case 'L':
                    case 'M':
                        a = time.month;
                        if (i2 < 4) {
                            if (i2 != 3) {
                                aMPMString = C46486g.m87706gL(a + 1, i2);
                                break;
                            }
                            aMPMString = DateUtils.getMonthString(a, 20);
                            break;
                        }
                        aMPMString = DateUtils.getMonthString(a, 10);
                        break;
                    case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                        aMPMString = DateUtils.getAMPMString(time.hour < 12 ? 0 : 1);
                        break;
                    case 'd':
                        aMPMString = C46486g.m87706gL(time.monthDay, i2);
                        break;
                    case 'h':
                        a = time.hour;
                        if (a == 0) {
                            a = 12;
                        }
                        if (a > 12) {
                            a -= 12;
                        }
                        aMPMString = String.valueOf(a);
                        break;
                    case 'k':
                        aMPMString = C46486g.m87706gL(time.hour, i2);
                        break;
                    case 'm':
                        aMPMString = C46486g.m87706gL(time.minute, i2);
                        break;
                    case 's':
                        aMPMString = C46486g.m87706gL(time.second, i2);
                        break;
                    case 'y':
                        a = time.year;
                        if (i2 > 2) {
                            aMPMString = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(a)});
                            break;
                        }
                        aMPMString = C46486g.m87706gL(a % 100, 2);
                        break;
                    case 'z':
                        TimeZone timeZone = TimeZone.getDefault();
                        timeZone.inDaylightTime(new Date(time.toMillis(false)));
                        if (i2 >= 2) {
                            aMPMString = timeZone.getDisplayName(time.isDst != 0, 0);
                            break;
                        }
                        long rawOffset = (((long) timeZone.getRawOffset()) + time.gmtoff) / 1000;
                        StringBuilder stringBuilder = new StringBuilder();
                        if (rawOffset < 0) {
                            stringBuilder.insert(0, "-");
                            rawOffset = -rawOffset;
                        } else {
                            stringBuilder.insert(0, "+");
                        }
                        a = (int) ((rawOffset % 3600) / 60);
                        stringBuilder.append(C46486g.m87706gL((int) (rawOffset / 3600), 2));
                        stringBuilder.append(C46486g.m87706gL(a, 2));
                        aMPMString = stringBuilder.toString();
                        break;
                    default:
                        aMPMString = null;
                        break;
                }
                if (aMPMString != null) {
                    spannableStringBuilder.replace(i, i + i2, aMPMString);
                    a = aMPMString.length();
                    length2 = spannableStringBuilder.length();
                } else {
                    a = i2;
                    length2 = length;
                }
            }
            i = a + i;
            length = length2;
        }
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        AppMethodBeat.m2505o(79453);
        return spannableStringBuilder2;
    }

    /* renamed from: a */
    private static int m87704a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        AppMethodBeat.m2504i(79454);
        if (i + 1 >= i2 || spannableStringBuilder.charAt(i + 1) != '\'') {
            int i3 = 0;
            spannableStringBuilder.delete(i, i + 1);
            int i4 = i2 - 1;
            while (i < i4) {
                if (spannableStringBuilder.charAt(i) != '\'') {
                    i++;
                    i3++;
                } else if (i + 1 >= i4 || spannableStringBuilder.charAt(i + 1) != '\'') {
                    spannableStringBuilder.delete(i, i + 1);
                    break;
                } else {
                    spannableStringBuilder.delete(i, i + 1);
                    i4--;
                    i3++;
                    i++;
                }
            }
            AppMethodBeat.m2505o(79454);
            return i3;
        }
        spannableStringBuilder.delete(i, i + 1);
        AppMethodBeat.m2505o(79454);
        return 1;
    }

    /* renamed from: gL */
    private static String m87706gL(int i, int i2) {
        AppMethodBeat.m2504i(79455);
        String format = String.format(Locale.getDefault(), "%0" + i2 + "d", new Object[]{Integer.valueOf(i)});
        AppMethodBeat.m2505o(79455);
        return format;
    }
}
