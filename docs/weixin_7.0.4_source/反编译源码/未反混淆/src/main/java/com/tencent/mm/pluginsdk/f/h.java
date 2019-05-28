package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class h {
    private static boolean vdA = false;
    private static long vdz;

    public static String formatTime(String str, long j) {
        AppMethodBeat.i(79456);
        String format = new SimpleDateFormat(str).format(new Date(1000 * j));
        AppMethodBeat.o(79456);
        return format;
    }

    public static String ae(Context context, int i) {
        AppMethodBeat.i(79457);
        long j = 1000 * ((long) i);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String str;
        if (j < 3600000) {
            str = "";
            AppMethodBeat.o(79457);
            return str;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis < 0 || timeInMillis >= 86400000) {
            timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 86400000);
            if (timeInMillis < 0 || timeInMillis >= 86400000) {
                timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 172800000);
                if (timeInMillis < 0 || timeInMillis >= 86400000) {
                    timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 86400000);
                    if (timeInMillis < 0 || timeInMillis >= 86400000) {
                        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 172800000);
                        if (timeInMillis < 0 || timeInMillis >= 86400000) {
                            gregorianCalendar2 = new GregorianCalendar();
                            gregorianCalendar2.setTimeInMillis(j);
                            int i2 = gregorianCalendar2.get(11);
                            if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) == gregorianCalendar2.get(3)) {
                                str = af(context, gregorianCalendar2.get(7)) + " " + ag(context, i2) + ";" + aJ(context.getString(R.string.bxp), j);
                                AppMethodBeat.o(79457);
                                return str;
                            } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar2.get(3)) {
                                int i3 = gregorianCalendar2.get(7);
                                StringBuilder stringBuilder = new StringBuilder();
                                switch (i3) {
                                    case 1:
                                        str = context.getString(R.string.bxz);
                                        break;
                                    case 2:
                                        str = context.getString(R.string.bxx);
                                        break;
                                    case 3:
                                        str = context.getString(R.string.by1);
                                        break;
                                    case 4:
                                        str = context.getString(R.string.by2);
                                        break;
                                    case 5:
                                        str = context.getString(R.string.by0);
                                        break;
                                    case 6:
                                        str = context.getString(R.string.bxw);
                                        break;
                                    case 7:
                                        str = context.getString(R.string.bxy);
                                        break;
                                    default:
                                        str = "";
                                        break;
                                }
                                str = stringBuilder.append(str).append(" ").append(ag(context, i2)).append(";").append(aJ(context.getString(R.string.bxp), j)).toString();
                                AppMethodBeat.o(79457);
                                return str;
                            } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
                                str = DateFormat.format(context.getString(R.string.bww), j) + " " + ag(context, i2) + ";" + aJ(context.getString(R.string.bxp), j);
                                AppMethodBeat.o(79457);
                                return str;
                            } else {
                                str = DateFormat.format(context.getString(R.string.bxe), j) + " " + ag(context, i2) + ";" + aJ(context.getString(R.string.bxp), j);
                                AppMethodBeat.o(79457);
                                return str;
                            }
                        }
                        str = context.getString(R.string.bxu) + " " + r(context, timeInMillis) + ";" + aJ(context.getString(R.string.bxp), j);
                        AppMethodBeat.o(79457);
                        return str;
                    }
                    str = context.getString(R.string.by4) + " " + r(context, timeInMillis) + ";" + aJ(context.getString(R.string.bxp), j);
                    AppMethodBeat.o(79457);
                    return str;
                }
                str = context.getString(R.string.bxv) + " " + r(context, timeInMillis) + ";" + aJ(context.getString(R.string.bxp), j);
                AppMethodBeat.o(79457);
                return str;
            }
            str = context.getString(R.string.byb) + " " + r(context, timeInMillis) + ";" + aJ(context.getString(R.string.bxp), j);
            AppMethodBeat.o(79457);
            return str;
        }
        str = r(context, timeInMillis) + ";" + aJ(context.getString(R.string.bxp), j);
        AppMethodBeat.o(79457);
        return str;
    }

    public static String aJ(String str, long j) {
        AppMethodBeat.i(79458);
        String charSequence = DateFormat.format(str, j).toString();
        if (bo.isNullOrNil(charSequence)) {
            charSequence = "";
            AppMethodBeat.o(79458);
            return charSequence;
        }
        charSequence = charSequence.trim();
        if (charSequence.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            charSequence = charSequence.substring(1);
        }
        AppMethodBeat.o(79458);
        return charSequence;
    }

    public static String af(Context context, int i) {
        AppMethodBeat.i(79459);
        String string;
        switch (i) {
            case 1:
                string = context.getString(R.string.by8);
                AppMethodBeat.o(79459);
                return string;
            case 2:
                string = context.getString(R.string.by6);
                AppMethodBeat.o(79459);
                return string;
            case 3:
                string = context.getString(R.string.by_);
                AppMethodBeat.o(79459);
                return string;
            case 4:
                string = context.getString(R.string.bya);
                AppMethodBeat.o(79459);
                return string;
            case 5:
                string = context.getString(R.string.by9);
                AppMethodBeat.o(79459);
                return string;
            case 6:
                string = context.getString(R.string.by5);
                AppMethodBeat.o(79459);
                return string;
            case 7:
                string = context.getString(R.string.by7);
                AppMethodBeat.o(79459);
                return string;
            default:
                string = "";
                AppMethodBeat.o(79459);
                return string;
        }
    }

    public static CharSequence p(Context context, long j) {
        AppMethodBeat.i(79460);
        String str = context.getString(R.string.bz0) + DateFormat.format(context.getString(R.string.byz), j);
        AppMethodBeat.o(79460);
        return str;
    }

    public static CharSequence q(Context context, long j) {
        AppMethodBeat.i(79461);
        String str = context.getString(R.string.bz1) + DateFormat.format(context.getString(R.string.byz), j);
        AppMethodBeat.o(79461);
        return str;
    }

    private static CharSequence ag(Context context, int i) {
        AppMethodBeat.i(79462);
        CharSequence string;
        if (i < 0) {
            String str = "";
            AppMethodBeat.o(79462);
            return str;
        } else if (((long) i) < 6) {
            string = context.getString(R.string.bx0);
            AppMethodBeat.o(79462);
            return string;
        } else if (((long) i) < 12) {
            string = context.getString(R.string.bxi);
            AppMethodBeat.o(79462);
            return string;
        } else if (((long) i) < 13) {
            string = context.getString(R.string.bxo);
            AppMethodBeat.o(79462);
            return string;
        } else if (((long) i) < 18) {
            string = context.getString(R.string.bwm);
            AppMethodBeat.o(79462);
            return string;
        } else {
            string = context.getString(R.string.bx7);
            AppMethodBeat.o(79462);
            return string;
        }
    }

    public static CharSequence r(Context context, long j) {
        AppMethodBeat.i(79463);
        CharSequence string;
        if (j < 0) {
            String str = "";
            AppMethodBeat.o(79463);
            return str;
        } else if (j < 21600000) {
            string = context.getString(R.string.bx0);
            AppMethodBeat.o(79463);
            return string;
        } else if (j < 43200000) {
            string = context.getString(R.string.bxi);
            AppMethodBeat.o(79463);
            return string;
        } else if (j < 46800000) {
            string = context.getString(R.string.bxo);
            AppMethodBeat.o(79463);
            return string;
        } else if (j < 64800000) {
            string = context.getString(R.string.bwm);
            AppMethodBeat.o(79463);
            return string;
        } else {
            string = context.getString(R.string.bx7);
            AppMethodBeat.o(79463);
            return string;
        }
    }

    public static boolean dhT() {
        AppMethodBeat.i(79464);
        if (System.currentTimeMillis() - vdz > 30000) {
            vdA = DateFormat.is24HourFormat(ah.getContext());
        }
        boolean z = vdA;
        AppMethodBeat.o(79464);
        return z;
    }

    public static CharSequence c(Context context, long j, boolean z) {
        AppMethodBeat.i(79465);
        CharSequence charSequence;
        if (!aa.doo()) {
            Locale amw = aa.amw(aa.dor());
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                String str = "";
                AppMethodBeat.o(79465);
                return str;
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                    gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(j);
                    if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) == gregorianCalendar2.get(3)) {
                        charSequence = new SimpleDateFormat(QLog.TAG_REPORTLEVEL_USER, amw).format(Long.valueOf(j));
                        if (z) {
                            AppMethodBeat.o(79465);
                            return charSequence;
                        }
                        charSequence = charSequence + " " + java.text.DateFormat.getTimeInstance(3, amw).format(Long.valueOf(j));
                        AppMethodBeat.o(79465);
                        return charSequence;
                    } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
                        if (z) {
                            charSequence = java.text.DateFormat.getDateInstance(3, amw).format(Long.valueOf(j));
                            AppMethodBeat.o(79465);
                            return charSequence;
                        }
                        charSequence = java.text.DateFormat.getDateTimeInstance(3, 3, amw).format(Long.valueOf(j));
                        AppMethodBeat.o(79465);
                        return charSequence;
                    } else if (z) {
                        charSequence = java.text.DateFormat.getDateInstance(3, amw).format(Long.valueOf(j));
                        AppMethodBeat.o(79465);
                        return charSequence;
                    } else {
                        charSequence = java.text.DateFormat.getDateTimeInstance(3, 3, amw).format(Long.valueOf(j));
                        AppMethodBeat.o(79465);
                        return charSequence;
                    }
                } else if (z) {
                    charSequence = context.getString(R.string.byb);
                    AppMethodBeat.o(79465);
                    return charSequence;
                } else {
                    charSequence = context.getString(R.string.byb) + " " + java.text.DateFormat.getTimeInstance(3, amw).format(Long.valueOf(j));
                    AppMethodBeat.o(79465);
                    return charSequence;
                }
            }
            charSequence = java.text.DateFormat.getTimeInstance(3, amw).format(Long.valueOf(j));
            AppMethodBeat.o(79465);
            return charSequence;
        } else if (j < 3600000) {
            charSequence = "";
            AppMethodBeat.o(79465);
            return charSequence;
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                if (dhT()) {
                    charSequence = g.a(context.getString(R.string.bxq), time);
                    AppMethodBeat.o(79465);
                    return charSequence;
                }
                charSequence = ag(context, time.hour) + g.a(context.getString(R.string.bxp), time);
                AppMethodBeat.o(79465);
                return charSequence;
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                boolean dhT = dhT();
                if (z) {
                    charSequence = context.getString(R.string.byb);
                    AppMethodBeat.o(79465);
                    return charSequence;
                }
                Object a;
                StringBuilder append = new StringBuilder().append(context.getString(R.string.byb)).append(" ");
                if (dhT) {
                    a = g.a(context.getString(R.string.bxq), time);
                } else {
                    a = ag(context, time.hour) + g.a(context.getString(R.string.bxp), time);
                }
                charSequence = append.append(a).toString();
                AppMethodBeat.o(79465);
                return charSequence;
            } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                charSequence = g.a("E ", time);
                if (z) {
                    AppMethodBeat.o(79465);
                    return charSequence;
                }
                charSequence = charSequence + g.a(context.getString(R.string.bxr), time);
                AppMethodBeat.o(79465);
                return charSequence;
            } else if (time.year == time2.year) {
                if (z) {
                    charSequence = g.a(context.getString(R.string.bww), time);
                    AppMethodBeat.o(79465);
                    return charSequence;
                }
                charSequence = g.a(context.getString(R.string.bwy, new Object[]{r(context, ((long) time.hour) * 3600000)}).toString(), time);
                AppMethodBeat.o(79465);
                return charSequence;
            } else if (z) {
                charSequence = g.a(context.getString(R.string.bxe), time);
                AppMethodBeat.o(79465);
                return charSequence;
            } else {
                charSequence = g.a(context.getString(R.string.bxg, new Object[]{r(context, ((long) time.hour) * 3600000)}).toString(), time);
                AppMethodBeat.o(79465);
                return charSequence;
            }
        }
    }
}
