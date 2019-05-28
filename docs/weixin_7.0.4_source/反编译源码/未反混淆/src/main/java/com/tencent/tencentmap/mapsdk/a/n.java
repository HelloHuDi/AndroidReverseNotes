package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ho;
import com.tencent.tencentmap.mapsdk.maps.a.hq;
import com.tencent.tencentmap.mapsdk.maps.a.hr;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class n {
    private WeakReference<m> a;
    private String b;

    public void a(String str, ho hoVar, m mVar, String str2) {
        AppMethodBeat.i(98249);
        if (hoVar == null || mVar == null) {
            AppMethodBeat.o(98249);
            return;
        }
        this.a = new WeakReference(mVar);
        this.b = str2;
        List<hq> a = a(hoVar);
        if (a == null || a.size() == 0) {
            AppMethodBeat.o(98249);
            return;
        }
        for (hq a2 : a) {
            a(a2, str);
        }
        AppMethodBeat.o(98249);
    }

    private List<hq> a(ho hoVar) {
        List<hq> list = null;
        AppMethodBeat.i(98250);
        try {
            dt a = ds.a().a("https://vectorsdk.map.qq.com".concat(String.valueOf(ic.a(this.b))), "androidsdk", hoVar.toByteArray("UTF-8"));
            if (a == null || a.a == null) {
                a(1, null);
                AppMethodBeat.o(98250);
                return list;
            }
            k kVar = new k(a.a);
            kVar.a("UTF-8");
            hr hrVar = new hr();
            hrVar.readFrom(kVar);
            if (hrVar.a == 0) {
                list = hrVar.b;
                AppMethodBeat.o(98250);
                return list;
            }
            a(2, null);
            AppMethodBeat.o(98250);
            return list;
        } catch (Exception e) {
        }
    }

    private void a(hq hqVar, String str) {
        Closeable inputStream;
        Closeable fileOutputStream;
        Closeable closeable;
        Throwable th;
        AppMethodBeat.i(98251);
        if (hqVar.b != 0) {
            a(2, null);
            AppMethodBeat.o(98251);
        } else if (hqVar.d == 1) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(hqVar.e).openConnection();
                inputStream = httpURLConnection.getInputStream();
                try {
                    File file = new File(str + File.separator + hqVar.a);
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
                    v.a(inputStream);
                    v.a(closeable);
                    AppMethodBeat.o(98251);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    v.a(inputStream);
                    v.a(fileOutputStream);
                    AppMethodBeat.o(98251);
                    throw th;
                }
                try {
                    v.a(inputStream, fileOutputStream);
                    httpURLConnection.disconnect();
                    a(0, hqVar);
                    v.a(inputStream);
                    v.a(fileOutputStream);
                    AppMethodBeat.o(98251);
                } catch (Exception e2) {
                    closeable = fileOutputStream;
                    v.a(inputStream);
                    v.a(closeable);
                    AppMethodBeat.o(98251);
                } catch (Throwable th3) {
                    th = th3;
                    v.a(inputStream);
                    v.a(fileOutputStream);
                    AppMethodBeat.o(98251);
                    throw th;
                }
            } catch (Exception e3) {
                closeable = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                inputStream = null;
                v.a(inputStream);
                v.a(fileOutputStream);
                AppMethodBeat.o(98251);
                throw th;
            }
        } else {
            a(0, hqVar);
            AppMethodBeat.o(98251);
        }
    }

    private void a(int i, hq hqVar) {
        AppMethodBeat.i(98252);
        if (!(this.a == null || this.a.get() == null)) {
            ((m) this.a.get()).onResult(i, hqVar);
        }
        AppMethodBeat.o(98252);
    }
}
