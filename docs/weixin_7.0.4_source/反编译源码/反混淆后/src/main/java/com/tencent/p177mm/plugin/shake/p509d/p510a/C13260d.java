package com.tencent.p177mm.plugin.shake.p509d.p510a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C34900h.C3825a;
import com.tencent.p177mm.protocal.protobuf.atx;
import com.tencent.p177mm.protocal.protobuf.aty;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.shake.d.a.d */
public final class C13260d extends C1207m implements C1918k {
    int action;
    private C1202f ehi;
    final C7472b fAT;
    private long qtH;

    public C13260d(Collection<C3825a> collection, float f, float f2, int i) {
        int i2;
        AppMethodBeat.m2504i(24610);
        this.action = 1;
        this.qtH = 0;
        this.action = 1;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new atx();
        c1196a.fsK = new aty();
        c1196a.uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
        c1196a.fsI = 658;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fAT = c1196a.acD();
        C32782bp aao = C32782bp.aao();
        String nullAsNil = C5046bo.nullAsNil(aao.fnp);
        String nullAsNil2 = C5046bo.nullAsNil(aao.fno);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        atx atx = (atx) this.fAT.fsG.fsP;
        atx.wxX = C5046bo.nullAsNil(null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"Beacons\":[");
        if (collection != null) {
            i2 = 0;
            int size = collection.size();
            Iterator it = collection.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                C3825a c3825a = (C3825a) it.next();
                stringBuilder.append("{\"UUID\":\"" + c3825a.eCq + "\",\"Location\":{\"Major\":" + c3825a.major + ",\"Minor\":" + c3825a.minor + "},\"Distance\":" + c3825a.fNN + ",\"Extra\":\"\",\"MacAddress\":\"" + c3825a.qtR + "\",\"Rssi\":\"" + c3825a.qtS + "\",\"MeasurePower\":\"" + c3825a.qtT + "\"}");
                if (i3 < size - 1) {
                    stringBuilder.append(",");
                }
                i2 = i3 + 1;
            }
        }
        i2 = 1;
        boolean hasSystemFeature = C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter != null && defaultAdapter.getState() == 12 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
            i2 = 0;
        }
        stringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + f + ",\"Longitude\":" + f2 + ",\"Province\":\"" + nullAsNil + "\",\"City\":\"" + nullAsNil2 + "\"},\"MachineID\":\"" + C1427q.m3028LM() + "\",\"ZBBeaconState\":\"" + i2 + "\"}");
        atx.ncM = stringBuilder.toString();
        String str = "MicroMsg.NetSceneShakeIbeacon";
        nullAsNil = "[oneliang]beaconCollection.size:%d,json:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(collection != null ? collection.size() : 0);
        objArr[1] = atx.ncM;
        C4990ab.m7417i(str, nullAsNil, objArr);
        C18698o.m29222a(2008, f2, f, i);
        AppMethodBeat.m2505o(24610);
    }

    public final int getType() {
        return 658;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24611);
        this.qtH = System.currentTimeMillis();
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(24611);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24612);
        C4990ab.m7417i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        this.qtH = System.currentTimeMillis() - this.qtH;
        C7060h.pYm.mo8381e(11497, String.valueOf((int) (((double) (this.qtH / 1000)) + 0.5d)), Integer.valueOf(1), Integer.valueOf((int) this.qtH));
        int i4;
        String string;
        JSONObject jSONObject;
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
            aty aty = (aty) this.fAT.fsH.fsP;
            try {
                JSONObject jSONObject2 = new JSONObject(((atx) this.fAT.fsG.fsP).ncM);
                JSONArray jSONArray = jSONObject2.getJSONArray("Beacons");
                int length = jSONArray.length();
                JSONObject jSONObject3 = jSONObject2.getJSONObject("LBS");
                i4 = jSONObject2.getInt("Action");
                String string2 = jSONObject3.getString("Latitude");
                string = jSONObject3.getString("Longitude");
                if (length > 0) {
                    jSONObject = jSONArray.getJSONObject(0);
                    String string3 = jSONObject.getString("UUID");
                    jSONObject = jSONObject.getJSONObject("Location");
                    int i5 = jSONObject.getInt("Major");
                    int i6 = jSONObject.getInt("Minor");
                    if (aty.wxY.vYu == 0) {
                        String str2 = aty.wxY.mZR;
                        if (i4 == 1 && str2 != null && !str2.equals("") && new JSONObject(str2).getJSONArray("msgs").length() == 0) {
                            C7060h.pYm.mo8381e(12659, Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(aty.wxY.vYu));
                        }
                        AppMethodBeat.m2505o(24612);
                        return;
                    }
                    C7060h.pYm.mo8381e(12659, Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(aty.wxY.vYu));
                    AppMethodBeat.m2505o(24612);
                    return;
                }
                C7060h.pYm.mo8381e(12659, Integer.valueOf(1), Integer.valueOf(length), "", Integer.valueOf(0), Integer.valueOf(0), string2, string, Integer.valueOf(2), Integer.valueOf(aty.wxY.vYu));
                AppMethodBeat.m2505o(24612);
                return;
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                AppMethodBeat.m2505o(24612);
                return;
            }
        }
        C4990ab.m7410d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
        try {
            jSONObject = new JSONObject(((atx) this.fAT.fsG.fsP).ncM);
            JSONArray jSONArray2 = jSONObject.getJSONArray("Beacons");
            i4 = jSONArray2.length();
            jSONObject = jSONObject.getJSONObject("LBS");
            String string4 = jSONObject.getString("Latitude");
            String string5 = jSONObject.getString("Longitude");
            if (i4 > 0) {
                JSONObject jSONObject4 = jSONArray2.getJSONObject(0);
                string = jSONObject4.getString("UUID");
                jSONObject4 = jSONObject4.getJSONObject("Location");
                int i7 = jSONObject4.getInt("Major");
                int i8 = jSONObject4.getInt("Minor");
                C7060h.pYm.mo8381e(12659, Integer.valueOf(1), Integer.valueOf(i4), string, Integer.valueOf(i7), Integer.valueOf(i8), string4, string5, Integer.valueOf(1), Integer.valueOf(i3));
                AppMethodBeat.m2505o(24612);
                return;
            }
            C7060h.pYm.mo8381e(12659, Integer.valueOf(1), Integer.valueOf(i4), "", Integer.valueOf(0), Integer.valueOf(0), string4, string5, Integer.valueOf(1), Integer.valueOf(i3));
            AppMethodBeat.m2505o(24612);
        } catch (JSONException e2) {
            C4990ab.m7412e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
            AppMethodBeat.m2505o(24612);
        }
    }
}
