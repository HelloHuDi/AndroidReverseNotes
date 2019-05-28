package com.tencent.ttpic.filter;

import android.annotation.TargetApi;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.ProgramTools;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(18)
public class TransformFeedback {
    private final String TAG = "TransformFeedback";
    private final String fragmentShaderCode = "#version 300 es \nprecision mediump float;\nout vec4 fragColor;\nvoid main() {\n  fragColor = vec4(1.0,1.0,1.0,1.0);\n}";
    private final int mProgram;
    private final String vertexShaderSrc = "#version 300 es \nin float inValue;\nout float outValue;\nvoid main() {\n    outValue = sqrt(inValue);\n}";

    public TransformFeedback() {
        AppMethodBeat.m2504i(83020);
        int loadShader = ProgramTools.loadShader(35633, "#version 300 es \nin float inValue;\nout float outValue;\nvoid main() {\n    outValue = sqrt(inValue);\n}");
        int loadShader2 = ProgramTools.loadShader(35632, "#version 300 es \nprecision mediump float;\nout vec4 fragColor;\nvoid main() {\n  fragColor = vec4(1.0,1.0,1.0,1.0);\n}");
        this.mProgram = GLES30.glCreateProgram();
        GLES30.glAttachShader(this.mProgram, loadShader);
        GLES30.glAttachShader(this.mProgram, loadShader2);
        GLES30.glTransformFeedbackVaryings(this.mProgram, new String[]{"outValue"}, 35980);
        GlUtil.checkGlError("TransformFeedback glTransformFeedbackVaryings");
        GLES30.glLinkProgram(this.mProgram);
        GLES30.glGetProgramiv(this.mProgram, 35714, new int[1], 0);
        GlUtil.checkGlError("TransformFeedback glLinkProgram");
        GLES30.glUseProgram(this.mProgram);
        GlUtil.checkGlError("TransformFeedback glUseProgram");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(20).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(new float[]{1.0f, 4.0f, 9.0f, 16.0f, 25.0f}).position(0);
        int[] iArr = new int[1];
        GLES30.glGenBuffers(1, iArr, 0);
        GLES30.glBindBuffer(34962, iArr[0]);
        GLES30.glBufferData(34962, 20, asFloatBuffer, 35045);
        GlUtil.checkGlError("TransformFeedback glBufferData GL_ARRAY_BUFFER");
        int glGetAttribLocation = GLES30.glGetAttribLocation(this.mProgram, "inValue");
        GLES30.glEnableVertexAttribArray(glGetAttribLocation);
        GLES30.glVertexAttribPointer(glGetAttribLocation, 1, 5126, false, 4, 0);
        GlUtil.checkGlError("TransformFeedback glVertexAttribPointer");
        int[] iArr2 = new int[1];
        GLES30.glGenBuffers(1, iArr2, 0);
        GLES30.glBindBuffer(35982, iArr2[0]);
        GLES30.glBufferData(35982, 20, null, 35045);
        GLES30.glBindBufferBase(35982, 0, iArr2[0]);
        GlUtil.checkGlError("TransformFeedback glBindBufferBase");
        GLES30.glEnable(35977);
        GLES30.glBeginTransformFeedback(0);
        GLES30.glDrawArrays(0, 0, 5);
        GlUtil.checkGlError("TransformFeedback glDrawArrays");
        GLES30.glEndTransformFeedback();
        GLES30.glDisable(35977);
        GLES30.glFlush();
        GlUtil.checkGlError("TransformFeedback pre-glMapBufferRange ");
        Buffer glMapBufferRange = GLES30.glMapBufferRange(35982, 0, 20, 1);
        GlUtil.checkGlError("TransformFeedback glMapBufferRange");
        if (glMapBufferRange != null) {
            ByteBuffer byteBuffer = (ByteBuffer) glMapBufferRange;
            byteBuffer.order(ByteOrder.nativeOrder());
            asFloatBuffer = byteBuffer.asFloatBuffer();
            String.format("output values = %f %f %f %f %f\n", new Object[]{Float.valueOf(asFloatBuffer.get()), Float.valueOf(asFloatBuffer.get()), Float.valueOf(asFloatBuffer.get()), Float.valueOf(asFloatBuffer.get()), Float.valueOf(asFloatBuffer.get())});
        }
        GLES30.glUnmapBuffer(35982);
        GLES30.glDeleteProgram(this.mProgram);
        GLES30.glDeleteShader(loadShader);
        GLES30.glDeleteShader(loadShader2);
        GLES30.glDeleteBuffers(1, iArr2, 0);
        GLES30.glDeleteBuffers(1, iArr, 0);
        AppMethodBeat.m2505o(83020);
    }
}
