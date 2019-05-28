package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver.Observable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, Observable {
    private HashSet<DataBufferObserver> zzni = new HashSet();

    public DataBufferObserverSet() {
        AppMethodBeat.m2504i(61039);
        AppMethodBeat.m2505o(61039);
    }

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.m2504i(61042);
        this.zzni.add(dataBufferObserver);
        AppMethodBeat.m2505o(61042);
    }

    public final void clear() {
        AppMethodBeat.m2504i(61041);
        this.zzni.clear();
        AppMethodBeat.m2505o(61041);
    }

    public final boolean hasObservers() {
        AppMethodBeat.m2504i(61040);
        if (this.zzni.isEmpty()) {
            AppMethodBeat.m2505o(61040);
            return false;
        }
        AppMethodBeat.m2505o(61040);
        return true;
    }

    public final void onDataChanged() {
        AppMethodBeat.m2504i(61044);
        Iterator it = this.zzni.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataChanged();
        }
        AppMethodBeat.m2505o(61044);
    }

    public final void onDataRangeChanged(int i, int i2) {
        AppMethodBeat.m2504i(61045);
        Iterator it = this.zzni.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeChanged(i, i2);
        }
        AppMethodBeat.m2505o(61045);
    }

    public final void onDataRangeInserted(int i, int i2) {
        AppMethodBeat.m2504i(61046);
        Iterator it = this.zzni.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeInserted(i, i2);
        }
        AppMethodBeat.m2505o(61046);
    }

    public final void onDataRangeMoved(int i, int i2, int i3) {
        AppMethodBeat.m2504i(61048);
        Iterator it = this.zzni.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeMoved(i, i2, i3);
        }
        AppMethodBeat.m2505o(61048);
    }

    public final void onDataRangeRemoved(int i, int i2) {
        AppMethodBeat.m2504i(61047);
        Iterator it = this.zzni.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeRemoved(i, i2);
        }
        AppMethodBeat.m2505o(61047);
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.m2504i(61043);
        this.zzni.remove(dataBufferObserver);
        AppMethodBeat.m2505o(61043);
    }
}
