package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.R;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;

public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private String kWl;
    private GetEmotionRewardResponse laG;
    private EmojiStoreV2RewardBannerView lek;
    private View lel;
    private MMCopiableTextView lem;
    private TextView len;
    private TextView leo;
    private AnimationDrawable lep;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53688);
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (bo.isNullOrNil(str) || !e.ct(str)) {
                        ab.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                        break;
                    }
                    EmojiStoreV2RewardThanksUI.this.lek.setImageFilePath(str);
                    EmojiStoreV2RewardThanksUI.this.lek.setScaleType(ScaleType.FIT_XY);
                    if (EmojiStoreV2RewardThanksUI.this.lep != null && EmojiStoreV2RewardThanksUI.this.lep.isRunning()) {
                        EmojiStoreV2RewardThanksUI.this.lep.stop();
                        AppMethodBeat.o(53688);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(53688);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2RewardThanksUI() {
        AppMethodBeat.i(53691);
        AppMethodBeat.o(53691);
    }

    public final int getLayoutId() {
        return R.layout.uv;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53692);
        super.onCreate(bundle);
        this.kWl = getIntent().getStringExtra("extra_id");
        initView();
        this.laG = j.getEmojiStorageMgr().xYs.aqq(this.kWl);
        if (this.laG == null) {
            this.lek.setBackgroundDrawable(getResources().getDrawable(R.drawable.a8_));
            this.lek.setImageDrawable(this.lep);
            this.lek.setScaleType(ScaleType.CENTER);
            this.lep.start();
        } else if (this.laG.Reward == null || bo.isNullOrNil(this.laG.Reward.web)) {
            this.lek.setBackgroundDrawable(getResources().getDrawable(R.drawable.a8_));
            this.lek.setImageDrawable(this.lep);
            this.lek.setScaleType(ScaleType.CENTER);
            this.lep.start();
        } else {
            final String str = this.laG.Reward.wec;
            final String K = EmojiLogic.K(b.Yb(), this.kWl, str);
            if (e.ct(K)) {
                this.lek.setImageFilePath(K);
                this.lek.setScaleType(ScaleType.FIT_XY);
                if (this.lep != null && this.lep.isRunning()) {
                    this.lep.stop();
                }
            } else {
                o.ahp().a(str, this.lek, g.k(this.kWl, str, new Object[0]), new i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(53690);
                        if (!bo.isNullOrNil(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = 1001;
                            message.obj = K;
                            EmojiStoreV2RewardThanksUI.this.mHandler.sendMessage(message);
                        }
                        AppMethodBeat.o(53690);
                    }
                });
                this.lek.setBackgroundDrawable(getResources().getDrawable(R.drawable.a8_));
                this.lek.setImageDrawable(this.lep);
                this.lek.setScaleType(ScaleType.CENTER);
                this.lep.start();
            }
        }
        if (this.laG == null || this.laG.Reward == null) {
            this.lel.setVisibility(8);
            AppMethodBeat.o(53692);
            return;
        }
        this.lel.setVisibility(0);
        bo.isNullOrNil(this.laG.Reward.wee);
        this.lem.setVisibility(0);
        this.lem.setText(R.string.bbw);
        this.len.setVisibility(8);
        this.leo.setVisibility(8);
        AppMethodBeat.o(53692);
    }

    public void onDestroy() {
        AppMethodBeat.i(53693);
        if (this.lep != null && this.lep.isRunning()) {
            this.lep.stop();
        }
        super.onDestroy();
        AppMethodBeat.o(53693);
    }

    public final void initView() {
        AppMethodBeat.i(53694);
        setMMTitle((int) R.string.bbv);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53689);
                EmojiStoreV2RewardThanksUI.this.finish();
                AppMethodBeat.o(53689);
                return false;
            }
        });
        this.lek = (EmojiStoreV2RewardBannerView) findViewById(R.id.bgw);
        this.lek.setScale(1.0f);
        this.lel = findViewById(R.id.bgx);
        this.lem = (MMCopiableTextView) findViewById(R.id.bgz);
        this.len = (TextView) findViewById(R.id.bh0);
        this.leo = (TextView) findViewById(R.id.bgy);
        this.lep = (AnimationDrawable) getResources().getDrawable(R.drawable.emoji_doge_loading);
        AppMethodBeat.o(53694);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
