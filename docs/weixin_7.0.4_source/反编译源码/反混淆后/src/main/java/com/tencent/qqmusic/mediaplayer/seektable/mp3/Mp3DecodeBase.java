package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;

class Mp3DecodeBase {
    Mp3DecodeBase() {
    }

    static boolean hasId3v2(byte[] bArr, int i) {
        if (bArr == null || i < 3) {
            return false;
        }
        if (bArr[0] == (byte) 73 && bArr[1] == (byte) 68 && bArr[2] == (byte) 51) {
            return true;
        }
        return false;
    }

    static boolean isXingVBRheader(byte[] bArr, int i) {
        if (bArr == null || i < 4) {
            return false;
        }
        if (bArr[0] == (byte) 88 && bArr[1] == (byte) 105 && bArr[2] == (byte) 110 && bArr[3] == (byte) 103) {
            return true;
        }
        if (bArr[0] == (byte) 73 && bArr[1] == (byte) 110 && bArr[2] == (byte) 102 && bArr[3] == (byte) 111) {
            return true;
        }
        return false;
    }

    static boolean isVBRIVBRHeader(byte[] bArr, int i) {
        if (bArr == null || i < 4) {
            return false;
        }
        if (bArr[0] == (byte) 86 && bArr[1] == (byte) 66 && bArr[2] == (byte) 82 && bArr[3] == (byte) 73) {
            return true;
        }
        return false;
    }

    static int readInt(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 < 4 || bArr.length < i + i2) {
            return -1;
        }
        return ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
    }

    static int readInt(byte[] bArr, int i) {
        AppMethodBeat.m2504i(128493);
        int readInt = readInt(bArr, 0, i);
        AppMethodBeat.m2505o(128493);
        return readInt;
    }

    static long readLong(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 < 4 || bArr.length < i + i2) {
            return -1;
        }
        return (long) (((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255));
    }

    static long readLong(byte[] bArr, int i) {
        AppMethodBeat.m2504i(128494);
        long readLong = readLong(bArr, 0, i);
        AppMethodBeat.m2505o(128494);
        return readLong;
    }

    static int readUnsignedInt24(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 < 3 || bArr.length < i + i2) {
            return -1;
        }
        return (((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8)) | (bArr[i + 2] & 255);
    }

    static int readUnsignedInt24(byte[] bArr, int i) {
        AppMethodBeat.m2504i(128495);
        int readUnsignedInt24 = readUnsignedInt24(bArr, 0, i);
        AppMethodBeat.m2505o(128495);
        return readUnsignedInt24;
    }

    static int readShort(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 < 2 || bArr.length < i + i2) {
            return -1;
        }
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    static int readShort(byte[] bArr, int i) {
        AppMethodBeat.m2504i(128496);
        int readShort = readShort(bArr, 0, i);
        AppMethodBeat.m2505o(128496);
        return readShort;
    }

    static int readByte(byte[] bArr, int i) {
        AppMethodBeat.m2504i(128497);
        int readByte = readByte(bArr, 0, i);
        AppMethodBeat.m2505o(128497);
        return readByte;
    }

    static int readByte(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 <= 0 || bArr.length < i + i2) {
            return -1;
        }
        return bArr[i] & 255;
    }
}
