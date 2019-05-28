package com.tencent.liteav.muxer.jni;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.nio.ByteBuffer;

public class TXSWMuxerJNI {
    /* renamed from: a */
    private long f14918a;
    /* renamed from: b */
    private volatile boolean f14919b;
    /* renamed from: c */
    private volatile boolean f14920c;

    public static class AVOptions {
        public int audioChannels = 0;
        public int audioSampleRate = 0;
        public int videoGOP = 12;
        public int videoHeight = 540;
        public int videoWidth = VideoFilterUtil.IMAGE_HEIGHT;
    }

    private native long init();

    private native void release(long j);

    private native void setAVParams(long j, AVOptions aVOptions);

    private native void setAudioCSD(long j, byte[] bArr);

    private native void setDstPath(long j, String str);

    private native void setVideoCSD(long j, byte[] bArr, byte[] bArr2);

    private native int start(long j);

    private native int stop(long j);

    private native int writeFrame(long j, byte[] bArr, int i, int i2, int i3, int i4, long j2);

    public TXSWMuxerJNI() {
        AppMethodBeat.m2504i(67141);
        this.f14918a = -1;
        this.f14918a = init();
        this.f14919b = true;
        AppMethodBeat.m2505o(67141);
    }

    /* renamed from: a */
    public void mo52796a(AVOptions aVOptions) {
        AppMethodBeat.m2504i(67142);
        if (this.f14919b) {
            setAVParams(this.f14918a, aVOptions);
            AppMethodBeat.m2505o(67142);
            return;
        }
        TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.m2505o(67142);
    }

    /* renamed from: a */
    public void mo52797a(String str) {
        AppMethodBeat.m2504i(67143);
        if (this.f14919b) {
            setDstPath(this.f14918a, str);
            AppMethodBeat.m2505o(67143);
            return;
        }
        TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.m2505o(67143);
    }

    /* renamed from: a */
    public void mo52799a(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2) {
        AppMethodBeat.m2504i(67144);
        if (this.f14919b) {
            setVideoCSD(this.f14918a, m52447b(byteBuffer, i), m52447b(byteBuffer2, i2));
            AppMethodBeat.m2505o(67144);
            return;
        }
        TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.m2505o(67144);
    }

    /* renamed from: a */
    public void mo52798a(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(67145);
        if (this.f14919b) {
            setAudioCSD(this.f14918a, m52447b(byteBuffer, i));
            AppMethodBeat.m2505o(67145);
            return;
        }
        TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.m2505o(67145);
    }

    /* renamed from: a */
    public int mo52795a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.m2504i(67146);
        if (!this.f14919b) {
            TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
            AppMethodBeat.m2505o(67146);
            return -1;
        } else if (this.f14920c) {
            int writeFrame = writeFrame(this.f14918a, m52447b(byteBuffer, i3), i, i2, i3, i4, j);
            if (writeFrame != 0) {
                TXCLog.m15676e("TXSWMuxerJNI", "Muxer write frame error!");
            }
            AppMethodBeat.m2505o(67146);
            return writeFrame;
        } else {
            TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't start yet!");
            AppMethodBeat.m2505o(67146);
            return -1;
        }
    }

    /* renamed from: a */
    public int mo52794a() {
        AppMethodBeat.m2504i(67147);
        if (this.f14919b) {
            int start = start(this.f14918a);
            if (start == 0) {
                this.f14920c = true;
            } else {
                TXCLog.m15676e("TXSWMuxerJNI", "Start Muxer Error!!!");
            }
            AppMethodBeat.m2505o(67147);
            return start;
        }
        TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.m2505o(67147);
        return -1;
    }

    /* renamed from: b */
    public int mo52800b() {
        int i = -1;
        AppMethodBeat.m2504i(67148);
        if (!this.f14919b) {
            TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
            AppMethodBeat.m2505o(67148);
        } else if (this.f14920c) {
            this.f14920c = false;
            i = stop(this.f14918a);
            if (i != 0) {
                TXCLog.m15676e("TXSWMuxerJNI", "Stop Muxer Error!!!");
            }
            AppMethodBeat.m2505o(67148);
        } else {
            TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't start yet!");
            AppMethodBeat.m2505o(67148);
        }
        return i;
    }

    /* renamed from: c */
    public void mo52801c() {
        AppMethodBeat.m2504i(67149);
        if (this.f14919b) {
            release(this.f14918a);
            this.f14919b = false;
            this.f14920c = false;
            AppMethodBeat.m2505o(67149);
            return;
        }
        TXCLog.m15676e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.m2505o(67149);
    }

    /* renamed from: b */
    private byte[] m52447b(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(67150);
        if (byteBuffer == null) {
            AppMethodBeat.m2505o(67150);
            return null;
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        AppMethodBeat.m2505o(67150);
        return bArr;
    }
}
