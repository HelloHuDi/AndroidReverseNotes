package com.tencent.p177mm.plugin.voip_cs.p547b;

import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.a */
public final class C43746a extends v2protocal {
    public int field_voipcsChannelInfoLength = 0;
    int field_voipcsEngineInfoLength = 0;
    public byte[] tcD = new byte[2048];
    byte[] tcE = new byte[2048];

    public C43746a(C7306ak c7306ak) {
        super(c7306ak);
        AppMethodBeat.m2504i(135285);
        AppMethodBeat.m2505o(135285);
    }

    public final String cMb() {
        AppMethodBeat.m2504i(135286);
        getVoipcsEngineInfo(this.tcE, this.tcE.length);
        C4990ab.m7411d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", Integer.valueOf(this.field_voipcsEngineInfoLength));
        String str = this.nwC + "," + this.nwv + "," + this.sTZ + "," + C43749c.cMg().tdl + "," + this.sUm + "," + this.sUn + cKC() + new String(this.tcE, 0, this.field_voipcsEngineInfoLength);
        C46317a.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(135286);
        return str;
    }

    public final int cMc() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(135287);
        this.netType = C46317a.getNetType(C4996ah.getContext());
        this.sTX = this.netType;
        C43749c.cMg().sTX = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z3 = this.sTX >= 4 && (cpuFlag0 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (cpuFlag0 & 255) >= 30;
        if (C1427q.etc.erv != 1 || C1427q.etc.eqX.width < 480 || C1427q.etc.eqX.height < v2helper.VOIP_ENC_HEIGHT_LV1 || C1427q.etc.eqZ.width < 480 || C1427q.etc.eqZ.height < v2helper.VOIP_ENC_HEIGHT_LV1) {
            z = false;
        } else {
            z = true;
        }
        if (C1427q.etc.erv == 0) {
            z2 = true;
        }
        if ((z3 || z) && !z2) {
            this.defaultWidth = 480;
            this.defaultHeight = v2helper.VOIP_ENC_HEIGHT_LV1;
            sTV = true;
            C46317a.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + VideoMaterialUtil.CRAZYFACE_X + this.defaultHeight);
        }
        C46317a.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z3 + ", bEnable480FromSvr:" + z + ", bDisable480FromSvr:" + z2);
        this.sUU = new int[(this.defaultWidth * this.defaultHeight)];
        C1720g.m3534RN();
        this.kIm = C1668a.m3383QF();
        int i = VERSION.SDK_INT;
        int gLVersion = OpenGlRender.getGLVersion();
        Display defaultDisplay = ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int init = init(this.netType, 2, (this.defaultWidth << 16) | this.defaultHeight, (width << 16) | defaultDisplay.getHeight(), this.kIm, cpuFlag0 | ((gLVersion << 24) | (i << 16)), C6457e.eSi + "lib/", 8);
        C46317a.Logd("MicroMsg.CSV2protocal", "protocal init ret :" + init + ",uin= " + this.kIm);
        this.isInited = true;
        if (init < 0) {
            reset();
        }
        AppMethodBeat.m2505o(135287);
        return init;
    }
}
