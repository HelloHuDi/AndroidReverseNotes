package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C25649b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.liteav.videodecoder.a */
public interface C25680a {
    int config(Surface surface);

    void decode(C25649b c25649b);

    boolean isHevc();

    void setListener(C37377d c37377d);

    void setNotifyListener(WeakReference<C0946a> weakReference);

    int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2);

    void stop();
}
