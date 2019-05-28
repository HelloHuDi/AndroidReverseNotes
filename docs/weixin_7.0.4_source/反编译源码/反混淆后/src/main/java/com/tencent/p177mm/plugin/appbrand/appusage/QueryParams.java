package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "(ILcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;)V", "getCount", "()I", "getOrder", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.QueryParams */
final class QueryParams implements Parcelable {
    public static final C2081a CREATOR = new C2081a();
    final int count;
    final C10117a haS;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.QueryParams$a */
    public static final class C2081a implements Creator<QueryParams> {
        private C2081a() {
        }

        public /* synthetic */ C2081a(byte b) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(134563);
            C25052j.m39376p(parcel, "parcel");
            QueryParams queryParams = new QueryParams(parcel);
            AppMethodBeat.m2505o(134563);
            return queryParams;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QueryParams[i];
        }
    }

    static {
        AppMethodBeat.m2504i(134566);
        AppMethodBeat.m2505o(134566);
    }

    public QueryParams(int i, C10117a c10117a) {
        this.count = i;
        this.haS = c10117a;
    }

    public QueryParams(Parcel parcel) {
        C10117a c10117a;
        C25052j.m39376p(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        if (readInt2 == C10117a.ASC.ordinal()) {
            c10117a = C10117a.ASC;
        } else if (readInt2 == C10117a.DESC.ordinal()) {
            c10117a = C10117a.DESC;
        } else {
            c10117a = null;
        }
        this(readInt, c10117a);
        AppMethodBeat.m2505o(134565);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(134564);
        if (parcel != null) {
            parcel.writeInt(this.count);
        }
        if (parcel != null) {
            C10117a c10117a = this.haS;
            parcel.writeInt(c10117a != null ? c10117a.ordinal() : -1);
            AppMethodBeat.m2505o(134564);
            return;
        }
        AppMethodBeat.m2505o(134564);
    }

    public final int describeContents() {
        return 0;
    }
}
