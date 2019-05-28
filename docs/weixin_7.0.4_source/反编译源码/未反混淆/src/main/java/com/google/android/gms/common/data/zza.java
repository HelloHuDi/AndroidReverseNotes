package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class zza extends Builder {
    zza(String[] strArr, String str) {
        super(strArr, null, null);
    }

    public final Builder withRow(ContentValues contentValues) {
        AppMethodBeat.i(61198);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot add data to empty builder");
        AppMethodBeat.o(61198);
        throw unsupportedOperationException;
    }

    public final Builder withRow(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(61197);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot add data to empty builder");
        AppMethodBeat.o(61197);
        throw unsupportedOperationException;
    }
}
