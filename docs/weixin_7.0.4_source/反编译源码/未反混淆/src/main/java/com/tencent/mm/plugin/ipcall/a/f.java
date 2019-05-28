package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f {
    private static Map<Integer, List<Integer>> nvy = new HashMap();
    public int mCurrentState = -1;

    public final boolean xg(int i) {
        AppMethodBeat.i(21739);
        if (xh(i)) {
            ab.i("MicroMsg.IPCallStateIndicator", "updateState, origin: %s, new: %s", stateToString(this.mCurrentState), stateToString(i));
            this.mCurrentState = i;
            AppMethodBeat.o(21739);
            return true;
        }
        ab.i("MicroMsg.IPCallStateIndicator", "transform state error, origin state: %s, new state: %s", stateToString(i.bHu().mCurrentState), stateToString(i));
        AppMethodBeat.o(21739);
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

    private boolean xh(int i) {
        AppMethodBeat.i(21740);
        if (this.mCurrentState == -1) {
            AppMethodBeat.o(21740);
            return true;
        } else if (nvy.containsKey(Integer.valueOf(this.mCurrentState)) && ((List) nvy.get(Integer.valueOf(this.mCurrentState))).contains(Integer.valueOf(i))) {
            AppMethodBeat.o(21740);
            return true;
        } else {
            AppMethodBeat.o(21740);
            return false;
        }
    }

    public static String stateToString(int i) {
        AppMethodBeat.i(21741);
        String str;
        switch (i) {
            case -1:
                str = "RESET_STATE";
                AppMethodBeat.o(21741);
                return str;
            case 1:
                str = "START_INVITE";
                AppMethodBeat.o(21741);
                return str;
            case 2:
                str = "INVITE_FAILED";
                AppMethodBeat.o(21741);
                return str;
            case 3:
                str = "INVITE_SUCCESS";
                AppMethodBeat.o(21741);
                return str;
            case 4:
                str = "RING_ING";
                AppMethodBeat.o(21741);
                return str;
            case 5:
                str = "USER_ACCEPT";
                AppMethodBeat.o(21741);
                return str;
            case 8:
                str = "USER_CANCEL";
                AppMethodBeat.o(21741);
                return str;
            case 9:
                str = "USER_SELF_SHUTDOWN";
                AppMethodBeat.o(21741);
                return str;
            case 10:
                str = "OTHER_SIDE_USER_SHUTDOWN";
                AppMethodBeat.o(21741);
                return str;
            case 11:
                str = "USER_SELF_SHUTDOWN_BY_ERR";
                AppMethodBeat.o(21741);
                return str;
            case 12:
                str = "CANCEL_BY_ERR";
                AppMethodBeat.o(21741);
                return str;
            default:
                str = String.valueOf(i);
                AppMethodBeat.o(21741);
                return str;
        }
    }

    static {
        AppMethodBeat.i(21742);
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
        AppMethodBeat.o(21742);
    }
}
