package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zzoa = false;
    private ArrayList<Integer> zzob;

    protected EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zzck() {
        synchronized (this) {
            if (!this.zzoa) {
                int count = this.mDataHolder.getCount();
                this.zzob = new ArrayList();
                if (count > 0) {
                    this.zzob.add(Integer.valueOf(0));
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    int i = 1;
                    while (i < count) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i, windowIndex);
                        if (string2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(primaryDataMarkerColumn).length() + 78).append("Missing value for markerColumn: ").append(primaryDataMarkerColumn).append(", at row: ").append(i).append(", for window: ").append(windowIndex).toString());
                        }
                        if (string2.equals(string)) {
                            string2 = string;
                        } else {
                            this.zzob.add(Integer.valueOf(i));
                        }
                        i++;
                        string = string2;
                    }
                }
                this.zzoa = true;
            }
        }
    }

    public final T get(int i) {
        zzck();
        return getEntry(zzi(i), getChildCount(i));
    }

    /* Access modifiers changed, original: protected */
    public int getChildCount(int i) {
        if (i < 0 || i == this.zzob.size()) {
            return 0;
        }
        int count = i == this.zzob.size() + -1 ? this.mDataHolder.getCount() - ((Integer) this.zzob.get(i)).intValue() : ((Integer) this.zzob.get(i + 1)).intValue() - ((Integer) this.zzob.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int zzi = zzi(i);
        int windowIndex = this.mDataHolder.getWindowIndex(zzi);
        String childDataMarkerColumn = getChildDataMarkerColumn();
        return (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zzi, windowIndex) != null) ? count : 0;
    }

    /* Access modifiers changed, original: protected */
    public String getChildDataMarkerColumn() {
        return null;
    }

    public int getCount() {
        zzck();
        return this.zzob.size();
    }

    public abstract T getEntry(int i, int i2);

    public abstract String getPrimaryDataMarkerColumn();

    /* Access modifiers changed, original: final */
    public final int zzi(int i) {
        if (i >= 0 && i < this.zzob.size()) {
            return ((Integer) this.zzob.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }
}
