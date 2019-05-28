package com.tencent.mm.plugin.voip_cs.b;

import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;

public final class a extends v2protocal {
    public int field_voipcsChannelInfoLength = 0;
    int field_voipcsEngineInfoLength = 0;
    public byte[] tcD = new byte[2048];
    byte[] tcE = new byte[2048];

    public a(ak akVar) {
        super(akVar);
        AppMethodBeat.i(135285);
        AppMethodBeat.o(135285);
    }

    public final String cMb() {
        AppMethodBeat.i(135286);
        getVoipcsEngineInfo(this.tcE, this.tcE.length);
        ab.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", Integer.valueOf(this.field_voipcsEngineInfoLength));
        String str = this.nwC + "," + this.nwv + "," + this.sTZ + "," + c.cMg().tdl + "," + this.sUm + "," + this.sUn + cKC() + new String(this.tcE, 0, this.field_voipcsEngineInfoLength);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
        AppMethodBeat.o(135286);
        return str;
    }

    public final int cMc() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(135287);
        this.netType = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
        this.sTX = this.netType;
        c.cMg().sTX = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z3 = this.sTX >= 4 && (cpuFlag0 & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (cpuFlag0 & 255) >= 30;
        if (q.etc.erv != 1 || q.etc.eqX.width < 480 || q.etc.eqX.height < v2helper.VOIP_ENC_HEIGHT_LV1 || q.etc.eqZ.width < 480 || q.etc.eqZ.height < v2helper.VOIP_ENC_HEIGHT_LV1) {
            z = false;
        } else {
            z = true;
        }
        if (q.etc.erv == 0) {
            z2 = true;
        }
        if ((z3 || z) && !z2) {
            this.defaultWidth = 480;
            this.defaultHeight = v2helper.VOIP_ENC_HEIGHT_LV1;
            sTV = true;
            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + VideoMaterialUtil.CRAZYFACE_X + this.defaultHeight);
        }
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z3 + ", bEnable480FromSvr:" + z + ", bDisable480FromSvr:" + z2);
        this.sUU = new int[(this.defaultWidth * this.defaultHeight)];
        g.RN();
        this.kIm = com.tencent.mm.kernel.a.QF();
        int i = VERSION.SDK_INT;
        int gLVersion = OpenGlRender.getGLVersion();
        Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int init = init(this.netType, 2, (this.defaultWidth << 16) | this.defaultHeight, (width << 16) | defaultDisplay.getHeight(), this.kIm, cpuFlag0 | ((gLVersion << 24) | (i << 16)), e.eSi + "lib/", 8);
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.CSV2protocal", "protocal init ret :" + init + ",uin= " + this.kIm);
        this.isInited = true;
        if (init < 0) {
            reset();
        }
        AppMethodBeat.o(135287);
        return init;
    }
}
