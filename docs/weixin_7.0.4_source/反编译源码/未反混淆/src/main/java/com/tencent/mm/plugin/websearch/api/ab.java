package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class ab extends f {
    public String lvA;
    public String lvz;
    public String phw;
    public String qVw;
    public String source;
    public String thumbUrl;
    public String uaa;
    public String uab;
    public String uac;
    public String uad;
    public long uae;
    public String uaf;
    public String uag;
    public String uah;
    public String uai;
    public String uaj;
    public String uak;
    public String ual;
    public long uam;
    public String uan;

    public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
        AppMethodBeat.i(124149);
        stringBuilder.append("<websearch>");
        if (!bo.isNullOrNil(this.uaa)) {
            stringBuilder.append("<relevant_vid>");
            stringBuilder.append(b.mf(this.uaa));
            stringBuilder.append("</relevant_vid>");
        }
        if (!bo.isNullOrNil(this.uab)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(b.mf(this.uab));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bo.isNullOrNil(this.uab)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(b.mf(this.uab));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bo.isNullOrNil(this.uac)) {
            stringBuilder.append("<relevant_pre_searchid>");
            stringBuilder.append(b.mf(this.uac));
            stringBuilder.append("</relevant_pre_searchid>");
        }
        if (!bo.isNullOrNil(this.uad)) {
            stringBuilder.append("<relevant_shared_openid>");
            stringBuilder.append(b.mf(this.uad));
            stringBuilder.append("</relevant_shared_openid>");
        }
        if (this.uae >= 0) {
            stringBuilder.append("<rec_category>");
            stringBuilder.append(this.uae);
            stringBuilder.append("</rec_category>");
        }
        if (!bo.isNullOrNil(this.lvz)) {
            stringBuilder.append("<shareUrl>");
            stringBuilder.append(b.mf(this.lvz));
            stringBuilder.append("</shareUrl>");
        }
        if (!bo.isNullOrNil(this.lvA)) {
            stringBuilder.append("<shareTitle>");
            stringBuilder.append(b.mf(this.lvA));
            stringBuilder.append("</shareTitle>");
        }
        if (!bo.isNullOrNil(this.qVw)) {
            stringBuilder.append("<shareDesc>");
            stringBuilder.append(b.mf(this.qVw));
            stringBuilder.append("</shareDesc>");
        }
        if (!bo.isNullOrNil(this.uaf)) {
            stringBuilder.append("<shareImgUrl>");
            stringBuilder.append(b.mf(this.uaf));
            stringBuilder.append("</shareImgUrl>");
        }
        if (!bo.isNullOrNil(this.uag)) {
            stringBuilder.append("<shareString>");
            stringBuilder.append(b.mf(this.uag));
            stringBuilder.append("</shareString>");
        }
        if (!bo.isNullOrNil(this.uah)) {
            stringBuilder.append("<shareStringUrl>");
            stringBuilder.append(b.mf(this.uah));
            stringBuilder.append("</shareStringUrl>");
        }
        if (!bo.isNullOrNil(this.source)) {
            stringBuilder.append("<source>");
            stringBuilder.append(b.mf(this.source));
            stringBuilder.append("</source>");
        }
        if (!bo.isNullOrNil(this.phw)) {
            stringBuilder.append("<sourceUrl>");
            stringBuilder.append(b.mf(this.phw));
            stringBuilder.append("</sourceUrl>");
        }
        if (!bo.isNullOrNil(this.uai)) {
            stringBuilder.append("<strPlayCount>");
            stringBuilder.append(b.mf(this.uai));
            stringBuilder.append("</strPlayCount>");
        }
        if (!bo.isNullOrNil(this.uaj)) {
            stringBuilder.append("<titleUrl>");
            stringBuilder.append(b.mf(this.uaj));
            stringBuilder.append("</titleUrl>");
        }
        if (!bo.isNullOrNil(this.uak)) {
            stringBuilder.append("<extReqParams>");
            stringBuilder.append(b.mf(this.uak));
            stringBuilder.append("</extReqParams>");
        }
        if (!bo.isNullOrNil(this.ual)) {
            stringBuilder.append("<tagList>");
            stringBuilder.append(b.mf(this.ual));
            stringBuilder.append("</tagList>");
        }
        if (this.uam >= 0) {
            stringBuilder.append("<channelId>");
            stringBuilder.append(this.uam);
            stringBuilder.append("</channelId>");
        }
        if (!bo.isNullOrNil(this.thumbUrl)) {
            stringBuilder.append("<thumbUrl>");
            stringBuilder.append(b.mf(this.thumbUrl));
            stringBuilder.append("</thumbUrl>");
        }
        if (!bo.isNullOrNil(this.uan)) {
            stringBuilder.append("<shareTag>");
            stringBuilder.append(b.mf(this.uan));
            stringBuilder.append("</shareTag>");
        }
        stringBuilder.append("</websearch>");
        AppMethodBeat.o(124149);
    }

    public final void a(Map<String, String> map, b bVar) {
        AppMethodBeat.i(124150);
        this.uaa = (String) map.get(".msg.appmsg.websearch.relevant_vid");
        this.uab = (String) map.get(".msg.appmsg.websearch.relevant_expand");
        this.uac = (String) map.get(".msg.appmsg.websearch.relevant_pre_searchid");
        this.uad = (String) map.get(".msg.appmsg.websearch.relevant_shared_openid");
        this.uae = (long) bo.getInt((String) map.get(".msg.appmsg.websearch.rec_category"), -1);
        this.lvz = (String) map.get(".msg.appmsg.websearch.shareUrl");
        this.lvA = (String) map.get(".msg.appmsg.websearch.shareTitle");
        this.qVw = (String) map.get(".msg.appmsg.websearch.shareDesc");
        this.uaf = (String) map.get(".msg.appmsg.websearch.shareImgUrl");
        this.uag = (String) map.get(".msg.appmsg.websearch.shareString");
        this.uah = (String) map.get(".msg.appmsg.websearch.shareStringUrl");
        this.source = (String) map.get(".msg.appmsg.websearch.source");
        this.phw = (String) map.get(".msg.appmsg.websearch.sourceUrl");
        this.uai = (String) map.get(".msg.appmsg.websearch.strPlayCount");
        this.uaj = (String) map.get(".msg.appmsg.websearch.titleUrl");
        this.uak = (String) map.get(".msg.appmsg.websearch.extReqParams");
        this.ual = (String) map.get(".msg.appmsg.websearch.tagList");
        this.uam = bo.getLong((String) map.get(".msg.appmsg.websearch.channelId"), -1);
        this.thumbUrl = (String) map.get(".msg.appmsg.websearch.thumbUrl");
        this.uan = (String) map.get(".msg.appmsg.websearch.shareTag");
        AppMethodBeat.o(124150);
    }

    public final /* synthetic */ f Xz() {
        AppMethodBeat.i(124151);
        ab abVar = new ab();
        abVar.uaa = this.uaa;
        abVar.uab = this.uab;
        abVar.uac = this.uac;
        abVar.uad = this.uad;
        abVar.uae = this.uae;
        abVar.lvz = this.lvz;
        abVar.lvA = this.lvA;
        abVar.qVw = this.qVw;
        abVar.uaf = this.uaf;
        abVar.uag = this.uag;
        abVar.uah = this.uah;
        abVar.source = this.source;
        abVar.phw = this.phw;
        abVar.uai = this.uai;
        abVar.uaj = this.uaj;
        abVar.uak = this.uak;
        abVar.ual = this.ual;
        abVar.uam = this.uam;
        abVar.thumbUrl = this.thumbUrl;
        abVar.uan = this.uan;
        AppMethodBeat.o(124151);
        return abVar;
    }
}
