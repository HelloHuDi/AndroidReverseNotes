package com.tencent.mm.plugin.appbrand.q;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends j<a> {
    public static final String[] fjY = new String[]{j.a(a.gSs, "AppBrandCommonKVBinaryData")};

    static final class a extends c {
        static final com.tencent.mm.sdk.e.c.a gSs = c.ax(a.class);
        @i(dpV = "$$invalid", dpW = 1)
        public String field_key;
        public byte[] field_value;

        a() {
        }

        public final com.tencent.mm.sdk.e.c.a Ag() {
            return gSs;
        }

        public final void d(Cursor cursor) {
            AppMethodBeat.i(132769);
            this.field_key = cursor.getString(0);
            this.field_value = cursor.getBlob(1);
            AppMethodBeat.o(132769);
        }

        public final ContentValues Hl() {
            AppMethodBeat.i(132770);
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", this.field_key);
            contentValues.put("value", this.field_value);
            AppMethodBeat.o(132770);
            return contentValues;
        }

        static {
            AppMethodBeat.i(132771);
            AppMethodBeat.o(132771);
        }
    }

    static {
        AppMethodBeat.i(132776);
        AppMethodBeat.o(132776);
    }

    public a(e eVar) {
        super(eVar, a.gSs, "AppBrandCommonKVBinaryData", null);
    }

    public final void clear(String str) {
        AppMethodBeat.i(132772);
        a aVar = new a();
        aVar.field_key = str;
        aVar.field_value = new byte[0];
        super.a(aVar);
        AppMethodBeat.o(132772);
    }

    public final void s(String str, byte[] bArr) {
        AppMethodBeat.i(132773);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132773);
            return;
        }
        a aVar = new a();
        aVar.field_key = str;
        aVar.field_value = bArr;
        super.a(aVar);
        AppMethodBeat.o(132773);
    }

    public final byte[] DH(String str) {
        AppMethodBeat.i(132774);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132774);
            return null;
        }
        c aVar = new a();
        aVar.field_key = str;
        if (super.b(aVar, new String[0])) {
            byte[] bArr = aVar.field_value;
            AppMethodBeat.o(132774);
            return bArr;
        }
        AppMethodBeat.o(132774);
        return null;
    }

    public final <T extends com.tencent.mm.bt.a> T e(String str, Class<T> cls) {
        AppMethodBeat.i(132775);
        byte[] DH = DH(str);
        if (bo.cb(DH)) {
            AppMethodBeat.o(132775);
            return null;
        }
        try {
            com.tencent.mm.bt.a aVar = (com.tencent.mm.bt.a) cls.newInstance();
            aVar.parseFrom(DH);
            AppMethodBeat.o(132775);
            return aVar;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", cls.getSimpleName(), e);
            AppMethodBeat.o(132775);
            return null;
        }
    }
}
