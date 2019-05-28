package com.tencent.mm.vending.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b<T> {
    private volatile List<T> a;

    public static final class a<T> {
        private ArrayList<T> a = new ArrayList();

        public a() {
            AppMethodBeat.i(126074);
            AppMethodBeat.o(126074);
        }

        private void a() {
            AppMethodBeat.i(126075);
            if (this.a == null) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                AppMethodBeat.o(126075);
                throw illegalAccessError;
            }
            AppMethodBeat.o(126075);
        }

        public final a<T> A(T... tArr) {
            AppMethodBeat.i(126076);
            a();
            for (int i = 0; i <= 0; i++) {
                this.a.add(tArr[0]);
            }
            AppMethodBeat.o(126076);
            return this;
        }

        public final b<T> dMh() {
            AppMethodBeat.i(126077);
            a();
            ArrayList arrayList = this.a;
            this.a = null;
            b bVar = new b(arrayList, (byte) 0);
            AppMethodBeat.o(126077);
            return bVar;
        }
    }

    /* synthetic */ b(List list, byte b) {
        this(list);
    }

    private b(List list) {
        this.a = list;
    }

    public final int size() {
        AppMethodBeat.i(126072);
        int size = this.a.size();
        AppMethodBeat.o(126072);
        return size;
    }

    public final T get(int i) {
        AppMethodBeat.i(126073);
        Object obj = this.a.get(i);
        AppMethodBeat.o(126073);
        return obj;
    }
}
