package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.util.C25735a;
import com.tencent.map.lib.util.ZipUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C25001ar;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C36480m;
import com.tencent.tencentmap.mapsdk.p666a.C41027s;
import com.tencent.tencentmap.mapsdk.p666a.C41355u;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;
import com.tencent.tencentmap.mapsdk.p666a.C5848n;
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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jo */
public class C41067jo implements C36480m {
    /* renamed from: e */
    private static volatile Map<String, List<WeakReference<C25001ar>>> f16515e = new HashMap();
    /* renamed from: a */
    private boolean f16516a = false;
    /* renamed from: b */
    private String f16517b;
    /* renamed from: c */
    private C41027s f16518c;
    /* renamed from: d */
    private C46765r f16519d;
    /* renamed from: f */
    private WeakReference<C25001ar> f16520f;
    /* renamed from: g */
    private String f16521g;
    /* renamed from: h */
    private String f16522h;
    /* renamed from: i */
    private String f16523i;
    /* renamed from: j */
    private String f16524j;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jo$a */
    static class C24394a extends Thread {
        /* renamed from: a */
        private final WeakReference<C41067jo> f4749a;
        /* renamed from: b */
        private final String f4750b;
        /* renamed from: c */
        private final int f4751c;

        public C24394a(C41067jo c41067jo, String str, int i) {
            AppMethodBeat.m2504i(100074);
            this.f4749a = new WeakReference(c41067jo);
            this.f4750b = str;
            this.f4751c = i;
            AppMethodBeat.m2505o(100074);
        }

        public void run() {
            AppMethodBeat.m2504i(100075);
            if (!(this.f4749a == null || this.f4749a.get() == null)) {
                C41067jo c41067jo = (C41067jo) this.f4749a.get();
                C41067jo.m71430a(c41067jo, this.f4750b, this.f4751c);
                C41067jo.m71429a(c41067jo);
            }
            AppMethodBeat.m2505o(100075);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m71430a(C41067jo c41067jo, String str, int i) {
        AppMethodBeat.m2504i(100085);
        c41067jo.m71435b(str, i);
        AppMethodBeat.m2505o(100085);
    }

    static {
        AppMethodBeat.m2504i(100087);
        AppMethodBeat.m2505o(100087);
    }

    public C41067jo(Context context, C25001ar c25001ar, String str) {
        AppMethodBeat.m2504i(100076);
        this.f16519d = C46765r.m88663a(context);
        this.f16517b = "";
        if (!(c25001ar == null || c25001ar.mo41910l() == null || c25001ar.mo41910l().mo75386b() == null)) {
            this.f16517b = c25001ar.mo41910l().mo75386b().mo20144G();
        }
        this.f16520f = new WeakReference(c25001ar);
        this.f16521g = str;
        this.f16522h = this.f16519d.mo75316b(this.f16521g);
        this.f16523i = this.f16519d.mo75318c(this.f16521g);
        this.f16524j = this.f16519d.mo75320d(this.f16521g);
        this.f16518c = C41355u.m72123a(context, this.f16521g);
        AppMethodBeat.m2505o(100076);
    }

    /* renamed from: a */
    public void mo65153a(String str, int i) {
        AppMethodBeat.m2504i(100077);
        String b = m71434b();
        if (f16515e.containsKey(b)) {
            m71431a(b, this.f16520f);
            AppMethodBeat.m2505o(100077);
            return;
        }
        m71431a(b, this.f16520f);
        new C24394a(this, str, i).start();
        AppMethodBeat.m2505o(100077);
    }

    public void onResult(int i, Object obj) {
        boolean z = false;
        AppMethodBeat.m2504i(100078);
        if (i == 0 && (obj instanceof C46941hq)) {
            if (m71433a(true, (C46941hq) obj) || this.f16516a) {
                z = true;
            }
            this.f16516a = z;
            AppMethodBeat.m2505o(100078);
            return;
        }
        if (m71433a(false, null) || this.f16516a) {
            z = true;
        }
        this.f16516a = z;
        AppMethodBeat.m2505o(100078);
    }

    /* renamed from: b */
    private void m71435b(String str, int i) {
        Object c44522hp;
        AppMethodBeat.m2504i(100079);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C44522hp("mapconfig", this.f16518c.mo65087b("mapConfigVersion"), this.f16518c.mo65080a("mapConfigZipMd5")));
        arrayList.add(new C44522hp("poi_icon", this.f16518c.mo65087b("poiIconVersion"), this.f16518c.mo65080a("mapPoiIconZipMd5")));
        arrayList.add(new C44522hp("map_icon", this.f16518c.mo65087b("mapIconVersion"), this.f16518c.mo65080a("mapIconZipMd5")));
        arrayList.add(new C44522hp("rtt_config.json", this.f16518c.mo65087b("rttConfigVersion"), this.f16518c.mo65080a("rttConfigMd5")));
        arrayList.add(new C44522hp("closedroadstyle_normalmode", this.f16518c.mo65087b("closeRoadSytleNomalModeVersion"), this.f16518c.mo65080a("closeRoadSytleNomalModeMd5")));
        arrayList.add(new C44522hp("closedroadstyle_trafficmode", this.f16518c.mo65087b("closeRoadStyleTrafficModeVersion"), this.f16518c.mo65080a("closeRoadStyleTrafficModeMd5")));
        if (i == C16286jj.f3441d) {
            c44522hp = new C44522hp("indoormap_config_premium", this.f16518c.mo65087b("mapConfigIndoorPremiumVersion"), this.f16518c.mo65080a("mapConfigIndoorPremiumMd5"));
        } else {
            c44522hp = new C44522hp("indoormap_config", this.f16518c.mo65087b("mapConfigIndoorVersion"), this.f16518c.mo65080a("mapConfigIndoorMd5"));
        }
        arrayList.add(c44522hp);
        arrayList.add(new C44522hp("indoorpoi_icon", this.f16518c.mo65087b("mapPoiIconIndoorVersion"), this.f16518c.mo65080a("poiIconIndoorMd5")));
        arrayList.add(new C44522hp("sdk_offline_city_ver.json", this.f16518c.mo65087b("offlineCityListVersion"), this.f16518c.mo65080a("offlineCityListMd5")));
        String b = m71434b();
        new C5848n().mo12378a(this.f16524j, new C41061ho(arrayList, b, "4.2.2.1", null, this.f16517b, str), this, b);
        AppMethodBeat.m2505o(100079);
    }

    /* renamed from: a */
    private void m71428a() {
        AppMethodBeat.m2504i(100080);
        this.f16518c.mo65083a("mapConfigLastCheckTime", System.currentTimeMillis());
        List list = (List) f16515e.get(m71434b());
        if (list == null) {
            AppMethodBeat.m2505o(100080);
            return;
        }
        int size = list.size();
        WeakReference[] weakReferenceArr = (WeakReference[]) list.toArray(new WeakReference[size]);
        for (int i = 0; i < size; i++) {
            if (weakReferenceArr[i] != null) {
                C25001ar c25001ar = (C25001ar) weakReferenceArr[i].get();
                if (!(c25001ar == null || c25001ar.mo41910l() == null || c25001ar.mo41910l().mo75386b() == null)) {
                    C8889f b = c25001ar.mo41910l().mo75386b();
                    if (this.f16516a) {
                        b.mo20240p();
                        if (c25001ar.mo41903b() != null) {
                            c25001ar.mo41903b().mo29201a(b);
                        }
                        b.mo20154a();
                    }
                    b.mo20235k(true);
                }
            }
        }
        f16515e.clear();
        C41355u.m72125c();
        AppMethodBeat.m2505o(100080);
    }

    /* renamed from: a */
    private boolean m71433a(boolean z, C46941hq c46941hq) {
        AppMethodBeat.m2504i(100081);
        if (!z || c46941hq == null) {
            AppMethodBeat.m2505o(100081);
            return false;
        } else if (c46941hq.f18313d == 0) {
            AppMethodBeat.m2505o(100081);
            return false;
        } else {
            C31015v.m49802a(this.f16524j);
            String str = this.f16524j + c46941hq.f18310a;
            String str2 = c46941hq.f18310a;
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
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65082a("mapConfigVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("mapConfigZipMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, true);
                    if (z2) {
                        this.f16518c.mo65082a("poiIconVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("mapPoiIconZipMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16523i, c46941hq.f18315f, true);
                    if (z2) {
                        this.f16518c.mo65082a("mapIconVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("mapIconZipMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65082a("rttConfigVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("rttConfigMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65082a("closeRoadSytleNomalModeVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("closeRoadSytleNomalModeMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65082a("closeRoadStyleTrafficModeVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("closeRoadStyleTrafficModeMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65086a(new String[]{"mapConfigIndoorVersion", "mapConfigIndoorMd5"});
                        this.f16518c.mo65082a("mapConfigIndoorPremiumVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("mapConfigIndoorPremiumMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65086a(new String[]{"mapConfigIndoorPremiumVersion", "mapConfigIndoorPremiumMd5"});
                        this.f16518c.mo65082a("mapConfigIndoorVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("mapConfigIndoorMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65082a("mapPoiIconIndoorVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("poiIconIndoorMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                case true:
                    z2 = m71432a(str, this.f16522h, c46941hq.f18315f, false);
                    if (z2) {
                        this.f16518c.mo65082a("offlineCityListVersion", c46941hq.f18312c);
                        this.f16518c.mo65084a("offlineCityListMd5", c46941hq.f18315f);
                        break;
                    }
                    break;
                default:
                    z2 = false;
                    break;
            }
            C31015v.m49805c(this.f16524j);
            AppMethodBeat.m2505o(100081);
            return z2;
        }
    }

    /* renamed from: a */
    private boolean m71432a(String str, String str2, String str3, boolean z) {
        Throwable th;
        AppMethodBeat.m2504i(100082);
        File file = new File(str);
        if (!file.exists() || str3 == null) {
            AppMethodBeat.m2505o(100082);
            return false;
        }
        try {
            if (!str3.equals(C25735a.m40858a(file))) {
                AppMethodBeat.m2505o(100082);
                return false;
            }
        } catch (FileNotFoundException e) {
            C1015d.m2290b(e.getMessage());
        }
        if (z) {
            try {
                ZipUtil.upZipFile(file, this.f16524j);
                file.delete();
            } catch (IOException e2) {
                C1015d.m2290b(e2.getMessage());
            }
        }
        File file2 = new File(this.f16524j);
        if (file2.exists() && file2.isDirectory()) {
            String b = m71434b();
            if (f16515e == null || f16515e.get(b) == null || ((List) f16515e.get(b)).size() == 0) {
                AppMethodBeat.m2505o(100082);
                return false;
            }
            C25001ar c25001ar = null;
            List list = (List) f16515e.get(b);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    c25001ar = (C25001ar) ((WeakReference) list.get(i)).get();
                    if (c25001ar != null) {
                        break;
                    }
                }
            }
            if (c25001ar == null || c25001ar.mo41910l() == null || c25001ar.mo41910l().mo75386b() == null) {
                AppMethodBeat.m2505o(100082);
                return false;
            }
            C8889f b2 = c25001ar.mo41910l().mo75386b();
            boolean z2 = true;
            File[] listFiles = file2.listFiles();
            if (listFiles == null) {
                AppMethodBeat.m2505o(100082);
                return true;
            }
            for (File file3 : listFiles) {
                String a = m71427a(file3.getName());
                if (a == null) {
                    file3.delete();
                } else {
                    Closeable fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            byte[] bArr = new byte[((int) file3.length())];
                            fileInputStream.read(bArr, 0, bArr.length);
                            if (str2.equals(this.f16522h)) {
                                z2 &= b2.mo20186a(a, bArr);
                            } else if (str2.equals(this.f16523i)) {
                                z2 &= b2.mo20202b(a, bArr);
                            }
                            C31015v.m49801a(fileInputStream);
                        } catch (FileNotFoundException e3) {
                            C31015v.m49801a(fileInputStream);
                        } catch (IOException e4) {
                            C31015v.m49801a(fileInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            C31015v.m49801a(fileInputStream);
                            AppMethodBeat.m2505o(100082);
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        fileInputStream = null;
                        C31015v.m49801a(fileInputStream);
                    } catch (IOException e6) {
                        fileInputStream = null;
                        C31015v.m49801a(fileInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                        C31015v.m49801a(fileInputStream);
                        AppMethodBeat.m2505o(100082);
                        throw th;
                    }
                }
            }
            AppMethodBeat.m2505o(100082);
            return z2;
        }
        C1015d.m2290b("Config temp dir not exists:" + this.f16524j);
        AppMethodBeat.m2505o(100082);
        return false;
    }

    /* renamed from: a */
    private String m71427a(String str) {
        AppMethodBeat.m2504i(100083);
        if (str.equals("mapconfig")) {
            str = "mapconfig.dat";
            AppMethodBeat.m2505o(100083);
            return str;
        } else if (str.equals("indoormap_config") || str.equals("indoormap_config_premium")) {
            str = "indoormap_config.dat";
            AppMethodBeat.m2505o(100083);
            return str;
        } else if (str.equals("indoorpoi_icon")) {
            str = "poi_icon_indoor@2x.png";
            AppMethodBeat.m2505o(100083);
            return str;
        } else if (str.equals("closedroadstyle_normalmode")) {
            str = "style_normalmode.xml";
            AppMethodBeat.m2505o(100083);
            return str;
        } else if (str.equals("closedroadstyle_trafficmode")) {
            str = "style_trafficmode.xml";
            AppMethodBeat.m2505o(100083);
            return str;
        } else if (str.contains("@3x")) {
            AppMethodBeat.m2505o(100083);
            return null;
        } else {
            AppMethodBeat.m2505o(100083);
            return str;
        }
    }

    /* renamed from: b */
    private String m71434b() {
        String str = this.f16521g;
        if (str == null) {
            return C36520ic.f15396a;
        }
        return str;
    }

    /* renamed from: a */
    private synchronized void m71431a(String str, WeakReference<C25001ar> weakReference) {
        AppMethodBeat.m2504i(100084);
        if (f16515e.containsKey(str)) {
            ((List) f16515e.get(str)).add(weakReference);
            AppMethodBeat.m2505o(100084);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(weakReference);
            f16515e.put(str, arrayList);
            AppMethodBeat.m2505o(100084);
        }
    }
}
