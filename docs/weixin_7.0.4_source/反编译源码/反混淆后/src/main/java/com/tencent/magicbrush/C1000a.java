package com.tencent.magicbrush;

import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.a */
public final class C1000a {
    public final MBRuntime bSg;
    public SparseLongArray bSh = new SparseLongArray();

    /* renamed from: com.tencent.magicbrush.a$a */
    public class C1001a {
        public float bSi;
        public float bSj;
    }

    C1000a(MBRuntime mBRuntime) {
        AppMethodBeat.m2504i(115779);
        this.bSg = mBRuntime;
        AppMethodBeat.m2505o(115779);
    }

    /* renamed from: fQ */
    public final float mo3981fQ(int i) {
        AppMethodBeat.m2504i(115780);
        float yt = (((float) (mo3984yt() - i)) * 1000.0f) / ((float) C37414c.m63041az(this.bSh.get(i)));
        AppMethodBeat.m2505o(115780);
        return yt;
    }

    public final C1001a getCurrentFps() {
        C1001a c1001a;
        AppMethodBeat.m2504i(115781);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    c1001a = new C1001a();
                } else {
                    c1001a = new C1001a();
                    float[] nativeGetCurrentFps = this.bSg.nativeGetCurrentFps(this.bSg.mNativeInst);
                    c1001a.bSi = nativeGetCurrentFps[0];
                    c1001a.bSj = nativeGetCurrentFps[1];
                    AppMethodBeat.m2505o(115781);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115781);
            }
        }
        return c1001a;
    }

    /* renamed from: ys */
    public final float mo3983ys() {
        float f;
        AppMethodBeat.m2504i(115782);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    f = -1.0f;
                } else {
                    f = this.bSg.nativeGetCurrentFpsVariance(this.bSg.mNativeInst);
                    AppMethodBeat.m2505o(115782);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115782);
            }
        }
        return f;
    }

    /* renamed from: yt */
    public final int mo3984yt() {
        int i;
        AppMethodBeat.m2504i(115783);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = -1;
                } else {
                    i = this.bSg.nativeGetFrameCounter(this.bSg.mNativeInst);
                    AppMethodBeat.m2505o(115783);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115783);
            }
        }
        return i;
    }

    /* renamed from: yu */
    public final int mo3985yu() {
        int i;
        AppMethodBeat.m2504i(115784);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = 0;
                } else {
                    i = this.bSg.nativeGetDrawCalls(this.bSg.mNativeInst);
                    AppMethodBeat.m2505o(115784);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115784);
            }
        }
        return i;
    }

    /* renamed from: yv */
    public final int mo3986yv() {
        int i;
        AppMethodBeat.m2504i(115785);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = 0;
                } else {
                    i = this.bSg.nativeGetVertexes(this.bSg.mNativeInst);
                    AppMethodBeat.m2505o(115785);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115785);
            }
        }
        return i;
    }

    /* renamed from: yw */
    public final int mo3987yw() {
        int i;
        AppMethodBeat.m2504i(115786);
        synchronized (this.bSg) {
            try {
                if (this.bSg.mNativeInst == 0) {
                    i = 0;
                } else {
                    i = this.bSg.nativeGetTriangles(this.bSg.mNativeInst);
                    AppMethodBeat.m2505o(115786);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115786);
            }
        }
        return i;
    }
}
