package com.github.henryye.nativeiv.bitmap;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public enum BitmapType {
    Native,
    Legacy,
    Undefined;

    static {
        AppMethodBeat.o(115756);
    }
}
