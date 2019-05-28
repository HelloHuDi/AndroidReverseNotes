package com.tencent.mm.plugin.emojicapture.ui.b;

import a.l;
import android.opengl.EGL14;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.PTModule;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u00020\u000eH\u0014J\u0006\u0010\u000f\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLSurfaceTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "renderOutputType", "", "(I)V", "TAG", "", "useCpuCrop", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getEmojiProcessOutputTexture", "release", "releaseFilterProcess", "resetRenderer", "plugin-emojicapture_release"})
public final class b extends a {
    private final String TAG;
    private boolean fau;

    private b() {
        super(0, 0, 0, 0, 1, 1);
        this.TAG = "MicroMsg.EmojiCaptureGLSurfaceTextureRenderer";
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public final com.tencent.mm.media.h.b.a Vc() {
        AppMethodBeat.i(3144);
        ab.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.fau);
        try {
            PTModule.getInstance().init(EGL14.eglGetCurrentContext());
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "PTModule.getInstance().init error", new Object[0]);
        }
        com.tencent.mm.media.h.b.a fVar;
        if (this.fau) {
            fVar = new f(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
            AppMethodBeat.o(3144);
            return fVar;
        }
        fVar = new a(this.eYW, this.eYX, this.eYY, this.eYZ, this.eZa, this.scaleType);
        AppMethodBeat.o(3144);
        return fVar;
    }

    public final void release() {
        AppMethodBeat.i(3145);
        super.release();
        GamePlaySDK.getInstance().clear();
        PTModule.getInstance().destroy();
        AppMethodBeat.o(3145);
    }
}
