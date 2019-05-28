package com.tencent.tencentmap.mapsdk.maps.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.util.ZipUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class gb extends Thread implements gc {
    private long a = 0;
    private gm b;
    private hf c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private List<Integer> g;

    public gb(gm gmVar, hf hfVar) {
        this.b = gmVar;
        this.c = hfVar;
    }

    public void a(boolean z) {
        AppMethodBeat.i(98971);
        if (this.b == null) {
            AppMethodBeat.o(98971);
            return;
        }
        this.b.b(z);
        this.d = z;
        if (z) {
            try {
                start();
            } catch (Exception e) {
            }
        }
        this.b.w();
        AppMethodBeat.o(98971);
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        AppMethodBeat.i(98972);
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98972);
            }
        }
    }

    public void c() {
        AppMethodBeat.i(98973);
        this.e = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98973);
            }
        }
    }

    public void d() {
        AppMethodBeat.i(98974);
        this.e = true;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98974);
            }
        }
    }

    public void e() {
        AppMethodBeat.i(98975);
        this.f = true;
        this.e = true;
        this.d = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98975);
            }
        }
        interrupt();
    }

    public void run() {
        AppMethodBeat.i(98976);
        super.run();
        while (!this.f) {
            if (!this.e && this.d) {
                f();
            }
            synchronized (this) {
                try {
                    wait(300000);
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(98976);
                    }
                } catch (InterruptedException e) {
                    AppMethodBeat.o(98976);
                    return;
                }
            }
        }
        AppMethodBeat.o(98976);
    }

    private void f() {
        AppMethodBeat.i(98977);
        if (this.b == null || this.b.a() == null || this.b.a().y() == null || this.b.a().m() < 11) {
            AppMethodBeat.o(98977);
            return;
        }
        gk a = this.b.a();
        List a2 = this.b.a(a.y(), a.m());
        if (a2 == null || a2.size() == 0) {
            AppMethodBeat.o(98977);
            return;
        }
        a(a2);
        AppMethodBeat.o(98977);
    }

    private void a(List<Integer> list) {
        AppMethodBeat.i(98978);
        if (this.c == null) {
            AppMethodBeat.o(98978);
            return;
        }
        List arrayList = new ArrayList();
        boolean b = b(list);
        if (b || System.currentTimeMillis() - this.a >= 300000) {
            Object obj = null;
            this.g = list;
            int size = list.size() - 1;
            while (size >= 0) {
                Object obj2;
                int intValue = ((Integer) list.get(size)).intValue();
                String num = Integer.toString(intValue);
                File a = a(num);
                String a2 = a(num, a);
                int i;
                if (a == null || System.currentTimeMillis() - a.lastModified() >= 300000) {
                    byte[] a3 = this.c.a(a(num, a2));
                    if (a3 != null && a3.length >= 10) {
                        if (a3[4] == (byte) 0) {
                            i = 0;
                            try {
                                i = Integer.parseInt(a2);
                            } catch (Exception e) {
                            }
                            arrayList.add(new BlockRouteCityData(intValue, i));
                            a.setLastModified(System.currentTimeMillis());
                            obj2 = obj;
                        } else {
                            byte[] bArr = new byte[4];
                            System.arraycopy(a3, 0, bArr, 0, 4);
                            int a4 = (int) a(bArr);
                            System.arraycopy(a3, 5, bArr, 0, 4);
                            int a5 = (int) a(bArr);
                            if (a(a4, a5, a3)) {
                                b(num, a2);
                                arrayList.add(new BlockRouteCityData(a4, a5));
                                obj2 = 1;
                            } else {
                                i = 0;
                                try {
                                    i = Integer.parseInt(a2);
                                } catch (Exception e2) {
                                }
                                arrayList.add(new BlockRouteCityData(intValue, i));
                            }
                        }
                    }
                    obj2 = obj;
                } else {
                    i = 0;
                    try {
                        i = Integer.parseInt(a2);
                    } catch (Exception e3) {
                    }
                    arrayList.add(new BlockRouteCityData(intValue, i));
                    obj2 = obj;
                }
                size--;
                obj = obj2;
            }
            if (b || obj != null) {
                this.b.a(arrayList);
                this.b.w();
            }
            this.a = System.currentTimeMillis();
            AppMethodBeat.o(98978);
            return;
        }
        AppMethodBeat.o(98978);
    }

    private boolean b(List<Integer> list) {
        AppMethodBeat.i(98979);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(98979);
            return false;
        } else if (this.g == null) {
            AppMethodBeat.o(98979);
            return true;
        } else {
            int i = 0;
            while (i < list.size()) {
                if (this.g.contains(list.get(i))) {
                    i++;
                } else {
                    AppMethodBeat.o(98979);
                    return true;
                }
            }
            AppMethodBeat.o(98979);
            return false;
        }
    }

    private String a(String str, String str2) {
        AppMethodBeat.i(98980);
        if (this.b == null || this.b.A() == null) {
            AppMethodBeat.o(98980);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.A());
        stringBuilder.append("&citycode=".concat(String.valueOf(str)));
        stringBuilder.append("&version=".concat(String.valueOf(str2)));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(98980);
        return stringBuilder2;
    }

    private String a(String str, File file) {
        AppMethodBeat.i(98981);
        String str2;
        if (file == null) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.o(98981);
            return str2;
        }
        String[] split = file.getName().split("_|\\.");
        if (split.length <= 1 || !str.equals(split[0])) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.o(98981);
            return str2;
        }
        str2 = split[1];
        AppMethodBeat.o(98981);
        return str2;
    }

    private File a(String str) {
        AppMethodBeat.i(98982);
        File g = g();
        if (g == null) {
            AppMethodBeat.o(98982);
            return null;
        }
        try {
            File[] listFiles = g.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.o(98982);
                return null;
            }
            int i = 0;
            while (i < listFiles.length) {
                String[] split = listFiles[i].getName().split("_|\\.");
                if (split.length <= 1 || !str.equals(split[0])) {
                    i++;
                } else {
                    g = listFiles[i];
                    AppMethodBeat.o(98982);
                    return g;
                }
            }
            AppMethodBeat.o(98982);
            return null;
        } catch (Exception e) {
            AppMethodBeat.o(98982);
            return null;
        }
    }

    private File g() {
        AppMethodBeat.i(98983);
        if (this.b == null || this.b.D() == null) {
            AppMethodBeat.o(98983);
            return null;
        }
        String e = this.b.D().e();
        if (e == null) {
            AppMethodBeat.o(98983);
            return null;
        }
        File file = new File(e);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e2) {
                AppMethodBeat.o(98983);
                return null;
            }
        }
        AppMethodBeat.o(98983);
        return file;
    }

    private long a(byte[] bArr) {
        return (long) ((((bArr[0] & 255) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & WebView.NIGHT_MODE_COLOR));
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090 A:{SYNTHETIC, Splitter:B:37:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b A:{SYNTHETIC, Splitter:B:42:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6 A:{SYNTHETIC, Splitter:B:47:0x00a6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int i, int i2, byte[] bArr) {
        Throwable th;
        AppMethodBeat.i(98984);
        if (bArr == null || bArr.length < 10) {
            AppMethodBeat.o(98984);
            return false;
        }
        File g = g();
        if (g == null) {
            AppMethodBeat.o(98984);
            return false;
        }
        File file = new File(g.getAbsolutePath() + File.separator + c(Integer.toString(i), Integer.toString(i2)));
        if (file.exists() && !file.delete()) {
            file.deleteOnExit();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = null;
            FileOutputStream fileOutputStream2;
            try {
                byte[] inflate = ZipUtil.inflate(bArr, 10, bArr.length - 10);
                if (inflate == null) {
                    AppMethodBeat.o(98984);
                    return false;
                }
                fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(inflate);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.o(98984);
                    return true;
                } catch (FileNotFoundException e2) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.o(98984);
                    return false;
                } catch (IOException e4) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.o(98984);
                    return false;
                } catch (Exception e6) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    AppMethodBeat.o(98984);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    AppMethodBeat.o(98984);
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                fileOutputStream2 = null;
            } catch (IOException e10) {
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(98984);
                return false;
            } catch (Exception e11) {
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(98984);
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(98984);
                throw th;
            }
        } catch (IOException e12) {
            AppMethodBeat.o(98984);
            return false;
        }
    }

    private void b(String str, String str2) {
        AppMethodBeat.i(98985);
        File g = g();
        if (g == null) {
            AppMethodBeat.o(98985);
            return;
        }
        File file = new File(g.getAbsolutePath() + File.separator + c(str, str2));
        if (file.exists() && !file.delete()) {
            file.deleteOnExit();
        }
        AppMethodBeat.o(98985);
    }

    private String c(String str, String str2) {
        AppMethodBeat.i(98986);
        String str3 = str + "_" + str2 + ".kml";
        AppMethodBeat.o(98986);
        return str3;
    }
}
