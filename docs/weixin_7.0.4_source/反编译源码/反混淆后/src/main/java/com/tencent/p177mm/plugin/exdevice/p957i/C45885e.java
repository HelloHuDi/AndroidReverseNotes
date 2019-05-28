package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.exdevice.model.C20495e;
import com.tencent.p177mm.plugin.exdevice.model.C38950ae;
import com.tencent.p177mm.plugin.exdevice.model.C42996r;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1255e.C45879a;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p952b.C20469b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.exdevice.i.e */
public final class C45885e extends C38950ae implements C1202f {
    private C27865m lqX;
    private C42990d lxx;
    private C20469b lxy = null;
    private C27838a lxz;
    private int mErrorCode;

    public C45885e(int i, long j, int i2, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(19731);
        this.lxy = new C20469b(j, i2, i3, bArr);
        this.mErrorCode = i;
        AppMethodBeat.m2505o(19731);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19732);
        C9638aw.m17182Rg().mo14546b(541, (C1202f) this);
        C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        C42996r c42996r = (C42996r) c1207m;
        C11648b Ku = C45891ad.boW().mo45700Ku(this.lxy.jJa);
        if (Ku == null) {
            C4990ab.m7412e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.m2505o(19732);
            return;
        }
        boolean b;
        if (System.currentTimeMillis() / 1000 < ((long) Ku.dFi)) {
            C4990ab.m7412e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
            this.lxy.mo35788e(-5, "", new byte[0]);
            this.lxz = new C27838a(this.lxy, this.lxx);
            b = this.lxz.mo45713b(this.lqX);
            C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(b));
            AppMethodBeat.m2505o(19732);
            return;
        }
        this.lxy.mo35788e(i2, str, c42996r.boQ());
        this.lxz = new C27838a(this.lxy, this.lxx);
        b = this.lxz.mo45713b(this.lqX);
        C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(b));
        AppMethodBeat.m2505o(19732);
    }

    /* JADX WARNING: Missing block: B:21:0x00fa, code skipped:
            if (r0 != r10.lxy.jJa) goto L_0x00fc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo23404a(C27865m c27865m, C42990d c42990d) {
        AppMethodBeat.m2504i(19733);
        if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            C4990ab.m7413e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(this.mErrorCode));
            this.lxy.mo35788e(-1, "", new byte[0]);
            this.lxz = new C27838a(this.lxy, c42990d);
            C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.mo45713b(c27865m)));
            AppMethodBeat.m2505o(19733);
            return this.lxz.mo45713b(c27865m);
        }
        C11648b Ku = C45891ad.boW().mo45700Ku(this.lxy.jJa);
        if (Ku == null) {
            C4990ab.m7413e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", Long.valueOf(this.lxy.jJa));
            AppMethodBeat.m2505o(19733);
            return false;
        }
        C45879a c45879a = (C45879a) this.lxy.bou();
        if (c45879a == null) {
            C4990ab.m7412e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
            this.lxy.mo35788e(-4, "", new byte[0]);
            this.lxz = new C27838a(this.lxy, c42990d);
            C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.mo45713b(c27865m)));
            AppMethodBeat.m2505o(19733);
            return this.lxz.mo45713b(c27865m);
        }
        long j;
        if (c45879a.luM == 2) {
            if (c45879a.luO != null) {
                byte[] bArr = c45879a.luO.f1226wR;
                if (C5046bo.m7540cb(bArr)) {
                    j = -1;
                } else {
                    Object obj = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
                    System.arraycopy(bArr, 0, obj, 2, 6);
                    j = C42992b.m76350aO(obj);
                }
            }
            C4990ab.m7412e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
            this.lxy.mo35788e(-1, "", new byte[0]);
            this.lxz = new C27838a(this.lxy, c42990d);
            C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.mo45713b(c27865m)));
            AppMethodBeat.m2505o(19733);
            return this.lxz.mo45713b(c27865m);
        } else if (c45879a.luM != 1 && c45879a.luM != 1) {
            C4990ab.m7412e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
            this.lxy.mo35788e(-8, "", new byte[0]);
            this.lxz = new C27838a(this.lxy, c42990d);
            C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.mo45713b(c27865m)));
            AppMethodBeat.m2505o(19733);
            return this.lxz.mo45713b(c27865m);
        } else if (c45879a.luJ == null || !C42992b.m76354c(c45879a.luJ.f1226wR, 0, C1178g.m2592y((Ku.field_deviceType + Ku.field_deviceID).getBytes()))) {
            C4990ab.m7412e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
            this.lxy.mo35788e(-1, "", new byte[0]);
            this.lxz = new C27838a(this.lxy, c42990d);
            C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.mo45713b(c27865m)));
            AppMethodBeat.m2505o(19733);
            return this.lxz.mo45713b(c27865m);
        }
        if (Ku != null) {
            if (System.currentTimeMillis() / 1000 < ((long) Ku.dFi)) {
                C4990ab.m7412e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
                this.lxy.mo35788e(-5, "", new byte[0]);
                this.lxz = new C27838a(this.lxy, c42990d);
                C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.mo45713b(c27865m)));
                AppMethodBeat.m2505o(19733);
                return this.lxz.mo45713b(c27865m);
            }
            j = Ku.dFj;
            int i = Ku.dFh;
            if (((long) i) + j > 0 && j + ((long) i) < System.currentTimeMillis() / 1000) {
                int i2;
                byte[] o = C20548u.bpx().mo45726o(this.lxy.jJa, 1);
                byte[] o2 = C20548u.bpx().mo45726o(this.lxy.jJa, 2);
                String str = "MicroMsg.exdevice.MMAuthTaskExcuter";
                String str2 = "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(o == null ? -1 : o.length);
                if (o2 == null) {
                    i2 = -1;
                } else {
                    i2 = o2.length;
                }
                objArr[1] = Integer.valueOf(i2);
                C4990ab.m7417i(str, str2, objArr);
                if (o == null || o2 == null) {
                    C4990ab.m7416i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
                } else {
                    C20548u.bpx().mo45723hV(Ku.field_mac);
                    if (2 == C20548u.bpx().mo45720hS(Ku.field_mac)) {
                        C45891ad.bph();
                        C20495e.m31663b(Ku.field_brandName, Ku.field_url, 2, Ku.field_deviceID);
                    }
                    this.lxy.mo35788e(0, "", C20548u.bpx().mo45726o(this.lxy.jJa, 1));
                    this.lxz = new C27838a(this.lxy, this.lxx);
                    c27865m.setChannelSessionKey(Ku.field_mac, o2);
                    C4990ab.m7417i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.mo45713b(c27865m)));
                    AppMethodBeat.m2505o(19733);
                    return this.lxz.mo45713b(c27865m);
                }
            }
        }
        C4990ab.m7416i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
        this.lqX = c27865m;
        this.lxx = c42990d;
        byte[] bArr2 = null;
        if (!(c45879a == null || c45879a.luN == null)) {
            bArr2 = c45879a.luN.toByteArray();
        }
        C9638aw.m17182Rg().mo14539a(541, (C1202f) this);
        C9638aw.m17182Rg().mo14541a(new C42996r(Ku.field_brandName, Ku.field_deviceType, Ku.field_deviceID, c45879a.luL, bArr2), 0);
        AppMethodBeat.m2505o(19733);
        return true;
    }
}
