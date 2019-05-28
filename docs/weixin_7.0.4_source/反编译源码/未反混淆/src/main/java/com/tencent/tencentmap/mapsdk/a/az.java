package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public class az {
    protected float K = 1.0f;
    protected int L = Color.argb(17, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    protected int M = Color.argb(255, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    protected float N = 0.0f;
    protected boolean O = true;
    protected boolean P = false;
    protected int Q = di.c;

    public az() {
        AppMethodBeat.i(100726);
        AppMethodBeat.o(100726);
    }

    public void a(boolean z) {
        this.O = z;
    }

    public float D() {
        return this.N;
    }

    public void d(float f) {
        this.K = f;
        this.P = true;
    }

    public void c(int i) {
        this.M = i;
        this.P = true;
    }

    public void d(int i) {
        this.L = i;
        this.P = true;
    }

    public void c(float f) {
        this.N = f;
        this.P = true;
    }

    public void a_(int i) {
        this.Q = i;
        this.P = true;
    }

    public int E() {
        return this.Q;
    }
}
