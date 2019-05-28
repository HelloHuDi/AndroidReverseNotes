package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public interface SeekTable {
    void parse(IDataSource iDataSource);

    long seek(long j);
}
