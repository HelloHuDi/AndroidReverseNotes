package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDataSource implements IDataSource {
    private long currentPosition;
    private InputStream currentStream;
    private final InputStreamFactory factory;
    private long size;

    public interface InputStreamFactory {
        InputStream create();
    }

    public InputStreamDataSource(InputStreamFactory inputStreamFactory) {
        this.factory = inputStreamFactory;
    }

    public void open() {
        AppMethodBeat.i(128362);
        if (this.currentStream != null) {
            this.currentStream.close();
        }
        this.currentStream = this.factory.create();
        this.size = (long) this.currentStream.available();
        this.currentPosition = 0;
        AppMethodBeat.o(128362);
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(128363);
        int readAt;
        if (j < this.currentPosition) {
            open();
            readAt = readAt(j, bArr, i, i2);
            AppMethodBeat.o(128363);
            return readAt;
        }
        if (j > this.currentPosition) {
            long j2 = j - this.currentPosition;
            while (true) {
                long skip = this.currentStream.skip(j2);
                j2 -= skip;
                if (j2 <= 0 && skip > 0) {
                    break;
                }
            }
            if (j2 < 0) {
                IOException iOException = new IOException("skipped too much bytes");
                AppMethodBeat.o(128363);
                throw iOException;
            }
            this.currentPosition = j;
        }
        readAt = this.currentStream.read(bArr, i, i2);
        if (readAt > 0) {
            this.currentPosition += (long) readAt;
        }
        AppMethodBeat.o(128363);
        return readAt;
    }

    public long getSize() {
        return this.size;
    }

    public AudioType getAudioType() {
        AppMethodBeat.i(128364);
        AudioType audioFormat = FormatDetector.getAudioFormat((IDataSource) this, false);
        AppMethodBeat.o(128364);
        return audioFormat;
    }

    public void close() {
        AppMethodBeat.i(128365);
        if (this.currentStream != null) {
            this.currentStream.close();
        }
        AppMethodBeat.o(128365);
    }
}
