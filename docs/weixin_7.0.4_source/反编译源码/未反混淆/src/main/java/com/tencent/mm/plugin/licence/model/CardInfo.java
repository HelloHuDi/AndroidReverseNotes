package com.tencent.mm.plugin.licence.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CardInfo {
    public byte[] bitmapData;
    public int bitmapLen = 0;
    public int height = 0;
    public int width = 0;

    public CardInfo(int i, int i2) {
        AppMethodBeat.i(72865);
        this.bitmapData = new byte[(((((int) (0.8d * ((double) i))) * ((int) (0.52d * ((double) i)))) * 3) + 54)];
        AppMethodBeat.o(72865);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getSize() {
        return this.bitmapLen;
    }

    public byte[] getData() {
        return this.bitmapData;
    }
}
