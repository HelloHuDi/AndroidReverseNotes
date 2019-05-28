package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FloatBufferInfo {
    public int bufferSize;
    public float[] floatBuffer;
    public float[] tempFloatBuffer;

    public void setFloatBufferCapacity(int i) {
        if (this.floatBuffer == null || this.floatBuffer.length < i) {
            this.floatBuffer = new float[i];
        }
    }

    public void setTempFloatBufferCapacity(int i) {
        if (this.tempFloatBuffer == null || this.tempFloatBuffer.length < i) {
            this.tempFloatBuffer = new float[i];
        }
    }

    public void appendFloat(float[] fArr, int i, int i2) {
        AppMethodBeat.m2504i(111096);
        if (fArr != null && i >= 0 && i2 > 0 && i + i2 <= fArr.length) {
            setFloatBufferCapacity(this.bufferSize + i2);
            System.arraycopy(fArr, i, this.floatBuffer, this.bufferSize, i2);
        }
        AppMethodBeat.m2505o(111096);
    }

    public void fillFloat(float[] fArr, int i) {
        if (fArr != null && i > 0 && i <= fArr.length) {
            this.floatBuffer = fArr;
            this.bufferSize = i;
        }
    }

    public FloatBufferInfo copy(FloatBufferInfo floatBufferInfo) {
        floatBufferInfo.bufferSize = this.bufferSize;
        floatBufferInfo.floatBuffer = this.floatBuffer;
        floatBufferInfo.tempFloatBuffer = this.tempFloatBuffer;
        return floatBufferInfo;
    }
}
