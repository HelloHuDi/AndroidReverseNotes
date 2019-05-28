package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C32677t;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c.C28110a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43121f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.q */
public final class C6925q extends C3154a {
    public C7616ad ehM;
    public C45966l hpS;
    public CharSequence jMY;
    public CharSequence jMZ;
    public CharSequence mLl;
    private C6927b mLm = new C6927b();
    C6926a mLn = new C6926a();
    public String username;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.q$a */
    public class C6926a extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        public C6926a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.q$b */
    public class C6927b extends C3156b {
        public C6927b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(62029);
            View inflate = LayoutInflater.from(context).inflate(2130969613, viewGroup, false);
            C6926a c6926a = C6925q.this.mLn;
            c6926a.ejo = (ImageView) inflate.findViewById(2131821183);
            c6926a.gnB = (TextView) inflate.findViewById(2131821185);
            c6926a.gnC = (TextView) inflate.findViewById(2131820991);
            c6926a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c6926a);
            AppMethodBeat.m2505o(62029);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(62030);
            C6926a c6926a = (C6926a) c3155a;
            C6925q c6925q = (C6925q) c3154a;
            C3201m.m5503p(c6926a.contentView, C6925q.this.mFk);
            if (c6925q.username == null || c6925q.username.length() <= 0) {
                c6926a.ejo.setImageResource(C25738R.drawable.ad2);
            } else {
                C40460b.m69434b(c6926a.ejo, c6925q.username);
            }
            if (C1855t.m3903mP(c6925q.username)) {
                C3201m.m5501a(((C32873b) C1720g.m3528K(C32873b.class)).mo44298a(context, c6925q.jMY), c6926a.gnB);
            } else {
                C3201m.m5501a(c6925q.jMY, c6926a.gnB);
            }
            c6926a.gnB.setMaxWidth(C1338a.fromDPToPix(context, 200));
            C3201m.m5501a(c6925q.jMZ, c6926a.gnC);
            AppMethodBeat.m2505o(62030);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(62031);
            C6925q c6925q = (C6925q) c3154a;
            C3156b.m5386a(C6925q.this.mDz.mDY, c6925q.hpS);
            Intent putExtra = new Intent().putExtra("Chat_User", c6925q.username).putExtra("finish_direct", true);
            if (C1855t.m3903mP(c6925q.username)) {
                C32677t c32677t = new C32677t();
                c32677t.mo53208eO(c6925q.username);
                c32677t.cXP = 3;
                c32677t.ajK();
            }
            C25985d.m41473f(context, ".ui.chatting.ChattingUI", putExtra);
            AppMethodBeat.m2505o(62031);
            return true;
        }
    }

    public C6925q(int i) {
        super(2, i);
        AppMethodBeat.m2504i(62032);
        AppMethodBeat.m2505o(62032);
    }

    /* JADX WARNING: Missing block: B:5:0x003a, code skipped:
            if (r1 == null) goto L_0x00e8;
     */
    /* JADX WARNING: Missing block: B:6:0x003c, code skipped:
            r10.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r11, r7, (float) com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHw);
            r10.jMY = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66569a(r10.jMY, r10.mDz, r2, r3, (float) com.tencent.p177mm.plugin.fts.p424ui.C45976b.C20875a.mHq, com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHx)).mDR;
     */
    /* JADX WARNING: Missing block: B:7:0x005a, code skipped:
            r10.jMZ = r6;
     */
    /* JADX WARNING: Missing block: B:8:0x005c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(62033);
     */
    /* JADX WARNING: Missing block: B:10:0x0061, code skipped:
            r3 = r0;
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:12:?, code skipped:
            r10.jMZ = r10.ehM.field_nickname;
            r6 = null;
     */
    /* JADX WARNING: Missing block: B:28:0x00e8, code skipped:
            r10.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r11, r7, (float) com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHw);
            r0 = r10.jMY;
            r1 = r10.mLl;
            r2 = (float) com.tencent.p177mm.plugin.fts.p424ui.C45976b.C20875a.mHq;
            r3 = com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHx;
            r4 = android.text.TextUtils.TruncateAt.END;
            r2 = r2 - r3.measureText(r1.toString());
            r10.jMY = android.text.TextUtils.concat(new java.lang.CharSequence[]{android.text.TextUtils.ellipsize(r0, r3, r2, r4), r1});
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        Object obj = 1;
        AppMethodBeat.m2504i(62033);
        this.username = this.hpS.mDx;
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.username);
        try {
            Resources resources = context.getResources();
            CharSequence LC = C3161d.m5401LC(this.ehM.field_username);
            boolean z;
            boolean z2;
            boolean z3;
            CharSequence charSequence;
            switch (this.hpS.mDw) {
                case 1:
                case 5:
                    z = false;
                    z2 = false;
                    break;
                case 2:
                case 6:
                    z3 = false;
                    break;
                case 3:
                case 7:
                    z3 = true;
                    break;
                case 38:
                    String[] strArr;
                    Cursor a = C1720g.m3536RP().eJN.mo10104a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{this.ehM.field_username}, 2);
                    if (a.moveToFirst()) {
                        String string = a.getString(0);
                        if (string == null) {
                            strArr = null;
                        } else {
                            strArr = C28110a.mCy.split(string);
                        }
                    } else {
                        strArr = null;
                    }
                    a.close();
                    if (strArr != null && strArr.length > 0) {
                        this.mLl = "(" + strArr.length + ")";
                    }
                    if (!(strArr == null || this.hpS.mEI == null)) {
                        CharSequence a2 = C3201m.m5498a(context, this.hpS.mEI, strArr, this.mDz, C3197c.mHz);
                        String string2 = resources.getString(C25738R.string.e03);
                        CharSequence concat = TextUtils.concat(new CharSequence[]{string2, a2});
                        z = false;
                        z2 = false;
                        obj = null;
                        charSequence = concat;
                        break;
                    }
                default:
                    z = false;
                    z2 = false;
                    obj = null;
                    charSequence = null;
                    break;
            }
        } catch (Exception e) {
            if (this.jMY == null) {
                this.jMY = C3161d.m5401LC(this.ehM.field_username);
            }
            AppMethodBeat.m2505o(62033);
        }
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mLm;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }

    public final int bAu() {
        int i;
        AppMethodBeat.m2504i(62034);
        if (this.hpS.mDw == 38) {
            List list = this.hpS.mEI;
            if (list != null && list.size() > 0) {
                i = ((C43121f) list.get(0)).mDw;
                AppMethodBeat.m2505o(62034);
                return i;
            }
        }
        i = super.bAu();
        AppMethodBeat.m2505o(62034);
        return i;
    }

    public final boolean bAv() {
        return this.hpS.mEL;
    }
}
