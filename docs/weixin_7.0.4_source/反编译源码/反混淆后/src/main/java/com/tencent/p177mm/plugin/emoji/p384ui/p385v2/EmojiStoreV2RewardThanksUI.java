package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p384ui.widget.MMCopiableTextView;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI */
public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private String kWl;
    private GetEmotionRewardResponse laG;
    private EmojiStoreV2RewardBannerView lek;
    private View lel;
    private MMCopiableTextView lem;
    private TextView len;
    private TextView leo;
    private AnimationDrawable lep;
    private C7306ak mHandler = new C277711();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI$2 */
    class C204162 implements OnMenuItemClickListener {
        C204162() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53689);
            EmojiStoreV2RewardThanksUI.this.finish();
            AppMethodBeat.m2505o(53689);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI$1 */
    class C277711 extends C7306ak {
        C277711() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53688);
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                        break;
                    }
                    EmojiStoreV2RewardThanksUI.this.lek.setImageFilePath(str);
                    EmojiStoreV2RewardThanksUI.this.lek.setScaleType(ScaleType.FIT_XY);
                    if (EmojiStoreV2RewardThanksUI.this.lep != null && EmojiStoreV2RewardThanksUI.this.lep.isRunning()) {
                        EmojiStoreV2RewardThanksUI.this.lep.stop();
                        AppMethodBeat.m2505o(53688);
                        return;
                    }
                    break;
            }
            AppMethodBeat.m2505o(53688);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreV2RewardThanksUI() {
        AppMethodBeat.m2504i(53691);
        AppMethodBeat.m2505o(53691);
    }

    public final int getLayoutId() {
        return 2130969376;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53692);
        super.onCreate(bundle);
        this.kWl = getIntent().getStringExtra("extra_id");
        initView();
        this.laG = C42952j.getEmojiStorageMgr().xYs.aqq(this.kWl);
        if (this.laG == null) {
            this.lek.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.a8_));
            this.lek.setImageDrawable(this.lep);
            this.lek.setScaleType(ScaleType.CENTER);
            this.lep.start();
        } else if (this.laG.Reward == null || C5046bo.isNullOrNil(this.laG.Reward.web)) {
            this.lek.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.a8_));
            this.lek.setImageDrawable(this.lep);
            this.lek.setScaleType(ScaleType.CENTER);
            this.lep.start();
        } else {
            final String str = this.laG.Reward.wec;
            final String K = EmojiLogic.m44072K(C2933b.m5221Yb(), this.kWl, str);
            if (C5730e.m8628ct(K)) {
                this.lek.setImageFilePath(K);
                this.lek.setScaleType(ScaleType.FIT_XY);
                if (this.lep != null && this.lep.isRunning()) {
                    this.lep.stop();
                }
            } else {
                C32291o.ahp().mo43768a(str, this.lek, C20364g.m31464k(this.kWl, str, new Object[0]), new C1282i() {
                    /* renamed from: a */
                    public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.m2504i(53690);
                        if (!C5046bo.isNullOrNil(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = 1001;
                            message.obj = K;
                            EmojiStoreV2RewardThanksUI.this.mHandler.sendMessage(message);
                        }
                        AppMethodBeat.m2505o(53690);
                    }
                });
                this.lek.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.a8_));
                this.lek.setImageDrawable(this.lep);
                this.lek.setScaleType(ScaleType.CENTER);
                this.lep.start();
            }
        }
        if (this.laG == null || this.laG.Reward == null) {
            this.lel.setVisibility(8);
            AppMethodBeat.m2505o(53692);
            return;
        }
        this.lel.setVisibility(0);
        C5046bo.isNullOrNil(this.laG.Reward.wee);
        this.lem.setVisibility(0);
        this.lem.setText(C25738R.string.bbw);
        this.len.setVisibility(8);
        this.leo.setVisibility(8);
        AppMethodBeat.m2505o(53692);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53693);
        if (this.lep != null && this.lep.isRunning()) {
            this.lep.stop();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(53693);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53694);
        setMMTitle((int) C25738R.string.bbv);
        setBackBtn(new C204162());
        this.lek = (EmojiStoreV2RewardBannerView) findViewById(2131823574);
        this.lek.setScale(1.0f);
        this.lel = findViewById(2131823575);
        this.lem = (MMCopiableTextView) findViewById(2131823577);
        this.len = (TextView) findViewById(2131823578);
        this.leo = (TextView) findViewById(2131823576);
        this.lep = (AnimationDrawable) getResources().getDrawable(C25738R.drawable.emoji_doge_loading);
        AppMethodBeat.m2505o(53694);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
