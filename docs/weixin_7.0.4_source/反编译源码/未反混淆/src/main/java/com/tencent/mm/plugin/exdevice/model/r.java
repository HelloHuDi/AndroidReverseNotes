package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;

public final class r extends m implements k {
    private String cwz;
    private b ehh = null;
    private f ehi = null;
    String ltF;

    public r(String str, String str2, String str3, int i, byte[] bArr) {
        AppMethodBeat.i(19329);
        a aVar = new a();
        aVar.fsJ = new ass();
        aVar.fsK = new ast();
        aVar.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        aVar.fsI = 541;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ass ass = (ass) this.ehh.fsG.fsP;
        asq asq = new asq();
        asq.vIk = str2;
        asq.jBE = str3;
        ass.vLi = asq;
        ass.wwx = i;
        ass.wwy = new SKBuiltinBuffer_t().setBuffer(bArr);
        this.ltF = str3;
        this.cwz = str;
        AppMethodBeat.o(19329);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19330);
        ab.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        com.tencent.mm.plugin.exdevice.h.b Kv = ad.boW().Kv(this.ltF);
        if (i2 == 0 && i3 == 0) {
            ast ast = (ast) this.ehh.fsH.fsP;
            if (Kv != null) {
                byte[] boQ = boQ();
                if (boQ != null) {
                    Kv.field_authBuf = boQ;
                }
                Kv.dFi = ast.wwC;
                Kv.dqp = true;
                Kv.dFh = ast.wwB;
                Kv.dqp = true;
                byte[] adl = adl();
                if (adl != null) {
                    u.bpx().b(Kv.field_mac, adl, 2);
                    if (u.bpy().lqX != null) {
                        u.bpy().lqX.setChannelSessionKey(Kv.field_mac, adl);
                    }
                    Kv.field_sessionKey = adl;
                }
                adl = boR();
                if (adl != null) {
                    u.bpx().b(Kv.field_mac, adl, 3);
                    Kv.field_sessionBuf = adl;
                }
                adl = boQ();
                if (boQ != null) {
                    u.bpx().b(Kv.field_mac, adl, 1);
                    Kv.field_authBuf = boQ;
                }
                Kv.dFj = System.currentTimeMillis() / 1000;
                Kv.dqp = true;
                if (2 == u.bpx().hS(Kv.field_mac)) {
                    ad.bph();
                    e.b(this.cwz, Kv.field_url, 2, Kv.field_deviceID);
                }
                u.bpx().hV(Kv.field_mac);
                boolean c = ad.boW().c(Kv, new String[0]);
                ab.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", Boolean.valueOf(c));
            } else {
                ab.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (Kv != null) {
                u.bpx().hW(Kv.field_mac);
                ad.bph();
                e.b(this.cwz, Kv.field_url, 4, Kv.field_deviceID);
            }
            ad.bph();
            e.cc(this.cwz, 3);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19330);
    }

    public final int getType() {
        return 541;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19331);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19331);
        return a;
    }

    private byte[] adl() {
        AppMethodBeat.i(19332);
        try {
            byte[] bufferToBytes = ((ast) this.ehh.fsH.fsP).vHG.getBufferToBytes();
            AppMethodBeat.o(19332);
            return bufferToBytes;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            AppMethodBeat.o(19332);
            return null;
        }
    }

    public final byte[] boQ() {
        AppMethodBeat.i(19333);
        try {
            byte[] bufferToBytes = ((ast) this.ehh.fsH.fsP).wwA.getBufferToBytes();
            AppMethodBeat.o(19333);
            return bufferToBytes;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            AppMethodBeat.o(19333);
            return null;
        }
    }

    private byte[] boR() {
        AppMethodBeat.i(19334);
        try {
            byte[] bufferToBytes = ((ast) this.ehh.fsH.fsP).wwz.getBufferToBytes();
            AppMethodBeat.o(19334);
            return bufferToBytes;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            AppMethodBeat.o(19334);
            return null;
        }
    }
}
