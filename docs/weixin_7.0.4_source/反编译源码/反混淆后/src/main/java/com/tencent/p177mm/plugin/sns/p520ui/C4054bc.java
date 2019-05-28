package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p198aw.C25847d;
import com.tencent.p177mm.p198aw.C25848g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C32607ok;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45337kd;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29045ae;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C13354a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34930b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46405w;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.cfg;
import com.tencent.p177mm.protocal.protobuf.cvi;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.ui.bc */
public final class C4054bc {
    Context context;
    int cvd = 0;
    long iYa = 0;
    public OnClickListener rDA = new C40612();
    public OnClickListener rDB = new C40623();
    public OnClickListener rDC = new C40714();
    public OnClickListener rDD = new C40695();
    public OnClickListener rDE = new C40706();
    public OnClickListener rDF = new C40727();
    C4063a rDr;
    public OnClickListener rDs = new C40558();
    public OnClickListener rDt = new C40589();
    public OnClickListener rDu = new C405610();
    public OnClickListener rDv = new C406411();
    public OnClickListener rDw = new C406512();
    public OnClickListener rDx = new C406613();
    public OnClickListener rDy = new C406714();
    public OnClickListener rDz = new C406815();
    C29045ae rhQ;
    public OnClickListener rvD = new C40571();
    C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$8 */
    class C40558 implements OnClickListener {
        C40558() {
        }

        public final void onClick(View view) {
            boolean z;
            String str;
            AppMethodBeat.m2504i(39869);
            C4054bc c4054bc = C4054bc.this;
            if (view == null || !(view.getTag() instanceof TimeLineObject)) {
                z = true;
            } else {
                str = ((TimeLineObject) view.getTag()).xfH.f17242Id;
                Intent intent;
                if ("wx485a97c844086dc9".equals(str)) {
                    C25985d.m41467b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                    z = true;
                } else if ("wx7fa037cc7dfabad5".equals(str)) {
                    C22162d.m33785kT(34);
                    C1720g.m3537RQ();
                    if (C7486a.m12942jh(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        C25985d.m41473f(c4054bc.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        C25985d.m41467b(c4054bc.context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    z = true;
                } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                    C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    C25985d.m41467b(view.getContext(), "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else if ("wx751a1acca5688ba3".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 5);
                    if (!(C35973a.m59178bI(c4054bc.context) || C35973a.m59177bH(c4054bc.context))) {
                        C25985d.m41467b(c4054bc.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wxfbc915ff7c30e335".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    if (!(C35973a.m59178bI(c4054bc.context) || C35973a.m59177bH(c4054bc.context))) {
                        C25985d.m41467b(c4054bc.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wx482a4001c37e2b74".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 2);
                    if (!(C35973a.m59178bI(c4054bc.context) || C35973a.m59177bH(c4054bc.context))) {
                        C25985d.m41467b(c4054bc.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if (!"wxaf060266bfa9a35c".equals(str)) {
                    z = false;
                } else if (C25847d.aim()) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    C25985d.m41467b(c4054bc.context, "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z) {
                if (view == null || !(view.getTag() instanceof TimeLineObject)) {
                    AppMethodBeat.m2505o(39869);
                    return;
                }
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (timeLineObject == null || timeLineObject.xfH == null) {
                    C4990ab.m7412e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                    AppMethodBeat.m2505o(39869);
                    return;
                }
                String str2 = timeLineObject.xfH.f17242Id;
                String df = C24826a.gkF.mo38864df(str2);
                if (C5046bo.isNullOrNil(df)) {
                    str = C24826a.gkF.mo38868f(C4054bc.this.context, str2, "timeline");
                    if (str == null || str.length() == 0) {
                        AppMethodBeat.m2505o(39869);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("shortUrl", str);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("type", -255);
                    intent2.putExtra("geta8key_scene", 2);
                    C24826a.gkE.mo38924i(intent2, C4054bc.this.context);
                } else {
                    int i;
                    String str3 = timeLineObject == null ? null : timeLineObject.jBB;
                    if (timeLineObject.xfI.wbJ == 1) {
                        i = 2;
                    } else if (timeLineObject.xfI.wbJ == 3) {
                        i = 5;
                    } else {
                        i = 2;
                    }
                    String str4 = null;
                    if (!(timeLineObject.qNO == null || timeLineObject.qNO.vCy == null)) {
                        str4 = timeLineObject.qNO.vCy.vCs;
                    }
                    C32607ok c32607ok = new C32607ok();
                    c32607ok.cKI.context = C4054bc.this.context;
                    c32607ok.cKI.scene = 4;
                    c32607ok.cKI.csB = str2;
                    c32607ok.cKI.packageName = df;
                    c32607ok.cKI.msgType = i;
                    c32607ok.cKI.cEV = str3;
                    c32607ok.cKI.mediaTagName = str4;
                    c32607ok.cKI.cKJ = 5;
                    c32607ok.cKI.cKK = 0;
                    c32607ok.cKI.cKL = timeLineObject.f15074Id;
                    C4879a.xxA.mo10055m(c32607ok);
                    C9365gt c9365gt = new C9365gt();
                    c9365gt.cBv.actionCode = 2;
                    c9365gt.cBv.scene = 3;
                    c9365gt.cBv.extMsg = "timeline_src=3";
                    c9365gt.cBv.appId = str2;
                    c9365gt.cBv.context = C4054bc.this.context;
                    C4879a.xxA.mo10055m(c9365gt);
                    AppMethodBeat.m2505o(39869);
                    return;
                }
            }
            AppMethodBeat.m2505o(39869);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$10 */
    class C405610 implements OnClickListener {
        C405610() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39873);
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_Product_xml", str);
                    intent.putExtra("key_ProductUI_getProductInfoScene", 2);
                    C25985d.m41467b(view.getContext(), "scanner", ".ui.ProductUI", intent);
                }
                AppMethodBeat.m2505o(39873);
                return;
            }
            AppMethodBeat.m2505o(39873);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$1 */
    class C40571 implements OnClickListener {
        C40571() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39862);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - C4054bc.this.iYa < 500) {
                AppMethodBeat.m2505o(39862);
                return;
            }
            C4054bc.this.iYa = currentTimeMillis;
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                if (C4054bc.this.rhQ != null) {
                    C4054bc.this.rhQ.cnj().mo69122x(YT);
                }
                bau bau;
                String B;
                if (timeLineObject.xfI.wbJ == 18) {
                    C4054bc c4054bc = C4054bc.this;
                    Context context = C4054bc.this.context;
                    TimeLineObject timeLineObject2 = c13707q.rin;
                    C34927j.m57341a(C34930b.AdUrl, C13354a.EnterCompleteVideo, C13373af.cnF().mo62918YT(c13707q.cwT), c4054bc.cvd);
                    Intent intent = new Intent();
                    bau = null;
                    if (timeLineObject2.xfI.wbK.size() > 0) {
                        bau = (bau) timeLineObject2.xfI.wbK.get(0);
                    }
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", timeLineObject2.xfI.Url);
                    intent.putExtra("KSta_SourceType", 2);
                    intent.putExtra("KSta_Scene", C34930b.AdUrl.value);
                    intent.putExtra("KSta_FromUserName", timeLineObject2.jBB);
                    intent.putExtra("KSta_SnSId", timeLineObject2.f15074Id);
                    if (bau == null) {
                        intent.putExtra("KMediaId", "fakeid_" + (bau == null ? timeLineObject2.f15074Id : bau.f17915Id));
                    } else {
                        intent.putExtra("KMediaId", bau.f17915Id);
                    }
                    cfg cfg = timeLineObject2.xfN;
                    if (cfg != null) {
                        intent.putExtra("KMediaVideoTime", cfg.fiH);
                        intent.putExtra("StreamWording", cfg.fiJ);
                        intent.putExtra("StremWebUrl", cfg.fiK);
                        intent.putExtra("KMediaTitle", cfg.fiI);
                        intent.putExtra("KStremVideoUrl", cfg.fiG);
                        intent.putExtra("KThumUrl", cfg.fiL);
                        intent.putExtra("KSta_StremVideoAduxInfo", cfg.fiM);
                        intent.putExtra("KSta_StremVideoPublishId", cfg.fiN);
                    }
                    intent.putExtra("KSta_SnsStatExtStr", timeLineObject2.rjC);
                    C25985d.m41467b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                    AppMethodBeat.m2505o(39862);
                    return;
                } else if (timeLineObject.qNQ == null || C5046bo.isNullOrNil(timeLineObject.qNQ.uaa)) {
                    String str = timeLineObject.xfI.Url;
                    C4990ab.m7410d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(str)));
                    B = C24826a.gkF.mo38843B(str, "timeline");
                    if (B == null || B.length() == 0) {
                        AppMethodBeat.m2505o(39862);
                        return;
                    }
                    String str2;
                    Intent intent2 = new Intent();
                    Bundle bundle = null;
                    if (timeLineObject != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("KSnsStrId", timeLineObject.f15074Id);
                        bundle2.putString("KSnsLocalId", c13707q.cwT);
                        bundle2.putBoolean("KFromTimeline", true);
                        if (timeLineObject.xfI != null && timeLineObject.xfI.wbK.size() > 0) {
                            bundle2.putString("K_sns_thumb_url", ((bau) timeLineObject.xfI.wbK.get(0)).wEH);
                            bundle2.putString("K_sns_raw_url", timeLineObject.xfI.Url);
                            C4990ab.m7417i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", ((bau) timeLineObject.xfI.wbK.get(0)).wEH, timeLineObject.xfI.Url);
                        }
                        bundle = bundle2;
                    }
                    bundle.putString("key_snsad_statextstr", timeLineObject.rjC);
                    intent2.putExtra("rawUrl", B);
                    intent2.putExtra("shortUrl", B);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("type", -255);
                    if (timeLineObject.xfJ != null) {
                        intent2.putExtra("srcUsername", timeLineObject.xfJ);
                        intent2.putExtra("srcDisplayname", timeLineObject.vjM);
                        C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + timeLineObject.vjM + " tlObj.publicUserName: " + timeLineObject.xfJ);
                    }
                    intent2.putExtra("sns_local_id", c13707q.cwT);
                    if (YT != null) {
                        intent2.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(YT.field_snsId));
                        intent2.putExtra("pre_username", YT.field_userName);
                        intent2.putExtra("prePublishId", "sns_" + C29036i.m46117jV(YT.field_snsId));
                        intent2.putExtra("preUsername", YT.field_userName);
                        intent2.putExtra("share_report_pre_msg_url", B);
                        intent2.putExtra("share_report_pre_msg_title", timeLineObject.xfI.Title);
                        intent2.putExtra("share_report_pre_msg_desc", timeLineObject.xfI.Desc);
                        if (timeLineObject.xfI.wbK != null && timeLineObject.xfI.wbK.size() > 0) {
                            intent2.putExtra("share_report_pre_msg_icon_url", ((bau) timeLineObject.xfI.wbK.get(0)).wEH);
                        }
                        intent2.putExtra("share_report_pre_msg_appid", "");
                        intent2.putExtra("share_report_from_scene", 1);
                    }
                    if (!(timeLineObject == null || timeLineObject.xfH == null)) {
                        intent2.putExtra("KAppId", timeLineObject.xfH.f17242Id);
                    }
                    if (YT != null && YT.mo74253DI(32)) {
                        C21980a cqr;
                        if (C4054bc.this.cvd == 2) {
                            cqr = YT.cqr();
                        } else {
                            cqr = YT.cqq();
                        }
                        if (cqr != null) {
                            intent2.putExtra("KsnsViewId", cqr.hnw);
                        }
                    }
                    if (!(YT == null || timeLineObject == null)) {
                        C37952b lY;
                        if (C4054bc.this.cvd == 0) {
                            lY = C37952b.m64170lY(718);
                        } else {
                            lY = C37952b.m64171lZ(718);
                        }
                        lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(timeLineObject.xfJ).mo60722tx(timeLineObject.xfH == null ? "" : timeLineObject.xfH.f17242Id).mo60722tx(timeLineObject.xfI.Url);
                        lY.ajK();
                        if (C4054bc.this.cvd == 0) {
                            lY = C37952b.m64170lY(743);
                        } else {
                            lY = C37952b.m64171lZ(743);
                        }
                        C37952b tx = lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(timeLineObject.xfJ);
                        if (timeLineObject.xfH == null) {
                            str2 = "";
                        } else {
                            str2 = timeLineObject.xfH.f17242Id;
                        }
                        tx.mo60722tx(str2).mo60722tx(timeLineObject.xfI.Url);
                        if (bundle != null) {
                            str2 = "intent_key_StatisticsOplog";
                            byte[] adk = lY.adk();
                            if (adk != null) {
                                bundle.putByteArray(str2, adk);
                            }
                        }
                    }
                    if (bundle != null) {
                        intent2.putExtra("jsapiargs", bundle);
                    }
                    intent2.putExtra("geta8key_scene", 2);
                    intent2.putExtra("from_scence", 3);
                    if (!(timeLineObject.xfI.wbN == null || timeLineObject.xfI.wbN.vGc == -1)) {
                        intent2.putExtra(C5506m.ygo, timeLineObject.xfI.wbN.vGc);
                    }
                    int[] iArr;
                    int width;
                    if (C5046bo.isNullOrNil(timeLineObject.rCK) || !C3953i.m6288YO(timeLineObject.rCK) || YT == null) {
                        intent2.addFlags(536870912);
                        int i = timeLineObject.xfI.wbN != null ? timeLineObject.xfI.wbN.vGc : -1;
                        int bFf = C4054bc.this.rhQ.bFf();
                        if (timeLineObject.xfI.wbN != null && i == 5 && timeLineObject.xfI.wbN.fgb == 1 && ((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
                            intent2.putExtra("biz_video_title", timeLineObject.xfI.Title);
                            intent2.putExtra("biz_video_vid", timeLineObject.xfI.wbN.fgd);
                            intent2.putExtra("biz_video_func_flag", timeLineObject.xfI.wbN.fgc);
                            intent2.putExtra("biz_video_desc", timeLineObject.xfI.wbN.desc);
                            if (C5046bo.isNullOrNil(timeLineObject.xfI.wbN.lvx)) {
                                intent2.putExtra("biz_video_icon_url", intent2.getStringExtra("share_report_pre_msg_icon_url"));
                            } else {
                                intent2.putExtra("biz_video_icon_url", timeLineObject.xfI.wbN.lvx);
                            }
                            intent2.putExtra("biz_video_item_show_type", timeLineObject.xfI.wbN.vGc);
                            intent2.putExtra("biz_video_pub_time", (long) timeLineObject.xfI.wbN.fga);
                            intent2.putExtra("biz_video_duration", timeLineObject.xfI.wbN.duration);
                            intent2.putExtra("biz_video_width", timeLineObject.xfI.wbN.videoWidth);
                            intent2.putExtra("biz_video_height", timeLineObject.xfI.wbN.videoHeight);
                            intent2.putExtra("biz_video_scene", 2);
                            intent2.putExtra("biz_video_subscene", bFf);
                            iArr = new int[2];
                            View findViewById = view.findViewById(2131825687);
                            if (findViewById != null) {
                                width = findViewById.getWidth();
                                i = findViewById.getHeight();
                                findViewById.getLocationInWindow(iArr);
                                intent2.putExtra("img_gallery_width", width).putExtra("img_gallery_height", i).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                            }
                            C25985d.m41467b(C4054bc.this.context, "brandservice", ".ui.timeline.video.BizVideoDetailUI", intent2);
                        } else if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(4) && ((C20023b) C1720g.m3528K(C20023b.class)).mo6750a(C4054bc.this.context, B, i, 2, bFf, intent2)) {
                            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
                        } else {
                            C24826a.gkE.mo38924i(intent2, C4054bc.this.context);
                        }
                        B = null;
                        int i2 = 0;
                        if (!(timeLineObject == null || timeLineObject.xfH == null)) {
                            B = timeLineObject.xfH.f17242Id;
                            i2 = C5046bo.getInt(timeLineObject.xfH.jCh, 0);
                        }
                        str2 = C24826a.gkF.mo38873t(B, i2);
                        if (!C5046bo.isNullOrNil(str2)) {
                            String str3 = null;
                            if (!(timeLineObject == null || timeLineObject.qNO == null || timeLineObject.qNO.vCy == null)) {
                                str3 = timeLineObject.qNO.vCy.vCs;
                            }
                            C24826a.gkF.mo38855a(C4054bc.this.context, B, str2, timeLineObject == null ? null : timeLineObject.jBB, 5, 4, 1, str3, timeLineObject.f15074Id);
                        }
                        C7060h.pYm.mo8381e(11105, timeLineObject.jBB, timeLineObject.xfI.Url);
                        if (YT != null && YT.field_type == 4) {
                            bau = (bau) timeLineObject.xfI.wbK.get(0);
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(1);
                            objArr[1] = bau == null ? "" : bau.Desc;
                            objArr[2] = timeLineObject.xfH.f17242Id;
                            c7060h.mo8381e(13043, objArr);
                        }
                    } else {
                        iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width2 = view.getWidth();
                        width = view.getHeight();
                        Intent intent3 = new Intent();
                        intent3.putExtra("img_gallery_left", iArr[0]);
                        intent3.putExtra("img_gallery_top", iArr[1]);
                        intent3.putExtra("img_gallery_width", width2);
                        intent3.putExtra("img_gallery_height", width);
                        if (timeLineObject != null) {
                            LinkedList linkedList = timeLineObject.xfI.wbK;
                            if (linkedList.size() > 0) {
                                intent3.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                            }
                        }
                        intent3.putExtra("sns_landing_pages_share_sns_id", YT.cqA());
                        intent3.putExtra("sns_landing_pages_rawSnsId", YT.cqu().f15074Id);
                        intent3.putExtra("sns_landing_pages_aid", YT.cqZ());
                        intent3.putExtra("sns_landing_pages_traceid", YT.cra());
                        intent3.putExtra("sns_landing_pages_ux_info", YT.crc());
                        intent3.putExtra("sns_landig_pages_from_source", C4054bc.this.cvd == 0 ? 3 : 4);
                        intent3.setClass(C4054bc.this.context, SnsAdNativeLandingPagesUI.class);
                        intent3.putExtra("sns_landing_pages_xml", timeLineObject.rCK);
                        intent3.putExtra("sns_landing_pages_rec_src", YT.cre());
                        intent3.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        C3953i.m6310y(intent3, C4054bc.this.context);
                        AppMethodBeat.m2505o(39862);
                        return;
                    }
                } else {
                    C4054bc c4054bc2 = C4054bc.this;
                    cvi cvi = timeLineObject.qNQ;
                    if (!(cvi == null || C5046bo.isNullOrNil(cvi.uaa))) {
                        C46400aa.m87323a(c4054bc2.context, C39964g.m68429a(cvi, 31, C29736ac.adL("discoverRecommendEntry").optString("wording")));
                        String str4 = timeLineObject.jBB;
                        B = timeLineObject.f15074Id;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("isShareClick=1");
                        stringBuffer.append("&relevant_vid=");
                        stringBuffer.append(cvi.uaa);
                        stringBuffer.append("&relevant_pre_searchid=");
                        stringBuffer.append(cvi.uac);
                        stringBuffer.append("&relevant_shared_openid=");
                        stringBuffer.append(cvi.uad);
                        stringBuffer.append("&rec_category=");
                        if (cvi.uam > 0) {
                            stringBuffer.append(cvi.uam);
                        } else {
                            stringBuffer.append(cvi.uae);
                        }
                        stringBuffer.append("&source=");
                        stringBuffer.append(cvi.source);
                        stringBuffer.append("&fromUser=");
                        stringBuffer.append(str4);
                        stringBuffer.append("&fromScene=");
                        stringBuffer.append(3);
                        stringBuffer.append("&targetInfo=");
                        stringBuffer.append(B);
                        stringBuffer.append("&expand=");
                        stringBuffer.append(cvi.uab);
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", stringBuffer.toString());
                        bsj bsj = new bsj();
                        bsj.wUu = stringBuffer.toString();
                        C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
                    }
                    AppMethodBeat.m2505o(39862);
                    return;
                }
            }
            AppMethodBeat.m2505o(39862);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$9 */
    class C40589 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.bc$9$1 */
        class C40591 implements C9636a {
            C40591() {
            }

            /* renamed from: o */
            public final void mo6218o(String str, boolean z) {
                AppMethodBeat.m2504i(39870);
                if (C4054bc.this.tipDialog != null) {
                    C4054bc.this.tipDialog.dismiss();
                }
                if (z) {
                    C41730b.m73489U(str, 3);
                    C17884o.acv().mo67495pZ(str);
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Scene", 37);
                    C1720g.m3537RQ();
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                    if (aoO != null && aoO.dsf()) {
                        C7060h.pYm.mo8374X(10298, str + ",37");
                        intent.putExtra("Contact_Scene", 37);
                    }
                    C24826a.gkE.mo38912c(intent, C4054bc.this.context);
                    AppMethodBeat.m2505o(39870);
                    return;
                }
                Toast.makeText(C4054bc.this.context, C4054bc.this.context.getString(C25738R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                AppMethodBeat.m2505o(39870);
            }
        }

        C40589() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39872);
            if (view.getTag() instanceof C29201az) {
                final C29201az c29201az = (C29201az) view.getTag();
                if (C5046bo.isNullOrNil(c29201az.rDc)) {
                    C4990ab.m7412e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                    Toast.makeText(C4054bc.this.context, C4054bc.this.context.getString(C25738R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                    AppMethodBeat.m2505o(39872);
                    return;
                }
                C1720g.m3537RQ();
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c29201az.rDc);
                if (aoO == null || !aoO.field_username.equals(c29201az.rDc)) {
                    C26417a.flu.mo20966a(c29201az.rDc, "", new C40591());
                    C4054bc c4054bc = C4054bc.this;
                    Context context = C4054bc.this.context;
                    C4054bc.this.context.getString(C25738R.string.f9238tz);
                    c4054bc.tipDialog = C30379h.m48458b(context, C4054bc.this.context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(39871);
                            C26417a.flu.mo20969or(c29201az.rDc);
                            AppMethodBeat.m2505o(39871);
                        }
                    });
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.putExtra("Contact_User", c29201az.rDc);
                    C7060h.pYm.mo8374X(10298, c29201az.rDc + ",37");
                    intent.putExtra("Contact_Scene", 37);
                    C24826a.gkE.mo38912c(intent, C4054bc.this.context);
                    AppMethodBeat.m2505o(39872);
                    return;
                }
            }
            AppMethodBeat.m2505o(39872);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$2 */
    class C40612 implements OnClickListener {
        C40612() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39863);
            boolean z = view.getTag() instanceof C13707q;
            C4990ab.m7410d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(z)));
            if (z) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (C4054bc.m6399Wi(timeLineObject.f15074Id)) {
                    C7060h.pYm.mo8374X(10231, "1");
                    C37494a.aic();
                } else if (!(C35973a.m59179bJ(C4054bc.this.context) || C35973a.m59177bH(C4054bc.this.context))) {
                    C7060h.pYm.mo8374X(10090, "1,0");
                    if (timeLineObject.xfI.wbK.size() > 0) {
                        C37952b lY;
                        String str;
                        bau bau = (bau) timeLineObject.xfI.wbK.get(0);
                        if (C4054bc.this.cvd == 0) {
                            lY = C37952b.m64170lY(738);
                        } else {
                            lY = C37952b.m64171lZ(738);
                        }
                        C37952b tx = lY.mo60722tx(timeLineObject.f15074Id).mo60722tx(timeLineObject.jBB);
                        if (timeLineObject.xfH == null) {
                            str = "";
                        } else {
                            str = timeLineObject.xfH.f17242Id;
                        }
                        tx.mo60722tx(str).mo60722tx(bau.Title).mo60722tx(bau.Desc).mo60722tx("");
                        lY.ajK();
                    }
                    if (c13707q.rio) {
                        C37494a.m63279a(C25848g.m41159a(C13373af.getAccPath(), timeLineObject, 9));
                    } else {
                        C37494a.m63280b(C25848g.m41159a(C13373af.getAccPath(), timeLineObject, 1));
                    }
                }
                if (C4054bc.this.rDr != null) {
                    C4054bc.this.rDr.ctb();
                }
                AppMethodBeat.m2505o(39863);
                return;
            }
            AppMethodBeat.m2505o(39863);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$3 */
    class C40623 implements OnClickListener {
        C40623() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39864);
            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                if (C4054bc.this.rhQ != null) {
                    C4054bc.this.rhQ.cnj().mo69122x(YT);
                }
                if (timeLineObject.xfO == null) {
                    C4990ab.m7412e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                    AppMethodBeat.m2505o(39864);
                    return;
                }
                String str = timeLineObject.xfO.username;
                String str2 = timeLineObject.xfO.path;
                C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
                C32628se c32628se = new C32628se();
                c32628se.cOf.userName = str;
                c32628se.cOf.cOh = str2;
                c32628se.cOf.scene = 1009;
                c32628se.cOf.cst = timeLineObject.f15074Id + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + timeLineObject.jBB;
                Bundle bundle = new Bundle();
                bundle.putString("stat_send_msg_user", YT.field_userName);
                bundle.putString("stat_msg_id", "sns_" + C29036i.m46117jV(YT.field_snsId));
                C4879a.xxA.mo10055m(c32628se);
                AppMethodBeat.m2505o(39864);
                return;
            }
            AppMethodBeat.m2505o(39864);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$a */
    public interface C4063a {
        void ctb();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$11 */
    class C406411 implements OnClickListener {
        C406411() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39874);
            C4990ab.m7410d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_TV_xml", str);
                    intent.putExtra("key_TV_getProductInfoScene", 2);
                    C25985d.m41467b(view.getContext(), "shake", ".ui.TVInfoUI", intent);
                }
                AppMethodBeat.m2505o(39874);
                return;
            }
            AppMethodBeat.m2505o(39874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$12 */
    class C406512 implements OnClickListener {
        C406512() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39875);
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("preceding_scence", 10);
                    intent.putExtra("download_entrance_scene", 13);
                    C25985d.m41467b(view.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
                AppMethodBeat.m2505o(39875);
                return;
            }
            AppMethodBeat.m2505o(39875);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$13 */
    class C406613 implements OnClickListener {
        C406613() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39876);
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    C25985d.m41467b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
                }
                AppMethodBeat.m2505o(39876);
                return;
            }
            AppMethodBeat.m2505o(39876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$14 */
    class C406714 implements OnClickListener {
        C406714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39877);
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    C25985d.m41467b(view.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                }
                AppMethodBeat.m2505o(39877);
                return;
            }
            AppMethodBeat.m2505o(39877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$15 */
    class C406815 implements OnClickListener {
        C406815() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39878);
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    C25985d.m41467b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                }
                AppMethodBeat.m2505o(39878);
                return;
            }
            AppMethodBeat.m2505o(39878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$5 */
    class C40695 implements OnClickListener {
        C40695() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39866);
            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_product_scene", 2);
                    intent.putExtra("key_product_info", str);
                    C25985d.m41467b(C4054bc.this.context, "product", ".ui.MallProductUI", intent);
                }
                AppMethodBeat.m2505o(39866);
                return;
            }
            AppMethodBeat.m2505o(39866);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$6 */
    class C40706 implements OnClickListener {
        C40706() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39867);
            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbK.size() > 0) {
                    C46236n YT = C13373af.cnF().mo62918YT(c13707q.cwT);
                    if (C4054bc.this.rhQ != null) {
                        C4054bc.this.rhQ.cnj().mo69122x(YT);
                    }
                    String str = ((bau) timeLineObject.xfI.wbK.get(0)).rik;
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 12);
                    if (TextUtils.isEmpty(str)) {
                        C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                    } else {
                        String[] split = str.split("#");
                        if (split.length >= 2) {
                            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                            intent.putExtra("key_card_id", split[0]);
                            intent.putExtra("key_card_ext", split[1]);
                            C25985d.m41467b(C4054bc.this.context, "card", ".ui.CardDetailUI", intent);
                            AppMethodBeat.m2505o(39867);
                            return;
                        } else if (split.length == 1) {
                            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(str)));
                            intent.putExtra("key_card_id", split[0]);
                            intent.putExtra("key_card_ext", "");
                            C25985d.m41467b(C4054bc.this.context, "card", ".ui.CardDetailUI", intent);
                            AppMethodBeat.m2505o(39867);
                            return;
                        } else {
                            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(str)));
                            AppMethodBeat.m2505o(39867);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(39867);
                return;
            }
            AppMethodBeat.m2505o(39867);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$4 */
    class C40714 implements OnClickListener {
        C40714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39865);
            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (view.getTag() instanceof TimeLineObject) {
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (timeLineObject.xfO == null) {
                    C4990ab.m7412e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                    AppMethodBeat.m2505o(39865);
                    return;
                }
                String str = timeLineObject.xfO.username;
                C32628se c32628se = new C32628se();
                C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(str)));
                c32628se.cOf.userName = str;
                c32628se.cOf.scene = 1009;
                c32628se.cOf.cst = timeLineObject.f15074Id + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + timeLineObject.jBB;
                C4879a.xxA.mo10055m(c32628se);
                AppMethodBeat.m2505o(39865);
                return;
            }
            AppMethodBeat.m2505o(39865);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bc$7 */
    class C40727 implements OnClickListener {
        C40727() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39868);
            C4990ab.m7416i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
            if (view.getTag() instanceof C13707q) {
                C13707q c13707q = (C13707q) view.getTag();
                if (c13707q.rin.xfI.wbJ == 26) {
                    if (C5046bo.isNullOrNil(c13707q.rin.xfI.wbM)) {
                        AppMethodBeat.m2505o(39868);
                        return;
                    }
                    C37721gh c37721gh = new C37721gh();
                    c37721gh.cAH.type = 37;
                    c37721gh.cAH.desc = c13707q.rin.xfI.wbM;
                    String str = "";
                    if (c13707q.rin.xfI.wbK != null && c13707q.rin.xfI.wbK.size() > 0) {
                        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), ((bau) c13707q.rin.xfI.wbK.get(0)).f17915Id);
                        str = C29036i.m46108e((bau) c13707q.rin.xfI.wbK.get(0));
                        str = C5730e.m8628ct(new StringBuilder().append(fZ).append(str).toString()) ? fZ + str : "";
                    }
                    c37721gh.cAH.path = str;
                    c37721gh.cAH.title = c13707q.cwT;
                    c37721gh.cAH.context = C4054bc.this.context;
                    C4879a.xxA.mo10055m(c37721gh);
                }
            }
            AppMethodBeat.m2505o(39868);
        }
    }

    public C4054bc(Context context, C4063a c4063a, int i, C29045ae c29045ae) {
        AppMethodBeat.m2504i(39879);
        this.context = context;
        this.rDr = c4063a;
        this.cvd = i;
        this.rhQ = c29045ae;
        AppMethodBeat.m2505o(39879);
    }

    /* renamed from: Wi */
    protected static boolean m6399Wi(String str) {
        AppMethodBeat.m2504i(39880);
        C45337kd c45337kd = new C45337kd();
        c45337kd.cFz.action = -2;
        C4879a.xxA.mo10055m(c45337kd);
        C9058e c9058e = c45337kd.cFA.cFB;
        if (c9058e != null && C37494a.m63282d(c9058e) && str.equals(c9058e.fJU) && C37494a.aie()) {
            AppMethodBeat.m2505o(39880);
            return true;
        }
        AppMethodBeat.m2505o(39880);
        return false;
    }
}
