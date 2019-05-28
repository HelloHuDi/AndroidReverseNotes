package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.p069v7.app.ActionBar;
import android.support.p069v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.p612ui.C15481a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42951i;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C11558a;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C27740b;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p381a.C45843a;
import com.tencent.p177mm.plugin.emoji.p381a.C45844h;
import com.tencent.p177mm.plugin.emoji.p381a.C45844h.C42932a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f.C11547a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33945b;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C45842c;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiMineUI;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiStoreVpHeader;
import com.tencent.p177mm.plugin.emoji.p726f.C20375n;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p947e.C11553m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C23249h.C14889a;
import com.tencent.p177mm.pluginsdk.model.C44064n;
import com.tencent.p177mm.protocal.protobuf.EmotionBanner;
import com.tencent.p177mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment */
public abstract class EmojiStoreV2BaseFragment extends MMFragment implements OnScrollListener, OnItemClickListener, C1202f, C42932a, C11558a, C27740b, C14889a, C4931a, C5258c, C5260d, C5257e {
    /* renamed from: Ek */
    private View f16168Ek;
    private ProgressDialog gqo;
    private boolean hZu;
    C33944a kVA;
    EmojiStoreVpHeader kXW;
    private MMPullDownView kXZ;
    private TextView kYa;
    private int kYc = -1;
    private View kYd;
    private byte[] kYe;
    private final int kYi = 131074;
    private final int kYj = 131075;
    private final int kYk = 131076;
    private final String kYl = "product_id";
    private final String kYm = "progress";
    private final String kYn = "status";
    private C20375n kYo;
    private int kYp;
    private C20383f kYq;
    private C42951i kYr;
    private C4884c kYt = new C388962();
    private C42945g kYu;
    private boolean kYv = false;
    private LinkedList<EmotionBanner> kYw = new LinkedList();
    private LinkedList<EmotionBannerSet> kYx = new LinkedList();
    private final int lcV = 131077;
    public EmojiStoreV2HotBarView lcW;
    private boolean lcX = false;
    private boolean lcY = false;
    private boolean lcZ = false;
    private C7306ak lda = new C204101();
    private OnMenuItemClickListener ldb = new C388983();
    private ActionBar mActionBar;
    private C15481a mActionBarHelper;
    ListView mListView;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$6 */
    class C115886 implements OnTouchListener {
        C115886() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$9 */
    class C115909 implements OnCancelListener {
        C115909() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$1 */
    class C204101 extends C7306ak {
        C204101() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53571);
            EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
            String string;
            switch (message.what) {
                case 131074:
                    if (emojiStoreV2BaseFragment.kVA != null) {
                        emojiStoreV2BaseFragment.kVA.notifyDataSetChanged();
                        AppMethodBeat.m2505o(53571);
                        return;
                    }
                    break;
                case 131075:
                    if (emojiStoreV2BaseFragment.kVA == null || message.getData() == null) {
                        AppMethodBeat.m2505o(53571);
                        return;
                    }
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        emojiStoreV2BaseFragment.kVA.mo54492bX(string, message.getData().getInt("progress"));
                        AppMethodBeat.m2505o(53571);
                        return;
                    }
                    break;
                case 131076:
                    if (emojiStoreV2BaseFragment.kVA == null || message.getData() == null) {
                        AppMethodBeat.m2505o(53571);
                        return;
                    }
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        emojiStoreV2BaseFragment.kVA.mo54491bW(string, message.getData().getInt("status"));
                        AppMethodBeat.m2505o(53571);
                        return;
                    }
                    break;
                case 131077:
                    if (emojiStoreV2BaseFragment.kXW != null) {
                        emojiStoreV2BaseFragment.kXW.blS();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(53571);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$7 */
    class C277657 implements Runnable {
        C277657() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53577);
            EmojiStoreV2BaseFragment.this.mo61768gt(false);
            AppMethodBeat.m2505o(53577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$2 */
    class C388962 extends C4884c<C18232da> {
        C388962() {
            AppMethodBeat.m2504i(53572);
            this.xxI = C18232da.class.getName().hashCode();
            AppMethodBeat.m2505o(53572);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53573);
            C18232da c18232da = (C18232da) c4883b;
            if (c18232da != null) {
                EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
                String str = c18232da.cwf.cwg;
                int i = c18232da.cwf.status;
                int i2 = c18232da.cwf.progress;
                C4990ab.m7411d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), c18232da.cwf.cwh);
                if (emojiStoreV2BaseFragment.kVA != null) {
                    C45842c c45842c = emojiStoreV2BaseFragment.kVA.kSP;
                    if (c45842c != null) {
                        if (i == 6) {
                            Message obtain = Message.obtain();
                            obtain.getData().putString("product_id", str);
                            obtain.getData().putInt("progress", i2);
                            obtain.what = 131075;
                            emojiStoreV2BaseFragment.mo61769n(obtain);
                        } else {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", Integer.valueOf(i));
                            Message obtain2 = Message.obtain();
                            obtain2.getData().putString("product_id", str);
                            obtain2.getData().putInt("status", i);
                            obtain2.what = 131076;
                            emojiStoreV2BaseFragment.mo61769n(obtain2);
                        }
                        C11546f IT = c45842c.mo73635IT(str);
                        if (IT != null) {
                            IT.kTe = r4;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(53573);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$4 */
    class C388974 implements OnClickListener {
        C388974() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53575);
            if (EmojiStoreV2BaseFragment.this.isScreenEnable()) {
                if (EmojiStoreV2BaseFragment.this.ldb != null) {
                    EmojiStoreV2BaseFragment.this.ldb.onMenuItemClick(null);
                }
                AppMethodBeat.m2505o(53575);
                return;
            }
            AppMethodBeat.m2505o(53575);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$3 */
    class C388983 implements OnMenuItemClickListener {
        C388983() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53574);
            EmojiStoreV2BaseFragment.this.thisActivity().finish();
            AppMethodBeat.m2505o(53574);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment$5 */
    class C388995 implements OnMenuItemClickListener {
        C388995() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53576);
            Intent intent = new Intent();
            intent.setClass(EmojiStoreV2BaseFragment.this.thisActivity(), EmojiMineUI.class);
            EmojiStoreV2BaseFragment.this.startActivity(intent);
            AppMethodBeat.m2505o(53576);
            return false;
        }
    }

    public abstract C33944a bkO();

    public abstract int bkV();

    public abstract boolean bmd();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.mActionBar = ((AppCompatActivity) thisActivity()).getSupportActionBar();
        View inflate = C5616v.m8409hu(getContext()).inflate(2130968612, null);
        this.mActionBarHelper = new C15481a(inflate);
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.mo1339fc();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.mo1338fb();
        this.mActionBar.mo1340fd();
        this.mActionBar.setCustomView(inflate);
        this.mActionBar.show();
        C15481a c15481a = this.mActionBarHelper;
        c15481a.gnB.setText(C25738R.string.ba7);
        if (C1338a.m2865ga(c15481a.gnB.getContext())) {
            c15481a.gnB.setTextSize(0, C1338a.m2862fY(c15481a.gnB.getContext()) * ((float) C1338a.m2857am(c15481a.gnB.getContext(), C25738R.dimen.f9720dk)));
        }
        this.mActionBarHelper.mo27555b(new C388974());
        showOptionMenu(true);
        addIconOptionMenu(0, C1318a.actionbar_setting_icon, new C388995());
        C4879a.xxA.mo10052c(this.kYt);
        C42952j.getEmojiStorageMgr().xYo.mo10116c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.lcZ = true;
        this.kVA = bkO();
        this.kVA.kSQ = this;
        this.f16168Ek = findViewById(2131821749);
        this.kYa = (TextView) this.f16168Ek.findViewById(2131823528);
        this.kYd = getActivityLayoutInflater().inflate(2130969354, null);
        this.kYd.setVisibility(8);
        this.kXW = new EmojiStoreVpHeader(getContext());
        this.mListView = (ListView) findViewById(16908298);
        this.mListView.addHeaderView(this.kXW);
        if (!bmd()) {
            this.lcW = new EmojiStoreV2HotBarView(getContext());
            this.lcW.setDesignerEmojiViewVisibility(8);
            this.lcW.setDesignerCatalogViewPadding(false);
            this.mListView.addHeaderView(this.lcW);
        }
        this.mListView.addFooterView(this.kYd);
        this.mListView.setAdapter(this.kVA);
        if (bmd()) {
            this.mListView.setOnItemClickListener(this);
        } else {
            ((C45844h) this.kVA).kSy = this;
        }
        this.mListView.setOnScrollListener(this);
        this.mListView.setLongClickable(false);
        this.mListView.setOnTouchListener(new C115886());
        this.kVA.kSO = this.mListView;
        this.kXZ = (MMPullDownView) findViewById(2131823536);
        if (this.kXZ != null) {
            this.kXZ.setTopViewVisible(false);
            this.kXZ.setAtTopCallBack(this);
            this.kXZ.setOnBottomLoadDataListener(this);
            this.kXZ.setAtBottomCallBack(this);
            this.kXZ.setBottomViewVisible(false);
            this.kXZ.setIsBottomShowAll(false);
            this.kXZ.setIsReturnSuperDispatchWhenCancel(true);
        }
        if (this.lcX) {
            blY();
        }
    }

    public void onStart() {
        super.onStart();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        C1720g.m3535RO().eJo.mo14539a(411, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        if (this.lcX) {
            if (this.lda != null) {
                this.lda.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.kVA == null || this.kVA.kSP == null)) {
                this.kVA.kSP.bjD();
                this.kVA.refreshView();
            }
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(208900, Boolean.FALSE)).booleanValue()) {
                bkf();
                C1720g.m3536RP().mo5239Ry().set(208900, Boolean.FALSE);
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        C4990ab.m7411d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", Boolean.valueOf(z));
        super.setUserVisibleHint(z);
        this.lcX = z;
        if (!this.lcY && this.lcZ) {
            blY();
        }
    }

    public void onPause() {
        super.onPause();
        C1720g.m3535RO().eJo.mo14546b(411, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.kXW != null) {
            this.kXW.blT();
        }
        if (this.lda != null) {
            this.lda.removeMessages(131077);
        }
    }

    public void onStop() {
        super.onStop();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.kVA != null) {
            this.kVA.clear();
            this.kVA = null;
        }
        if (this.kXW != null) {
            this.kXW.blT();
            this.kXW.clear();
        }
        C4879a.xxA.mo10053d(this.kYt);
        C42952j.getEmojiStorageMgr().xYo.mo10117d(this);
    }

    public void onDetach() {
        super.onDetach();
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void blY() {
        this.lcY = true;
        blZ();
        this.kYp = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
        if (!bma() || this.lda == null) {
            mo61768gt(true);
        } else {
            this.lda.postDelayed(new C277657(), 3000);
        }
    }

    private void blZ() {
        this.kYr = new C42951i();
        this.kYr.jiq = thisActivity();
        this.kYr.kVC = this;
        this.kYr.kVA = this.kVA;
        if (bmd()) {
            this.kYr.kVD = 1;
        } else {
            this.kYr.kVD = 2;
        }
        this.kYr.kVG = this;
    }

    private boolean bma() {
        GetEmotionListResponse ME = C42952j.getEmojiStorageMgr().xYq.mo64085ME(bkV());
        C20383f a = C20375n.m31536a(ME);
        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
        String str2 = "load cache type: %d, size: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bkV());
        objArr[1] = Integer.valueOf(ME == null ? 0 : ME.EmotionCount);
        C4990ab.m7411d(str, str2, objArr);
        if (a == null || a.kVq.size() <= 0) {
            return false;
        }
        int size;
        int i;
        int i2;
        this.kYv = true;
        this.f16168Ek.setVisibility(8);
        this.kXZ.setVisibility(0);
        m66011a(this.kYc, a);
        if (ME != null) {
            size = ME.CellSetList == null ? 0 : ME.CellSetList.size();
            i = ME.TopHotNum;
            i2 = ME.RecentHotNum;
        } else {
            i2 = 0;
            i = 0;
            size = 0;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", Integer.valueOf(i), Integer.valueOf(bkV()));
        if (this.kVA != null && bmd()) {
            this.kVA.mo7111tU(size + i);
            this.kVA.mo7112tV(i2);
        }
        bkU();
        return true;
    }

    /* renamed from: gt */
    public final void mo61768gt(boolean z) {
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", Boolean.valueOf(z), Boolean.valueOf(EmojiStoreV2BaseFragment.bmb()));
        if (!z) {
            EmojiStoreV2BaseFragment.bmb();
        }
        m66013aI(this.kYe);
        bkX();
    }

    /* renamed from: aI */
    private void m66013aI(byte[] bArr) {
        int bkV = bkV();
        int i = this.kYp;
        if (bArr != null) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", bArr.toString());
            this.kYo = new C20375n(bkV, bArr, i);
            return;
        }
        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.kYo = new C20375n(bkV, i);
    }

    private void bkX() {
        C1720g.m3535RO().eJo.mo14541a(this.kYo, 0);
    }

    private static boolean bmb() {
        ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_STORE_LAST_REFRESH_TIME_LONG, Long.valueOf(0))).longValue();
        return true;
    }

    /* renamed from: a */
    private void m66011a(int i, C20383f c20383f) {
        boolean z;
        boolean z2;
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        switch (i) {
            case -1:
                this.kYq = c20383f;
                z = true;
                z2 = true;
                break;
            case 0:
                this.kYq = c20383f;
                z = false;
                z2 = false;
                break;
            case 1:
                this.kYq = c20383f;
                z = false;
                z2 = true;
                break;
            case 2:
                if (this.kYq == null) {
                    this.kYq = new C20383f();
                }
                this.kYq.mo35681ue(c20383f.kVp);
                this.kYq.mo35680br(c20383f.kVq);
                z = false;
                z2 = true;
                break;
            default:
                z = false;
                z2 = false;
                break;
        }
        if (this.kYq != null) {
            this.kYq.bke();
        }
        m66008A(z2, z);
    }

    private void bkU() {
        C33945b.m55558a(this.kVA.kSP, (C14889a) this);
    }

    /* renamed from: A */
    private void m66008A(boolean z, boolean z2) {
        if (this.kYq != null && z) {
            if (z2) {
                bmc();
            }
            if (this.kVA != null) {
                this.kVA.mo54490b(this.kYq);
            }
        }
    }

    private void bmc() {
        if (this.kYq == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
            return;
        }
        this.kYw = (LinkedList) this.kYq.kVs;
        this.kYx = (LinkedList) this.kYq.kVt;
        if (this.kYw != null) {
            this.kXW.mo45597d(this.kYw, this.kYx);
        } else if (this.kYq.kVr != null) {
            this.kYw = new LinkedList();
            this.kYw.add(this.kYq.kVr);
            this.kXW.mo45597d(this.kYw, this.kYx);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        switch (c1207m.getType()) {
            case 411:
                if (c1207m instanceof C20375n) {
                    C20375n c20375n = (C20375n) c1207m;
                    if (c20375n != null && c20375n.mType == bkV()) {
                        Object obj;
                        int i3 = 0;
                        int i4 = 0;
                        int i5 = 0;
                        if (!(c20375n == null || c20375n.bkB() == null)) {
                            if (this.kVA.bjy() <= 0 && bmd()) {
                                if (c20375n.bkB().CellSetList == null) {
                                    i3 = 0;
                                } else {
                                    i3 = c20375n.bkB().CellSetList.size();
                                }
                                this.kVA.mo7113tW(i3);
                            }
                            i4 = c20375n.bkB().TopHotNum;
                            i5 = c20375n.bkB().RecentHotNum;
                        }
                        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(r4), Integer.valueOf(c20375n.mType));
                        if (this.kVA != null && this.kVA.bjx() <= 0 && bmd()) {
                            C33944a c33944a = this.kVA;
                            c33944a.mo7111tU(i4 + c33944a.bjy());
                            this.kVA.mo7112tV(i5);
                        }
                        this.hZu = false;
                        this.kYd.setVisibility(8);
                        if (i == 0 || i == 4) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.f16168Ek.setVisibility(8);
                            this.kXZ.setVisibility(0);
                            C20375n c20375n2 = (C20375n) c1207m;
                            C20383f a = C20375n.m31536a(c20375n2.bkB());
                            this.kYe = c20375n2.kWS;
                            GetEmotionListResponse bkB;
                            if (i2 == 0) {
                                bkB = c20375n2.bkB();
                                m66011a(this.kYc, a);
                                m66014d(bkB);
                                this.kYc = 0;
                            } else if (i2 == 2) {
                                bkB = c20375n2.bkB();
                                m66011a(this.kYc, a);
                                bkU();
                                m66014d(bkB);
                                this.kYc = 2;
                            } else if (i2 == 3) {
                                m66011a(this.kYc, a);
                                this.kYc = 1;
                            } else {
                                this.f16168Ek.setVisibility(0);
                                this.kXZ.setVisibility(8);
                                this.kYa.setText(C25738R.string.bat);
                            }
                        } else if (!this.kYv) {
                            this.f16168Ek.setVisibility(0);
                            this.kXZ.setVisibility(8);
                            this.kYa.setText(C25738R.string.bau);
                        }
                        if (bmd()) {
                            if (!(c20375n.bkB() == null || c20375n.bkB().CellSetList == null || c20375n.bkB().CellSetList.size() <= 0)) {
                                i3 = 0;
                                while (true) {
                                    i5 = i3;
                                    if (i5 < c20375n.bkB().CellSetList.size()) {
                                        C7060h.pYm.mo8381e(13223, Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet) c20375n.bkB().CellSetList.get(i5)).f15073ID), ((EmotionBannerSet) c20375n.bkB().CellSetList.get(i5)).Title, Integer.valueOf(0));
                                        i3 = i5 + 1;
                                    }
                                }
                            }
                            if (c20375n.bkB().RecentHotNum > 0 && c20375n.bkB().EmotionList != null && c20375n.bkB().EmotionList.size() > c20375n.bkB().TopHotNum + c20375n.bkB().RecentHotNum) {
                                i3 = 0;
                                while (true) {
                                    i5 = i3;
                                    if (i5 < c20375n.bkB().RecentHotNum) {
                                        C7060h.pYm.mo8381e(13223, Integer.valueOf(0), ((EmotionSummary) c20375n.bkB().EmotionList.get(c20375n.bkB().TopHotNum + i5)).ProductID, ((EmotionSummary) c20375n.bkB().EmotionList.get(c20375n.bkB().TopHotNum + i5)).PackName, Integer.valueOf(1));
                                        i3 = i5 + 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
                break;
            default:
                C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    public final boolean bhk() {
        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        m66015gu(true);
        return true;
    }

    public final boolean bhl() {
        return false;
    }

    public final boolean bhm() {
        return false;
    }

    /* renamed from: d */
    private void m66014d(final GetEmotionListResponse getEmotionListResponse) {
        if (this.kYc == -1) {
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.m2504i(53578);
                    if (getEmotionListResponse != null) {
                        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
                        String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(getEmotionListResponse == null ? 0 : getEmotionListResponse.EmotionCount);
                        if (!(getEmotionListResponse == null || getEmotionListResponse.ReqBuf == null)) {
                            i = getEmotionListResponse.ReqBuf.computeSize();
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(EmojiStoreV2BaseFragment.this.bkV());
                        C4990ab.m7411d(str, str2, objArr);
                        C42952j.getEmojiStorageMgr().xYq.mo64086a(EmojiStoreV2BaseFragment.this.bkV(), getEmotionListResponse);
                    }
                    AppMethodBeat.m2505o(53578);
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo23265a(C45843a c45843a) {
        if (c45843a.bjn() == 9) {
            m66009JP(getString(C25738R.string.f9245u6));
        }
        if (!bmd()) {
            this.kYr.kVD = 2;
        } else if (c45843a.mPosition >= 0 && c45843a.mPosition < this.kVA.bjw()) {
            this.kYr.kVD = 3;
        } else if (c45843a.mPosition < this.kVA.bjw() || c45843a.mPosition >= this.kVA.bjx() + this.kVA.bjw()) {
            this.kYr.kVD = 1;
        } else {
            this.kYr.kVD = 19;
        }
        this.kYr.mo68470a(c45843a);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.mListView.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.kVA.getCount()) {
            C11546f tX = this.kVA.getItem(headerViewsCount);
            m66012a(tX, headerViewsCount);
            if (bmd() && this.kVA.bjx() > 0 && headerViewsCount >= this.kVA.bjw() && headerViewsCount < this.kVA.bjw() + this.kVA.bjx() && tX.kTb != null) {
                C7060h.pYm.mo8381e(13223, Integer.valueOf(1), tX.kTb.ProductID, tX.kTb.PackName, Integer.valueOf(1), Integer.valueOf(0));
            }
        }
    }

    /* renamed from: tY */
    public final void mo61773tY(int i) {
        if (i >= 0 && i < ((C45844h) this.kVA).bjB()) {
            m66012a(this.kVA.getItem(i), i);
        }
    }

    /* renamed from: a */
    private void m66012a(C11546f c11546f, int i) {
        if (c11546f == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (c11546f.kTa == C11547a.cellset) {
            EmotionBannerSet emotionBannerSet = c11546f.kTc;
            if (emotionBannerSet == null) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                C11553m.m19374a(getContext(), emotionBannerSet, false);
            }
        } else {
            EmotionSummary emotionSummary = c11546f.kTb;
            if (emotionSummary == null) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
                return;
            }
            int i2;
            if (!bmd()) {
                i2 = 2;
            } else if (i >= 0 && i < this.kVA.bjw()) {
                i2 = 3;
            } else if (i < this.kVA.bjw() || i >= this.kVA.bjx() + this.kVA.bjw()) {
                i2 = 1;
            } else {
                i2 = 19;
            }
            C11553m.m19375a(getContext(), emotionSummary, i2, c11546f.mStatus, c11546f.f2905EV, thisActivity().getIntent().getStringExtra("to_talker_name"), 5);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.kYc == 0 || this.hZu) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
            return;
        }
        m66015gu(true);
        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        if (this.kYr != null) {
            this.kYr.onActivityResult(i, i2, intent);
        } else {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    /* renamed from: gu */
    private void m66015gu(boolean z) {
        if (this.hZu) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.hZu = true;
        if (z) {
            this.kYd.setVisibility(0);
        }
        m66013aI(this.kYe);
        bkX();
        C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            m66009JP(getString(C25738R.string.f9260un));
        }
    }

    /* renamed from: n */
    public final void mo61769n(Message message) {
        if (this.lda != null) {
            this.lda.sendMessage(message);
        }
    }

    /* renamed from: JP */
    private void m66009JP(String str) {
        if (isFinishing()) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        Context thisActivity = thisActivity();
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b(thisActivity, str, true, new C115909());
    }

    /* renamed from: A */
    public final void mo24138A(ArrayList<C44064n> arrayList) {
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.kVA != null) {
            if (this.lda != null) {
                this.lda.sendEmptyMessageDelayed(131074, 50);
            }
            C33945b.m55559a((ArrayList) arrayList, this.kVA.kSP);
        }
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group") && this.lda != null) {
            this.lda.sendEmptyMessageDelayed(131074, 50);
        }
    }

    public int getForceOrientation() {
        return 1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kXW != null) {
            this.kXW.requestLayout();
        }
        setRequestedOrientation(1);
    }

    /* renamed from: i */
    public final void mo23318i(String str, String str2, String str3, String str4) {
        this.kYu = new C42945g(str, str2, str3);
        C1720g.m3535RO().eJo.mo14541a(this.kYu, 0);
    }

    public final void bkf() {
        this.kYe = null;
        this.kYc = -1;
        m66015gu(false);
    }
}
