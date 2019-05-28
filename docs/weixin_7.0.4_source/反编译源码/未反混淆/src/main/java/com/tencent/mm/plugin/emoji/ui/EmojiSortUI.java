package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.e;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiSortUI extends EmojiBaseActivity implements f, a {
    ProgressDialog gqo;
    private e laq;
    private DragSortListView lar;
    private s las;
    private h lau = new h() {
        public final void dm(int i, int i2) {
            AppMethodBeat.i(53411);
            EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) EmojiSortUI.this.laq.getItem(i);
            EmojiSortUI.this.laq.remove(emojiGroupInfo);
            EmojiSortUI.this.laq.insert(emojiGroupInfo, i2);
            AppMethodBeat.o(53411);
        }
    };
    private l lav = new l() {
        public final void remove(int i) {
            AppMethodBeat.i(53412);
            EmojiSortUI.this.laq.remove(EmojiSortUI.this.laq.getItem(i));
            AppMethodBeat.o(53412);
        }
    };
    private ArrayList<EmojiGroupInfo> mData = new ArrayList();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiSortUI() {
        AppMethodBeat.i(53413);
        AppMethodBeat.o(53413);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53414);
        super.onCreate(bundle);
        initView();
        this.mData = j.getEmojiStorageMgr().xYo.duM();
        this.lar = (DragSortListView) findViewById(16908298);
        this.lar.setDropListener(this.lau);
        this.lar.setRemoveListener(this.lav);
        this.laq = new e(this.mController.ylL, this.mData);
        this.lar.setAdapter(this.laq);
        j.getEmojiStorageMgr().xYo.c(this);
        g.RO().eJo.a(717, (f) this);
        AppMethodBeat.o(53414);
    }

    public void onDestroy() {
        AppMethodBeat.i(53415);
        j.getEmojiStorageMgr().xYo.d(this);
        g.RO().eJo.b(717, (f) this);
        super.onDestroy();
        AppMethodBeat.o(53415);
    }

    public final int getLayoutId() {
        return R.layout.u2;
    }

    public final void initView() {
        AppMethodBeat.i(53416);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53408);
                EmojiSortUI.this.finish();
                AppMethodBeat.o(53408);
                return true;
            }
        });
        setMMTitle(getString(R.string.e6o));
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53409);
                if (at.isConnected(ah.getContext())) {
                    Context context = EmojiSortUI.this;
                    context.getString(R.string.tz);
                    context.gqo = com.tencent.mm.ui.base.h.b(context, context.getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(53410);
                            if (EmojiSortUI.this.las != null) {
                                g.RO().eJo.c(EmojiSortUI.this.las);
                            }
                            AppMethodBeat.o(53410);
                        }
                    });
                    ArrayList arrayList = new ArrayList();
                    if (!(EmojiSortUI.this.laq == null || EmojiSortUI.this.laq.kSg == null)) {
                        for (EmojiGroupInfo emojiGroupInfo : EmojiSortUI.this.laq.kSg) {
                            arrayList.add(emojiGroupInfo.field_productID);
                        }
                    }
                    EmojiSortUI.this.las = new s(arrayList, 2);
                    g.RO().eJo.a(EmojiSortUI.this.las, 0);
                } else {
                    EmojiSortUI.a(EmojiSortUI.this);
                }
                AppMethodBeat.o(53409);
                return true;
            }
        });
        ((TextView) findViewById(16908310)).setText(R.string.bay);
        AppMethodBeat.o(53416);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(53417);
        if (!(str == null || !str.equals("event_update_group") || this.laq == null)) {
            e eVar = this.laq;
            ArrayList duM = j.getEmojiStorageMgr().xYo.duM();
            eVar.clear();
            Iterator it = duM.iterator();
            while (it.hasNext()) {
                eVar.insert((EmojiGroupInfo) it.next(), eVar.getCount());
            }
            eVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(53417);
    }

    public final void l(Message message) {
    }

    public final void m(Message message) {
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(53418);
        ab.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i + "   errCode:" + i2);
        if (this.gqo != null) {
            this.gqo.dismiss();
        }
        if (i == 0 && i == 0) {
            this.laq.bjz();
            finish();
            AppMethodBeat.o(53418);
            return;
        }
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ba3), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(53418);
    }

    static /* synthetic */ void a(EmojiSortUI emojiSortUI) {
        AppMethodBeat.i(53419);
        com.tencent.mm.ui.base.h.a((Context) emojiSortUI, emojiSortUI.getString(R.string.ba5), "", emojiSortUI.getString(R.string.ba4), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(53419);
    }
}
