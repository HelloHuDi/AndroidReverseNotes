package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class TracerDataSource implements IDataSource {
    private static final String TAG = "TracerDataSource";
    private final IDataSource impl;

    public TracerDataSource(IDataSource iDataSource) {
        this.impl = iDataSource;
    }

    public void open() {
        AppMethodBeat.i(104583);
        try {
            this.impl.open();
            AppMethodBeat.o(104583);
        } catch (Throwable th) {
            Logger.e(TAG, "[open] failed!", th);
            AppMethodBeat.o(104583);
        }
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(104584);
        try {
            int readAt = this.impl.readAt(j, bArr, i, i2);
            AppMethodBeat.o(104584);
            return readAt;
        } catch (Throwable th) {
            Logger.e(TAG, "[readAt] failed! pos = " + j + ", offset = " + i + ", size = " + i2, th);
            AppMethodBeat.o(104584);
        }
    }

    public long getSize() {
        AppMethodBeat.i(104585);
        try {
            long size = this.impl.getSize();
            AppMethodBeat.o(104585);
            return size;
        } catch (Throwable th) {
            Logger.e(TAG, "[getSize] failed!", th);
            AppMethodBeat.o(104585);
        }
    }

    public AudioType getAudioType() {
        AppMethodBeat.i(104586);
        try {
            AudioType audioType = this.impl.getAudioType();
            AppMethodBeat.o(104586);
            return audioType;
        } catch (Throwable th) {
            Logger.e(TAG, "[getAudioType] failed!", th);
            AppMethodBeat.o(104586);
        }
    }

    public void close() {
        AppMethodBeat.i(104587);
        try {
            this.impl.close();
            AppMethodBeat.o(104587);
        } catch (Throwable th) {
            Logger.e(TAG, "[close] failed!", th);
            AppMethodBeat.o(104587);
        }
    }

    public String toString() {
        AppMethodBeat.i(104588);
        String obj = this.impl.toString();
        AppMethodBeat.o(104588);
        return obj;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(104589);
        boolean equals = this.impl.equals(obj);
        AppMethodBeat.o(104589);
        return equals;
    }

    public int hashCode() {
        AppMethodBeat.i(104590);
        int hashCode = this.impl.hashCode();
        AppMethodBeat.o(104590);
        return hashCode;
    }
}
