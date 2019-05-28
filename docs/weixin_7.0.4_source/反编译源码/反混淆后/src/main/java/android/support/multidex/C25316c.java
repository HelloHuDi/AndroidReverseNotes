package android.support.multidex;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* renamed from: android.support.multidex.c */
final class C25316c {

    /* renamed from: android.support.multidex.c$a */
    static class C25317a {
        long size;
        /* renamed from: xb */
        long f5120xb;

        C25317a() {
        }
    }

    /* renamed from: g */
    static long m39921g(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = C25316c.m39919a(randomAccessFile, C25316c.m39920a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    /* renamed from: a */
    private static C25317a m39920a(RandomAccessFile randomAccessFile) {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() != reverseBytes) {
                j2--;
            } else {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C25317a c25317a = new C25317a();
                c25317a.size = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                c25317a.f5120xb = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return c25317a;
            }
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    /* renamed from: a */
    private static long m39919a(RandomAccessFile randomAccessFile, C25317a c25317a) {
        CRC32 crc32 = new CRC32();
        long j = c25317a.size;
        randomAccessFile.seek(c25317a.f5120xb);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }
}
