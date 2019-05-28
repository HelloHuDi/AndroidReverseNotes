package com.tencent.p177mm.plugin.appbrand.p911q;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4930i;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.q.a */
public final class C19676a extends C7563j<C19675a> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C19675a.gSs, "AppBrandCommonKVBinaryData")};

    /* renamed from: com.tencent.mm.plugin.appbrand.q.a$a */
    static final class C19675a extends C4925c {
        static final C4924a gSs = C4925c.m7296ax(C19675a.class);
        @C4930i(dpV = "$$invalid", dpW = 1)
        public String field_key;
        public byte[] field_value;

        C19675a() {
        }

        /* renamed from: Ag */
        public final C4924a mo4635Ag() {
            return gSs;
        }

        /* renamed from: d */
        public final void mo8995d(Cursor cursor) {
            AppMethodBeat.m2504i(132769);
            this.field_key = cursor.getString(0);
            this.field_value = cursor.getBlob(1);
            AppMethodBeat.m2505o(132769);
        }

        /* renamed from: Hl */
        public final ContentValues mo10098Hl() {
            AppMethodBeat.m2504i(132770);
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", this.field_key);
            contentValues.put("value", this.field_value);
            AppMethodBeat.m2505o(132770);
            return contentValues;
        }

        static {
            AppMethodBeat.m2504i(132771);
            AppMethodBeat.m2505o(132771);
        }
    }

    static {
        AppMethodBeat.m2504i(132776);
        AppMethodBeat.m2505o(132776);
    }

    public C19676a(C4927e c4927e) {
        super(c4927e, C19675a.gSs, "AppBrandCommonKVBinaryData", null);
    }

    public final void clear(String str) {
        AppMethodBeat.m2504i(132772);
        C19675a c19675a = new C19675a();
        c19675a.field_key = str;
        c19675a.field_value = new byte[0];
        super.mo10099a(c19675a);
        AppMethodBeat.m2505o(132772);
    }

    /* renamed from: s */
    public final void mo34914s(String str, byte[] bArr) {
        AppMethodBeat.m2504i(132773);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132773);
            return;
        }
        C19675a c19675a = new C19675a();
        c19675a.field_key = str;
        c19675a.field_value = bArr;
        super.mo10099a(c19675a);
        AppMethodBeat.m2505o(132773);
    }

    /* renamed from: DH */
    public final byte[] mo34911DH(String str) {
        AppMethodBeat.m2504i(132774);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132774);
            return null;
        }
        C4925c c19675a = new C19675a();
        c19675a.field_key = str;
        if (super.mo10102b(c19675a, new String[0])) {
            byte[] bArr = c19675a.field_value;
            AppMethodBeat.m2505o(132774);
            return bArr;
        }
        AppMethodBeat.m2505o(132774);
        return null;
    }

    /* renamed from: e */
    public final <T extends C1331a> T mo34913e(String str, Class<T> cls) {
        AppMethodBeat.m2504i(132775);
        byte[] DH = mo34911DH(str);
        if (C5046bo.m7540cb(DH)) {
            AppMethodBeat.m2505o(132775);
            return null;
        }
        try {
            C1331a c1331a = (C1331a) cls.newInstance();
            c1331a.parseFrom(DH);
            AppMethodBeat.m2505o(132775);
            return c1331a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", cls.getSimpleName(), e);
            AppMethodBeat.m2505o(132775);
            return null;
        }
    }
}
