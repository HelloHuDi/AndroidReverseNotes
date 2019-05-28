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
        AppMethodBeat.m2504i(104583);
        try {
            this.impl.open();
            AppMethodBeat.m2505o(104583);
        } catch (Throwable th) {
            Logger.m71022e(TAG, "[open] failed!", th);
            AppMethodBeat.m2505o(104583);
        }
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(104584);
        try {
            int readAt = this.impl.readAt(j, bArr, i, i2);
            AppMethodBeat.m2505o(104584);
            return readAt;
        } catch (Throwable th) {
            Logger.m71022e(TAG, "[readAt] failed! pos = " + j + ", offset = " + i + ", size = " + i2, th);
            AppMethodBeat.m2505o(104584);
        }
    }

    public long getSize() {
        AppMethodBeat.m2504i(104585);
        try {
            long size = this.impl.getSize();
            AppMethodBeat.m2505o(104585);
            return size;
        } catch (Throwable th) {
            Logger.m71022e(TAG, "[getSize] failed!", th);
            AppMethodBeat.m2505o(104585);
        }
    }

    public AudioType getAudioType() {
        AppMethodBeat.m2504i(104586);
        try {
            AudioType audioType = this.impl.getAudioType();
            AppMethodBeat.m2505o(104586);
            return audioType;
        } catch (Throwable th) {
            Logger.m71022e(TAG, "[getAudioType] failed!", th);
            AppMethodBeat.m2505o(104586);
        }
    }

    public void close() {
        AppMethodBeat.m2504i(104587);
        try {
            this.impl.close();
            AppMethodBeat.m2505o(104587);
        } catch (Throwable th) {
            Logger.m71022e(TAG, "[close] failed!", th);
            AppMethodBeat.m2505o(104587);
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(104588);
        String obj = this.impl.toString();
        AppMethodBeat.m2505o(104588);
        return obj;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(104589);
        boolean equals = this.impl.equals(obj);
        AppMethodBeat.m2505o(104589);
        return equals;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(104590);
        int hashCode = this.impl.hashCode();
        AppMethodBeat.m2505o(104590);
        return hashCode;
    }
}
