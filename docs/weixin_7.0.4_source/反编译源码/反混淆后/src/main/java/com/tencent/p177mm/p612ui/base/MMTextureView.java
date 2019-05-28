package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;

@TargetApi(14)
/* renamed from: com.tencent.mm.ui.base.MMTextureView */
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
        AppMethodBeat.m2504i(106862);
        try {
            super.onDetachedFromWindow();
            AppMethodBeat.m2505o(106862);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMTextureView", e, "unkown error", new Object[0]);
            AppMethodBeat.m2505o(106862);
        }
    }

    public final void dAh() {
        AppMethodBeat.m2504i(106863);
        if (C1443d.m3067fP(16)) {
            C4990ab.m7417i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.m2505o(106863);
        } else if (C1443d.m3069iX(20)) {
            C4990ab.m7417i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.m2505o(106863);
        } else if (C1427q.etn.esC == 2) {
            C4990ab.m7416i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
            AppMethodBeat.m2505o(106863);
        } else {
            C4990ab.m7416i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.yxT == null) {
                    this.yxT = TextureView.class.getDeclaredField("mSurface");
                    this.yxT.setAccessible(true);
                }
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.yxT.get(this);
                if (surfaceTexture == null) {
                    C4990ab.m7416i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                    AppMethodBeat.m2505o(106863);
                } else if (surfaceTexture instanceof C23637r) {
                    C4990ab.m7416i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                    AppMethodBeat.m2505o(106863);
                } else {
                    C23637r c23637r = new C23637r();
                    c23637r.mSurfaceTexture = surfaceTexture;
                    this.yxT.set(this, c23637r);
                    C4990ab.m7416i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                    AppMethodBeat.m2505o(106863);
                }
            } catch (NoSuchFieldException e) {
                C4990ab.printErrStackTrace("MicroMsg.MMTextureView", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
                AppMethodBeat.m2505o(106863);
            } catch (IllegalArgumentException e2) {
                C4990ab.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
                AppMethodBeat.m2505o(106863);
            } catch (IllegalAccessException e3) {
                C4990ab.printErrStackTrace("MicroMsg.MMTextureView", e3, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
                AppMethodBeat.m2505o(106863);
            }
        }
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(106864);
        super.setSurfaceTexture(surfaceTexture);
        dAh();
        AppMethodBeat.m2505o(106864);
    }
}
