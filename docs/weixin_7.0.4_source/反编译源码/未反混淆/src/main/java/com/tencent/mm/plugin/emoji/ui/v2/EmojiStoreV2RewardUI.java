package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.v;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI extends MMActivity implements OnItemClickListener, f {
    private ProgressDialog gqo;
    private int kVD;
    private String kVJ;
    private String kWl;
    private GetEmotionRewardResponse laG;
    private Button lbf;
    private b leA;
    private com.tencent.mm.plugin.emoji.f.b leB;
    private String leC;
    private String leD;
    private a leE = a.NORMAL;
    private boolean leF = false;
    private OnClickListener leG = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53696);
            if (EmojiStoreV2RewardUI.this.leA != null) {
                EmotionPrice uk = EmojiStoreV2RewardUI.this.leA.uk(0);
                if (EmojiStoreV2RewardUI.this.lex.getText() != null) {
                    uk.Number = EmojiStoreV2RewardUI.this.lex.getText().toString();
                    EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.this.kWl, uk);
                    AppMethodBeat.o(53696);
                    return;
                }
                ab.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
                AppMethodBeat.o(53696);
                return;
            }
            ab.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
            AppMethodBeat.o(53696);
        }
    };
    private OnClickListener leH = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53697);
            if (EmojiStoreV2RewardUI.this.leE == a.NORMAL) {
                EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, a.CUSTOM);
            }
            AppMethodBeat.o(53697);
        }
    };
    private TextWatcher leI = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(53698);
            if (EmojiStoreV2RewardUI.this.lbf != null) {
                if (editable != null && editable.length() > 0) {
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    if (indexOf > 0 && (obj.length() - indexOf) - 1 > 2) {
                        editable.delete(indexOf + 3, indexOf + 4);
                    }
                    float f = 0.0f;
                    try {
                        f = Float.valueOf(editable.toString()).floatValue();
                    } catch (NumberFormatException e) {
                    }
                    if (f > 200.0f || f < 1.0f) {
                        EmojiStoreV2RewardUI.this.lex.getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.mController.ylL.getResources().getColor(R.color.xy));
                    } else {
                        EmojiStoreV2RewardUI.this.lex.getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.mController.ylL.getResources().getColor(R.color.w4));
                        EmojiStoreV2RewardUI.this.lbf.setEnabled(true);
                        AppMethodBeat.o(53698);
                        return;
                    }
                }
                EmojiStoreV2RewardUI.this.lbf.setEnabled(false);
            }
            AppMethodBeat.o(53698);
        }
    };
    private h leJ = new h(new i() {
        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(53699);
            if (!bo.isNullOrNil(str) && str.equalsIgnoreCase(EmojiStoreV2RewardUI.this.leC)) {
                Message message = new Message();
                message.what = 1001;
                message.obj = EmojiStoreV2RewardUI.this.leD;
                EmojiStoreV2RewardUI.this.mHandler.sendMessage(message);
            }
            AppMethodBeat.o(53699);
        }
    });
    private AnimationDrawable lep;
    private int les;
    private EmojiStoreV2RewardBannerView let;
    private GridInScrollView leu;
    private View lev;
    private View lew;
    private MMFormInputView lex;
    private TextView ley;
    private TextView lez;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53695);
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (bo.isNullOrNil(str) || !e.ct(str)) {
                        ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
                        AppMethodBeat.o(53695);
                        return;
                    }
                    EmojiStoreV2RewardUI.this.let.setImageFilePath(str);
                    EmojiStoreV2RewardUI.this.let.setScaleType(ScaleType.FIT_XY);
                    if (EmojiStoreV2RewardUI.this.lep != null && EmojiStoreV2RewardUI.this.lep.isRunning()) {
                        EmojiStoreV2RewardUI.this.lep.stop();
                        AppMethodBeat.o(53695);
                        return;
                    }
                    break;
                case 1002:
                    EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this);
                    break;
            }
            AppMethodBeat.o(53695);
        }
    };

    class b extends BaseAdapter {
        private LinkedList<EmotionPrice> lei;

        b() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(53710);
            EmotionPrice uk = uk(i);
            AppMethodBeat.o(53710);
            return uk;
        }

        public final void Q(LinkedList<EmotionPrice> linkedList) {
            AppMethodBeat.i(53706);
            if (this.lei == null) {
                this.lei = new LinkedList();
            }
            this.lei.clear();
            this.lei.addAll(linkedList);
            notifyDataSetChanged();
            AppMethodBeat.o(53706);
        }

        public final int getCount() {
            AppMethodBeat.i(53707);
            if (this.lei == null) {
                AppMethodBeat.o(53707);
                return 0;
            }
            int size = this.lei.size();
            AppMethodBeat.o(53707);
            return size;
        }

        public final EmotionPrice uk(int i) {
            AppMethodBeat.i(53708);
            if (i < 0 || i > getCount()) {
                AppMethodBeat.o(53708);
                return null;
            } else if (this.lei == null) {
                AppMethodBeat.o(53708);
                return null;
            } else {
                EmotionPrice emotionPrice = (EmotionPrice) this.lei.get(i);
                AppMethodBeat.o(53708);
                return emotionPrice;
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(53709);
            if (view == null || view.getTag() == null) {
                view = v.hu(EmojiStoreV2RewardUI.this.mController.ylL).inflate(R.layout.uu, null);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            EmotionPrice uk = uk(i);
            if (uk != null) {
                cVar.leO.setVisibility(0);
                cVar.leO.setText(uk.Number + uk.Label);
            } else {
                cVar.leO.setVisibility(8);
            }
            AppMethodBeat.o(53709);
            return view;
        }
    }

    enum a {
        NORMAL,
        CUSTOM;

        static {
            AppMethodBeat.o(53705);
        }
    }

    class c {
        TextView leO;

        public c(View view) {
            AppMethodBeat.i(53711);
            this.leO = (TextView) view.findViewById(R.id.bgv);
            AppMethodBeat.o(53711);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2RewardUI() {
        AppMethodBeat.i(53712);
        AppMethodBeat.o(53712);
    }

    static /* synthetic */ void a(EmojiStoreV2RewardUI emojiStoreV2RewardUI, String str, EmotionPrice emotionPrice) {
        AppMethodBeat.i(53727);
        emojiStoreV2RewardUI.a(str, emotionPrice);
        AppMethodBeat.o(53727);
    }

    static /* synthetic */ void c(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        AppMethodBeat.i(53726);
        emojiStoreV2RewardUI.cu();
        AppMethodBeat.o(53726);
    }

    public final int getLayoutId() {
        return R.layout.uw;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53713);
        super.onCreate(bundle);
        this.kWl = getIntent().getStringExtra("extra_id");
        this.kVJ = getIntent().getStringExtra("name");
        this.kVD = getIntent().getIntExtra("scene", 0);
        this.les = getIntent().getIntExtra("pageType", 0);
        initView();
        this.laG = j.getEmojiStorageMgr().xYs.aqq(this.kWl);
        if (this.laG == null || this.laG.Reward == null) {
            gy(false);
        } else {
            o.ahp().a(this.laG.Reward.wec, null, g.k(this.kWl, this.laG.Reward.wec, new Object[0]));
            o.ahp().a(this.laG.Reward.wed, null, g.k(this.kWl, this.laG.Reward.wed, new Object[0]));
        }
        cu();
        com.tencent.mm.kernel.g.RO().eJo.a(830, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(822, (f) this);
        com.tencent.mm.plugin.report.service.h.pYm.a(408, 0, 1, false);
        AppMethodBeat.o(53713);
    }

    public void onDestroy() {
        AppMethodBeat.i(53714);
        com.tencent.mm.kernel.g.RO().eJo.b(830, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b(822, (f) this);
        if (this.lep != null && this.lep.isRunning()) {
            this.lep.stop();
        }
        o.ahp().b(null, this.let);
        this.leJ.kVz = null;
        this.leJ = null;
        super.onDestroy();
        AppMethodBeat.o(53714);
    }

    public void onBackPressed() {
        AppMethodBeat.i(53715);
        ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", this.mController.ymc);
        if (this.leE == a.NORMAL) {
            if (this.leF) {
                com.tencent.mm.plugin.report.service.h.pYm.a(408, 2, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(408, 1, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(4));
            }
            super.onBackPressed();
            AppMethodBeat.o(53715);
            return;
        }
        a(a.NORMAL);
        AppMethodBeat.o(53715);
    }

    private void a(a aVar) {
        AppMethodBeat.i(53716);
        if (aVar == a.CUSTOM) {
            this.leE = a.CUSTOM;
            if (this.lew != null) {
                this.lew.setVisibility(0);
                this.lew.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, R.anim.c4));
                this.lex.getContentEditText().requestFocus();
                showVKB();
                this.lev.setVisibility(8);
                AppMethodBeat.o(53716);
                return;
            }
        }
        aqX();
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(53700);
                EmojiStoreV2RewardUI.l(EmojiStoreV2RewardUI.this);
                AppMethodBeat.o(53700);
            }
        }, 300);
        AppMethodBeat.o(53716);
    }

    public final void initView() {
        AppMethodBeat.i(53717);
        if (bo.isNullOrNil(this.kVJ)) {
            setMMTitle((int) R.string.bbe);
        } else {
            setMMTitle(getString(R.string.bbx, new Object[]{this.kVJ}));
        }
        setMMSubTitle((int) R.string.g0d);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53701);
                EmojiStoreV2RewardUI.this.onBackPressed();
                AppMethodBeat.o(53701);
                return true;
            }
        });
        this.lev = findViewById(R.id.bh1);
        this.lew = findViewById(R.id.bh5);
        this.lex = (MMFormInputView) findViewById(R.id.bh6);
        this.lbf = (Button) findViewById(R.id.bh7);
        this.lbf.setOnClickListener(this.leG);
        this.lbf.setEnabled(false);
        this.lex.setInputType(8194);
        this.lex.addTextChangedListener(this.leI);
        this.lex.getContentEditText().setFilters(new InputFilter[]{new LengthFilter(12)});
        this.ley = (TextView) findViewById(R.id.bh4);
        this.ley.setOnClickListener(this.leH);
        this.lez = (TextView) findViewById(R.id.bh3);
        this.let = (EmojiStoreV2RewardBannerView) findViewById(R.id.bh2);
        this.leu = (GridInScrollView) findViewById(16908298);
        this.leA = new b();
        this.leu.setAdapter(this.leA);
        this.leu.setOnItemClickListener(this);
        this.lep = (AnimationDrawable) getResources().getDrawable(R.drawable.emoji_doge_loading);
        AppMethodBeat.o(53717);
    }

    private void cu() {
        AppMethodBeat.i(53718);
        if (this.laG != null) {
            this.ley.setVisibility(0);
            this.lez.setVisibility(0);
            if (this.laG.Reward == null || bo.isNullOrNil(this.laG.Reward.web)) {
                this.let.setBackgroundDrawable(getResources().getDrawable(R.drawable.a8_));
                this.let.setImageDrawable(this.lep);
                this.let.setScaleType(ScaleType.CENTER);
                this.lep.start();
            } else {
                this.leC = this.laG.Reward.web;
                this.leD = EmojiLogic.K(com.tencent.mm.plugin.emoji.h.b.Yb(), this.kWl, this.leC);
                if (e.ct(this.leD)) {
                    this.let.setImageFilePath(this.leD);
                    this.let.setScaleType(ScaleType.FIT_XY);
                    if (this.lep != null && this.lep.isRunning()) {
                        this.lep.stop();
                    }
                } else {
                    o.ahp().a(this.leC, this.let, g.k(this.kWl, this.leC, new Object[0]), this.leJ);
                    this.let.setBackgroundDrawable(getResources().getDrawable(R.drawable.a8_));
                    this.let.setImageDrawable(this.lep);
                    this.let.setScaleType(ScaleType.CENTER);
                    this.lep.start();
                }
            }
        } else {
            this.ley.setVisibility(8);
            this.lez.setVisibility(8);
        }
        if (this.laG == null || this.laG.Price == null) {
            this.leu.setVisibility(8);
            AppMethodBeat.o(53718);
            return;
        }
        this.leu.setVisibility(0);
        this.leA.Q(this.laG.Price);
        AppMethodBeat.o(53718);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(53719);
        if (this.leA != null) {
            EmotionPrice uk = this.leA.uk(i);
            if (uk != null) {
                ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", Integer.valueOf(i));
                a(this.kWl, uk);
            }
        }
        AppMethodBeat.o(53719);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53720);
        switch (i) {
            case 8001:
                if (i2 != -1) {
                    if (i2 != 0) {
                        if (!this.leF) {
                            this.leF = true;
                            com.tencent.mm.plugin.report.service.h.pYm.e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(2));
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.a(408, 4, 1, false);
                        break;
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(3));
                    com.tencent.mm.plugin.report.service.h.pYm.a(408, 3, 1, false);
                    AppMethodBeat.o(53720);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(this, EmojiStoreV2RewardThanksUI.class);
                intent2.putExtra("extra_id", this.kWl);
                startActivity(intent2);
                com.tencent.mm.plugin.report.service.h.pYm.e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(1));
                com.tencent.mm.plugin.report.service.h.pYm.a(408, 9, 1, false);
                gy(true);
                finish();
                AppMethodBeat.o(53720);
                return;
        }
        AppMethodBeat.o(53720);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53721);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        switch (mVar.getType()) {
            case 822:
                if (mVar instanceof com.tencent.mm.plugin.emoji.f.o) {
                    com.tencent.mm.plugin.emoji.f.o oVar = (com.tencent.mm.plugin.emoji.f.o) mVar;
                    if (i == 0 && i2 == 0) {
                        ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
                        this.laG = oVar.bkD();
                        o.ahp().a(this.laG.Reward.wec, null, g.k(this.kWl, this.laG.Reward.wec, new Object[0]));
                        this.mHandler.sendEmptyMessage(1002);
                        AppMethodBeat.o(53721);
                        return;
                    }
                    ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
                    AppMethodBeat.o(53721);
                    return;
                }
                break;
            case 830:
                com.tencent.mm.plugin.emoji.f.b bVar = (com.tencent.mm.plugin.emoji.f.b) mVar;
                if (i == 0 && i2 == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("extinfo_key_10", true);
                    AppCompatActivity appCompatActivity = this.mController.ylL;
                    String str2 = bVar.bkt().vHD;
                    String str3 = bVar.bkt().mZr;
                    if (!bo.isNullOrNil(str2)) {
                        PayInfo N = com.tencent.mm.pluginsdk.wallet.h.N(str2, str3, 5);
                        N.vwh = bundle;
                        com.tencent.mm.pluginsdk.wallet.h.a(appCompatActivity, N, 8001);
                    }
                    AppMethodBeat.o(53721);
                    return;
                } else if (i == 4) {
                    if (!this.leF) {
                        this.leF = true;
                        com.tencent.mm.plugin.report.service.h.pYm.e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(2));
                    }
                    if (i2 == com.tencent.mm.plugin.emoji.f.b.kWi) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(408, 6, 1, false);
                        if (bo.isNullOrNil(str)) {
                            JN(getString(R.string.bbk));
                            AppMethodBeat.o(53721);
                            return;
                        }
                        JN(str);
                        AppMethodBeat.o(53721);
                        return;
                    } else if (i2 == com.tencent.mm.plugin.emoji.f.b.kWj) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(408, 7, 1, false);
                        if (bo.isNullOrNil(str)) {
                            JN(getString(R.string.bbm));
                            AppMethodBeat.o(53721);
                            return;
                        }
                        JN(str);
                        AppMethodBeat.o(53721);
                        return;
                    } else if (i2 == com.tencent.mm.plugin.emoji.f.b.kWk) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(408, 5, 1, false);
                        if (bo.isNullOrNil(str)) {
                            JN(getString(R.string.bbl));
                            AppMethodBeat.o(53721);
                            return;
                        }
                        JN(str);
                        AppMethodBeat.o(53721);
                        return;
                    } else {
                        com.tencent.mm.plugin.report.service.h.pYm.a(408, 8, 1, false);
                        Toast.makeText(this, getString(R.string.ba_), 0).show();
                        AppMethodBeat.o(53721);
                        return;
                    }
                } else {
                    if (!this.leF) {
                        this.leF = true;
                        com.tencent.mm.plugin.report.service.h.pYm.e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(2));
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(408, 8, 1, false);
                    Toast.makeText(this, getString(R.string.ba_), 0).show();
                    AppMethodBeat.o(53721);
                    return;
                }
            default:
                ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", Integer.valueOf(mVar.getType()));
                break;
        }
        AppMethodBeat.o(53721);
    }

    private void a(String str, EmotionPrice emotionPrice) {
        AppMethodBeat.i(53722);
        aoW();
        this.leB = new com.tencent.mm.plugin.emoji.f.b(str, emotionPrice);
        com.tencent.mm.kernel.g.RO().eJo.a(this.leB, 0);
        AppMethodBeat.o(53722);
    }

    private void aoW() {
        AppMethodBeat.i(53723);
        getString(R.string.tz);
        this.gqo = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(53702);
                com.tencent.mm.kernel.g.RO().eJo.c(EmojiStoreV2RewardUI.this.leB);
                AppMethodBeat.o(53702);
            }
        });
        AppMethodBeat.o(53723);
    }

    private void gy(boolean z) {
        AppMethodBeat.i(53725);
        ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
        if (z) {
            com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.o(this.kWl, com.tencent.mm.plugin.emoji.f.o.kWX), 0);
            AppMethodBeat.o(53725);
            return;
        }
        com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.o(this.kWl, com.tencent.mm.plugin.emoji.f.o.kWY), 0);
        aoW();
        AppMethodBeat.o(53725);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void JN(String str) {
        AppMethodBeat.i(53724);
        com.tencent.mm.ui.base.h.a(this.mController.ylL, str, null, getString(R.string.ba4), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(53724);
    }

    static /* synthetic */ void l(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        AppMethodBeat.i(53729);
        emojiStoreV2RewardUI.leE = a.NORMAL;
        if (emojiStoreV2RewardUI.lew != null) {
            emojiStoreV2RewardUI.lew.setVisibility(8);
            emojiStoreV2RewardUI.lev.setVisibility(0);
            emojiStoreV2RewardUI.lew.startAnimation(AnimationUtils.loadAnimation(emojiStoreV2RewardUI.mController.ylL, R.anim.c9));
        }
        AppMethodBeat.o(53729);
    }
}
