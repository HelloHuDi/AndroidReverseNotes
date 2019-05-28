package com.tencent.p177mm.plugin.ipcall.p438a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p707ba.C25854m;
import com.tencent.p177mm.p707ba.C32329j;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d */
public final class C43220d implements C1202f {
    private static C43220d nvs = null;
    private boolean fpA = false;
    C4884c nvt = new C283291();
    private int retryCount = 0;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.d$1 */
    class C283291 extends C4884c<C6471cq> {
        C283291() {
            AppMethodBeat.m2504i(21725);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(21725);
        }

        /* renamed from: a */
        private boolean m44942a(C6471cq c6471cq) {
            AppMethodBeat.m2504i(21726);
            if (c6471cq instanceof C6471cq) {
                C4990ab.m7410d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
                C9638aw.m17190ZK();
                int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(0))).intValue();
                int i = C26373g.m41964Nu().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
                C4990ab.m7411d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", Integer.valueOf(intValue), Integer.valueOf(i));
                if (intValue != i) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(i));
                    C41787r.aix().mo20546lT(26);
                    C46032c bHc = C46032c.bHc();
                    C4990ab.m7411d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", C6457e.eSj + "ipcallCountryCodeConfig.cfg");
                    try {
                        File file = new File(C6457e.eSj + "ipcallCountryCodeConfig.cfg");
                        if (file.exists()) {
                            file.delete();
                        }
                        bHc.bZi = false;
                        bHc.nvr.clear();
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", e.getMessage());
                    }
                    C43220d.this.mo68728ii(true);
                }
            }
            AppMethodBeat.m2505o(21726);
            return false;
        }
    }

    private C43220d() {
        AppMethodBeat.m2504i(21728);
        AppMethodBeat.m2505o(21728);
    }

    public static C43220d bHg() {
        AppMethodBeat.m2504i(21729);
        if (nvs == null) {
            nvs = new C43220d();
        }
        C43220d c43220d = nvs;
        AppMethodBeat.m2505o(21729);
        return c43220d;
    }

    /* renamed from: ii */
    public final void mo68728ii(boolean z) {
        AppMethodBeat.m2504i(21730);
        if (!C9638aw.m17179RK()) {
            C4990ab.m7416i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
            AppMethodBeat.m2505o(21730);
        } else if (this.fpA) {
            C4990ab.m7416i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
            AppMethodBeat.m2505o(21730);
        } else {
            C4990ab.m7411d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", Boolean.valueOf(z));
            if (!z) {
                C9638aw.m17190ZK();
                long longValue = ((Long) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < 86400000) {
                    C4990ab.m7416i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    AppMethodBeat.m2505o(21730);
                    return;
                }
            }
            C4990ab.m7416i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.fpA = true;
            C9638aw.m17182Rg().mo14539a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(160, (C1202f) this);
            C43220d.bHh();
            AppMethodBeat.m2505o(21730);
        }
    }

    private static void bHh() {
        boolean z;
        AppMethodBeat.m2504i(21731);
        C25854m[] lU = C41787r.aix().mo20547lU(26);
        if (lU == null || lU.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        C9638aw.m17182Rg().mo14541a(new C45181k(z), 0);
        AppMethodBeat.m2505o(21731);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(21732);
        C4990ab.m7411d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.fpA));
        if (this.fpA) {
            boolean z;
            if (i == 0 || i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7411d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", Boolean.valueOf(z));
            if (c1207m.getType() != JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (c1207m.getType() == 160 && z) {
                    C4990ab.m7410d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                    C46032c.bHc().mo73924ih(true);
                    bHi();
                }
                AppMethodBeat.m2505o(21732);
                return;
            } else if (z) {
                C4990ab.m7410d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
                C25854m[] lU = C41787r.aix().mo20547lU(26);
                if (lU == null || lU.length == 0) {
                    C4990ab.m7410d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                    bHi();
                    AppMethodBeat.m2505o(21732);
                    return;
                }
                C4990ab.m7411d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", Integer.valueOf(lU.length));
                C25854m c25854m = lU[0];
                C4990ab.m7411d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", Integer.valueOf(c25854m.cBc), Integer.valueOf(c25854m.f13661id), Integer.valueOf(c25854m.version), Integer.valueOf(c25854m.status), c25854m.ais());
                if (c25854m.status == 3) {
                    C4990ab.m7410d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                    AppMethodBeat.m2505o(21732);
                    return;
                } else if (c25854m.status != 5) {
                    C4990ab.m7410d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                    C46032c.bHc().mo73924ih(true);
                    bHi();
                    AppMethodBeat.m2505o(21732);
                    return;
                } else {
                    C9638aw.m17182Rg().mo14541a(new C32329j(c25854m.f13661id, 26), 0);
                    AppMethodBeat.m2505o(21732);
                    return;
                }
            } else if (this.retryCount < 3) {
                this.retryCount++;
                C43220d.bHh();
                C4990ab.m7411d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", Integer.valueOf(this.retryCount));
                AppMethodBeat.m2505o(21732);
                return;
            } else {
                C4990ab.m7412e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
                AppMethodBeat.m2505o(21732);
                return;
            }
        }
        AppMethodBeat.m2505o(21732);
    }

    private void bHi() {
        AppMethodBeat.m2504i(21733);
        this.fpA = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
        AppMethodBeat.m2505o(21733);
    }
}
