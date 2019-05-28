package com.tencent.p177mm.plugin.sns.p520ui.p526d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32606oi;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C42065td;
import com.tencent.p177mm.p230g.p231a.C45370tc;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.MaskImageButton;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.p444l.C3330a;
import com.tencent.p177mm.plugin.p444l.C3330a.C3331a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sns.abtest.C21865a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C34935b;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21905g;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C39742m;
import com.tencent.p177mm.plugin.sns.lucky.p1657b.C46215a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.plugin.sns.model.C13417av;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C29045ae;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C34957aq;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b;
import com.tencent.p177mm.plugin.sns.model.C46224r;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C13354a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34930b;
import com.tencent.p177mm.plugin.sns.p520ui.C13707q;
import com.tencent.p177mm.plugin.sns.p520ui.C22055af;
import com.tencent.p177mm.plugin.sns.p520ui.C29190ao;
import com.tencent.p177mm.plugin.sns.p520ui.C35119c;
import com.tencent.p177mm.plugin.sns.p520ui.C39828ar;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au.C13632a;
import com.tencent.p177mm.plugin.sns.p520ui.C46922l;
import com.tencent.p177mm.plugin.sns.p520ui.MaskImageView;
import com.tencent.p177mm.plugin.sns.p520ui.SnsAdNativeLandingPagesUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsOnlineVideoActivity;
import com.tencent.p177mm.plugin.sns.p520ui.SnsPermissionUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsSightPlayerUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsSingleTextViewUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsTimeLineUI;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i.C13697b;
import com.tencent.p177mm.plugin.sns.p520ui.item.C4078a.C4081a;
import com.tencent.p177mm.plugin.sns.p520ui.item.C41313c.C13687a;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.C29169a;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C13638f;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C13642g;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C35109c;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C35110d;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C39833a;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C4029e;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C4033h;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a.C46252b;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C13649f;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C22072c;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C29203d;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C35113g;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C35115h;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C39835a;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C4038e;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C46253b;
import com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b.C46253b.C43596a;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13655b;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13658c;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13665d;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C35118a;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21980a.C21982b.C21983a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C13474b;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C3956a;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C7252av;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cbb;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbn;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C46618a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.d.b */
public abstract class C22089b {
    Activity activity;
    int cvd = 0;
    public OnTouchListener jNA;
    private ClipboardManager mmO;
    volatile C46253b rJD;
    volatile C39835a rJE;
    volatile C46252b rJF;
    volatile C39833a rJG;
    public C43597a rJH;
    public OnClickListener rJI;
    public OnLongClickListener rJJ;
    public C22121c rJK;
    public OnClickListener rJL;
    public OnClickListener rJM;
    public OnClickListener rJN;
    public OnClickListener rJO;
    public OnClickListener rJP;
    public OnClickListener rJQ;
    public OnClickListener rJR;
    public OnClickListener rJS;
    public OnClickListener rJT;
    public C22121c rJU;
    public C22121c rJV;
    public C22121c rJW;
    public C22121c rJX;
    public C22121c rJY;
    public C22121c rJZ;
    public C13304e rJj;
    public C22121c rKa;
    C22121c rKb;
    public OnClickListener rKc;
    public OnClickListener rKd;
    public OnClickListener rKe;
    public OnClickListener rKf;
    public OnClickListener rKg;
    public OnClickListener rKh;
    public OnClickListener rKi;
    public OnItemClickListener rKj;
    public OnItemClickListener rKk;
    public OnClickListener rKl = new C221121();
    public OnClickListener rKm = new C2208112();
    public OnClickListener rKn;
    public C13632a rKo;
    int rKp;
    private C4884c<C42065td> rKq = new C2209823();
    private C4884c<C45370tc> rKr = new C1367233();
    public OnClickListener rKs = new C407632();
    C29045ae rhQ;
    public OnClickListener rjy;

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$31 */
    class C407531 implements C13304e {
        C407531() {
        }

        /* renamed from: c */
        public final void mo8940c(C13303b c13303b, int i) {
            AppMethodBeat.m2504i(40288);
            if (c13303b != null && i == 0) {
                View view;
                if (c13303b.qxx != null) {
                    view = (View) c13303b.qxx.get();
                } else {
                    view = null;
                }
                if (view != null && (view instanceof C34915a)) {
                    C34915a c34915a = (C34915a) view;
                    c34915a.getVideoPath();
                    if (c34915a.getTagObject() != null && (c34915a.getTagObject() instanceof C43589aj)) {
                        c34915a.getTagObject();
                    }
                }
            }
            AppMethodBeat.m2505o(40288);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$32 */
    class C407632 implements OnClickListener {
        C407632() {
        }

        public final void onClick(View view) {
            MMImageView mMImageView;
            TagImageView tagImageView;
            int i = 2;
            boolean z = false;
            AppMethodBeat.m2504i(40289);
            Object tag = view.getTag();
            C46236n c46236n = null;
            if (tag instanceof BaseViewHolder) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                C46236n YS = C21990h.m33615YS(baseViewHolder.cFc);
                mMImageView = null;
                tagImageView = baseViewHolder.rHF;
                c46236n = YS;
            } else if (tag instanceof C46236n) {
                mMImageView = (MMImageView) view.getTag(2131820637);
                tagImageView = null;
                c46236n = (C46236n) tag;
            } else {
                mMImageView = null;
                tagImageView = null;
            }
            if (c46236n != null) {
                String y;
                C43570e crd = c46236n.crd();
                int source = crd.getSource();
                if (c46236n != null && c46236n.mo74253DI(32)) {
                    C21980a a = C22089b.m33699a(C22089b.this, c46236n);
                    if (c46236n.cqo().coK() && C3953i.m6288YO(c46236n.crd().field_adxml)) {
                        y = C3953i.m6309y(c46236n);
                        if (!C5046bo.isNullOrNil(y)) {
                            crd.field_adxml = y;
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (tagImageView != null) {
                            tagImageView.getLocationInWindow(iArr);
                            width = tagImageView.getWidth();
                            height = tagImageView.getHeight();
                        } else if (mMImageView != null) {
                            mMImageView.getLocationInWindow(iArr);
                            width = mMImageView.getWidth();
                            height = mMImageView.getHeight();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", c46236n.cqA());
                        intent.putExtra("sns_landing_pages_rawSnsId", c46236n.cqu().f15074Id);
                        intent.putExtra("sns_landing_pages_ux_info", c46236n.crc());
                        TimeLineObject cqu = c46236n.cqu();
                        if (cqu != null) {
                            LinkedList linkedList = cqu.xfI.wbK;
                            if (linkedList.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                            }
                        }
                        intent.setClass(C22089b.this.activity, SnsAdNativeLandingPagesUI.class);
                        width = 9;
                        if (source == 2) {
                            width = 16;
                        } else if (source == 1) {
                            width = 10;
                        }
                        intent.putExtra("sns_landig_pages_from_source", width);
                        intent.putExtra("sns_landing_pages_xml", c46236n.crd().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", c46236n.cre());
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                        C22089b.this.activity.startActivity(intent);
                        C22089b.this.activity.overridePendingTransition(0, 0);
                        if (source == 0) {
                            i = 1;
                        }
                        C29036i.m46098a(new SnsAdClick(source, i, c46236n.field_snsId, 23, 21));
                        AppMethodBeat.m2505o(40289);
                        return;
                    } else if (a != null && a.qTw == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_card_id", a.qTy);
                        intent2.putExtra("key_card_ext", a.qTz);
                        intent2.putExtra("key_from_scene", 21);
                        intent2.putExtra("key_stastic_scene", 15);
                        C25985d.m41467b(C22089b.this.activity, "card", ".ui.CardDetailUI", intent2);
                        if (source == 0) {
                            i = 1;
                        }
                        C29036i.m46098a(new SnsAdClick(source, i, c46236n.field_snsId, 23, 11));
                        AppMethodBeat.m2505o(40289);
                        return;
                    } else if (C22089b.m33702a(C22089b.this, a, c46236n, false)) {
                        if (source == 0) {
                            i = 1;
                        }
                        C29036i.m46098a(new SnsAdClick(source, i, c46236n.field_snsId, 23, 31));
                        AppMethodBeat.m2505o(40289);
                        return;
                    }
                }
                if (source == 0) {
                    i = 1;
                }
                SnsAdClick snsAdClick = new SnsAdClick(source, i, c46236n.field_snsId, 23, 0);
                C29036i.m46098a(snsAdClick);
                y = c46236n.crb();
                if (C5046bo.isNullOrNil(y)) {
                    y = c46236n.getAdLink();
                }
                C4990ab.m7416i("MicroMsg.TimelineClickListener", "adlink url " + y + " " + c46236n.cqo().qUg);
                Intent intent3 = new Intent();
                boolean z2 = c46236n.cqo().qUg == 0;
                if (!C1947ae.giI) {
                    z = z2;
                }
                if (c46236n != null && c46236n.mo74253DI(32)) {
                    C21980a a2 = C22089b.m33699a(C22089b.this, c46236n);
                    if (a2 != null) {
                        intent3.putExtra("KsnsViewId", a2.hnw);
                    }
                }
                intent3.putExtra("KRightBtn", z);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                bundle.putString("key_snsad_statextstr", crd.cqu().rjC);
                intent3.putExtra("jsapiargs", bundle);
                intent3.putExtra("rawUrl", y);
                intent3.putExtra("useJs", true);
                intent3.putExtra("srcUsername", c46236n.field_userName);
                intent3.putExtra("stastic_scene", 15);
                intent3.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                intent3.putExtra("pre_username", c46236n.field_userName);
                intent3.putExtra("prePublishId", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                intent3.putExtra("preUsername", c46236n.field_userName);
                C24826a.gkE.mo38924i(intent3, C22089b.this.activity);
            }
            AppMethodBeat.m2505o(40289);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$34 */
    class C407734 implements OnClickListener {
        C407734() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x0215  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0444  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0252  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x0447  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x025f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            int i = 2;
            boolean z = false;
            AppMethodBeat.m2504i(40296);
            if (view.getTag() == null || !(view.getTag() instanceof Long)) {
                AppMethodBeat.m2505o(40296);
                return;
            }
            String adLink;
            int i2;
            SnsAdClick snsAdClick;
            Intent intent;
            boolean z2;
            Bundle bundle;
            C43570e ku = C13373af.cnI().mo69174ku(((Long) view.getTag()).longValue());
            C46236n cqB = ku.cqB();
            C34927j.m57341a(C34930b.Sight, C13354a.DetailTimeline, ku.cqB(), C22089b.this.cvd);
            ku.getSource();
            String crb = cqB.crb();
            if (C5046bo.isNullOrNil(crb)) {
                adLink = cqB.getAdLink();
            } else {
                adLink = crb;
            }
            if (cqB.mo74253DI(32)) {
                C21980a a = C22089b.m33699a(C22089b.this, cqB);
                int i3 = -1;
                C46618a aoe = C18624c.abj().aoe("Sns_CanvasAd_DetailLink_JumpWay");
                if (aoe.isValid()) {
                    i3 = C5046bo.getInt(aoe.field_value, -1);
                }
                Intent intent2;
                TimeLineObject cqu;
                LinkedList linkedList;
                if (a != null && a.qTw == 1) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_card_id", a.qTy);
                    intent3.putExtra("key_card_ext", a.qTz);
                    intent3.putExtra("key_from_scene", 21);
                    intent3.putExtra("key_stastic_scene", 15);
                    C25985d.m41467b(C22089b.this.activity, "card", ".ui.CardDetailUI", intent3);
                    i2 = C22089b.this.cvd;
                    if (C22089b.this.cvd == 0) {
                        i = 1;
                    }
                    C29036i.m46098a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 11));
                    AppMethodBeat.m2505o(40296);
                    return;
                } else if (a == null || i3 != 1) {
                    if (a == null || i3 != 0) {
                        if (a != null && i3 == -1 && a.qTw == 3) {
                            if (cqB.cqo().coK() && C3953i.m6288YO(cqB.crd().field_adxml)) {
                                crb = C3953i.m6309y(cqB);
                                if (!C5046bo.isNullOrNil(crb)) {
                                    ku.field_adxml = crb;
                                }
                                intent2 = new Intent();
                                intent2.putExtra("sns_landing_pages_share_sns_id", cqB.cqA());
                                intent2.putExtra("sns_landing_pages_rawSnsId", cqB.cqu().f15074Id);
                                intent2.putExtra("sns_landing_pages_ux_info", cqB.crc());
                                intent2.putExtra("sns_landing_pages_aid", cqB.cqZ());
                                intent2.putExtra("sns_landing_pages_traceid", cqB.cra());
                                cqu = cqB.cqu();
                                if (cqu != null) {
                                    linkedList = cqu.xfI.wbK;
                                    if (linkedList.size() > 0) {
                                        intent2.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                                    }
                                }
                                intent2.setClass(C22089b.this.activity, SnsAdNativeLandingPagesUI.class);
                                i3 = 9;
                                if (C22089b.this.cvd == 2) {
                                    i3 = 16;
                                } else if (C22089b.this.cvd == 1) {
                                    i3 = 10;
                                }
                                intent2.putExtra("sns_landig_pages_from_source", i3);
                                intent2.putExtra("sns_landing_pages_xml", cqB.crd().field_adxml);
                                intent2.putExtra("sns_landing_pages_rec_src", cqB.cre());
                                intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                C22089b.this.activity.startActivity(intent2);
                                C22089b.this.activity.overridePendingTransition(0, 0);
                                i2 = C22089b.this.cvd;
                                if (C22089b.this.cvd == 0) {
                                    i = 1;
                                }
                                C29036i.m46098a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 21));
                                AppMethodBeat.m2505o(40296);
                                return;
                            }
                        } else if (C22089b.m33702a(C22089b.this, a, cqB, false)) {
                            i2 = C22089b.this.cvd;
                            if (C22089b.this.cvd == 0) {
                                i = 1;
                            }
                            C29036i.m46098a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 31));
                            AppMethodBeat.m2505o(40296);
                            return;
                        }
                    } else if (cqB.cqo().coK() && C3953i.m6288YO(cqB.crd().field_adxml)) {
                        crb = C3953i.m6309y(cqB);
                        if (!C5046bo.isNullOrNil(crb)) {
                            ku.field_adxml = crb;
                        }
                        Map z3 = C5049br.m7595z(cqB.crd().field_adxml, "adxml");
                        if (z3 != null) {
                            crb = C5046bo.m7532bc((String) z3.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                            if (!C5046bo.isNullOrNil(crb)) {
                                adLink = crb;
                            }
                            crb = adLink;
                        } else {
                            C4990ab.m7412e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + cqB.crd().field_adxml);
                            crb = adLink;
                        }
                        i2 = C22089b.this.cvd;
                        if (C22089b.this.cvd == 0) {
                            i = 1;
                        }
                        snsAdClick = new SnsAdClick(i2, i, cqB.field_snsId, 3, 0);
                        C29036i.m46098a(snsAdClick);
                        C4990ab.m7416i("MicroMsg.TimelineClickListener", "adlink url " + crb + " " + cqB.cqo().qUg);
                        intent = new Intent();
                        z2 = cqB.cqo().qUg != 0;
                        if (!C1947ae.giI) {
                            z = z2;
                        }
                        if (cqB.mo74253DI(32)) {
                            a = C22089b.m33699a(C22089b.this, cqB);
                            if (a != null) {
                                intent.putExtra("KsnsViewId", a.hnw);
                            }
                        }
                        intent.putExtra("KRightBtn", z);
                        bundle = new Bundle();
                        bundle.putParcelable("KSnsAdTag", snsAdClick);
                        bundle.putString("key_snsad_statextstr", ku.cqu().rjC);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", crb);
                        intent.putExtra("useJs", true);
                        intent.putExtra("srcUsername", cqB.field_userName);
                        intent.putExtra("sns_local_id", cqB.cqU());
                        intent.putExtra("stastic_scene", 15);
                        intent.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(cqB.field_snsId));
                        intent.putExtra("pre_username", cqB.field_userName);
                        intent.putExtra("prePublishId", "sns_" + C29036i.m46117jV(cqB.field_snsId));
                        intent.putExtra("preUsername", cqB.field_userName);
                        C24826a.gkE.mo38924i(intent, C22089b.this.activity);
                        AppMethodBeat.m2505o(40296);
                    }
                } else if (cqB.cqo().coK() && C3953i.m6288YO(cqB.crd().field_adxml)) {
                    crb = C3953i.m6309y(cqB);
                    if (!C5046bo.isNullOrNil(crb)) {
                        ku.field_adxml = crb;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("sns_landing_pages_share_sns_id", cqB.cqA());
                    intent2.putExtra("sns_landing_pages_rawSnsId", cqB.cqu().f15074Id);
                    intent2.putExtra("sns_landing_pages_ux_info", cqB.crc());
                    intent2.putExtra("sns_landing_pages_aid", cqB.cqZ());
                    intent2.putExtra("sns_landing_pages_traceid", cqB.cra());
                    cqu = cqB.cqu();
                    if (cqu != null) {
                        linkedList = cqu.xfI.wbK;
                        if (linkedList.size() > 0) {
                            intent2.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                        }
                    }
                    intent2.setClass(C22089b.this.activity, SnsAdNativeLandingPagesUI.class);
                    i3 = 9;
                    if (C22089b.this.cvd == 2) {
                        i3 = 16;
                    } else if (C22089b.this.cvd == 1) {
                        i3 = 10;
                    }
                    intent2.putExtra("sns_landig_pages_from_source", i3);
                    intent2.putExtra("sns_landing_pages_xml", cqB.crd().field_adxml);
                    intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent2.putExtra("sns_landing_pages_rec_src", cqB.cre());
                    intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    C22089b.this.activity.startActivity(intent2);
                    C22089b.this.activity.overridePendingTransition(0, 0);
                    i2 = C22089b.this.cvd;
                    if (C22089b.this.cvd == 0) {
                        i = 1;
                    }
                    C29036i.m46098a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 21));
                    AppMethodBeat.m2505o(40296);
                    return;
                }
            }
            crb = adLink;
            i2 = C22089b.this.cvd;
            if (C22089b.this.cvd == 0) {
            }
            snsAdClick = new SnsAdClick(i2, i, cqB.field_snsId, 3, 0);
            C29036i.m46098a(snsAdClick);
            C4990ab.m7416i("MicroMsg.TimelineClickListener", "adlink url " + crb + " " + cqB.cqo().qUg);
            intent = new Intent();
            if (cqB.cqo().qUg != 0) {
            }
            if (C1947ae.giI) {
            }
            if (cqB.mo74253DI(32)) {
            }
            intent.putExtra("KRightBtn", z);
            bundle = new Bundle();
            bundle.putParcelable("KSnsAdTag", snsAdClick);
            bundle.putString("key_snsad_statextstr", ku.cqu().rjC);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", crb);
            intent.putExtra("useJs", true);
            intent.putExtra("srcUsername", cqB.field_userName);
            intent.putExtra("sns_local_id", cqB.cqU());
            intent.putExtra("stastic_scene", 15);
            intent.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(cqB.field_snsId));
            intent.putExtra("pre_username", cqB.field_userName);
            intent.putExtra("prePublishId", "sns_" + C29036i.m46117jV(cqB.field_snsId));
            intent.putExtra("preUsername", cqB.field_userName);
            C24826a.gkE.mo38924i(intent, C22089b.this.activity);
            AppMethodBeat.m2505o(40296);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$20 */
    class C1367020 implements OnTouchListener {
        C1367020() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(40269);
            C4990ab.m7410d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
            C22089b.this.mo17694dI(view);
            AppMethodBeat.m2505o(40269);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$27 */
    class C1367127 implements OnItemClickListener {
        C1367127() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(40283);
            C4990ab.m7416i("MicroMsg.TimelineClickListener", "unlike click");
            if (adapterView.getAdapter() instanceof C35119c) {
                C34935b c34935b = (C34935b) view.getTag();
                C46236n YT = C13373af.cnF().mo62918YT(c34935b.cwT);
                if (YT == null) {
                    AppMethodBeat.m2505o(40283);
                    return;
                } else if (i == 0) {
                    Object obj;
                    if (YT.mo74253DI(32)) {
                        Object obj2;
                        C21980a a = C22089b.m33699a(C22089b.this, YT);
                        if (a == null) {
                            obj2 = "";
                        } else {
                            String obj22 = a.hnw;
                        }
                        ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(11855, YT.cre(), Integer.valueOf(3), obj22, Integer.valueOf(YT.cre()));
                    }
                    if (c34935b.qFH.rDn.qTP.coJ().size() > 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    C1207m c46224r;
                    if (obj != null) {
                        C35119c c35119c = (C35119c) adapterView.getAdapter();
                        c35119c.hzv++;
                        c35119c.notifyDataSetChanged();
                        adapterView.setOnItemClickListener(C22089b.this.rKk);
                        C22089b.this.crF();
                        obj = new C21983a();
                        obj.qUc = C21983a.qTY;
                        obj.qFI = c34935b.qFI;
                        obj.qUd = 0;
                        c46224r = new C46224r(YT.field_snsId, 8, obj);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                        AppMethodBeat.m2505o(40283);
                        return;
                    } else if (c34935b.qFH.rDn.qTT) {
                        AppMethodBeat.m2505o(40283);
                        return;
                    } else {
                        C22089b.this.mo17697dL(view);
                        obj = new C21983a();
                        obj.qFI = c34935b.qFI;
                        obj.qUd = System.currentTimeMillis();
                        c46224r = new C46224r(YT.field_snsId, 8, obj);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                        AppMethodBeat.m2505o(40283);
                        return;
                    }
                } else if (c34935b.qFH.rDm.qUZ == null) {
                    C4990ab.m7412e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
                    AppMethodBeat.m2505o(40283);
                    return;
                } else {
                    C3956a c3956a = c34935b.qFH.rDm.qUZ;
                    int i2 = i - 1;
                    if (i2 < c3956a.list.size()) {
                        String str = ((C13474b) c3956a.list.get(i2)).url;
                        try {
                            String[] strArr = new String[4];
                            strArr[0] = String.format("snsid=%s", new Object[]{YT.cqu().f15074Id});
                            strArr[1] = String.format("aid=%s", new Object[]{YT.cqZ()});
                            strArr[2] = String.format("traceid=%s", new Object[]{YT.cra()});
                            Object[] objArr = new Object[1];
                            C1720g.m3534RN();
                            objArr[0] = C1668a.m3384QG();
                            strArr[3] = String.format("uin=%s", objArr);
                            str = C3953i.m6306m(str, strArr);
                        } catch (Exception e) {
                        }
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("useJs", true);
                        intent.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(YT.field_snsId));
                        intent.putExtra("pre_username", YT.field_userName);
                        intent.putExtra("prePublishId", "sns_" + C29036i.m46117jV(YT.field_snsId));
                        intent.putExtra("preUsername", YT.field_userName);
                        C24826a.gkE.mo38924i(intent, C22089b.this.activity);
                    }
                    AppMethodBeat.m2505o(40283);
                    return;
                }
            }
            C4990ab.m7420w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
            AppMethodBeat.m2505o(40283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$33 */
    class C1367233 extends C4884c<C45370tc> {
        C1367233() {
            AppMethodBeat.m2504i(40294);
            this.xxI = C45370tc.class.getName().hashCode();
            AppMethodBeat.m2505o(40294);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(40295);
            C45370tc c45370tc = (C45370tc) c4883b;
            C4990ab.m7416i("MicroMsg.TimelineClickListener", "receive timeline back anim event");
            final long j;
            if (C22089b.this.rJE != null) {
                j = c45370tc.cPp.cvc;
                C5004al.m7441d(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$33$1$1 */
                    class C136741 implements C43596a {
                        C136741() {
                        }

                        public final void onAnimationEnd() {
                            AppMethodBeat.m2504i(40290);
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "timeline back animation end");
                            C22089b.this.rJE = null;
                            ((SnsTimeLineUI) C22089b.this.activity).mo55690lm(false);
                            AppMethodBeat.m2505o(40290);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(40291);
                        if (C22089b.this.activity instanceof SnsTimeLineUI) {
                            ((SnsTimeLineUI) C22089b.this.activity).mo55690lm(true);
                        }
                        C22089b.this.rJE.mo8889kM(j);
                        C22089b.this.rJE.mo63024a(new C136741());
                        AppMethodBeat.m2505o(40291);
                    }
                });
                AppMethodBeat.m2505o(40295);
                return true;
            } else if (C22089b.this.rJG != null) {
                j = c45370tc.cPp.cvc;
                C5004al.m7441d(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$33$2$1 */
                    class C136761 implements C43596a {
                        C136761() {
                        }

                        public final void onAnimationEnd() {
                            AppMethodBeat.m2504i(40292);
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "detail back animation end");
                            C22089b.this.rJG = null;
                            AppMethodBeat.m2505o(40292);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(40293);
                        C22089b.this.rJG.mo8878kM(j);
                        C22089b.this.rJG.mo63021a(new C136761());
                        AppMethodBeat.m2505o(40293);
                    }
                });
                AppMethodBeat.m2505o(40295);
                return true;
            } else {
                AppMethodBeat.m2505o(40295);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$12 */
    class C2208112 implements OnClickListener {
        C2208112() {
        }

        public final void onClick(View view) {
            boolean z = false;
            AppMethodBeat.m2504i(40259);
            if (view.getTag() == null) {
                AppMethodBeat.m2505o(40259);
                return;
            }
            C46236n dQ = C22089b.m33704dQ(view);
            if (dQ == null || !dQ.mo74253DI(32)) {
                AppMethodBeat.m2505o(40259);
                return;
            }
            boolean z2;
            if (dQ.crd().cqo().coS()) {
                int gr = C35002v.m57491gr(dQ.crd().cqo().coN(), dQ.crc());
                Object obj = gr > 0 ? 1 : null;
                String coN = dQ.crd().cqo().coN();
                String crc = dQ.crc();
                C1720g.m3534RN();
                C35002v.m57492h(coN, crc, C1668a.m3384QG(), obj != null ? gr : 2, obj != null ? 0 : 1);
                if (obj == null) {
                    z = true;
                }
                z2 = z;
            } else {
                z2 = false;
            }
            TimeLineObject cqu = dQ.cqu();
            if (cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                if ((cqu.xfI.wbJ == 1 && cqu.xfI.wbK.size() == 1) || cqu.xfI.wbJ == 7) {
                    C22089b.m33703b(C22089b.this, view, dQ, 1002, dQ.crd().cqo().coU(), z2);
                }
                AppMethodBeat.m2505o(40259);
                return;
            }
            C22089b.m33700a(C22089b.this, view, dQ, 1002, dQ.crd().cqo().coU(), z2);
            AppMethodBeat.m2505o(40259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$13 */
    class C2208213 implements OnClickListener {
        C2208213() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40260);
            String str = (String) view.getTag();
            C4990ab.m7410d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(str)));
            TimeLineObject cqu = C13373af.cnF().mo62918YT(str).cqu();
            C7252av c7252av = cqu.qNO;
            if (c7252av.vCy == null) {
                AppMethodBeat.m2505o(40260);
                return;
            }
            String df = C24826a.gkF.mo38864df(c7252av.vCy.fKh);
            int i = 0;
            if (cqu.xfI.wbJ == 1) {
                i = 2;
            } else if (cqu.xfI.wbJ == 3) {
                i = 5;
            } else if (cqu.xfI.wbJ == 15) {
                i = 38;
            }
            if (C3953i.m6294a(cqu, C22089b.this.activity)) {
                C24826a.gkF.mo38855a(C22089b.this.activity, c7252av.vCy.fKh, df, cqu.jBB, i, 11, 9, c7252av.vCy.vCs, cqu.f15074Id);
                AppMethodBeat.m2505o(40260);
                return;
            }
            C9365gt c9365gt;
            switch (c7252av.jCt) {
                case 4:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", c7252av.Url);
                    C24826a.gkE.mo38924i(intent, C22089b.this.activity);
                    C24826a.gkF.mo38855a(C22089b.this.activity, c7252av.vCy.fKh, df, cqu.jBB, i, 11, 1, c7252av.vCy.vCs, cqu.f15074Id);
                    AppMethodBeat.m2505o(40260);
                    return;
                case 5:
                    if (c7252av.Scene == 1) {
                        c9365gt = new C9365gt();
                        c9365gt.cBv.actionCode = 2;
                        c9365gt.cBv.scene = 3;
                        c9365gt.cBv.appId = c7252av.vCy.fKh;
                        c9365gt.cBv.context = C22089b.this.activity;
                        C4879a.xxA.mo10055m(c9365gt);
                        C24826a.gkF.mo38855a(C22089b.this.activity, c7252av.vCy.fKh, df, cqu.jBB, i, 11, 6, c7252av.vCy.vCs, cqu.f15074Id);
                        AppMethodBeat.m2505o(40260);
                        return;
                    }
                    break;
                case 6:
                    int a = C22055af.m33674a(C22089b.this.activity, c7252av);
                    if (a != 1) {
                        if (a == 2) {
                            c9365gt = new C9365gt();
                            c9365gt.cBv.context = C22089b.this.activity;
                            c9365gt.cBv.actionCode = 1;
                            c9365gt.cBv.appId = c7252av.vCy.fKh;
                            c9365gt.cBv.messageAction = c7252av.vCy.vCu;
                            c9365gt.cBv.messageExt = c7252av.vCy.vCt;
                            c9365gt.cBv.scene = 3;
                            C4879a.xxA.mo10055m(c9365gt);
                            C24826a.gkF.mo38855a(C22089b.this.activity, c7252av.vCy.fKh, df, cqu.jBB, i, 11, 3, c7252av.vCy.vCs, cqu.f15074Id);
                            break;
                        }
                    }
                    c9365gt = new C9365gt();
                    c9365gt.cBv.context = C22089b.this.activity;
                    c9365gt.cBv.actionCode = 2;
                    c9365gt.cBv.appId = c7252av.vCy.fKh;
                    c9365gt.cBv.messageAction = c7252av.vCy.vCu;
                    c9365gt.cBv.messageExt = c7252av.vCy.vCt;
                    c9365gt.cBv.scene = 3;
                    C4879a.xxA.mo10055m(c9365gt);
                    C24826a.gkF.mo38855a(C22089b.this.activity, c7252av.vCy.fKh, df, cqu.jBB, i, 11, 6, c7252av.vCy.vCs, cqu.f15074Id);
                    AppMethodBeat.m2505o(40260);
                    return;
                    break;
            }
            AppMethodBeat.m2505o(40260);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$14 */
    class C2208314 implements OnClickListener {
        C2208314() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40261);
            if (view.getTag() instanceof C46236n) {
                C46236n c46236n = (C46236n) view.getTag();
                if (c46236n.field_type == 21 && C1853r.m3846Yz().equals(c46236n.field_userName)) {
                    c46236n.cqu();
                    C39742m.m67972m(c46236n);
                    C39742m.m67971l(c46236n);
                    System.currentTimeMillis();
                    C21904b.m33474kT(24);
                }
                Intent intent = new Intent();
                intent.putExtra("key_sendid", c46236n.cqA());
                intent.putExtra("key_feedid", c46236n.cqU());
                intent.setClassName(C22089b.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
                C22089b.this.activity.startActivity(intent);
                String cqU = c46236n.cqU();
                c46236n.cqA();
                C2208314.m33698ZQ(cqU);
            }
            AppMethodBeat.m2505o(40261);
        }

        /* renamed from: ZQ */
        private static void m33698ZQ(String str) {
            int i = 0;
            AppMethodBeat.m2504i(40262);
            C46236n kD = C13373af.cnF().mo62941kD(C13373af.cnF().mo62918YT(str).field_snsId);
            if (kD != null) {
                TimeLineObject cqu = kD.cqu();
                if (cqu != null) {
                    LinkedList linkedList = cqu.xfI.wbK;
                    if (linkedList.size() > 0) {
                        linkedList.get(0);
                    }
                }
                cbf q = C34955aj.m57409q(kD);
                ArrayList arrayList = new ArrayList();
                LinkedList linkedList2 = q.xaE.xbh;
                if (linkedList2 != null) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= linkedList2.size()) {
                            break;
                        }
                        cbb cbb = (cbb) linkedList2.get(i2);
                        C3331a c3331a = new C3331a();
                        c3331a.igi = cbb.vHl;
                        c3331a.nRz = cbb.pcX;
                        c3331a.nRA = cbb.wZK;
                        arrayList.add(c3331a);
                        i = i2 + 1;
                    }
                }
                C3330a.m5634o(str, arrayList);
            }
            AppMethodBeat.m2505o(40262);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$16 */
    class C2208416 implements OnClickListener {
        C2208416() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40264);
            C22089b.this.mo17695dJ(view);
            AppMethodBeat.m2505o(40264);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$28 */
    class C2208728 implements OnItemClickListener {
        C2208728() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(40284);
            if (view.getTag() != null && (view.getTag() instanceof C34935b)) {
                C34935b c34935b = (C34935b) view.getTag();
                if (i < c34935b.qFH.rDn.qTP.coJ().size()) {
                    if (c34935b.qFH.rDn.qTT) {
                        AppMethodBeat.m2505o(40284);
                        return;
                    }
                    Object obj = (C21983a) c34935b.qFH.rDn.qTP.coJ().get(i);
                    C4990ab.m7417i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", obj.qTZ, Integer.valueOf(obj.qUc));
                    C46236n YT = C13373af.cnF().mo62918YT(c34935b.cwT);
                    if (YT == null) {
                        AppMethodBeat.m2505o(40284);
                        return;
                    }
                    obj.qFI = c34935b.qFI;
                    obj.qUd = System.currentTimeMillis();
                    C1207m c46224r = new C46224r(YT.field_snsId, 8, obj);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c46224r, 0);
                    C22089b.this.mo17697dL(view);
                }
            }
            AppMethodBeat.m2505o(40284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$29 */
    class C2208829 implements OnClickListener {
        C2208829() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:187:0x04e5  */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x036b  */
        /* JADX WARNING: Removed duplicated region for block: B:188:0x04ed  */
        /* JADX WARNING: Removed duplicated region for block: B:161:0x039f  */
        /* JADX WARNING: Removed duplicated region for block: B:192:0x051a  */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x03c3  */
        /* JADX WARNING: Removed duplicated region for block: B:209:0x057a  */
        /* JADX WARNING: Removed duplicated region for block: B:169:0x03f6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            AppMethodBeat.m2504i(40285);
            if (view.getTag() == null || !((view.getTag() instanceof BaseViewHolder) || (view.getTag() instanceof C29190ao) || (view.getTag() instanceof C43589aj) || (view.getTag() instanceof MaskImageView) || (view.getTag() instanceof C35118a))) {
                AppMethodBeat.m2505o(40285);
                return;
            }
            Object obj;
            int obj2;
            int i;
            int i2;
            int i3;
            Object obj3;
            C46236n c46236n;
            C43589aj c43589aj;
            BaseViewHolder baseViewHolder;
            C46236n c46236n2 = null;
            int i4 = 0;
            int i5 = 0;
            C46236n YT;
            if (view.getTag() instanceof C29190ao) {
                YT = C21990h.m33616YT(((C29190ao) view.getTag()).czD);
                if (view instanceof LinearLayout) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (((C29190ao) view.getTag()).rnw) {
                    int i6 = ((C29190ao) view.getTag()).index;
                    if (i6 > 0) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    i4 = i6;
                } else {
                    i = 0;
                }
                i2 = i;
                i3 = i4;
                obj3 = obj2;
                c46236n = YT;
            } else {
                if (view.getTag() instanceof MaskImageView) {
                    Object obj4;
                    MaskImageView maskImageView = (MaskImageView) view.getTag();
                    if (maskImageView.getTag() instanceof C29190ao) {
                        c46236n = C21990h.m33616YT(((C29190ao) maskImageView.getTag()).czD);
                        if (!(view instanceof LinearLayout)) {
                            obj4 = 1;
                            c46236n2 = c46236n;
                        }
                    } else {
                        obj4 = null;
                    }
                    i2 = 0;
                    i3 = 0;
                    obj3 = obj4;
                    c46236n = c46236n2;
                } else if (view.getTag() instanceof C43589aj) {
                    c43589aj = (C43589aj) view.getTag();
                    YT = C13373af.cnF().mo62918YT(c43589aj.cwT);
                    if (view instanceof LinearLayout) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (c43589aj.rnw) {
                        i4 = c43589aj.rnx;
                        i = i4 > 0 ? 2 : 1;
                    } else {
                        i = 0;
                    }
                    i2 = i;
                    i3 = i4;
                    obj3 = obj2;
                    c46236n = YT;
                } else if (view.getTag() instanceof BaseViewHolder) {
                    baseViewHolder = (BaseViewHolder) view.getTag();
                    c46236n = C21990h.m33615YS(baseViewHolder.cFc);
                    if (baseViewHolder instanceof C13697b) {
                        i4 = ((C13697b) baseViewHolder).rJh.index;
                        i = i4 > 0 ? 2 : 1;
                    } else {
                        i = 0;
                    }
                    i5 = i;
                } else if (view.getTag() instanceof C35118a) {
                    c46236n = ((C35118a) view.getTag()).ros;
                    if (view.getTag() instanceof C13665d) {
                        i4 = ((C13665d) view.getTag()).currentIndex;
                        i5 = i4 > 0 ? 2 : 1;
                    }
                } else {
                    c46236n = null;
                }
                i2 = i5;
                i3 = i4;
                obj3 = null;
            }
            if (c46236n == null || !c46236n.mo74253DI(32)) {
                AppMethodBeat.m2505o(40285);
                return;
            }
            String str;
            String str2;
            String coN;
            try {
                C21980a a = C22089b.m33699a(C22089b.this, c46236n);
                if (a == null) {
                    obj2 = "";
                } else {
                    str = a.hnw;
                }
                str2 = c46236n.cqu().f15074Id;
                if (!c46236n.coX()) {
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(C22089b.this.cvd == 0 ? 1 : 2);
                    objArr[1] = Integer.valueOf(obj3 != null ? 1 : 2);
                    objArr[2] = str2;
                    objArr[3] = obj2;
                    c7060h.mo8381e(14066, objArr);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.TimelineClickListener", "report click ad card style error " + e.getMessage());
            }
            if (c46236n.crd().cqo().coS()) {
                coN = c46236n.crd().cqo().coN();
                str = c46236n.crc();
                C1720g.m3534RN();
                str2 = C1668a.m3384QG();
                C35002v.m57492h(coN, str, str2, C35002v.m57487ak(coN, str, str2), 0);
            }
            TimeLineObject cqu = c46236n.cqu();
            Intent intent;
            TimeLineObject cqu2;
            LinkedList linkedList;
            SnsAdClick snsAdClick;
            boolean z;
            C21980a a2;
            Bundle bundle;
            if ((cqu.xfI.wbJ != 15 || cqu.xfP == 1) && !(cqu.xfI.wbJ == 27 && cqu.xfI.wbK.size() > i3 && ((bau) cqu.xfI.wbK.get(i3)).jCt == 6)) {
                if ((cqu.xfI.wbJ == 1 && cqu.xfI.wbK.size() == 1) || cqu.xfI.wbJ == 7 || (cqu.xfI.wbJ == 27 && cqu.xfI.wbK.size() > i3 && ((bau) cqu.xfI.wbK.get(i3)).jCt == 2)) {
                    View view2;
                    if (view.getTag() instanceof BaseViewHolder) {
                        baseViewHolder = (BaseViewHolder) view.getTag();
                        if (view.getTag() instanceof C4081a) {
                            view2 = ((C4081a) view.getTag()).rGX;
                        } else if (view.getTag() instanceof C13687a) {
                            view2 = ((C13687a) view.getTag()).rGX;
                        } else if (baseViewHolder instanceof C13697b) {
                            view2 = (TagImageView) ((C13697b) baseViewHolder).rJh.view;
                        } else {
                            view2 = baseViewHolder.rHT.mo8755DT(0);
                        }
                    } else {
                        if (view.getTag() instanceof C35118a) {
                            if (view.getTag() instanceof C13655b) {
                                view2 = ((C13655b) view.getTag()).rGK;
                            } else if (view.getTag() instanceof C13658c) {
                                view2 = ((C13658c) view.getTag()).rGX;
                            } else if (view.getTag() instanceof C13665d) {
                                view2 = ((C13665d) view.getTag()).contentView;
                            }
                        } else if (view.getTag() instanceof MaskImageView) {
                            view2 = (MaskImageView) view.getTag();
                        } else if (view.getTag() instanceof TagImageView) {
                            view2 = (TagImageView) view;
                        }
                        view2 = null;
                    }
                    if (c46236n.cqo().coK()) {
                        if (C3953i.m6305go(c46236n.crd().field_adxml, i3 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                            C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, c46236n.field_snsId, 21, i2, (byte) 0));
                            if (view.getTag() instanceof BaseViewHolder) {
                                C22089b.this.mo37648h((BaseViewHolder) view.getTag());
                            } else if (view.getTag() instanceof C35118a) {
                                C22089b.this.mo37646a((C35118a) view.getTag());
                            }
                            int[] iArr = new int[2];
                            view2.getLocationInWindow(iArr);
                            i5 = view2.getWidth();
                            obj2 = view2.getHeight();
                            intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", i5);
                            intent.putExtra("img_gallery_height", obj2);
                            intent.putExtra("sns_landing_pages_share_sns_id", c46236n.cqA());
                            intent.putExtra("sns_landing_pages_rawSnsId", c46236n.cqu().f15074Id);
                            intent.putExtra("sns_landing_pages_ux_info", c46236n.crc());
                            intent.putExtra("sns_landing_pages_aid", c46236n.cqZ());
                            intent.putExtra("sns_landing_pages_traceid", c46236n.cra());
                            cqu2 = c46236n.cqu();
                            if (cqu2 != null) {
                                linkedList = cqu2.xfI.wbK;
                                if (linkedList.size() > i3) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(i3)).wEH);
                                } else if (linkedList.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                                }
                            }
                            intent.setClass(C22089b.this.activity, SnsAdNativeLandingPagesUI.class);
                            i = 1;
                            if (C22089b.this.cvd == 2) {
                                i = 16;
                            } else if (C22089b.this.cvd == 1) {
                                i = 2;
                            }
                            intent.putExtra("sns_landig_pages_from_source", i);
                            intent.putExtra("sns_landing_pages_xml", i3 > 0 ? c46236n.cqo().coV() : c46236n.crd().field_adxml);
                            intent.putExtra("sns_landing_pages_rec_src", c46236n.cre());
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            C22089b.this.activity.startActivity(intent);
                            C22089b.this.activity.overridePendingTransition(0, 0);
                            if (C22089b.this.rhQ != null) {
                                C22089b.this.rhQ.cnj().mo69122x(c46236n);
                            }
                            AppMethodBeat.m2505o(40285);
                            return;
                        }
                    }
                    if (C22089b.m33702a(C22089b.this, C22089b.m33699a(C22089b.this, c46236n), c46236n, i3 > 0)) {
                        C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, c46236n.field_snsId, 31, i2, (byte) 0));
                        AppMethodBeat.m2505o(40285);
                        return;
                    }
                    coN = i3 > 0 ? c46236n.cqo().qUX.qTA : c46236n.crb();
                    if (C5046bo.isNullOrNil(coN)) {
                        coN = c46236n.getAdLink();
                    }
                    if (C5046bo.isNullOrNil(coN)) {
                        AppMethodBeat.m2505o(40285);
                        return;
                    }
                    snsAdClick = new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, c46236n.field_snsId, 0, i2, (byte) 0);
                    C29036i.m46098a(snsAdClick);
                    C4990ab.m7416i("MicroMsg.TimelineClickListener", "adlink url " + coN + " " + c46236n.cqo().qUg);
                    intent = new Intent();
                    z = c46236n.cqo().qUg == 0;
                    if (C1947ae.giI) {
                        z = false;
                    }
                    if (c46236n != null && c46236n.mo74253DI(32)) {
                        a2 = C22089b.m33699a(C22089b.this, c46236n);
                        if (a2 != null) {
                            intent.putExtra("KsnsViewId", a2.hnw);
                        }
                    }
                    intent.putExtra("KRightBtn", z);
                    bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    bundle.putString("key_snsad_statextstr", c46236n.cqu().rjC);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("rawUrl", coN);
                    intent.putExtra("useJs", true);
                    intent.putExtra("srcUsername", c46236n.field_userName);
                    intent.putExtra("stastic_scene", 15);
                    intent.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                    intent.putExtra("pre_username", c46236n.field_userName);
                    intent.putExtra("prePublishId", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                    intent.putExtra("preUsername", c46236n.field_userName);
                    C24826a.gkE.mo38924i(intent, C22089b.this.activity);
                }
                AppMethodBeat.m2505o(40285);
                return;
            }
            C43589aj c43589aj2;
            C4990ab.m7416i("MicroMsg.TimelineClickListener", "onsight click");
            c43589aj = null;
            BaseViewHolder baseViewHolder2 = null;
            if (view.getTag() instanceof C43589aj) {
                c43589aj = (C43589aj) view.getTag();
            }
            if (view.getTag() instanceof BaseViewHolder) {
                baseViewHolder = (BaseViewHolder) view.getTag();
                if (cqu.xfI.wbJ == 27) {
                    baseViewHolder2 = baseViewHolder;
                    c43589aj2 = ((C13697b) baseViewHolder).rJi;
                } else {
                    baseViewHolder2 = baseViewHolder;
                    c43589aj2 = baseViewHolder.rGD;
                }
            } else if (view.getTag() instanceof C35118a) {
                c43589aj2 = ((C35118a) view.getTag()).rGD;
            } else {
                c43589aj2 = c43589aj;
            }
            if (c46236n == null) {
                AppMethodBeat.m2505o(40285);
                return;
            }
            if (C22089b.this.rhQ != null) {
                C22089b.this.rhQ.cnj().mo69122x(c46236n);
            }
            boolean DI = c46236n.mo74253DI(32);
            if (cqu.xfI.wbK == null || cqu.xfI.wbK.size() == 0) {
                C4990ab.m7412e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                AppMethodBeat.m2505o(40285);
                return;
            }
            C37952b lY;
            int[] iArr2;
            bau bau = (bau) cqu.xfI.wbK.get(i3);
            if (DI) {
                C13373af.cnC();
                if (!(C21925g.m33541t(bau) || c43589aj2 == null)) {
                    c43589aj2.raP.setVisibility(8);
                    c43589aj2.rnu.setVisibility(0);
                    c43589aj2.rnu.dKB();
                    C13373af.cnC().mo37473z(bau);
                    C43558b cnA = C13373af.cnA();
                    C44222az dtl = C44222az.dtl();
                    dtl.oyB = cqu.pcX;
                    cnA.mo69138a(bau, 4, null, dtl);
                    if (DI) {
                        C34927j.m57341a(C34930b.Sight, C13354a.PlayIcon, c46236n, C22089b.this.cvd);
                    }
                    AppMethodBeat.m2505o(40285);
                    return;
                }
            }
            if (c46236n.mo74253DI(32) && c46236n.cqo().coK()) {
                if (C3953i.m6305go(c46236n.crd().field_adxml, i3 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                    obj3 = 1;
                    if (obj3 == null || !DI || !C13373af.cnC().mo37468u(bau) || c43589aj2 == null) {
                        int i7;
                        if (C22089b.this.cvd != 0) {
                            lY = C37952b.m64170lY(717);
                        } else {
                            lY = C37952b.m64171lZ(717);
                        }
                        lY.mo60722tx(C29036i.m46115j(c46236n)).mo60720mb(c46236n.field_type).mo60718cS(c46236n.mo74253DI(32)).mo60722tx(c46236n.crc()).mo60722tx(bau.f17915Id);
                        lY.ajK();
                        if (C22089b.this.cvd != 0) {
                            lY = C37952b.m64170lY(745);
                        } else {
                            lY = C37952b.m64171lZ(745);
                        }
                        lY.mo60722tx(C29036i.m46115j(c46236n)).mo60720mb(c46236n.field_type).mo60718cS(c46236n.mo74253DI(32));
                        iArr2 = new int[2];
                        if (baseViewHolder2 == null) {
                            if (baseViewHolder2.rGD.rnt != null) {
                                baseViewHolder2.rGD.rnt.getLocationInWindow(iArr2);
                                i4 = baseViewHolder2.rGD.rnt.getWidth();
                                obj2 = baseViewHolder2.rGD.rnt.getHeight();
                                i7 = i4;
                            } else if (cqu.xfI.wbJ == 27) {
                                ((C13697b) baseViewHolder2).rJf.getLocationInWindow(iArr2);
                                i4 = ((C13697b) baseViewHolder2).rJf.getWidth();
                                obj2 = ((C13697b) baseViewHolder2).rJf.getHeight();
                                i7 = i4;
                            } else {
                                obj2 = 0;
                                i7 = 0;
                            }
                        } else if (view.getTag() instanceof C43589aj) {
                            c43589aj = (C43589aj) view.getTag();
                            if (c43589aj != null) {
                                c43589aj.rnt.getLocationInWindow(iArr2);
                            }
                            i5 = c43589aj.rnt.getWidth();
                            obj2 = c43589aj.rnt.getHeight();
                            i7 = i5;
                        } else {
                            if (view != null) {
                                view.getLocationInWindow(iArr2);
                            }
                            i5 = view.getWidth();
                            obj2 = view.getHeight();
                            i7 = i5;
                        }
                        C7060h.pYm.mo8381e(11444, Integer.valueOf(3));
                        if (obj3 == null) {
                            if (view.getTag() instanceof BaseViewHolder) {
                                C22089b.this.mo37648h((BaseViewHolder) view.getTag());
                            } else if (view.getTag() instanceof C35118a) {
                                C22089b.this.mo37646a((C35118a) view.getTag());
                            }
                            C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, c46236n.field_snsId, 22, 21));
                            Intent intent2 = new Intent();
                            intent2.putExtra("img_gallery_left", iArr2[0]);
                            intent2.putExtra("img_gallery_top", iArr2[1]);
                            intent2.putExtra("img_gallery_width", i7);
                            intent2.putExtra("img_gallery_height", obj2);
                            intent2.putExtra("sns_landing_pages_share_sns_id", c46236n.cqA());
                            intent2.putExtra("sns_landing_pages_rawSnsId", c46236n.cqu().f15074Id);
                            intent2.putExtra("sns_landing_pages_ux_info", c46236n.crc());
                            cqu2 = c46236n.cqu();
                            if (cqu2 != null) {
                                linkedList = cqu2.xfI.wbK;
                                if (linkedList.size() > i3) {
                                    intent2.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(i3)).wEH);
                                }
                            }
                            intent2.setClass(C22089b.this.activity, SnsAdNativeLandingPagesUI.class);
                            i = 1;
                            if (C22089b.this.cvd == 2) {
                                i = 16;
                            } else if (C22089b.this.cvd == 1) {
                                i = 2;
                            }
                            intent2.putExtra("sns_landig_pages_from_source", i);
                            intent2.putExtra("sns_landing_pages_xml", i3 > 0 ? c46236n.cqo().coV() : c46236n.crd().field_adxml);
                            intent2.putExtra("sns_landing_pages_rec_src", c46236n.cre());
                            intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            intent2.putExtra("sns_landing_is_native_sight_ad", true);
                            C22089b.this.activity.startActivity(intent2);
                            C22089b.this.activity.overridePendingTransition(0, 0);
                            AppMethodBeat.m2505o(40285);
                            return;
                        }
                        if (C22089b.m33702a(C22089b.this, C22089b.m33699a(C22089b.this, c46236n), c46236n, i3 > 0)) {
                            C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, c46236n.field_snsId, 22, 31));
                            AppMethodBeat.m2505o(40285);
                            return;
                        }
                        snsAdClick = new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, c46236n.field_snsId, 22, 0);
                        C29036i.m46098a(snsAdClick);
                        coN = i3 > 0 ? c46236n.cqo().qUX.qTA : c46236n.crb();
                        if (C5046bo.isNullOrNil(coN)) {
                            coN = c46236n.getAdLink();
                        }
                        if (C5046bo.isNullOrNil(coN)) {
                            AppMethodBeat.m2505o(40285);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.TimelineClickListener", "adlink url " + coN + " " + c46236n.cqo().qUg);
                        intent = new Intent();
                        z = c46236n.cqo().qUg == 0;
                        if (C1947ae.giI) {
                            z = false;
                        }
                        if (c46236n != null && c46236n.mo74253DI(32)) {
                            a2 = C22089b.m33699a(C22089b.this, c46236n);
                            if (a2 != null) {
                                intent.putExtra("KsnsViewId", a2.hnw);
                            }
                        }
                        intent.putExtra("KRightBtn", z);
                        bundle = new Bundle();
                        bundle.putParcelable("KSnsAdTag", snsAdClick);
                        bundle.putString("key_snsad_statextstr", c46236n.cqu().rjC);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", coN);
                        intent.putExtra("useJs", true);
                        intent.putExtra("srcUsername", c46236n.field_userName);
                        intent.putExtra("stastic_scene", 15);
                        intent.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                        intent.putExtra("pre_username", c46236n.field_userName);
                        intent.putExtra("prePublishId", "sns_" + C29036i.m46117jV(c46236n.field_snsId));
                        intent.putExtra("preUsername", c46236n.field_userName);
                        C24826a.gkE.mo38924i(intent, C22089b.this.activity);
                        AppMethodBeat.m2505o(40285);
                        return;
                    }
                    C13373af.cnC().mo37473z(bau);
                    c43589aj2.raP.setVisibility(8);
                    c43589aj2.rnu.setVisibility(8);
                    C21925g cnC = C13373af.cnC();
                    C34915a c34915a = c43589aj2.qzM;
                    i4 = C22089b.this.activity.hashCode();
                    int i8 = c43589aj2.position;
                    C44222az dtl2 = C44222az.dtl();
                    dtl2.oyB = cqu.pcX;
                    cnC.mo37448a(c46236n, bau, c34915a, i4, i8, dtl2, DI);
                    if (DI) {
                        C34927j.m57341a(C34930b.Sight, C13354a.PlayIcon, c46236n, C22089b.this.cvd);
                    }
                    AppMethodBeat.m2505o(40285);
                    return;
                }
            }
            obj3 = null;
            if (obj3 == null) {
            }
            if (C22089b.this.cvd != 0) {
            }
            lY.mo60722tx(C29036i.m46115j(c46236n)).mo60720mb(c46236n.field_type).mo60718cS(c46236n.mo74253DI(32)).mo60722tx(c46236n.crc()).mo60722tx(bau.f17915Id);
            lY.ajK();
            if (C22089b.this.cvd != 0) {
            }
            lY.mo60722tx(C29036i.m46115j(c46236n)).mo60720mb(c46236n.field_type).mo60718cS(c46236n.mo74253DI(32));
            iArr2 = new int[2];
            if (baseViewHolder2 == null) {
            }
            C7060h.pYm.mo8381e(11444, Integer.valueOf(3));
            if (obj3 == null) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$6 */
    class C220906 extends C22121c {
        C220906() {
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40249);
            if (view.getTag() instanceof C13707q) {
                C22089b.this.rKb.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            }
            AppMethodBeat.m2505o(40249);
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40250);
            if (view.getTag() instanceof C13707q) {
                String str = ((C13707q) view.getTag()).cwT;
                C22089b.this.rJH.mo69202a(view, str, C13373af.cnF().mo62918YT(str).cqu());
                AppMethodBeat.m2505o(40250);
                return true;
            }
            AppMethodBeat.m2505o(40250);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$7 */
    class C220917 extends C22121c {
        C220917() {
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40251);
            if (view != null && (view.getTag() instanceof C29190ao)) {
                int width;
                int height;
                String str = ((C29190ao) view.getTag()).czD;
                C46236n YT = C13373af.cnF().mo62918YT(str);
                if (C25985d.afj("favorite")) {
                    contextMenu.add(0, 2, 0, C22089b.this.activity.getString(C25738R.string.dcq));
                    C9321dq c9321dq = new C9321dq();
                    c9321dq.cxc.cwT = str;
                    C4879a.xxA.mo10055m(c9321dq);
                    if (c9321dq.cxd.cwB) {
                        contextMenu.add(0, 18, 0, C22089b.this.activity.getString(C25738R.string.f9188s7));
                    }
                }
                C21865a.m33410a(contextMenu, YT);
                MenuItem add = contextMenu.add(0, 21, 0, C22089b.this.activity.getString(C25738R.string.ekc));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
            AppMethodBeat.m2505o(40251);
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40252);
            if (view.getTag() instanceof C29190ao) {
                String str = ((C29190ao) view.getTag()).czD;
                C22089b.this.rJH.mo69202a(view, str, C13373af.cnF().mo62918YT(str).cqu());
                AppMethodBeat.m2505o(40252);
                return true;
            }
            AppMethodBeat.m2505o(40252);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$8 */
    class C220928 extends C22121c {
        C220928() {
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            String str;
            AppMethodBeat.m2504i(40253);
            Object tag = view.getTag();
            if (tag instanceof C29190ao) {
                str = ((C29190ao) tag).czD;
            } else if (tag instanceof C13707q) {
                str = ((C13707q) tag).cwT;
            } else {
                str = null;
            }
            if (str != null) {
                C22089b.this.rJH.mo69202a(view, str, C13373af.cnF().mo62918YT(str).cqu());
                AppMethodBeat.m2505o(40253);
                return true;
            }
            AppMethodBeat.m2505o(40253);
            return false;
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            String str;
            AppMethodBeat.m2504i(40254);
            Object tag = view.getTag();
            if (tag instanceof C29190ao) {
                str = ((C29190ao) tag).czD;
            } else if (tag instanceof C13707q) {
                str = ((C13707q) tag).cwT;
            } else {
                str = null;
            }
            if (str != null) {
                C46236n YT = C13373af.cnF().mo62918YT(str);
                TimeLineObject cqu = YT.cqu();
                if (C25985d.afj("favorite")) {
                    switch (cqu.xfI.wbJ) {
                        case 1:
                            contextMenu.add(0, 2, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        case 15:
                            contextMenu.add(0, 10, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                    }
                }
                C21865a.m33410a(contextMenu, YT);
            }
            AppMethodBeat.m2505o(40254);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$9 */
    class C220939 implements OnClickListener {
        C220939() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40255);
            String str = null;
            if (view.getTag() instanceof C29190ao) {
                str = ((C29190ao) view.getTag()).czD;
            } else if (view.getTag() instanceof BaseViewHolder) {
                str = ((BaseViewHolder) view.getTag()).cwT;
            } else if (view.getTag() instanceof C35118a) {
                str = ((C35118a) view.getTag()).ros.cqU();
            }
            C46236n YT = C21990h.m33616YT(str);
            if (YT == null) {
                C4990ab.m7412e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(40255);
            } else if (YT.mo74253DI(32) && YT.cqo() != null && (YT.cqo().coP() || YT.cqo().coQ())) {
                C22089b.this.rKn.onClick(view);
                AppMethodBeat.m2505o(40255);
            } else {
                if (YT.cqu().xfI.wbJ == 21) {
                    if (C1853r.m3846Yz().equals(YT.field_userName)) {
                        YT.cqu();
                        C39742m.m67972m(YT);
                        C39742m.m67971l(YT);
                        System.currentTimeMillis();
                        C21904b.m33474kT(25);
                    }
                    if (!C1853r.m3846Yz().equals(YT.field_userName)) {
                        C46215a.m86422a(2, YT);
                        C21904b.m33474kT(30);
                    }
                }
                if (YT.mo74253DI(32)) {
                    C22089b.m33699a(C22089b.this, YT);
                    if (YT.cqo().coK() && C3953i.m6288YO(YT.crd().field_adxml)) {
                        int i;
                        str = C3953i.m6309y(YT);
                        if (!C5046bo.isNullOrNil(str)) {
                            YT.crd().field_adxml = str;
                        }
                        C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 21, 21));
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", YT.cqA());
                        intent.putExtra("sns_landing_pages_rawSnsId", YT.cqu().f15074Id);
                        intent.putExtra("sns_landing_pages_ux_info", YT.crc());
                        intent.putExtra("sns_landing_pages_aid", YT.cqZ());
                        intent.putExtra("sns_landing_pages_traceid", YT.cra());
                        TimeLineObject cqu = YT.cqu();
                        if (cqu != null) {
                            LinkedList linkedList = cqu.xfI.wbK;
                            if (linkedList.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                                intent.putExtra("sns_landing_pages_from_outer_index", ((C29190ao) view.getTag()).index);
                            }
                        }
                        intent.setClass(C22089b.this.activity, SnsAdNativeLandingPagesUI.class);
                        if (C22089b.this.cvd == 2) {
                            i = 16;
                        } else if (C22089b.this.cvd == 1) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                        intent.putExtra("sns_landig_pages_from_source", i);
                        intent.putExtra("sns_landing_pages_xml", YT.crd().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", YT.cre());
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        C22089b.this.activity.startActivity(intent);
                        C22089b.this.activity.overridePendingTransition(0, 0);
                        if (C22089b.this.rhQ != null) {
                            C22089b.this.rhQ.cnj().mo69122x(YT);
                        }
                    } else {
                        C22089b.this.mo17689cp(view);
                    }
                } else {
                    C22089b.this.mo17689cp(view);
                }
                C29190ao c29190ao = (C29190ao) view.getTag();
                if (c29190ao.rps && YT != null) {
                    C29169a.m46338b(YT, c29190ao.index);
                    C29169a.m46339c(YT, c29190ao.index);
                    C13417av.m21560Yk(YT.cqU());
                }
                if (YT != null) {
                    TimeLineObject cqu2 = YT.cqu();
                    if (cqu2 != null) {
                        String str2 = cqu2.xfH == null ? null : cqu2.xfH.f17242Id;
                        if (!C5046bo.isNullOrNil(str2)) {
                            C24826a.gkF.mo38855a(null, str2, C24826a.gkF.mo38864df(str2), cqu2.jBB, 2, 4, 4, cqu2.xfM, cqu2.f15074Id);
                        }
                    }
                }
                AppMethodBeat.m2505o(40255);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$15 */
    class C2209415 implements OnClickListener {
        C2209415() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40263);
            C22089b.this.mo17692dG(view);
            AppMethodBeat.m2505o(40263);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$26 */
    class C2209526 implements OnClickListener {
        C2209526() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40282);
            C22089b.this.mo17696dK(view);
            if (view.getTag() == null || !(view.getTag() instanceof C34935b)) {
                AppMethodBeat.m2505o(40282);
                return;
            }
            C34935b c34935b = (C34935b) view.getTag();
            C46236n YT = C13373af.cnF().mo62918YT(c34935b.cwT);
            if (YT == null) {
                AppMethodBeat.m2505o(40282);
                return;
            }
            if (YT.mo74253DI(32)) {
                c34935b.qFI = System.currentTimeMillis();
                C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 20, 0));
            }
            AppMethodBeat.m2505o(40282);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$30 */
    class C2209630 extends C22121c {
        C2209630() {
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40286);
            Object tag = view.getTag();
            if (tag instanceof C13707q) {
                C13707q c13707q = (C13707q) tag;
                TimeLineObject timeLineObject = c13707q.rin;
                if (timeLineObject.xfI.wbJ == 10 || timeLineObject.xfI.wbJ == 17 || timeLineObject.xfI.wbJ == 22 || timeLineObject.xfI.wbJ == 23) {
                    AppMethodBeat.m2505o(40286);
                    return false;
                }
                C22089b.this.rJH.mo69202a(view, c13707q.cwT, timeLineObject);
                AppMethodBeat.m2505o(40286);
                return true;
            }
            AppMethodBeat.m2505o(40286);
            return false;
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40287);
            Object tag = view.getTag();
            if (tag instanceof C13707q) {
                C13707q c13707q = (C13707q) tag;
                TimeLineObject timeLineObject = c13707q.rin;
                if (C25985d.afj("favorite")) {
                    C9321dq c9321dq;
                    switch (timeLineObject.xfI.wbJ) {
                        case 1:
                            contextMenu.add(0, 2, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        case 3:
                            contextMenu.add(0, 3, 0, view.getContext().getString(C25738R.string.dcq));
                            c9321dq = new C9321dq();
                            c9321dq.cxc.cwT = c13707q.cwT;
                            C4879a.xxA.mo10055m(c9321dq);
                            if (c9321dq.cxd.cwB) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(C25738R.string.f9188s7));
                                break;
                            }
                            break;
                        case 4:
                            contextMenu.add(0, 4, 0, view.getContext().getString(C25738R.string.dcq));
                            c9321dq = new C9321dq();
                            c9321dq.cxc.cwT = c13707q.cwT;
                            C4879a.xxA.mo10055m(c9321dq);
                            if (c9321dq.cxd.cwB) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(C25738R.string.f9188s7));
                                break;
                            }
                            break;
                        case 9:
                            contextMenu.add(0, 5, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        case 14:
                            contextMenu.add(0, 9, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        case 15:
                            contextMenu.add(0, 10, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        case 26:
                            contextMenu.add(0, 22, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        default:
                            contextMenu.add(0, 3, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                    }
                }
                C21865a.m33410a(contextMenu, C13373af.cnF().mo62918YT(c13707q.cwT));
            }
            AppMethodBeat.m2505o(40287);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$35 */
    class C2209735 implements OnClickListener {
        C2209735() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40297);
            if (view.getTag() instanceof String) {
                C46236n YT = C13373af.cnF().mo62918YT((String) view.getTag());
                C37952b lY;
                if (YT == null) {
                    AppMethodBeat.m2505o(40297);
                    return;
                } else if (YT.mo74253DI(32)) {
                    C4990ab.m7416i("MicroMsg.TimelineClickListener", "click the ad poi button");
                    C21980a a = C22089b.m33699a(C22089b.this, YT);
                    if (a == null) {
                        C4990ab.m7412e("MicroMsg.TimelineClickListener", "the adInfo is null");
                        AppMethodBeat.m2505o(40297);
                        return;
                    }
                    SnsAdClick snsAdClick = new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 19, 0);
                    C29036i.m46098a(snsAdClick);
                    if (C5046bo.isNullOrNil(a.qTE)) {
                        C4990ab.m7412e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                        AppMethodBeat.m2505o(40297);
                        return;
                    }
                    if (C22089b.this.cvd == 0) {
                        lY = C37952b.m64170lY(724);
                    } else {
                        lY = C37952b.m64171lZ(724);
                    }
                    lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx("").mo60722tx("").mo60722tx("").mo60722tx("").mo60722tx(a.qTD).mo60722tx("").mo60722tx("");
                    lY.ajK();
                    C4990ab.m7416i("MicroMsg.TimelineClickListener", "open webview url : " + a.qTE);
                    Intent intent = new Intent();
                    if (YT != null && YT.mo74253DI(32)) {
                        C21980a a2 = C22089b.m33699a(C22089b.this, YT);
                        if (a2 != null) {
                            intent.putExtra("KsnsViewId", a2.hnw);
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("useJs", true);
                    intent.putExtra("KPublisherId", "sns_" + C29036i.m46117jV(YT.field_snsId));
                    intent.putExtra("pre_username", YT.field_userName);
                    intent.putExtra("prePublishId", "sns_" + C29036i.m46117jV(YT.field_snsId));
                    intent.putExtra("preUsername", YT.field_userName);
                    intent.putExtra("rawUrl", a.qTE);
                    C24826a.gkE.mo38924i(intent, C22089b.this.activity);
                    AppMethodBeat.m2505o(40297);
                    return;
                } else {
                    ayt ayt = YT.cqu().xfG;
                    Intent intent2 = new Intent();
                    if (C22089b.this.cvd == 0) {
                        lY = C37952b.m64170lY(724);
                    } else {
                        lY = C37952b.m64171lZ(724);
                    }
                    lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(ayt.wCC).mo60720mb(ayt.rki).mo60722tx(ayt.vRq).mo60722tx(ayt.vRp).mo60722tx(ayt.eUu).mo60722tx(ayt.rkg).mo60722tx(ayt.guP);
                    lY.ajK();
                    if (C5046bo.isNullOrNil(ayt.wCC)) {
                        intent2.putExtra("map_view_type", 7);
                        intent2.putExtra("kwebmap_slat", (double) ayt.vRq);
                        intent2.putExtra("kwebmap_lng", (double) ayt.vRp);
                        intent2.putExtra("kPoiName", ayt.eUu);
                        intent2.putExtra("Kwebmap_locaion", ayt.rkg);
                        C25985d.m41467b(C22089b.this.activity, C8741b.LOCATION, ".ui.RedirectUI", intent2);
                        AppMethodBeat.m2505o(40297);
                        return;
                    }
                    String format;
                    if (C22089b.this.rKp == 0) {
                        format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[]{ayt.wCC});
                    } else {
                        format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[]{ayt.wCC, r1.f15074Id});
                    }
                    intent2.putExtra("rawUrl", format);
                    C24826a.gkE.mo38924i(intent2, C22089b.this.activity);
                    AppMethodBeat.m2505o(40297);
                    return;
                }
            }
            AppMethodBeat.m2505o(40297);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$23 */
    class C2209823 extends C4884c<C42065td> {
        C2209823() {
            AppMethodBeat.m2504i(40276);
            this.xxI = C42065td.class.getName().hashCode();
            AppMethodBeat.m2505o(40276);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(40277);
            C42065td c42065td = (C42065td) c4883b;
            C4990ab.m7416i("MicroMsg.TimelineClickListener", "receive timeline play click anim event");
            final long j;
            if (C22089b.this.rJD != null) {
                j = c42065td.cPq.cvc;
                C5004al.m7441d(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$23$1$1 */
                    class C220851 implements C43596a {
                        C220851() {
                        }

                        public final void onAnimationEnd() {
                            AppMethodBeat.m2504i(40272);
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "timeline click animation end");
                            C22089b.this.rJD = null;
                            AppMethodBeat.m2505o(40272);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(40273);
                        C22089b.this.rJD.mo25856kM(j);
                        C22089b.this.rJD.mo74356a(new C220851());
                        AppMethodBeat.m2505o(40273);
                    }
                });
                AppMethodBeat.m2505o(40277);
                return true;
            } else if (C22089b.this.rJF != null) {
                j = c42065td.cPq.cvc;
                C5004al.m7441d(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$23$2$1 */
                    class C220861 implements C43596a {
                        C220861() {
                        }

                        public final void onAnimationEnd() {
                            AppMethodBeat.m2504i(40274);
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "detail click animation end");
                            C22089b.this.rJF = null;
                            AppMethodBeat.m2505o(40274);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(40275);
                        C22089b.this.rJF.mo8883kM(j);
                        C22089b.this.rJF.mo74355a(new C220861());
                        AppMethodBeat.m2505o(40275);
                    }
                });
                AppMethodBeat.m2505o(40277);
                return true;
            } else {
                AppMethodBeat.m2505o(40277);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$25 */
    class C2210125 extends C22121c {
        C2210125() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00b8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40280);
            if (view.getTag() instanceof C43589aj) {
                int i;
                C43589aj c43589aj = (C43589aj) view.getTag();
                if (!c43589aj.qFG) {
                    contextMenu.add(0, 19, 0, C22089b.this.activity.getString(C25738R.string.amb));
                }
                if (C5046bo.ank(C26373g.m41964Nu().getValue("SIGHTCannotTransmitForFav")) == 0) {
                    if (c43589aj.rnr.xfI.wbK.size() > 0) {
                        bau bau = (bau) c43589aj.rnr.xfI.wbK.get(0);
                        String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46108e(bau);
                        String a = C34957aq.m57415a(c43589aj.cwT, bau);
                        C4990ab.m7417i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", Boolean.valueOf(C5730e.m8628ct(str)), Boolean.valueOf(C5730e.m8628ct(a)));
                        if (C5730e.m8628ct(str) && r1) {
                            i = 1;
                            if (C25985d.afj("favorite")) {
                                contextMenu.add(0, 10, 0, C22089b.this.activity.getString(C25738R.string.dcq));
                            }
                            if (i != 0) {
                                C9321dq c9321dq = new C9321dq();
                                c9321dq.cxc.cwT = c43589aj.cwT;
                                C4879a.xxA.mo10055m(c9321dq);
                                if (c9321dq.cxd.cwB) {
                                    contextMenu.add(0, 18, 0, C22089b.this.activity.getString(C25738R.string.f9188s7));
                                }
                            }
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
                    }
                }
                i = 0;
                if (C25985d.afj("favorite")) {
                }
                if (i != 0) {
                }
            }
            AppMethodBeat.m2505o(40280);
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40281);
            if (view.getTag() instanceof C43589aj) {
                String str = ((C43589aj) view.getTag()).cwT;
                C22089b.this.rJH.mo69202a(view, str, C13373af.cnF().mo62918YT(str).cqu());
                AppMethodBeat.m2505o(40281);
                return true;
            }
            AppMethodBeat.m2505o(40281);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$36 */
    class C2210236 implements OnClickListener {
        C2210236() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40298);
            if (view.getTag() instanceof String) {
                C46236n YT = C13373af.cnF().mo62918YT((String) view.getTag());
                if (YT == null) {
                    AppMethodBeat.m2505o(40298);
                    return;
                } else if (YT.mo74253DI(32)) {
                    C4990ab.m7416i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                    C21980a a = C22089b.m33699a(C22089b.this, YT);
                    if (a == null) {
                        C4990ab.m7412e("MicroMsg.TimelineClickListener", "the adInfo is null");
                        AppMethodBeat.m2505o(40298);
                        return;
                    } else if (C5046bo.isNullOrNil(a.qTH)) {
                        C4990ab.m7412e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                        AppMethodBeat.m2505o(40298);
                        return;
                    } else {
                        C4990ab.m7416i("MicroMsg.TimelineClickListener", "open webview url : " + a.qTH);
                        Intent intent = new Intent();
                        intent.putExtra("jsapiargs", new Bundle());
                        intent.putExtra("useJs", true);
                        intent.putExtra("rawUrl", a.qTH);
                        C24826a.gkE.mo38924i(intent, C22089b.this.activity);
                        AppMethodBeat.m2505o(40298);
                        return;
                    }
                } else {
                    AppMethodBeat.m2505o(40298);
                    return;
                }
            }
            AppMethodBeat.m2505o(40298);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$38 */
    class C2210338 implements OnClickListener {
        C2210338() {
        }

        public final void onClick(View view) {
            C46236n c46236n;
            int i;
            boolean z = false;
            int i2 = 1;
            AppMethodBeat.m2504i(40300);
            String str = (String) view.getTag();
            C4990ab.m7410d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(str)));
            Intent intent = new Intent();
            boolean i3;
            if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).eSe == null) {
                c46236n = null;
                i3 = false;
            } else {
                C46236n YT = C13373af.cnF().mo62918YT((String) ((MaskImageButton) view).eSe);
                if (YT.mo74253DI(32)) {
                    C21984b cqo = YT.cqo();
                    C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 1, 0));
                    if (cqo == null || cqo.qUq != 1 || C5046bo.isNullOrNil(cqo.qUr)) {
                        c46236n = YT;
                        i3 = 1;
                    } else {
                        str = cqo.qUr;
                        C4990ab.m7416i("MicroMsg.TimelineClickListener", "headClickParam url " + str + " " + cqo.qUs);
                        Intent intent2 = new Intent();
                        if (cqo.qUs == 0) {
                            z = true;
                        }
                        intent2.putExtra("KsnsViewId", C22089b.m33699a(C22089b.this, YT).hnw);
                        intent2.putExtra("KRightBtn", z);
                        intent2.putExtra("jsapiargs", new Bundle());
                        intent2.putExtra("rawUrl", str);
                        intent2.putExtra("useJs", true);
                        C24826a.gkE.mo38924i(intent2, C22089b.this.activity);
                        AppMethodBeat.m2505o(40300);
                        return;
                    }
                }
                c46236n = YT;
                i3 = false;
            }
            if (str.endsWith("@ad")) {
                AppMethodBeat.m2505o(40300);
                return;
            }
            if (c46236n != null) {
                C37952b lY;
                if (C22089b.this.cvd == 0) {
                    lY = C37952b.m64170lY(c46236n.mo74253DI(32) ? 722 : 721);
                } else {
                    lY = C37952b.m64171lZ(c46236n.mo74253DI(32) ? 722 : 721);
                }
                lY.mo60722tx(C29036i.m46115j(c46236n)).mo60720mb(c46236n.field_type).mo60718cS(c46236n.mo74253DI(32)).mo60722tx(c46236n.crc()).mo60722tx(str);
                lY.ajK();
            }
            if (i3 != 0) {
                SnsAdClick snsAdClick = new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, c46236n.field_snsId, 1, 0);
                intent.putExtra("Contact_User", str);
                intent.putExtra("KSnsAdTag", snsAdClick);
                str = "CONTACT_INFO_UI_SOURCE";
                if (C22089b.this.cvd == 0) {
                    i2 = 6;
                }
                intent.putExtra(str, i2);
                C24826a.gkE.mo38912c(intent, C22089b.this.activity);
                AppMethodBeat.m2505o(40300);
                return;
            }
            C37952b lY2;
            C22089b.this.rhQ.cnj().mo69103a(c46236n, true);
            if (C22089b.this.cvd == 0) {
                lY2 = C37952b.m64170lY(746);
            } else {
                lY2 = C37952b.m64171lZ(746);
            }
            lY2.mo60722tx(str).mo60718cS(str.endsWith(C1853r.m3846Yz()));
            lY2.mo60717b(intent, "intent_key_StatisticsOplog");
            String str2 = "CONTACT_INFO_UI_SOURCE";
            if (C22089b.this.cvd == 0) {
                i2 = 6;
            }
            intent.putExtra(str2, i2);
            intent.putExtra("Contact_User", str);
            C24826a.gkE.mo38912c(intent, C22089b.this.activity);
            AppMethodBeat.m2505o(40300);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$3 */
    class C221043 extends C22121c {
        C221043() {
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40243);
            C39828ar c39828ar = (C39828ar) view.getTag();
            C46236n YS = C13373af.cnF().mo62917YS(c39828ar.cFc);
            if (YS == null) {
                AppMethodBeat.m2505o(40243);
                return;
            }
            contextMenu.add(0, 0, 0, C22089b.this.activity.getString(C25738R.string.f9082oy));
            if (C25985d.afj("favorite")) {
                contextMenu.add(0, 1, 0, C22089b.this.activity.getString(C25738R.string.dcq));
            }
            TimeLineObject cqu = YS.cqu();
            if (c39828ar.rvm || !(cqu == null || cqu.xfK == 1 || c39828ar.rvn)) {
                if (c39828ar.ctI()) {
                    C13413ap.m21544b(contextMenu, true);
                } else {
                    C13413ap.m21541a(contextMenu, true);
                }
            }
            C21865a.m33410a(contextMenu, YS);
            AppMethodBeat.m2505o(40243);
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40244);
            if (view.getTag() instanceof C39828ar) {
                C46236n YS = C13373af.cnF().mo62917YS(((C39828ar) view.getTag()).cFc);
                if (YS == null) {
                    AppMethodBeat.m2505o(40244);
                    return false;
                }
                C22089b.this.rJH.mo69202a(view, YS.cqU(), YS.cqu());
                AppMethodBeat.m2505o(40244);
                return true;
            }
            AppMethodBeat.m2505o(40244);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$5 */
    class C221055 extends C22121c {
        C221055() {
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40247);
            if ((view.getTag() instanceof BaseViewHolder) || (view.getTag() instanceof C46236n)) {
                C46236n YS;
                Object tag = view.getTag();
                if (tag instanceof BaseViewHolder) {
                    YS = C21990h.m33615YS(((BaseViewHolder) view.getTag()).cFc);
                } else if (tag instanceof C46236n) {
                    YS = (C46236n) tag;
                } else {
                    YS = null;
                }
                if (YS != null) {
                    C22089b.this.rJH.mo69202a(view, YS.cqU(), YS.cqu());
                }
                AppMethodBeat.m2505o(40247);
                return true;
            }
            AppMethodBeat.m2505o(40247);
            return false;
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40248);
            Object tag = view.getTag();
            if ((tag instanceof BaseViewHolder) || (tag instanceof C46236n)) {
                C46236n YS;
                if (tag instanceof BaseViewHolder) {
                    YS = C21990h.m33615YS(((BaseViewHolder) tag).cFc);
                } else if (tag instanceof C46236n) {
                    YS = (C46236n) tag;
                } else {
                    YS = null;
                }
                if (C25985d.afj("favorite")) {
                    C21984b cqo = YS.cqo();
                    C21980a a = C22089b.m33699a(C22089b.this, YS);
                    if (cqo.coO()) {
                        if (cqo.coK()) {
                            contextMenu.add(0, 2, 0, view.getContext().getString(C25738R.string.dcq));
                        } else if (a.qTw == 0) {
                            contextMenu.add(0, 3, 0, view.getContext().getString(C25738R.string.dcq));
                        }
                    }
                    C9321dq c9321dq = new C9321dq();
                    c9321dq.cxc.cwT = YS.cqU();
                    C4879a.xxA.mo10055m(c9321dq);
                    if (c9321dq.cxd.cwB) {
                        contextMenu.add(0, 18, 0, view.getContext().getString(C25738R.string.f9188s7));
                    }
                }
                if (YS != null) {
                    C21865a.m33410a(contextMenu, YS);
                }
            }
            AppMethodBeat.m2505o(40248);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$10 */
    class C2210610 implements OnClickListener {
        C2210610() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40256);
            view.getTag();
            C22089b.this.mo17689cp(view);
            AppMethodBeat.m2505o(40256);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$11 */
    class C2210711 implements OnClickListener {
        C2210711() {
        }

        public final void onClick(final View view) {
            AppMethodBeat.m2504i(40258);
            C30379h.m48428a(C22089b.this.activity, (int) C25738R.string.epn, (int) C25738R.string.f9238tz, (int) C25738R.string.f9088p4, (int) C25738R.string.f9076or, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(40257);
                    if (view.getTag() instanceof String) {
                        String str = (String) view.getTag();
                        C4990ab.m7410d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(str)));
                        C46236n YT = C13373af.cnF().mo62918YT(str);
                        C37952b lY;
                        C37952b mb;
                        String str2;
                        if (YT == null) {
                            C4990ab.m7411d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", str);
                            AppMethodBeat.m2505o(40257);
                            return;
                        } else if (YT.cqW()) {
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "dead item");
                            C13373af.cnF().mo62915DL(YT.reX);
                            if (C22089b.this.rKo != null) {
                                C22089b.this.rKo.cud();
                            }
                            if (C22089b.this.cvd == 0) {
                                lY = C37952b.m64170lY(739);
                            } else {
                                lY = C37952b.m64171lZ(739);
                            }
                            mb = lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type);
                            str2 = YT.cqW() ? "2" : YT.field_snsId == 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            mb.mo60722tx(str2);
                            lY.ajK();
                            if (YT.field_type == 21) {
                                C21905g.cmv().cmx();
                            }
                            AppMethodBeat.m2505o(40257);
                            return;
                        } else if (YT.cnn()) {
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "cancel item " + YT.cqU());
                            C13373af.cnB().mo47134u(YT);
                            C22089b.this.crE();
                            AppMethodBeat.m2505o(40257);
                            return;
                        } else {
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "delete by server");
                            str = YT.cqA();
                            C13373af.cnE().mo37410km(C35002v.m57483Zm(str));
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(new C46224r(C35002v.m57483Zm(str), 1), 0);
                            C13373af.cnF().delete(C35002v.m57483Zm(str));
                            C13373af.cnK().mo47208ky(C35002v.m57483Zm(str));
                            C21991i.m33620kx(C35002v.m57483Zm(str));
                            C22089b.this.crE();
                            TimeLineObject cqu = YT.cqu();
                            if (cqu != null) {
                                if (cqu.xfH == null) {
                                    str = null;
                                } else {
                                    str = cqu.xfH.f17242Id;
                                }
                                if (!C5046bo.isNullOrNil(str) && C24826a.gkF.mo38866dk(str)) {
                                    String df = C24826a.gkF.mo38864df(str);
                                    C32606oi c32606oi = new C32606oi();
                                    c32606oi.cKD.appId = str;
                                    c32606oi.cKD.cKE = cqu.jBB;
                                    c32606oi.cKD.ceO = df;
                                    c32606oi.cKD.mediaTagName = cqu.xfM;
                                    C4879a.xxA.mo10055m(c32606oi);
                                }
                            }
                            if (C22089b.this.cvd == 0) {
                                lY = C37952b.m64170lY(739);
                            } else {
                                lY = C37952b.m64171lZ(739);
                            }
                            mb = lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type);
                            str2 = YT.cqW() ? "2" : YT.field_snsId == 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            mb.mo60722tx(str2);
                            lY.ajK();
                            AppMethodBeat.m2505o(40257);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(40257);
                }
            }, null);
            AppMethodBeat.m2505o(40258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$17 */
    class C2210917 implements OnClickListener {
        C2210917() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40265);
            if (view.getTag() instanceof String) {
                String str = (String) view.getTag();
                C4990ab.m7410d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(str)));
                C34955aj.m57388Da(C35002v.m57484Zn(str));
                C34955aj.m57386CY(C35002v.m57484Zn(str));
                C13373af.cnB().cmp();
                C22089b.this.crE();
                if (C22089b.this.rKo != null) {
                    C22089b.this.rKo.cud();
                }
            }
            AppMethodBeat.m2505o(40265);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$18 */
    class C2211018 implements OnClickListener {
        C2211018() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40266);
            try {
                int Zn = C35002v.m57484Zn((String) view.getTag());
                Intent intent = new Intent();
                intent.putExtra("sns_label_sns_info", Zn);
                C24826a.gkE.mo38936u(intent, C22089b.this.activity);
                AppMethodBeat.m2505o(40266);
            } catch (Exception e) {
                AppMethodBeat.m2505o(40266);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$19 */
    class C2211119 extends C22121c {
        C2211119() {
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40267);
            if (view.getTag() instanceof C46922l) {
                C46922l c46922l = (C46922l) view.getTag();
                if (!C39851d.m68264fF(c46922l.qJj.wZL, 16)) {
                    contextMenu.add(0, 11, 0, C22089b.this.activity.getString(C25738R.string.f9082oy));
                }
                if (c46922l.jBB != null && c46922l.jBB.equals(C1853r.m3846Yz())) {
                    contextMenu.add(0, 7, 0, C22089b.this.activity.getString(C25738R.string.f9088p4));
                }
                if (!C39851d.m68264fF(c46922l.qJj.wZL, 16)) {
                    int i;
                    String ga = C13413ap.m21555ga(c46922l.rib, (c46922l.qJj.wZG != 0 ? (long) c46922l.qJj.wZG : c46922l.qJj.wZJ));
                    if (c46922l.scene == 1) {
                        i = 2;
                    } else if (c46922l.scene == 2) {
                        i = 4;
                    } else {
                        i = -1;
                    }
                    C13414b Ye = C13413ap.m21540Ye(ga);
                    if (Ye == null || !Ye.foa || Ye.aAR || (i & Ye.dtW) == 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        C13413ap.m21541a(contextMenu, false);
                        AppMethodBeat.m2505o(40267);
                        return;
                    }
                    C13413ap.m21544b(contextMenu, false);
                }
            }
            AppMethodBeat.m2505o(40267);
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40268);
            if (view.getTag() instanceof C46922l) {
                C46236n YS = C13373af.cnF().mo62917YS(((C46922l) view.getTag()).rib);
                C22089b.this.rJH.mo69202a(view, YS.cqU(), YS.cqu());
                AppMethodBeat.m2505o(40268);
                return true;
            }
            AppMethodBeat.m2505o(40268);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$1 */
    class C221121 implements OnClickListener {
        C221121() {
        }

        public final void onClick(View view) {
            boolean z = false;
            AppMethodBeat.m2504i(40239);
            if (view.getTag() == null) {
                AppMethodBeat.m2505o(40239);
                return;
            }
            C46236n dQ = C22089b.m33704dQ(view);
            if (dQ == null || !dQ.mo74253DI(32)) {
                AppMethodBeat.m2505o(40239);
                return;
            }
            boolean z2;
            if (dQ.crd().cqo().coS()) {
                int i;
                int gr = C35002v.m57491gr(dQ.crd().cqo().coN(), dQ.crc());
                Object obj = gr > 0 ? 1 : null;
                String coN = dQ.crd().cqo().coN();
                String crc = dQ.crc();
                C1720g.m3534RN();
                String QG = C1668a.m3384QG();
                if (obj != null) {
                    i = gr;
                } else {
                    i = 1;
                }
                C35002v.m57492h(coN, crc, QG, i, obj != null ? 0 : 1);
                if (obj == null) {
                    z = true;
                }
                z2 = z;
            } else {
                z2 = false;
            }
            TimeLineObject cqu = dQ.cqu();
            if (cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                if ((cqu.xfI.wbJ == 1 && cqu.xfI.wbK.size() == 1) || cqu.xfI.wbJ == 7) {
                    C22089b.m33703b(C22089b.this, view, dQ, 1001, dQ.crd().cqo().coT(), z2);
                }
                AppMethodBeat.m2505o(40239);
                return;
            }
            C22089b.m33700a(C22089b.this, view, dQ, 1001, dQ.crd().cqo().coT(), z2);
            AppMethodBeat.m2505o(40239);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$2 */
    class C221132 implements OnLongClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$2$1 */
        class C221151 implements OnCreateContextMenuListener {
            C221151() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(40240);
                contextMenu.add(0, 0, 0, C22089b.this.activity.getString(C25738R.string.aya));
                contextMenu.add(1, 1, 0, C22089b.this.activity.getString(C25738R.string.epl));
                AppMethodBeat.m2505o(40240);
            }
        }

        C221132() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(40242);
            final String str = (String) view.getTag();
            C4990ab.m7410d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(40242);
                return true;
            } else if (str.equals(C13373af.cnk())) {
                AppMethodBeat.m2505o(40242);
                return true;
            } else {
                String str2;
                int i;
                if (((MaskImageButton) view).eSe == null || !(((MaskImageButton) view).eSe instanceof String)) {
                    str2 = "";
                } else {
                    str2 = (String) ((MaskImageButton) view).eSe;
                }
                Intent intent = new Intent();
                final C46236n YT = C13373af.cnF().mo62918YT(str2);
                if (YT == null || !YT.mo74253DI(32)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    AppMethodBeat.m2505o(40242);
                    return false;
                }
                C24088a c24088a = new C24088a(C22089b.this.activity, view);
                c24088a.zRZ = new C221151();
                c24088a.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        long j = 0;
                        AppMethodBeat.m2504i(40241);
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent();
                                String str = "sns_permission_snsinfo_svr_id";
                                if (YT != null) {
                                    j = YT.field_snsId;
                                }
                                intent.putExtra(str, j);
                                intent.putExtra("sns_permission_userName", str);
                                intent.putExtra("sns_permission_anim", true);
                                intent.putExtra("sns_permission_block_scene", 5);
                                intent.setClass(C22089b.this.activity, SnsPermissionUI.class);
                                C22089b.this.activity.startActivityForResult(intent, 11);
                                AppMethodBeat.m2505o(40241);
                                return;
                            case 1:
                                intent = new Intent();
                                C46236n YT = C13373af.cnF().mo62918YT(str2);
                                if (YT != null) {
                                    C4990ab.m7416i("MicroMsg.TimelineClickListener", "expose id " + YT.cqA() + " " + YT.field_userName);
                                    String str2 = "k_expose_msg_id";
                                    if (YT != null) {
                                        j = YT.field_snsId;
                                    }
                                    intent.putExtra(str2, j);
                                    intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                    C25985d.m41467b(C22089b.this.activity, "webview", ".ui.tools.WebViewUI", intent);
                                    break;
                                }
                                C4990ab.m7416i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + str2);
                                AppMethodBeat.m2505o(40241);
                                return;
                        }
                        AppMethodBeat.m2505o(40241);
                    }
                };
                int[] iArr = new int[2];
                if (view.getTag(2131820679) instanceof int[]) {
                    iArr = (int[]) view.getTag(2131820679);
                }
                c24088a.mo22431dn(iArr[0], iArr[1]);
                AppMethodBeat.m2505o(40242);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$21 */
    class C2211621 implements OnClickListener {
        C2211621() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40270);
            if (view.getTag() instanceof C39828ar) {
                C46236n YS = C13373af.cnF().mo62917YS(((C39828ar) view.getTag()).cFc);
                if (YS == null) {
                    AppMethodBeat.m2505o(40270);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("sns_text_show", YS.cqu().xfF);
                intent.putExtra("sns_local_id", YS.cqU());
                intent.setClass(C22089b.this.activity, SnsSingleTextViewUI.class);
                C22089b.this.activity.startActivity(intent);
            }
            AppMethodBeat.m2505o(40270);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$22 */
    class C2211722 implements OnClickListener {
        C2211722() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40271);
            if (view.getTag() instanceof C13707q) {
                int width;
                int height;
                C13707q c13707q = (C13707q) view.getTag();
                bau bau = (bau) c13707q.rin.xfI.wbK.get(0);
                C13373af.cnF().mo62917YS(c13707q.cwT);
                String str = "";
                String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
                String str2 = "";
                String j = C29036i.m46116j(bau);
                if (C5730e.m8628ct(fZ + j)) {
                    str = fZ + j;
                    str2 = fZ + C29036i.m46108e(bau);
                }
                if (C5730e.m8628ct(fZ + C29036i.m46126p(bau))) {
                    str = fZ + C29036i.m46126p(bau);
                    str2 = fZ + C29036i.m46123n(bau);
                }
                int[] iArr = new int[2];
                View findViewById = view.findViewById(2131827794);
                if (findViewById != null) {
                    findViewById.getLocationInWindow(iArr);
                    width = findViewById.getWidth();
                    height = findViewById.getHeight();
                } else {
                    view.getLocationInWindow(iArr);
                    width = view.getWidth();
                    height = view.getHeight();
                }
                Intent intent = new Intent();
                intent.setClass(C22089b.this.activity, SnsOnlineVideoActivity.class);
                intent.putExtra("intent_videopath", str);
                intent.putExtra("intent_thumbpath", str2);
                intent.putExtra("intent_localid", c13707q.cwT);
                intent.putExtra("intent_isad", false);
                intent.putExtra("intent_from_scene", C22089b.this.cvd);
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                C22089b.this.activity.startActivity(intent);
                C22089b.this.activity.overridePendingTransition(0, 0);
                C22089b.m33701a(C22089b.this, c13707q.rin);
            }
            AppMethodBeat.m2505o(40271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$24 */
    class C2211824 implements OnClickListener {
        C2211824() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:139:0x0726  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x0647  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x0647  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0726  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0726  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x0647  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            C43589aj c43589aj;
            int i;
            int i2;
            int i3;
            Throwable e;
            AppMethodBeat.m2504i(40279);
            C4990ab.m7416i("MicroMsg.TimelineClickListener", "onsight click");
            if (view.getTag() instanceof C43589aj) {
                c43589aj = (C43589aj) view.getTag();
            } else if (view.getTag() instanceof BaseViewHolder) {
                c43589aj = ((BaseViewHolder) view.getTag()).rGD;
            } else if (view.getTag() instanceof C35118a) {
                c43589aj = ((C35118a) view.getTag()).rGD;
            } else {
                c43589aj = null;
            }
            C46236n YT = C13373af.cnF().mo62918YT(c43589aj.cwT);
            if (YT == null) {
                AppMethodBeat.m2505o(40279);
                return;
            }
            if (C22089b.this.rhQ != null) {
                C22089b.this.rhQ.cnj().mo69122x(YT);
            }
            boolean DI = YT.mo74253DI(32);
            if (DI && YT.cqo() != null && (YT.cqo().coP() || YT.cqo().coQ())) {
                C22089b.this.rKn.onClick(view);
                AppMethodBeat.m2505o(40279);
                return;
            }
            TimeLineObject timeLineObject = c43589aj.rnr;
            if (timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.size() == 0) {
                C4990ab.m7412e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                AppMethodBeat.m2505o(40279);
                return;
            }
            bau bau = (bau) timeLineObject.xfI.wbK.get(0);
            if (DI) {
                C13373af.cnC();
                if (!C21925g.m33541t(bau)) {
                    c43589aj.raP.setVisibility(8);
                    c43589aj.rnu.setVisibility(0);
                    c43589aj.rnu.dKB();
                    C13373af.cnC().mo37473z(bau);
                    C43558b cnA = C13373af.cnA();
                    C44222az dtl = C44222az.dtl();
                    dtl.oyB = timeLineObject.pcX;
                    cnA.mo69138a(bau, 4, null, dtl);
                    if (DI) {
                        C34927j.m57341a(C34930b.Sight, C13354a.PlayIcon, YT, C22089b.this.cvd);
                    }
                    AppMethodBeat.m2505o(40279);
                    return;
                }
            }
            Object obj = (YT.mo74253DI(32) && YT.cqo().coK() && C3953i.m6288YO(YT.crd().field_adxml)) ? 1 : null;
            if (obj == null && DI && C13373af.cnC().mo37468u(bau)) {
                C13373af.cnC().mo37473z(bau);
                c43589aj.raP.setVisibility(8);
                c43589aj.rnu.setVisibility(8);
                C21925g cnC = C13373af.cnC();
                C34915a c34915a = c43589aj.qzM;
                int hashCode = C22089b.this.activity.hashCode();
                int i4 = c43589aj.position;
                C44222az dtl2 = C44222az.dtl();
                dtl2.oyB = timeLineObject.pcX;
                cnC.mo37448a(YT, bau, c34915a, hashCode, i4, dtl2, DI);
                if (DI) {
                    C34927j.m57341a(C34930b.Sight, C13354a.PlayIcon, YT, C22089b.this.cvd);
                }
                AppMethodBeat.m2505o(40279);
                return;
            }
            C37952b lY;
            if (C22089b.this.cvd == 0) {
                lY = C37952b.m64170lY(717);
            } else {
                lY = C37952b.m64171lZ(717);
            }
            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(bau.f17915Id);
            lY.ajK();
            if (C22089b.this.cvd == 0) {
                lY = C37952b.m64170lY(745);
            } else {
                lY = C37952b.m64171lZ(745);
            }
            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32));
            if (DI) {
                C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, YT.field_snsId, YT.cqo().coK() ? 21 : 17, YT.cqo().coK() ? 0 : 21));
                if (!(YT.cqo().coK() && C3953i.m6288YO(YT.crd().field_adxml))) {
                    C34927j.m57341a(C34930b.Sight, C13354a.EnterFullScreen, YT, C22089b.this.cvd);
                }
            }
            String str = "";
            String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
            String str2 = "";
            String j = C29036i.m46116j(bau);
            if (C5730e.m8628ct(fZ + j)) {
                str = fZ + j;
                str2 = fZ + C29036i.m46108e(bau);
            }
            if (C5730e.m8628ct(fZ + C29036i.m46126p(bau))) {
                str = fZ + C29036i.m46126p(bau);
                str2 = fZ + C29036i.m46123n(bau);
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            C7060h.pYm.mo8381e(11444, Integer.valueOf(3));
            Intent intent;
            TimeLineObject cqu;
            int i5;
            if (!DI) {
                C4990ab.m7416i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
                intent = new Intent();
                intent.setClass(C22089b.this.activity, SnsOnlineVideoActivity.class);
                intent.putExtra("intent_videopath", str);
                intent.putExtra("intent_thumbpath", str2);
                intent.putExtra("intent_localid", c43589aj.cwT);
                intent.putExtra("intent_isad", DI);
                intent.putExtra("intent_from_scene", C22089b.this.cvd);
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                lY.mo60717b(intent, "intent_key_StatisticsOplog");
                C22089b.this.activity.startActivity(intent);
                C22089b.this.activity.overridePendingTransition(0, 0);
                C22089b.m33701a(C22089b.this, YT.cqu());
                AppMethodBeat.m2505o(40279);
            } else if (YT.mo74253DI(32) && YT.cqo().coK() && C3953i.m6288YO(YT.crd().field_adxml)) {
                String y = C3953i.m6309y(YT);
                if (!C5046bo.isNullOrNil(y)) {
                    YT.crd().field_adxml = y;
                }
                intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("sns_landing_pages_share_sns_id", YT.cqA());
                intent.putExtra("sns_landing_pages_rawSnsId", YT.cqu().f15074Id);
                intent.putExtra("sns_landing_pages_ux_info", YT.crc());
                cqu = YT.cqu();
                if (cqu != null) {
                    LinkedList linkedList = cqu.xfI.wbK;
                    if (linkedList.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                    }
                }
                intent.setClass(C22089b.this.activity, SnsAdNativeLandingPagesUI.class);
                i5 = 1;
                if (C22089b.this.cvd == 2) {
                    i5 = 16;
                } else if (C22089b.this.cvd == 1) {
                    i5 = 2;
                }
                intent.putExtra("sns_landig_pages_from_source", i5);
                intent.putExtra("sns_landing_pages_xml", YT.crd().field_adxml);
                intent.putExtra("sns_landing_pages_rec_src", YT.cre());
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                C22089b.this.activity.startActivity(intent);
                C22089b.this.activity.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(40279);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(C22089b.this.activity, SnsSightPlayerUI.class);
                intent2.putExtra("intent_videopath", str);
                intent2.putExtra("intent_thumbpath", str2);
                intent2.putExtra("intent_localid", c43589aj.cwT);
                intent2.putExtra("intent_isad", DI);
                intent2.putExtra("intent_from_scene", C22089b.this.cvd);
                intent2.putExtra("img_gallery_left", iArr[0]);
                intent2.putExtra("img_gallery_top", iArr[1]);
                intent2.putExtra("img_gallery_width", width);
                intent2.putExtra("img_gallery_height", height);
                lY.mo60717b(intent2, "intent_key_StatisticsOplog");
                C22089b.this.activity.startActivity(intent2);
                C22089b.this.activity.overridePendingTransition(0, 0);
                final bau bau2 = bau;
                final C43589aj c43589aj2 = c43589aj;
                final C46236n c46236n = YT;
                final TimeLineObject timeLineObject2 = timeLineObject;
                final boolean z = DI;
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(40278);
                        if (C13373af.cnC().mo37468u(bau2)) {
                            c43589aj2.qzM.mo8509bf(null, false);
                            C21925g cnC = C13373af.cnC();
                            C46236n c46236n = c46236n;
                            bau bau = bau2;
                            C34915a c34915a = c43589aj2.qzM;
                            int hashCode = C22089b.this.activity.hashCode();
                            int i = c43589aj2.position;
                            C44222az dtl = C44222az.dtl();
                            dtl.oyB = timeLineObject2.pcX;
                            cnC.mo37448a(c46236n, bau, c34915a, hashCode, i, dtl, z);
                            c43589aj2.raP.setVisibility(0);
                            c43589aj2.rnu.setVisibility(8);
                            c43589aj2.raP.setImageDrawable(C1338a.m2864g(C22089b.this.activity, C1318a.shortvideo_play_btn));
                        }
                        AppMethodBeat.m2505o(40278);
                    }
                }, 500);
                int[] iArr2 = new int[3];
                if (!DI && C13373af.cnC().mo37433a(YT, iArr2) > 5) {
                    C13373af.cnC().mo37472y(bau);
                    i = 1;
                } else if (!DI || C13373af.cnC().mo37453b(YT, iArr2) <= 5) {
                    i = 2;
                } else {
                    C13373af.cnC().mo37472y(bau);
                    i = 1;
                }
                int i6 = iArr2[0];
                int i7 = iArr2[1];
                if (i == 2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                width = iArr2[2];
                cqu = YT.cqu();
                C32831d c32831d = new C32831d();
                c32831d.mo53400l("20FeedId", cqu.f15074Id + ",");
                c32831d.mo53400l("21AdUxInfo", YT.crc() + ",");
                try {
                    cbf cbf = (cbf) new cbf().parseFrom(YT.field_attrBuf);
                    if (cbf.xaD != null) {
                        cbn cbn = (cbn) new cbn().parseFrom(cbf.xaD.getBufferToBytes());
                        if (cbn.xaS != null) {
                            i3 = cbn.xaS.wcL;
                            try {
                                i5 = cbn.xaS.wcM;
                            } catch (Exception e2) {
                                e = e2;
                                C4990ab.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                i5 = 0;
                                c32831d.mo53400l("22LayerId", i3 + ",");
                                c32831d.mo53400l("23ExpId", i5 + ",");
                                c32831d.mo53400l("24ClickState", i + ",");
                                c32831d.mo53400l("25ClickTime", C5046bo.anT() + ",");
                                i5 = 0;
                                if (C5023at.isWifi(C4996ah.getContext())) {
                                }
                                c32831d.mo53400l("26NetworkType", i5 + ",");
                                c32831d.mo53400l("27IsFlowControl", i6 + ",");
                                c32831d.mo53400l("28AutoDownloadSetting", i7 + ",");
                                c32831d.mo53400l("29IsAutoPlay", i2 + ",");
                                c32831d.mo53400l("30IsFlowControlDatePeriod", width + ",");
                                C4990ab.m7416i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + c32831d.mo53398Fk());
                                C7060h.pYm.mo8381e(13323, c32831d);
                                AppMethodBeat.m2505o(40279);
                            }
                            c32831d.mo53400l("22LayerId", i3 + ",");
                            c32831d.mo53400l("23ExpId", i5 + ",");
                            c32831d.mo53400l("24ClickState", i + ",");
                            c32831d.mo53400l("25ClickTime", C5046bo.anT() + ",");
                            i5 = 0;
                            if (C5023at.isWifi(C4996ah.getContext())) {
                                i5 = 1;
                            } else if (C5023at.is2G(C4996ah.getContext())) {
                                i5 = 2;
                            } else if (C5023at.is3G(C4996ah.getContext())) {
                                i5 = 3;
                            } else if (C5023at.is4G(C4996ah.getContext())) {
                                i5 = 4;
                            }
                            c32831d.mo53400l("26NetworkType", i5 + ",");
                            c32831d.mo53400l("27IsFlowControl", i6 + ",");
                            c32831d.mo53400l("28AutoDownloadSetting", i7 + ",");
                            c32831d.mo53400l("29IsAutoPlay", i2 + ",");
                            c32831d.mo53400l("30IsFlowControlDatePeriod", width + ",");
                            C4990ab.m7416i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + c32831d.mo53398Fk());
                            C7060h.pYm.mo8381e(13323, c32831d);
                            AppMethodBeat.m2505o(40279);
                        }
                    }
                    i5 = 0;
                    i3 = 0;
                } catch (Exception e3) {
                    e = e3;
                    i3 = 0;
                    C4990ab.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                    i5 = 0;
                    c32831d.mo53400l("22LayerId", i3 + ",");
                    c32831d.mo53400l("23ExpId", i5 + ",");
                    c32831d.mo53400l("24ClickState", i + ",");
                    c32831d.mo53400l("25ClickTime", C5046bo.anT() + ",");
                    i5 = 0;
                    if (C5023at.isWifi(C4996ah.getContext())) {
                    }
                    c32831d.mo53400l("26NetworkType", i5 + ",");
                    c32831d.mo53400l("27IsFlowControl", i6 + ",");
                    c32831d.mo53400l("28AutoDownloadSetting", i7 + ",");
                    c32831d.mo53400l("29IsAutoPlay", i2 + ",");
                    c32831d.mo53400l("30IsFlowControlDatePeriod", width + ",");
                    C4990ab.m7416i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + c32831d.mo53398Fk());
                    C7060h.pYm.mo8381e(13323, c32831d);
                    AppMethodBeat.m2505o(40279);
                }
                c32831d.mo53400l("22LayerId", i3 + ",");
                c32831d.mo53400l("23ExpId", i5 + ",");
                c32831d.mo53400l("24ClickState", i + ",");
                c32831d.mo53400l("25ClickTime", C5046bo.anT() + ",");
                i5 = 0;
                if (C5023at.isWifi(C4996ah.getContext())) {
                }
                c32831d.mo53400l("26NetworkType", i5 + ",");
                c32831d.mo53400l("27IsFlowControl", i6 + ",");
                c32831d.mo53400l("28AutoDownloadSetting", i7 + ",");
                c32831d.mo53400l("29IsAutoPlay", i2 + ",");
                c32831d.mo53400l("30IsFlowControlDatePeriod", width + ",");
                C4990ab.m7416i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + c32831d.mo53398Fk());
                C7060h.pYm.mo8381e(13323, c32831d);
                AppMethodBeat.m2505o(40279);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$37 */
    class C2211937 implements OnClickListener {
        C2211937() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40299);
            if (view.getTag() instanceof BaseViewHolder) {
                C46236n YT = C13373af.cnF().mo62918YT(((BaseViewHolder) view.getTag()).cwT);
                if (YT == null) {
                    AppMethodBeat.m2505o(40299);
                    return;
                } else if (YT.mo74253DI(32)) {
                    C4990ab.m7416i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                    C29036i.m46098a(new SnsAdClick(C22089b.this.cvd, C22089b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 24, 0));
                    C22089b.this.mo17693dH(view);
                }
            }
            AppMethodBeat.m2505o(40299);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.d.b$4 */
    class C221204 extends C22121c {
        C221204() {
        }

        /* renamed from: dR */
        public final boolean mo37651dR(View view) {
            AppMethodBeat.m2504i(40245);
            if ((view.getTag() instanceof BaseViewHolder) || (view.getTag() instanceof C46236n) || (view.getTag() instanceof C43589aj) || (view.getTag() instanceof C29190ao) || (view.getTag() instanceof C35118a)) {
                C46236n YS;
                Object tag = view.getTag();
                if (tag instanceof BaseViewHolder) {
                    YS = C21990h.m33615YS(((BaseViewHolder) view.getTag()).cFc);
                } else if (tag instanceof C46236n) {
                    YS = (C46236n) tag;
                } else if (tag instanceof C43589aj) {
                    YS = C13373af.cnF().mo62918YT(((C43589aj) tag).cwT);
                } else if (view.getTag() instanceof C29190ao) {
                    YS = C13373af.cnF().mo62918YT(((C29190ao) view.getTag()).czD);
                } else if (view.getTag() instanceof C35118a) {
                    YS = ((C35118a) view.getTag()).ros;
                } else {
                    YS = null;
                }
                if (YS != null) {
                    if (!YS.mo74253DI(32)) {
                        AppMethodBeat.m2505o(40245);
                        return false;
                    } else if (YS.cqo() == null || !YS.cqo().coP()) {
                        AppMethodBeat.m2505o(40245);
                        return false;
                    } else {
                        C22089b.this.rJH.mo69202a(view, YS.cqU(), YS.cqu());
                    }
                }
                AppMethodBeat.m2505o(40245);
                return true;
            }
            AppMethodBeat.m2505o(40245);
            return false;
        }

        /* renamed from: a */
        public final void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(40246);
            Object tag = view.getTag();
            if ((tag instanceof BaseViewHolder) || (tag instanceof C46236n) || (tag instanceof C43589aj) || (tag instanceof C29190ao) || (tag instanceof C35118a)) {
                C46236n YS;
                if (tag instanceof BaseViewHolder) {
                    YS = C21990h.m33615YS(((BaseViewHolder) tag).cFc);
                } else if (tag instanceof C46236n) {
                    YS = (C46236n) tag;
                } else if (tag instanceof C43589aj) {
                    YS = C13373af.cnF().mo62918YT(((C43589aj) tag).cwT);
                } else if (view.getTag() instanceof C29190ao) {
                    YS = C13373af.cnF().mo62918YT(((C29190ao) view.getTag()).czD);
                } else if (view.getTag() instanceof C35118a) {
                    YS = ((C35118a) view.getTag()).ros;
                } else {
                    YS = null;
                }
                if (!YS.mo74253DI(32)) {
                    AppMethodBeat.m2505o(40246);
                    return;
                } else if (YS.cqo() == null || !YS.cqo().coP()) {
                    AppMethodBeat.m2505o(40246);
                    return;
                } else if (C22089b.m33699a(C22089b.this, YS).qTO != null) {
                    AppMethodBeat.m2505o(40246);
                    return;
                } else {
                    if (C25985d.afj("favorite")) {
                        if (YS.cqo().coP()) {
                            contextMenu.add(0, 20, 0, view.getContext().getString(C25738R.string.dcq));
                        }
                        C9321dq c9321dq = new C9321dq();
                        c9321dq.cxc.cwT = YS.cqU();
                        C4879a.xxA.mo10055m(c9321dq);
                        if (c9321dq.cxd.cwB) {
                            contextMenu.add(0, 18, 0, view.getContext().getString(C25738R.string.f9188s7));
                        }
                    }
                    if (YS != null) {
                        C21865a.m33410a(contextMenu, YS);
                    }
                }
            }
            AppMethodBeat.m2505o(40246);
        }
    }

    /* renamed from: b */
    public abstract void mo17688b(View view, int i, int i2, int i3);

    /* renamed from: cp */
    public abstract void mo17689cp(Object obj);

    public abstract void crE();

    public abstract void crF();

    /* renamed from: dG */
    public abstract void mo17692dG(View view);

    /* renamed from: dH */
    public abstract void mo17693dH(View view);

    /* renamed from: dI */
    public abstract void mo17694dI(View view);

    /* renamed from: dJ */
    public abstract void mo17695dJ(View view);

    /* renamed from: dK */
    public abstract void mo17696dK(View view);

    /* renamed from: dL */
    public abstract void mo17697dL(View view);

    public C22089b(int i, Activity activity, C29045ae c29045ae) {
        this.cvd = i;
        this.activity = activity;
        this.rhQ = c29045ae;
        this.rKp = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
        C4990ab.m7417i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", Integer.valueOf(this.rKp));
        this.mmO = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        this.rJH = new C43597a(this.activity, this.cvd, this.rhQ);
        this.rJS = new C407734();
        this.rKd = new C2209735();
        this.rKh = new C2210236();
        this.rKi = new C2211937();
        this.rJI = new C2210338();
        this.rJJ = new C221132();
        this.rJK = new C221043();
        this.rJZ = new C221204();
        this.rKa = new C221055();
        this.rJW = new C220906();
        this.rJV = new C220917();
        this.rJY = new C220928();
        this.rjy = new C220939();
        this.rJL = new C2210610();
        this.rJM = new C2210711();
        this.rJN = new C2208213();
        this.rJT = new C2208314();
        this.rJO = new C2209415();
        this.rJP = new C2208416();
        this.rJQ = new C2210917();
        this.rJR = new C2211018();
        this.rJU = new C2211119();
        this.jNA = new C1367020();
        this.rKc = new C2211621();
        this.rKf = new C2211722();
        this.rKe = new C2211824();
        this.rJX = new C2210125();
        this.rKg = new C2209526();
        this.rKj = new C1367127();
        this.rKk = new C2208728();
        this.rKn = new C2208829();
        this.rKb = new C2209630();
        this.rJj = new C407531();
    }

    public final void bIB() {
        this.rJH.bIB();
        C4879a.xxA.mo10052c(this.rKq);
        C4879a.xxA.mo10052c(this.rKr);
    }

    public final void removeListener() {
        this.rJH.removeListener();
        C4879a.xxA.mo10053d(this.rKq);
        C4879a.xxA.mo10053d(this.rKr);
    }

    /* renamed from: h */
    public final void mo37648h(BaseViewHolder baseViewHolder) {
        if (baseViewHolder instanceof C4081a) {
            this.rJD = new C29203d((MMActivity) this.activity, baseViewHolder);
            this.rJE = new C22072c((MMActivity) this.activity, baseViewHolder);
        } else if (baseViewHolder instanceof C13687a) {
            this.rJD = new C13649f((MMActivity) this.activity, baseViewHolder);
            this.rJE = new C4038e((MMActivity) this.activity, baseViewHolder);
        } else if (baseViewHolder instanceof C13697b) {
            this.rJD = new C35115h((MMActivity) this.activity, baseViewHolder);
            this.rJE = new C35113g((MMActivity) this.activity, baseViewHolder);
        }
    }

    /* renamed from: a */
    public final void mo37646a(C35118a c35118a) {
        if (c35118a instanceof C13655b) {
            this.rJF = new C35110d((MMActivity) this.activity, c35118a);
            this.rJG = new C35109c((MMActivity) this.activity, c35118a);
        } else if (c35118a instanceof C13658c) {
            this.rJF = new C13638f((MMActivity) this.activity, c35118a);
            this.rJG = new C4029e((MMActivity) this.activity, c35118a);
        } else if (c35118a instanceof C13665d) {
            this.rJF = new C4033h((MMActivity) this.activity, c35118a);
            this.rJG = new C13642g((MMActivity) this.activity, c35118a);
        }
    }

    /* renamed from: dQ */
    static /* synthetic */ C46236n m33704dQ(View view) {
        if (view.getTag() instanceof C29190ao) {
            return C21990h.m33616YT(((C29190ao) view.getTag()).czD);
        }
        if (view.getTag() instanceof MaskImageView) {
            MaskImageView maskImageView = (MaskImageView) view.getTag();
            if (maskImageView.getTag() instanceof C29190ao) {
                return C21990h.m33616YT(((C29190ao) maskImageView.getTag()).czD);
            }
        } else if (view.getTag() instanceof C43589aj) {
            return C13373af.cnF().mo62918YT(((C43589aj) view.getTag()).cwT);
        } else if (view.getTag() instanceof BaseViewHolder) {
            return C21990h.m33615YS(((BaseViewHolder) view.getTag()).cFc);
        } else {
            if (view.getTag() instanceof C35118a) {
                return ((C35118a) view.getTag()).ros;
            }
        }
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m33700a(C22089b c22089b, View view, C46236n c46236n, int i, String str, boolean z) {
        C43589aj c43589aj;
        C43589aj c43589aj2 = null;
        if (view.getTag() instanceof C43589aj) {
            c43589aj2 = (C43589aj) view.getTag();
        }
        if (view.getTag() instanceof BaseViewHolder) {
            c43589aj2 = ((BaseViewHolder) view.getTag()).rGD;
        }
        if (view.getTag() instanceof C35118a) {
            c43589aj = ((C35118a) view.getTag()).rGD;
        } else {
            c43589aj = c43589aj2;
        }
        if (c46236n != null && c43589aj != null) {
            if (c22089b.rhQ != null) {
                c22089b.rhQ.cnj().mo69122x(c46236n);
            }
            boolean DI = c46236n.mo74253DI(32);
            TimeLineObject cqu = c46236n.cqu();
            if (cqu.xfI.wbK == null || cqu.xfI.wbK.size() == 0) {
                C4990ab.m7412e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                return;
            }
            bau bau = (bau) cqu.xfI.wbK.get(0);
            if (DI) {
                C13373af.cnC();
                if (!C21925g.m33541t(bau)) {
                    c43589aj.raP.setVisibility(8);
                    c43589aj.rnu.setVisibility(0);
                    c43589aj.rnu.dKB();
                    C13373af.cnC().mo37473z(bau);
                    C43558b cnA = C13373af.cnA();
                    C44222az dtl = C44222az.dtl();
                    dtl.oyB = cqu.pcX;
                    cnA.mo69138a(bau, 4, null, dtl);
                    return;
                }
            }
            Object obj = (c46236n.mo74253DI(32) && c46236n.cqo().coK() && C3953i.m6288YO(str)) ? 1 : null;
            if (obj == null && DI && C13373af.cnC().mo37468u(bau)) {
                C13373af.cnC().mo37473z(bau);
                c43589aj.raP.setVisibility(8);
                c43589aj.rnu.setVisibility(8);
                C21925g cnC = C13373af.cnC();
                C34915a c34915a = c43589aj.qzM;
                int hashCode = c22089b.activity.hashCode();
                int i2 = c43589aj.position;
                C44222az dtl2 = C44222az.dtl();
                dtl2.oyB = cqu.pcX;
                cnC.mo37448a(c46236n, bau, c34915a, hashCode, i2, dtl2, DI);
                return;
            }
            int[] iArr = new int[2];
            c43589aj.rnt.getLocationInWindow(iArr);
            int width = c43589aj.rnt.getWidth();
            int height = c43589aj.rnt.getHeight();
            if (c46236n.mo74253DI(32) && c46236n.cqo().coK() && C3953i.m6288YO(str)) {
                int i3;
                if (view.getTag() instanceof BaseViewHolder) {
                    c22089b.mo37648h((BaseViewHolder) view.getTag());
                } else if (view.getTag() instanceof C35118a) {
                    c22089b.mo37646a((C35118a) view.getTag());
                }
                String y = C3953i.m6309y(c46236n);
                if (!C5046bo.isNullOrNil(y)) {
                    c46236n.crd().field_adxml = y;
                }
                int i4 = c22089b.cvd;
                int i5 = c22089b.cvd == 0 ? 1 : 2;
                long j = c46236n.field_snsId;
                if (z) {
                    i3 = 22;
                } else {
                    i3 = 21;
                }
                C29036i.m46098a(new SnsAdClick(i4, i5, j, i, i3));
                Intent intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("sns_landing_pages_share_sns_id", c46236n.cqA());
                intent.putExtra("sns_landing_pages_rawSnsId", c46236n.cqu().f15074Id);
                intent.putExtra("sns_landing_pages_ux_info", c46236n.crc());
                TimeLineObject cqu2 = c46236n.cqu();
                if (cqu2 != null) {
                    LinkedList linkedList = cqu2.xfI.wbK;
                    if (linkedList.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                    }
                }
                intent.setClass(c22089b.activity, SnsAdNativeLandingPagesUI.class);
                int i6 = 1;
                if (c22089b.cvd == 2) {
                    i6 = 16;
                } else if (c22089b.cvd == 1) {
                    i6 = 2;
                }
                intent.putExtra("sns_landig_pages_from_source", i6);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_rec_src", c46236n.cre());
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                c22089b.activity.startActivity(intent);
                c22089b.activity.overridePendingTransition(0, 0);
                return;
            }
            C4990ab.m7412e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m33703b(C22089b c22089b, View view, C46236n c46236n, int i, String str, boolean z) {
        TagImageView tagImageView;
        if (view.getTag() instanceof BaseViewHolder) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            if (baseViewHolder instanceof C4081a) {
                tagImageView = ((C4081a) baseViewHolder).rGX;
            } else {
                tagImageView = baseViewHolder.rHT.mo8755DT(0);
            }
        } else if (view.getTag() instanceof MaskImageView) {
            tagImageView = (MaskImageView) view.getTag();
        } else if (view.getTag() instanceof C13655b) {
            tagImageView = ((C13655b) view.getTag()).rGK;
        } else {
            tagImageView = (TagImageView) view;
        }
        if (c46236n.cqo().coK() && C3953i.m6288YO(str)) {
            int i2;
            if (view.getTag() instanceof BaseViewHolder) {
                c22089b.mo37648h((BaseViewHolder) view.getTag());
            } else if (view.getTag() instanceof C35118a) {
                c22089b.mo37646a((C35118a) view.getTag());
            }
            int i3 = c22089b.cvd;
            int i4 = c22089b.cvd == 0 ? 1 : 2;
            long j = c46236n.field_snsId;
            if (z) {
                i2 = 22;
            } else {
                i2 = 21;
            }
            C29036i.m46098a(new SnsAdClick(i3, i4, j, i, i2));
            String y = C3953i.m6309y(c46236n);
            if (!C5046bo.isNullOrNil(y)) {
                c46236n.crd().field_adxml = y;
            }
            int[] iArr = new int[2];
            tagImageView.getLocationInWindow(iArr);
            int width = tagImageView.getWidth();
            i3 = tagImageView.getHeight();
            Intent intent = new Intent();
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", i3);
            intent.putExtra("sns_landing_pages_share_sns_id", c46236n.cqA());
            intent.putExtra("sns_landing_pages_rawSnsId", c46236n.cqu().f15074Id);
            intent.putExtra("sns_landing_pages_ux_info", c46236n.crc());
            intent.putExtra("sns_landing_pages_aid", c46236n.cqZ());
            intent.putExtra("sns_landing_pages_traceid", c46236n.cra());
            TimeLineObject cqu = c46236n.cqu();
            if (cqu != null) {
                LinkedList linkedList = cqu.xfI.wbK;
                if (linkedList.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                }
            }
            intent.setClass(c22089b.activity, SnsAdNativeLandingPagesUI.class);
            int i5 = 1;
            if (c22089b.cvd == 2) {
                i5 = 16;
            } else if (c22089b.cvd == 1) {
                i5 = 2;
            }
            intent.putExtra("sns_landig_pages_from_source", i5);
            intent.putExtra("sns_landing_pages_xml", str);
            intent.putExtra("sns_landing_pages_rec_src", c46236n.cre());
            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            c22089b.activity.startActivity(intent);
            c22089b.activity.overridePendingTransition(0, 0);
            if (c22089b.rhQ != null) {
                c22089b.rhQ.cnj().mo69122x(c46236n);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m33702a(C22089b c22089b, C21980a c21980a, C46236n c46236n, boolean z) {
        if (c21980a != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (z && c46236n.cqo().qUX.cBb != null) {
                str = c46236n.cqo().qUX.cBb;
                str2 = c46236n.cqo().qUX.csu;
                str3 = c46236n.cqo().qUX.appVersion;
            } else if (!(z || c21980a.qTw != 4 || c21980a.qTO == null)) {
                str = c21980a.qTO.cBb;
                str2 = c21980a.qTO.csu;
                str3 = c21980a.qTO.appVersion;
            }
            if (!C5046bo.isNullOrNil(str)) {
                if (!C5046bo.isNullOrNil(str2)) {
                    r5 = new String[2];
                    r5[0] = String.format("gdt_vid=%s", new Object[]{c46236n.cra()});
                    r5[1] = String.format("weixinadinfo=%s.%s.0.0", new Object[]{c46236n.cqZ(), c46236n.cra()});
                    str2 = C3953i.m6307n(str2, r5);
                }
                C32628se c32628se = new C32628se();
                c32628se.cOf.cst = C29036i.m46117jV(c46236n.field_snsId) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c21980a.qPj + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C13373af.cnk() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + System.currentTimeMillis();
                c32628se.cOf.userName = str;
                c32628se.cOf.axy = C5046bo.ank(str3);
                c32628se.cOf.cOh = str2;
                c32628se.cOf.scene = c22089b.cvd == 0 ? 1045 : 1046;
                C4879a.xxA.mo10055m(c32628se);
                return true;
            }
        }
        return false;
    }
}
