package com.tencent.ttpic.util;

import com.tencent.filter.C41672h;

public interface OnSegmentReadyListener {
    boolean needWait();

    void onTextureReady(C41672h c41672h, boolean z);

    void reset();
}
