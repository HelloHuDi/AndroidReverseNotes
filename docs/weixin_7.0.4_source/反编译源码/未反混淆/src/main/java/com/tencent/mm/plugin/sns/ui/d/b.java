package com.tencent.mm.plugin.sns.ui.d;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.g.a.td;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.b.b.a;
import com.tencent.mm.plugin.sns.ui.b.b.f;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public abstract class b {
    Activity activity;
    int cvd = 0;
    public OnTouchListener jNA;
    private ClipboardManager mmO;
    volatile com.tencent.mm.plugin.sns.ui.b.b.b rJD;
    volatile a rJE;
    volatile com.tencent.mm.plugin.sns.ui.b.a.b rJF;
    volatile com.tencent.mm.plugin.sns.ui.b.a.a rJG;
    public a rJH;
    public OnClickListener rJI;
    public OnLongClickListener rJJ;
    public c rJK;
    public OnClickListener rJL;
    public OnClickListener rJM;
    public OnClickListener rJN;
    public OnClickListener rJO;
    public OnClickListener rJP;
    public OnClickListener rJQ;
    public OnClickListener rJR;
    public OnClickListener rJS;
    public OnClickListener rJT;
    public c rJU;
    public c rJV;
    public c rJW;
    public c rJX;
    public c rJY;
    public c rJZ;
    public e rJj;
    public c rKa;
    c rKb;
    public OnClickListener rKc;
    public OnClickListener rKd;
    public OnClickListener rKe;
    public OnClickListener rKf;
    public OnClickListener rKg;
    public OnClickListener rKh;
    public OnClickListener rKi;
    public OnItemClickListener rKj;
    public OnItemClickListener rKk;
    public OnClickListener rKl = new OnClickListener() {
        public final void onClick(View view) {
            boolean z = false;
            AppMethodBeat.i(40239);
            if (view.getTag() == null) {
                AppMethodBeat.o(40239);
                return;
            }
            n dQ = b.dQ(view);
            if (dQ == null || !dQ.DI(32)) {
                AppMethodBeat.o(40239);
                return;
            }
            boolean z2;
            if (dQ.crd().cqo().coS()) {
                int i;
                int gr = v.gr(dQ.crd().cqo().coN(), dQ.crc());
                Object obj = gr > 0 ? 1 : null;
                String coN = dQ.crd().cqo().coN();
                String crc = dQ.crc();
                g.RN();
                String QG = com.tencent.mm.kernel.a.QG();
                if (obj != null) {
                    i = gr;
                } else {
                    i = 1;
                }
                v.h(coN, crc, QG, i, obj != null ? 0 : 1);
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
                    b.b(b.this, view, dQ, 1001, dQ.crd().cqo().coT(), z2);
                }
                AppMethodBeat.o(40239);
                return;
            }
            b.a(b.this, view, dQ, 1001, dQ.crd().cqo().coT(), z2);
            AppMethodBeat.o(40239);
        }
    };
    public OnClickListener rKm = new OnClickListener() {
        public final void onClick(View view) {
            boolean z = false;
            AppMethodBeat.i(40259);
            if (view.getTag() == null) {
                AppMethodBeat.o(40259);
                return;
            }
            n dQ = b.dQ(view);
            if (dQ == null || !dQ.DI(32)) {
                AppMethodBeat.o(40259);
                return;
            }
            boolean z2;
            if (dQ.crd().cqo().coS()) {
                int gr = v.gr(dQ.crd().cqo().coN(), dQ.crc());
                Object obj = gr > 0 ? 1 : null;
                String coN = dQ.crd().cqo().coN();
                String crc = dQ.crc();
                g.RN();
                v.h(coN, crc, com.tencent.mm.kernel.a.QG(), obj != null ? gr : 2, obj != null ? 0 : 1);
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
                    b.b(b.this, view, dQ, 1002, dQ.crd().cqo().coU(), z2);
                }
                AppMethodBeat.o(40259);
                return;
            }
            b.a(b.this, view, dQ, 1002, dQ.crd().cqo().coU(), z2);
            AppMethodBeat.o(40259);
        }
    };
    public OnClickListener rKn;
    public au.a rKo;
    int rKp;
    private c<td> rKq = new c<td>() {
        {
            AppMethodBeat.i(40276);
            this.xxI = td.class.getName().hashCode();
            AppMethodBeat.o(40276);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(40277);
            td tdVar = (td) bVar;
            ab.i("MicroMsg.TimelineClickListener", "receive timeline play click anim event");
            final long j;
            if (b.this.rJD != null) {
                j = tdVar.cPq.cvc;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40273);
                        b.this.rJD.kM(j);
                        b.this.rJD.a(new com.tencent.mm.plugin.sns.ui.b.b.b.a() {
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(40272);
                                ab.i("MicroMsg.TimelineClickListener", "timeline click animation end");
                                b.this.rJD = null;
                                AppMethodBeat.o(40272);
                            }
                        });
                        AppMethodBeat.o(40273);
                    }
                });
                AppMethodBeat.o(40277);
                return true;
            } else if (b.this.rJF != null) {
                j = tdVar.cPq.cvc;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40275);
                        b.this.rJF.kM(j);
                        b.this.rJF.a(new com.tencent.mm.plugin.sns.ui.b.b.b.a() {
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(40274);
                                ab.i("MicroMsg.TimelineClickListener", "detail click animation end");
                                b.this.rJF = null;
                                AppMethodBeat.o(40274);
                            }
                        });
                        AppMethodBeat.o(40275);
                    }
                });
                AppMethodBeat.o(40277);
                return true;
            } else {
                AppMethodBeat.o(40277);
                return false;
            }
        }
    };
    private c<tc> rKr = new c<tc>() {
        {
            AppMethodBeat.i(40294);
            this.xxI = tc.class.getName().hashCode();
            AppMethodBeat.o(40294);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(40295);
            tc tcVar = (tc) bVar;
            ab.i("MicroMsg.TimelineClickListener", "receive timeline back anim event");
            final long j;
            if (b.this.rJE != null) {
                j = tcVar.cPp.cvc;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40291);
                        if (b.this.activity instanceof SnsTimeLineUI) {
                            ((SnsTimeLineUI) b.this.activity).lm(true);
                        }
                        b.this.rJE.kM(j);
                        b.this.rJE.a(new com.tencent.mm.plugin.sns.ui.b.b.b.a() {
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(40290);
                                ab.i("MicroMsg.TimelineClickListener", "timeline back animation end");
                                b.this.rJE = null;
                                ((SnsTimeLineUI) b.this.activity).lm(false);
                                AppMethodBeat.o(40290);
                            }
                        });
                        AppMethodBeat.o(40291);
                    }
                });
                AppMethodBeat.o(40295);
                return true;
            } else if (b.this.rJG != null) {
                j = tcVar.cPp.cvc;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40293);
                        b.this.rJG.kM(j);
                        b.this.rJG.a(new com.tencent.mm.plugin.sns.ui.b.b.b.a() {
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(40292);
                                ab.i("MicroMsg.TimelineClickListener", "detail back animation end");
                                b.this.rJG = null;
                                AppMethodBeat.o(40292);
                            }
                        });
                        AppMethodBeat.o(40293);
                    }
                });
                AppMethodBeat.o(40295);
                return true;
            } else {
                AppMethodBeat.o(40295);
                return false;
            }
        }
    };
    public OnClickListener rKs = new OnClickListener() {
        public final void onClick(View view) {
            MMImageView mMImageView;
            TagImageView tagImageView;
            int i = 2;
            boolean z = false;
            AppMethodBeat.i(40289);
            Object tag = view.getTag();
            n nVar = null;
            if (tag instanceof BaseViewHolder) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                n YS = h.YS(baseViewHolder.cFc);
                mMImageView = null;
                tagImageView = baseViewHolder.rHF;
                nVar = YS;
            } else if (tag instanceof n) {
                mMImageView = (MMImageView) view.getTag(R.id.bt);
                tagImageView = null;
                nVar = (n) tag;
            } else {
                mMImageView = null;
                tagImageView = null;
            }
            if (nVar != null) {
                String y;
                com.tencent.mm.plugin.sns.storage.e crd = nVar.crd();
                int source = crd.getSource();
                if (nVar != null && nVar.DI(32)) {
                    com.tencent.mm.plugin.sns.storage.a a = b.a(b.this, nVar);
                    if (nVar.cqo().coK() && i.YO(nVar.crd().field_adxml)) {
                        y = i.y(nVar);
                        if (!bo.isNullOrNil(y)) {
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
                        intent.putExtra("sns_landing_pages_share_sns_id", nVar.cqA());
                        intent.putExtra("sns_landing_pages_rawSnsId", nVar.cqu().Id);
                        intent.putExtra("sns_landing_pages_ux_info", nVar.crc());
                        TimeLineObject cqu = nVar.cqu();
                        if (cqu != null) {
                            LinkedList linkedList = cqu.xfI.wbK;
                            if (linkedList.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                            }
                        }
                        intent.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        width = 9;
                        if (source == 2) {
                            width = 16;
                        } else if (source == 1) {
                            width = 10;
                        }
                        intent.putExtra("sns_landig_pages_from_source", width);
                        intent.putExtra("sns_landing_pages_xml", nVar.crd().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", nVar.cre());
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                        b.this.activity.startActivity(intent);
                        b.this.activity.overridePendingTransition(0, 0);
                        if (source == 0) {
                            i = 1;
                        }
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(source, i, nVar.field_snsId, 23, 21));
                        AppMethodBeat.o(40289);
                        return;
                    } else if (a != null && a.qTw == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_card_id", a.qTy);
                        intent2.putExtra("key_card_ext", a.qTz);
                        intent2.putExtra("key_from_scene", 21);
                        intent2.putExtra("key_stastic_scene", 15);
                        d.b(b.this.activity, "card", ".ui.CardDetailUI", intent2);
                        if (source == 0) {
                            i = 1;
                        }
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(source, i, nVar.field_snsId, 23, 11));
                        AppMethodBeat.o(40289);
                        return;
                    } else if (b.a(b.this, a, nVar, false)) {
                        if (source == 0) {
                            i = 1;
                        }
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(source, i, nVar.field_snsId, 23, 31));
                        AppMethodBeat.o(40289);
                        return;
                    }
                }
                if (source == 0) {
                    i = 1;
                }
                SnsAdClick snsAdClick = new SnsAdClick(source, i, nVar.field_snsId, 23, 0);
                com.tencent.mm.plugin.sns.data.i.a(snsAdClick);
                y = nVar.crb();
                if (bo.isNullOrNil(y)) {
                    y = nVar.getAdLink();
                }
                ab.i("MicroMsg.TimelineClickListener", "adlink url " + y + " " + nVar.cqo().qUg);
                Intent intent3 = new Intent();
                boolean z2 = nVar.cqo().qUg == 0;
                if (!ae.giI) {
                    z = z2;
                }
                if (nVar != null && nVar.DI(32)) {
                    com.tencent.mm.plugin.sns.storage.a a2 = b.a(b.this, nVar);
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
                intent3.putExtra("srcUsername", nVar.field_userName);
                intent3.putExtra("stastic_scene", 15);
                intent3.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(nVar.field_snsId));
                intent3.putExtra("pre_username", nVar.field_userName);
                intent3.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(nVar.field_snsId));
                intent3.putExtra("preUsername", nVar.field_userName);
                com.tencent.mm.plugin.sns.c.a.gkE.i(intent3, b.this.activity);
            }
            AppMethodBeat.o(40289);
        }
    };
    com.tencent.mm.plugin.sns.model.ae rhQ;
    public OnClickListener rjy;

    public abstract void b(View view, int i, int i2, int i3);

    public abstract void cp(Object obj);

    public abstract void crE();

    public abstract void crF();

    public abstract void dG(View view);

    public abstract void dH(View view);

    public abstract void dI(View view);

    public abstract void dJ(View view);

    public abstract void dK(View view);

    public abstract void dL(View view);

    public b(int i, Activity activity, com.tencent.mm.plugin.sns.model.ae aeVar) {
        this.cvd = i;
        this.activity = activity;
        this.rhQ = aeVar;
        this.rKp = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
        ab.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", Integer.valueOf(this.rKp));
        this.mmO = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        this.rJH = new a(this.activity, this.cvd, this.rhQ);
        this.rJS = new OnClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0215  */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x0444  */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x0252  */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x0447  */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x025f  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(View view) {
                int i = 2;
                boolean z = false;
                AppMethodBeat.i(40296);
                if (view.getTag() == null || !(view.getTag() instanceof Long)) {
                    AppMethodBeat.o(40296);
                    return;
                }
                String adLink;
                int i2;
                SnsAdClick snsAdClick;
                Intent intent;
                boolean z2;
                Bundle bundle;
                com.tencent.mm.plugin.sns.storage.e ku = af.cnI().ku(((Long) view.getTag()).longValue());
                n cqB = ku.cqB();
                j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.DetailTimeline, ku.cqB(), b.this.cvd);
                ku.getSource();
                String crb = cqB.crb();
                if (bo.isNullOrNil(crb)) {
                    adLink = cqB.getAdLink();
                } else {
                    adLink = crb;
                }
                if (cqB.DI(32)) {
                    com.tencent.mm.plugin.sns.storage.a a = b.a(b.this, cqB);
                    int i3 = -1;
                    com.tencent.mm.storage.a aoe = com.tencent.mm.model.c.c.abj().aoe("Sns_CanvasAd_DetailLink_JumpWay");
                    if (aoe.isValid()) {
                        i3 = bo.getInt(aoe.field_value, -1);
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
                        d.b(b.this.activity, "card", ".ui.CardDetailUI", intent3);
                        i2 = b.this.cvd;
                        if (b.this.cvd == 0) {
                            i = 1;
                        }
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 11));
                        AppMethodBeat.o(40296);
                        return;
                    } else if (a == null || i3 != 1) {
                        if (a == null || i3 != 0) {
                            if (a != null && i3 == -1 && a.qTw == 3) {
                                if (cqB.cqo().coK() && i.YO(cqB.crd().field_adxml)) {
                                    crb = i.y(cqB);
                                    if (!bo.isNullOrNil(crb)) {
                                        ku.field_adxml = crb;
                                    }
                                    intent2 = new Intent();
                                    intent2.putExtra("sns_landing_pages_share_sns_id", cqB.cqA());
                                    intent2.putExtra("sns_landing_pages_rawSnsId", cqB.cqu().Id);
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
                                    intent2.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                    i3 = 9;
                                    if (b.this.cvd == 2) {
                                        i3 = 16;
                                    } else if (b.this.cvd == 1) {
                                        i3 = 10;
                                    }
                                    intent2.putExtra("sns_landig_pages_from_source", i3);
                                    intent2.putExtra("sns_landing_pages_xml", cqB.crd().field_adxml);
                                    intent2.putExtra("sns_landing_pages_rec_src", cqB.cre());
                                    intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                    intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                    b.this.activity.startActivity(intent2);
                                    b.this.activity.overridePendingTransition(0, 0);
                                    i2 = b.this.cvd;
                                    if (b.this.cvd == 0) {
                                        i = 1;
                                    }
                                    com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 21));
                                    AppMethodBeat.o(40296);
                                    return;
                                }
                            } else if (b.a(b.this, a, cqB, false)) {
                                i2 = b.this.cvd;
                                if (b.this.cvd == 0) {
                                    i = 1;
                                }
                                com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 31));
                                AppMethodBeat.o(40296);
                                return;
                            }
                        } else if (cqB.cqo().coK() && i.YO(cqB.crd().field_adxml)) {
                            crb = i.y(cqB);
                            if (!bo.isNullOrNil(crb)) {
                                ku.field_adxml = crb;
                            }
                            Map z3 = br.z(cqB.crd().field_adxml, "adxml");
                            if (z3 != null) {
                                crb = bo.bc((String) z3.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                                if (!bo.isNullOrNil(crb)) {
                                    adLink = crb;
                                }
                                crb = adLink;
                            } else {
                                ab.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + cqB.crd().field_adxml);
                                crb = adLink;
                            }
                            i2 = b.this.cvd;
                            if (b.this.cvd == 0) {
                                i = 1;
                            }
                            snsAdClick = new SnsAdClick(i2, i, cqB.field_snsId, 3, 0);
                            com.tencent.mm.plugin.sns.data.i.a(snsAdClick);
                            ab.i("MicroMsg.TimelineClickListener", "adlink url " + crb + " " + cqB.cqo().qUg);
                            intent = new Intent();
                            z2 = cqB.cqo().qUg != 0;
                            if (!ae.giI) {
                                z = z2;
                            }
                            if (cqB.DI(32)) {
                                a = b.a(b.this, cqB);
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
                            intent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(cqB.field_snsId));
                            intent.putExtra("pre_username", cqB.field_userName);
                            intent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(cqB.field_snsId));
                            intent.putExtra("preUsername", cqB.field_userName);
                            com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                            AppMethodBeat.o(40296);
                        }
                    } else if (cqB.cqo().coK() && i.YO(cqB.crd().field_adxml)) {
                        crb = i.y(cqB);
                        if (!bo.isNullOrNil(crb)) {
                            ku.field_adxml = crb;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("sns_landing_pages_share_sns_id", cqB.cqA());
                        intent2.putExtra("sns_landing_pages_rawSnsId", cqB.cqu().Id);
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
                        intent2.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        i3 = 9;
                        if (b.this.cvd == 2) {
                            i3 = 16;
                        } else if (b.this.cvd == 1) {
                            i3 = 10;
                        }
                        intent2.putExtra("sns_landig_pages_from_source", i3);
                        intent2.putExtra("sns_landing_pages_xml", cqB.crd().field_adxml);
                        intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent2.putExtra("sns_landing_pages_rec_src", cqB.cre());
                        intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                        b.this.activity.startActivity(intent2);
                        b.this.activity.overridePendingTransition(0, 0);
                        i2 = b.this.cvd;
                        if (b.this.cvd == 0) {
                            i = 1;
                        }
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i2, i, cqB.field_snsId, 3, 21));
                        AppMethodBeat.o(40296);
                        return;
                    }
                }
                crb = adLink;
                i2 = b.this.cvd;
                if (b.this.cvd == 0) {
                }
                snsAdClick = new SnsAdClick(i2, i, cqB.field_snsId, 3, 0);
                com.tencent.mm.plugin.sns.data.i.a(snsAdClick);
                ab.i("MicroMsg.TimelineClickListener", "adlink url " + crb + " " + cqB.cqo().qUg);
                intent = new Intent();
                if (cqB.cqo().qUg != 0) {
                }
                if (ae.giI) {
                }
                if (cqB.DI(32)) {
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
                intent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(cqB.field_snsId));
                intent.putExtra("pre_username", cqB.field_userName);
                intent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(cqB.field_snsId));
                intent.putExtra("preUsername", cqB.field_userName);
                com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                AppMethodBeat.o(40296);
            }
        };
        this.rKd = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40297);
                if (view.getTag() instanceof String) {
                    n YT = af.cnF().YT((String) view.getTag());
                    com.tencent.mm.modelsns.b lY;
                    if (YT == null) {
                        AppMethodBeat.o(40297);
                        return;
                    } else if (YT.DI(32)) {
                        ab.i("MicroMsg.TimelineClickListener", "click the ad poi button");
                        com.tencent.mm.plugin.sns.storage.a a = b.a(b.this, YT);
                        if (a == null) {
                            ab.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                            AppMethodBeat.o(40297);
                            return;
                        }
                        SnsAdClick snsAdClick = new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 19, 0);
                        com.tencent.mm.plugin.sns.data.i.a(snsAdClick);
                        if (bo.isNullOrNil(a.qTE)) {
                            ab.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                            AppMethodBeat.o(40297);
                            return;
                        }
                        if (b.this.cvd == 0) {
                            lY = com.tencent.mm.modelsns.b.lY(724);
                        } else {
                            lY = com.tencent.mm.modelsns.b.lZ(724);
                        }
                        lY.tx(com.tencent.mm.plugin.sns.data.i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx("").tx("").tx("").tx("").tx(a.qTD).tx("").tx("");
                        lY.ajK();
                        ab.i("MicroMsg.TimelineClickListener", "open webview url : " + a.qTE);
                        Intent intent = new Intent();
                        if (YT != null && YT.DI(32)) {
                            com.tencent.mm.plugin.sns.storage.a a2 = b.a(b.this, YT);
                            if (a2 != null) {
                                intent.putExtra("KsnsViewId", a2.hnw);
                            }
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("KSnsAdTag", snsAdClick);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("useJs", true);
                        intent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(YT.field_snsId));
                        intent.putExtra("pre_username", YT.field_userName);
                        intent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(YT.field_snsId));
                        intent.putExtra("preUsername", YT.field_userName);
                        intent.putExtra("rawUrl", a.qTE);
                        com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                        AppMethodBeat.o(40297);
                        return;
                    } else {
                        ayt ayt = YT.cqu().xfG;
                        Intent intent2 = new Intent();
                        if (b.this.cvd == 0) {
                            lY = com.tencent.mm.modelsns.b.lY(724);
                        } else {
                            lY = com.tencent.mm.modelsns.b.lZ(724);
                        }
                        lY.tx(com.tencent.mm.plugin.sns.data.i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx(ayt.wCC).mb(ayt.rki).tx(ayt.vRq).tx(ayt.vRp).tx(ayt.eUu).tx(ayt.rkg).tx(ayt.guP);
                        lY.ajK();
                        if (bo.isNullOrNil(ayt.wCC)) {
                            intent2.putExtra("map_view_type", 7);
                            intent2.putExtra("kwebmap_slat", (double) ayt.vRq);
                            intent2.putExtra("kwebmap_lng", (double) ayt.vRp);
                            intent2.putExtra("kPoiName", ayt.eUu);
                            intent2.putExtra("Kwebmap_locaion", ayt.rkg);
                            d.b(b.this.activity, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent2);
                            AppMethodBeat.o(40297);
                            return;
                        }
                        String format;
                        if (b.this.rKp == 0) {
                            format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[]{ayt.wCC});
                        } else {
                            format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[]{ayt.wCC, r1.Id});
                        }
                        intent2.putExtra("rawUrl", format);
                        com.tencent.mm.plugin.sns.c.a.gkE.i(intent2, b.this.activity);
                        AppMethodBeat.o(40297);
                        return;
                    }
                }
                AppMethodBeat.o(40297);
            }
        };
        this.rKh = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40298);
                if (view.getTag() instanceof String) {
                    n YT = af.cnF().YT((String) view.getTag());
                    if (YT == null) {
                        AppMethodBeat.o(40298);
                        return;
                    } else if (YT.DI(32)) {
                        ab.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        com.tencent.mm.plugin.sns.storage.a a = b.a(b.this, YT);
                        if (a == null) {
                            ab.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                            AppMethodBeat.o(40298);
                            return;
                        } else if (bo.isNullOrNil(a.qTH)) {
                            ab.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                            AppMethodBeat.o(40298);
                            return;
                        } else {
                            ab.i("MicroMsg.TimelineClickListener", "open webview url : " + a.qTH);
                            Intent intent = new Intent();
                            intent.putExtra("jsapiargs", new Bundle());
                            intent.putExtra("useJs", true);
                            intent.putExtra("rawUrl", a.qTH);
                            com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                            AppMethodBeat.o(40298);
                            return;
                        }
                    } else {
                        AppMethodBeat.o(40298);
                        return;
                    }
                }
                AppMethodBeat.o(40298);
            }
        };
        this.rKi = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40299);
                if (view.getTag() instanceof BaseViewHolder) {
                    n YT = af.cnF().YT(((BaseViewHolder) view.getTag()).cwT);
                    if (YT == null) {
                        AppMethodBeat.o(40299);
                        return;
                    } else if (YT.DI(32)) {
                        ab.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 24, 0));
                        b.this.dH(view);
                    }
                }
                AppMethodBeat.o(40299);
            }
        };
        this.rJI = new OnClickListener() {
            public final void onClick(View view) {
                n nVar;
                int i;
                boolean z = false;
                int i2 = 1;
                AppMethodBeat.i(40300);
                String str = (String) view.getTag();
                ab.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(str)));
                Intent intent = new Intent();
                boolean i3;
                if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).eSe == null) {
                    nVar = null;
                    i3 = false;
                } else {
                    n YT = af.cnF().YT((String) ((MaskImageButton) view).eSe);
                    if (YT.DI(32)) {
                        com.tencent.mm.plugin.sns.storage.b cqo = YT.cqo();
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 1, 0));
                        if (cqo == null || cqo.qUq != 1 || bo.isNullOrNil(cqo.qUr)) {
                            nVar = YT;
                            i3 = 1;
                        } else {
                            str = cqo.qUr;
                            ab.i("MicroMsg.TimelineClickListener", "headClickParam url " + str + " " + cqo.qUs);
                            Intent intent2 = new Intent();
                            if (cqo.qUs == 0) {
                                z = true;
                            }
                            intent2.putExtra("KsnsViewId", b.a(b.this, YT).hnw);
                            intent2.putExtra("KRightBtn", z);
                            intent2.putExtra("jsapiargs", new Bundle());
                            intent2.putExtra("rawUrl", str);
                            intent2.putExtra("useJs", true);
                            com.tencent.mm.plugin.sns.c.a.gkE.i(intent2, b.this.activity);
                            AppMethodBeat.o(40300);
                            return;
                        }
                    }
                    nVar = YT;
                    i3 = false;
                }
                if (str.endsWith("@ad")) {
                    AppMethodBeat.o(40300);
                    return;
                }
                if (nVar != null) {
                    com.tencent.mm.modelsns.b lY;
                    if (b.this.cvd == 0) {
                        lY = com.tencent.mm.modelsns.b.lY(nVar.DI(32) ? 722 : 721);
                    } else {
                        lY = com.tencent.mm.modelsns.b.lZ(nVar.DI(32) ? 722 : 721);
                    }
                    lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar)).mb(nVar.field_type).cS(nVar.DI(32)).tx(nVar.crc()).tx(str);
                    lY.ajK();
                }
                if (i3 != 0) {
                    SnsAdClick snsAdClick = new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, nVar.field_snsId, 1, 0);
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("KSnsAdTag", snsAdClick);
                    str = "CONTACT_INFO_UI_SOURCE";
                    if (b.this.cvd == 0) {
                        i2 = 6;
                    }
                    intent.putExtra(str, i2);
                    com.tencent.mm.plugin.sns.c.a.gkE.c(intent, b.this.activity);
                    AppMethodBeat.o(40300);
                    return;
                }
                com.tencent.mm.modelsns.b lY2;
                b.this.rhQ.cnj().a(nVar, true);
                if (b.this.cvd == 0) {
                    lY2 = com.tencent.mm.modelsns.b.lY(746);
                } else {
                    lY2 = com.tencent.mm.modelsns.b.lZ(746);
                }
                lY2.tx(str).cS(str.endsWith(r.Yz()));
                lY2.b(intent, "intent_key_StatisticsOplog");
                String str2 = "CONTACT_INFO_UI_SOURCE";
                if (b.this.cvd == 0) {
                    i2 = 6;
                }
                intent.putExtra(str2, i2);
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.c.a.gkE.c(intent, b.this.activity);
                AppMethodBeat.o(40300);
            }
        };
        this.rJJ = new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(40242);
                final String str = (String) view.getTag();
                ab.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(40242);
                    return true;
                } else if (str.equals(af.cnk())) {
                    AppMethodBeat.o(40242);
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
                    final n YT = af.cnF().YT(str2);
                    if (YT == null || !YT.DI(32)) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        AppMethodBeat.o(40242);
                        return false;
                    }
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(b.this.activity, view);
                    aVar.zRZ = new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(40240);
                            contextMenu.add(0, 0, 0, b.this.activity.getString(R.string.aya));
                            contextMenu.add(1, 1, 0, b.this.activity.getString(R.string.epl));
                            AppMethodBeat.o(40240);
                        }
                    };
                    aVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            long j = 0;
                            AppMethodBeat.i(40241);
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
                                    intent.setClass(b.this.activity, SnsPermissionUI.class);
                                    b.this.activity.startActivityForResult(intent, 11);
                                    AppMethodBeat.o(40241);
                                    return;
                                case 1:
                                    intent = new Intent();
                                    n YT = af.cnF().YT(str2);
                                    if (YT != null) {
                                        ab.i("MicroMsg.TimelineClickListener", "expose id " + YT.cqA() + " " + YT.field_userName);
                                        String str2 = "k_expose_msg_id";
                                        if (YT != null) {
                                            j = YT.field_snsId;
                                        }
                                        intent.putExtra(str2, j);
                                        intent.putExtra("k_username", YT == null ? "" : YT.field_userName);
                                        intent.putExtra("showShare", false);
                                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                        d.b(b.this.activity, "webview", ".ui.tools.WebViewUI", intent);
                                        break;
                                    }
                                    ab.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + str2);
                                    AppMethodBeat.o(40241);
                                    return;
                            }
                            AppMethodBeat.o(40241);
                        }
                    };
                    int[] iArr = new int[2];
                    if (view.getTag(R.id.cy) instanceof int[]) {
                        iArr = (int[]) view.getTag(R.id.cy);
                    }
                    aVar.dn(iArr[0], iArr[1]);
                    AppMethodBeat.o(40242);
                    return false;
                }
            }
        };
        this.rJK = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40243);
                ar arVar = (ar) view.getTag();
                n YS = af.cnF().YS(arVar.cFc);
                if (YS == null) {
                    AppMethodBeat.o(40243);
                    return;
                }
                contextMenu.add(0, 0, 0, b.this.activity.getString(R.string.oy));
                if (d.afj("favorite")) {
                    contextMenu.add(0, 1, 0, b.this.activity.getString(R.string.dcq));
                }
                TimeLineObject cqu = YS.cqu();
                if (arVar.rvm || !(cqu == null || cqu.xfK == 1 || arVar.rvn)) {
                    if (arVar.ctI()) {
                        ap.b(contextMenu, true);
                    } else {
                        ap.a(contextMenu, true);
                    }
                }
                com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, YS);
                AppMethodBeat.o(40243);
            }

            public final boolean dR(View view) {
                AppMethodBeat.i(40244);
                if (view.getTag() instanceof ar) {
                    n YS = af.cnF().YS(((ar) view.getTag()).cFc);
                    if (YS == null) {
                        AppMethodBeat.o(40244);
                        return false;
                    }
                    b.this.rJH.a(view, YS.cqU(), YS.cqu());
                    AppMethodBeat.o(40244);
                    return true;
                }
                AppMethodBeat.o(40244);
                return false;
            }
        };
        this.rJZ = new c() {
            public final boolean dR(View view) {
                AppMethodBeat.i(40245);
                if ((view.getTag() instanceof BaseViewHolder) || (view.getTag() instanceof n) || (view.getTag() instanceof aj) || (view.getTag() instanceof ao) || (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                    n YS;
                    Object tag = view.getTag();
                    if (tag instanceof BaseViewHolder) {
                        YS = h.YS(((BaseViewHolder) view.getTag()).cFc);
                    } else if (tag instanceof n) {
                        YS = (n) tag;
                    } else if (tag instanceof aj) {
                        YS = af.cnF().YT(((aj) tag).cwT);
                    } else if (view.getTag() instanceof ao) {
                        YS = af.cnF().YT(((ao) view.getTag()).czD);
                    } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                        YS = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).ros;
                    } else {
                        YS = null;
                    }
                    if (YS != null) {
                        if (!YS.DI(32)) {
                            AppMethodBeat.o(40245);
                            return false;
                        } else if (YS.cqo() == null || !YS.cqo().coP()) {
                            AppMethodBeat.o(40245);
                            return false;
                        } else {
                            b.this.rJH.a(view, YS.cqU(), YS.cqu());
                        }
                    }
                    AppMethodBeat.o(40245);
                    return true;
                }
                AppMethodBeat.o(40245);
                return false;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40246);
                Object tag = view.getTag();
                if ((tag instanceof BaseViewHolder) || (tag instanceof n) || (tag instanceof aj) || (tag instanceof ao) || (tag instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                    n YS;
                    if (tag instanceof BaseViewHolder) {
                        YS = h.YS(((BaseViewHolder) tag).cFc);
                    } else if (tag instanceof n) {
                        YS = (n) tag;
                    } else if (tag instanceof aj) {
                        YS = af.cnF().YT(((aj) tag).cwT);
                    } else if (view.getTag() instanceof ao) {
                        YS = af.cnF().YT(((ao) view.getTag()).czD);
                    } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                        YS = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).ros;
                    } else {
                        YS = null;
                    }
                    if (!YS.DI(32)) {
                        AppMethodBeat.o(40246);
                        return;
                    } else if (YS.cqo() == null || !YS.cqo().coP()) {
                        AppMethodBeat.o(40246);
                        return;
                    } else if (b.a(b.this, YS).qTO != null) {
                        AppMethodBeat.o(40246);
                        return;
                    } else {
                        if (d.afj("favorite")) {
                            if (YS.cqo().coP()) {
                                contextMenu.add(0, 20, 0, view.getContext().getString(R.string.dcq));
                            }
                            dq dqVar = new dq();
                            dqVar.cxc.cwT = YS.cqU();
                            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                            if (dqVar.cxd.cwB) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(R.string.s7));
                            }
                        }
                        if (YS != null) {
                            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, YS);
                        }
                    }
                }
                AppMethodBeat.o(40246);
            }
        };
        this.rKa = new c() {
            public final boolean dR(View view) {
                AppMethodBeat.i(40247);
                if ((view.getTag() instanceof BaseViewHolder) || (view.getTag() instanceof n)) {
                    n YS;
                    Object tag = view.getTag();
                    if (tag instanceof BaseViewHolder) {
                        YS = h.YS(((BaseViewHolder) view.getTag()).cFc);
                    } else if (tag instanceof n) {
                        YS = (n) tag;
                    } else {
                        YS = null;
                    }
                    if (YS != null) {
                        b.this.rJH.a(view, YS.cqU(), YS.cqu());
                    }
                    AppMethodBeat.o(40247);
                    return true;
                }
                AppMethodBeat.o(40247);
                return false;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40248);
                Object tag = view.getTag();
                if ((tag instanceof BaseViewHolder) || (tag instanceof n)) {
                    n YS;
                    if (tag instanceof BaseViewHolder) {
                        YS = h.YS(((BaseViewHolder) tag).cFc);
                    } else if (tag instanceof n) {
                        YS = (n) tag;
                    } else {
                        YS = null;
                    }
                    if (d.afj("favorite")) {
                        com.tencent.mm.plugin.sns.storage.b cqo = YS.cqo();
                        com.tencent.mm.plugin.sns.storage.a a = b.a(b.this, YS);
                        if (cqo.coO()) {
                            if (cqo.coK()) {
                                contextMenu.add(0, 2, 0, view.getContext().getString(R.string.dcq));
                            } else if (a.qTw == 0) {
                                contextMenu.add(0, 3, 0, view.getContext().getString(R.string.dcq));
                            }
                        }
                        dq dqVar = new dq();
                        dqVar.cxc.cwT = YS.cqU();
                        com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                        if (dqVar.cxd.cwB) {
                            contextMenu.add(0, 18, 0, view.getContext().getString(R.string.s7));
                        }
                    }
                    if (YS != null) {
                        com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, YS);
                    }
                }
                AppMethodBeat.o(40248);
            }
        };
        this.rJW = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40249);
                if (view.getTag() instanceof q) {
                    b.this.rKb.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
                AppMethodBeat.o(40249);
            }

            public final boolean dR(View view) {
                AppMethodBeat.i(40250);
                if (view.getTag() instanceof q) {
                    String str = ((q) view.getTag()).cwT;
                    b.this.rJH.a(view, str, af.cnF().YT(str).cqu());
                    AppMethodBeat.o(40250);
                    return true;
                }
                AppMethodBeat.o(40250);
                return false;
            }
        };
        this.rJV = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40251);
                if (view != null && (view.getTag() instanceof ao)) {
                    int width;
                    int height;
                    String str = ((ao) view.getTag()).czD;
                    n YT = af.cnF().YT(str);
                    if (d.afj("favorite")) {
                        contextMenu.add(0, 2, 0, b.this.activity.getString(R.string.dcq));
                        dq dqVar = new dq();
                        dqVar.cxc.cwT = str;
                        com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                        if (dqVar.cxd.cwB) {
                            contextMenu.add(0, 18, 0, b.this.activity.getString(R.string.s7));
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, YT);
                    MenuItem add = contextMenu.add(0, 21, 0, b.this.activity.getString(R.string.ekc));
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
                AppMethodBeat.o(40251);
            }

            public final boolean dR(View view) {
                AppMethodBeat.i(40252);
                if (view.getTag() instanceof ao) {
                    String str = ((ao) view.getTag()).czD;
                    b.this.rJH.a(view, str, af.cnF().YT(str).cqu());
                    AppMethodBeat.o(40252);
                    return true;
                }
                AppMethodBeat.o(40252);
                return false;
            }
        };
        this.rJY = new c() {
            public final boolean dR(View view) {
                String str;
                AppMethodBeat.i(40253);
                Object tag = view.getTag();
                if (tag instanceof ao) {
                    str = ((ao) tag).czD;
                } else if (tag instanceof q) {
                    str = ((q) tag).cwT;
                } else {
                    str = null;
                }
                if (str != null) {
                    b.this.rJH.a(view, str, af.cnF().YT(str).cqu());
                    AppMethodBeat.o(40253);
                    return true;
                }
                AppMethodBeat.o(40253);
                return false;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                String str;
                AppMethodBeat.i(40254);
                Object tag = view.getTag();
                if (tag instanceof ao) {
                    str = ((ao) tag).czD;
                } else if (tag instanceof q) {
                    str = ((q) tag).cwT;
                } else {
                    str = null;
                }
                if (str != null) {
                    n YT = af.cnF().YT(str);
                    TimeLineObject cqu = YT.cqu();
                    if (d.afj("favorite")) {
                        switch (cqu.xfI.wbJ) {
                            case 1:
                                contextMenu.add(0, 2, 0, view.getContext().getString(R.string.dcq));
                                break;
                            case 15:
                                contextMenu.add(0, 10, 0, view.getContext().getString(R.string.dcq));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, YT);
                }
                AppMethodBeat.o(40254);
            }
        };
        this.rjy = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40255);
                String str = null;
                if (view.getTag() instanceof ao) {
                    str = ((ao) view.getTag()).czD;
                } else if (view.getTag() instanceof BaseViewHolder) {
                    str = ((BaseViewHolder) view.getTag()).cwT;
                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                    str = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).ros.cqU();
                }
                n YT = h.YT(str);
                if (YT == null) {
                    ab.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(str)));
                    AppMethodBeat.o(40255);
                } else if (YT.DI(32) && YT.cqo() != null && (YT.cqo().coP() || YT.cqo().coQ())) {
                    b.this.rKn.onClick(view);
                    AppMethodBeat.o(40255);
                } else {
                    if (YT.cqu().xfI.wbJ == 21) {
                        if (r.Yz().equals(YT.field_userName)) {
                            YT.cqu();
                            m.m(YT);
                            m.l(YT);
                            System.currentTimeMillis();
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(25);
                        }
                        if (!r.Yz().equals(YT.field_userName)) {
                            com.tencent.mm.plugin.sns.lucky.b.a.a(2, YT);
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(30);
                        }
                    }
                    if (YT.DI(32)) {
                        b.a(b.this, YT);
                        if (YT.cqo().coK() && i.YO(YT.crd().field_adxml)) {
                            int i;
                            str = i.y(YT);
                            if (!bo.isNullOrNil(str)) {
                                YT.crd().field_adxml = str;
                            }
                            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 21, 21));
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
                            intent.putExtra("sns_landing_pages_rawSnsId", YT.cqu().Id);
                            intent.putExtra("sns_landing_pages_ux_info", YT.crc());
                            intent.putExtra("sns_landing_pages_aid", YT.cqZ());
                            intent.putExtra("sns_landing_pages_traceid", YT.cra());
                            TimeLineObject cqu = YT.cqu();
                            if (cqu != null) {
                                LinkedList linkedList = cqu.xfI.wbK;
                                if (linkedList.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                                    intent.putExtra("sns_landing_pages_from_outer_index", ((ao) view.getTag()).index);
                                }
                            }
                            intent.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                            if (b.this.cvd == 2) {
                                i = 16;
                            } else if (b.this.cvd == 1) {
                                i = 2;
                            } else {
                                i = 1;
                            }
                            intent.putExtra("sns_landig_pages_from_source", i);
                            intent.putExtra("sns_landing_pages_xml", YT.crd().field_adxml);
                            intent.putExtra("sns_landing_pages_rec_src", YT.cre());
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            b.this.activity.startActivity(intent);
                            b.this.activity.overridePendingTransition(0, 0);
                            if (b.this.rhQ != null) {
                                b.this.rhQ.cnj().x(YT);
                            }
                        } else {
                            b.this.cp(view);
                        }
                    } else {
                        b.this.cp(view);
                    }
                    ao aoVar = (ao) view.getTag();
                    if (aoVar.rps && YT != null) {
                        com.tencent.mm.plugin.sns.ui.a.a.b(YT, aoVar.index);
                        com.tencent.mm.plugin.sns.ui.a.a.c(YT, aoVar.index);
                        av.Yk(YT.cqU());
                    }
                    if (YT != null) {
                        TimeLineObject cqu2 = YT.cqu();
                        if (cqu2 != null) {
                            String str2 = cqu2.xfH == null ? null : cqu2.xfH.Id;
                            if (!bo.isNullOrNil(str2)) {
                                com.tencent.mm.plugin.sns.c.a.gkF.a(null, str2, com.tencent.mm.plugin.sns.c.a.gkF.df(str2), cqu2.jBB, 2, 4, 4, cqu2.xfM, cqu2.Id);
                            }
                        }
                    }
                    AppMethodBeat.o(40255);
                }
            }
        };
        this.rJL = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40256);
                view.getTag();
                b.this.cp(view);
                AppMethodBeat.o(40256);
            }
        };
        this.rJM = new OnClickListener() {
            public final void onClick(final View view) {
                AppMethodBeat.i(40258);
                com.tencent.mm.ui.base.h.a(b.this.activity, (int) R.string.epn, (int) R.string.tz, (int) R.string.p4, (int) R.string.or, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(40257);
                        if (view.getTag() instanceof String) {
                            String str = (String) view.getTag();
                            ab.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(str)));
                            n YT = af.cnF().YT(str);
                            com.tencent.mm.modelsns.b lY;
                            com.tencent.mm.modelsns.b mb;
                            String str2;
                            if (YT == null) {
                                ab.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", str);
                                AppMethodBeat.o(40257);
                                return;
                            } else if (YT.cqW()) {
                                ab.i("MicroMsg.TimelineClickListener", "dead item");
                                af.cnF().DL(YT.reX);
                                if (b.this.rKo != null) {
                                    b.this.rKo.cud();
                                }
                                if (b.this.cvd == 0) {
                                    lY = com.tencent.mm.modelsns.b.lY(739);
                                } else {
                                    lY = com.tencent.mm.modelsns.b.lZ(739);
                                }
                                mb = lY.tx(com.tencent.mm.plugin.sns.data.i.j(YT)).mb(YT.field_type);
                                str2 = YT.cqW() ? "2" : YT.field_snsId == 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                mb.tx(str2);
                                lY.ajK();
                                if (YT.field_type == 21) {
                                    com.tencent.mm.plugin.sns.lucky.a.g.cmv().cmx();
                                }
                                AppMethodBeat.o(40257);
                                return;
                            } else if (YT.cnn()) {
                                ab.i("MicroMsg.TimelineClickListener", "cancel item " + YT.cqU());
                                af.cnB().u(YT);
                                b.this.crE();
                                AppMethodBeat.o(40257);
                                return;
                            } else {
                                ab.i("MicroMsg.TimelineClickListener", "delete by server");
                                str = YT.cqA();
                                af.cnE().km(v.Zm(str));
                                g.RQ();
                                g.RO().eJo.a(new com.tencent.mm.plugin.sns.model.r(v.Zm(str), 1), 0);
                                af.cnF().delete(v.Zm(str));
                                af.cnK().ky(v.Zm(str));
                                com.tencent.mm.plugin.sns.storage.i.kx(v.Zm(str));
                                b.this.crE();
                                TimeLineObject cqu = YT.cqu();
                                if (cqu != null) {
                                    if (cqu.xfH == null) {
                                        str = null;
                                    } else {
                                        str = cqu.xfH.Id;
                                    }
                                    if (!bo.isNullOrNil(str) && com.tencent.mm.plugin.sns.c.a.gkF.dk(str)) {
                                        String df = com.tencent.mm.plugin.sns.c.a.gkF.df(str);
                                        oi oiVar = new oi();
                                        oiVar.cKD.appId = str;
                                        oiVar.cKD.cKE = cqu.jBB;
                                        oiVar.cKD.ceO = df;
                                        oiVar.cKD.mediaTagName = cqu.xfM;
                                        com.tencent.mm.sdk.b.a.xxA.m(oiVar);
                                    }
                                }
                                if (b.this.cvd == 0) {
                                    lY = com.tencent.mm.modelsns.b.lY(739);
                                } else {
                                    lY = com.tencent.mm.modelsns.b.lZ(739);
                                }
                                mb = lY.tx(com.tencent.mm.plugin.sns.data.i.j(YT)).mb(YT.field_type);
                                str2 = YT.cqW() ? "2" : YT.field_snsId == 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                mb.tx(str2);
                                lY.ajK();
                                AppMethodBeat.o(40257);
                                return;
                            }
                        }
                        AppMethodBeat.o(40257);
                    }
                }, null);
                AppMethodBeat.o(40258);
            }
        };
        this.rJN = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40260);
                String str = (String) view.getTag();
                ab.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(str)));
                TimeLineObject cqu = af.cnF().YT(str).cqu();
                com.tencent.mm.protocal.protobuf.av avVar = cqu.qNO;
                if (avVar.vCy == null) {
                    AppMethodBeat.o(40260);
                    return;
                }
                String df = com.tencent.mm.plugin.sns.c.a.gkF.df(avVar.vCy.fKh);
                int i = 0;
                if (cqu.xfI.wbJ == 1) {
                    i = 2;
                } else if (cqu.xfI.wbJ == 3) {
                    i = 5;
                } else if (cqu.xfI.wbJ == 15) {
                    i = 38;
                }
                if (i.a(cqu, b.this.activity)) {
                    com.tencent.mm.plugin.sns.c.a.gkF.a(b.this.activity, avVar.vCy.fKh, df, cqu.jBB, i, 11, 9, avVar.vCy.vCs, cqu.Id);
                    AppMethodBeat.o(40260);
                    return;
                }
                gt gtVar;
                switch (avVar.jCt) {
                    case 4:
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", avVar.Url);
                        com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                        com.tencent.mm.plugin.sns.c.a.gkF.a(b.this.activity, avVar.vCy.fKh, df, cqu.jBB, i, 11, 1, avVar.vCy.vCs, cqu.Id);
                        AppMethodBeat.o(40260);
                        return;
                    case 5:
                        if (avVar.Scene == 1) {
                            gtVar = new gt();
                            gtVar.cBv.actionCode = 2;
                            gtVar.cBv.scene = 3;
                            gtVar.cBv.appId = avVar.vCy.fKh;
                            gtVar.cBv.context = b.this.activity;
                            com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                            com.tencent.mm.plugin.sns.c.a.gkF.a(b.this.activity, avVar.vCy.fKh, df, cqu.jBB, i, 11, 6, avVar.vCy.vCs, cqu.Id);
                            AppMethodBeat.o(40260);
                            return;
                        }
                        break;
                    case 6:
                        int a = com.tencent.mm.plugin.sns.ui.af.a(b.this.activity, avVar);
                        if (a != 1) {
                            if (a == 2) {
                                gtVar = new gt();
                                gtVar.cBv.context = b.this.activity;
                                gtVar.cBv.actionCode = 1;
                                gtVar.cBv.appId = avVar.vCy.fKh;
                                gtVar.cBv.messageAction = avVar.vCy.vCu;
                                gtVar.cBv.messageExt = avVar.vCy.vCt;
                                gtVar.cBv.scene = 3;
                                com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                                com.tencent.mm.plugin.sns.c.a.gkF.a(b.this.activity, avVar.vCy.fKh, df, cqu.jBB, i, 11, 3, avVar.vCy.vCs, cqu.Id);
                                break;
                            }
                        }
                        gtVar = new gt();
                        gtVar.cBv.context = b.this.activity;
                        gtVar.cBv.actionCode = 2;
                        gtVar.cBv.appId = avVar.vCy.fKh;
                        gtVar.cBv.messageAction = avVar.vCy.vCu;
                        gtVar.cBv.messageExt = avVar.vCy.vCt;
                        gtVar.cBv.scene = 3;
                        com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                        com.tencent.mm.plugin.sns.c.a.gkF.a(b.this.activity, avVar.vCy.fKh, df, cqu.jBB, i, 11, 6, avVar.vCy.vCs, cqu.Id);
                        AppMethodBeat.o(40260);
                        return;
                        break;
                }
                AppMethodBeat.o(40260);
            }
        };
        this.rJT = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40261);
                if (view.getTag() instanceof n) {
                    n nVar = (n) view.getTag();
                    if (nVar.field_type == 21 && r.Yz().equals(nVar.field_userName)) {
                        nVar.cqu();
                        m.m(nVar);
                        m.l(nVar);
                        System.currentTimeMillis();
                        com.tencent.mm.plugin.sns.lucky.a.b.kT(24);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_sendid", nVar.cqA());
                    intent.putExtra("key_feedid", nVar.cqU());
                    intent.setClassName(b.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
                    b.this.activity.startActivity(intent);
                    String cqU = nVar.cqU();
                    nVar.cqA();
                    AnonymousClass14.ZQ(cqU);
                }
                AppMethodBeat.o(40261);
            }

            private static void ZQ(String str) {
                int i = 0;
                AppMethodBeat.i(40262);
                n kD = af.cnF().kD(af.cnF().YT(str).field_snsId);
                if (kD != null) {
                    TimeLineObject cqu = kD.cqu();
                    if (cqu != null) {
                        LinkedList linkedList = cqu.xfI.wbK;
                        if (linkedList.size() > 0) {
                            linkedList.get(0);
                        }
                    }
                    cbf q = com.tencent.mm.plugin.sns.model.aj.q(kD);
                    ArrayList arrayList = new ArrayList();
                    LinkedList linkedList2 = q.xaE.xbh;
                    if (linkedList2 != null) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= linkedList2.size()) {
                                break;
                            }
                            cbb cbb = (cbb) linkedList2.get(i2);
                            com.tencent.mm.plugin.l.a.a aVar = new com.tencent.mm.plugin.l.a.a();
                            aVar.igi = cbb.vHl;
                            aVar.nRz = cbb.pcX;
                            aVar.nRA = cbb.wZK;
                            arrayList.add(aVar);
                            i = i2 + 1;
                        }
                    }
                    com.tencent.mm.plugin.l.a.o(str, arrayList);
                }
                AppMethodBeat.o(40262);
            }
        };
        this.rJO = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40263);
                b.this.dG(view);
                AppMethodBeat.o(40263);
            }
        };
        this.rJP = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40264);
                b.this.dJ(view);
                AppMethodBeat.o(40264);
            }
        };
        this.rJQ = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40265);
                if (view.getTag() instanceof String) {
                    String str = (String) view.getTag();
                    ab.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(str)));
                    com.tencent.mm.plugin.sns.model.aj.Da(v.Zn(str));
                    com.tencent.mm.plugin.sns.model.aj.CY(v.Zn(str));
                    af.cnB().cmp();
                    b.this.crE();
                    if (b.this.rKo != null) {
                        b.this.rKo.cud();
                    }
                }
                AppMethodBeat.o(40265);
            }
        };
        this.rJR = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40266);
                try {
                    int Zn = v.Zn((String) view.getTag());
                    Intent intent = new Intent();
                    intent.putExtra("sns_label_sns_info", Zn);
                    com.tencent.mm.plugin.sns.c.a.gkE.u(intent, b.this.activity);
                    AppMethodBeat.o(40266);
                } catch (Exception e) {
                    AppMethodBeat.o(40266);
                }
            }
        };
        this.rJU = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40267);
                if (view.getTag() instanceof l) {
                    l lVar = (l) view.getTag();
                    if (!com.tencent.mm.plugin.sns.ui.widget.d.fF(lVar.qJj.wZL, 16)) {
                        contextMenu.add(0, 11, 0, b.this.activity.getString(R.string.oy));
                    }
                    if (lVar.jBB != null && lVar.jBB.equals(r.Yz())) {
                        contextMenu.add(0, 7, 0, b.this.activity.getString(R.string.p4));
                    }
                    if (!com.tencent.mm.plugin.sns.ui.widget.d.fF(lVar.qJj.wZL, 16)) {
                        int i;
                        String ga = ap.ga(lVar.rib, (lVar.qJj.wZG != 0 ? (long) lVar.qJj.wZG : lVar.qJj.wZJ));
                        if (lVar.scene == 1) {
                            i = 2;
                        } else if (lVar.scene == 2) {
                            i = 4;
                        } else {
                            i = -1;
                        }
                        com.tencent.mm.plugin.sns.model.ap.b Ye = ap.Ye(ga);
                        if (Ye == null || !Ye.foa || Ye.aAR || (i & Ye.dtW) == 0) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (i == 0) {
                            ap.a(contextMenu, false);
                            AppMethodBeat.o(40267);
                            return;
                        }
                        ap.b(contextMenu, false);
                    }
                }
                AppMethodBeat.o(40267);
            }

            public final boolean dR(View view) {
                AppMethodBeat.i(40268);
                if (view.getTag() instanceof l) {
                    n YS = af.cnF().YS(((l) view.getTag()).rib);
                    b.this.rJH.a(view, YS.cqU(), YS.cqu());
                    AppMethodBeat.o(40268);
                    return true;
                }
                AppMethodBeat.o(40268);
                return false;
            }
        };
        this.jNA = new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(40269);
                ab.d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
                b.this.dI(view);
                AppMethodBeat.o(40269);
                return false;
            }
        };
        this.rKc = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40270);
                if (view.getTag() instanceof ar) {
                    n YS = af.cnF().YS(((ar) view.getTag()).cFc);
                    if (YS == null) {
                        AppMethodBeat.o(40270);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("sns_text_show", YS.cqu().xfF);
                    intent.putExtra("sns_local_id", YS.cqU());
                    intent.setClass(b.this.activity, SnsSingleTextViewUI.class);
                    b.this.activity.startActivity(intent);
                }
                AppMethodBeat.o(40270);
            }
        };
        this.rKf = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40271);
                if (view.getTag() instanceof q) {
                    int width;
                    int height;
                    q qVar = (q) view.getTag();
                    bau bau = (bau) qVar.rin.xfI.wbK.get(0);
                    af.cnF().YS(qVar.cwT);
                    String str = "";
                    String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
                    String str2 = "";
                    String j = com.tencent.mm.plugin.sns.data.i.j(bau);
                    if (com.tencent.mm.vfs.e.ct(fZ + j)) {
                        str = fZ + j;
                        str2 = fZ + com.tencent.mm.plugin.sns.data.i.e(bau);
                    }
                    if (com.tencent.mm.vfs.e.ct(fZ + com.tencent.mm.plugin.sns.data.i.p(bau))) {
                        str = fZ + com.tencent.mm.plugin.sns.data.i.p(bau);
                        str2 = fZ + com.tencent.mm.plugin.sns.data.i.n(bau);
                    }
                    int[] iArr = new int[2];
                    View findViewById = view.findViewById(R.id.ejz);
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
                    intent.setClass(b.this.activity, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", qVar.cwT);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_from_scene", b.this.cvd);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    b.this.activity.startActivity(intent);
                    b.this.activity.overridePendingTransition(0, 0);
                    b.a(b.this, qVar.rin);
                }
                AppMethodBeat.o(40271);
            }
        };
        this.rKe = new OnClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:139:0x0726  */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x0647  */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x0647  */
            /* JADX WARNING: Removed duplicated region for block: B:139:0x0726  */
            /* JADX WARNING: Removed duplicated region for block: B:139:0x0726  */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x0647  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(View view) {
                aj ajVar;
                int i;
                int i2;
                int i3;
                Throwable e;
                AppMethodBeat.i(40279);
                ab.i("MicroMsg.TimelineClickListener", "onsight click");
                if (view.getTag() instanceof aj) {
                    ajVar = (aj) view.getTag();
                } else if (view.getTag() instanceof BaseViewHolder) {
                    ajVar = ((BaseViewHolder) view.getTag()).rGD;
                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                    ajVar = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).rGD;
                } else {
                    ajVar = null;
                }
                n YT = af.cnF().YT(ajVar.cwT);
                if (YT == null) {
                    AppMethodBeat.o(40279);
                    return;
                }
                if (b.this.rhQ != null) {
                    b.this.rhQ.cnj().x(YT);
                }
                boolean DI = YT.DI(32);
                if (DI && YT.cqo() != null && (YT.cqo().coP() || YT.cqo().coQ())) {
                    b.this.rKn.onClick(view);
                    AppMethodBeat.o(40279);
                    return;
                }
                TimeLineObject timeLineObject = ajVar.rnr;
                if (timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.size() == 0) {
                    ab.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                    AppMethodBeat.o(40279);
                    return;
                }
                bau bau = (bau) timeLineObject.xfI.wbK.get(0);
                if (DI) {
                    af.cnC();
                    if (!com.tencent.mm.plugin.sns.model.g.t(bau)) {
                        ajVar.raP.setVisibility(8);
                        ajVar.rnu.setVisibility(0);
                        ajVar.rnu.dKB();
                        af.cnC().z(bau);
                        com.tencent.mm.plugin.sns.model.b cnA = af.cnA();
                        az dtl = az.dtl();
                        dtl.oyB = timeLineObject.pcX;
                        cnA.a(bau, 4, null, dtl);
                        if (DI) {
                            j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, YT, b.this.cvd);
                        }
                        AppMethodBeat.o(40279);
                        return;
                    }
                }
                Object obj = (YT.DI(32) && YT.cqo().coK() && i.YO(YT.crd().field_adxml)) ? 1 : null;
                if (obj == null && DI && af.cnC().u(bau)) {
                    af.cnC().z(bau);
                    ajVar.raP.setVisibility(8);
                    ajVar.rnu.setVisibility(8);
                    com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
                    com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar.qzM;
                    int hashCode = b.this.activity.hashCode();
                    int i4 = ajVar.position;
                    az dtl2 = az.dtl();
                    dtl2.oyB = timeLineObject.pcX;
                    cnC.a(YT, bau, aVar, hashCode, i4, dtl2, DI);
                    if (DI) {
                        j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, YT, b.this.cvd);
                    }
                    AppMethodBeat.o(40279);
                    return;
                }
                com.tencent.mm.modelsns.b lY;
                if (b.this.cvd == 0) {
                    lY = com.tencent.mm.modelsns.b.lY(717);
                } else {
                    lY = com.tencent.mm.modelsns.b.lZ(717);
                }
                lY.tx(com.tencent.mm.plugin.sns.data.i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx(bau.Id);
                lY.ajK();
                if (b.this.cvd == 0) {
                    lY = com.tencent.mm.modelsns.b.lY(745);
                } else {
                    lY = com.tencent.mm.modelsns.b.lZ(745);
                }
                lY.tx(com.tencent.mm.plugin.sns.data.i.j(YT)).mb(YT.field_type).cS(YT.DI(32));
                if (DI) {
                    com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, YT.field_snsId, YT.cqo().coK() ? 21 : 17, YT.cqo().coK() ? 0 : 21));
                    if (!(YT.cqo().coK() && i.YO(YT.crd().field_adxml))) {
                        j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.EnterFullScreen, YT, b.this.cvd);
                    }
                }
                String str = "";
                String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
                String str2 = "";
                String j = com.tencent.mm.plugin.sns.data.i.j(bau);
                if (com.tencent.mm.vfs.e.ct(fZ + j)) {
                    str = fZ + j;
                    str2 = fZ + com.tencent.mm.plugin.sns.data.i.e(bau);
                }
                if (com.tencent.mm.vfs.e.ct(fZ + com.tencent.mm.plugin.sns.data.i.p(bau))) {
                    str = fZ + com.tencent.mm.plugin.sns.data.i.p(bau);
                    str2 = fZ + com.tencent.mm.plugin.sns.data.i.n(bau);
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                com.tencent.mm.plugin.report.service.h.pYm.e(11444, Integer.valueOf(3));
                Intent intent;
                TimeLineObject cqu;
                int i5;
                if (!DI) {
                    ab.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
                    intent = new Intent();
                    intent.setClass(b.this.activity, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", ajVar.cwT);
                    intent.putExtra("intent_isad", DI);
                    intent.putExtra("intent_from_scene", b.this.cvd);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    lY.b(intent, "intent_key_StatisticsOplog");
                    b.this.activity.startActivity(intent);
                    b.this.activity.overridePendingTransition(0, 0);
                    b.a(b.this, YT.cqu());
                    AppMethodBeat.o(40279);
                } else if (YT.DI(32) && YT.cqo().coK() && i.YO(YT.crd().field_adxml)) {
                    String y = i.y(YT);
                    if (!bo.isNullOrNil(y)) {
                        YT.crd().field_adxml = y;
                    }
                    intent = new Intent();
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    intent.putExtra("sns_landing_pages_share_sns_id", YT.cqA());
                    intent.putExtra("sns_landing_pages_rawSnsId", YT.cqu().Id);
                    intent.putExtra("sns_landing_pages_ux_info", YT.crc());
                    cqu = YT.cqu();
                    if (cqu != null) {
                        LinkedList linkedList = cqu.xfI.wbK;
                        if (linkedList.size() > 0) {
                            intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                        }
                    }
                    intent.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                    i5 = 1;
                    if (b.this.cvd == 2) {
                        i5 = 16;
                    } else if (b.this.cvd == 1) {
                        i5 = 2;
                    }
                    intent.putExtra("sns_landig_pages_from_source", i5);
                    intent.putExtra("sns_landing_pages_xml", YT.crd().field_adxml);
                    intent.putExtra("sns_landing_pages_rec_src", YT.cre());
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                    intent.putExtra("sns_landing_is_native_sight_ad", true);
                    b.this.activity.startActivity(intent);
                    b.this.activity.overridePendingTransition(0, 0);
                    AppMethodBeat.o(40279);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setClass(b.this.activity, SnsSightPlayerUI.class);
                    intent2.putExtra("intent_videopath", str);
                    intent2.putExtra("intent_thumbpath", str2);
                    intent2.putExtra("intent_localid", ajVar.cwT);
                    intent2.putExtra("intent_isad", DI);
                    intent2.putExtra("intent_from_scene", b.this.cvd);
                    intent2.putExtra("img_gallery_left", iArr[0]);
                    intent2.putExtra("img_gallery_top", iArr[1]);
                    intent2.putExtra("img_gallery_width", width);
                    intent2.putExtra("img_gallery_height", height);
                    lY.b(intent2, "intent_key_StatisticsOplog");
                    b.this.activity.startActivity(intent2);
                    b.this.activity.overridePendingTransition(0, 0);
                    final bau bau2 = bau;
                    final aj ajVar2 = ajVar;
                    final n nVar = YT;
                    final TimeLineObject timeLineObject2 = timeLineObject;
                    final boolean z = DI;
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(40278);
                            if (af.cnC().u(bau2)) {
                                ajVar2.qzM.bf(null, false);
                                com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
                                n nVar = nVar;
                                bau bau = bau2;
                                com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar2.qzM;
                                int hashCode = b.this.activity.hashCode();
                                int i = ajVar2.position;
                                az dtl = az.dtl();
                                dtl.oyB = timeLineObject2.pcX;
                                cnC.a(nVar, bau, aVar, hashCode, i, dtl, z);
                                ajVar2.raP.setVisibility(0);
                                ajVar2.rnu.setVisibility(8);
                                ajVar2.raP.setImageDrawable(com.tencent.mm.bz.a.g(b.this.activity, R.raw.shortvideo_play_btn));
                            }
                            AppMethodBeat.o(40278);
                        }
                    }, 500);
                    int[] iArr2 = new int[3];
                    if (!DI && af.cnC().a(YT, iArr2) > 5) {
                        af.cnC().y(bau);
                        i = 1;
                    } else if (!DI || af.cnC().b(YT, iArr2) <= 5) {
                        i = 2;
                    } else {
                        af.cnC().y(bau);
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
                    com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                    dVar.l("20FeedId", cqu.Id + ",");
                    dVar.l("21AdUxInfo", YT.crc() + ",");
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
                                    ab.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                    i5 = 0;
                                    dVar.l("22LayerId", i3 + ",");
                                    dVar.l("23ExpId", i5 + ",");
                                    dVar.l("24ClickState", i + ",");
                                    dVar.l("25ClickTime", bo.anT() + ",");
                                    i5 = 0;
                                    if (at.isWifi(ah.getContext())) {
                                    }
                                    dVar.l("26NetworkType", i5 + ",");
                                    dVar.l("27IsFlowControl", i6 + ",");
                                    dVar.l("28AutoDownloadSetting", i7 + ",");
                                    dVar.l("29IsAutoPlay", i2 + ",");
                                    dVar.l("30IsFlowControlDatePeriod", width + ",");
                                    ab.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Fk());
                                    com.tencent.mm.plugin.report.service.h.pYm.e(13323, dVar);
                                    AppMethodBeat.o(40279);
                                }
                                dVar.l("22LayerId", i3 + ",");
                                dVar.l("23ExpId", i5 + ",");
                                dVar.l("24ClickState", i + ",");
                                dVar.l("25ClickTime", bo.anT() + ",");
                                i5 = 0;
                                if (at.isWifi(ah.getContext())) {
                                    i5 = 1;
                                } else if (at.is2G(ah.getContext())) {
                                    i5 = 2;
                                } else if (at.is3G(ah.getContext())) {
                                    i5 = 3;
                                } else if (at.is4G(ah.getContext())) {
                                    i5 = 4;
                                }
                                dVar.l("26NetworkType", i5 + ",");
                                dVar.l("27IsFlowControl", i6 + ",");
                                dVar.l("28AutoDownloadSetting", i7 + ",");
                                dVar.l("29IsAutoPlay", i2 + ",");
                                dVar.l("30IsFlowControlDatePeriod", width + ",");
                                ab.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Fk());
                                com.tencent.mm.plugin.report.service.h.pYm.e(13323, dVar);
                                AppMethodBeat.o(40279);
                            }
                        }
                        i5 = 0;
                        i3 = 0;
                    } catch (Exception e3) {
                        e = e3;
                        i3 = 0;
                        ab.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                        i5 = 0;
                        dVar.l("22LayerId", i3 + ",");
                        dVar.l("23ExpId", i5 + ",");
                        dVar.l("24ClickState", i + ",");
                        dVar.l("25ClickTime", bo.anT() + ",");
                        i5 = 0;
                        if (at.isWifi(ah.getContext())) {
                        }
                        dVar.l("26NetworkType", i5 + ",");
                        dVar.l("27IsFlowControl", i6 + ",");
                        dVar.l("28AutoDownloadSetting", i7 + ",");
                        dVar.l("29IsAutoPlay", i2 + ",");
                        dVar.l("30IsFlowControlDatePeriod", width + ",");
                        ab.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Fk());
                        com.tencent.mm.plugin.report.service.h.pYm.e(13323, dVar);
                        AppMethodBeat.o(40279);
                    }
                    dVar.l("22LayerId", i3 + ",");
                    dVar.l("23ExpId", i5 + ",");
                    dVar.l("24ClickState", i + ",");
                    dVar.l("25ClickTime", bo.anT() + ",");
                    i5 = 0;
                    if (at.isWifi(ah.getContext())) {
                    }
                    dVar.l("26NetworkType", i5 + ",");
                    dVar.l("27IsFlowControl", i6 + ",");
                    dVar.l("28AutoDownloadSetting", i7 + ",");
                    dVar.l("29IsAutoPlay", i2 + ",");
                    dVar.l("30IsFlowControlDatePeriod", width + ",");
                    ab.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Fk());
                    com.tencent.mm.plugin.report.service.h.pYm.e(13323, dVar);
                    AppMethodBeat.o(40279);
                }
            }
        };
        this.rJX = new c() {
            /* JADX WARNING: Removed duplicated region for block: B:15:0x00a6  */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x00b8  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40280);
                if (view.getTag() instanceof aj) {
                    int i;
                    aj ajVar = (aj) view.getTag();
                    if (!ajVar.qFG) {
                        contextMenu.add(0, 19, 0, b.this.activity.getString(R.string.amb));
                    }
                    if (bo.ank(com.tencent.mm.m.g.Nu().getValue("SIGHTCannotTransmitForFav")) == 0) {
                        if (ajVar.rnr.xfI.wbK.size() > 0) {
                            bau bau = (bau) ajVar.rnr.xfI.wbK.get(0);
                            String str = an.fZ(af.getAccSnsPath(), bau.Id) + com.tencent.mm.plugin.sns.data.i.e(bau);
                            String a = aq.a(ajVar.cwT, bau);
                            ab.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", Boolean.valueOf(com.tencent.mm.vfs.e.ct(str)), Boolean.valueOf(com.tencent.mm.vfs.e.ct(a)));
                            if (com.tencent.mm.vfs.e.ct(str) && r1) {
                                i = 1;
                                if (d.afj("favorite")) {
                                    contextMenu.add(0, 10, 0, b.this.activity.getString(R.string.dcq));
                                }
                                if (i != 0) {
                                    dq dqVar = new dq();
                                    dqVar.cxc.cwT = ajVar.cwT;
                                    com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                                    if (dqVar.cxd.cwB) {
                                        contextMenu.add(0, 18, 0, b.this.activity.getString(R.string.s7));
                                    }
                                }
                            }
                        } else {
                            ab.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
                        }
                    }
                    i = 0;
                    if (d.afj("favorite")) {
                    }
                    if (i != 0) {
                    }
                }
                AppMethodBeat.o(40280);
            }

            public final boolean dR(View view) {
                AppMethodBeat.i(40281);
                if (view.getTag() instanceof aj) {
                    String str = ((aj) view.getTag()).cwT;
                    b.this.rJH.a(view, str, af.cnF().YT(str).cqu());
                    AppMethodBeat.o(40281);
                    return true;
                }
                AppMethodBeat.o(40281);
                return false;
            }
        };
        this.rKg = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40282);
                b.this.dK(view);
                if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
                    AppMethodBeat.o(40282);
                    return;
                }
                com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                n YT = af.cnF().YT(bVar.cwT);
                if (YT == null) {
                    AppMethodBeat.o(40282);
                    return;
                }
                if (YT.DI(32)) {
                    bVar.qFI = System.currentTimeMillis();
                    com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, YT.field_snsId, 20, 0));
                }
                AppMethodBeat.o(40282);
            }
        };
        this.rKj = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(40283);
                ab.i("MicroMsg.TimelineClickListener", "unlike click");
                if (adapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c) {
                    com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                    n YT = af.cnF().YT(bVar.cwT);
                    if (YT == null) {
                        AppMethodBeat.o(40283);
                        return;
                    } else if (i == 0) {
                        Object obj;
                        if (YT.DI(32)) {
                            Object obj2;
                            com.tencent.mm.plugin.sns.storage.a a = b.a(b.this, YT);
                            if (a == null) {
                                obj2 = "";
                            } else {
                                String obj22 = a.hnw;
                            }
                            ((com.tencent.mm.plugin.sns.b.c) g.K(com.tencent.mm.plugin.sns.b.c.class)).a(11855, YT.cre(), Integer.valueOf(3), obj22, Integer.valueOf(YT.cre()));
                        }
                        if (bVar.qFH.rDn.qTP.coJ().size() > 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        com.tencent.mm.ai.m rVar;
                        if (obj != null) {
                            com.tencent.mm.plugin.sns.ui.c cVar = (com.tencent.mm.plugin.sns.ui.c) adapterView.getAdapter();
                            cVar.hzv++;
                            cVar.notifyDataSetChanged();
                            adapterView.setOnItemClickListener(b.this.rKk);
                            b.this.crF();
                            obj = new com.tencent.mm.plugin.sns.storage.a.b.a();
                            obj.qUc = com.tencent.mm.plugin.sns.storage.a.b.a.qTY;
                            obj.qFI = bVar.qFI;
                            obj.qUd = 0;
                            rVar = new com.tencent.mm.plugin.sns.model.r(YT.field_snsId, 8, obj);
                            g.RQ();
                            g.RO().eJo.a(rVar, 0);
                            AppMethodBeat.o(40283);
                            return;
                        } else if (bVar.qFH.rDn.qTT) {
                            AppMethodBeat.o(40283);
                            return;
                        } else {
                            b.this.dL(view);
                            obj = new com.tencent.mm.plugin.sns.storage.a.b.a();
                            obj.qFI = bVar.qFI;
                            obj.qUd = System.currentTimeMillis();
                            rVar = new com.tencent.mm.plugin.sns.model.r(YT.field_snsId, 8, obj);
                            g.RQ();
                            g.RO().eJo.a(rVar, 0);
                            AppMethodBeat.o(40283);
                            return;
                        }
                    } else if (bVar.qFH.rDm.qUZ == null) {
                        ab.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
                        AppMethodBeat.o(40283);
                        return;
                    } else {
                        com.tencent.mm.plugin.sns.storage.b.a aVar = bVar.qFH.rDm.qUZ;
                        int i2 = i - 1;
                        if (i2 < aVar.list.size()) {
                            String str = ((com.tencent.mm.plugin.sns.storage.b.b) aVar.list.get(i2)).url;
                            try {
                                String[] strArr = new String[4];
                                strArr[0] = String.format("snsid=%s", new Object[]{YT.cqu().Id});
                                strArr[1] = String.format("aid=%s", new Object[]{YT.cqZ()});
                                strArr[2] = String.format("traceid=%s", new Object[]{YT.cra()});
                                Object[] objArr = new Object[1];
                                g.RN();
                                objArr[0] = com.tencent.mm.kernel.a.QG();
                                strArr[3] = String.format("uin=%s", objArr);
                                str = i.m(str, strArr);
                            } catch (Exception e) {
                            }
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("useJs", true);
                            intent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(YT.field_snsId));
                            intent.putExtra("pre_username", YT.field_userName);
                            intent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(YT.field_snsId));
                            intent.putExtra("preUsername", YT.field_userName);
                            com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                        }
                        AppMethodBeat.o(40283);
                        return;
                    }
                }
                ab.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
                AppMethodBeat.o(40283);
            }
        };
        this.rKk = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(40284);
                if (view.getTag() != null && (view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
                    com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                    if (i < bVar.qFH.rDn.qTP.coJ().size()) {
                        if (bVar.qFH.rDn.qTT) {
                            AppMethodBeat.o(40284);
                            return;
                        }
                        Object obj = (com.tencent.mm.plugin.sns.storage.a.b.a) bVar.qFH.rDn.qTP.coJ().get(i);
                        ab.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", obj.qTZ, Integer.valueOf(obj.qUc));
                        n YT = af.cnF().YT(bVar.cwT);
                        if (YT == null) {
                            AppMethodBeat.o(40284);
                            return;
                        }
                        obj.qFI = bVar.qFI;
                        obj.qUd = System.currentTimeMillis();
                        com.tencent.mm.ai.m rVar = new com.tencent.mm.plugin.sns.model.r(YT.field_snsId, 8, obj);
                        g.RQ();
                        g.RO().eJo.a(rVar, 0);
                        b.this.dL(view);
                    }
                }
                AppMethodBeat.o(40284);
            }
        };
        this.rKn = new OnClickListener() {
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
                AppMethodBeat.i(40285);
                if (view.getTag() == null || !((view.getTag() instanceof BaseViewHolder) || (view.getTag() instanceof ao) || (view.getTag() instanceof aj) || (view.getTag() instanceof MaskImageView) || (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))) {
                    AppMethodBeat.o(40285);
                    return;
                }
                Object obj;
                int obj2;
                int i;
                int i2;
                int i3;
                Object obj3;
                n nVar;
                aj ajVar;
                BaseViewHolder baseViewHolder;
                n nVar2 = null;
                int i4 = 0;
                int i5 = 0;
                n YT;
                if (view.getTag() instanceof ao) {
                    YT = h.YT(((ao) view.getTag()).czD);
                    if (view instanceof LinearLayout) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (((ao) view.getTag()).rnw) {
                        int i6 = ((ao) view.getTag()).index;
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
                    nVar = YT;
                } else {
                    if (view.getTag() instanceof MaskImageView) {
                        Object obj4;
                        MaskImageView maskImageView = (MaskImageView) view.getTag();
                        if (maskImageView.getTag() instanceof ao) {
                            nVar = h.YT(((ao) maskImageView.getTag()).czD);
                            if (!(view instanceof LinearLayout)) {
                                obj4 = 1;
                                nVar2 = nVar;
                            }
                        } else {
                            obj4 = null;
                        }
                        i2 = 0;
                        i3 = 0;
                        obj3 = obj4;
                        nVar = nVar2;
                    } else if (view.getTag() instanceof aj) {
                        ajVar = (aj) view.getTag();
                        YT = af.cnF().YT(ajVar.cwT);
                        if (view instanceof LinearLayout) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (ajVar.rnw) {
                            i4 = ajVar.rnx;
                            i = i4 > 0 ? 2 : 1;
                        } else {
                            i = 0;
                        }
                        i2 = i;
                        i3 = i4;
                        obj3 = obj2;
                        nVar = YT;
                    } else if (view.getTag() instanceof BaseViewHolder) {
                        baseViewHolder = (BaseViewHolder) view.getTag();
                        nVar = h.YS(baseViewHolder.cFc);
                        if (baseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.i.b) {
                            i4 = ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh.index;
                            i = i4 > 0 ? 2 : 1;
                        } else {
                            i = 0;
                        }
                        i5 = i;
                    } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                        nVar = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).ros;
                        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.d) {
                            i4 = ((com.tencent.mm.plugin.sns.ui.c.a.d) view.getTag()).currentIndex;
                            i5 = i4 > 0 ? 2 : 1;
                        }
                    } else {
                        nVar = null;
                    }
                    i2 = i5;
                    i3 = i4;
                    obj3 = null;
                }
                if (nVar == null || !nVar.DI(32)) {
                    AppMethodBeat.o(40285);
                    return;
                }
                String str;
                String str2;
                String coN;
                try {
                    com.tencent.mm.plugin.sns.storage.a a = b.a(b.this, nVar);
                    if (a == null) {
                        obj2 = "";
                    } else {
                        str = a.hnw;
                    }
                    str2 = nVar.cqu().Id;
                    if (!nVar.coX()) {
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(b.this.cvd == 0 ? 1 : 2);
                        objArr[1] = Integer.valueOf(obj3 != null ? 1 : 2);
                        objArr[2] = str2;
                        objArr[3] = obj2;
                        hVar.e(14066, objArr);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.TimelineClickListener", "report click ad card style error " + e.getMessage());
                }
                if (nVar.crd().cqo().coS()) {
                    coN = nVar.crd().cqo().coN();
                    str = nVar.crc();
                    g.RN();
                    str2 = com.tencent.mm.kernel.a.QG();
                    v.h(coN, str, str2, v.ak(coN, str, str2), 0);
                }
                TimeLineObject cqu = nVar.cqu();
                Intent intent;
                TimeLineObject cqu2;
                LinkedList linkedList;
                SnsAdClick snsAdClick;
                boolean z;
                com.tencent.mm.plugin.sns.storage.a a2;
                Bundle bundle;
                if ((cqu.xfI.wbJ != 15 || cqu.xfP == 1) && !(cqu.xfI.wbJ == 27 && cqu.xfI.wbK.size() > i3 && ((bau) cqu.xfI.wbK.get(i3)).jCt == 6)) {
                    if ((cqu.xfI.wbJ == 1 && cqu.xfI.wbK.size() == 1) || cqu.xfI.wbJ == 7 || (cqu.xfI.wbJ == 27 && cqu.xfI.wbK.size() > i3 && ((bau) cqu.xfI.wbK.get(i3)).jCt == 2)) {
                        View view2;
                        if (view.getTag() instanceof BaseViewHolder) {
                            baseViewHolder = (BaseViewHolder) view.getTag();
                            if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.a.a) {
                                view2 = ((com.tencent.mm.plugin.sns.ui.item.a.a) view.getTag()).rGX;
                            } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.c.a) {
                                view2 = ((com.tencent.mm.plugin.sns.ui.item.c.a) view.getTag()).rGX;
                            } else if (baseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.i.b) {
                                view2 = (TagImageView) ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJh.view;
                            } else {
                                view2 = baseViewHolder.rHT.DT(0);
                            }
                        } else {
                            if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b) {
                                    view2 = ((com.tencent.mm.plugin.sns.ui.c.a.b) view.getTag()).rGK;
                                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.c) {
                                    view2 = ((com.tencent.mm.plugin.sns.ui.c.a.c) view.getTag()).rGX;
                                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.d) {
                                    view2 = ((com.tencent.mm.plugin.sns.ui.c.a.d) view.getTag()).contentView;
                                }
                            } else if (view.getTag() instanceof MaskImageView) {
                                view2 = (MaskImageView) view.getTag();
                            } else if (view.getTag() instanceof TagImageView) {
                                view2 = (TagImageView) view;
                            }
                            view2 = null;
                        }
                        if (nVar.cqo().coK()) {
                            if (i.go(nVar.crd().field_adxml, i3 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                                com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, nVar.field_snsId, 21, i2, (byte) 0));
                                if (view.getTag() instanceof BaseViewHolder) {
                                    b.this.h((BaseViewHolder) view.getTag());
                                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                                    b.this.a((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag());
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
                                intent.putExtra("sns_landing_pages_share_sns_id", nVar.cqA());
                                intent.putExtra("sns_landing_pages_rawSnsId", nVar.cqu().Id);
                                intent.putExtra("sns_landing_pages_ux_info", nVar.crc());
                                intent.putExtra("sns_landing_pages_aid", nVar.cqZ());
                                intent.putExtra("sns_landing_pages_traceid", nVar.cra());
                                cqu2 = nVar.cqu();
                                if (cqu2 != null) {
                                    linkedList = cqu2.xfI.wbK;
                                    if (linkedList.size() > i3) {
                                        intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(i3)).wEH);
                                    } else if (linkedList.size() > 0) {
                                        intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                                    }
                                }
                                intent.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                i = 1;
                                if (b.this.cvd == 2) {
                                    i = 16;
                                } else if (b.this.cvd == 1) {
                                    i = 2;
                                }
                                intent.putExtra("sns_landig_pages_from_source", i);
                                intent.putExtra("sns_landing_pages_xml", i3 > 0 ? nVar.cqo().coV() : nVar.crd().field_adxml);
                                intent.putExtra("sns_landing_pages_rec_src", nVar.cre());
                                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                b.this.activity.startActivity(intent);
                                b.this.activity.overridePendingTransition(0, 0);
                                if (b.this.rhQ != null) {
                                    b.this.rhQ.cnj().x(nVar);
                                }
                                AppMethodBeat.o(40285);
                                return;
                            }
                        }
                        if (b.a(b.this, b.a(b.this, nVar), nVar, i3 > 0)) {
                            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, nVar.field_snsId, 31, i2, (byte) 0));
                            AppMethodBeat.o(40285);
                            return;
                        }
                        coN = i3 > 0 ? nVar.cqo().qUX.qTA : nVar.crb();
                        if (bo.isNullOrNil(coN)) {
                            coN = nVar.getAdLink();
                        }
                        if (bo.isNullOrNil(coN)) {
                            AppMethodBeat.o(40285);
                            return;
                        }
                        snsAdClick = new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, nVar.field_snsId, 0, i2, (byte) 0);
                        com.tencent.mm.plugin.sns.data.i.a(snsAdClick);
                        ab.i("MicroMsg.TimelineClickListener", "adlink url " + coN + " " + nVar.cqo().qUg);
                        intent = new Intent();
                        z = nVar.cqo().qUg == 0;
                        if (ae.giI) {
                            z = false;
                        }
                        if (nVar != null && nVar.DI(32)) {
                            a2 = b.a(b.this, nVar);
                            if (a2 != null) {
                                intent.putExtra("KsnsViewId", a2.hnw);
                            }
                        }
                        intent.putExtra("KRightBtn", z);
                        bundle = new Bundle();
                        bundle.putParcelable("KSnsAdTag", snsAdClick);
                        bundle.putString("key_snsad_statextstr", nVar.cqu().rjC);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", coN);
                        intent.putExtra("useJs", true);
                        intent.putExtra("srcUsername", nVar.field_userName);
                        intent.putExtra("stastic_scene", 15);
                        intent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(nVar.field_snsId));
                        intent.putExtra("pre_username", nVar.field_userName);
                        intent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(nVar.field_snsId));
                        intent.putExtra("preUsername", nVar.field_userName);
                        com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                    }
                    AppMethodBeat.o(40285);
                    return;
                }
                aj ajVar2;
                ab.i("MicroMsg.TimelineClickListener", "onsight click");
                ajVar = null;
                BaseViewHolder baseViewHolder2 = null;
                if (view.getTag() instanceof aj) {
                    ajVar = (aj) view.getTag();
                }
                if (view.getTag() instanceof BaseViewHolder) {
                    baseViewHolder = (BaseViewHolder) view.getTag();
                    if (cqu.xfI.wbJ == 27) {
                        baseViewHolder2 = baseViewHolder;
                        ajVar2 = ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder).rJi;
                    } else {
                        baseViewHolder2 = baseViewHolder;
                        ajVar2 = baseViewHolder.rGD;
                    }
                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                    ajVar2 = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).rGD;
                } else {
                    ajVar2 = ajVar;
                }
                if (nVar == null) {
                    AppMethodBeat.o(40285);
                    return;
                }
                if (b.this.rhQ != null) {
                    b.this.rhQ.cnj().x(nVar);
                }
                boolean DI = nVar.DI(32);
                if (cqu.xfI.wbK == null || cqu.xfI.wbK.size() == 0) {
                    ab.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                    AppMethodBeat.o(40285);
                    return;
                }
                com.tencent.mm.modelsns.b lY;
                int[] iArr2;
                bau bau = (bau) cqu.xfI.wbK.get(i3);
                if (DI) {
                    af.cnC();
                    if (!(com.tencent.mm.plugin.sns.model.g.t(bau) || ajVar2 == null)) {
                        ajVar2.raP.setVisibility(8);
                        ajVar2.rnu.setVisibility(0);
                        ajVar2.rnu.dKB();
                        af.cnC().z(bau);
                        com.tencent.mm.plugin.sns.model.b cnA = af.cnA();
                        az dtl = az.dtl();
                        dtl.oyB = cqu.pcX;
                        cnA.a(bau, 4, null, dtl);
                        if (DI) {
                            j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, nVar, b.this.cvd);
                        }
                        AppMethodBeat.o(40285);
                        return;
                    }
                }
                if (nVar.DI(32) && nVar.cqo().coK()) {
                    if (i.go(nVar.crd().field_adxml, i3 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                        obj3 = 1;
                        if (obj3 == null || !DI || !af.cnC().u(bau) || ajVar2 == null) {
                            int i7;
                            if (b.this.cvd != 0) {
                                lY = com.tencent.mm.modelsns.b.lY(717);
                            } else {
                                lY = com.tencent.mm.modelsns.b.lZ(717);
                            }
                            lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar)).mb(nVar.field_type).cS(nVar.DI(32)).tx(nVar.crc()).tx(bau.Id);
                            lY.ajK();
                            if (b.this.cvd != 0) {
                                lY = com.tencent.mm.modelsns.b.lY(745);
                            } else {
                                lY = com.tencent.mm.modelsns.b.lZ(745);
                            }
                            lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar)).mb(nVar.field_type).cS(nVar.DI(32));
                            iArr2 = new int[2];
                            if (baseViewHolder2 == null) {
                                if (baseViewHolder2.rGD.rnt != null) {
                                    baseViewHolder2.rGD.rnt.getLocationInWindow(iArr2);
                                    i4 = baseViewHolder2.rGD.rnt.getWidth();
                                    obj2 = baseViewHolder2.rGD.rnt.getHeight();
                                    i7 = i4;
                                } else if (cqu.xfI.wbJ == 27) {
                                    ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder2).rJf.getLocationInWindow(iArr2);
                                    i4 = ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder2).rJf.getWidth();
                                    obj2 = ((com.tencent.mm.plugin.sns.ui.item.i.b) baseViewHolder2).rJf.getHeight();
                                    i7 = i4;
                                } else {
                                    obj2 = 0;
                                    i7 = 0;
                                }
                            } else if (view.getTag() instanceof aj) {
                                ajVar = (aj) view.getTag();
                                if (ajVar != null) {
                                    ajVar.rnt.getLocationInWindow(iArr2);
                                }
                                i5 = ajVar.rnt.getWidth();
                                obj2 = ajVar.rnt.getHeight();
                                i7 = i5;
                            } else {
                                if (view != null) {
                                    view.getLocationInWindow(iArr2);
                                }
                                i5 = view.getWidth();
                                obj2 = view.getHeight();
                                i7 = i5;
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(11444, Integer.valueOf(3));
                            if (obj3 == null) {
                                if (view.getTag() instanceof BaseViewHolder) {
                                    b.this.h((BaseViewHolder) view.getTag());
                                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                                    b.this.a((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag());
                                }
                                com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, nVar.field_snsId, 22, 21));
                                Intent intent2 = new Intent();
                                intent2.putExtra("img_gallery_left", iArr2[0]);
                                intent2.putExtra("img_gallery_top", iArr2[1]);
                                intent2.putExtra("img_gallery_width", i7);
                                intent2.putExtra("img_gallery_height", obj2);
                                intent2.putExtra("sns_landing_pages_share_sns_id", nVar.cqA());
                                intent2.putExtra("sns_landing_pages_rawSnsId", nVar.cqu().Id);
                                intent2.putExtra("sns_landing_pages_ux_info", nVar.crc());
                                cqu2 = nVar.cqu();
                                if (cqu2 != null) {
                                    linkedList = cqu2.xfI.wbK;
                                    if (linkedList.size() > i3) {
                                        intent2.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(i3)).wEH);
                                    }
                                }
                                intent2.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                i = 1;
                                if (b.this.cvd == 2) {
                                    i = 16;
                                } else if (b.this.cvd == 1) {
                                    i = 2;
                                }
                                intent2.putExtra("sns_landig_pages_from_source", i);
                                intent2.putExtra("sns_landing_pages_xml", i3 > 0 ? nVar.cqo().coV() : nVar.crd().field_adxml);
                                intent2.putExtra("sns_landing_pages_rec_src", nVar.cre());
                                intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                intent2.putExtra("sns_landing_is_native_sight_ad", true);
                                b.this.activity.startActivity(intent2);
                                b.this.activity.overridePendingTransition(0, 0);
                                AppMethodBeat.o(40285);
                                return;
                            }
                            if (b.a(b.this, b.a(b.this, nVar), nVar, i3 > 0)) {
                                com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, nVar.field_snsId, 22, 31));
                                AppMethodBeat.o(40285);
                                return;
                            }
                            snsAdClick = new SnsAdClick(b.this.cvd, b.this.cvd == 0 ? 1 : 2, nVar.field_snsId, 22, 0);
                            com.tencent.mm.plugin.sns.data.i.a(snsAdClick);
                            coN = i3 > 0 ? nVar.cqo().qUX.qTA : nVar.crb();
                            if (bo.isNullOrNil(coN)) {
                                coN = nVar.getAdLink();
                            }
                            if (bo.isNullOrNil(coN)) {
                                AppMethodBeat.o(40285);
                                return;
                            }
                            ab.i("MicroMsg.TimelineClickListener", "adlink url " + coN + " " + nVar.cqo().qUg);
                            intent = new Intent();
                            z = nVar.cqo().qUg == 0;
                            if (ae.giI) {
                                z = false;
                            }
                            if (nVar != null && nVar.DI(32)) {
                                a2 = b.a(b.this, nVar);
                                if (a2 != null) {
                                    intent.putExtra("KsnsViewId", a2.hnw);
                                }
                            }
                            intent.putExtra("KRightBtn", z);
                            bundle = new Bundle();
                            bundle.putParcelable("KSnsAdTag", snsAdClick);
                            bundle.putString("key_snsad_statextstr", nVar.cqu().rjC);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", coN);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", nVar.field_userName);
                            intent.putExtra("stastic_scene", 15);
                            intent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(nVar.field_snsId));
                            intent.putExtra("pre_username", nVar.field_userName);
                            intent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.jV(nVar.field_snsId));
                            intent.putExtra("preUsername", nVar.field_userName);
                            com.tencent.mm.plugin.sns.c.a.gkE.i(intent, b.this.activity);
                            AppMethodBeat.o(40285);
                            return;
                        }
                        af.cnC().z(bau);
                        ajVar2.raP.setVisibility(8);
                        ajVar2.rnu.setVisibility(8);
                        com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
                        com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar2.qzM;
                        i4 = b.this.activity.hashCode();
                        int i8 = ajVar2.position;
                        az dtl2 = az.dtl();
                        dtl2.oyB = cqu.pcX;
                        cnC.a(nVar, bau, aVar, i4, i8, dtl2, DI);
                        if (DI) {
                            j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, nVar, b.this.cvd);
                        }
                        AppMethodBeat.o(40285);
                        return;
                    }
                }
                obj3 = null;
                if (obj3 == null) {
                }
                if (b.this.cvd != 0) {
                }
                lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar)).mb(nVar.field_type).cS(nVar.DI(32)).tx(nVar.crc()).tx(bau.Id);
                lY.ajK();
                if (b.this.cvd != 0) {
                }
                lY.tx(com.tencent.mm.plugin.sns.data.i.j(nVar)).mb(nVar.field_type).cS(nVar.DI(32));
                iArr2 = new int[2];
                if (baseViewHolder2 == null) {
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(11444, Integer.valueOf(3));
                if (obj3 == null) {
                }
            }
        };
        this.rKb = new c() {
            public final boolean dR(View view) {
                AppMethodBeat.i(40286);
                Object tag = view.getTag();
                if (tag instanceof q) {
                    q qVar = (q) tag;
                    TimeLineObject timeLineObject = qVar.rin;
                    if (timeLineObject.xfI.wbJ == 10 || timeLineObject.xfI.wbJ == 17 || timeLineObject.xfI.wbJ == 22 || timeLineObject.xfI.wbJ == 23) {
                        AppMethodBeat.o(40286);
                        return false;
                    }
                    b.this.rJH.a(view, qVar.cwT, timeLineObject);
                    AppMethodBeat.o(40286);
                    return true;
                }
                AppMethodBeat.o(40286);
                return false;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(40287);
                Object tag = view.getTag();
                if (tag instanceof q) {
                    q qVar = (q) tag;
                    TimeLineObject timeLineObject = qVar.rin;
                    if (d.afj("favorite")) {
                        dq dqVar;
                        switch (timeLineObject.xfI.wbJ) {
                            case 1:
                                contextMenu.add(0, 2, 0, view.getContext().getString(R.string.dcq));
                                break;
                            case 3:
                                contextMenu.add(0, 3, 0, view.getContext().getString(R.string.dcq));
                                dqVar = new dq();
                                dqVar.cxc.cwT = qVar.cwT;
                                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                                if (dqVar.cxd.cwB) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(R.string.s7));
                                    break;
                                }
                                break;
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(R.string.dcq));
                                dqVar = new dq();
                                dqVar.cxc.cwT = qVar.cwT;
                                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                                if (dqVar.cxd.cwB) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(R.string.s7));
                                    break;
                                }
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(R.string.dcq));
                                break;
                            case 14:
                                contextMenu.add(0, 9, 0, view.getContext().getString(R.string.dcq));
                                break;
                            case 15:
                                contextMenu.add(0, 10, 0, view.getContext().getString(R.string.dcq));
                                break;
                            case 26:
                                contextMenu.add(0, 22, 0, view.getContext().getString(R.string.dcq));
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(R.string.dcq));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, af.cnF().YT(qVar.cwT));
                }
                AppMethodBeat.o(40287);
            }
        };
        this.rJj = new e() {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                AppMethodBeat.i(40288);
                if (bVar != null && i == 0) {
                    View view;
                    if (bVar.qxx != null) {
                        view = (View) bVar.qxx.get();
                    } else {
                        view = null;
                    }
                    if (view != null && (view instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view;
                        aVar.getVideoPath();
                        if (aVar.getTagObject() != null && (aVar.getTagObject() instanceof aj)) {
                            aVar.getTagObject();
                        }
                    }
                }
                AppMethodBeat.o(40288);
            }
        };
    }

    public final void bIB() {
        this.rJH.bIB();
        com.tencent.mm.sdk.b.a.xxA.c(this.rKq);
        com.tencent.mm.sdk.b.a.xxA.c(this.rKr);
    }

    public final void removeListener() {
        this.rJH.removeListener();
        com.tencent.mm.sdk.b.a.xxA.d(this.rKq);
        com.tencent.mm.sdk.b.a.xxA.d(this.rKr);
    }

    public final void h(BaseViewHolder baseViewHolder) {
        if (baseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a) {
            this.rJD = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity) this.activity, baseViewHolder);
            this.rJE = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity) this.activity, baseViewHolder);
        } else if (baseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.c.a) {
            this.rJD = new f((MMActivity) this.activity, baseViewHolder);
            this.rJE = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity) this.activity, baseViewHolder);
        } else if (baseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.i.b) {
            this.rJD = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity) this.activity, baseViewHolder);
            this.rJE = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity) this.activity, baseViewHolder);
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.c.a.a aVar) {
        if (aVar instanceof com.tencent.mm.plugin.sns.ui.c.a.b) {
            this.rJF = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity) this.activity, aVar);
            this.rJG = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity) this.activity, aVar);
        } else if (aVar instanceof com.tencent.mm.plugin.sns.ui.c.a.c) {
            this.rJF = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity) this.activity, aVar);
            this.rJG = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity) this.activity, aVar);
        } else if (aVar instanceof com.tencent.mm.plugin.sns.ui.c.a.d) {
            this.rJF = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity) this.activity, aVar);
            this.rJG = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity) this.activity, aVar);
        }
    }

    static /* synthetic */ n dQ(View view) {
        if (view.getTag() instanceof ao) {
            return h.YT(((ao) view.getTag()).czD);
        }
        if (view.getTag() instanceof MaskImageView) {
            MaskImageView maskImageView = (MaskImageView) view.getTag();
            if (maskImageView.getTag() instanceof ao) {
                return h.YT(((ao) maskImageView.getTag()).czD);
            }
        } else if (view.getTag() instanceof aj) {
            return af.cnF().YT(((aj) view.getTag()).cwT);
        } else if (view.getTag() instanceof BaseViewHolder) {
            return h.YS(((BaseViewHolder) view.getTag()).cFc);
        } else {
            if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                return ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).ros;
            }
        }
        return null;
    }

    static /* synthetic */ void a(b bVar, View view, n nVar, int i, String str, boolean z) {
        aj ajVar;
        aj ajVar2 = null;
        if (view.getTag() instanceof aj) {
            ajVar2 = (aj) view.getTag();
        }
        if (view.getTag() instanceof BaseViewHolder) {
            ajVar2 = ((BaseViewHolder) view.getTag()).rGD;
        }
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
            ajVar = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).rGD;
        } else {
            ajVar = ajVar2;
        }
        if (nVar != null && ajVar != null) {
            if (bVar.rhQ != null) {
                bVar.rhQ.cnj().x(nVar);
            }
            boolean DI = nVar.DI(32);
            TimeLineObject cqu = nVar.cqu();
            if (cqu.xfI.wbK == null || cqu.xfI.wbK.size() == 0) {
                ab.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                return;
            }
            bau bau = (bau) cqu.xfI.wbK.get(0);
            if (DI) {
                af.cnC();
                if (!com.tencent.mm.plugin.sns.model.g.t(bau)) {
                    ajVar.raP.setVisibility(8);
                    ajVar.rnu.setVisibility(0);
                    ajVar.rnu.dKB();
                    af.cnC().z(bau);
                    com.tencent.mm.plugin.sns.model.b cnA = af.cnA();
                    az dtl = az.dtl();
                    dtl.oyB = cqu.pcX;
                    cnA.a(bau, 4, null, dtl);
                    return;
                }
            }
            Object obj = (nVar.DI(32) && nVar.cqo().coK() && i.YO(str)) ? 1 : null;
            if (obj == null && DI && af.cnC().u(bau)) {
                af.cnC().z(bau);
                ajVar.raP.setVisibility(8);
                ajVar.rnu.setVisibility(8);
                com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
                com.tencent.mm.plugin.sight.decode.a.a aVar = ajVar.qzM;
                int hashCode = bVar.activity.hashCode();
                int i2 = ajVar.position;
                az dtl2 = az.dtl();
                dtl2.oyB = cqu.pcX;
                cnC.a(nVar, bau, aVar, hashCode, i2, dtl2, DI);
                return;
            }
            int[] iArr = new int[2];
            ajVar.rnt.getLocationInWindow(iArr);
            int width = ajVar.rnt.getWidth();
            int height = ajVar.rnt.getHeight();
            if (nVar.DI(32) && nVar.cqo().coK() && i.YO(str)) {
                int i3;
                if (view.getTag() instanceof BaseViewHolder) {
                    bVar.h((BaseViewHolder) view.getTag());
                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                    bVar.a((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag());
                }
                String y = i.y(nVar);
                if (!bo.isNullOrNil(y)) {
                    nVar.crd().field_adxml = y;
                }
                int i4 = bVar.cvd;
                int i5 = bVar.cvd == 0 ? 1 : 2;
                long j = nVar.field_snsId;
                if (z) {
                    i3 = 22;
                } else {
                    i3 = 21;
                }
                com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i4, i5, j, i, i3));
                Intent intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("sns_landing_pages_share_sns_id", nVar.cqA());
                intent.putExtra("sns_landing_pages_rawSnsId", nVar.cqu().Id);
                intent.putExtra("sns_landing_pages_ux_info", nVar.crc());
                TimeLineObject cqu2 = nVar.cqu();
                if (cqu2 != null) {
                    LinkedList linkedList = cqu2.xfI.wbK;
                    if (linkedList.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                    }
                }
                intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
                int i6 = 1;
                if (bVar.cvd == 2) {
                    i6 = 16;
                } else if (bVar.cvd == 1) {
                    i6 = 2;
                }
                intent.putExtra("sns_landig_pages_from_source", i6);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_rec_src", nVar.cre());
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                bVar.activity.startActivity(intent);
                bVar.activity.overridePendingTransition(0, 0);
                return;
            }
            ab.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
        }
    }

    static /* synthetic */ void b(b bVar, View view, n nVar, int i, String str, boolean z) {
        TagImageView tagImageView;
        if (view.getTag() instanceof BaseViewHolder) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            if (baseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a) {
                tagImageView = ((com.tencent.mm.plugin.sns.ui.item.a.a) baseViewHolder).rGX;
            } else {
                tagImageView = baseViewHolder.rHT.DT(0);
            }
        } else if (view.getTag() instanceof MaskImageView) {
            tagImageView = (MaskImageView) view.getTag();
        } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b) {
            tagImageView = ((com.tencent.mm.plugin.sns.ui.c.a.b) view.getTag()).rGK;
        } else {
            tagImageView = (TagImageView) view;
        }
        if (nVar.cqo().coK() && i.YO(str)) {
            int i2;
            if (view.getTag() instanceof BaseViewHolder) {
                bVar.h((BaseViewHolder) view.getTag());
            } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                bVar.a((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag());
            }
            int i3 = bVar.cvd;
            int i4 = bVar.cvd == 0 ? 1 : 2;
            long j = nVar.field_snsId;
            if (z) {
                i2 = 22;
            } else {
                i2 = 21;
            }
            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i3, i4, j, i, i2));
            String y = i.y(nVar);
            if (!bo.isNullOrNil(y)) {
                nVar.crd().field_adxml = y;
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
            intent.putExtra("sns_landing_pages_share_sns_id", nVar.cqA());
            intent.putExtra("sns_landing_pages_rawSnsId", nVar.cqu().Id);
            intent.putExtra("sns_landing_pages_ux_info", nVar.crc());
            intent.putExtra("sns_landing_pages_aid", nVar.cqZ());
            intent.putExtra("sns_landing_pages_traceid", nVar.cra());
            TimeLineObject cqu = nVar.cqu();
            if (cqu != null) {
                LinkedList linkedList = cqu.xfI.wbK;
                if (linkedList.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                }
            }
            intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
            int i5 = 1;
            if (bVar.cvd == 2) {
                i5 = 16;
            } else if (bVar.cvd == 1) {
                i5 = 2;
            }
            intent.putExtra("sns_landig_pages_from_source", i5);
            intent.putExtra("sns_landing_pages_xml", str);
            intent.putExtra("sns_landing_pages_rec_src", nVar.cre());
            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            bVar.activity.startActivity(intent);
            bVar.activity.overridePendingTransition(0, 0);
            if (bVar.rhQ != null) {
                bVar.rhQ.cnj().x(nVar);
            }
        }
    }

    static /* synthetic */ boolean a(b bVar, com.tencent.mm.plugin.sns.storage.a aVar, n nVar, boolean z) {
        if (aVar != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (z && nVar.cqo().qUX.cBb != null) {
                str = nVar.cqo().qUX.cBb;
                str2 = nVar.cqo().qUX.csu;
                str3 = nVar.cqo().qUX.appVersion;
            } else if (!(z || aVar.qTw != 4 || aVar.qTO == null)) {
                str = aVar.qTO.cBb;
                str2 = aVar.qTO.csu;
                str3 = aVar.qTO.appVersion;
            }
            if (!bo.isNullOrNil(str)) {
                if (!bo.isNullOrNil(str2)) {
                    r5 = new String[2];
                    r5[0] = String.format("gdt_vid=%s", new Object[]{nVar.cra()});
                    r5[1] = String.format("weixinadinfo=%s.%s.0.0", new Object[]{nVar.cqZ(), nVar.cra()});
                    str2 = i.n(str2, r5);
                }
                se seVar = new se();
                seVar.cOf.cst = com.tencent.mm.plugin.sns.data.i.jV(nVar.field_snsId) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + aVar.qPj + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + af.cnk() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + System.currentTimeMillis();
                seVar.cOf.userName = str;
                seVar.cOf.axy = bo.ank(str3);
                seVar.cOf.cOh = str2;
                seVar.cOf.scene = bVar.cvd == 0 ? 1045 : 1046;
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                return true;
            }
        }
        return false;
    }
}
