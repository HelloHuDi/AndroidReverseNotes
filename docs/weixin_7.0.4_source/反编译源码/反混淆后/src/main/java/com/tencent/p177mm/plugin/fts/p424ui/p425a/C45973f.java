package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.f */
public class C45973f extends C39147k {
    public String mEp;
    protected CharSequence mKl;
    protected String mKm;
    protected CharSequence mKn;
    protected String mKo;
    public C45966l mKp;
    private C20872a mKq = new C20872a();
    C34228b mKr = new C34228b();
    public int showType;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.f$a */
    public class C20872a extends C3156b {
        public C20872a() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(61982);
            View inflate = LayoutInflater.from(context).inflate(2130969615, viewGroup, false);
            C34228b c34228b = C45973f.this.mKr;
            c34228b.mKt = (TextView) inflate.findViewById(2131824213);
            c34228b.mKu = (ImageView) inflate.findViewById(2131824212);
            c34228b.mKv = (TextView) inflate.findViewById(2131824216);
            c34228b.mKw = (ImageView) inflate.findViewById(2131824215);
            c34228b.mKx = (TextView) inflate.findViewById(2131824214);
            c34228b.contentView = inflate.findViewById(2131821182);
            c34228b.mKk = inflate.findViewById(2131820896);
            inflate.setTag(c34228b);
            AppMethodBeat.m2505o(61982);
            return inflate;
        }

        /* renamed from: a */
        public void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61983);
            C34228b c34228b = (C34228b) c3155a;
            C3201m.m5501a(C45973f.this.mKl, c34228b.mKt);
            C40460b.m69434b(c34228b.mKu, C45973f.this.mKm);
            C3201m.m5501a(C45973f.this.mKn, c34228b.mKv);
            if (C5046bo.isNullOrNil(C45973f.this.mKo)) {
                c34228b.mKw.setVisibility(8);
            } else {
                c34228b.mKw.setVisibility(0);
                C40460b.m69434b(c34228b.mKw, C45973f.this.mKo);
            }
            C3201m.m5504q(c34228b.contentView, C45973f.this.mFk);
            if (C45973f.this.position == 0) {
                c34228b.mKk.setVisibility(8);
            } else {
                c34228b.mKk.setVisibility(0);
            }
            c34228b.mKx.setVisibility(0);
            AppMethodBeat.m2505o(61983);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.f$b */
    public class C34228b extends C3155a {
        public View contentView;
        public View mKk;
        public TextView mKt;
        public ImageView mKu;
        public TextView mKv;
        public ImageView mKw;
        public TextView mKx;

        public C34228b() {
            super();
        }
    }

    public C45973f(int i) {
        super(i);
        AppMethodBeat.m2504i(61984);
        AppMethodBeat.m2505o(61984);
    }

    /* JADX WARNING: Missing block: B:4:0x001a, code skipped:
            if (r11.showType != 2) goto L_0x00db;
     */
    /* JADX WARNING: Missing block: B:5:0x001c, code skipped:
            r11.mKm = r6;
     */
    /* JADX WARNING: Missing block: B:6:0x0022, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r5) != false) goto L_0x00c5;
     */
    /* JADX WARNING: Missing block: B:7:0x0024, code skipped:
            r11.mKl = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66570a(r0, r11.mKp.mDz, r2, r3, com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHv, r5 + "(", ")")).mDR;
     */
    /* JADX WARNING: Missing block: B:8:0x004d, code skipped:
            r11.mKl = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", r11.mKl, "\""});
            r11.mKn = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", android.text.TextUtils.ellipsize(com.tencent.p177mm.plugin.fts.p419a.C3161d.m5401LC(r11.mEp), com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHx, 300.0f, android.text.TextUtils.TruncateAt.END), r12.getString(com.tencent.p177mm.C25738R.string.e11)});
            r11.mKo = r11.mEp;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(61985);
     */
    /* JADX WARNING: Missing block: B:10:0x009f, code skipped:
            r2 = true;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:11:0x00a2, code skipped:
            r0 = com.tencent.p177mm.plugin.fts.p419a.C3161d.m5401LC(r6);
            r5 = null;
     */
    /* JADX WARNING: Missing block: B:13:0x00aa, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:14:0x00ab, code skipped:
            r0 = ((com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j.class)).mo15369XM().aoO(r6).field_nickname;
            r5 = com.tencent.p177mm.plugin.fts.p419a.C3161d.m5401LC(r6);
            r3 = r1;
     */
    /* JADX WARNING: Missing block: B:15:0x00c5, code skipped:
            r11.mKl = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66569a(r0, r11.mKp.mDz, r2, r3, 400.0f, com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHv)).mDR;
     */
    /* JADX WARNING: Missing block: B:16:0x00db, code skipped:
            r11.mKl = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", android.text.TextUtils.ellipsize(com.tencent.p177mm.plugin.fts.p419a.C3161d.m5401LC(r11.mEp), com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHx, 300.0f, android.text.TextUtils.TruncateAt.END), "\""});
            r11.mKm = r11.mEp;
            r11.mKo = r6;
     */
    /* JADX WARNING: Missing block: B:17:0x010d, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r5) != false) goto L_0x015e;
     */
    /* JADX WARNING: Missing block: B:18:0x010f, code skipped:
            r11.mKn = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66570a(r0, r11.mKp.mDz, r2, r3, com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHv, r5 + "(", ")")).mDR;
     */
    /* JADX WARNING: Missing block: B:19:0x0138, code skipped:
            r11.mKn = android.text.TextUtils.concat(new java.lang.CharSequence[]{"\"", r11.mKn, r12.getString(com.tencent.p177mm.C25738R.string.e11)});
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(61985);
     */
    /* JADX WARNING: Missing block: B:20:0x015e, code skipped:
            r11.mKn = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66569a(r0, r11.mKp.mDz, r2, r3, 400.0f, com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHv)).mDR;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(61985);
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

    /* renamed from: Ps */
    public C3156b mo7412Ps() {
        return this.mKq;
    }

    public final C3155a bBi() {
        return this.mKr;
    }
}
