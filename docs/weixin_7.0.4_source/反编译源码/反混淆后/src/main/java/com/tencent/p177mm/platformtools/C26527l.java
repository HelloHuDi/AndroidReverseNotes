package com.tencent.p177mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.platformtools.l */
public final class C26527l extends C9788d {
    public C26527l(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124540);
        C4990ab.m7416i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.m2505o(124540);
    }

    /* renamed from: b */
    public final boolean mo5703b(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124541);
        C4990ab.m7410d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124541);
        return true;
    }

    /* renamed from: c */
    public final boolean mo5704c(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124542);
        C4990ab.m7410d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124542);
        return true;
    }

    /* renamed from: d */
    public final boolean mo5705d(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124543);
        C4990ab.m7410d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124543);
        return true;
    }

    /* renamed from: e */
    public final boolean mo5706e(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124544);
        C4990ab.m7410d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124544);
        return true;
    }
}
