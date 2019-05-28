package com.tencent.oscarcamera.particlesystem;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Value {
    private static final String TAG = Value.class.getSimpleName();
    private static final int TYPE_CONST = 0;
    private static final int TYPE_EXPRESSION = 1;
    private double mConstVal = 0.0d;
    private long mNativeExpression = -1;
    private int mType = 0;

    static {
        AppMethodBeat.m2504i(81562);
        AppMethodBeat.m2505o(81562);
    }

    public Value(Object obj) {
        AppMethodBeat.m2504i(81561);
        if (obj instanceof Number) {
            this.mType = 0;
            this.mConstVal = ((Number) obj).doubleValue();
            this.mNativeExpression = -1;
            AppMethodBeat.m2505o(81561);
            return;
        }
        if (obj instanceof String) {
            this.mType = 1;
            this.mNativeExpression = ParticleSystem.compile((String) obj);
        }
        AppMethodBeat.m2505o(81561);
    }

    public double value() {
        if (this.mType == 0) {
            return this.mConstVal;
        }
        if (this.mType == 1) {
        }
        return 0.0d;
    }

    public long expression() {
        return this.mNativeExpression;
    }
}
