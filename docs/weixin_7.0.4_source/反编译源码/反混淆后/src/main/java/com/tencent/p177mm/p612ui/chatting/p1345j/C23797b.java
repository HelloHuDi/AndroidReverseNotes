package com.tencent.p177mm.p612ui.chatting.p1345j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.chatting.j.b */
public final class C23797b {
    public static final C23797b yZH = new C23797b();
    public int mCount;
    public int mSuccessCount;
    public int tVN;
    public int yZI;
    public int yZJ;
    public int yZK;

    static {
        AppMethodBeat.m2504i(32672);
        AppMethodBeat.m2505o(32672);
    }

    /* renamed from: c */
    public final void mo39621c(boolean z, boolean z2, String str) {
        AppMethodBeat.m2504i(32667);
        C4990ab.m7416i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + z + " isSuccess:" + z2 + " chatroomid:" + str);
        if (z) {
            this.yZI++;
        } else {
            this.yZJ++;
        }
        this.mCount++;
        if (z2) {
            this.mSuccessCount++;
            AppMethodBeat.m2505o(32667);
            return;
        }
        this.tVN++;
        AppMethodBeat.m2505o(32667);
    }

    /* renamed from: Pi */
    public final void mo39620Pi(int i) {
        this.yZK += i;
    }

    /* renamed from: ax */
    public static void m36635ax(String str, int i, int i2) {
        AppMethodBeat.m2504i(32668);
        C4990ab.m7417i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (i > 0) {
            C7053e.pXa.mo8378a(403, 67, 1, true);
            C7053e.pXa.mo8378a(403, 68, (long) i, true);
        }
        C7053e.pXa.mo8378a(403, 70, (long) i2, true);
        if (i2 <= 5) {
            C7053e.pXa.mo8378a(403, 71, 1, true);
            AppMethodBeat.m2505o(32668);
        } else if (i2 <= 10) {
            C7053e.pXa.mo8378a(403, 72, 1, true);
            AppMethodBeat.m2505o(32668);
        } else if (i2 <= 20) {
            C7053e.pXa.mo8378a(403, 73, 1, true);
            AppMethodBeat.m2505o(32668);
        } else if (i2 <= 30) {
            C7053e.pXa.mo8378a(403, 74, 1, true);
            AppMethodBeat.m2505o(32668);
        } else if (i2 <= 50) {
            C7053e.pXa.mo8378a(403, 75, 1, true);
            AppMethodBeat.m2505o(32668);
        } else {
            C7053e.pXa.mo8378a(403, 76, 1, true);
            AppMethodBeat.m2505o(32668);
        }
    }

    public static void dGX() {
        AppMethodBeat.m2504i(32669);
        C7053e.pXa.mo8378a(403, 77, 1, true);
        AppMethodBeat.m2505o(32669);
    }

    public static void dGY() {
        AppMethodBeat.m2504i(32670);
        C7053e.pXa.mo8378a(403, 41, 1, false);
        AppMethodBeat.m2505o(32670);
    }

    public static void dGZ() {
        AppMethodBeat.m2504i(32671);
        C7053e.pXa.mo8378a(403, 78, 1, false);
        AppMethodBeat.m2505o(32671);
    }
}
