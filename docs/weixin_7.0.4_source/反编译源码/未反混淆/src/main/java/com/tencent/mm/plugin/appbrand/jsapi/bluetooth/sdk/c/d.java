package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public String ceI;
    public int cyC;
    public SparseArray<byte[]> hEG;
    public List<ParcelUuid> hEH;
    public String hEI;
    public Map<ParcelUuid, byte[]> hEJ;
    private JSONObject jsonObject;
    public String name;

    public d(String str, String str2) {
        this.name = str;
        this.ceI = str2;
    }

    public d(ScanResultCompat scanResultCompat) {
        AppMethodBeat.i(94279);
        this.name = bo.nullAsNil(scanResultCompat.getDevice().getName());
        this.ceI = bo.nullAsNil(scanResultCompat.getDevice().getAddress());
        this.cyC = scanResultCompat.hGc;
        this.hEG = scanResultCompat.hGb.hFX;
        this.hEH = scanResultCompat.hGb.hFW;
        this.hEI = bo.nullAsNil(scanResultCompat.hGb.mDeviceName);
        this.hEJ = scanResultCompat.hGb.hFY;
        AppMethodBeat.o(94279);
    }

    public final JSONObject aCq() {
        AppMethodBeat.i(94280);
        if (this.jsonObject == null) {
            this.jsonObject = new JSONObject();
            this.jsonObject.put("deviceId", this.ceI);
            this.jsonObject.put("name", this.name);
            this.jsonObject.put("RSSI", this.cyC);
            byte[] bArr = new byte[0];
            StringBuilder stringBuilder = new StringBuilder();
            if (this.hEG != null && this.hEG.size() >= 0) {
                int i = 0;
                Object obj = bArr;
                while (i < this.hEG.size()) {
                    int keyAt = this.hEG.keyAt(0);
                    byte[] bArr2 = new byte[]{(byte) (keyAt & 255), (byte) ((keyAt >> 8) & 255)};
                    bArr = (byte[]) this.hEG.valueAt(i);
                    Object obj2 = new byte[((obj.length + 2) + bArr.length)];
                    System.arraycopy(obj, 0, obj2, 0, obj.length);
                    System.arraycopy(bArr2, 0, obj2, obj.length, 2);
                    System.arraycopy(bArr, 0, obj2, obj.length + 2, bArr.length);
                    i++;
                    obj = obj2;
                }
                bArr = obj;
            }
            stringBuilder.append(new String(Base64.encode(bArr, 2)));
            this.jsonObject.put("advertisData", stringBuilder);
            JSONArray jSONArray = new JSONArray();
            if (this.hEH != null) {
                for (ParcelUuid uuid : this.hEH) {
                    jSONArray.put(uuid.getUuid().toString().toUpperCase());
                }
            }
            this.jsonObject.put("advertisServiceUUIDs", jSONArray);
            this.jsonObject.put("localName", this.hEI);
            JSONObject jSONObject = new JSONObject();
            if (this.hEJ != null && this.hEJ.size() > 0) {
                for (ParcelUuid uuid2 : this.hEJ.keySet()) {
                    jSONObject.put(uuid2.getUuid().toString().toUpperCase(), new String(Base64.encode((byte[]) this.hEJ.get(uuid2), 2)));
                }
            }
            this.jsonObject.put("serviceData", jSONObject);
        }
        JSONObject jSONObject2 = this.jsonObject;
        AppMethodBeat.o(94280);
        return jSONObject2;
    }
}
