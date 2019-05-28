package com.tencent.p177mm.plugin.emojicapture.p389ui.editor.p1397a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "text", "", "switchFont", "fontPath", "", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.a.c */
public interface C27826c {
    public static final C27827a loI = C27827a.loK;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer$Companion;", "", "()V", "ellipsisText", "", "getEllipsisText", "()Ljava/lang/String;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.a.c$a */
    public static final class C27827a {
        private static final String loJ = loJ;
        static final /* synthetic */ C27827a loK = new C27827a();

        static {
            AppMethodBeat.m2504i(3140);
            AppMethodBeat.m2505o(3140);
        }

        private C27827a() {
        }

        public static String boe() {
            return loJ;
        }
    }

    /* renamed from: Kd */
    void mo45694Kd(String str);

    /* renamed from: a */
    void mo45695a(Canvas canvas, int i, int i2, float f, float f2, Paint paint, boolean z);

    void refresh();

    void setText(CharSequence charSequence);
}
