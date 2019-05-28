package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.a.f.b;

public final class o extends f {
    private a mLh = new a();

    public class a extends com.tencent.mm.plugin.fts.ui.a.f.a {
        public a() {
            super();
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(62023);
            super.a(context, aVar, aVar2, objArr);
            ((b) aVar).mKx.setVisibility(8);
            AppMethodBeat.o(62023);
        }
    }

    public o(int i) {
        super(i);
        AppMethodBeat.i(62024);
        AppMethodBeat.o(62024);
    }

    /* JADX WARNING: Missing block: B:3:0x0018, code skipped:
            r10.mKm = r6;
     */
    /* JADX WARNING: Missing block: B:4:0x001e, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r5) != false) goto L_0x008f;
     */
    /* JADX WARNING: Missing block: B:5:0x0020, code skipped:
            r10.mKl = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r0, r10.mKp.mDz, r2, r3, com.tencent.mm.plugin.fts.ui.b.c.mHv, r5 + "(", ")")).mDR;
     */
    /* JADX WARNING: Missing block: B:6:0x0049, code skipped:
            r10.mKl = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", r10.mKl, r11.getString(com.tencent.mm.R.string.e11)});
            com.tencent.matrix.trace.core.AppMethodBeat.o(62025);
     */
    /* JADX WARNING: Missing block: B:7:0x0068, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:9:0x006a, code skipped:
            r1 = true;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:10:0x006c, code skipped:
            r0 = com.tencent.mm.plugin.fts.a.d.LC(r6);
            r5 = null;
            r2 = r1;
     */
    /* JADX WARNING: Missing block: B:12:0x0074, code skipped:
            r1 = true;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:13:0x0076, code skipped:
            r0 = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(r6).field_nickname;
            r5 = com.tencent.mm.plugin.fts.a.d.LC(r6);
            r2 = r1;
     */
    /* JADX WARNING: Missing block: B:14:0x008f, code skipped:
            r10.mKl = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r0, r10.mKp.mDz, r2, r3, 400.0f, com.tencent.mm.plugin.fts.ui.b.c.mHv)).mDR;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(62025);
        String str = this.mKp.mDx;
        boolean z;
        boolean z2;
        boolean z3;
        switch (this.mKp.mDw) {
            case 1:
                z = false;
                z2 = false;
                break;
            case 2:
                z3 = false;
                break;
            case 3:
                z3 = true;
                break;
            case 5:
                z = false;
                z2 = false;
                break;
            case 6:
                z3 = false;
                break;
            case 7:
                z3 = true;
                break;
            default:
                String str2 = null;
                CharSequence charSequence = null;
                boolean z4 = false;
                z2 = false;
                break;
        }
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mLh;
    }
}
