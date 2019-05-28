package com.tencent.mm.plugin.wenote.model.nativenote.a;

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
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.r;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public final class b {
    public static String a(Spanned spanned) {
        AppMethodBeat.i(26690);
        String str;
        if (spanned == null || bo.isNullOrNil(spanned.toString())) {
            str = "";
            AppMethodBeat.o(26690);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        a(spanned, stringBuilder);
        str = stringBuilder.toString();
        AppMethodBeat.o(26690);
        return str;
    }

    private static void a(final Spanned spanned, StringBuilder stringBuilder) {
        AppMethodBeat.i(26691);
        ArrayList arrayList = new j(spanned).uQu;
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            r rVar;
            q qVar;
            int indexOf;
            e eVar = (n) arrayList.get(i);
            Set<r> a = a(spanned, eVar);
            q qVar2 = null;
            for (r rVar2 : a) {
                if (rVar2.uRP.uSp) {
                    qVar2 = rVar2.uRP;
                    break;
                }
            }
            int i2 = 0;
            q qVar3 = q.NONE;
            Iterator it = a.iterator();
            while (true) {
                qVar = qVar3;
                if (!it.hasNext()) {
                    break;
                }
                int i3;
                boolean z;
                rVar2 = (r) it.next();
                if (rVar2.uRP.dfG() || rVar2.uRP.dfH() || rVar2.uRP.dfI()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i2 += i3;
                q qVar4 = rVar2.uRP;
                if (rVar2.uRP.dfG()) {
                    z = ((d) rVar2.uSv).uRV;
                } else if (rVar2.uRP.dfH()) {
                    z = ((m) rVar2.uSv).uRV;
                } else if (rVar2.uRP.dfI()) {
                    z = ((k) rVar2.uSv).uRV;
                } else {
                    z = true;
                }
                qVar3 = z ? q.NONE : qVar4.dfG() ? q.NOTEUL : qVar4.dfH() ? q.NOTEOL : qVar4.dfI() ? q.NOTETODO : qVar;
            }
            a(stack, stringBuilder, new a(qVar, i2, 0));
            if (qVar.dfI()) {
                k[] kVarArr = (k[]) spanned.getSpans(eVar.aqm, eVar.Ls, k.class);
                if (kVarArr.length > 0) {
                    qVar.uSt = kVarArr[0].uSb;
                    indexOf = qVar.uSq.indexOf("\"") + 1;
                    i2 = qVar.uSq.lastIndexOf("\"");
                    if (indexOf < i2) {
                        String substring = qVar.uSq.substring(indexOf, i2);
                        if (!bo.isNullOrNil(substring)) {
                            if (!substring.trim().equals(qVar.uSt ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                String str;
                                String str2 = qVar.uSq;
                                if (qVar.uSt) {
                                    str = "1";
                                } else {
                                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                                qVar.uSq = str2.replaceAll(substring, str);
                            }
                        }
                    }
                }
            }
            stringBuilder.append(qVar.uSq);
            if (qVar2 != null) {
                stringBuilder.append(qVar2.uSn);
            }
            indexOf = eVar.aqm;
            int i4 = eVar.Ls;
            TreeSet treeSet = new TreeSet(new Comparator<CharacterStyle>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(26689);
                    CharacterStyle characterStyle = (CharacterStyle) obj;
                    CharacterStyle characterStyle2 = (CharacterStyle) obj2;
                    int spanStart = spanned.getSpanStart(characterStyle);
                    int spanStart2 = spanned.getSpanStart(characterStyle2);
                    if (spanStart != spanStart2) {
                        spanStart -= spanStart2;
                        AppMethodBeat.o(26689);
                        return spanStart;
                    }
                    spanStart = spanned.getSpanEnd(characterStyle);
                    spanStart2 = spanned.getSpanEnd(characterStyle2);
                    if (spanStart != spanStart2) {
                        spanStart = spanStart2 - spanStart;
                        AppMethodBeat.o(26689);
                        return spanStart;
                    }
                    spanStart = characterStyle.getClass().getName().compareTo(characterStyle2.getClass().getName());
                    AppMethodBeat.o(26689);
                    return spanStart;
                }
            });
            treeSet.addAll(Arrays.asList(spanned.getSpans(indexOf, i4, CharacterStyle.class)));
            a(spanned, stringBuilder, indexOf, i4, treeSet);
            if (qVar2 != null) {
                a(stringBuilder, qVar2);
                stringBuilder.append(qVar2.uSo);
            }
            a(stringBuilder, qVar);
            stringBuilder.append(qVar.uSr);
        }
        while (!stack.isEmpty()) {
            a(stack, stringBuilder);
        }
        AppMethodBeat.o(26691);
    }

    private static void a(Spanned spanned, StringBuilder stringBuilder, int i, int i2, SortedSet<CharacterStyle> sortedSet) {
        AppMethodBeat.i(26692);
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
                a(spanned, stringBuilder, i, Math.min(i2, spanStart));
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
                    stringBuilder.append((float) com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Kd((int) (((RelativeSizeSpan) obj2).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
                    stringBuilder.append("px\">");
                } else if (obj2 instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("<wx-font style=\"font-size:");
                    stringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Kd(((AbsoluteSizeSpan) obj2).getSize()));
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
                a(spanned, stringBuilder, Math.max(spanStart, i), Math.min(spanEnd, i2), sortedSet);
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
        AppMethodBeat.o(26692);
    }

    public static void a(CharSequence charSequence, StringBuilder stringBuilder, int i, int i2) {
        AppMethodBeat.i(26693);
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
        AppMethodBeat.o(26693);
    }

    private static Set<r> a(Spanned spanned, e eVar) {
        AppMethodBeat.i(26695);
        HashSet hashSet = new HashSet();
        for (ParagraphStyle paragraphStyle : (ParagraphStyle[]) spanned.getSpans(eVar.aqm, eVar.Ls, ParagraphStyle.class)) {
            q a = q.a(paragraphStyle);
            if (a != null) {
                hashSet.add(new r(a, paragraphStyle));
            }
        }
        AppMethodBeat.o(26695);
        return hashSet;
    }

    private static void a(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        AppMethodBeat.i(26696);
        while (true) {
            int i = 0;
            q qVar = q.NONE;
            if (!stack.isEmpty()) {
                a aVar2 = (a) stack.peek();
                i = aVar2.uRQ;
                qVar = aVar2.uRP;
            }
            if (aVar.uRQ > i) {
                aVar.uRR = aVar.uRQ - i;
                b(stack, stringBuilder, aVar);
                AppMethodBeat.o(26696);
                return;
            } else if (aVar.uRQ < i) {
                a((Stack) stack, stringBuilder);
            } else {
                if (aVar.uRP != qVar) {
                    aVar.uRR = a((Stack) stack, stringBuilder);
                    b(stack, stringBuilder, aVar);
                }
                AppMethodBeat.o(26696);
                return;
            }
        }
    }

    private static int a(Stack<a> stack, StringBuilder stringBuilder) {
        int i = 0;
        AppMethodBeat.i(26697);
        if (stack.isEmpty()) {
            AppMethodBeat.o(26697);
            return 0;
        }
        a aVar = (a) stack.pop();
        String str = aVar.uRP.uSo;
        int i2 = aVar.uRR;
        while (i < i2) {
            stringBuilder.append(str);
            i++;
        }
        int i3 = aVar.uRR;
        AppMethodBeat.o(26697);
        return i3;
    }

    private static void a(StringBuilder stringBuilder, q qVar) {
        AppMethodBeat.i(26694);
        if (qVar.uSs && stringBuilder.length() >= 5) {
            int length = stringBuilder.length() - 5;
            int length2 = stringBuilder.length();
            if (stringBuilder.subSequence(length, length2).equals("<br/>")) {
                stringBuilder.delete(length, length2);
            }
        }
        AppMethodBeat.o(26694);
    }

    private static void b(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        AppMethodBeat.i(26698);
        String str = aVar.uRP.uSn;
        int i = aVar.uRR;
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        stack.push(aVar);
        AppMethodBeat.o(26698);
    }
}
