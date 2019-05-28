package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

public class PcmConvertionUtil {
    public static void convertBitDepthTo16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i) {
        AppMethodBeat.m2504i(111097);
        switch (i) {
            case 2:
                checkBufferLength(bufferInfo);
                bufferInfo.copy(bufferInfo2);
                AppMethodBeat.m2505o(111097);
                return;
            case 3:
                convertBitDepth24To16(bufferInfo, bufferInfo2, i);
                AppMethodBeat.m2505o(111097);
                return;
            case 4:
                convertBitDepth32To16(bufferInfo, bufferInfo2, i);
                AppMethodBeat.m2505o(111097);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not support originBitDepth, originBitDepth=".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(111097);
                throw illegalArgumentException;
        }
    }

    private static void convertBitDepth24To16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i) {
        AppMethodBeat.m2504i(111098);
        checkBufferLength(bufferInfo);
        IllegalArgumentException illegalArgumentException;
        if (bufferInfo2 == null) {
            illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.m2505o(111098);
            throw illegalArgumentException;
        } else if (i != 3) {
            illegalArgumentException = new IllegalArgumentException("origin bit depth must be 3");
            AppMethodBeat.m2505o(111098);
            throw illegalArgumentException;
        } else {
            int i2 = bufferInfo.bufferSize;
            bufferInfo2.setTempByteBufferCapacity(bufferInfo.bufferSize);
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5;
                if (i3 % 3 != 0) {
                    i5 = i4 + 1;
                    bufferInfo2.tempByteBuffer[i4] = bufferInfo.byteBuffer[i3];
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
            }
            bufferInfo2.fillByte(bufferInfo2.tempByteBuffer, i4);
            bufferInfo2.bufferSize = i4;
            AppMethodBeat.m2505o(111098);
        }
    }

    private static void convertBitDepth32To16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i) {
        AppMethodBeat.m2504i(111099);
        checkBufferLength(bufferInfo);
        IllegalArgumentException illegalArgumentException;
        if (bufferInfo2 == null) {
            illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.m2505o(111099);
            throw illegalArgumentException;
        } else if (i != 4) {
            illegalArgumentException = new IllegalArgumentException("origin bit depth must be 4");
            AppMethodBeat.m2505o(111099);
            throw illegalArgumentException;
        } else {
            int i2 = bufferInfo.bufferSize;
            bufferInfo2.setTempByteBufferCapacity(bufferInfo.bufferSize);
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                DataConversionUtil.floatTo2Bytes(DataConversionUtil.bytesToFloat32bitInLittleEndian(bufferInfo.byteBuffer, i3), bufferInfo2.tempByteBuffer, i4);
                i3 += 4;
                i4 += 2;
            }
            bufferInfo2.fillByte(bufferInfo2.tempByteBuffer, i4);
            bufferInfo2.bufferSize = i4;
            AppMethodBeat.m2505o(111099);
        }
    }

    public static void convertByteBufferToFloatBuffer(BufferInfo bufferInfo, FloatBufferInfo floatBufferInfo, int i) {
        AppMethodBeat.m2504i(111100);
        checkBufferLength(bufferInfo);
        IllegalArgumentException illegalArgumentException;
        if (floatBufferInfo == null) {
            illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.m2505o(111100);
            throw illegalArgumentException;
        } else if (i <= 0) {
            illegalArgumentException = new IllegalArgumentException("bit depth must not be zero");
            AppMethodBeat.m2505o(111100);
            throw illegalArgumentException;
        } else {
            floatBufferInfo.setTempFloatBufferCapacity(bufferInfo.bufferSize / i);
            floatBufferInfo.bufferSize = bufferInfo.bufferSize / i;
            DataConversionUtil.byteArrayToFloatArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, i, floatBufferInfo.tempFloatBuffer);
            floatBufferInfo.fillFloat(floatBufferInfo.tempFloatBuffer, floatBufferInfo.bufferSize);
            AppMethodBeat.m2505o(111100);
        }
    }

    public static void reSample(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j, long j2, int i) {
        AppMethodBeat.m2504i(111101);
        checkBufferLength(bufferInfo);
        if (bufferInfo2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("BufferInfo dest must not be null");
            AppMethodBeat.m2505o(111101);
            throw illegalArgumentException;
        } else if (j == j2 || j2 <= 0 || j <= 0) {
            bufferInfo.copy(bufferInfo2);
            AppMethodBeat.m2505o(111101);
        } else {
            switch (i) {
                case 2:
                    interpolateIn16Bit(bufferInfo, bufferInfo2, j, j2);
                    AppMethodBeat.m2505o(111101);
                    return;
                case 3:
                    interpolateIn24Bit(bufferInfo, bufferInfo2, j, j2);
                    AppMethodBeat.m2505o(111101);
                    return;
                case 4:
                    interpolateIn32Bit(bufferInfo, bufferInfo2, j, j2);
                    AppMethodBeat.m2505o(111101);
                    return;
                default:
                    bufferInfo.copy(bufferInfo2);
                    AppMethodBeat.m2505o(111101);
                    return;
            }
        }
    }

    private static void interpolateIn16Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j, long j2) {
        AppMethodBeat.m2504i(111102);
        int i = bufferInfo.bufferSize / 2;
        int round = Math.round(((1.0f * ((float) i)) / ((float) j)) * ((float) j2));
        float f = ((float) round) / ((float) i);
        short[] sArr = new short[i];
        short[] sArr2 = new short[round];
        DataConversionUtil.byteArray16BitToShortArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, sArr);
        linearInterpolate(sArr, i, sArr2, round, f);
        byte[] bArr = new byte[(round * 2)];
        DataConversionUtil.shortArrayToByteArray16Bit(sArr2, round, bArr);
        bufferInfo2.fillByte(bArr, bArr.length);
        AppMethodBeat.m2505o(111102);
    }

    private static void interpolateIn24Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j, long j2) {
        AppMethodBeat.m2504i(111103);
        int i = bufferInfo.bufferSize / 3;
        int round = Math.round(((1.0f * ((float) i)) / ((float) j)) * ((float) j2));
        float f = ((float) round) / ((float) i);
        int[] iArr = new int[i];
        int[] iArr2 = new int[round];
        DataConversionUtil.byteArray24BitToIntArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, iArr);
        linearInterpolate(iArr, i, iArr2, round, f);
        byte[] bArr = new byte[(round * 3)];
        DataConversionUtil.intArrayToByteArray24Bit(iArr2, round, bArr);
        bufferInfo2.fillByte(bArr, bArr.length);
        AppMethodBeat.m2505o(111103);
    }

    private static void interpolateIn32Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j, long j2) {
        AppMethodBeat.m2504i(111104);
        int i = bufferInfo.bufferSize / 4;
        int round = Math.round(((1.0f * ((float) i)) / ((float) j)) * ((float) j2));
        float f = ((float) round) / ((float) i);
        int[] iArr = new int[i];
        int[] iArr2 = new int[round];
        DataConversionUtil.byteArray32BitToIntArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, iArr);
        linearInterpolate(iArr, i, iArr2, round, f);
        byte[] bArr = new byte[(round * 4)];
        DataConversionUtil.intArrayToByteArray32Bit(iArr2, round, bArr);
        bufferInfo2.fillByte(bArr, bArr.length);
        AppMethodBeat.m2505o(111104);
    }

    private static void linearInterpolate(int[] iArr, int i, int[] iArr2, int i2, float f) {
        AppMethodBeat.m2504i(111105);
        checkArrayLength(iArr, i);
        checkArrayLength(iArr2, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            float f2 = ((float) i3) / f;
            int i4 = (int) f2;
            int i5 = i4 + 1;
            if (i5 >= i) {
                i5 = i - 1;
            }
            iArr2[i3] = (int) ((((float) (iArr[i5] - iArr[i4])) * (f2 - ((float) i4))) + ((float) iArr[i4]));
        }
        AppMethodBeat.m2505o(111105);
    }

    private static void linearInterpolate(short[] sArr, int i, short[] sArr2, int i2, float f) {
        AppMethodBeat.m2504i(111106);
        checkArrayLength(sArr, i);
        checkArrayLength(sArr2, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            float f2 = ((float) i3) / f;
            int i4 = (int) f2;
            int i5 = i4 + 1;
            if (i5 >= i) {
                i5 = i - 1;
            }
            sArr2[i3] = (short) ((int) ((((float) (sArr[i5] - sArr[i4])) * (f2 - ((float) i4))) + ((float) sArr[i4])));
        }
        AppMethodBeat.m2505o(111106);
    }

    private static void checkBufferLength(BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(111107);
        if (bufferInfo == null || bufferInfo.byteBuffer == null || bufferInfo.bufferSize <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bufferInfo must not be null or zero length");
            AppMethodBeat.m2505o(111107);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(111107);
    }

    private static void checkArrayLength(int[] iArr, int i) {
        AppMethodBeat.m2504i(111108);
        IllegalArgumentException illegalArgumentException;
        if (iArr == null || iArr.length == 0) {
            illegalArgumentException = new IllegalArgumentException("int Array must not be null or zero length");
            AppMethodBeat.m2505o(111108);
            throw illegalArgumentException;
        } else if (i > iArr.length) {
            illegalArgumentException = new IllegalArgumentException("the length param can not larger than int Array length. param:" + i + ", int array length:" + iArr.length);
            AppMethodBeat.m2505o(111108);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(111108);
        }
    }

    private static void checkArrayLength(short[] sArr, int i) {
        AppMethodBeat.m2504i(111109);
        IllegalArgumentException illegalArgumentException;
        if (sArr == null || sArr.length == 0) {
            illegalArgumentException = new IllegalArgumentException("short Array must not be null or zero length");
            AppMethodBeat.m2505o(111109);
            throw illegalArgumentException;
        } else if (i > sArr.length) {
            illegalArgumentException = new IllegalArgumentException("the length param can not larger than short Array length. param:" + i + ", short array length:" + sArr.length);
            AppMethodBeat.m2505o(111109);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(111109);
        }
    }
}
