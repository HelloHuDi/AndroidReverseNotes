package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33381d;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;

class Mp3FrameInfoParse {
    private static final int[][][] BitrateTable;
    private static final int DECODE_ERROR_IO_READ = -3;
    private static final int DECODE_ERROR_MEMORY_ALLOC = -2;
    private static final int DECODE_ERROR_SUCCESS = 0;
    private static final int DECODE_FAIL = -1;
    private static final int[][] SAMPLE_PER_FRAME = new int[][]{new int[]{384, 1152, 1152}, new int[]{384, 1152, 576}, new int[]{384, 1152, 576}};
    private static final int[][] SAMPLE_RATE_TABLE = new int[][]{new int[]{11025, 12000, TXRecordCommon.AUDIO_SAMPLERATE_8000}, new int[]{0, 0, 0}, new int[]{22050, 24000, TXRecordCommon.AUDIO_SAMPLERATE_16000}, new int[]{TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_32000}};
    private static final String TAG = "Mp3FrameInfoParse";
    public static final int VBR_TYPE_CBR = 0;
    public static final int VBR_TYPE_VBRI = 1;
    public static final int VBR_TYPE_XING = 2;

    static class Mp3Info {
        int VBRType = 0;
        int bit_rate = 0;
        int channels = 0;
        long duration = 0;
        int entry_count = 0;
        int entry_size = 0;
        long fileLengthInBytes = 0;
        long firstFramePosition = 0;
        long firstFrameSize = 0;
        int flag_value = 0;
        int idv2Size = 0;
        int isVbr = 0;
        int layer = 0;
        long lengthInFrames = 0;
        int mpeg_version = 0;
        long sample_rate = 0;
        int scale_factor = 0;
        long[] toc_table = null;

        Mp3Info() {
        }
    }

    Mp3FrameInfoParse() {
    }

    static {
        r0 = new int[2][][];
        r0[0] = new int[][]{new int[]{0, 32, 64, 96, 128, 160, C33250az.CTRL_INDEX, 224, 256, C31128d.MIC_PTU_YOUJIALI, 320, C33381d.CTRL_INDEX, 384, 416, FileUtils.S_IRWXU}, new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 160, C33250az.CTRL_INDEX, 224, 256, 320, 384}, new int[]{0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, C33250az.CTRL_INDEX, 224, 256, 320}};
        r0[1] = new int[][]{new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, ErrorCode.NEEDDOWNLOAD_FALSE_6, C33250az.CTRL_INDEX, 224, 256}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}};
        BitrateTable = r0;
    }

    public static int parseFrameInfo(TrackPositionDataSource trackPositionDataSource, Mp3Info mp3Info) {
        AppMethodBeat.m2504i(128498);
        if (trackPositionDataSource == null) {
            AppMethodBeat.m2505o(128498);
            return -1;
        }
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        if (trackPositionDataSource.read(bArr, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            AppMethodBeat.m2505o(128498);
            return -2;
        }
        if (Mp3DecodeBase.hasId3v2(bArr, 4)) {
            Logger.m71025i(TAG, "hasId3v2");
            skipId3v2(trackPositionDataSource, bArr, mp3Info);
        } else {
            trackPositionDataSource.seek(0);
        }
        int i = 0;
        long size = trackPositionDataSource.getSize();
        long j = (long) mp3Info.idv2Size;
        if (j > 0 && size > j) {
            size -= j;
        }
        while (true) {
            long curPosition = trackPositionDataSource.getCurPosition();
            if (j > 0) {
                curPosition -= j;
            }
            if (curPosition >= size / 10) {
                AppMethodBeat.m2505o(128498);
                return -3;
            } else if (i < 3 || trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() - 3) >= 0) {
                int read = trackPositionDataSource.read(bArr, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                if (read == -1) {
                    mp3Info.firstFramePosition = -1;
                    AppMethodBeat.m2505o(128498);
                    return -3;
                }
                i += read;
                int i2 = 0;
                while (i2 + 4 <= read) {
                    if (255 == (bArr[i2] & 255) && 224 == (bArr[i2 + 1] & 224) && IsMp3Header(trackPositionDataSource, bArr, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, i2, mp3Info)) {
                        mp3Info.firstFramePosition = (long) (((mp3Info.idv2Size + i) - read) + i2);
                        Logger.m71025i(TAG, "FirstFramePos = " + mp3Info.firstFramePosition);
                        if (trackPositionDataSource.seek(mp3Info.firstFramePosition) < 0) {
                            AppMethodBeat.m2505o(128498);
                            return -1;
                        }
                        boolean parseVBRFrameInfo = parseVBRFrameInfo(trackPositionDataSource, mp3Info);
                        if (trackPositionDataSource.seek(0) < 0 || !parseVBRFrameInfo) {
                            AppMethodBeat.m2505o(128498);
                            return -1;
                        }
                        AppMethodBeat.m2505o(128498);
                        return 0;
                    }
                    i2++;
                }
            } else {
                AppMethodBeat.m2505o(128498);
                return -3;
            }
        }
    }

    private static void skipId3v2(TrackPositionDataSource trackPositionDataSource, byte[] bArr, Mp3Info mp3Info) {
        AppMethodBeat.m2504i(128499);
        if (trackPositionDataSource == null || bArr == null) {
            AppMethodBeat.m2505o(128499);
            return;
        }
        if (bArr[0] == (byte) 73 && bArr[1] == (byte) 68 && bArr[2] == (byte) 51) {
            int i;
            int i2 = ((((bArr[6] & C31128d.MIC_SketchMark) << 21) + ((bArr[7] & C31128d.MIC_SketchMark) << 14)) + ((bArr[8] & C31128d.MIC_SketchMark) << 7)) + (bArr[9] & C31128d.MIC_SketchMark);
            if ((bArr[5] & 16) != 0) {
                i = i2 + 20;
                i2 = 1;
            } else {
                i = i2 + 10;
                i2 = 0;
            }
            if (trackPositionDataSource.seek((long) i) < 0) {
                AppMethodBeat.m2505o(128499);
                return;
            }
            if (i2 == 0) {
                byte[] bArr2 = new byte[1];
                i2 = trackPositionDataSource.read(bArr2, 1);
                while (bArr2[0] == (byte) 0 && r0 == 1) {
                    i++;
                    i2 = trackPositionDataSource.read(bArr2, 1);
                }
            }
            mp3Info.idv2Size = i;
            Logger.m71025i(TAG, "id3V2 Size: " + mp3Info.idv2Size);
            trackPositionDataSource.seek((long) i);
        }
        AppMethodBeat.m2505o(128499);
    }

    private static boolean IsMp3Header(TrackPositionDataSource trackPositionDataSource, byte[] bArr, int i, int i2, Mp3Info mp3Info) {
        AppMethodBeat.m2504i(128500);
        if (bArr == null || mp3Info == null) {
            AppMethodBeat.m2505o(128500);
            return false;
        }
        int i3 = (bArr[i2 + 1] >> 3) & 3;
        if (1 == i3) {
            AppMethodBeat.m2505o(128500);
            return false;
        }
        int i4 = (bArr[i2 + 1] >> 1) & 3;
        if (i4 == 0) {
            AppMethodBeat.m2505o(128500);
            return false;
        }
        int i5 = 4 - i4;
        int i6 = (bArr[i2 + 2] >> 4) & 15;
        if (15 == i6) {
            AppMethodBeat.m2505o(128500);
            return false;
        }
        int i7 = (bArr[i2 + 2] >> 2) & 3;
        if (3 == i7) {
            AppMethodBeat.m2505o(128500);
            return false;
        }
        int i8 = (bArr[i2 + 3] >> 6) & 3;
        int i9 = (bArr[i2 + 2] >> 1) & 1;
        int i10 = i3 == 3 ? 0 : 1;
        if (1 == i5) {
            i4 = (((BitrateTable[i10][0][i6] * 12000) / SAMPLE_RATE_TABLE[i3][i7]) + i9) << 2;
        } else if (2 == i5) {
            i4 = ((BitrateTable[i10][1][i6] * 144000) / SAMPLE_RATE_TABLE[i3][i7]) + i9;
        } else {
            i4 = ((BitrateTable[i10][2][i6] * 144000) / (SAMPLE_RATE_TABLE[i3][i7] << i10)) + i9;
        }
        if (i4 > 0) {
            long curPosition = trackPositionDataSource.getCurPosition();
            if (trackPositionDataSource.seek(((curPosition - ((long) i)) + ((long) i2)) + ((long) i4)) < 0) {
                AppMethodBeat.m2505o(128500);
                return false;
            }
            byte[] bArr2 = new byte[4];
            if (trackPositionDataSource.read(bArr2, 4) == -1) {
                AppMethodBeat.m2505o(128500);
                return false;
            }
            int readInt = Mp3DecodeBase.readInt(bArr, i2, 4);
            i9 = Mp3DecodeBase.readInt(bArr2, 4);
            trackPositionDataSource.seek(curPosition);
            if (readInt == 0 || i9 == 0 || (-128000 & readInt) != (i9 & -128000)) {
                AppMethodBeat.m2505o(128500);
                return false;
            }
            Logger.m71025i(TAG, "FirstFrameSize = ".concat(String.valueOf(i4)));
            mp3Info.firstFrameSize = (long) i4;
            i4 = 0;
            if (i3 == 3) {
                i4 = 0;
            } else if (i3 == 2) {
                i4 = 1;
            } else if (i3 == 0) {
                i4 = 2;
            }
            mp3Info.mpeg_version = i4;
            mp3Info.layer = i5;
            mp3Info.sample_rate = (long) SAMPLE_RATE_TABLE[i3][i7];
            mp3Info.bit_rate = BitrateTable[i10][i5 - 1][i6];
            mp3Info.channels = i8 == 3 ? 1 : 2;
            AppMethodBeat.m2505o(128500);
            return true;
        }
        mp3Info.firstFrameSize = -1;
        AppMethodBeat.m2505o(128500);
        return false;
    }

    private static boolean parseVBRFrameInfo(TrackPositionDataSource trackPositionDataSource, Mp3Info mp3Info) {
        AppMethodBeat.m2504i(128501);
        if (trackPositionDataSource == null || mp3Info == null) {
            AppMethodBeat.m2505o(128501);
            return false;
        }
        long j = mp3Info.sample_rate;
        int i = mp3Info.channels;
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        long j2 = mp3Info.mpeg_version == 0 ? i != 1 ? 36 : 21 : i != 1 ? 21 : 13;
        if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() + j2) < 0) {
            AppMethodBeat.m2505o(128501);
            return false;
        } else if (trackPositionDataSource.read(bArr, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            AppMethodBeat.m2505o(128501);
            return false;
        } else {
            if (Mp3DecodeBase.isXingVBRheader(bArr, 4)) {
                Logger.m71025i(TAG, "is Xing VBR");
                mp3Info.VBRType = 2;
                mp3Info.isVbr = 1;
                parseXingInfo(bArr, j, mp3Info);
            } else if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() - (j2 + 1024)) < 0) {
                AppMethodBeat.m2505o(128501);
                return false;
            } else if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() + 36) < 0) {
                AppMethodBeat.m2505o(128501);
                return false;
            } else if (trackPositionDataSource.read(bArr, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                AppMethodBeat.m2505o(128501);
                return false;
            } else if (Mp3DecodeBase.isVBRIVBRHeader(bArr, 4)) {
                Logger.m71025i(TAG, "is VBRI VBR");
                mp3Info.VBRType = 1;
                mp3Info.isVbr = 1;
                parseVBRIInfo(mp3Info, bArr, j);
            } else {
                Logger.m71025i(TAG, "is CBR");
                mp3Info.VBRType = 0;
                j2 = trackPositionDataSource.getSize();
                if (mp3Info.fileLengthInBytes <= 0) {
                    mp3Info.fileLengthInBytes = j2;
                }
                mp3Info.duration = (long) ((((float) (mp3Info.fileLengthInBytes - ((long) mp3Info.idv2Size))) * 8.0f) / ((float) mp3Info.bit_rate));
            }
            AppMethodBeat.m2505o(128501);
            return true;
        }
    }

    private static void parseXingInfo(byte[] bArr, long j, Mp3Info mp3Info) {
        AppMethodBeat.m2504i(128502);
        if (bArr == null || mp3Info == null) {
            AppMethodBeat.m2505o(128502);
            return;
        }
        int i;
        long[] jArr = null;
        int readInt = Mp3DecodeBase.readInt(bArr, 4, 4);
        int i2 = 8;
        if ((readInt & 1) == 1) {
            long readLong = Mp3DecodeBase.readLong(bArr, 8, 4) - 1;
            if (readLong > 0 && j > 0) {
                i2 = mp3Info.mpeg_version;
                i = mp3Info.layer - 1;
                mp3Info.lengthInFrames = readLong;
                mp3Info.duration = (long) (((((double) (readLong * ((long) SAMPLE_PER_FRAME[i2][i]))) * 1.0d) / ((double) j)) * 1000.0d);
            }
            i2 = 12;
        }
        if ((readInt & 2) == 2) {
            mp3Info.fileLengthInBytes = Mp3DecodeBase.readLong(bArr, i2, 4);
            i = i2 + 4;
        } else {
            i = i2;
        }
        if ((readInt & 4) == 4) {
            jArr = new long[100];
            for (i2 = 0; i2 < 100; i2++) {
                jArr[i2] = (long) (bArr[i2 + i] & 255);
            }
        }
        if (readInt > 0 && jArr != null) {
            mp3Info.toc_table = jArr;
            mp3Info.flag_value = readInt;
        }
        AppMethodBeat.m2505o(128502);
    }

    private static void parseVBRIInfo(Mp3Info mp3Info, byte[] bArr, long j) {
        AppMethodBeat.m2504i(128503);
        if (bArr == null || mp3Info == null) {
            AppMethodBeat.m2505o(128503);
            return;
        }
        int i;
        int i2;
        long readLong = Mp3DecodeBase.readLong(bArr, 10, 4);
        mp3Info.fileLengthInBytes = readLong;
        long readLong2 = Mp3DecodeBase.readLong(bArr, 14, 4);
        if (readLong2 > 0 && j > 0) {
            i = mp3Info.mpeg_version;
            i2 = mp3Info.layer - 1;
            mp3Info.lengthInFrames = readLong2;
            mp3Info.duration = (long) (((((double) (readLong2 * ((long) SAMPLE_PER_FRAME[i][i2]))) * 1.0d) / ((double) j)) * 1000.0d);
        }
        int readShort = Mp3DecodeBase.readShort(bArr, 18, 2);
        int readShort2 = Mp3DecodeBase.readShort(bArr, 20, 2);
        int readShort3 = Mp3DecodeBase.readShort(bArr, 22, 2);
        i = 24;
        if (readShort > 0 && readShort2 > 0) {
            int i3 = readShort + 1;
            long[] jArr = new long[i3];
            int i4 = 0;
            if (mp3Info.firstFramePosition > 0) {
                i4 = (int) (0 + mp3Info.firstFramePosition);
            }
            if (mp3Info.firstFrameSize > 0) {
                i4 = (int) (((long) i4) + mp3Info.firstFrameSize);
            }
            i2 = 1;
            int i5 = i4;
            while (i2 < i3) {
                i4 = -1;
                if (readShort3 == 1) {
                    i4 = Mp3DecodeBase.readByte(bArr, i, 1);
                    i++;
                } else if (readShort3 == 2) {
                    i4 = Mp3DecodeBase.readShort(bArr, i, 2);
                    i += 2;
                } else if (readShort3 == 3) {
                    i4 = Mp3DecodeBase.readUnsignedInt24(bArr, i, 3);
                    i += 3;
                } else if (readShort3 == 4) {
                    i4 = Mp3DecodeBase.readInt(bArr, i, 4);
                    i += 4;
                } else {
                    jArr = null;
                }
                if (i4 < 0) {
                    break;
                }
                i4 = (i4 * readShort2) + i5;
                if (((long) i4) >= readLong) {
                    i4 = (int) readLong;
                }
                jArr[i2] = (long) i4;
                i2++;
                i5 = i4;
            }
            long[] jArr2 = jArr;
            mp3Info.entry_count = readShort;
            mp3Info.entry_size = readShort3;
            mp3Info.scale_factor = readShort2;
            mp3Info.toc_table = jArr2;
        }
        AppMethodBeat.m2505o(128503);
    }
}
