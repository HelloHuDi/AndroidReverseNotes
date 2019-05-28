package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.Iterator;

public final class g extends d implements f {
    private static HashMap<com.tencent.mm.plugin.fav.a.g, m> uNi = new HashMap();
    private abh cAS = new abh();
    public boolean cHc = true;
    public long cHh = -1;
    private com.tencent.mm.plugin.fav.a.g mjP;
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
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ abf uNr;

        public AnonymousClass1(abf abf) {
            this.uNr = abf;
        }

        public final void run() {
            AppMethodBeat.i(26616);
            com.tencent.mm.plugin.fav.a.g gVar = new com.tencent.mm.plugin.fav.a.g();
            gVar.field_localId = g.this.cHh;
            gVar.field_favProto = this.uNr;
            g.this.uMZ = gVar.field_favProto;
            g.this.uMQ = gVar;
            g.this.mjP = gVar;
            if (g.uNi.containsKey(g.this.mjP)) {
                g.this.uMP = (m) g.uNi.get(g.this.mjP);
            } else {
                g.c(g.this);
            }
            g.this.ef(g.this.uMP.pJZ);
            if (k.deT() != null) {
                k.deX();
            }
            AppMethodBeat.o(26616);
        }

        public final String toString() {
            AppMethodBeat.i(26617);
            String str = super.toString() + "|dealWNoteInfo";
            AppMethodBeat.o(26617);
            return str;
        }
    }

    static {
        AppMethodBeat.i(26634);
        AppMethodBeat.o(26634);
    }

    public g() {
        AppMethodBeat.i(26620);
        this.uMR.clear();
        this.uMQ = null;
        uMW = "";
        this.uMY = false;
        c.bvD();
        aw.Rg().a((int) v2helper.EMethodSetAgcRxOn, (f) this);
        AppMethodBeat.o(26620);
    }

    public final void a(long j, Context context, Boolean bool, int i, int i2, abh abh, final abf abf) {
        AppMethodBeat.i(26621);
        this.cHh = j;
        this.cHc = bool.booleanValue();
        this.uNj = i;
        this.uNk = i2;
        this.cAS = abh;
        ddJ();
        if (this.uNm == 0 && this.uMZ.wit != null) {
            this.uNm = this.uMZ.wit.cvp;
        }
        ab(context, 2);
        d.xDH.ak(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26618);
                if (abf != null) {
                    com.tencent.mm.plugin.fav.a.g gVar = new com.tencent.mm.plugin.fav.a.g();
                    gVar.field_localId = g.this.cHh;
                    gVar.field_favProto = abf;
                    g.this.uMZ = gVar.field_favProto;
                    g.this.uMQ = gVar;
                    g.this.mjP = gVar;
                }
                if (g.uNi.containsKey(g.this.mjP)) {
                    g.this.uMP = (m) g.uNi.get(g.this.mjP);
                } else {
                    g.c(g.this);
                }
                g.this.ef(g.this.uMP.pJZ);
                if (k.deT() != null) {
                    k.deX();
                }
                AppMethodBeat.o(26618);
            }

            public final String toString() {
                AppMethodBeat.i(26619);
                String str = super.toString() + "|dealWNoteInfo";
                AppMethodBeat.o(26619);
                return str;
            }
        });
        AppMethodBeat.o(26621);
    }

    public final void ab(Context context, int i) {
        AppMethodBeat.i(26622);
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
        com.tencent.mm.bp.d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        AppMethodBeat.o(26622);
    }

    private void ddJ() {
        AppMethodBeat.i(26623);
        this.mjP = f.jD(this.cHh);
        if (this.mjP == null) {
            AppMethodBeat.o(26623);
            return;
        }
        if (this.uNn <= 0) {
            this.uNn = this.mjP.field_updateTime;
        }
        this.uMZ = this.mjP.field_favProto;
        this.uMQ = this.mjP;
        AppMethodBeat.o(26623);
    }

    public final String b(aar aar) {
        AppMethodBeat.i(26624);
        String o = f.o(aar);
        AppMethodBeat.o(26624);
        return o;
    }

    public final String c(aar aar) {
        AppMethodBeat.i(26625);
        String c = f.c(aar);
        AppMethodBeat.o(26625);
        return c;
    }

    public final void n(aar aar) {
        AppMethodBeat.i(26626);
        m mVar = this.uMP;
        gh ghVar = new gh();
        ghVar.cAH.type = 28;
        ghVar.cAH.cvv = mVar.mnW.field_localId;
        ghVar.cAH.cAJ = aar;
        ghVar.cAH.path = "";
        ghVar.cAH.cAO = 18;
        a.xxA.m(ghVar);
        AppMethodBeat.o(26626);
    }

    public final void a(aar aar, String str) {
        AppMethodBeat.i(26627);
        m mVar = this.uMP;
        gh ghVar = new gh();
        ghVar.cAH.type = 28;
        ghVar.cAH.cvv = mVar.mnW.field_localId;
        ghVar.cAH.cAJ = aar;
        ghVar.cAH.path = str;
        ghVar.cAH.cAO = 18;
        a.xxA.m(ghVar);
        AppMethodBeat.o(26627);
    }

    public final void bm(Context context, String str) {
        AppMethodBeat.i(26628);
        u uVar = (u) this.uMT.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.uNh);
        if (uVar != null) {
            intent.putExtra("key_detail_data_id", agX(str));
        }
        intent.putExtra("key_detail_can_delete", false);
        intent.putExtra("key_detail_info_id", this.cHh);
        intent.putExtra("key_detail_fav_scene", this.cAS.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.cAS.jSW);
        intent.putExtra("key_detail_fav_index", this.cAS.index);
        b.a(context, ".ui.detail.FavoriteFileDetailUI", intent, 1);
        AppMethodBeat.o(26628);
    }

    public final void bo(Context context, String str) {
        AppMethodBeat.i(26629);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.uNh);
        if (this.uMT.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((o) this.uMT.get(str)).mnd);
        }
        intent.putExtra("key_detail_info_id", this.cHh);
        intent.putExtra("key_detail_fav_scene", this.cAS.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.cAS.jSW);
        intent.putExtra("key_detail_fav_index", this.cAS.index);
        b.a(context, ".ui.FavImgGalleryUI", intent, 1);
        AppMethodBeat.o(26629);
    }

    public final void bn(Context context, String str) {
        AppMethodBeat.i(26630);
        String str2 = "";
        s sVar = (s) this.uMT.get(str);
        if (sVar == null) {
            h.bQ(context, ah.getContext().getString(R.string.bqo));
            AppMethodBeat.o(26630);
            return;
        }
        Intent intent = new Intent();
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
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.cHh);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        com.tencent.mm.bp.d.b(context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 1);
        AppMethodBeat.o(26630);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(26631);
        if (mVar.getType() == v2helper.EMethodSetAgcRxOn) {
            gh ghVar = new gh();
            ghVar.cAH.cwn = mVar;
            ghVar.cAH.type = 31;
            a.xxA.m(ghVar);
            if (!bo.isNullOrNil(ghVar.cAI.path) && i2 == -435) {
                ab.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            aw.Rg().b((int) v2helper.EMethodSetAgcRxOn, (f) this);
            AppMethodBeat.o(26631);
            return;
        }
        AppMethodBeat.o(26631);
    }

    public final void agU(String str) {
        this.uNh = str;
    }

    public final String ddH() {
        return this.uNh;
    }

    private String agX(String str) {
        AppMethodBeat.i(26632);
        com.tencent.mm.plugin.fav.a.g jD = f.jD(this.cHh);
        String str2;
        if (jD == null) {
            str2 = ((o) this.uMT.get(str)).mnd;
            AppMethodBeat.o(26632);
            return str2;
        }
        Iterator it = jD.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (!bo.isNullOrNil(aar.whb) && aar.whb.equals(str)) {
                str2 = aar.mnd;
                AppMethodBeat.o(26632);
                return str2;
            }
        }
        str2 = ((o) this.uMT.get(str)).mnd;
        AppMethodBeat.o(26632);
        return str2;
    }
}
