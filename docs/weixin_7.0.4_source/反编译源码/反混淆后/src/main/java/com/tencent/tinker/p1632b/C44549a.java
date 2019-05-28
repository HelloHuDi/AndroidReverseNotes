package com.tencent.tinker.p1632b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.tencent.tinker.b.a */
public final class C44549a {
    /* renamed from: a */
    public static int m80913a(InputStream inputStream, InputStream inputStream2, File file) {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        byte[] K = C46814b.m89030K(inputStream);
        byte[] K2 = C46814b.m89030K(inputStream2);
        int length = K.length;
        int length2 = K2.length;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(K2, 0, length2));
        dataInputStream.skip(8);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(K2, 0, length2);
        byteArrayInputStream.skip(32);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        byteArrayInputStream = new ByteArrayInputStream(K2, 0, length2);
        byteArrayInputStream.skip(32 + readLong);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byteArrayInputStream = new ByteArrayInputStream(K2, 0, length2);
        byteArrayInputStream.skip((readLong2 + readLong) + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr = new byte[readLong3];
        int i = 0;
        int[] iArr = new int[3];
        length2 = 0;
        while (length2 < readLong3) {
            int i2;
            for (i2 = 0; i2 <= 2; i2++) {
                iArr[i2] = dataInputStream2.readInt();
            }
            if (iArr[0] + length2 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            } else if (C46814b.m89031a(gZIPInputStream, bArr, length2, iArr[0])) {
                i2 = 0;
                while (i2 < iArr[0]) {
                    if (i + i2 >= 0 && i + i2 < length) {
                        int i3 = length2 + i2;
                        bArr[i3] = (byte) (bArr[i3] + K[i + i2]);
                    }
                    i2++;
                }
                i2 = iArr[0] + length2;
                length2 = iArr[0] + i;
                if (iArr[1] + i2 > readLong3) {
                    throw new IOException("Corrupt by wrong patch file.");
                } else if (C46814b.m89031a(gZIPInputStream2, bArr, i2, iArr[1])) {
                    i = iArr[2] + length2;
                    length2 = i2 + iArr[1];
                } else {
                    throw new IOException("Corrupt by wrong patch file.");
                }
            } else {
                throw new IOException("Corrupt by wrong patch file.");
            }
        }
        dataInputStream2.close();
        gZIPInputStream.close();
        gZIPInputStream2.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            return 1;
        } finally {
            fileOutputStream.close();
        }
    }
}
