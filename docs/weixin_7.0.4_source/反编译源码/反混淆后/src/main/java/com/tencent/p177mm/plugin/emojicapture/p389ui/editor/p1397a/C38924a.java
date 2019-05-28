package com.tencent.p177mm.plugin.emojicapture.p389ui.editor.p1397a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.p1397a.C27826c.C27827a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "()V", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontName", "", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.a.a */
public final class C38924a implements C27826c {
    private CharSequence text;

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.m2504i(3131);
        C25052j.m39376p(charSequence, "text");
        this.text = charSequence;
        AppMethodBeat.m2505o(3131);
    }

    public final void refresh() {
    }

    /* renamed from: Kd */
    public final void mo45694Kd(String str) {
        AppMethodBeat.m2504i(3132);
        C25052j.m39376p(str, "fontName");
        AppMethodBeat.m2505o(3132);
    }

    /* renamed from: a */
    public final void mo45695a(Canvas canvas, int i, int i2, float f, float f2, Paint paint, boolean z) {
        AppMethodBeat.m2504i(3133);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(paint, "paint");
        if (this.text == null) {
            AppMethodBeat.m2505o(3133);
            return;
        }
        canvas.drawText(this.text, i, i2, f, f2, paint);
        if (z) {
            canvas.drawText(C27827a.boe(), paint.measureText(this.text, i, i2) + f, f2, paint);
        }
        AppMethodBeat.m2505o(3133);
    }
}
