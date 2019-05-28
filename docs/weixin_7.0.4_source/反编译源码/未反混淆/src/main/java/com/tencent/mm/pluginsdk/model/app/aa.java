package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class aa extends m implements k {
    private static final String[] vcr = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};
    final String appId;
    private b ehh;
    private f ehi;
    private final int fOZ = 3;

    public aa(String str) {
        AppMethodBeat.i(79369);
        this.appId = str;
        a aVar = new a();
        aVar.fsJ = new aeh();
        aVar.fsK = new aei();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfo";
        aVar.fsI = 231;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(79369);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(79370);
        this.ehi = fVar;
        if (this.appId == null || this.appId.length() == 0) {
            ab.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
            AppMethodBeat.o(79370);
            return -1;
        }
        aeh aeh = (aeh) this.ehh.fsG.fsP;
        aeh.mZr = this.appId;
        aeh.weH = this.fOZ;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(79370);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(79371);
        ab.d("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 4 && i3 == -1011) {
            ab.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3 + ", appinfo does not exist");
            com.tencent.mm.plugin.s.a.bYJ();
            f dhF = i.dhF();
            dhF.field_appId = this.appId;
            com.tencent.mm.plugin.s.a.bYJ().a(dhF);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(79371);
        } else if (i2 == 0 && i3 == 0) {
            f fVar;
            aei aei = (aei) ((b) qVar).fsH.fsP;
            String str2 = aei.wmk.vDo;
            bfu bfu = aei.wmk;
            if (bfu == null) {
                ab.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
                fVar = null;
            } else {
                fVar = new f();
                fVar.field_appId = bfu.mZr;
                fVar.field_appName = bfu.ncH;
                fVar.field_appDiscription = bfu.wJA;
                fVar.field_appIconUrl = bfu.vDm;
                fVar.field_appStoreUrl = bfu.mZJ;
                fVar.field_appVersion = bfu.vMG;
                fVar.field_appWatermarkUrl = bfu.wJB;
                fVar.field_packageName = bfu.vDo;
                fVar.field_signature = p.aiO(bfu.vMD);
                fVar.field_appName_en = bfu.wJC;
                fVar.field_appName_tw = bfu.wJE;
                fVar.field_appDiscription_en = bfu.wJD;
                fVar.field_appDiscription_tw = bfu.wJF;
                fVar.field_appInfoFlag = bfu.mZx;
                ab.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag));
            }
            if (fVar == null) {
                ab.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(79371);
                return;
            }
            Object obj;
            fVar.field_appType = aei.vME;
            bfu bfu2 = aei.wmk;
            String str3 = bfu2.vDo;
            String str4 = bfu2.vMD;
            if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || fVar.xy()) {
                ab.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = ".concat(String.valueOf(str2)));
                com.tencent.mm.pluginsdk.ui.tools.b.ajV(this.appId);
            }
            if (fVar.field_appId == null) {
                ab.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(79371);
            } else if (fVar.field_appId.equals(this.appId)) {
                i bYJ = com.tencent.mm.plugin.s.a.bYJ();
                f aiJ = bYJ.aiJ(this.appId);
                if (aiJ == null || aiJ.field_appId == null || aiJ.field_appId.length() == 0) {
                    fVar.field_status = obj != null ? 3 : 4;
                    fVar.field_modifyTime = System.currentTimeMillis();
                    if (fVar.field_appId != null) {
                        for (Object equals : vcr) {
                            if (fVar.field_appId.equals(equals)) {
                                fVar.field_status = -1;
                                break;
                            }
                        }
                    }
                    if (bYJ.n(fVar)) {
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 1);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 2);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 3);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 4);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 5);
                    } else {
                        ab.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
                        this.ehi.onSceneEnd(3, -1, str, this);
                        AppMethodBeat.o(79371);
                        return;
                    }
                }
                fVar.field_status = obj != null ? 3 : aiJ.field_status;
                if (fVar.field_appId != null) {
                    for (Object equals2 : vcr) {
                        if (fVar.field_appId.equals(equals2)) {
                            fVar.field_status = -1;
                            break;
                        }
                    }
                }
                if (aiJ == null) {
                    ab.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
                } else {
                    if (aiJ.dhx()) {
                        if (!bo.isNullOrNil(aiJ.field_appIconUrl)) {
                            fVar.field_appIconUrl = aiJ.field_appIconUrl;
                        }
                        if (!bo.isNullOrNil(aiJ.field_appName)) {
                            fVar.field_appName = aiJ.field_appName;
                        }
                        if (!bo.isNullOrNil(aiJ.field_appName_en)) {
                            fVar.field_appName_en = aiJ.field_appName_en;
                        }
                        if (!bo.isNullOrNil(aiJ.field_appName_tw)) {
                            fVar.field_appName_tw = aiJ.field_appName_tw;
                        }
                        if (!bo.isNullOrNil(aiJ.field_appName_hk)) {
                            fVar.field_appName_hk = aiJ.field_appName_hk;
                        }
                    }
                    if (bo.isNullOrNil(fVar.field_appId) || bo.isNullOrNil(aiJ.field_appId)) {
                        ab.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
                    } else if (fVar.field_appId.equalsIgnoreCase(aiJ.field_appId)) {
                        fVar.field_openId = aiJ.field_openId;
                        fVar.field_authFlag = aiJ.field_authFlag;
                        fVar.m12if(aiJ.dmY);
                        fVar.ig(aiJ.dmZ);
                        fVar.ih(aiJ.dna);
                    } else {
                        ab.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
                    }
                }
                if (bYJ.a(fVar, new String[0])) {
                    obj = (aiJ == null || aiJ.field_appIconUrl == null || aiJ.field_appIconUrl.length() == 0) ? 1 : (bo.isNullOrNil(fVar.dns) || !bo.isNullOrNil(aiJ.dns)) ? (bo.isNullOrNil(fVar.dnt) || !bo.isNullOrNil(aiJ.dnt)) ? (fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? null : !aiJ.field_appIconUrl.equals(fVar.field_appIconUrl) ? 1 : null : 1 : 1;
                    if (obj != null) {
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 1);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 2);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 3);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 4);
                        com.tencent.mm.plugin.s.a.bYH().dW(this.appId, 5);
                    }
                } else {
                    ab.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
                    this.ehi.onSceneEnd(3, -1, str, this);
                    AppMethodBeat.o(79371);
                    return;
                }
                if (bo.isNullOrNil(fVar.field_openId)) {
                    ab.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + fVar.field_appId);
                    com.tencent.mm.plugin.s.a.bYL().wy(fVar.field_appId);
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(79371);
            } else {
                ab.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(79371);
            }
        } else {
            ab.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(79371);
        }
    }

    public final int getType() {
        return 231;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }
}
