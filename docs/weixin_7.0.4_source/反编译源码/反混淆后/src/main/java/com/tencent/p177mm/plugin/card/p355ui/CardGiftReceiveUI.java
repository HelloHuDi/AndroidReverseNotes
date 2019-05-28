package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18296ik;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C11292t;
import com.tencent.p177mm.plugin.card.model.C27589z;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.CardGiftInfo;
import com.tencent.p177mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.p177mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C20130a;
import com.tencent.p177mm.plugin.card.p931d.C20130a.C20132a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C44152oj;
import com.tencent.p177mm.protocal.protobuf.cdc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI */
public class CardGiftReceiveUI extends MMActivity implements OnClickListener, C1202f {
    private int fhF;
    private String fhG;
    private TextView kkA;
    private TextView kkB;
    private ImageView kkC;
    private ImageView kkD;
    private LinearLayout kkE;
    private RelativeLayout kkF;
    private RelativeLayout kkG;
    private TextView kkH;
    private ImageView kkI;
    private TextView kkJ;
    private TextView kkK;
    private TextView kkL;
    private ImageView kkM;
    private ImageView kkN;
    private View kkO;
    private TextView kkP;
    private LinearLayout kkQ;
    private ListView kkR;
    private RelativeLayout kkS;
    private LinearLayout kkT;
    private ImageView kkU;
    private TextView kkV;
    private LinearLayout kkW;
    private TextView kkX;
    private RelativeLayout kkY;
    private RelativeLayout kkZ;
    private CardGiftInfo kkk;
    private ProgressBar kko;
    private C7306ak kkp = new C7306ak(Looper.getMainLooper());
    private ScrollView kkx;
    private LinearLayout kky;
    private ImageView kkz;
    private ImageView kla;
    private ImageView klb;
    private TextView klc;
    private TextView kld;
    private ListView kle;
    private RelativeLayout klf;
    private TextView klg;
    private TextView klh;
    private View kli;
    C20132a klj = new C113114();
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$c */
    class C11304c extends BaseAdapter {
        private LinkedList<AcceptedCardItem> klo;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(88429);
            AcceptedCardItem td = m19023td(i);
            AppMethodBeat.m2505o(88429);
            return td;
        }

        C11304c(LinkedList<AcceptedCardItem> linkedList) {
            this.klo = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(88426);
            int size = this.klo.size();
            AppMethodBeat.m2505o(88426);
            return size;
        }

        /* renamed from: td */
        private AcceptedCardItem m19023td(int i) {
            AppMethodBeat.m2504i(88427);
            AcceptedCardItem acceptedCardItem = (AcceptedCardItem) this.klo.get(i);
            AppMethodBeat.m2505o(88427);
            return acceptedCardItem;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C11307d c11307d;
            AppMethodBeat.m2504i(88428);
            AcceptedCardItem td = m19023td(i);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, 2130968920, null);
                C11307d c11307d2 = new C11307d();
                c11307d2.gsf = (TextView) view.findViewById(2131822067);
                c11307d2.kln = (TextView) view.findViewById(2131822068);
                view.setTag(c11307d2);
                c11307d = c11307d2;
            } else {
                c11307d = (C11307d) view.getTag();
            }
            c11307d.gsf.setText(td.kcU);
            c11307d.kln.setText(td.kcV + CardGiftReceiveUI.this.mController.ylL.getString(C25738R.string.ae_));
            AppMethodBeat.m2505o(88428);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$a */
    class C11305a extends BaseAdapter {
        C11305a() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(88423);
            int size = CardGiftReceiveUI.this.kkk.kcP.size();
            AppMethodBeat.m2505o(88423);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C11306b c11306b;
            AppMethodBeat.m2504i(88424);
            AccepterItem accepterItem = (AccepterItem) CardGiftReceiveUI.this.kkk.kcP.get(i);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, 2130968921, null);
                C11306b c11306b2 = new C11306b();
                c11306b2.klm = (ImageView) view.findViewById(2131822071);
                c11306b2.jWY = (TextView) view.findViewById(2131822072);
                c11306b2.gsf = (TextView) view.findViewById(2131822073);
                c11306b2.kln = (TextView) view.findViewById(2131822074);
                view.setTag(c11306b2);
                c11306b = c11306b2;
            } else {
                c11306b = (C11306b) view.getTag();
            }
            if (accepterItem != null) {
                if (accepterItem.kcX != null) {
                    ImageView imageView = c11306b.klm;
                    String str = accepterItem.kcX;
                    if (!(imageView == null || TextUtils.isEmpty(str))) {
                        if (TextUtils.isEmpty(str)) {
                            imageView.setImageResource(C25738R.drawable.bcm);
                        } else {
                            C17927a c17927a = new C17927a();
                            c17927a.ePK = C6457e.eSn;
                            C32291o.ahq();
                            c17927a.ePY = null;
                            c17927a.ePJ = C33770m.m55183Gz(str);
                            c17927a.ePH = true;
                            c17927a.eQf = true;
                            c17927a.eQg = 3.0f;
                            c17927a.ePF = true;
                            c17927a.ePO = 34;
                            c17927a.ePN = 34;
                            c17927a.ePT = C25738R.drawable.bcm;
                            C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
                        }
                    }
                }
                c11306b.jWY.setText(accepterItem.kcW);
                c11306b.gsf.setText(accepterItem.kcU);
                c11306b.kln.setText(accepterItem.kcV + CardGiftReceiveUI.this.mController.ylL.getString(C25738R.string.ae_));
            }
            AppMethodBeat.m2505o(88424);
            return view;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(88425);
            AccepterItem accepterItem = (AccepterItem) CardGiftReceiveUI.this.kkk.kcP.get(i);
            AppMethodBeat.m2505o(88425);
            return accepterItem;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$b */
    class C11306b {
        public TextView gsf;
        public TextView jWY;
        public ImageView klm;
        public TextView kln;

        C11306b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$d */
    class C11307d {
        public TextView gsf;
        public TextView kln;

        C11307d() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$1 */
    class C113081 implements OnGlobalLayoutListener {
        C113081() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(88415);
            C4990ab.m7417i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", Integer.valueOf(C1338a.fromDPToPix(CardGiftReceiveUI.this.mController.ylL, 67)), Integer.valueOf(CardGiftReceiveUI.this.kkx.getChildAt(0).getHeight() + C1338a.fromDPToPix(CardGiftReceiveUI.this.mController.ylL, 67)), Integer.valueOf(CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight()));
            CardGiftReceiveUI.this.kkx.setFillViewport(true);
            if (CardGiftReceiveUI.this.kkx.getChildAt(0).getHeight() + C1338a.fromDPToPix(CardGiftReceiveUI.this.mController.ylL, 67) > CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight()) {
                CardGiftReceiveUI.m19026a(CardGiftReceiveUI.this, true);
            } else {
                CardGiftReceiveUI.m19026a(CardGiftReceiveUI.this, false);
            }
            CardGiftReceiveUI.this.kkx.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.m2505o(88415);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$2 */
    class C113092 implements OnMenuItemClickListener {
        C113092() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88416);
            CardGiftReceiveUI.this.finish();
            AppMethodBeat.m2505o(88416);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$3 */
    class C113103 implements OnCancelListener {
        C113103() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(88417);
            if (CardGiftReceiveUI.this.tipDialog != null && CardGiftReceiveUI.this.tipDialog.isShowing()) {
                CardGiftReceiveUI.this.tipDialog.dismiss();
            }
            if (CardGiftReceiveUI.this.mController.contentView.getVisibility() == 8 || CardGiftReceiveUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
                CardGiftReceiveUI.this.finish();
            }
            AppMethodBeat.m2505o(88417);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$4 */
    class C113114 implements C20132a {

        /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftReceiveUI$4$1 */
        class C27701 implements Runnable {
            C27701() {
            }

            public final void run() {
                AppMethodBeat.m2504i(88418);
                if (CardGiftReceiveUI.this.kko.getVisibility() != 0) {
                    CardGiftReceiveUI.this.kko.setVisibility(0);
                }
                AppMethodBeat.m2505o(88418);
            }
        }

        C113114() {
        }

        /* renamed from: bN */
        public final void mo23013bN(String str, int i) {
            AppMethodBeat.m2504i(88420);
            if (CardGiftReceiveUI.this.kkk == null) {
                C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
                AppMethodBeat.m2505o(88420);
            } else if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(CardGiftReceiveUI.this.kkk.kco) || !str.equals(CardGiftReceiveUI.this.kkk.kco)) {
                CardGiftReceiveUI.this.kkp.post(new C27701());
                AppMethodBeat.m2505o(88420);
            } else {
                C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
                AppMethodBeat.m2505o(88420);
            }
        }

        /* renamed from: GS */
        public final void mo23012GS(String str) {
            AppMethodBeat.m2504i(88421);
            C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(88421);
        }

        /* renamed from: dr */
        public final void mo23014dr(final String str, final String str2) {
            AppMethodBeat.m2504i(88422);
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(str)));
            if (CardGiftReceiveUI.this.kkk == null) {
                C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
                AppMethodBeat.m2505o(88422);
            } else if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(CardGiftReceiveUI.this.kkk.kco) || !str.equals(CardGiftReceiveUI.this.kkk.kco)) {
                CardGiftReceiveUI.this.kkp.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(88419);
                        if (CardGiftReceiveUI.this.kko.getVisibility() != 8) {
                            CardGiftReceiveUI.this.kko.setVisibility(8);
                        }
                        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(CardGiftReceiveUI.this.kkk.kcp) || !str.equals(CardGiftReceiveUI.this.kkk.kcp)) {
                            CardGiftReceiveUI.this.kkZ.setVisibility(8);
                        } else {
                            CardGiftReceiveUI.this.kkZ.setVisibility(0);
                        }
                        Bitmap vv = C18764x.m29333vv(str2);
                        if (vv == null) {
                            CardGiftReceiveUI.this.kla.setImageResource(C1318a.download_image_icon);
                            AppMethodBeat.m2505o(88419);
                            return;
                        }
                        CardGiftReceiveUI.this.kla.setImageBitmap(vv);
                        AppMethodBeat.m2505o(88419);
                    }
                });
                AppMethodBeat.m2505o(88422);
            } else {
                C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
                AppMethodBeat.m2505o(88422);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardGiftReceiveUI() {
        AppMethodBeat.m2504i(88430);
        AppMethodBeat.m2505o(88430);
    }

    public final int getLayoutId() {
        return 2130968925;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88431);
        super.onCreate(bundle);
        this.fhG = getIntent().getStringExtra("key_order_id");
        this.fhF = getIntent().getIntExtra("key_biz_uin", -1);
        this.kkk = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        C4990ab.m7417i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", this.fhG, Integer.valueOf(this.fhF));
        initView();
        C1720g.m3535RO().eJo.mo14539a(1165, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(699, (C1202f) this);
        C20130a.m31138a(this.klj);
        if (this.kkk == null) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.fhF == -1) {
                C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                AppMethodBeat.m2505o(88431);
                return;
            }
            if (this.fhG == null) {
                C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            C1720g.m3535RO().eJo.mo14541a(new C27589z(this.fhF, this.fhG), 0);
            this.tipDialog = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.cn5), true, new C113103());
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
            AppMethodBeat.m2505o(88431);
            return;
        }
        bbB();
        AppMethodBeat.m2505o(88431);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88432);
        super.onDestroy();
        C1720g.m3535RO().eJo.mo14546b(1165, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(699, (C1202f) this);
        C20130a.m31139b(this.klj);
        AppMethodBeat.m2505o(88432);
    }

    private void bbB() {
        AppMethodBeat.m2504i(88433);
        if (this.kkk == null) {
            C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            AppMethodBeat.m2505o(88433);
            return;
        }
        C4990ab.m7417i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", Integer.valueOf(this.kkk.kcE));
        if (this.kkk.kcE == 1 || this.kkk.kcE != 2) {
            bda();
        } else {
            bcZ();
        }
        bcY();
        bbS();
        bdb();
        if (C5046bo.isNullOrNil(this.kkk.kcK) && C5046bo.isNullOrNil(this.kkk.kcx)) {
            this.kkx.setFillViewport(true);
            AppMethodBeat.m2505o(88433);
            return;
        }
        this.kkx.getViewTreeObserver().addOnGlobalLayoutListener(new C113081());
        AppMethodBeat.m2505o(88433);
    }

    private void bcY() {
        AppMethodBeat.m2504i(88435);
        if (this.kkk.kcR == 1) {
            this.kkT.setVisibility(0);
            this.kkW.setVisibility(8);
            this.kkS.setVisibility(8);
            this.kkV.setText(C44089j.m79293b((Context) this, this.kkk.cKE, this.kkV.getTextSize()));
            m19034f(this.kkU);
            AppMethodBeat.m2505o(88435);
            return;
        }
        this.kkT.setVisibility(8);
        this.kkW.setVisibility(0);
        this.kkS.setVisibility(0);
        m19034f(this.klb);
        this.klc.setText(C44089j.m79293b((Context) this, this.kkk.cKE, this.klc.getTextSize()));
        if ((C5046bo.isNullOrNil(this.kkk.kcn) || "undefined".equals(this.kkk.kcn)) && (C5046bo.isNullOrNil(this.kkk.kco) || "undefined".equals(this.kkk.kco))) {
            this.kkY.setVisibility(8);
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
        } else {
            this.kkY.setVisibility(0);
        }
        bdc();
        if (!C5046bo.isNullOrNil(this.kkk.kcm)) {
            this.kkX.setText(C44089j.m79293b((Context) this, this.kkk.kcm, this.kkX.getTextSize()));
        }
        AppMethodBeat.m2505o(88435);
    }

    /* renamed from: f */
    private void m19034f(ImageView imageView) {
        AppMethodBeat.m2504i(88436);
        if (C5046bo.isNullOrNil(this.kkk.kcl)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
            AppMethodBeat.m2505o(88436);
            return;
        }
        int fromDPToPix = C1338a.fromDPToPix(this, 20);
        C17927a c17927a = new C17927a();
        c17927a.ePK = C6457e.eSn;
        C32291o.ahq();
        c17927a.ePY = null;
        c17927a.ePJ = C33770m.m55183Gz(this.kkk.kcl);
        c17927a.ePH = true;
        c17927a.eQf = true;
        c17927a.eQg = 3.0f;
        c17927a.ePF = true;
        c17927a.ePO = fromDPToPix;
        c17927a.ePN = fromDPToPix;
        c17927a.ePU = new ColorDrawable(C38736l.m65701Hn("#CCCCCC"));
        C32291o.ahp().mo43766a(this.kkk.kcl, imageView, c17927a.ahG());
        AppMethodBeat.m2505o(88436);
    }

    private void bcZ() {
        C17927a c17927a;
        AppMethodBeat.m2504i(88437);
        this.kkE.setVisibility(8);
        this.kky.setVisibility(0);
        this.kkA.setText(this.kkk.kcC);
        this.kkB.setText(this.kkk.kcv + "     " + this.kkk.kcw + this.mController.ylL.getString(C25738R.string.ae_));
        if (C5046bo.isNullOrNil(this.kkk.kcD)) {
            this.kkz.setVisibility(8);
        } else {
            this.kkz.setVisibility(0);
            c17927a = new C17927a();
            c17927a.ePK = C6457e.eSn;
            C32291o.ahq();
            c17927a.ePY = null;
            c17927a.ePJ = C33770m.m55183Gz(this.kkk.kcD);
            c17927a.ePH = true;
            c17927a.ePF = true;
            C32291o.ahp().mo43766a(this.kkk.kcD, this.kkz, c17927a.ahG());
        }
        if (C5046bo.isNullOrNil(this.kkk.kcG)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
        } else {
            this.kkA.setTextColor(C5046bo.m7530bS(this.kkk.kcG, getResources().getColor(C25738R.color.f11782h4)));
        }
        if (C5046bo.isNullOrNil(this.kkk.kcH)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
        } else {
            this.kkB.setTextColor(C5046bo.m7530bS(this.kkk.kcH, getResources().getColor(C25738R.color.f11782h4)));
        }
        if (C5046bo.isNullOrNil(this.kkk.kcu)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
        } else {
            c17927a = new C17927a();
            c17927a.ePK = C6457e.eSn;
            C32291o.ahq();
            c17927a.ePY = null;
            c17927a.ePJ = C33770m.m55183Gz(this.kkk.kcu);
            c17927a.eQf = true;
            c17927a.ePH = true;
            c17927a.ePF = true;
            c17927a.ePU = new ColorDrawable(C38736l.m65701Hn("#CCCCCC"));
            C32291o.ahp().mo43766a(this.kkk.kcu, this.kkD, c17927a.ahG());
        }
        if (C5046bo.isNullOrNil(this.kkk.kct)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            AppMethodBeat.m2505o(88437);
            return;
        }
        c17927a = new C17927a();
        c17927a.ePK = C6457e.eSn;
        C32291o.ahq();
        c17927a.ePY = null;
        c17927a.ePJ = C33770m.m55183Gz(this.kkk.kct);
        c17927a.ePH = true;
        c17927a.ePF = true;
        c17927a.ePU = new ColorDrawable(C38736l.m65701Hn("#CCCCCC"));
        c17927a.eQf = true;
        c17927a.eQg = (float) C1338a.fromDPToPix(this, 8);
        C32291o.ahp().mo43766a(this.kkk.kct, this.kkC, c17927a.ahG());
        AppMethodBeat.m2505o(88437);
    }

    private void bda() {
        C17927a c17927a;
        AppMethodBeat.m2504i(88438);
        this.kky.setVisibility(8);
        this.kkE.setVisibility(0);
        this.kkJ.setText(this.kkk.kcv);
        if (this.kkk.kcR == 1) {
            this.kkM.setAlpha(0.5f);
            this.kkK.setVisibility(8);
            this.kkL.setVisibility(8);
            this.kkG.setVisibility(8);
            this.kkF.setVisibility(8);
        } else {
            this.kkK.setVisibility(0);
            this.kkL.setVisibility(0);
            this.kkG.setVisibility(0);
            this.kkF.setVisibility(0);
            this.kkK.setText(this.kkk.kcw);
            this.kkL.setText(C25738R.string.ae_);
            if (C5046bo.isNullOrNil(this.kkk.kcw)) {
                this.kkK.setVisibility(8);
                this.kkL.setVisibility(8);
            }
            if (C5046bo.isNullOrNil(this.kkk.kcI)) {
                C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
            } else {
                this.kkK.setTextColor(C5046bo.m7530bS(this.kkk.kcI, getResources().getColor(C25738R.color.f11782h4)));
            }
        }
        if (C5046bo.isNullOrNil(this.kkk.kcD)) {
            this.kkI.setVisibility(8);
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        } else {
            this.kkI.setVisibility(0);
            c17927a = new C17927a();
            c17927a.ePK = C6457e.eSn;
            C32291o.ahq();
            c17927a.ePY = null;
            c17927a.ePJ = C33770m.m55183Gz(this.kkk.kcD);
            c17927a.ePH = true;
            c17927a.ePF = true;
            C32291o.ahp().mo43766a(this.kkk.kcD, this.kkI, c17927a.ahG());
        }
        if (C5046bo.isNullOrNil(this.kkk.kcC)) {
            this.kkH.setVisibility(8);
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        } else {
            this.kkH.setVisibility(0);
            this.kkH.setText(this.kkk.kcC);
            if (C5046bo.isNullOrNil(this.kkk.kcG)) {
                C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
            } else {
                this.kkH.setTextColor(C5046bo.m7530bS(this.kkk.kcG, getResources().getColor(C25738R.color.f11782h4)));
            }
        }
        if (C5046bo.isNullOrNil(this.kkk.kcH)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
        } else {
            this.kkJ.setTextColor(C5046bo.m7530bS(this.kkk.kcH, getResources().getColor(C25738R.color.f11782h4)));
        }
        if (C5046bo.isNullOrNil(this.kkk.kcu)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
        } else {
            c17927a = new C17927a();
            c17927a.ePK = C6457e.eSn;
            C32291o.ahq();
            c17927a.ePY = null;
            c17927a.ePJ = C33770m.m55183Gz(this.kkk.kcu);
            c17927a.eQf = true;
            c17927a.ePH = true;
            c17927a.ePF = true;
            c17927a.ePU = new ColorDrawable(C38736l.m65701Hn("#CCCCCC"));
            C32291o.ahp().mo43766a(this.kkk.kcu, this.kkN, c17927a.ahG());
        }
        if (C5046bo.isNullOrNil(this.kkk.kct)) {
            C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            AppMethodBeat.m2505o(88438);
            return;
        }
        c17927a = new C17927a();
        c17927a.ePK = C6457e.eSn;
        C32291o.ahq();
        c17927a.ePY = null;
        c17927a.ePJ = C33770m.m55183Gz(this.kkk.kct);
        c17927a.ePH = true;
        c17927a.ePF = true;
        c17927a.ePU = new ColorDrawable(C38736l.m65701Hn("#CCCCCC"));
        c17927a.eQf = true;
        c17927a.eQg = (float) C1338a.fromDPToPix(this, 8);
        C32291o.ahp().mo43766a(this.kkk.kct, this.kkM, c17927a.ahG());
        AppMethodBeat.m2505o(88438);
    }

    private void bbS() {
        int i = 0;
        AppMethodBeat.m2504i(88439);
        if (this.kkk.kcO.size() > 0) {
            this.kkO.setVisibility(0);
            this.kkR.setVisibility(8);
            if (this.kkk.kcO.size() <= 2) {
                this.kkP.setVisibility(8);
                m19024L(this.kkk.kcO);
                AppMethodBeat.m2505o(88439);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.kkk.kcO.get(0));
            linkedList.add(this.kkk.kcO.get(1));
            m19024L(linkedList);
            this.kkP.setVisibility(0);
            this.kkP.setOnClickListener(this);
            linkedList = new LinkedList();
            while (i < this.kkk.kcO.size()) {
                if (!(i == 0 || i == 1)) {
                    linkedList.add(this.kkk.kcO.get(i));
                }
                i++;
            }
            this.kkR.setAdapter(new C11304c(linkedList));
            CardGiftReceiveUI.m19029b(this.kkR);
            AppMethodBeat.m2505o(88439);
            return;
        }
        this.kkO.setVisibility(8);
        this.kkP.setVisibility(8);
        this.kkR.setVisibility(8);
        AppMethodBeat.m2505o(88439);
    }

    /* renamed from: L */
    private void m19024L(LinkedList<AcceptedCardItem> linkedList) {
        AppMethodBeat.m2504i(88440);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            AcceptedCardItem acceptedCardItem = (AcceptedCardItem) it.next();
            View inflate = View.inflate(this, 2130968920, null);
            TextView textView = (TextView) inflate.findViewById(2131822068);
            ((TextView) inflate.findViewById(2131822067)).setText(acceptedCardItem.kcU);
            textView.setText(acceptedCardItem.kcV + this.mController.ylL.getString(C25738R.string.ae_));
            this.kkQ.addView(inflate);
        }
        AppMethodBeat.m2505o(88440);
    }

    private void bdb() {
        AppMethodBeat.m2504i(88441);
        if (this.kkk.kcP.size() > 0) {
            this.klf.setVisibility(0);
            this.kle.setVisibility(0);
            this.kle.setAdapter(new C11305a());
            CardGiftReceiveUI.m19029b(this.kle);
            if (!C5046bo.isNullOrNil(this.kkk.kcQ)) {
                this.kld.setVisibility(0);
                this.kld.setText(this.kkk.kcQ);
            }
            AppMethodBeat.m2505o(88441);
            return;
        }
        this.klf.setVisibility(0);
        this.kle.setVisibility(0);
        this.kld.setVisibility(0);
        if (!C5046bo.isNullOrNil(this.kkk.kcQ)) {
            this.kld.setVisibility(0);
            this.kld.setText(this.kkk.kcQ);
        }
        AppMethodBeat.m2505o(88441);
    }

    /* renamed from: b */
    private static void m19029b(ListView listView) {
        AppMethodBeat.m2504i(88442);
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            AppMethodBeat.m2505o(88442);
            return;
        }
        int count = adapter.getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(0, 0);
            i += view.getMeasuredHeight();
        }
        LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
        listView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(88442);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88443);
        this.kkx = (ScrollView) findViewById(2131822102);
        this.kky = (LinearLayout) findViewById(2131822104);
        this.kkz = (ImageView) findViewById(2131822105);
        this.kkA = (TextView) findViewById(2131822106);
        this.kkB = (TextView) findViewById(2131822109);
        this.kkC = (ImageView) findViewById(2131822107);
        this.kkD = (ImageView) findViewById(2131822108);
        this.kkC.setOnClickListener(this);
        this.kkE = (LinearLayout) findViewById(2131822110);
        this.kkF = (RelativeLayout) findViewById(2131822111);
        this.kkG = (RelativeLayout) findViewById(2131822112);
        this.kkH = (TextView) findViewById(2131822085);
        this.kkJ = (TextView) findViewById(2131822088);
        this.kkI = (ImageView) findViewById(2131822087);
        this.kkK = (TextView) findViewById(2131822089);
        this.kkL = (TextView) findViewById(2131822113);
        this.kkM = (ImageView) findViewById(2131822091);
        this.kkN = (ImageView) findViewById(2131822092);
        this.kkM.setOnClickListener(this);
        this.kkO = findViewById(2131822117);
        this.kkP = (TextView) findViewById(2131822120);
        this.kkQ = (LinearLayout) findViewById(2131822118);
        this.kkR = (ListView) findViewById(2131822119);
        this.kkS = (RelativeLayout) findViewById(2131822121);
        this.kkT = (LinearLayout) findViewById(2131822114);
        this.kkU = (ImageView) findViewById(2131822115);
        this.kkV = (TextView) findViewById(2131822116);
        this.kkW = (LinearLayout) findViewById(2131822123);
        this.klb = (ImageView) findViewById(2131822099);
        this.klc = (TextView) findViewById(2131822100);
        this.kkX = (TextView) findViewById(2131822124);
        this.kkY = (RelativeLayout) findViewById(2131822125);
        this.kkZ = (RelativeLayout) findViewById(2131822126);
        this.kla = (ImageView) findViewById(2131822096);
        this.kkY.setOnClickListener(this);
        this.kkZ.setOnClickListener(this);
        this.kld = (TextView) findViewById(2131822129);
        this.kle = (ListView) findViewById(2131822130);
        this.klf = (RelativeLayout) findViewById(2131822127);
        this.kko = (ProgressBar) findViewById(2131822082);
        C45778m.m84647d(this);
        setMMTitle("");
        setBackBtn(new C113092());
        AppMethodBeat.m2505o(88443);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88444);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C27589z) {
                C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.kkk = ((C27589z) c1207m).kdV;
                bbB();
                AppMethodBeat.m2505o(88444);
                return;
            } else if (c1207m instanceof C11292t) {
                Intent intent = new Intent(this, CardDetailUI.class);
                LinkedList linkedList = ((C11292t) c1207m).kdZ;
                if (linkedList == null || linkedList.size() == 0) {
                    C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
                    AppMethodBeat.m2505o(88444);
                    return;
                }
                C42837b c42837b = (C42837b) linkedList.get(0);
                if (c42837b == null || !(c42837b instanceof CardInfo)) {
                    C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
                    AppMethodBeat.m2505o(88444);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add((CardInfo) it.next());
                }
                intent.putExtra("key_card_info", (CardInfo) c42837b);
                intent.putExtra("key_previous_scene", 27);
                intent.putExtra("key_from_scene", 27);
                intent.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
                intent.putExtra("key_card_git_info", this.kkk);
                startActivity(intent);
                AppMethodBeat.m2505o(88444);
                return;
            }
        } else if (c1207m instanceof C27589z) {
            C4990ab.m7413e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            C42840d.m76036a(this, str, true);
            AppMethodBeat.m2505o(88444);
            return;
        } else if (c1207m instanceof C11292t) {
            C4990ab.m7413e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(88444);
            return;
        }
        AppMethodBeat.m2505o(88444);
    }

    private void bdc() {
        AppMethodBeat.m2504i(88445);
        if (this.kkk == null || C5046bo.isNullOrNil(this.kkk.kcn)) {
            C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
        } else {
            C20130a.m31140g(this.kkk.kcn, this.kkk.kcq, this.kkk.kcz, 2);
        }
        if (this.kkk == null || C5046bo.isNullOrNil(this.kkk.kcp)) {
            C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
            AppMethodBeat.m2505o(88445);
            return;
        }
        C20130a.m31140g(this.kkk.kcp, this.kkk.kcs, this.kkk.kcB, 2);
        AppMethodBeat.m2505o(88445);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(88446);
        Intent intent;
        if (view.getId() == 2131822126) {
            if (!C5046bo.isNullOrNil(this.kkk.kco)) {
                intent = new Intent(this, CardGiftVideoUI.class);
                intent.putExtra("key_gift_into", this.kkk);
                intent.putExtra("key_is_mute", false);
                startActivity(intent);
                overridePendingTransition(0, 0);
                C7060h.pYm.mo8381e(13866, Integer.valueOf(3), this.fhG, C1183p.getString(this.fhF));
                AppMethodBeat.m2505o(88446);
                return;
            }
        } else if (view.getId() == 2131822125) {
            if (this.kko.getVisibility() == 0) {
                AppMethodBeat.m2505o(88446);
                return;
            } else if (!C5046bo.isNullOrNil(this.kkk.kcn)) {
                intent = new Intent(this, CardGiftImageUI.class);
                intent.putExtra("key_gift_into", this.kkk);
                startActivity(intent);
                overridePendingTransition(0, 0);
                C7060h.pYm.mo8381e(13866, Integer.valueOf(4), this.fhG, C1183p.getString(this.fhF));
                AppMethodBeat.m2505o(88446);
                return;
            }
        } else if (view.getId() == 2131822078) {
            if (this.kkk != null && this.kkk.kcy) {
                C7060h.pYm.mo8381e(13866, Integer.valueOf(7), this.fhG, C1183p.getString(this.fhF));
                C18296ik c18296ik = new C18296ik();
                c18296ik.cDz.context = this.mController.ylL;
                c18296ik.cDz.scene = 2;
                C4879a.xxA.mo10055m(c18296ik);
                C4990ab.m7416i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
                finish();
                overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(88446);
                return;
            }
        } else if (view.getId() == 2131822077) {
            if (!TextUtils.isEmpty(this.kkk.kcS) && !TextUtils.isEmpty(this.kkk.kcT)) {
                C45774b.m84634d(this.kkk.kcJ, this.kkk.kcS, this.kkk.kcT, FilterEnum4Shaka.MIC_WEISHI_HUAYE, getIntent().getIntExtra("key_from_appbrand_type", 0));
                C7060h.pYm.mo8381e(13866, Integer.valueOf(8), this.fhG, C1183p.getString(this.fhF));
                AppMethodBeat.m2505o(88446);
                return;
            } else if (!C5046bo.isNullOrNil(this.kkk.kcL)) {
                C45774b.m84626a((MMActivity) this, this.kkk.kcL, 0);
                C7060h.pYm.mo8381e(13866, Integer.valueOf(8), this.fhG, C1183p.getString(this.fhF));
                AppMethodBeat.m2505o(88446);
                return;
            }
        } else if (view.getId() == 2131822091 || view.getId() == 2131822107) {
            if (C5046bo.isNullOrNil(this.kkk.kcM) || C5046bo.isNullOrNil(this.kkk.kcN)) {
                C4990ab.m7412e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
                AppMethodBeat.m2505o(88446);
                return;
            }
            LinkedList linkedList = new LinkedList();
            C44152oj c44152oj = new C44152oj();
            c44152oj.kbU = this.kkk.kcM;
            c44152oj.code = this.kkk.kcN;
            linkedList.add(c44152oj);
            String stringExtra = getIntent().getStringExtra("key_template_id");
            cdc cdc = new cdc();
            cdc.xcM = stringExtra;
            C4990ab.m7417i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", stringExtra);
            C1720g.m3535RO().eJo.mo14541a(new C11292t(linkedList, cdc, 27), 0);
            C7060h.pYm.mo8381e(13866, Integer.valueOf(9), this.fhG, C1183p.getString(this.fhF));
            AppMethodBeat.m2505o(88446);
            return;
        } else if (view.getId() == 2131822120) {
            if (this.kkR.getVisibility() == 0) {
                this.kkR.setVisibility(8);
                this.kkP.setText("查看全部");
                AppMethodBeat.m2505o(88446);
                return;
            }
            this.kkR.setVisibility(0);
            this.kkP.setText("收起");
        }
        AppMethodBeat.m2505o(88446);
    }

    /* renamed from: ad */
    private int m19027ad(int i) {
        AppMethodBeat.m2504i(88434);
        int fromDPToPix = C1338a.fromDPToPix(this.mController.ylL, i);
        AppMethodBeat.m2505o(88434);
        return fromDPToPix;
    }

    /* renamed from: a */
    static /* synthetic */ void m19026a(CardGiftReceiveUI cardGiftReceiveUI, boolean z) {
        AppMethodBeat.m2504i(88447);
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(cardGiftReceiveUI, 2130968922, null);
        cardGiftReceiveUI.kli = relativeLayout.findViewById(2131822076);
        cardGiftReceiveUI.klg = (TextView) relativeLayout.findViewById(2131822077);
        cardGiftReceiveUI.klh = (TextView) relativeLayout.findViewById(2131822078);
        cardGiftReceiveUI.klg.setOnClickListener(cardGiftReceiveUI);
        cardGiftReceiveUI.klh.setOnClickListener(cardGiftReceiveUI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z) {
            if (cardGiftReceiveUI.klf.getVisibility() == 0) {
                layoutParams.addRule(3, 2131822130);
            } else {
                layoutParams.addRule(3, 2131822122);
            }
            layoutParams.bottomMargin = cardGiftReceiveUI.m19027ad(30);
            layoutParams.topMargin = cardGiftReceiveUI.m19027ad(40);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = cardGiftReceiveUI.m19027ad(30);
            layoutParams.topMargin = cardGiftReceiveUI.m19027ad(40);
        }
        LinearLayout.LayoutParams layoutParams2;
        if (cardGiftReceiveUI.klf.getVisibility() == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            if (cardGiftReceiveUI.kkY.getVisibility() == 0) {
                layoutParams2.topMargin = cardGiftReceiveUI.m19027ad(0);
                cardGiftReceiveUI.klf.setLayoutParams(layoutParams2);
            } else {
                layoutParams2.topMargin = cardGiftReceiveUI.m19027ad(60);
            }
            cardGiftReceiveUI.klf.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.klf.addView(relativeLayout, layoutParams);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = cardGiftReceiveUI.m19027ad(60);
            cardGiftReceiveUI.kkS.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kkS.addView(relativeLayout, layoutParams);
        }
        if (C5046bo.isNullOrNil(cardGiftReceiveUI.kkk.kcK)) {
            cardGiftReceiveUI.klg.setVisibility(8);
        } else {
            cardGiftReceiveUI.klg.setVisibility(0);
            cardGiftReceiveUI.klg.setText(cardGiftReceiveUI.kkk.kcK);
        }
        if (C5046bo.isNullOrNil(cardGiftReceiveUI.kkk.kcx)) {
            cardGiftReceiveUI.kli.setVisibility(8);
            cardGiftReceiveUI.klh.setVisibility(8);
        } else {
            cardGiftReceiveUI.kli.setVisibility(0);
            cardGiftReceiveUI.klh.setVisibility(0);
            cardGiftReceiveUI.klh.setText(cardGiftReceiveUI.kkk.kcx);
        }
        if (C5046bo.isNullOrNil(cardGiftReceiveUI.kkk.kcm)) {
            cardGiftReceiveUI.kkS.setVisibility(8);
        }
        AppMethodBeat.m2505o(88447);
    }
}
