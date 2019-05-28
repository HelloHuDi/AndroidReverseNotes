package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44095b;
import com.tencent.p177mm.protocal.protobuf.aeh;
import com.tencent.p177mm.protocal.protobuf.aei;
import com.tencent.p177mm.protocal.protobuf.bfu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.model.app.aa */
public final class C7236aa extends C1207m implements C1918k {
    private static final String[] vcr = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};
    final String appId;
    private C7472b ehh;
    private C1202f ehi;
    private final int fOZ = 3;

    public C7236aa(String str) {
        AppMethodBeat.m2504i(79369);
        this.appId = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aeh();
        c1196a.fsK = new aei();
        c1196a.uri = "/cgi-bin/micromsg-bin/getappinfo";
        c1196a.fsI = 231;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(79369);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(79370);
        this.ehi = c1202f;
        if (this.appId == null || this.appId.length() == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
            AppMethodBeat.m2505o(79370);
            return -1;
        }
        aeh aeh = (aeh) this.ehh.fsG.fsP;
        aeh.mZr = this.appId;
        aeh.weH = this.fOZ;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(79370);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(79371);
        C4990ab.m7410d("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 4 && i3 == -1011) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3 + ", appinfo does not exist");
            C34832a.bYJ();
            C40439f dhF = C35796i.dhF();
            dhF.field_appId = this.appId;
            C34832a.bYJ().mo10099a(dhF);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(79371);
        } else if (i2 == 0 && i3 == 0) {
            C40439f c40439f;
            aei aei = (aei) ((C7472b) c1929q).fsH.fsP;
            String str2 = aei.wmk.vDo;
            bfu bfu = aei.wmk;
            if (bfu == null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
                c40439f = null;
            } else {
                c40439f = new C40439f();
                c40439f.field_appId = bfu.mZr;
                c40439f.field_appName = bfu.ncH;
                c40439f.field_appDiscription = bfu.wJA;
                c40439f.field_appIconUrl = bfu.vDm;
                c40439f.field_appStoreUrl = bfu.mZJ;
                c40439f.field_appVersion = bfu.vMG;
                c40439f.field_appWatermarkUrl = bfu.wJB;
                c40439f.field_packageName = bfu.vDo;
                c40439f.field_signature = C35799p.aiO(bfu.vMD);
                c40439f.field_appName_en = bfu.wJC;
                c40439f.field_appName_tw = bfu.wJE;
                c40439f.field_appDiscription_en = bfu.wJD;
                c40439f.field_appDiscription_tw = bfu.wJF;
                c40439f.field_appInfoFlag = bfu.mZx;
                C4990ab.m7411d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", c40439f.field_appId, Integer.valueOf(c40439f.field_appInfoFlag));
            }
            if (c40439f == null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.m2505o(79371);
                return;
            }
            Object obj;
            c40439f.field_appType = aei.vME;
            bfu bfu2 = aei.wmk;
            String str3 = bfu2.vDo;
            String str4 = bfu2.vMD;
            if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || c40439f.mo63847xy()) {
                C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = ".concat(String.valueOf(str2)));
                C44095b.ajV(this.appId);
            }
            if (c40439f.field_appId == null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.m2505o(79371);
            } else if (c40439f.field_appId.equals(this.appId)) {
                C35796i bYJ = C34832a.bYJ();
                C40439f aiJ = bYJ.aiJ(this.appId);
                if (aiJ == null || aiJ.field_appId == null || aiJ.field_appId.length() == 0) {
                    c40439f.field_status = obj != null ? 3 : 4;
                    c40439f.field_modifyTime = System.currentTimeMillis();
                    if (c40439f.field_appId != null) {
                        for (Object equals : vcr) {
                            if (c40439f.field_appId.equals(equals)) {
                                c40439f.field_status = -1;
                                break;
                            }
                        }
                    }
                    if (bYJ.mo56573n(c40439f)) {
                        C34832a.bYH().mo48331dW(this.appId, 1);
                        C34832a.bYH().mo48331dW(this.appId, 2);
                        C34832a.bYH().mo48331dW(this.appId, 3);
                        C34832a.bYH().mo48331dW(this.appId, 4);
                        C34832a.bYH().mo48331dW(this.appId, 5);
                    } else {
                        C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
                        this.ehi.onSceneEnd(3, -1, str, this);
                        AppMethodBeat.m2505o(79371);
                        return;
                    }
                }
                c40439f.field_status = obj != null ? 3 : aiJ.field_status;
                if (c40439f.field_appId != null) {
                    for (Object equals2 : vcr) {
                        if (c40439f.field_appId.equals(equals2)) {
                            c40439f.field_status = -1;
                            break;
                        }
                    }
                }
                if (aiJ == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
                } else {
                    if (aiJ.dhx()) {
                        if (!C5046bo.isNullOrNil(aiJ.field_appIconUrl)) {
                            c40439f.field_appIconUrl = aiJ.field_appIconUrl;
                        }
                        if (!C5046bo.isNullOrNil(aiJ.field_appName)) {
                            c40439f.field_appName = aiJ.field_appName;
                        }
                        if (!C5046bo.isNullOrNil(aiJ.field_appName_en)) {
                            c40439f.field_appName_en = aiJ.field_appName_en;
                        }
                        if (!C5046bo.isNullOrNil(aiJ.field_appName_tw)) {
                            c40439f.field_appName_tw = aiJ.field_appName_tw;
                        }
                        if (!C5046bo.isNullOrNil(aiJ.field_appName_hk)) {
                            c40439f.field_appName_hk = aiJ.field_appName_hk;
                        }
                    }
                    if (C5046bo.isNullOrNil(c40439f.field_appId) || C5046bo.isNullOrNil(aiJ.field_appId)) {
                        C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
                    } else if (c40439f.field_appId.equalsIgnoreCase(aiJ.field_appId)) {
                        c40439f.field_openId = aiJ.field_openId;
                        c40439f.field_authFlag = aiJ.field_authFlag;
                        c40439f.mo44074if(aiJ.dmY);
                        c40439f.mo44075ig(aiJ.dmZ);
                        c40439f.mo44076ih(aiJ.dna);
                    } else {
                        C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
                    }
                }
                if (bYJ.mo56566a(c40439f, new String[0])) {
                    obj = (aiJ == null || aiJ.field_appIconUrl == null || aiJ.field_appIconUrl.length() == 0) ? 1 : (C5046bo.isNullOrNil(c40439f.dns) || !C5046bo.isNullOrNil(aiJ.dns)) ? (C5046bo.isNullOrNil(c40439f.dnt) || !C5046bo.isNullOrNil(aiJ.dnt)) ? (c40439f.field_appIconUrl == null || c40439f.field_appIconUrl.length() == 0) ? null : !aiJ.field_appIconUrl.equals(c40439f.field_appIconUrl) ? 1 : null : 1 : 1;
                    if (obj != null) {
                        C34832a.bYH().mo48331dW(this.appId, 1);
                        C34832a.bYH().mo48331dW(this.appId, 2);
                        C34832a.bYH().mo48331dW(this.appId, 3);
                        C34832a.bYH().mo48331dW(this.appId, 4);
                        C34832a.bYH().mo48331dW(this.appId, 5);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
                    this.ehi.onSceneEnd(3, -1, str, this);
                    AppMethodBeat.m2505o(79371);
                    return;
                }
                if (C5046bo.isNullOrNil(c40439f.field_openId)) {
                    C4990ab.m7410d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + c40439f.field_appId);
                    C34832a.bYL().mo9878wy(c40439f.field_appId);
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(79371);
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
                this.ehi.onSceneEnd(3, -1, str, this);
                AppMethodBeat.m2505o(79371);
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(79371);
        }
    }

    public final int getType() {
        return 231;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }
}
