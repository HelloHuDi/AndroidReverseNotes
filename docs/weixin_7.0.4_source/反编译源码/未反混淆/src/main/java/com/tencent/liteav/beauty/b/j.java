package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j {
    private static String i = "GPUGreenScreen";
    private int a;
    private int b;
    private boolean c;
    private u d;
    private boolean e;
    private h f;
    private e g;
    private boolean h;

    public int a(int i) {
        return i;
    }

    private void b() {
        AppMethodBeat.i(67026);
        if (this.d != null) {
            this.d.a();
        }
        this.d = null;
        this.e = false;
        this.h = false;
        AppMethodBeat.o(67026);
    }

    public void a() {
        AppMethodBeat.i(67027);
        b();
        c();
        if (this.f != null) {
            this.f.d();
            this.f = null;
        }
        if (this.g != null) {
            this.g.d();
            this.g = null;
        }
        this.c = false;
        AppMethodBeat.o(67027);
    }

    private void c() {
        AppMethodBeat.i(67028);
        if (!(this.b == -1 || this.b == this.a)) {
            GLES20.glDeleteTextures(1, new int[]{this.b}, 0);
            this.b = -1;
        }
        if (this.a != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.a}, 0);
            this.a = -1;
        }
        AppMethodBeat.o(67028);
    }
}
