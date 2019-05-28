package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import java.net.URL;
import org.xml.sax.XMLReader;

/* renamed from: com.tencent.mm.plugin.product.ui.HtmlTextView */
public class HtmlTextView extends TextView {
    ImageGetter pib = new C128182();
    TagHandler pic = new C35973();

    /* renamed from: com.tencent.mm.plugin.product.ui.HtmlTextView$3 */
    class C35973 implements TagHandler {
        C35973() {
        }

        public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            AppMethodBeat.m2504i(44013);
            if (str.equalsIgnoreCase("strike") || str.equals("s")) {
                int length = editable.length();
                if (z) {
                    editable.setSpan(new StrikethroughSpan(), length, length, 17);
                    AppMethodBeat.m2505o(44013);
                    return;
                }
                Object a = C35973.m5944a(editable, StrikethroughSpan.class);
                int spanStart = editable.getSpanStart(a);
                editable.removeSpan(a);
                if (spanStart != length) {
                    editable.setSpan(new StrikethroughSpan(), spanStart, length, 33);
                }
            }
            AppMethodBeat.m2505o(44013);
        }

        /* renamed from: a */
        private static Object m5944a(Editable editable, Class cls) {
            AppMethodBeat.m2504i(44014);
            Object[] spans = editable.getSpans(0, editable.length(), cls);
            if (spans.length == 0) {
                AppMethodBeat.m2505o(44014);
                return null;
            }
            for (int length = spans.length; length > 0; length--) {
                if (editable.getSpanFlags(spans[length - 1]) == 17) {
                    Object obj = spans[length - 1];
                    AppMethodBeat.m2505o(44014);
                    return obj;
                }
            }
            AppMethodBeat.m2505o(44014);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.HtmlTextView$2 */
    class C128182 implements ImageGetter {
        C128182() {
        }

        public final Drawable getDrawable(String str) {
            AppMethodBeat.m2504i(44012);
            try {
                Drawable createFromStream = Drawable.createFromStream(new URL(str).openStream(), "");
                if (createFromStream != null) {
                    createFromStream.setBounds(0, 0, createFromStream.getIntrinsicWidth(), createFromStream.getIntrinsicHeight());
                }
                AppMethodBeat.m2505o(44012);
                return createFromStream;
            } catch (Exception e) {
                AppMethodBeat.m2505o(44012);
                return null;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m86096a(HtmlTextView htmlTextView, CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.m2504i(44019);
        super.setText(charSequence, bufferType);
        AppMethodBeat.m2505o(44019);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(44015);
        AppMethodBeat.m2505o(44015);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(44016);
        AppMethodBeat.m2505o(44016);
    }

    public void setText(final String str) {
        AppMethodBeat.m2504i(44017);
        C1720g.m3539RS().mo10300a(new C5002a() {
            private volatile Spanned pie;

            public final boolean acf() {
                AppMethodBeat.m2504i(44009);
                this.pie = HtmlTextView.m86095a(HtmlTextView.this, str);
                AppMethodBeat.m2505o(44009);
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.m2504i(44010);
                HtmlTextView.m86096a(HtmlTextView.this, this.pie, BufferType.SPANNABLE);
                HtmlTextView.this.setMovementMethod(LinkMovementMethod.getInstance());
                AppMethodBeat.m2505o(44010);
                return true;
            }

            public final String toString() {
                AppMethodBeat.m2504i(44011);
                String str = super.toString() + "|setText";
                AppMethodBeat.m2505o(44011);
                return str;
            }
        });
        AppMethodBeat.m2505o(44017);
    }

    /* renamed from: a */
    static /* synthetic */ Spanned m86095a(HtmlTextView htmlTextView, String str) {
        AppMethodBeat.m2504i(44018);
        Spanned fromHtml = Html.fromHtml(str, null, htmlTextView.pic);
        AppMethodBeat.m2505o(44018);
        return fromHtml;
    }
}
