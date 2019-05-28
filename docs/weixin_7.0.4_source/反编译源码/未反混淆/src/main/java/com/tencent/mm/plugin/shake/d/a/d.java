package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends m implements k {
    int action;
    private f ehi;
    final b fAT;
    private long qtH;

    public d(Collection<a> collection, float f, float f2, int i) {
        int i2;
        AppMethodBeat.i(24610);
        this.action = 1;
        this.qtH = 0;
        this.action = 1;
        b.a aVar = new b.a();
        aVar.fsJ = new atx();
        aVar.fsK = new aty();
        aVar.uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
        aVar.fsI = 658;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fAT = aVar.acD();
        bp aao = bp.aao();
        String nullAsNil = bo.nullAsNil(aao.fnp);
        String nullAsNil2 = bo.nullAsNil(aao.fno);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        atx atx = (atx) this.fAT.fsG.fsP;
        atx.wxX = bo.nullAsNil(null);
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
                a aVar2 = (a) it.next();
                stringBuilder.append("{\"UUID\":\"" + aVar2.eCq + "\",\"Location\":{\"Major\":" + aVar2.major + ",\"Minor\":" + aVar2.minor + "},\"Distance\":" + aVar2.fNN + ",\"Extra\":\"\",\"MacAddress\":\"" + aVar2.qtR + "\",\"Rssi\":\"" + aVar2.qtS + "\",\"MeasurePower\":\"" + aVar2.qtT + "\"}");
                if (i3 < size - 1) {
                    stringBuilder.append(",");
                }
                i2 = i3 + 1;
            }
        }
        i2 = 1;
        boolean hasSystemFeature = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter != null && defaultAdapter.getState() == 12 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
            i2 = 0;
        }
        stringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + f + ",\"Longitude\":" + f2 + ",\"Province\":\"" + nullAsNil + "\",\"City\":\"" + nullAsNil2 + "\"},\"MachineID\":\"" + q.LM() + "\",\"ZBBeaconState\":\"" + i2 + "\"}");
        atx.ncM = stringBuilder.toString();
        String str = "MicroMsg.NetSceneShakeIbeacon";
        nullAsNil = "[oneliang]beaconCollection.size:%d,json:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(collection != null ? collection.size() : 0);
        objArr[1] = atx.ncM;
        ab.i(str, nullAsNil, objArr);
        o.a(2008, f2, f, i);
        AppMethodBeat.o(24610);
    }

    public final int getType() {
        return 658;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24611);
        this.qtH = System.currentTimeMillis();
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(24611);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(24612);
        ab.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        this.qtH = System.currentTimeMillis() - this.qtH;
        h.pYm.e(11497, String.valueOf((int) (((double) (this.qtH / 1000)) + 0.5d)), Integer.valueOf(1), Integer.valueOf((int) this.qtH));
        int i4;
        String string;
        JSONObject jSONObject;
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
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
                            h.pYm.e(12659, Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(aty.wxY.vYu));
                        }
                        AppMethodBeat.o(24612);
                        return;
                    }
                    h.pYm.e(12659, Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(aty.wxY.vYu));
                    AppMethodBeat.o(24612);
                    return;
                }
                h.pYm.e(12659, Integer.valueOf(1), Integer.valueOf(length), "", Integer.valueOf(0), Integer.valueOf(0), string2, string, Integer.valueOf(2), Integer.valueOf(aty.wxY.vYu));
                AppMethodBeat.o(24612);
                return;
            } catch (JSONException e) {
                ab.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                AppMethodBeat.o(24612);
                return;
            }
        }
        ab.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
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
                h.pYm.e(12659, Integer.valueOf(1), Integer.valueOf(i4), string, Integer.valueOf(i7), Integer.valueOf(i8), string4, string5, Integer.valueOf(1), Integer.valueOf(i3));
                AppMethodBeat.o(24612);
                return;
            }
            h.pYm.e(12659, Integer.valueOf(1), Integer.valueOf(i4), "", Integer.valueOf(0), Integer.valueOf(0), string4, string5, Integer.valueOf(1), Integer.valueOf(i3));
            AppMethodBeat.o(24612);
        } catch (JSONException e2) {
            ab.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
            AppMethodBeat.o(24612);
        }
    }
}
