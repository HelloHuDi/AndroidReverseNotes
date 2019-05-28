package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class zzdf extends DataBufferRef implements DataItem {
    private final int zzdl;

    public zzdf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzdl = i2;
    }

    public final /* synthetic */ Object freeze() {
        AppMethodBeat.i(71204);
        zzdc zzdc = new zzdc(this);
        AppMethodBeat.o(71204);
        return zzdc;
    }

    public final Map<String, DataItemAsset> getAssets() {
        AppMethodBeat.i(71201);
        HashMap hashMap = new HashMap(this.zzdl);
        for (int i = 0; i < this.zzdl; i++) {
            zzdb zzdb = new zzdb(this.mDataHolder, this.mDataRow + i);
            if (zzdb.getDataItemKey() != null) {
                hashMap.put(zzdb.getDataItemKey(), zzdb);
            }
        }
        AppMethodBeat.o(71201);
        return hashMap;
    }

    public final byte[] getData() {
        AppMethodBeat.i(71200);
        byte[] byteArray = getByteArray("data");
        AppMethodBeat.o(71200);
        return byteArray;
    }

    public final Uri getUri() {
        AppMethodBeat.i(71199);
        Uri parse = Uri.parse(getString("path"));
        AppMethodBeat.o(71199);
        return parse;
    }

    public final DataItem setData(byte[] bArr) {
        AppMethodBeat.i(71202);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(71202);
        throw unsupportedOperationException;
    }

    public final String toString() {
        AppMethodBeat.i(71203);
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] data = getData();
        Map assets = getAssets();
        StringBuilder stringBuilder = new StringBuilder("DataItemRef{ ");
        String valueOf = String.valueOf(getUri());
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        String valueOf2 = String.valueOf(data == null ? BuildConfig.COMMAND : Integer.valueOf(data.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf2).length() + 9).append(", dataSz=").append(valueOf2).toString());
        stringBuilder.append(", numAssets=" + assets.size());
        if (isLoggable && !assets.isEmpty()) {
            stringBuilder.append(", assets=[");
            valueOf2 = "";
            Iterator it = assets.entrySet().iterator();
            while (true) {
                String str = valueOf2;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                String str2 = (String) entry.getKey();
                valueOf2 = ((DataItemAsset) entry.getValue()).getId();
                stringBuilder.append(new StringBuilder(((String.valueOf(str).length() + 2) + String.valueOf(str2).length()) + String.valueOf(valueOf2).length()).append(str).append(str2).append(": ").append(valueOf2).toString());
                valueOf2 = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        valueOf2 = stringBuilder.toString();
        AppMethodBeat.o(71203);
        return valueOf2;
    }
}
