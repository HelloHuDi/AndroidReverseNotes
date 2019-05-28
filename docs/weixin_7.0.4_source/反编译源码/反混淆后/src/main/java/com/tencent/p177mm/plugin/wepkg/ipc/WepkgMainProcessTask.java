package com.tencent.p177mm.plugin.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask */
public abstract class WepkgMainProcessTask implements Parcelable {
    private static final Set<Object> hvo = new HashSet();
    Messenger hvF;
    int mTaskId;

    public abstract void asP();

    public void asQ() {
    }

    /* renamed from: g */
    public void mo48259g(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: wM */
    public final void mo63809wM() {
        if (this.hvF != null) {
            Message obtain = Message.obtain();
            obtain.what = this.mTaskId;
            obtain.setData(WepkgMainProcessService.m87661c(this));
            try {
                this.hvF.send(obtain);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Wepkg.WepkgMainProcessTask", e.getMessage());
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
