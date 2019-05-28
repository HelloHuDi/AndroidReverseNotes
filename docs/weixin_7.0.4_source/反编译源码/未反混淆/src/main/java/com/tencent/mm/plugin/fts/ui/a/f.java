package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bo;

public class f extends k {
    public String mEp;
    protected CharSequence mKl;
    protected String mKm;
    protected CharSequence mKn;
    protected String mKo;
    public l mKp;
    private a mKq = new a();
    b mKr = new b();
    public int showType;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(61982);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1_, viewGroup, false);
            b bVar = f.this.mKr;
            bVar.mKt = (TextView) inflate.findViewById(R.id.by6);
            bVar.mKu = (ImageView) inflate.findViewById(R.id.by5);
            bVar.mKv = (TextView) inflate.findViewById(R.id.by9);
            bVar.mKw = (ImageView) inflate.findViewById(R.id.by8);
            bVar.mKx = (TextView) inflate.findViewById(R.id.by7);
            bVar.contentView = inflate.findViewById(R.id.qj);
            bVar.mKk = inflate.findViewById(R.id.it);
            inflate.setTag(bVar);
            AppMethodBeat.o(61982);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61983);
            b bVar = (b) aVar;
            m.a(f.this.mKl, bVar.mKt);
            com.tencent.mm.pluginsdk.ui.a.b.b(bVar.mKu, f.this.mKm);
            m.a(f.this.mKn, bVar.mKv);
            if (bo.isNullOrNil(f.this.mKo)) {
                bVar.mKw.setVisibility(8);
            } else {
                bVar.mKw.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.a.b.b(bVar.mKw, f.this.mKo);
            }
            m.q(bVar.contentView, f.this.mFk);
            if (f.this.position == 0) {
                bVar.mKk.setVisibility(8);
            } else {
                bVar.mKk.setVisibility(0);
            }
            bVar.mKx.setVisibility(0);
            AppMethodBeat.o(61983);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public View mKk;
        public TextView mKt;
        public ImageView mKu;
        public TextView mKv;
        public ImageView mKw;
        public TextView mKx;

        public b() {
            super();
        }
    }

    public f(int i) {
        super(i);
        AppMethodBeat.i(61984);
        AppMethodBeat.o(61984);
    }

    /* JADX WARNING: Missing block: B:4:0x001a, code skipped:
            if (r11.showType != 2) goto L_0x00db;
     */
    /* JADX WARNING: Missing block: B:5:0x001c, code skipped:
            r11.mKm = r6;
     */
    /* JADX WARNING: Missing block: B:6:0x0022, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r5) != false) goto L_0x00c5;
     */
    /* JADX WARNING: Missing block: B:7:0x0024, code skipped:
            r11.mKl = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r0, r11.mKp.mDz, r2, r3, com.tencent.mm.plugin.fts.ui.b.c.mHv, r5 + "(", ")")).mDR;
     */
    /* JADX WARNING: Missing block: B:8:0x004d, code skipped:
            r11.mKl = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", r11.mKl, "\""});
            r11.mKn = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", android.text.TextUtils.ellipsize(com.tencent.mm.plugin.fts.a.d.LC(r11.mEp), com.tencent.mm.plugin.fts.ui.b.c.mHx, 300.0f, android.text.TextUtils.TruncateAt.END), r12.getString(com.tencent.mm.R.string.e11)});
            r11.mKo = r11.mEp;
            com.tencent.matrix.trace.core.AppMethodBeat.o(61985);
     */
    /* JADX WARNING: Missing block: B:10:0x009f, code skipped:
            r2 = true;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:11:0x00a2, code skipped:
            r0 = com.tencent.mm.plugin.fts.a.d.LC(r6);
            r5 = null;
     */
    /* JADX WARNING: Missing block: B:13:0x00aa, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:14:0x00ab, code skipped:
            r0 = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(r6).field_nickname;
            r5 = com.tencent.mm.plugin.fts.a.d.LC(r6);
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:15:0x00c5, code skipped:
            r11.mKl = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r0, r11.mKp.mDz, r2, r3, 400.0f, com.tencent.mm.plugin.fts.ui.b.c.mHv)).mDR;
     */
    /* JADX WARNING: Missing block: B:16:0x00db, code skipped:
            r11.mKl = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", android.text.TextUtils.ellipsize(com.tencent.mm.plugin.fts.a.d.LC(r11.mEp), com.tencent.mm.plugin.fts.ui.b.c.mHx, 300.0f, android.text.TextUtils.TruncateAt.END), "\""});
            r11.mKm = r11.mEp;
            r11.mKo = r6;
     */
    /* JADX WARNING: Missing block: B:17:0x010d, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r5) != false) goto L_0x015e;
     */
    /* JADX WARNING: Missing block: B:18:0x010f, code skipped:
            r11.mKn = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r0, r11.mKp.mDz, r2, r3, com.tencent.mm.plugin.fts.ui.b.c.mHv, r5 + "(", ")")).mDR;
     */
    /* JADX WARNING: Missing block: B:19:0x0138, code skipped:
            r11.mKn = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", r11.mKn, r12.getString(com.tencent.mm.R.string.e11)});
            com.tencent.matrix.trace.core.AppMethodBeat.o(61985);
     */
    /* JADX WARNING: Missing block: B:20:0x015e, code skipped:
            r11.mKn = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r0, r11.mKp.mDz, r2, r3, 400.0f, com.tencent.mm.plugin.fts.ui.b.c.mHv)).mDR;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(61985);
        String str = this.mKp.mDx;
        boolean z = false;
        boolean z2 = false;
        CharSequence charSequence = null;
        boolean z3;
        boolean z4;
        switch (this.mKp.mDw) {
            case 1:
                z3 = false;
                break;
            case 2:
                z4 = false;
                break;
            case 3:
                z4 = true;
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                z = true;
                break;
            default:
                String str2 = null;
                z3 = false;
                break;
        }
    }

    public com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKq;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.a bBi() {
        return this.mKr;
    }
}
