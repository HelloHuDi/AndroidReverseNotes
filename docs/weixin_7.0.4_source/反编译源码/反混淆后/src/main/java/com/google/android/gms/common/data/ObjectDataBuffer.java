package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBufferObserver.Observable;
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class ObjectDataBuffer<T> extends AbstractDataBuffer<T> implements Observable, ObjectExclusionFilterable<T> {
    private final ArrayList<Integer> zzob;
    private final HashSet<Integer> zzoe;
    private DataBufferObserverSet zzof;
    private final ArrayList<T> zzog;

    public ObjectDataBuffer() {
        super(null);
        AppMethodBeat.m2504i(61139);
        this.zzoe = new HashSet();
        this.zzob = new ArrayList();
        this.zzog = new ArrayList();
        this.zzof = new DataBufferObserverSet();
        zzcl();
        AppMethodBeat.m2505o(61139);
    }

    public ObjectDataBuffer(ArrayList<T> arrayList) {
        super(null);
        AppMethodBeat.m2504i(61141);
        this.zzoe = new HashSet();
        this.zzob = new ArrayList();
        this.zzog = arrayList;
        this.zzof = new DataBufferObserverSet();
        zzcl();
        AppMethodBeat.m2505o(61141);
    }

    public ObjectDataBuffer(T... tArr) {
        super(null);
        AppMethodBeat.m2504i(61140);
        this.zzoe = new HashSet();
        this.zzob = new ArrayList();
        this.zzog = new ArrayList(Arrays.asList(tArr));
        this.zzof = new DataBufferObserverSet();
        zzcl();
        AppMethodBeat.m2505o(61140);
    }

    private final void zzcl() {
        AppMethodBeat.m2504i(61161);
        this.zzob.clear();
        int size = this.zzog.size();
        for (int i = 0; i < size; i++) {
            if (!this.zzoe.contains(Integer.valueOf(i))) {
                this.zzob.add(Integer.valueOf(i));
            }
        }
        AppMethodBeat.m2505o(61161);
    }

    public final void add(T t) {
        boolean z = false;
        AppMethodBeat.m2504i(61144);
        int size = this.zzog.size();
        this.zzog.add(t);
        zzcl();
        if (this.zzof.hasObservers()) {
            Asserts.checkState(!this.zzoe.contains(Integer.valueOf(size)));
            int size2 = this.zzob.size();
            Asserts.checkState(size2 > 0);
            if (((Integer) this.zzob.get(size2 - 1)).intValue() == size) {
                z = true;
            }
            Asserts.checkState(z);
            this.zzof.onDataRangeInserted(size2 - 1, 1);
        }
        AppMethodBeat.m2505o(61144);
    }

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.m2504i(61142);
        this.zzof.addObserver(dataBufferObserver);
        AppMethodBeat.m2505o(61142);
    }

    public final void filterOut(T t) {
        AppMethodBeat.m2504i(61156);
        int size = this.zzog.size();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        Object obj = null;
        int i4 = -1;
        while (i < size) {
            if (!this.zzoe.contains(Integer.valueOf(i))) {
                i4++;
                if (t.equals(this.zzog.get(i))) {
                    this.zzoe.add(Integer.valueOf(i));
                    int obj2;
                    if (!this.zzof.hasObservers()) {
                        obj2 = 1;
                    } else if (i3 < 0) {
                        i2 = 1;
                        i3 = i4;
                        obj2 = 1;
                    } else {
                        i2++;
                        obj2 = 1;
                    }
                } else if (i3 >= 0) {
                    zzcl();
                    this.zzof.onDataRangeRemoved(i3, i2);
                    i4 -= i2;
                    i2 = -1;
                    i3 = -1;
                    obj2 = null;
                }
            }
            i++;
            i4 = i4;
        }
        if (obj2 != null) {
            zzcl();
        }
        if (i3 >= 0) {
            this.zzof.onDataRangeRemoved(i3, i2);
        }
        AppMethodBeat.m2505o(61156);
    }

    public final void filterOutRaw(int i) {
        int i2;
        AppMethodBeat.m2504i(61157);
        boolean add = this.zzoe.add(Integer.valueOf(i));
        if (this.zzof.hasObservers() && add) {
            int size = this.zzob.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((Integer) this.zzob.get(i3)).intValue() == i) {
                    i2 = i3;
                    break;
                }
            }
        }
        i2 = -1;
        zzcl();
        if (i2 >= 0) {
            this.zzof.onDataRangeRemoved(i2, 1);
        }
        AppMethodBeat.m2505o(61157);
    }

    public final T get(int i) {
        AppMethodBeat.m2504i(61148);
        Object obj = this.zzog.get(getRawPosition(i));
        AppMethodBeat.m2505o(61148);
        return obj;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(61147);
        int size = this.zzog.size() - this.zzoe.size();
        AppMethodBeat.m2505o(61147);
        return size;
    }

    public final Bundle getMetadata() {
        return null;
    }

    public final int getPositionFromRawPosition(int i) {
        AppMethodBeat.m2504i(61152);
        int i2 = -1;
        for (int i3 = 0; i3 <= i; i3++) {
            if (!this.zzoe.contains(Integer.valueOf(i3))) {
                i2++;
            }
        }
        AppMethodBeat.m2505o(61152);
        return i2;
    }

    public final T getRaw(int i) {
        AppMethodBeat.m2504i(61150);
        Object obj = this.zzog.get(i);
        AppMethodBeat.m2505o(61150);
        return obj;
    }

    public final int getRawCount() {
        AppMethodBeat.m2504i(61149);
        int size = this.zzog.size();
        AppMethodBeat.m2505o(61149);
        return size;
    }

    public final int getRawPosition(int i) {
        AppMethodBeat.m2504i(61151);
        if (i < 0 || i >= getCount()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
            AppMethodBeat.m2505o(61151);
            throw illegalArgumentException;
        }
        int intValue = ((Integer) this.zzob.get(i)).intValue();
        AppMethodBeat.m2505o(61151);
        return intValue;
    }

    public final void insertRaw(int i, T t) {
        AppMethodBeat.m2504i(61145);
        this.zzog.add(i, t);
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator it = this.zzoe.iterator();
        int i2 = i;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < i) {
                i2--;
            } else {
                hashSet.add(Integer.valueOf(num.intValue() + 1));
                it.remove();
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (this.zzof.hasObservers()) {
            this.zzof.onDataRangeInserted(i2, 1);
        }
        AppMethodBeat.m2505o(61145);
    }

    public final boolean isRawPositionFiltered(int i) {
        AppMethodBeat.m2504i(61153);
        boolean contains = this.zzoe.contains(Integer.valueOf(i));
        AppMethodBeat.m2505o(61153);
        return contains;
    }

    public final void notifyChanged(T t) {
        AppMethodBeat.m2504i(61160);
        if (this.zzof.hasObservers()) {
            int size = this.zzob.size();
            for (int i = 0; i < size; i++) {
                if (t.equals(this.zzog.get(((Integer) this.zzob.get(i)).intValue()))) {
                    this.zzof.onDataRangeChanged(i, 1);
                }
            }
            AppMethodBeat.m2505o(61160);
            return;
        }
        AppMethodBeat.m2505o(61160);
    }

    public final void release() {
        AppMethodBeat.m2504i(61154);
        this.zzof.clear();
        AppMethodBeat.m2505o(61154);
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.m2504i(61143);
        this.zzof.removeObserver(dataBufferObserver);
        AppMethodBeat.m2505o(61143);
    }

    public final void removeRaw(int i) {
        AppMethodBeat.m2504i(61155);
        this.zzog.remove(i);
        boolean remove = this.zzoe.remove(Integer.valueOf(i));
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator it = this.zzoe.iterator();
        int i2 = i;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < i) {
                i2--;
            } else {
                it.remove();
                hashSet.add(Integer.valueOf(num.intValue() - 1));
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (!remove && this.zzof.hasObservers()) {
            this.zzof.onDataRangeRemoved(i2, 1);
        }
        AppMethodBeat.m2505o(61155);
    }

    public final boolean setRaw(int i, T t) {
        AppMethodBeat.m2504i(61146);
        this.zzog.set(i, t);
        boolean z = !this.zzoe.contains(Integer.valueOf(i));
        if (z && this.zzof.hasObservers()) {
            int size = this.zzob.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((Integer) this.zzob.get(i2)).intValue() == i) {
                    this.zzof.onDataRangeChanged(i2, 1);
                    break;
                }
            }
        }
        AppMethodBeat.m2505o(61146);
        return z;
    }

    public final void unfilter(T t) {
        AppMethodBeat.m2504i(61158);
        int size = this.zzog.size();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        Object obj = null;
        int i4 = 0;
        while (i < size) {
            if (!this.zzoe.contains(Integer.valueOf(i))) {
                i4++;
                if (i3 >= 0) {
                    zzcl();
                    this.zzof.onDataRangeInserted(i3, i2);
                    i4 += i2;
                    i2 = -1;
                    i3 = -1;
                    obj = null;
                }
            } else if (t.equals(this.zzog.get(i))) {
                this.zzoe.remove(Integer.valueOf(i));
                int obj2;
                if (!this.zzof.hasObservers()) {
                    obj2 = 1;
                } else if (i3 < 0) {
                    i2 = 1;
                    i3 = i4;
                    obj2 = 1;
                } else {
                    i2++;
                    obj2 = 1;
                }
            } else if (this.zzof.hasObservers() && i3 >= 0) {
                zzcl();
                this.zzof.onDataRangeInserted(i3, i2);
                i4 += i2;
                i2 = -1;
                i3 = -1;
                obj2 = null;
            }
            i++;
            i4 = i4;
        }
        if (obj2 != null) {
            zzcl();
        }
        if (i3 >= 0) {
            this.zzof.onDataRangeInserted(i3, i2);
        }
        AppMethodBeat.m2505o(61158);
    }

    public final void unfilterRaw(int i) {
        AppMethodBeat.m2504i(61159);
        boolean remove = this.zzoe.remove(Integer.valueOf(i));
        zzcl();
        if (this.zzof.hasObservers() && remove) {
            int i2;
            int size = this.zzob.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((Integer) this.zzob.get(i3)).intValue() == i) {
                    i2 = i3;
                    break;
                }
            }
            i2 = -1;
            if (i2 >= 0) {
                this.zzof.onDataRangeInserted(i2, 1);
            }
            AppMethodBeat.m2505o(61159);
            return;
        }
        AppMethodBeat.m2505o(61159);
    }
}
