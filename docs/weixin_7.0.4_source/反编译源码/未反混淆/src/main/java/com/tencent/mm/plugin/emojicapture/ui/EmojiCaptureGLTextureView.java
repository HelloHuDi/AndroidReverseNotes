package com.tencent.mm.plugin.emojicapture.ui;

import a.l;
import a.v;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.plugin.emojicapture.ui.b.f;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getPreviewTextureId", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureGLTextureView extends CameraPreviewGLTextureView {
    public static final a llb = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(2861);
        AppMethodBeat.o(2861);
    }

    public EmojiCaptureGLTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EmojiCaptureGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmojiCaptureGLTextureView(Context context) {
        super(context);
    }

    public final int getPreviewTextureId() {
        AppMethodBeat.i(2860);
        int boj;
        if (getRenderer() instanceof b) {
            com.tencent.mm.media.h.a renderer = getRenderer();
            v vVar;
            if (renderer == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureGLSurfaceTextureRenderer");
                AppMethodBeat.o(2860);
                throw vVar;
            }
            b bVar = (b) renderer;
            com.tencent.mm.media.h.b.a aVar;
            if (bVar.eYL instanceof com.tencent.mm.plugin.emojicapture.ui.b.a) {
                aVar = bVar.eYL;
                if (aVar == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureCropTopRenderProc");
                    AppMethodBeat.o(2860);
                    throw vVar;
                }
                boj = ((com.tencent.mm.plugin.emojicapture.ui.b.a) aVar).loL.boj();
                AppMethodBeat.o(2860);
                return boj;
            } else if (bVar.eYL instanceof f) {
                aVar = bVar.eYL;
                if (aVar == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureRGBRenderProc");
                    AppMethodBeat.o(2860);
                    throw vVar;
                }
                boj = ((f) aVar).loL.boj();
                AppMethodBeat.o(2860);
                return boj;
            } else {
                AppMethodBeat.o(2860);
                return 0;
            }
        }
        boj = super.getPreviewTextureId();
        AppMethodBeat.o(2860);
        return boj;
    }
}
