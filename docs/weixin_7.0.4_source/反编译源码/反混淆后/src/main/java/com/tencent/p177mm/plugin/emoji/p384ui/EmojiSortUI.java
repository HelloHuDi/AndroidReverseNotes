package com.tencent.p177mm.plugin.emoji.p384ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C16018h;
import com.tencent.p177mm.p612ui.widget.sortlist.DragSortListView.C30819l;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p381a.C2929e;
import com.tencent.p177mm.plugin.emoji.p726f.C45857s;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI */
public class EmojiSortUI extends EmojiBaseActivity implements C1202f, C4931a {
    ProgressDialog gqo;
    private C2929e laq;
    private DragSortListView lar;
    private C45857s las;
    private C16018h lau = new C203924();
    private C30819l lav = new C203935();
    private ArrayList<EmojiGroupInfo> mData = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI$1 */
    class C29471 implements OnMenuItemClickListener {
        C29471() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53408);
            EmojiSortUI.this.finish();
            AppMethodBeat.m2505o(53408);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI$7 */
    class C115727 implements OnClickListener {
        C115727() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI$4 */
    class C203924 implements C16018h {
        C203924() {
        }

        /* renamed from: dm */
        public final void mo17752dm(int i, int i2) {
            AppMethodBeat.m2504i(53411);
            EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) EmojiSortUI.this.laq.getItem(i);
            EmojiSortUI.this.laq.remove(emojiGroupInfo);
            EmojiSortUI.this.laq.insert(emojiGroupInfo, i2);
            AppMethodBeat.m2505o(53411);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI$5 */
    class C203935 implements C30819l {
        C203935() {
        }

        public final void remove(int i) {
            AppMethodBeat.m2504i(53412);
            EmojiSortUI.this.laq.remove(EmojiSortUI.this.laq.getItem(i));
            AppMethodBeat.m2505o(53412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI$3 */
    class C203943 implements OnCancelListener {
        C203943() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53410);
            if (EmojiSortUI.this.las != null) {
                C1720g.m3535RO().eJo.mo14547c(EmojiSortUI.this.las);
            }
            AppMethodBeat.m2505o(53410);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI$6 */
    class C203956 implements OnClickListener {
        C203956() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiSortUI$2 */
    class C203962 implements OnMenuItemClickListener {
        C203962() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53409);
            if (C5023at.isConnected(C4996ah.getContext())) {
                Context context = EmojiSortUI.this;
                context.getString(C25738R.string.f9238tz);
                context.gqo = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, new C203943());
                ArrayList arrayList = new ArrayList();
                if (!(EmojiSortUI.this.laq == null || EmojiSortUI.this.laq.kSg == null)) {
                    for (EmojiGroupInfo emojiGroupInfo : EmojiSortUI.this.laq.kSg) {
                        arrayList.add(emojiGroupInfo.field_productID);
                    }
                }
                EmojiSortUI.this.las = new C45857s(arrayList, 2);
                C1720g.m3535RO().eJo.mo14541a(EmojiSortUI.this.las, 0);
            } else {
                EmojiSortUI.m31567a(EmojiSortUI.this);
            }
            AppMethodBeat.m2505o(53409);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiSortUI() {
        AppMethodBeat.m2504i(53413);
        AppMethodBeat.m2505o(53413);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53414);
        super.onCreate(bundle);
        initView();
        this.mData = C42952j.getEmojiStorageMgr().xYo.duM();
        this.lar = (DragSortListView) findViewById(16908298);
        this.lar.setDropListener(this.lau);
        this.lar.setRemoveListener(this.lav);
        this.laq = new C2929e(this.mController.ylL, this.mData);
        this.lar.setAdapter(this.laq);
        C42952j.getEmojiStorageMgr().xYo.mo10116c(this);
        C1720g.m3535RO().eJo.mo14539a(717, (C1202f) this);
        AppMethodBeat.m2505o(53414);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53415);
        C42952j.getEmojiStorageMgr().xYo.mo10117d(this);
        C1720g.m3535RO().eJo.mo14546b(717, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(53415);
    }

    public final int getLayoutId() {
        return 2130969346;
    }

    public final void initView() {
        AppMethodBeat.m2504i(53416);
        setBackBtn(new C29471());
        setMMTitle(getString(C25738R.string.e6o));
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C203962());
        ((TextView) findViewById(16908310)).setText(C25738R.string.bay);
        AppMethodBeat.m2505o(53416);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(53417);
        if (!(str == null || !str.equals("event_update_group") || this.laq == null)) {
            C2929e c2929e = this.laq;
            ArrayList duM = C42952j.getEmojiStorageMgr().xYo.duM();
            c2929e.clear();
            Iterator it = duM.iterator();
            while (it.hasNext()) {
                c2929e.insert((EmojiGroupInfo) it.next(), c2929e.getCount());
            }
            c2929e.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(53417);
    }

    /* renamed from: l */
    public final void mo30731l(Message message) {
    }

    /* renamed from: m */
    public final void mo30732m(Message message) {
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53418);
        C4990ab.m7410d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i + "   errCode:" + i2);
        if (this.gqo != null) {
            this.gqo.dismiss();
        }
        if (i == 0 && i == 0) {
            this.laq.bjz();
            finish();
            AppMethodBeat.m2505o(53418);
            return;
        }
        C30379h.m48438a((Context) this, getString(C25738R.string.ba3), "", new C203956());
        AppMethodBeat.m2505o(53418);
    }

    /* renamed from: a */
    static /* synthetic */ void m31567a(EmojiSortUI emojiSortUI) {
        AppMethodBeat.m2504i(53419);
        C30379h.m48443a((Context) emojiSortUI, emojiSortUI.getString(C25738R.string.ba5), "", emojiSortUI.getString(C25738R.string.ba4), new C115727());
        AppMethodBeat.m2505o(53419);
    }
}
