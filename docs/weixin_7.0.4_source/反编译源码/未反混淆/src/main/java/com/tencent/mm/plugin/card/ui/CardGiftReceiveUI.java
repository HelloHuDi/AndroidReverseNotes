package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI extends MMActivity implements OnClickListener, f {
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
    private ak kkp = new ak(Looper.getMainLooper());
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
    com.tencent.mm.plugin.card.d.a.a klj = new com.tencent.mm.plugin.card.d.a.a() {
        public final void bN(String str, int i) {
            AppMethodBeat.i(88420);
            if (CardGiftReceiveUI.this.kkk == null) {
                ab.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
                AppMethodBeat.o(88420);
            } else if (bo.isNullOrNil(str) || bo.isNullOrNil(CardGiftReceiveUI.this.kkk.kco) || !str.equals(CardGiftReceiveUI.this.kkk.kco)) {
                CardGiftReceiveUI.this.kkp.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(88418);
                        if (CardGiftReceiveUI.this.kko.getVisibility() != 0) {
                            CardGiftReceiveUI.this.kko.setVisibility(0);
                        }
                        AppMethodBeat.o(88418);
                    }
                });
                AppMethodBeat.o(88420);
            } else {
                ab.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
                AppMethodBeat.o(88420);
            }
        }

        public final void GS(String str) {
            AppMethodBeat.i(88421);
            ab.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(str)));
            AppMethodBeat.o(88421);
        }

        public final void dr(final String str, final String str2) {
            AppMethodBeat.i(88422);
            ab.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(str)));
            if (CardGiftReceiveUI.this.kkk == null) {
                ab.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
                AppMethodBeat.o(88422);
            } else if (bo.isNullOrNil(str) || bo.isNullOrNil(CardGiftReceiveUI.this.kkk.kco) || !str.equals(CardGiftReceiveUI.this.kkk.kco)) {
                CardGiftReceiveUI.this.kkp.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(88419);
                        if (CardGiftReceiveUI.this.kko.getVisibility() != 8) {
                            CardGiftReceiveUI.this.kko.setVisibility(8);
                        }
                        if (bo.isNullOrNil(str) || bo.isNullOrNil(CardGiftReceiveUI.this.kkk.kcp) || !str.equals(CardGiftReceiveUI.this.kkk.kcp)) {
                            CardGiftReceiveUI.this.kkZ.setVisibility(8);
                        } else {
                            CardGiftReceiveUI.this.kkZ.setVisibility(0);
                        }
                        Bitmap vv = x.vv(str2);
                        if (vv == null) {
                            CardGiftReceiveUI.this.kla.setImageResource(R.raw.download_image_icon);
                            AppMethodBeat.o(88419);
                            return;
                        }
                        CardGiftReceiveUI.this.kla.setImageBitmap(vv);
                        AppMethodBeat.o(88419);
                    }
                });
                AppMethodBeat.o(88422);
            } else {
                ab.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
                AppMethodBeat.o(88422);
            }
        }
    };
    private p tipDialog = null;

    class c extends BaseAdapter {
        private LinkedList<AcceptedCardItem> klo;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(88429);
            AcceptedCardItem td = td(i);
            AppMethodBeat.o(88429);
            return td;
        }

        c(LinkedList<AcceptedCardItem> linkedList) {
            this.klo = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.i(88426);
            int size = this.klo.size();
            AppMethodBeat.o(88426);
            return size;
        }

        private AcceptedCardItem td(int i) {
            AppMethodBeat.i(88427);
            AcceptedCardItem acceptedCardItem = (AcceptedCardItem) this.klo.get(i);
            AppMethodBeat.o(88427);
            return acceptedCardItem;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            AppMethodBeat.i(88428);
            AcceptedCardItem td = td(i);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, R.layout.il, null);
                d dVar2 = new d();
                dVar2.gsf = (TextView) view.findViewById(R.id.ad5);
                dVar2.kln = (TextView) view.findViewById(R.id.ad6);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.gsf.setText(td.kcU);
            dVar.kln.setText(td.kcV + CardGiftReceiveUI.this.mController.ylL.getString(R.string.ae_));
            AppMethodBeat.o(88428);
            return view;
        }
    }

    class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(88423);
            int size = CardGiftReceiveUI.this.kkk.kcP.size();
            AppMethodBeat.o(88423);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(88424);
            AccepterItem accepterItem = (AccepterItem) CardGiftReceiveUI.this.kkk.kcP.get(i);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, R.layout.im, null);
                b bVar2 = new b();
                bVar2.klm = (ImageView) view.findViewById(R.id.ad9);
                bVar2.jWY = (TextView) view.findViewById(R.id.ad_);
                bVar2.gsf = (TextView) view.findViewById(R.id.ada);
                bVar2.kln = (TextView) view.findViewById(R.id.adb);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (accepterItem != null) {
                if (accepterItem.kcX != null) {
                    ImageView imageView = bVar.klm;
                    String str = accepterItem.kcX;
                    if (!(imageView == null || TextUtils.isEmpty(str))) {
                        if (TextUtils.isEmpty(str)) {
                            imageView.setImageResource(R.drawable.bcm);
                        } else {
                            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                            aVar.ePK = e.eSn;
                            o.ahq();
                            aVar.ePY = null;
                            aVar.ePJ = m.Gz(str);
                            aVar.ePH = true;
                            aVar.eQf = true;
                            aVar.eQg = 3.0f;
                            aVar.ePF = true;
                            aVar.ePO = 34;
                            aVar.ePN = 34;
                            aVar.ePT = R.drawable.bcm;
                            o.ahp().a(str, imageView, aVar.ahG());
                        }
                    }
                }
                bVar.jWY.setText(accepterItem.kcW);
                bVar.gsf.setText(accepterItem.kcU);
                bVar.kln.setText(accepterItem.kcV + CardGiftReceiveUI.this.mController.ylL.getString(R.string.ae_));
            }
            AppMethodBeat.o(88424);
            return view;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(88425);
            AccepterItem accepterItem = (AccepterItem) CardGiftReceiveUI.this.kkk.kcP.get(i);
            AppMethodBeat.o(88425);
            return accepterItem;
        }
    }

    class b {
        public TextView gsf;
        public TextView jWY;
        public ImageView klm;
        public TextView kln;

        b() {
        }
    }

    class d {
        public TextView gsf;
        public TextView kln;

        d() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardGiftReceiveUI() {
        AppMethodBeat.i(88430);
        AppMethodBeat.o(88430);
    }

    public final int getLayoutId() {
        return R.layout.iq;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88431);
        super.onCreate(bundle);
        this.fhG = getIntent().getStringExtra("key_order_id");
        this.fhF = getIntent().getIntExtra("key_biz_uin", -1);
        this.kkk = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        ab.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", this.fhG, Integer.valueOf(this.fhF));
        initView();
        g.RO().eJo.a(1165, (f) this);
        g.RO().eJo.a(699, (f) this);
        com.tencent.mm.plugin.card.d.a.a(this.klj);
        if (this.kkk == null) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.fhF == -1) {
                ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                AppMethodBeat.o(88431);
                return;
            }
            if (this.fhG == null) {
                ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            ab.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            g.RO().eJo.a(new z(this.fhF, this.fhG), 0);
            this.tipDialog = h.b(this.mController.ylL, getString(R.string.cn5), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(88417);
                    if (CardGiftReceiveUI.this.tipDialog != null && CardGiftReceiveUI.this.tipDialog.isShowing()) {
                        CardGiftReceiveUI.this.tipDialog.dismiss();
                    }
                    if (CardGiftReceiveUI.this.mController.contentView.getVisibility() == 8 || CardGiftReceiveUI.this.mController.contentView.getVisibility() == 4) {
                        ab.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
                        CardGiftReceiveUI.this.finish();
                    }
                    AppMethodBeat.o(88417);
                }
            });
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
            AppMethodBeat.o(88431);
            return;
        }
        bbB();
        AppMethodBeat.o(88431);
    }

    public void onDestroy() {
        AppMethodBeat.i(88432);
        super.onDestroy();
        g.RO().eJo.b(1165, (f) this);
        g.RO().eJo.b(699, (f) this);
        com.tencent.mm.plugin.card.d.a.b(this.klj);
        AppMethodBeat.o(88432);
    }

    private void bbB() {
        AppMethodBeat.i(88433);
        if (this.kkk == null) {
            ab.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            AppMethodBeat.o(88433);
            return;
        }
        ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", Integer.valueOf(this.kkk.kcE));
        if (this.kkk.kcE == 1 || this.kkk.kcE != 2) {
            bda();
        } else {
            bcZ();
        }
        bcY();
        bbS();
        bdb();
        if (bo.isNullOrNil(this.kkk.kcK) && bo.isNullOrNil(this.kkk.kcx)) {
            this.kkx.setFillViewport(true);
            AppMethodBeat.o(88433);
            return;
        }
        this.kkx.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(88415);
                ab.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", Integer.valueOf(com.tencent.mm.bz.a.fromDPToPix(CardGiftReceiveUI.this.mController.ylL, 67)), Integer.valueOf(CardGiftReceiveUI.this.kkx.getChildAt(0).getHeight() + com.tencent.mm.bz.a.fromDPToPix(CardGiftReceiveUI.this.mController.ylL, 67)), Integer.valueOf(CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight()));
                CardGiftReceiveUI.this.kkx.setFillViewport(true);
                if (CardGiftReceiveUI.this.kkx.getChildAt(0).getHeight() + com.tencent.mm.bz.a.fromDPToPix(CardGiftReceiveUI.this.mController.ylL, 67) > CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight()) {
                    CardGiftReceiveUI.a(CardGiftReceiveUI.this, true);
                } else {
                    CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
                }
                CardGiftReceiveUI.this.kkx.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AppMethodBeat.o(88415);
            }
        });
        AppMethodBeat.o(88433);
    }

    private void bcY() {
        AppMethodBeat.i(88435);
        if (this.kkk.kcR == 1) {
            this.kkT.setVisibility(0);
            this.kkW.setVisibility(8);
            this.kkS.setVisibility(8);
            this.kkV.setText(j.b((Context) this, this.kkk.cKE, this.kkV.getTextSize()));
            f(this.kkU);
            AppMethodBeat.o(88435);
            return;
        }
        this.kkT.setVisibility(8);
        this.kkW.setVisibility(0);
        this.kkS.setVisibility(0);
        f(this.klb);
        this.klc.setText(j.b((Context) this, this.kkk.cKE, this.klc.getTextSize()));
        if ((bo.isNullOrNil(this.kkk.kcn) || "undefined".equals(this.kkk.kcn)) && (bo.isNullOrNil(this.kkk.kco) || "undefined".equals(this.kkk.kco))) {
            this.kkY.setVisibility(8);
            ab.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
        } else {
            this.kkY.setVisibility(0);
        }
        bdc();
        if (!bo.isNullOrNil(this.kkk.kcm)) {
            this.kkX.setText(j.b((Context) this, this.kkk.kcm, this.kkX.getTextSize()));
        }
        AppMethodBeat.o(88435);
    }

    private void f(ImageView imageView) {
        AppMethodBeat.i(88436);
        if (bo.isNullOrNil(this.kkk.kcl)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
            AppMethodBeat.o(88436);
            return;
        }
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this, 20);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePK = e.eSn;
        o.ahq();
        aVar.ePY = null;
        aVar.ePJ = m.Gz(this.kkk.kcl);
        aVar.ePH = true;
        aVar.eQf = true;
        aVar.eQg = 3.0f;
        aVar.ePF = true;
        aVar.ePO = fromDPToPix;
        aVar.ePN = fromDPToPix;
        aVar.ePU = new ColorDrawable(l.Hn("#CCCCCC"));
        o.ahp().a(this.kkk.kcl, imageView, aVar.ahG());
        AppMethodBeat.o(88436);
    }

    private void bcZ() {
        com.tencent.mm.at.a.a.c.a aVar;
        AppMethodBeat.i(88437);
        this.kkE.setVisibility(8);
        this.kky.setVisibility(0);
        this.kkA.setText(this.kkk.kcC);
        this.kkB.setText(this.kkk.kcv + "     " + this.kkk.kcw + this.mController.ylL.getString(R.string.ae_));
        if (bo.isNullOrNil(this.kkk.kcD)) {
            this.kkz.setVisibility(8);
        } else {
            this.kkz.setVisibility(0);
            aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = e.eSn;
            o.ahq();
            aVar.ePY = null;
            aVar.ePJ = m.Gz(this.kkk.kcD);
            aVar.ePH = true;
            aVar.ePF = true;
            o.ahp().a(this.kkk.kcD, this.kkz, aVar.ahG());
        }
        if (bo.isNullOrNil(this.kkk.kcG)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
        } else {
            this.kkA.setTextColor(bo.bS(this.kkk.kcG, getResources().getColor(R.color.h4)));
        }
        if (bo.isNullOrNil(this.kkk.kcH)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
        } else {
            this.kkB.setTextColor(bo.bS(this.kkk.kcH, getResources().getColor(R.color.h4)));
        }
        if (bo.isNullOrNil(this.kkk.kcu)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
        } else {
            aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = e.eSn;
            o.ahq();
            aVar.ePY = null;
            aVar.ePJ = m.Gz(this.kkk.kcu);
            aVar.eQf = true;
            aVar.ePH = true;
            aVar.ePF = true;
            aVar.ePU = new ColorDrawable(l.Hn("#CCCCCC"));
            o.ahp().a(this.kkk.kcu, this.kkD, aVar.ahG());
        }
        if (bo.isNullOrNil(this.kkk.kct)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            AppMethodBeat.o(88437);
            return;
        }
        aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePK = e.eSn;
        o.ahq();
        aVar.ePY = null;
        aVar.ePJ = m.Gz(this.kkk.kct);
        aVar.ePH = true;
        aVar.ePF = true;
        aVar.ePU = new ColorDrawable(l.Hn("#CCCCCC"));
        aVar.eQf = true;
        aVar.eQg = (float) com.tencent.mm.bz.a.fromDPToPix(this, 8);
        o.ahp().a(this.kkk.kct, this.kkC, aVar.ahG());
        AppMethodBeat.o(88437);
    }

    private void bda() {
        com.tencent.mm.at.a.a.c.a aVar;
        AppMethodBeat.i(88438);
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
            this.kkL.setText(R.string.ae_);
            if (bo.isNullOrNil(this.kkk.kcw)) {
                this.kkK.setVisibility(8);
                this.kkL.setVisibility(8);
            }
            if (bo.isNullOrNil(this.kkk.kcI)) {
                ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
            } else {
                this.kkK.setTextColor(bo.bS(this.kkk.kcI, getResources().getColor(R.color.h4)));
            }
        }
        if (bo.isNullOrNil(this.kkk.kcD)) {
            this.kkI.setVisibility(8);
            ab.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        } else {
            this.kkI.setVisibility(0);
            aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = e.eSn;
            o.ahq();
            aVar.ePY = null;
            aVar.ePJ = m.Gz(this.kkk.kcD);
            aVar.ePH = true;
            aVar.ePF = true;
            o.ahp().a(this.kkk.kcD, this.kkI, aVar.ahG());
        }
        if (bo.isNullOrNil(this.kkk.kcC)) {
            this.kkH.setVisibility(8);
            ab.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        } else {
            this.kkH.setVisibility(0);
            this.kkH.setText(this.kkk.kcC);
            if (bo.isNullOrNil(this.kkk.kcG)) {
                ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
            } else {
                this.kkH.setTextColor(bo.bS(this.kkk.kcG, getResources().getColor(R.color.h4)));
            }
        }
        if (bo.isNullOrNil(this.kkk.kcH)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
        } else {
            this.kkJ.setTextColor(bo.bS(this.kkk.kcH, getResources().getColor(R.color.h4)));
        }
        if (bo.isNullOrNil(this.kkk.kcu)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
        } else {
            aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = e.eSn;
            o.ahq();
            aVar.ePY = null;
            aVar.ePJ = m.Gz(this.kkk.kcu);
            aVar.eQf = true;
            aVar.ePH = true;
            aVar.ePF = true;
            aVar.ePU = new ColorDrawable(l.Hn("#CCCCCC"));
            o.ahp().a(this.kkk.kcu, this.kkN, aVar.ahG());
        }
        if (bo.isNullOrNil(this.kkk.kct)) {
            ab.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            AppMethodBeat.o(88438);
            return;
        }
        aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePK = e.eSn;
        o.ahq();
        aVar.ePY = null;
        aVar.ePJ = m.Gz(this.kkk.kct);
        aVar.ePH = true;
        aVar.ePF = true;
        aVar.ePU = new ColorDrawable(l.Hn("#CCCCCC"));
        aVar.eQf = true;
        aVar.eQg = (float) com.tencent.mm.bz.a.fromDPToPix(this, 8);
        o.ahp().a(this.kkk.kct, this.kkM, aVar.ahG());
        AppMethodBeat.o(88438);
    }

    private void bbS() {
        int i = 0;
        AppMethodBeat.i(88439);
        if (this.kkk.kcO.size() > 0) {
            this.kkO.setVisibility(0);
            this.kkR.setVisibility(8);
            if (this.kkk.kcO.size() <= 2) {
                this.kkP.setVisibility(8);
                L(this.kkk.kcO);
                AppMethodBeat.o(88439);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.kkk.kcO.get(0));
            linkedList.add(this.kkk.kcO.get(1));
            L(linkedList);
            this.kkP.setVisibility(0);
            this.kkP.setOnClickListener(this);
            linkedList = new LinkedList();
            while (i < this.kkk.kcO.size()) {
                if (!(i == 0 || i == 1)) {
                    linkedList.add(this.kkk.kcO.get(i));
                }
                i++;
            }
            this.kkR.setAdapter(new c(linkedList));
            b(this.kkR);
            AppMethodBeat.o(88439);
            return;
        }
        this.kkO.setVisibility(8);
        this.kkP.setVisibility(8);
        this.kkR.setVisibility(8);
        AppMethodBeat.o(88439);
    }

    private void L(LinkedList<AcceptedCardItem> linkedList) {
        AppMethodBeat.i(88440);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            AcceptedCardItem acceptedCardItem = (AcceptedCardItem) it.next();
            View inflate = View.inflate(this, R.layout.il, null);
            TextView textView = (TextView) inflate.findViewById(R.id.ad6);
            ((TextView) inflate.findViewById(R.id.ad5)).setText(acceptedCardItem.kcU);
            textView.setText(acceptedCardItem.kcV + this.mController.ylL.getString(R.string.ae_));
            this.kkQ.addView(inflate);
        }
        AppMethodBeat.o(88440);
    }

    private void bdb() {
        AppMethodBeat.i(88441);
        if (this.kkk.kcP.size() > 0) {
            this.klf.setVisibility(0);
            this.kle.setVisibility(0);
            this.kle.setAdapter(new a());
            b(this.kle);
            if (!bo.isNullOrNil(this.kkk.kcQ)) {
                this.kld.setVisibility(0);
                this.kld.setText(this.kkk.kcQ);
            }
            AppMethodBeat.o(88441);
            return;
        }
        this.klf.setVisibility(0);
        this.kle.setVisibility(0);
        this.kld.setVisibility(0);
        if (!bo.isNullOrNil(this.kkk.kcQ)) {
            this.kld.setVisibility(0);
            this.kld.setText(this.kkk.kcQ);
        }
        AppMethodBeat.o(88441);
    }

    private static void b(ListView listView) {
        AppMethodBeat.i(88442);
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            AppMethodBeat.o(88442);
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
        AppMethodBeat.o(88442);
    }

    public final void initView() {
        AppMethodBeat.i(88443);
        this.kkx = (ScrollView) findViewById(R.id.ae3);
        this.kky = (LinearLayout) findViewById(R.id.ae5);
        this.kkz = (ImageView) findViewById(R.id.ae6);
        this.kkA = (TextView) findViewById(R.id.ae7);
        this.kkB = (TextView) findViewById(R.id.ae_);
        this.kkC = (ImageView) findViewById(R.id.ae8);
        this.kkD = (ImageView) findViewById(R.id.ae9);
        this.kkC.setOnClickListener(this);
        this.kkE = (LinearLayout) findViewById(R.id.aea);
        this.kkF = (RelativeLayout) findViewById(R.id.aeb);
        this.kkG = (RelativeLayout) findViewById(R.id.aec);
        this.kkH = (TextView) findViewById(R.id.adm);
        this.kkJ = (TextView) findViewById(R.id.adp);
        this.kkI = (ImageView) findViewById(R.id.ado);
        this.kkK = (TextView) findViewById(R.id.adq);
        this.kkL = (TextView) findViewById(R.id.aed);
        this.kkM = (ImageView) findViewById(R.id.ads);
        this.kkN = (ImageView) findViewById(R.id.adt);
        this.kkM.setOnClickListener(this);
        this.kkO = findViewById(R.id.aeh);
        this.kkP = (TextView) findViewById(R.id.aek);
        this.kkQ = (LinearLayout) findViewById(R.id.aei);
        this.kkR = (ListView) findViewById(R.id.aej);
        this.kkS = (RelativeLayout) findViewById(R.id.ael);
        this.kkT = (LinearLayout) findViewById(R.id.aee);
        this.kkU = (ImageView) findViewById(R.id.aef);
        this.kkV = (TextView) findViewById(R.id.aeg);
        this.kkW = (LinearLayout) findViewById(R.id.aen);
        this.klb = (ImageView) findViewById(R.id.ae0);
        this.klc = (TextView) findViewById(R.id.ae1);
        this.kkX = (TextView) findViewById(R.id.aeo);
        this.kkY = (RelativeLayout) findViewById(R.id.aep);
        this.kkZ = (RelativeLayout) findViewById(R.id.aeq);
        this.kla = (ImageView) findViewById(R.id.adx);
        this.kkY.setOnClickListener(this);
        this.kkZ.setOnClickListener(this);
        this.kld = (TextView) findViewById(R.id.aet);
        this.kle = (ListView) findViewById(R.id.aeu);
        this.klf = (RelativeLayout) findViewById(R.id.aer);
        this.kko = (ProgressBar) findViewById(R.id.adj);
        com.tencent.mm.plugin.card.d.m.d(this);
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88416);
                CardGiftReceiveUI.this.finish();
                AppMethodBeat.o(88416);
                return true;
            }
        });
        AppMethodBeat.o(88443);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(88444);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (mVar instanceof z) {
                ab.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.kkk = ((z) mVar).kdV;
                bbB();
                AppMethodBeat.o(88444);
                return;
            } else if (mVar instanceof t) {
                Intent intent = new Intent(this, CardDetailUI.class);
                LinkedList linkedList = ((t) mVar).kdZ;
                if (linkedList == null || linkedList.size() == 0) {
                    ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
                    AppMethodBeat.o(88444);
                    return;
                }
                com.tencent.mm.plugin.card.base.b bVar = (com.tencent.mm.plugin.card.base.b) linkedList.get(0);
                if (bVar == null || !(bVar instanceof CardInfo)) {
                    ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
                    AppMethodBeat.o(88444);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add((CardInfo) it.next());
                }
                intent.putExtra("key_card_info", (CardInfo) bVar);
                intent.putExtra("key_previous_scene", 27);
                intent.putExtra("key_from_scene", 27);
                intent.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
                intent.putExtra("key_card_git_info", this.kkk);
                startActivity(intent);
                AppMethodBeat.o(88444);
                return;
            }
        } else if (mVar instanceof z) {
            ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            com.tencent.mm.plugin.card.d.d.a(this, str, true);
            AppMethodBeat.o(88444);
            return;
        } else if (mVar instanceof t) {
            ab.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.o(88444);
            return;
        }
        AppMethodBeat.o(88444);
    }

    private void bdc() {
        AppMethodBeat.i(88445);
        if (this.kkk == null || bo.isNullOrNil(this.kkk.kcn)) {
            ab.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
        } else {
            com.tencent.mm.plugin.card.d.a.g(this.kkk.kcn, this.kkk.kcq, this.kkk.kcz, 2);
        }
        if (this.kkk == null || bo.isNullOrNil(this.kkk.kcp)) {
            ab.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
            AppMethodBeat.o(88445);
            return;
        }
        com.tencent.mm.plugin.card.d.a.g(this.kkk.kcp, this.kkk.kcs, this.kkk.kcB, 2);
        AppMethodBeat.o(88445);
    }

    public void onClick(View view) {
        AppMethodBeat.i(88446);
        Intent intent;
        if (view.getId() == R.id.aeq) {
            if (!bo.isNullOrNil(this.kkk.kco)) {
                intent = new Intent(this, CardGiftVideoUI.class);
                intent.putExtra("key_gift_into", this.kkk);
                intent.putExtra("key_is_mute", false);
                startActivity(intent);
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.h.pYm.e(13866, Integer.valueOf(3), this.fhG, com.tencent.mm.a.p.getString(this.fhF));
                AppMethodBeat.o(88446);
                return;
            }
        } else if (view.getId() == R.id.aep) {
            if (this.kko.getVisibility() == 0) {
                AppMethodBeat.o(88446);
                return;
            } else if (!bo.isNullOrNil(this.kkk.kcn)) {
                intent = new Intent(this, CardGiftImageUI.class);
                intent.putExtra("key_gift_into", this.kkk);
                startActivity(intent);
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.h.pYm.e(13866, Integer.valueOf(4), this.fhG, com.tencent.mm.a.p.getString(this.fhF));
                AppMethodBeat.o(88446);
                return;
            }
        } else if (view.getId() == R.id.adf) {
            if (this.kkk != null && this.kkk.kcy) {
                com.tencent.mm.plugin.report.service.h.pYm.e(13866, Integer.valueOf(7), this.fhG, com.tencent.mm.a.p.getString(this.fhF));
                ik ikVar = new ik();
                ikVar.cDz.context = this.mController.ylL;
                ikVar.cDz.scene = 2;
                com.tencent.mm.sdk.b.a.xxA.m(ikVar);
                ab.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
                finish();
                overridePendingTransition(0, 0);
                AppMethodBeat.o(88446);
                return;
            }
        } else if (view.getId() == R.id.ade) {
            if (!TextUtils.isEmpty(this.kkk.kcS) && !TextUtils.isEmpty(this.kkk.kcT)) {
                com.tencent.mm.plugin.card.d.b.d(this.kkk.kcJ, this.kkk.kcS, this.kkk.kcT, FilterEnum4Shaka.MIC_WEISHI_HUAYE, getIntent().getIntExtra("key_from_appbrand_type", 0));
                com.tencent.mm.plugin.report.service.h.pYm.e(13866, Integer.valueOf(8), this.fhG, com.tencent.mm.a.p.getString(this.fhF));
                AppMethodBeat.o(88446);
                return;
            } else if (!bo.isNullOrNil(this.kkk.kcL)) {
                com.tencent.mm.plugin.card.d.b.a((MMActivity) this, this.kkk.kcL, 0);
                com.tencent.mm.plugin.report.service.h.pYm.e(13866, Integer.valueOf(8), this.fhG, com.tencent.mm.a.p.getString(this.fhF));
                AppMethodBeat.o(88446);
                return;
            }
        } else if (view.getId() == R.id.ads || view.getId() == R.id.ae8) {
            if (bo.isNullOrNil(this.kkk.kcM) || bo.isNullOrNil(this.kkk.kcN)) {
                ab.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
                AppMethodBeat.o(88446);
                return;
            }
            LinkedList linkedList = new LinkedList();
            oj ojVar = new oj();
            ojVar.kbU = this.kkk.kcM;
            ojVar.code = this.kkk.kcN;
            linkedList.add(ojVar);
            String stringExtra = getIntent().getStringExtra("key_template_id");
            cdc cdc = new cdc();
            cdc.xcM = stringExtra;
            ab.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", stringExtra);
            g.RO().eJo.a(new t(linkedList, cdc, 27), 0);
            com.tencent.mm.plugin.report.service.h.pYm.e(13866, Integer.valueOf(9), this.fhG, com.tencent.mm.a.p.getString(this.fhF));
            AppMethodBeat.o(88446);
            return;
        } else if (view.getId() == R.id.aek) {
            if (this.kkR.getVisibility() == 0) {
                this.kkR.setVisibility(8);
                this.kkP.setText("查看全部");
                AppMethodBeat.o(88446);
                return;
            }
            this.kkR.setVisibility(0);
            this.kkP.setText("收起");
        }
        AppMethodBeat.o(88446);
    }

    private int ad(int i) {
        AppMethodBeat.i(88434);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, i);
        AppMethodBeat.o(88434);
        return fromDPToPix;
    }

    static /* synthetic */ void a(CardGiftReceiveUI cardGiftReceiveUI, boolean z) {
        AppMethodBeat.i(88447);
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(cardGiftReceiveUI, R.layout.in, null);
        cardGiftReceiveUI.kli = relativeLayout.findViewById(R.id.add);
        cardGiftReceiveUI.klg = (TextView) relativeLayout.findViewById(R.id.ade);
        cardGiftReceiveUI.klh = (TextView) relativeLayout.findViewById(R.id.adf);
        cardGiftReceiveUI.klg.setOnClickListener(cardGiftReceiveUI);
        cardGiftReceiveUI.klh.setOnClickListener(cardGiftReceiveUI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z) {
            if (cardGiftReceiveUI.klf.getVisibility() == 0) {
                layoutParams.addRule(3, R.id.aeu);
            } else {
                layoutParams.addRule(3, R.id.aem);
            }
            layoutParams.bottomMargin = cardGiftReceiveUI.ad(30);
            layoutParams.topMargin = cardGiftReceiveUI.ad(40);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = cardGiftReceiveUI.ad(30);
            layoutParams.topMargin = cardGiftReceiveUI.ad(40);
        }
        LinearLayout.LayoutParams layoutParams2;
        if (cardGiftReceiveUI.klf.getVisibility() == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            if (cardGiftReceiveUI.kkY.getVisibility() == 0) {
                layoutParams2.topMargin = cardGiftReceiveUI.ad(0);
                cardGiftReceiveUI.klf.setLayoutParams(layoutParams2);
            } else {
                layoutParams2.topMargin = cardGiftReceiveUI.ad(60);
            }
            cardGiftReceiveUI.klf.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.klf.addView(relativeLayout, layoutParams);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = cardGiftReceiveUI.ad(60);
            cardGiftReceiveUI.kkS.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kkS.addView(relativeLayout, layoutParams);
        }
        if (bo.isNullOrNil(cardGiftReceiveUI.kkk.kcK)) {
            cardGiftReceiveUI.klg.setVisibility(8);
        } else {
            cardGiftReceiveUI.klg.setVisibility(0);
            cardGiftReceiveUI.klg.setText(cardGiftReceiveUI.kkk.kcK);
        }
        if (bo.isNullOrNil(cardGiftReceiveUI.kkk.kcx)) {
            cardGiftReceiveUI.kli.setVisibility(8);
            cardGiftReceiveUI.klh.setVisibility(8);
        } else {
            cardGiftReceiveUI.kli.setVisibility(0);
            cardGiftReceiveUI.klh.setVisibility(0);
            cardGiftReceiveUI.klh.setText(cardGiftReceiveUI.kkk.kcx);
        }
        if (bo.isNullOrNil(cardGiftReceiveUI.kkk.kcm)) {
            cardGiftReceiveUI.kkS.setVisibility(8);
        }
        AppMethodBeat.o(88447);
    }
}
