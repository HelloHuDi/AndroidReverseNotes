package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMLoadScrollView.C36354a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p384ui.SquareImageView;
import com.tencent.p177mm.plugin.emoji.p726f.C20374m;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.protocal.protobuf.EmotionDonor;
import com.tencent.p177mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.p177mm.protocal.protobuf.aim;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI */
public class EmojiStoreV2RewardDetailUI extends MMActivity implements OnScrollListener, C1202f {
    private View abB;
    private boolean isLoading = false;
    private String kWA;
    private String kWl;
    private int kYc = -1;
    private GetEmotionRewardResponse laG;
    private String ldU;
    private String ldV;
    private ImageView ldW;
    private TextView ldX;
    private TextView ldY;
    private TextView ldZ;
    private C7306ak lda = new C204151();
    private View lea;
    private View leb;
    private C42962a lec;
    private aim led;
    private byte[] lee;
    private C20374m lef;
    private C36354a leg = new C115922();
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI$2 */
    class C115922 implements C36354a {
        C115922() {
        }

        public final void bmh() {
            AppMethodBeat.m2504i(53670);
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
            EmojiStoreV2RewardDetailUI.m84943b(EmojiStoreV2RewardDetailUI.this);
            AppMethodBeat.m2505o(53670);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI$1 */
    class C204151 extends C7306ak {
        C204151() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53669);
            switch (message.what) {
                case 1001:
                    if (EmojiStoreV2RewardDetailUI.this.leb != null) {
                        EmojiStoreV2RewardDetailUI.this.leb.setVisibility(8);
                        AppMethodBeat.m2505o(53669);
                        return;
                    }
                    break;
                case 1002:
                    if (EmojiStoreV2RewardDetailUI.this.leb != null) {
                        EmojiStoreV2RewardDetailUI.this.leb.setVisibility(0);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(53669);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI$3 */
    class C277703 implements OnMenuItemClickListener {
        C277703() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53671);
            EmojiStoreV2RewardDetailUI.this.finish();
            AppMethodBeat.m2505o(53671);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI$a */
    class C42962a extends BaseAdapter {
        private Bitmap cdX = null;
        int iWJ;
        private int kSw;
        int lcR;
        private LinkedList<EmotionDonor> lei;
        boolean lej = false;
        private Context mContext;
        private int mNumColumns = 1;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(53677);
            EmotionDonor uj = m76293uj(i);
            AppMethodBeat.m2505o(53677);
            return uj;
        }

        public C42962a(Context context) {
            AppMethodBeat.m2504i(53672);
            this.mContext = context;
            this.lcR = C1338a.m2856al(EmojiStoreV2RewardDetailUI.this.mController.ylL, C25738R.dimen.a0e);
            int gd = C1338a.m2868gd(EmojiStoreV2RewardDetailUI.this.mController.ylL) - (C1338a.m2856al(EmojiStoreV2RewardDetailUI.this.mController.ylL, C25738R.dimen.f9948l5) * 2);
            int i = this.lcR;
            int al = C1338a.m2856al(EmojiStoreV2RewardDetailUI.this.mController.ylL, C25738R.dimen.f9958le);
            int i2 = gd / (i + al);
            if ((gd - (i2 * i)) - (al * (i2 - 1)) > i) {
                i2++;
            }
            this.mNumColumns = i2;
            this.kSw = C1338a.m2868gd(this.mContext);
            this.iWJ = (int) (((float) (this.kSw - (this.mNumColumns * this.lcR))) / (((float) this.mNumColumns) + 1.0f));
            try {
                this.cdX = C4977b.m7372b(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
                AppMethodBeat.m2505o(53672);
            } catch (IOException e) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", C5046bo.dpG());
                AppMethodBeat.m2505o(53672);
            }
        }

        /* renamed from: Q */
        public final void mo68484Q(LinkedList<EmotionDonor> linkedList) {
            AppMethodBeat.m2504i(53673);
            if (this.lei == null) {
                this.lei = new LinkedList();
            }
            if (this.lej) {
                this.lei.clear();
                this.lej = false;
            }
            this.lei.addAll(linkedList);
            notifyDataSetChanged();
            AppMethodBeat.m2505o(53673);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(53674);
            int size = this.lei == null ? 0 : this.lei.size();
            if (size > 0) {
                size = (int) Math.ceil((double) (((float) size) / ((float) this.mNumColumns)));
                AppMethodBeat.m2505o(53674);
                return size;
            }
            AppMethodBeat.m2505o(53674);
            return size;
        }

        /* renamed from: uj */
        private EmotionDonor m76293uj(int i) {
            AppMethodBeat.m2504i(53675);
            if (this.lei != null) {
                int i2;
                if (this.lei == null) {
                    i2 = 0;
                } else {
                    i2 = this.lei.size();
                }
                if (i < i2) {
                    EmotionDonor emotionDonor = (EmotionDonor) this.lei.get(i);
                    AppMethodBeat.m2505o(53675);
                    return emotionDonor;
                }
            }
            AppMethodBeat.m2505o(53675);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C42963b c42963b;
            AppMethodBeat.m2504i(53676);
            if (view == null || view.getTag() == null) {
                view = new LinearLayout(this.mContext);
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                view.setBackgroundResource(C25738R.drawable.a8g);
                view.setOrientation(0);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, this.iWJ);
                c42963b = new C42963b();
                c42963b.kSC = view;
                view.setTag(c42963b);
                for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.lcR, this.lcR);
                    layoutParams2.leftMargin = this.iWJ;
                    c42963b.kSC.addView(new SquareImageView(this.mContext), i2, layoutParams2);
                }
            } else {
                c42963b = (C42963b) view.getTag();
            }
            for (int i3 = 0; i3 < this.mNumColumns; i3++) {
                ImageView imageView = (SquareImageView) c42963b.kSC.getChildAt(i3);
                EmotionDonor uj = m76293uj((this.mNumColumns * i) + i3);
                if (uj != null) {
                    imageView.setVisibility(0);
                    if (C5046bo.isNullOrNil(uj.HeadUrl)) {
                        imageView.setImageBitmap(this.cdX);
                    } else {
                        C32291o.ahp().mo43766a(uj.HeadUrl, imageView, C20364g.m31468u(EmojiStoreV2RewardDetailUI.this.kWl, uj.HeadUrl, this.lcR));
                    }
                } else {
                    imageView.setVisibility(8);
                }
            }
            AppMethodBeat.m2505o(53676);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI$b */
    class C42963b {
        LinearLayout kSC;

        C42963b() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreV2RewardDetailUI() {
        AppMethodBeat.m2504i(53678);
        AppMethodBeat.m2505o(53678);
    }

    /* renamed from: b */
    static /* synthetic */ void m84943b(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
        AppMethodBeat.m2504i(53687);
        emojiStoreV2RewardDetailUI.m84945gx(true);
        AppMethodBeat.m2505o(53687);
    }

    public final int getLayoutId() {
        return 2130969372;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53679);
        super.onCreate(bundle);
        this.kWl = getIntent().getStringExtra("extra_id");
        this.kWA = getIntent().getStringExtra("extra_name");
        this.ldU = getIntent().getStringExtra("extra_iconurl");
        this.ldV = getIntent().getStringExtra("name");
        initView();
        this.laG = C42952j.getEmojiStorageMgr().xYs.aqq(this.kWl);
        bmg();
        C32291o.ahp().mo43766a(this.ldU, this.ldW, C20364g.m31459dH(this.kWl, this.ldU));
        this.ldX.setText(this.kWA);
        this.ldY.setText(this.ldV);
        if (this.led != null) {
            this.lec.mo68484Q(this.led.Donors);
            this.lec.lej = true;
        }
        if (this.laG != null) {
            this.ldZ.setText(getString(C25738R.string.bbi, new Object[]{Integer.valueOf(this.laG.DonorNum)}));
        }
        C1720g.m3535RO().eJo.mo14539a(299, (C1202f) this);
        AppMethodBeat.m2505o(53679);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53680);
        super.onPause();
        AppMethodBeat.m2505o(53680);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53681);
        super.onDestroy();
        C1720g.m3535RO().eJo.mo14546b(299, (C1202f) this);
        C32291o.ahp().mo43773cm(0);
        AppMethodBeat.m2505o(53681);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53682);
        setMMTitle((int) C25738R.string.bbh);
        setBackBtn(new C277703());
        this.abB = C5616v.m8409hu(this.mController.ylL).inflate(2130969373, null);
        this.ldW = (ImageView) this.abB.findViewById(2131823538);
        this.ldX = (TextView) this.abB.findViewById(2131823571);
        this.ldY = (TextView) this.abB.findViewById(2131823543);
        this.ldZ = (TextView) this.abB.findViewById(2131823572);
        this.lea = findViewById(2131820987);
        this.mListView = (ListView) findViewById(2131823569);
        this.leb = C5616v.m8409hu(this.mController.ylL).inflate(2130969354, null);
        this.leb.setVisibility(8);
        this.mListView.addHeaderView(this.abB);
        this.mListView.addFooterView(this.leb);
        this.lec = new C42962a(this);
        this.mListView.setAdapter(this.lec);
        this.mListView.setOnScrollListener(this);
        AppMethodBeat.m2505o(53682);
    }

    private void bmg() {
        AppMethodBeat.m2504i(53683);
        this.lef = new C20374m(this.kWl, this.lee);
        C1720g.m3535RO().eJo.mo14541a(this.lef, 0);
        AppMethodBeat.m2505o(53683);
    }

    /* renamed from: gx */
    private void m84945gx(boolean z) {
        AppMethodBeat.m2504i(53684);
        if (!(this.isLoading || this.kYc == 0)) {
            bmg();
            this.isLoading = true;
            if (z) {
                this.lda.sendEmptyMessageDelayed(1002, 200);
            }
        }
        AppMethodBeat.m2505o(53684);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(53686);
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (this.kYc == 0 || this.isLoading) {
                C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
                AppMethodBeat.m2505o(53686);
                return;
            }
            m84945gx(true);
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
            C32291o.ahp().mo43773cm(i);
        }
        AppMethodBeat.m2505o(53686);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 1;
        AppMethodBeat.m2504i(53685);
        this.isLoading = false;
        if (this.leb != null) {
            this.leb.setVisibility(8);
            this.lda.removeMessages(1002);
            this.lda.sendEmptyMessageDelayed(1001, 200);
        }
        switch (c1207m.getType()) {
            case 299:
                C20374m c20374m = (C20374m) c1207m;
                if (i != 0 && i != 4) {
                    C4990ab.m7421w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", Integer.valueOf(i));
                    break;
                }
                this.lee = c20374m.kWS;
                if (i2 == 0) {
                    this.kYc = 0;
                    if (c20374m.bkA() != null) {
                        this.lec.mo68484Q(c20374m.bkA().Donors);
                        AppMethodBeat.m2505o(53685);
                        return;
                    }
                } else if (i2 == 2) {
                    this.kYc = 2;
                    if (c20374m.bkA() != null) {
                        this.lec.mo68484Q(c20374m.bkA().Donors);
                    }
                    if (!(this.lec == null || this.abB == null)) {
                        C42962a c42962a = this.lec;
                        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", Integer.valueOf(c42962a.iWJ + c42962a.lcR), Integer.valueOf(this.abB.getHeight()), Integer.valueOf(C1338a.m2869ge(this)));
                        if (C1338a.m2869ge(this) > ((c42962a.iWJ + c42962a.lcR) * this.lec.getCount()) + this.abB.getHeight()) {
                            i3 = 0;
                        }
                    }
                    if (i3 == 0) {
                        m84945gx(false);
                        AppMethodBeat.m2505o(53685);
                        return;
                    }
                } else if (i2 == 3) {
                    this.kYc = 1;
                    this.lee = null;
                    this.lec.lej = true;
                    m84945gx(false);
                    AppMethodBeat.m2505o(53685);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(53685);
    }
}
