package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YtHandBox {
    public float confidence = 0.0f;
    public int handType = -999;
    public float height = 0.0f;
    public long makeTime = 0;
    public float width = 0.0f;
    /* renamed from: x */
    public float f16571x = 0.0f;
    /* renamed from: y */
    public float f16572y = 0.0f;

    public void reset() {
        this.confidence = 0.0f;
        this.height = 0.0f;
        this.width = 0.0f;
        this.f16572y = 0.0f;
        this.f16571x = 0.0f;
        this.makeTime = 0;
        this.handType = -999;
    }

    public boolean isValid() {
        return this.width > 0.0f && this.height > 0.0f;
    }

    public YtHandBox copy() {
        AppMethodBeat.m2504i(84415);
        YtHandBox ytHandBox = new YtHandBox();
        ytHandBox.f16571x = this.f16571x;
        ytHandBox.f16572y = this.f16572y;
        ytHandBox.width = this.width;
        ytHandBox.height = this.height;
        ytHandBox.confidence = this.confidence;
        ytHandBox.makeTime = this.makeTime;
        ytHandBox.handType = this.handType;
        AppMethodBeat.m2505o(84415);
        return ytHandBox;
    }
}
