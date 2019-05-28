package com.tencent.ttpic.util;

import com.tencent.filter.h;

public interface OnSegmentReadyListener {
    boolean needWait();

    void onTextureReady(h hVar, boolean z);

    void reset();
}
