package com.tencent.mm.sdk.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class b<R> {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private HashMap<String, LinkedList<R>> cS = new HashMap();

    static {
        AppMethodBeat.i(52529);
        AppMethodBeat.o(52529);
    }

    public b() {
        AppMethodBeat.i(52523);
        AppMethodBeat.o(52523);
    }

    public final synchronized R g(R r, String str) {
        R r2;
        AppMethodBeat.i(52524);
        i(r, str);
        LinkedList linkedList = (LinkedList) this.cS.get(str);
        if (linkedList == null || linkedList.size() <= 0) {
            r2 = null;
            AppMethodBeat.o(52524);
        } else {
            r2 = linkedList.getFirst();
            AppMethodBeat.o(52524);
        }
        return r2;
    }

    public final synchronized boolean h(R r, String str) {
        boolean z;
        AppMethodBeat.i(52525);
        AssertionError assertionError;
        if (!$assertionsDisabled && r == null) {
            assertionError = new AssertionError();
            AppMethodBeat.o(52525);
            throw assertionError;
        } else if ($assertionsDisabled || !TextUtils.isEmpty(str)) {
            LinkedList linkedList;
            LinkedList linkedList2 = (LinkedList) this.cS.get(str);
            if (linkedList2 == null) {
                HashMap hashMap = this.cS;
                linkedList2 = new LinkedList();
                hashMap.put(str, linkedList2);
                linkedList = linkedList2;
            } else {
                linkedList = linkedList2;
            }
            z = linkedList.size() == 0;
            linkedList.add(r);
            AppMethodBeat.o(52525);
        } else {
            assertionError = new AssertionError();
            AppMethodBeat.o(52525);
            throw assertionError;
        }
        return z;
    }

    private synchronized boolean i(R r, String str) {
        boolean z;
        AppMethodBeat.i(52526);
        if (r == null) {
            AppMethodBeat.o(52526);
            z = false;
        } else {
            LinkedList linkedList = (LinkedList) this.cS.get(str);
            if (linkedList != null) {
                boolean remove = linkedList.remove(r);
                if (remove && linkedList.size() == 0) {
                    this.cS.remove(str);
                }
                AppMethodBeat.o(52526);
                z = remove;
            } else {
                AppMethodBeat.o(52526);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean remove(R r) {
        boolean z;
        AppMethodBeat.i(52527);
        if (r == null) {
            AppMethodBeat.o(52527);
            z = false;
        } else {
            Iterator it = this.cS.values().iterator();
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
            AppMethodBeat.o(52527);
            z = z2;
        }
        return z;
    }

    public final synchronized LinkedList<R> anK(String str) {
        LinkedList<R> linkedList;
        AppMethodBeat.i(52528);
        if (str == null || "".equals(str) || !this.cS.containsKey(str)) {
            linkedList = new LinkedList();
            AppMethodBeat.o(52528);
        } else {
            linkedList = (LinkedList) this.cS.remove(str);
            AppMethodBeat.o(52528);
        }
        return linkedList;
    }
}
