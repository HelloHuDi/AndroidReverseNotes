package com.tencent.p177mm.media.p253f;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "(Ljava/util/List;)V", "currFrameTime", "", "drawFrame", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.f.b */
public final class C32744b {
    private long eUj;
    private final List<C9584b> eWG;

    public C32744b(List<C9584b> list) {
        C25052j.m39376p(list, "editorItems");
        AppMethodBeat.m2504i(12991);
        this.eWG = list;
        AppMethodBeat.m2505o(12991);
    }

    /* renamed from: a */
    public final long mo53300a(Canvas canvas, Paint paint) {
        AppMethodBeat.m2504i(12990);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(paint, "paint");
        if (this.eWG.size() <= 0) {
            AppMethodBeat.m2505o(12990);
            return 0;
        }
        long j = Long.MAX_VALUE;
        Iterator it = this.eWG.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                C9584b c9584b = (C9584b) it.next();
                long ff = c9584b.mo20907ff(this.eUj);
                c9584b.draw(canvas, paint);
                if (ff < j2) {
                    j = ff;
                } else {
                    j = j2;
                }
            } else {
                this.eUj = j2;
                j = this.eUj;
                AppMethodBeat.m2505o(12990);
                return j;
            }
        }
    }
}
