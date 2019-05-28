package com.tencent.p177mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

/* renamed from: com.tencent.mm.kiss.widget.textview.f */
public final class C37874f {
    public Alignment eNC;
    public TruncateAt eND;
    public boolean eNL = true;
    CharSequence eNM;
    public TextPaint eNN;
    public StaticLayout eNO;
    public int gravity;
    public int maxLength;
    public int maxLines;
    CharSequence text;

    public C37874f(StaticLayout staticLayout) {
        this.eNO = staticLayout;
    }
}
