package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.emojicapture.ui.editor.a.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\tH\u0002J\u0010\u00104\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0014J\u0018\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0014J\u000e\u00108\u001a\u00020-2\u0006\u00103\u001a\u00020\u000eJ\u0010\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010;J(\u0010<\u001a\u00020-2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/FontTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignment", "Landroid/text/Layout$Alignment;", "contentLeft", "", "contentPadding", "defaultText", "", "drawStroke", "", "getDrawStroke", "()Z", "setDrawStroke", "(Z)V", "includePadding", "layout", "Landroid/text/StaticLayout;", "lineHeight", "lineSpacing", "maxWidth", "newLayout", "spacingAddition", "spacingMultiplier", "strokePaint", "Landroid/text/TextPaint;", "text", "", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "getTextDrawer", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "setTextDrawer", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;)V", "textPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "line", "lineSpace", "makeNewLayout", "width", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "updateText", "color", "strokeColor", "change", "plugin-emojicapture_release"})
public final class FontTextView extends View {
    private final Alignment eNC;
    private TextPaint eNN;
    private float hcW;
    private StaticLayout layout;
    private String lnT;
    private final float lnU;
    private final float lnV;
    private final boolean lnW;
    private TextPaint lnX;
    private final int lnY;
    private float lnZ;
    private float loa;
    private float lob;
    private boolean loc;
    private c lod;
    private boolean loe;
    private CharSequence text;

    public FontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(3109);
        this.eNC = Alignment.ALIGN_CENTER;
        this.lnU = 1.0f;
        this.eNN = new TextPaint();
        this.lnX = new TextPaint();
        this.text = "";
        if (context == null) {
            j.dWJ();
        }
        float dimension = context.getResources().getDimension(R.dimen.a01);
        this.loa = context.getResources().getDimension(R.dimen.a03);
        this.lob = context.getResources().getDimension(R.dimen.a04);
        String string = context.getResources().getString(R.string.ac_);
        j.o(string, "context.resources.getStr…pture_emoji_text_default)");
        this.lnT = string;
        this.lnY = a.fromDPToPix(context, 2);
        this.eNN.setAntiAlias(true);
        this.eNN.setTextSize(dimension);
        this.eNN.setColor(BaseClientBuilder.API_PRIORITY_OTHER);
        dimension = (float) a.fromDPToPix(context, 1);
        this.eNN.setShadowLayer(dimension, 0.0f, dimension, WebView.NIGHT_MODE_COLOR);
        this.lnX.setStrokeWidth(context.getResources().getDimension(R.dimen.a05));
        this.lnX.setAntiAlias(true);
        this.lnX.setTextSize(this.eNN.getTextSize());
        this.lnX.setStyle(Style.STROKE);
        this.layout = new StaticLayout(this.text, this.eNN, getWidth(), this.eNC, this.lnU, this.lnV, this.lnW);
        setLayerType(1, null);
        this.lod = new com.tencent.mm.plugin.emojicapture.ui.editor.a.a();
        this.text = this.lnT;
        c cVar = this.lod;
        if (cVar != null) {
            cVar.setText(this.text);
            AppMethodBeat.o(3109);
            return;
        }
        AppMethodBeat.o(3109);
    }

    public FontTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FontTextView(Context context) {
        this(context, null);
    }

    public final c getTextDrawer() {
        return this.lod;
    }

    public final void setTextDrawer(c cVar) {
        this.lod = cVar;
    }

    public final boolean getDrawStroke() {
        return this.loe;
    }

    public final void setDrawStroke(boolean z) {
        this.loe = z;
    }

    public final void setMaxWidth(float f) {
        this.hcW = f;
    }

    public final void d(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.i(3104);
        boolean z = charSequence == null || charSequence.length() == 0;
        if (z) {
            this.loe = false;
            this.text = this.lnT;
            this.eNN.setColor(BaseClientBuilder.API_PRIORITY_OTHER);
            float fromDPToPix = (float) a.fromDPToPix(getContext(), 1);
            this.eNN.setShadowLayer(fromDPToPix, 0.0f, fromDPToPix, WebView.NIGHT_MODE_COLOR);
        } else {
            this.loe = true;
            if (charSequence == null) {
                j.dWJ();
            }
            this.text = charSequence;
            this.eNN.setColor(i);
            this.eNN.clearShadowLayer();
        }
        this.lnX.setColor(i2);
        c cVar = this.lod;
        if (cVar != null) {
            cVar.setText(this.text);
        }
        cVar = this.lod;
        if (cVar != null) {
            cVar.refresh();
            AppMethodBeat.o(3104);
            return;
        }
        AppMethodBeat.o(3104);
    }

    public final void setTypeface(Typeface typeface) {
        AppMethodBeat.i(3105);
        this.eNN.setTypeface(typeface);
        this.lnX.setTypeface(typeface);
        AppMethodBeat.o(3105);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(3106);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        canvas.save();
        canvas.translate(-this.lnZ, 0.0f);
        a(canvas, 0, 0.0f);
        a(canvas, 1, this.lob);
        canvas.restore();
        AppMethodBeat.o(3106);
    }

    private final void a(Canvas canvas, int i, float f) {
        AppMethodBeat.i(3107);
        if (i < 0 || i >= this.layout.getLineCount()) {
            AppMethodBeat.o(3107);
            return;
        }
        c cVar;
        float lineLeft = this.layout.getLineLeft(i) + ((float) getPaddingLeft());
        float lineBaseline = (((float) this.layout.getLineBaseline(i)) + f) + ((float) getPaddingTop());
        boolean z = this.layout.getEllipsisCount(i) > 0;
        int lineStart = z ? this.layout.getLineStart(i) + this.layout.getEllipsisStart(i) : this.layout.getLineEnd(i);
        if (this.loe) {
            cVar = this.lod;
            if (cVar != null) {
                cVar.a(canvas, this.layout.getLineStart(i), lineStart, lineLeft, lineBaseline, this.lnX, z);
            }
        }
        cVar = this.lod;
        if (cVar != null) {
            cVar.a(canvas, this.layout.getLineStart(i), lineStart, lineLeft, lineBaseline, this.eNN, z);
            AppMethodBeat.o(3107);
            return;
        }
        AppMethodBeat.o(3107);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(3108);
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        if (((float) size) > this.hcW) {
            size = (int) this.hcW;
        }
        this.loc = true;
        int i3 = size - (this.lnY * 2);
        StaticLayout staticLayout = this.layout;
        if (this.loc && i3 >= 0) {
            c cVar = this.lod;
            if (cVar != null) {
                cVar.refresh();
            }
            if (VERSION.SDK_INT >= 23) {
                staticLayout = Builder.obtain(this.text, 0, this.text.length(), this.eNN, i3).setAlignment(this.eNC).setIncludePad(this.lnW).setMaxLines(2).setLineSpacing(this.lnV, this.lnU).setEllipsize(TruncateAt.END).build();
                j.o(staticLayout, "StaticLayout.Builder.obt…                 .build()");
            } else {
                staticLayout = new StaticLayout(this.text, this.eNN, i3, this.eNC, this.lnU, this.lnV, this.lnW);
            }
            this.loc = false;
        }
        this.layout = staticLayout;
        size = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
        if (((float) size) > this.loa) {
            this.loa = (float) size;
        }
        if (this.layout.getLineCount() <= 1) {
            size = (int) this.loa;
        } else {
            size = (int) ((2.0f * this.loa) + this.lob);
        }
        int paddingBottom = size + (getPaddingBottom() + getPaddingTop());
        float lineLeft = this.layout.getLineLeft(0);
        float lineRight = this.layout.getLineRight(0);
        if (this.layout.getLineCount() > 1) {
            if (lineLeft > this.layout.getLineLeft(1)) {
                lineLeft = this.layout.getLineLeft(1);
            }
            if (lineRight < this.layout.getLineRight(1)) {
                lineRight = this.layout.getLineRight(1);
            }
        }
        this.lnZ = lineLeft - ((float) this.lnY);
        setMeasuredDimension((int) ((lineRight - lineLeft) + ((float) (this.lnY * 2))), paddingBottom);
        AppMethodBeat.o(3108);
    }
}
