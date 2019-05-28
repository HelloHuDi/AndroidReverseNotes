package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b implements com.tencent.mm.bp.d.b {
    private static WeakHashMap<Fragment, HashMap<Integer, a>> yYM = new WeakHashMap();
    private WeakReference<com.tencent.mm.ui.chatting.d.a> yYN;

    static {
        AppMethodBeat.i(32501);
        AppMethodBeat.o(32501);
    }

    public b(com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(32495);
        this.yYN = new WeakReference(aVar);
        AppMethodBeat.o(32495);
    }

    public static a b(Fragment fragment, int i) {
        AppMethodBeat.i(32496);
        HashMap hashMap = (HashMap) yYM.get(fragment);
        if (hashMap != null) {
            a aVar = (a) hashMap.remove(Integer.valueOf(i));
            AppMethodBeat.o(32496);
            return aVar;
        }
        AppMethodBeat.o(32496);
        return null;
    }

    private static void a(Fragment fragment, int i, a aVar) {
        AppMethodBeat.i(32497);
        HashMap hashMap = (HashMap) yYM.get(fragment);
        if (hashMap == null) {
            hashMap = new HashMap();
            yYM.put(fragment, hashMap);
        }
        hashMap.put(Integer.valueOf(i), aVar);
        AppMethodBeat.o(32497);
    }

    public final Fragment getFragment() {
        AppMethodBeat.i(32498);
        com.tencent.mm.ui.chatting.d.a aVar = (com.tencent.mm.ui.chatting.d.a) this.yYN.get();
        if (aVar != null) {
            BaseChattingUIFragment baseChattingUIFragment = aVar.yTx;
            AppMethodBeat.o(32498);
            return baseChattingUIFragment;
        }
        AppMethodBeat.o(32498);
        return null;
    }

    public final void a(Intent intent, int i, a aVar) {
        AppMethodBeat.i(32499);
        Fragment fragment = getFragment();
        if (fragment == null) {
            AppMethodBeat.o(32499);
            return;
        }
        a(fragment, i, aVar);
        fragment.startActivityForResult(intent, i);
        AppMethodBeat.o(32499);
    }

    public final Context getContext() {
        AppMethodBeat.i(32500);
        FragmentActivity activity = getFragment().getActivity();
        AppMethodBeat.o(32500);
        return activity;
    }
}
