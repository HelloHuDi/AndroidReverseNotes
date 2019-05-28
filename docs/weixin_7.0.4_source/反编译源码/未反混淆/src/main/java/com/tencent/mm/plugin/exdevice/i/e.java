package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.e.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends ae implements f {
    private m lqX;
    private d lxx;
    private b lxy = null;
    private a lxz;
    private int mErrorCode;

    public e(int i, long j, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(19731);
        this.lxy = new b(j, i2, i3, bArr);
        this.mErrorCode = i;
        AppMethodBeat.o(19731);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(19732);
        aw.Rg().b(541, (f) this);
        ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        r rVar = (r) mVar;
        com.tencent.mm.plugin.exdevice.h.b Ku = ad.boW().Ku(this.lxy.jJa);
        if (Ku == null) {
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(19732);
            return;
        }
        boolean b;
        if (System.currentTimeMillis() / 1000 < ((long) Ku.dFi)) {
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
            this.lxy.e(-5, "", new byte[0]);
            this.lxz = new a(this.lxy, this.lxx);
            b = this.lxz.b(this.lqX);
            ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(b));
            AppMethodBeat.o(19732);
            return;
        }
        this.lxy.e(i2, str, rVar.boQ());
        this.lxz = new a(this.lxy, this.lxx);
        b = this.lxz.b(this.lqX);
        ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(b));
        AppMethodBeat.o(19732);
    }

    /* JADX WARNING: Missing block: B:21:0x00fa, code skipped:
            if (r0 != r10.lxy.jJa) goto L_0x00fc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(19733);
        if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(this.mErrorCode));
            this.lxy.e(-1, "", new byte[0]);
            this.lxz = new a(this.lxy, dVar);
            ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.b(mVar)));
            AppMethodBeat.o(19733);
            return this.lxz.b(mVar);
        }
        com.tencent.mm.plugin.exdevice.h.b Ku = ad.boW().Ku(this.lxy.jJa);
        if (Ku == null) {
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", Long.valueOf(this.lxy.jJa));
            AppMethodBeat.o(19733);
            return false;
        }
        a aVar = (a) this.lxy.bou();
        if (aVar == null) {
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
            this.lxy.e(-4, "", new byte[0]);
            this.lxz = new a(this.lxy, dVar);
            ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.b(mVar)));
            AppMethodBeat.o(19733);
            return this.lxz.b(mVar);
        }
        long j;
        if (aVar.luM == 2) {
            if (aVar.luO != null) {
                byte[] bArr = aVar.luO.wR;
                if (bo.cb(bArr)) {
                    j = -1;
                } else {
                    Object obj = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
                    System.arraycopy(bArr, 0, obj, 2, 6);
                    j = com.tencent.mm.plugin.exdevice.j.b.aO(obj);
                }
            }
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
            this.lxy.e(-1, "", new byte[0]);
            this.lxz = new a(this.lxy, dVar);
            ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.b(mVar)));
            AppMethodBeat.o(19733);
            return this.lxz.b(mVar);
        } else if (aVar.luM != 1 && aVar.luM != 1) {
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
            this.lxy.e(-8, "", new byte[0]);
            this.lxz = new a(this.lxy, dVar);
            ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.b(mVar)));
            AppMethodBeat.o(19733);
            return this.lxz.b(mVar);
        } else if (aVar.luJ == null || !com.tencent.mm.plugin.exdevice.j.b.c(aVar.luJ.wR, 0, g.y((Ku.field_deviceType + Ku.field_deviceID).getBytes()))) {
            ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
            this.lxy.e(-1, "", new byte[0]);
            this.lxz = new a(this.lxy, dVar);
            ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.b(mVar)));
            AppMethodBeat.o(19733);
            return this.lxz.b(mVar);
        }
        if (Ku != null) {
            if (System.currentTimeMillis() / 1000 < ((long) Ku.dFi)) {
                ab.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
                this.lxy.e(-5, "", new byte[0]);
                this.lxz = new a(this.lxy, dVar);
                ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.b(mVar)));
                AppMethodBeat.o(19733);
                return this.lxz.b(mVar);
            }
            j = Ku.dFj;
            int i = Ku.dFh;
            if (((long) i) + j > 0 && j + ((long) i) < System.currentTimeMillis() / 1000) {
                int i2;
                byte[] o = u.bpx().o(this.lxy.jJa, 1);
                byte[] o2 = u.bpx().o(this.lxy.jJa, 2);
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
                ab.i(str, str2, objArr);
                if (o == null || o2 == null) {
                    ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
                } else {
                    u.bpx().hV(Ku.field_mac);
                    if (2 == u.bpx().hS(Ku.field_mac)) {
                        ad.bph();
                        com.tencent.mm.plugin.exdevice.model.e.b(Ku.field_brandName, Ku.field_url, 2, Ku.field_deviceID);
                    }
                    this.lxy.e(0, "", u.bpx().o(this.lxy.jJa, 1));
                    this.lxz = new a(this.lxy, this.lxx);
                    mVar.setChannelSessionKey(Ku.field_mac, o2);
                    ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.lxz.b(mVar)));
                    AppMethodBeat.o(19733);
                    return this.lxz.b(mVar);
                }
            }
        }
        ab.i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
        this.lqX = mVar;
        this.lxx = dVar;
        byte[] bArr2 = null;
        if (!(aVar == null || aVar.luN == null)) {
            bArr2 = aVar.luN.toByteArray();
        }
        aw.Rg().a(541, (f) this);
        aw.Rg().a(new r(Ku.field_brandName, Ku.field_deviceType, Ku.field_deviceID, aVar.luL, bArr2), 0);
        AppMethodBeat.o(19733);
        return true;
    }
}
