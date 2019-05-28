package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.protocal.protobuf.C44189xe;
import com.tencent.p177mm.protocal.protobuf.C44190xf;
import com.tencent.p177mm.protocal.protobuf.bbx;

/* renamed from: com.tencent.mm.plugin.setting.model.k */
public final class C34848k extends C3463b {
    private bbx qjJ;

    public C34848k(boolean z, int i, int i2) {
        int i3 = 1;
        super(31);
        AppMethodBeat.m2504i(126861);
        this.qjJ = new bbx();
        C44189xe c44189xe = new C44189xe();
        c44189xe.wcX = z ? 1 : 0;
        if (z) {
            i3 = 0;
        }
        c44189xe.wcZ = i3;
        C44190xf c44190xf = new C44190xf();
        c44190xf.wdb = i;
        c44190xf.wdc = i2;
        c44189xe.wcY = c44190xf;
        c44190xf.wdb = 0;
        c44190xf.wdc = 0;
        c44189xe.wda = c44190xf;
        this.qjJ.wGB = c44189xe;
        this.oqT = this.qjJ;
        AppMethodBeat.m2505o(126861);
    }

    public C34848k() {
        this(false, 22, 8);
    }
}
