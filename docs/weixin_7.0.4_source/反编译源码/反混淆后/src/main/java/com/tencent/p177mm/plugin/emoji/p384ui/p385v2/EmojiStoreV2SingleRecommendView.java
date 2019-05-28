package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C27740b;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiStoreDetailUI;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.RecommendView;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView */
public class EmojiStoreV2SingleRecommendView extends RecommendView implements OnClickListener, C27740b {
    private ViewGroup ius;
    private String kWl;
    private C42945g kXT;
    protected final int kYi = 131074;
    private final int kYj = 131075;
    private final int kYk = 131076;
    private final String kYl = "product_id";
    private final String kYm = "progress";
    private final String kYn = "status";
    private ImageView laS;
    private String lbl;
    private C7306ak lda = new C115961();
    private ImageView lfE;
    private TextView lfF;
    private TextView lfG;
    private Button lfH;
    private ProgressBar lfI;
    private EmojiGroupInfo lfJ;
    private boolean lfK = true;
    private C4884c lfL = new C115972();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView$1 */
    class C115961 extends C7306ak {
        C115961() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53783);
            switch (message.what) {
                case 131074:
                    AppMethodBeat.m2505o(53783);
                    return;
                case 131075:
                    int i = message.getData().getInt("progress");
                    if (C5046bo.isNullOrNil(message.getData().getString("product_id"))) {
                        C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        AppMethodBeat.m2505o(53783);
                        return;
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lfH != null) {
                        EmojiStoreV2SingleRecommendView.this.lfH.setVisibility(8);
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lfI != null) {
                        EmojiStoreV2SingleRecommendView.this.lfI.setVisibility(0);
                        EmojiStoreV2SingleRecommendView.this.lfI.setProgress(i);
                        AppMethodBeat.m2505o(53783);
                        return;
                    }
                    break;
                case 131076:
                    message.getData().getInt("status");
                    if (!C5046bo.isNullOrNil(message.getData().getString("product_id"))) {
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
                    C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                    AppMethodBeat.m2505o(53783);
                    return;
                    break;
            }
            AppMethodBeat.m2505o(53783);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView$2 */
    class C115972 extends C4884c<C18232da> {
        C115972() {
            AppMethodBeat.m2504i(53784);
            this.xxI = C18232da.class.getName().hashCode();
            AppMethodBeat.m2505o(53784);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53785);
            C18232da c18232da = (C18232da) c4883b;
            if (c18232da instanceof C18232da) {
                EmojiStoreV2SingleRecommendView.this.lbl = c18232da.cwf.cwh;
                if (!C5046bo.isNullOrNil(c18232da.cwf.cwg) && c18232da.cwf.cwg.equalsIgnoreCase(EmojiStoreV2SingleRecommendView.this.kWl)) {
                    EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = EmojiStoreV2SingleRecommendView.this;
                    String str = c18232da.cwf.cwg;
                    int i = c18232da.cwf.status;
                    int i2 = c18232da.cwf.progress;
                    String str2 = c18232da.cwf.cwh;
                    C4990ab.m7411d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        emojiStoreV2SingleRecommendView.mo23319n(obtain);
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", Integer.valueOf(i));
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt("status", i);
                        obtain2.what = 131076;
                        emojiStoreV2SingleRecommendView.mo23319n(obtain2);
                    }
                }
            }
            AppMethodBeat.m2505o(53785);
            return false;
        }
    }

    static /* synthetic */ void bmn() {
    }

    public EmojiStoreV2SingleRecommendView(Context context, boolean z) {
        super(context);
        AppMethodBeat.m2504i(53786);
        this.lfK = z;
        init();
        AppMethodBeat.m2505o(53786);
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53787);
        init();
        AppMethodBeat.m2505o(53787);
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(53788);
        init();
        AppMethodBeat.m2505o(53788);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(53789);
        super.onAttachedToWindow();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        C4879a.xxA.mo10052c(this.lfL);
        AppMethodBeat.m2505o(53789);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(53790);
        super.onDetachedFromWindow();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        C4879a.xxA.mo10053d(this.lfL);
        AppMethodBeat.m2505o(53790);
    }

    private void init() {
        AppMethodBeat.m2504i(53791);
        if (this.lfK) {
            this.ius = (ViewGroup) C5616v.m8409hu(getContext()).inflate(2130969382, this);
        } else {
            this.ius = (ViewGroup) C5616v.m8409hu(getContext()).inflate(2130969383, this);
        }
        this.laS = (ImageView) this.ius.findViewById(2131823518);
        this.lfE = (ImageView) this.ius.findViewById(2131823591);
        this.lfF = (TextView) this.ius.findViewById(2131823512);
        this.lfG = (TextView) this.ius.findViewById(2131823592);
        this.lfH = (Button) this.ius.findViewById(2131823593);
        this.lfI = (ProgressBar) this.ius.findViewById(2131823517);
        AppMethodBeat.m2505o(53791);
    }

    public void setProductID(String str) {
        AppMethodBeat.m2504i(53792);
        this.kWl = str;
        if (C5046bo.isNullOrNil(this.kWl)) {
            this.ius.setVisibility(8);
            AppMethodBeat.m2505o(53792);
            return;
        }
        this.lfJ = C42952j.getEmojiStorageMgr().xYo.mo74770bZ(this.kWl, false);
        this.laS.setOnClickListener(this);
        this.lfH.setOnClickListener(this);
        this.ius.setOnClickListener(this);
        setTitleName(this.lfJ);
        this.lfI.setVisibility(8);
        C32291o.ahp().mo43766a(this.lfJ.field_BigIconUrl, this.lfE, C20364g.m31463j(this.kWl, this.lfJ.field_BigIconUrl, new Object[0]));
        AppMethodBeat.m2505o(53792);
    }

    private void setTitleName(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.m2504i(53793);
        if (this.lfH != null) {
            switch (emojiGroupInfo.field_buttonType) {
                case 1:
                    this.lfH.setVisibility(0);
                    this.lfH.setText(C25738R.string.bai);
                    break;
                case 2:
                    this.lfH.setVisibility(0);
                    this.lfH.setText(C25738R.string.czm);
                    break;
                default:
                    this.lfH.setVisibility(8);
                    break;
            }
        }
        if (!C5046bo.isNullOrNil(emojiGroupInfo.field_packName)) {
            this.lfF.setText(emojiGroupInfo.field_packName);
        }
        if (this.lfG != null) {
            if (C5046bo.isNullOrNil(emojiGroupInfo.field_recommandWord)) {
                this.lfG.setVisibility(8);
            } else {
                this.lfG.setVisibility(0);
                this.lfG.setText(emojiGroupInfo.field_recommandWord);
                AppMethodBeat.m2505o(53793);
                return;
            }
        }
        AppMethodBeat.m2505o(53793);
    }

    /* renamed from: i */
    public final void mo23318i(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(53794);
        C1720g.m3535RO().eJo.mo14541a(new C42945g(str, str2, str3), 0);
        AppMethodBeat.m2505o(53794);
    }

    public final void bkf() {
    }

    /* renamed from: n */
    public final void mo23319n(Message message) {
        AppMethodBeat.m2504i(53795);
        if (this.lda != null) {
            this.lda.sendMessage(message);
        }
        AppMethodBeat.m2505o(53795);
    }

    /* renamed from: f */
    private void m19413f(EmotionSummary emotionSummary) {
        AppMethodBeat.m2504i(53796);
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
        AppMethodBeat.m2505o(53796);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(53797);
        if (view == this.laS) {
            C42952j.getEmojiStorageMgr().xYo.aqd(this.kWl);
            C7060h.pYm.mo8381e(12068, Integer.valueOf(2), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            AppMethodBeat.m2505o(53797);
        } else if (view == this.ius) {
            m19413f(this.lfJ.duw());
            C7060h.pYm.mo8381e(12068, Integer.valueOf(4), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            AppMethodBeat.m2505o(53797);
        } else if (view != this.lfH) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
            AppMethodBeat.m2505o(53797);
        } else if (this.lfJ.field_buttonType == 1) {
            this.kXT = new C42945g(this.kWl);
            C1720g.m3535RO().eJo.mo14541a(this.kXT, 0);
            C7060h.pYm.mo8381e(12068, Integer.valueOf(3), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            C7060h.pYm.mo8381e(12066, Integer.valueOf(0), Integer.valueOf(8), "", this.kWl);
            AppMethodBeat.m2505o(53797);
        } else if (this.lfJ.field_buttonType == 2) {
            m19413f(this.lfJ.duw());
            C7060h.pYm.mo8381e(12068, Integer.valueOf(4), this.kWl, Integer.valueOf(this.lfJ.field_recommandType));
            AppMethodBeat.m2505o(53797);
        } else {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
            AppMethodBeat.m2505o(53797);
        }
    }
}
