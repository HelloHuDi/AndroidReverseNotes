package com.tencent.liteav.muxer.jni;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.nio.ByteBuffer;

public class TXSWMuxerJNI {
    private long a;
    private volatile boolean b;
    private volatile boolean c;

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
        AppMethodBeat.i(67141);
        this.a = -1;
        this.a = init();
        this.b = true;
        AppMethodBeat.o(67141);
    }

    public void a(AVOptions aVOptions) {
        AppMethodBeat.i(67142);
        if (this.b) {
            setAVParams(this.a, aVOptions);
            AppMethodBeat.o(67142);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(67142);
    }

    public void a(String str) {
        AppMethodBeat.i(67143);
        if (this.b) {
            setDstPath(this.a, str);
            AppMethodBeat.o(67143);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(67143);
    }

    public void a(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2) {
        AppMethodBeat.i(67144);
        if (this.b) {
            setVideoCSD(this.a, b(byteBuffer, i), b(byteBuffer2, i2));
            AppMethodBeat.o(67144);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(67144);
    }

    public void a(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(67145);
        if (this.b) {
            setAudioCSD(this.a, b(byteBuffer, i));
            AppMethodBeat.o(67145);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(67145);
    }

    public int a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.i(67146);
        if (!this.b) {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
            AppMethodBeat.o(67146);
            return -1;
        } else if (this.c) {
            int writeFrame = writeFrame(this.a, b(byteBuffer, i3), i, i2, i3, i4, j);
            if (writeFrame != 0) {
                TXCLog.e("TXSWMuxerJNI", "Muxer write frame error!");
            }
            AppMethodBeat.o(67146);
            return writeFrame;
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
            AppMethodBeat.o(67146);
            return -1;
        }
    }

    public int a() {
        AppMethodBeat.i(67147);
        if (this.b) {
            int start = start(this.a);
            if (start == 0) {
                this.c = true;
            } else {
                TXCLog.e("TXSWMuxerJNI", "Start Muxer Error!!!");
            }
            AppMethodBeat.o(67147);
            return start;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(67147);
        return -1;
    }

    public int b() {
        int i = -1;
        AppMethodBeat.i(67148);
        if (!this.b) {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
            AppMethodBeat.o(67148);
        } else if (this.c) {
            this.c = false;
            i = stop(this.a);
            if (i != 0) {
                TXCLog.e("TXSWMuxerJNI", "Stop Muxer Error!!!");
            }
            AppMethodBeat.o(67148);
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
            AppMethodBeat.o(67148);
        }
        return i;
    }

    public void c() {
        AppMethodBeat.i(67149);
        if (this.b) {
            release(this.a);
            this.b = false;
            this.c = false;
            AppMethodBeat.o(67149);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(67149);
    }

    private byte[] b(ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(67150);
        if (byteBuffer == null) {
            AppMethodBeat.o(67150);
            return null;
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        AppMethodBeat.o(67150);
        return bArr;
    }
}
