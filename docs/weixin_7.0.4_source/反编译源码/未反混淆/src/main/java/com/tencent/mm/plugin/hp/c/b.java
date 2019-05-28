package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.hp.b.e;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.List;

public final class b extends a {
    private boolean ntW;
    com.tencent.mm.plugin.hp.d.b ntX;

    public b() {
        this("", "", null, false);
    }

    public b(String str, String str2, List<bhv> list) {
        this(str, str2, list, true);
    }

    private b(String str, String str2, List<bhv> list, boolean z) {
        String str3;
        Collection list2;
        AppMethodBeat.i(90622);
        this.ntW = true;
        if (z) {
            this.gOW = 0;
            str3 = str2;
        } else {
            str = "tinker_id_" + a.Ul();
            str3 = a.eSh == null ? "" : "tinker_id_" + a.eSh;
            list2 = a.bGn();
            this.gOW = 1;
        }
        this.ntS = str;
        this.ntT = str3;
        this.ntU.addAll(list2);
        this.ntW = z;
        if (this.ntW) {
            AnonymousClass1 anonymousClass1 = new c.a() {
                public final void a(boolean z, com.tencent.mm.plugin.hp.d.b bVar) {
                    AppMethodBeat.i(90621);
                    if (!z || bVar == null) {
                        Context context = ah.getContext();
                        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", b.this.ntS).apply();
                        g.aB(ah.getContext(), "");
                        AppMethodBeat.o(90621);
                        return;
                    }
                    b.this.ntX = bVar;
                    b.this.ntT = b.this.ntX.num;
                    ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", b.this.ntX.num, b.this.ntT);
                    h.pYm.a(614, 71, 1, false);
                    AppMethodBeat.o(90621);
                }
            };
            str3 = ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
            if (!bo.isNullOrNil(str3)) {
                try {
                    bhx bhx = new bhx();
                    bhx.parseFrom(Base64.decode(str3.getBytes(), 0));
                    if (bhx.pdA != null) {
                        str3 = a.eSh == null ? "" : "tinker_id_" + a.eSh;
                        String str4 = "tinker_id_" + a.Ul();
                        String string = ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
                        com.tencent.mm.plugin.hp.d.b bVar = new com.tencent.mm.plugin.hp.d.b(bhx.wLf);
                        ab.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", bVar.num, str3, string, str4);
                        if (!(bo.isNullOrNil(bVar.num) || bVar.num.equalsIgnoreCase(str3) || bo.isNullOrNil(str4) || !str4.equalsIgnoreCase(string))) {
                            anonymousClass1.a(true, bVar);
                            AppMethodBeat.o(90622);
                            return;
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("Tinker.TinkerUtils", e, "parse tinker update Response failed.", new Object[0]);
                    h.pYm.a(614, 73, 1, false);
                }
            }
            anonymousClass1.a(false, null);
        }
        AppMethodBeat.o(90622);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(90623);
        ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            bhx bhx = (bhx) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
            bia bia = bhx.wLf;
            if (bia == null) {
                if (bhx.wLh == 1) {
                    com.tencent.mm.plugin.hp.b.a.en(1, 0);
                } else if (bhx.wLh == 2) {
                    com.tencent.mm.plugin.hp.b.a.en(2, 0);
                } else if (bhx.wLh == 3) {
                    com.tencent.mm.plugin.hp.b.a.en(3, 0);
                } else if (bhx.wLh == 4) {
                    com.tencent.mm.plugin.hp.b.a.en(6, 0);
                } else if (bhx.wLh == 6) {
                    ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
                } else {
                    com.tencent.mm.plugin.hp.b.a.en(5, 0);
                }
                if (this.ntX != null) {
                    String str2 = a.eSh == null ? "" : "tinker_id_" + a.eSh;
                    if (!(bo.isNullOrNil(this.ntX.num) || this.ntX.num.equalsIgnoreCase(str2))) {
                        int i4 = ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
                        if (i4 >= 4) {
                            g.aB(ah.getContext(), "");
                            g.P(ah.getContext(), 0);
                            ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", Integer.valueOf(i4));
                            h.pYm.a(614, 74, 1, false);
                        } else {
                            new e(this.ntX).m5if(this.ntW);
                            h.pYm.a(614, 70, 1, false);
                            g.P(ah.getContext(), i4 + 1);
                            ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", Integer.valueOf(i4));
                        }
                    }
                }
            } else if (this.ntW) {
                try {
                    g.aB(ah.getContext(), new String(Base64.encode(bhx.toByteArray(), 0)));
                    g.P(ah.getContext(), 0);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "save node failed.", new Object[0]);
                    h.pYm.a(614, 72, 1, false);
                }
                ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
                com.tencent.mm.plugin.hp.d.b bVar = new com.tencent.mm.plugin.hp.d.b(bia);
                ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
                new e(bVar).m5if(this.ntW);
                ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
                com.tencent.mm.plugin.hp.b.a.en(4, 0);
            } else {
                ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
            }
        } else {
            ab.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
            com.tencent.mm.plugin.hp.b.a.en(5, i2);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(90623);
    }
}
