package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43120c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.j */
public final class C28144j extends C3154a {
    public int actionType = -1;
    public C45966l hpS;
    public CharSequence mKK;
    public String mKL;
    public C43120c mKM;
    private C28143b mKN = new C28143b();
    C12063a mKO = new C12063a();
    public CharSequence mnr;
    public String mnu;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.j$a */
    public class C12063a extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        public C12063a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.j$b */
    public class C28143b extends C3156b {
        public C28143b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(62000);
            View inflate = LayoutInflater.from(context).inflate(2130969613, viewGroup, false);
            C12063a c12063a = C28144j.this.mKO;
            c12063a.ejo = (ImageView) inflate.findViewById(2131821183);
            c12063a.gnB = (TextView) inflate.findViewById(2131821185);
            c12063a.gnC = (TextView) inflate.findViewById(2131820991);
            c12063a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c12063a);
            AppMethodBeat.m2505o(62000);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(62001);
            C12063a c12063a = (C12063a) c3155a;
            C28144j c28144j = (C28144j) c3154a;
            C3201m.m5503p(c12063a.contentView, C28144j.this.mFk);
            C3201m.m5501a(C28144j.this.mnr, c12063a.gnB);
            C3201m.m5501a(C28144j.this.mKK, c12063a.gnC);
            C3201m.m5499a(context, c12063a.ejo, null, c28144j.mnu, (int) C1318a.fts_default_img);
            AppMethodBeat.m2505o(62001);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(62002);
            boolean a = ((C12029n) C1720g.m3530M(C12029n.class)).getItemClickHandler(C28144j.this.klY).mo7423a(context, c3154a);
            AppMethodBeat.m2505o(62002);
            return a;
        }
    }

    public C28144j(int i) {
        super(3, i);
        AppMethodBeat.m2504i(62003);
        AppMethodBeat.m2505o(62003);
    }

    /* JADX WARNING: Missing block: B:5:0x003d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(62004);
     */
    /* JADX WARNING: Missing block: B:7:0x0042, code skipped:
            r5.mnr = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r5.mnr, r5.mDz, r1, r0)).mDR;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(62004);
     */
    /* JADX WARNING: Missing block: B:12:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:13:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        boolean z = true;
        AppMethodBeat.m2504i(62004);
        this.mKM = (C43120c) this.hpS.userData;
        if (this.mKM != null) {
            this.mnr = this.mKM.field_title;
            this.mKK = this.mKM.field_tag;
            this.mnu = this.mKM.field_iconPath;
            this.mKL = this.mKM.field_androidUrl;
            this.actionType = this.mKM.field_actionType;
            boolean z2;
            switch (this.hpS.mDw) {
                case 1:
                    z = false;
                    z2 = false;
                    break;
                case 2:
                    z2 = false;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    this.mKK = C34204f.m56086a(C39127d.m66566a(this.mKK, this.mDz)).mDR;
                    break;
            }
        }
        AppMethodBeat.m2505o(62004);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mKN;
    }

    public final String aAp() {
        return this.mKM.field_title;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}
