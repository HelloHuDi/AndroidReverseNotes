package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI extends MMActivity implements OnScrollListener, f {
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
    private ak lda = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53669);
            switch (message.what) {
                case 1001:
                    if (EmojiStoreV2RewardDetailUI.this.leb != null) {
                        EmojiStoreV2RewardDetailUI.this.leb.setVisibility(8);
                        AppMethodBeat.o(53669);
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
            AppMethodBeat.o(53669);
        }
    };
    private View lea;
    private View leb;
    private a lec;
    private aim led;
    private byte[] lee;
    private m lef;
    private com.tencent.mm.ui.widget.MMLoadScrollView.a leg = new com.tencent.mm.ui.widget.MMLoadScrollView.a() {
        public final void bmh() {
            AppMethodBeat.i(53670);
            ab.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
            EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
            AppMethodBeat.o(53670);
        }
    };
    private ListView mListView;

    class a extends BaseAdapter {
        private Bitmap cdX = null;
        int iWJ;
        private int kSw;
        int lcR;
        private LinkedList<EmotionDonor> lei;
        boolean lej = false;
        private Context mContext;
        private int mNumColumns = 1;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(53677);
            EmotionDonor uj = uj(i);
            AppMethodBeat.o(53677);
            return uj;
        }

        public a(Context context) {
            AppMethodBeat.i(53672);
            this.mContext = context;
            this.lcR = com.tencent.mm.bz.a.al(EmojiStoreV2RewardDetailUI.this.mController.ylL, R.dimen.a0e);
            int gd = com.tencent.mm.bz.a.gd(EmojiStoreV2RewardDetailUI.this.mController.ylL) - (com.tencent.mm.bz.a.al(EmojiStoreV2RewardDetailUI.this.mController.ylL, R.dimen.l5) * 2);
            int i = this.lcR;
            int al = com.tencent.mm.bz.a.al(EmojiStoreV2RewardDetailUI.this.mController.ylL, R.dimen.le);
            int i2 = gd / (i + al);
            if ((gd - (i2 * i)) - (al * (i2 - 1)) > i) {
                i2++;
            }
            this.mNumColumns = i2;
            this.kSw = com.tencent.mm.bz.a.gd(this.mContext);
            this.iWJ = (int) (((float) (this.kSw - (this.mNumColumns * this.lcR))) / (((float) this.mNumColumns) + 1.0f));
            try {
                this.cdX = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
                AppMethodBeat.o(53672);
            } catch (IOException e) {
                ab.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", bo.dpG());
                AppMethodBeat.o(53672);
            }
        }

        public final void Q(LinkedList<EmotionDonor> linkedList) {
            AppMethodBeat.i(53673);
            if (this.lei == null) {
                this.lei = new LinkedList();
            }
            if (this.lej) {
                this.lei.clear();
                this.lej = false;
            }
            this.lei.addAll(linkedList);
            notifyDataSetChanged();
            AppMethodBeat.o(53673);
        }

        public final int getCount() {
            AppMethodBeat.i(53674);
            int size = this.lei == null ? 0 : this.lei.size();
            if (size > 0) {
                size = (int) Math.ceil((double) (((float) size) / ((float) this.mNumColumns)));
                AppMethodBeat.o(53674);
                return size;
            }
            AppMethodBeat.o(53674);
            return size;
        }

        private EmotionDonor uj(int i) {
            AppMethodBeat.i(53675);
            if (this.lei != null) {
                int i2;
                if (this.lei == null) {
                    i2 = 0;
                } else {
                    i2 = this.lei.size();
                }
                if (i < i2) {
                    EmotionDonor emotionDonor = (EmotionDonor) this.lei.get(i);
                    AppMethodBeat.o(53675);
                    return emotionDonor;
                }
            }
            AppMethodBeat.o(53675);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(53676);
            if (view == null || view.getTag() == null) {
                view = new LinearLayout(this.mContext);
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                view.setBackgroundResource(R.drawable.a8g);
                view.setOrientation(0);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, this.iWJ);
                bVar = new b();
                bVar.kSC = view;
                view.setTag(bVar);
                for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.lcR, this.lcR);
                    layoutParams2.leftMargin = this.iWJ;
                    bVar.kSC.addView(new SquareImageView(this.mContext), i2, layoutParams2);
                }
            } else {
                bVar = (b) view.getTag();
            }
            for (int i3 = 0; i3 < this.mNumColumns; i3++) {
                ImageView imageView = (SquareImageView) bVar.kSC.getChildAt(i3);
                EmotionDonor uj = uj((this.mNumColumns * i) + i3);
                if (uj != null) {
                    imageView.setVisibility(0);
                    if (bo.isNullOrNil(uj.HeadUrl)) {
                        imageView.setImageBitmap(this.cdX);
                    } else {
                        o.ahp().a(uj.HeadUrl, imageView, g.u(EmojiStoreV2RewardDetailUI.this.kWl, uj.HeadUrl, this.lcR));
                    }
                } else {
                    imageView.setVisibility(8);
                }
            }
            AppMethodBeat.o(53676);
            return view;
        }
    }

    class b {
        LinearLayout kSC;

        b() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2RewardDetailUI() {
        AppMethodBeat.i(53678);
        AppMethodBeat.o(53678);
    }

    static /* synthetic */ void b(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
        AppMethodBeat.i(53687);
        emojiStoreV2RewardDetailUI.gx(true);
        AppMethodBeat.o(53687);
    }

    public final int getLayoutId() {
        return R.layout.ur;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53679);
        super.onCreate(bundle);
        this.kWl = getIntent().getStringExtra("extra_id");
        this.kWA = getIntent().getStringExtra("extra_name");
        this.ldU = getIntent().getStringExtra("extra_iconurl");
        this.ldV = getIntent().getStringExtra("name");
        initView();
        this.laG = j.getEmojiStorageMgr().xYs.aqq(this.kWl);
        bmg();
        o.ahp().a(this.ldU, this.ldW, g.dH(this.kWl, this.ldU));
        this.ldX.setText(this.kWA);
        this.ldY.setText(this.ldV);
        if (this.led != null) {
            this.lec.Q(this.led.Donors);
            this.lec.lej = true;
        }
        if (this.laG != null) {
            this.ldZ.setText(getString(R.string.bbi, new Object[]{Integer.valueOf(this.laG.DonorNum)}));
        }
        com.tencent.mm.kernel.g.RO().eJo.a(299, (f) this);
        AppMethodBeat.o(53679);
    }

    public void onPause() {
        AppMethodBeat.i(53680);
        super.onPause();
        AppMethodBeat.o(53680);
    }

    public void onDestroy() {
        AppMethodBeat.i(53681);
        super.onDestroy();
        com.tencent.mm.kernel.g.RO().eJo.b(299, (f) this);
        o.ahp().cm(0);
        AppMethodBeat.o(53681);
    }

    public final void initView() {
        AppMethodBeat.i(53682);
        setMMTitle((int) R.string.bbh);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53671);
                EmojiStoreV2RewardDetailUI.this.finish();
                AppMethodBeat.o(53671);
                return false;
            }
        });
        this.abB = v.hu(this.mController.ylL).inflate(R.layout.us, null);
        this.ldW = (ImageView) this.abB.findViewById(R.id.bfx);
        this.ldX = (TextView) this.abB.findViewById(R.id.bgt);
        this.ldY = (TextView) this.abB.findViewById(R.id.bg2);
        this.ldZ = (TextView) this.abB.findViewById(R.id.bgu);
        this.lea = findViewById(R.id.l_);
        this.mListView = (ListView) findViewById(R.id.bgr);
        this.leb = v.hu(this.mController.ylL).inflate(R.layout.u_, null);
        this.leb.setVisibility(8);
        this.mListView.addHeaderView(this.abB);
        this.mListView.addFooterView(this.leb);
        this.lec = new a(this);
        this.mListView.setAdapter(this.lec);
        this.mListView.setOnScrollListener(this);
        AppMethodBeat.o(53682);
    }

    private void bmg() {
        AppMethodBeat.i(53683);
        this.lef = new m(this.kWl, this.lee);
        com.tencent.mm.kernel.g.RO().eJo.a(this.lef, 0);
        AppMethodBeat.o(53683);
    }

    private void gx(boolean z) {
        AppMethodBeat.i(53684);
        if (!(this.isLoading || this.kYc == 0)) {
            bmg();
            this.isLoading = true;
            if (z) {
                this.lda.sendEmptyMessageDelayed(1002, 200);
            }
        }
        AppMethodBeat.o(53684);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(53686);
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (this.kYc == 0 || this.isLoading) {
                ab.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
                AppMethodBeat.o(53686);
                return;
            }
            gx(true);
            ab.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
            o.ahp().cm(i);
        }
        AppMethodBeat.o(53686);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        int i3 = 1;
        AppMethodBeat.i(53685);
        this.isLoading = false;
        if (this.leb != null) {
            this.leb.setVisibility(8);
            this.lda.removeMessages(1002);
            this.lda.sendEmptyMessageDelayed(1001, 200);
        }
        switch (mVar.getType()) {
            case 299:
                m mVar2 = (m) mVar;
                if (i != 0 && i != 4) {
                    ab.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", Integer.valueOf(i));
                    break;
                }
                this.lee = mVar2.kWS;
                if (i2 == 0) {
                    this.kYc = 0;
                    if (mVar2.bkA() != null) {
                        this.lec.Q(mVar2.bkA().Donors);
                        AppMethodBeat.o(53685);
                        return;
                    }
                } else if (i2 == 2) {
                    this.kYc = 2;
                    if (mVar2.bkA() != null) {
                        this.lec.Q(mVar2.bkA().Donors);
                    }
                    if (!(this.lec == null || this.abB == null)) {
                        a aVar = this.lec;
                        ab.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", Integer.valueOf(aVar.iWJ + aVar.lcR), Integer.valueOf(this.abB.getHeight()), Integer.valueOf(com.tencent.mm.bz.a.ge(this)));
                        if (com.tencent.mm.bz.a.ge(this) > ((aVar.iWJ + aVar.lcR) * this.lec.getCount()) + this.abB.getHeight()) {
                            i3 = 0;
                        }
                    }
                    if (i3 == 0) {
                        gx(false);
                        AppMethodBeat.o(53685);
                        return;
                    }
                } else if (i2 == 3) {
                    this.kYc = 1;
                    this.lee = null;
                    this.lec.lej = true;
                    gx(false);
                    AppMethodBeat.o(53685);
                    return;
                }
                break;
        }
        AppMethodBeat.o(53685);
    }
}
