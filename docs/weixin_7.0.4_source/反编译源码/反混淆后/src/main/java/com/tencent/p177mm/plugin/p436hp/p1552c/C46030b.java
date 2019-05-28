package com.tencent.p177mm.plugin.p436hp.p1552c;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.p436hp.p1273d.C21071c.C21072a;
import com.tencent.p177mm.plugin.p436hp.p1273d.C28317b;
import com.tencent.p177mm.plugin.p436hp.p437b.C3296e;
import com.tencent.p177mm.plugin.p436hp.p437b.C39251a;
import com.tencent.p177mm.plugin.p436hp.tinker.C21075g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bhv;
import com.tencent.p177mm.protocal.protobuf.bhx;
import com.tencent.p177mm.protocal.protobuf.bia;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collection;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.hp.c.b */
public final class C46030b extends C39252a {
    private boolean ntW;
    C28317b ntX;

    /* renamed from: com.tencent.mm.plugin.hp.c.b$1 */
    class C432131 implements C21072a {
        C432131() {
        }

        /* renamed from: a */
        public final void mo36393a(boolean z, C28317b c28317b) {
            AppMethodBeat.m2504i(90621);
            if (!z || c28317b == null) {
                Context context = C4996ah.getContext();
                context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", C46030b.this.ntS).apply();
                C21075g.m32382aB(C4996ah.getContext(), "");
                AppMethodBeat.m2505o(90621);
                return;
            }
            C46030b.this.ntX = c28317b;
            C46030b.this.ntT = C46030b.this.ntX.num;
            C4990ab.m7417i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", C46030b.this.ntX.num, C46030b.this.ntT);
            C7060h.pYm.mo8378a(614, 71, 1, false);
            AppMethodBeat.m2505o(90621);
        }
    }

    public C46030b() {
        this("", "", null, false);
    }

    public C46030b(String str, String str2, List<bhv> list) {
        this(str, str2, list, true);
    }

    private C46030b(String str, String str2, List<bhv> list, boolean z) {
        String str3;
        Collection list2;
        AppMethodBeat.m2504i(90622);
        this.ntW = true;
        if (z) {
            this.gOW = 0;
            str3 = str2;
        } else {
            str = "tinker_id_" + C1760a.m3622Ul();
            str3 = C1760a.eSh == null ? "" : "tinker_id_" + C1760a.eSh;
            list2 = C39252a.bGn();
            this.gOW = 1;
        }
        this.ntS = str;
        this.ntT = str3;
        this.ntU.addAll(list2);
        this.ntW = z;
        if (this.ntW) {
            C432131 c432131 = new C432131();
            str3 = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
            if (!C5046bo.isNullOrNil(str3)) {
                try {
                    bhx bhx = new bhx();
                    bhx.parseFrom(Base64.decode(str3.getBytes(), 0));
                    if (bhx.pdA != null) {
                        str3 = C1760a.eSh == null ? "" : "tinker_id_" + C1760a.eSh;
                        String str4 = "tinker_id_" + C1760a.m3622Ul();
                        String string = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
                        C28317b c28317b = new C28317b(bhx.wLf);
                        C4990ab.m7417i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", c28317b.num, str3, string, str4);
                        if (!(C5046bo.isNullOrNil(c28317b.num) || c28317b.num.equalsIgnoreCase(str3) || C5046bo.isNullOrNil(str4) || !str4.equalsIgnoreCase(string))) {
                            c432131.mo36393a(true, c28317b);
                            AppMethodBeat.m2505o(90622);
                            return;
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("Tinker.TinkerUtils", e, "parse tinker update Response failed.", new Object[0]);
                    C7060h.pYm.mo8378a(614, 73, 1, false);
                }
            }
            c432131.mo36393a(false, null);
        }
        AppMethodBeat.m2505o(90622);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(90623);
        C4990ab.m7417i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            bhx bhx = (bhx) ((C7472b) c1929q).fsH.fsP;
            bia bia = bhx.wLf;
            if (bia == null) {
                if (bhx.wLh == 1) {
                    C39251a.m66895en(1, 0);
                } else if (bhx.wLh == 2) {
                    C39251a.m66895en(2, 0);
                } else if (bhx.wLh == 3) {
                    C39251a.m66895en(3, 0);
                } else if (bhx.wLh == 4) {
                    C39251a.m66895en(6, 0);
                } else if (bhx.wLh == 6) {
                    C4990ab.m7416i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
                } else {
                    C39251a.m66895en(5, 0);
                }
                if (this.ntX != null) {
                    String str2 = C1760a.eSh == null ? "" : "tinker_id_" + C1760a.eSh;
                    if (!(C5046bo.isNullOrNil(this.ntX.num) || this.ntX.num.equalsIgnoreCase(str2))) {
                        int i4 = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
                        if (i4 >= 4) {
                            C21075g.m32382aB(C4996ah.getContext(), "");
                            C21075g.m32380P(C4996ah.getContext(), 0);
                            C4990ab.m7417i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", Integer.valueOf(i4));
                            C7060h.pYm.mo8378a(614, 74, 1, false);
                        } else {
                            new C3296e(this.ntX).mo7670if(this.ntW);
                            C7060h.pYm.mo8378a(614, 70, 1, false);
                            C21075g.m32380P(C4996ah.getContext(), i4 + 1);
                            C4990ab.m7411d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", Integer.valueOf(i4));
                        }
                    }
                }
            } else if (this.ntW) {
                try {
                    C21075g.m32382aB(C4996ah.getContext(), new String(Base64.encode(bhx.toByteArray(), 0)));
                    C21075g.m32380P(C4996ah.getContext(), 0);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "save node failed.", new Object[0]);
                    C7060h.pYm.mo8378a(614, 72, 1, false);
                }
                C4990ab.m7410d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
                C28317b c28317b = new C28317b(bia);
                C4990ab.m7410d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
                new C3296e(c28317b).mo7670if(this.ntW);
                C4990ab.m7410d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
                C39251a.m66895en(4, 0);
            } else {
                C4990ab.m7416i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
            }
        } else {
            C4990ab.m7410d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
            C39251a.m66895en(5, i2);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(90623);
    }
}
