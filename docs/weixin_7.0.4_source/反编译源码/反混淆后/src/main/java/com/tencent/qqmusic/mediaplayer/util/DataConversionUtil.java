package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;

public class DataConversionUtil {
    private static final float BASE_16BIT = 32768.0f;
    private static final float BASE_32BIT = 2.14748365E9f;
    private static final boolean IS_LITTLE_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);

    static {
        AppMethodBeat.m2504i(105541);
        AppMethodBeat.m2505o(105541);
    }

    public static float bytesToFloat24bit(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105522);
        float bytesToFloat24bitInLittleEndian;
        if (IS_LITTLE_ENDIAN) {
            bytesToFloat24bitInLittleEndian = bytesToFloat24bitInLittleEndian(bArr, i);
            AppMethodBeat.m2505o(105522);
            return bytesToFloat24bitInLittleEndian;
        }
        bytesToFloat24bitInLittleEndian = bytesToFloat24bitInBigEndian(bArr, i);
        AppMethodBeat.m2505o(105522);
        return bytesToFloat24bitInLittleEndian;
    }

    public static float bytesToFloat32bit(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105523);
        float bytesToFloat32bitInLittleEndian;
        if (IS_LITTLE_ENDIAN) {
            bytesToFloat32bitInLittleEndian = bytesToFloat32bitInLittleEndian(bArr, i);
            AppMethodBeat.m2505o(105523);
            return bytesToFloat32bitInLittleEndian;
        }
        bytesToFloat32bitInLittleEndian = bytesToFloat32bitInBigEndian(bArr, i);
        AppMethodBeat.m2505o(105523);
        return bytesToFloat32bitInLittleEndian;
    }

    public static float bytesToFloat24bitInLittleEndian(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105524);
        float bytesToInt24bitInLittleEndian = ((float) bytesToInt24bitInLittleEndian(bArr, i)) / BASE_32BIT;
        AppMethodBeat.m2505o(105524);
        return bytesToInt24bitInLittleEndian;
    }

    public static float bytesToFloat24bitInBigEndian(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105525);
        float bytesToInt24bitInBigEndian = ((float) bytesToInt24bitInBigEndian(bArr, i)) / BASE_32BIT;
        AppMethodBeat.m2505o(105525);
        return bytesToInt24bitInBigEndian;
    }

    public static float bytesToFloat32bitInLittleEndian(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105526);
        float bytesToInt32bitInLittleEndian = ((float) bytesToInt32bitInLittleEndian(bArr, i)) / BASE_32BIT;
        AppMethodBeat.m2505o(105526);
        return bytesToInt32bitInLittleEndian;
    }

    public static float bytesToFloat32bitInBigEndian(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105527);
        float bytesToInt32bitInBigEndian = ((float) bytesToInt32bitInBigEndian(bArr, i)) / BASE_32BIT;
        AppMethodBeat.m2505o(105527);
        return bytesToInt32bitInBigEndian;
    }

    public static short bytesToShort16bitInLittleEndian(byte[] bArr, int i) {
        return (short) ((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8));
    }

    public static short bytesToShort16bitInBigEndian(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public static int bytesToInt24bitInLittleEndian(byte[] bArr, int i) {
        return (((bArr[i] << 8) & 255) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 24);
    }

    public static int bytesToInt24bitInBigEndian(byte[] bArr, int i) {
        return (((bArr[i + 2] << 8) & 255) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i] & 255) << 24);
    }

    public static int bytesToInt32bitInLittleEndian(byte[] bArr, int i) {
        return (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
    }

    public static int bytesToInt32bitInBigEndian(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) | ((bArr[i + 2] & 255) << 8)) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i] & 255) << 24);
    }

    public static void floatTo2Bytes(float f, byte[] bArr, int i) {
        float f2 = 1.0f;
        float f3 = -1.0f;
        AppMethodBeat.m2504i(105528);
        if (f <= 1.0f) {
            f2 = f;
        }
        if (f2 >= -1.0f) {
            f3 = f2;
        }
        shortTo2Bytes((short) ((int) (f3 * BASE_16BIT)), bArr, i);
        AppMethodBeat.m2505o(105528);
    }

    public static void shortTo2Bytes(short s, byte[] bArr, int i) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i] = (byte) (s & 255);
            bArr[i + 1] = (byte) ((s >> 8) & 255);
            return;
        }
        bArr[i + 1] = (byte) (s & 255);
        bArr[i] = (byte) ((s >> 8) & 255);
    }

    public static void intTo3Bytes(int i, byte[] bArr, int i2) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i2] = (byte) ((i >> 8) & 255);
            bArr[i2 + 1] = (byte) ((i >> 16) & 255);
            bArr[i2 + 2] = (byte) ((i >> 24) & 255);
            return;
        }
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2] = (byte) ((i >> 24) & 255);
    }

    public static void intTo4Bytes(int i, byte[] bArr, int i2) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            return;
        }
        bArr[i2 + 3] = (byte) (i & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2] = (byte) ((i >> 24) & 255);
    }

    public static int byteArrayToFloatArray(byte[] bArr, int i, int i2, float[] fArr) {
        AppMethodBeat.m2504i(105529);
        checkByteArrayLength(bArr, i);
        checkFloatArrayLength(fArr, i / i2);
        checkByteArrayProperty(i, i2);
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            float bytesToFloat24bit;
            int i5 = i3 / i2;
            if (i2 == 3) {
                bytesToFloat24bit = bytesToFloat24bit(bArr, i3);
            } else {
                bytesToFloat24bit = bytesToFloat32bit(bArr, i3);
            }
            fArr[i5] = bytesToFloat24bit;
            i4++;
            i3 += i2;
        }
        AppMethodBeat.m2505o(105529);
        return i4;
    }

    public static int byteArray16BitToShortArray(byte[] bArr, int i, short[] sArr) {
        AppMethodBeat.m2504i(105530);
        checkByteArrayLength(bArr, i);
        checkShortArrayLength(sArr, i / 2);
        if (i % 2 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of 2");
            AppMethodBeat.m2505o(105530);
            throw illegalArgumentException;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i && i2 < sArr.length; i3 += 2) {
            short bytesToShort16bitInLittleEndian;
            if (IS_LITTLE_ENDIAN) {
                bytesToShort16bitInLittleEndian = bytesToShort16bitInLittleEndian(bArr, i3);
            } else {
                bytesToShort16bitInLittleEndian = bytesToShort16bitInBigEndian(bArr, i3);
            }
            sArr[i2] = bytesToShort16bitInLittleEndian;
            i2++;
        }
        AppMethodBeat.m2505o(105530);
        return i2;
    }

    public static int byteArray24BitToIntArray(byte[] bArr, int i, int[] iArr) {
        AppMethodBeat.m2504i(105531);
        checkByteArrayLength(bArr, i);
        checkIntArrayLength(iArr, i / 3);
        if (i % 3 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of 3");
            AppMethodBeat.m2505o(105531);
            throw illegalArgumentException;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i && i2 < iArr.length; i3 += 3) {
            int bytesToInt24bitInLittleEndian;
            if (IS_LITTLE_ENDIAN) {
                bytesToInt24bitInLittleEndian = bytesToInt24bitInLittleEndian(bArr, i3);
            } else {
                bytesToInt24bitInLittleEndian = bytesToInt24bitInBigEndian(bArr, i3);
            }
            iArr[i2] = bytesToInt24bitInLittleEndian;
            i2++;
        }
        AppMethodBeat.m2505o(105531);
        return i2;
    }

    public static int byteArray32BitToIntArray(byte[] bArr, int i, int[] iArr) {
        AppMethodBeat.m2504i(105532);
        checkByteArrayLength(bArr, i);
        checkIntArrayLength(iArr, i / 4);
        if (i % 4 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of 4");
            AppMethodBeat.m2505o(105532);
            throw illegalArgumentException;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i && i2 < iArr.length; i3 += 4) {
            int bytesToInt32bitInLittleEndian;
            if (IS_LITTLE_ENDIAN) {
                bytesToInt32bitInLittleEndian = bytesToInt32bitInLittleEndian(bArr, i3);
            } else {
                bytesToInt32bitInLittleEndian = bytesToInt32bitInBigEndian(bArr, i3);
            }
            iArr[i2] = bytesToInt32bitInLittleEndian;
            i2++;
        }
        AppMethodBeat.m2505o(105532);
        return i2;
    }

    public static int shortArrayToByteArray16Bit(short[] sArr, int i, byte[] bArr) {
        AppMethodBeat.m2504i(105533);
        checkShortArrayLength(sArr, i);
        checkByteArrayLength(bArr, i * 2);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            shortTo2Bytes(sArr[i2], bArr, i3);
            i2++;
            i3 += 2;
        }
        AppMethodBeat.m2505o(105533);
        return i3;
    }

    public static int intArrayToByteArray24Bit(int[] iArr, int i, byte[] bArr) {
        AppMethodBeat.m2504i(105534);
        checkIntArrayLength(iArr, i);
        checkByteArrayLength(bArr, i * 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            intTo3Bytes(iArr[i2], bArr, i3);
            i2++;
            i3 += 3;
        }
        AppMethodBeat.m2505o(105534);
        return i3;
    }

    public static int intArrayToByteArray32Bit(int[] iArr, int i, byte[] bArr) {
        AppMethodBeat.m2504i(105535);
        checkIntArrayLength(iArr, i);
        checkByteArrayLength(bArr, i * 4);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            intTo4Bytes(iArr[i2], bArr, i3);
            i2++;
            i3 += 4;
        }
        AppMethodBeat.m2505o(105535);
        return i3;
    }

    private static void checkByteArrayProperty(int i, int i2) {
        AppMethodBeat.m2504i(105536);
        IllegalArgumentException illegalArgumentException;
        if (i2 > 4 || i2 < 3) {
            illegalArgumentException = new IllegalArgumentException("bytesPerSample of " + i2 + " is not supported");
            AppMethodBeat.m2505o(105536);
            throw illegalArgumentException;
        } else if (i % i2 != 0) {
            illegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of bytesPerSample");
            AppMethodBeat.m2505o(105536);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(105536);
        }
    }

    private static void checkByteArrayLength(byte[] bArr, int i) {
        AppMethodBeat.m2504i(105537);
        IllegalArgumentException illegalArgumentException;
        if (bArr == null || bArr.length == 0) {
            illegalArgumentException = new IllegalArgumentException("byte Array must not be null or zero length");
            AppMethodBeat.m2505o(105537);
            throw illegalArgumentException;
        } else if (i > bArr.length) {
            illegalArgumentException = new IllegalArgumentException("the length param can not larger than byte Array length. param:" + i + ", byte array length:" + bArr.length);
            AppMethodBeat.m2505o(105537);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(105537);
        }
    }

    private static void checkShortArrayLength(short[] sArr, int i) {
        AppMethodBeat.m2504i(105538);
        IllegalArgumentException illegalArgumentException;
        if (sArr == null || sArr.length == 0) {
            illegalArgumentException = new IllegalArgumentException("short Array must not be null or zero length");
            AppMethodBeat.m2505o(105538);
            throw illegalArgumentException;
        } else if (i > sArr.length) {
            illegalArgumentException = new IllegalArgumentException("the length param can not larger than short Array length. param:" + i + ", short array length:" + sArr.length);
            AppMethodBeat.m2505o(105538);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(105538);
        }
    }

    private static void checkIntArrayLength(int[] iArr, int i) {
        AppMethodBeat.m2504i(105539);
        IllegalArgumentException illegalArgumentException;
        if (iArr == null || iArr.length == 0) {
            illegalArgumentException = new IllegalArgumentException("int Array must not be null or zero length");
            AppMethodBeat.m2505o(105539);
            throw illegalArgumentException;
        } else if (i > iArr.length) {
            illegalArgumentException = new IllegalArgumentException("the length param can not larger than int Array length. param:" + i + ", int array length:" + iArr.length);
            AppMethodBeat.m2505o(105539);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(105539);
        }
    }

    private static void checkFloatArrayLength(float[] fArr, int i) {
        AppMethodBeat.m2504i(105540);
        IllegalArgumentException illegalArgumentException;
        if (fArr == null || fArr.length == 0) {
            illegalArgumentException = new IllegalArgumentException("float Array must not be null or zero length");
            AppMethodBeat.m2505o(105540);
            throw illegalArgumentException;
        } else if (i > fArr.length) {
            illegalArgumentException = new IllegalArgumentException("the length param can not larger than float Array length. param:" + i + ", float array length:" + fArr.length);
            AppMethodBeat.m2505o(105540);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(105540);
        }
    }
}
