package com.tencent.p177mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.video.ObservableSurfaceView */
public class ObservableSurfaceView extends SurfaceView implements Callback {
    protected SurfaceHolder hei;
    private C35338a sKK = null;
    protected boolean sKL = false;
    protected boolean sKM = false;
    protected boolean sKN = false;

    public ObservableSurfaceView(Context context) {
        super(context);
        AppMethodBeat.m2504i(50956);
        init();
        AppMethodBeat.m2505o(50956);
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(50957);
        init();
        AppMethodBeat.m2505o(50957);
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(50958);
        init();
        AppMethodBeat.m2505o(50958);
    }

    private void init() {
        AppMethodBeat.m2504i(50959);
        this.hei = getHolder();
        this.hei.addCallback(this);
        AppMethodBeat.m2505o(50959);
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.hei;
    }

    public void setNeedSetType(boolean z) {
        AppMethodBeat.m2504i(50960);
        this.sKN = z;
        if (this.sKN) {
            this.hei.setType(3);
        }
        AppMethodBeat.m2505o(50960);
    }

    public void setSurfaceChangeCallback(C35338a c35338a) {
        AppMethodBeat.m2504i(50961);
        this.sKK = c35338a;
        if (this.sKN) {
            this.hei.setType(3);
        }
        AppMethodBeat.m2505o(50961);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.sKL = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.m2504i(50962);
        C4990ab.m7410d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.sKM = true;
        try {
            this.hei.removeCallback(this);
        } catch (Exception e) {
        }
        this.hei = surfaceHolder;
        this.hei.addCallback(this);
        if (this.sKK != null) {
            this.sKK.mo56084a(this.hei);
        }
        AppMethodBeat.m2505o(50962);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.sKL = false;
        this.sKM = false;
    }

    public final boolean cHK() {
        return this.sKL;
    }
}
