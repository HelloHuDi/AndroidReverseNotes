package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.f;

public final class a extends com.tencent.mm.ipcinvoker.extension.event.a<a> {
    private static final a hpz = new a();

    public static class a implements f {
        public int height;
        public String id;
        public int width;

        public final void e(Parcel parcel) {
            AppMethodBeat.i(11085);
            parcel.writeString(this.id);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            AppMethodBeat.o(11085);
        }

        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.i(11086);
            this.id = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            AppMethodBeat.o(11086);
        }
    }

    static {
        AppMethodBeat.i(11087);
        AppMethodBeat.o(11087);
    }
}
