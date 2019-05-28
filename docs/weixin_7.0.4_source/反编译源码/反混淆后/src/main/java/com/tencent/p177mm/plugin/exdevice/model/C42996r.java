package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.ass;
import com.tencent.p177mm.protocal.protobuf.ast;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.r */
public final class C42996r extends C1207m implements C1918k {
    private String cwz;
    private C7472b ehh = null;
    private C1202f ehi = null;
    String ltF;

    public C42996r(String str, String str2, String str3, int i, byte[] bArr) {
        AppMethodBeat.m2504i(19329);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ass();
        c1196a.fsK = new ast();
        c1196a.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        c1196a.fsI = 541;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ass ass = (ass) this.ehh.fsG.fsP;
        asq asq = new asq();
        asq.vIk = str2;
        asq.jBE = str3;
        ass.vLi = asq;
        ass.wwx = i;
        ass.wwy = new SKBuiltinBuffer_t().setBuffer(bArr);
        this.ltF = str3;
        this.cwz = str;
        AppMethodBeat.m2505o(19329);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19330);
        C4990ab.m7416i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        C11648b Kv = C45891ad.boW().mo45701Kv(this.ltF);
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
                    C20548u.bpx().mo45718b(Kv.field_mac, adl, 2);
                    if (C20548u.bpy().lqX != null) {
                        C20548u.bpy().lqX.setChannelSessionKey(Kv.field_mac, adl);
                    }
                    Kv.field_sessionKey = adl;
                }
                adl = boR();
                if (adl != null) {
                    C20548u.bpx().mo45718b(Kv.field_mac, adl, 3);
                    Kv.field_sessionBuf = adl;
                }
                adl = boQ();
                if (boQ != null) {
                    C20548u.bpx().mo45718b(Kv.field_mac, adl, 1);
                    Kv.field_authBuf = boQ;
                }
                Kv.dFj = System.currentTimeMillis() / 1000;
                Kv.dqp = true;
                if (2 == C20548u.bpx().mo45720hS(Kv.field_mac)) {
                    C45891ad.bph();
                    C20495e.m31663b(this.cwz, Kv.field_url, 2, Kv.field_deviceID);
                }
                C20548u.bpx().mo45723hV(Kv.field_mac);
                boolean c = C45891ad.boW().mo10103c(Kv, new String[0]);
                C4990ab.m7417i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", Boolean.valueOf(c));
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (Kv != null) {
                C20548u.bpx().mo45724hW(Kv.field_mac);
                C45891ad.bph();
                C20495e.m31663b(this.cwz, Kv.field_url, 4, Kv.field_deviceID);
            }
            C45891ad.bph();
            C20495e.m31665cc(this.cwz, 3);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19330);
    }

    public final int getType() {
        return 541;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19331);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19331);
        return a;
    }

    private byte[] adl() {
        AppMethodBeat.m2504i(19332);
        try {
            byte[] bufferToBytes = ((ast) this.ehh.fsH.fsP).vHG.getBufferToBytes();
            AppMethodBeat.m2505o(19332);
            return bufferToBytes;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            AppMethodBeat.m2505o(19332);
            return null;
        }
    }

    public final byte[] boQ() {
        AppMethodBeat.m2504i(19333);
        try {
            byte[] bufferToBytes = ((ast) this.ehh.fsH.fsP).wwA.getBufferToBytes();
            AppMethodBeat.m2505o(19333);
            return bufferToBytes;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            AppMethodBeat.m2505o(19333);
            return null;
        }
    }

    private byte[] boR() {
        AppMethodBeat.m2504i(19334);
        try {
            byte[] bufferToBytes = ((ast) this.ehh.fsH.fsP).wwz.getBufferToBytes();
            AppMethodBeat.m2505o(19334);
            return bufferToBytes;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            AppMethodBeat.m2505o(19334);
            return null;
        }
    }
}
