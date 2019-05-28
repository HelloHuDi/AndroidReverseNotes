package com.tencent.p177mm.plugin.appbrand.dynamic.html;

import android.text.Editable;
import android.text.Html.TagHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xml.sax.XMLReader;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.html.b */
public final class C33162b implements TagHandler {
    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        AppMethodBeat.m2504i(10814);
        if ("a".equalsIgnoreCase(str)) {
            int length;
            if (z) {
                length = editable.length();
                editable.setSpan(new CustomURLSpan(""), length, length, 17);
                AppMethodBeat.m2505o(10814);
                return;
            }
            Object obj;
            int length2 = editable.length();
            Object[] spans = editable.getSpans(0, editable.length(), CustomURLSpan.class);
            if (spans.length != 0) {
                for (length = spans.length; length > 0; length--) {
                    if (editable.getSpanFlags(spans[length - 1]) == 17) {
                        obj = spans[length - 1];
                        break;
                    }
                }
            }
            obj = null;
            CustomURLSpan customURLSpan = (CustomURLSpan) obj;
            int spanStart = editable.getSpanStart(customURLSpan);
            String charSequence = editable.subSequence(spanStart, length2).toString();
            editable.removeSpan(customURLSpan);
            if (spanStart != length2) {
                editable.setSpan(new CustomURLSpan(charSequence), spanStart, length2, 33);
            }
        }
        AppMethodBeat.m2505o(10814);
    }
}
