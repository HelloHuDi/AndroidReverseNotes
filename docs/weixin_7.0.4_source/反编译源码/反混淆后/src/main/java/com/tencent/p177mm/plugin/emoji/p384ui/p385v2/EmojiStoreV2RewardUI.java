package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.p069v7.app.AppCompatActivity;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.plugin.emoji.model.C42950h;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p384ui.GridInScrollView;
import com.tencent.p177mm.plugin.emoji.p726f.C27738o;
import com.tencent.p177mm.plugin.emoji.p726f.C38879b;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.EmotionPrice;
import com.tencent.p177mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI */
public class EmojiStoreV2RewardUI extends MMActivity implements OnItemClickListener, C1202f {
    private ProgressDialog gqo;
    private int kVD;
    private String kVJ;
    private String kWl;
    private GetEmotionRewardResponse laG;
    private Button lbf;
    private C11593b leA;
    private C38879b leB;
    private String leC;
    private String leD;
    private C20421a leE = C20421a.NORMAL;
    private boolean leF = false;
    private OnClickListener leG = new C429652();
    private OnClickListener leH = new C458633();
    private TextWatcher leI = new C429664();
    private C42950h leJ = new C42950h(new C204185());
    private AnimationDrawable lep;
    private int les;
    private EmojiStoreV2RewardBannerView let;
    private GridInScrollView leu;
    private View lev;
    private View lew;
    private MMFormInputView lex;
    private TextView ley;
    private TextView lez;
    private C7306ak mHandler = new C429641();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$b */
    class C11593b extends BaseAdapter {
        private LinkedList<EmotionPrice> lei;

        C11593b() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(53710);
            EmotionPrice uk = mo23314uk(i);
            AppMethodBeat.m2505o(53710);
            return uk;
        }

        /* renamed from: Q */
        public final void mo23309Q(LinkedList<EmotionPrice> linkedList) {
            AppMethodBeat.m2504i(53706);
            if (this.lei == null) {
                this.lei = new LinkedList();
            }
            this.lei.clear();
            this.lei.addAll(linkedList);
            notifyDataSetChanged();
            AppMethodBeat.m2505o(53706);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(53707);
            if (this.lei == null) {
                AppMethodBeat.m2505o(53707);
                return 0;
            }
            int size = this.lei.size();
            AppMethodBeat.m2505o(53707);
            return size;
        }

        /* renamed from: uk */
        public final EmotionPrice mo23314uk(int i) {
            AppMethodBeat.m2504i(53708);
            if (i < 0 || i > getCount()) {
                AppMethodBeat.m2505o(53708);
                return null;
            } else if (this.lei == null) {
                AppMethodBeat.m2505o(53708);
                return null;
            } else {
                EmotionPrice emotionPrice = (EmotionPrice) this.lei.get(i);
                AppMethodBeat.m2505o(53708);
                return emotionPrice;
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C27773c c27773c;
            AppMethodBeat.m2504i(53709);
            if (view == null || view.getTag() == null) {
                view = C5616v.m8409hu(EmojiStoreV2RewardUI.this.mController.ylL).inflate(2130969375, null);
                c27773c = new C27773c(view);
                view.setTag(c27773c);
            } else {
                c27773c = (C27773c) view.getTag();
            }
            EmotionPrice uk = mo23314uk(i);
            if (uk != null) {
                c27773c.leO.setVisibility(0);
                c27773c.leO.setText(uk.Number + uk.Label);
            } else {
                c27773c.leO.setVisibility(8);
            }
            AppMethodBeat.m2505o(53709);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$5 */
    class C204185 implements C1282i {
        C204185() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(53699);
            if (!C5046bo.isNullOrNil(str) && str.equalsIgnoreCase(EmojiStoreV2RewardUI.this.leC)) {
                Message message = new Message();
                message.what = 1001;
                message.obj = EmojiStoreV2RewardUI.this.leD;
                EmojiStoreV2RewardUI.this.mHandler.sendMessage(message);
            }
            AppMethodBeat.m2505o(53699);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$6 */
    class C204196 implements Runnable {
        C204196() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53700);
            EmojiStoreV2RewardUI.m84964l(EmojiStoreV2RewardUI.this);
            AppMethodBeat.m2505o(53700);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$8 */
    class C204208 implements OnCancelListener {
        C204208() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53702);
            C1720g.m3535RO().eJo.mo14547c(EmojiStoreV2RewardUI.this.leB);
            AppMethodBeat.m2505o(53702);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$a */
    enum C20421a {
        NORMAL,
        CUSTOM;

        static {
            AppMethodBeat.m2505o(53705);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$7 */
    class C277727 implements OnMenuItemClickListener {
        C277727() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53701);
            EmojiStoreV2RewardUI.this.onBackPressed();
            AppMethodBeat.m2505o(53701);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$c */
    class C27773c {
        TextView leO;

        public C27773c(View view) {
            AppMethodBeat.m2504i(53711);
            this.leO = (TextView) view.findViewById(2131823573);
            AppMethodBeat.m2505o(53711);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$1 */
    class C429641 extends C7306ak {
        C429641() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53695);
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
                        AppMethodBeat.m2505o(53695);
                        return;
                    }
                    EmojiStoreV2RewardUI.this.let.setImageFilePath(str);
                    EmojiStoreV2RewardUI.this.let.setScaleType(ScaleType.FIT_XY);
                    if (EmojiStoreV2RewardUI.this.lep != null && EmojiStoreV2RewardUI.this.lep.isRunning()) {
                        EmojiStoreV2RewardUI.this.lep.stop();
                        AppMethodBeat.m2505o(53695);
                        return;
                    }
                    break;
                case 1002:
                    EmojiStoreV2RewardUI.m84953c(EmojiStoreV2RewardUI.this);
                    break;
            }
            AppMethodBeat.m2505o(53695);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$2 */
    class C429652 implements OnClickListener {
        C429652() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53696);
            if (EmojiStoreV2RewardUI.this.leA != null) {
                EmotionPrice uk = EmojiStoreV2RewardUI.this.leA.mo23314uk(0);
                if (EmojiStoreV2RewardUI.this.lex.getText() != null) {
                    uk.Number = EmojiStoreV2RewardUI.this.lex.getText().toString();
                    EmojiStoreV2RewardUI.m84950a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.this.kWl, uk);
                    AppMethodBeat.m2505o(53696);
                    return;
                }
                C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
                AppMethodBeat.m2505o(53696);
                return;
            }
            C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
            AppMethodBeat.m2505o(53696);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$4 */
    class C429664 implements TextWatcher {
        C429664() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(53698);
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
                        EmojiStoreV2RewardUI.this.lex.getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.mController.ylL.getResources().getColor(C25738R.color.f12266xy));
                    } else {
                        EmojiStoreV2RewardUI.this.lex.getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.mController.ylL.getResources().getColor(C25738R.color.f12212w4));
                        EmojiStoreV2RewardUI.this.lbf.setEnabled(true);
                        AppMethodBeat.m2505o(53698);
                        return;
                    }
                }
                EmojiStoreV2RewardUI.this.lbf.setEnabled(false);
            }
            AppMethodBeat.m2505o(53698);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$9 */
    class C429679 implements DialogInterface.OnClickListener {
        C429679() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI$3 */
    class C458633 implements OnClickListener {
        C458633() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53697);
            if (EmojiStoreV2RewardUI.this.leE == C20421a.NORMAL) {
                EmojiStoreV2RewardUI.m84949a(EmojiStoreV2RewardUI.this, C20421a.CUSTOM);
            }
            AppMethodBeat.m2505o(53697);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreV2RewardUI() {
        AppMethodBeat.m2504i(53712);
        AppMethodBeat.m2505o(53712);
    }

    /* renamed from: a */
    static /* synthetic */ void m84950a(EmojiStoreV2RewardUI emojiStoreV2RewardUI, String str, EmotionPrice emotionPrice) {
        AppMethodBeat.m2504i(53727);
        emojiStoreV2RewardUI.m84951a(str, emotionPrice);
        AppMethodBeat.m2505o(53727);
    }

    /* renamed from: c */
    static /* synthetic */ void m84953c(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        AppMethodBeat.m2504i(53726);
        emojiStoreV2RewardUI.m84954cu();
        AppMethodBeat.m2505o(53726);
    }

    public final int getLayoutId() {
        return 2130969377;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53713);
        super.onCreate(bundle);
        this.kWl = getIntent().getStringExtra("extra_id");
        this.kVJ = getIntent().getStringExtra("name");
        this.kVD = getIntent().getIntExtra("scene", 0);
        this.les = getIntent().getIntExtra("pageType", 0);
        initView();
        this.laG = C42952j.getEmojiStorageMgr().xYs.aqq(this.kWl);
        if (this.laG == null || this.laG.Reward == null) {
            m84959gy(false);
        } else {
            C32291o.ahp().mo43766a(this.laG.Reward.wec, null, C20364g.m31464k(this.kWl, this.laG.Reward.wec, new Object[0]));
            C32291o.ahp().mo43766a(this.laG.Reward.wed, null, C20364g.m31464k(this.kWl, this.laG.Reward.wed, new Object[0]));
        }
        m84954cu();
        C1720g.m3535RO().eJo.mo14539a(830, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(822, (C1202f) this);
        C7060h.pYm.mo8378a(408, 0, 1, false);
        AppMethodBeat.m2505o(53713);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53714);
        C1720g.m3535RO().eJo.mo14546b(830, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(822, (C1202f) this);
        if (this.lep != null && this.lep.isRunning()) {
            this.lep.stop();
        }
        C32291o.ahp().mo43772b(null, this.let);
        this.leJ.kVz = null;
        this.leJ = null;
        super.onDestroy();
        AppMethodBeat.m2505o(53714);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(53715);
        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardUI", this.mController.ymc);
        if (this.leE == C20421a.NORMAL) {
            if (this.leF) {
                C7060h.pYm.mo8378a(408, 2, 1, false);
            } else {
                C7060h.pYm.mo8378a(408, 1, 1, false);
                C7060h.pYm.mo8381e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(4));
            }
            super.onBackPressed();
            AppMethodBeat.m2505o(53715);
            return;
        }
        m84948a(C20421a.NORMAL);
        AppMethodBeat.m2505o(53715);
    }

    /* renamed from: a */
    private void m84948a(C20421a c20421a) {
        AppMethodBeat.m2504i(53716);
        if (c20421a == C20421a.CUSTOM) {
            this.leE = C20421a.CUSTOM;
            if (this.lew != null) {
                this.lew.setVisibility(0);
                this.lew.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8362c4));
                this.lex.getContentEditText().requestFocus();
                showVKB();
                this.lev.setVisibility(8);
                AppMethodBeat.m2505o(53716);
                return;
            }
        }
        aqX();
        this.mHandler.postDelayed(new C204196(), 300);
        AppMethodBeat.m2505o(53716);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53717);
        if (C5046bo.isNullOrNil(this.kVJ)) {
            setMMTitle((int) C25738R.string.bbe);
        } else {
            setMMTitle(getString(C25738R.string.bbx, new Object[]{this.kVJ}));
        }
        setMMSubTitle((int) C25738R.string.g0d);
        setBackBtn(new C277727());
        this.lev = findViewById(2131823579);
        this.lew = findViewById(2131823583);
        this.lex = (MMFormInputView) findViewById(2131823584);
        this.lbf = (Button) findViewById(2131823585);
        this.lbf.setOnClickListener(this.leG);
        this.lbf.setEnabled(false);
        this.lex.setInputType(8194);
        this.lex.addTextChangedListener(this.leI);
        this.lex.getContentEditText().setFilters(new InputFilter[]{new LengthFilter(12)});
        this.ley = (TextView) findViewById(2131823582);
        this.ley.setOnClickListener(this.leH);
        this.lez = (TextView) findViewById(2131823581);
        this.let = (EmojiStoreV2RewardBannerView) findViewById(2131823580);
        this.leu = (GridInScrollView) findViewById(16908298);
        this.leA = new C11593b();
        this.leu.setAdapter(this.leA);
        this.leu.setOnItemClickListener(this);
        this.lep = (AnimationDrawable) getResources().getDrawable(C25738R.drawable.emoji_doge_loading);
        AppMethodBeat.m2505o(53717);
    }

    /* renamed from: cu */
    private void m84954cu() {
        AppMethodBeat.m2504i(53718);
        if (this.laG != null) {
            this.ley.setVisibility(0);
            this.lez.setVisibility(0);
            if (this.laG.Reward == null || C5046bo.isNullOrNil(this.laG.Reward.web)) {
                this.let.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.a8_));
                this.let.setImageDrawable(this.lep);
                this.let.setScaleType(ScaleType.CENTER);
                this.lep.start();
            } else {
                this.leC = this.laG.Reward.web;
                this.leD = EmojiLogic.m44072K(C2933b.m5221Yb(), this.kWl, this.leC);
                if (C5730e.m8628ct(this.leD)) {
                    this.let.setImageFilePath(this.leD);
                    this.let.setScaleType(ScaleType.FIT_XY);
                    if (this.lep != null && this.lep.isRunning()) {
                        this.lep.stop();
                    }
                } else {
                    C32291o.ahp().mo43768a(this.leC, this.let, C20364g.m31464k(this.kWl, this.leC, new Object[0]), this.leJ);
                    this.let.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.a8_));
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
            AppMethodBeat.m2505o(53718);
            return;
        }
        this.leu.setVisibility(0);
        this.leA.mo23309Q(this.laG.Price);
        AppMethodBeat.m2505o(53718);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(53719);
        if (this.leA != null) {
            EmotionPrice uk = this.leA.mo23314uk(i);
            if (uk != null) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", Integer.valueOf(i));
                m84951a(this.kWl, uk);
            }
        }
        AppMethodBeat.m2505o(53719);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53720);
        switch (i) {
            case 8001:
                if (i2 != -1) {
                    if (i2 != 0) {
                        if (!this.leF) {
                            this.leF = true;
                            C7060h.pYm.mo8381e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(2));
                        }
                        C7060h.pYm.mo8378a(408, 4, 1, false);
                        break;
                    }
                    C7060h.pYm.mo8381e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(3));
                    C7060h.pYm.mo8378a(408, 3, 1, false);
                    AppMethodBeat.m2505o(53720);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(this, EmojiStoreV2RewardThanksUI.class);
                intent2.putExtra("extra_id", this.kWl);
                startActivity(intent2);
                C7060h.pYm.mo8381e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(1));
                C7060h.pYm.mo8378a(408, 9, 1, false);
                m84959gy(true);
                finish();
                AppMethodBeat.m2505o(53720);
                return;
        }
        AppMethodBeat.m2505o(53720);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53721);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        switch (c1207m.getType()) {
            case 822:
                if (c1207m instanceof C27738o) {
                    C27738o c27738o = (C27738o) c1207m;
                    if (i == 0 && i2 == 0) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
                        this.laG = c27738o.bkD();
                        C32291o.ahp().mo43766a(this.laG.Reward.wec, null, C20364g.m31464k(this.kWl, this.laG.Reward.wec, new Object[0]));
                        this.mHandler.sendEmptyMessage(1002);
                        AppMethodBeat.m2505o(53721);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
                    AppMethodBeat.m2505o(53721);
                    return;
                }
                break;
            case 830:
                C38879b c38879b = (C38879b) c1207m;
                if (i == 0 && i2 == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("extinfo_key_10", true);
                    AppCompatActivity appCompatActivity = this.mController.ylL;
                    String str2 = c38879b.bkt().vHD;
                    String str3 = c38879b.bkt().mZr;
                    if (!C5046bo.isNullOrNil(str2)) {
                        PayInfo N = C35899h.m58849N(str2, str3, 5);
                        N.vwh = bundle;
                        C35899h.m58853a(appCompatActivity, N, 8001);
                    }
                    AppMethodBeat.m2505o(53721);
                    return;
                } else if (i == 4) {
                    if (!this.leF) {
                        this.leF = true;
                        C7060h.pYm.mo8381e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(2));
                    }
                    if (i2 == C38879b.kWi) {
                        C7060h.pYm.mo8378a(408, 6, 1, false);
                        if (C5046bo.isNullOrNil(str)) {
                            m84946JN(getString(C25738R.string.bbk));
                            AppMethodBeat.m2505o(53721);
                            return;
                        }
                        m84946JN(str);
                        AppMethodBeat.m2505o(53721);
                        return;
                    } else if (i2 == C38879b.kWj) {
                        C7060h.pYm.mo8378a(408, 7, 1, false);
                        if (C5046bo.isNullOrNil(str)) {
                            m84946JN(getString(C25738R.string.bbm));
                            AppMethodBeat.m2505o(53721);
                            return;
                        }
                        m84946JN(str);
                        AppMethodBeat.m2505o(53721);
                        return;
                    } else if (i2 == C38879b.kWk) {
                        C7060h.pYm.mo8378a(408, 5, 1, false);
                        if (C5046bo.isNullOrNil(str)) {
                            m84946JN(getString(C25738R.string.bbl));
                            AppMethodBeat.m2505o(53721);
                            return;
                        }
                        m84946JN(str);
                        AppMethodBeat.m2505o(53721);
                        return;
                    } else {
                        C7060h.pYm.mo8378a(408, 8, 1, false);
                        Toast.makeText(this, getString(C25738R.string.ba_), 0).show();
                        AppMethodBeat.m2505o(53721);
                        return;
                    }
                } else {
                    if (!this.leF) {
                        this.leF = true;
                        C7060h.pYm.mo8381e(12738, this.kWl, Integer.valueOf(this.les), Integer.valueOf(this.kVD), Integer.valueOf(2));
                    }
                    C7060h.pYm.mo8378a(408, 8, 1, false);
                    Toast.makeText(this, getString(C25738R.string.ba_), 0).show();
                    AppMethodBeat.m2505o(53721);
                    return;
                }
            default:
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", Integer.valueOf(c1207m.getType()));
                break;
        }
        AppMethodBeat.m2505o(53721);
    }

    /* renamed from: a */
    private void m84951a(String str, EmotionPrice emotionPrice) {
        AppMethodBeat.m2504i(53722);
        aoW();
        this.leB = new C38879b(str, emotionPrice);
        C1720g.m3535RO().eJo.mo14541a(this.leB, 0);
        AppMethodBeat.m2505o(53722);
    }

    private void aoW() {
        AppMethodBeat.m2504i(53723);
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C204208());
        AppMethodBeat.m2505o(53723);
    }

    /* renamed from: gy */
    private void m84959gy(boolean z) {
        AppMethodBeat.m2504i(53725);
        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
        if (z) {
            C1720g.m3535RO().eJo.mo14541a(new C27738o(this.kWl, C27738o.kWX), 0);
            AppMethodBeat.m2505o(53725);
            return;
        }
        C1720g.m3535RO().eJo.mo14541a(new C27738o(this.kWl, C27738o.kWY), 0);
        aoW();
        AppMethodBeat.m2505o(53725);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: JN */
    private void m84946JN(String str) {
        AppMethodBeat.m2504i(53724);
        C30379h.m48443a(this.mController.ylL, str, null, getString(C25738R.string.ba4), new C429679());
        AppMethodBeat.m2505o(53724);
    }

    /* renamed from: l */
    static /* synthetic */ void m84964l(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        AppMethodBeat.m2504i(53729);
        emojiStoreV2RewardUI.leE = C20421a.NORMAL;
        if (emojiStoreV2RewardUI.lew != null) {
            emojiStoreV2RewardUI.lew.setVisibility(8);
            emojiStoreV2RewardUI.lev.setVisibility(0);
            emojiStoreV2RewardUI.lew.startAnimation(AnimationUtils.loadAnimation(emojiStoreV2RewardUI.mController.ylL, C25738R.anim.f8367c9));
        }
        AppMethodBeat.m2505o(53729);
    }
}
