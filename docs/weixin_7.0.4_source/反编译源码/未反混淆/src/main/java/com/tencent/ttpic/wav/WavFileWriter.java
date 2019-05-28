package com.tencent.ttpic.wav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WavFileWriter {
    private DataOutputStream mDataOutputStream;
    private int mDataSize = 0;
    private String mFilepath;

    public boolean openFile(String str, int i, int i2, int i3) {
        AppMethodBeat.i(84498);
        if (this.mDataOutputStream != null) {
            closeFile();
        }
        this.mFilepath = str;
        this.mDataSize = 0;
        this.mDataOutputStream = new DataOutputStream(new FileOutputStream(str));
        boolean writeHeader = writeHeader(i, i3, i2);
        AppMethodBeat.o(84498);
        return writeHeader;
    }

    public boolean closeFile() {
        AppMethodBeat.i(84499);
        boolean z = true;
        if (this.mDataOutputStream != null) {
            z = writeDataSize();
            this.mDataOutputStream.close();
            this.mDataOutputStream = null;
        }
        AppMethodBeat.o(84499);
        return z;
    }

    public boolean writeData(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(84500);
        if (this.mDataOutputStream == null) {
            AppMethodBeat.o(84500);
            return false;
        }
        try {
            this.mDataOutputStream.write(bArr, i, i2);
            this.mDataSize += i2;
            AppMethodBeat.o(84500);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(84500);
            return false;
        }
    }

    private boolean writeHeader(int i, int i2, int i3) {
        AppMethodBeat.i(84501);
        if (this.mDataOutputStream == null) {
            AppMethodBeat.o(84501);
            return false;
        }
        WavFileHeader wavFileHeader = new WavFileHeader(i, i2, i3);
        try {
            this.mDataOutputStream.writeBytes(wavFileHeader.mChunkID);
            this.mDataOutputStream.write(intToByteArray(wavFileHeader.mChunkSize), 0, 4);
            this.mDataOutputStream.writeBytes(wavFileHeader.mFormat);
            this.mDataOutputStream.writeBytes(wavFileHeader.mSubChunk1ID);
            this.mDataOutputStream.write(intToByteArray(wavFileHeader.mSubChunk1Size), 0, 4);
            this.mDataOutputStream.write(shortToByteArray(wavFileHeader.mAudioFormat), 0, 2);
            this.mDataOutputStream.write(shortToByteArray(wavFileHeader.mNumChannel), 0, 2);
            this.mDataOutputStream.write(intToByteArray(wavFileHeader.mSampleRate), 0, 4);
            this.mDataOutputStream.write(intToByteArray(wavFileHeader.mByteRate), 0, 4);
            this.mDataOutputStream.write(shortToByteArray(wavFileHeader.mBlockAlign), 0, 2);
            this.mDataOutputStream.write(shortToByteArray(wavFileHeader.mBitsPerSample), 0, 2);
            this.mDataOutputStream.writeBytes(wavFileHeader.mSubChunk2ID);
            this.mDataOutputStream.write(intToByteArray(wavFileHeader.mSubChunk2Size), 0, 4);
            AppMethodBeat.o(84501);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(84501);
            return false;
        }
    }

    private boolean writeDataSize() {
        AppMethodBeat.i(84502);
        if (this.mDataOutputStream == null) {
            AppMethodBeat.o(84502);
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.mFilepath, "rw");
            randomAccessFile.seek(4);
            randomAccessFile.write(intToByteArray(this.mDataSize + 36), 0, 4);
            randomAccessFile.seek(40);
            randomAccessFile.write(intToByteArray(this.mDataSize), 0, 4);
            randomAccessFile.close();
            AppMethodBeat.o(84502);
            return true;
        } catch (FileNotFoundException e) {
            AppMethodBeat.o(84502);
            return false;
        } catch (IOException e2) {
            AppMethodBeat.o(84502);
            return false;
        }
    }

    private static byte[] intToByteArray(int i) {
        AppMethodBeat.i(84503);
        byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array();
        AppMethodBeat.o(84503);
        return array;
    }

    private static byte[] shortToByteArray(short s) {
        AppMethodBeat.i(84504);
        byte[] array = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s).array();
        AppMethodBeat.o(84504);
        return array;
    }
}
