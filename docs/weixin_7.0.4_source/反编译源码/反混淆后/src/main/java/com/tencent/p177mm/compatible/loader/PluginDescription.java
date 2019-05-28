package com.tencent.p177mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C41944n;
import java.io.Serializable;

/* renamed from: com.tencent.mm.compatible.loader.PluginDescription */
public class PluginDescription implements Parcelable, Serializable {
    public static final Creator<PluginDescription> CREATOR = new C14371();
    public final String cvZ;
    public final int eun;
    public final String name;
    public final int size;
    public final String url;
    public final String version;

    /* renamed from: com.tencent.mm.compatible.loader.PluginDescription$1 */
    static class C14371 implements Creator<PluginDescription> {
        C14371() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDescription[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(93023);
            PluginDescription pluginDescription = new PluginDescription(parcel);
            AppMethodBeat.m2505o(93023);
            return pluginDescription;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(93024);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.cvZ);
        parcel.writeString(this.version);
        parcel.writeInt(this.size);
        parcel.writeInt(this.eun);
        AppMethodBeat.m2505o(93024);
    }

    static {
        AppMethodBeat.m2504i(93027);
        AppMethodBeat.m2505o(93027);
    }

    protected PluginDescription(Parcel parcel) {
        AppMethodBeat.m2504i(93025);
        this.name = (String) C41944n.checkNotNull(parcel.readString());
        this.url = (String) C41944n.checkNotNull(parcel.readString());
        this.cvZ = (String) C41944n.checkNotNull(parcel.readString());
        this.version = (String) C41944n.checkNotNull(parcel.readString());
        this.size = parcel.readInt();
        this.eun = parcel.readInt();
        AppMethodBeat.m2505o(93025);
    }

    public String toString() {
        AppMethodBeat.m2504i(93026);
        String format = String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[]{this.name, this.url, this.cvZ, this.version, Integer.valueOf(this.size), Integer.valueOf(this.eun)});
        AppMethodBeat.m2505o(93026);
        return format;
    }
}
