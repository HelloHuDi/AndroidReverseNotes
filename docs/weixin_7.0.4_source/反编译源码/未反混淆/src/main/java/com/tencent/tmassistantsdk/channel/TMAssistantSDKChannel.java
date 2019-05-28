package com.tencent.tmassistantsdk.channel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TMAssistantSDKChannel {
    public synchronized ArrayList<TMAssistantSDKChannelDataItem> getChannelDataItemList() {
        ArrayList queryAll;
        AppMethodBeat.i(75615);
        queryAll = new DBOption().queryAll();
        AppMethodBeat.o(75615);
        return queryAll;
    }

    public synchronized long AddDataItem(String str, int i, String str2, int i2, String str3, long j, long j2, int i3, byte[] bArr) {
        long insert;
        AppMethodBeat.i(75616);
        insert = new DBOption().insert(new TMAssistantSDKChannelDataItem(str, i, str2, i2, str3, j, j2, i3, bArr));
        AppMethodBeat.o(75616);
        return insert;
    }

    public synchronized boolean delDataItem(long j) {
        boolean z;
        AppMethodBeat.i(75617);
        if (j < 0) {
            z = false;
            AppMethodBeat.o(75617);
        } else {
            z = new DBOption().delete(j);
            AppMethodBeat.o(75617);
        }
        return z;
    }
}
