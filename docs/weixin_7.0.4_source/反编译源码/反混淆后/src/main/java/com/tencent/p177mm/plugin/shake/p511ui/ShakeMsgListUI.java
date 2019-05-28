package com.tencent.p177mm.plugin.shake.p511ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p1019b.C13248f;
import com.tencent.p177mm.plugin.shake.p1019b.C13249g;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.shake.ui.ShakeMsgListUI */
public class ShakeMsgListUI extends MMActivity {
    private int from;
    private C5279d jKa = new C397076();
    private long jvz;
    private TextView kFs;
    private int limit = 0;
    private int mType;
    private int oQK = 0;
    private int oQL = 0;
    private C13249g quO = null;
    private C46920d quP;
    private ListView quQ;

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeMsgListUI$1 */
    class C218371 implements OnMenuItemClickListener {
        C218371() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24751);
            ShakeMsgListUI.this.aqX();
            ShakeMsgListUI.this.finish();
            AppMethodBeat.m2505o(24751);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeMsgListUI$2 */
    class C218382 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeMsgListUI$2$1 */
        class C218391 implements OnClickListener {
            C218391() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(24752);
                C13249g a = ShakeMsgListUI.this.quO;
                a.bSd.delete(a.getTableName(), null, null);
                ShakeMsgListUI.this.quP.mo6869KC();
                ShakeMsgListUI.m67860c(ShakeMsgListUI.this);
                AppMethodBeat.m2505o(24752);
            }
        }

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeMsgListUI$2$2 */
        class C218402 implements OnClickListener {
            C218402() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C218382() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24753);
            C30379h.m48453a(ShakeMsgListUI.this.mController.ylL, true, ShakeMsgListUI.this.getString(C25738R.string.efc), "", ShakeMsgListUI.this.getString(C25738R.string.dx2), ShakeMsgListUI.this.getString(C25738R.string.f9076or), new C218391(), new C218402());
            AppMethodBeat.m2505o(24753);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeMsgListUI$4 */
    class C397054 implements OnItemClickListener {
        C397054() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(24755);
            C13248f c13248f = (C13248f) ShakeMsgListUI.this.quP.getItem(i);
            if (!C5046bo.isNullOrNil(c13248f.field_tag)) {
                C7060h.pYm.mo8374X(11316, ShakeMsgListUI.this.from + "," + c13248f.field_tag);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", c13248f.field_tag);
                C25985d.m41467b(ShakeMsgListUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(24755);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeMsgListUI$6 */
    class C397076 implements C5279d {
        C397076() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(24757);
            C13249g a = ShakeMsgListUI.this.quO;
            C4990ab.m7416i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(a.bSd.delete(a.getTableName(), "svrid = '" + String.valueOf(ShakeMsgListUI.this.jvz) + "'", null))));
            ShakeMsgListUI.this.quP.mo5248a(null, null);
            AppMethodBeat.m2505o(24757);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShakeMsgListUI() {
        AppMethodBeat.m2504i(24758);
        AppMethodBeat.m2505o(24758);
    }

    /* renamed from: c */
    static /* synthetic */ void m67860c(ShakeMsgListUI shakeMsgListUI) {
        AppMethodBeat.m2504i(24765);
        shakeMsgListUI.ckB();
        AppMethodBeat.m2505o(24765);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24759);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.quO = C28987m.cjT();
        this.oQL = this.quO.baS();
        this.limit = this.oQL == 0 ? 8 : this.oQL;
        this.oQK = this.quO.getCount();
        this.from = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.from == 1) {
            C7060h.pYm.mo8381e(11313, Integer.valueOf(this.oQL), C43527e.ckT());
        } else {
            C7060h.pYm.mo8381e(11315, Integer.valueOf(this.oQL), C43527e.ckT());
        }
        C13249g c13249g = this.quO;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(1));
        c13249g.bSd.update(c13249g.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        initView();
        AppMethodBeat.m2505o(24759);
    }

    public void onResume() {
        AppMethodBeat.m2504i(24760);
        super.onResume();
        if (this.oQK != this.quO.getCount()) {
            this.oQK = this.quO.getCount();
            if (this.oQK == 0) {
                ckB();
            }
            this.quP.mo6869KC();
        }
        this.quP.notifyDataSetChanged();
        AppMethodBeat.m2505o(24760);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24761);
        this.quP.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(24761);
    }

    public final int getLayoutId() {
        return 2130970656;
    }

    public final void initView() {
        AppMethodBeat.m2504i(24762);
        setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
        setBackBtn(new C218371());
        addTextOptionMenu(0, getString(C25738R.string.f9078ou), new C218382());
        this.kFs = (TextView) findViewById(2131821807);
        if (this.oQK == 0) {
            ckB();
        }
        this.quQ = (ListView) findViewById(2131827486);
        final View inflate = getLayoutInflater().inflate(2130970536, null);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(24754);
                ShakeMsgListUI.this.limit = ShakeMsgListUI.this.limit + 8;
                ShakeMsgListUI.this.quP.mo76129CA(ShakeMsgListUI.this.limit);
                if (ShakeMsgListUI.this.oQK <= ShakeMsgListUI.this.limit) {
                    ShakeMsgListUI.this.quQ.removeFooterView(inflate);
                }
                AppMethodBeat.m2505o(24754);
            }
        });
        if (this.oQK > 0 && this.limit < this.oQK) {
            this.quQ.addFooterView(inflate);
        }
        this.quP = new C46920d(this);
        this.quP.quL = this.limit;
        this.quQ.setAdapter(this.quP);
        this.quQ.setOnItemClickListener(new C397054());
        final C46696j c46696j = new C46696j(this);
        this.quQ.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(24756);
                if (i < ShakeMsgListUI.this.quQ.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
                    AppMethodBeat.m2505o(24756);
                } else {
                    c46696j.mo75004a(view, i, j, ShakeMsgListUI.this.mController.ylL, ShakeMsgListUI.this.jKa);
                    AppMethodBeat.m2505o(24756);
                }
                return true;
            }
        });
        AppMethodBeat.m2505o(24762);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(24763);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jvz = ((C13248f) this.quP.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, C25738R.string.f9088p4);
        AppMethodBeat.m2505o(24763);
    }

    private void ckB() {
        AppMethodBeat.m2504i(24764);
        this.kFs.setText(C25738R.string.efd);
        this.kFs.setVisibility(0);
        enableOptionMenu(false);
        AppMethodBeat.m2505o(24764);
    }
}
