package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

public abstract class WepkgMainProcessTask implements Parcelable {
    private static final Set<Object> hvo = new HashSet();
    Messenger hvF;
    int mTaskId;

    public abstract void asP();

    public void asQ() {
    }

    public void g(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void wM() {
        if (this.hvF != null) {
            Message obtain = Message.obtain();
            obtain.what = this.mTaskId;
            obtain.setData(WepkgMainProcessService.c(this));
            try {
                this.hvF.send(obtain);
            } catch (Exception e) {
                ab.e("MicroMsg.Wepkg.WepkgMainProcessTask", e.getMessage());
            }
        }
    }

    public final void aBV() {
        hvo.add(this);
    }

    public final void aBW() {
        hvo.remove(this);
    }
}
