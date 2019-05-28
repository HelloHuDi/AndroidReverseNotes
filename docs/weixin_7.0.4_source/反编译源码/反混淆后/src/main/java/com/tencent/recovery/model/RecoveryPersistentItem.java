package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem implements Parcelable {
    public abstract boolean atL(String str);

    public abstract String dQf();

    public String toString() {
        return dQf();
    }
}
