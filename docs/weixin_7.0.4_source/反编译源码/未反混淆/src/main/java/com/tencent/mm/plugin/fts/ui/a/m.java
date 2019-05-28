package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.wav.WavFileHeader;
import org.xwalk.core.XWalkEnvironment;

public class m extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence gnx;
    public CharSequence gny;
    public l hpS;
    public int mKY;
    public CharSequence mKZ;
    private b mLa = new b();
    a mLb = new a();
    public String username;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView ejp;
        public TextView ene;
        public TextView enf;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(62013);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1t, viewGroup, false);
            a aVar = m.this.mLb;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.ejp = (TextView) inflate.findViewById(R.id.b6e);
            aVar.ene = (TextView) inflate.findViewById(R.id.b01);
            aVar.enf = (TextView) inflate.findViewById(R.id.la);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(62013);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(62014);
            m mVar = (m) aVar2;
            a aVar3 = (a) aVar;
            com.tencent.mm.plugin.fts.ui.m.p(aVar3.contentView, m.this.mFk);
            com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, mVar.username);
            com.tencent.mm.plugin.fts.ui.m.a(mVar.gny, aVar3.ene);
            com.tencent.mm.plugin.fts.ui.m.a(mVar.mKZ, aVar3.enf);
            if (t.mP(mVar.username)) {
                com.tencent.mm.plugin.fts.ui.m.a(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(context, mVar.gnx), aVar3.ejp);
                AppMethodBeat.o(62014);
            } else if (ad.aox(mVar.username)) {
                g.RQ();
                ad aoO = ((j) g.K(j.class)).XM().aoO(mVar.username);
                ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(aVar3.ejp.getContext(), aVar3.ejp, mVar.gnx, aoO.field_openImAppid, aoO.field_descWordingId, (int) aVar3.ejp.getTextSize());
                AppMethodBeat.o(62014);
            } else {
                com.tencent.mm.plugin.fts.ui.m.a(mVar.gnx, aVar3.ejp);
                AppMethodBeat.o(62014);
            }
        }

        public boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(62015);
            boolean a = ((n) g.M(n.class)).getItemClickHandler(m.this.klY).a(context, aVar);
            AppMethodBeat.o(62015);
            return a;
        }
    }

    public m(int i) {
        super(6, i);
        AppMethodBeat.i(62016);
        AppMethodBeat.o(62016);
    }

    public void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(62017);
        a aVar2 = (a) aVar;
        this.username = this.hpS.mDx;
        this.gnx = com.tencent.mm.pluginsdk.ui.e.j.d(context, d.LC(this.username), aVar2.ejp.getTextSize());
        if (this.hpS.userData instanceof Integer) {
            this.mKY = ((Integer) this.hpS.userData).intValue();
        }
        if (this.mKY < 2) {
            CharSequence charSequence = "";
            String str = "";
            bi jf = ((j) g.K(j.class)).bOr().jf(this.hpS.mEB);
            com.tencent.mm.af.j.b me;
            String str2;
            Object charSequence2;
            switch (this.hpS.mDw) {
                case 41:
                    str = jf.field_content;
                    if (t.mN(this.username)) {
                        str = bf.oz(str);
                        break;
                    }
                    break;
                case 42:
                    me = com.tencent.mm.af.j.b.me(jf.field_content);
                    if (me != null) {
                        str2 = me.title;
                    } else {
                        str2 = str;
                    }
                    charSequence2 = context.getString(R.string.c23);
                    str = str2;
                    break;
                case 43:
                    me = com.tencent.mm.af.j.b.me(jf.field_content);
                    if (me != null) {
                        str = me.title;
                    }
                    charSequence2 = context.getString(R.string.c24);
                    break;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    com.tencent.mm.af.j.b me2 = com.tencent.mm.af.j.b.me(jf.field_content);
                    if (me2 != null) {
                        str2 = me2.title + ": ";
                        str = me2.description;
                        charSequence2 = str2;
                        break;
                    }
                    break;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    me = com.tencent.mm.af.j.b.me(jf.field_content);
                    if (me != null) {
                        str = bo.bc(me.title, "") + ": " + bo.bc(me.description, "");
                        break;
                    }
                    break;
                case 46:
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    com.tencent.mm.af.j.b me3 = com.tencent.mm.af.j.b.me(jf.field_content);
                    if (me3 != null) {
                        if (jf.field_isSend != 1) {
                            str = bo.bc(me3.fhW, "") + ": " + bo.bc(me3.fhS, "");
                            break;
                        } else {
                            str = bo.bc(me3.fhW, "") + ": " + bo.bc(me3.fhT, "");
                            break;
                        }
                    }
                    str = "";
                    break;
                case 48:
                    me = com.tencent.mm.af.j.b.me(jf.field_content);
                    if (me != null) {
                        str = me.title;
                    }
                    charSequence2 = context.getString(R.string.c22);
                    break;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    me = com.tencent.mm.af.j.b.me(jf.field_content);
                    if (me != null) {
                        str = me.description;
                    }
                    charSequence2 = context.getString(R.string.c26);
                    break;
                case 50:
                    str2 = jf.field_content;
                    if (t.kH(this.username)) {
                        str = bf.oz(str2);
                    } else {
                        str = str2;
                    }
                    if (!bo.isNullOrNil(str)) {
                        com.tencent.mm.storage.bi.b Ro = ((j) g.K(j.class)).bOr().Ro(str);
                        if (Ro.dua()) {
                            str = Ro.eUu;
                        }
                    }
                    charSequence2 = context.getString(R.string.c25);
                    break;
            }
            this.gny = com.tencent.mm.pluginsdk.ui.e.j.d(context, bo.bc(str, "").replace(10, ' '), (float) c.mHy);
            if (bo.ac(charSequence2)) {
                this.gny = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gny, this.mDz, (float) com.tencent.mm.plugin.fts.ui.b.a.mHq, c.mHz)).mDR;
            } else {
                this.gny = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gny, this.mDz, ((float) com.tencent.mm.plugin.fts.ui.b.a.mHq) - c.mHz.measureText(charSequence2.toString()), c.mHz)).mDR;
                this.gny = TextUtils.concat(new CharSequence[]{charSequence2, this.gny});
            }
            this.mKZ = h.c(context, this.hpS.timestamp, true);
            AppMethodBeat.o(62017);
            return;
        }
        this.gny = context.getResources().getString(R.string.e0q, new Object[]{Integer.valueOf(this.mKY)});
        AppMethodBeat.o(62017);
    }

    public com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mLa;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }

    public int bAw() {
        if (this.mKY < 2) {
            return 0;
        }
        return 1;
    }
}
