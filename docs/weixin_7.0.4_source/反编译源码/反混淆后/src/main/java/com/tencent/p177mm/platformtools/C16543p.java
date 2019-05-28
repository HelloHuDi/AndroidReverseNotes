package com.tencent.p177mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.platformtools.p */
public final class C16543p extends C9788d {
    public C16543p(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124560);
        C4990ab.m7416i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.m2505o(124560);
    }

    /* renamed from: b */
    public final boolean mo5703b(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124561);
        C4990ab.m7410d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124561);
        return true;
    }

    /* renamed from: c */
    public final boolean mo5704c(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124562);
        C4990ab.m7410d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124562);
        return true;
    }

    /* renamed from: d */
    public final boolean mo5705d(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124563);
        C4990ab.m7410d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124563);
        return true;
    }

    /* renamed from: e */
    public final boolean mo5706e(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124564);
        C4990ab.m7410d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124564);
        return true;
    }
}
