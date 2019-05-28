package com.tencent.p177mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.websearch.api.ab */
public class C14420ab extends C37435f {
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

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
        AppMethodBeat.m2504i(124149);
        stringBuilder.append("<websearch>");
        if (!C5046bo.isNullOrNil(this.uaa)) {
            stringBuilder.append("<relevant_vid>");
            stringBuilder.append(C8910b.m16065mf(this.uaa));
            stringBuilder.append("</relevant_vid>");
        }
        if (!C5046bo.isNullOrNil(this.uab)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(C8910b.m16065mf(this.uab));
            stringBuilder.append("</relevant_expand>");
        }
        if (!C5046bo.isNullOrNil(this.uab)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(C8910b.m16065mf(this.uab));
            stringBuilder.append("</relevant_expand>");
        }
        if (!C5046bo.isNullOrNil(this.uac)) {
            stringBuilder.append("<relevant_pre_searchid>");
            stringBuilder.append(C8910b.m16065mf(this.uac));
            stringBuilder.append("</relevant_pre_searchid>");
        }
        if (!C5046bo.isNullOrNil(this.uad)) {
            stringBuilder.append("<relevant_shared_openid>");
            stringBuilder.append(C8910b.m16065mf(this.uad));
            stringBuilder.append("</relevant_shared_openid>");
        }
        if (this.uae >= 0) {
            stringBuilder.append("<rec_category>");
            stringBuilder.append(this.uae);
            stringBuilder.append("</rec_category>");
        }
        if (!C5046bo.isNullOrNil(this.lvz)) {
            stringBuilder.append("<shareUrl>");
            stringBuilder.append(C8910b.m16065mf(this.lvz));
            stringBuilder.append("</shareUrl>");
        }
        if (!C5046bo.isNullOrNil(this.lvA)) {
            stringBuilder.append("<shareTitle>");
            stringBuilder.append(C8910b.m16065mf(this.lvA));
            stringBuilder.append("</shareTitle>");
        }
        if (!C5046bo.isNullOrNil(this.qVw)) {
            stringBuilder.append("<shareDesc>");
            stringBuilder.append(C8910b.m16065mf(this.qVw));
            stringBuilder.append("</shareDesc>");
        }
        if (!C5046bo.isNullOrNil(this.uaf)) {
            stringBuilder.append("<shareImgUrl>");
            stringBuilder.append(C8910b.m16065mf(this.uaf));
            stringBuilder.append("</shareImgUrl>");
        }
        if (!C5046bo.isNullOrNil(this.uag)) {
            stringBuilder.append("<shareString>");
            stringBuilder.append(C8910b.m16065mf(this.uag));
            stringBuilder.append("</shareString>");
        }
        if (!C5046bo.isNullOrNil(this.uah)) {
            stringBuilder.append("<shareStringUrl>");
            stringBuilder.append(C8910b.m16065mf(this.uah));
            stringBuilder.append("</shareStringUrl>");
        }
        if (!C5046bo.isNullOrNil(this.source)) {
            stringBuilder.append("<source>");
            stringBuilder.append(C8910b.m16065mf(this.source));
            stringBuilder.append("</source>");
        }
        if (!C5046bo.isNullOrNil(this.phw)) {
            stringBuilder.append("<sourceUrl>");
            stringBuilder.append(C8910b.m16065mf(this.phw));
            stringBuilder.append("</sourceUrl>");
        }
        if (!C5046bo.isNullOrNil(this.uai)) {
            stringBuilder.append("<strPlayCount>");
            stringBuilder.append(C8910b.m16065mf(this.uai));
            stringBuilder.append("</strPlayCount>");
        }
        if (!C5046bo.isNullOrNil(this.uaj)) {
            stringBuilder.append("<titleUrl>");
            stringBuilder.append(C8910b.m16065mf(this.uaj));
            stringBuilder.append("</titleUrl>");
        }
        if (!C5046bo.isNullOrNil(this.uak)) {
            stringBuilder.append("<extReqParams>");
            stringBuilder.append(C8910b.m16065mf(this.uak));
            stringBuilder.append("</extReqParams>");
        }
        if (!C5046bo.isNullOrNil(this.ual)) {
            stringBuilder.append("<tagList>");
            stringBuilder.append(C8910b.m16065mf(this.ual));
            stringBuilder.append("</tagList>");
        }
        if (this.uam >= 0) {
            stringBuilder.append("<channelId>");
            stringBuilder.append(this.uam);
            stringBuilder.append("</channelId>");
        }
        if (!C5046bo.isNullOrNil(this.thumbUrl)) {
            stringBuilder.append("<thumbUrl>");
            stringBuilder.append(C8910b.m16065mf(this.thumbUrl));
            stringBuilder.append("</thumbUrl>");
        }
        if (!C5046bo.isNullOrNil(this.uan)) {
            stringBuilder.append("<shareTag>");
            stringBuilder.append(C8910b.m16065mf(this.uan));
            stringBuilder.append("</shareTag>");
        }
        stringBuilder.append("</websearch>");
        AppMethodBeat.m2505o(124149);
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
        AppMethodBeat.m2504i(124150);
        this.uaa = (String) map.get(".msg.appmsg.websearch.relevant_vid");
        this.uab = (String) map.get(".msg.appmsg.websearch.relevant_expand");
        this.uac = (String) map.get(".msg.appmsg.websearch.relevant_pre_searchid");
        this.uad = (String) map.get(".msg.appmsg.websearch.relevant_shared_openid");
        this.uae = (long) C5046bo.getInt((String) map.get(".msg.appmsg.websearch.rec_category"), -1);
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
        this.uam = C5046bo.getLong((String) map.get(".msg.appmsg.websearch.channelId"), -1);
        this.thumbUrl = (String) map.get(".msg.appmsg.websearch.thumbUrl");
        this.uan = (String) map.get(".msg.appmsg.websearch.shareTag");
        AppMethodBeat.m2505o(124150);
    }

    /* renamed from: Xz */
    public final /* synthetic */ C37435f mo20330Xz() {
        AppMethodBeat.m2504i(124151);
        C14420ab c14420ab = new C14420ab();
        c14420ab.uaa = this.uaa;
        c14420ab.uab = this.uab;
        c14420ab.uac = this.uac;
        c14420ab.uad = this.uad;
        c14420ab.uae = this.uae;
        c14420ab.lvz = this.lvz;
        c14420ab.lvA = this.lvA;
        c14420ab.qVw = this.qVw;
        c14420ab.uaf = this.uaf;
        c14420ab.uag = this.uag;
        c14420ab.uah = this.uah;
        c14420ab.source = this.source;
        c14420ab.phw = this.phw;
        c14420ab.uai = this.uai;
        c14420ab.uaj = this.uaj;
        c14420ab.uak = this.uak;
        c14420ab.ual = this.ual;
        c14420ab.uam = this.uam;
        c14420ab.thumbUrl = this.thumbUrl;
        c14420ab.uan = this.uan;
        AppMethodBeat.m2505o(124151);
        return c14420ab;
    }
}
