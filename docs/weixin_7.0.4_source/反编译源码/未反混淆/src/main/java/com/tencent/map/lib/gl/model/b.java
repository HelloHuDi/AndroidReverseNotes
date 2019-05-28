package com.tencent.map.lib.gl.model;

import android.opengl.Matrix;
import com.tencent.map.lib.gl.a;
import com.tencent.tencentmap.mapsdk.maps.a.hd;
import com.tencent.tencentmap.mapsdk.maps.a.he;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public abstract class b {
    protected static final int TEXTURE_NOT_EXIST = 0;
    private short[] mIndices;
    private ShortBuffer mIndicesBuffer;
    protected float[] mModelMatrix = new float[16];
    private FloatBuffer mTextureBuffer;
    protected f mVertexList;
    private FloatBuffer mVerticesBuffer;

    public b() {
        Matrix.setIdentityM(this.mModelMatrix, 0);
    }

    public void drawMesh(GL10 gl10, float[] fArr, float[] fArr2) {
        gl10.glVertexPointer(3, 5126, 0, this.mVerticesBuffer);
        gl10.glColor4f(fArr[0], fArr[1], fArr[2], fArr[3]);
        gl10.glDrawElements(4, this.mIndicesBuffer.capacity(), 5123, this.mIndicesBuffer);
        gl10.glColor4f(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        gl10.glDrawElements(1, this.mIndicesBuffer.capacity(), 5123, this.mIndicesBuffer);
    }

    public boolean testHint(float f, float f2, float[] fArr, float[] fArr2, int[] iArr) {
        for (int i = 0; i < this.mIndices.length / 3; i++) {
            int i2 = i * 3;
            int i3 = this.mIndices[i2];
            int i4 = this.mIndices[i2 + 1];
            i2 = this.mIndices[i2 + 2];
            e a = this.mVertexList.a(i3).a(fArr);
            e a2 = this.mVertexList.a(i4).a(fArr);
            e a3 = this.mVertexList.a(i2).a(fArr);
            if (a.c > 0.0f && a2.c > 0.0f && a3.c > 0.0f) {
                return false;
            }
            if (hd.a(f, f2, new c(a, a2, a3).a(), fArr2, iArr)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void drawWithTexture(GL10 gl10, int i) {
        drawWithTextureImpl(gl10, i, 3);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void drawWithTextureImpl(GL10 gl10, int i, int i2) {
        if (!(this.mVerticesBuffer == null || this.mIndicesBuffer == null)) {
            gl10.glVertexPointer(i2, 5126, 0, this.mVerticesBuffer);
            if (i != 0) {
                gl10.glEnable(3553);
                gl10.glTexCoordPointer(2, 5126, 0, this.mTextureBuffer);
                gl10.glBindTexture(3553, i);
                gl10.glDrawElements(4, this.mIndicesBuffer.capacity(), 5123, this.mIndicesBuffer);
                gl10.glDisable(3553);
            } else {
                gl10.glDrawElements(4, this.mIndicesBuffer.capacity(), 5123, this.mIndicesBuffer);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void loadIdentity(GL10 gl10) {
        gl10.glLoadIdentity();
        Matrix.setIdentityM(this.mModelMatrix, 0);
    }

    /* Access modifiers changed, original: protected */
    public void translatef(GL10 gl10, float f, float f2, float f3) {
        gl10.glTranslatef(f, f2, f3);
        Matrix.translateM(this.mModelMatrix, 0, f, f2, f3);
    }

    /* Access modifiers changed, original: protected */
    public void rotatef(GL10 gl10, float f, int i, int i2, int i3) {
        gl10.glRotatef(f, (float) i, (float) i2, (float) i3);
        Matrix.rotateM(this.mModelMatrix, 0, f, (float) i, (float) i2, (float) i3);
    }

    /* Access modifiers changed, original: protected */
    public void scalef(GL10 gl10, float f, float f2, float f3) {
        gl10.glScalef(f, f2, f3);
        Matrix.scaleM(this.mModelMatrix, 0, f, f2, f3);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void setVertices(float[] fArr) {
        this.mVertexList = new f();
        int i = 0;
        while (i < fArr.length) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            i = i3 + 1;
            this.mVertexList.a(new e(fArr[i], fArr[i2], fArr[i3]));
        }
        this.mVerticesBuffer = a.a(fArr, this.mVerticesBuffer);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void setIndices(short[] sArr) {
        this.mIndices = sArr;
        this.mIndicesBuffer = a.a(sArr, this.mIndicesBuffer);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void setTextureCoordinates(float[] fArr) {
        this.mTextureBuffer = a.a(fArr, this.mTextureBuffer);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void setVerticesBuffer(FloatBuffer floatBuffer) {
        this.mVertexList = new f();
        int i = 0;
        while (i < floatBuffer.limit()) {
            int i2 = i + 1;
            float f = floatBuffer.get(i);
            i = i2 + 1;
            this.mVertexList.a(new e(f, floatBuffer.get(i2), 0.0f));
        }
        this.mVerticesBuffer = floatBuffer;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void setTextureBuffer(FloatBuffer floatBuffer) {
        this.mTextureBuffer = floatBuffer;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void setIndicesBuffer(ShortBuffer shortBuffer) {
        this.mIndicesBuffer = shortBuffer;
    }

    /* Access modifiers changed, original: protected */
    public boolean isVisibility(float[][] fArr) {
        return he.a(fArr, this.mVertexList.a());
    }

    /* Access modifiers changed, original: protected */
    public boolean isVisibility(float[] fArr, float[] fArr2) {
        return he.a(he.a(fArr, fArr2), this.mVertexList.a());
    }
}
