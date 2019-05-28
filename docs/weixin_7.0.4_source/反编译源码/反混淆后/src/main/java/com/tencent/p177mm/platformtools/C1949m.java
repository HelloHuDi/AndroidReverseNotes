package com.tencent.p177mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.platformtools.m */
public final class C1949m extends C9788d {
    public C1949m(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124545);
        C4990ab.m7416i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.m2505o(124545);
    }

    /* renamed from: b */
    public final boolean mo5703b(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124546);
        C4990ab.m7410d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124546);
        return true;
    }

    /* renamed from: c */
    public final boolean mo5704c(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124547);
        C4990ab.m7410d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124547);
        return true;
    }

    /* renamed from: d */
    public final boolean mo5705d(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124548);
        C4990ab.m7410d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124548);
        return true;
    }

    /* renamed from: e */
    public final boolean mo5706e(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124549);
        C4990ab.m7410d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124549);
        return true;
    }
}
