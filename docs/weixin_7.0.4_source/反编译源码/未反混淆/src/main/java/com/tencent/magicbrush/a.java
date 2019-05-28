package com.tencent.magicbrush;

import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public final MBRuntime bSg;
    public SparseLongArray bSh = new SparseLongArray();

    public class a {
        public float bSi;
        public float bSj;
    }

    a(MBRuntime mBRuntime) {
        AppMethodBeat.i(115779);
        this.bSg = mBRuntime;
        AppMethodBeat.o(115779);
    }

    public final float fQ(int i) {
        AppMethodBeat.i(115780);
        float yt = (((float) (yt() - i)) * 1000.0f) / ((float) c.az(this.bSh.get(i)));
        AppMethodBeat.o(115780);
        return yt;
    }

    public final a getCurrentFps() {
        a aVar;
        AppMethodBeat.i(115781);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    aVar = new a();
                } else {
                    aVar = new a();
                    float[] nativeGetCurrentFps = this.bSg.nativeGetCurrentFps(this.bSg.mNativeInst);
                    aVar.bSi = nativeGetCurrentFps[0];
                    aVar.bSj = nativeGetCurrentFps[1];
                    AppMethodBeat.o(115781);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115781);
            }
        }
        return aVar;
    }

    public final float ys() {
        float f;
        AppMethodBeat.i(115782);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    f = -1.0f;
                } else {
                    f = this.bSg.nativeGetCurrentFpsVariance(this.bSg.mNativeInst);
                    AppMethodBeat.o(115782);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115782);
            }
        }
        return f;
    }

    public final int yt() {
        int i;
        AppMethodBeat.i(115783);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = -1;
                } else {
                    i = this.bSg.nativeGetFrameCounter(this.bSg.mNativeInst);
                    AppMethodBeat.o(115783);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115783);
            }
        }
        return i;
    }

    public final int yu() {
        int i;
        AppMethodBeat.i(115784);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = 0;
                } else {
                    i = this.bSg.nativeGetDrawCalls(this.bSg.mNativeInst);
                    AppMethodBeat.o(115784);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115784);
            }
        }
        return i;
    }

    public final int yv() {
        int i;
        AppMethodBeat.i(115785);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = 0;
                } else {
                    i = this.bSg.nativeGetVertexes(this.bSg.mNativeInst);
                    AppMethodBeat.o(115785);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115785);
            }
        }
        return i;
    }

    public final int yw() {
        int i;
        AppMethodBeat.i(115786);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = 0;
                } else {
                    i = this.bSg.nativeGetTriangles(this.bSg.mNativeInst);
                    AppMethodBeat.o(115786);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115786);
            }
        }
        return i;
    }
}
