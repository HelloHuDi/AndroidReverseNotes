package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class zzdc implements DataItem {
    private byte[] data;
    private Uri uri;
    private Map<String, DataItemAsset> zzdo;

    public zzdc(DataItem dataItem) {
        AppMethodBeat.m2504i(71191);
        this.uri = dataItem.getUri();
        this.data = dataItem.getData();
        HashMap hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put((String) entry.getKey(), (DataItemAsset) ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.zzdo = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.m2505o(71191);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final Map<String, DataItemAsset> getAssets() {
        return this.zzdo;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final DataItem setData(byte[] bArr) {
        AppMethodBeat.m2504i(71192);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(71192);
        throw unsupportedOperationException;
    }

    public final String toString() {
        AppMethodBeat.m2504i(71193);
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        String valueOf = String.valueOf(this.uri);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        valueOf = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 9).append(", dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.zzdo.size());
        if (isLoggable && !this.zzdo.isEmpty()) {
            stringBuilder.append(", assets=[");
            valueOf = "";
            Iterator it = this.zzdo.entrySet().iterator();
            while (true) {
                String str = valueOf;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                String str2 = (String) entry.getKey();
                valueOf = ((DataItemAsset) entry.getValue()).getId();
                stringBuilder.append(new StringBuilder(((String.valueOf(str).length() + 2) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append(str).append(str2).append(": ").append(valueOf).toString());
                valueOf = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        valueOf = stringBuilder.toString();
        AppMethodBeat.m2505o(71193);
        return valueOf;
    }
}
