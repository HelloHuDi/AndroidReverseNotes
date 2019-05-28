package com.tencent.mm.media.h;

import a.l;
import android.graphics.SurfaceTexture;
import com.tencent.mm.sdk.platformtools.ab;
import javax.microedition.khronos.opengles.GL10;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "renderOutputType", "", "(I)V", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "plugin-mediaeditor_release"})
public abstract class d extends a {
    public d() {
        super(0, 0, 0, 0, 1, 2);
    }

    public void onDrawFrame(GL10 gl10) {
        try {
            SurfaceTexture surfaceTexture = this.bsb;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Media.AbsSurfaceRenderer", e, "updateTexImage error", new Object[0]);
        }
        if (this.eYO) {
            this.eYO = false;
        } else {
            super.onDrawFrame(gl10);
        }
    }
}
