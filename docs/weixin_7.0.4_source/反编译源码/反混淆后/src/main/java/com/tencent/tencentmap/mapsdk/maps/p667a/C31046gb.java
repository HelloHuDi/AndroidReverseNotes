package com.tencent.tencentmap.mapsdk.maps.p667a;

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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gb */
public class C31046gb extends Thread implements C41051gc {
    /* renamed from: a */
    private long f14131a = 0;
    /* renamed from: b */
    private C46789gm f14132b;
    /* renamed from: c */
    private C24386hf f14133c;
    /* renamed from: d */
    private boolean f14134d = false;
    /* renamed from: e */
    private boolean f14135e = false;
    /* renamed from: f */
    private boolean f14136f = false;
    /* renamed from: g */
    private List<Integer> f14137g;

    public C31046gb(C46789gm c46789gm, C24386hf c24386hf) {
        this.f14132b = c46789gm;
        this.f14133c = c24386hf;
    }

    /* renamed from: a */
    public void mo40577a(boolean z) {
        AppMethodBeat.m2504i(98971);
        if (this.f14132b == null) {
            AppMethodBeat.m2505o(98971);
            return;
        }
        this.f14132b.mo75438b(z);
        this.f14134d = z;
        if (z) {
            try {
                start();
            } catch (Exception e) {
            }
        }
        this.f14132b.mo75472w();
        AppMethodBeat.m2505o(98971);
    }

    /* renamed from: a */
    public boolean mo40578a() {
        return this.f14134d;
    }

    /* renamed from: b */
    public void mo40579b() {
        AppMethodBeat.m2504i(98972);
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98972);
            }
        }
    }

    /* renamed from: c */
    public void mo40580c() {
        AppMethodBeat.m2504i(98973);
        this.f14135e = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98973);
            }
        }
    }

    /* renamed from: d */
    public void mo40581d() {
        AppMethodBeat.m2504i(98974);
        this.f14135e = true;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98974);
            }
        }
    }

    /* renamed from: e */
    public void mo40582e() {
        AppMethodBeat.m2504i(98975);
        this.f14136f = true;
        this.f14135e = true;
        this.f14134d = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98975);
            }
        }
        interrupt();
    }

    public void run() {
        AppMethodBeat.m2504i(98976);
        super.run();
        while (!this.f14136f) {
            if (!this.f14135e && this.f14134d) {
                m49898f();
            }
            synchronized (this) {
                try {
                    wait(300000);
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(98976);
                    }
                } catch (InterruptedException e) {
                    AppMethodBeat.m2505o(98976);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(98976);
    }

    /* renamed from: f */
    private void m49898f() {
        AppMethodBeat.m2504i(98977);
        if (this.f14132b == null || this.f14132b.mo12440a() == null || this.f14132b.mo12440a().mo58861y() == null || this.f14132b.mo12440a().mo58849m() < 11) {
            AppMethodBeat.m2505o(98977);
            return;
        }
        C36894gk a = this.f14132b.mo12440a();
        List a2 = this.f14132b.mo75409a(a.mo58861y(), a.mo58849m());
        if (a2 == null || a2.size() == 0) {
            AppMethodBeat.m2505o(98977);
            return;
        }
        m49893a(a2);
        AppMethodBeat.m2505o(98977);
    }

    /* renamed from: a */
    private void m49893a(List<Integer> list) {
        AppMethodBeat.m2504i(98978);
        if (this.f14133c == null) {
            AppMethodBeat.m2505o(98978);
            return;
        }
        List arrayList = new ArrayList();
        boolean b = m49896b(list);
        if (b || System.currentTimeMillis() - this.f14131a >= 300000) {
            Object obj = null;
            this.f14137g = list;
            int size = list.size() - 1;
            while (size >= 0) {
                Object obj2;
                int intValue = ((Integer) list.get(size)).intValue();
                String num = Integer.toString(intValue);
                File a = m49890a(num);
                String a2 = m49891a(num, a);
                int i;
                if (a == null || System.currentTimeMillis() - a.lastModified() >= 300000) {
                    byte[] a3 = this.f14133c.mo40646a(m49892a(num, a2));
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
                            int a4 = (int) m49889a(bArr);
                            System.arraycopy(a3, 5, bArr, 0, 4);
                            int a5 = (int) m49889a(bArr);
                            if (m49894a(a4, a5, a3)) {
                                m49895b(num, a2);
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
                this.f14132b.mo75426a(arrayList);
                this.f14132b.mo75472w();
            }
            this.f14131a = System.currentTimeMillis();
            AppMethodBeat.m2505o(98978);
            return;
        }
        AppMethodBeat.m2505o(98978);
    }

    /* renamed from: b */
    private boolean m49896b(List<Integer> list) {
        AppMethodBeat.m2504i(98979);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(98979);
            return false;
        } else if (this.f14137g == null) {
            AppMethodBeat.m2505o(98979);
            return true;
        } else {
            int i = 0;
            while (i < list.size()) {
                if (this.f14137g.contains(list.get(i))) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(98979);
                    return true;
                }
            }
            AppMethodBeat.m2505o(98979);
            return false;
        }
    }

    /* renamed from: a */
    private String m49892a(String str, String str2) {
        AppMethodBeat.m2504i(98980);
        if (this.f14132b == null || this.f14132b.mo75394A() == null) {
            AppMethodBeat.m2505o(98980);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f14132b.mo75394A());
        stringBuilder.append("&citycode=".concat(String.valueOf(str)));
        stringBuilder.append("&version=".concat(String.valueOf(str2)));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(98980);
        return stringBuilder2;
    }

    /* renamed from: a */
    private String m49891a(String str, File file) {
        AppMethodBeat.m2504i(98981);
        String str2;
        if (file == null) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.m2505o(98981);
            return str2;
        }
        String[] split = file.getName().split("_|\\.");
        if (split.length <= 1 || !str.equals(split[0])) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.m2505o(98981);
            return str2;
        }
        str2 = split[1];
        AppMethodBeat.m2505o(98981);
        return str2;
    }

    /* renamed from: a */
    private File m49890a(String str) {
        AppMethodBeat.m2504i(98982);
        File g = m49899g();
        if (g == null) {
            AppMethodBeat.m2505o(98982);
            return null;
        }
        try {
            File[] listFiles = g.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.m2505o(98982);
                return null;
            }
            int i = 0;
            while (i < listFiles.length) {
                String[] split = listFiles[i].getName().split("_|\\.");
                if (split.length <= 1 || !str.equals(split[0])) {
                    i++;
                } else {
                    g = listFiles[i];
                    AppMethodBeat.m2505o(98982);
                    return g;
                }
            }
            AppMethodBeat.m2505o(98982);
            return null;
        } catch (Exception e) {
            AppMethodBeat.m2505o(98982);
            return null;
        }
    }

    /* renamed from: g */
    private File m49899g() {
        AppMethodBeat.m2504i(98983);
        if (this.f14132b == null || this.f14132b.mo75397D() == null) {
            AppMethodBeat.m2505o(98983);
            return null;
        }
        String e = this.f14132b.mo75397D().mo57749e();
        if (e == null) {
            AppMethodBeat.m2505o(98983);
            return null;
        }
        File file = new File(e);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e2) {
                AppMethodBeat.m2505o(98983);
                return null;
            }
        }
        AppMethodBeat.m2505o(98983);
        return file;
    }

    /* renamed from: a */
    private long m49889a(byte[] bArr) {
        return (long) ((((bArr[0] & 255) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & WebView.NIGHT_MODE_COLOR));
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090 A:{SYNTHETIC, Splitter:B:37:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b A:{SYNTHETIC, Splitter:B:42:0x009b} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6 A:{SYNTHETIC, Splitter:B:47:0x00a6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m49894a(int i, int i2, byte[] bArr) {
        Throwable th;
        AppMethodBeat.m2504i(98984);
        if (bArr == null || bArr.length < 10) {
            AppMethodBeat.m2505o(98984);
            return false;
        }
        File g = m49899g();
        if (g == null) {
            AppMethodBeat.m2505o(98984);
            return false;
        }
        File file = new File(g.getAbsolutePath() + File.separator + m49897c(Integer.toString(i), Integer.toString(i2)));
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
                    AppMethodBeat.m2505o(98984);
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
                    AppMethodBeat.m2505o(98984);
                    return true;
                } catch (FileNotFoundException e2) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.m2505o(98984);
                    return false;
                } catch (IOException e4) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.m2505o(98984);
                    return false;
                } catch (Exception e6) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    AppMethodBeat.m2505o(98984);
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
                    AppMethodBeat.m2505o(98984);
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                fileOutputStream2 = null;
            } catch (IOException e10) {
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(98984);
                return false;
            } catch (Exception e11) {
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(98984);
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(98984);
                throw th;
            }
        } catch (IOException e12) {
            AppMethodBeat.m2505o(98984);
            return false;
        }
    }

    /* renamed from: b */
    private void m49895b(String str, String str2) {
        AppMethodBeat.m2504i(98985);
        File g = m49899g();
        if (g == null) {
            AppMethodBeat.m2505o(98985);
            return;
        }
        File file = new File(g.getAbsolutePath() + File.separator + m49897c(str, str2));
        if (file.exists() && !file.delete()) {
            file.deleteOnExit();
        }
        AppMethodBeat.m2505o(98985);
    }

    /* renamed from: c */
    private String m49897c(String str, String str2) {
        AppMethodBeat.m2504i(98986);
        String str3 = str + "_" + str2 + ".kml";
        AppMethodBeat.m2505o(98986);
        return str3;
    }
}
