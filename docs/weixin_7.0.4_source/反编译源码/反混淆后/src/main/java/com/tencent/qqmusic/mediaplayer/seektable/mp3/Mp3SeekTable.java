package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class Mp3SeekTable implements SeekTable {
    private final Mp3Info mInfo = new Mp3Info();

    public Mp3SeekTable() {
        AppMethodBeat.m2504i(128489);
        AppMethodBeat.m2505o(128489);
    }

    public void parse(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128490);
        Mp3FrameInfoParse.parseFrameInfo(new TrackPositionDataSource(iDataSource), this.mInfo);
        AppMethodBeat.m2505o(128490);
    }

    public long seek(long j) {
        AppMethodBeat.m2504i(128491);
        if (j < 0) {
            AppMethodBeat.m2505o(128491);
            return -1;
        }
        long timeToBytePositionInCbr;
        switch (this.mInfo.VBRType) {
            case 0:
                timeToBytePositionInCbr = timeToBytePositionInCbr(this.mInfo, j);
                AppMethodBeat.m2505o(128491);
                return timeToBytePositionInCbr;
            case 1:
                timeToBytePositionInCbr = timeToBytePositionInVBRIVbr(this.mInfo, j);
                AppMethodBeat.m2505o(128491);
                return timeToBytePositionInCbr;
            case 2:
                timeToBytePositionInCbr = timeToBytePositionInXingVbr(this.mInfo, j);
                AppMethodBeat.m2505o(128491);
                return timeToBytePositionInCbr;
            default:
                AppMethodBeat.m2505o(128491);
                return -1;
        }
    }

    private static long timeToBytePositionInCbr(Mp3Info mp3Info, long j) {
        if (mp3Info == null || mp3Info.bit_rate <= 0 || j < 0) {
            return -1;
        }
        long j2 = ((long) (mp3Info.bit_rate / 8)) * j;
        if (mp3Info.idv2Size > 0) {
            return j2 + ((long) mp3Info.idv2Size);
        }
        return j2;
    }

    private static long timeToBytePositionInXingVbr(Mp3Info mp3Info, long j) {
        AppMethodBeat.m2504i(128492);
        if (mp3Info == null || mp3Info.toc_table == null || mp3Info.fileLengthInBytes <= 0 || mp3Info.firstFramePosition < 0 || mp3Info.duration < 0 || j < 0) {
            AppMethodBeat.m2505o(128492);
            return -1;
        }
        double d;
        long j2 = mp3Info.fileLengthInBytes;
        long j3 = mp3Info.firstFramePosition;
        long[] jArr = mp3Info.toc_table;
        double d2 = (((double) j) * 100.0d) / ((double) mp3Info.duration);
        if (d2 <= 0.0d) {
            d = 0.0d;
        } else if (d2 >= 100.0d) {
            d = 256.0d;
        } else {
            float f;
            float f2;
            int i = (int) d2;
            if (i == 0) {
                f = 0.0f;
            } else {
                f = (float) jArr[i];
            }
            if (i < 99) {
                f2 = (float) jArr[i + 1];
            } else {
                f2 = 256.0f;
            }
            d = (((double) (f2 - f)) * (d2 - ((double) i))) + ((double) f);
        }
        long round = Math.round((d * 0.00390625d) * ((double) j2)) + j3;
        j2 = (j2 + j3) - 1;
        if (mp3Info.idv2Size > 0) {
            j2 -= (long) mp3Info.idv2Size;
        }
        if (round < j2) {
            AppMethodBeat.m2505o(128492);
            return round;
        }
        AppMethodBeat.m2505o(128492);
        return j2;
    }

    private static long timeToBytePositionInVBRIVbr(Mp3Info mp3Info, long j) {
        if (mp3Info == null || mp3Info.toc_table == null || mp3Info.fileLengthInBytes <= 0 || mp3Info.firstFramePosition < 0 || mp3Info.duration <= 0 || j < 0) {
            return -1;
        }
        long j2 = mp3Info.fileLengthInBytes;
        long j3 = mp3Info.firstFramePosition;
        int i = mp3Info.entry_count;
        long[] jArr = mp3Info.toc_table;
        long j4 = mp3Info.duration;
        int i2 = (int) (((((double) j) * 1.0d) / ((double) j4)) * ((double) (i + 1)));
        if (i2 >= 0) {
            j3 = jArr[i2];
        }
        if (i2 < i) {
            j2 = jArr[i2 + 1];
        }
        long j5 = (((long) i2) * j4) / ((long) (i + 1));
        return (j2 == j3 ? 0 : (long) (((((double) (j2 - j3)) * 1.0d) * ((double) (j - j5))) / ((double) (((j4 * ((long) (i2 + 1))) / ((long) (i + 1))) - j5)))) + j3;
    }
}
