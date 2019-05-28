package com.tencent.mm.plugin.emoji.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.c;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ub;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53375);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        h.pYm.X(10931, String.valueOf(getIntent().getIntExtra("10931", 0)));
        ab.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", Integer.valueOf(r0));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53373);
                EmojiMineUI.this.finish();
                AppMethodBeat.o(53373);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.b_z), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53374);
                ArrayList duM = j.getEmojiStorageMgr().xYo.duM();
                ArrayList arrayList = new ArrayList();
                Iterator it = duM.iterator();
                while (it.hasNext()) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
                    if (emojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
                        arrayList.add(emojiGroupInfo);
                    }
                }
                if (arrayList.size() <= 1) {
                    com.tencent.mm.ui.base.h.g(EmojiMineUI.this.mController.ylL, R.string.b99, R.string.tz);
                    AppMethodBeat.o(53374);
                } else if (at.isConnected(ah.getContext())) {
                    Intent intent = new Intent();
                    intent.setClass(EmojiMineUI.this, EmojiSortUI.class);
                    EmojiMineUI.this.startActivity(intent);
                    AppMethodBeat.o(53374);
                } else {
                    EmojiMineUI.a(EmojiMineUI.this);
                    AppMethodBeat.o(53374);
                }
                return true;
            }
        });
        if (!((Boolean) g.RP().Ry().get(a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            com.tencent.mm.plugin.emoji.c.a.gm(true);
        }
        h.pYm.a(406, 3, 1, false);
        h.pYm.a(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
        h.pYm.e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24));
        AppMethodBeat.o(53375);
    }

    public final void initView() {
        AppMethodBeat.i(53376);
        setMMTitle((int) R.string.e6p);
        super.initView();
        this.kZu = findViewById(R.id.bdk);
        this.kZv = (TextView) this.kZu.findViewById(R.id.bdl);
        this.kZv.setText(R.string.bcq);
        if (j.bkj().kXj.kXr) {
            j.bkj();
            if (BKGLoaderManager.bkJ()) {
                this.kZu.setVisibility(0);
                dS(8001, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                this.mListView.setOnScrollListener(null);
                AppMethodBeat.o(53376);
            }
        }
        this.kZu.setVisibility(8);
        this.mListView.setOnScrollListener(null);
        AppMethodBeat.o(53376);
    }

    public void onClick(View view) {
        AppMethodBeat.i(53377);
        if (view == this.lag) {
            ug(0);
            AppMethodBeat.o(53377);
        } else if (view == this.lai) {
            Intent intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            startActivity(intent);
            AppMethodBeat.o(53377);
        } else if (view == this.lah) {
            ug(1);
            AppMethodBeat.o(53377);
        } else {
            AppMethodBeat.o(53377);
        }
    }

    private boolean ug(int i) {
        AppMethodBeat.i(53378);
        Intent intent = new Intent();
        intent.setClass(this, EmojiCustomUI.class);
        intent.putExtra("key_emoji_panel_type", i);
        startActivity(intent);
        AppMethodBeat.o(53378);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkS() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.emoji.a.a.a bkO() {
        AppMethodBeat.i(53379);
        c cVar = new c(this.mController.ylL);
        AppMethodBeat.o(53379);
        return cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bkV() {
        return 8;
    }

    /* Access modifiers changed, original: protected|final */
    public final int aH(byte[] bArr) {
        AppMethodBeat.i(53380);
        int aH = super.aH(bArr);
        AppMethodBeat.o(53380);
        return aH;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(53381);
        super.onItemClick(adapterView, view, i - 1, j);
        AppMethodBeat.o(53381);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(53382);
        if (str != null && str.equals("event_update_group")) {
            blo();
            dS(131074, 50);
        }
        AppMethodBeat.o(53382);
    }

    public final void h(String str, int i, int i2, String str2) {
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
        AppMethodBeat.i(53384);
        if (this.kVA != null) {
            this.kVA.notifyDataSetChanged();
            this.kYv = true;
            this.Ek.setVisibility(8);
        } else {
            z = false;
        }
        ble();
        AppMethodBeat.o(53384);
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(GetEmotionListResponse getEmotionListResponse) {
        AppMethodBeat.i(53385);
        super.c(getEmotionListResponse);
        AppMethodBeat.o(53385);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(boolean z, f fVar, boolean z2, boolean z3) {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bkR() {
        return false;
    }

    public final void m(Message message) {
        AppMethodBeat.i(53386);
        if (message.what == 8001 && this.kZu != null) {
            this.kZu.setVisibility(8);
        }
        super.m(message);
        AppMethodBeat.o(53386);
    }

    public final void ble() {
        AppMethodBeat.i(53387);
        if (this.laj != null) {
            if (this.kVA == null || this.kVA.isEmpty()) {
                this.lak.setVisibility(8);
            } else {
                this.lak.setVisibility(0);
                AppMethodBeat.o(53387);
                return;
            }
        }
        AppMethodBeat.o(53387);
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
        AppMethodBeat.i(53383);
        this.laj = (ViewGroup) View.inflate(this.mController.ylL, R.layout.tx, null);
        this.lak = (TextView) this.laj.findViewById(R.id.beo);
        this.lak.setText(R.string.e6r);
        this.lak.setVisibility(8);
        this.mListView.addHeaderView(this.laj, null, false);
        this.laf = (ViewGroup) View.inflate(this.mController.ylL, R.layout.tu, null);
        this.lag = (ViewGroup) this.laj.findViewById(R.id.bek);
        this.lah = (ViewGroup) this.laj.findViewById(R.id.bel);
        this.lai = (ViewGroup) this.laf.findViewById(R.id.bej);
        ((TextView) this.lag.findViewById(16908310)).setText(R.string.b9v);
        ((TextView) this.lai.findViewById(16908310)).setText(R.string.b_m);
        ((TextView) this.lah.findViewById(R.id.ben)).setText(R.string.b9n);
        this.lai.findViewById(R.id.m5).setBackgroundResource(R.drawable.k7);
        this.lag.setOnClickListener(this);
        this.lai.setOnClickListener(this);
        this.lah.setOnClickListener(this);
        this.mListView.addFooterView(this.laf, null, false);
        AppMethodBeat.o(53383);
    }

    static /* synthetic */ void a(EmojiMineUI emojiMineUI) {
        AppMethodBeat.i(53388);
        com.tencent.mm.ui.base.h.a((Context) emojiMineUI, emojiMineUI.getString(R.string.ba5), "", emojiMineUI.getString(R.string.ba4), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(53388);
    }
}
