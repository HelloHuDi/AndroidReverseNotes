package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31070k;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41061ho;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41062hr;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46941hq;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.n */
public class C5848n {
    /* renamed from: a */
    private WeakReference<C36480m> f1486a;
    /* renamed from: b */
    private String f1487b;

    /* renamed from: a */
    public void mo12378a(String str, C41061ho c41061ho, C36480m c36480m, String str2) {
        AppMethodBeat.m2504i(98249);
        if (c41061ho == null || c36480m == null) {
            AppMethodBeat.m2505o(98249);
            return;
        }
        this.f1486a = new WeakReference(c36480m);
        this.f1487b = str2;
        List<C46941hq> a = m8977a(c41061ho);
        if (a == null || a.size() == 0) {
            AppMethodBeat.m2505o(98249);
            return;
        }
        for (C46941hq a2 : a) {
            m8979a(a2, str);
        }
        AppMethodBeat.m2505o(98249);
    }

    /* renamed from: a */
    private List<C46941hq> m8977a(C41061ho c41061ho) {
        List<C46941hq> list = null;
        AppMethodBeat.m2504i(98250);
        try {
            C16193dt a = C31006ds.m49791a().mo50283a("https://vectorsdk.map.qq.com".concat(String.valueOf(C36520ic.m60475a(this.f1487b))), "androidsdk", c41061ho.toByteArray("UTF-8"));
            if (a == null || a.f3096a == null) {
                m8978a(1, null);
                AppMethodBeat.m2505o(98250);
                return list;
            }
            C31070k c31070k = new C31070k(a.f3096a);
            c31070k.mo50504a("UTF-8");
            C41062hr c41062hr = new C41062hr();
            c41062hr.readFrom(c31070k);
            if (c41062hr.f16508a == 0) {
                list = c41062hr.f16509b;
                AppMethodBeat.m2505o(98250);
                return list;
            }
            m8978a(2, null);
            AppMethodBeat.m2505o(98250);
            return list;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m8979a(C46941hq c46941hq, String str) {
        Closeable inputStream;
        Closeable fileOutputStream;
        Closeable closeable;
        Throwable th;
        AppMethodBeat.m2504i(98251);
        if (c46941hq.f18311b != 0) {
            m8978a(2, null);
            AppMethodBeat.m2505o(98251);
        } else if (c46941hq.f18313d == 1) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(c46941hq.f18314e).openConnection();
                inputStream = httpURLConnection.getInputStream();
                try {
                    File file = new File(str + File.separator + c46941hq.f18310a);
                    if (!file.exists()) {
                        File parentFile = file.getParentFile();
                        if (parentFile != null) {
                            parentFile.mkdirs();
                        }
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file, false);
                } catch (Exception e) {
                    closeable = null;
                    C31015v.m49801a(inputStream);
                    C31015v.m49801a(closeable);
                    AppMethodBeat.m2505o(98251);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    C31015v.m49801a(inputStream);
                    C31015v.m49801a(fileOutputStream);
                    AppMethodBeat.m2505o(98251);
                    throw th;
                }
                try {
                    C31015v.m49799a(inputStream, fileOutputStream);
                    httpURLConnection.disconnect();
                    m8978a(0, c46941hq);
                    C31015v.m49801a(inputStream);
                    C31015v.m49801a(fileOutputStream);
                    AppMethodBeat.m2505o(98251);
                } catch (Exception e2) {
                    closeable = fileOutputStream;
                    C31015v.m49801a(inputStream);
                    C31015v.m49801a(closeable);
                    AppMethodBeat.m2505o(98251);
                } catch (Throwable th3) {
                    th = th3;
                    C31015v.m49801a(inputStream);
                    C31015v.m49801a(fileOutputStream);
                    AppMethodBeat.m2505o(98251);
                    throw th;
                }
            } catch (Exception e3) {
                closeable = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                inputStream = null;
                C31015v.m49801a(inputStream);
                C31015v.m49801a(fileOutputStream);
                AppMethodBeat.m2505o(98251);
                throw th;
            }
        } else {
            m8978a(0, c46941hq);
            AppMethodBeat.m2505o(98251);
        }
    }

    /* renamed from: a */
    private void m8978a(int i, C46941hq c46941hq) {
        AppMethodBeat.m2504i(98252);
        if (!(this.f1486a == null || this.f1486a.get() == null)) {
            ((C36480m) this.f1486a.get()).onResult(i, c46941hq);
        }
        AppMethodBeat.m2505o(98252);
    }
}
