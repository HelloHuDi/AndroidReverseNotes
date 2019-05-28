package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.StreamUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileDataSource implements IDataSource {
    private long currentPosition;
    private File file;
    private FileInputStream fileInputStream;
    private final String filePath;
    private boolean opened = false;
    private BufferedInputStream readingStream;

    public FileDataSource(String str) {
        this.filePath = str;
    }

    public void open() {
        AppMethodBeat.m2504i(128355);
        if (this.opened) {
            AppMethodBeat.m2505o(128355);
            return;
        }
        this.opened = true;
        this.file = new File(this.filePath);
        this.fileInputStream = new FileInputStream(this.filePath);
        this.readingStream = new BufferedInputStream(this.fileInputStream);
        this.currentPosition = 0;
        AppMethodBeat.m2505o(128355);
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(128356);
        if (this.currentPosition != j) {
            long skipForBufferStream;
            if (this.currentPosition > j) {
                this.readingStream.close();
                this.fileInputStream.close();
                this.fileInputStream = new FileInputStream(this.filePath);
                this.readingStream = new BufferedInputStream(this.fileInputStream);
                skipForBufferStream = StreamUtils.skipForBufferStream(this.readingStream, j);
            } else {
                skipForBufferStream = this.currentPosition + StreamUtils.skipForBufferStream(this.readingStream, j - this.currentPosition);
            }
            if (skipForBufferStream != j) {
                AppMethodBeat.m2505o(128356);
                return -1;
            }
            this.currentPosition = j;
        }
        int read = this.readingStream.read(bArr, i, i2);
        if (read >= 0) {
            this.currentPosition += (long) read;
        }
        AppMethodBeat.m2505o(128356);
        return read;
    }

    public long getSize() {
        AppMethodBeat.m2504i(128357);
        long length = this.file.length();
        AppMethodBeat.m2505o(128357);
        return length;
    }

    public AudioType getAudioType() {
        AppMethodBeat.m2504i(128358);
        AudioType recognitionAudioFormatExactly = AudioRecognition.recognitionAudioFormatExactly(this.filePath);
        AppMethodBeat.m2505o(128358);
        return recognitionAudioFormatExactly;
    }

    public void close() {
        AppMethodBeat.m2504i(128359);
        if (this.opened) {
            if (this.fileInputStream != null) {
                this.fileInputStream.close();
            }
            if (this.readingStream != null) {
                this.readingStream.close();
            }
            this.opened = false;
            AppMethodBeat.m2505o(128359);
            return;
        }
        AppMethodBeat.m2505o(128359);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String toString() {
        AppMethodBeat.m2504i(128360);
        String str = "(fd)" + this.filePath;
        AppMethodBeat.m2505o(128360);
        return str;
    }
}
