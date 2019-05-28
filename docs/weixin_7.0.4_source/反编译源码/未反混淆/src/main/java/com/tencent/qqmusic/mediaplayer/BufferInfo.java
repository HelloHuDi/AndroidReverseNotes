package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BufferInfo {
    public int bufferSize;
    public byte[] byteBuffer;
    public byte[] tempByteBuffer;

    public void setByteBufferCapacity(int i) {
        if (this.byteBuffer == null || this.byteBuffer.length < i) {
            this.byteBuffer = new byte[i];
        }
    }

    public void setTempByteBufferCapacity(int i) {
        if (this.tempByteBuffer == null || this.tempByteBuffer.length < i) {
            this.tempByteBuffer = new byte[i];
        }
    }

    public void appendByte(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(111089);
        if (bArr != null && i >= 0 && i2 > 0 && i + i2 <= bArr.length) {
            setByteBufferCapacity(this.bufferSize + i2);
            System.arraycopy(bArr, i, this.byteBuffer, this.bufferSize, i2);
        }
        AppMethodBeat.o(111089);
    }

    public void fillByte(byte[] bArr, int i) {
        if (bArr != null && i > 0 && i <= bArr.length) {
            this.byteBuffer = bArr;
            this.bufferSize = i;
        }
    }

    public BufferInfo copy(BufferInfo bufferInfo) {
        bufferInfo.bufferSize = this.bufferSize;
        bufferInfo.byteBuffer = this.byteBuffer;
        bufferInfo.tempByteBuffer = this.tempByteBuffer;
        return bufferInfo;
    }
}
