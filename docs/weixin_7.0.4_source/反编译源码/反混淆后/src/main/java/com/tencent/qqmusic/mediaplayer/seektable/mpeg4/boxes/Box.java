package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import java.nio.charset.Charset;
import java.util.Arrays;

public abstract class Box implements IMpeg4Box {
    private long largeSize;
    private int size;
    private byte[] type;
    private byte[] userType;

    public void parse(Parsable parsable, Box box) {
        if (box == null) {
            this.size = parsable.readInt();
            this.type = new byte[4];
            parsable.readBytes(this.type, 0, this.type.length);
            if (this.size == 1) {
                this.largeSize = parsable.readLong();
                if (this.largeSize == 0) {
                    throw new InvalidBoxException("invalid [" + getType() + "]: largeSize is 0!");
                }
            } else if (this.size == 0) {
                this.largeSize = parsable.available();
            } else if (this.size < 8) {
                throw new InvalidBoxException("invalid [" + getType() + "]: size is less than 8!");
            }
            if (Arrays.equals(this.type, "uuid".getBytes())) {
                this.userType = new byte[16];
                parsable.readBytes(this.userType, 0, this.userType.length);
                return;
            }
            return;
        }
        this.size = box.size;
        this.type = box.type;
        this.largeSize = box.largeSize;
        this.userType = box.userType;
    }

    public final long getSize() {
        if (this.largeSize != 0) {
            return this.largeSize;
        }
        return (long) this.size;
    }

    public final String getType() {
        return new String(this.type, Charset.defaultCharset());
    }
}
