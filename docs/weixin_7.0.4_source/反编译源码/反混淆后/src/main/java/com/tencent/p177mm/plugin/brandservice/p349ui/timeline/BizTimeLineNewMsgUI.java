package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C23522t;
import com.tencent.p177mm.storage.C40635r.C40633a;
import com.tencent.p177mm.storage.C40635r.C40639b;
import com.tencent.p177mm.storage.C46627q;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI */
public class BizTimeLineNewMsgUI extends MMActivity implements C2697h {
    private TextView emptyTipTv;
    private int fromScene = 1;
    private ListView gGW;
    private int jLX = 0;
    private int jLY = 0;
    private C24088a jMO;
    View jNV;
    ProgressBar jNW;
    TextView jNX;
    private View jNY;
    private C27524e jNZ;
    private C46627q jOa;
    private C5279d jOb = new C386927();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI$2 */
    class C200472 implements OnScrollListener {
        C200472() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(14157);
            C32291o.ahp().mo43773cm(i);
            AppMethodBeat.m2505o(14157);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI$3 */
    class C200483 implements OnItemClickListener {
        C200483() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(14158);
            C46627q sg = BizTimeLineNewMsgUI.this.jNZ.mo45320sg(i);
            if (sg == null) {
                C4990ab.m7412e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
                AppMethodBeat.m2505o(14158);
            } else if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(sg.field_msgId).field_msgId == 0) {
                C30379h.m48465bQ(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(C25738R.string.a_9));
                AppMethodBeat.m2505o(14158);
            } else {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", sg.field_talker);
                intent.putExtra("finish_direct", true);
                intent.putExtra("from_global_search", true);
                intent.putExtra("msg_local_id", sg.field_msgId);
                intent.putExtra("specific_chat_from_scene", 9);
                intent.putExtra("preChatTYPE", 13);
                C25985d.m41473f(BizTimeLineNewMsgUI.this.mController.ylL, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.m2505o(14158);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI$4 */
    class C200494 implements OnTouchListener {
        C200494() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(14159);
            switch (motionEvent.getAction()) {
                case 0:
                    BizTimeLineNewMsgUI.this.jLX = (int) motionEvent.getRawX();
                    BizTimeLineNewMsgUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(14159);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI$1 */
    class C275171 implements OnMenuItemClickListener {
        C275171() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(14156);
            BizTimeLineNewMsgUI.this.finish();
            AppMethodBeat.m2505o(14156);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI$7 */
    class C386927 implements C5279d {
        C386927() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(14162);
            switch (menuItem.getItemId()) {
                case 1:
                    if (BizTimeLineNewMsgUI.this.jOa != null) {
                        C41747z.aeY().mo39196mJ(BizTimeLineNewMsgUI.this.jOa.field_msgId);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(14162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI$5 */
    class C428125 implements OnItemLongClickListener {
        C428125() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(14160);
            BizTimeLineNewMsgUI.this.jOa = BizTimeLineNewMsgUI.this.jNZ.mo45320sg(i);
            BizTimeLineNewMsgUI.this.jMO.mo39885a(view, i, j, BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.jOb, BizTimeLineNewMsgUI.this.jLX, BizTimeLineNewMsgUI.this.jLY);
            AppMethodBeat.m2505o(14160);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI$6 */
    class C428136 implements OnClickListener {
        C428136() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14161);
            BizTimeLineNewMsgUI.this.jNV.setOnClickListener(null);
            BizTimeLineNewMsgUI.this.jNZ.jNT = true;
            BizTimeLineNewMsgUI.this.jNZ.mo45321sh(BizTimeLineNewMsgUI.this.jNZ.getCount() - 1);
            BizTimeLineNewMsgUI.this.jNW.setVisibility(0);
            BizTimeLineNewMsgUI.this.jNX.setText(BizTimeLineNewMsgUI.this.getString(C25738R.string.a_4));
            BizTimeLineNewMsgUI.this.jNV.setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(C25738R.color.f11774gw));
            BizTimeLineNewMsgUI.this.jNY.setVisibility(8);
            AppMethodBeat.m2505o(14161);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BizTimeLineNewMsgUI() {
        AppMethodBeat.m2504i(14163);
        AppMethodBeat.m2505o(14163);
    }

    public void onCreate(Bundle bundle) {
        List p;
        AppMethodBeat.m2504i(14164);
        super.onCreate(bundle);
        this.emptyTipTv = (TextView) findViewById(2131821807);
        this.emptyTipTv.setText(C25738R.string.a9u);
        setMMTitle(getString(C25738R.string.a_c));
        this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
        if (this.fromScene == 1) {
            p = C23522t.m36351p(C41747z.aeY().fni.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[]{"4"}, null, null, "createTime DESC "));
        } else {
            p = C23522t.m36351p(C41747z.aeY().fni.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20"));
        }
        this.jNZ = new C27524e(this, p, this.fromScene);
        this.gGW = (ListView) findViewById(2131821847);
        ListView listView = this.gGW;
        this.jNV = getLayoutInflater().inflate(2130968860, null);
        this.jNW = (ProgressBar) this.jNV.findViewById(2131821811);
        this.jNX = (TextView) this.jNV.findViewById(2131821812);
        this.jNY = this.jNV.findViewById(2131821810);
        listView.addFooterView(this.jNV);
        this.gGW.setAdapter(this.jNZ);
        this.gGW.setFooterDividersEnabled(false);
        this.gGW.setOnScrollListener(new C200472());
        this.gGW.setOnItemClickListener(new C200483());
        this.gGW.setEmptyView(this.emptyTipTv);
        if (this.fromScene == 1 && this.jNV != null) {
            this.jNW.setVisibility(8);
            this.jNX.setText(getString(C25738R.string.a_b));
            this.jNV.setBackgroundResource(C25738R.drawable.f6448ej);
            this.jNY.setVisibility(0);
            this.jNV.setOnClickListener(new C428136());
        }
        this.gGW.setOnTouchListener(new C200494());
        this.jMO = new C24088a(this);
        this.gGW.setOnItemLongClickListener(new C428125());
        setBackBtn(new C275171());
        mo17446xE(-1052684);
        AppMethodBeat.m2505o(14164);
    }

    public final int getLayoutId() {
        return 2130968868;
    }

    public final void aWv() {
        AppMethodBeat.m2504i(14165);
        if (this.jNZ != null) {
            this.jNZ.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(14165);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(14166);
        super.onDestroy();
        C41747z.aeY().mo39190a(this.jNZ.jKp);
        C23522t aeY = C41747z.aeY();
        aeY.fni.mo10108hY("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
        C40633a c40633a = new C40633a();
        c40633a.xId = C40639b.UPDATE;
        aeY.mo39189a(c40633a);
        AppMethodBeat.m2505o(14166);
    }

    public void onResume() {
        AppMethodBeat.m2504i(14167);
        super.onResume();
        AppMethodBeat.m2505o(14167);
    }

    public void onPause() {
        AppMethodBeat.m2504i(14168);
        super.onPause();
        AppMethodBeat.m2505o(14168);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(14169);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 1, 0, C25738R.string.a9p);
        AppMethodBeat.m2505o(14169);
    }
}
