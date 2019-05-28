package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MP3FileCheck {
    private static final String TAG = "MP3FileCheck";
    private byte[] buf = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
    private int endPos;
    private boolean eof;
    private int frameCount;
    private boolean hasCheck = false;
    private boolean hasID3V2 = false;
    private MP3Header header = new MP3Header();
    private int headerMask;
    private boolean isMP3 = false;
    private String mFilePath = null;
    private int mID3V2Size = -1;
    private RandomAccessFile mRandomAccessFile = null;
    private int pos;
    private int skipped;
    private boolean sync;

    public MP3FileCheck(String str) {
        AppMethodBeat.m2504i(128565);
        this.mFilePath = str;
        AppMethodBeat.m2505o(128565);
    }

    public static boolean isMp3File(String str) {
        AppMethodBeat.m2504i(128566);
        boolean isMp3File = new MP3FileCheck(str).isMp3File();
        AppMethodBeat.m2505o(128566);
        return isMp3File;
    }

    private boolean isMp3File() {
        AppMethodBeat.m2504i(128567);
        if (!this.hasCheck) {
            fileCheck();
        }
        boolean z = this.isMP3;
        AppMethodBeat.m2505o(128567);
        return z;
    }

    private boolean checkAndSeekID3V2Tag() {
        AppMethodBeat.m2504i(128568);
        byte[] bArr = new byte[10];
        int fillBuffer = fillBuffer(bArr, 0, 10);
        if (fillBuffer <= 0) {
            AppMethodBeat.m2505o(128568);
            return false;
        }
        if (bArr[0] == (byte) 73 && bArr[1] == (byte) 68 && bArr[2] == (byte) 51) {
            this.mID3V2Size = (((bArr[6] << 21) + (bArr[7] << 14)) + (bArr[8] << 7)) + bArr[9];
            this.hasID3V2 = true;
            seekTo(this.mID3V2Size - fillBuffer);
            Logger.m71020d(TAG, "有ID3V2，ID3V2大小 = " + this.mID3V2Size);
        } else {
            closeFileStream();
            Logger.m71020d(TAG, "没有有ID3V2");
        }
        boolean z = this.hasID3V2;
        AppMethodBeat.m2505o(128568);
        return z;
    }

    private void closeFileStream() {
        AppMethodBeat.m2504i(128569);
        if (this.mRandomAccessFile != null) {
            try {
                this.mRandomAccessFile.close();
            } catch (IOException e) {
                Logger.m71024e(TAG, e);
            }
            this.mRandomAccessFile = null;
        }
        AppMethodBeat.m2505o(128569);
    }

    private void seekTo(int i) {
        AppMethodBeat.m2504i(128570);
        try {
            this.mRandomAccessFile.seek((long) i);
            AppMethodBeat.m2505o(128570);
        } catch (Exception e) {
            Logger.m71024e(TAG, e);
            AppMethodBeat.m2505o(128570);
        }
    }

    public void fileCheck() {
        AppMethodBeat.m2504i(128571);
        try {
            this.hasCheck = true;
            checkAndSeekID3V2Tag();
            this.headerMask = -2097152;
            this.sync = false;
            this.eof = false;
            this.frameCount = 0;
            int length = this.buf.length;
            this.pos = length;
            this.endPos = length;
            this.header.initialize();
            nextFrameHeader();
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                    AppMethodBeat.m2505o(128571);
                    return;
                } catch (Exception e) {
                    Logger.m71024e(TAG, e);
                    AppMethodBeat.m2505o(128571);
                    return;
                }
            }
        } catch (Exception e2) {
            Logger.m71024e(TAG, e2);
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                    AppMethodBeat.m2505o(128571);
                    return;
                } catch (Exception e22) {
                    Logger.m71024e(TAG, e22);
                    AppMethodBeat.m2505o(128571);
                    return;
                }
            }
        } catch (Throwable th) {
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (Exception e3) {
                    Logger.m71024e(TAG, e3);
                }
            }
            AppMethodBeat.m2505o(128571);
        }
        AppMethodBeat.m2505o(128571);
    }

    public int getFrameSize() {
        AppMethodBeat.m2504i(128572);
        if (this.header != null) {
            int frameSize = this.header.getFrameSize();
            AppMethodBeat.m2505o(128572);
            return frameSize;
        }
        AppMethodBeat.m2505o(128572);
        return -1;
    }

    private void nextFrameHeader() {
        AppMethodBeat.m2504i(128573);
        int i = 0;
        while (!this.eof && !syncFrame()) {
            int i2 = this.endPos - this.pos;
            if (i2 > 0) {
                System.arraycopy(this.buf, this.pos, this.buf, 0, i2);
            }
            this.endPos = fillBuffer(this.buf, i2, this.pos) + i2;
            if (this.endPos > i2) {
                i += this.pos;
                if (i <= 65536) {
                    this.pos = 0;
                }
            }
            this.eof = true;
            this.pos = 0;
        }
        AppMethodBeat.m2505o(128573);
    }

    private boolean syncFrame() {
        AppMethodBeat.m2504i(128574);
        int i = this.pos;
        if (this.endPos - this.pos <= 4) {
            AppMethodBeat.m2505o(128574);
            return false;
        }
        int byte2int = byte2int(this.buf, this.pos);
        this.pos += 4;
        System.out.println(this.frameCount);
        while (!this.eof) {
            byte[] bArr;
            int i2;
            int i3;
            while (!available(byte2int, this.headerMask)) {
                byte2int <<= 8;
                bArr = this.buf;
                i2 = this.pos;
                this.pos = i2 + 1;
                byte2int |= bArr[i2] & 255;
                if (this.pos == this.endPos) {
                    byte2int = this.skipped;
                    i3 = this.pos - 4;
                    this.pos = i3;
                    this.skipped = byte2int + (i3 - i);
                    AppMethodBeat.m2505o(128574);
                    return false;
                }
            }
            if (this.pos > i + 4) {
                this.sync = false;
                this.skipped += (this.pos - 4) - i;
            }
            this.header.decode(byte2int);
            int frameSize = this.header.getFrameSize();
            if (this.pos + frameSize > this.endPos + 4) {
                byte2int = this.skipped;
                i3 = this.pos - 4;
                this.pos = i3;
                this.skipped = byte2int + (i3 - i);
                AppMethodBeat.m2505o(128574);
                return false;
            } else if (this.sync) {
                break;
            } else if (this.pos + frameSize > this.endPos) {
                byte2int = this.skipped;
                i3 = this.pos - 4;
                this.pos = i3;
                this.skipped = byte2int + (i3 - i);
                AppMethodBeat.m2505o(128574);
                return false;
            } else {
                i2 = (((1572864 & byte2int) | -2097152) | (393216 & byte2int)) | (byte2int & 3072);
                if (available(byte2int(this.buf, frameSize + (this.pos - 4)), i2)) {
                    if (this.headerMask == -2097152) {
                        this.headerMask = i2;
                    }
                    this.sync = true;
                } else {
                    byte2int <<= 8;
                    bArr = this.buf;
                    i2 = this.pos;
                    this.pos = i2 + 1;
                    byte2int |= bArr[i2] & 255;
                }
            }
        }
        if (this.header.isProtected()) {
            this.pos += 2;
        }
        this.frameCount++;
        if (this.skipped > 0 || (this.skipped == 0 && this.sync)) {
            this.isMP3 = true;
            this.skipped = 0;
        }
        AppMethodBeat.m2505o(128574);
        return true;
    }

    private int fillBuffer(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(128575);
        try {
            if (this.mRandomAccessFile == null) {
                this.mRandomAccessFile = new RandomAccessFile(this.mFilePath, "r");
            }
            int read = this.mRandomAccessFile.read(bArr, i, i2);
            AppMethodBeat.m2505o(128575);
            return read;
        } catch (Exception e) {
            AppMethodBeat.m2505o(128575);
            return -1;
        }
    }

    private int byte2int(byte[] bArr, int i) {
        return (((bArr[i] << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
    }

    private boolean available(int i, int i2) {
        return ((i & i2) != i2 || ((i >> 19) & 3) == 1 || ((i >> 17) & 3) == 0 || ((i >> 12) & 15) == 15 || ((i >> 12) & 15) == 0 || ((i >> 10) & 3) == 3) ? false : true;
    }
}
