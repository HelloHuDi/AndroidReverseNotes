package com.tencent.p177mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C1430v;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.C39388g.C39389b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.mmsight.model.j */
public final class C12563j {
    static int fXT;
    static double ouA;
    public static boolean ouw = true;
    public static boolean oux = false;
    public static boolean ouy = false;
    public static C34551o ouz;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.j$a */
    public enum C12565a {
        MMSightCameraConfig,
        MMStoryCameraConfig;

        static {
            AppMethodBeat.m2505o(76525);
        }
    }

    /* renamed from: d */
    public static boolean m20500d(Point point) {
        AppMethodBeat.m2504i(76526);
        if (oux) {
            Context context = C4996ah.getContext();
            Resources resources = C4996ah.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = ouz == null ? "" : Integer.valueOf(ouz.ouK);
            C23639t.makeText(context, resources.getString(C25738R.string.cda, objArr), 1).show();
            AppMethodBeat.m2505o(76526);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", Integer.valueOf(C1427q.etj.etz), Integer.valueOf(C1427q.etj.etG), Boolean.valueOf(ouy));
        if (ouy) {
            AppMethodBeat.m2505o(76526);
            return false;
        } else if (C1427q.etj.etz != -1) {
            AppMethodBeat.m2505o(76526);
            return true;
        } else if (ouz != null && 1 == ouz.etz) {
            AppMethodBeat.m2505o(76526);
            return true;
        } else if (point == null) {
            AppMethodBeat.m2505o(76526);
            return false;
        } else if (C3475d.m5786yO(point.x) && C3475d.m5786yO(point.y)) {
            AppMethodBeat.m2505o(76526);
            return true;
        } else {
            if (ouz != null) {
                C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", point.toString());
                ouz.etz = 1;
            }
            AppMethodBeat.m2505o(76526);
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
    /* renamed from: a */
    public static void m20497a(Parameters parameters, boolean z) {
        AppMethodBeat.m2504i(76527);
        if (oux) {
            Context context = C4996ah.getContext();
            Resources resources = C4996ah.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = ouz == null ? "" : Integer.valueOf(ouz.ouK);
            C23639t.makeText(context, resources.getString(C25738R.string.cda, objArr), 1).show();
            AppMethodBeat.m2505o(76527);
            return;
        }
        C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", Integer.valueOf(C1427q.etj.etG), Boolean.valueOf(ouy));
        if (ouy) {
            AppMethodBeat.m2505o(76527);
            return;
        }
        C34551o c34551o;
        Point bPg = C3475d.bPg();
        int i = C5046bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
        C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", Integer.valueOf(i), Integer.valueOf(C5046bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19)), Integer.valueOf(C5046bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19)));
        if (C1427q.etj.etF == -1 || (C1427q.etj.etF & 1) != 0) {
            if (C1427q.etj.etF != -1 && (C1427q.etj.etF & 1) != 0) {
                ouz.bPG().ouM = true;
                i = 1;
                if (C1427q.etj.etA != -1) {
                }
                if (C1427q.etj.etF == -1) {
                }
                c34551o = ouz;
                c34551o.ouP = C39388g.m67218a(parameters, C3475d.bPg(), 720, z);
                if (c34551o.ouP != null) {
                }
                i = 0;
                if (i != 0) {
                }
                ouz.ouK = -1;
                C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", ouz.toString());
                AppMethodBeat.m2505o(76527);
            } else if (C1443d.m3068iW(r3) && fXT >= 512 && ouA >= 1725.0d && Math.min(bPg.x, bPg.y) >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                c34551o = ouz;
                c34551o.ouP = C39388g.m67218a(parameters, C3475d.bPg(), c34551o.fcY.width * 2, z);
                if (c34551o.ouP == null || c34551o.ouP.oum == null) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    ouz.bPG().ouM = true;
                    i = 1;
                    if (C1427q.etj.etA != -1) {
                        boolean z2;
                        C34551o c34551o2 = ouz;
                        if (C1427q.etj.etA == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        c34551o2.ouL = z2;
                    } else {
                        ouz.ouL = false;
                    }
                    if (C1427q.etj.etF == -1 || (C1427q.etj.etF & 2) != 0) {
                        if (C1427q.etj.etF == -1 && (C1427q.etj.etF & 2) != 0) {
                            c34551o = ouz.bPE();
                            c34551o.ouM = false;
                            c34551o.bPF();
                        } else if (i == 0 && C1443d.m3068iW(r5) && fXT >= 512 && ouA >= 1725.0d && Math.min(bPg.x, bPg.y) >= 720) {
                            c34551o = ouz;
                            c34551o.ouP = C39388g.m67218a(parameters, C3475d.bPg(), 720, z);
                            if (c34551o.ouP != null || c34551o.ouP.oum == null) {
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
                    C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", ouz.toString());
                    AppMethodBeat.m2505o(76527);
                }
            }
        }
        i = 0;
        if (C1427q.etj.etA != -1) {
        }
        if (C1427q.etj.etF == -1) {
        }
        c34551o = ouz;
        c34551o.ouP = C39388g.m67218a(parameters, C3475d.bPg(), 720, z);
        if (c34551o.ouP != null) {
        }
        i = 0;
        if (i != 0) {
        }
        ouz.ouK = -1;
        C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", ouz.toString());
        AppMethodBeat.m2505o(76527);
    }

    /* renamed from: c */
    public static void m20499c(VideoTransPara videoTransPara) {
        int i;
        int i2;
        boolean z = true;
        AppMethodBeat.m2504i(76528);
        C12565a c12565a = C12565a.MMSightCameraConfig;
        oux = false;
        ouy = false;
        fXT = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        ouA = (double) C3475d.m5782ev(C4996ah.getContext());
        String dut = C7574bs.dut();
        C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", Integer.valueOf(C5046bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19)));
        if (CaptureMMProxy.getInstance() != null) {
            C1427q.m3050ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", Integer.valueOf(fXT), Double.valueOf(ouA), dut, C1427q.etj);
        if (CaptureMMProxy.getInstance() != null) {
            i = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, -1);
            i2 = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, 1);
        } else {
            i2 = 1;
            i = -1;
        }
        C34551o a = C34551o.m56645a(i, videoTransPara);
        ouz = a;
        if (a != null) {
            ouz.ouN = i2 == 1;
            oux = true;
            Context context = C4996ah.getContext();
            Resources resources = C4996ah.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = ouz == null ? "" : Integer.valueOf(ouz.ouK);
            C23639t.makeText(context, resources.getString(C25738R.string.cda, objArr), 1).show();
            AppMethodBeat.m2505o(76528);
            return;
        }
        switch (c12565a) {
            case MMStoryCameraConfig:
                C1430v c1430v = C1427q.etk;
                i = 12;
                break;
            default:
                i = C1427q.etj.etG;
                break;
        }
        C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", Integer.valueOf(i));
        if (i != -1) {
            ouz = C34551o.m56645a(i, videoTransPara);
        }
        if (ouz != null) {
            if (i2 == 1) {
                ouz.ouN = true;
            } else {
                ouz.ouN = false;
            }
            ouy = true;
            AppMethodBeat.m2505o(76528);
            return;
        }
        ouz = C34551o.m56645a(1, videoTransPara);
        if (i2 == 1) {
            ouz.ouN = true;
        } else {
            ouz.ouN = false;
        }
        if (C1427q.etj.etz != -1) {
            ouz.etz = C1427q.etj.etz;
        } else if (C1443d.m3068iW(r6)) {
            ouz.etz = 2;
        } else {
            ouz.etz = 1;
        }
        if (C1427q.etj.etC != -1) {
            ouw = C1427q.etj.etC == 1;
        }
        if (C1427q.etj.etA != -1) {
            C34551o c34551o = ouz;
            if (C1427q.etj.etA != 1) {
                z = false;
            }
            c34551o.ouL = z;
            AppMethodBeat.m2505o(76528);
            return;
        }
        ouz.ouL = false;
        AppMethodBeat.m2505o(76528);
    }

    /* renamed from: a */
    public static void m20498a(C39389b c39389b) {
        AppMethodBeat.m2504i(76529);
        if (c39389b.oum == null) {
            C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", c39389b.toString());
            c39389b.oum = c39389b.oup;
            c39389b.oun = c39389b.ouq;
            c39389b.ouo = c39389b.our;
            if (Math.min(c39389b.oun.y, c39389b.oun.x) >= ouz.fcY.width + 16) {
                ouz.bPF();
                ouz.ouM = false;
                ouz.ouL = false;
                C4990ab.m7417i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", c39389b.toString());
            }
        }
        AppMethodBeat.m2505o(76529);
    }

    public static void bPw() {
        AppMethodBeat.m2504i(76530);
        C4990ab.m7416i("MicroMsg.MMSightRecorderConfig", "initSimple");
        C34551o c34551o = new C34551o();
        ouz = c34551o;
        c34551o.ouL = false;
        ouz.ouM = false;
        if (C1443d.m3068iW(19)) {
            ouz.etz = 2;
            AppMethodBeat.m2505o(76530);
            return;
        }
        ouz.etz = 1;
        AppMethodBeat.m2505o(76530);
    }
}
