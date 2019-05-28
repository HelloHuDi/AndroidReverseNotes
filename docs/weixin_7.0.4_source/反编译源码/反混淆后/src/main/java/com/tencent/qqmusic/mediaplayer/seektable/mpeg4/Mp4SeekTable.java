package com.tencent.qqmusic.mediaplayer.seektable.mpeg4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Co64;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.GhostBox;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Mdhd;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stco;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsc;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsz;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stts;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Mp4SeekTable implements SeekTable {
    private final Map<String, IMpeg4Box> essentialStblChunkMap = new HashMap();
    private final Mdhd mdhd;

    interface Function1<T, R> {
        R call(T t);
    }

    /* renamed from: com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable$1 */
    class C364121 implements Function1<HashSet<String>, Boolean> {
        C364121() {
        }

        public Boolean call(HashSet<String> hashSet) {
            AppMethodBeat.m2504i(128480);
            Boolean valueOf = Boolean.valueOf(Mp4SeekTable.access$000(hashSet));
            AppMethodBeat.m2505o(128480);
            return valueOf;
        }
    }

    static /* synthetic */ boolean access$000(HashSet hashSet) {
        AppMethodBeat.m2504i(128479);
        boolean needMoreChunks = needMoreChunks(hashSet);
        AppMethodBeat.m2505o(128479);
        return needMoreChunks;
    }

    public Mp4SeekTable() {
        AppMethodBeat.m2504i(128467);
        this.essentialStblChunkMap.put("stco", new Stco());
        this.essentialStblChunkMap.put("co64", new Co64());
        this.essentialStblChunkMap.put("stts", new Stts());
        this.essentialStblChunkMap.put("stsc", new Stsc());
        this.essentialStblChunkMap.put("stsz", new Stsz());
        this.mdhd = new Mdhd();
        AppMethodBeat.m2505o(128467);
    }

    public void parse(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128468);
        ParsableInputStreamWrapper parsableInputStreamWrapper = new ParsableInputStreamWrapper(iDataSource);
        InvalidBoxException invalidBoxException;
        if (seekTo(parsableInputStreamWrapper, "moov.trak.mdia") == null) {
            invalidBoxException = new InvalidBoxException("invalid mp4: no [mdia] was found!");
            AppMethodBeat.m2505o(128468);
            throw invalidBoxException;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("mdhd", this.mdhd);
        hashMap.put("minf", new GhostBox());
        parseChunks(parsableInputStreamWrapper, hashMap, null);
        if (seekTo(parsableInputStreamWrapper, "stbl") == null) {
            invalidBoxException = new InvalidBoxException("invalid mp4: no [stbl] was found!");
            AppMethodBeat.m2505o(128468);
            throw invalidBoxException;
        }
        parseChunks(parsableInputStreamWrapper, this.essentialStblChunkMap, new C364121());
        AppMethodBeat.m2505o(128468);
    }

    public long seek(long j) {
        AppMethodBeat.m2504i(128469);
        long seekInternal = seekInternal((int) Math.round(((double) (((long) this.mdhd.getTimeScale()) * j)) / 1000.0d));
        AppMethodBeat.m2505o(128469);
        return seekInternal;
    }

    private long seekInternal(int i) {
        long offsetOfChunk;
        AppMethodBeat.m2504i(128470);
        int[] iArr = new int[2];
        int sampleOfTime = sampleOfTime((Stts) this.essentialStblChunkMap.get("stts"), i);
        chunkOfSample((Stsc) this.essentialStblChunkMap.get("stsc"), sampleOfTime, iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (((IMpeg4Box) this.essentialStblChunkMap.get("stco")).getSize() != 0) {
            offsetOfChunk = (long) offsetOfChunk((Stco) this.essentialStblChunkMap.get("stco"), i2);
        } else if (((IMpeg4Box) this.essentialStblChunkMap.get("co64")).getSize() != 0) {
            offsetOfChunk = offset64OfChunk((Co64) this.essentialStblChunkMap.get("co64"), i2);
        } else {
            RuntimeException runtimeException = new RuntimeException("invalid stbl: both [stco] nor [co64] was found!");
            AppMethodBeat.m2505o(128470);
            throw runtimeException;
        }
        long offsetOfSampleInChunk = ((long) offsetOfSampleInChunk((Stsz) this.essentialStblChunkMap.get("stsz"), sampleOfTime, i3)) + offsetOfChunk;
        AppMethodBeat.m2505o(128470);
        return offsetOfSampleInChunk;
    }

    private static void chunkOfSample(Stsc stsc, int i, int[] iArr) {
        AppMethodBeat.m2504i(128471);
        int entryCount = stsc.getEntryCount();
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = stsc.getFirstChunk()[i5];
            int i7 = (i6 - i3) * i2;
            if (i < i4 + i7) {
                i5 = 1;
                entryCount = i2;
                break;
            }
            i2 = stsc.getSamplesPerChunk()[i5];
            if (i5 < entryCount) {
                i5++;
                i4 += i7;
            }
            if (i5 >= entryCount) {
                i5 = 0;
                entryCount = i2;
                i3 = i6;
                break;
            }
            i3 = i6;
        }
        if (entryCount == 0) {
            i2 = 1;
        } else if (i5 != 0) {
            i2 = ((i - i4) / entryCount) + i3;
        } else {
            i2 = i3;
        }
        i3 = ((i2 - i3) * entryCount) + i4;
        iArr[0] = i2;
        iArr[1] = i3;
        AppMethodBeat.m2505o(128471);
    }

    private static int offsetOfChunk(Stco stco, int i) {
        AppMethodBeat.m2504i(128472);
        int i2;
        if (i > stco.getEntryCount()) {
            i2 = stco.getChunkOffset()[stco.getEntryCount() - 1];
            AppMethodBeat.m2505o(128472);
            return i2;
        } else if (stco.getEntryCount() > 0) {
            i2 = stco.getChunkOffset()[i - 1];
            AppMethodBeat.m2505o(128472);
            return i2;
        } else {
            AppMethodBeat.m2505o(128472);
            return 8;
        }
    }

    private static long offset64OfChunk(Co64 co64, int i) {
        AppMethodBeat.m2504i(128473);
        long j;
        if (i > co64.getEntryCount()) {
            j = co64.getChunkOffset()[co64.getEntryCount() - 1];
            AppMethodBeat.m2505o(128473);
            return j;
        } else if (co64.getEntryCount() > 0) {
            j = co64.getChunkOffset()[i - 1];
            AppMethodBeat.m2505o(128473);
            return j;
        } else {
            AppMethodBeat.m2505o(128473);
            return 8;
        }
    }

    private static int offsetOfSampleInChunk(Stsz stsz, int i, int i2) {
        AppMethodBeat.m2504i(128474);
        int sampleSize;
        if (stsz.getSampleSize() != 0) {
            sampleSize = (i - i2) * stsz.getSampleSize();
            AppMethodBeat.m2505o(128474);
            return sampleSize;
        }
        sampleSize = 0;
        while (i2 < Math.min(i, stsz.getSampleCount())) {
            sampleSize += stsz.getEntrySize()[i2];
            i2++;
        }
        AppMethodBeat.m2505o(128474);
        return sampleSize;
    }

    private static int sampleOfTime(Stts stts, int i) {
        Object obj = null;
        AppMethodBeat.m2504i(128475);
        int entryCount = stts.getEntryCount();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < entryCount; i4++) {
            i3 = stts.getSampleDelta()[i4];
            int i5 = stts.getSampleCount()[i4];
            int i6 = i5 * i3;
            if (i < i6) {
                obj = 1;
                break;
            }
            i -= i6;
            i2 += i5;
        }
        if (obj != null) {
            i2 += i / i3;
            AppMethodBeat.m2505o(128475);
            return i2;
        }
        AppMethodBeat.m2505o(128475);
        return i2;
    }

    private static IMpeg4Box seekTo(Parsable parsable, String str) {
        AppMethodBeat.m2504i(128476);
        GhostBox ghostBox = new GhostBox();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        IMpeg4Box iMpeg4Box = null;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = null;
            while (obj == null && parsable.available() > 0) {
                ghostBox.parse(parsable, null);
                if (nextToken.equalsIgnoreCase(ghostBox.getType())) {
                    obj = 1;
                    if (!stringTokenizer.hasMoreTokens()) {
                        iMpeg4Box = ghostBox;
                        break;
                    }
                } else {
                    parsable.skip(ghostBox.getSize() - 8);
                }
            }
        }
        AppMethodBeat.m2505o(128476);
        return iMpeg4Box;
    }

    private static void parseChunks(Parsable parsable, Map<String, IMpeg4Box> map, Function1<HashSet<String>, Boolean> function1) {
        AppMethodBeat.m2504i(128477);
        GhostBox ghostBox = new GhostBox();
        HashSet hashSet = new HashSet(map.keySet());
        while (true) {
            if ((function1 == null || ((Boolean) function1.call(hashSet)).booleanValue()) && hashSet.size() != 0 && parsable.available() > 0) {
                ghostBox.parse(parsable, null);
                String type = ghostBox.getType();
                IMpeg4Box iMpeg4Box = (IMpeg4Box) map.get(type);
                if (iMpeg4Box == null) {
                    parsable.skip(ghostBox.getSize() - 8);
                } else {
                    iMpeg4Box.parse(parsable, ghostBox);
                    hashSet.remove(type);
                }
            }
        }
        if (function1 == null || !((Boolean) function1.call(hashSet)).booleanValue()) {
            AppMethodBeat.m2505o(128477);
            return;
        }
        InvalidBoxException invalidBoxException = new InvalidBoxException("invalid box: critical box not found!");
        AppMethodBeat.m2505o(128477);
        throw invalidBoxException;
    }

    private static boolean needMoreChunks(HashSet<String> hashSet) {
        AppMethodBeat.m2504i(128478);
        if (hashSet.size() > 2) {
            AppMethodBeat.m2505o(128478);
            return true;
        } else if (hashSet.contains("stco") && hashSet.contains("co64")) {
            AppMethodBeat.m2505o(128478);
            return true;
        } else {
            AppMethodBeat.m2505o(128478);
            return false;
        }
    }
}
