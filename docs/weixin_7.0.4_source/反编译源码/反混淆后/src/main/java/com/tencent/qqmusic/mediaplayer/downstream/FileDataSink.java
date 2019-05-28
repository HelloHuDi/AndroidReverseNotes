package com.tencent.qqmusic.mediaplayer.downstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.RandomAccessFile;

public class FileDataSink implements IDataSink {
    private static final String TAG = "FileDataSink";
    private long currentPosition = 0;
    private final String filePath;
    private boolean opened = false;
    private RandomAccessFile randomAccessFile = null;

    public FileDataSink(String str) {
        this.filePath = str;
    }

    public void open() {
        AppMethodBeat.m2504i(104485);
        if (this.opened) {
            AppMethodBeat.m2505o(104485);
            return;
        }
        this.randomAccessFile = new RandomAccessFile(this.filePath, "rw");
        this.currentPosition = 0;
        this.opened = true;
        AppMethodBeat.m2505o(104485);
    }

    public int write(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(104486);
        if (this.randomAccessFile != null) {
            if (this.currentPosition != j) {
                Logger.m71020d(TAG, "[write] seek to: ".concat(String.valueOf(j)));
                this.randomAccessFile.seek(j);
                this.currentPosition = j;
            }
            this.randomAccessFile.write(bArr, i, i2);
            this.currentPosition += (long) i2;
            AppMethodBeat.m2505o(104486);
            return i2;
        }
        AppMethodBeat.m2505o(104486);
        return 0;
    }

    public void close() {
        AppMethodBeat.m2504i(104487);
        if (this.opened) {
            this.randomAccessFile.close();
            this.currentPosition = 0;
            AppMethodBeat.m2505o(104487);
            return;
        }
        AppMethodBeat.m2505o(104487);
    }
}
