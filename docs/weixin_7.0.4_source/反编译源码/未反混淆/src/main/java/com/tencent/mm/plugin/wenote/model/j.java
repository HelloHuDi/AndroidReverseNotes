package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class j extends d {
    private static HashMap<String, m> uNJ = new HashMap();
    private abh cAS = new abh();
    private String cHP;
    private boolean cHc;
    private c pKz = null;
    private Long uNH;
    private boolean uNI = false;
    private int uNj = 0;
    private int uNk = 0;
    private String uNl;

    static {
        AppMethodBeat.i(26663);
        AppMethodBeat.o(26663);
    }

    public j() {
        AppMethodBeat.i(26651);
        this.uMR.clear();
        com.tencent.mm.plugin.fav.ui.c.bvD();
        AppMethodBeat.o(26651);
    }

    public final void a(String str, Long l, boolean z, Context context, int i, int i2, abh abh) {
        AppMethodBeat.i(26652);
        this.cHP = str;
        this.uNH = l;
        this.cHc = z;
        this.uNj = i;
        this.uNk = i2;
        this.cAS = abh;
        this.pKz = VI(str);
        if (!(this.pKz == null || this.pKz.fjr == null || this.pKz.fjr.size() <= 1)) {
            nt ntVar = new nt();
            ntVar.cJY.type = 9;
            ntVar.cJY.cAv = (aar) this.pKz.fjr.get(0);
            ntVar.cJY.cvx = this.uNH.longValue();
            a.xxA.m(ntVar);
            this.uNI = ntVar.cJZ.cKj;
        }
        if (this.pKz == null || this.pKz.vzK == null) {
            this.uNl = null;
        } else {
            this.uNl = this.pKz.vzK.wim + ";" + this.pKz.vzK.win + ";" + this.pKz.lgR;
        }
        fx(context);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26649);
                j.a(j.this);
                j.this.ef(j.this.uMP.pJZ);
                if (k.deT() != null) {
                    k.deX();
                }
                AppMethodBeat.o(26649);
            }

            public final String toString() {
                AppMethodBeat.i(26650);
                String str = super.toString() + "|dealWNoteInfo";
                AppMethodBeat.o(26650);
                return str;
            }
        });
        AppMethodBeat.o(26652);
    }

    private void fx(Context context) {
        AppMethodBeat.i(26653);
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
        if (!bo.isNullOrNil(this.uNl)) {
            intent.putExtra("fav_note_link_source_info", this.uNl);
        }
        intent.putExtra("key_detail_fav_scene", this.cAS.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.cAS.jSW);
        intent.putExtra("key_detail_fav_index", this.cAS.index);
        d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        AppMethodBeat.o(26653);
    }

    private static c VI(String str) {
        AppMethodBeat.i(26654);
        nt ntVar = new nt();
        ntVar.cJY.type = 0;
        ntVar.cJY.cKa = str;
        a.xxA.m(ntVar);
        c cVar = ntVar.cJZ.cKi;
        AppMethodBeat.o(26654);
        return cVar;
    }

    public final String b(aar aar) {
        AppMethodBeat.i(26655);
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = this.uNH.longValue();
        a.xxA.m(ntVar);
        String str = ntVar.cJZ.dataPath;
        AppMethodBeat.o(26655);
        return str;
    }

    public final String c(aar aar) {
        AppMethodBeat.i(26656);
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = this.uNH.longValue();
        a.xxA.m(ntVar);
        String str = ntVar.cJZ.thumbPath;
        AppMethodBeat.o(26656);
        return str;
    }

    public final void n(aar aar) {
        AppMethodBeat.i(26657);
        nt ntVar = new nt();
        ntVar.cJY.type = 8;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = this.uNH.longValue();
        ntVar.cJY.thumbPath = "";
        a.xxA.m(ntVar);
        AppMethodBeat.o(26657);
    }

    public final void a(aar aar, String str) {
        AppMethodBeat.i(26658);
        nt ntVar = new nt();
        ntVar.cJY.type = 8;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = this.uNH.longValue();
        ntVar.cJY.thumbPath = str;
        a.xxA.m(ntVar);
        AppMethodBeat.o(26658);
    }

    public final void bm(Context context, String str) {
        AppMethodBeat.i(26659);
        Intent intent = new Intent();
        intent.putExtra("message_id", this.uNH);
        intent.putExtra("record_xml", this.cHP);
        intent.putExtra("record_data_id", ((o) this.uMT.get(str)).mnd);
        d.b(ah.getContext(), "record", ".ui.RecordMsgFileUI", intent);
        AppMethodBeat.o(26659);
    }

    public final void bo(Context context, String str) {
        AppMethodBeat.i(26660);
        Intent intent = new Intent();
        intent.putExtra("message_id", this.uNH);
        intent.putExtra("record_data_id", ((o) this.uMT.get(str)).mnd);
        intent.putExtra("record_xml", this.cHP);
        d.b(ah.getContext(), "record", ".ui.RecordMsgImageUI", intent);
        AppMethodBeat.o(26660);
    }

    public final void bn(Context context, String str) {
        aat aat;
        String str2 = null;
        AppMethodBeat.i(26661);
        aar aar = ((o) this.uMT.get(str)).uOn;
        if (aar.wgT != null) {
            aat = aar.wgT.whw;
        } else {
            aat = null;
        }
        if (aat != null) {
            if (bo.isNullOrNil(aat.whU)) {
                str2 = s.mJ(aat.cEV);
            } else {
                str2 = s.mJ(aat.whU);
            }
        }
        com.tencent.mm.plugin.wenote.model.a.s sVar = (com.tencent.mm.plugin.wenote.model.a.s) this.uMT.get(str);
        if (sVar == null) {
            h.bQ(ah.getContext(), ah.getContext().getString(R.string.bqo));
            AppMethodBeat.o(26661);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", sVar.lat);
        intent.putExtra("kwebmap_lng", sVar.lng);
        intent.putExtra("kPoiName", sVar.eUu);
        intent.putExtra("Kwebmap_locaion", sVar.fBg);
        if (sVar.scale >= 0.0d) {
            intent.putExtra("kwebmap_scale", sVar.scale);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(ah.getContext(), b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(26661);
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(26662);
        if (uNJ.containsKey(jVar.cHP)) {
            jVar.uMP = (m) uNJ.get(jVar.cHP);
            AppMethodBeat.o(26662);
            return;
        }
        jVar.uMP = new m();
        jVar.uMP.cvx = jVar.uNH.longValue();
        jVar.uMP.uOj = jVar.cHP;
        if (jVar.pKz == null || jVar.pKz.fjr == null) {
            AppMethodBeat.o(26662);
            return;
        }
        if (jVar.pKz.vzK != null) {
            jVar.uMP.uOl = jVar.pKz.vzK.win;
            jVar.uMP.uOk = jVar.pKz.vzK.wim;
            jVar.uMP.uOm = jVar.pKz.lgR;
        }
        jVar.uMP.pJZ = jVar.pKz.fjr;
        jVar.uMP.dataType = 0;
        uNJ.put(jVar.cHP, jVar.uMP);
        AppMethodBeat.o(26662);
    }
}
