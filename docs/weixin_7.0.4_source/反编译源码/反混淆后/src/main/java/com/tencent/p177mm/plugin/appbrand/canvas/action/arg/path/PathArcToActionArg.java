package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcToActionArg */
public class PathArcToActionArg extends PathActionArg {
    public static final Creator<PathArcToActionArg> CREATOR = new C423931();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcToActionArg$1 */
    static class C423931 implements Creator<PathArcToActionArg> {
        C423931() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathArcToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103599);
            PathArcToActionArg pathArcToActionArg = new PathArcToActionArg(parcel);
            AppMethodBeat.m2505o(103599);
            return pathArcToActionArg;
        }
    }

    public PathArcToActionArg(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.m2504i(103600);
        AppMethodBeat.m2505o(103600);
    }
}
