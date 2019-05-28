package com.tencent.ttpic.particlesystemx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.particlesystem2d.Particle;

public class ParticleItemX {
    private static final String TAG = ParticleItemX.class.getSimpleName();
    public float emitterX;
    public float emitterY;
    public Particle[] particles;
    public float screenRatioScale = 1.0f;

    static {
        AppMethodBeat.i(83660);
        AppMethodBeat.o(83660);
    }
}
