package com.tencent.p177mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.exdevice.service.f */
public final class C27859f {
    public HashMap<Long, C27860a> lwJ = new HashMap();

    /* renamed from: com.tencent.mm.plugin.exdevice.service.f$a */
    public static class C27860a {
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

    public C27859f() {
        AppMethodBeat.m2504i(19581);
        AppMethodBeat.m2505o(19581);
    }

    /* renamed from: hR */
    public final boolean mo45719hR(long j) {
        AppMethodBeat.m2504i(19582);
        if (mo45720hS(j) == 2) {
            AppMethodBeat.m2505o(19582);
            return true;
        }
        AppMethodBeat.m2505o(19582);
        return false;
    }

    /* renamed from: hS */
    public final int mo45720hS(long j) {
        AppMethodBeat.m2504i(19583);
        if (this.lwJ.containsKey(Long.valueOf(j))) {
            int i = ((C27860a) this.lwJ.get(Long.valueOf(j))).cxs;
            AppMethodBeat.m2505o(19583);
            return i;
        }
        AppMethodBeat.m2505o(19583);
        return 0;
    }

    /* renamed from: hT */
    public final C27860a mo45721hT(long j) {
        AppMethodBeat.m2504i(19584);
        if (!this.lwJ.containsKey(Long.valueOf(j))) {
            m44284hY(j);
        }
        C27860a c27860a = (C27860a) this.lwJ.get(Long.valueOf(j));
        AppMethodBeat.m2505o(19584);
        return c27860a;
    }

    /* renamed from: hU */
    public final C27860a mo45722hU(long j) {
        AppMethodBeat.m2504i(19585);
        C27860a c27860a;
        if (this.lwJ.containsKey(Long.valueOf(j))) {
            c27860a = (C27860a) this.lwJ.get(Long.valueOf(j));
            AppMethodBeat.m2505o(19585);
            return c27860a;
        }
        c27860a = new C27860a();
        c27860a.lwK = j;
        c27860a.lwM = null;
        c27860a.bFT = null;
        c27860a.lwL = null;
        c27860a.cwz = null;
        c27860a.mURL = null;
        c27860a.cxs = 0;
        c27860a.lwN = false;
        c27860a.jGw = 0;
        this.lwJ.put(Long.valueOf(j), c27860a);
        AppMethodBeat.m2505o(19585);
        return c27860a;
    }

    /* renamed from: hV */
    public final boolean mo45723hV(long j) {
        AppMethodBeat.m2504i(19586);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", Long.valueOf(j));
        C27860a hT = mo45721hT(j);
        if (hT == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.m2505o(19586);
            return false;
        }
        hT.lwN = true;
        AppMethodBeat.m2505o(19586);
        return true;
    }

    /* renamed from: hW */
    public final boolean mo45724hW(long j) {
        AppMethodBeat.m2504i(19587);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", Long.valueOf(j));
        C27860a hT = mo45721hT(j);
        if (hT == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.m2505o(19587);
            return false;
        }
        hT.lwN = false;
        AppMethodBeat.m2505o(19587);
        return true;
    }

    /* renamed from: hX */
    public final boolean mo45725hX(long j) {
        AppMethodBeat.m2504i(19588);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", Long.valueOf(j));
        C27860a hT = mo45721hT(j);
        if (hT == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.m2505o(19588);
            return false;
        }
        boolean z = hT.lwN;
        AppMethodBeat.m2505o(19588);
        return z;
    }

    /* renamed from: hY */
    private void m44284hY(long j) {
        AppMethodBeat.m2504i(19589);
        C11648b Ku = C45891ad.boW().mo45700Ku(String.valueOf(j));
        if (Ku == null) {
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", Long.valueOf(j));
            AppMethodBeat.m2505o(19589);
            return;
        }
        C27860a c27860a = new C27860a();
        c27860a.lwK = j;
        c27860a.lwM = Ku.field_authBuf;
        c27860a.bFT = Ku.field_sessionKey;
        c27860a.lwL = Ku.field_sessionBuf;
        c27860a.cwz = Ku.field_brandName;
        c27860a.mURL = Ku.field_url;
        c27860a.cxs = 0;
        c27860a.lwN = false;
        this.lwJ.put(Long.valueOf(j), c27860a);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", Long.valueOf(j));
        AppMethodBeat.m2505o(19589);
    }

    /* renamed from: o */
    public final byte[] mo45726o(long j, int i) {
        AppMethodBeat.m2504i(19590);
        if (j < 0) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
            AppMethodBeat.m2505o(19590);
            return null;
        }
        C27860a c27860a = (C27860a) this.lwJ.get(Long.valueOf(j));
        if (c27860a == null) {
            m44284hY(j);
            c27860a = (C27860a) this.lwJ.get(Long.valueOf(j));
        }
        if (c27860a == null) {
            AppMethodBeat.m2505o(19590);
            return null;
        }
        byte[] bArr;
        switch (i) {
            case 1:
                bArr = c27860a.lwM;
                break;
            case 2:
                bArr = c27860a.bFT;
                break;
            case 3:
                bArr = c27860a.lwL;
                break;
            default:
                bArr = null;
                break;
        }
        AppMethodBeat.m2505o(19590);
        return bArr;
    }

    /* renamed from: b */
    public final void mo45718b(long j, byte[] bArr, int i) {
        AppMethodBeat.m2504i(19591);
        if (j < 0 || bArr == null || bArr.length == 0) {
            String str = "MicroMsg.exdevice.ExdeviceInfoManager";
            String str2 = "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j);
            objArr[1] = Boolean.valueOf(bArr == null);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(19591);
            return;
        }
        Object obj = (C27860a) this.lwJ.get(Long.valueOf(j));
        if (obj == null) {
            obj = new C27860a();
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
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", Integer.valueOf(i));
                break;
        }
        this.lwJ.put(Long.valueOf(j), obj);
        AppMethodBeat.m2505o(19591);
    }
}
