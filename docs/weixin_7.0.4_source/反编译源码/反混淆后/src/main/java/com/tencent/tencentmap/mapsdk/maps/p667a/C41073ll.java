package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.p666a.C31001da;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;
import com.tencent.tencentmap.mapsdk.p666a.C5837be;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ll */
public class C41073ll {
    /* renamed from: a */
    private static volatile C41073ll f16540a;
    /* renamed from: d */
    private static String f16541d = "/rastermap/world";
    /* renamed from: e */
    private static String f16542e = "/tencentmapsdk/rastermap/handdraw";
    /* renamed from: b */
    private Context f16543b;
    /* renamed from: c */
    private ReentrantReadWriteLock f16544c = new ReentrantReadWriteLock();
    /* renamed from: f */
    private final int f16545f = 128;

    /* renamed from: a */
    public static C41073ll m71458a(Context context) {
        AppMethodBeat.m2504i(100431);
        if (f16540a == null) {
            synchronized (C41073ll.class) {
                try {
                    if (f16540a == null) {
                        f16540a = new C41073ll(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(100431);
                    }
                }
            }
        }
        C41073ll c41073ll = f16540a;
        AppMethodBeat.m2505o(100431);
        return c41073ll;
    }

    private C41073ll(Context context) {
        AppMethodBeat.m2504i(100432);
        this.f16543b = context;
        AppMethodBeat.m2505o(100432);
    }

    /* renamed from: a */
    private String[] m71460a(C5837be c5837be, boolean z) {
        String a;
        AppMethodBeat.m2504i(100433);
        int a2 = c5837be.mo12300a() / 128;
        int b = c5837be.mo12303b() / 128;
        int i = a2 / 10;
        int i2 = b / 10;
        String[] strArr = new String[2];
        StringBuilder stringBuilder = new StringBuilder();
        C31001da e = c5837be.mo12306e();
        switch (c5837be.mo12305d()) {
            case 0:
                a = mo65167a(e);
                break;
            case 1:
                a = mo65166a();
                break;
            default:
                a = null;
                break;
        }
        if (a == null) {
            AppMethodBeat.m2505o(100433);
            return null;
        }
        stringBuilder.append(a);
        stringBuilder.append("glGrid");
        stringBuilder.append("/");
        stringBuilder.append(c5837be.mo12304c());
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
        stringBuilder.append(c5837be.mo12304c());
        stringBuilder.append("_");
        stringBuilder.append(a2);
        stringBuilder.append("_");
        stringBuilder.append(b);
        strArr[0] = stringBuilder.toString() + ".idx";
        strArr[1] = stringBuilder.toString() + ".dat";
        AppMethodBeat.m2505o(100433);
        return strArr;
    }

    /* renamed from: b */
    private byte[] m71462b(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((WebView.NIGHT_MODE_COLOR & i) >> 24)};
    }

    /* renamed from: a */
    private void m71459a(byte[] bArr) {
        if (bArr != null && bArr.length == 4) {
            byte b = bArr[0];
            bArr[0] = bArr[3];
            bArr[3] = b;
            b = bArr[1];
            bArr[1] = bArr[2];
            bArr[2] = b;
        }
    }

    /* renamed from: b */
    private int m71461b(byte[] bArr) {
        return (((bArr[0] & 255) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & WebView.NIGHT_MODE_COLOR);
    }

    /* renamed from: a */
    private int m71457a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    /* renamed from: a */
    public Bitmap mo65165a(C5837be c5837be) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(100434);
        String[] a = m71460a(c5837be, true);
        if (a == null || a.length != 2 || a[0].equals("") || Arrays.equals(a, new String[a.length])) {
            AppMethodBeat.m2505o(100434);
        } else {
            File file = new File(a[0]);
            if (!file.exists() || file.length() == 0) {
                AppMethodBeat.m2505o(100434);
            } else {
                int a2 = m71457a(c5837be.mo12300a(), c5837be.mo12303b());
                if (a2 < 0) {
                    AppMethodBeat.m2505o(100434);
                } else {
                    byte[] bArr = new byte[4];
                    this.f16544c.readLock().lock();
                    Closeable randomAccessFile;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            randomAccessFile.seek((long) (a2 * 4));
                            randomAccessFile.read(bArr, 0, 4);
                            this.f16544c.readLock().unlock();
                            C31015v.m49801a(randomAccessFile);
                            m71459a(bArr);
                            int b = m71461b(bArr);
                            if (b < 0) {
                                AppMethodBeat.m2505o(100434);
                            } else {
                                File file2 = new File(a[1]);
                                if (file2.exists()) {
                                    try {
                                        this.f16544c.readLock().lock();
                                        randomAccessFile = new RandomAccessFile(file2, "r");
                                        try {
                                            randomAccessFile.seek((long) b);
                                            randomAccessFile.read(bArr, 0, 4);
                                            this.f16544c.readLock().unlock();
                                            m71459a(bArr);
                                            int b2 = m71461b(bArr);
                                            if (b2 <= 0) {
                                                C31015v.m49801a(randomAccessFile);
                                                AppMethodBeat.m2505o(100434);
                                            } else {
                                                byte[] bArr2 = new byte[b2];
                                                try {
                                                    randomAccessFile.read(bArr2, 0, b2);
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e) {
                                                    }
                                                    try {
                                                        Options f = c5837be.mo12308f();
                                                        if (f != null) {
                                                            bitmap = BitmapFactory.decodeByteArray(bArr2, 0, b2, f);
                                                        } else {
                                                            bitmap = BitmapFactory.decodeByteArray(bArr2, 0, b2);
                                                        }
                                                    } catch (Exception e2) {
                                                    }
                                                    c5837be.mo12301a(bitmap);
                                                    AppMethodBeat.m2505o(100434);
                                                } catch (IOException e3) {
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e4) {
                                                    }
                                                    AppMethodBeat.m2505o(100434);
                                                } catch (Throwable th2) {
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e5) {
                                                    }
                                                    AppMethodBeat.m2505o(100434);
                                                }
                                            }
                                        } catch (Exception e6) {
                                            try {
                                                C31015v.m49801a(randomAccessFile);
                                                return bitmap;
                                            } finally {
                                                this.f16544c.readLock().unlock();
                                                AppMethodBeat.m2505o(100434);
                                            }
                                        }
                                    } catch (Exception e7) {
                                        randomAccessFile = bitmap;
                                        C31015v.m49801a(randomAccessFile);
                                        return bitmap;
                                    }
                                }
                                AppMethodBeat.m2505o(100434);
                            }
                        } catch (Exception e8) {
                            this.f16544c.readLock().unlock();
                            C31015v.m49801a(randomAccessFile);
                            AppMethodBeat.m2505o(100434);
                            return bitmap;
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = randomAccessFile;
                            this.f16544c.readLock().unlock();
                            C31015v.m49801a(closeable);
                            AppMethodBeat.m2505o(100434);
                            throw th;
                        }
                    } catch (Exception e9) {
                        randomAccessFile = bitmap;
                        this.f16544c.readLock().unlock();
                        C31015v.m49801a(randomAccessFile);
                        AppMethodBeat.m2505o(100434);
                        return bitmap;
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = bitmap;
                        this.f16544c.readLock().unlock();
                        C31015v.m49801a(closeable);
                        AppMethodBeat.m2505o(100434);
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
            com.tencent.tencentmap.mapsdk.p666a.C31015v.m49801a(r7);
            r11.f16544c.writeLock().unlock();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(100435);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized boolean mo65169a(byte[] bArr, C5837be c5837be) {
        String[] a;
        Closeable randomAccessFile;
        long length;
        long j;
        File file;
        Closeable closeable = null;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(100435);
            if (bArr == null) {
                AppMethodBeat.m2505o(100435);
            } else {
                int length2 = bArr.length;
                if (length2 <= 0) {
                    AppMethodBeat.m2505o(100435);
                } else {
                    a = m71460a(c5837be, false);
                    if (a == null || a.length != 2 || a[0].equals("") || Arrays.equals(a, new String[a.length])) {
                        AppMethodBeat.m2505o(100435);
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
                                AppMethodBeat.m2505o(100435);
                            }
                        }
                        try {
                            randomAccessFile = new RandomAccessFile(file2, "rws");
                        } catch (Exception e2) {
                            C31015v.m49801a(closeable);
                            this.f16544c.writeLock().unlock();
                        } catch (Exception e3) {
                            this.f16544c.writeLock().unlock();
                        } catch (Exception e4) {
                        } catch (Exception e5) {
                            Object randomAccessFile2 = null;
                        } catch (Throwable th) {
                        }
                        if (randomAccessFile2 == null) {
                            AppMethodBeat.m2505o(100435);
                        } else {
                            byte[] b = m71462b(length2);
                            m71459a(b);
                            this.f16544c.writeLock().lock();
                            try {
                                length = randomAccessFile2.length();
                                randomAccessFile2.seek(length);
                                randomAccessFile2.write(b);
                                randomAccessFile2.write(bArr);
                                C31015v.m49801a(randomAccessFile2);
                                this.f16544c.writeLock().unlock();
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
                                    AppMethodBeat.m2505o(100435);
                                }
                            }
                            try {
                                closeable = new RandomAccessFile(file, "rws");
                            } catch (Exception e8) {
                            }
                            if (closeable != null) {
                                AppMethodBeat.m2505o(100435);
                            } else {
                                try {
                                    length = closeable.length();
                                } catch (Exception e9) {
                                    length = 0;
                                }
                                if (length == 0) {
                                    byte[] bArr2 = new byte[65536];
                                    Arrays.fill(bArr2, (byte) -1);
                                    this.f16544c.writeLock().lock();
                                    closeable.write(bArr2);
                                    this.f16544c.writeLock().unlock();
                                }
                                int a2 = m71457a(c5837be.mo12300a(), c5837be.mo12303b());
                                if (a2 < 0) {
                                    C31015v.m49801a(closeable);
                                    AppMethodBeat.m2505o(100435);
                                } else {
                                    try {
                                        closeable.seek((long) (a2 * 4));
                                    } catch (Exception e10) {
                                    }
                                    byte[] b2 = m71462b((int) j);
                                    m71459a(b2);
                                    this.f16544c.writeLock().lock();
                                    closeable.write(b2);
                                    C31015v.m49801a(closeable);
                                    this.f16544c.writeLock().unlock();
                                    AppMethodBeat.m2505o(100435);
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
        C31015v.m49801a(randomAccessFile2);
        this.f16544c.writeLock().unlock();
        j = length;
        file = new File(a[0]);
        if (file.exists()) {
        }
        closeable = new RandomAccessFile(file, "rws");
        if (closeable != null) {
        }
    }

    /* renamed from: a */
    public boolean mo65168a(int i) {
        AppMethodBeat.m2504i(100436);
        String str = null;
        if (i == 0) {
            str = C46765r.m88663a(this.f16543b).mo75313a().getPath() + f16541d;
        }
        if (i == 1) {
            str = C46765r.m88664b(this.f16543b) + f16542e;
        }
        boolean c = C31015v.m49805c(str);
        AppMethodBeat.m2505o(100436);
        return c;
    }

    /* renamed from: a */
    public String mo65167a(C31001da c31001da) {
        AppMethodBeat.m2504i(100437);
        if (this.f16543b == null) {
            AppMethodBeat.m2505o(100437);
            return null;
        }
        String str = (C46765r.m88663a(this.f16543b).mo75313a().getPath() + f16541d) + "/" + C24414lq.m37991b() + "/" + C24414lq.m37987a() + "/" + C24414lq.m37992c() + "/";
        if (c31001da != null) {
            str = str + c31001da.name() + "/";
        }
        AppMethodBeat.m2505o(100437);
        return str;
    }

    /* renamed from: a */
    public String mo65166a() {
        AppMethodBeat.m2504i(100438);
        if (this.f16543b == null) {
            AppMethodBeat.m2505o(100438);
            return null;
        }
        String str = C46765r.m88664b(this.f16543b) + "/" + f16542e + "/" + C46796jp.m88979a() + "/";
        AppMethodBeat.m2505o(100438);
        return str;
    }
}
