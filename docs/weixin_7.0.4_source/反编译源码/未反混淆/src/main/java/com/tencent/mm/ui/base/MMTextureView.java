package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView extends TextureView {
    private Field yxT;

    public MMTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMTextureView(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(14)
    public void onDetachedFromWindow() {
        AppMethodBeat.i(106862);
        try {
            super.onDetachedFromWindow();
            AppMethodBeat.o(106862);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMTextureView", e, "unkown error", new Object[0]);
            AppMethodBeat.o(106862);
        }
    }

    public final void dAh() {
        AppMethodBeat.i(106863);
        if (d.fP(16)) {
            ab.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.o(106863);
        } else if (d.iX(20)) {
            ab.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.o(106863);
        } else if (q.etn.esC == 2) {
            ab.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
            AppMethodBeat.o(106863);
        } else {
            ab.i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.yxT == null) {
                    this.yxT = TextureView.class.getDeclaredField("mSurface");
                    this.yxT.setAccessible(true);
                }
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.yxT.get(this);
                if (surfaceTexture == null) {
                    ab.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                    AppMethodBeat.o(106863);
                } else if (surfaceTexture instanceof r) {
                    ab.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                    AppMethodBeat.o(106863);
                } else {
                    r rVar = new r();
                    rVar.mSurfaceTexture = surfaceTexture;
                    this.yxT.set(this, rVar);
                    ab.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                    AppMethodBeat.o(106863);
                }
            } catch (NoSuchFieldException e) {
                ab.printErrStackTrace("MicroMsg.MMTextureView", e, "", new Object[0]);
                ab.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
                AppMethodBeat.o(106863);
            } catch (IllegalArgumentException e2) {
                ab.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
                ab.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
                AppMethodBeat.o(106863);
            } catch (IllegalAccessException e3) {
                ab.printErrStackTrace("MicroMsg.MMTextureView", e3, "", new Object[0]);
                ab.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
                AppMethodBeat.o(106863);
            }
        }
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(106864);
        super.setSurfaceTexture(surfaceTexture);
        dAh();
        AppMethodBeat.o(106864);
    }
}
