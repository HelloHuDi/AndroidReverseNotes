package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.mg */
public final class C44537mg implements C24417lz {
    /* renamed from: a */
    private LinkedList<C24417lz> f17490a;
    /* renamed from: b */
    private volatile boolean f17491b;
    /* renamed from: c */
    private final ReentrantLock f17492c = new ReentrantLock();

    public C44537mg() {
        AppMethodBeat.m2504i(100505);
        AppMethodBeat.m2505o(100505);
    }

    /* renamed from: a */
    public final boolean mo70931a() {
        return this.f17491b;
    }

    /* renamed from: b */
    public final void mo12543b() {
        AppMethodBeat.m2504i(100506);
        if (!this.f17491b) {
            this.f17492c.lock();
            try {
                if (!this.f17491b) {
                    this.f17491b = true;
                    LinkedList linkedList = this.f17490a;
                    this.f17490a = null;
                    this.f17492c.unlock();
                    C44537mg.m80841a(linkedList);
                } else {
                    return;
                }
            } finally {
                this.f17492c.unlock();
                AppMethodBeat.m2505o(100506);
            }
        }
        AppMethodBeat.m2505o(100506);
    }

    /* renamed from: a */
    private static void m80841a(Collection<C24417lz> collection) {
        AppMethodBeat.m2504i(100507);
        if (collection == null) {
            AppMethodBeat.m2505o(100507);
            return;
        }
        List list = null;
        for (C24417lz b : collection) {
            try {
                b.mo12543b();
            } catch (Throwable th) {
                List arrayList;
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = list;
                }
                arrayList.add(th);
                list = arrayList;
            }
        }
        C41077mb.m71479a(list);
        AppMethodBeat.m2505o(100507);
    }
}
