package com.tencent.p177mm.plugin.sns.p520ui.item;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.p613a.C5216a;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.p613a.C5217b;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.plugin.sns.abtest.C21865a;
import com.tencent.p177mm.plugin.sns.abtest.C34932c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C34935b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.sns.p516g.C21884c;
import com.tencent.p177mm.plugin.sns.p517i.C43548b;
import com.tencent.p177mm.plugin.sns.p520ui.AsyncNormalTextView;
import com.tencent.p177mm.plugin.sns.p520ui.AsyncTextView;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C29201az;
import com.tencent.p177mm.plugin.sns.p520ui.C29220i.C29224a;
import com.tencent.p177mm.plugin.sns.p520ui.C39828ar;
import com.tencent.p177mm.plugin.sns.p520ui.C4052bb;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.C43612w;
import com.tencent.p177mm.plugin.sns.p520ui.C46247aa;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au.C29195b;
import com.tencent.p177mm.plugin.sns.p520ui.C46922l;
import com.tencent.p177mm.plugin.sns.p520ui.MaskTextView;
import com.tencent.p177mm.plugin.sns.p520ui.PhotosContent;
import com.tencent.p177mm.plugin.sns.p520ui.SnsTranslateResultView;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.p520ui.TranslateCommentTextView;
import com.tencent.p177mm.plugin.sns.p520ui.p1027a.C29169a;
import com.tencent.p177mm.plugin.sns.p520ui.p1413e.C29210a;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C7134g;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsAvatarImageView;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsCommentCollapseLayout;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C35169f.C35170a;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o.C24945a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vending.p638d.C5683b;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem */
public abstract class BaseTimeLineItem {
    public boolean DEBUG = false;
    protected int klY;
    protected Activity mActivity;
    protected C46251au qPr;
    public ArrayList<C13414b> rHq = new ArrayList();
    protected boolean rps = false;

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$a */
    class C13683a extends C24944o {
        C13683a() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40121);
            BaseTimeLineItem.this.qPr.rqg.rDC.onClick(view);
            AppMethodBeat.m2505o(40121);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(40122);
            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(C25738R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.m2505o(40122);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.m2505o(40122);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$5 */
    class C314185 implements C24945a {
        C314185() {
        }

        /* renamed from: a */
        public final void mo25466a(View view, Object obj) {
            AppMethodBeat.m2504i(40119);
            if (BaseTimeLineItem.this.qPr.rqd != null) {
                BaseTimeLineItem.this.qPr.rqd.cvd = 13;
                BaseTimeLineItem.this.qPr.rqd.mo25466a(view, obj);
            }
            AppMethodBeat.m2505o(40119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$1 */
    class C351241 implements OnTouchListener {
        C351241() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(40115);
            if (motionEvent.getAction() == 0) {
                view.setTag(2131820679, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
            }
            AppMethodBeat.m2505o(40115);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder */
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
        public C4052bb qFH;
        public TextView qHh;
        public C43589aj rGD = new C43589aj();
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
        public C7486a rIs;
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
            AppMethodBeat.m2504i(40125);
            AppMethodBeat.m2505o(40125);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$b */
    class C39846b extends C24944o {
        C39846b() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40123);
            BaseTimeLineItem.this.qPr.rqg.rDs.onClick(view);
            AppMethodBeat.m2505o(40123);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(40124);
            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(C25738R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.m2505o(40124);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.m2505o(40124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$c */
    class C39847c extends C24944o {
        C39847c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40126);
            BaseTimeLineItem.this.qPr.rqg.rDt.onClick(view);
            AppMethodBeat.m2505o(40126);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(40127);
            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(C25738R.color.a0j);
            if (this.ozq) {
                textPaint.bgColor = color;
                AppMethodBeat.m2505o(40127);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.m2505o(40127);
        }
    }

    /* renamed from: a */
    public abstract void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au);

    /* renamed from: d */
    public abstract void mo8945d(BaseViewHolder baseViewHolder);

    public final void setIsFromMainTimeline(boolean z) {
        this.rps = z;
    }

    /* renamed from: a */
    private static void m68241a(BaseViewHolder baseViewHolder, C46236n c46236n) {
        LayoutParams layoutParams;
        if (c46236n.mo74253DI(32)) {
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

    /* renamed from: a */
    public final View mo63037a(Activity activity, BaseViewHolder baseViewHolder, int i, C46251au c46251au, C46236n c46236n) {
        String str;
        this.mActivity = activity;
        this.klY = i;
        this.qPr = c46251au;
        baseViewHolder.cFc = c46236n.cqA();
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
        View a = C1742b.m3596SM().mo5274a(this.mActivity, str, 2130970820);
        baseViewHolder.rIA = str;
        View findViewById = a.findViewById(2131827717);
        if (findViewById instanceof ViewStub) {
            baseViewHolder.rHC = (ViewStub) findViewById;
        } else {
            baseViewHolder.rHC = null;
        }
        C4990ab.m7416i("MicroMsg.BaseTimeLineItem", "create new item  " + i + "  " + a.hashCode());
        baseViewHolder.rIt = a.findViewById(2131827903);
        baseViewHolder.klY = i;
        baseViewHolder.rHv = (SnsAvatarImageView) a.findViewById(2131827708);
        baseViewHolder.rHv.setWeakContext(activity);
        baseViewHolder.rHv.setOnClickListener(c46251au.qOL.rJI);
        baseViewHolder.rHv.setOnLongClickListener(c46251au.qOL.rJJ);
        baseViewHolder.rHv.setOnTouchListener(new C351241());
        baseViewHolder.rHw = (AsyncTextView) a.findViewById(2131823149);
        baseViewHolder.rHx = (ImageView) a.findViewById(2131827711);
        baseViewHolder.rHw.setOnTouchListener(new C46247aa());
        baseViewHolder.rHy = (ViewGroup) a.findViewById(2131827904);
        baseViewHolder.rHz = (AsyncNormalTextView) a.findViewById(2131827906);
        baseViewHolder.rHz.setOpClickListener(c46251au.rxZ);
        baseViewHolder.rHB = (LinearLayout) a.findViewById(2131827716);
        baseViewHolder.rHB.setTag(baseViewHolder);
        baseViewHolder.rHB.setOnClickListener(c46251au.qOL.rKn);
        c46251au.jMO.mo39887c(a.findViewById(2131820991), c46251au.qOL.rJK, c46251au.qOL.rJH);
        c46251au.jMO.mo39887c((TextView) a.findViewById(2131822812), c46251au.qOL.rJK, c46251au.qOL.rJH);
        baseViewHolder.rHA = (SnsTranslateResultView) a.findViewById(2131827715);
        baseViewHolder.rHA.setVisibility(8);
        baseViewHolder.rHA.getSplitlineView().setPadding(0, 0, (int) this.mActivity.getResources().getDimension(C25738R.dimen.f10011nc), 0);
        baseViewHolder.rHA.getResultTextView().setBackgroundResource(C25738R.drawable.a0t);
        c46251au.jMO.mo39887c(baseViewHolder.rHA.getResultTextView(), c46251au.qOL.rJK, c46251au.qOL.rJH);
        baseViewHolder.rHS = (LinearLayout) a.findViewById(2131827758);
        baseViewHolder.rHI = (TextView) a.findViewById(2131827719);
        baseViewHolder.timeTv = (TextView) a.findViewById(2131827720);
        baseViewHolder.rHJ = (AsyncTextView) a.findViewById(2131827721);
        baseViewHolder.rHK = (AsyncTextView) a.findViewById(2131827722);
        baseViewHolder.rvM = (TextView) a.findViewById(2131827718);
        baseViewHolder.qFH = new C4052bb(a);
        baseViewHolder.qFH.mo8917a(c46251au.qOL.rJS, c46251au.qOL.rKg);
        baseViewHolder.rjj = (TextView) a.findViewById(2131827726);
        baseViewHolder.rjj.setText(activity.getString(C25738R.string.f9088p4));
        baseViewHolder.rjj.setOnClickListener(c46251au.qOL.rJM);
        baseViewHolder.rHJ.setOnClickListener(c46251au.qOL.rKh);
        baseViewHolder.rHK.setOnClickListener(c46251au.qOL.rKi);
        baseViewHolder.rvM.setOnClickListener(c46251au.qOL.rKd);
        baseViewHolder.rHL = a.findViewById(2131827723);
        baseViewHolder.rHL.setOnClickListener(c46251au.qOL.rJR);
        baseViewHolder.kPs = (TextView) a.findViewById(2131827724);
        baseViewHolder.rHM = (ImageView) a.findViewById(2131827709);
        baseViewHolder.rHV = (ViewStub) a.findViewById(2131827911);
        baseViewHolder.rgx = (LinearLayout) a.findViewById(2131827888);
        baseViewHolder.rIv = (ViewStub) a.findViewById(2131827910);
        baseViewHolder.rHX = (ViewStub) a.findViewById(2131827913);
        baseViewHolder.rHE = (TextView) a.findViewById(2131827908);
        baseViewHolder.rHE.setOnClickListener(c46251au.qOL.rJN);
        baseViewHolder.rIz = (TextView) a.findViewById(2131827725);
        baseViewHolder.mRR = a;
        if (this.rps) {
            C34932c.m57347b(a, baseViewHolder);
            C21865a.m33412a(a, baseViewHolder);
            C13373af.cnw();
            C21884c.m33446c(a, baseViewHolder);
        }
        mo8945d(baseViewHolder);
        a.setTag(baseViewHolder);
        BaseTimeLineItem.m68241a(baseViewHolder, c46236n);
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
    /* renamed from: a */
    public final void mo63039a(final BaseViewHolder baseViewHolder, int i, C46236n c46236n, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        String cqU;
        String gj;
        String str;
        CharSequence charSequence;
        C5216a dzk;
        View view;
        AsyncTextView asyncTextView;
        TextView textView;
        String content;
        TextView textView2;
        boolean z;
        C13633av c13633av = (C13633av) c46251au.cuc().crQ().get(Integer.valueOf(i));
        BaseTimeLineItem.m68241a(baseViewHolder, c46236n);
        this.klY = i2;
        this.qPr = c46251au;
        if (this.rps) {
            C29169a.m46336F(c46236n);
        }
        C29169a.m46341d(timeLineObject);
        if (c46236n.mo74253DI(32)) {
            C4990ab.m7416i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + C29036i.m46118jW(c46236n.field_snsId) + " for susan");
        }
        baseViewHolder.rHt = c13633av.rAt;
        baseViewHolder.mVC = false;
        baseViewHolder.position = i;
        baseViewHolder.cFc = c13633av.rAs;
        baseViewHolder.cwT = c13633av.riA;
        baseViewHolder.rHu = c13633av.rAx;
        baseViewHolder.rHM.setOnClickListener(c46251au.rxY);
        baseViewHolder.timeLineObject = timeLineObject;
        cbf cbf = c13633av.qBX;
        baseViewHolder.qCX = cbf;
        C43548b c43548b = c46251au.rxP.rhn.qMn;
        if (c46236n != null) {
            cqU = c46236n.cqU();
            c43548b.qSA.add(cqU);
            if (c46236n.mo74253DI(32)) {
                c43548b.qSF.add(cqU);
            }
            c43548b.qSG.add(c46236n.field_userName);
            switch (c46236n.field_type) {
                case 1:
                    c43548b.qSC.add(cqU);
                    break;
                case 2:
                    c43548b.qSB.add(cqU);
                    break;
                case 3:
                    if (!C5046bo.isNullOrNil(timeLineObject.xfJ)) {
                        c43548b.qSH.add(cqU);
                        break;
                    } else {
                        c43548b.qSI.add(cqU);
                        break;
                    }
                case 4:
                    c43548b.qSE.add(cqU);
                    break;
                case 5:
                    c43548b.qSJ.add(cqU);
                    break;
                case 15:
                    c43548b.qSD.add(cqU);
                    break;
                case 18:
                    c43548b.qSK.add(cqU);
                    break;
                default:
                    c43548b.qSL.add(cqU);
                    break;
            }
            if (i < c43548b.qSy) {
                c43548b.qSy = i;
                c43548b.qRd = C29036i.m46115j(c46236n);
            }
            if (i > c43548b.qSz) {
                c43548b.qSz = i;
                c43548b.qRe = C29036i.m46115j(c46236n);
            }
            c43548b.qRj = c43548b.qSB.size();
            c43548b.qRk = c43548b.qSC.size();
            c43548b.qRl = c43548b.qSD.size();
            c43548b.qRn = c43548b.qSE.size();
            c43548b.qRm = c43548b.qSF.size();
            c43548b.qRo = c43548b.qSJ.size();
            c43548b.qRw = c43548b.qSK.size();
            c43548b.jLU = c43548b.qSG.size();
            c43548b.qRh = c43548b.qSH.size();
            c43548b.qRi = c43548b.qSI.size();
            c43548b.qRv = c43548b.qSL.size();
            c43548b.qQR = c43548b.qSA.size();
        }
        C21984b cqo = c46236n.cqo();
        cqU = c13633av.igi;
        if (!C5046bo.isNullOrNil(cqU)) {
            baseViewHolder.rIs = c13633av.rAr;
            baseViewHolder.rHv.setTag(cqU);
            final C46251au c46251au2;
            if (cqo == null || !cqo.qVa) {
                if (cqU.endsWith("@ad")) {
                    baseViewHolder.rHv.setImageResource(C25738R.drawable.ad2);
                    baseViewHolder.rHv.mo55778dk(cqU, 4);
                    baseViewHolder.rHv.setShowStoryHint(false);
                } else {
                    if (c13633av.rAI) {
                        C4990ab.m7417i("MicroMsg.BaseTimeLineItem", "getContact %s", cqU);
                        if (C40460b.diS().mo8229AZ() != null) {
                            baseViewHolder.rHv.setImageBitmap(C40460b.diS().mo8229AZ());
                        }
                        C26417a.flu.mo20966a(cqU, "", new C29195b(c46251au.cuc(), i));
                    } else {
                        C40460b.m69434b(baseViewHolder.rHv, cqU);
                    }
                    if (c13633av.rAJ) {
                        baseViewHolder.rHv.mo55778dk(cqU, 4);
                        baseViewHolder.rHv.setShowStoryHint(false);
                    } else {
                        C29210a.m46386b(4, (String) baseViewHolder.rHv.getTag(), baseViewHolder.rHv);
                        baseViewHolder.rHv.mo55778dk(cqU, 4);
                        baseViewHolder.rHv.setTag(cqU);
                        C29210a.m46385a(4, cqU, baseViewHolder.rHv);
                        baseViewHolder.rHv.setShowStoryHint(((C35168e) C1720g.m3530M(C35168e.class)).hasNewStory(cqU));
                    }
                }
                c46251au2 = c46251au;
                baseViewHolder.rHw.mo47236a(cqU, c13633av.rAH, new C24945a() {
                    /* renamed from: a */
                    public final void mo25466a(View view, Object obj) {
                        AppMethodBeat.m2504i(40118);
                        if (c46251au2.rqd != null) {
                            c46251au2.rqd.cvd = 6;
                            c46251au2.rqd.mo25466a(view, obj);
                        }
                        AppMethodBeat.m2505o(40118);
                    }
                }, c13633av.rgZ, c13633av.riA, i2, c13633av.rgZ);
            } else {
                baseViewHolder.rHv.setImageResource(C25738R.drawable.ad2);
                baseViewHolder.rHv.mo55778dk(cqU, 4);
                baseViewHolder.rHv.setShowStoryHint(false);
                if (!C5046bo.isNullOrNil(cqo.qVc)) {
                    gj = C13473h.m21625gj("adId", cqo.qVc);
                    baseViewHolder.rHv.setTag(2131820666, cqo.qVc);
                    if (C5730e.m8628ct(gj)) {
                        Bitmap decodeFile = C5056d.decodeFile(gj, null);
                        if (decodeFile != null) {
                            baseViewHolder.rHv.setImageBitmap(C5056d.m7616a(decodeFile, true, 0.1f * ((float) decodeFile.getWidth())));
                        }
                    } else {
                        C13473h.m21620a(cqo.qVc, new C3951a() {
                            public final void cpu() {
                            }

                            public final void cmD() {
                            }

                            /* renamed from: YJ */
                            public final void mo8627YJ(String str) {
                                AppMethodBeat.m2504i(40116);
                                C4990ab.m7417i("MicroMsg.BaseTimeLineItem", "download img %s", str);
                                if (!C5046bo.m7510Q((String) baseViewHolder.rHv.getTag(2131820666), str) && str.equals(C13473h.m21625gj("adId", (String) baseViewHolder.rHv.getTag(2131820666)))) {
                                    Bitmap decodeFile = C5056d.decodeFile(str, null);
                                    if (decodeFile != null) {
                                        baseViewHolder.rHv.setImageBitmap(C5056d.m7616a(decodeFile, true, 0.1f * ((float) decodeFile.getWidth())));
                                    }
                                }
                                AppMethodBeat.m2505o(40116);
                            }
                        });
                    }
                }
                c46251au2 = c46251au;
                baseViewHolder.rHw.mo47236a(cqU, c13633av.rAH, new C24945a() {
                    /* renamed from: a */
                    public final void mo25466a(View view, Object obj) {
                        AppMethodBeat.m2504i(40117);
                        if (c46251au2.rqd != null) {
                            c46251au2.rqd.cvd = 0;
                            c46251au2.rqd.mo25466a(view, obj);
                        }
                        AppMethodBeat.m2505o(40117);
                    }
                }, c13633av.rgZ, c13633av.riA, i2, c13633av.rgZ);
            }
            baseViewHolder.rHv.eSe = c13633av.riA;
        }
        baseViewHolder.rHx.setVisibility(8);
        if (c13633av.rgZ) {
            baseViewHolder.qFG = true;
            baseViewHolder.mVC = c13633av.rAy;
        } else {
            baseViewHolder.qFG = false;
        }
        if (((C35168e) C1720g.m3530M(C35168e.class)).hasNewStory(cqU)) {
            c13633av.rAq = null;
        }
        baseViewHolder.rHz.mo37539a(c13633av.rAu, c46251au, c13633av.rAv, c13633av);
        baseViewHolder.rHz.setShow(baseViewHolder);
        baseViewHolder.kPs.setOnTouchListener(new C46247aa());
        mo8944a(baseViewHolder, i, c13633av, timeLineObject, i2, c46251au);
        c46251au.rxR.put(Integer.valueOf(i), new WeakReference(baseViewHolder.mRR));
        if (baseViewHolder.mRR.getBackground() == null) {
            baseViewHolder.mRR.setBackgroundResource(C25738R.drawable.f6623k5);
            int fromDPToPix = C1338a.fromDPToPix(this.mActivity, 12);
            baseViewHolder.mRR.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, C1338a.fromDPToPix(this.mActivity, 8));
        }
        baseViewHolder.timeTv.setText(c13633av.rAA);
        baseViewHolder.rHJ.setVisibility(8);
        baseViewHolder.rHK.setVisibility(8);
        if (c13633av.rgZ) {
            C21980a c21980a = c13633av.rAB;
            baseViewHolder.rHJ.setTag(c13633av.riA);
            if (c13633av.rAB.qTF == C21980a.qTr) {
                if (C5046bo.isNullOrNil(c13633av.rAE)) {
                    baseViewHolder.rHJ.setVisibility(8);
                } else {
                    baseViewHolder.rHJ.setText(c13633av.rAE);
                    baseViewHolder.rHJ.setVisibility(0);
                }
            } else if (c21980a.qTF == C21980a.qTs) {
                if (C5046bo.isNullOrNil(c13633av.rAF)) {
                    baseViewHolder.rHJ.setVisibility(8);
                } else {
                    str = c13633av.rAG;
                    gj = c13633av.rAF;
                    Activity activity = this.mActivity;
                    baseViewHolder.rHJ.getTextSize();
                    C44090k c44090k = new C44090k(C44089j.m79298c(activity, gj, 1));
                    c44090k.mo69792a(null, gj, 0);
                    TextPaint paint = baseViewHolder.rHJ.getPaint();
                    if (C1338a.m2859ao(this.mActivity, (int) Layout.getDesiredWidth(c44090k, 0, c44090k.length(), paint)) > baseViewHolder.rql) {
                        while (str.length() > 1) {
                            str = str.substring(0, str.length() - 2);
                            String format = String.format(c21980a.qTG, new Object[]{str + "..."});
                            Activity activity2 = this.mActivity;
                            baseViewHolder.rHJ.getTextSize();
                            C44090k c44090k2 = new C44090k(C44089j.m79298c(activity2, format, 1));
                            c44090k2.mo69792a(null, format, 0);
                            int ao = C1338a.m2859ao(this.mActivity, (int) Layout.getDesiredWidth(c44090k2, 0, c44090k2.length(), paint));
                            baseViewHolder.rHJ.setText(c44090k2, BufferType.SPANNABLE);
                            baseViewHolder.rHJ.setVisibility(0);
                            if (ao <= baseViewHolder.rql) {
                            }
                        }
                    } else {
                        baseViewHolder.rHJ.setText(c44090k, BufferType.SPANNABLE);
                        baseViewHolder.rHJ.setVisibility(0);
                    }
                }
            }
            if (baseViewHolder.rHJ.getVisibility() != 8 && C5046bo.isNullOrNil(c21980a.qTH)) {
                baseViewHolder.rHJ.setTextColor(this.mActivity.getResources().getColor(C25738R.color.a1a));
                baseViewHolder.rHJ.setOnClickListener(null);
            }
            if ((c46236n.cqu().xfI.wbL & 4) != 0) {
                baseViewHolder.rHK.setTag(baseViewHolder);
                baseViewHolder.rHK.setVisibility(0);
                baseViewHolder.rHK.setText(String.format("%s%s%s", new Object[]{this.mActivity.getResources().getString(C25738R.string.eiu), c13633av.rAH, this.mActivity.getResources().getString(C25738R.string.eiv)}));
            } else {
                baseViewHolder.rHK.setVisibility(8);
            }
        }
        if (c13633av.rAK) {
            baseViewHolder.rIz.setText(c46251au.crP.getString(C25738R.string.ctw, new Object[]{Integer.valueOf(c13633av.rAL)}));
            baseViewHolder.rIz.setVisibility(0);
        } else {
            baseViewHolder.rIz.setVisibility(8);
        }
        baseViewHolder.rvM.setTag(c13633av.riA);
        if (C5046bo.isNullOrNil(c13633av.rAN)) {
            baseViewHolder.rvM.setVisibility(8);
        } else {
            baseViewHolder.rvM.setVisibility(0);
            baseViewHolder.rvM.setText(c13633av.rAN);
            baseViewHolder.rvM.setClickable(c13633av.rAO);
            baseViewHolder.rvM.setTextColor(c13633av.rAO ? -11048043 : -9211021);
        }
        baseViewHolder.kPs.setTextColor(this.mActivity.getResources().getColor(C25738R.color.a0k));
        if (c13633av.rAP) {
            baseViewHolder.kPs.setVisibility(0);
            charSequence = this.mActivity.getString(C25738R.string.ejz) + c13633av.mAppName;
            if (charSequence.length() > 10) {
                charSequence = charSequence.substring(0, 10) + "...";
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new C39846b(), 0, spannableString.length(), 33);
            baseViewHolder.kPs.setText(spannableString, BufferType.SPANNABLE);
            if (!(c13633av.rAR || "wx7fa037cc7dfabad5".equals(timeLineObject.xfH.f17242Id))) {
                baseViewHolder.kPs.setTextColor(this.mActivity.getResources().getColor(C25738R.color.a1a));
                baseViewHolder.kPs.setOnTouchListener(null);
            }
            baseViewHolder.kPs.setTag(timeLineObject);
        } else if (c13633av.rAQ) {
            baseViewHolder.kPs.setVisibility(0);
            SpannableString spannableString2 = new SpannableString(c13633av.rAT);
            spannableString2.setSpan(new C39847c(), 0, spannableString2.length(), 33);
            baseViewHolder.kPs.setText(spannableString2, BufferType.SPANNABLE);
            baseViewHolder.kPs.setTag(new C29201az(c13633av.rAS, c13633av.rAT));
        } else if (c13633av.rAU) {
            baseViewHolder.kPs.setVisibility(0);
            str = this.mActivity.getString(C25738R.string.f8840gq);
            cqU = str + c13633av.mAppName;
            SpannableString spannableString3 = new SpannableString(cqU);
            spannableString3.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(C25738R.color.a1a)), 0, str.length(), 33);
            spannableString3.setSpan(new C13683a(), str.length(), cqU.length(), 33);
            baseViewHolder.kPs.setText(spannableString3, BufferType.SPANNABLE);
            if (!(c13633av.rAR || "wx7fa037cc7dfabad5".equals(timeLineObject.xfH.f17242Id))) {
                baseViewHolder.kPs.setTextColor(this.mActivity.getResources().getColor(C25738R.color.a1a));
                baseViewHolder.kPs.setOnTouchListener(null);
            }
            baseViewHolder.kPs.setTag(timeLineObject);
        } else {
            baseViewHolder.kPs.setVisibility(8);
        }
        if (c13633av.rAJ) {
            baseViewHolder.rjj.setVisibility(0);
            baseViewHolder.rjj.setTag(c13633av.riA);
        } else {
            baseViewHolder.rjj.setVisibility(8);
        }
        baseViewHolder.rHM.setTag(baseViewHolder);
        if (c13633av.rAV) {
            if (!baseViewHolder.rIb) {
                baseViewHolder.rHQ = (LinearLayout) baseViewHolder.rHX.inflate();
                baseViewHolder.rHR = baseViewHolder.mRR.findViewById(2131827834);
                baseViewHolder.rIb = true;
                baseViewHolder.rHR.setTag(c13633av.riA);
                baseViewHolder.raQ = (TextView) baseViewHolder.rHQ.findViewById(2131827834);
            }
            baseViewHolder.rHX.setVisibility(0);
            baseViewHolder.rHR.setOnClickListener(c46251au.qOL.rJQ);
            switch (c13633av.rAW) {
                case 201:
                    baseViewHolder.raQ.setText(C25738R.string.enn);
                    baseViewHolder.rHR.setClickable(false);
                    baseViewHolder.rHR.setEnabled(false);
                    break;
                case 210:
                    baseViewHolder.raQ.setText(C25738R.string.enp);
                    baseViewHolder.rHR.setClickable(false);
                    baseViewHolder.rHR.setEnabled(false);
                    break;
                case 211:
                    baseViewHolder.raQ.setText(C25738R.string.eno);
                    baseViewHolder.rHR.setClickable(true);
                    baseViewHolder.rHR.setEnabled(true);
                    break;
                default:
                    baseViewHolder.raQ.setText(C25738R.string.enq);
                    baseViewHolder.rHR.setClickable(true);
                    baseViewHolder.rHR.setEnabled(true);
                    break;
            }
            bav cqM = c46236n.cqM();
            if (!(cqM == null || C5046bo.isNullOrNil(cqM.wFu))) {
                baseViewHolder.raQ.setText(cqM.wFu);
            }
        } else if (baseViewHolder.rIb) {
            baseViewHolder.rHX.setVisibility(8);
        }
        if (c13633av.rAX) {
            baseViewHolder.rHL.setVisibility(0);
            baseViewHolder.rHL.setTag(c13633av.riA);
        } else {
            baseViewHolder.rHL.setVisibility(8);
        }
        if (c13633av.rAY) {
            if (!C5046bo.isNullOrNil(c13633av.rAZ)) {
                baseViewHolder.rHI.setVisibility(0);
                if (i2 == 7) {
                    charSequence = String.format(this.mActivity.getString(C25738R.string.eq1), new Object[]{c13633av.rAZ});
                } else {
                    charSequence = String.format(this.mActivity.getString(C25738R.string.eq2), new Object[]{c13633av.rAZ});
                }
                baseViewHolder.rHI.setText(C44089j.m79293b(this.mActivity, charSequence, baseViewHolder.rHI.getTextSize()));
            } else if (c13633av.rBa) {
                baseViewHolder.rHI.setVisibility(0);
                baseViewHolder.rHI.setText(C44089j.m79293b(this.mActivity, this.mActivity.getString(C25738R.string.eq3).toString(), baseViewHolder.rHI.getTextSize()));
            }
            if (!c13633av.rBb) {
                if (baseViewHolder.rIw == null) {
                    baseViewHolder.rIw = baseViewHolder.rIv.inflate();
                    baseViewHolder.qHh = (TextView) baseViewHolder.rIw.findViewById(2131825679);
                    baseViewHolder.rIx = (MaskTextView) baseViewHolder.rIw.findViewById(2131825681);
                    baseViewHolder.rIx.setOnTouchListener(new C46247aa());
                }
                baseViewHolder.rIw.setVisibility(0);
                m68245b(baseViewHolder.rIx, c13633av.rBe, i2);
                baseViewHolder.qHh.setText(this.mActivity.getString(C25738R.string.emn, new Object[]{Integer.valueOf(c13633av.rBc), C5046bo.m7501F(c13633av.rBd / 100.0d)}));
                baseViewHolder.rIw.setTag(c46236n);
                baseViewHolder.rIw.setOnClickListener(c46251au.qOL.rJT);
            } else if (baseViewHolder.rIw != null) {
                baseViewHolder.rIw.setVisibility(8);
            }
            if ((c13633av.rBf == null && c13633av.rBf.size() != 0) || (c13633av.rBg != null && c13633av.rBg.size() != 0)) {
                if (!baseViewHolder.rHW) {
                    if (baseViewHolder.rgx != null || baseViewHolder.rHV.getParent() == null) {
                        cqU = "MicroMsg.BaseTimeLineItem";
                        gj = "holder.listKeeper = null %s,and holder.commentStub.inflated";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(baseViewHolder.rgx == null);
                        C4990ab.m7413e(cqU, gj, objArr);
                    } else {
                        baseViewHolder.rgx = (LinearLayout) baseViewHolder.rHV.inflate();
                    }
                    if (baseViewHolder.rgx != null) {
                        baseViewHolder.rHO = (MaskTextView) baseViewHolder.rgx.findViewById(2131827889);
                        baseViewHolder.rHO.setOnTouchListener(new C46247aa());
                        baseViewHolder.rHP = (LinearLayout) baseViewHolder.mRR.findViewById(2131827891);
                        baseViewHolder.rgx.setTag(c13633av.rAs);
                        baseViewHolder.rHO.setTag(c13633av.rAs);
                        baseViewHolder.rHU = baseViewHolder.rgx.findViewById(2131827890);
                        baseViewHolder.rIy = baseViewHolder.rgx.findViewById(2131827888);
                        baseViewHolder.rHW = true;
                    }
                }
                if (baseViewHolder.rgx != null) {
                    baseViewHolder.rgx.setVisibility(0);
                }
                if (c13633av.rBf == null || c13633av.rBf.size() <= 0) {
                    baseViewHolder.rHO.setVisibility(8);
                } else {
                    baseViewHolder.rHO.setVisibility(0);
                    m68242a(baseViewHolder.rHO, c13633av.rBf, i2);
                }
                if (c13633av.rBg != null) {
                    m68243a(cbf.xat, c13633av.rBg, baseViewHolder);
                } else {
                    baseViewHolder.rHP.setVisibility(8);
                }
                if (c13633av.rBf == null || c13633av.rBf.size() == 0 || c13633av.rBg == null || c13633av.rBg.size() == 0) {
                    baseViewHolder.rHU.setVisibility(8);
                } else {
                    baseViewHolder.rHU.setVisibility(0);
                }
            } else if (baseViewHolder.rgx == null) {
                baseViewHolder.rgx.setVisibility(8);
            } else if (baseViewHolder.rHW) {
                baseViewHolder.rHV.setVisibility(8);
            }
            if (c13633av.rBh) {
                baseViewHolder.rHE.setVisibility(8);
            } else {
                baseViewHolder.rHE.setTag(c13633av.riA);
                baseViewHolder.rHE.setText(c13633av.rBi);
                baseViewHolder.rHE.setVisibility(0);
            }
            if (c13633av.rgZ) {
                baseViewHolder.qFH.setVisibility(8);
            } else {
                C4990ab.m7416i("MicroMsg.BaseTimeLineItem", "adatag " + c13633av.rAD);
                baseViewHolder.qFH.mo8922z(Long.valueOf(c13633av.rAt), new C34935b(baseViewHolder.qFH, baseViewHolder.position, c13633av.riA, c13633av.rAt, c13633av.rAz));
                baseViewHolder.qFH.mo8918a(c13633av.rAC, c13633av.rAB);
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
                        layoutParams.setMargins(layoutParams.leftMargin, C4977b.m7371b(this.mActivity, 0.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
                        baseViewHolder.rvM.setLayoutParams(layoutParams);
                    }
                }
            }
            if (this.rps) {
                C13373af.cnw().mo37370a(this.mActivity, cbf, baseViewHolder);
            }
            baseViewHolder.rHA.getResultTextView().setTag(new C39828ar(c13633av.rAs, c13633av.riA, false, true, 1));
            dzk = C5215a.yqY;
            view = baseViewHolder.mRR;
            asyncTextView = baseViewHolder.rHw;
            textView = baseViewHolder.timeTv;
            content = baseViewHolder.rHz.getContent();
            textView2 = baseViewHolder.rHG;
            z = baseViewHolder.rIr;
            if (dzk.dzj() && dzk.f1297Gn != null && view != null && asyncTextView != null && textView != null) {
                C5217b c5217b = new C5217b();
                c5217b.aqI(asyncTextView.getText().toString());
                c5217b.aqI(content);
                if (textView2 != null) {
                    c5217b.aqI(textView2.getText().toString());
                }
                if (z) {
                    c5217b.aqI(dzk.f1297Gn.getString(C25738R.string.b32));
                }
                c5217b.mo10720eD(view);
                return;
            }
            return;
        }
        baseViewHolder.rHI.setVisibility(8);
        if (!c13633av.rBb) {
        }
        if (c13633av.rBf == null) {
        }
        if (baseViewHolder.rgx == null) {
        }
        if (c13633av.rBh) {
        }
        if (c13633av.rgZ) {
        }
        if (this.rps) {
        }
        baseViewHolder.rHA.getResultTextView().setTag(new C39828ar(c13633av.rAs, c13633av.riA, false, true, 1));
        dzk = C5215a.yqY;
        view = baseViewHolder.mRR;
        asyncTextView = baseViewHolder.rHw;
        textView = baseViewHolder.timeTv;
        content = baseViewHolder.rHz.getContent();
        textView2 = baseViewHolder.rHG;
        z = baseViewHolder.rIr;
        if (dzk.dzj()) {
        }
    }

    /* renamed from: a */
    public static void m68240a(C13414b c13414b, BaseViewHolder baseViewHolder, String str, String str2) {
        if (baseViewHolder != null && baseViewHolder.rHA != null) {
            baseViewHolder.rHA.mo62986a(c13414b, 1, str, str2, c13414b.qMU);
            baseViewHolder.rHA.setVisibility(0);
        }
    }

    /* renamed from: e */
    public static void m68246e(BaseViewHolder baseViewHolder) {
        if (baseViewHolder != null && baseViewHolder.rHA != null) {
            baseViewHolder.rHA.mo62985El(1);
            baseViewHolder.rHA.setVisibility(0);
        }
    }

    /* renamed from: f */
    public static void m68247f(BaseViewHolder baseViewHolder) {
        if (baseViewHolder != null && baseViewHolder.rHA != null) {
            baseViewHolder.rHA.setVisibility(8);
        }
    }

    /* renamed from: a */
    private boolean m68242a(MaskTextView maskTextView, C5683b<C5710a> c5683b, int i) {
        int i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[c5683b.size()];
        int[] iArr2 = new int[c5683b.size()];
        Object obj = 1;
        int i3 = 0;
        while (i3 < c5683b.size()) {
            try {
                CharSequence charSequence = (String) ((C5710a) c5683b.get(i3)).get(1);
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
                spannableStringBuilder.append(C44089j.m79293b(this.mActivity, charSequence, maskTextView.getTextSize()));
                if (C39732a.m67943Xt((String) ((C5710a) c5683b.get(i3)).get(0)) && ((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().mo47460a(C35170a.TimeLine_Like) && C46270n.isShowStoryCheck()) {
                    spannableStringBuilder.append("  ");
                    spannableStringBuilder.setSpan(new C7134g(((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69264ls(true)), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                }
                i3++;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", C5046bo.m7574l(e));
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(i == 10 ? C25738R.drawable.f6765ps : C25738R.drawable.f6941w5);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        C5664a c5664a = new C5664a(drawable);
        c5664a.zLT = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) C1338a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(c5664a, length, length + 1, 33);
        if (i == 10) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        for (i3 = 0; i3 < iArr.length; i3++) {
            spannableStringBuilder.setSpan(new C24944o((String) ((C5710a) c5683b.get(i3)).get(0), new C314185(), i2), iArr[i3], iArr2[i3], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.setOriginText(stringBuffer.toString());
        return true;
    }

    /* renamed from: b */
    private void m68245b(MaskTextView maskTextView, C5683b<C5710a> c5683b, int i) {
        if (c5683b.size() == 0) {
            maskTextView.setVisibility(8);
            return;
        }
        maskTextView.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[c5683b.size()];
        int[] iArr2 = new int[c5683b.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < c5683b.size()) {
            try {
                CharSequence charSequence = (String) ((C5710a) c5683b.get(i2)).get(1);
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
                spannableStringBuilder.append(C44089j.m79293b(this.mActivity, charSequence, maskTextView.getTextSize()));
                i2++;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", C5046bo.m7574l(e));
                return;
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(C1318a.friendactivity_luckymoney_icon);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        C5664a c5664a = new C5664a(drawable);
        c5664a.zLT = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) C1338a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(c5664a, length, length + 1, 33);
        int i3 = i == 10 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new C24944o((String) ((C5710a) c5683b.get(i2)).get(0), this.qPr.rqd, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.setOriginText(stringBuffer.toString());
    }

    /* renamed from: a */
    public final void mo63038a(BaseViewHolder baseViewHolder, int i, C46236n c46236n) {
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        int i2 = i;
        mo8944a(baseViewHolder2, i2, (C13633av) this.qPr.cuc().crQ().get(Integer.valueOf(i)), c46236n.cqu(), baseViewHolder.klY, this.qPr);
    }

    /* renamed from: a */
    private boolean m68243a(List<cat> list, C5683b<C5710a> c5683b, BaseViewHolder baseViewHolder) {
        int i;
        LinearLayout linearLayout = baseViewHolder.rHP;
        int childCount = linearLayout.getChildCount();
        int size = c5683b.size();
        if (childCount > size) {
            for (i = size; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(size);
                linearLayout.removeViewAt(size);
                if (childAt instanceof SnsCommentCollapseLayout) {
                    this.qPr.mo74342a((SnsCommentCollapseLayout) childAt);
                }
            }
        }
        if (c5683b.size() == 0) {
            linearLayout.setVisibility(8);
            return false;
        }
        C13633av c13633av;
        linearLayout.setVisibility(0);
        C43612w cuc = this.qPr.cuc();
        if (cuc instanceof C29169a) {
            c13633av = (C13633av) ((C29169a) cuc).rEB.get(baseViewHolder.position);
        } else {
            c13633av = null;
        }
        int i2 = 0;
        if (this.DEBUG) {
            C4990ab.m7410d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + baseViewHolder.position + " commentCount: " + size);
        }
        i = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i4 >= c5683b.size()) {
                return true;
            }
            View ctY;
            Object obj;
            View view;
            Object obj2;
            View view2;
            C5710a c5710a = (C5710a) c5683b.get(i4);
            long longValue = ((Long) c5710a.get(0)).longValue();
            String str = (String) c5710a.get(1);
            String str2 = (String) c5710a.get(2);
            String str3 = (String) c5710a.get(3);
            CharSequence charSequence = (CharSequence) c5710a.get(4);
            cat cat = (cat) list.get(i4);
            int i5 = cat.wZL;
            C13414b aq = m68244aq(baseViewHolder.cFc, longValue);
            if (aq != null && aq.aAR) {
                C13413ap.m21550da(aq.f2919id, 2);
            }
            if (i3 >= childCount) {
                if (aq == null || aq.aAR) {
                    ctY = this.qPr.ctY();
                    ((SnsCommentCollapseLayout) ctY).setTextSize$255e752(15.0f * C1338a.m2860dm(ctY.getContext()));
                    if (this.qPr.rxT == -1) {
                        this.qPr.rxT = this.mActivity.getResources().getColor(C25738R.color.a0d);
                    }
                    ((SnsCommentCollapseLayout) ctY).setTextColor(this.qPr.rxT);
                    ((SnsCommentCollapseLayout) ctY).setGravity(16);
                } else {
                    ctY = new TranslateCommentTextView(this.mActivity);
                    ((TranslateCommentTextView) ctY).getTranslateResultView().setResultTextSize$255e752(15.0f * C1338a.m2860dm(ctY.getContext()));
                    ((TranslateCommentTextView) ctY).getOriginCommentTextView().setTextSize(1, 15.0f * C1338a.m2860dm(ctY.getContext()));
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
                    ((TranslateCommentTextView) ctY).getTranslateResultView().setResultTextSize$255e752(15.0f * C1338a.m2860dm(ctY.getContext()));
                    ((TranslateCommentTextView) ctY).getOriginCommentTextView().setTextSize(1, 15.0f * C1338a.m2860dm(ctY.getContext()));
                    view = ctY;
                }
                TranslateCommentTextView translateCommentTextView = (TranslateCommentTextView) view;
                view.setOnTouchListener(null);
                BaseTimeLineItem.m68239a(translateCommentTextView.getOriginCommentTextView(), charSequence, i5);
                if (!aq.foa) {
                    translateCommentTextView.rDZ.setTextSize(1, 15.0f * C1338a.m2860dm(translateCommentTextView.getContext()));
                    translateCommentTextView.rrm.mo62985El(2);
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
                    if (!C5046bo.isNullOrNil(charSequence2)) {
                        String[] strArr;
                        String[] split = charSequence2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (split.length > 2) {
                            strArr = new String[]{split[0], charSequence2.substring(r2[0].length() + 1)};
                        } else {
                            strArr = split;
                        }
                        if (strArr.length == 2) {
                            if (C5046bo.isNullOrNil(str4)) {
                                translateCommentTextView.rrm.mo62986a(aq, 2, null, str5, aq.qMU);
                            } else {
                                translateCommentTextView.rrm.mo62986a(aq, 2, strArr[0] + ": " + str4, str5, aq.qMU);
                            }
                            translateCommentTextView.rrm.setVisibility(0);
                        }
                        translateCommentTextView.rDZ.setTextSize(1, 15.0f * C1338a.m2860dm(translateCommentTextView.getContext()));
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
                    ((SnsCommentCollapseLayout) ctY2).setTextSize$255e752(15.0f * C1338a.m2860dm(ctY2.getContext()));
                } else {
                    ctY2 = view;
                }
                if (ctY2 instanceof SnsCommentCollapseLayout) {
                    ((SnsCommentCollapseLayout) ctY2).setTextSize$255e752(15.0f * C1338a.m2860dm(ctY2.getContext()));
                    ((SnsCommentCollapseLayout) ctY2).setOpClickListener(this.qPr.rya);
                    ((SnsCommentCollapseLayout) ctY2).setPressTouchListener(new C30132m(this.mActivity));
                }
                BaseTimeLineItem.m68239a(ctY2, charSequence, i5);
                obj2 = null;
                view2 = ctY2;
            }
            view2.setBackgroundResource(C25738R.drawable.a1n);
            if (i3 > 0) {
                if (obj2 != null) {
                    view2.setPadding(0, C1338a.fromDPToPix(this.mActivity, 2), 0, C1338a.fromDPToPix(this.mActivity, 7));
                } else {
                    view2.setPadding(0, C1338a.fromDPToPix(this.mActivity, 2), 0, C1338a.fromDPToPix(this.mActivity, 3));
                }
            } else if (obj2 != null) {
                view2.setPadding(0, 1, 0, C1338a.fromDPToPix(this.mActivity, 7));
            } else {
                view2.setPadding(0, 1, 0, C1338a.fromDPToPix(this.mActivity, 3));
            }
            if (obj2 != null) {
                i = (int) this.mActivity.getResources().getDimension(C25738R.dimen.f10011nc);
                ((TranslateCommentTextView) view2).rrm.getSplitlineView().setPadding(0, 0, i, 0);
            }
            view2.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    int[] iArr;
                    AppMethodBeat.m2504i(40120);
                    int[] iArr2 = new int[2];
                    if (view.getTag(2131820679) instanceof int[]) {
                        iArr = (int[]) view.getTag(2131820679);
                    } else {
                        iArr = iArr2;
                    }
                    BaseTimeLineItem.this.qPr.jMO.mo39886a(view2, BaseTimeLineItem.this.qPr.qOL.rJU, BaseTimeLineItem.this.qPr.qOL.rJH, iArr[0], iArr[1]);
                    AppMethodBeat.m2505o(40120);
                    return true;
                }
            });
            view2.setOnClickListener(new C29224a(cat, str2, str3, baseViewHolder));
            if (c13633av != null) {
                view2.setTag(new C46922l(c13633av.riA, c13633av.rAs, cat, str, str3, view2, 1));
            }
            if (obj != null) {
                linearLayout.addView(view2);
            }
            i2 = i3 + 1;
            i = i4 + 1;
        }
    }

    /* renamed from: a */
    private static void m68239a(View view, CharSequence charSequence, int i) {
        if (view instanceof SnsCommentCollapseLayout) {
            ((SnsCommentCollapseLayout) view).mo37715k(charSequence, i);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
    }

    /* renamed from: aq */
    private C13414b m68244aq(String str, long j) {
        if (this.rHq.size() <= 0) {
            return null;
        }
        Iterator it = this.rHq.iterator();
        while (it.hasNext()) {
            C13414b c13414b = (C13414b) it.next();
            if (c13414b.f2919id != null && c13414b.f2919id.equals(C13413ap.m21555ga(str, String.valueOf(j)))) {
                return c13414b;
            }
        }
        return null;
    }
}
