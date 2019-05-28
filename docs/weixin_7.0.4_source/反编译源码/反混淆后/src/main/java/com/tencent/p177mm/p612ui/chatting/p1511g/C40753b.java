package com.tencent.p177mm.p612ui.chatting.p1511g;

import android.content.Context;
import android.content.Intent;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.BaseChattingUIFragment;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.p842bp.C25985d.C25988b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

/* renamed from: com.tencent.mm.ui.chatting.g.b */
public final class C40753b implements C25988b {
    private static WeakHashMap<Fragment, HashMap<Integer, C25987a>> yYM = new WeakHashMap();
    private WeakReference<C46650a> yYN;

    static {
        AppMethodBeat.m2504i(32501);
        AppMethodBeat.m2505o(32501);
    }

    public C40753b(C46650a c46650a) {
        AppMethodBeat.m2504i(32495);
        this.yYN = new WeakReference(c46650a);
        AppMethodBeat.m2505o(32495);
    }

    /* renamed from: b */
    public static C25987a m70466b(Fragment fragment, int i) {
        AppMethodBeat.m2504i(32496);
        HashMap hashMap = (HashMap) yYM.get(fragment);
        if (hashMap != null) {
            C25987a c25987a = (C25987a) hashMap.remove(Integer.valueOf(i));
            AppMethodBeat.m2505o(32496);
            return c25987a;
        }
        AppMethodBeat.m2505o(32496);
        return null;
    }

    /* renamed from: a */
    private static void m70465a(Fragment fragment, int i, C25987a c25987a) {
        AppMethodBeat.m2504i(32497);
        HashMap hashMap = (HashMap) yYM.get(fragment);
        if (hashMap == null) {
            hashMap = new HashMap();
            yYM.put(fragment, hashMap);
        }
        hashMap.put(Integer.valueOf(i), c25987a);
        AppMethodBeat.m2505o(32497);
    }

    public final Fragment getFragment() {
        AppMethodBeat.m2504i(32498);
        C46650a c46650a = (C46650a) this.yYN.get();
        if (c46650a != null) {
            BaseChattingUIFragment baseChattingUIFragment = c46650a.yTx;
            AppMethodBeat.m2505o(32498);
            return baseChattingUIFragment;
        }
        AppMethodBeat.m2505o(32498);
        return null;
    }

    /* renamed from: a */
    public final void mo43869a(Intent intent, int i, C25987a c25987a) {
        AppMethodBeat.m2504i(32499);
        Fragment fragment = getFragment();
        if (fragment == null) {
            AppMethodBeat.m2505o(32499);
            return;
        }
        C40753b.m70465a(fragment, i, c25987a);
        fragment.startActivityForResult(intent, i);
        AppMethodBeat.m2505o(32499);
    }

    public final Context getContext() {
        AppMethodBeat.m2504i(32500);
        FragmentActivity activity = getFragment().getActivity();
        AppMethodBeat.m2505o(32500);
        return activity;
    }
}
