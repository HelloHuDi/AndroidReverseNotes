package com.tencent.ttpic.particlesystemx;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.Transition;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class ParticleSystemX {
    private static final String TAG = ParticleSystemX.class.getSimpleName();
    private static ParticleSystemX mInstance;
    private List<ParticleTemplateX> mClouds = new ArrayList();
    private Context mContext = null;
    private long mNativeCtx;

    class TexCoord {
        float[] texCoord = new float[12];

        private TexCoord() {
            AppMethodBeat.i(83661);
            AppMethodBeat.o(83661);
        }
    }

    public static native int nativeAdvance(long j, int i, float f, float f2, FloatBuffer floatBuffer, float f3, boolean z);

    public static native int nativeClearParticles(long j, int i);

    public static native long nativeEmitAt(long j, double d, double d2, double d3);

    public static native long nativeInit();

    public static native void nativeRegisterTemplate(long j, Object[] objArr);

    public static native void nativeRelease(long j);

    public static native int nativeReset(long j);

    static {
        AppMethodBeat.i(83675);
        System.loadLibrary("ParticleSystem");
        AppMethodBeat.o(83675);
    }

    public static synchronized ParticleSystemX getInstance() {
        ParticleSystemX particleSystemX;
        synchronized (ParticleSystemX.class) {
            AppMethodBeat.i(83662);
            if (mInstance == null) {
                mInstance = new ParticleSystemX();
            }
            particleSystemX = mInstance;
            AppMethodBeat.o(83662);
        }
        return particleSystemX;
    }

    private ParticleSystemX() {
        AppMethodBeat.i(83663);
        AppMethodBeat.o(83663);
    }

    public void init(Context context) {
        AppMethodBeat.i(83664);
        if (this.mContext == null || this.mNativeCtx == 0) {
            this.mContext = context;
            this.mNativeCtx = nativeInit();
        }
        AppMethodBeat.o(83664);
    }

    private void loadFinish() {
        AppMethodBeat.i(83665);
        for (int i = 0; i < this.mClouds.size(); i++) {
            this.mClouds.get(i);
        }
        nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
        AppMethodBeat.o(83665);
    }

    public void createParticles(Transition transition) {
        AppMethodBeat.i(83666);
        this.mClouds.add(new ParticleTemplateX(300, (double) transition.emissionRate, transition.life, transition.positionX, transition.positionY, transition.scale, transition.rotate, transition.p0, transition.p1, transition.p2));
        loadFinish();
        AppMethodBeat.o(83666);
    }

    public void addParticle(Transition transition) {
        AppMethodBeat.i(83667);
        this.mClouds.add(new ParticleTemplateX(transition.particleCountMax, (double) transition.emissionRate, transition.life, transition.positionX, transition.positionY, transition.scale, transition.rotate, transition.p0, transition.p1, transition.p2));
        AppMethodBeat.o(83667);
    }

    public void registerTemplate() {
        AppMethodBeat.i(83668);
        nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
        AppMethodBeat.o(83668);
    }

    public int advance(float f, float f2, FloatBuffer floatBuffer, float f3) {
        AppMethodBeat.i(83669);
        int advanceByTemplate = advanceByTemplate(-1, f, f2, floatBuffer, f3, true);
        AppMethodBeat.o(83669);
        return advanceByTemplate;
    }

    public int advanceByTemplate(int i, float f, float f2, FloatBuffer floatBuffer, float f3, boolean z) {
        AppMethodBeat.i(83670);
        int nativeAdvance = nativeAdvance(this.mNativeCtx, i, f, f2, floatBuffer, f3, z);
        AppMethodBeat.o(83670);
        return nativeAdvance;
    }

    public int clearParticles(int i) {
        AppMethodBeat.i(83671);
        int nativeClearParticles = nativeClearParticles(this.mNativeCtx, i);
        AppMethodBeat.o(83671);
        return nativeClearParticles;
    }

    public int reset() {
        AppMethodBeat.i(83672);
        int nativeReset = nativeReset(this.mNativeCtx);
        AppMethodBeat.o(83672);
        return nativeReset;
    }

    public void release() {
        AppMethodBeat.i(83673);
        if (this.mNativeCtx != 0) {
            nativeRelease(this.mNativeCtx);
            this.mNativeCtx = 0;
            this.mContext = null;
        }
        AppMethodBeat.o(83673);
    }

    public long emitImmediately(float f, float f2, float f3) {
        AppMethodBeat.i(83674);
        long nativeEmitAt = nativeEmitAt(this.mNativeCtx, (double) f, (double) f2, (double) f3);
        AppMethodBeat.o(83674);
        return nativeEmitAt;
    }
}
