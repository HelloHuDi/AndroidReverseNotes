package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class NativeSeekTable implements SeekTable {
    private final BaseDecoder nativeDecoder;

    public NativeSeekTable(BaseDecoder baseDecoder) {
        this.nativeDecoder = baseDecoder;
    }

    public void parse(IDataSource iDataSource) {
    }

    public long seek(long j) {
        AppMethodBeat.i(128507);
        long bytePositionOfTime = this.nativeDecoder.getBytePositionOfTime(j);
        AppMethodBeat.o(128507);
        return bytePositionOfTime;
    }
}
