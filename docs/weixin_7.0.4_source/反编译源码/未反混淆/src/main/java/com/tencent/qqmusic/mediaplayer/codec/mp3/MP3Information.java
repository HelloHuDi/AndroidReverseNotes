package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.qqmusic.mediaplayer.AudioInformation;

public class MP3Information extends AudioInformation {
    private int bitratemode;
    private int encoding;
    private String error;
    private long fileLengthInBytes;
    private long firstFramePos;
    private long firstFrameSize;
    private long id3v2Size;
    private int layer;
    private long[] mTocTable;
    private int mpeg_version;
    private boolean success = false;

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public void setEncoding(int i) {
        this.encoding = i;
    }

    public int getBitratemode() {
        return this.bitratemode;
    }

    public void setBitratemode(int i) {
        this.bitratemode = i;
    }

    public int getLayer() {
        return this.layer;
    }

    public int getMpeg_version() {
        return this.mpeg_version;
    }

    public long getId3v2Size() {
        return this.id3v2Size;
    }

    public long getFirstFramePos() {
        return this.firstFramePos;
    }

    public long getFirstFrameSize() {
        return this.firstFrameSize;
    }

    public long[] getTocTable() {
        return this.mTocTable;
    }

    public void setTocTable(long[] jArr) {
        this.mTocTable = jArr;
    }

    public long getFileLengthInBytes() {
        return this.fileLengthInBytes;
    }
}
