package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import java.io.Serializable;

public class PluginDescription implements Parcelable, Serializable {
    public static final Creator<PluginDescription> CREATOR = new Creator<PluginDescription>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDescription[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(93023);
            PluginDescription pluginDescription = new PluginDescription(parcel);
            AppMethodBeat.o(93023);
            return pluginDescription;
        }
    };
    public final String cvZ;
    public final int eun;
    public final String name;
    public final int size;
    public final String url;
    public final String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(93024);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.cvZ);
        parcel.writeString(this.version);
        parcel.writeInt(this.size);
        parcel.writeInt(this.eun);
        AppMethodBeat.o(93024);
    }

    static {
        AppMethodBeat.i(93027);
        AppMethodBeat.o(93027);
    }

    protected PluginDescription(Parcel parcel) {
        AppMethodBeat.i(93025);
        this.name = (String) n.checkNotNull(parcel.readString());
        this.url = (String) n.checkNotNull(parcel.readString());
        this.cvZ = (String) n.checkNotNull(parcel.readString());
        this.version = (String) n.checkNotNull(parcel.readString());
        this.size = parcel.readInt();
        this.eun = parcel.readInt();
        AppMethodBeat.o(93025);
    }

    public String toString() {
        AppMethodBeat.i(93026);
        String format = String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[]{this.name, this.url, this.cvZ, this.version, Integer.valueOf(this.size), Integer.valueOf(this.eun)});
        AppMethodBeat.o(93026);
        return format;
    }
}
