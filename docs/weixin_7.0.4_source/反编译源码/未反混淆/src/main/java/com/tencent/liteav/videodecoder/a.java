package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.g.b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public interface a {
    int config(Surface surface);

    void decode(b bVar);

    boolean isHevc();

    void setListener(d dVar);

    void setNotifyListener(WeakReference<com.tencent.liteav.basic.d.a> weakReference);

    int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2);

    void stop();
}
