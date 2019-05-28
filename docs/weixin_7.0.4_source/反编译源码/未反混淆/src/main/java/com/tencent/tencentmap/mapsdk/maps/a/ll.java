package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.a.be;
import com.tencent.tencentmap.mapsdk.a.da;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.v;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ll {
    private static volatile ll a;
    private static String d = "/rastermap/world";
    private static String e = "/tencentmapsdk/rastermap/handdraw";
    private Context b;
    private ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    private final int f = 128;

    public static ll a(Context context) {
        AppMethodBeat.i(100431);
        if (a == null) {
            synchronized (ll.class) {
                try {
                    if (a == null) {
                        a = new ll(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(100431);
                    }
                }
            }
        }
        ll llVar = a;
        AppMethodBeat.o(100431);
        return llVar;
    }

    private ll(Context context) {
        AppMethodBeat.i(100432);
        this.b = context;
        AppMethodBeat.o(100432);
    }

    private String[] a(be beVar, boolean z) {
        String a;
        AppMethodBeat.i(100433);
        int a2 = beVar.a() / 128;
        int b = beVar.b() / 128;
        int i = a2 / 10;
        int i2 = b / 10;
        String[] strArr = new String[2];
        StringBuilder stringBuilder = new StringBuilder();
        da e = beVar.e();
        switch (beVar.d()) {
            case 0:
                a = a(e);
                break;
            case 1:
                a = a();
                break;
            default:
                a = null;
                break;
        }
        if (a == null) {
            AppMethodBeat.o(100433);
            return null;
        }
        stringBuilder.append(a);
        stringBuilder.append("glGrid");
        stringBuilder.append("/");
        stringBuilder.append(beVar.c());
        stringBuilder.append("/");
        stringBuilder.append(i);
        stringBuilder.append("/");
        stringBuilder.append(i2);
        stringBuilder.append("/");
        if (!z) {
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        stringBuilder.append(beVar.c());
        stringBuilder.append("_");
        stringBuilder.append(a2);
        stringBuilder.append("_");
        stringBuilder.append(b);
        strArr[0] = stringBuilder.toString() + ".idx";
        strArr[1] = stringBuilder.toString() + ".dat";
        AppMethodBeat.o(100433);
        return strArr;
    }

    private byte[] b(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((WebView.NIGHT_MODE_COLOR & i) >> 24)};
    }

    private void a(byte[] bArr) {
        if (bArr != null && bArr.length == 4) {
            byte b = bArr[0];
            bArr[0] = bArr[3];
            bArr[3] = b;
            b = bArr[1];
            bArr[1] = bArr[2];
            bArr[2] = b;
        }
    }

    private int b(byte[] bArr) {
        return (((bArr[0] & 255) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & WebView.NIGHT_MODE_COLOR);
    }

    private int a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    public Bitmap a(be beVar) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.i(100434);
        String[] a = a(beVar, true);
        if (a == null || a.length != 2 || a[0].equals("") || Arrays.equals(a, new String[a.length])) {
            AppMethodBeat.o(100434);
        } else {
            File file = new File(a[0]);
            if (!file.exists() || file.length() == 0) {
                AppMethodBeat.o(100434);
            } else {
                int a2 = a(beVar.a(), beVar.b());
                if (a2 < 0) {
                    AppMethodBeat.o(100434);
                } else {
                    byte[] bArr = new byte[4];
                    this.c.readLock().lock();
                    Closeable randomAccessFile;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            randomAccessFile.seek((long) (a2 * 4));
                            randomAccessFile.read(bArr, 0, 4);
                            this.c.readLock().unlock();
                            v.a(randomAccessFile);
                            a(bArr);
                            int b = b(bArr);
                            if (b < 0) {
                                AppMethodBeat.o(100434);
                            } else {
                                File file2 = new File(a[1]);
                                if (file2.exists()) {
                                    try {
                                        this.c.readLock().lock();
                                        randomAccessFile = new RandomAccessFile(file2, "r");
                                        try {
                                            randomAccessFile.seek((long) b);
                                            randomAccessFile.read(bArr, 0, 4);
                                            this.c.readLock().unlock();
                                            a(bArr);
                                            int b2 = b(bArr);
                                            if (b2 <= 0) {
                                                v.a(randomAccessFile);
                                                AppMethodBeat.o(100434);
                                            } else {
                                                byte[] bArr2 = new byte[b2];
                                                try {
                                                    randomAccessFile.read(bArr2, 0, b2);
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e) {
                                                    }
                                                    try {
                                                        Options f = beVar.f();
                                                        if (f != null) {
                                                            bitmap = BitmapFactory.decodeByteArray(bArr2, 0, b2, f);
                                                        } else {
                                                            bitmap = BitmapFactory.decodeByteArray(bArr2, 0, b2);
                                                        }
                                                    } catch (Exception e2) {
                                                    }
                                                    beVar.a(bitmap);
                                                    AppMethodBeat.o(100434);
                                                } catch (IOException e3) {
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e4) {
                                                    }
                                                    AppMethodBeat.o(100434);
                                                } catch (Throwable th2) {
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e5) {
                                                    }
                                                    AppMethodBeat.o(100434);
                                                }
                                            }
                                        } catch (Exception e6) {
                                            try {
                                                v.a(randomAccessFile);
                                                return bitmap;
                                            } finally {
                                                this.c.readLock().unlock();
                                                AppMethodBeat.o(100434);
                                            }
                                        }
                                    } catch (Exception e7) {
                                        randomAccessFile = bitmap;
                                        v.a(randomAccessFile);
                                        return bitmap;
                                    }
                                }
                                AppMethodBeat.o(100434);
                            }
                        } catch (Exception e8) {
                            this.c.readLock().unlock();
                            v.a(randomAccessFile);
                            AppMethodBeat.o(100434);
                            return bitmap;
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = randomAccessFile;
                            this.c.readLock().unlock();
                            v.a(closeable);
                            AppMethodBeat.o(100434);
                            throw th;
                        }
                    } catch (Exception e9) {
                        randomAccessFile = bitmap;
                        this.c.readLock().unlock();
                        v.a(randomAccessFile);
                        AppMethodBeat.o(100434);
                        return bitmap;
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = bitmap;
                        this.c.readLock().unlock();
                        v.a(closeable);
                        AppMethodBeat.o(100434);
                        throw th;
                    }
                }
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d3 A:{Catch:{ Exception -> 0x0189, all -> 0x0197, Exception -> 0x013e, all -> 0x0149, Exception -> 0x01b0, all -> 0x00d3, Exception -> 0x007a }, Splitter:B:47:0x008d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5 A:{SYNTHETIC, Splitter:B:55:0x00b5} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fd A:{SYNTHETIC, Splitter:B:76:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f5  */
    /* JADX WARNING: Missing block: B:65:0x00d4, code skipped:
            com.tencent.tencentmap.mapsdk.a.v.a(r7);
            r11.c.writeLock().unlock();
            com.tencent.matrix.trace.core.AppMethodBeat.o(100435);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(byte[] bArr, be beVar) {
        String[] a;
        Closeable randomAccessFile;
        long length;
        long j;
        File file;
        Closeable closeable = null;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(100435);
            if (bArr == null) {
                AppMethodBeat.o(100435);
            } else {
                int length2 = bArr.length;
                if (length2 <= 0) {
                    AppMethodBeat.o(100435);
                } else {
                    a = a(beVar, false);
                    if (a == null || a.length != 2 || a[0].equals("") || Arrays.equals(a, new String[a.length])) {
                        AppMethodBeat.o(100435);
                    } else {
                        boolean createNewFile;
                        File file2 = new File(a[1]);
                        if (!file2.exists()) {
                            try {
                                createNewFile = file2.createNewFile();
                            } catch (Exception e) {
                                createNewFile = false;
                            }
                            if (!createNewFile) {
                                AppMethodBeat.o(100435);
                            }
                        }
                        try {
                            randomAccessFile = new RandomAccessFile(file2, "rws");
                        } catch (Exception e2) {
                            v.a(closeable);
                            this.c.writeLock().unlock();
                        } catch (Exception e3) {
                            this.c.writeLock().unlock();
                        } catch (Exception e4) {
                        } catch (Exception e5) {
                            Object randomAccessFile2 = null;
                        } catch (Throwable th) {
                        }
                        if (randomAccessFile2 == null) {
                            AppMethodBeat.o(100435);
                        } else {
                            byte[] b = b(length2);
                            a(b);
                            this.c.writeLock().lock();
                            try {
                                length = randomAccessFile2.length();
                                randomAccessFile2.seek(length);
                                randomAccessFile2.write(b);
                                randomAccessFile2.write(bArr);
                                v.a(randomAccessFile2);
                                this.c.writeLock().unlock();
                                j = length;
                            } catch (Exception e6) {
                                length = 0;
                            } catch (Throwable th2) {
                            }
                            file = new File(a[0]);
                            if (!file.exists()) {
                                try {
                                    createNewFile = file.createNewFile();
                                } catch (Exception e7) {
                                    createNewFile = false;
                                }
                                if (!createNewFile) {
                                    AppMethodBeat.o(100435);
                                }
                            }
                            try {
                                closeable = new RandomAccessFile(file, "rws");
                            } catch (Exception e8) {
                            }
                            if (closeable != null) {
                                AppMethodBeat.o(100435);
                            } else {
                                try {
                                    length = closeable.length();
                                } catch (Exception e9) {
                                    length = 0;
                                }
                                if (length == 0) {
                                    byte[] bArr2 = new byte[65536];
                                    Arrays.fill(bArr2, (byte) -1);
                                    this.c.writeLock().lock();
                                    closeable.write(bArr2);
                                    this.c.writeLock().unlock();
                                }
                                int a2 = a(beVar.a(), beVar.b());
                                if (a2 < 0) {
                                    v.a(closeable);
                                    AppMethodBeat.o(100435);
                                } else {
                                    try {
                                        closeable.seek((long) (a2 * 4));
                                    } catch (Exception e10) {
                                    }
                                    byte[] b2 = b((int) j);
                                    a(b2);
                                    this.c.writeLock().lock();
                                    closeable.write(b2);
                                    v.a(closeable);
                                    this.c.writeLock().unlock();
                                    AppMethodBeat.o(100435);
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
        v.a(randomAccessFile2);
        this.c.writeLock().unlock();
        j = length;
        file = new File(a[0]);
        if (file.exists()) {
        }
        closeable = new RandomAccessFile(file, "rws");
        if (closeable != null) {
        }
    }

    public boolean a(int i) {
        AppMethodBeat.i(100436);
        String str = null;
        if (i == 0) {
            str = r.a(this.b).a().getPath() + d;
        }
        if (i == 1) {
            str = r.b(this.b) + e;
        }
        boolean c = v.c(str);
        AppMethodBeat.o(100436);
        return c;
    }

    public String a(da daVar) {
        AppMethodBeat.i(100437);
        if (this.b == null) {
            AppMethodBeat.o(100437);
            return null;
        }
        String str = (r.a(this.b).a().getPath() + d) + "/" + lq.b() + "/" + lq.a() + "/" + lq.c() + "/";
        if (daVar != null) {
            str = str + daVar.name() + "/";
        }
        AppMethodBeat.o(100437);
        return str;
    }

    public String a() {
        AppMethodBeat.i(100438);
        if (this.b == null) {
            AppMethodBeat.o(100438);
            return null;
        }
        String str = r.b(this.b) + "/" + e + "/" + jp.a() + "/";
        AppMethodBeat.o(100438);
        return str;
    }
}
