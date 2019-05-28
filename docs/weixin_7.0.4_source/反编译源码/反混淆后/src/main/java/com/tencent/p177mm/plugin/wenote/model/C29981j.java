package com.tencent.p177mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C35738s;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44004m;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wenote.model.j */
public final class C29981j extends C40369d {
    private static HashMap<String, C44004m> uNJ = new HashMap();
    private abh cAS = new abh();
    private String cHP;
    private boolean cHc;
    private C44099c pKz = null;
    private Long uNH;
    private boolean uNI = false;
    private int uNj = 0;
    private int uNk = 0;
    private String uNl;

    /* renamed from: com.tencent.mm.plugin.wenote.model.j$1 */
    class C299821 implements Runnable {
        C299821() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26649);
            C29981j.m47443a(C29981j.this);
            C29981j.this.mo63731ef(C29981j.this.uMP.pJZ);
            if (C46457k.deT() != null) {
                C46457k.deX();
            }
            AppMethodBeat.m2505o(26649);
        }

        public final String toString() {
            AppMethodBeat.m2504i(26650);
            String str = super.toString() + "|dealWNoteInfo";
            AppMethodBeat.m2505o(26650);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(26663);
        AppMethodBeat.m2505o(26663);
    }

    public C29981j() {
        AppMethodBeat.m2504i(26651);
        this.uMR.clear();
        C45932c.bvD();
        AppMethodBeat.m2505o(26651);
    }

    /* renamed from: a */
    public final void mo48223a(String str, Long l, boolean z, Context context, int i, int i2, abh abh) {
        AppMethodBeat.m2504i(26652);
        this.cHP = str;
        this.uNH = l;
        this.cHc = z;
        this.uNj = i;
        this.uNk = i2;
        this.cAS = abh;
        this.pKz = C29981j.m47442VI(str);
        if (!(this.pKz == null || this.pKz.fjr == null || this.pKz.fjr.size() <= 1)) {
            C18348nt c18348nt = new C18348nt();
            c18348nt.cJY.type = 9;
            c18348nt.cJY.cAv = (aar) this.pKz.fjr.get(0);
            c18348nt.cJY.cvx = this.uNH.longValue();
            C4879a.xxA.mo10055m(c18348nt);
            this.uNI = c18348nt.cJZ.cKj;
        }
        if (this.pKz == null || this.pKz.vzK == null) {
            this.uNl = null;
        } else {
            this.uNl = this.pKz.vzK.wim + ";" + this.pKz.vzK.win + ";" + this.pKz.lgR;
        }
        m47444fx(context);
        C9638aw.m17180RS().mo10302aa(new C299821());
        AppMethodBeat.m2505o(26652);
    }

    /* renamed from: fx */
    private void m47444fx(Context context) {
        AppMethodBeat.m2504i(26653);
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", 1);
        intent.putExtra("edit_status", this.uMY);
        intent.putExtra("note_msgid", this.uNH);
        intent.putExtra("record_show_share", this.cHc);
        intent.putExtra("fav_note_xml", this.cHP);
        intent.putExtra("fav_note_out_of_date", this.uNI);
        intent.putExtra("fav_note_scroll_to_position", this.uNj);
        intent.putExtra("fav_note_scroll_to_offset", this.uNk);
        intent.putExtra("fav_note_scroll_to_offset", this.uNk);
        if (!C5046bo.isNullOrNil(this.uNl)) {
            intent.putExtra("fav_note_link_source_info", this.uNl);
        }
        intent.putExtra("key_detail_fav_scene", this.cAS.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.cAS.jSW);
        intent.putExtra("key_detail_fav_index", this.cAS.index);
        C25985d.m41467b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        AppMethodBeat.m2505o(26653);
    }

    /* renamed from: VI */
    private static C44099c m47442VI(String str) {
        AppMethodBeat.m2504i(26654);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 0;
        c18348nt.cJY.cKa = str;
        C4879a.xxA.mo10055m(c18348nt);
        C44099c c44099c = c18348nt.cJZ.cKi;
        AppMethodBeat.m2505o(26654);
        return c44099c;
    }

    /* renamed from: b */
    public final String mo26990b(aar aar) {
        AppMethodBeat.m2504i(26655);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = this.uNH.longValue();
        C4879a.xxA.mo10055m(c18348nt);
        String str = c18348nt.cJZ.dataPath;
        AppMethodBeat.m2505o(26655);
        return str;
    }

    /* renamed from: c */
    public final String mo26994c(aar aar) {
        AppMethodBeat.m2504i(26656);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = this.uNH.longValue();
        C4879a.xxA.mo10055m(c18348nt);
        String str = c18348nt.cJZ.thumbPath;
        AppMethodBeat.m2505o(26656);
        return str;
    }

    /* renamed from: n */
    public final void mo26996n(aar aar) {
        AppMethodBeat.m2504i(26657);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 8;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = this.uNH.longValue();
        c18348nt.cJY.thumbPath = "";
        C4879a.xxA.mo10055m(c18348nt);
        AppMethodBeat.m2505o(26657);
    }

    /* renamed from: a */
    public final void mo26987a(aar aar, String str) {
        AppMethodBeat.m2504i(26658);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 8;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = this.uNH.longValue();
        c18348nt.cJY.thumbPath = str;
        C4879a.xxA.mo10055m(c18348nt);
        AppMethodBeat.m2505o(26658);
    }

    /* renamed from: bm */
    public final void mo26991bm(Context context, String str) {
        AppMethodBeat.m2504i(26659);
        Intent intent = new Intent();
        intent.putExtra("message_id", this.uNH);
        intent.putExtra("record_xml", this.cHP);
        intent.putExtra("record_data_id", ((C29978o) this.uMT.get(str)).mnd);
        C25985d.m41467b(C4996ah.getContext(), "record", ".ui.RecordMsgFileUI", intent);
        AppMethodBeat.m2505o(26659);
    }

    /* renamed from: bo */
    public final void mo26993bo(Context context, String str) {
        AppMethodBeat.m2504i(26660);
        Intent intent = new Intent();
        intent.putExtra("message_id", this.uNH);
        intent.putExtra("record_data_id", ((C29978o) this.uMT.get(str)).mnd);
        intent.putExtra("record_xml", this.cHP);
        C25985d.m41467b(C4996ah.getContext(), "record", ".ui.RecordMsgImageUI", intent);
        AppMethodBeat.m2505o(26660);
    }

    /* renamed from: bn */
    public final void mo26992bn(Context context, String str) {
        aat aat;
        String str2 = null;
        AppMethodBeat.m2504i(26661);
        aar aar = ((C29978o) this.uMT.get(str)).uOn;
        if (aar.wgT != null) {
            aat = aar.wgT.whw;
        } else {
            aat = null;
        }
        if (aat != null) {
            if (C5046bo.isNullOrNil(aat.whU)) {
                str2 = C1854s.m3866mJ(aat.cEV);
            } else {
                str2 = C1854s.m3866mJ(aat.whU);
            }
        }
        C35738s c35738s = (C35738s) this.uMT.get(str);
        if (c35738s == null) {
            C30379h.m48465bQ(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.bqo));
            AppMethodBeat.m2505o(26661);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
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
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        C25985d.m41467b(C4996ah.getContext(), C8741b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.m2505o(26661);
    }

    /* renamed from: a */
    static /* synthetic */ void m47443a(C29981j c29981j) {
        AppMethodBeat.m2504i(26662);
        if (uNJ.containsKey(c29981j.cHP)) {
            c29981j.uMP = (C44004m) uNJ.get(c29981j.cHP);
            AppMethodBeat.m2505o(26662);
            return;
        }
        c29981j.uMP = new C44004m();
        c29981j.uMP.cvx = c29981j.uNH.longValue();
        c29981j.uMP.uOj = c29981j.cHP;
        if (c29981j.pKz == null || c29981j.pKz.fjr == null) {
            AppMethodBeat.m2505o(26662);
            return;
        }
        if (c29981j.pKz.vzK != null) {
            c29981j.uMP.uOl = c29981j.pKz.vzK.win;
            c29981j.uMP.uOk = c29981j.pKz.vzK.wim;
            c29981j.uMP.uOm = c29981j.pKz.lgR;
        }
        c29981j.uMP.pJZ = c29981j.pKz.fjr;
        c29981j.uMP.dataType = 0;
        uNJ.put(c29981j.cHP, c29981j.uMP);
        AppMethodBeat.m2505o(26662);
    }
}
