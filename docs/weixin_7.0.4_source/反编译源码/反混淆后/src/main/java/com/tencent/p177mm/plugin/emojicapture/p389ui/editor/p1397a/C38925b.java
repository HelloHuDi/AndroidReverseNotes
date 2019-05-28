package com.tencent.p177mm.plugin.emojicapture.p389ui.editor.p1397a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.fontdecode.PathExtractor;
import com.tencent.p177mm.fontdecode.PathExtractor.Metrics;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.p1397a.C27826c.C27827a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C25272c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0004H\u0016R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "fontPaths", "", "", "textSize", "", "([Ljava/lang/String;I)V", "currFont", "dataMap", "", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "defaultDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontPath", "TextPathData", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.a.b */
public final class C38925b implements C27826c {
    private String loB = "";
    private Map<String, C34021a> loC = new HashMap();
    private final C38924a loD = new C38924a();
    private CharSequence text;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/PathTextDrawer$TextPathData;", "", "fontPath", "", "textSize", "", "(Ljava/lang/String;I)V", "boxList", "", "Landroid/graphics/RectF;", "getBoxList", "()Ljava/util/List;", "metrics", "Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "getMetrics", "()Lcom/tencent/mm/fontdecode/PathExtractor$Metrics;", "pathExtractor", "Lcom/tencent/mm/fontdecode/PathExtractor;", "pathList", "Landroid/graphics/Path;", "getPathList", "isValid", "", "refresh", "", "text", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.a.b$a */
    public static final class C34021a {
        final PathExtractor loE;
        final List<Path> loF;
        final List<RectF> loG;
        private final Metrics loH = new Metrics();

        public C34021a(String str, int i) {
            C25052j.m39376p(str, "fontPath");
            AppMethodBeat.m2504i(3134);
            this.loE = new PathExtractor(str);
            this.loE.setTextSize(i);
            this.loF = new ArrayList();
            this.loG = new ArrayList();
            this.loE.mo33686a(this.loH);
            AppMethodBeat.m2505o(3134);
        }
    }

    public C38925b(String[] strArr, int i) {
        C25052j.m39376p(strArr, "fontPaths");
        AppMethodBeat.m2504i(3139);
        for (String str : strArr) {
            C34021a c34021a = new C34021a(str, i);
            if (c34021a.loE.isValid()) {
                this.loC.put(str, c34021a);
            }
        }
        AppMethodBeat.m2505o(3139);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.m2504i(3135);
        C25052j.m39376p(charSequence, "text");
        this.text = charSequence;
        this.loD.setText(charSequence);
        AppMethodBeat.m2505o(3135);
    }

    public final void refresh() {
        AppMethodBeat.m2504i(3136);
        for (C34021a c34021a : this.loC.values()) {
            CharSequence charSequence = this.text;
            c34021a.loF.clear();
            c34021a.loG.clear();
            if (charSequence != null) {
                for (int i = 0; i < charSequence.length(); i++) {
                    char charAt = charSequence.charAt(i);
                    Path path = new Path();
                    RectF rectF = new RectF();
                    if (c34021a.loE.mo33687a(charAt, path, rectF)) {
                        c34021a.loF.add(path);
                        c34021a.loG.add(rectF);
                    } else {
                        c34021a.loF.add(null);
                        c34021a.loG.add(null);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(3136);
    }

    /* renamed from: Kd */
    public final void mo45694Kd(String str) {
        AppMethodBeat.m2504i(3137);
        C25052j.m39376p(str, "fontPath");
        this.loB = str;
        AppMethodBeat.m2505o(3137);
    }

    /* renamed from: a */
    public final void mo45695a(Canvas canvas, int i, int i2, float f, float f2, Paint paint, boolean z) {
        AppMethodBeat.m2504i(3138);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(paint, "paint");
        if (C5046bo.m7519ac(this.text)) {
            AppMethodBeat.m2505o(3138);
            return;
        }
        C34021a c34021a = (C34021a) this.loC.get(this.loB);
        if (c34021a == null) {
            this.loD.mo45695a(canvas, i, i2, f, f2, paint, z);
            AppMethodBeat.m2505o(3138);
            return;
        }
        canvas.save();
        canvas.translate(f, f2);
        int i3 = -1;
        for (int i4 = i; i4 < i2; i4++) {
            float measureText;
            if (c34021a.loF.get(i4) != null) {
                canvas.drawPath((Path) c34021a.loF.get(i4), paint);
                measureText = paint.measureText(this.text, i4, i4 + 1);
            } else {
                CharSequence charSequence = this.text;
                if (charSequence == null) {
                    C25052j.dWJ();
                }
                if (C25272c.isSurrogate(charSequence.charAt(i4)) && i3 == -1) {
                    i3 = i4;
                } else if (i3 != -1) {
                    charSequence = this.text;
                    if (charSequence == null) {
                        C25052j.dWJ();
                    }
                    if (i4 < charSequence.length() - 1) {
                        charSequence = this.text;
                        if (charSequence == null) {
                            C25052j.dWJ();
                        }
                        if (C25272c.isSurrogate(charSequence.charAt(i4 + 1))) {
                        }
                    }
                    canvas.save();
                    canvas.drawText(this.text, i3, i4 + 1, 0.0f, 0.0f, paint);
                    canvas.restore();
                    measureText = paint.measureText(this.text, i3, i4 + 1);
                    i3 = -1;
                } else {
                    canvas.drawText(this.text, i4, i4 + 1, 0.0f, 0.0f, paint);
                    measureText = paint.measureText(this.text, i4, i4 + 1);
                }
            }
            canvas.translate(measureText, 0.0f);
        }
        if (z) {
            canvas.drawText(C27827a.boe(), 0.0f, 0.0f, paint);
        }
        canvas.restore();
        AppMethodBeat.m2505o(3138);
    }
}
