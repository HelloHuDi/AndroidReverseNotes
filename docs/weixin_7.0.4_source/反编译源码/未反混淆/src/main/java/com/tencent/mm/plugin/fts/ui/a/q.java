package com.tencent.mm.plugin.fts.ui.a;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class q extends com.tencent.mm.plugin.fts.a.d.a.a {
    public ad ehM;
    public l hpS;
    public CharSequence jMY;
    public CharSequence jMZ;
    public CharSequence mLl;
    private b mLm = new b();
    a mLn = new a();
    public String username;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(62029);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a18, viewGroup, false);
            a aVar = q.this.mLn;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(62029);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(62030);
            a aVar3 = (a) aVar;
            q qVar = (q) aVar2;
            m.p(aVar3.contentView, q.this.mFk);
            if (qVar.username == null || qVar.username.length() <= 0) {
                aVar3.ejo.setImageResource(R.drawable.ad2);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, qVar.username);
            }
            if (t.mP(qVar.username)) {
                m.a(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(context, qVar.jMY), aVar3.gnB);
            } else {
                m.a(qVar.jMY, aVar3.gnB);
            }
            aVar3.gnB.setMaxWidth(com.tencent.mm.bz.a.fromDPToPix(context, 200));
            m.a(qVar.jMZ, aVar3.gnC);
            AppMethodBeat.o(62030);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(62031);
            q qVar = (q) aVar;
            com.tencent.mm.plugin.fts.a.d.a.a.b.a(q.this.mDz.mDY, qVar.hpS);
            Intent putExtra = new Intent().putExtra("Chat_User", qVar.username).putExtra("finish_direct", true);
            if (t.mP(qVar.username)) {
                com.tencent.mm.g.b.a.t tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(qVar.username);
                tVar.cXP = 3;
                tVar.ajK();
            }
            d.f(context, ".ui.chatting.ChattingUI", putExtra);
            AppMethodBeat.o(62031);
            return true;
        }
    }

    public q(int i) {
        super(2, i);
        AppMethodBeat.i(62032);
        AppMethodBeat.o(62032);
    }

    /* JADX WARNING: Missing block: B:5:0x003a, code skipped:
            if (r1 == null) goto L_0x00e8;
     */
    /* JADX WARNING: Missing block: B:6:0x003c, code skipped:
            r10.jMY = com.tencent.mm.pluginsdk.ui.e.j.d(r11, r7, (float) com.tencent.mm.plugin.fts.ui.b.c.mHw);
            r10.jMY = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r10.jMY, r10.mDz, r2, r3, (float) com.tencent.mm.plugin.fts.ui.b.a.mHq, com.tencent.mm.plugin.fts.ui.b.c.mHx)).mDR;
     */
    /* JADX WARNING: Missing block: B:7:0x005a, code skipped:
            r10.jMZ = r6;
     */
    /* JADX WARNING: Missing block: B:8:0x005c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(62033);
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
            r10.jMY = com.tencent.mm.pluginsdk.ui.e.j.d(r11, r7, (float) com.tencent.mm.plugin.fts.ui.b.c.mHw);
            r0 = r10.jMY;
            r1 = r10.mLl;
            r2 = (float) com.tencent.mm.plugin.fts.ui.b.a.mHq;
            r3 = com.tencent.mm.plugin.fts.ui.b.c.mHx;
            r4 = android.text.TextUtils.TruncateAt.END;
            r2 = r2 - r3.measureText(r1.toString());
            r10.jMY = android.text.TextUtils.concat(new java.lang.CharSequence[]{android.text.TextUtils.ellipsize(r0, r3, r2, r4), r1});
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        Object obj = 1;
        AppMethodBeat.i(62033);
        this.username = this.hpS.mDx;
        this.ehM = ((j) g.K(j.class)).XM().aoO(this.username);
        try {
            Resources resources = context.getResources();
            CharSequence LC = com.tencent.mm.plugin.fts.a.d.LC(this.ehM.field_username);
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
                    Cursor a = g.RP().eJN.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{this.ehM.field_username}, 2);
                    if (a.moveToFirst()) {
                        String string = a.getString(0);
                        if (string == null) {
                            strArr = null;
                        } else {
                            strArr = com.tencent.mm.plugin.fts.a.c.a.mCy.split(string);
                        }
                    } else {
                        strArr = null;
                    }
                    a.close();
                    if (strArr != null && strArr.length > 0) {
                        this.mLl = "(" + strArr.length + ")";
                    }
                    if (!(strArr == null || this.hpS.mEI == null)) {
                        CharSequence a2 = m.a(context, this.hpS.mEI, strArr, this.mDz, c.mHz);
                        String string2 = resources.getString(R.string.e03);
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
                this.jMY = com.tencent.mm.plugin.fts.a.d.LC(this.ehM.field_username);
            }
            AppMethodBeat.o(62033);
        }
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mLm;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }

    public final int bAu() {
        int i;
        AppMethodBeat.i(62034);
        if (this.hpS.mDw == 38) {
            List list = this.hpS.mEI;
            if (list != null && list.size() > 0) {
                i = ((f) list.get(0)).mDw;
                AppMethodBeat.o(62034);
                return i;
            }
        }
        i = super.bAu();
        AppMethodBeat.o(62034);
        return i;
    }

    public final boolean bAv() {
        return this.hpS.mEL;
    }
}
