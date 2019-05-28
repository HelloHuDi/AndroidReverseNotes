package com.tencent.mm.plugin.product.ui;

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
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al.a;
import java.net.URL;
import org.xml.sax.XMLReader;

public class HtmlTextView extends TextView {
    ImageGetter pib = new ImageGetter() {
        public final Drawable getDrawable(String str) {
            AppMethodBeat.i(44012);
            try {
                Drawable createFromStream = Drawable.createFromStream(new URL(str).openStream(), "");
                if (createFromStream != null) {
                    createFromStream.setBounds(0, 0, createFromStream.getIntrinsicWidth(), createFromStream.getIntrinsicHeight());
                }
                AppMethodBeat.o(44012);
                return createFromStream;
            } catch (Exception e) {
                AppMethodBeat.o(44012);
                return null;
            }
        }
    };
    TagHandler pic = new TagHandler() {
        public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            AppMethodBeat.i(44013);
            if (str.equalsIgnoreCase("strike") || str.equals("s")) {
                int length = editable.length();
                if (z) {
                    editable.setSpan(new StrikethroughSpan(), length, length, 17);
                    AppMethodBeat.o(44013);
                    return;
                }
                Object a = AnonymousClass3.a(editable, StrikethroughSpan.class);
                int spanStart = editable.getSpanStart(a);
                editable.removeSpan(a);
                if (spanStart != length) {
                    editable.setSpan(new StrikethroughSpan(), spanStart, length, 33);
                }
            }
            AppMethodBeat.o(44013);
        }

        private static Object a(Editable editable, Class cls) {
            AppMethodBeat.i(44014);
            Object[] spans = editable.getSpans(0, editable.length(), cls);
            if (spans.length == 0) {
                AppMethodBeat.o(44014);
                return null;
            }
            for (int length = spans.length; length > 0; length--) {
                if (editable.getSpanFlags(spans[length - 1]) == 17) {
                    Object obj = spans[length - 1];
                    AppMethodBeat.o(44014);
                    return obj;
                }
            }
            AppMethodBeat.o(44014);
            return null;
        }
    };

    static /* synthetic */ void a(HtmlTextView htmlTextView, CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(44019);
        super.setText(charSequence, bufferType);
        AppMethodBeat.o(44019);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(44015);
        AppMethodBeat.o(44015);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(44016);
        AppMethodBeat.o(44016);
    }

    public void setText(final String str) {
        AppMethodBeat.i(44017);
        g.RS().a(new a() {
            private volatile Spanned pie;

            public final boolean acf() {
                AppMethodBeat.i(44009);
                this.pie = HtmlTextView.a(HtmlTextView.this, str);
                AppMethodBeat.o(44009);
                return true;
            }

            public final boolean acg() {
                AppMethodBeat.i(44010);
                HtmlTextView.a(HtmlTextView.this, this.pie, BufferType.SPANNABLE);
                HtmlTextView.this.setMovementMethod(LinkMovementMethod.getInstance());
                AppMethodBeat.o(44010);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(44011);
                String str = super.toString() + "|setText";
                AppMethodBeat.o(44011);
                return str;
            }
        });
        AppMethodBeat.o(44017);
    }

    static /* synthetic */ Spanned a(HtmlTextView htmlTextView, String str) {
        AppMethodBeat.i(44018);
        Spanned fromHtml = Html.fromHtml(str, null, htmlTextView.pic);
        AppMethodBeat.o(44018);
        return fromHtml;
    }
}
