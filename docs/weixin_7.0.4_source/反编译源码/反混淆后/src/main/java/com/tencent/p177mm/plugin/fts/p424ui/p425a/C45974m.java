package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C20875a;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.ttpic.wav.WavFileHeader;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.m */
public class C45974m extends C3154a {
    public CharSequence gnx;
    public CharSequence gny;
    public C45966l hpS;
    public int mKY;
    public CharSequence mKZ;
    private C44741b mLa = new C44741b();
    C43131a mLb = new C43131a();
    public String username;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.m$a */
    public class C43131a extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView ejp;
        public TextView ene;
        public TextView enf;

        public C43131a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.m$b */
    public class C44741b extends C3156b {
        public C44741b() {
            super();
        }

        /* renamed from: a */
        public View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(62013);
            View inflate = LayoutInflater.from(context).inflate(2130969635, viewGroup, false);
            C43131a c43131a = C45974m.this.mLb;
            c43131a.ejo = (ImageView) inflate.findViewById(2131821183);
            c43131a.ejp = (TextView) inflate.findViewById(2131823149);
            c43131a.ene = (TextView) inflate.findViewById(2131822913);
            c43131a.enf = (TextView) inflate.findViewById(2131820988);
            c43131a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c43131a);
            AppMethodBeat.m2505o(62013);
            return inflate;
        }

        /* renamed from: a */
        public void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(62014);
            C45974m c45974m = (C45974m) c3154a;
            C43131a c43131a = (C43131a) c3155a;
            C3201m.m5503p(c43131a.contentView, C45974m.this.mFk);
            C40460b.m69434b(c43131a.ejo, c45974m.username);
            C3201m.m5501a(c45974m.gny, c43131a.ene);
            C3201m.m5501a(c45974m.mKZ, c43131a.enf);
            if (C1855t.m3903mP(c45974m.username)) {
                C3201m.m5501a(((C32873b) C1720g.m3528K(C32873b.class)).mo44298a(context, c45974m.gnx), c43131a.ejp);
                AppMethodBeat.m2505o(62014);
            } else if (C7616ad.aox(c45974m.username)) {
                C1720g.m3537RQ();
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c45974m.username);
                ((C32873b) C1720g.m3528K(C32873b.class)).mo44302a(c43131a.ejp.getContext(), c43131a.ejp, c45974m.gnx, aoO.field_openImAppid, aoO.field_descWordingId, (int) c43131a.ejp.getTextSize());
                AppMethodBeat.m2505o(62014);
            } else {
                C3201m.m5501a(c45974m.gnx, c43131a.ejp);
                AppMethodBeat.m2505o(62014);
            }
        }

        /* renamed from: a */
        public boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(62015);
            boolean a = ((C12029n) C1720g.m3530M(C12029n.class)).getItemClickHandler(C45974m.this.klY).mo7423a(context, c3154a);
            AppMethodBeat.m2505o(62015);
            return a;
        }
    }

    public C45974m(int i) {
        super(6, i);
        AppMethodBeat.m2504i(62016);
        AppMethodBeat.m2505o(62016);
    }

    /* renamed from: a */
    public void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(62017);
        C43131a c43131a = (C43131a) c3155a;
        this.username = this.hpS.mDx;
        this.gnx = C44089j.m79300d(context, C3161d.m5401LC(this.username), c43131a.ejp.getTextSize());
        if (this.hpS.userData instanceof Integer) {
            this.mKY = ((Integer) this.hpS.userData).intValue();
        }
        if (this.mKY < 2) {
            CharSequence charSequence = "";
            String str = "";
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.hpS.mEB);
            C8910b me;
            String str2;
            Object charSequence2;
            switch (this.hpS.mDw) {
                case 41:
                    str = jf.field_content;
                    if (C1855t.m3901mN(this.username)) {
                        str = C1829bf.m3763oz(str);
                        break;
                    }
                    break;
                case 42:
                    me = C8910b.m16064me(jf.field_content);
                    if (me != null) {
                        str2 = me.title;
                    } else {
                        str2 = str;
                    }
                    charSequence2 = context.getString(C25738R.string.c23);
                    str = str2;
                    break;
                case 43:
                    me = C8910b.m16064me(jf.field_content);
                    if (me != null) {
                        str = me.title;
                    }
                    charSequence2 = context.getString(C25738R.string.c24);
                    break;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    C8910b me2 = C8910b.m16064me(jf.field_content);
                    if (me2 != null) {
                        str2 = me2.title + ": ";
                        str = me2.description;
                        charSequence2 = str2;
                        break;
                    }
                    break;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    me = C8910b.m16064me(jf.field_content);
                    if (me != null) {
                        str = C5046bo.m7532bc(me.title, "") + ": " + C5046bo.m7532bc(me.description, "");
                        break;
                    }
                    break;
                case 46:
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    C8910b me3 = C8910b.m16064me(jf.field_content);
                    if (me3 != null) {
                        if (jf.field_isSend != 1) {
                            str = C5046bo.m7532bc(me3.fhW, "") + ": " + C5046bo.m7532bc(me3.fhS, "");
                            break;
                        } else {
                            str = C5046bo.m7532bc(me3.fhW, "") + ": " + C5046bo.m7532bc(me3.fhT, "");
                            break;
                        }
                    }
                    str = "";
                    break;
                case 48:
                    me = C8910b.m16064me(jf.field_content);
                    if (me != null) {
                        str = me.title;
                    }
                    charSequence2 = context.getString(C25738R.string.c22);
                    break;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    me = C8910b.m16064me(jf.field_content);
                    if (me != null) {
                        str = me.description;
                    }
                    charSequence2 = context.getString(C25738R.string.c26);
                    break;
                case 50:
                    str2 = jf.field_content;
                    if (C1855t.m3896kH(this.username)) {
                        str = C1829bf.m3763oz(str2);
                    } else {
                        str = str2;
                    }
                    if (!C5046bo.isNullOrNil(str)) {
                        C5136b Ro = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15261Ro(str);
                        if (Ro.dua()) {
                            str = Ro.eUu;
                        }
                    }
                    charSequence2 = context.getString(C25738R.string.c25);
                    break;
            }
            this.gny = C44089j.m79300d(context, C5046bo.m7532bc(str, "").replace(10, ' '), (float) C3197c.mHy);
            if (C5046bo.m7519ac(charSequence2)) {
                this.gny = C34204f.m56086a(C39127d.m66567a(this.gny, this.mDz, (float) C20875a.mHq, C3197c.mHz)).mDR;
            } else {
                this.gny = C34204f.m56086a(C39127d.m66567a(this.gny, this.mDz, ((float) C20875a.mHq) - C3197c.mHz.measureText(charSequence2.toString()), C3197c.mHz)).mDR;
                this.gny = TextUtils.concat(new CharSequence[]{charSequence2, this.gny});
            }
            this.mKZ = C14835h.m23089c(context, this.hpS.timestamp, true);
            AppMethodBeat.m2505o(62017);
            return;
        }
        this.gny = context.getResources().getString(C25738R.string.e0q, new Object[]{Integer.valueOf(this.mKY)});
        AppMethodBeat.m2505o(62017);
    }

    /* renamed from: Ps */
    public C3156b mo7412Ps() {
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
