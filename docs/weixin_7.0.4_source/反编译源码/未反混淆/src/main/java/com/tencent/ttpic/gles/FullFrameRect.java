package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.Drawable2d.Prefab;

public class FullFrameRect {
    private Texture2dProgram mProgram;
    private final Drawable2d mRectDrawable = new Drawable2d(Prefab.FULL_RECTANGLE);

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        AppMethodBeat.i(49985);
        this.mProgram = texture2dProgram;
        AppMethodBeat.o(49985);
    }

    public void release(boolean z) {
        AppMethodBeat.i(49986);
        if (this.mProgram != null) {
            if (z) {
                this.mProgram.release();
            }
            this.mProgram = null;
        }
        AppMethodBeat.o(49986);
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        AppMethodBeat.i(49987);
        this.mProgram.release();
        this.mProgram = texture2dProgram;
        AppMethodBeat.o(49987);
    }

    public int createTextureObject() {
        AppMethodBeat.i(49988);
        int createTextureObject = this.mProgram.createTextureObject();
        AppMethodBeat.o(49988);
        return createTextureObject;
    }

    public void drawFrame(int i, float[] fArr) {
        AppMethodBeat.i(49989);
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride());
        AppMethodBeat.o(49989);
    }
}
