package com.tencent.p177mm.plugin.emojicapture.p389ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p255h.p256b.C1786a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C20447b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27807a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C42981f;
import p000a.C0220l;
import p000a.C44941v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getPreviewTextureId", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView */
public final class EmojiCaptureGLTextureView extends CameraPreviewGLTextureView {
    public static final C20440a llb = new C20440a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView$a */
    public static final class C20440a {
        private C20440a() {
        }

        public /* synthetic */ C20440a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(2861);
        AppMethodBeat.m2505o(2861);
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
        AppMethodBeat.m2504i(2860);
        int boj;
        if (getRenderer() instanceof C20447b) {
            C37897a renderer = getRenderer();
            C44941v c44941v;
            if (renderer == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureGLSurfaceTextureRenderer");
                AppMethodBeat.m2505o(2860);
                throw c44941v;
            }
            C20447b c20447b = (C20447b) renderer;
            C1786a c1786a;
            if (c20447b.eYL instanceof C27807a) {
                c1786a = c20447b.eYL;
                if (c1786a == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureCropTopRenderProc");
                    AppMethodBeat.m2505o(2860);
                    throw c44941v;
                }
                boj = ((C27807a) c1786a).loL.boj();
                AppMethodBeat.m2505o(2860);
                return boj;
            } else if (c20447b.eYL instanceof C42981f) {
                c1786a = c20447b.eYL;
                if (c1786a == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCaptureRGBRenderProc");
                    AppMethodBeat.m2505o(2860);
                    throw c44941v;
                }
                boj = ((C42981f) c1786a).loL.boj();
                AppMethodBeat.m2505o(2860);
                return boj;
            } else {
                AppMethodBeat.m2505o(2860);
                return 0;
            }
        }
        boj = super.getPreviewTextureId();
        AppMethodBeat.m2505o(2860);
        return boj;
    }
}
