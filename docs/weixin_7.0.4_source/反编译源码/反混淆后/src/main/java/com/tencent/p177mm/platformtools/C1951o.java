package com.tencent.p177mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.platformtools.o */
public final class C1951o extends C9788d {
    public C1951o(Activity activity) {
        super(activity);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124555);
        C4990ab.m7416i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        AppMethodBeat.m2505o(124555);
    }

    /* renamed from: b */
    public final boolean mo5703b(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124556);
        C4990ab.m7410d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124556);
        return true;
    }

    /* renamed from: c */
    public final boolean mo5704c(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124557);
        C4990ab.m7410d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124557);
        return true;
    }

    /* renamed from: d */
    public final boolean mo5705d(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124558);
        C4990ab.m7410d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124558);
        return true;
    }

    /* renamed from: e */
    public final boolean mo5706e(C45475ag c45475ag) {
        AppMethodBeat.m2504i(124559);
        C4990ab.m7410d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, c45475ag.content, 0).show();
        AppMethodBeat.m2505o(124559);
        return true;
    }
}
