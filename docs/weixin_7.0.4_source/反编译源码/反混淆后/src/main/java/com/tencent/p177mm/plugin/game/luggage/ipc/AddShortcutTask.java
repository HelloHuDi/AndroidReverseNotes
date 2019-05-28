package com.tencent.p177mm.plugin.game.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.webview.model.C35610at;
import com.tencent.p177mm.plugin.webview.model.C35610at.C14514a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask */
public class AddShortcutTask extends MainProcessTask {
    public static final Creator<AddShortcutTask> CREATOR = new C209812();
    public String appId;
    public Runnable hww;
    public boolean success;
    public String username;

    /* renamed from: com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask$2 */
    static class C209812 implements Creator<AddShortcutTask> {
        C209812() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AddShortcutTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(135847);
            AddShortcutTask addShortcutTask = new AddShortcutTask(parcel, (byte) 0);
            AppMethodBeat.m2505o(135847);
            return addShortcutTask;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask$1 */
    class C342921 implements C14514a {
        C342921() {
        }

        /* renamed from: hJ */
        public final void mo26754hJ(boolean z) {
            AppMethodBeat.m2504i(135846);
            AddShortcutTask.this.success = z;
            AddShortcutTask.m76754a(AddShortcutTask.this);
            AppMethodBeat.m2505o(135846);
        }
    }

    /* synthetic */ AddShortcutTask(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m76754a(AddShortcutTask addShortcutTask) {
        AppMethodBeat.m2504i(135853);
        boolean aCb = addShortcutTask.aCb();
        AppMethodBeat.m2505o(135853);
        return aCb;
    }

    public final void asP() {
        AppMethodBeat.m2504i(135848);
        if (C5046bo.isNullOrNil(this.appId) || C5046bo.isNullOrNil(this.username)) {
            C4990ab.m7412e("MicroMsg.AddShortcutTask", "appid or username is null");
            this.success = false;
            AppMethodBeat.m2505o(135848);
            return;
        }
        C35610at.m58448a(C4996ah.getContext(), this.username, this.appId, new C342921());
        AppMethodBeat.m2505o(135848);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(135849);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(135849);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(135850);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.success = z;
        AppMethodBeat.m2505o(135850);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(135851);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeByte((byte) (this.success ? 1 : 0));
        AppMethodBeat.m2505o(135851);
    }

    private AddShortcutTask(Parcel parcel) {
        AppMethodBeat.m2504i(135852);
        mo6032g(parcel);
        AppMethodBeat.m2505o(135852);
    }

    static {
        AppMethodBeat.m2504i(135854);
        AppMethodBeat.m2505o(135854);
    }
}
