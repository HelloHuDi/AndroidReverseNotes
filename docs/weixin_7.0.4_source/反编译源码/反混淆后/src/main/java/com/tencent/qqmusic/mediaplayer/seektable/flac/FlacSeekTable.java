package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.view.C31128d;
import java.util.Arrays;
import java.util.HashSet;

public class FlacSeekTable implements SeekTable {
    private static final int SEEK_POINT_SIZE = 18;
    private static final byte TYPE_SEEKTABLE = (byte) 3;
    private static final byte TYPE_STREAMINFO = (byte) 0;
    private long firstFrameOffset;
    private long[] offsets;
    private long[] sampleNumbers;
    private int sampleRate = 0;

    class SeektableHandler implements BlockHandler {
        SeektableHandler() {
        }

        public boolean handle(Parsable parsable, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(128529);
            if (i != 3) {
                AppMethodBeat.m2505o(128529);
                return false;
            }
            byte[] bArr = new byte[3];
            parsable.readBytes(bArr, 0, 3);
            int from = BytesUtil.from(bArr) / 18;
            FlacSeekTable.this.sampleNumbers = new long[from];
            FlacSeekTable.this.offsets = new long[from];
            while (i2 < from) {
                FlacSeekTable.this.sampleNumbers[i2] = parsable.readLong();
                FlacSeekTable.this.offsets[i2] = parsable.readLong();
                parsable.skip(2);
                i2++;
            }
            if (FlacSeekTable.access$200(parsable)) {
                FlacSeekTable.this.firstFrameOffset = parsable.tell() - 2;
                AppMethodBeat.m2505o(128529);
                return true;
            }
            InvalidBoxException invalidBoxException = new InvalidBoxException("can't find audio frame!");
            AppMethodBeat.m2505o(128529);
            throw invalidBoxException;
        }
    }

    class StreamInfoHandler implements BlockHandler {
        StreamInfoHandler() {
        }

        public boolean handle(Parsable parsable, int i) {
            AppMethodBeat.m2504i(128520);
            if (i != 0) {
                AppMethodBeat.m2505o(128520);
                return false;
            }
            parsable.skip(13);
            parsable.readBytes(new byte[3], 0, 3);
            parsable.skip(21);
            AppMethodBeat.m2505o(128520);
            return true;
        }
    }

    interface BlockHandler {
        boolean handle(Parsable parsable, int i);
    }

    static /* synthetic */ boolean access$200(Parsable parsable) {
        AppMethodBeat.m2504i(128528);
        boolean seekToFirstFrame = seekToFirstFrame(parsable);
        AppMethodBeat.m2505o(128528);
        return seekToFirstFrame;
    }

    public FlacSeekTable(int i) {
        this.sampleRate = i;
    }

    public long[] getOffsetRangeOfSample(int i) {
        AppMethodBeat.m2504i(128521);
        long[] jArr;
        if (binarySearchFloor(this.sampleNumbers, (long) i, true, true) + 1 >= this.offsets.length) {
            jArr = new long[]{this.firstFrameOffset + this.offsets[binarySearchFloor(this.sampleNumbers, (long) i, true, true)], -1};
            AppMethodBeat.m2505o(128521);
            return jArr;
        }
        jArr = new long[]{this.firstFrameOffset + this.offsets[binarySearchFloor(this.sampleNumbers, (long) i, true, true)], this.firstFrameOffset + this.offsets[binarySearchFloor(this.sampleNumbers, (long) i, true, true) + 1]};
        AppMethodBeat.m2505o(128521);
        return jArr;
    }

    public void parse(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128522);
        ParsableInputStreamWrapper parsableInputStreamWrapper = new ParsableInputStreamWrapper(iDataSource);
        if (seekToFlac(parsableInputStreamWrapper)) {
            if (walkThrough(parsableInputStreamWrapper, this.sampleRate == 0 ? new BlockHandler[]{new SeektableHandler(), new StreamInfoHandler()} : new BlockHandler[]{new SeektableHandler()})) {
                AppMethodBeat.m2505o(128522);
                return;
            }
            InvalidBoxException invalidBoxException = new InvalidBoxException("lack one or more critical BLOCK(s) to create seek table!");
            AppMethodBeat.m2505o(128522);
            throw invalidBoxException;
        }
        AppMethodBeat.m2505o(128522);
    }

    public long seek(long j) {
        AppMethodBeat.m2504i(128523);
        int binarySearchFloor = binarySearchFloor(this.sampleNumbers, (long) ((int) (Math.round(((double) j) / 1000.0d) * ((long) this.sampleRate))), true, true);
        long j2 = this.offsets[binarySearchFloor] + this.firstFrameOffset;
        AppMethodBeat.m2505o(128523);
        return j2;
    }

    private static boolean seekToFlac(Parsable parsable) {
        AppMethodBeat.m2504i(128524);
        byte[] bArr = new byte[4];
        parsable.readBytes(bArr, 0, 4);
        if (bArr[0] == (byte) 73 && bArr[1] == (byte) 68 && bArr[2] == (byte) 51) {
            parsable.skip(2);
            parsable.skip((long) Id3Util.unsynchsafe(parsable.readInt()));
            parsable.readBytes(bArr, 0, 4);
        }
        if (bArr[0] == (byte) 102 && bArr[1] == (byte) 76 && bArr[2] == (byte) 97 && bArr[3] == (byte) 67) {
            AppMethodBeat.m2505o(128524);
            return true;
        }
        AppMethodBeat.m2505o(128524);
        return false;
    }

    private static boolean walkThrough(Parsable parsable, BlockHandler... blockHandlerArr) {
        AppMethodBeat.m2504i(128525);
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        HashSet hashSet = new HashSet();
        while (hashSet.size() < blockHandlerArr.length && parsable.available() > 0) {
            parsable.readBytes(bArr, 0, 1);
            int i = bArr[0] & C31128d.MIC_SketchMark;
            boolean z = false;
            for (BlockHandler blockHandler : blockHandlerArr) {
                z = blockHandler.handle(parsable, i);
                if (z) {
                    hashSet.add(Integer.valueOf(blockHandler.hashCode()));
                    break;
                }
            }
            if (!z) {
                if (((bArr[0] & 255) >> 7) == 1) {
                    break;
                }
                parsable.readBytes(bArr2, 0, 3);
                parsable.skip((long) BytesUtil.from(bArr2));
            }
        }
        if (hashSet.size() == blockHandlerArr.length) {
            AppMethodBeat.m2505o(128525);
            return true;
        }
        AppMethodBeat.m2505o(128525);
        return false;
    }

    private static boolean seekToFirstFrame(Parsable parsable) {
        boolean z = false;
        AppMethodBeat.m2504i(128526);
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        boolean z2 = false;
        while (parsable.available() > 0) {
            if (z2) {
                byte[] bArr3 = new byte[2];
                parsable.readBytes(bArr3, 0, 2);
                if ((bArr3[0] & 255) == 255 && ((bArr3[1] & 255) >> 2) == 62) {
                    z = true;
                }
                AppMethodBeat.m2505o(128526);
                return z;
            }
            parsable.readBytes(bArr, 0, 1);
            if (((bArr[0] & 255) >> 7) == 1) {
                z2 = true;
            }
            parsable.readBytes(bArr2, 0, 3);
            parsable.skip((long) BytesUtil.from(bArr2));
        }
        AppMethodBeat.m2505o(128526);
        return z;
    }

    private static int binarySearchFloor(long[] jArr, long j, boolean z, boolean z2) {
        AppMethodBeat.m2504i(128527);
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z) {
            binarySearch--;
        }
        if (z2) {
            binarySearch = Math.max(0, binarySearch);
            AppMethodBeat.m2505o(128527);
            return binarySearch;
        }
        AppMethodBeat.m2505o(128527);
        return binarySearch;
    }
}
