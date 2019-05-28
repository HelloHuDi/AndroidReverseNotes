package com.tencent.p177mm.vending.p638d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.vending.d.b */
public final class C5683b<T> {
    /* renamed from: a */
    private volatile List<T> f1342a;

    /* renamed from: com.tencent.mm.vending.d.b$a */
    public static final class C5682a<T> {
        /* renamed from: a */
        private ArrayList<T> f1341a = new ArrayList();

        public C5682a() {
            AppMethodBeat.m2504i(126074);
            AppMethodBeat.m2505o(126074);
        }

        /* renamed from: a */
        private void m8533a() {
            AppMethodBeat.m2504i(126075);
            if (this.f1341a == null) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                AppMethodBeat.m2505o(126075);
                throw illegalAccessError;
            }
            AppMethodBeat.m2505o(126075);
        }

        /* renamed from: A */
        public final C5682a<T> mo11571A(T... tArr) {
            AppMethodBeat.m2504i(126076);
            m8533a();
            for (int i = 0; i <= 0; i++) {
                this.f1341a.add(tArr[0]);
            }
            AppMethodBeat.m2505o(126076);
            return this;
        }

        public final C5683b<T> dMh() {
            AppMethodBeat.m2504i(126077);
            m8533a();
            ArrayList arrayList = this.f1341a;
            this.f1341a = null;
            C5683b c5683b = new C5683b(arrayList, (byte) 0);
            AppMethodBeat.m2505o(126077);
            return c5683b;
        }
    }

    /* synthetic */ C5683b(List list, byte b) {
        this(list);
    }

    private C5683b(List list) {
        this.f1342a = list;
    }

    public final int size() {
        AppMethodBeat.m2504i(126072);
        int size = this.f1342a.size();
        AppMethodBeat.m2505o(126072);
        return size;
    }

    public final T get(int i) {
        AppMethodBeat.m2504i(126073);
        Object obj = this.f1342a.get(i);
        AppMethodBeat.m2505o(126073);
        return obj;
    }
}
