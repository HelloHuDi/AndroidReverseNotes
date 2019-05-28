package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.annotation.SuppressLint;
import android.support.v4.widget.j;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

public final class c implements TagHandler {
    private static final Pattern bnF = Pattern.compile("\\d+");
    private static final Pattern uOM = Pattern.compile("#[a-f0-9]+");
    private static HashMap<String, Integer> uON;
    private Stack<com.tencent.mm.plugin.wenote.model.nativenote.spans.a> uOK = new Stack();
    final HashMap<String, String> uOL = new HashMap();

    static class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static class b {
        int mSize;
        String uOO;
        String uOP;
        String uOQ;

        private b() {
            this.mSize = j.INVALID_ID;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class d extends c {
        d(int i) {
            super(i);
        }
    }

    static abstract class c {
        int uOR;
        boolean uOS = false;

        c(int i) {
            this.uOR = i;
        }
    }

    static class f extends c {
        f(int i) {
            super(i);
        }
    }

    static class e extends c {
        boolean uOT = false;

        e(int i, boolean z) {
            super(i);
            this.uOT = z;
        }
    }

    public c() {
        AppMethodBeat.i(26699);
        AppMethodBeat.o(26699);
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        Object obj;
        int intValue;
        int i;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(26700);
        this.uOL.clear();
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            declaredField = obj2.getClass().getDeclaredField("data");
            declaredField.setAccessible(true);
            String[] strArr = (String[]) declaredField.get(obj2);
            Field declaredField3 = obj2.getClass().getDeclaredField("length");
            declaredField3.setAccessible(true);
            intValue = ((Integer) declaredField3.get(obj2)).intValue();
            for (i = 0; i < intValue; i++) {
                this.uOL.put(strArr[(i * 5) + 1], strArr[(i * 5) + 4]);
            }
        } catch (Exception e) {
        }
        int spanStart;
        int del;
        String str2;
        if (!z) {
            c cVar;
            int length;
            boolean z4;
            boolean z5;
            if (str.equalsIgnoreCase("wx-ul")) {
                oi(false);
            } else if (str.equalsIgnoreCase("wx-ol")) {
                oi(true);
            } else if (str.equalsIgnoreCase("wn-todo")) {
                cVar = (c) a(editable, c.class);
                if (cVar != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart = editable.getSpanStart(cVar);
                    length = editable.length();
                    if (!cVar.uOS) {
                        del = com.tencent.mm.plugin.wenote.model.nativenote.manager.b.del();
                        z4 = ((e) cVar).uOT;
                        if (spanStart == length) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        editable.setSpan(new k(z4, del, z5, false, false), spanStart, length, 33);
                    }
                    editable.removeSpan(cVar);
                }
            } else if (str.equalsIgnoreCase("wx-li")) {
                cVar = (c) a(editable, c.class);
                if (cVar != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart = editable.getSpanStart(cVar);
                    length = editable.length();
                    if (!cVar.uOS) {
                        del = com.tencent.mm.plugin.wenote.model.nativenote.manager.b.del();
                        if (cVar instanceof d) {
                            if (spanStart == length) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            obj = new m(1, del, z5, false, false);
                        } else {
                            if (spanStart != length) {
                                z2 = false;
                            }
                            obj = new com.tencent.mm.plugin.wenote.model.nativenote.spans.d(del, z2, false, false);
                        }
                        editable.setSpan(obj, spanStart, length, 33);
                    }
                    editable.removeSpan(cVar);
                }
            } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
                del = editable.length();
                obj = a(editable, b.class);
                if (obj != null) {
                    intValue = editable.getSpanStart(obj);
                    editable.removeSpan(obj);
                    if (intValue != del) {
                        b bVar = (b) obj;
                        if (TextUtils.isEmpty(bVar.uOQ)) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            editable.setSpan(new TypefaceSpan(bVar.uOQ), intValue, del, 33);
                        }
                        if (bVar.mSize > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            editable.setSpan(new AbsoluteSizeSpan(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Kc(bVar.mSize)), intValue, del, 33);
                        }
                        if (TextUtils.isEmpty(bVar.uOO)) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            i = ahc(bVar.uOO);
                            if (i != -1) {
                                editable.setSpan(new ForegroundColorSpan(i | WebView.NIGHT_MODE_COLOR), intValue, del, 33);
                            }
                        }
                        if (TextUtils.isEmpty(bVar.uOP)) {
                            z2 = false;
                        }
                        if (z2) {
                            int ahc = ahc(bVar.uOP);
                            if (ahc != -1) {
                                editable.setSpan(new BackgroundColorSpan(ahc | WebView.NIGHT_MODE_COLOR), intValue, del, 33);
                            }
                        }
                    }
                }
            } else if (str.equalsIgnoreCase("wx-b")) {
                BoldSpan boldSpan = new BoldSpan();
                del = editable.length();
                obj = a(editable, a.class);
                intValue = editable.getSpanStart(obj);
                editable.removeSpan(obj);
                if (intValue != del) {
                    editable.setSpan(boldSpan, intValue, del, 33);
                }
            } else if (str.equalsIgnoreCase("wx-p")) {
                d(editable);
            } else {
                str.equalsIgnoreCase("wx-div");
            }
            this.uOL.clear();
        } else if (str.equalsIgnoreCase("wx-ul")) {
            a(false, q.NOTEUL);
        } else if (str.equalsIgnoreCase("wx-ol")) {
            a(true, q.NOTEOL);
        } else if (str.equalsIgnoreCase("wn-todo")) {
            this.uOK.push(new com.tencent.mm.plugin.wenote.model.nativenote.spans.a(q.NOTETODO, 1, 1));
            str2 = (String) this.uOL.get("checked");
            if (!bo.isNullOrNil(str2) && str2.equals("1")) {
                z3 = true;
            }
            a(editable, new e(((com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.uOK.peek()).uRQ, z3));
        } else if (str.equalsIgnoreCase("wx-li")) {
            str2 = (String) this.uOL.get("done");
            if (bo.isNullOrNil(str2) || !str2.equals("true")) {
                z2 = false;
            }
            if (this.uOK.isEmpty()) {
                obj = new f(0);
            } else {
                com.tencent.mm.plugin.wenote.model.nativenote.spans.a aVar = (com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.uOK.peek();
                q qVar = aVar.uRP;
                intValue = aVar.uRQ;
                if (qVar.dfH()) {
                    obj = new d(intValue);
                } else if (qVar.dfG()) {
                    obj = new f(intValue);
                } else if (qVar.dfI()) {
                    obj = new e(intValue, z2);
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                a(editable, obj);
            }
        } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
            String str3;
            String str4;
            intValue = j.INVALID_ID;
            str2 = (String) this.uOL.get(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            if (str2 != null) {
                String[] split = str2.toLowerCase(Locale.ENGLISH).split(";");
                spanStart = split.length;
                int i2 = 0;
                str2 = null;
                str3 = null;
                while (i2 < spanStart) {
                    String str5 = split[i2];
                    Matcher matcher;
                    if (str5.startsWith("font-size")) {
                        matcher = bnF.matcher(str5);
                        if (matcher.find(0)) {
                            try {
                                del = Integer.parseInt(str5.substring(matcher.start(), matcher.end()));
                            } catch (NumberFormatException e2) {
                            }
                        }
                        del = intValue;
                    } else if (str5.startsWith("color")) {
                        matcher = uOM.matcher(str5);
                        if (matcher.find(0)) {
                            str3 = str5.substring(matcher.start(), matcher.end());
                        }
                        del = intValue;
                    } else {
                        if (str5.startsWith("background-color")) {
                            matcher = uOM.matcher(str5);
                            if (matcher.find(0)) {
                                str2 = str5.substring(matcher.start(), matcher.end());
                                del = intValue;
                            }
                        }
                        del = intValue;
                    }
                    i2++;
                    intValue = del;
                }
                str4 = str2;
            } else {
                str4 = null;
                str3 = null;
            }
            str2 = (String) this.uOL.get("face");
            del = editable.length();
            b bVar2 = new b();
            bVar2.mSize = intValue;
            bVar2.uOO = str3;
            bVar2.uOP = str4;
            editable.setSpan(bVar2.uOQ = str2, del, del, 17);
        } else if (str.equalsIgnoreCase("wx-b")) {
            a(editable, new a());
        } else if (str.equalsIgnoreCase("wx-p")) {
            d(editable);
        } else if (str.equalsIgnoreCase("wx-div")) {
            d(editable);
        }
        a.uOI = editable;
        AppMethodBeat.o(26700);
    }

    private static void d(Editable editable) {
        AppMethodBeat.i(26701);
        int length = editable.length();
        if (length <= 0 || editable.charAt(length - 1) != 10) {
            if (length != 0) {
                editable.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            AppMethodBeat.o(26701);
            return;
        }
        AppMethodBeat.o(26701);
    }

    private void a(boolean z, q qVar) {
        com.tencent.mm.plugin.wenote.model.nativenote.spans.a aVar;
        AppMethodBeat.i(26702);
        if (z) {
            qVar = q.NOTEOL;
        }
        if (this.uOK.isEmpty()) {
            aVar = null;
        } else {
            aVar = (com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.uOK.peek();
        }
        if (aVar == null) {
            this.uOK.push(new com.tencent.mm.plugin.wenote.model.nativenote.spans.a(qVar, 1, 1));
            AppMethodBeat.o(26702);
        } else if (aVar.uRP == qVar) {
            aVar.uRQ++;
            aVar.uRR++;
            AppMethodBeat.o(26702);
        } else {
            this.uOK.push(new com.tencent.mm.plugin.wenote.model.nativenote.spans.a(qVar, aVar.uRQ + 1, 1));
            AppMethodBeat.o(26702);
        }
    }

    private void oi(boolean z) {
        AppMethodBeat.i(26703);
        while (!this.uOK.isEmpty()) {
            com.tencent.mm.plugin.wenote.model.nativenote.spans.a aVar = (com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.uOK.peek();
            q qVar = aVar.uRP;
            if (!(z && qVar.dfH()) && ((z || !qVar.dfG()) && (z || !qVar.dfI()))) {
                this.uOK.pop();
            } else {
                int i = aVar.uRR;
                if (i > 1) {
                    aVar.uRR = i - 1;
                    aVar.uRQ--;
                    AppMethodBeat.o(26703);
                    return;
                }
                this.uOK.pop();
                AppMethodBeat.o(26703);
                return;
            }
        }
        AppMethodBeat.o(26703);
    }

    private static Object a(Editable editable, Class<? extends Object> cls) {
        AppMethodBeat.i(26704);
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            AppMethodBeat.o(26704);
            return null;
        }
        Object obj = spans[spans.length - 1];
        AppMethodBeat.o(26704);
        return obj;
    }

    private static void a(Editable editable, Object obj) {
        AppMethodBeat.i(26705);
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
        AppMethodBeat.o(26705);
    }

    static {
        AppMethodBeat.i(26707);
        HashMap hashMap = new HashMap();
        uON = hashMap;
        hashMap.put("aqua", Integer.valueOf(CdnLogic.kBizGeneric));
        uON.put("black", Integer.valueOf(0));
        uON.put("blue", Integer.valueOf(255));
        uON.put("fuchsia", Integer.valueOf(16711935));
        uON.put("green", Integer.valueOf(32768));
        uON.put("grey", Integer.valueOf(8421504));
        uON.put("lime", Integer.valueOf(65280));
        uON.put("maroon", Integer.valueOf(8388608));
        uON.put("navy", Integer.valueOf(128));
        uON.put("olive", Integer.valueOf(8421376));
        uON.put("purple", Integer.valueOf(8388736));
        uON.put("red", Integer.valueOf(16711680));
        uON.put("silver", Integer.valueOf(12632256));
        uON.put("teal", Integer.valueOf(32896));
        uON.put("white", Integer.valueOf(16777215));
        uON.put("yellow", Integer.valueOf(16776960));
        AppMethodBeat.o(26707);
    }

    @SuppressLint({"DefaultLocale"})
    private static int ahc(String str) {
        AppMethodBeat.i(26706);
        Integer num = (Integer) uON.get(str.toLowerCase());
        int intValue;
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.o(26706);
            return intValue;
        } else if (str == null) {
            try {
                AppMethodBeat.o(26706);
                return -1;
            } catch (NumberFormatException e) {
                AppMethodBeat.o(26706);
                return -1;
            }
        } else {
            int i;
            int i2;
            int i3;
            String charSequence = str.toString();
            int length = charSequence.length();
            intValue = 10;
            if ('-' == charSequence.charAt(0)) {
                i = 1;
                i2 = -1;
            } else {
                i = 0;
                i2 = 1;
            }
            if ('0' == charSequence.charAt(i)) {
                if (i == length - 1) {
                    AppMethodBeat.o(26706);
                    return 0;
                }
                char charAt = charSequence.charAt(i + 1);
                if ('x' == charAt || 'X' == charAt) {
                    i3 = i + 2;
                    intValue = 16;
                } else {
                    i3 = i + 1;
                    intValue = 8;
                }
            } else if ('#' == charSequence.charAt(i)) {
                i3 = i + 1;
                intValue = 16;
            } else {
                i3 = i;
            }
            intValue = Integer.parseInt(charSequence.substring(i3), intValue) * i2;
            AppMethodBeat.o(26706);
            return intValue;
        }
    }
}
