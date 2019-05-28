package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ObservableSurfaceView extends SurfaceView implements Callback {
    protected SurfaceHolder hei;
    private a sKK = null;
    protected boolean sKL = false;
    protected boolean sKM = false;
    protected boolean sKN = false;

    public ObservableSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(50956);
        init();
        AppMethodBeat.o(50956);
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(50957);
        init();
        AppMethodBeat.o(50957);
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(50958);
        init();
        AppMethodBeat.o(50958);
    }

    private void init() {
        AppMethodBeat.i(50959);
        this.hei = getHolder();
        this.hei.addCallback(this);
        AppMethodBeat.o(50959);
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.hei;
    }

    public void setNeedSetType(boolean z) {
        AppMethodBeat.i(50960);
        this.sKN = z;
        if (this.sKN) {
            this.hei.setType(3);
        }
        AppMethodBeat.o(50960);
    }

    public void setSurfaceChangeCallback(a aVar) {
        AppMethodBeat.i(50961);
        this.sKK = aVar;
        if (this.sKN) {
            this.hei.setType(3);
        }
        AppMethodBeat.o(50961);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.sKL = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(50962);
        ab.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.sKM = true;
        try {
            this.hei.removeCallback(this);
        } catch (Exception e) {
        }
        this.hei = surfaceHolder;
        this.hei.addCallback(this);
        if (this.sKK != null) {
            this.sKK.a(this.hei);
        }
        AppMethodBeat.o(50962);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.sKL = false;
        this.sKM = false;
    }

    public final boolean cHK() {
        return this.sKL;
    }
}
