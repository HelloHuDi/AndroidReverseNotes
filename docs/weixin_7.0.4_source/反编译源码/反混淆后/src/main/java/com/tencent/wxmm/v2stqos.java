package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class v2stqos {
    private static final String TAG = "WXMM.Voip[stqos]";
    public byte cFps;
    public byte cHPPMaxLyr;
    public byte cIPeriod;
    public byte cIReqFlag;
    public byte cQPmax;
    public byte cQPmin;
    public byte cRSLevel;
    public byte cResolution;
    public byte cRsvd1;
    public byte cRsvd2;
    public byte cSkipFlag;
    public byte cSwitch;
    public short iKbps;
    public byte[] s2p = new byte[14];

    public v2stqos() {
        AppMethodBeat.m2504i(35429);
        AppMethodBeat.m2505o(35429);
    }

    public void parseS2PData() {
        AppMethodBeat.m2504i(35430);
        ByteBuffer wrap = ByteBuffer.wrap(this.s2p);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.iKbps = wrap.getShort();
        this.cFps = wrap.get();
        this.cIPeriod = wrap.get();
        this.cRSLevel = wrap.get();
        this.cQPmin = wrap.get();
        this.cQPmax = wrap.get();
        this.cHPPMaxLyr = wrap.get();
        this.cSwitch = wrap.get();
        this.cResolution = wrap.get();
        this.cRsvd1 = wrap.get();
        this.cRsvd2 = wrap.get();
        this.cSkipFlag = wrap.get();
        this.cIReqFlag = wrap.get();
        AppMethodBeat.m2505o(35430);
    }

    public void printS2P() {
        AppMethodBeat.m2504i(35431);
        new StringBuilder("raw S2P:").append(this.s2p);
        new StringBuilder("-S2P- iKbps:").append(this.iKbps).append(", fps:").append(this.cFps).append(", IP:").append(this.cIPeriod).append(", RS:").append(this.cRSLevel).append(", QPMin:").append(this.cQPmin).append(", QPMax:").append(this.cQPmax).append(", HPP:").append(this.cHPPMaxLyr).append(", SWitch:").append(this.cSwitch).append(", Reso:").append(this.cResolution).append(", Rsvd1:").append(this.cRsvd1).append(", Rsvd2:").append(this.cRsvd2).append(", Skip:").append(this.cSkipFlag).append(", IReq:").append(this.cIReqFlag);
        AppMethodBeat.m2505o(35431);
    }
}
