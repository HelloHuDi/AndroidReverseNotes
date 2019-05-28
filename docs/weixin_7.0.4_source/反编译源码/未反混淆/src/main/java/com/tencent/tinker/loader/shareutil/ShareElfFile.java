package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile implements Closeable {
    private final FileInputStream ADV;
    private final Map<String, SectionHeader> ADW = new HashMap();
    public ElfHeader ADX = null;
    public ProgramHeader[] ADY = null;
    public SectionHeader[] ADZ = null;

    public static class ElfHeader {
        public final byte[] AEa;
        public final short AEb;
        public final short AEc;
        public final int AEd;
        public final long AEe;
        public final long AEf;
        public final long AEg;
        public final int AEh;
        public final short AEi;
        public final short AEj;
        public final short AEk;
        public final short AEl;
        public final short AEm;
        public final short AEn;

        /* synthetic */ ElfHeader(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }

        private ElfHeader(FileChannel fileChannel) {
            this.AEa = new byte[16];
            fileChannel.position(0);
            fileChannel.read(ByteBuffer.wrap(this.AEa));
            if (this.AEa[0] == Byte.MAX_VALUE && this.AEa[1] == (byte) 69 && this.AEa[2] == (byte) 76 && this.AEa[3] == (byte) 70) {
                ShareElfFile.D(this.AEa[4], 2, "bad elf class: " + this.AEa[4]);
                ShareElfFile.D(this.AEa[5], 2, "bad elf data encoding: " + this.AEa[5]);
                ByteBuffer allocate = ByteBuffer.allocate(this.AEa[4] == (byte) 1 ? 36 : 48);
                allocate.order(this.AEa[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                ShareElfFile.a(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.AEb = allocate.getShort();
                this.AEc = allocate.getShort();
                this.AEd = allocate.getInt();
                ShareElfFile.D(this.AEd, 1, "bad elf version: " + this.AEd);
                switch (this.AEa[4]) {
                    case (byte) 1:
                        this.AEe = (long) allocate.getInt();
                        this.AEf = (long) allocate.getInt();
                        this.AEg = (long) allocate.getInt();
                        break;
                    case (byte) 2:
                        this.AEe = allocate.getLong();
                        this.AEf = allocate.getLong();
                        this.AEg = allocate.getLong();
                        break;
                    default:
                        throw new IOException("Unexpected elf class: " + this.AEa[4]);
                }
                this.AEh = allocate.getInt();
                this.AEi = allocate.getShort();
                this.AEj = allocate.getShort();
                this.AEk = allocate.getShort();
                this.AEl = allocate.getShort();
                this.AEm = allocate.getShort();
                this.AEn = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(this.AEa[0]), Byte.valueOf(this.AEa[1]), Byte.valueOf(this.AEa[2]), Byte.valueOf(this.AEa[3])}));
        }
    }

    public static class ProgramHeader {
        public final int AEo;
        public final int AEp;
        public final long AEq;
        public final long AEr;
        public final long AEs;
        public final long AEt;
        public final long AEu;
        public final long AEv;

        /* synthetic */ ProgramHeader(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private ProgramHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.AEo = byteBuffer.getInt();
                    this.AEq = (long) byteBuffer.getInt();
                    this.AEr = (long) byteBuffer.getInt();
                    this.AEs = (long) byteBuffer.getInt();
                    this.AEt = (long) byteBuffer.getInt();
                    this.AEu = (long) byteBuffer.getInt();
                    this.AEp = byteBuffer.getInt();
                    this.AEv = (long) byteBuffer.getInt();
                    return;
                case 2:
                    this.AEo = byteBuffer.getInt();
                    this.AEp = byteBuffer.getInt();
                    this.AEq = byteBuffer.getLong();
                    this.AEr = byteBuffer.getLong();
                    this.AEs = byteBuffer.getLong();
                    this.AEt = byteBuffer.getLong();
                    this.AEu = byteBuffer.getLong();
                    this.AEv = byteBuffer.getLong();
                    return;
                default:
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
        }
    }

    public static class SectionHeader {
        public final long AEA;
        public final long AEB;
        public final int AEC;
        public final int AED;
        public final long AEE;
        public final long AEF;
        public String AEG;
        public final int AEw;
        public final int AEx;
        public final long AEy;
        public final long AEz;

        /* synthetic */ SectionHeader(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private SectionHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.AEw = byteBuffer.getInt();
                    this.AEx = byteBuffer.getInt();
                    this.AEy = (long) byteBuffer.getInt();
                    this.AEz = (long) byteBuffer.getInt();
                    this.AEA = (long) byteBuffer.getInt();
                    this.AEB = (long) byteBuffer.getInt();
                    this.AEC = byteBuffer.getInt();
                    this.AED = byteBuffer.getInt();
                    this.AEE = (long) byteBuffer.getInt();
                    this.AEF = (long) byteBuffer.getInt();
                    break;
                case 2:
                    this.AEw = byteBuffer.getInt();
                    this.AEx = byteBuffer.getInt();
                    this.AEy = byteBuffer.getLong();
                    this.AEz = byteBuffer.getLong();
                    this.AEA = byteBuffer.getLong();
                    this.AEB = byteBuffer.getLong();
                    this.AEC = byteBuffer.getInt();
                    this.AED = byteBuffer.getInt();
                    this.AEE = byteBuffer.getLong();
                    this.AEF = byteBuffer.getLong();
                    break;
                default:
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.AEG = null;
        }
    }

    public ShareElfFile(File file) {
        int i;
        int i2 = 0;
        this.ADV = new FileInputStream(file);
        FileChannel channel = this.ADV.getChannel();
        this.ADX = new ElfHeader(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.ADX.AEj);
        allocate.order(this.ADX.AEa[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.ADX.AEf);
        this.ADY = new ProgramHeader[this.ADX.AEk];
        for (i = 0; i < this.ADY.length; i++) {
            a(channel, allocate, "failed to read phdr.");
            this.ADY[i] = new ProgramHeader(allocate, this.ADX.AEa[4], (byte) 0);
        }
        channel.position(this.ADX.AEg);
        allocate.limit(this.ADX.AEl);
        this.ADZ = new SectionHeader[this.ADX.AEm];
        for (i = 0; i < this.ADZ.length; i++) {
            a(channel, allocate, "failed to read shdr.");
            this.ADZ[i] = new SectionHeader(allocate, this.ADX.AEa[4], (byte) 0);
        }
        if (this.ADX.AEn > (short) 0) {
            SectionHeader sectionHeader = this.ADZ[this.ADX.AEn];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) sectionHeader.AEB);
            this.ADV.getChannel().position(sectionHeader.AEA);
            a(this.ADV.getChannel(), allocate2, "failed to read section: " + sectionHeader.AEG);
            SectionHeader[] sectionHeaderArr = this.ADZ;
            int length = sectionHeaderArr.length;
            while (i2 < length) {
                SectionHeader sectionHeader2 = sectionHeaderArr[i2];
                allocate2.position(sectionHeader2.AEw);
                sectionHeader2.AEG = K(allocate2);
                this.ADW.put(sectionHeader2.AEG, sectionHeader2);
                i2++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0058 A:{SYNTHETIC, Splitter:B:35:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int an(File file) {
        Throwable th;
        InputStream inputStream;
        try {
            byte[] bArr = new byte[4];
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                if (bArr[0] == (byte) 100 && bArr[1] == (byte) 101 && bArr[2] == (byte) 121 && bArr[3] == (byte) 10) {
                    try {
                        fileInputStream.close();
                        return 0;
                    } catch (Throwable th2) {
                        return 0;
                    }
                } else if (bArr[0] == Byte.MAX_VALUE && bArr[1] == (byte) 69 && bArr[2] == (byte) 76 && bArr[3] == (byte) 70) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                    }
                    return 1;
                } else {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                    }
                    return -1;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = fileInputStream;
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th7) {
                }
            }
            throw th;
        }
    }

    public static void a(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
        }
        byteBuffer.flip();
    }

    private static String K(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != (byte) 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public void close() {
        this.ADV.close();
        this.ADW.clear();
        this.ADY = null;
        this.ADZ = null;
    }

    static /* synthetic */ void D(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }
}
