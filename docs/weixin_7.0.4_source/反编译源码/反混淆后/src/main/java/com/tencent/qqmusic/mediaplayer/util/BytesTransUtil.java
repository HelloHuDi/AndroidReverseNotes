package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;

public class BytesTransUtil {
    private static BytesTransUtil instance = null;
    private String TAG = "BytesTransUtil";

    private BytesTransUtil() {
    }

    public static BytesTransUtil getInstance() {
        AppMethodBeat.m2504i(105543);
        if (instance == null) {
            instance = new BytesTransUtil();
        }
        BytesTransUtil bytesTransUtil = instance;
        AppMethodBeat.m2505o(105543);
        return bytesTransUtil;
    }

    public boolean testCPU() {
        AppMethodBeat.m2504i(105544);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            AppMethodBeat.m2505o(105544);
            return true;
        }
        AppMethodBeat.m2505o(105544);
        return false;
    }

    public byte[] getBytes(short s, boolean z) {
        byte[] bArr = new byte[2];
        int i;
        int i2;
        if (z) {
            for (i = 1; i >= 0; i--) {
                bArr[i] = (byte) (i2 & 255);
                i2 = (short) (i2 >> 8);
            }
        } else {
            for (i = 0; i < 2; i++) {
                bArr[i] = (byte) (i2 & 255);
                i2 = (short) (i2 >> 8);
            }
        }
        return bArr;
    }

    public byte[] getBytes(int i, boolean z) {
        AppMethodBeat.m2504i(105545);
        byte[] bArr = new byte[4];
        int i2;
        if (z) {
            for (i2 = 3; i2 >= 0; i2--) {
                bArr[i2] = (byte) (i & 255);
                i >>= 8;
            }
        } else {
            System.out.println("1");
            for (i2 = 0; i2 < 4; i2++) {
                bArr[i2] = (byte) (i & 255);
                i >>= 8;
            }
        }
        AppMethodBeat.m2505o(105545);
        return bArr;
    }

    public byte[] getBytes(long j, boolean z) {
        byte[] bArr = new byte[8];
        int i;
        if (z) {
            for (i = 7; i >= 0; i--) {
                bArr[i] = (byte) ((int) (j & 255));
                j >>= 8;
            }
        } else {
            for (i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) (j & 255));
                j >>= 8;
            }
        }
        return bArr;
    }

    public short getShort(byte[] bArr, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(105546);
        IllegalArgumentException illegalArgumentException;
        if (bArr == null) {
            illegalArgumentException = new IllegalArgumentException("byte array is null!");
            AppMethodBeat.m2505o(105546);
            throw illegalArgumentException;
        } else if (bArr.length > 2) {
            illegalArgumentException = new IllegalArgumentException("byte array size > 2 !");
            AppMethodBeat.m2505o(105546);
            throw illegalArgumentException;
        } else {
            short s;
            int i2;
            if (z) {
                s = (short) 0;
                while (true) {
                    i2 = i;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    s = (short) (((short) (s << 8)) | (bArr[i2] & 255));
                    i = i2 + 1;
                }
            } else {
                s = (short) 0;
                for (i2 = bArr.length - 1; i2 >= 0; i2--) {
                    s = (short) (((short) (s << 8)) | (bArr[i2] & 255));
                }
            }
            AppMethodBeat.m2505o(105546);
            return s;
        }
    }

    public int getInt(byte[] bArr, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(105547);
        IllegalArgumentException illegalArgumentException;
        if (bArr == null) {
            illegalArgumentException = new IllegalArgumentException("byte array is null!");
            AppMethodBeat.m2505o(105547);
            throw illegalArgumentException;
        } else if (bArr.length > 4) {
            illegalArgumentException = new IllegalArgumentException("byte array size > 4 !");
            AppMethodBeat.m2505o(105547);
            throw illegalArgumentException;
        } else {
            int i2;
            int i3;
            if (z) {
                i2 = 0;
                while (true) {
                    i3 = i;
                    if (i3 >= bArr.length) {
                        break;
                    }
                    i2 = (i2 << 8) | (bArr[i3] & 255);
                    i = i3 + 1;
                }
            } else {
                i2 = 0;
                for (i3 = bArr.length - 1; i3 >= 0; i3--) {
                    i2 = (i2 << 8) | (bArr[i3] & 255);
                }
            }
            AppMethodBeat.m2505o(105547);
            return i2;
        }
    }

    public long getLong(byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(105548);
        IllegalArgumentException illegalArgumentException;
        if (bArr == null) {
            illegalArgumentException = new IllegalArgumentException("byte array is null!");
            AppMethodBeat.m2505o(105548);
            throw illegalArgumentException;
        } else if (bArr.length > 8) {
            illegalArgumentException = new IllegalArgumentException("byte array size > 8 !");
            AppMethodBeat.m2505o(105548);
            throw illegalArgumentException;
        } else {
            long j = 0;
            int length;
            if (z) {
                for (byte b : bArr) {
                    j = (j << 8) | ((long) (b & 255));
                }
            } else {
                for (length = bArr.length - 1; length >= 0; length--) {
                    j = (j << 8) | ((long) (bArr[length] & 255));
                }
            }
            AppMethodBeat.m2505o(105548);
            return j;
        }
    }

    public byte[] getBytes(int i) {
        AppMethodBeat.m2504i(105549);
        byte[] bytes = getBytes(i, testCPU());
        AppMethodBeat.m2505o(105549);
        return bytes;
    }

    public byte[] getBytes(short s) {
        AppMethodBeat.m2504i(105550);
        byte[] bytes = getBytes(s, testCPU());
        AppMethodBeat.m2505o(105550);
        return bytes;
    }

    public byte[] getBytes(long j) {
        AppMethodBeat.m2504i(105551);
        byte[] bytes = getBytes(j, testCPU());
        AppMethodBeat.m2505o(105551);
        return bytes;
    }

    public int getInt(byte[] bArr) {
        AppMethodBeat.m2504i(105552);
        int i = getInt(bArr, testCPU());
        AppMethodBeat.m2505o(105552);
        return i;
    }

    public short getShort(byte[] bArr) {
        AppMethodBeat.m2504i(105553);
        short s = getShort(bArr, testCPU());
        AppMethodBeat.m2505o(105553);
        return s;
    }

    public long getLong(byte[] bArr) {
        AppMethodBeat.m2504i(105554);
        long j = getLong(bArr, testCPU());
        AppMethodBeat.m2505o(105554);
        return j;
    }

    public short[] Bytes2Shorts(short[] sArr, byte[] bArr) {
        AppMethodBeat.m2504i(105555);
        byte[] bArr2 = new byte[2];
        for (int i = 0; i < sArr.length; i++) {
            System.arraycopy(bArr, i * 2, bArr2, 0, 2);
            sArr[i] = getShort(bArr2);
        }
        AppMethodBeat.m2505o(105555);
        return sArr;
    }

    public byte[] Shorts2Bytes(short[] sArr) {
        AppMethodBeat.m2504i(105556);
        byte[] bArr = new byte[(sArr.length * 2)];
        Shorts2Bytes(sArr, bArr);
        AppMethodBeat.m2505o(105556);
        return bArr;
    }

    public void Shorts2Bytes(short[] sArr, byte[] bArr) {
        AppMethodBeat.m2504i(105557);
        for (int i = 0; i < sArr.length; i++) {
            System.arraycopy(getBytes(sArr[i]), 0, bArr, i * 2, 2);
        }
        AppMethodBeat.m2505o(105557);
    }

    public int[] Bytes2Ints(byte[] bArr) {
        AppMethodBeat.m2504i(105558);
        int[] iArr = new int[(bArr.length / 4)];
        for (int i = 0; i < iArr.length; i++) {
            byte[] bArr2 = new byte[4];
            for (int i2 = 0; i2 < 4; i2++) {
                bArr2[i2] = bArr[(i * 4) + i2];
            }
            iArr[i] = getInt(bArr2);
            System.out.println("2out->" + iArr[i]);
        }
        AppMethodBeat.m2505o(105558);
        return iArr;
    }

    public byte[] Ints2Bytes(int[] iArr) {
        AppMethodBeat.m2504i(105559);
        byte[] bArr = new byte[(iArr.length * 4)];
        for (int i = 0; i < iArr.length; i++) {
            byte[] bytes = getBytes(iArr[i]);
            System.out.println("1out->" + iArr[i]);
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[(i * 4) + i2] = bytes[i2];
            }
        }
        AppMethodBeat.m2505o(105559);
        return bArr;
    }

    public long[] Bytes2Longs(byte[] bArr) {
        AppMethodBeat.m2504i(105560);
        long[] jArr = new long[(bArr.length / 8)];
        for (int i = 0; i < jArr.length; i++) {
            byte[] bArr2 = new byte[8];
            for (int i2 = 0; i2 < 8; i2++) {
                bArr2[i2] = bArr[(i * 8) + i2];
            }
            jArr[i] = getLong(bArr2);
        }
        AppMethodBeat.m2505o(105560);
        return jArr;
    }

    public byte[] Longs2Bytes(long[] jArr) {
        AppMethodBeat.m2504i(105561);
        byte[] bArr = new byte[(jArr.length * 8)];
        for (int i = 0; i < jArr.length; i++) {
            byte[] bytes = getBytes(jArr[i]);
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[(i * 8) + i2] = bytes[i2];
            }
        }
        AppMethodBeat.m2505o(105561);
        return bArr;
    }
}
