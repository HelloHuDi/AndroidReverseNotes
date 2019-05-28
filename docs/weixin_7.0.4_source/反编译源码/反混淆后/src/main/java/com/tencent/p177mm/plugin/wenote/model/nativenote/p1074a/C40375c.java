package com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a;

import android.annotation.SuppressLint;
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C35746b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C17002d;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C17003m;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C40385a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C40387k;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C44012q;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.c */
public final class C40375c implements TagHandler {
    private static final Pattern bnF = Pattern.compile("\\d+");
    private static final Pattern uOM = Pattern.compile("#[a-f0-9]+");
    private static HashMap<String, Integer> uON;
    private Stack<C40385a> uOK = new Stack();
    final HashMap<String, String> uOL = new HashMap();

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.c$a */
    static class C14726a {
        private C14726a() {
        }

        /* synthetic */ C14726a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.c$b */
    static class C14727b {
        int mSize;
        String uOO;
        String uOP;
        String uOQ;

        private C14727b() {
            this.mSize = C8415j.INVALID_ID;
        }

        /* synthetic */ C14727b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.c$d */
    static class C14728d extends C29983c {
        C14728d(int i) {
            super(i);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.c$c */
    static abstract class C29983c {
        int uOR;
        boolean uOS = false;

        C29983c(int i) {
            this.uOR = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.c$f */
    static class C40374f extends C29983c {
        C40374f(int i) {
            super(i);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.c$e */
    static class C40376e extends C29983c {
        boolean uOT = false;

        C40376e(int i, boolean z) {
            super(i);
            this.uOT = z;
        }
    }

    public C40375c() {
        AppMethodBeat.m2504i(26699);
        AppMethodBeat.m2505o(26699);
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        Object obj;
        int intValue;
        int i;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.m2504i(26700);
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
            C29983c c29983c;
            int length;
            boolean z4;
            boolean z5;
            if (str.equalsIgnoreCase("wx-ul")) {
                m69238oi(false);
            } else if (str.equalsIgnoreCase("wx-ol")) {
                m69238oi(true);
            } else if (str.equalsIgnoreCase("wn-todo")) {
                c29983c = (C29983c) C40375c.m69234a(editable, C29983c.class);
                if (c29983c != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart = editable.getSpanStart(c29983c);
                    length = editable.length();
                    if (!c29983c.uOS) {
                        del = C35746b.del();
                        z4 = ((C40376e) c29983c).uOT;
                        if (spanStart == length) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        editable.setSpan(new C40387k(z4, del, z5, false, false), spanStart, length, 33);
                    }
                    editable.removeSpan(c29983c);
                }
            } else if (str.equalsIgnoreCase("wx-li")) {
                c29983c = (C29983c) C40375c.m69234a(editable, C29983c.class);
                if (c29983c != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart = editable.getSpanStart(c29983c);
                    length = editable.length();
                    if (!c29983c.uOS) {
                        del = C35746b.del();
                        if (c29983c instanceof C14728d) {
                            if (spanStart == length) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            obj = new C17003m(1, del, z5, false, false);
                        } else {
                            if (spanStart != length) {
                                z2 = false;
                            }
                            obj = new C17002d(del, z2, false, false);
                        }
                        editable.setSpan(obj, spanStart, length, 33);
                    }
                    editable.removeSpan(c29983c);
                }
            } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
                del = editable.length();
                obj = C40375c.m69234a(editable, C14727b.class);
                if (obj != null) {
                    intValue = editable.getSpanStart(obj);
                    editable.removeSpan(obj);
                    if (intValue != del) {
                        C14727b c14727b = (C14727b) obj;
                        if (TextUtils.isEmpty(c14727b.uOQ)) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            editable.setSpan(new TypefaceSpan(c14727b.uOQ), intValue, del, 33);
                        }
                        if (c14727b.mSize > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            editable.setSpan(new AbsoluteSizeSpan(C35746b.m58600Kc(c14727b.mSize)), intValue, del, 33);
                        }
                        if (TextUtils.isEmpty(c14727b.uOO)) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            i = C40375c.ahc(c14727b.uOO);
                            if (i != -1) {
                                editable.setSpan(new ForegroundColorSpan(i | WebView.NIGHT_MODE_COLOR), intValue, del, 33);
                            }
                        }
                        if (TextUtils.isEmpty(c14727b.uOP)) {
                            z2 = false;
                        }
                        if (z2) {
                            int ahc = C40375c.ahc(c14727b.uOP);
                            if (ahc != -1) {
                                editable.setSpan(new BackgroundColorSpan(ahc | WebView.NIGHT_MODE_COLOR), intValue, del, 33);
                            }
                        }
                    }
                }
            } else if (str.equalsIgnoreCase("wx-b")) {
                BoldSpan boldSpan = new BoldSpan();
                del = editable.length();
                obj = C40375c.m69234a(editable, C14726a.class);
                intValue = editable.getSpanStart(obj);
                editable.removeSpan(obj);
                if (intValue != del) {
                    editable.setSpan(boldSpan, intValue, del, 33);
                }
            } else if (str.equalsIgnoreCase("wx-p")) {
                C40375c.m69237d(editable);
            } else {
                str.equalsIgnoreCase("wx-div");
            }
            this.uOL.clear();
        } else if (str.equalsIgnoreCase("wx-ul")) {
            m69236a(false, C44012q.NOTEUL);
        } else if (str.equalsIgnoreCase("wx-ol")) {
            m69236a(true, C44012q.NOTEOL);
        } else if (str.equalsIgnoreCase("wn-todo")) {
            this.uOK.push(new C40385a(C44012q.NOTETODO, 1, 1));
            str2 = (String) this.uOL.get("checked");
            if (!C5046bo.isNullOrNil(str2) && str2.equals("1")) {
                z3 = true;
            }
            C40375c.m69235a(editable, new C40376e(((C40385a) this.uOK.peek()).uRQ, z3));
        } else if (str.equalsIgnoreCase("wx-li")) {
            str2 = (String) this.uOL.get("done");
            if (C5046bo.isNullOrNil(str2) || !str2.equals("true")) {
                z2 = false;
            }
            if (this.uOK.isEmpty()) {
                obj = new C40374f(0);
            } else {
                C40385a c40385a = (C40385a) this.uOK.peek();
                C44012q c44012q = c40385a.uRP;
                intValue = c40385a.uRQ;
                if (c44012q.dfH()) {
                    obj = new C14728d(intValue);
                } else if (c44012q.dfG()) {
                    obj = new C40374f(intValue);
                } else if (c44012q.dfI()) {
                    obj = new C40376e(intValue, z2);
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                C40375c.m69235a(editable, obj);
            }
        } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
            String str3;
            String str4;
            intValue = C8415j.INVALID_ID;
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
            C14727b c14727b2 = new C14727b();
            c14727b2.mSize = intValue;
            c14727b2.uOO = str3;
            c14727b2.uOP = str4;
            editable.setSpan(c14727b2.uOQ = str2, del, del, 17);
        } else if (str.equalsIgnoreCase("wx-b")) {
            C40375c.m69235a(editable, new C14726a());
        } else if (str.equalsIgnoreCase("wx-p")) {
            C40375c.m69237d(editable);
        } else if (str.equalsIgnoreCase("wx-div")) {
            C40375c.m69237d(editable);
        }
        C14724a.uOI = editable;
        AppMethodBeat.m2505o(26700);
    }

    /* renamed from: d */
    private static void m69237d(Editable editable) {
        AppMethodBeat.m2504i(26701);
        int length = editable.length();
        if (length <= 0 || editable.charAt(length - 1) != 10) {
            if (length != 0) {
                editable.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            AppMethodBeat.m2505o(26701);
            return;
        }
        AppMethodBeat.m2505o(26701);
    }

    /* renamed from: a */
    private void m69236a(boolean z, C44012q c44012q) {
        C40385a c40385a;
        AppMethodBeat.m2504i(26702);
        if (z) {
            c44012q = C44012q.NOTEOL;
        }
        if (this.uOK.isEmpty()) {
            c40385a = null;
        } else {
            c40385a = (C40385a) this.uOK.peek();
        }
        if (c40385a == null) {
            this.uOK.push(new C40385a(c44012q, 1, 1));
            AppMethodBeat.m2505o(26702);
        } else if (c40385a.uRP == c44012q) {
            c40385a.uRQ++;
            c40385a.uRR++;
            AppMethodBeat.m2505o(26702);
        } else {
            this.uOK.push(new C40385a(c44012q, c40385a.uRQ + 1, 1));
            AppMethodBeat.m2505o(26702);
        }
    }

    /* renamed from: oi */
    private void m69238oi(boolean z) {
        AppMethodBeat.m2504i(26703);
        while (!this.uOK.isEmpty()) {
            C40385a c40385a = (C40385a) this.uOK.peek();
            C44012q c44012q = c40385a.uRP;
            if (!(z && c44012q.dfH()) && ((z || !c44012q.dfG()) && (z || !c44012q.dfI()))) {
                this.uOK.pop();
            } else {
                int i = c40385a.uRR;
                if (i > 1) {
                    c40385a.uRR = i - 1;
                    c40385a.uRQ--;
                    AppMethodBeat.m2505o(26703);
                    return;
                }
                this.uOK.pop();
                AppMethodBeat.m2505o(26703);
                return;
            }
        }
        AppMethodBeat.m2505o(26703);
    }

    /* renamed from: a */
    private static Object m69234a(Editable editable, Class<? extends Object> cls) {
        AppMethodBeat.m2504i(26704);
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            AppMethodBeat.m2505o(26704);
            return null;
        }
        Object obj = spans[spans.length - 1];
        AppMethodBeat.m2505o(26704);
        return obj;
    }

    /* renamed from: a */
    private static void m69235a(Editable editable, Object obj) {
        AppMethodBeat.m2504i(26705);
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
        AppMethodBeat.m2505o(26705);
    }

    static {
        AppMethodBeat.m2504i(26707);
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
        AppMethodBeat.m2505o(26707);
    }

    @SuppressLint({"DefaultLocale"})
    private static int ahc(String str) {
        AppMethodBeat.m2504i(26706);
        Integer num = (Integer) uON.get(str.toLowerCase());
        int intValue;
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.m2505o(26706);
            return intValue;
        } else if (str == null) {
            try {
                AppMethodBeat.m2505o(26706);
                return -1;
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(26706);
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
                    AppMethodBeat.m2505o(26706);
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
            AppMethodBeat.m2505o(26706);
            return intValue;
        }
    }
}
