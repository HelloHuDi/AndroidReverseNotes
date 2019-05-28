package com.tencent.oscarcamera.particlesystem;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Attribute {
    public String mName;
    public Value mValue;
    public int mVarIndex;

    public double value() {
        AppMethodBeat.m2504i(81508);
        if (this.mValue != null) {
            double value = this.mValue.value();
            AppMethodBeat.m2505o(81508);
            return value;
        }
        AppMethodBeat.m2505o(81508);
        return 0.0d;
    }

    public long expression() {
        AppMethodBeat.m2504i(81509);
        if (this.mValue != null) {
            long expression = this.mValue.expression();
            AppMethodBeat.m2505o(81509);
            return expression;
        }
        AppMethodBeat.m2505o(81509);
        return -1;
    }
}
