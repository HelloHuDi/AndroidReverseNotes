package com.tencent.p177mm.plugin.appbrand.dynamic.widget;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C42136f;
import com.tencent.p177mm.ipcinvoker.extension.event.C42135a;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.a */
public final class C19208a extends C42135a<C19209a> {
    private static final C19208a hpz = new C19208a();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.a$a */
    public static class C19209a implements C42136f {
        public int height;
        /* renamed from: id */
        public String f4349id;
        public int width;

        /* renamed from: e */
        public final void mo5956e(Parcel parcel) {
            AppMethodBeat.m2504i(11085);
            parcel.writeString(this.f4349id);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            AppMethodBeat.m2505o(11085);
        }

        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(11086);
            this.f4349id = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            AppMethodBeat.m2505o(11086);
        }
    }

    static {
        AppMethodBeat.m2504i(11087);
        AppMethodBeat.m2505o(11087);
    }
}
