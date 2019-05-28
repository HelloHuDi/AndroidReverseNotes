package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;

/* renamed from: com.tencent.wecall.talkroom.model.i */
public final class C41113i {
    public int ALh;
    public int ALi;
    public int ALj;
    public int ALk;
    public int ALl;
    public int ALm;
    public int ALn;
    public int ALo;
    public int ALp;
    public int AlQ;
    public int mHeight;
    public int mWidth;

    public C41113i(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        AppMethodBeat.m2504i(128000);
        this.ALh = i;
        this.mWidth = i2;
        this.mHeight = i3;
        this.ALi = i4;
        this.ALj = i5;
        this.ALk = i6;
        this.ALl = i7;
        this.AlQ = i8;
        this.ALm = i9;
        this.ALn = i10;
        this.ALo = i11;
        this.ALp = i12;
        C44443c.m80389d("VoiceEngineConf", "mDisableVideo: ", Integer.valueOf(i), " mWidth: ", Integer.valueOf(i2), " mHeight: ", Integer.valueOf(i3), " mInFPS: ", Integer.valueOf(i4), " mOutFmt: ", Integer.valueOf(i5), " mOSType: ", Integer.valueOf(i6), " mNetKbps: ", Integer.valueOf(i7), " mNetType: ", Integer.valueOf(i8), " mMTUSize: ", Integer.valueOf(i9), " mCPUFlag: ", Integer.valueOf(i10), " mDispRate: ", Integer.valueOf(i11), " mVCodecType: ", Integer.valueOf(i12));
        AppMethodBeat.m2505o(128000);
    }
}
