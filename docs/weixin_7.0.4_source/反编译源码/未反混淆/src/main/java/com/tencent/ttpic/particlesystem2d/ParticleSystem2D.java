package com.tencent.ttpic.particlesystem2d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.Transition;
import java.util.ArrayList;
import java.util.List;

public class ParticleSystem2D {
    private static final String TAG = ParticleSystem2D.class.getSimpleName();
    private List<ParticleTemplate2D> mClouds = new ArrayList();
    final Context mContext;
    private long mNativeCtx;

    class TexCoord {
        float[] texCoord = new float[12];

        private TexCoord() {
            AppMethodBeat.i(83650);
            AppMethodBeat.o(83650);
        }
    }

    public static native int nativeAdvance(long j, Object[] objArr, int i);

    public static native int nativeClearParticles(long j, int i);

    public static native long nativeEmitAt(long j, double d, double d2, double d3);

    public static native long nativeInit();

    public static native void nativeRegisterTemplate(long j, Object[] objArr);

    public static native void nativeRelease(long j);

    public static native int nativeReset(long j);

    static {
        AppMethodBeat.i(83659);
        try {
            System.loadLibrary("ParticleSystem");
        } catch (UnsatisfiedLinkError e) {
            LogUtils.e(e);
        } catch (RuntimeException e2) {
            LogUtils.e(e2);
        } catch (Exception e3) {
            LogUtils.e(e3);
        }
        AppMethodBeat.o(83659);
    }

    public ParticleSystem2D(Context context) {
        AppMethodBeat.i(83651);
        this.mContext = context;
        this.mNativeCtx = nativeInit();
        AppMethodBeat.o(83651);
    }

    private void loadFinish() {
        AppMethodBeat.i(83652);
        for (int i = 0; i < this.mClouds.size(); i++) {
            this.mClouds.get(i);
        }
        nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
        AppMethodBeat.o(83652);
    }

    public void createParticles(List<StickerItem> list) {
        AppMethodBeat.i(83653);
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                Transition transition = ((StickerItem) list.get(i2)).transition;
                if (transition != null) {
                    this.mClouds.add(new ParticleTemplate2D(transition.particleCountMax, (double) transition.emissionRate, transition.life, transition.positionX, transition.positionY, transition.scale, transition.rotate, transition.p0, transition.p1, transition.p2));
                }
                i = i2 + 1;
            }
            loadFinish();
        }
        AppMethodBeat.o(83653);
    }

    public int advance(ParticleItem[] particleItemArr, int i) {
        AppMethodBeat.i(83654);
        for (ParticleItem particleItem : particleItemArr) {
            for (Particle particle : particleItem.particles) {
                particle.alive = false;
            }
        }
        int nativeAdvance = nativeAdvance(this.mNativeCtx, particleItemArr, i);
        AppMethodBeat.o(83654);
        return nativeAdvance;
    }

    public int clearParticles(int i) {
        AppMethodBeat.i(83655);
        int nativeClearParticles = nativeClearParticles(this.mNativeCtx, i);
        AppMethodBeat.o(83655);
        return nativeClearParticles;
    }

    public int reset() {
        AppMethodBeat.i(83656);
        int nativeReset = nativeReset(this.mNativeCtx);
        AppMethodBeat.o(83656);
        return nativeReset;
    }

    public void release() {
        AppMethodBeat.i(83657);
        if (this.mNativeCtx != -1) {
            nativeRelease(this.mNativeCtx);
            this.mNativeCtx = -1;
        }
        AppMethodBeat.o(83657);
    }

    public long emitImmediately(float f, float f2, float f3) {
        AppMethodBeat.i(83658);
        long nativeEmitAt = nativeEmitAt(this.mNativeCtx, (double) f, (double) f2, (double) f3);
        AppMethodBeat.o(83658);
        return nativeEmitAt;
    }
}
