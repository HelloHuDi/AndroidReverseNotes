package com.tencent.p177mm.p178a;

import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* renamed from: com.tencent.mm.a.e */
public final class C1173e {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bb A:{SYNTHETIC, Splitter:B:22:0x00bb} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f8 A:{SYNTHETIC, Splitter:B:29:0x00f8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static int m2558b(String str, String str2, byte[] bArr) {
        Throwable e;
        if (bArr == null) {
            return -2;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2, true));
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                    return 0;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, str2, Integer.valueOf(bArr.length));
                    return 0;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendBuf e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e.getClass().getSimpleName(), e.getMessage(), str, str2, Integer.valueOf(bArr.length));
                    if (bufferedOutputStream != null) {
                    }
                    return -1;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, str2, Integer.valueOf(bArr.length));
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FileOperation", "file op appendBuf e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e.getClass().getSimpleName(), e.getMessage(), str, str2, Integer.valueOf(bArr.length));
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, str2, Integer.valueOf(bArr.length));
                }
            }
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c0 A:{SYNTHETIC, Splitter:B:28:0x00c0} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086 A:{SYNTHETIC, Splitter:B:20:0x0086} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public static int m2568e(String str, byte[] bArr) {
        Throwable e;
        if (bArr == null || bArr.length == 0) {
            return -2;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, true);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length));
                    return 0;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length));
                    if (fileOutputStream != null) {
                    }
                    return -1;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length));
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length));
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length));
                }
            }
            return -1;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f0 A:{SYNTHETIC, Splitter:B:30:0x00f0} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a7 A:{SYNTHETIC, Splitter:B:22:0x00a7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m2557a(String str, byte[] bArr, int i) {
        Throwable e;
        if (bArr == null || bArr.length == 0 || bArr.length < i + 0) {
            return -2;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, true);
            try {
                fileOutputStream.write(bArr, 0, i);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    return 0;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    if (fileOutputStream != null) {
                    }
                    return -1;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            return -1;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ef A:{SYNTHETIC, Splitter:B:29:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6 A:{SYNTHETIC, Splitter:B:21:0x00a6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static int m2559b(String str, byte[] bArr, int i) {
        Throwable e;
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, false);
            try {
                fileOutputStream.write(bArr, 0, i);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    return 0;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op writeFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    if (fileOutputStream != null) {
                    }
                    return -1;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e4, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FileOperation", "file op writeFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                }
            }
            return -1;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be A:{SYNTHETIC, Splitter:B:32:0x00be} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be A:{SYNTHETIC, Splitter:B:32:0x00be} */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0100 A:{SYNTHETIC, Splitter:B:39:0x0100} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public static byte[] m2569e(String str, int i, int i2) {
        Throwable e;
        Throwable th;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        if (i2 == -1) {
            i2 = (int) file.length();
        }
        if (i < 0) {
            return null;
        }
        if (i2 <= 0) {
            return null;
        }
        if (i + i2 > ((int) file.length())) {
            return null;
        }
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                bArr = new byte[i2];
                try {
                    randomAccessFile.seek((long) i);
                    randomAccessFile.readFully(bArr);
                    try {
                        randomAccessFile.close();
                        return bArr;
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                        C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                        return bArr;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                        C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                        if (randomAccessFile == null) {
                            return bArr;
                        }
                        try {
                            randomAccessFile.close();
                            return bArr;
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                            return bArr;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                bArr = null;
                C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                if (randomAccessFile == null) {
                }
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
            bArr = null;
            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
            if (randomAccessFile == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e222) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4 A:{SYNTHETIC, Splitter:B:33:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4 A:{SYNTHETIC, Splitter:B:33:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0108 A:{SYNTHETIC, Splitter:B:41:0x0108} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public static byte[] m2571f(String str, int i, int i2) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length;
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        byte[] bArr;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                bArr = new byte[length];
            } catch (Exception e2) {
                e = e2;
                bArr = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    if (randomAccessFile == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e3, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e3.getClass().getSimpleName(), e3.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                        }
                    }
                    throw th;
                }
            }
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (IOException e32) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e32, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e32.getClass().getSimpleName(), e32.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    return bArr;
                }
            } catch (Exception e4) {
                e = e4;
                C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                if (randomAccessFile == null) {
                    return bArr;
                }
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (IOException e322) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e322, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e322.getClass().getSimpleName(), e322.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    return bArr;
                }
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
            bArr = null;
            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e.getClass().getSimpleName(), e.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
            if (randomAccessFile == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    /* renamed from: cs */
    public static int m2560cs(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    /* renamed from: h */
    public static final boolean m2572h(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return false;
        }
        File file = new File(str + str2);
        File file2 = new File(str + str3);
        if (file.exists()) {
            return file.renameTo(file2);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x015f A:{SYNTHETIC, Splitter:B:54:0x015f} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0164 A:{SYNTHETIC, Splitter:B:57:0x0164} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090 A:{SYNTHETIC, Splitter:B:31:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095 A:{SYNTHETIC, Splitter:B:34:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015f A:{SYNTHETIC, Splitter:B:54:0x015f} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0164 A:{SYNTHETIC, Splitter:B:57:0x0164} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090 A:{SYNTHETIC, Splitter:B:31:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095 A:{SYNTHETIC, Splitter:B:34:0x0095} */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A:{SYNTHETIC, RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static final boolean m2567d(File file, File file2) {
        Throwable e;
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            int i = 0;
            while (true) {
                boolean z2 = z;
                if (i >= listFiles.length) {
                    return z2;
                }
                File file3 = listFiles[i];
                z = C1173e.m2567d(file3, new File(file2.getPath(), file3.getName()));
                if (z) {
                    file.delete();
                }
                i++;
            }
        } else {
            InputStream fileInputStream;
            OutputStream fileOutputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[65536];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        file.delete();
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e2, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e2.getClass().getSimpleName(), e2.getMessage(), file, file2);
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e22, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e22.getClass().getSimpleName(), e22.getMessage(), file, file2);
                        }
                        return true;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                            C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e.getClass().getSimpleName(), e.getMessage(), file, file2);
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream == null) {
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw e;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e.getClass().getSimpleName(), e.getMessage(), file, file2);
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e.getClass().getSimpleName(), e.getMessage(), file, file2);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e222) {
                        C4990ab.printErrStackTrace("MicroMsg.FileOperation", e222, "", new Object[0]);
                        C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e222.getClass().getSimpleName(), e222.getMessage(), file, file2);
                    }
                }
                if (fileOutputStream == null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (IOException e2222) {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e2222, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e2222.getClass().getSimpleName(), e2222.getMessage(), file, file2);
                    return false;
                }
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        C4990ab.printErrStackTrace("MicroMsg.FileOperation", e6, "", new Object[0]);
                        C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e6.getClass().getSimpleName(), e6.getMessage(), file, file2);
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        C4990ab.printErrStackTrace("MicroMsg.FileOperation", e7, "", new Object[0]);
                        C4990ab.m7421w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e7.getClass().getSimpleName(), e7.getMessage(), file, file2);
                    }
                }
                throw e;
            }
        }
    }

    /* renamed from: ct */
    public static final boolean m2561ct(String str) {
        if (str != null && new File(str).exists()) {
            return true;
        }
        return false;
    }

    /* renamed from: cu */
    public static boolean m2562cu(String str) {
        return C1173e.m2575t(new File(str));
    }

    /* renamed from: t */
    public static final boolean m2575t(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                while (i < listFiles.length) {
                    C1173e.m2575t(listFiles[i]);
                    i++;
                }
            }
        }
        file.delete();
        return true;
    }

    /* renamed from: cv */
    public static final String m2563cv(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == name.length() - 1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    /* renamed from: cw */
    public static final boolean m2564cw(String str) {
        if (C5046bo.isNullOrNil(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            return false;
        }
        String str2 = "/";
        for (int i = 0; i < split.length; i++) {
            if (!C5046bo.isNullOrNil(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    return false;
                }
                if (!(file2.exists() || file2.mkdir())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073 A:{SYNTHETIC, Splitter:B:29:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A:{SYNTHETIC, Splitter:B:32:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073 A:{SYNTHETIC, Splitter:B:29:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A:{SYNTHETIC, Splitter:B:32:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073 A:{SYNTHETIC, Splitter:B:29:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A:{SYNTHETIC, Splitter:B:32:0x0078} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: y */
    public static long m2577y(String str, String str2) {
        FileChannel channel;
        Throwable e;
        FileChannel fileChannel;
        try {
            FileChannel channel2;
            channel = new FileInputStream(str).getChannel();
            try {
                channel2 = new FileOutputStream(str2).getChannel();
            } catch (Exception e2) {
                e = e2;
                fileChannel = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                    C4990ab.m7421w("MicroMsg.FileOperation", "file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", e.getClass().getSimpleName(), e.getMessage(), str, str2);
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable e22) {
                    e = e22;
                    if (channel != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw e;
                }
            } catch (Throwable e222) {
                e = e222;
                fileChannel = null;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e5) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e6) {
                    }
                }
                throw e;
            }
            try {
                channel2.transferFrom(channel, 0, channel.size());
                long size = channel.size();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e7) {
                    }
                }
                if (channel2 != null) {
                    try {
                        channel2.close();
                    } catch (IOException e8) {
                    }
                }
                return size;
            } catch (Exception e9) {
                e = e9;
                fileChannel = channel2;
            } catch (Throwable th) {
                e = th;
                fileChannel = channel2;
                if (channel != null) {
                }
                if (fileChannel != null) {
                }
                throw e;
            }
        } catch (Exception e2222) {
            e = e2222;
            fileChannel = null;
            channel = null;
        } catch (Throwable e22222) {
            e = e22222;
            fileChannel = null;
            channel = null;
            if (channel != null) {
            }
            if (fileChannel != null) {
            }
            throw e;
        }
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return 0;
        }
        try {
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += (long) read;
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.FileOperation", "copyStream error: %s", e.getMessage());
            return 0;
        }
    }

    /* renamed from: p */
    public static void m2573p(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                C4990ab.m7421w("MicroMsg.FileOperation", "file op closeInputStream e type:%s, e msg:%s, stream:%s", e.getClass().getSimpleName(), e.getMessage(), inputStream);
            }
        }
    }

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.FileOperation", e, "", new Object[0]);
                C4990ab.m7421w("MicroMsg.FileOperation", "file op closeOutputStream e type:%s, e msg:%s, stream:%s", e.getClass().getSimpleName(), e.getMessage(), outputStream);
            }
        }
    }

    /* renamed from: cx */
    public static void m2565cx(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs() || !parentFile.isDirectory()) {
                C4990ab.m7413e("MicroMsg.FileOperation", "mkParentDir mkdir error. %s", str);
            }
        }
    }

    /* renamed from: f */
    public static void m2570f(String... strArr) {
        for (String file : strArr) {
            File file2 = new File(file);
            if (!(file2.exists() || (file2.mkdirs() && file2.isDirectory()))) {
                C4990ab.m7413e("MicroMsg.FileOperation", "batchMkDirs mkdir error. %s", file);
            }
        }
    }

    /* renamed from: u */
    public static final boolean m2576u(File file) {
        int i = 0;
        if (file == null || !file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        while (i < listFiles.length) {
            listFiles[i].delete();
            i++;
        }
        return true;
    }

    /* renamed from: q */
    public static byte[] m2574q(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        int i = 0;
        while (true) {
            try {
                i = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } catch (IOException e) {
            }
            if (i <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static boolean deleteFile(String str) {
        if (str == null) {
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    /* renamed from: cy */
    public static String m2566cy(String str) {
        IOException e;
        Throwable th;
        if (!new File(str).exists()) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                char[] cArr = new char[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read != -1) {
                        stringBuffer.append(String.valueOf(cArr, 0, read));
                    } else {
                        try {
                            bufferedReader.close();
                            return stringBuffer.toString();
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e22) {
                    throw e22;
                }
            }
            throw th;
        }
    }
}
