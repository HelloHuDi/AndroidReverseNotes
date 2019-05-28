package com.tencent.p177mm.pluginsdk.p1079f;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* renamed from: com.tencent.mm.pluginsdk.f.h */
public final class C14835h {
    private static boolean vdA = false;
    private static long vdz;

    public static String formatTime(String str, long j) {
        AppMethodBeat.m2504i(79456);
        String format = new SimpleDateFormat(str).format(new Date(1000 * j));
        AppMethodBeat.m2505o(79456);
        return format;
    }

    /* renamed from: ae */
    public static String m23086ae(Context context, int i) {
        AppMethodBeat.m2504i(79457);
        long j = 1000 * ((long) i);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String str;
        if (j < 3600000) {
            str = "";
            AppMethodBeat.m2505o(79457);
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
                                str = C14835h.m23087af(context, gregorianCalendar2.get(7)) + " " + C14835h.m23088ag(context, i2) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
                                AppMethodBeat.m2505o(79457);
                                return str;
                            } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar2.get(3)) {
                                int i3 = gregorianCalendar2.get(7);
                                StringBuilder stringBuilder = new StringBuilder();
                                switch (i3) {
                                    case 1:
                                        str = context.getString(C25738R.string.bxz);
                                        break;
                                    case 2:
                                        str = context.getString(C25738R.string.bxx);
                                        break;
                                    case 3:
                                        str = context.getString(C25738R.string.by1);
                                        break;
                                    case 4:
                                        str = context.getString(C25738R.string.by2);
                                        break;
                                    case 5:
                                        str = context.getString(C25738R.string.by0);
                                        break;
                                    case 6:
                                        str = context.getString(C25738R.string.bxw);
                                        break;
                                    case 7:
                                        str = context.getString(C25738R.string.bxy);
                                        break;
                                    default:
                                        str = "";
                                        break;
                                }
                                str = stringBuilder.append(str).append(" ").append(C14835h.m23088ag(context, i2)).append(";").append(C14835h.m23085aJ(context.getString(C25738R.string.bxp), j)).toString();
                                AppMethodBeat.m2505o(79457);
                                return str;
                            } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
                                str = DateFormat.format(context.getString(C25738R.string.bww), j) + " " + C14835h.m23088ag(context, i2) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
                                AppMethodBeat.m2505o(79457);
                                return str;
                            } else {
                                str = DateFormat.format(context.getString(C25738R.string.bxe), j) + " " + C14835h.m23088ag(context, i2) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
                                AppMethodBeat.m2505o(79457);
                                return str;
                            }
                        }
                        str = context.getString(C25738R.string.bxu) + " " + C14835h.m23092r(context, timeInMillis) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
                        AppMethodBeat.m2505o(79457);
                        return str;
                    }
                    str = context.getString(C25738R.string.by4) + " " + C14835h.m23092r(context, timeInMillis) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
                    AppMethodBeat.m2505o(79457);
                    return str;
                }
                str = context.getString(C25738R.string.bxv) + " " + C14835h.m23092r(context, timeInMillis) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
                AppMethodBeat.m2505o(79457);
                return str;
            }
            str = context.getString(C25738R.string.byb) + " " + C14835h.m23092r(context, timeInMillis) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
            AppMethodBeat.m2505o(79457);
            return str;
        }
        str = C14835h.m23092r(context, timeInMillis) + ";" + C14835h.m23085aJ(context.getString(C25738R.string.bxp), j);
        AppMethodBeat.m2505o(79457);
        return str;
    }

    /* renamed from: aJ */
    public static String m23085aJ(String str, long j) {
        AppMethodBeat.m2504i(79458);
        String charSequence = DateFormat.format(str, j).toString();
        if (C5046bo.isNullOrNil(charSequence)) {
            charSequence = "";
            AppMethodBeat.m2505o(79458);
            return charSequence;
        }
        charSequence = charSequence.trim();
        if (charSequence.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            charSequence = charSequence.substring(1);
        }
        AppMethodBeat.m2505o(79458);
        return charSequence;
    }

    /* renamed from: af */
    public static String m23087af(Context context, int i) {
        AppMethodBeat.m2504i(79459);
        String string;
        switch (i) {
            case 1:
                string = context.getString(C25738R.string.by8);
                AppMethodBeat.m2505o(79459);
                return string;
            case 2:
                string = context.getString(C25738R.string.by6);
                AppMethodBeat.m2505o(79459);
                return string;
            case 3:
                string = context.getString(C25738R.string.by_);
                AppMethodBeat.m2505o(79459);
                return string;
            case 4:
                string = context.getString(C25738R.string.bya);
                AppMethodBeat.m2505o(79459);
                return string;
            case 5:
                string = context.getString(C25738R.string.by9);
                AppMethodBeat.m2505o(79459);
                return string;
            case 6:
                string = context.getString(C25738R.string.by5);
                AppMethodBeat.m2505o(79459);
                return string;
            case 7:
                string = context.getString(C25738R.string.by7);
                AppMethodBeat.m2505o(79459);
                return string;
            default:
                string = "";
                AppMethodBeat.m2505o(79459);
                return string;
        }
    }

    /* renamed from: p */
    public static CharSequence m23090p(Context context, long j) {
        AppMethodBeat.m2504i(79460);
        String str = context.getString(C25738R.string.bz0) + DateFormat.format(context.getString(C25738R.string.byz), j);
        AppMethodBeat.m2505o(79460);
        return str;
    }

    /* renamed from: q */
    public static CharSequence m23091q(Context context, long j) {
        AppMethodBeat.m2504i(79461);
        String str = context.getString(C25738R.string.bz1) + DateFormat.format(context.getString(C25738R.string.byz), j);
        AppMethodBeat.m2505o(79461);
        return str;
    }

    /* renamed from: ag */
    private static CharSequence m23088ag(Context context, int i) {
        AppMethodBeat.m2504i(79462);
        CharSequence string;
        if (i < 0) {
            String str = "";
            AppMethodBeat.m2505o(79462);
            return str;
        } else if (((long) i) < 6) {
            string = context.getString(C25738R.string.bx0);
            AppMethodBeat.m2505o(79462);
            return string;
        } else if (((long) i) < 12) {
            string = context.getString(C25738R.string.bxi);
            AppMethodBeat.m2505o(79462);
            return string;
        } else if (((long) i) < 13) {
            string = context.getString(C25738R.string.bxo);
            AppMethodBeat.m2505o(79462);
            return string;
        } else if (((long) i) < 18) {
            string = context.getString(C25738R.string.bwm);
            AppMethodBeat.m2505o(79462);
            return string;
        } else {
            string = context.getString(C25738R.string.bx7);
            AppMethodBeat.m2505o(79462);
            return string;
        }
    }

    /* renamed from: r */
    public static CharSequence m23092r(Context context, long j) {
        AppMethodBeat.m2504i(79463);
        CharSequence string;
        if (j < 0) {
            String str = "";
            AppMethodBeat.m2505o(79463);
            return str;
        } else if (j < 21600000) {
            string = context.getString(C25738R.string.bx0);
            AppMethodBeat.m2505o(79463);
            return string;
        } else if (j < 43200000) {
            string = context.getString(C25738R.string.bxi);
            AppMethodBeat.m2505o(79463);
            return string;
        } else if (j < 46800000) {
            string = context.getString(C25738R.string.bxo);
            AppMethodBeat.m2505o(79463);
            return string;
        } else if (j < 64800000) {
            string = context.getString(C25738R.string.bwm);
            AppMethodBeat.m2505o(79463);
            return string;
        } else {
            string = context.getString(C25738R.string.bx7);
            AppMethodBeat.m2505o(79463);
            return string;
        }
    }

    public static boolean dhT() {
        AppMethodBeat.m2504i(79464);
        if (System.currentTimeMillis() - vdz > 30000) {
            vdA = DateFormat.is24HourFormat(C4996ah.getContext());
        }
        boolean z = vdA;
        AppMethodBeat.m2505o(79464);
        return z;
    }

    /* renamed from: c */
    public static CharSequence m23089c(Context context, long j, boolean z) {
        AppMethodBeat.m2504i(79465);
        CharSequence charSequence;
        if (!C4988aa.doo()) {
            Locale amw = C4988aa.amw(C4988aa.dor());
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                String str = "";
                AppMethodBeat.m2505o(79465);
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
                            AppMethodBeat.m2505o(79465);
                            return charSequence;
                        }
                        charSequence = charSequence + " " + java.text.DateFormat.getTimeInstance(3, amw).format(Long.valueOf(j));
                        AppMethodBeat.m2505o(79465);
                        return charSequence;
                    } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
                        if (z) {
                            charSequence = java.text.DateFormat.getDateInstance(3, amw).format(Long.valueOf(j));
                            AppMethodBeat.m2505o(79465);
                            return charSequence;
                        }
                        charSequence = java.text.DateFormat.getDateTimeInstance(3, 3, amw).format(Long.valueOf(j));
                        AppMethodBeat.m2505o(79465);
                        return charSequence;
                    } else if (z) {
                        charSequence = java.text.DateFormat.getDateInstance(3, amw).format(Long.valueOf(j));
                        AppMethodBeat.m2505o(79465);
                        return charSequence;
                    } else {
                        charSequence = java.text.DateFormat.getDateTimeInstance(3, 3, amw).format(Long.valueOf(j));
                        AppMethodBeat.m2505o(79465);
                        return charSequence;
                    }
                } else if (z) {
                    charSequence = context.getString(C25738R.string.byb);
                    AppMethodBeat.m2505o(79465);
                    return charSequence;
                } else {
                    charSequence = context.getString(C25738R.string.byb) + " " + java.text.DateFormat.getTimeInstance(3, amw).format(Long.valueOf(j));
                    AppMethodBeat.m2505o(79465);
                    return charSequence;
                }
            }
            charSequence = java.text.DateFormat.getTimeInstance(3, amw).format(Long.valueOf(j));
            AppMethodBeat.m2505o(79465);
            return charSequence;
        } else if (j < 3600000) {
            charSequence = "";
            AppMethodBeat.m2505o(79465);
            return charSequence;
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                if (C14835h.dhT()) {
                    charSequence = C46486g.m87705a(context.getString(C25738R.string.bxq), time);
                    AppMethodBeat.m2505o(79465);
                    return charSequence;
                }
                charSequence = C14835h.m23088ag(context, time.hour) + C46486g.m87705a(context.getString(C25738R.string.bxp), time);
                AppMethodBeat.m2505o(79465);
                return charSequence;
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                boolean dhT = C14835h.dhT();
                if (z) {
                    charSequence = context.getString(C25738R.string.byb);
                    AppMethodBeat.m2505o(79465);
                    return charSequence;
                }
                Object a;
                StringBuilder append = new StringBuilder().append(context.getString(C25738R.string.byb)).append(" ");
                if (dhT) {
                    a = C46486g.m87705a(context.getString(C25738R.string.bxq), time);
                } else {
                    a = C14835h.m23088ag(context, time.hour) + C46486g.m87705a(context.getString(C25738R.string.bxp), time);
                }
                charSequence = append.append(a).toString();
                AppMethodBeat.m2505o(79465);
                return charSequence;
            } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                charSequence = C46486g.m87705a("E ", time);
                if (z) {
                    AppMethodBeat.m2505o(79465);
                    return charSequence;
                }
                charSequence = charSequence + C46486g.m87705a(context.getString(C25738R.string.bxr), time);
                AppMethodBeat.m2505o(79465);
                return charSequence;
            } else if (time.year == time2.year) {
                if (z) {
                    charSequence = C46486g.m87705a(context.getString(C25738R.string.bww), time);
                    AppMethodBeat.m2505o(79465);
                    return charSequence;
                }
                charSequence = C46486g.m87705a(context.getString(C25738R.string.bwy, new Object[]{C14835h.m23092r(context, ((long) time.hour) * 3600000)}).toString(), time);
                AppMethodBeat.m2505o(79465);
                return charSequence;
            } else if (z) {
                charSequence = C46486g.m87705a(context.getString(C25738R.string.bxe), time);
                AppMethodBeat.m2505o(79465);
                return charSequence;
            } else {
                charSequence = C46486g.m87705a(context.getString(C25738R.string.bxg, new Object[]{C14835h.m23092r(context, ((long) time.hour) * 3600000)}).toString(), time);
                AppMethodBeat.m2505o(79465);
                return charSequence;
            }
        }
    }
}
