package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.k;
import com.tencent.mm.ba.m;
import com.tencent.mm.ba.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.io.File;

public final class d implements f {
    private static d nvs = null;
    private boolean fpA = false;
    c nvt = new c<cq>() {
        {
            AppMethodBeat.i(21725);
            this.xxI = cq.class.getName().hashCode();
            AppMethodBeat.o(21725);
        }

        private boolean a(cq cqVar) {
            AppMethodBeat.i(21726);
            if (cqVar instanceof cq) {
                ab.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
                aw.ZK();
                int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(0))).intValue();
                int i = g.Nu().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
                ab.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", Integer.valueOf(intValue), Integer.valueOf(i));
                if (intValue != i) {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(i));
                    r.aix().lT(26);
                    c bHc = c.bHc();
                    ab.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", e.eSj + "ipcallCountryCodeConfig.cfg");
                    try {
                        File file = new File(e.eSj + "ipcallCountryCodeConfig.cfg");
                        if (file.exists()) {
                            file.delete();
                        }
                        bHc.bZi = false;
                        bHc.nvr.clear();
                    } catch (Exception e) {
                        ab.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", e.getMessage());
                    }
                    d.this.ii(true);
                }
            }
            AppMethodBeat.o(21726);
            return false;
        }
    };
    private int retryCount = 0;

    private d() {
        AppMethodBeat.i(21728);
        AppMethodBeat.o(21728);
    }

    public static d bHg() {
        AppMethodBeat.i(21729);
        if (nvs == null) {
            nvs = new d();
        }
        d dVar = nvs;
        AppMethodBeat.o(21729);
        return dVar;
    }

    public final void ii(boolean z) {
        AppMethodBeat.i(21730);
        if (!aw.RK()) {
            ab.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
            AppMethodBeat.o(21730);
        } else if (this.fpA) {
            ab.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
            AppMethodBeat.o(21730);
        } else {
            ab.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", Boolean.valueOf(z));
            if (!z) {
                aw.ZK();
                long longValue = ((Long) com.tencent.mm.model.c.Ry().get(a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < 86400000) {
                    ab.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    AppMethodBeat.o(21730);
                    return;
                }
            }
            ab.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.fpA = true;
            aw.Rg().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (f) this);
            aw.Rg().a(160, (f) this);
            bHh();
            AppMethodBeat.o(21730);
        }
    }

    private static void bHh() {
        boolean z;
        AppMethodBeat.i(21731);
        m[] lU = r.aix().lU(26);
        if (lU == null || lU.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        aw.Rg().a(new k(z), 0);
        AppMethodBeat.o(21731);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(21732);
        ab.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.fpA));
        if (this.fpA) {
            boolean z;
            if (i == 0 || i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            ab.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", Boolean.valueOf(z));
            if (mVar.getType() != JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (mVar.getType() == 160 && z) {
                    ab.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                    c.bHc().ih(true);
                    bHi();
                }
                AppMethodBeat.o(21732);
                return;
            } else if (z) {
                ab.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
                m[] lU = r.aix().lU(26);
                if (lU == null || lU.length == 0) {
                    ab.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                    bHi();
                    AppMethodBeat.o(21732);
                    return;
                }
                ab.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", Integer.valueOf(lU.length));
                m mVar2 = lU[0];
                ab.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", Integer.valueOf(mVar2.cBc), Integer.valueOf(mVar2.id), Integer.valueOf(mVar2.version), Integer.valueOf(mVar2.status), mVar2.ais());
                if (mVar2.status == 3) {
                    ab.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                    AppMethodBeat.o(21732);
                    return;
                } else if (mVar2.status != 5) {
                    ab.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                    c.bHc().ih(true);
                    bHi();
                    AppMethodBeat.o(21732);
                    return;
                } else {
                    aw.Rg().a(new j(mVar2.id, 26), 0);
                    AppMethodBeat.o(21732);
                    return;
                }
            } else if (this.retryCount < 3) {
                this.retryCount++;
                bHh();
                ab.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", Integer.valueOf(this.retryCount));
                AppMethodBeat.o(21732);
                return;
            } else {
                ab.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
                AppMethodBeat.o(21732);
                return;
            }
        }
        AppMethodBeat.o(21732);
    }

    private void bHi() {
        AppMethodBeat.i(21733);
        this.fpA = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(21733);
    }
}
