package com.tencent.p177mm.plugin.emoji.p384ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p1252c.C27731a;
import com.tencent.p177mm.plugin.emoji.p381a.C36759c;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiMineUI */
public class EmojiMineUI extends BaseEmojiStoreUI implements OnClickListener {
    private final String TAG = "MicroMsg.emoji.EmojiMineUI";
    private View kZu;
    private TextView kZv;
    private ViewGroup laf;
    private ViewGroup lag;
    private ViewGroup lah;
    private ViewGroup lai;
    private ViewGroup laj;
    private TextView lak;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiMineUI$1 */
    class C277541 implements OnMenuItemClickListener {
        C277541() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53373);
            EmojiMineUI.this.finish();
            AppMethodBeat.m2505o(53373);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiMineUI$2 */
    class C277552 implements OnMenuItemClickListener {
        C277552() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53374);
            ArrayList duM = C42952j.getEmojiStorageMgr().xYo.duM();
            ArrayList arrayList = new ArrayList();
            Iterator it = duM.iterator();
            while (it.hasNext()) {
                EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
                if (emojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
                    arrayList.add(emojiGroupInfo);
                }
            }
            if (arrayList.size() <= 1) {
                C30379h.m48467g(EmojiMineUI.this.mController.ylL, C25738R.string.b99, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(53374);
            } else if (C5023at.isConnected(C4996ah.getContext())) {
                Intent intent = new Intent();
                intent.setClass(EmojiMineUI.this, EmojiSortUI.class);
                EmojiMineUI.this.startActivity(intent);
                AppMethodBeat.m2505o(53374);
            } else {
                EmojiMineUI.m44098a(EmojiMineUI.this);
                AppMethodBeat.m2505o(53374);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiMineUI$3 */
    class C277563 implements DialogInterface.OnClickListener {
        C277563() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969356;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53375);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        C7060h.pYm.mo8374X(10931, String.valueOf(getIntent().getIntExtra("10931", 0)));
        C4990ab.m7417i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", Integer.valueOf(r0));
        setBackBtn(new C277541());
        addTextOptionMenu(0, getString(C25738R.string.b_z), new C277552());
        if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            C27731a.m44046gm(true);
        }
        C7060h.pYm.mo8378a(406, 3, 1, false);
        C7060h.pYm.mo8378a(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
        C7060h.pYm.mo8381e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24));
        AppMethodBeat.m2505o(53375);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53376);
        setMMTitle((int) C25738R.string.e6p);
        super.initView();
        this.kZu = findViewById(2131823451);
        this.kZv = (TextView) this.kZu.findViewById(2131823452);
        this.kZv.setText(C25738R.string.bcq);
        if (C42952j.bkj().kXj.kXr) {
            C42952j.bkj();
            if (BKGLoaderManager.bkJ()) {
                this.kZu.setVisibility(0);
                mo45578dS(8001, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                this.mListView.setOnScrollListener(null);
                AppMethodBeat.m2505o(53376);
            }
        }
        this.kZu.setVisibility(8);
        this.mListView.setOnScrollListener(null);
        AppMethodBeat.m2505o(53376);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(53377);
        if (view == this.lag) {
            m44099ug(0);
            AppMethodBeat.m2505o(53377);
        } else if (view == this.lai) {
            Intent intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            startActivity(intent);
            AppMethodBeat.m2505o(53377);
        } else if (view == this.lah) {
            m44099ug(1);
            AppMethodBeat.m2505o(53377);
        } else {
            AppMethodBeat.m2505o(53377);
        }
    }

    /* renamed from: ug */
    private boolean m44099ug(int i) {
        AppMethodBeat.m2504i(53378);
        Intent intent = new Intent();
        intent.setClass(this, EmojiCustomUI.class);
        intent.putExtra("key_emoji_panel_type", i);
        startActivity(intent);
        AppMethodBeat.m2505o(53378);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkS() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final C33944a bkO() {
        AppMethodBeat.m2504i(53379);
        C36759c c36759c = new C36759c(this.mController.ylL);
        AppMethodBeat.m2505o(53379);
        return c36759c;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkV() {
        return 8;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aH */
    public final int mo30708aH(byte[] bArr) {
        AppMethodBeat.m2504i(53380);
        int aH = super.mo30708aH(bArr);
        AppMethodBeat.m2505o(53380);
        return aH;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(53381);
        super.onItemClick(adapterView, view, i - 1, j);
        AppMethodBeat.m2505o(53381);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(53382);
        if (str != null && str.equals("event_update_group")) {
            blo();
            mo45578dS(131074, 50);
        }
        AppMethodBeat.m2505o(53382);
    }

    /* renamed from: h */
    public final void mo30729h(String str, int i, int i2, String str2) {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bld() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean blc() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bla() {
        boolean z = true;
        AppMethodBeat.m2504i(53384);
        if (this.kVA != null) {
            this.kVA.notifyDataSetChanged();
            this.kYv = true;
            this.f3573Ek.setVisibility(8);
        } else {
            z = false;
        }
        ble();
        AppMethodBeat.m2505o(53384);
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo30728c(GetEmotionListResponse getEmotionListResponse) {
        AppMethodBeat.m2504i(53385);
        super.mo30728c(getEmotionListResponse);
        AppMethodBeat.m2505o(53385);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo30707a(boolean z, C20383f c20383f, boolean z2, boolean z3) {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkR() {
        return false;
    }

    /* renamed from: m */
    public final void mo30732m(Message message) {
        AppMethodBeat.m2504i(53386);
        if (message.what == 8001 && this.kZu != null) {
            this.kZu.setVisibility(8);
        }
        super.mo30732m(message);
        AppMethodBeat.m2505o(53386);
    }

    public final void ble() {
        AppMethodBeat.m2504i(53387);
        if (this.laj != null) {
            if (this.kVA == null || this.kVA.isEmpty()) {
                this.lak.setVisibility(8);
            } else {
                this.lak.setVisibility(0);
                AppMethodBeat.m2505o(53387);
                return;
            }
        }
        AppMethodBeat.m2505o(53387);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkM() {
        return 24;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkN() {
        return 7;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkP() {
        AppMethodBeat.m2504i(53383);
        this.laj = (ViewGroup) View.inflate(this.mController.ylL, 2130969341, null);
        this.lak = (TextView) this.laj.findViewById(2131823492);
        this.lak.setText(C25738R.string.e6r);
        this.lak.setVisibility(8);
        this.mListView.addHeaderView(this.laj, null, false);
        this.laf = (ViewGroup) View.inflate(this.mController.ylL, 2130969338, null);
        this.lag = (ViewGroup) this.laj.findViewById(2131823488);
        this.lah = (ViewGroup) this.laj.findViewById(2131823489);
        this.lai = (ViewGroup) this.laf.findViewById(2131823487);
        ((TextView) this.lag.findViewById(16908310)).setText(C25738R.string.b9v);
        ((TextView) this.lai.findViewById(16908310)).setText(C25738R.string.b_m);
        ((TextView) this.lah.findViewById(2131823491)).setText(C25738R.string.b9n);
        this.lai.findViewById(2131821019).setBackgroundResource(C25738R.drawable.f6625k7);
        this.lag.setOnClickListener(this);
        this.lai.setOnClickListener(this);
        this.lah.setOnClickListener(this);
        this.mListView.addFooterView(this.laf, null, false);
        AppMethodBeat.m2505o(53383);
    }

    /* renamed from: a */
    static /* synthetic */ void m44098a(EmojiMineUI emojiMineUI) {
        AppMethodBeat.m2504i(53388);
        C30379h.m48443a((Context) emojiMineUI, emojiMineUI.getString(C25738R.string.ba5), "", emojiMineUI.getString(C25738R.string.ba4), new C277563());
        AppMethodBeat.m2505o(53388);
    }
}
