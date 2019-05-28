package com.tencent.p177mm.sdk.p604g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.sdk.g.b */
public class C4953b<R> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4953b.class.desiredAssertionStatus());
    /* renamed from: cS */
    private HashMap<String, LinkedList<R>> f1292cS = new HashMap();

    static {
        AppMethodBeat.m2504i(52529);
        AppMethodBeat.m2505o(52529);
    }

    public C4953b() {
        AppMethodBeat.m2504i(52523);
        AppMethodBeat.m2505o(52523);
    }

    /* renamed from: g */
    public final synchronized R mo10193g(R r, String str) {
        R r2;
        AppMethodBeat.m2504i(52524);
        m7356i(r, str);
        LinkedList linkedList = (LinkedList) this.f1292cS.get(str);
        if (linkedList == null || linkedList.size() <= 0) {
            r2 = null;
            AppMethodBeat.m2505o(52524);
        } else {
            r2 = linkedList.getFirst();
            AppMethodBeat.m2505o(52524);
        }
        return r2;
    }

    /* renamed from: h */
    public final synchronized boolean mo10194h(R r, String str) {
        boolean z;
        AppMethodBeat.m2504i(52525);
        AssertionError assertionError;
        if (!$assertionsDisabled && r == null) {
            assertionError = new AssertionError();
            AppMethodBeat.m2505o(52525);
            throw assertionError;
        } else if ($assertionsDisabled || !TextUtils.isEmpty(str)) {
            LinkedList linkedList;
            LinkedList linkedList2 = (LinkedList) this.f1292cS.get(str);
            if (linkedList2 == null) {
                HashMap hashMap = this.f1292cS;
                linkedList2 = new LinkedList();
                hashMap.put(str, linkedList2);
                linkedList = linkedList2;
            } else {
                linkedList = linkedList2;
            }
            z = linkedList.size() == 0;
            linkedList.add(r);
            AppMethodBeat.m2505o(52525);
        } else {
            assertionError = new AssertionError();
            AppMethodBeat.m2505o(52525);
            throw assertionError;
        }
        return z;
    }

    /* renamed from: i */
    private synchronized boolean m7356i(R r, String str) {
        boolean z;
        AppMethodBeat.m2504i(52526);
        if (r == null) {
            AppMethodBeat.m2505o(52526);
            z = false;
        } else {
            LinkedList linkedList = (LinkedList) this.f1292cS.get(str);
            if (linkedList != null) {
                boolean remove = linkedList.remove(r);
                if (remove && linkedList.size() == 0) {
                    this.f1292cS.remove(str);
                }
                AppMethodBeat.m2505o(52526);
                z = remove;
            } else {
                AppMethodBeat.m2505o(52526);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean remove(R r) {
        boolean z;
        AppMethodBeat.m2504i(52527);
        if (r == null) {
            AppMethodBeat.m2505o(52527);
            z = false;
        } else {
            Iterator it = this.f1292cS.values().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Iterator it2 = ((LinkedList) it.next()).iterator();
                Object obj = 1;
                while (it2.hasNext()) {
                    if (r == it2.next()) {
                        it2.remove();
                        z2 = true;
                    } else {
                        obj = null;
                    }
                }
                if (obj != null) {
                    it.remove();
                }
            }
            AppMethodBeat.m2505o(52527);
            z = z2;
        }
        return z;
    }

    public final synchronized LinkedList<R> anK(String str) {
        LinkedList<R> linkedList;
        AppMethodBeat.m2504i(52528);
        if (str == null || "".equals(str) || !this.f1292cS.containsKey(str)) {
            linkedList = new LinkedList();
            AppMethodBeat.m2505o(52528);
        } else {
            linkedList = (LinkedList) this.f1292cS.remove(str);
            AppMethodBeat.m2505o(52528);
        }
        return linkedList;
    }
}
