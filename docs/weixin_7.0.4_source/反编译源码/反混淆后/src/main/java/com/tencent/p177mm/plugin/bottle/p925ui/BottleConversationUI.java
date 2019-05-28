package com.tencent.p177mm.plugin.bottle.p925ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37920l;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.bottle.C24727a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI */
public class BottleConversationUI extends MMActivity {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private ListView jJY;
    private C42789a jJZ;
    private C5279d jKa = new C2750810();
    private String talker;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$4 */
    class C200174 implements C23600g {
        C200174() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(18559);
            BottleConversationUI.this.jJY.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(18559);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$9 */
    class C200189 implements OnClickListener {
        C200189() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18564);
            C4978c.m7375a(BottleConversationUI.this.jJY);
            AppMethodBeat.m2505o(18564);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$3 */
    class C275033 implements C15521c {
        C275033() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(18558);
            int positionForView = BottleConversationUI.this.jJY.getPositionForView(view);
            AppMethodBeat.m2505o(18558);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$1 */
    class C275041 implements C30723a {
        C275041() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(18553);
            BottleConversationUI bottleConversationUI = BottleConversationUI.this;
            String string = BottleConversationUI.this.getString(C25738R.string.aah);
            int Yv = C37920l.m64042Yv();
            if (Yv <= 0) {
                bottleConversationUI.setMMTitle(string);
            } else {
                bottleConversationUI.setMMTitle(string + "(" + Yv + ")");
            }
            if (BottleConversationUI.this.jJZ.getCount() <= 0) {
                BottleConversationUI.this.emptyTipTv.setVisibility(0);
                BottleConversationUI.this.jJY.setVisibility(8);
                AppMethodBeat.m2505o(18553);
                return;
            }
            BottleConversationUI.this.emptyTipTv.setVisibility(8);
            BottleConversationUI.this.jJY.setVisibility(0);
            AppMethodBeat.m2505o(18553);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$7 */
    class C275067 implements OnItemClickListener {
        C275067() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(18562);
            C7617ak c7617ak = (C7617ak) BottleConversationUI.this.jJZ.getItem(i);
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", c7617ak.field_username);
            intent.putExtra("finish_direct", true);
            intent.putExtra("key_need_send_video", false);
            C24727a.gkE.mo38915d(intent, BottleConversationUI.this);
            AppMethodBeat.m2505o(18562);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$8 */
    class C275078 implements OnMenuItemClickListener {
        C275078() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18563);
            BottleConversationUI.this.finish();
            AppMethodBeat.m2505o(18563);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$10 */
    class C2750810 implements C5279d {
        C2750810() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(18565);
            BottleConversationUI.m43631a(BottleConversationUI.this, BottleConversationUI.this.talker);
            AppMethodBeat.m2505o(18565);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bottle.ui.BottleConversationUI$5 */
    class C275095 implements C23599f {
        C275095() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(18560);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
                AppMethodBeat.m2505o(18560);
                return;
            }
            BottleConversationUI.m43631a(BottleConversationUI.this, obj.toString());
            AppMethodBeat.m2505o(18560);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BottleConversationUI() {
        AppMethodBeat.m2504i(18566);
        AppMethodBeat.m2505o(18566);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18567);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(18567);
    }

    public final int getLayoutId() {
        return 2130970930;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(18568);
        this.jJZ.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(18568);
    }

    public void onResume() {
        AppMethodBeat.m2504i(18569);
        super.onResume();
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.jJZ);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10118a(this.jJZ);
        this.jJZ.mo5248a(null, null);
        AppMethodBeat.m2505o(18569);
    }

    public void onPause() {
        AppMethodBeat.m2504i(18570);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.jJZ);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10121b(this.jJZ);
        C9638aw.m17190ZK();
        C7620bi yw = C18628c.m29080XO().mo15355yw(8);
        if (yw != null && yw.field_msgId > 0) {
            C4990ab.m7410d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + yw.field_createTime);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(12306, Long.valueOf(yw.field_createTime));
        }
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ("floatbottle");
        if (aoZ == null || C5046bo.nullAsNil(aoZ.field_username).length() <= 0) {
            C4990ab.m7412e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            aoZ.mo14748hM(0);
            C9638aw.m17190ZK();
            if (C18628c.m29083XR().mo15767a(aoZ, aoZ.field_username) == -1) {
                C4990ab.m7412e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.jJZ.onPause();
        super.onPause();
        AppMethodBeat.m2505o(18570);
    }

    public final void initView() {
        AppMethodBeat.m2504i(18571);
        int YD = C1853r.m3822YD() | 4096;
        int YK = C1853r.m3829YK() & -65;
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(7, Integer.valueOf(YD));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(34, Integer.valueOf(YK));
        this.jJY = (ListView) findViewById(2131823620);
        this.emptyTipTv = (TextView) findViewById(2131821807);
        this.emptyTipTv.setText(C25738R.string.aab);
        this.jJZ = new C42789a(this, new C275041());
        this.jJZ.setGetViewPositionCallback(new C275033());
        this.jJZ.setPerformItemClickListener(new C200174());
        this.jJZ.mo68254a(new C275095());
        this.jJY.setAdapter(this.jJZ);
        final C46696j c46696j = new C46696j(this);
        this.jJY.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(18561);
                if (i < BottleConversationUI.this.jJY.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
                    AppMethodBeat.m2505o(18561);
                } else {
                    c46696j.mo75004a(view, i, j, BottleConversationUI.this, BottleConversationUI.this.jKa);
                    AppMethodBeat.m2505o(18561);
                }
                return true;
            }
        });
        this.jJY.setOnItemClickListener(new C275067());
        C24727a.gkF.mo38844BS();
        setBackBtn(new C275078());
        C200189 c200189 = new C200189();
        AppMethodBeat.m2505o(18571);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(18572);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.talker = ((C7617ak) this.jJZ.getItem(adapterContextMenuInfo.position)).field_username;
        Object[] objArr = new Object[1];
        C42789a c42789a = this.jJZ;
        C9638aw.m17190ZK();
        objArr[0] = c42789a.mo68253E(C18628c.m29078XM().aoO(this.talker));
        contextMenu.setHeaderTitle(getString(C25738R.string.aa8, objArr));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, C25738R.string.aa9);
        AppMethodBeat.m2505o(18572);
    }
}
