package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.map.lib.d;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.ZipUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ar;
import com.tencent.tencentmap.mapsdk.a.m;
import com.tencent.tencentmap.mapsdk.a.n;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.s;
import com.tencent.tencentmap.mapsdk.a.u;
import com.tencent.tencentmap.mapsdk.a.v;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jo implements m {
    private static volatile Map<String, List<WeakReference<ar>>> e = new HashMap();
    private boolean a = false;
    private String b;
    private s c;
    private r d;
    private WeakReference<ar> f;
    private String g;
    private String h;
    private String i;
    private String j;

    static class a extends Thread {
        private final WeakReference<jo> a;
        private final String b;
        private final int c;

        public a(jo joVar, String str, int i) {
            AppMethodBeat.i(100074);
            this.a = new WeakReference(joVar);
            this.b = str;
            this.c = i;
            AppMethodBeat.o(100074);
        }

        public void run() {
            AppMethodBeat.i(100075);
            if (!(this.a == null || this.a.get() == null)) {
                jo joVar = (jo) this.a.get();
                jo.a(joVar, this.b, this.c);
                jo.a(joVar);
            }
            AppMethodBeat.o(100075);
        }
    }

    static /* synthetic */ void a(jo joVar, String str, int i) {
        AppMethodBeat.i(100085);
        joVar.b(str, i);
        AppMethodBeat.o(100085);
    }

    static {
        AppMethodBeat.i(100087);
        AppMethodBeat.o(100087);
    }

    public jo(Context context, ar arVar, String str) {
        AppMethodBeat.i(100076);
        this.d = r.a(context);
        this.b = "";
        if (!(arVar == null || arVar.l() == null || arVar.l().b() == null)) {
            this.b = arVar.l().b().G();
        }
        this.f = new WeakReference(arVar);
        this.g = str;
        this.h = this.d.b(this.g);
        this.i = this.d.c(this.g);
        this.j = this.d.d(this.g);
        this.c = u.a(context, this.g);
        AppMethodBeat.o(100076);
    }

    public void a(String str, int i) {
        AppMethodBeat.i(100077);
        String b = b();
        if (e.containsKey(b)) {
            a(b, this.f);
            AppMethodBeat.o(100077);
            return;
        }
        a(b, this.f);
        new a(this, str, i).start();
        AppMethodBeat.o(100077);
    }

    public void onResult(int i, Object obj) {
        boolean z = false;
        AppMethodBeat.i(100078);
        if (i == 0 && (obj instanceof hq)) {
            if (a(true, (hq) obj) || this.a) {
                z = true;
            }
            this.a = z;
            AppMethodBeat.o(100078);
            return;
        }
        if (a(false, null) || this.a) {
            z = true;
        }
        this.a = z;
        AppMethodBeat.o(100078);
    }

    private void b(String str, int i) {
        Object hpVar;
        AppMethodBeat.i(100079);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hp("mapconfig", this.c.b("mapConfigVersion"), this.c.a("mapConfigZipMd5")));
        arrayList.add(new hp("poi_icon", this.c.b("poiIconVersion"), this.c.a("mapPoiIconZipMd5")));
        arrayList.add(new hp("map_icon", this.c.b("mapIconVersion"), this.c.a("mapIconZipMd5")));
        arrayList.add(new hp("rtt_config.json", this.c.b("rttConfigVersion"), this.c.a("rttConfigMd5")));
        arrayList.add(new hp("closedroadstyle_normalmode", this.c.b("closeRoadSytleNomalModeVersion"), this.c.a("closeRoadSytleNomalModeMd5")));
        arrayList.add(new hp("closedroadstyle_trafficmode", this.c.b("closeRoadStyleTrafficModeVersion"), this.c.a("closeRoadStyleTrafficModeMd5")));
        if (i == jj.d) {
            hpVar = new hp("indoormap_config_premium", this.c.b("mapConfigIndoorPremiumVersion"), this.c.a("mapConfigIndoorPremiumMd5"));
        } else {
            hpVar = new hp("indoormap_config", this.c.b("mapConfigIndoorVersion"), this.c.a("mapConfigIndoorMd5"));
        }
        arrayList.add(hpVar);
        arrayList.add(new hp("indoorpoi_icon", this.c.b("mapPoiIconIndoorVersion"), this.c.a("poiIconIndoorMd5")));
        arrayList.add(new hp("sdk_offline_city_ver.json", this.c.b("offlineCityListVersion"), this.c.a("offlineCityListMd5")));
        String b = b();
        new n().a(this.j, new ho(arrayList, b, "4.2.2.1", null, this.b, str), this, b);
        AppMethodBeat.o(100079);
    }

    private void a() {
        AppMethodBeat.i(100080);
        this.c.a("mapConfigLastCheckTime", System.currentTimeMillis());
        List list = (List) e.get(b());
        if (list == null) {
            AppMethodBeat.o(100080);
            return;
        }
        int size = list.size();
        WeakReference[] weakReferenceArr = (WeakReference[]) list.toArray(new WeakReference[size]);
        for (int i = 0; i < size; i++) {
            if (weakReferenceArr[i] != null) {
                ar arVar = (ar) weakReferenceArr[i].get();
                if (!(arVar == null || arVar.l() == null || arVar.l().b() == null)) {
                    f b = arVar.l().b();
                    if (this.a) {
                        b.p();
                        if (arVar.b() != null) {
                            arVar.b().a(b);
                        }
                        b.a();
                    }
                    b.k(true);
                }
            }
        }
        e.clear();
        u.c();
        AppMethodBeat.o(100080);
    }

    private boolean a(boolean z, hq hqVar) {
        AppMethodBeat.i(100081);
        if (!z || hqVar == null) {
            AppMethodBeat.o(100081);
            return false;
        } else if (hqVar.d == 0) {
            AppMethodBeat.o(100081);
            return false;
        } else {
            v.a(this.j);
            String str = this.j + hqVar.a;
            String str2 = hqVar.a;
            boolean z2 = true;
            switch (str2.hashCode()) {
                case -2042251002:
                    if (str2.equals("sdk_offline_city_ver.json")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1105972063:
                    if (str2.equals("indoorpoi_icon")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -810824476:
                    if (str2.equals("closedroadstyle_normalmode")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -752505210:
                    if (str2.equals("closedroadstyle_trafficmode")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 178735484:
                    if (str2.equals("map_icon")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 451944782:
                    if (str2.equals("poi_icon")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1217119024:
                    if (str2.equals("indoormap_config_premium")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1221876167:
                    if (str2.equals("rtt_config.json")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1366209438:
                    if (str2.equals("mapconfig")) {
                        z2 = false;
                        break;
                    }
                    break;
                case 1590879768:
                    if (str2.equals("indoormap_config")) {
                        z2 = true;
                        break;
                    }
                    break;
            }
            switch (z2) {
                case false:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a("mapConfigVersion", hqVar.c);
                        this.c.a("mapConfigZipMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, true);
                    if (z2) {
                        this.c.a("poiIconVersion", hqVar.c);
                        this.c.a("mapPoiIconZipMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.i, hqVar.f, true);
                    if (z2) {
                        this.c.a("mapIconVersion", hqVar.c);
                        this.c.a("mapIconZipMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a("rttConfigVersion", hqVar.c);
                        this.c.a("rttConfigMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a("closeRoadSytleNomalModeVersion", hqVar.c);
                        this.c.a("closeRoadSytleNomalModeMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a("closeRoadStyleTrafficModeVersion", hqVar.c);
                        this.c.a("closeRoadStyleTrafficModeMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a(new String[]{"mapConfigIndoorVersion", "mapConfigIndoorMd5"});
                        this.c.a("mapConfigIndoorPremiumVersion", hqVar.c);
                        this.c.a("mapConfigIndoorPremiumMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a(new String[]{"mapConfigIndoorPremiumVersion", "mapConfigIndoorPremiumMd5"});
                        this.c.a("mapConfigIndoorVersion", hqVar.c);
                        this.c.a("mapConfigIndoorMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a("mapPoiIconIndoorVersion", hqVar.c);
                        this.c.a("poiIconIndoorMd5", hqVar.f);
                        break;
                    }
                    break;
                case true:
                    z2 = a(str, this.h, hqVar.f, false);
                    if (z2) {
                        this.c.a("offlineCityListVersion", hqVar.c);
                        this.c.a("offlineCityListMd5", hqVar.f);
                        break;
                    }
                    break;
                default:
                    z2 = false;
                    break;
            }
            v.c(this.j);
            AppMethodBeat.o(100081);
            return z2;
        }
    }

    private boolean a(String str, String str2, String str3, boolean z) {
        Throwable th;
        AppMethodBeat.i(100082);
        File file = new File(str);
        if (!file.exists() || str3 == null) {
            AppMethodBeat.o(100082);
            return false;
        }
        try {
            if (!str3.equals(com.tencent.map.lib.util.a.a(file))) {
                AppMethodBeat.o(100082);
                return false;
            }
        } catch (FileNotFoundException e) {
            d.b(e.getMessage());
        }
        if (z) {
            try {
                ZipUtil.upZipFile(file, this.j);
                file.delete();
            } catch (IOException e2) {
                d.b(e2.getMessage());
            }
        }
        File file2 = new File(this.j);
        if (file2.exists() && file2.isDirectory()) {
            String b = b();
            if (e == null || e.get(b) == null || ((List) e.get(b)).size() == 0) {
                AppMethodBeat.o(100082);
                return false;
            }
            ar arVar = null;
            List list = (List) e.get(b);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    arVar = (ar) ((WeakReference) list.get(i)).get();
                    if (arVar != null) {
                        break;
                    }
                }
            }
            if (arVar == null || arVar.l() == null || arVar.l().b() == null) {
                AppMethodBeat.o(100082);
                return false;
            }
            f b2 = arVar.l().b();
            boolean z2 = true;
            File[] listFiles = file2.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(100082);
                return true;
            }
            for (File file3 : listFiles) {
                String a = a(file3.getName());
                if (a == null) {
                    file3.delete();
                } else {
                    Closeable fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            byte[] bArr = new byte[((int) file3.length())];
                            fileInputStream.read(bArr, 0, bArr.length);
                            if (str2.equals(this.h)) {
                                z2 &= b2.a(a, bArr);
                            } else if (str2.equals(this.i)) {
                                z2 &= b2.b(a, bArr);
                            }
                            v.a(fileInputStream);
                        } catch (FileNotFoundException e3) {
                            v.a(fileInputStream);
                        } catch (IOException e4) {
                            v.a(fileInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            v.a(fileInputStream);
                            AppMethodBeat.o(100082);
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        fileInputStream = null;
                        v.a(fileInputStream);
                    } catch (IOException e6) {
                        fileInputStream = null;
                        v.a(fileInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                        v.a(fileInputStream);
                        AppMethodBeat.o(100082);
                        throw th;
                    }
                }
            }
            AppMethodBeat.o(100082);
            return z2;
        }
        d.b("Config temp dir not exists:" + this.j);
        AppMethodBeat.o(100082);
        return false;
    }

    private String a(String str) {
        AppMethodBeat.i(100083);
        if (str.equals("mapconfig")) {
            str = "mapconfig.dat";
            AppMethodBeat.o(100083);
            return str;
        } else if (str.equals("indoormap_config") || str.equals("indoormap_config_premium")) {
            str = "indoormap_config.dat";
            AppMethodBeat.o(100083);
            return str;
        } else if (str.equals("indoorpoi_icon")) {
            str = "poi_icon_indoor@2x.png";
            AppMethodBeat.o(100083);
            return str;
        } else if (str.equals("closedroadstyle_normalmode")) {
            str = "style_normalmode.xml";
            AppMethodBeat.o(100083);
            return str;
        } else if (str.equals("closedroadstyle_trafficmode")) {
            str = "style_trafficmode.xml";
            AppMethodBeat.o(100083);
            return str;
        } else if (str.contains("@3x")) {
            AppMethodBeat.o(100083);
            return null;
        } else {
            AppMethodBeat.o(100083);
            return str;
        }
    }

    private String b() {
        String str = this.g;
        if (str == null) {
            return ic.a;
        }
        return str;
    }

    private synchronized void a(String str, WeakReference<ar> weakReference) {
        AppMethodBeat.i(100084);
        if (e.containsKey(str)) {
            ((List) e.get(str)).add(weakReference);
            AppMethodBeat.o(100084);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(weakReference);
            e.put(str, arrayList);
            AppMethodBeat.o(100084);
        }
    }
}
