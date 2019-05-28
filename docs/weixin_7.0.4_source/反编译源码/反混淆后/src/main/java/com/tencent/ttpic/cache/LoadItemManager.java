package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface LoadItemManager {

    public enum LOAD_TYPE {
        LOAD_ALL,
        LOAD_PRE;

        static {
            AppMethodBeat.m2505o(81807);
        }
    }

    void clear();

    ETC1Texture loadETCAlphaTexture(int i);

    ETC1Texture loadETCRGBTexture(int i);

    Bitmap loadImage(int i);

    Bitmap loadImage(String str);

    void prepareImages();

    void reset();
}
