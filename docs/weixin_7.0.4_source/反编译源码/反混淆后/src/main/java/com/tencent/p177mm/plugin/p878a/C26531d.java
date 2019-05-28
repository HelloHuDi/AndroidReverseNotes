package com.tencent.p177mm.plugin.p878a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.a.d */
public final class C26531d {
    private static final int gjS = C26531d.m42369ag(new byte[]{(byte) 102, (byte) 114, (byte) 101, (byte) 101});
    private static final int gjT = C26531d.m42369ag(new byte[]{(byte) 106, (byte) 117, (byte) 110, (byte) 107});
    private static final int gjU = C26531d.m42369ag(new byte[]{(byte) 109, (byte) 100, (byte) 97, (byte) 116});
    private static final int gjV = C26531d.m42369ag(new byte[]{(byte) 109, (byte) 111, (byte) 111, (byte) 118});
    private static final int gjW = C26531d.m42369ag(new byte[]{(byte) 112, (byte) 110, (byte) 111, (byte) 116});
    private static final int gjX = C26531d.m42369ag(new byte[]{(byte) 115, (byte) 107, (byte) 105, (byte) 112});
    private static final int gjY = C26531d.m42369ag(new byte[]{(byte) 119, (byte) 105, (byte) 100, (byte) 101});
    private static final int gjZ = C26531d.m42369ag(new byte[]{(byte) 80, (byte) 73, (byte) 67, (byte) 84});
    private static final int gka = C26531d.m42369ag(new byte[]{(byte) 102, (byte) 116, (byte) 121, (byte) 112});
    private static final int gkb = C26531d.m42369ag(new byte[]{(byte) 117, (byte) 117, (byte) 105, (byte) 100});
    private static final int gkc = C26531d.m42369ag(new byte[]{(byte) 99, (byte) 109, (byte) 111, (byte) 118});
    private static final int gkd = C26531d.m42369ag(new byte[]{(byte) 115, (byte) 116, (byte) 99, (byte) 111});
    private static final int gke = C26531d.m42369ag(new byte[]{(byte) 99, (byte) 111, (byte) 54, (byte) 52});

    static {
        AppMethodBeat.m2504i(117844);
        AppMethodBeat.m2505o(117844);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0130 A:{SYNTHETIC, Splitter:B:35:0x0130} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0135 A:{SYNTHETIC, Splitter:B:38:0x0135} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0140 A:{SYNTHETIC, Splitter:B:44:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0145 A:{SYNTHETIC, Splitter:B:47:0x0145} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0130 A:{SYNTHETIC, Splitter:B:35:0x0130} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0135 A:{SYNTHETIC, Splitter:B:38:0x0135} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0140 A:{SYNTHETIC, Splitter:B:44:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0145 A:{SYNTHETIC, Splitter:B:47:0x0145} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0140 A:{SYNTHETIC, Splitter:B:44:0x0140} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0145 A:{SYNTHETIC, Splitter:B:47:0x0145} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: be */
    private static boolean m42371be(String str, String str2) {
        Exception e;
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.m2504i(117837);
        File file = new File(str);
        File file2 = new File(str2);
        if (file.length() != file2.length()) {
            C4990ab.m7420w("MicroMsg.FastStart", "check size not right");
            AppMethodBeat.m2505o(117837);
            return false;
        }
        long vB = new C45479b().mo73275vB(str);
        C9794f c9794f = new C9794f();
        c9794f.mo21148v(str, vB);
        int i = c9794f.gkm;
        long vB2 = new C45479b().mo73275vB(str2);
        C9794f c9794f2 = new C9794f();
        c9794f2.mo21148v(str2, vB2);
        int i2 = c9794f2.gkm;
        if (i2 != i) {
            C4990ab.m7420w("MicroMsg.FastStart", "check duration not right");
            AppMethodBeat.m2505o(117837);
            return false;
        }
        C4990ab.m7410d("MicroMsg.FastStart", "old duration:" + i + " new duration: " + i2);
        i = new Random().nextInt(i2 - 1) + 1;
        if (i + 1 <= i2) {
            i2 = i + 1;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        c9794f.mo21144a(i, i2, pInt, pInt2);
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        c9794f2.mo21144a(i, i2, pInt3, pInt4);
        if (pInt4.value != pInt2.value) {
            C4990ab.m7420w("MicroMsg.FastStart", "check len not right");
            AppMethodBeat.m2505o(117837);
            return false;
        }
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.skip((long) pInt.value);
                byte[] bArr = new byte[4096];
                fileInputStream2.read(bArr);
                fileInputStream3 = new FileInputStream(file2);
                try {
                    fileInputStream3.skip((long) pInt3.value);
                    byte[] bArr2 = new byte[4096];
                    fileInputStream2.read(bArr2);
                    if (Arrays.equals(bArr, bArr2)) {
                        C4990ab.m7420w("MicroMsg.FastStart", "check data not right");
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                        }
                        try {
                            fileInputStream3.close();
                        } catch (IOException e3) {
                        }
                        AppMethodBeat.m2505o(117837);
                        return false;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                    }
                    try {
                        fileInputStream3.close();
                    } catch (IOException e5) {
                    }
                    AppMethodBeat.m2505o(117837);
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = fileInputStream3;
                    try {
                        C4990ab.m7420w("MicroMsg.FastStart", "fast start error: " + e.toString());
                        if (fileInputStream2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(117837);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream3 = fileInputStream;
                        if (fileInputStream2 != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.m2505o(117837);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream2 != null) {
                    }
                    if (fileInputStream3 != null) {
                    }
                    AppMethodBeat.m2505o(117837);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                fileInputStream = null;
                C4990ab.m7420w("MicroMsg.FastStart", "fast start error: " + e.toString());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e8) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                    }
                }
                AppMethodBeat.m2505o(117837);
                return true;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream3 = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e10) {
                    }
                }
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e11) {
                    }
                }
                AppMethodBeat.m2505o(117837);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
            fileInputStream2 = null;
            C4990ab.m7420w("MicroMsg.FastStart", "fast start error: " + e.toString());
            if (fileInputStream2 != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(117837);
            return true;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream3 = null;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
            }
            if (fileInputStream3 != null) {
            }
            AppMethodBeat.m2505o(117837);
            throw th;
        }
    }

    /* renamed from: ag */
    private static int m42369ag(byte[] bArr) {
        AppMethodBeat.m2504i(117838);
        int i = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        AppMethodBeat.m2505o(117838);
        return i;
    }

    /* renamed from: gc */
    private static int m42373gc(long j) {
        AppMethodBeat.m2504i(117839);
        if (j > 2147483647L || j < 0) {
            Exception exception = new Exception("uint32 value is too large");
            AppMethodBeat.m2505o(117839);
            throw exception;
        }
        int i = (int) j;
        AppMethodBeat.m2505o(117839);
        return i;
    }

    /* renamed from: a */
    private static boolean m42367a(FileChannel fileChannel, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(117840);
        byteBuffer.clear();
        int read = fileChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read == byteBuffer.capacity()) {
            AppMethodBeat.m2505o(117840);
            return true;
        }
        AppMethodBeat.m2505o(117840);
        return false;
    }

    /* renamed from: c */
    private static void m42372c(Closeable closeable) {
        AppMethodBeat.m2504i(117841);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.m2505o(117841);
                return;
            } catch (IOException e) {
                C4990ab.m7420w("MicroMsg.FastStart", "Failed to close file: ");
            }
        }
        AppMethodBeat.m2505o(117841);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static boolean m42370b(String str, String str2, PInt pInt) {
        boolean a;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(117842);
        boolean z = false;
        File file = new File(str);
        File file2 = new File(str2);
        Closeable fileInputStream;
        Closeable fileOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    a = C26531d.m42368a(channel, fileOutputStream.getChannel(), pInt);
                    if (a) {
                        try {
                            a = C26531d.m42371be(str, str2);
                        } catch (Exception e2) {
                            e = e2;
                            z = a;
                        }
                    }
                    C26531d.m42372c(fileInputStream);
                    C26531d.m42372c(fileOutputStream);
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e32) {
                e = e32;
                fileOutputStream = null;
                try {
                    C4990ab.m7420w("MicroMsg.FastStart", "fast start error: " + e.toString());
                    C26531d.m42372c(fileInputStream);
                    C26531d.m42372c(fileOutputStream);
                    a = z;
                    if (!a) {
                    }
                    AppMethodBeat.m2505o(117842);
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    C26531d.m42372c(fileInputStream);
                    C26531d.m42372c(fileOutputStream);
                    AppMethodBeat.m2505o(117842);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                C26531d.m42372c(fileInputStream);
                C26531d.m42372c(fileOutputStream);
                AppMethodBeat.m2505o(117842);
                throw th;
            }
        } catch (Exception e322) {
            e = e322;
            fileOutputStream = null;
            fileInputStream = null;
            C4990ab.m7420w("MicroMsg.FastStart", "fast start error: " + e.toString());
            C26531d.m42372c(fileInputStream);
            C26531d.m42372c(fileOutputStream);
            a = z;
            if (a) {
            }
            AppMethodBeat.m2505o(117842);
            return a;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
            C26531d.m42372c(fileInputStream);
            C26531d.m42372c(fileOutputStream);
            AppMethodBeat.m2505o(117842);
            throw th;
        }
        if (a) {
            file2.delete();
        }
        AppMethodBeat.m2505o(117842);
        return a;
    }

    /* renamed from: a */
    private static boolean m42368a(FileChannel fileChannel, FileChannel fileChannel2, PInt pInt) {
        long j;
        int gc;
        AppMethodBeat.m2504i(117843);
        int i = 0;
        long j2 = 0;
        ByteBuffer byteBuffer = null;
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        long j3 = 0;
        Object obj = null;
        Object obj2 = null;
        long j4 = -1;
        while (C26531d.m42367a(fileChannel, order)) {
            j = 4294967295L & ((long) order.getInt());
            i = order.getInt();
            if (i == gka) {
                obj = 1;
                gc = C26531d.m42373gc(j);
                byteBuffer = ByteBuffer.allocate(gc).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                byteBuffer.put(order);
                if (fileChannel.read(byteBuffer) < gc - 8) {
                    obj2 = null;
                    break;
                }
                byteBuffer.flip();
                j3 = fileChannel.position();
                j2 = j;
            } else if (i == gjV) {
                j2 = fileChannel.position() - 8;
                if (obj2 == null) {
                    C4990ab.m7410d("MicroMsg.FastStart", "it moov before mdat, needn't fast start");
                    pInt.value = 1;
                    AppMethodBeat.m2505o(117843);
                    return false;
                }
                C4990ab.m7410d("MicroMsg.FastStart", "it moov after mdat, need fast start");
                j4 = j2;
                obj2 = 1;
            } else {
                if (i == gjU) {
                    obj2 = 1;
                }
                if (j == 1) {
                    order.clear();
                    if (!C26531d.m42367a(fileChannel, order)) {
                        obj2 = null;
                        break;
                    }
                    j = order.getLong();
                    if (j < 0) {
                        Exception exception = new Exception("uint64 value is too large");
                        AppMethodBeat.m2505o(117843);
                        throw exception;
                    }
                    fileChannel.position((fileChannel.position() + j) - 16);
                    j2 = j;
                } else {
                    fileChannel.position((fileChannel.position() + j) - 8);
                    j2 = j;
                }
            }
            if (j2 < 8) {
                C4990ab.m7420w("MicroMsg.FastStart", "atom size less 8, it error mp4.");
                AppMethodBeat.m2505o(117843);
                return false;
            }
        }
        obj2 = null;
        j = j2;
        if (obj == null || r2 == null) {
            C4990ab.m7420w("MicroMsg.FastStart", "it can not find moov or ftyp");
            AppMethodBeat.m2505o(117843);
            return false;
        } else if (i != gjV || j4 < 0) {
            C4990ab.m7420w("MicroMsg.FastStart", "it can not find moov atom");
            AppMethodBeat.m2505o(117843);
            return false;
        } else {
            int gc2 = C26531d.m42373gc(j);
            ByteBuffer order2 = ByteBuffer.allocate(gc2).order(ByteOrder.BIG_ENDIAN);
            order2.clear();
            int read = fileChannel.read(order2, j4);
            order2.flip();
            if (read == order2.capacity()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                C4990ab.m7420w("MicroMsg.FastStart", "failed to read moov atom");
                AppMethodBeat.m2505o(117843);
                return false;
            } else if (order2.getInt(12) == gkc) {
                C4990ab.m7420w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
                AppMethodBeat.m2505o(117843);
                return false;
            } else {
                while (order2.remaining() >= 8) {
                    read = order2.position();
                    i = order2.getInt(read + 4);
                    if (i != gkd && i != gke) {
                        order2.position(order2.position() + 1);
                    } else if ((((long) order2.getInt(read)) & 4294967295L) > ((long) order2.remaining())) {
                        C4990ab.m7420w("MicroMsg.FastStart", "bad atom size");
                        AppMethodBeat.m2505o(117843);
                        return false;
                    } else {
                        order2.position(read + 12);
                        if (order2.remaining() < 4) {
                            C4990ab.m7420w("MicroMsg.FastStart", "malformed atom");
                            AppMethodBeat.m2505o(117843);
                            return false;
                        }
                        gc = C26531d.m42373gc((long) order2.getInt());
                        if (i == gkd) {
                            if (order2.remaining() < gc * 4) {
                                C4990ab.m7420w("MicroMsg.FastStart", "bad atom size/element count");
                                AppMethodBeat.m2505o(117843);
                                return false;
                            }
                            read = 0;
                            while (read < gc) {
                                i = order2.getInt(order2.position());
                                int i2 = i + gc2;
                                if (i >= 0 || i2 < 0) {
                                    order2.putInt(i2);
                                    read++;
                                } else {
                                    AppMethodBeat.m2505o(117843);
                                    return false;
                                }
                            }
                            continue;
                        } else if (i != gke) {
                            continue;
                        } else if (order2.remaining() < gc * 8) {
                            C4990ab.m7420w("MicroMsg.FastStart", "bad atom size/element count");
                            AppMethodBeat.m2505o(117843);
                            return false;
                        } else {
                            for (read = 0; read < gc; read++) {
                                order2.putLong(order2.getLong(order2.position()) + ((long) gc2));
                            }
                        }
                    }
                }
                fileChannel.position(j3);
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    fileChannel2.write(byteBuffer);
                }
                order2.rewind();
                fileChannel2.write(order2);
                fileChannel.transferTo(j3, j4 - j3, fileChannel2);
                fileChannel.transferTo(j4 + ((long) gc2), (fileChannel.size() - j4) - ((long) gc2), fileChannel2);
                AppMethodBeat.m2505o(117843);
                return true;
            }
        }
    }
}
