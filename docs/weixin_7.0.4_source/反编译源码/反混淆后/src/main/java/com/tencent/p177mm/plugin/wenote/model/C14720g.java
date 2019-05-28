package com.tencent.p177mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C35738s;
import com.tencent.p177mm.plugin.wenote.model.p585a.C35740u;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44004m;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.g */
public final class C14720g extends C40369d implements C1202f {
    private static HashMap<C27966g, C44004m> uNi = new HashMap();
    private abh cAS = new abh();
    public boolean cHc = true;
    public long cHh = -1;
    private C27966g mjP;
    public String uNg;
    public String uNh = "";
    private int uNj = 0;
    private int uNk = 0;
    public String uNl;
    public int uNm = 0;
    public long uNn = 0;
    public String uNo;
    public String uNp;
    public boolean uNq = false;

    /* renamed from: com.tencent.mm.plugin.wenote.model.g$1 */
    public class C147211 implements Runnable {
        final /* synthetic */ abf uNr;

        public C147211(abf abf) {
            this.uNr = abf;
        }

        public final void run() {
            AppMethodBeat.m2504i(26616);
            C27966g c27966g = new C27966g();
            c27966g.field_localId = C14720g.this.cHh;
            c27966g.field_favProto = this.uNr;
            C14720g.this.uMZ = c27966g.field_favProto;
            C14720g.this.uMQ = c27966g;
            C14720g.this.mjP = c27966g;
            if (C14720g.uNi.containsKey(C14720g.this.mjP)) {
                C14720g.this.uMP = (C44004m) C14720g.uNi.get(C14720g.this.mjP);
            } else {
                C14720g.m22915c(C14720g.this);
            }
            C14720g.this.mo63731ef(C14720g.this.uMP.pJZ);
            if (C46457k.deT() != null) {
                C46457k.deX();
            }
            AppMethodBeat.m2505o(26616);
        }

        public final String toString() {
            AppMethodBeat.m2504i(26617);
            String str = super.toString() + "|dealWNoteInfo";
            AppMethodBeat.m2505o(26617);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(26634);
        AppMethodBeat.m2505o(26634);
    }

    public C14720g() {
        AppMethodBeat.m2504i(26620);
        this.uMR.clear();
        this.uMQ = null;
        uMW = "";
        this.uMY = false;
        C45932c.bvD();
        C9638aw.m17182Rg().mo14539a((int) v2helper.EMethodSetAgcRxOn, (C1202f) this);
        AppMethodBeat.m2505o(26620);
    }

    /* renamed from: a */
    public final void mo26986a(long j, Context context, Boolean bool, int i, int i2, abh abh, final abf abf) {
        AppMethodBeat.m2504i(26621);
        this.cHh = j;
        this.cHc = bool.booleanValue();
        this.uNj = i;
        this.uNk = i2;
        this.cAS = abh;
        ddJ();
        if (this.uNm == 0 && this.uMZ.wit != null) {
            this.uNm = this.uMZ.wit.cvp;
        }
        mo26988ab(context, 2);
        C7305d.xDH.mo10142ak(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(26618);
                if (abf != null) {
                    C27966g c27966g = new C27966g();
                    c27966g.field_localId = C14720g.this.cHh;
                    c27966g.field_favProto = abf;
                    C14720g.this.uMZ = c27966g.field_favProto;
                    C14720g.this.uMQ = c27966g;
                    C14720g.this.mjP = c27966g;
                }
                if (C14720g.uNi.containsKey(C14720g.this.mjP)) {
                    C14720g.this.uMP = (C44004m) C14720g.uNi.get(C14720g.this.mjP);
                } else {
                    C14720g.m22915c(C14720g.this);
                }
                C14720g.this.mo63731ef(C14720g.this.uMP.pJZ);
                if (C46457k.deT() != null) {
                    C46457k.deX();
                }
                AppMethodBeat.m2505o(26618);
            }

            public final String toString() {
                AppMethodBeat.m2504i(26619);
                String str = super.toString() + "|dealWNoteInfo";
                AppMethodBeat.m2505o(26619);
                return str;
            }
        });
        AppMethodBeat.m2505o(26621);
    }

    /* renamed from: ab */
    public final void mo26988ab(Context context, int i) {
        AppMethodBeat.m2504i(26622);
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", i);
        if (i == 4) {
            intent.putExtra("fav_note_thumbpath", this.uNo);
            intent.putExtra("fav_note_link_sns_xml", this.uNp);
        }
        intent.putExtra("edit_status", this.uMY);
        intent.putExtra("need_save", this.uNq);
        intent.putExtra("show_share", this.cHc);
        intent.putExtra("note_fav_localid", this.cHh);
        intent.putExtra("note_link_sns_localid", this.uNg);
        intent.putExtra("fav_note_xml", this.uNh);
        intent.putExtra("fav_note_scroll_to_position", this.uNj);
        intent.putExtra("fav_note_scroll_to_offset", this.uNk);
        intent.putExtra("fav_note_link_source_info", this.uNl);
        intent.putExtra("note_fav_post_scene", this.uNm);
        intent.putExtra("key_detail_fav_scene", this.cAS.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.cAS.jSW);
        intent.putExtra("key_detail_fav_index", this.cAS.index);
        intent.putExtra("key_detail_fav_query", this.cAS.query);
        intent.putExtra("key_detail_fav_sessionid", this.cAS.cvF);
        intent.putExtra("key_detail_fav_tags", this.cAS.mfg);
        C25985d.m41467b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        AppMethodBeat.m2505o(26622);
    }

    private void ddJ() {
        AppMethodBeat.m2504i(26623);
        this.mjP = C14719f.m22909jD(this.cHh);
        if (this.mjP == null) {
            AppMethodBeat.m2505o(26623);
            return;
        }
        if (this.uNn <= 0) {
            this.uNn = this.mjP.field_updateTime;
        }
        this.uMZ = this.mjP.field_favProto;
        this.uMQ = this.mjP;
        AppMethodBeat.m2505o(26623);
    }

    /* renamed from: b */
    public final String mo26990b(aar aar) {
        AppMethodBeat.m2504i(26624);
        String o = C14719f.m22910o(aar);
        AppMethodBeat.m2505o(26624);
        return o;
    }

    /* renamed from: c */
    public final String mo26994c(aar aar) {
        AppMethodBeat.m2504i(26625);
        String c = C14719f.m22907c(aar);
        AppMethodBeat.m2505o(26625);
        return c;
    }

    /* renamed from: n */
    public final void mo26996n(aar aar) {
        AppMethodBeat.m2504i(26626);
        C44004m c44004m = this.uMP;
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 28;
        c37721gh.cAH.cvv = c44004m.mnW.field_localId;
        c37721gh.cAH.cAJ = aar;
        c37721gh.cAH.path = "";
        c37721gh.cAH.cAO = 18;
        C4879a.xxA.mo10055m(c37721gh);
        AppMethodBeat.m2505o(26626);
    }

    /* renamed from: a */
    public final void mo26987a(aar aar, String str) {
        AppMethodBeat.m2504i(26627);
        C44004m c44004m = this.uMP;
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 28;
        c37721gh.cAH.cvv = c44004m.mnW.field_localId;
        c37721gh.cAH.cAJ = aar;
        c37721gh.cAH.path = str;
        c37721gh.cAH.cAO = 18;
        C4879a.xxA.mo10055m(c37721gh);
        AppMethodBeat.m2505o(26627);
    }

    /* renamed from: bm */
    public final void mo26991bm(Context context, String str) {
        AppMethodBeat.m2504i(26628);
        C35740u c35740u = (C35740u) this.uMT.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.uNh);
        if (c35740u != null) {
            intent.putExtra("key_detail_data_id", agX(str));
        }
        intent.putExtra("key_detail_can_delete", false);
        intent.putExtra("key_detail_info_id", this.cHh);
        intent.putExtra("key_detail_fav_scene", this.cAS.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.cAS.jSW);
        intent.putExtra("key_detail_fav_index", this.cAS.index);
        C39037b.m66352a(context, ".ui.detail.FavoriteFileDetailUI", intent, 1);
        AppMethodBeat.m2505o(26628);
    }

    /* renamed from: bo */
    public final void mo26993bo(Context context, String str) {
        AppMethodBeat.m2504i(26629);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.uNh);
        if (this.uMT.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((C29978o) this.uMT.get(str)).mnd);
        }
        intent.putExtra("key_detail_info_id", this.cHh);
        intent.putExtra("key_detail_fav_scene", this.cAS.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.cAS.jSW);
        intent.putExtra("key_detail_fav_index", this.cAS.index);
        C39037b.m66352a(context, ".ui.FavImgGalleryUI", intent, 1);
        AppMethodBeat.m2505o(26629);
    }

    /* renamed from: bn */
    public final void mo26992bn(Context context, String str) {
        AppMethodBeat.m2504i(26630);
        String str2 = "";
        C35738s c35738s = (C35738s) this.uMT.get(str);
        if (c35738s == null) {
            C30379h.m48465bQ(context, C4996ah.getContext().getString(C25738R.string.bqo));
            AppMethodBeat.m2505o(26630);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kwebmap_slat", c35738s.lat);
        intent.putExtra("kwebmap_lng", c35738s.lng);
        intent.putExtra("kPoiName", c35738s.eUu);
        intent.putExtra("Kwebmap_locaion", c35738s.fBg);
        if (c35738s.scale >= 0.0d) {
            intent.putExtra("kwebmap_scale", c35738s.scale);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.cHh);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        C25985d.m41468b(context, C8741b.LOCATION, ".ui.RedirectUI", intent, 1);
        AppMethodBeat.m2505o(26630);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26631);
        if (c1207m.getType() == v2helper.EMethodSetAgcRxOn) {
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.cwn = c1207m;
            c37721gh.cAH.type = 31;
            C4879a.xxA.mo10055m(c37721gh);
            if (!C5046bo.isNullOrNil(c37721gh.cAI.path) && i2 == -435) {
                C4990ab.m7412e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            C9638aw.m17182Rg().mo14546b((int) v2helper.EMethodSetAgcRxOn, (C1202f) this);
            AppMethodBeat.m2505o(26631);
            return;
        }
        AppMethodBeat.m2505o(26631);
    }

    public final void agU(String str) {
        this.uNh = str;
    }

    public final String ddH() {
        return this.uNh;
    }

    private String agX(String str) {
        AppMethodBeat.m2504i(26632);
        C27966g jD = C14719f.m22909jD(this.cHh);
        String str2;
        if (jD == null) {
            str2 = ((C29978o) this.uMT.get(str)).mnd;
            AppMethodBeat.m2505o(26632);
            return str2;
        }
        Iterator it = jD.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (!C5046bo.isNullOrNil(aar.whb) && aar.whb.equals(str)) {
                str2 = aar.mnd;
                AppMethodBeat.m2505o(26632);
                return str2;
            }
        }
        str2 = ((C29978o) this.uMT.get(str)).mnd;
        AppMethodBeat.m2505o(26632);
        return str2;
    }
}
