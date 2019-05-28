package com.tencent.p177mm.plugin.ipcall.p438a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f */
public final class C46037f {
    private static Map<Integer, List<Integer>> nvy = new HashMap();
    public int mCurrentState = -1;

    /* renamed from: xg */
    public final boolean mo73930xg(int i) {
        AppMethodBeat.m2504i(21739);
        if (m85622xh(i)) {
            C4990ab.m7417i("MicroMsg.IPCallStateIndicator", "updateState, origin: %s, new: %s", C46037f.stateToString(this.mCurrentState), C46037f.stateToString(i));
            this.mCurrentState = i;
            AppMethodBeat.m2505o(21739);
            return true;
        }
        C4990ab.m7417i("MicroMsg.IPCallStateIndicator", "transform state error, origin state: %s, new state: %s", C46037f.stateToString(C21088i.bHu().mCurrentState), C46037f.stateToString(i));
        AppMethodBeat.m2505o(21739);
        return false;
    }

    public final boolean bHk() {
        return this.mCurrentState == 1 || this.mCurrentState == 3 || this.mCurrentState == 4 || this.mCurrentState == 5;
    }

    public final boolean bHl() {
        return this.mCurrentState == 4 || this.mCurrentState == 5;
    }

    public final boolean bHm() {
        return this.mCurrentState == 5;
    }

    public final boolean bHn() {
        return this.mCurrentState == 5;
    }

    /* renamed from: xh */
    private boolean m85622xh(int i) {
        AppMethodBeat.m2504i(21740);
        if (this.mCurrentState == -1) {
            AppMethodBeat.m2505o(21740);
            return true;
        } else if (nvy.containsKey(Integer.valueOf(this.mCurrentState)) && ((List) nvy.get(Integer.valueOf(this.mCurrentState))).contains(Integer.valueOf(i))) {
            AppMethodBeat.m2505o(21740);
            return true;
        } else {
            AppMethodBeat.m2505o(21740);
            return false;
        }
    }

    public static String stateToString(int i) {
        AppMethodBeat.m2504i(21741);
        String str;
        switch (i) {
            case -1:
                str = "RESET_STATE";
                AppMethodBeat.m2505o(21741);
                return str;
            case 1:
                str = "START_INVITE";
                AppMethodBeat.m2505o(21741);
                return str;
            case 2:
                str = "INVITE_FAILED";
                AppMethodBeat.m2505o(21741);
                return str;
            case 3:
                str = "INVITE_SUCCESS";
                AppMethodBeat.m2505o(21741);
                return str;
            case 4:
                str = "RING_ING";
                AppMethodBeat.m2505o(21741);
                return str;
            case 5:
                str = "USER_ACCEPT";
                AppMethodBeat.m2505o(21741);
                return str;
            case 8:
                str = "USER_CANCEL";
                AppMethodBeat.m2505o(21741);
                return str;
            case 9:
                str = "USER_SELF_SHUTDOWN";
                AppMethodBeat.m2505o(21741);
                return str;
            case 10:
                str = "OTHER_SIDE_USER_SHUTDOWN";
                AppMethodBeat.m2505o(21741);
                return str;
            case 11:
                str = "USER_SELF_SHUTDOWN_BY_ERR";
                AppMethodBeat.m2505o(21741);
                return str;
            case 12:
                str = "CANCEL_BY_ERR";
                AppMethodBeat.m2505o(21741);
                return str;
            default:
                str = String.valueOf(i);
                AppMethodBeat.m2505o(21741);
                return str;
        }
    }

    static {
        AppMethodBeat.m2504i(21742);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(3));
        arrayList.add(Integer.valueOf(2));
        arrayList.add(Integer.valueOf(8));
        arrayList.add(Integer.valueOf(12));
        nvy.put(Integer.valueOf(1), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(12));
        arrayList.add(Integer.valueOf(8));
        nvy.put(Integer.valueOf(2), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(4));
        arrayList.add(Integer.valueOf(5));
        arrayList.add(Integer.valueOf(8));
        arrayList.add(Integer.valueOf(12));
        nvy.put(Integer.valueOf(3), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(5));
        arrayList.add(Integer.valueOf(8));
        arrayList.add(Integer.valueOf(12));
        nvy.put(Integer.valueOf(4), arrayList);
        arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(9));
        arrayList.add(Integer.valueOf(10));
        arrayList.add(Integer.valueOf(11));
        nvy.put(Integer.valueOf(5), arrayList);
        AppMethodBeat.m2505o(21742);
    }
}
