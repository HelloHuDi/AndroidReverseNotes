package com.tencent.mm.plugin.appbrand.h;

import java.nio.ByteBuffer;

public interface k extends j {
    ByteBuffer getNativeBuffer(int i);

    int getNativeBufferId();

    void setNativeBuffer(int i, ByteBuffer byteBuffer);
}
