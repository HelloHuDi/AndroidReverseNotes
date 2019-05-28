package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzw implements Continuation<Void, List<TResult>> {
    private final /* synthetic */ Collection zzagk;

    zzw(Collection collection) {
        this.zzagk = collection;
    }

    public final /* synthetic */ Object then(Task task) {
        AppMethodBeat.i(57448);
        if (this.zzagk.size() == 0) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(57448);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Task result : this.zzagk) {
            arrayList.add(result.getResult());
        }
        AppMethodBeat.o(57448);
        return arrayList;
    }
}
