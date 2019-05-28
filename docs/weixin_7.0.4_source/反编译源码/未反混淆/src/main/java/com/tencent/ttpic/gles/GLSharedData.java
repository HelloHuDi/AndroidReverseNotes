package com.tencent.ttpic.gles;

import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GLSharedData {
    public EGLContext mSharedContext;
    public TextureDataPipe[] mTexturePile = new TextureDataPipe[2];

    public GLSharedData(EGLContext eGLContext) {
        AppMethodBeat.i(83236);
        this.mSharedContext = eGLContext;
        this.mTexturePile[0] = new TextureDataPipe();
        this.mTexturePile[1] = new TextureDataPipe();
        AppMethodBeat.o(83236);
    }

    public TextureDataPipe getCurrentTexturePile() {
        int i;
        AppMethodBeat.i(83237);
        int i2 = this.mTexturePile[0].getTexureCurrentStatus() == 2 ? 1 : 0;
        if (this.mTexturePile[1].getTexureCurrentStatus() == 2) {
            i = 1;
        } else {
            i = 0;
        }
        TextureDataPipe textureDataPipe = (i2 == 0 || i == 0) ? i2 != 0 ? this.mTexturePile[0] : i != 0 ? this.mTexturePile[1] : null : this.mTexturePile[0].mTimestamp < this.mTexturePile[1].mTimestamp ? this.mTexturePile[0] : this.mTexturePile[1];
        AppMethodBeat.o(83237);
        return textureDataPipe;
    }

    public TextureDataPipe getFreeTexturePileMakeBusy() {
        TextureDataPipe textureDataPipe;
        AppMethodBeat.i(83238);
        for (int i = 0; i < this.mTexturePile.length; i++) {
            if (this.mTexturePile[i].getTexureCurrentStatus() == 0) {
                textureDataPipe = this.mTexturePile[i];
                textureDataPipe.makeBusy();
                break;
            }
        }
        textureDataPipe = null;
        AppMethodBeat.o(83238);
        return textureDataPipe;
    }

    public boolean judgeBrotherTextureIsReady(TextureDataPipe textureDataPipe) {
        AppMethodBeat.i(83239);
        TextureDataPipe textureDataPipe2 = this.mTexturePile[0];
        if (this.mTexturePile[0] == textureDataPipe) {
            textureDataPipe2 = this.mTexturePile[1];
        }
        if (textureDataPipe2.getTexureCurrentStatus() == 2) {
            AppMethodBeat.o(83239);
            return true;
        }
        AppMethodBeat.o(83239);
        return false;
    }

    public void clear() {
        AppMethodBeat.i(83240);
        for (TextureDataPipe release : this.mTexturePile) {
            release.release();
        }
        AppMethodBeat.o(83240);
    }
}
