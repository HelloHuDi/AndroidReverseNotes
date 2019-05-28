package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class f {
    public HashMap<Long, a> lwJ = new HashMap();

    public static class a {
        public byte[] bFT;
        public String cwz;
        public int cxs;
        public long jGw;
        public long lwK;
        public byte[] lwL;
        public byte[] lwM;
        public boolean lwN;
        public String mURL;
    }

    public f() {
        AppMethodBeat.i(19581);
        AppMethodBeat.o(19581);
    }

    public final boolean hR(long j) {
        AppMethodBeat.i(19582);
        if (hS(j) == 2) {
            AppMethodBeat.o(19582);
            return true;
        }
        AppMethodBeat.o(19582);
        return false;
    }

    public final int hS(long j) {
        AppMethodBeat.i(19583);
        if (this.lwJ.containsKey(Long.valueOf(j))) {
            int i = ((a) this.lwJ.get(Long.valueOf(j))).cxs;
            AppMethodBeat.o(19583);
            return i;
        }
        AppMethodBeat.o(19583);
        return 0;
    }

    public final a hT(long j) {
        AppMethodBeat.i(19584);
        if (!this.lwJ.containsKey(Long.valueOf(j))) {
            hY(j);
        }
        a aVar = (a) this.lwJ.get(Long.valueOf(j));
        AppMethodBeat.o(19584);
        return aVar;
    }

    public final a hU(long j) {
        AppMethodBeat.i(19585);
        a aVar;
        if (this.lwJ.containsKey(Long.valueOf(j))) {
            aVar = (a) this.lwJ.get(Long.valueOf(j));
            AppMethodBeat.o(19585);
            return aVar;
        }
        aVar = new a();
        aVar.lwK = j;
        aVar.lwM = null;
        aVar.bFT = null;
        aVar.lwL = null;
        aVar.cwz = null;
        aVar.mURL = null;
        aVar.cxs = 0;
        aVar.lwN = false;
        aVar.jGw = 0;
        this.lwJ.put(Long.valueOf(j), aVar);
        AppMethodBeat.o(19585);
        return aVar;
    }

    public final boolean hV(long j) {
        AppMethodBeat.i(19586);
        ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", Long.valueOf(j));
        a hT = hT(j);
        if (hT == null) {
            ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.o(19586);
            return false;
        }
        hT.lwN = true;
        AppMethodBeat.o(19586);
        return true;
    }

    public final boolean hW(long j) {
        AppMethodBeat.i(19587);
        ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", Long.valueOf(j));
        a hT = hT(j);
        if (hT == null) {
            ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.o(19587);
            return false;
        }
        hT.lwN = false;
        AppMethodBeat.o(19587);
        return true;
    }

    public final boolean hX(long j) {
        AppMethodBeat.i(19588);
        ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", Long.valueOf(j));
        a hT = hT(j);
        if (hT == null) {
            ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.o(19588);
            return false;
        }
        boolean z = hT.lwN;
        AppMethodBeat.o(19588);
        return z;
    }

    private void hY(long j) {
        AppMethodBeat.i(19589);
        b Ku = ad.boW().Ku(String.valueOf(j));
        if (Ku == null) {
            ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", Long.valueOf(j));
            AppMethodBeat.o(19589);
            return;
        }
        a aVar = new a();
        aVar.lwK = j;
        aVar.lwM = Ku.field_authBuf;
        aVar.bFT = Ku.field_sessionKey;
        aVar.lwL = Ku.field_sessionBuf;
        aVar.cwz = Ku.field_brandName;
        aVar.mURL = Ku.field_url;
        aVar.cxs = 0;
        aVar.lwN = false;
        this.lwJ.put(Long.valueOf(j), aVar);
        ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", Long.valueOf(j));
        AppMethodBeat.o(19589);
    }

    public final byte[] o(long j, int i) {
        AppMethodBeat.i(19590);
        if (j < 0) {
            ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
            AppMethodBeat.o(19590);
            return null;
        }
        a aVar = (a) this.lwJ.get(Long.valueOf(j));
        if (aVar == null) {
            hY(j);
            aVar = (a) this.lwJ.get(Long.valueOf(j));
        }
        if (aVar == null) {
            AppMethodBeat.o(19590);
            return null;
        }
        byte[] bArr;
        switch (i) {
            case 1:
                bArr = aVar.lwM;
                break;
            case 2:
                bArr = aVar.bFT;
                break;
            case 3:
                bArr = aVar.lwL;
                break;
            default:
                bArr = null;
                break;
        }
        AppMethodBeat.o(19590);
        return bArr;
    }

    public final void b(long j, byte[] bArr, int i) {
        AppMethodBeat.i(19591);
        if (j < 0 || bArr == null || bArr.length == 0) {
            String str = "MicroMsg.exdevice.ExdeviceInfoManager";
            String str2 = "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j);
            objArr[1] = Boolean.valueOf(bArr == null);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(19591);
            return;
        }
        Object obj = (a) this.lwJ.get(Long.valueOf(j));
        if (obj == null) {
            obj = new a();
            obj.lwK = j;
        }
        switch (i) {
            case 1:
                obj.lwM = bArr;
                break;
            case 2:
                obj.bFT = bArr;
                break;
            case 3:
                obj.lwL = bArr;
                break;
            default:
                ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", Integer.valueOf(i));
                break;
        }
        this.lwJ.put(Long.valueOf(j), obj);
        AppMethodBeat.o(19591);
    }
}
