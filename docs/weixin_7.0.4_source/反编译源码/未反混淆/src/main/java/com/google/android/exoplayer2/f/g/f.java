package com.google.android.exoplayer2.f.g;

import android.support.v4.widget.j;
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
import com.google.android.exoplayer2.i.l;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class f {
    public static final Pattern boE = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern boF = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder bnC = new StringBuilder();

    static final class a {
        private static final String[] boG = new String[0];
        public final String boH;
        public final String[] boI;
        public final String name;
        public final int position;

        private a(String str, int i, String str2, String[] strArr) {
            this.position = i;
            this.name = str;
            this.boH = str2;
            this.boI = strArr;
        }

        public static a k(String str, int i) {
            AppMethodBeat.i(95729);
            String trim = str.trim();
            if (trim.isEmpty()) {
                AppMethodBeat.o(95729);
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
            a aVar = new a(str3, i, str2, split);
            AppMethodBeat.o(95729);
            return aVar;
        }

        public static a te() {
            AppMethodBeat.i(95730);
            a aVar = new a("", 0, "", new String[0]);
            AppMethodBeat.o(95730);
            return aVar;
        }
    }

    static final class b implements Comparable<b> {
        public final d boJ;
        public final int score;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.score - ((b) obj).score;
        }

        public b(int i, d dVar) {
            this.score = i;
            this.boJ = dVar;
        }
    }

    static {
        AppMethodBeat.i(95739);
        AppMethodBeat.o(95739);
    }

    public f() {
        AppMethodBeat.i(95731);
        AppMethodBeat.o(95731);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(l lVar, com.google.android.exoplayer2.f.g.e.a aVar, List<d> list) {
        AppMethodBeat.i(95732);
        String readLine = lVar.readLine();
        if (readLine == null) {
            AppMethodBeat.o(95732);
            return false;
        }
        Matcher matcher = boE.matcher(readLine);
        boolean a;
        if (matcher.matches()) {
            a = a(null, matcher, lVar, aVar, this.bnC, list);
            AppMethodBeat.o(95732);
            return a;
        }
        String readLine2 = lVar.readLine();
        if (readLine2 == null) {
            AppMethodBeat.o(95732);
            return false;
        }
        matcher = boE.matcher(readLine2);
        if (matcher.matches()) {
            a = a(readLine.trim(), matcher, lVar, aVar, this.bnC, list);
            AppMethodBeat.o(95732);
            return a;
        }
        AppMethodBeat.o(95732);
        return false;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(String str, com.google.android.exoplayer2.f.g.e.a aVar) {
        AppMethodBeat.i(95733);
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
                        aVar.bkX = aC(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        aVar.bkX = j.INVALID_ID;
                    }
                    if (group2.endsWith("%")) {
                        aVar.bkW = h.aE(group2);
                        aVar.lineType = 0;
                    } else {
                        parseInt = Integer.parseInt(group2);
                        if (parseInt < 0) {
                            parseInt--;
                        }
                        aVar.bkW = (float) parseInt;
                        aVar.lineType = 1;
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
                    aVar.bkV = alignment;
                } else if ("position".equals(group)) {
                    indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        aVar.bkZ = aC(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        aVar.bkZ = j.INVALID_ID;
                    }
                    aVar.bkY = h.aE(group2);
                } else if ("size".equals(group)) {
                    aVar.width = h.aE(group2);
                } else {
                    new StringBuilder("Unknown cue setting ").append(group).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(group2);
                }
            } catch (NumberFormatException e) {
                new StringBuilder("Skipping bad cue setting: ").append(matcher.group());
            }
        }
        AppMethodBeat.o(95733);
    }

    static void a(String str, String str2, com.google.android.exoplayer2.f.g.e.a aVar, List<d> list) {
        AppMethodBeat.i(95734);
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
                                case d.MIC_ALPHA_ADJUST_REAL /*117*/:
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
                                        stack.push(a.k(substring2, spannableStringBuilder.length()));
                                        i = indexOf;
                                        break;
                                    }
                                }
                                while (!stack.isEmpty()) {
                                    a aVar2 = (a) stack.pop();
                                    a(str, aVar2, spannableStringBuilder, list, arrayList);
                                    if (aVar2.name.equals(substring)) {
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
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.te(), spannableStringBuilder, list, arrayList);
        aVar.boD = spannableStringBuilder;
        AppMethodBeat.o(95734);
    }

    private static boolean a(String str, Matcher matcher, l lVar, com.google.android.exoplayer2.f.g.e.a aVar, StringBuilder stringBuilder, List<d> list) {
        AppMethodBeat.i(95735);
        try {
            aVar.startTime = h.aD(matcher.group(1));
            aVar.endTime = h.aD(matcher.group(2));
            a(matcher.group(3), aVar);
            stringBuilder.setLength(0);
            while (true) {
                String readLine = lVar.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    a(str, stringBuilder.toString(), aVar, (List) list);
                    AppMethodBeat.o(95735);
                    return true;
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuilder.append(readLine.trim());
            }
        } catch (NumberFormatException e) {
            new StringBuilder("Skipping cue with bad header: ").append(matcher.group());
            AppMethodBeat.o(95735);
            return false;
        }
    }

    private static int aC(String str) {
        AppMethodBeat.i(95736);
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
                AppMethodBeat.o(95736);
                return 0;
            case 1:
            case 2:
                AppMethodBeat.o(95736);
                return 1;
            case 3:
                AppMethodBeat.o(95736);
                return 2;
            default:
                AppMethodBeat.o(95736);
                return j.INVALID_ID;
        }
    }

    private static void a(String str, a aVar, SpannableStringBuilder spannableStringBuilder, List<d> list, List<b> list2) {
        AppMethodBeat.i(95737);
        int i = aVar.position;
        int length = spannableStringBuilder.length();
        String str2 = aVar.name;
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
            case d.MIC_ALPHA_ADJUST_REAL /*117*/:
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
                AppMethodBeat.o(95737);
                return;
        }
        list2.clear();
        a((List) list, str, aVar, (List) list2);
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = ((b) list2.get(i2)).boJ;
            if (dVar != null) {
                IllegalStateException illegalStateException;
                if (dVar.getStyle() != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(dVar.getStyle()), i, length, 33);
                }
                if (dVar.bnW == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
                }
                if (dVar.bnX == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (dVar.bnU) {
                    if (dVar.bnU) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.bnT), i, length, 33);
                    } else {
                        illegalStateException = new IllegalStateException("Font color not defined");
                        AppMethodBeat.o(95737);
                        throw illegalStateException;
                    }
                }
                if (dVar.bnV) {
                    if (dVar.bnV) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.backgroundColor), i, length, 33);
                    } else {
                        illegalStateException = new IllegalStateException("Background color not defined.");
                        AppMethodBeat.o(95737);
                        throw illegalStateException;
                    }
                }
                if (dVar.bnS != null) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(dVar.bnS), i, length, 33);
                }
                if (dVar.boc != null) {
                    spannableStringBuilder.setSpan(new Standard(dVar.boc), i, length, 33);
                }
                switch (dVar.boa) {
                    case 1:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.fontSize, true), i, length, 33);
                        break;
                    case 2:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize), i, length, 33);
                        break;
                    case 3:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize / 100.0f), i, length, 33);
                        break;
                    default:
                        break;
                }
            }
        }
        AppMethodBeat.o(95737);
    }

    private static void a(List<d> list, String str, a aVar, List<b> list2) {
        AppMethodBeat.i(95738);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a;
            d dVar = (d) list.get(i);
            String str2 = aVar.name;
            String[] strArr = aVar.boI;
            String str3 = aVar.boH;
            if (!dVar.boy.isEmpty() || !dVar.boz.isEmpty() || !dVar.boA.isEmpty() || !dVar.boB.isEmpty()) {
                a = d.a(d.a(d.a(0, dVar.boy, str, ErrorDialogData.SUPPRESSED), dVar.boz, str2, 2), dVar.boB, str3, 4);
                if (a == -1 || !Arrays.asList(strArr).containsAll(dVar.boA)) {
                    a = 0;
                } else {
                    a += dVar.boA.size() * 4;
                }
            } else if (str2.isEmpty()) {
                a = 1;
            } else {
                a = 0;
            }
            if (a > 0) {
                list2.add(new b(a, dVar));
            }
        }
        Collections.sort(list2);
        AppMethodBeat.o(95738);
    }
}
