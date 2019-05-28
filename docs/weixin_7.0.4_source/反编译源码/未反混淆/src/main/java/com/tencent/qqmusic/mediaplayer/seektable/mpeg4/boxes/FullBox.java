package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public abstract class FullBox extends Box {
    int flags;
    int version;

    public void parse(Parsable parsable, Box box) {
        super.parse(parsable, box);
        byte[] bArr = new byte[4];
        parsable.readBytes(bArr, 0, 4);
        this.version = bArr[0] & 255;
        this.flags = (bArr[3] & 255) | (((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8));
    }

    public int getVersion() {
        return this.version;
    }

    public int getFlags() {
        return this.flags;
    }
}
