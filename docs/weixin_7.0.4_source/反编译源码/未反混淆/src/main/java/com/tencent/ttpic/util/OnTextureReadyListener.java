package com.tencent.ttpic.util;

import com.tencent.filter.h;

public interface OnTextureReadyListener {
    boolean needWait();

    void onTextureReady(h hVar, boolean z, boolean z2, double d);

    void reset();
}
