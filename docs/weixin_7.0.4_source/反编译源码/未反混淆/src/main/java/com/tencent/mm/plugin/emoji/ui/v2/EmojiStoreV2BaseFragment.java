package com.tencent.mm.plugin.emoji.ui.v2;

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
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.da;
import com.tencent.mm.plugin.emoji.a.h.a;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.model.i.b;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.v;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class EmojiStoreV2BaseFragment extends MMFragment implements OnScrollListener, OnItemClickListener, f, a, i.a, b, h.a, k.a, c, d, e {
    private View Ek;
    private ProgressDialog gqo;
    private boolean hZu;
    com.tencent.mm.plugin.emoji.a.a.a kVA;
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
    private n kYo;
    private int kYp;
    private com.tencent.mm.plugin.emoji.model.f kYq;
    private i kYr;
    private com.tencent.mm.sdk.b.c kYt = new com.tencent.mm.sdk.b.c<da>() {
        {
            AppMethodBeat.i(53572);
            this.xxI = da.class.getName().hashCode();
            AppMethodBeat.o(53572);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53573);
            da daVar = (da) bVar;
            if (daVar != null) {
                EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
                String str = daVar.cwf.cwg;
                int i = daVar.cwf.status;
                int i2 = daVar.cwf.progress;
                ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), daVar.cwf.cwh);
                if (emojiStoreV2BaseFragment.kVA != null) {
                    com.tencent.mm.plugin.emoji.a.a.c cVar = emojiStoreV2BaseFragment.kVA.kSP;
                    if (cVar != null) {
                        if (i == 6) {
                            Message obtain = Message.obtain();
                            obtain.getData().putString("product_id", str);
                            obtain.getData().putInt("progress", i2);
                            obtain.what = 131075;
                            emojiStoreV2BaseFragment.n(obtain);
                        } else {
                            ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", Integer.valueOf(i));
                            Message obtain2 = Message.obtain();
                            obtain2.getData().putString("product_id", str);
                            obtain2.getData().putInt("status", i);
                            obtain2.what = 131076;
                            emojiStoreV2BaseFragment.n(obtain2);
                        }
                        com.tencent.mm.plugin.emoji.a.a.f IT = cVar.IT(str);
                        if (IT != null) {
                            IT.kTe = r4;
                        }
                    }
                }
            }
            AppMethodBeat.o(53573);
            return false;
        }
    };
    private g kYu;
    private boolean kYv = false;
    private LinkedList<EmotionBanner> kYw = new LinkedList();
    private LinkedList<EmotionBannerSet> kYx = new LinkedList();
    private final int lcV = 131077;
    public EmojiStoreV2HotBarView lcW;
    private boolean lcX = false;
    private boolean lcY = false;
    private boolean lcZ = false;
    private ak lda = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53571);
            EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
            String string;
            switch (message.what) {
                case 131074:
                    if (emojiStoreV2BaseFragment.kVA != null) {
                        emojiStoreV2BaseFragment.kVA.notifyDataSetChanged();
                        AppMethodBeat.o(53571);
                        return;
                    }
                    break;
                case 131075:
                    if (emojiStoreV2BaseFragment.kVA == null || message.getData() == null) {
                        AppMethodBeat.o(53571);
                        return;
                    }
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        emojiStoreV2BaseFragment.kVA.bX(string, message.getData().getInt("progress"));
                        AppMethodBeat.o(53571);
                        return;
                    }
                    break;
                case 131076:
                    if (emojiStoreV2BaseFragment.kVA == null || message.getData() == null) {
                        AppMethodBeat.o(53571);
                        return;
                    }
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        emojiStoreV2BaseFragment.kVA.bW(string, message.getData().getInt("status"));
                        AppMethodBeat.o(53571);
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
            AppMethodBeat.o(53571);
        }
    };
    private OnMenuItemClickListener ldb = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(53574);
            EmojiStoreV2BaseFragment.this.thisActivity().finish();
            AppMethodBeat.o(53574);
            return false;
        }
    };
    private ActionBar mActionBar;
    private com.tencent.mm.ui.a mActionBarHelper;
    ListView mListView;

    public abstract com.tencent.mm.plugin.emoji.a.a.a bkO();

    public abstract int bkV();

    public abstract boolean bmd();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.mActionBar = ((AppCompatActivity) thisActivity()).getSupportActionBar();
        View inflate = v.hu(getContext()).inflate(R.layout.a_, null);
        this.mActionBarHelper = new com.tencent.mm.ui.a(inflate);
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.fc();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.fb();
        this.mActionBar.fd();
        this.mActionBar.setCustomView(inflate);
        this.mActionBar.show();
        com.tencent.mm.ui.a aVar = this.mActionBarHelper;
        aVar.gnB.setText(R.string.ba7);
        if (com.tencent.mm.bz.a.ga(aVar.gnB.getContext())) {
            aVar.gnB.setTextSize(0, com.tencent.mm.bz.a.fY(aVar.gnB.getContext()) * ((float) com.tencent.mm.bz.a.am(aVar.gnB.getContext(), R.dimen.dk)));
        }
        this.mActionBarHelper.b(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53575);
                if (EmojiStoreV2BaseFragment.this.isScreenEnable()) {
                    if (EmojiStoreV2BaseFragment.this.ldb != null) {
                        EmojiStoreV2BaseFragment.this.ldb.onMenuItemClick(null);
                    }
                    AppMethodBeat.o(53575);
                    return;
                }
                AppMethodBeat.o(53575);
            }
        });
        showOptionMenu(true);
        addIconOptionMenu(0, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53576);
                Intent intent = new Intent();
                intent.setClass(EmojiStoreV2BaseFragment.this.thisActivity(), EmojiMineUI.class);
                EmojiStoreV2BaseFragment.this.startActivity(intent);
                AppMethodBeat.o(53576);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.kYt);
        j.getEmojiStorageMgr().xYo.c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.lcZ = true;
        this.kVA = bkO();
        this.kVA.kSQ = this;
        this.Ek = findViewById(R.id.a5j);
        this.kYa = (TextView) this.Ek.findViewById(R.id.bfn);
        this.kYd = getActivityLayoutInflater().inflate(R.layout.u_, null);
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
            ((com.tencent.mm.plugin.emoji.a.h) this.kVA).kSy = this;
        }
        this.mListView.setOnScrollListener(this);
        this.mListView.setLongClickable(false);
        this.mListView.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.kVA.kSO = this.mListView;
        this.kXZ = (MMPullDownView) findViewById(R.id.bfv);
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
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        com.tencent.mm.kernel.g.RO().eJo.a(411, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a((int) v2helper.EMethodSetNgStrength, (f) this);
        if (this.lcX) {
            if (this.lda != null) {
                this.lda.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.kVA == null || this.kVA.kSP == null)) {
                this.kVA.kSP.bjD();
                this.kVA.refreshView();
            }
            if (((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(208900, Boolean.FALSE)).booleanValue()) {
                bkf();
                com.tencent.mm.kernel.g.RP().Ry().set(208900, Boolean.FALSE);
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", Boolean.valueOf(z));
        super.setUserVisibleHint(z);
        this.lcX = z;
        if (!this.lcY && this.lcZ) {
            blY();
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.RO().eJo.b(411, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b((int) v2helper.EMethodSetNgStrength, (f) this);
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.kXW != null) {
            this.kXW.blT();
        }
        if (this.lda != null) {
            this.lda.removeMessages(131077);
        }
    }

    public void onStop() {
        super.onStop();
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.kVA != null) {
            this.kVA.clear();
            this.kVA = null;
        }
        if (this.kXW != null) {
            this.kXW.blT();
            this.kXW.clear();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.kYt);
        j.getEmojiStorageMgr().xYo.d(this);
    }

    public void onDetach() {
        super.onDetach();
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void blY() {
        this.lcY = true;
        blZ();
        this.kYp = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
        if (!bma() || this.lda == null) {
            gt(true);
        } else {
            this.lda.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(53577);
                    EmojiStoreV2BaseFragment.this.gt(false);
                    AppMethodBeat.o(53577);
                }
            }, 3000);
        }
    }

    private void blZ() {
        this.kYr = new i();
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
        GetEmotionListResponse ME = j.getEmojiStorageMgr().xYq.ME(bkV());
        com.tencent.mm.plugin.emoji.model.f a = n.a(ME);
        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
        String str2 = "load cache type: %d, size: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bkV());
        objArr[1] = Integer.valueOf(ME == null ? 0 : ME.EmotionCount);
        ab.d(str, str2, objArr);
        if (a == null || a.kVq.size() <= 0) {
            return false;
        }
        int size;
        int i;
        int i2;
        this.kYv = true;
        this.Ek.setVisibility(8);
        this.kXZ.setVisibility(0);
        a(this.kYc, a);
        if (ME != null) {
            size = ME.CellSetList == null ? 0 : ME.CellSetList.size();
            i = ME.TopHotNum;
            i2 = ME.RecentHotNum;
        } else {
            i2 = 0;
            i = 0;
            size = 0;
        }
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", Integer.valueOf(i), Integer.valueOf(bkV()));
        if (this.kVA != null && bmd()) {
            this.kVA.tU(size + i);
            this.kVA.tV(i2);
        }
        bkU();
        return true;
    }

    public final void gt(boolean z) {
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", Boolean.valueOf(z), Boolean.valueOf(bmb()));
        if (!z) {
            bmb();
        }
        aI(this.kYe);
        bkX();
    }

    private void aI(byte[] bArr) {
        int bkV = bkV();
        int i = this.kYp;
        if (bArr != null) {
            ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", bArr.toString());
            this.kYo = new n(bkV, bArr, i);
            return;
        }
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.kYo = new n(bkV, i);
    }

    private void bkX() {
        com.tencent.mm.kernel.g.RO().eJo.a(this.kYo, 0);
    }

    private static boolean bmb() {
        ((Long) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_EMOJI_STORE_LAST_REFRESH_TIME_LONG, Long.valueOf(0))).longValue();
        return true;
    }

    private void a(int i, com.tencent.mm.plugin.emoji.model.f fVar) {
        boolean z;
        boolean z2;
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        switch (i) {
            case -1:
                this.kYq = fVar;
                z = true;
                z2 = true;
                break;
            case 0:
                this.kYq = fVar;
                z = false;
                z2 = false;
                break;
            case 1:
                this.kYq = fVar;
                z = false;
                z2 = true;
                break;
            case 2:
                if (this.kYq == null) {
                    this.kYq = new com.tencent.mm.plugin.emoji.model.f();
                }
                this.kYq.ue(fVar.kVp);
                this.kYq.br(fVar.kVq);
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
        A(z2, z);
    }

    private void bkU() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.kVA.kSP, (h.a) this);
    }

    private void A(boolean z, boolean z2) {
        if (this.kYq != null && z) {
            if (z2) {
                bmc();
            }
            if (this.kVA != null) {
                this.kVA.b(this.kYq);
            }
        }
    }

    private void bmc() {
        if (this.kYq == null) {
            ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
            return;
        }
        this.kYw = (LinkedList) this.kYq.kVs;
        this.kYx = (LinkedList) this.kYq.kVt;
        if (this.kYw != null) {
            this.kXW.d(this.kYw, this.kYx);
        } else if (this.kYq.kVr != null) {
            this.kYw = new LinkedList();
            this.kYw.add(this.kYq.kVr);
            this.kXW.d(this.kYw, this.kYx);
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        switch (mVar.getType()) {
            case 411:
                if (mVar instanceof n) {
                    n nVar = (n) mVar;
                    if (nVar != null && nVar.mType == bkV()) {
                        Object obj;
                        int i3 = 0;
                        int i4 = 0;
                        int i5 = 0;
                        if (!(nVar == null || nVar.bkB() == null)) {
                            if (this.kVA.bjy() <= 0 && bmd()) {
                                if (nVar.bkB().CellSetList == null) {
                                    i3 = 0;
                                } else {
                                    i3 = nVar.bkB().CellSetList.size();
                                }
                                this.kVA.tW(i3);
                            }
                            i4 = nVar.bkB().TopHotNum;
                            i5 = nVar.bkB().RecentHotNum;
                        }
                        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(r4), Integer.valueOf(nVar.mType));
                        if (this.kVA != null && this.kVA.bjx() <= 0 && bmd()) {
                            com.tencent.mm.plugin.emoji.a.a.a aVar = this.kVA;
                            aVar.tU(i4 + aVar.bjy());
                            this.kVA.tV(i5);
                        }
                        this.hZu = false;
                        this.kYd.setVisibility(8);
                        if (i == 0 || i == 4) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.Ek.setVisibility(8);
                            this.kXZ.setVisibility(0);
                            n nVar2 = (n) mVar;
                            com.tencent.mm.plugin.emoji.model.f a = n.a(nVar2.bkB());
                            this.kYe = nVar2.kWS;
                            GetEmotionListResponse bkB;
                            if (i2 == 0) {
                                bkB = nVar2.bkB();
                                a(this.kYc, a);
                                d(bkB);
                                this.kYc = 0;
                            } else if (i2 == 2) {
                                bkB = nVar2.bkB();
                                a(this.kYc, a);
                                bkU();
                                d(bkB);
                                this.kYc = 2;
                            } else if (i2 == 3) {
                                a(this.kYc, a);
                                this.kYc = 1;
                            } else {
                                this.Ek.setVisibility(0);
                                this.kXZ.setVisibility(8);
                                this.kYa.setText(R.string.bat);
                            }
                        } else if (!this.kYv) {
                            this.Ek.setVisibility(0);
                            this.kXZ.setVisibility(8);
                            this.kYa.setText(R.string.bau);
                        }
                        if (bmd()) {
                            if (!(nVar.bkB() == null || nVar.bkB().CellSetList == null || nVar.bkB().CellSetList.size() <= 0)) {
                                i3 = 0;
                                while (true) {
                                    i5 = i3;
                                    if (i5 < nVar.bkB().CellSetList.size()) {
                                        com.tencent.mm.plugin.report.service.h.pYm.e(13223, Integer.valueOf(0), Integer.valueOf(((EmotionBannerSet) nVar.bkB().CellSetList.get(i5)).ID), ((EmotionBannerSet) nVar.bkB().CellSetList.get(i5)).Title, Integer.valueOf(0));
                                        i3 = i5 + 1;
                                    }
                                }
                            }
                            if (nVar.bkB().RecentHotNum > 0 && nVar.bkB().EmotionList != null && nVar.bkB().EmotionList.size() > nVar.bkB().TopHotNum + nVar.bkB().RecentHotNum) {
                                i3 = 0;
                                while (true) {
                                    i5 = i3;
                                    if (i5 < nVar.bkB().RecentHotNum) {
                                        com.tencent.mm.plugin.report.service.h.pYm.e(13223, Integer.valueOf(0), ((EmotionSummary) nVar.bkB().EmotionList.get(nVar.bkB().TopHotNum + i5)).ProductID, ((EmotionSummary) nVar.bkB().EmotionList.get(nVar.bkB().TopHotNum + i5)).PackName, Integer.valueOf(1));
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
                ab.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    public final boolean bhk() {
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        gu(true);
        return true;
    }

    public final boolean bhl() {
        return false;
    }

    public final boolean bhm() {
        return false;
    }

    private void d(final GetEmotionListResponse getEmotionListResponse) {
        if (this.kYc == -1) {
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.i(53578);
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
                        ab.d(str, str2, objArr);
                        j.getEmojiStorageMgr().xYq.a(EmojiStoreV2BaseFragment.this.bkV(), getEmotionListResponse);
                    }
                    AppMethodBeat.o(53578);
                }
            });
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar.bjn() == 9) {
            JP(getString(R.string.u6));
        }
        if (!bmd()) {
            this.kYr.kVD = 2;
        } else if (aVar.mPosition >= 0 && aVar.mPosition < this.kVA.bjw()) {
            this.kYr.kVD = 3;
        } else if (aVar.mPosition < this.kVA.bjw() || aVar.mPosition >= this.kVA.bjx() + this.kVA.bjw()) {
            this.kYr.kVD = 1;
        } else {
            this.kYr.kVD = 19;
        }
        this.kYr.a(aVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.mListView.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.kVA.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f tX = this.kVA.getItem(headerViewsCount);
            a(tX, headerViewsCount);
            if (bmd() && this.kVA.bjx() > 0 && headerViewsCount >= this.kVA.bjw() && headerViewsCount < this.kVA.bjw() + this.kVA.bjx() && tX.kTb != null) {
                com.tencent.mm.plugin.report.service.h.pYm.e(13223, Integer.valueOf(1), tX.kTb.ProductID, tX.kTb.PackName, Integer.valueOf(1), Integer.valueOf(0));
            }
        }
    }

    public final void tY(int i) {
        if (i >= 0 && i < ((com.tencent.mm.plugin.emoji.a.h) this.kVA).bjB()) {
            a(this.kVA.getItem(i), i);
        }
    }

    private void a(com.tencent.mm.plugin.emoji.a.a.f fVar, int i) {
        if (fVar == null) {
            ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (fVar.kTa == com.tencent.mm.plugin.emoji.a.a.f.a.cellset) {
            EmotionBannerSet emotionBannerSet = fVar.kTc;
            if (emotionBannerSet == null) {
                ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                com.tencent.mm.plugin.emoji.e.m.a(getContext(), emotionBannerSet, false);
            }
        } else {
            EmotionSummary emotionSummary = fVar.kTb;
            if (emotionSummary == null) {
                ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
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
            com.tencent.mm.plugin.emoji.e.m.a(getContext(), emotionSummary, i2, fVar.mStatus, fVar.EV, thisActivity().getIntent().getStringExtra("to_talker_name"), 5);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.kYc == 0 || this.hZu) {
            ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
            return;
        }
        gu(true);
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        if (this.kYr != null) {
            this.kYr.onActivityResult(i, i2, intent);
        } else {
            ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    private void gu(boolean z) {
        if (this.hZu) {
            ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.hZu = true;
        if (z) {
            this.kYd.setVisibility(0);
        }
        aI(this.kYe);
        bkX();
        ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            JP(getString(R.string.un));
        }
    }

    public final void n(Message message) {
        if (this.lda != null) {
            this.lda.sendMessage(message);
        }
    }

    private void JP(String str) {
        if (isFinishing()) {
            ab.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        Context thisActivity = thisActivity();
        getString(R.string.tz);
        this.gqo = com.tencent.mm.ui.base.h.b(thisActivity, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    public final void A(ArrayList<com.tencent.mm.pluginsdk.model.n> arrayList) {
        ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.kVA != null) {
            if (this.lda != null) {
                this.lda.sendEmptyMessageDelayed(131074, 50);
            }
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.kVA.kSP);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
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

    public final void i(String str, String str2, String str3, String str4) {
        this.kYu = new g(str, str2, str3);
        com.tencent.mm.kernel.g.RO().eJo.a(this.kYu, 0);
    }

    public final void bkf() {
        this.kYe = null;
        this.kYc = -1;
        gu(false);
    }
}
