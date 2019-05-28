package com.tencent.ttpic.glmodel;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.util.Maths;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class Sphere {
    private static final int AMOUNT_OF_NUMBERS_PER_TEXTURE_POINT = 2;
    private static final int AMOUNT_OF_NUMBERS_PER_VERTEX_POINT = 3;
    private static final int MAXIMUM_ALLOWED_DEPTH = 5;
    private static final int NUM_FLOATS_PER_TEXTURE = 2;
    private static final int NUM_FLOATS_PER_VERTEX = 3;
    private static final int PER_FLOAT_BYTE = 4;
    private static final int VERTEX_MAGIC_NUMBER = 5;
    private final List<FloatBuffer> mColorBuffer = new ArrayList();
    private final List<float[]> mColors = new ArrayList();
    private final List<FloatBuffer> mTextureBuffer = new ArrayList();
    private final int[] mTextures = new int[1];
    private final int mTotalNumStrips;
    private final List<FloatBuffer> mVertexBuffer = new ArrayList();
    private final List<float[]> mVertices = new ArrayList();

    public Sphere(int i, float f) {
        AppMethodBeat.i(83268);
        int max = Math.max(1, Math.min(5, i));
        this.mTotalNumStrips = Maths.power(2, max - 1) * 5;
        int power = Maths.power(2, max) * 3;
        double power2 = 2.0943951023931953d / ((double) Maths.power(2, max));
        double d = 6.283185307179586d / ((double) this.mTotalNumStrips);
        ArrayList arrayList = new ArrayList();
        max = 0;
        while (true) {
            int i2 = max;
            if (i2 < this.mTotalNumStrips) {
                Object obj = new float[(power * 3)];
                Object obj2 = new float[(power * 2)];
                Object obj3 = new float[(power * 3)];
                int i3 = 0;
                int i4 = 0;
                double d2 = 1.5707963267948966d;
                double d3 = ((double) i2) * d;
                for (max = 0; max < power; max += 2) {
                    double sin = ((double) f) * Math.sin(d2);
                    double cos = ((double) f) * Math.cos(d2);
                    double sin2 = Math.sin(d3) * cos;
                    cos *= Math.cos(d3);
                    obj3[i3] = (1.0f / ((float) this.mTotalNumStrips)) * ((float) i2);
                    int i5 = i3 + 1;
                    obj[i3] = (float) cos;
                    obj3[i5] = (1.0f / ((float) this.mTotalNumStrips)) * ((float) i2);
                    i3 = i5 + 1;
                    obj[i5] = (float) sin;
                    obj3[i3] = (1.0f / ((float) this.mTotalNumStrips)) * ((float) i2);
                    i5 = i3 + 1;
                    obj[i3] = (float) sin2;
                    i3 = i4 + 1;
                    obj2[i4] = (float) (1.0d - (d3 / 6.283185307179586d));
                    i4 = i3 + 1;
                    obj2[i3] = (float) (1.0d - ((1.5707963267948966d + d2) / 3.141592653589793d));
                    d2 -= power2;
                    d3 -= d / 2.0d;
                    sin = ((double) f) * Math.sin(d2);
                    cos = ((double) f) * Math.cos(d2);
                    sin2 = Math.sin(d3) * cos;
                    cos *= Math.cos(d3);
                    obj3[i5] = (1.0f / ((float) this.mTotalNumStrips)) * ((float) i2);
                    i3 = i5 + 1;
                    obj[i5] = (float) cos;
                    obj3[i3] = (1.0f / ((float) this.mTotalNumStrips)) * ((float) i2);
                    i5 = i3 + 1;
                    obj[i3] = (float) sin;
                    obj3[i5] = (1.0f / ((float) this.mTotalNumStrips)) * ((float) i2);
                    i3 = i5 + 1;
                    obj[i5] = (float) sin2;
                    i5 = i4 + 1;
                    obj2[i4] = (float) (1.0d - (d3 / 6.283185307179586d));
                    i4 = i5 + 1;
                    obj2[i5] = (float) (1.0d - ((1.5707963267948966d + d2) / 3.141592653589793d));
                    d3 += d;
                }
                this.mVertices.add(obj);
                this.mColors.add(obj3);
                arrayList.add(obj2);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect((power * 3) * 32);
                allocateDirect.order(ByteOrder.nativeOrder());
                FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                asFloatBuffer.put((float[]) this.mVertices.get(i2));
                asFloatBuffer.position(0);
                this.mVertexBuffer.add(asFloatBuffer);
                allocateDirect = ByteBuffer.allocateDirect((power * 3) * 32);
                allocateDirect.order(ByteOrder.nativeOrder());
                asFloatBuffer = allocateDirect.asFloatBuffer();
                asFloatBuffer.put((float[]) this.mColors.get(i2));
                asFloatBuffer.position(0);
                this.mColorBuffer.add(asFloatBuffer);
                allocateDirect = ByteBuffer.allocateDirect((power * 2) * 32);
                allocateDirect.order(ByteOrder.nativeOrder());
                asFloatBuffer = allocateDirect.asFloatBuffer();
                asFloatBuffer.put((float[]) arrayList.get(i2));
                asFloatBuffer.position(0);
                this.mTextureBuffer.add(asFloatBuffer);
                max = i2 + 1;
            } else {
                AppMethodBeat.o(83268);
                return;
            }
        }
    }

    public void draw(GL10 gl10) {
        AppMethodBeat.i(83269);
        gl10.glBindTexture(3553, this.mTextures[0]);
        gl10.glEnableClientState(32884);
        gl10.glEnableClientState(32888);
        gl10.glFrontFace(2304);
        for (int i = 0; i < this.mTotalNumStrips; i++) {
            gl10.glVertexPointer(3, 5126, 0, (Buffer) this.mVertexBuffer.get(i));
            gl10.glTexCoordPointer(2, 5126, 0, (Buffer) this.mTextureBuffer.get(i));
            gl10.glDrawArrays(5, 0, ((float[]) this.mVertices.get(i)).length / 3);
        }
        gl10.glDisableClientState(32884);
        gl10.glDisableClientState(32888);
        AppMethodBeat.o(83269);
    }

    public void loadGLTexture(Bitmap bitmap) {
        AppMethodBeat.i(83270);
        if (this.mTextures[0] <= 0) {
            GLES20.glGenTextures(1, this.mTextures, 0);
        }
        if (BitmapUtils.isLegal(bitmap)) {
            GLES20.glBindTexture(3553, this.mTextures[0]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        AppMethodBeat.o(83270);
    }

    public void draw(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(83271);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.mTextures[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(i4, 0);
        GLES20.glEnableVertexAttribArray(i);
        GLES20.glEnableVertexAttribArray(i2);
        GLES20.glFrontFace(2304);
        for (int i5 = 0; i5 < this.mTotalNumStrips; i5++) {
            GLES20.glVertexAttribPointer(i, 3, 5126, false, 12, (Buffer) this.mVertexBuffer.get(i5));
            GLES20.glVertexAttribPointer(i3, 2, 5126, false, 8, (Buffer) this.mColorBuffer.get(i5));
            GLES20.glVertexAttribPointer(i2, 2, 5126, false, 8, (Buffer) this.mTextureBuffer.get(i5));
            GLES20.glDrawArrays(5, 0, ((float[]) this.mVertices.get(i5)).length / 3);
        }
        GLES20.glFinish();
        AppMethodBeat.o(83271);
    }
}
