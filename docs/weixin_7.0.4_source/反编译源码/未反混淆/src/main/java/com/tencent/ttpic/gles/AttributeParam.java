package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class AttributeParam {
    private static final int PER_FLOAT_BYTE = 4;
    private FloatBuffer buffer;
    private int[] glBuffer;
    public int handle;
    public String name;
    public int perVertexFloat;
    private boolean update;
    private boolean useVBO;
    public float[] vertices;

    public AttributeParam(String str, float[] fArr) {
        this(str, fArr, false);
    }

    public AttributeParam(String str, float[] fArr, boolean z) {
        this(str, fArr, 2, z);
    }

    public AttributeParam(String str, float[] fArr, int i) {
        this(str, fArr, i, false);
    }

    public AttributeParam(String str, float[] fArr, int i, boolean z) {
        this.name = str;
        this.vertices = fArr;
        this.handle = -1;
        this.perVertexFloat = i;
        this.useVBO = z;
    }

    public void initialParams(int i) {
        AppMethodBeat.i(49945);
        this.handle = GLES20.glGetAttribLocation(i, this.name);
        AppMethodBeat.o(49945);
    }

    public void setParams(int i) {
        AppMethodBeat.i(49946);
        if (this.vertices == null) {
            AppMethodBeat.o(49946);
            return;
        }
        if (this.buffer == null || this.buffer.capacity() < this.vertices.length) {
            this.buffer = ByteBuffer.allocateDirect(this.vertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        if (this.useVBO && this.glBuffer == null) {
            this.glBuffer = new int[1];
            GLES20.glGenBuffers(this.glBuffer.length, this.glBuffer, 0);
        }
        if (this.update) {
            this.buffer.put(this.vertices).position(0);
            if (this.glBuffer != null) {
                GLES20.glBindBuffer(34962, this.glBuffer[0]);
                GLES20.glBufferData(34962, this.buffer.capacity() * 4, this.buffer, 35044);
            }
            this.update = false;
        }
        if (!this.useVBO || this.glBuffer == null) {
            GLES20.glEnableVertexAttribArray(this.handle);
            GLES20.glVertexAttribPointer(this.handle, this.perVertexFloat, 5126, false, this.perVertexFloat * 4, this.buffer);
            AppMethodBeat.o(49946);
            return;
        }
        GLES20.glBindBuffer(34962, this.glBuffer[0]);
        GLES20.glEnableVertexAttribArray(this.handle);
        GLES20.glVertexAttribPointer(this.handle, this.perVertexFloat, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, 0);
        AppMethodBeat.o(49946);
    }

    public void clear() {
        AppMethodBeat.i(49947);
        this.vertices = null;
        this.buffer = null;
        if (this.glBuffer != null) {
            GLES20.glDeleteBuffers(this.glBuffer.length, this.glBuffer, 0);
        }
        AppMethodBeat.o(49947);
    }

    public void setVertices(float[] fArr) {
        this.vertices = fArr;
        this.update = true;
    }

    public void setUseVBO(boolean z) {
        this.useVBO = z;
    }
}
