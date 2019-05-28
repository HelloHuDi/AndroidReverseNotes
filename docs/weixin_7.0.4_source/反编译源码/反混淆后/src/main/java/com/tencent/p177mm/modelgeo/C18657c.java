package com.tencent.p177mm.modelgeo;

import com.facebook.appevents.UserDataStore;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.modelgeo.c */
public final class C18657c implements C1202f {
    public static String TAG = "MicroMsg.LocationAddr";
    private static C18657c fBv;
    private boolean fBA = true;
    private C18658c fBw = null;
    private CopyOnWriteArrayList<C18658c> fBx = new CopyOnWriteArrayList();
    private HashMap<String, CopyOnWriteArrayList<WeakReference<C18660a>>> fBy = new HashMap();
    private C23498az fBz = new C23498az(1, "addr_worker");

    /* renamed from: com.tencent.mm.modelgeo.c$c */
    class C18658c {
        double lat;
        double lng;
        Object tag = "";

        public C18658c(double d, double d2, Object obj) {
            this.lat = d;
            this.lng = d2;
            this.tag = obj;
        }

        public final String toString() {
            String str;
            AppMethodBeat.m2504i(78108);
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            if (this.tag == null) {
                str = "";
            } else if ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) {
                str = this.tag;
            } else {
                str = this.tag.toString();
            }
            str = append.append(str).toString();
            AppMethodBeat.m2505o(78108);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(78109);
            if (obj == null || !(obj instanceof C18658c)) {
                AppMethodBeat.m2505o(78109);
                return false;
            }
            boolean equals = ((C18658c) obj).toString().equals(toString());
            AppMethodBeat.m2505o(78109);
            return equals;
        }
    }

    /* renamed from: com.tencent.mm.modelgeo.c$b */
    class C18659b implements C23499a {
        private Addr fBB = null;

        public final boolean acf() {
            AppMethodBeat.m2504i(78106);
            if (C18657c.this.fBw == null) {
                AppMethodBeat.m2505o(78106);
                return false;
            }
            if (this.fBB == null || this.fBB.fBg == null || this.fBB.fBg.equals("")) {
                this.fBB = C18657c.m29167c(C18657c.this.fBw.lat, C18657c.this.fBw.lng, C18657c.this.fBA);
            }
            AppMethodBeat.m2505o(78106);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(78107);
            C18657c.this.fBA = true;
            C18657c.m29162a(C18657c.this, this.fBB);
            AppMethodBeat.m2505o(78107);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.modelgeo.c$a */
    public interface C18660a {
        /* renamed from: b */
        void mo8746b(Addr addr);
    }

    /* renamed from: c */
    static /* synthetic */ Addr m29167c(double d, double d2, boolean z) {
        AppMethodBeat.m2504i(78122);
        Addr b = C18657c.m29164b(d, d2, z);
        AppMethodBeat.m2505o(78122);
        return b;
    }

    private C18657c() {
        AppMethodBeat.m2504i(78110);
        AppMethodBeat.m2505o(78110);
    }

    public static C18657c agw() {
        AppMethodBeat.m2504i(78111);
        if (fBv == null) {
            fBv = new C18657c();
        }
        C18657c c18657c = fBv;
        AppMethodBeat.m2505o(78111);
        return c18657c;
    }

    /* renamed from: a */
    public final boolean mo33925a(C18660a c18660a) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        AppMethodBeat.m2504i(78112);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str : this.fBy.keySet()) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.fBy.get(str);
            C18657c.m29166b(copyOnWriteArrayList, c18660a);
            this.fBy.put(str, copyOnWriteArrayList);
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
                linkedList2.add(str);
            }
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            this.fBy.remove((String) it.next());
        }
        Iterator it2 = this.fBx.iterator();
        while (it2.hasNext()) {
            C18658c c18658c = (C18658c) it2.next();
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.fBy.get(c18658c.toString());
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
                linkedList.add(c18658c);
                this.fBy.remove(c18658c.toString());
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            this.fBx.remove((C18658c) it.next());
        }
        C4990ab.m7417i(TAG, "remove taskLists %d listeners size %d", Integer.valueOf(this.fBx.size()), Integer.valueOf(this.fBy.size()));
        AppMethodBeat.m2505o(78112);
        return true;
    }

    /* renamed from: a */
    private static boolean m29163a(CopyOnWriteArrayList<WeakReference<C18660a>> copyOnWriteArrayList, C18660a c18660a) {
        AppMethodBeat.m2504i(78113);
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C18660a) weakReference.get()).equals(c18660a)) {
                AppMethodBeat.m2505o(78113);
                return true;
            }
        }
        AppMethodBeat.m2505o(78113);
        return false;
    }

    /* renamed from: b */
    private static boolean m29166b(CopyOnWriteArrayList<WeakReference<C18660a>> copyOnWriteArrayList, C18660a c18660a) {
        AppMethodBeat.m2504i(78114);
        if (copyOnWriteArrayList == null) {
            AppMethodBeat.m2505o(78114);
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C18660a) weakReference.get()).equals(c18660a)) {
                copyOnWriteArrayList.remove(weakReference);
                AppMethodBeat.m2505o(78114);
                return true;
            }
        }
        AppMethodBeat.m2505o(78114);
        return false;
    }

    /* renamed from: a */
    public final boolean mo33923a(double d, double d2, C18660a c18660a) {
        AppMethodBeat.m2504i(78116);
        boolean a = mo33924a(d, d2, c18660a, null);
        AppMethodBeat.m2505o(78116);
        return a;
    }

    private void agx() {
        AppMethodBeat.m2504i(78117);
        if (this.fBw == null && this.fBx != null && this.fBx.size() > 0) {
            this.fBw = (C18658c) this.fBx.remove(0);
            agy();
        }
        AppMethodBeat.m2505o(78117);
    }

    private void agy() {
        AppMethodBeat.m2504i(78118);
        if (C5046bo.m7558gT(C4996ah.getContext())) {
            this.fBz.mo39163e(new C18659b());
            AppMethodBeat.m2505o(78118);
            return;
        }
        C1720g.m3540Rg().mo14539a(655, (C1202f) this);
        C1720g.m3540Rg().mo14541a(new C9691e(this.fBw.lat, this.fBw.lng), 0);
        AppMethodBeat.m2505o(78118);
    }

    /* renamed from: a */
    private void m29161a(Addr addr) {
        AppMethodBeat.m2504i(78119);
        if (this.fBw == null) {
            AppMethodBeat.m2505o(78119);
            return;
        }
        Object obj;
        if (addr == null) {
            addr = new Addr();
        }
        if (this.fBw.tag == null) {
            obj = new Object();
        } else {
            obj = this.fBw.tag;
        }
        addr.tag = obj;
        addr.fBr = (float) this.fBw.lat;
        addr.fBs = (float) this.fBw.lng;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.fBy.get(this.fBw.toString());
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((C18660a) weakReference.get()).mo8746b(addr);
                }
            }
        }
        this.fBy.remove(this.fBw.toString());
        C4990ab.m7411d(TAG, "postexecute2 listeners %d", Integer.valueOf(this.fBy.size()));
        this.fBw = null;
        agx();
        if (this.fBw == null && this.fBx.size() > 0) {
            C1720g.m3540Rg().mo14546b(655, (C1202f) this);
        }
        AppMethodBeat.m2505o(78119);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0085=Splitter:B:13:0x0085, B:64:0x0238=Splitter:B:64:0x0238} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a8 A:{SYNTHETIC, Splitter:B:18:0x00a8} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a8 A:{SYNTHETIC, Splitter:B:18:0x00a8} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0084 A:{Splitter:B:6:0x0070, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a8 A:{SYNTHETIC, Splitter:B:18:0x00a8} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a8 A:{SYNTHETIC, Splitter:B:18:0x00a8} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:12:0x0084, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:16:0x00a1, code skipped:
            r3.connection.disconnect();
     */
    /* JADX WARNING: Missing block: B:67:0x0254, code skipped:
            r3.connection.disconnect();
     */
    /* JADX WARNING: Missing block: B:70:0x0270, code skipped:
            r0 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static Addr m29164b(double d, double d2, boolean z) {
        Object format;
        InputStreamReader inputStreamReader;
        Throwable e;
        AppMethodBeat.m2504i(78120);
        String dor = C4988aa.dor();
        Addr addr = new Addr();
        if (z) {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), dor});
        } else {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), "zh_CN"});
        }
        C4990ab.m7410d(TAG, "url ".concat(String.valueOf(format)));
        C1936u c1936u = null;
        try {
            c1936u = C1897b.m4020a(format, null);
            c1936u.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
            c1936u.setRequestMethod("GET");
            C4990ab.m7410d(TAG, "conn " + c1936u.getResponseCode());
            inputStreamReader = new InputStreamReader(c1936u.getInputStream());
            try {
                String readLine;
                String string;
                String string2;
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                C4990ab.m7410d(TAG, "sb " + stringBuffer.toString());
                JSONArray jSONArray = new JSONObject(stringBuffer.toString()).getJSONArray("results");
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                addr.fBg = jSONObject.getString("formatted_address");
                JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("address_components");
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                    string = jSONObject2.getString("long_name");
                    string2 = jSONObject2.getJSONArray("types").getString(0);
                    if (string2.equals("administrative_area_level_1")) {
                        addr.fBh = string;
                    } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_LOCALITY)) {
                        addr.fBi = string;
                    } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY)) {
                        addr.fBk = string;
                    } else if (string2.equals("neighborhood")) {
                        addr.fBl = string;
                    } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_ROUTE)) {
                        addr.fBm = string;
                    } else if (string2.equals("street_number")) {
                        addr.fBn = string;
                    } else if (string2.equals(UserDataStore.COUNTRY)) {
                        addr.country = string;
                    }
                }
                String str = ProtocolPackage.ServerEncoding;
                string2 = URLEncoder.encode(addr.fBg, str);
                readLine = URLEncoder.encode(jSONArray2.toString(), str);
                string = URLEncoder.encode(jSONObject.getJSONObject("geometry").toString(), str);
                String encode = URLEncoder.encode(jSONObject.getString("place_id"), str);
                String encode2 = URLEncoder.encode(jSONObject.getJSONArray("types").toString(), str);
                str = URLEncoder.encode(String.format("[%f,%f]", new Object[]{Double.valueOf(d), Double.valueOf(d2)}), str);
                C4990ab.m7411d(TAG, "google report, formattedaddr: %s, componentaddr: %s, geometry: %s, placeId: %s, types: %s, location: %s, curLanguage: %s", string2, readLine, string, encode, encode2, str, dor);
                C7060h.pYm.mo8381e(12886, readLine, string2, string, encode, encode2, str, dor);
                c1936u.connection.disconnect();
            } catch (Exception e2) {
            } catch (IOException e3) {
            }
        } catch (IOException e4) {
            e = e4;
            inputStreamReader = null;
            try {
                C4990ab.m7410d(TAG, "error e");
                C4990ab.m7413e(TAG, "exception:%s", C5046bo.m7574l(e));
                if (c1936u != null) {
                }
                if (inputStreamReader != null) {
                }
                AppMethodBeat.m2505o(78120);
                return addr;
            } catch (Throwable th) {
                if (c1936u != null) {
                    c1936u.connection.disconnect();
                }
                AppMethodBeat.m2505o(78120);
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamReader = null;
            C4990ab.m7410d(TAG, "error Exception");
            C4990ab.m7413e(TAG, "exception:%s", C5046bo.m7574l(e));
            if (c1936u != null) {
            }
            if (inputStreamReader != null) {
            }
            AppMethodBeat.m2505o(78120);
            return addr;
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e6) {
                C4990ab.m7413e(TAG, "exception:%s", C5046bo.m7574l(e6));
            }
        }
        AppMethodBeat.m2505o(78120);
        return addr;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78121);
        if (c1207m.getType() == 655) {
            Addr agD = ((C9691e) c1207m).agD();
            if (agD == null || agD.fBg == null || agD.fBg.equals("")) {
                this.fBz.mo39163e(new C18659b());
                AppMethodBeat.m2505o(78121);
                return;
            }
            m29161a(agD);
        }
        AppMethodBeat.m2505o(78121);
    }

    /* renamed from: a */
    public final boolean mo33924a(double d, double d2, C18660a c18660a, Object obj) {
        C18658c c18658c;
        AppMethodBeat.m2504i(78115);
        if (obj != null) {
            Iterator it = this.fBx.iterator();
            while (it.hasNext()) {
                c18658c = (C18658c) it.next();
                if (c18658c != null && c18658c.tag != null && c18658c.tag.equals(obj)) {
                    this.fBx.remove(c18658c);
                    break;
                }
            }
        }
        c18658c = new C18658c(d, d2, obj);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.fBy.get(c18658c.toString());
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
        }
        if (!C18657c.m29163a(copyOnWriteArrayList, c18660a)) {
            copyOnWriteArrayList.add(new WeakReference(c18660a));
        }
        this.fBy.put(c18658c.toString(), copyOnWriteArrayList);
        Iterator it2 = this.fBx.iterator();
        while (it2.hasNext()) {
            if (((C18658c) it2.next()).equals(c18658c)) {
                agx();
                AppMethodBeat.m2505o(78115);
                return false;
            }
        }
        if (this.fBw == null || !c18658c.equals(this.fBw)) {
            this.fBx.add(c18658c);
            C4990ab.m7417i(TAG, "push task size %d listeners %d", Integer.valueOf(this.fBx.size()), Integer.valueOf(this.fBy.size()));
            while (this.fBx.size() > 30) {
                C4990ab.m7416i(TAG, "force remove task");
                c18658c = (C18658c) this.fBx.remove(0);
                if (c18658c != null) {
                    this.fBy.remove(c18658c.toString());
                }
            }
            agx();
            AppMethodBeat.m2505o(78115);
            return true;
        }
        AppMethodBeat.m2505o(78115);
        return false;
    }
}
