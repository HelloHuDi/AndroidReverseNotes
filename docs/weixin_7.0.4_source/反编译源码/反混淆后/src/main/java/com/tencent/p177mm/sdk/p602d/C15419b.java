package com.tencent.p177mm.sdk.p602d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.Serializable;

/* renamed from: com.tencent.mm.sdk.d.b */
public class C15419b extends C7292c implements Serializable {
    public final String name = getClass().getSimpleName();

    public C15419b() {
        AppMethodBeat.m2504i(52444);
        AppMethodBeat.m2505o(52444);
    }

    public void enter() {
        AppMethodBeat.m2504i(52445);
        super.enter();
        C4990ab.m7416i("LogStateTransitionState", "entering " + this.name);
        AppMethodBeat.m2505o(52445);
    }

    public void exit() {
        AppMethodBeat.m2504i(52446);
        super.exit();
        C4990ab.m7416i("LogStateTransitionState", "exiting " + this.name);
        AppMethodBeat.m2505o(52446);
    }
}
