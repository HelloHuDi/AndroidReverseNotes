package com.tencent.mm.plugin.brandservice.ui.timeline;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;
import java.util.List;

public class BizTimeLineNewMsgUI extends MMActivity implements h {
    private TextView emptyTipTv;
    private int fromScene = 1;
    private ListView gGW;
    private int jLX = 0;
    private int jLY = 0;
    private a jMO;
    View jNV;
    ProgressBar jNW;
    TextView jNX;
    private View jNY;
    private e jNZ;
    private q jOa;
    private d jOb = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(14162);
            switch (menuItem.getItemId()) {
                case 1:
                    if (BizTimeLineNewMsgUI.this.jOa != null) {
                        z.aeY().mJ(BizTimeLineNewMsgUI.this.jOa.field_msgId);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(14162);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizTimeLineNewMsgUI() {
        AppMethodBeat.i(14163);
        AppMethodBeat.o(14163);
    }

    public void onCreate(Bundle bundle) {
        List p;
        AppMethodBeat.i(14164);
        super.onCreate(bundle);
        this.emptyTipTv = (TextView) findViewById(R.id.a74);
        this.emptyTipTv.setText(R.string.a9u);
        setMMTitle(getString(R.string.a_c));
        this.fromScene = getIntent().getIntExtra("biz_time_line_line_enter_scene", 1);
        if (this.fromScene == 1) {
            p = t.p(z.aeY().fni.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[]{"4"}, null, null, "createTime DESC "));
        } else {
            p = t.p(z.aeY().fni.query("BizTimeLineSingleMsgInfo", null, null, null, null, null, "createTime DESC limit 20"));
        }
        this.jNZ = new e(this, p, this.fromScene);
        this.gGW = (ListView) findViewById(R.id.a87);
        ListView listView = this.gGW;
        this.jNV = getLayoutInflater().inflate(R.layout.gz, null);
        this.jNW = (ProgressBar) this.jNV.findViewById(R.id.a78);
        this.jNX = (TextView) this.jNV.findViewById(R.id.a79);
        this.jNY = this.jNV.findViewById(R.id.a77);
        listView.addFooterView(this.jNV);
        this.gGW.setAdapter(this.jNZ);
        this.gGW.setFooterDividersEnabled(false);
        this.gGW.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(14157);
                o.ahp().cm(i);
                AppMethodBeat.o(14157);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.gGW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(14158);
                q sg = BizTimeLineNewMsgUI.this.jNZ.sg(i);
                if (sg == null) {
                    ab.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
                    AppMethodBeat.o(14158);
                } else if (((j) g.K(j.class)).bOr().jf(sg.field_msgId).field_msgId == 0) {
                    h.bQ(BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.getString(R.string.a_9));
                    AppMethodBeat.o(14158);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", sg.field_talker);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("from_global_search", true);
                    intent.putExtra("msg_local_id", sg.field_msgId);
                    intent.putExtra("specific_chat_from_scene", 9);
                    intent.putExtra("preChatTYPE", 13);
                    com.tencent.mm.bp.d.f(BizTimeLineNewMsgUI.this.mController.ylL, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(14158);
                }
            }
        });
        this.gGW.setEmptyView(this.emptyTipTv);
        if (this.fromScene == 1 && this.jNV != null) {
            this.jNW.setVisibility(8);
            this.jNX.setText(getString(R.string.a_b));
            this.jNV.setBackgroundResource(R.drawable.ej);
            this.jNY.setVisibility(0);
            this.jNV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(14161);
                    BizTimeLineNewMsgUI.this.jNV.setOnClickListener(null);
                    BizTimeLineNewMsgUI.this.jNZ.jNT = true;
                    BizTimeLineNewMsgUI.this.jNZ.sh(BizTimeLineNewMsgUI.this.jNZ.getCount() - 1);
                    BizTimeLineNewMsgUI.this.jNW.setVisibility(0);
                    BizTimeLineNewMsgUI.this.jNX.setText(BizTimeLineNewMsgUI.this.getString(R.string.a_4));
                    BizTimeLineNewMsgUI.this.jNV.setBackgroundColor(BizTimeLineNewMsgUI.this.getResources().getColor(R.color.gw));
                    BizTimeLineNewMsgUI.this.jNY.setVisibility(8);
                    AppMethodBeat.o(14161);
                }
            });
        }
        this.gGW.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(14159);
                switch (motionEvent.getAction()) {
                    case 0:
                        BizTimeLineNewMsgUI.this.jLX = (int) motionEvent.getRawX();
                        BizTimeLineNewMsgUI.this.jLY = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(14159);
                return false;
            }
        });
        this.jMO = new a(this);
        this.gGW.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(14160);
                BizTimeLineNewMsgUI.this.jOa = BizTimeLineNewMsgUI.this.jNZ.sg(i);
                BizTimeLineNewMsgUI.this.jMO.a(view, i, j, BizTimeLineNewMsgUI.this, BizTimeLineNewMsgUI.this.jOb, BizTimeLineNewMsgUI.this.jLX, BizTimeLineNewMsgUI.this.jLY);
                AppMethodBeat.o(14160);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(14156);
                BizTimeLineNewMsgUI.this.finish();
                AppMethodBeat.o(14156);
                return true;
            }
        });
        xE(-1052684);
        AppMethodBeat.o(14164);
    }

    public final int getLayoutId() {
        return R.layout.h7;
    }

    public final void aWv() {
        AppMethodBeat.i(14165);
        if (this.jNZ != null) {
            this.jNZ.notifyDataSetChanged();
        }
        AppMethodBeat.o(14165);
    }

    public void onDestroy() {
        AppMethodBeat.i(14166);
        super.onDestroy();
        z.aeY().a(this.jNZ.jKp);
        t aeY = z.aeY();
        aeY.fni.hY("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
        r.a aVar = new r.a();
        aVar.xId = b.UPDATE;
        aeY.a(aVar);
        AppMethodBeat.o(14166);
    }

    public void onResume() {
        AppMethodBeat.i(14167);
        super.onResume();
        AppMethodBeat.o(14167);
    }

    public void onPause() {
        AppMethodBeat.i(14168);
        super.onPause();
        AppMethodBeat.o(14168);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(14169);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 1, 0, R.string.a9p);
        AppMethodBeat.o(14169);
    }
}
