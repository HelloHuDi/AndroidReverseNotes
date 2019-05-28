package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseTimeLineItem {
    public boolean DEBUG = false;
    protected int klY;
    protected Activity mActivity;
    protected au qPr;
    public ArrayList<com.tencent.mm.plugin.sns.model.ap.b> rHq = new ArrayList();
    protected boolean rps = false;

    class a extends o {
        a() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(40121);
            BaseTimeLineItem.this.qPr.rqg.rDC.onClick(view);
            AppMethodBeat.o(40121);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(40122);
            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.o(40122);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.o(40122);
        }
    }

    public static class BaseViewHolder {
        public String cFc;
        public String cwT;
        public volatile boolean eBB;
        public TextView gne;
        public TextView kPs;
        public int klY;
        public View mRR;
        public boolean mVC;
        public int position;
        public cbf qCX;
        public boolean qFG;
        public bb qFH;
        public TextView qHh;
        public aj rGD = new aj();
        public SnsTranslateResultView rHA;
        public LinearLayout rHB;
        public ViewStub rHC;
        public boolean rHD = false;
        public TextView rHE;
        public TagImageView rHF;
        public TextView rHG;
        public int rHH = 0;
        public TextView rHI;
        public AsyncTextView rHJ;
        public AsyncTextView rHK;
        public View rHL;
        public ImageView rHM;
        public View rHN;
        public MaskTextView rHO;
        public LinearLayout rHP;
        public LinearLayout rHQ;
        public View rHR;
        public LinearLayout rHS;
        public PhotosContent rHT;
        public View rHU;
        public ViewStub rHV;
        public boolean rHW = false;
        public ViewStub rHX;
        public ViewStub rHY;
        public View rHZ = null;
        public long rHt;
        public int rHu;
        public SnsAvatarImageView rHv;
        public AsyncTextView rHw;
        public ImageView rHx;
        public ViewGroup rHy;
        public AsyncNormalTextView rHz;
        public String rIA;
        public boolean rIa = false;
        public boolean rIb = false;
        public ViewStub rIc;
        public boolean rId = false;
        public View rIe;
        public LinearLayout rIf;
        public TextView rIg;
        public ViewStub rIh;
        public boolean rIi = false;
        public View rIj;
        public LinearLayout rIk;
        public ViewStub rIl;
        public boolean rIm = false;
        public View rIn;
        public ImageView rIo;
        public boolean rIp = false;
        ViewStub rIq;
        boolean rIr = false;
        public com.tencent.mm.n.a rIs;
        public View rIt;
        public BaseTimeLineItem rIu;
        public ViewStub rIv;
        public View rIw;
        public MaskTextView rIx;
        public View rIy;
        private TextView rIz;
        public TextView raQ;
        public bav rfi;
        public LinearLayout rgx;
        public ImageView rhd;
        public TextView rjj;
        public int rql = 210;
        public TextView rvM;
        public View rvR;
        public TimeLineObject timeLineObject;
        public TextView timeTv;

        public BaseViewHolder() {
            AppMethodBeat.i(40125);
            AppMethodBeat.o(40125);
        }
    }

    class b extends o {
        b() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(40123);
            BaseTimeLineItem.this.qPr.rqg.rDs.onClick(view);
            AppMethodBeat.o(40123);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(40124);
            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.o(40124);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.o(40124);
        }
    }

    class c extends o {
        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(40126);
            BaseTimeLineItem.this.qPr.rqg.rDt.onClick(view);
            AppMethodBeat.o(40126);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(40127);
            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.o(40127);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.o(40127);
        }
    }

    public abstract void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar);

    public abstract void d(BaseViewHolder baseViewHolder);

    public final void setIsFromMainTimeline(boolean z) {
        this.rps = z;
    }

    private static void a(BaseViewHolder baseViewHolder, n nVar) {
        LayoutParams layoutParams;
        if (nVar.DI(32)) {
            if (baseViewHolder.rHz != null) {
                baseViewHolder.rHz.setVisibility(0);
            }
            baseViewHolder.rHB.setLongClickable(false);
            baseViewHolder.rHB.setOnClickListener(null);
            baseViewHolder.rHB.setLayoutParams(new LayoutParams(-1, -2));
            baseViewHolder.rHB.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (baseViewHolder.rHT != null) {
                layoutParams = (LayoutParams) baseViewHolder.rHT.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                baseViewHolder.rHT.setLayoutParams(layoutParams);
            }
            if (baseViewHolder.rIr) {
                layoutParams = (LayoutParams) baseViewHolder.rGD.rns.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                baseViewHolder.rGD.rns.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (baseViewHolder.rHz != null) {
            baseViewHolder.rHz.setVisibility(0);
        }
        baseViewHolder.rHB.setLongClickable(false);
        baseViewHolder.rHB.setOnClickListener(null);
        if (baseViewHolder.rHT != null) {
            layoutParams = (LayoutParams) baseViewHolder.rHT.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            baseViewHolder.rHT.setLayoutParams(layoutParams);
        }
        if (baseViewHolder.rIr) {
            layoutParams = (LayoutParams) baseViewHolder.rGD.rns.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            baseViewHolder.rGD.rns.setLayoutParams(layoutParams);
        }
        baseViewHolder.rHB.setLayoutParams(new LayoutParams(-1, -2));
        baseViewHolder.rHB.setBackgroundColor(Color.parseColor("#00ffffff"));
    }

    public final View a(Activity activity, BaseViewHolder baseViewHolder, int i, au auVar, n nVar) {
        String str;
        this.mActivity = activity;
        this.klY = i;
        this.qPr = auVar;
        baseViewHolder.cFc = nVar.cqA();
        switch (i) {
            case 0:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 1:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 2:
                str = "R.layout.sns_timeline_imagesline_one";
                break;
            case 3:
                str = "R.layout.sns_timeline_imagesline1";
                break;
            case 4:
                str = "R.layout.sns_timeline_imagesline2";
                break;
            case 5:
                str = "R.layout.sns_timeline_imagesline3";
                break;
            case 6:
                str = "R.layout.sns_timeline_item_photo_one3";
                break;
            case 7:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 8:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 9:
                str = "R.layout.sns_media_sight_item";
                break;
            case 10:
                str = "R.layout.sns_hb_reward_item";
                break;
            case 11:
                str = "R.layout.sns_timeline_turn_media";
                break;
            case 12:
                str = "R.layout.sns_media_collapse_item";
                break;
            case 13:
                str = "R.layout.sns_ad_card_layout_item";
                break;
            case 14:
                str = "R.layout.sns_timeline_ad_full_card";
                break;
            default:
                str = "R.layout.sns_media_sub_item2";
                break;
        }
        View a = com.tencent.mm.kiss.a.b.SM().a(this.mActivity, str, (int) R.layout.awu);
        baseViewHolder.rIA = str;
        View findViewById = a.findViewById(R.id.ehw);
        if (findViewById instanceof ViewStub) {
            baseViewHolder.rHC = (ViewStub) findViewById;
        } else {
            baseViewHolder.rHC = null;
        }
        ab.i("MicroMsg.BaseTimeLineItem", "create new item  " + i + "  " + a.hashCode());
        baseViewHolder.rIt = a.findViewById(R.id.emx);
        baseViewHolder.klY = i;
        baseViewHolder.rHv = (SnsAvatarImageView) a.findViewById(R.id.ehn);
        baseViewHolder.rHv.setWeakContext(activity);
        baseViewHolder.rHv.setOnClickListener(auVar.qOL.rJI);
        baseViewHolder.rHv.setOnLongClickListener(auVar.qOL.rJJ);
        baseViewHolder.rHv.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(40115);
                if (motionEvent.getAction() == 0) {
                    view.setTag(R.id.cy, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                }
                AppMethodBeat.o(40115);
                return false;
            }
        });
        baseViewHolder.rHw = (AsyncTextView) a.findViewById(R.id.b6e);
        baseViewHolder.rHx = (ImageView) a.findViewById(R.id.ehq);
        baseViewHolder.rHw.setOnTouchListener(new aa());
        baseViewHolder.rHy = (ViewGroup) a.findViewById(R.id.emy);
        baseViewHolder.rHz = (AsyncNormalTextView) a.findViewById(R.id.en0);
        baseViewHolder.rHz.setOpClickListener(auVar.rxZ);
        baseViewHolder.rHB = (LinearLayout) a.findViewById(R.id.ehv);
        baseViewHolder.rHB.setTag(baseViewHolder);
        baseViewHolder.rHB.setOnClickListener(auVar.qOL.rKn);
        auVar.jMO.c(a.findViewById(R.id.ld), auVar.qOL.rJK, auVar.qOL.rJH);
        auVar.jMO.c((TextView) a.findViewById(R.id.axa), auVar.qOL.rJK, auVar.qOL.rJH);
        baseViewHolder.rHA = (SnsTranslateResultView) a.findViewById(R.id.ehu);
        baseViewHolder.rHA.setVisibility(8);
        baseViewHolder.rHA.getSplitlineView().setPadding(0, 0, (int) this.mActivity.getResources().getDimension(R.dimen.nc), 0);
        baseViewHolder.rHA.getResultTextView().setBackgroundResource(R.drawable.a0t);
        auVar.jMO.c(baseViewHolder.rHA.getResultTextView(), auVar.qOL.rJK, auVar.qOL.rJH);
        baseViewHolder.rHS = (LinearLayout) a.findViewById(R.id.ej0);
        baseViewHolder.rHI = (TextView) a.findViewById(R.id.ehy);
        baseViewHolder.timeTv = (TextView) a.findViewById(R.id.ehz);
        baseViewHolder.rHJ = (AsyncTextView) a.findViewById(R.id.ei0);
        baseViewHolder.rHK = (AsyncTextView) a.findViewById(R.id.ei1);
        baseViewHolder.rvM = (TextView) a.findViewById(R.id.ehx);
        baseViewHolder.qFH = new bb(a);
        baseViewHolder.qFH.a(auVar.qOL.rJS, auVar.qOL.rKg);
        baseViewHolder.rjj = (TextView) a.findViewById(R.id.ei5);
        baseViewHolder.rjj.setText(activity.getString(R.string.p4));
        baseViewHolder.rjj.setOnClickListener(auVar.qOL.rJM);
        baseViewHolder.rHJ.setOnClickListener(auVar.qOL.rKh);
        baseViewHolder.rHK.setOnClickListener(auVar.qOL.rKi);
        baseViewHolder.rvM.setOnClickListener(auVar.qOL.rKd);
        baseViewHolder.rHL = a.findViewById(R.id.ei2);
        baseViewHolder.rHL.setOnClickListener(auVar.qOL.rJR);
        baseViewHolder.kPs = (TextView) a.findViewById(R.id.ei3);
        baseViewHolder.rHM = (ImageView) a.findViewById(R.id.eho);
        baseViewHolder.rHV = (ViewStub) a.findViewById(R.id.en5);
        baseViewHolder.rgx = (LinearLayout) a.findViewById(R.id.emi);
        baseViewHolder.rIv = (ViewStub) a.findViewById(R.id.en4);
        baseViewHolder.rHX = (ViewStub) a.findViewById(R.id.en7);
        baseViewHolder.rHE = (TextView) a.findViewById(R.id.en2);
        baseViewHolder.rHE.setOnClickListener(auVar.qOL.rJN);
        baseViewHolder.rIz = (TextView) a.findViewById(R.id.ei4);
        baseViewHolder.mRR = a;
        if (this.rps) {
            com.tencent.mm.plugin.sns.abtest.c.b(a, baseViewHolder);
            com.tencent.mm.plugin.sns.abtest.a.a(a, baseViewHolder);
            af.cnw();
            com.tencent.mm.plugin.sns.g.c.c(a, baseViewHolder);
        }
        d(baseViewHolder);
        a.setTag(baseViewHolder);
        a(baseViewHolder, nVar);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:217:0x09b3  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x09c0  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0558  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0abb  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0ac7  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x057b  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x05f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final BaseViewHolder baseViewHolder, int i, n nVar, TimeLineObject timeLineObject, int i2, au auVar) {
        String cqU;
        String gj;
        String str;
        CharSequence charSequence;
        com.tencent.mm.ui.a.a dzk;
        View view;
        AsyncTextView asyncTextView;
        TextView textView;
        String content;
        TextView textView2;
        boolean z;
        av avVar = (av) auVar.cuc().crQ().get(Integer.valueOf(i));
        a(baseViewHolder, nVar);
        this.klY = i2;
        this.qPr = auVar;
        if (this.rps) {
            com.tencent.mm.plugin.sns.ui.a.a.F(nVar);
        }
        com.tencent.mm.plugin.sns.ui.a.a.d(timeLineObject);
        if (nVar.DI(32)) {
            ab.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + i.jW(nVar.field_snsId) + " for susan");
        }
        baseViewHolder.rHt = avVar.rAt;
        baseViewHolder.mVC = false;
        baseViewHolder.position = i;
        baseViewHolder.cFc = avVar.rAs;
        baseViewHolder.cwT = avVar.riA;
        baseViewHolder.rHu = avVar.rAx;
        baseViewHolder.rHM.setOnClickListener(auVar.rxY);
        baseViewHolder.timeLineObject = timeLineObject;
        cbf cbf = avVar.qBX;
        baseViewHolder.qCX = cbf;
        com.tencent.mm.plugin.sns.i.b bVar = auVar.rxP.rhn.qMn;
        if (nVar != null) {
            cqU = nVar.cqU();
            bVar.qSA.add(cqU);
            if (nVar.DI(32)) {
                bVar.qSF.add(cqU);
            }
            bVar.qSG.add(nVar.field_userName);
            switch (nVar.field_type) {
                case 1:
                    bVar.qSC.add(cqU);
                    break;
                case 2:
                    bVar.qSB.add(cqU);
                    break;
                case 3:
                    if (!bo.isNullOrNil(timeLineObject.xfJ)) {
                        bVar.qSH.add(cqU);
                        break;
                    } else {
                        bVar.qSI.add(cqU);
                        break;
                    }
                case 4:
                    bVar.qSE.add(cqU);
                    break;
                case 5:
                    bVar.qSJ.add(cqU);
                    break;
                case 15:
                    bVar.qSD.add(cqU);
                    break;
                case 18:
                    bVar.qSK.add(cqU);
                    break;
                default:
                    bVar.qSL.add(cqU);
                    break;
            }
            if (i < bVar.qSy) {
                bVar.qSy = i;
                bVar.qRd = i.j(nVar);
            }
            if (i > bVar.qSz) {
                bVar.qSz = i;
                bVar.qRe = i.j(nVar);
            }
            bVar.qRj = bVar.qSB.size();
            bVar.qRk = bVar.qSC.size();
            bVar.qRl = bVar.qSD.size();
            bVar.qRn = bVar.qSE.size();
            bVar.qRm = bVar.qSF.size();
            bVar.qRo = bVar.qSJ.size();
            bVar.qRw = bVar.qSK.size();
            bVar.jLU = bVar.qSG.size();
            bVar.qRh = bVar.qSH.size();
            bVar.qRi = bVar.qSI.size();
            bVar.qRv = bVar.qSL.size();
            bVar.qQR = bVar.qSA.size();
        }
        com.tencent.mm.plugin.sns.storage.b cqo = nVar.cqo();
        cqU = avVar.igi;
        if (!bo.isNullOrNil(cqU)) {
            baseViewHolder.rIs = avVar.rAr;
            baseViewHolder.rHv.setTag(cqU);
            final au auVar2;
            if (cqo == null || !cqo.qVa) {
                if (cqU.endsWith("@ad")) {
                    baseViewHolder.rHv.setImageResource(R.drawable.ad2);
                    baseViewHolder.rHv.dk(cqU, 4);
                    baseViewHolder.rHv.setShowStoryHint(false);
                } else {
                    if (avVar.rAI) {
                        ab.i("MicroMsg.BaseTimeLineItem", "getContact %s", cqU);
                        if (com.tencent.mm.pluginsdk.ui.a.b.diS().AZ() != null) {
                            baseViewHolder.rHv.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.diS().AZ());
                        }
                        com.tencent.mm.model.ao.a.flu.a(cqU, "", new com.tencent.mm.plugin.sns.ui.au.b(auVar.cuc(), i));
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.b(baseViewHolder.rHv, cqU);
                    }
                    if (avVar.rAJ) {
                        baseViewHolder.rHv.dk(cqU, 4);
                        baseViewHolder.rHv.setShowStoryHint(false);
                    } else {
                        com.tencent.mm.plugin.sns.ui.e.a.b(4, (String) baseViewHolder.rHv.getTag(), baseViewHolder.rHv);
                        baseViewHolder.rHv.dk(cqU, 4);
                        baseViewHolder.rHv.setTag(cqU);
                        com.tencent.mm.plugin.sns.ui.e.a.a(4, cqU, baseViewHolder.rHv);
                        baseViewHolder.rHv.setShowStoryHint(((e) g.M(e.class)).hasNewStory(cqU));
                    }
                }
                auVar2 = auVar;
                baseViewHolder.rHw.a(cqU, avVar.rAH, new com.tencent.mm.pluginsdk.ui.e.o.a() {
                    public final void a(View view, Object obj) {
                        AppMethodBeat.i(40118);
                        if (auVar2.rqd != null) {
                            auVar2.rqd.cvd = 6;
                            auVar2.rqd.a(view, obj);
                        }
                        AppMethodBeat.o(40118);
                    }
                }, avVar.rgZ, avVar.riA, i2, avVar.rgZ);
            } else {
                baseViewHolder.rHv.setImageResource(R.drawable.ad2);
                baseViewHolder.rHv.dk(cqU, 4);
                baseViewHolder.rHv.setShowStoryHint(false);
                if (!bo.isNullOrNil(cqo.qVc)) {
                    gj = h.gj("adId", cqo.qVc);
                    baseViewHolder.rHv.setTag(R.id.cl, cqo.qVc);
                    if (com.tencent.mm.vfs.e.ct(gj)) {
                        Bitmap decodeFile = d.decodeFile(gj, null);
                        if (decodeFile != null) {
                            baseViewHolder.rHv.setImageBitmap(d.a(decodeFile, true, 0.1f * ((float) decodeFile.getWidth())));
                        }
                    } else {
                        h.a(cqo.qVc, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                            public final void cpu() {
                            }

                            public final void cmD() {
                            }

                            public final void YJ(String str) {
                                AppMethodBeat.i(40116);
                                ab.i("MicroMsg.BaseTimeLineItem", "download img %s", str);
                                if (!bo.Q((String) baseViewHolder.rHv.getTag(R.id.cl), str) && str.equals(h.gj("adId", (String) baseViewHolder.rHv.getTag(R.id.cl)))) {
                                    Bitmap decodeFile = d.decodeFile(str, null);
                                    if (decodeFile != null) {
                                        baseViewHolder.rHv.setImageBitmap(d.a(decodeFile, true, 0.1f * ((float) decodeFile.getWidth())));
                                    }
                                }
                                AppMethodBeat.o(40116);
                            }
                        });
                    }
                }
                auVar2 = auVar;
                baseViewHolder.rHw.a(cqU, avVar.rAH, new com.tencent.mm.pluginsdk.ui.e.o.a() {
                    public final void a(View view, Object obj) {
                        AppMethodBeat.i(40117);
                        if (auVar2.rqd != null) {
                            auVar2.rqd.cvd = 0;
                            auVar2.rqd.a(view, obj);
                        }
                        AppMethodBeat.o(40117);
                    }
                }, avVar.rgZ, avVar.riA, i2, avVar.rgZ);
            }
            baseViewHolder.rHv.eSe = avVar.riA;
        }
        baseViewHolder.rHx.setVisibility(8);
        if (avVar.rgZ) {
            baseViewHolder.qFG = true;
            baseViewHolder.mVC = avVar.rAy;
        } else {
            baseViewHolder.qFG = false;
        }
        if (((e) g.M(e.class)).hasNewStory(cqU)) {
            avVar.rAq = null;
        }
        baseViewHolder.rHz.a(avVar.rAu, auVar, avVar.rAv, avVar);
        baseViewHolder.rHz.setShow(baseViewHolder);
        baseViewHolder.kPs.setOnTouchListener(new aa());
        a(baseViewHolder, i, avVar, timeLineObject, i2, auVar);
        auVar.rxR.put(Integer.valueOf(i), new WeakReference(baseViewHolder.mRR));
        if (baseViewHolder.mRR.getBackground() == null) {
            baseViewHolder.mRR.setBackgroundResource(R.drawable.k5);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12);
            baseViewHolder.mRR.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 8));
        }
        baseViewHolder.timeTv.setText(avVar.rAA);
        baseViewHolder.rHJ.setVisibility(8);
        baseViewHolder.rHK.setVisibility(8);
        if (avVar.rgZ) {
            com.tencent.mm.plugin.sns.storage.a aVar = avVar.rAB;
            baseViewHolder.rHJ.setTag(avVar.riA);
            if (avVar.rAB.qTF == com.tencent.mm.plugin.sns.storage.a.qTr) {
                if (bo.isNullOrNil(avVar.rAE)) {
                    baseViewHolder.rHJ.setVisibility(8);
                } else {
                    baseViewHolder.rHJ.setText(avVar.rAE);
                    baseViewHolder.rHJ.setVisibility(0);
                }
            } else if (aVar.qTF == com.tencent.mm.plugin.sns.storage.a.qTs) {
                if (bo.isNullOrNil(avVar.rAF)) {
                    baseViewHolder.rHJ.setVisibility(8);
                } else {
                    str = avVar.rAG;
                    gj = avVar.rAF;
                    Activity activity = this.mActivity;
                    baseViewHolder.rHJ.getTextSize();
                    k kVar = new k(j.c(activity, gj, 1));
                    kVar.a(null, gj, 0);
                    TextPaint paint = baseViewHolder.rHJ.getPaint();
                    if (com.tencent.mm.bz.a.ao(this.mActivity, (int) Layout.getDesiredWidth(kVar, 0, kVar.length(), paint)) > baseViewHolder.rql) {
                        while (str.length() > 1) {
                            str = str.substring(0, str.length() - 2);
                            String format = String.format(aVar.qTG, new Object[]{str + "..."});
                            Activity activity2 = this.mActivity;
                            baseViewHolder.rHJ.getTextSize();
                            k kVar2 = new k(j.c(activity2, format, 1));
                            kVar2.a(null, format, 0);
                            int ao = com.tencent.mm.bz.a.ao(this.mActivity, (int) Layout.getDesiredWidth(kVar2, 0, kVar2.length(), paint));
                            baseViewHolder.rHJ.setText(kVar2, BufferType.SPANNABLE);
                            baseViewHolder.rHJ.setVisibility(0);
                            if (ao <= baseViewHolder.rql) {
                            }
                        }
                    } else {
                        baseViewHolder.rHJ.setText(kVar, BufferType.SPANNABLE);
                        baseViewHolder.rHJ.setVisibility(0);
                    }
                }
            }
            if (baseViewHolder.rHJ.getVisibility() != 8 && bo.isNullOrNil(aVar.qTH)) {
                baseViewHolder.rHJ.setTextColor(this.mActivity.getResources().getColor(R.color.a1a));
                baseViewHolder.rHJ.setOnClickListener(null);
            }
            if ((nVar.cqu().xfI.wbL & 4) != 0) {
                baseViewHolder.rHK.setTag(baseViewHolder);
                baseViewHolder.rHK.setVisibility(0);
                baseViewHolder.rHK.setText(String.format("%s%s%s", new Object[]{this.mActivity.getResources().getString(R.string.eiu), avVar.rAH, this.mActivity.getResources().getString(R.string.eiv)}));
            } else {
                baseViewHolder.rHK.setVisibility(8);
            }
        }
        if (avVar.rAK) {
            baseViewHolder.rIz.setText(auVar.crP.getString(R.string.ctw, new Object[]{Integer.valueOf(avVar.rAL)}));
            baseViewHolder.rIz.setVisibility(0);
        } else {
            baseViewHolder.rIz.setVisibility(8);
        }
        baseViewHolder.rvM.setTag(avVar.riA);
        if (bo.isNullOrNil(avVar.rAN)) {
            baseViewHolder.rvM.setVisibility(8);
        } else {
            baseViewHolder.rvM.setVisibility(0);
            baseViewHolder.rvM.setText(avVar.rAN);
            baseViewHolder.rvM.setClickable(avVar.rAO);
            baseViewHolder.rvM.setTextColor(avVar.rAO ? -11048043 : -9211021);
        }
        baseViewHolder.kPs.setTextColor(this.mActivity.getResources().getColor(R.color.a0k));
        if (avVar.rAP) {
            baseViewHolder.kPs.setVisibility(0);
            charSequence = this.mActivity.getString(R.string.ejz) + avVar.mAppName;
            if (charSequence.length() > 10) {
                charSequence = charSequence.substring(0, 10) + "...";
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new b(), 0, spannableString.length(), 33);
            baseViewHolder.kPs.setText(spannableString, BufferType.SPANNABLE);
            if (!(avVar.rAR || "wx7fa037cc7dfabad5".equals(timeLineObject.xfH.Id))) {
                baseViewHolder.kPs.setTextColor(this.mActivity.getResources().getColor(R.color.a1a));
                baseViewHolder.kPs.setOnTouchListener(null);
            }
            baseViewHolder.kPs.setTag(timeLineObject);
        } else if (avVar.rAQ) {
            baseViewHolder.kPs.setVisibility(0);
            SpannableString spannableString2 = new SpannableString(avVar.rAT);
            spannableString2.setSpan(new c(), 0, spannableString2.length(), 33);
            baseViewHolder.kPs.setText(spannableString2, BufferType.SPANNABLE);
            baseViewHolder.kPs.setTag(new az(avVar.rAS, avVar.rAT));
        } else if (avVar.rAU) {
            baseViewHolder.kPs.setVisibility(0);
            str = this.mActivity.getString(R.string.gq);
            cqU = str + avVar.mAppName;
            SpannableString spannableString3 = new SpannableString(cqU);
            spannableString3.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(R.color.a1a)), 0, str.length(), 33);
            spannableString3.setSpan(new a(), str.length(), cqU.length(), 33);
            baseViewHolder.kPs.setText(spannableString3, BufferType.SPANNABLE);
            if (!(avVar.rAR || "wx7fa037cc7dfabad5".equals(timeLineObject.xfH.Id))) {
                baseViewHolder.kPs.setTextColor(this.mActivity.getResources().getColor(R.color.a1a));
                baseViewHolder.kPs.setOnTouchListener(null);
            }
            baseViewHolder.kPs.setTag(timeLineObject);
        } else {
            baseViewHolder.kPs.setVisibility(8);
        }
        if (avVar.rAJ) {
            baseViewHolder.rjj.setVisibility(0);
            baseViewHolder.rjj.setTag(avVar.riA);
        } else {
            baseViewHolder.rjj.setVisibility(8);
        }
        baseViewHolder.rHM.setTag(baseViewHolder);
        if (avVar.rAV) {
            if (!baseViewHolder.rIb) {
                baseViewHolder.rHQ = (LinearLayout) baseViewHolder.rHX.inflate();
                baseViewHolder.rHR = baseViewHolder.mRR.findViewById(R.id.el2);
                baseViewHolder.rIb = true;
                baseViewHolder.rHR.setTag(avVar.riA);
                baseViewHolder.raQ = (TextView) baseViewHolder.rHQ.findViewById(R.id.el2);
            }
            baseViewHolder.rHX.setVisibility(0);
            baseViewHolder.rHR.setOnClickListener(auVar.qOL.rJQ);
            switch (avVar.rAW) {
                case 201:
                    baseViewHolder.raQ.setText(R.string.enn);
                    baseViewHolder.rHR.setClickable(false);
                    baseViewHolder.rHR.setEnabled(false);
                    break;
                case 210:
                    baseViewHolder.raQ.setText(R.string.enp);
                    baseViewHolder.rHR.setClickable(false);
                    baseViewHolder.rHR.setEnabled(false);
                    break;
                case 211:
                    baseViewHolder.raQ.setText(R.string.eno);
                    baseViewHolder.rHR.setClickable(true);
                    baseViewHolder.rHR.setEnabled(true);
                    break;
                default:
                    baseViewHolder.raQ.setText(R.string.enq);
                    baseViewHolder.rHR.setClickable(true);
                    baseViewHolder.rHR.setEnabled(true);
                    break;
            }
            bav cqM = nVar.cqM();
            if (!(cqM == null || bo.isNullOrNil(cqM.wFu))) {
                baseViewHolder.raQ.setText(cqM.wFu);
            }
        } else if (baseViewHolder.rIb) {
            baseViewHolder.rHX.setVisibility(8);
        }
        if (avVar.rAX) {
            baseViewHolder.rHL.setVisibility(0);
            baseViewHolder.rHL.setTag(avVar.riA);
        } else {
            baseViewHolder.rHL.setVisibility(8);
        }
        if (avVar.rAY) {
            if (!bo.isNullOrNil(avVar.rAZ)) {
                baseViewHolder.rHI.setVisibility(0);
                if (i2 == 7) {
                    charSequence = String.format(this.mActivity.getString(R.string.eq1), new Object[]{avVar.rAZ});
                } else {
                    charSequence = String.format(this.mActivity.getString(R.string.eq2), new Object[]{avVar.rAZ});
                }
                baseViewHolder.rHI.setText(j.b(this.mActivity, charSequence, baseViewHolder.rHI.getTextSize()));
            } else if (avVar.rBa) {
                baseViewHolder.rHI.setVisibility(0);
                baseViewHolder.rHI.setText(j.b(this.mActivity, this.mActivity.getString(R.string.eq3).toString(), baseViewHolder.rHI.getTextSize()));
            }
            if (!avVar.rBb) {
                if (baseViewHolder.rIw == null) {
                    baseViewHolder.rIw = baseViewHolder.rIv.inflate();
                    baseViewHolder.qHh = (TextView) baseViewHolder.rIw.findViewById(R.id.d0t);
                    baseViewHolder.rIx = (MaskTextView) baseViewHolder.rIw.findViewById(R.id.d0v);
                    baseViewHolder.rIx.setOnTouchListener(new aa());
                }
                baseViewHolder.rIw.setVisibility(0);
                b(baseViewHolder.rIx, avVar.rBe, i2);
                baseViewHolder.qHh.setText(this.mActivity.getString(R.string.emn, new Object[]{Integer.valueOf(avVar.rBc), bo.F(avVar.rBd / 100.0d)}));
                baseViewHolder.rIw.setTag(nVar);
                baseViewHolder.rIw.setOnClickListener(auVar.qOL.rJT);
            } else if (baseViewHolder.rIw != null) {
                baseViewHolder.rIw.setVisibility(8);
            }
            if ((avVar.rBf == null && avVar.rBf.size() != 0) || (avVar.rBg != null && avVar.rBg.size() != 0)) {
                if (!baseViewHolder.rHW) {
                    if (baseViewHolder.rgx != null || baseViewHolder.rHV.getParent() == null) {
                        cqU = "MicroMsg.BaseTimeLineItem";
                        gj = "holder.listKeeper = null %s,and holder.commentStub.inflated";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(baseViewHolder.rgx == null);
                        ab.e(cqU, gj, objArr);
                    } else {
                        baseViewHolder.rgx = (LinearLayout) baseViewHolder.rHV.inflate();
                    }
                    if (baseViewHolder.rgx != null) {
                        baseViewHolder.rHO = (MaskTextView) baseViewHolder.rgx.findViewById(R.id.emj);
                        baseViewHolder.rHO.setOnTouchListener(new aa());
                        baseViewHolder.rHP = (LinearLayout) baseViewHolder.mRR.findViewById(R.id.eml);
                        baseViewHolder.rgx.setTag(avVar.rAs);
                        baseViewHolder.rHO.setTag(avVar.rAs);
                        baseViewHolder.rHU = baseViewHolder.rgx.findViewById(R.id.emk);
                        baseViewHolder.rIy = baseViewHolder.rgx.findViewById(R.id.emi);
                        baseViewHolder.rHW = true;
                    }
                }
                if (baseViewHolder.rgx != null) {
                    baseViewHolder.rgx.setVisibility(0);
                }
                if (avVar.rBf == null || avVar.rBf.size() <= 0) {
                    baseViewHolder.rHO.setVisibility(8);
                } else {
                    baseViewHolder.rHO.setVisibility(0);
                    a(baseViewHolder.rHO, avVar.rBf, i2);
                }
                if (avVar.rBg != null) {
                    a(cbf.xat, avVar.rBg, baseViewHolder);
                } else {
                    baseViewHolder.rHP.setVisibility(8);
                }
                if (avVar.rBf == null || avVar.rBf.size() == 0 || avVar.rBg == null || avVar.rBg.size() == 0) {
                    baseViewHolder.rHU.setVisibility(8);
                } else {
                    baseViewHolder.rHU.setVisibility(0);
                }
            } else if (baseViewHolder.rgx == null) {
                baseViewHolder.rgx.setVisibility(8);
            } else if (baseViewHolder.rHW) {
                baseViewHolder.rHV.setVisibility(8);
            }
            if (avVar.rBh) {
                baseViewHolder.rHE.setVisibility(8);
            } else {
                baseViewHolder.rHE.setTag(avVar.riA);
                baseViewHolder.rHE.setText(avVar.rBi);
                baseViewHolder.rHE.setVisibility(0);
            }
            if (avVar.rgZ) {
                baseViewHolder.qFH.setVisibility(8);
            } else {
                ab.i("MicroMsg.BaseTimeLineItem", "adatag " + avVar.rAD);
                baseViewHolder.qFH.z(Long.valueOf(avVar.rAt), new com.tencent.mm.plugin.sns.data.b(baseViewHolder.qFH, baseViewHolder.position, avVar.riA, avVar.rAt, avVar.rAz));
                baseViewHolder.qFH.a(avVar.rAC, avVar.rAB);
                baseViewHolder.qFH.setVisibility(0);
                if (baseViewHolder.rvM != null && baseViewHolder.rvM.getVisibility() == 0) {
                    Object obj;
                    if (baseViewHolder.qFH.rDj.getVisibility() == 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        LayoutParams layoutParams = (LayoutParams) baseViewHolder.rvM.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mActivity, 0.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
                        baseViewHolder.rvM.setLayoutParams(layoutParams);
                    }
                }
            }
            if (this.rps) {
                af.cnw().a(this.mActivity, cbf, baseViewHolder);
            }
            baseViewHolder.rHA.getResultTextView().setTag(new ar(avVar.rAs, avVar.riA, false, true, 1));
            dzk = com.tencent.mm.ui.a.a.a.yqY;
            view = baseViewHolder.mRR;
            asyncTextView = baseViewHolder.rHw;
            textView = baseViewHolder.timeTv;
            content = baseViewHolder.rHz.getContent();
            textView2 = baseViewHolder.rHG;
            z = baseViewHolder.rIr;
            if (dzk.dzj() && dzk.Gn != null && view != null && asyncTextView != null && textView != null) {
                com.tencent.mm.ui.a.b bVar2 = new com.tencent.mm.ui.a.b();
                bVar2.aqI(asyncTextView.getText().toString());
                bVar2.aqI(content);
                if (textView2 != null) {
                    bVar2.aqI(textView2.getText().toString());
                }
                if (z) {
                    bVar2.aqI(dzk.Gn.getString(R.string.b32));
                }
                bVar2.eD(view);
                return;
            }
            return;
        }
        baseViewHolder.rHI.setVisibility(8);
        if (!avVar.rBb) {
        }
        if (avVar.rBf == null) {
        }
        if (baseViewHolder.rgx == null) {
        }
        if (avVar.rBh) {
        }
        if (avVar.rgZ) {
        }
        if (this.rps) {
        }
        baseViewHolder.rHA.getResultTextView().setTag(new ar(avVar.rAs, avVar.riA, false, true, 1));
        dzk = com.tencent.mm.ui.a.a.a.yqY;
        view = baseViewHolder.mRR;
        asyncTextView = baseViewHolder.rHw;
        textView = baseViewHolder.timeTv;
        content = baseViewHolder.rHz.getContent();
        textView2 = baseViewHolder.rHG;
        z = baseViewHolder.rIr;
        if (dzk.dzj()) {
        }
    }

    public static void a(com.tencent.mm.plugin.sns.model.ap.b bVar, BaseViewHolder baseViewHolder, String str, String str2) {
        if (baseViewHolder != null && baseViewHolder.rHA != null) {
            baseViewHolder.rHA.a(bVar, 1, str, str2, bVar.qMU);
            baseViewHolder.rHA.setVisibility(0);
        }
    }

    public static void e(BaseViewHolder baseViewHolder) {
        if (baseViewHolder != null && baseViewHolder.rHA != null) {
            baseViewHolder.rHA.El(1);
            baseViewHolder.rHA.setVisibility(0);
        }
    }

    public static void f(BaseViewHolder baseViewHolder) {
        if (baseViewHolder != null && baseViewHolder.rHA != null) {
            baseViewHolder.rHA.setVisibility(8);
        }
    }

    private boolean a(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        int i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i3 = 0;
        while (i3 < bVar.size()) {
            try {
                CharSequence charSequence = (String) ((com.tencent.mm.vending.j.a) bVar.get(i3)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i3] = spannableStringBuilder.length();
                iArr2[i3] = iArr[i3] + charSequence.length();
                stringBuffer.append(charSequence);
                spannableStringBuilder.append(j.b(this.mActivity, charSequence, maskTextView.getTextSize()));
                if (com.tencent.mm.plugin.sns.e.a.Xt((String) ((com.tencent.mm.vending.j.a) bVar.get(i3)).get(0)) && ((e) g.M(e.class)).getStoryBasicConfig().a(com.tencent.mm.plugin.story.api.f.a.TimeLine_Like) && com.tencent.mm.plugin.story.api.n.isShowStoryCheck()) {
                    spannableStringBuilder.append("  ");
                    spannableStringBuilder.setSpan(new com.tencent.mm.plugin.sns.ui.widget.g(((e) g.M(e.class)).getStoryUIFactory().ls(true)), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                }
                i3++;
            } catch (Exception e) {
                ab.e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", bo.l(e));
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(i == 10 ? R.drawable.ps : R.drawable.w5);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
        aVar.zLT = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(aVar, length, length + 1, 33);
        if (i == 10) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        for (i3 = 0; i3 < iArr.length; i3++) {
            spannableStringBuilder.setSpan(new o((String) ((com.tencent.mm.vending.j.a) bVar.get(i3)).get(0), new com.tencent.mm.pluginsdk.ui.e.o.a() {
                public final void a(View view, Object obj) {
                    AppMethodBeat.i(40119);
                    if (BaseTimeLineItem.this.qPr.rqd != null) {
                        BaseTimeLineItem.this.qPr.rqd.cvd = 13;
                        BaseTimeLineItem.this.qPr.rqd.a(view, obj);
                    }
                    AppMethodBeat.o(40119);
                }
            }, i2), iArr[i3], iArr2[i3], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.setOriginText(stringBuffer.toString());
        return true;
    }

    private void b(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        if (bVar.size() == 0) {
            maskTextView.setVisibility(8);
            return;
        }
        maskTextView.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < bVar.size()) {
            try {
                CharSequence charSequence = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + charSequence.length();
                stringBuffer.append(charSequence);
                spannableStringBuilder.append(j.b(this.mActivity, charSequence, maskTextView.getTextSize()));
                i2++;
            } catch (Exception e) {
                ab.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", bo.l(e));
                return;
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(R.raw.friendactivity_luckymoney_icon);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
        aVar.zLT = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(aVar, length, length + 1, 33);
        int i3 = i == 10 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new o((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.qPr.rqd, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.setOriginText(stringBuffer.toString());
    }

    public final void a(BaseViewHolder baseViewHolder, int i, n nVar) {
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        int i2 = i;
        a(baseViewHolder2, i2, (av) this.qPr.cuc().crQ().get(Integer.valueOf(i)), nVar.cqu(), baseViewHolder.klY, this.qPr);
    }

    private boolean a(List<cat> list, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, BaseViewHolder baseViewHolder) {
        int i;
        LinearLayout linearLayout = baseViewHolder.rHP;
        int childCount = linearLayout.getChildCount();
        int size = bVar.size();
        if (childCount > size) {
            for (i = size; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(size);
                linearLayout.removeViewAt(size);
                if (childAt instanceof SnsCommentCollapseLayout) {
                    this.qPr.a((SnsCommentCollapseLayout) childAt);
                }
            }
        }
        if (bVar.size() == 0) {
            linearLayout.setVisibility(8);
            return false;
        }
        av avVar;
        linearLayout.setVisibility(0);
        w cuc = this.qPr.cuc();
        if (cuc instanceof com.tencent.mm.plugin.sns.ui.a.a) {
            avVar = (av) ((com.tencent.mm.plugin.sns.ui.a.a) cuc).rEB.get(baseViewHolder.position);
        } else {
            avVar = null;
        }
        int i2 = 0;
        if (this.DEBUG) {
            ab.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + baseViewHolder.position + " commentCount: " + size);
        }
        i = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i4 >= bVar.size()) {
                return true;
            }
            View ctY;
            Object obj;
            View view;
            Object obj2;
            View view2;
            com.tencent.mm.vending.j.a aVar = (com.tencent.mm.vending.j.a) bVar.get(i4);
            long longValue = ((Long) aVar.get(0)).longValue();
            String str = (String) aVar.get(1);
            String str2 = (String) aVar.get(2);
            String str3 = (String) aVar.get(3);
            CharSequence charSequence = (CharSequence) aVar.get(4);
            cat cat = (cat) list.get(i4);
            int i5 = cat.wZL;
            com.tencent.mm.plugin.sns.model.ap.b aq = aq(baseViewHolder.cFc, longValue);
            if (aq != null && aq.aAR) {
                ap.da(aq.id, 2);
            }
            if (i3 >= childCount) {
                if (aq == null || aq.aAR) {
                    ctY = this.qPr.ctY();
                    ((SnsCommentCollapseLayout) ctY).setTextSize$255e752(15.0f * com.tencent.mm.bz.a.dm(ctY.getContext()));
                    if (this.qPr.rxT == -1) {
                        this.qPr.rxT = this.mActivity.getResources().getColor(R.color.a0d);
                    }
                    ((SnsCommentCollapseLayout) ctY).setTextColor(this.qPr.rxT);
                    ((SnsCommentCollapseLayout) ctY).setGravity(16);
                } else {
                    ctY = new TranslateCommentTextView(this.mActivity);
                    ((TranslateCommentTextView) ctY).getTranslateResultView().setResultTextSize$255e752(15.0f * com.tencent.mm.bz.a.dm(ctY.getContext()));
                    ((TranslateCommentTextView) ctY).getOriginCommentTextView().setTextSize(1, 15.0f * com.tencent.mm.bz.a.dm(ctY.getContext()));
                }
                obj = 1;
                view = ctY;
            } else {
                view = linearLayout.getChildAt(i3);
                obj = null;
            }
            if (aq != null) {
                if (!(view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    ctY = new TranslateCommentTextView(this.mActivity);
                    linearLayout.addView(ctY, i3);
                    ((TranslateCommentTextView) ctY).getTranslateResultView().setResultTextSize$255e752(15.0f * com.tencent.mm.bz.a.dm(ctY.getContext()));
                    ((TranslateCommentTextView) ctY).getOriginCommentTextView().setTextSize(1, 15.0f * com.tencent.mm.bz.a.dm(ctY.getContext()));
                    view = ctY;
                }
                TranslateCommentTextView translateCommentTextView = (TranslateCommentTextView) view;
                view.setOnTouchListener(null);
                a(translateCommentTextView.getOriginCommentTextView(), charSequence, i5);
                if (!aq.foa) {
                    translateCommentTextView.rDZ.setTextSize(1, 15.0f * com.tencent.mm.bz.a.dm(translateCommentTextView.getContext()));
                    translateCommentTextView.rrm.El(2);
                    translateCommentTextView.rrm.setVisibility(0);
                    obj2 = 1;
                    view2 = view;
                } else if (aq.aAR) {
                    translateCommentTextView.getTranslateResultView().setVisibility(8);
                    i2 = 1;
                    view2 = view;
                } else {
                    String str4 = aq.result;
                    String str5 = aq.fwM;
                    String charSequence2 = translateCommentTextView.rDZ.getText().toString();
                    if (!bo.isNullOrNil(charSequence2)) {
                        String[] strArr;
                        String[] split = charSequence2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (split.length > 2) {
                            strArr = new String[]{split[0], charSequence2.substring(r2[0].length() + 1)};
                        } else {
                            strArr = split;
                        }
                        if (strArr.length == 2) {
                            if (bo.isNullOrNil(str4)) {
                                translateCommentTextView.rrm.a(aq, 2, null, str5, aq.qMU);
                            } else {
                                translateCommentTextView.rrm.a(aq, 2, strArr[0] + ": " + str4, str5, aq.qMU);
                            }
                            translateCommentTextView.rrm.setVisibility(0);
                        }
                        translateCommentTextView.rDZ.setTextSize(1, 15.0f * com.tencent.mm.bz.a.dm(translateCommentTextView.getContext()));
                    }
                    i2 = 1;
                    view2 = view;
                }
            } else {
                View ctY2;
                if (obj == null && (view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    ctY2 = this.qPr.ctY();
                    linearLayout.addView(ctY2, i3);
                    ((SnsCommentCollapseLayout) ctY2).setTextSize$255e752(15.0f * com.tencent.mm.bz.a.dm(ctY2.getContext()));
                } else {
                    ctY2 = view;
                }
                if (ctY2 instanceof SnsCommentCollapseLayout) {
                    ((SnsCommentCollapseLayout) ctY2).setTextSize$255e752(15.0f * com.tencent.mm.bz.a.dm(ctY2.getContext()));
                    ((SnsCommentCollapseLayout) ctY2).setOpClickListener(this.qPr.rya);
                    ((SnsCommentCollapseLayout) ctY2).setPressTouchListener(new m(this.mActivity));
                }
                a(ctY2, charSequence, i5);
                obj2 = null;
                view2 = ctY2;
            }
            view2.setBackgroundResource(R.drawable.a1n);
            if (i3 > 0) {
                if (obj2 != null) {
                    view2.setPadding(0, com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 7));
                } else {
                    view2.setPadding(0, com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 3));
                }
            } else if (obj2 != null) {
                view2.setPadding(0, 1, 0, com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 7));
            } else {
                view2.setPadding(0, 1, 0, com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 3));
            }
            if (obj2 != null) {
                i = (int) this.mActivity.getResources().getDimension(R.dimen.nc);
                ((TranslateCommentTextView) view2).rrm.getSplitlineView().setPadding(0, 0, i, 0);
            }
            view2.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    int[] iArr;
                    AppMethodBeat.i(40120);
                    int[] iArr2 = new int[2];
                    if (view.getTag(R.id.cy) instanceof int[]) {
                        iArr = (int[]) view.getTag(R.id.cy);
                    } else {
                        iArr = iArr2;
                    }
                    BaseTimeLineItem.this.qPr.jMO.a(view2, BaseTimeLineItem.this.qPr.qOL.rJU, BaseTimeLineItem.this.qPr.qOL.rJH, iArr[0], iArr[1]);
                    AppMethodBeat.o(40120);
                    return true;
                }
            });
            view2.setOnClickListener(new com.tencent.mm.plugin.sns.ui.i.a(cat, str2, str3, baseViewHolder));
            if (avVar != null) {
                view2.setTag(new l(avVar.riA, avVar.rAs, cat, str, str3, view2, 1));
            }
            if (obj != null) {
                linearLayout.addView(view2);
            }
            i2 = i3 + 1;
            i = i4 + 1;
        }
    }

    private static void a(View view, CharSequence charSequence, int i) {
        if (view instanceof SnsCommentCollapseLayout) {
            ((SnsCommentCollapseLayout) view).k(charSequence, i);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
    }

    private com.tencent.mm.plugin.sns.model.ap.b aq(String str, long j) {
        if (this.rHq.size() <= 0) {
            return null;
        }
        Iterator it = this.rHq.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.sns.model.ap.b bVar = (com.tencent.mm.plugin.sns.model.ap.b) it.next();
            if (bVar.id != null && bVar.id.equals(ap.ga(str, String.valueOf(j)))) {
                return bVar;
            }
        }
        return null;
    }
}
