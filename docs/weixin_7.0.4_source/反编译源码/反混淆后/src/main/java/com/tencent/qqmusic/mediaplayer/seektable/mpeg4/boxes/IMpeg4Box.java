package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public interface IMpeg4Box {
    long getSize();

    String getType();

    void parse(Parsable parsable, Box box);
}
