package com.tencent.mm.plugin.facedetectaction.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetectaction.a.b;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;

public final class d implements f {
    public static d mcq = new d();
    String cKT;
    public String cKU;
    public MMActivity crP;
    public int fcR;
    private String lTX;
    public int mStatus = 0;
    public FaceActionUI mbY;
    public int mcA;
    public b mcr;
    private e mcs;
    private String mct;
    private float mcu;
    private String mcv;
    public a mcw;
    HandlerThread mcx;
    ak mcy;
    public int mcz;
    String packageName;
    int requestCode;
    int scene;

    public interface a {
        void Lx(String str);

        void a(int i, int i2, String str, int i3);

        void aA(int i, String str);

        void btP();
    }

    static {
        AppMethodBeat.i(700);
        AppMethodBeat.o(700);
    }

    public final void a(FaceActionUI faceActionUI) {
        AppMethodBeat.i(693);
        m aVar = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.cKT);
        g.Rg().a(2696, (f) this);
        g.Rg().a(aVar, 0);
        this.mbY = faceActionUI;
        AppMethodBeat.o(693);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(694);
        ab.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (mVar instanceof com.tencent.mm.plugin.facedetectaction.a.a) {
            g.Rg().b(2696, (f) this);
            com.tencent.mm.plugin.facedetectaction.a.a aVar = (com.tencent.mm.plugin.facedetectaction.a.a) mVar;
            if (i == 0 && i2 == 0) {
                ais ais = aVar.mbT;
                ab.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", Integer.valueOf(ais.kdT), ais.kdU, ais.woJ, Float.valueOf(ais.woK), ais.vYl);
                if (ais.kdT == 0) {
                    int i3;
                    this.mct = ais.person_id;
                    this.lTX = ais.woJ;
                    this.mcu = ais.woK;
                    this.mcv = ais.vYl;
                    switch (bo.getInt(this.lTX, -1)) {
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
                        ab.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", Integer.valueOf(i3), ais.woL);
                        b bVar = this.mcr;
                        MMActivity mMActivity = this.crP;
                        ab.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", Integer.valueOf(YTCommonExInterface.initAuth(ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false)));
                        bVar.mcm = i3;
                        if (YTCommonExInterface.initAuth(ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false) != 0) {
                            h.pYm.a(917, 58, 1, false);
                        } else {
                            h.pYm.a(917, 57, 1, false);
                            bVar.f(mMActivity);
                            bVar.mcn = new PoseDetectOnFrame() {
                                public final void onSuccess(int i) {
                                    AppMethodBeat.i(682);
                                    ab.i("MicroMsg.FaceCheckActionEngine", "detect action success: %s", Integer.valueOf(i));
                                    b.this.status = 3;
                                    h.pYm.a(917, 42, 1, false);
                                    if (b.this.mco != null) {
                                        b.this.mco;
                                    }
                                    AppMethodBeat.o(682);
                                }

                                public final void onFailed(int i, String str, String str2) {
                                    AppMethodBeat.i(683);
                                    ab.i("MicroMsg.FaceCheckActionEngine", "detect action failed, %s %s %s", Integer.valueOf(i), str, str2);
                                    b.this.status = 4;
                                    h.pYm.a(917, 43, 1, false);
                                    if (b.this.mco != null) {
                                        b.this.mco;
                                    }
                                    AppMethodBeat.o(683);
                                }

                                public final void onRecordingDone(byte[][] bArr, int i, int i2) {
                                    AppMethodBeat.i(684);
                                    if (bArr != null) {
                                        ab.i("MicroMsg.FaceCheckActionEngine", "notify start record, frameDatas.length: %s, width: %s, height: %s", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2));
                                    } else {
                                        ab.e("MicroMsg.FaceCheckActionEngine", "onRecordingDone, frameData is null!!");
                                    }
                                    b.this.status = 5;
                                    if (b.this.mco != null) {
                                        b.this.mco.a(bArr, i, i2);
                                    }
                                    AppMethodBeat.o(684);
                                }
                            };
                        }
                        this.mStatus = 0;
                        this.mcr.mco = new com.tencent.mm.plugin.facedetectaction.b.b.a() {
                            public final void a(byte[][] bArr, int i, int i2) {
                                AppMethodBeat.i(689);
                                ab.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", bArr, Integer.valueOf(i), Integer.valueOf(i2));
                                if (bArr != null) {
                                    d.a(d.this, bArr, i, i2);
                                }
                                AppMethodBeat.o(689);
                            }
                        };
                        if (this.mcw != null) {
                            this.mcw.aA(i3, r11);
                        }
                    } else if (this.mcw != null) {
                        this.mcw.a(1, -1, "", 1);
                        AppMethodBeat.o(694);
                        return;
                    }
                    AppMethodBeat.o(694);
                    return;
                }
                if (this.mcw != null) {
                    this.mcw.a(1, ais.kdT, ais.kdU, 1);
                }
                AppMethodBeat.o(694);
                return;
            }
            ab.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
            if (this.mcw != null) {
                this.mcw.a(1, i2, str, 1);
            }
            AppMethodBeat.o(694);
            return;
        }
        if (mVar instanceof b) {
            b bVar2 = (b) mVar;
            g.Rg().b(2726, (f) this);
            if (i == 0 && i2 == 0) {
                aiu aiu = bVar2.mbV;
                ab.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s", Integer.valueOf(aiu.kdT), aiu.kdU);
                if (aiu.kdT == 0) {
                    ab.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
                    if (this.mcw != null) {
                        this.mcw.Lx(aiu.wcg);
                        this.mStatus = 2;
                    }
                } else if (this.mcw != null) {
                    this.mcw.a(3, aiu.kdT, aiu.kdU, aiu.woP);
                    AppMethodBeat.o(694);
                    return;
                }
                AppMethodBeat.o(694);
                return;
            }
            ab.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
            if (this.mcw != null) {
                this.mcw.a(3, i2, str, 1);
            }
        }
        AppMethodBeat.o(694);
    }

    public final void R(Runnable runnable) {
        AppMethodBeat.i(695);
        if (this.mcy != null) {
            this.mcy.post(runnable);
        }
        AppMethodBeat.o(695);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(696);
        if (this.mStatus == 0 || this.mStatus == 1) {
            this.mbY.a("cancel", 90004, null, Boolean.valueOf(this.mbY.mcY));
            AppMethodBeat.o(696);
        } else if (this.mStatus == 2) {
            this.mbY.a("cancel", 90025, null, Boolean.valueOf(this.mbY.mcY));
            AppMethodBeat.o(696);
        } else {
            if (this.mStatus == 3) {
                this.mbY.a("cancel", 90006, null, Boolean.valueOf(this.mbY.mcY));
            }
            AppMethodBeat.o(696);
        }
    }

    public final void release(boolean z) {
        AppMethodBeat.i(697);
        ab.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", Boolean.valueOf(z));
        if (this.mcr != null) {
            b bVar = this.mcr;
            try {
                if (bVar.status == 4 || bVar.status == 3 || bVar.status == 5) {
                    YTPoseDetectInterface.releaseModel();
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FaceCheckActionEngine", e, "release error", new Object[0]);
            }
            this.mcr = new b();
        }
        if (this.mcs != null) {
            if (com.tencent.mm.plugin.facedetect.e.a.btw().isStarted()) {
                com.tencent.mm.plugin.facedetect.e.a.btw().bty();
            }
            this.mcs = null;
        }
        if (z) {
            if (this.mcx != null) {
                this.mcx.quit();
                this.mcx = null;
                this.mcy = null;
            }
            mcq = new d();
        }
        AppMethodBeat.o(697);
    }
}
