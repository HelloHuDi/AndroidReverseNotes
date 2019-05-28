package com.tencent.p177mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.MainProcessTask */
public abstract class MainProcessTask implements Parcelable {
    private static final Set<Object> hvE = new HashSet();
    Messenger hvF;
    protected String hvr = (Process.myPid() + hashCode());

    public abstract void asP();

    public void asQ() {
    }

    /* renamed from: g */
    public void mo6032g(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final boolean aCb() {
        if (this.hvF == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.setData(AppBrandMainProcessService.m54344a(this, false));
        try {
            this.hvF.send(obtain);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void aBV() {
        hvE.add(this);
    }

    public final void aBW() {
        hvE.remove(this);
    }
}
