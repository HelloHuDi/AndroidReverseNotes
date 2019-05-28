package com.tencent.p177mm.plugin.wepkg.model;

import android.os.Parcel;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessTask;

/* renamed from: com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask */
public abstract class BaseWepkgProcessTask extends WepkgMainProcessTask {
    public boolean csN = false;

    /* renamed from: a */
    public abstract void mo27109a(Parcel parcel, int i);

    /* renamed from: m */
    public abstract void mo27112m(Parcel parcel);

    /* renamed from: g */
    public final void mo48259g(Parcel parcel) {
        this.csN = parcel.readByte() != (byte) 0;
        mo27112m(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.csN ? 1 : 0));
        mo27109a(parcel, i);
    }
}
