package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;

public abstract class BaseWepkgProcessTask extends WepkgMainProcessTask {
    public boolean csN = false;

    public abstract void a(Parcel parcel, int i);

    public abstract void m(Parcel parcel);

    public final void g(Parcel parcel) {
        this.csN = parcel.readByte() != (byte) 0;
        m(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.csN ? 1 : 0));
        a(parcel, i);
    }
}
