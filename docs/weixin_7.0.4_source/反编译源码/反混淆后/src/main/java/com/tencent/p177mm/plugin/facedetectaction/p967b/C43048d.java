package com.tencent.p177mm.plugin.facedetectaction.p967b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetectaction.p1483a.C34117a;
import com.tencent.p177mm.plugin.facedetectaction.p1483a.C39027b;
import com.tencent.p177mm.plugin.facedetectaction.p404ui.FaceActionUI;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C39031b.C39030a;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C39031b.C390321;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.ais;
import com.tencent.p177mm.protocal.protobuf.aiu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

/* renamed from: com.tencent.mm.plugin.facedetectaction.b.d */
public final class C43048d implements C1202f {
    public static C43048d mcq = new C43048d();
    String cKT;
    public String cKU;
    public MMActivity crP;
    public int fcR;
    private String lTX;
    public int mStatus = 0;
    public FaceActionUI mbY;
    public int mcA;
    public C39031b mcr;
    private C27945e mcs;
    private String mct;
    private float mcu;
    private String mcv;
    public C39034a mcw;
    HandlerThread mcx;
    C7306ak mcy;
    public int mcz;
    String packageName;
    int requestCode;
    int scene;

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.d$1 */
    class C206661 implements C39030a {
        C206661() {
        }

        /* renamed from: a */
        public final void mo35963a(byte[][] bArr, int i, int i2) {
            AppMethodBeat.m2504i(689);
            C4990ab.m7417i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", bArr, Integer.valueOf(i), Integer.valueOf(i2));
            if (bArr != null) {
                C43048d.m76476a(C43048d.this, bArr, i, i2);
            }
            AppMethodBeat.m2505o(689);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.d$a */
    public interface C39034a {
        /* renamed from: Lx */
        void mo45862Lx(String str);

        /* renamed from: a */
        void mo45863a(int i, int i2, String str, int i3);

        /* renamed from: aA */
        void mo45864aA(int i, String str);

        void btP();
    }

    static {
        AppMethodBeat.m2504i(700);
        AppMethodBeat.m2505o(700);
    }

    /* renamed from: a */
    public final void mo68576a(FaceActionUI faceActionUI) {
        AppMethodBeat.m2504i(693);
        C1207m c34117a = new C34117a(this.scene, this.packageName, this.cKT);
        C1720g.m3540Rg().mo14539a(2696, (C1202f) this);
        C1720g.m3540Rg().mo14541a(c34117a, 0);
        this.mbY = faceActionUI;
        AppMethodBeat.m2505o(693);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(694);
        C4990ab.m7417i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (c1207m instanceof C34117a) {
            C1720g.m3540Rg().mo14546b(2696, (C1202f) this);
            C34117a c34117a = (C34117a) c1207m;
            if (i == 0 && i2 == 0) {
                ais ais = c34117a.mbT;
                C4990ab.m7417i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", Integer.valueOf(ais.kdT), ais.kdU, ais.woJ, Float.valueOf(ais.woK), ais.vYl);
                if (ais.kdT == 0) {
                    int i3;
                    this.mct = ais.person_id;
                    this.lTX = ais.woJ;
                    this.mcu = ais.woK;
                    this.mcv = ais.vYl;
                    switch (C5046bo.getInt(this.lTX, -1)) {
                        case 1:
                            i3 = 0;
                            break;
                        case 3:
                            i3 = 1;
                            break;
                        case 5:
                            i3 = 2;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    if (i3 != -1) {
                        C4990ab.m7417i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", Integer.valueOf(i3), ais.woL);
                        C39031b c39031b = this.mcr;
                        MMActivity mMActivity = this.crP;
                        C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", Integer.valueOf(YTCommonExInterface.initAuth(C4996ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false)));
                        c39031b.mcm = i3;
                        if (YTCommonExInterface.initAuth(C4996ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false) != 0) {
                            C7060h.pYm.mo8378a(917, 58, 1, false);
                        } else {
                            C7060h.pYm.mo8378a(917, 57, 1, false);
                            c39031b.mo61947f(mMActivity);
                            c39031b.mcn = new C390321();
                        }
                        this.mStatus = 0;
                        this.mcr.mco = new C206661();
                        if (this.mcw != null) {
                            this.mcw.mo45864aA(i3, r11);
                        }
                    } else if (this.mcw != null) {
                        this.mcw.mo45863a(1, -1, "", 1);
                        AppMethodBeat.m2505o(694);
                        return;
                    }
                    AppMethodBeat.m2505o(694);
                    return;
                }
                if (this.mcw != null) {
                    this.mcw.mo45863a(1, ais.kdT, ais.kdU, 1);
                }
                AppMethodBeat.m2505o(694);
                return;
            }
            C4990ab.m7412e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
            if (this.mcw != null) {
                this.mcw.mo45863a(1, i2, str, 1);
            }
            AppMethodBeat.m2505o(694);
            return;
        }
        if (c1207m instanceof C39027b) {
            C39027b c39027b = (C39027b) c1207m;
            C1720g.m3540Rg().mo14546b(2726, (C1202f) this);
            if (i == 0 && i2 == 0) {
                aiu aiu = c39027b.mbV;
                C4990ab.m7417i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s", Integer.valueOf(aiu.kdT), aiu.kdU);
                if (aiu.kdT == 0) {
                    C4990ab.m7416i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
                    if (this.mcw != null) {
                        this.mcw.mo45862Lx(aiu.wcg);
                        this.mStatus = 2;
                    }
                } else if (this.mcw != null) {
                    this.mcw.mo45863a(3, aiu.kdT, aiu.kdU, aiu.woP);
                    AppMethodBeat.m2505o(694);
                    return;
                }
                AppMethodBeat.m2505o(694);
                return;
            }
            C4990ab.m7412e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
            if (this.mcw != null) {
                this.mcw.mo45863a(3, i2, str, 1);
            }
        }
        AppMethodBeat.m2505o(694);
    }

    /* renamed from: R */
    public final void mo68575R(Runnable runnable) {
        AppMethodBeat.m2504i(695);
        if (this.mcy != null) {
            this.mcy.post(runnable);
        }
        AppMethodBeat.m2505o(695);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(696);
        if (this.mStatus == 0 || this.mStatus == 1) {
            this.mbY.mo54673a("cancel", 90004, null, Boolean.valueOf(this.mbY.mcY));
            AppMethodBeat.m2505o(696);
        } else if (this.mStatus == 2) {
            this.mbY.mo54673a("cancel", 90025, null, Boolean.valueOf(this.mbY.mcY));
            AppMethodBeat.m2505o(696);
        } else {
            if (this.mStatus == 3) {
                this.mbY.mo54673a("cancel", 90006, null, Boolean.valueOf(this.mbY.mcY));
            }
            AppMethodBeat.m2505o(696);
        }
    }

    public final void release(boolean z) {
        AppMethodBeat.m2504i(697);
        C4990ab.m7417i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", Boolean.valueOf(z));
        if (this.mcr != null) {
            C39031b c39031b = this.mcr;
            try {
                if (c39031b.status == 4 || c39031b.status == 3 || c39031b.status == 5) {
                    YTPoseDetectInterface.releaseModel();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FaceCheckActionEngine", e, "release error", new Object[0]);
            }
            this.mcr = new C39031b();
        }
        if (this.mcs != null) {
            if (C27922a.btw().isStarted()) {
                C27922a.btw().bty();
            }
            this.mcs = null;
        }
        if (z) {
            if (this.mcx != null) {
                this.mcx.quit();
                this.mcx = null;
                this.mcy = null;
            }
            mcq = new C43048d();
        }
        AppMethodBeat.m2505o(697);
    }
}
