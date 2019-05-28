package com.tencent.mm.p;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {

    public static final class a implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.coolassist.debugprovider/config");

        static {
            AppMethodBeat.i(125782);
            AppMethodBeat.o(125782);
        }
    }
}
