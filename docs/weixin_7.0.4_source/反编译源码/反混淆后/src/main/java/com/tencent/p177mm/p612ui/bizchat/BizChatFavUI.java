package com.tencent.p177mm.p612ui.bizchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C25772n;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C37446b.C37447a;
import com.tencent.p177mm.p184aj.p185a.C37446b.C37447a.C32233b;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8924b;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45145s;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI */
public class BizChatFavUI extends MMActivity implements C25772n {
    private TextView emptyTipTv;
    private C44275p iGY;
    private boolean isCurrentActivity;
    private ListView jJY;
    private C5279d jKa;
    private long jMj;
    private String jMp;
    private C37447a yEm;
    private C25753a yEn;
    private C36108c yEs;

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$1 */
    class C304021 implements C37447a {
        C304021() {
        }

        /* renamed from: a */
        public final void mo48789a(C32233b c32233b) {
            AppMethodBeat.m2504i(30107);
            if (!(c32233b == null || c32233b.fxr == null || !BizChatFavUI.this.jMp.equals(c32233b.fxr.field_brandUserName))) {
                C4990ab.m7416i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
                if (BizChatFavUI.this.isCurrentActivity) {
                    BizChatFavUI.this.yEs.mo6869KC();
                }
            }
            AppMethodBeat.m2505o(30107);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$3 */
    class C304033 implements OnItemClickListener {
        C304033() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(30109);
            BizChatFavUI.m59428b(BizChatFavUI.this, ((C45142c) BizChatFavUI.this.yEs.getItem(i)).field_bizChatLocalId);
            AppMethodBeat.m2505o(30109);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$10 */
    class C3609710 implements C15521c {
        C3609710() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(30116);
            int positionForView = BizChatFavUI.this.jJY.getPositionForView(view);
            AppMethodBeat.m2505o(30116);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$11 */
    class C3609811 implements C23600g {
        C3609811() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(30117);
            BizChatFavUI.this.jJY.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(30117);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$12 */
    class C3609912 implements C23599f {
        C3609912() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(30118);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.BizChatFavUI", "onItemDel object null");
                AppMethodBeat.m2505o(30118);
                return;
            }
            AppMethodBeat.m2505o(30118);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$13 */
    class C3610013 implements C5279d {
        C3610013() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(30119);
            switch (menuItem.getItemId()) {
                case 0:
                    BizChatFavUI.m59427a(BizChatFavUI.this, BizChatFavUI.this.jMj);
                    break;
            }
            AppMethodBeat.m2505o(30119);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$5 */
    class C361015 implements Runnable {
        C361015() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30111);
            BizChatFavUI.this.finish();
            AppMethodBeat.m2505o(30111);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$6 */
    class C361026 implements C25753a {
        C361026() {
        }

        /* renamed from: a */
        public final void mo15833a(C8924b c8924b) {
            AppMethodBeat.m2504i(30112);
            if (!(c8924b == null || c8924b.fxB == null)) {
                C4990ab.m7416i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
                C45142c aK = C41747z.aeT().mo60349aK(c8924b.fxq);
                C4990ab.m7411d("MicroMsg.BizChatFavUI", "needToUpdate:%s", Boolean.valueOf(aK.field_needToUpdate));
                if (BizChatFavUI.this.isCurrentActivity) {
                    BizChatFavUI.this.yEs.mo6869KC();
                }
            }
            AppMethodBeat.m2505o(30112);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$7 */
    class C361037 implements OnMenuItemClickListener {
        C361037() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30113);
            BizChatFavUI.this.finish();
            AppMethodBeat.m2505o(30113);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$9 */
    class C361049 implements C30723a {
        C361049() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(30115);
            BizChatFavUI.this.setMMTitle(C1854s.m3866mJ(BizChatFavUI.this.jMp));
            if (BizChatFavUI.this.yEs.getCount() <= 0) {
                BizChatFavUI.this.emptyTipTv.setVisibility(0);
                BizChatFavUI.this.jJY.setVisibility(8);
                AppMethodBeat.m2505o(30115);
                return;
            }
            BizChatFavUI.this.emptyTipTv.setVisibility(8);
            BizChatFavUI.this.jJY.setVisibility(0);
            AppMethodBeat.m2505o(30115);
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatFavUI$8 */
    class C361058 implements OnScrollListener {
        C361058() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(30114);
            C32291o.ahp().mo43773cm(i);
            AppMethodBeat.m2505o(30114);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30120);
        super.onCreate(bundle);
        this.jMp = getIntent().getStringExtra("Contact_User");
        C4990ab.m7416i("MicroMsg.BizChatFavUI", "[registerListener]");
        this.yEm = new C304021();
        this.yEn = new C361026();
        C41747z.aeU().mo60334a(this.yEm, getMainLooper());
        C41747z.aeT().mo60347a(this.yEn, getMainLooper());
        initView();
        C41747z.aeZ();
        C1720g.m3535RO().eJo.mo14541a(new C45145s(this.jMp), 0);
        AppMethodBeat.m2505o(30120);
    }

    public final int getLayoutId() {
        return 2130969400;
    }

    public void onResume() {
        AppMethodBeat.m2504i(30122);
        super.onResume();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.jMp);
        if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
            finish();
            AppMethodBeat.m2505o(30122);
            return;
        }
        setTitleMuteIconVisibility(8);
        this.isCurrentActivity = true;
        this.yEs.mo5248a(null, null);
        C9638aw.getNotification().mo41582jO(this.jMp);
        AppMethodBeat.m2505o(30122);
    }

    public void onPause() {
        AppMethodBeat.m2504i(30123);
        this.yEs.onPause();
        this.isCurrentActivity = false;
        C9638aw.getNotification().mo41582jO("");
        super.onPause();
        AppMethodBeat.m2505o(30123);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(30124);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jMj = ((C45142c) this.yEs.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, C25738R.string.a_q);
        AppMethodBeat.m2505o(30124);
    }

    /* renamed from: a */
    public final void mo15832a(int i, C1207m c1207m) {
        AppMethodBeat.m2504i(30125);
        if (this.iGY != null) {
            this.iGY.dismiss();
        }
        AppMethodBeat.m2505o(30125);
    }

    public final void initView() {
        AppMethodBeat.m2504i(30126);
        btZ();
        dAO();
        bkL();
        dAP();
        dAN();
        AppMethodBeat.m2505o(30126);
    }

    private void btZ() {
        AppMethodBeat.m2504i(30127);
        this.jJY = (ListView) findViewById(2131823620);
        this.emptyTipTv = (TextView) findViewById(2131821807);
        this.emptyTipTv.setText(C25738R.string.a_p);
        AppMethodBeat.m2505o(30127);
    }

    private void dAN() {
        AppMethodBeat.m2504i(30128);
        setBackBtn(new C361037());
        AppMethodBeat.m2505o(30128);
    }

    private void dAO() {
        AppMethodBeat.m2504i(30129);
        this.jJY.setOnScrollListener(new C361058());
        AppMethodBeat.m2505o(30129);
    }

    private void bkL() {
        AppMethodBeat.m2504i(30130);
        this.yEs = new C36108c(this, new C361049(), this.jMp);
        this.yEs.setGetViewPositionCallback(new C3609710());
        this.yEs.setPerformItemClickListener(new C3609811());
        this.yEs.mo56949a(new C3609912());
        this.jJY.setAdapter(this.yEs);
        AppMethodBeat.m2505o(30130);
    }

    private void dAP() {
        AppMethodBeat.m2504i(30131);
        this.jKa = new C3610013();
        final C46696j c46696j = new C46696j(this);
        this.jJY.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(30108);
                if (i < BizChatFavUI.this.jJY.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
                    AppMethodBeat.m2505o(30108);
                } else {
                    c46696j.mo75004a(view, i, j, BizChatFavUI.this, BizChatFavUI.this.jKa);
                    AppMethodBeat.m2505o(30108);
                }
                return true;
            }
        });
        this.jJY.setOnItemClickListener(new C304033());
        AppMethodBeat.m2505o(30131);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30121);
        C4990ab.m7416i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        C41747z.aeU().mo60333a(this.yEm);
        C41747z.aeT().mo60346a(this.yEn);
        this.yEs.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(30121);
    }

    /* renamed from: b */
    static /* synthetic */ void m59428b(BizChatFavUI bizChatFavUI, long j) {
        AppMethodBeat.m2504i(30133);
        Intent intent = new Intent(bizChatFavUI, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.jMp);
        intent.putExtra("key_biz_chat_id", j);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        bizChatFavUI.startActivity(intent);
        C5004al.m7442n(new C361015(), 500);
        AppMethodBeat.m2505o(30133);
    }
}
