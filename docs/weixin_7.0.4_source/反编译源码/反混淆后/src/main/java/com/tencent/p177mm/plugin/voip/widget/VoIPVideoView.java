package com.tencent.p177mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.voip.widget.VoIPVideoView */
public class VoIPVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] oJj = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private float bNO = 0.4f;
    private SurfaceTexture bsb;
    private int fcn;
    private int fco;
    private Paint oJk;
    private int tcp = 30;
    private int tcq = 30;
    private int tcr = 15;
    private float tcs = 0.02f;

    public VoIPVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(5157);
        initView();
        AppMethodBeat.m2505o(5157);
    }

    public VoIPVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(5158);
        initView();
        AppMethodBeat.m2505o(5158);
    }

    private void initView() {
        AppMethodBeat.m2504i(5159);
        this.oJk = new Paint();
        this.oJk.setColor(WebView.NIGHT_MODE_COLOR);
        this.oJk.setFilterBitmap(true);
        this.oJk.setTextSize(40.0f);
        setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(5159);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(5160);
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureAvailable %b %d %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(surfaceTexture != null);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        C4990ab.m7417i(str, str2, objArr);
        this.bsb = surfaceTexture;
        this.fcn = i;
        this.fco = i2;
        dAh();
        AppMethodBeat.m2505o(5160);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        AppMethodBeat.m2504i(5161);
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureSizeChanged %b %d %d";
        Object[] objArr = new Object[3];
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        C4990ab.m7417i(str, str2, objArr);
        this.fcn = i;
        this.fco = i2;
        AppMethodBeat.m2505o(5161);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z = true;
        AppMethodBeat.m2504i(5162);
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureDestroyed %b";
        Object[] objArr = new Object[1];
        if (surfaceTexture == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        this.bsb = null;
        this.fco = 0;
        this.fcn = 0;
        AppMethodBeat.m2505o(5162);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = true;
        AppMethodBeat.m2504i(5163);
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureUpdated %b";
        Object[] objArr = new Object[1];
        if (surfaceTexture == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7419v(str, str2, objArr);
        AppMethodBeat.m2505o(5163);
    }
}
