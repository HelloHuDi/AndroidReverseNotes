package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

class TrackPositionDataSource {
    private final IDataSource mDataSource;
    private long mPosition = 0;

    TrackPositionDataSource(IDataSource iDataSource) {
        this.mDataSource = iDataSource;
    }

    public int read(byte[] bArr, int i) {
        AppMethodBeat.i(128504);
        int readAt = this.mDataSource.readAt(this.mPosition, bArr, 0, i);
        this.mPosition += (long) readAt;
        AppMethodBeat.o(128504);
        return readAt;
    }

    public long seek(long j) {
        AppMethodBeat.i(128505);
        if (j < this.mDataSource.getSize()) {
            this.mPosition = j;
        } else {
            j = -1;
        }
        AppMethodBeat.o(128505);
        return j;
    }

    public long getSize() {
        AppMethodBeat.i(128506);
        long size = this.mDataSource.getSize();
        AppMethodBeat.o(128506);
        return size;
    }

    public long getCurPosition() {
        return this.mPosition;
    }
}
