package com.tencent.mm.media.widget.camerarecordview.preview.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "frameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "drawFrame", "", "data", "", "getFrameDataCallback", "plugin-mediaeditor_release"})
public final class b extends a {
    private final f fcA = new a(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
    static final class a implements f {
        final /* synthetic */ b fcB;

        a(b bVar) {
            this.fcB = bVar;
        }

        public final boolean O(byte[] bArr) {
            AppMethodBeat.i(13310);
            b bVar = this.fcB;
            if (bArr != null) {
                com.tencent.mm.media.h.a aVar = bVar.eXm;
                if (aVar != null) {
                    com.tencent.mm.media.h.a.a(aVar, bArr);
                }
                bVar.fcu.requestRender();
            } else {
                ab.v("MicroMsg.CameraPreviewGLSurfaceView", "passing draw");
            }
            AppMethodBeat.o(13310);
            return false;
        }
    }

    public b(c cVar) {
        j.p(cVar, "view");
        super(cVar);
        AppMethodBeat.i(13311);
        AppMethodBeat.o(13311);
    }

    public final f getFrameDataCallback() {
        return this.fcA;
    }
}
