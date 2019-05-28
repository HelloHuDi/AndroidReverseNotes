package com.tencent.mm.modelgeo;

import com.facebook.appevents.UserDataStore;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class c implements f {
    public static String TAG = "MicroMsg.LocationAddr";
    private static c fBv;
    private boolean fBA = true;
    private c fBw = null;
    private CopyOnWriteArrayList<c> fBx = new CopyOnWriteArrayList();
    private HashMap<String, CopyOnWriteArrayList<WeakReference<a>>> fBy = new HashMap();
    private az fBz = new az(1, "addr_worker");

    class c {
        double lat;
        double lng;
        Object tag = "";

        public c(double d, double d2, Object obj) {
            this.lat = d;
            this.lng = d2;
            this.tag = obj;
        }

        public final String toString() {
            String str;
            AppMethodBeat.i(78108);
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            if (this.tag == null) {
                str = "";
            } else if ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) {
                str = this.tag;
            } else {
                str = this.tag.toString();
            }
            str = append.append(str).toString();
            AppMethodBeat.o(78108);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(78109);
            if (obj == null || !(obj instanceof c)) {
                AppMethodBeat.o(78109);
                return false;
            }
            boolean equals = ((c) obj).toString().equals(toString());
            AppMethodBeat.o(78109);
            return equals;
        }
    }

    class b implements com.tencent.mm.sdk.platformtools.az.a {
        private Addr fBB = null;

        public final boolean acf() {
            AppMethodBeat.i(78106);
            if (c.this.fBw == null) {
                AppMethodBeat.o(78106);
                return false;
            }
            if (this.fBB == null || this.fBB.fBg == null || this.fBB.fBg.equals("")) {
                this.fBB = c.c(c.this.fBw.lat, c.this.fBw.lng, c.this.fBA);
            }
            AppMethodBeat.o(78106);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(78107);
            c.this.fBA = true;
            c.a(c.this, this.fBB);
            AppMethodBeat.o(78107);
            return true;
        }
    }

    public interface a {
        void b(Addr addr);
    }

    static /* synthetic */ Addr c(double d, double d2, boolean z) {
        AppMethodBeat.i(78122);
        Addr b = b(d, d2, z);
        AppMethodBeat.o(78122);
        return b;
    }

    private c() {
        AppMethodBeat.i(78110);
        AppMethodBeat.o(78110);
    }

    public static c agw() {
        AppMethodBeat.i(78111);
        if (fBv == null) {
            fBv = new c();
        }
        c cVar = fBv;
        AppMethodBeat.o(78111);
        return cVar;
    }

    public final boolean a(a aVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        AppMethodBeat.i(78112);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str : this.fBy.keySet()) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.fBy.get(str);
            b(copyOnWriteArrayList, aVar);
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
            c cVar = (c) it2.next();
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.fBy.get(cVar.toString());
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
                linkedList.add(cVar);
                this.fBy.remove(cVar.toString());
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            this.fBx.remove((c) it.next());
        }
        ab.i(TAG, "remove taskLists %d listeners size %d", Integer.valueOf(this.fBx.size()), Integer.valueOf(this.fBy.size()));
        AppMethodBeat.o(78112);
        return true;
    }

    private static boolean a(CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList, a aVar) {
        AppMethodBeat.i(78113);
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                AppMethodBeat.o(78113);
                return true;
            }
        }
        AppMethodBeat.o(78113);
        return false;
    }

    private static boolean b(CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList, a aVar) {
        AppMethodBeat.i(78114);
        if (copyOnWriteArrayList == null) {
            AppMethodBeat.o(78114);
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                copyOnWriteArrayList.remove(weakReference);
                AppMethodBeat.o(78114);
                return true;
            }
        }
        AppMethodBeat.o(78114);
        return false;
    }

    public final boolean a(double d, double d2, a aVar) {
        AppMethodBeat.i(78116);
        boolean a = a(d, d2, aVar, null);
        AppMethodBeat.o(78116);
        return a;
    }

    private void agx() {
        AppMethodBeat.i(78117);
        if (this.fBw == null && this.fBx != null && this.fBx.size() > 0) {
            this.fBw = (c) this.fBx.remove(0);
            agy();
        }
        AppMethodBeat.o(78117);
    }

    private void agy() {
        AppMethodBeat.i(78118);
        if (bo.gT(ah.getContext())) {
            this.fBz.e(new b());
            AppMethodBeat.o(78118);
            return;
        }
        g.Rg().a(655, (f) this);
        g.Rg().a(new e(this.fBw.lat, this.fBw.lng), 0);
        AppMethodBeat.o(78118);
    }

    private void a(Addr addr) {
        AppMethodBeat.i(78119);
        if (this.fBw == null) {
            AppMethodBeat.o(78119);
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
                    ((a) weakReference.get()).b(addr);
                }
            }
        }
        this.fBy.remove(this.fBw.toString());
        ab.d(TAG, "postexecute2 listeners %d", Integer.valueOf(this.fBy.size()));
        this.fBw = null;
        agx();
        if (this.fBw == null && this.fBx.size() > 0) {
            g.Rg().b(655, (f) this);
        }
        AppMethodBeat.o(78119);
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
    private static Addr b(double d, double d2, boolean z) {
        Object format;
        InputStreamReader inputStreamReader;
        Throwable e;
        AppMethodBeat.i(78120);
        String dor = aa.dor();
        Addr addr = new Addr();
        if (z) {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), dor});
        } else {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), "zh_CN"});
        }
        ab.d(TAG, "url ".concat(String.valueOf(format)));
        u uVar = null;
        try {
            uVar = com.tencent.mm.network.b.a(format, null);
            uVar.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
            uVar.setRequestMethod("GET");
            ab.d(TAG, "conn " + uVar.getResponseCode());
            inputStreamReader = new InputStreamReader(uVar.getInputStream());
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
                ab.d(TAG, "sb " + stringBuffer.toString());
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
                ab.d(TAG, "google report, formattedaddr: %s, componentaddr: %s, geometry: %s, placeId: %s, types: %s, location: %s, curLanguage: %s", string2, readLine, string, encode, encode2, str, dor);
                h.pYm.e(12886, readLine, string2, string, encode, encode2, str, dor);
                uVar.connection.disconnect();
            } catch (Exception e2) {
            } catch (IOException e3) {
            }
        } catch (IOException e4) {
            e = e4;
            inputStreamReader = null;
            try {
                ab.d(TAG, "error e");
                ab.e(TAG, "exception:%s", bo.l(e));
                if (uVar != null) {
                }
                if (inputStreamReader != null) {
                }
                AppMethodBeat.o(78120);
                return addr;
            } catch (Throwable th) {
                if (uVar != null) {
                    uVar.connection.disconnect();
                }
                AppMethodBeat.o(78120);
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamReader = null;
            ab.d(TAG, "error Exception");
            ab.e(TAG, "exception:%s", bo.l(e));
            if (uVar != null) {
            }
            if (inputStreamReader != null) {
            }
            AppMethodBeat.o(78120);
            return addr;
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e6) {
                ab.e(TAG, "exception:%s", bo.l(e6));
            }
        }
        AppMethodBeat.o(78120);
        return addr;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78121);
        if (mVar.getType() == 655) {
            Addr agD = ((e) mVar).agD();
            if (agD == null || agD.fBg == null || agD.fBg.equals("")) {
                this.fBz.e(new b());
                AppMethodBeat.o(78121);
                return;
            }
            a(agD);
        }
        AppMethodBeat.o(78121);
    }

    public final boolean a(double d, double d2, a aVar, Object obj) {
        c cVar;
        AppMethodBeat.i(78115);
        if (obj != null) {
            Iterator it = this.fBx.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                if (cVar != null && cVar.tag != null && cVar.tag.equals(obj)) {
                    this.fBx.remove(cVar);
                    break;
                }
            }
        }
        cVar = new c(d, d2, obj);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.fBy.get(cVar.toString());
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
        }
        if (!a(copyOnWriteArrayList, aVar)) {
            copyOnWriteArrayList.add(new WeakReference(aVar));
        }
        this.fBy.put(cVar.toString(), copyOnWriteArrayList);
        Iterator it2 = this.fBx.iterator();
        while (it2.hasNext()) {
            if (((c) it2.next()).equals(cVar)) {
                agx();
                AppMethodBeat.o(78115);
                return false;
            }
        }
        if (this.fBw == null || !cVar.equals(this.fBw)) {
            this.fBx.add(cVar);
            ab.i(TAG, "push task size %d listeners %d", Integer.valueOf(this.fBx.size()), Integer.valueOf(this.fBy.size()));
            while (this.fBx.size() > 30) {
                ab.i(TAG, "force remove task");
                cVar = (c) this.fBx.remove(0);
                if (cVar != null) {
                    this.fBy.remove(cVar.toString());
                }
            }
            agx();
            AppMethodBeat.o(78115);
            return true;
        }
        AppMethodBeat.o(78115);
        return false;
    }
}
