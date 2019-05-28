package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public class Drawable2d {
    private static final FloatBuffer FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_COORDS);
    private static final float[] FULL_RECTANGLE_COORDS = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    private static final float[] FULL_RECTANGLE_TEX_COORDS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer RECTANGLE_BUF = GlUtil.createFloatBuffer(RECTANGLE_COORDS);
    private static final float[] RECTANGLE_COORDS = new float[]{-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
    private static final FloatBuffer RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
    private static final float[] RECTANGLE_TEX_COORDS = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final int SIZEOF_FLOAT = 4;
    private static final FloatBuffer TRIANGLE_BUF = GlUtil.createFloatBuffer(TRIANGLE_COORDS);
    private static final float[] TRIANGLE_COORDS = new float[]{0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
    private static final FloatBuffer TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
    private static final float[] TRIANGLE_TEX_COORDS = new float[]{0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private int mCoordsPerVertex;
    private Prefab mPrefab;
    private FloatBuffer mTexCoordArray;
    private int mTexCoordStride;
    private FloatBuffer mVertexArray;
    private int mVertexCount;
    private int mVertexStride;

    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE;

        static {
            AppMethodBeat.o(49951);
        }
    }

    static {
        AppMethodBeat.i(49954);
        AppMethodBeat.o(49954);
    }

    public Drawable2d(Prefab prefab) {
        AppMethodBeat.i(49952);
        switch (prefab) {
            case TRIANGLE:
                this.mVertexArray = TRIANGLE_BUF;
                this.mTexCoordArray = TRIANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = TRIANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case RECTANGLE:
                this.mVertexArray = RECTANGLE_BUF;
                this.mTexCoordArray = RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case FULL_RECTANGLE:
                this.mVertexArray = FULL_RECTANGLE_BUF;
                this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = FULL_RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            default:
                RuntimeException runtimeException = new RuntimeException("Unknown shape ".concat(String.valueOf(prefab)));
                AppMethodBeat.o(49952);
                throw runtimeException;
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
        AppMethodBeat.o(49952);
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public String toString() {
        AppMethodBeat.i(49953);
        String str;
        if (this.mPrefab != null) {
            str = "[Drawable2d: " + this.mPrefab + "]";
            AppMethodBeat.o(49953);
            return str;
        }
        str = "[Drawable2d: ...]";
        AppMethodBeat.o(49953);
        return str;
    }
}
