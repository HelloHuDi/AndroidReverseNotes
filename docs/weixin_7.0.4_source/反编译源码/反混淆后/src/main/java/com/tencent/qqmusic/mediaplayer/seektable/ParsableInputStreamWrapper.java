package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.Closeable;
import java.nio.charset.Charset;

public class ParsableInputStreamWrapper implements Parsable, Closeable {
    private final IDataSource dataSource;
    private final byte[] intBuffer = new byte[4];
    private final byte[] longBuffer = new byte[8];
    private long position = 0;

    public ParsableInputStreamWrapper(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128508);
        this.dataSource = iDataSource;
        AppMethodBeat.m2505o(128508);
    }

    public int readInt() {
        AppMethodBeat.m2504i(128509);
        int readAt = this.dataSource.readAt(this.position, this.intBuffer, 0, this.intBuffer.length);
        this.position += (long) readAt;
        if (readAt != this.intBuffer.length) {
            AppMethodBeat.m2505o(128509);
            return -1;
        }
        readAt = ((((this.intBuffer[0] & 255) << 24) | ((this.intBuffer[1] & 255) << 16)) | ((this.intBuffer[2] & 255) << 8)) | (this.intBuffer[3] & 255);
        AppMethodBeat.m2505o(128509);
        return readAt;
    }

    public long readLong() {
        AppMethodBeat.m2504i(128510);
        int readAt = this.dataSource.readAt(this.position, this.longBuffer, 0, this.longBuffer.length);
        this.position += (long) readAt;
        if (readAt != this.longBuffer.length) {
            AppMethodBeat.m2505o(128510);
            return -1;
        }
        long j = ((((((((((long) this.longBuffer[0]) & 255) << 56) | ((((long) this.longBuffer[1]) & 255) << 48)) | ((((long) this.longBuffer[2]) & 255) << 40)) | ((((long) this.longBuffer[3]) & 255) << 32)) | ((((long) this.longBuffer[4]) & 255) << 24)) | ((((long) this.longBuffer[5]) & 255) << 16)) | ((((long) this.longBuffer[6]) & 255) << 8)) | (((long) this.longBuffer[7]) & 255);
        AppMethodBeat.m2505o(128510);
        return j;
    }

    public int[] readIntArray(int i) {
        AppMethodBeat.m2504i(128511);
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        AppMethodBeat.m2505o(128511);
        return iArr;
    }

    public long[] readLongArray(int i) {
        AppMethodBeat.m2504i(128512);
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = readLong();
        }
        AppMethodBeat.m2505o(128512);
        return jArr;
    }

    public void readIntArrayInterleaved(int i, int[]... iArr) {
        AppMethodBeat.m2504i(128513);
        for (int i2 = 0; i2 < i; i2++) {
            for (int[] iArr2 : iArr) {
                iArr2[i2] = readInt();
            }
        }
        AppMethodBeat.m2505o(128513);
    }

    public void readLongArrayInterleaved(int i, long[]... jArr) {
        AppMethodBeat.m2504i(128514);
        for (int i2 = 0; i2 < i; i2++) {
            for (long[] jArr2 : jArr) {
                jArr2[i2] = readLong();
            }
        }
        AppMethodBeat.m2505o(128514);
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(128515);
        this.position = ((long) this.dataSource.readAt(this.position, bArr, i, i2)) + this.position;
        AppMethodBeat.m2505o(128515);
    }

    public String readString(int i) {
        AppMethodBeat.m2504i(128516);
        byte[] bArr = new byte[i];
        readBytes(bArr, 0, i);
        String str = new String(bArr, Charset.defaultCharset());
        AppMethodBeat.m2505o(128516);
        return str;
    }

    public long available() {
        AppMethodBeat.m2504i(128517);
        long size = this.dataSource.getSize() - this.position;
        AppMethodBeat.m2505o(128517);
        return size;
    }

    public long skip(long j) {
        AppMethodBeat.m2504i(128518);
        long available = available();
        if (available > j) {
            this.position += j;
        } else {
            this.position += available;
            j = available;
        }
        AppMethodBeat.m2505o(128518);
        return j;
    }

    public long tell() {
        return this.position;
    }

    public void close() {
        AppMethodBeat.m2504i(128519);
        this.dataSource.close();
        AppMethodBeat.m2505o(128519);
    }
}
