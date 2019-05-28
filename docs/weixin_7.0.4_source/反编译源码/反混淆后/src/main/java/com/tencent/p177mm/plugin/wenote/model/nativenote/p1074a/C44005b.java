package com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C35746b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40383j;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C17002d;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C17003m;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29992n;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C40385a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C40387k;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C44012q;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C44013r;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.a.b */
public final class C44005b {
    /* renamed from: a */
    public static String m78993a(Spanned spanned) {
        AppMethodBeat.m2504i(26690);
        String str;
        if (spanned == null || C5046bo.isNullOrNil(spanned.toString())) {
            str = "";
            AppMethodBeat.m2505o(26690);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C44005b.m78995a(spanned, stringBuilder);
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(26690);
        return str;
    }

    /* renamed from: a */
    private static void m78995a(final Spanned spanned, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(26691);
        ArrayList arrayList = new C40383j(spanned).uQu;
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C44013r c44013r;
            C44012q c44012q;
            int indexOf;
            C23184e c23184e = (C29992n) arrayList.get(i);
            Set<C44013r> a = C44005b.m78994a(spanned, c23184e);
            C44012q c44012q2 = null;
            for (C44013r c44013r2 : a) {
                if (c44013r2.uRP.uSp) {
                    c44012q2 = c44013r2.uRP;
                    break;
                }
            }
            int i2 = 0;
            C44012q c44012q3 = C44012q.NONE;
            Iterator it = a.iterator();
            while (true) {
                c44012q = c44012q3;
                if (!it.hasNext()) {
                    break;
                }
                int i3;
                boolean z;
                c44013r2 = (C44013r) it.next();
                if (c44013r2.uRP.dfG() || c44013r2.uRP.dfH() || c44013r2.uRP.dfI()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i2 += i3;
                C44012q c44012q4 = c44013r2.uRP;
                if (c44013r2.uRP.dfG()) {
                    z = ((C17002d) c44013r2.uSv).uRV;
                } else if (c44013r2.uRP.dfH()) {
                    z = ((C17003m) c44013r2.uSv).uRV;
                } else if (c44013r2.uRP.dfI()) {
                    z = ((C40387k) c44013r2.uSv).uRV;
                } else {
                    z = true;
                }
                c44012q3 = z ? C44012q.NONE : c44012q4.dfG() ? C44012q.NOTEUL : c44012q4.dfH() ? C44012q.NOTEOL : c44012q4.dfI() ? C44012q.NOTETODO : c44012q;
            }
            C44005b.m78999a(stack, stringBuilder, new C40385a(c44012q, i2, 0));
            if (c44012q.dfI()) {
                C40387k[] c40387kArr = (C40387k[]) spanned.getSpans(c23184e.aqm, c23184e.f4406Ls, C40387k.class);
                if (c40387kArr.length > 0) {
                    c44012q.uSt = c40387kArr[0].uSb;
                    indexOf = c44012q.uSq.indexOf("\"") + 1;
                    i2 = c44012q.uSq.lastIndexOf("\"");
                    if (indexOf < i2) {
                        String substring = c44012q.uSq.substring(indexOf, i2);
                        if (!C5046bo.isNullOrNil(substring)) {
                            if (!substring.trim().equals(c44012q.uSt ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                String str;
                                String str2 = c44012q.uSq;
                                if (c44012q.uSt) {
                                    str = "1";
                                } else {
                                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                                c44012q.uSq = str2.replaceAll(substring, str);
                            }
                        }
                    }
                }
            }
            stringBuilder.append(c44012q.uSq);
            if (c44012q2 != null) {
                stringBuilder.append(c44012q2.uSn);
            }
            indexOf = c23184e.aqm;
            int i4 = c23184e.f4406Ls;
            TreeSet treeSet = new TreeSet(new Comparator<CharacterStyle>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.m2504i(26689);
                    CharacterStyle characterStyle = (CharacterStyle) obj;
                    CharacterStyle characterStyle2 = (CharacterStyle) obj2;
                    int spanStart = spanned.getSpanStart(characterStyle);
                    int spanStart2 = spanned.getSpanStart(characterStyle2);
                    if (spanStart != spanStart2) {
                        spanStart -= spanStart2;
                        AppMethodBeat.m2505o(26689);
                        return spanStart;
                    }
                    spanStart = spanned.getSpanEnd(characterStyle);
                    spanStart2 = spanned.getSpanEnd(characterStyle2);
                    if (spanStart != spanStart2) {
                        spanStart = spanStart2 - spanStart;
                        AppMethodBeat.m2505o(26689);
                        return spanStart;
                    }
                    spanStart = characterStyle.getClass().getName().compareTo(characterStyle2.getClass().getName());
                    AppMethodBeat.m2505o(26689);
                    return spanStart;
                }
            });
            treeSet.addAll(Arrays.asList(spanned.getSpans(indexOf, i4, CharacterStyle.class)));
            C44005b.m78996a(spanned, stringBuilder, indexOf, i4, treeSet);
            if (c44012q2 != null) {
                C44005b.m78998a(stringBuilder, c44012q2);
                stringBuilder.append(c44012q2.uSo);
            }
            C44005b.m78998a(stringBuilder, c44012q);
            stringBuilder.append(c44012q.uSr);
        }
        while (!stack.isEmpty()) {
            C44005b.m78992a(stack, stringBuilder);
        }
        AppMethodBeat.m2505o(26691);
    }

    /* renamed from: a */
    private static void m78996a(Spanned spanned, StringBuilder stringBuilder, int i, int i2, SortedSet<CharacterStyle> sortedSet) {
        AppMethodBeat.m2504i(26692);
        while (i < i2) {
            Object obj;
            if (sortedSet.isEmpty()) {
                obj = null;
            } else {
                CharacterStyle obj2 = (CharacterStyle) sortedSet.first();
            }
            int spanStart = obj2 == null ? BaseClientBuilder.API_PRIORITY_OTHER : spanned.getSpanStart(obj2);
            int spanEnd = obj2 == null ? BaseClientBuilder.API_PRIORITY_OTHER : spanned.getSpanEnd(obj2);
            if (i < spanStart) {
                C44005b.m78997a(spanned, stringBuilder, i, Math.min(i2, spanStart));
                i = spanStart;
            } else {
                sortedSet.remove(obj2);
                String toHexString;
                if (obj2 instanceof BoldSpan) {
                    stringBuilder.append("<wx-b>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 1) {
                    stringBuilder.append("<wx-b>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 2) {
                    stringBuilder.append("<i>");
                } else if (obj2 instanceof UnderlineSpan) {
                    stringBuilder.append("<u>");
                } else if (obj2 instanceof RelativeSizeSpan) {
                    stringBuilder.append("<wx-font style=\"font-size:");
                    stringBuilder.append((float) C35746b.m58601Kd((int) (((RelativeSizeSpan) obj2).getSizeChange() * C35746b.getTextSize())));
                    stringBuilder.append("px\">");
                } else if (obj2 instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("<wx-font style=\"font-size:");
                    stringBuilder.append(C35746b.m58601Kd(((AbsoluteSizeSpan) obj2).getSize()));
                    stringBuilder.append("px\">");
                } else if (obj2 instanceof ForegroundColorSpan) {
                    stringBuilder.append("<wx-font style=\"color:#");
                    toHexString = Integer.toHexString(((ForegroundColorSpan) obj2).getForegroundColor() + 16777216);
                    while (toHexString.length() < 6) {
                        toHexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(toHexString));
                    }
                    stringBuilder.append(toHexString);
                    stringBuilder.append("\">");
                } else if (obj2 instanceof BackgroundColorSpan) {
                    stringBuilder.append("<wx-font style=\"background-color:#");
                    toHexString = Integer.toHexString(((BackgroundColorSpan) obj2).getBackgroundColor() + 16777216);
                    while (toHexString.length() < 6) {
                        toHexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(toHexString));
                    }
                    stringBuilder.append(toHexString);
                    stringBuilder.append("\">");
                }
                C44005b.m78996a(spanned, stringBuilder, Math.max(spanStart, i), Math.min(spanEnd, i2), sortedSet);
                if (obj2 instanceof ForegroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (obj2 instanceof BackgroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (obj2 instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (obj2 instanceof UnderlineSpan) {
                    stringBuilder.append("</u>");
                } else if (obj2 instanceof BoldSpan) {
                    stringBuilder.append("</wx-b>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 2) {
                    stringBuilder.append("</i>");
                } else if ((obj2 instanceof StyleSpan) && ((StyleSpan) obj2).getStyle() == 1) {
                    stringBuilder.append("</wx-b>");
                } else if (obj2 instanceof RelativeSizeSpan) {
                    stringBuilder.append("</wx-font>");
                }
                i = spanEnd;
            }
        }
        AppMethodBeat.m2505o(26692);
    }

    /* renamed from: a */
    public static void m78997a(CharSequence charSequence, StringBuilder stringBuilder, int i, int i2) {
        AppMethodBeat.m2504i(26693);
        int i3 = i;
        while (i3 < i2) {
            char charAt = charSequence.charAt(i3);
            if (charAt == 10) {
                stringBuilder.append("<br/>");
            } else if (charAt == '<') {
                stringBuilder.append("&lt;");
            } else if (charAt == '>') {
                stringBuilder.append("&gt;");
            } else if (charAt == '&') {
                stringBuilder.append("&amp;");
            } else if (charAt == ' ') {
                while (i3 + 1 < i2 && charSequence.charAt(i3 + 1) == ' ') {
                    stringBuilder.append("&nbsp;");
                    i3++;
                }
                stringBuilder.append(' ');
            } else if (charAt < ' ') {
                stringBuilder.append("&#" + charAt + ";");
            } else {
                stringBuilder.append(charAt);
            }
            i3++;
        }
        AppMethodBeat.m2505o(26693);
    }

    /* renamed from: a */
    private static Set<C44013r> m78994a(Spanned spanned, C23184e c23184e) {
        AppMethodBeat.m2504i(26695);
        HashSet hashSet = new HashSet();
        for (ParagraphStyle paragraphStyle : (ParagraphStyle[]) spanned.getSpans(c23184e.aqm, c23184e.f4406Ls, ParagraphStyle.class)) {
            C44012q a = C44012q.m79005a(paragraphStyle);
            if (a != null) {
                hashSet.add(new C44013r(a, paragraphStyle));
            }
        }
        AppMethodBeat.m2505o(26695);
        return hashSet;
    }

    /* renamed from: a */
    private static void m78999a(Stack<C40385a> stack, StringBuilder stringBuilder, C40385a c40385a) {
        AppMethodBeat.m2504i(26696);
        while (true) {
            int i = 0;
            C44012q c44012q = C44012q.NONE;
            if (!stack.isEmpty()) {
                C40385a c40385a2 = (C40385a) stack.peek();
                i = c40385a2.uRQ;
                c44012q = c40385a2.uRP;
            }
            if (c40385a.uRQ > i) {
                c40385a.uRR = c40385a.uRQ - i;
                C44005b.m79000b(stack, stringBuilder, c40385a);
                AppMethodBeat.m2505o(26696);
                return;
            } else if (c40385a.uRQ < i) {
                C44005b.m78992a((Stack) stack, stringBuilder);
            } else {
                if (c40385a.uRP != c44012q) {
                    c40385a.uRR = C44005b.m78992a((Stack) stack, stringBuilder);
                    C44005b.m79000b(stack, stringBuilder, c40385a);
                }
                AppMethodBeat.m2505o(26696);
                return;
            }
        }
    }

    /* renamed from: a */
    private static int m78992a(Stack<C40385a> stack, StringBuilder stringBuilder) {
        int i = 0;
        AppMethodBeat.m2504i(26697);
        if (stack.isEmpty()) {
            AppMethodBeat.m2505o(26697);
            return 0;
        }
        C40385a c40385a = (C40385a) stack.pop();
        String str = c40385a.uRP.uSo;
        int i2 = c40385a.uRR;
        while (i < i2) {
            stringBuilder.append(str);
            i++;
        }
        int i3 = c40385a.uRR;
        AppMethodBeat.m2505o(26697);
        return i3;
    }

    /* renamed from: a */
    private static void m78998a(StringBuilder stringBuilder, C44012q c44012q) {
        AppMethodBeat.m2504i(26694);
        if (c44012q.uSs && stringBuilder.length() >= 5) {
            int length = stringBuilder.length() - 5;
            int length2 = stringBuilder.length();
            if (stringBuilder.subSequence(length, length2).equals("<br/>")) {
                stringBuilder.delete(length, length2);
            }
        }
        AppMethodBeat.m2505o(26694);
    }

    /* renamed from: b */
    private static void m79000b(Stack<C40385a> stack, StringBuilder stringBuilder, C40385a c40385a) {
        AppMethodBeat.m2504i(26698);
        String str = c40385a.uRP.uSn;
        int i = c40385a.uRR;
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        stack.push(c40385a);
        AppMethodBeat.m2505o(26698);
    }
}
