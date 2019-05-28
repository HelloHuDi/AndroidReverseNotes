package com.tencent.p177mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.platformtools.n */
public final class C1950n extends C9788d {
    public C1950n(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124550);
        C4990ab.m7416i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.m2505o(124550);
    }

    /* renamed from: b */
    public final boolean mo5703b(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124551);
        C4990ab.m7410d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124551);
        return true;
    }

    /* renamed from: c */
    public final boolean mo5704c(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124552);
        C4990ab.m7410d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124552);
        return true;
    }

    /* renamed from: d */
    public final boolean mo5705d(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124553);
        C4990ab.m7410d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124553);
        return true;
    }

    /* renamed from: e */
    public final boolean mo5706e(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124554);
        C4990ab.m7410d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124554);
        return true;
    }
}
