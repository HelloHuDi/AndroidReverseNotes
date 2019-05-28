package com.tencent.ttpic.filter;

import android.annotation.TargetApi;
import android.opengl.GLES31;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.ProgramTools;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(21)
public class ComputerFilter {
    private static final String COMPUTE_SHADER = "#version 320 es\nlayout(local_size_x = 8) in;\nlayout(binding = 0) readonly buffer Input0 {\n    float data[];\n} input0;\nlayout(binding = 1) readonly buffer Input1 {\n    float data[];\n} input1;\nlayout(binding = 2) writeonly buffer Output {\n    float data[];\n} output0;\nvoid main()\n{\n    uint idx = gl_GlobalInvocationID.x;\n    float f = input0.data[idx] + input1.data[idx];    output0.data[idx] = f;\n}\n";
    private static final String TAG = ComputerFilter.class.getSimpleName();

    static {
        AppMethodBeat.i(82118);
        AppMethodBeat.o(82118);
    }

    public void init() {
        int i;
        AppMethodBeat.i(82117);
        int createComputeProgram = ProgramTools.createComputeProgram(COMPUTE_SHADER);
        float[] fArr = new float[TXRecordCommon.AUDIO_SAMPLERATE_8000];
        float[] fArr2 = new float[TXRecordCommon.AUDIO_SAMPLERATE_8000];
        float[] fArr3 = new float[TXRecordCommon.AUDIO_SAMPLERATE_8000];
        for (i = 0; i < TXRecordCommon.AUDIO_SAMPLERATE_8000; i++) {
            fArr[i] = (float) i;
            fArr2[i] = (float) i;
        }
        int[] iArr = new int[3];
        GLES31.glGenBuffers(3, iArr, 0);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        BenchUtil.benchStart("setupSSBufferObject cpu");
        for (i = 0; i < TXRecordCommon.AUDIO_SAMPLERATE_8000; i++) {
            fArr3[i] = fArr[i] + fArr2[i];
        }
        BenchUtil.benchEnd("setupSSBufferObject cpu");
        BenchUtil.benchStart("setupSSBufferObject gpu");
        ProgramTools.setupSSBufferObject(i2, 0, fArr, TXRecordCommon.AUDIO_SAMPLERATE_8000);
        ProgramTools.setupSSBufferObject(i3, 1, fArr2, TXRecordCommon.AUDIO_SAMPLERATE_8000);
        ProgramTools.setupSSBufferObject(i4, 2, null, TXRecordCommon.AUDIO_SAMPLERATE_8000);
        GLES31.glUseProgram(createComputeProgram);
        GLES31.glDispatchCompute(1000, 1, 1);
        GLES31.glMemoryBarrier(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        GLES31.glFinish();
        GlUtil.checkGlError(TAG + " pre-glMapBufferRange ");
        BenchUtil.benchEnd("setupSSBufferObject gpu");
        GLES31.glBindBuffer(37074, i4);
        ByteBuffer byteBuffer = (ByteBuffer) GLES31.glMapBufferRange(37074, 0, TXRecordCommon.AUDIO_SAMPLERATE_32000, 1);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = byteBuffer.asFloatBuffer();
        fArr3 = new float[asFloatBuffer.remaining()];
        asFloatBuffer.get(fArr3);
        for (i = 0; i < TXRecordCommon.AUDIO_SAMPLERATE_8000; i++) {
            if (((double) Math.abs(fArr3[i] - (fArr[i] + fArr2[i]))) > 1.0E-4d) {
                GLES31.glUnmapBuffer(37074);
                AppMethodBeat.o(82117);
                return;
            }
        }
        GLES31.glUnmapBuffer(37074);
        GLES31.glDeleteProgram(createComputeProgram);
        AppMethodBeat.o(82117);
    }
}
