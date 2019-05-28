package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.at;
import com.tencent.mm.plugin.webview.model.at.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class AddShortcutTask extends MainProcessTask {
    public static final Creator<AddShortcutTask> CREATOR = new Creator<AddShortcutTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AddShortcutTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(135847);
            AddShortcutTask addShortcutTask = new AddShortcutTask(parcel, (byte) 0);
            AppMethodBeat.o(135847);
            return addShortcutTask;
        }
    };
    public String appId;
    public Runnable hww;
    public boolean success;
    public String username;

    /* synthetic */ AddShortcutTask(Parcel parcel, byte b) {
        this(parcel);
    }

    static /* synthetic */ boolean a(AddShortcutTask addShortcutTask) {
        AppMethodBeat.i(135853);
        boolean aCb = addShortcutTask.aCb();
        AppMethodBeat.o(135853);
        return aCb;
    }

    public final void asP() {
        AppMethodBeat.i(135848);
        if (bo.isNullOrNil(this.appId) || bo.isNullOrNil(this.username)) {
            ab.e("MicroMsg.AddShortcutTask", "appid or username is null");
            this.success = false;
            AppMethodBeat.o(135848);
            return;
        }
        at.a(ah.getContext(), this.username, this.appId, new a() {
            public final void hJ(boolean z) {
                AppMethodBeat.i(135846);
                AddShortcutTask.this.success = z;
                AddShortcutTask.a(AddShortcutTask.this);
                AppMethodBeat.o(135846);
            }
        });
        AppMethodBeat.o(135848);
    }

    public final void asQ() {
        AppMethodBeat.i(135849);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(135849);
    }

    public int describeContents() {
        return 0;
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(135850);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.success = z;
        AppMethodBeat.o(135850);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(135851);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeByte((byte) (this.success ? 1 : 0));
        AppMethodBeat.o(135851);
    }

    private AddShortcutTask(Parcel parcel) {
        AppMethodBeat.i(135852);
        g(parcel);
        AppMethodBeat.o(135852);
    }

    static {
        AppMethodBeat.i(135854);
        AppMethodBeat.o(135854);
    }
}
