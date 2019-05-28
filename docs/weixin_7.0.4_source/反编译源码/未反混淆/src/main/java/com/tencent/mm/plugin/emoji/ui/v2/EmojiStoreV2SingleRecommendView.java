package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.da;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.i.b;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.v;

public class EmojiStoreV2SingleRecommendView extends RecommendView implements OnClickListener, b {
    private ViewGroup ius;
    private String kWl;
    private g kXT;
    protected final int kYi = 131074;
    private final int kYj = 131075;
    private final int kYk = 131076;
    private final String kYl = "product_id";
    private final String kYm = "progress";
    private final String kYn = "status";
    private ImageView laS;
    private String lbl;
    private ak lda = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53783);
            switch (message.what) {
                case 131074:
                    AppMethodBeat.o(53783);
                    return;
                case 131075:
                    int i = message.getData().getInt("progress");
                    if (bo.isNullOrNil(message.getData().getString("product_id"))) {
                        ab.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        AppMethodBeat.o(53783);
                        return;
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lfH != null) {
                        EmojiStoreV2SingleRecommendView.this.lfH.setVisibility(8);
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lfI != null) {
                        EmojiStoreV2SingleRecommendView.this.lfI.setVisibility(0);
                        EmojiStoreV2SingleRecommendView.this.lfI.setProgress(i);
                        AppMethodBeat.o(53783);
                        return;
                    }
                    break;
                case 131076:
                    message.getData().getInt("status");
                    if (!bo.isNullOrNil(message.getData().getString("product_id"))) {
                        if (EmojiStoreV2SingleRecommendView.this.lfH != null) {
                            EmojiStoreV2SingleRecommendView.this.lfH.setVisibility(0);
                            EmojiStoreV2SingleRecommendView.bmn();
                        }
                        if (EmojiStoreV2SingleRecommendView.this.lfI != null) {
                            EmojiStoreV2SingleRecommendView.this.lfI.setVisibility(8);
                            EmojiStoreV2SingleRecommendView.this.lfI.setProgress(0);
                            break;
                        }
                    }
                    ab.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                    AppMethodBeat.o(53783);
                    return;
                    break;
            }
            AppMethodBeat.o(53783);
        }
    };
    private ImageView lfE;
    private TextView lfF;
    private TextView lfG;
    private Button lfH;
    private ProgressBar lfI;
    private EmojiGroupInfo lfJ;
    private boolean lfK = true;
    private c lfL = new c<da>() {
        {
            AppMethodBeat.i(53784);
            this.xxI = da.class.getName().hashCode();
            AppMethodBeat.o(53784);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53785);
            da daVar = (da) bVar;
            if (daVar instanceof da) {
                EmojiStoreV2SingleRecommendView.this.lbl = daVar.cwf.cwh;
                if (!bo.isNullOrNil(daVar.cwf.cwg) && daVar.cwf.cwg.equalsIgnoreCase(EmojiStoreV2SingleRecommendView.this.kWl)) {
                    EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = EmojiStoreV2SingleRecommendView.this;
                    String str = daVar.cwf.cwg;
                    int i = daVar.cwf.status;
                    int i2 = daVar.cwf.progress;
                    String str2 = daVar.cwf.cwh;
                    ab.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        emojiStoreV2SingleRecommendView.n(obtain);
                    } else {
                        ab.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", Integer.valueOf(i));
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt("status", i);
                        obtain2.what = 131076;
                        emojiStoreV2SingleRecommendView.n(obtain2);
                    }
                }
            }
            AppMethodBeat.o(53785);
            return false;
        }
    };

    static /* synthetic */ void bmn() {
    }

    public EmojiStoreV2SingleRecommendView(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(53786);
        this.lfK = z;
        init();
        AppMethodBeat.o(53786);
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53787);
        init();
        AppMethodBeat.o(53787);
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53788);
        init();
        AppMethodBeat.o(53788);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(53789);
        super.onAttachedToWindow();
        ab.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        a.xxA.c(this.lfL);
        AppMethodBeat.o(53789);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(53790);
        super.onDetachedFromWindow();
        ab.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        a.xxA.d(this.lfL);
        AppMethodBeat.o(53790);
    }

    private void init() {
        AppMethodBeat.i(53791);
        if (this.lfK) {
            this.ius = (ViewGroup) v.hu(getContext()).inflate(R.layout.v1, this);
        } else {
            this.ius = (ViewGroup) v.hu(getContext()).inflate(R.layout.v2, this);
        }
        this.laS = (ImageView) this.ius.findViewById(R.id.bfd);
        this.lfE = (ImageView) this.ius.findViewById(R.id.bhc);
        this.lfF = (TextView) this.ius.findViewById(R.id.bf8);
        this.lfG = (TextView) this.ius.findViewById(R.id.bhd);
        this.lfH = (Button) this.ius.findViewById(R.id.bhe);
        this.lfI = (ProgressBar) this.ius.findViewById(R.id.bfc);
        AppMethodBeat.o(53791);
    }

    public void setProductID(String str) {
        AppMethodBeat.i(53792);
        this.kWl = str;
        if (bo.isNullOrNil(this.kWl)) {
            this.ius.setVisibility(8);
            AppMethodBeat.o(53792);
            return;
        }
        this.lfJ = j.getEmojiStorageMgr().xYo.bZ(this.kWl, false);
        this.laS.setOnClickListener(this);
        this.lfH.setOnClickListener(this);
        this.ius.setOnClickListener(this);
        setTitleName(this.lfJ);
        this.lfI.setVisibility(8);
        o.ahp().a(this.lfJ.field_BigIconUrl, this.lfE, com.tencent.mm.plugin.emoji.e.g.j(this.kWl, this.lfJ.field_BigIconUrl, new Object[0]));
        AppMethodBeat.o(53792);
    }

    private void setTitleName(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(53793);
        if (this.lfH != null) {
            switch (emojiGroupInfo.field_buttonType) {
                case 1:
                    this.lfH.setVisibility(0);
                    this.lfH.setText(R.string.bai);
                    break;
                case 2:
                    this.lfH.setVisibility(0);
                    this.lfH.setText(R.string.czm);
                    break;
                default:
                    this.lfH.setVisibility(8);
                    break;
            }
        }
        if (!bo.isNullOrNil(emojiGroupInfo.field_packName)) {
            this.lfF.setText(emojiGroupInfo.field_packName);
        }
        if (this.lfG != null) {
            if (bo.isNullOrNil(emojiGroupInfo.field_recommandWord)) {
                this.lfG.setVisibility(8);
            } else {
                this.lfG.setVisibility(0);
                this.lfG.setText(emojiGroupInfo.field_recommandWord);
                AppMethodBeat.o(53793);
                return;
            }
        }
        AppMethodBeat.o(53793);
    }

    public final void i(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(53794);
        com.tencent.mm.kernel.g.RO().eJo.a(new g(str, str2, str3), 0);
        AppMethodBeat.o(53794);
    }

    public final void bkf() {
    }

    public final void n(Message message) {
        AppMethodBeat.i(53795);
        if (this.lda != null) {
            this.lda.sendMessage(message);
        }
        AppMethodBeat.o(53795);
    }

    private void f(EmotionSummary emotionSummary) {
        AppMethodBeat.i(53796);
        Intent intent = new Intent();
        intent.setClass(getContext(), EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", emotionSummary.ProductID);
        intent.putExtra("extra_name", emotionSummary.PackName);
        intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
        intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
        intent.putExtra("extra_description", emotionSummary.PackDesc);
        intent.putExtra("extra_price", emotionSummary.PackPrice);
        intent.putExtra("extra_type", emotionSummary.PackType);
        intent.putExtra("extra_flag", emotionSummary.PackFlag);
        intent.putExtra("extra_price_num", emotionSummary.PriceNum);
        intent.putExtra("extra_price_type", emotionSummary.PriceType);
        intent.putExtra("preceding_scence", 108);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", 8);
        intent.putExtra("check_clickflag", false);
        getContext().startActivity(intent);
        AppMethodBeat.o(53796);
    }

    public void onClick(View view) {
        AppMethodBeat.i(53797);
        if (view == this.laS) {
            j.getEmojiStorageMgr().xYo.aqd(this.kWl);
            h.pYm.e(12068, Integer.valueOf(2), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            AppMethodBeat.o(53797);
        } else if (view == this.ius) {
            f(this.lfJ.duw());
            h.pYm.e(12068, Integer.valueOf(4), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            AppMethodBeat.o(53797);
        } else if (view != this.lfH) {
            ab.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
            AppMethodBeat.o(53797);
        } else if (this.lfJ.field_buttonType == 1) {
            this.kXT = new g(this.kWl);
            com.tencent.mm.kernel.g.RO().eJo.a(this.kXT, 0);
            h.pYm.e(12068, Integer.valueOf(3), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            h.pYm.e(12066, Integer.valueOf(0), Integer.valueOf(8), "", this.kWl);
            AppMethodBeat.o(53797);
        } else if (this.lfJ.field_buttonType == 2) {
            f(this.lfJ.duw());
            h.pYm.e(12068, Integer.valueOf(4), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            AppMethodBeat.o(53797);
        } else {
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
            AppMethodBeat.o(53797);
        }
    }
}
