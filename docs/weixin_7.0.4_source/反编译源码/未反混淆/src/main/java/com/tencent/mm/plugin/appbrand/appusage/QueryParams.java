package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "(ILcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;)V", "getCount", "()I", "getOrder", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class QueryParams implements Parcelable {
    public static final a CREATOR = new a();
    final int count;
    final com.tencent.mm.plugin.appbrand.appusage.af.a haS;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "plugin-appbrand-integration_release"})
    public static final class a implements Creator<QueryParams> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134563);
            j.p(parcel, "parcel");
            QueryParams queryParams = new QueryParams(parcel);
            AppMethodBeat.o(134563);
            return queryParams;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QueryParams[i];
        }
    }

    static {
        AppMethodBeat.i(134566);
        AppMethodBeat.o(134566);
    }

    public QueryParams(int i, com.tencent.mm.plugin.appbrand.appusage.af.a aVar) {
        this.count = i;
        this.haS = aVar;
    }

    public QueryParams(Parcel parcel) {
        com.tencent.mm.plugin.appbrand.appusage.af.a aVar;
        j.p(parcel, "parcel");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        if (readInt2 == com.tencent.mm.plugin.appbrand.appusage.af.a.ASC.ordinal()) {
            aVar = com.tencent.mm.plugin.appbrand.appusage.af.a.ASC;
        } else if (readInt2 == com.tencent.mm.plugin.appbrand.appusage.af.a.DESC.ordinal()) {
            aVar = com.tencent.mm.plugin.appbrand.appusage.af.a.DESC;
        } else {
            aVar = null;
        }
        this(readInt, aVar);
        AppMethodBeat.o(134565);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(134564);
        if (parcel != null) {
            parcel.writeInt(this.count);
        }
        if (parcel != null) {
            com.tencent.mm.plugin.appbrand.appusage.af.a aVar = this.haS;
            parcel.writeInt(aVar != null ? aVar.ordinal() : -1);
            AppMethodBeat.o(134564);
            return;
        }
        AppMethodBeat.o(134564);
    }

    public final int describeContents() {
        return 0;
    }
}
