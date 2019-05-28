package com.tencent.p177mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.widget.EllipsizingTextView */
public class EllipsizingTextView extends TextView {
    private int maxLines = -1;
    private final List<Object> nom = new ArrayList();
    private boolean non;
    private boolean noo;
    private boolean nop;
    private String noq;
    private float nor = 1.0f;
    private float nos = 0.0f;

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112403);
        AppMethodBeat.m2505o(112403);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112404);
        AppMethodBeat.m2505o(112404);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.m2504i(112405);
        super.setMaxLines(i);
        this.maxLines = i;
        this.noo = true;
        AppMethodBeat.m2505o(112405);
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setLineSpacing(float f, float f2) {
        AppMethodBeat.m2504i(112406);
        this.nos = f;
        this.nor = f2;
        super.setLineSpacing(f, f2);
        AppMethodBeat.m2505o(112406);
    }

    /* Access modifiers changed, original: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AppMethodBeat.m2504i(112407);
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.nop) {
            this.noq = charSequence.toString();
            this.noo = true;
        }
        AppMethodBeat.m2505o(112407);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(112408);
        if (this.noo) {
            boolean z;
            super.setEllipsize(null);
            int maxLines = getMaxLines();
            String str = this.noq;
            if (maxLines != -1) {
                Layout Ow = m44843Ow(str);
                if (Ow.getLineCount() > maxLines) {
                    boolean z2;
                    String trim = this.noq.substring(0, Ow.getLineEnd(maxLines - 1)).trim();
                    if (trim.getBytes().length != trim.length()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        while (m44843Ow(trim + "...").getLineCount() > maxLines) {
                            int lastIndexOf = trim.lastIndexOf(32);
                            if (lastIndexOf == -1) {
                                break;
                            }
                            trim = trim.substring(0, lastIndexOf);
                        }
                    } else if (trim.length() >= 2) {
                        trim = trim.substring(0, (trim.length() - 1) - 1);
                    }
                    str = trim + "...";
                    z = true;
                    if (!str.equals(getText())) {
                        this.nop = true;
                        try {
                            setText(str);
                            this.nop = false;
                        } catch (Throwable th) {
                            this.nop = false;
                            AppMethodBeat.m2505o(112408);
                        }
                    }
                    this.noo = false;
                    if (z != this.non) {
                        this.non = z;
                        Iterator it = this.nom.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
            }
            z = false;
            if (str.equals(getText())) {
            }
            this.noo = false;
            if (z != this.non) {
            }
        }
        super.onDraw(canvas);
        AppMethodBeat.m2505o(112408);
    }

    /* renamed from: Ow */
    private Layout m44843Ow(String str) {
        AppMethodBeat.m2504i(112409);
        StaticLayout staticLayout = new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Alignment.ALIGN_NORMAL, this.nor, this.nos, false);
        AppMethodBeat.m2505o(112409);
        return staticLayout;
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }
}
