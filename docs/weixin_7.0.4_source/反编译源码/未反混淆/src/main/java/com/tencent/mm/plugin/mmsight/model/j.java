package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.v;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class j {
    static int fXT;
    static double ouA;
    public static boolean ouw = true;
    public static boolean oux = false;
    public static boolean ouy = false;
    public static o ouz;

    public enum a {
        MMSightCameraConfig,
        MMStoryCameraConfig;

        static {
            AppMethodBeat.o(76525);
        }
    }

    public static boolean d(Point point) {
        AppMethodBeat.i(76526);
        if (oux) {
            Context context = ah.getContext();
            Resources resources = ah.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = ouz == null ? "" : Integer.valueOf(ouz.ouK);
            t.makeText(context, resources.getString(R.string.cda, objArr), 1).show();
            AppMethodBeat.o(76526);
            return false;
        }
        ab.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", Integer.valueOf(q.etj.etz), Integer.valueOf(q.etj.etG), Boolean.valueOf(ouy));
        if (ouy) {
            AppMethodBeat.o(76526);
            return false;
        } else if (q.etj.etz != -1) {
            AppMethodBeat.o(76526);
            return true;
        } else if (ouz != null && 1 == ouz.etz) {
            AppMethodBeat.o(76526);
            return true;
        } else if (point == null) {
            AppMethodBeat.o(76526);
            return false;
        } else if (d.yO(point.x) && d.yO(point.y)) {
            AppMethodBeat.o(76526);
            return true;
        } else {
            if (ouz != null) {
                ab.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", point.toString());
                ouz.etz = 1;
            }
            AppMethodBeat.o(76526);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Parameters parameters, boolean z) {
        AppMethodBeat.i(76527);
        if (oux) {
            Context context = ah.getContext();
            Resources resources = ah.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = ouz == null ? "" : Integer.valueOf(ouz.ouK);
            t.makeText(context, resources.getString(R.string.cda, objArr), 1).show();
            AppMethodBeat.o(76527);
            return;
        }
        ab.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", Integer.valueOf(q.etj.etG), Boolean.valueOf(ouy));
        if (ouy) {
            AppMethodBeat.o(76527);
            return;
        }
        o oVar;
        Point bPg = d.bPg();
        int i = bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
        ab.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", Integer.valueOf(i), Integer.valueOf(bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19)), Integer.valueOf(bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19)));
        if (q.etj.etF == -1 || (q.etj.etF & 1) != 0) {
            if (q.etj.etF != -1 && (q.etj.etF & 1) != 0) {
                ouz.bPG().ouM = true;
                i = 1;
                if (q.etj.etA != -1) {
                }
                if (q.etj.etF == -1) {
                }
                oVar = ouz;
                oVar.ouP = g.a(parameters, d.bPg(), 720, z);
                if (oVar.ouP != null) {
                }
                i = 0;
                if (i != 0) {
                }
                ouz.ouK = -1;
                ab.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", ouz.toString());
                AppMethodBeat.o(76527);
            } else if (com.tencent.mm.compatible.util.d.iW(r3) && fXT >= 512 && ouA >= 1725.0d && Math.min(bPg.x, bPg.y) >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                oVar = ouz;
                oVar.ouP = g.a(parameters, d.bPg(), oVar.fcY.width * 2, z);
                if (oVar.ouP == null || oVar.ouP.oum == null) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    ouz.bPG().ouM = true;
                    i = 1;
                    if (q.etj.etA != -1) {
                        boolean z2;
                        o oVar2 = ouz;
                        if (q.etj.etA == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        oVar2.ouL = z2;
                    } else {
                        ouz.ouL = false;
                    }
                    if (q.etj.etF == -1 || (q.etj.etF & 2) != 0) {
                        if (q.etj.etF == -1 && (q.etj.etF & 2) != 0) {
                            oVar = ouz.bPE();
                            oVar.ouM = false;
                            oVar.bPF();
                        } else if (i == 0 && com.tencent.mm.compatible.util.d.iW(r5) && fXT >= 512 && ouA >= 1725.0d && Math.min(bPg.x, bPg.y) >= 720) {
                            oVar = ouz;
                            oVar.ouP = g.a(parameters, d.bPg(), 720, z);
                            if (oVar.ouP != null || oVar.ouP.oum == null) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i != 0) {
                                ouz.bPE().ouM = true;
                            }
                        }
                    }
                    ouz.ouK = -1;
                    ab.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", ouz.toString());
                    AppMethodBeat.o(76527);
                }
            }
        }
        i = 0;
        if (q.etj.etA != -1) {
        }
        if (q.etj.etF == -1) {
        }
        oVar = ouz;
        oVar.ouP = g.a(parameters, d.bPg(), 720, z);
        if (oVar.ouP != null) {
        }
        i = 0;
        if (i != 0) {
        }
        ouz.ouK = -1;
        ab.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", ouz.toString());
        AppMethodBeat.o(76527);
    }

    public static void c(VideoTransPara videoTransPara) {
        int i;
        int i2;
        boolean z = true;
        AppMethodBeat.i(76528);
        a aVar = a.MMSightCameraConfig;
        oux = false;
        ouy = false;
        fXT = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        ouA = (double) d.ev(ah.getContext());
        String dut = bs.dut();
        ab.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", Integer.valueOf(bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19)));
        if (CaptureMMProxy.getInstance() != null) {
            q.ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        ab.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", Integer.valueOf(fXT), Double.valueOf(ouA), dut, q.etj);
        if (CaptureMMProxy.getInstance() != null) {
            i = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, -1);
            i2 = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, 1);
        } else {
            i2 = 1;
            i = -1;
        }
        o a = o.a(i, videoTransPara);
        ouz = a;
        if (a != null) {
            ouz.ouN = i2 == 1;
            oux = true;
            Context context = ah.getContext();
            Resources resources = ah.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = ouz == null ? "" : Integer.valueOf(ouz.ouK);
            t.makeText(context, resources.getString(R.string.cda, objArr), 1).show();
            AppMethodBeat.o(76528);
            return;
        }
        switch (aVar) {
            case MMStoryCameraConfig:
                v vVar = q.etk;
                i = 12;
                break;
            default:
                i = q.etj.etG;
                break;
        }
        ab.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", Integer.valueOf(i));
        if (i != -1) {
            ouz = o.a(i, videoTransPara);
        }
        if (ouz != null) {
            if (i2 == 1) {
                ouz.ouN = true;
            } else {
                ouz.ouN = false;
            }
            ouy = true;
            AppMethodBeat.o(76528);
            return;
        }
        ouz = o.a(1, videoTransPara);
        if (i2 == 1) {
            ouz.ouN = true;
        } else {
            ouz.ouN = false;
        }
        if (q.etj.etz != -1) {
            ouz.etz = q.etj.etz;
        } else if (com.tencent.mm.compatible.util.d.iW(r6)) {
            ouz.etz = 2;
        } else {
            ouz.etz = 1;
        }
        if (q.etj.etC != -1) {
            ouw = q.etj.etC == 1;
        }
        if (q.etj.etA != -1) {
            o oVar = ouz;
            if (q.etj.etA != 1) {
                z = false;
            }
            oVar.ouL = z;
            AppMethodBeat.o(76528);
            return;
        }
        ouz.ouL = false;
        AppMethodBeat.o(76528);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(76529);
        if (bVar.oum == null) {
            ab.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", bVar.toString());
            bVar.oum = bVar.oup;
            bVar.oun = bVar.ouq;
            bVar.ouo = bVar.our;
            if (Math.min(bVar.oun.y, bVar.oun.x) >= ouz.fcY.width + 16) {
                ouz.bPF();
                ouz.ouM = false;
                ouz.ouL = false;
                ab.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", bVar.toString());
            }
        }
        AppMethodBeat.o(76529);
    }

    public static void bPw() {
        AppMethodBeat.i(76530);
        ab.i("MicroMsg.MMSightRecorderConfig", "initSimple");
        o oVar = new o();
        ouz = oVar;
        oVar.ouL = false;
        ouz.ouM = false;
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            ouz.etz = 2;
            AppMethodBeat.o(76530);
            return;
        }
        ouz.etz = 1;
        AppMethodBeat.o(76530);
    }
}
