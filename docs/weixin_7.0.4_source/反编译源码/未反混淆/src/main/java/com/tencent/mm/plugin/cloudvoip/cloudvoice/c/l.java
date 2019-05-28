package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class l {
    final Map<String, k> kBt = new ConcurrentHashMap(1);

    public interface a {
        void a(int i, int i2, String str, k kVar, boolean z);
    }

    static /* synthetic */ void a(l lVar, int i, int i2, String str, k kVar, boolean z, a aVar) {
        AppMethodBeat.i(135596);
        lVar.a(i, i2, str, kVar, z, aVar);
        AppMethodBeat.o(135596);
    }

    l() {
        AppMethodBeat.i(135591);
        AppMethodBeat.o(135591);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(135592);
        k kVar = (k) this.kBt.get(str);
        if (kVar == null || !kVar.isValid()) {
            this.kBt.remove(str);
            b(str, aVar);
            AppMethodBeat.o(135592);
            return;
        }
        ab.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
        a(0, 0, "", kVar, false, aVar);
        AppMethodBeat.o(135592);
    }

    private void a(int i, int i2, String str, k kVar, boolean z, a aVar) {
        AppMethodBeat.i(135593);
        final a aVar2 = aVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final k kVar2 = kVar;
        final boolean z2 = z;
        j.kzW.R(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135589);
                aVar2.a(i3, i4, str2, kVar2, z2);
                AppMethodBeat.o(135589);
            }
        });
        AppMethodBeat.o(135593);
    }

    private void b(final String str, final a aVar) {
        AppMethodBeat.i(135594);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new ahk();
        aVar2.fsK = new ahl();
        aVar2.fsI = 2985;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        b acD = aVar2.acD();
        ((ahk) acD.fsG.fsP).csB = str;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                AppMethodBeat.i(135590);
                if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                    ahl ahl = (ahl) bVar.fsH.fsP;
                    k kVar = new k();
                    kVar.kBq = ahl.wcw;
                    kVar.kBs = bo.yz();
                    kVar.kBr = (long) ahl.wnU;
                    ab.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", kVar);
                    l.this.kBt.put(str, kVar);
                    l.a(l.this, 0, 0, "", kVar, true, aVar);
                    AppMethodBeat.o(135590);
                    return;
                }
                ab.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + i + ",errCode:" + i2);
                l.a(l.this, i, i2, str, null, false, aVar);
                AppMethodBeat.o(135590);
            }
        });
        AppMethodBeat.o(135594);
    }

    public final void reset(String str) {
        AppMethodBeat.i(135595);
        ab.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(135595);
            return;
        }
        this.kBt.remove(str);
        AppMethodBeat.o(135595);
    }
}
