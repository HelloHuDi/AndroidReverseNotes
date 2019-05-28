package com.tencent.ttpic.wav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public class WavFileHeader {
    public static final int WAV_CHUNKSIZE_EXCLUDE_DATA = 36;
    public static final int WAV_CHUNKSIZE_OFFSET = 4;
    public static final int WAV_FILE_HEADER_SIZE = 44;
    public static final int WAV_SUB_CHUNKSIZE1_OFFSET = 16;
    public static final int WAV_SUB_CHUNKSIZE2_OFFSET = 40;
    public short mAudioFormat = (short) 1;
    public short mBitsPerSample = (short) 8;
    public short mBlockAlign = (short) 0;
    public int mByteRate = 0;
    public String mChunkID = "RIFF";
    public int mChunkSize = 0;
    public String mFormat = "WAVE";
    public short mNumChannel = (short) 1;
    public int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    public String mSubChunk1ID = "fmt ";
    public int mSubChunk1Size = 16;
    public String mSubChunk2ID = "data";
    public int mSubChunk2Size = 0;

    public WavFileHeader(int i, int i2, int i3) {
        AppMethodBeat.i(84497);
        this.mSampleRate = i;
        this.mBitsPerSample = (short) i3;
        this.mNumChannel = (short) i2;
        this.mByteRate = ((this.mSampleRate * this.mNumChannel) * this.mBitsPerSample) / 8;
        this.mBlockAlign = (short) ((this.mNumChannel * this.mBitsPerSample) / 8);
        AppMethodBeat.o(84497);
    }
}
