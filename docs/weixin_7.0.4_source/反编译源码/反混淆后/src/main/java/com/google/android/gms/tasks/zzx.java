package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class zzx implements Continuation<Void, Task<List<Task<?>>>> {
    private final /* synthetic */ Collection zzagk;

    zzx(Collection collection) {
        this.zzagk = collection;
    }

    public final /* synthetic */ Object then(Task task) {
        AppMethodBeat.m2504i(57449);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzagk);
        Task forResult = Tasks.forResult(arrayList);
        AppMethodBeat.m2505o(57449);
        return forResult;
    }
}
