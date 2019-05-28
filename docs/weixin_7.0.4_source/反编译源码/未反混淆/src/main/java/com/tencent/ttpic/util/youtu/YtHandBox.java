package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YtHandBox {
    public float confidence = 0.0f;
    public int handType = -999;
    public float height = 0.0f;
    public long makeTime = 0;
    public float width = 0.0f;
    public float x = 0.0f;
    public float y = 0.0f;

    public void reset() {
        this.confidence = 0.0f;
        this.height = 0.0f;
        this.width = 0.0f;
        this.y = 0.0f;
        this.x = 0.0f;
        this.makeTime = 0;
        this.handType = -999;
    }

    public boolean isValid() {
        return this.width > 0.0f && this.height > 0.0f;
    }

    public YtHandBox copy() {
        AppMethodBeat.i(84415);
        YtHandBox ytHandBox = new YtHandBox();
        ytHandBox.x = this.x;
        ytHandBox.y = this.y;
        ytHandBox.width = this.width;
        ytHandBox.height = this.height;
        ytHandBox.confidence = this.confidence;
        ytHandBox.makeTime = this.makeTime;
        ytHandBox.handType = this.handType;
        AppMethodBeat.o(84415);
        return ytHandBox;
    }
}
