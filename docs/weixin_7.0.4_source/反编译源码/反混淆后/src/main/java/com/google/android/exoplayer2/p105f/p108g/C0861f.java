package com.google.android.exoplayer2.p105f.p108g;

import android.support.p057v4.widget.C8415j;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.p105f.p108g.C0858e.C0859a;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.f.g.f */
final class C0861f {
    public static final Pattern boE = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern boF = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder bnC = new StringBuilder();

    /* renamed from: com.google.android.exoplayer2.f.g.f$a */
    static final class C0862a {
        private static final String[] boG = new String[0];
        public final String boH;
        public final String[] boI;
        public final String name;
        public final int position;

        private C0862a(String str, int i, String str2, String[] strArr) {
            this.position = i;
            this.name = str;
            this.boH = str2;
            this.boI = strArr;
        }

        /* renamed from: k */
        public static C0862a m1971k(String str, int i) {
            AppMethodBeat.m2504i(95729);
            String trim = str.trim();
            if (trim.isEmpty()) {
                AppMethodBeat.m2505o(95729);
                return null;
            }
            String str2;
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = trim.split("\\.");
            String str3 = split[0];
            if (split.length > 1) {
                split = (String[]) Arrays.copyOfRange(split, 1, split.length);
            } else {
                split = boG;
            }
            C0862a c0862a = new C0862a(str3, i, str2, split);
            AppMethodBeat.m2505o(95729);
            return c0862a;
        }

        /* renamed from: te */
        public static C0862a m1972te() {
            AppMethodBeat.m2504i(95730);
            C0862a c0862a = new C0862a("", 0, "", new String[0]);
            AppMethodBeat.m2505o(95730);
            return c0862a;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.g.f$b */
    static final class C0863b implements Comparable<C0863b> {
        public final C32050d boJ;
        public final int score;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.score - ((C0863b) obj).score;
        }

        public C0863b(int i, C32050d c32050d) {
            this.score = i;
            this.boJ = c32050d;
        }
    }

    static {
        AppMethodBeat.m2504i(95739);
        AppMethodBeat.m2505o(95739);
    }

    public C0861f() {
        AppMethodBeat.m2504i(95731);
        AppMethodBeat.m2505o(95731);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo2581a(C32065l c32065l, C0859a c0859a, List<C32050d> list) {
        AppMethodBeat.m2504i(95732);
        String readLine = c32065l.readLine();
        if (readLine == null) {
            AppMethodBeat.m2505o(95732);
            return false;
        }
        Matcher matcher = boE.matcher(readLine);
        boolean a;
        if (matcher.matches()) {
            a = C0861f.m1968a(null, matcher, c32065l, c0859a, this.bnC, list);
            AppMethodBeat.m2505o(95732);
            return a;
        }
        String readLine2 = c32065l.readLine();
        if (readLine2 == null) {
            AppMethodBeat.m2505o(95732);
            return false;
        }
        matcher = boE.matcher(readLine2);
        if (matcher.matches()) {
            a = C0861f.m1968a(readLine.trim(), matcher, c32065l, c0859a, this.bnC, list);
            AppMethodBeat.m2505o(95732);
            return a;
        }
        AppMethodBeat.m2505o(95732);
        return false;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static void m1964a(String str, C0859a c0859a) {
        AppMethodBeat.m2504i(95733);
        Matcher matcher = boF.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                int indexOf;
                int parseInt;
                if ("line".equals(group)) {
                    indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        c0859a.bkX = C0861f.m1969aC(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        c0859a.bkX = C8415j.INVALID_ID;
                    }
                    if (group2.endsWith("%")) {
                        c0859a.bkW = C17660h.m27523aE(group2);
                        c0859a.lineType = 0;
                    } else {
                        parseInt = Integer.parseInt(group2);
                        if (parseInt < 0) {
                            parseInt--;
                        }
                        c0859a.bkW = (float) parseInt;
                        c0859a.lineType = 1;
                    }
                } else if ("align".equals(group)) {
                    Alignment alignment;
                    switch (group2.hashCode()) {
                        case -1364013995:
                            if (group2.equals("center")) {
                                parseInt = 2;
                                break;
                            }
                        case -1074341483:
                            if (group2.equals("middle")) {
                                parseInt = 3;
                                break;
                            }
                        case 100571:
                            if (group2.equals("end")) {
                                parseInt = 4;
                                break;
                            }
                        case 3317767:
                            if (group2.equals("left")) {
                                parseInt = 1;
                                break;
                            }
                        case 108511772:
                            if (group2.equals("right")) {
                                parseInt = 5;
                                break;
                            }
                        case 109757538:
                            if (group2.equals("start")) {
                                parseInt = 0;
                                break;
                            }
                        default:
                            parseInt = -1;
                            break;
                    }
                    switch (parseInt) {
                        case 0:
                        case 1:
                            alignment = Alignment.ALIGN_NORMAL;
                            break;
                        case 2:
                        case 3:
                            alignment = Alignment.ALIGN_CENTER;
                            break;
                        case 4:
                        case 5:
                            alignment = Alignment.ALIGN_OPPOSITE;
                            break;
                        default:
                            alignment = null;
                            break;
                    }
                    c0859a.bkV = alignment;
                } else if ("position".equals(group)) {
                    indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        c0859a.bkZ = C0861f.m1969aC(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        c0859a.bkZ = C8415j.INVALID_ID;
                    }
                    c0859a.bkY = C17660h.m27523aE(group2);
                } else if ("size".equals(group)) {
                    c0859a.width = C17660h.m27523aE(group2);
                } else {
                    new StringBuilder("Unknown cue setting ").append(group).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(group2);
                }
            } catch (NumberFormatException e) {
                new StringBuilder("Skipping bad cue setting: ").append(matcher.group());
            }
        }
        AppMethodBeat.m2505o(95733);
    }

    /* renamed from: a */
    static void m1966a(String str, String str2, C0859a c0859a, List<C32050d> list) {
        AppMethodBeat.m2504i(95734);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            int indexOf;
            String substring;
            Object obj;
            switch (charAt) {
                case '&':
                    indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                    substring = str2.substring(i + 1, indexOf);
                    obj = -1;
                    switch (substring.hashCode()) {
                        case 3309:
                            if (substring.equals("gt")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 3464:
                            if (substring.equals("lt")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 96708:
                            if (substring.equals("amp")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 3374865:
                            if (substring.equals("nbsp")) {
                                obj = 2;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            spannableStringBuilder.append('<');
                            break;
                        case 1:
                            spannableStringBuilder.append('>');
                            break;
                        case 2:
                            spannableStringBuilder.append(' ');
                            break;
                        case 3:
                            spannableStringBuilder.append('&');
                            break;
                        default:
                            new StringBuilder("ignoring unsupported entity: '&").append(substring).append(";'");
                            break;
                    }
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i = indexOf + 1;
                    break;
                case '<':
                    if (i + 1 < str2.length()) {
                        Object obj2;
                        int i2;
                        if (str2.charAt(i + 1) == IOUtils.DIR_SEPARATOR_UNIX) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        indexOf = str2.indexOf(62, i + 1);
                        if (indexOf == -1) {
                            indexOf = str2.length();
                        } else {
                            indexOf++;
                        }
                        Object obj3 = str2.charAt(indexOf + -2) == IOUtils.DIR_SEPARATOR_UNIX ? 1 : null;
                        if (obj2 != null) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                        i2 += i;
                        if (obj3 != null) {
                            i = indexOf - 2;
                        } else {
                            i = indexOf - 1;
                        }
                        String substring2 = str2.substring(i2, i);
                        String trim = substring2.trim();
                        if (trim.isEmpty()) {
                            substring = null;
                        } else {
                            substring = trim.split("[ \\.]")[0];
                        }
                        if (substring != null) {
                            obj = -1;
                            switch (substring.hashCode()) {
                                case 98:
                                    if (substring.equals("b")) {
                                        obj = null;
                                        break;
                                    }
                                    break;
                                case 99:
                                    if (substring.equals("c")) {
                                        obj = 1;
                                        break;
                                    }
                                    break;
                                case 105:
                                    if (substring.equals("i")) {
                                        obj = 2;
                                        break;
                                    }
                                    break;
                                case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
                                    if (substring.equals("u")) {
                                        obj = 4;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (substring.equals("v")) {
                                        obj = 5;
                                        break;
                                    }
                                    break;
                                case 3314158:
                                    if (substring.equals("lang")) {
                                        obj = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (obj) {
                                case null:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            if (obj != null) {
                                if (obj2 == null) {
                                    if (obj3 == null) {
                                        stack.push(C0862a.m1971k(substring2, spannableStringBuilder.length()));
                                        i = indexOf;
                                        break;
                                    }
                                }
                                while (!stack.isEmpty()) {
                                    C0862a c0862a = (C0862a) stack.pop();
                                    C0861f.m1965a(str, c0862a, spannableStringBuilder, list, arrayList);
                                    if (c0862a.name.equals(substring)) {
                                        i = indexOf;
                                        break;
                                    }
                                }
                                i = indexOf;
                            }
                        }
                        i = indexOf;
                        break;
                    }
                    i++;
                    break;
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            C0861f.m1965a(str, (C0862a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        C0861f.m1965a(str, C0862a.m1972te(), spannableStringBuilder, list, arrayList);
        c0859a.boD = spannableStringBuilder;
        AppMethodBeat.m2505o(95734);
    }

    /* renamed from: a */
    private static boolean m1968a(String str, Matcher matcher, C32065l c32065l, C0859a c0859a, StringBuilder stringBuilder, List<C32050d> list) {
        AppMethodBeat.m2504i(95735);
        try {
            c0859a.startTime = C17660h.m27522aD(matcher.group(1));
            c0859a.endTime = C17660h.m27522aD(matcher.group(2));
            C0861f.m1964a(matcher.group(3), c0859a);
            stringBuilder.setLength(0);
            while (true) {
                String readLine = c32065l.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    C0861f.m1966a(str, stringBuilder.toString(), c0859a, (List) list);
                    AppMethodBeat.m2505o(95735);
                    return true;
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuilder.append(readLine.trim());
            }
        } catch (NumberFormatException e) {
            new StringBuilder("Skipping cue with bad header: ").append(matcher.group());
            AppMethodBeat.m2505o(95735);
            return false;
        }
    }

    /* renamed from: aC */
    private static int m1969aC(String str) {
        AppMethodBeat.m2504i(95736);
        int i = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    i = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    i = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    i = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                AppMethodBeat.m2505o(95736);
                return 0;
            case 1:
            case 2:
                AppMethodBeat.m2505o(95736);
                return 1;
            case 3:
                AppMethodBeat.m2505o(95736);
                return 2;
            default:
                AppMethodBeat.m2505o(95736);
                return C8415j.INVALID_ID;
        }
    }

    /* renamed from: a */
    private static void m1965a(String str, C0862a c0862a, SpannableStringBuilder spannableStringBuilder, List<C32050d> list, List<C0863b> list2) {
        AppMethodBeat.m2504i(95737);
        int i = c0862a.position;
        int length = spannableStringBuilder.length();
        String str2 = c0862a.name;
        Object obj = -1;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    obj = 6;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    obj = null;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    obj = 3;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    obj = 1;
                    break;
                }
                break;
            case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
                if (str2.equals("u")) {
                    obj = 2;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    obj = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                AppMethodBeat.m2505o(95737);
                return;
        }
        list2.clear();
        C0861f.m1967a((List) list, str, c0862a, (List) list2);
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            C32050d c32050d = ((C0863b) list2.get(i2)).boJ;
            if (c32050d != null) {
                IllegalStateException illegalStateException;
                if (c32050d.getStyle() != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(c32050d.getStyle()), i, length, 33);
                }
                if (c32050d.bnW == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
                }
                if (c32050d.bnX == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (c32050d.bnU) {
                    if (c32050d.bnU) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(c32050d.bnT), i, length, 33);
                    } else {
                        illegalStateException = new IllegalStateException("Font color not defined");
                        AppMethodBeat.m2505o(95737);
                        throw illegalStateException;
                    }
                }
                if (c32050d.bnV) {
                    if (c32050d.bnV) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(c32050d.backgroundColor), i, length, 33);
                    } else {
                        illegalStateException = new IllegalStateException("Background color not defined.");
                        AppMethodBeat.m2505o(95737);
                        throw illegalStateException;
                    }
                }
                if (c32050d.bnS != null) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(c32050d.bnS), i, length, 33);
                }
                if (c32050d.boc != null) {
                    spannableStringBuilder.setSpan(new Standard(c32050d.boc), i, length, 33);
                }
                switch (c32050d.boa) {
                    case 1:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c32050d.fontSize, true), i, length, 33);
                        break;
                    case 2:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(c32050d.fontSize), i, length, 33);
                        break;
                    case 3:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(c32050d.fontSize / 100.0f), i, length, 33);
                        break;
                    default:
                        break;
                }
            }
        }
        AppMethodBeat.m2505o(95737);
    }

    /* renamed from: a */
    private static void m1967a(List<C32050d> list, String str, C0862a c0862a, List<C0863b> list2) {
        AppMethodBeat.m2504i(95738);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a;
            C32050d c32050d = (C32050d) list.get(i);
            String str2 = c0862a.name;
            String[] strArr = c0862a.boI;
            String str3 = c0862a.boH;
            if (!c32050d.boy.isEmpty() || !c32050d.boz.isEmpty() || !c32050d.boA.isEmpty() || !c32050d.boB.isEmpty()) {
                a = C32050d.m52101a(C32050d.m52101a(C32050d.m52101a(0, c32050d.boy, str, ErrorDialogData.SUPPRESSED), c32050d.boz, str2, 2), c32050d.boB, str3, 4);
                if (a == -1 || !Arrays.asList(strArr).containsAll(c32050d.boA)) {
                    a = 0;
                } else {
                    a += c32050d.boA.size() * 4;
                }
            } else if (str2.isEmpty()) {
                a = 1;
            } else {
                a = 0;
            }
            if (a > 0) {
                list2.add(new C0863b(a, c32050d));
            }
        }
        Collections.sort(list2);
        AppMethodBeat.m2505o(95738);
    }
}
