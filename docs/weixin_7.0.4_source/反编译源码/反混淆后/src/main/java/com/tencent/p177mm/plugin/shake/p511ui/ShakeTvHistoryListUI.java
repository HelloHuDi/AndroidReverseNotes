package com.tencent.p177mm.plugin.shake.p511ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C13264n;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3826k;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C46199o;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C7087c;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI */
public class ShakeTvHistoryListUI extends MMActivity {
    private C5279d jKa = new C290105();
    private C29011a qwv;
    private ListView qww;
    private String username;

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$3 */
    class C218423 implements OnItemClickListener {
        C218423() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(24895);
            C13264n c13264n = (C13264n) ShakeTvHistoryListUI.this.qwv.getItem(i);
            AppCompatActivity appCompatActivity = ShakeTvHistoryListUI.this.mController.ylL;
            if (c13264n != null) {
                if (C5046bo.isNullOrNil(c13264n.field_username) && C5046bo.isNullOrNil(c13264n.field_deeplink)) {
                    C7060h.pYm.mo8381e(12108, C5046bo.nullAsNil(c13264n.field_username), Integer.valueOf(2), Integer.valueOf(0));
                    AppMethodBeat.m2505o(24895);
                    return;
                }
                C3826k.m6122a(c13264n.field_username, c13264n.field_deeplink, 2, appCompatActivity);
                C4990ab.m7416i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
            }
            AppMethodBeat.m2505o(24895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$5 */
    class C290105 implements C5279d {
        C290105() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(24897);
            switch (menuItem.getItemId()) {
                case 0:
                    int i2;
                    C7060h.pYm.mo8381e(12662, Integer.valueOf(1), C5046bo.nullAsNil(ShakeTvHistoryListUI.this.username));
                    C46199o cjU = C28987m.cjU();
                    String d = ShakeTvHistoryListUI.this.username;
                    if (C5046bo.isNullOrNil(d)) {
                        i2 = -1;
                    } else {
                        i2 = cjU.bSd.delete(cjU.getTableName(), "username = '" + d + "'", null);
                        C4990ab.m7410d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = ".concat(String.valueOf(i2)));
                    }
                    if (i2 < 0) {
                        C4990ab.m7417i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", Integer.valueOf(i2));
                    } else {
                        C9638aw.m17182Rg().mo14541a(new C7087c(1, ShakeTvHistoryListUI.this.username), 0);
                    }
                    ShakeTvHistoryListUI.this.qwv.mo5248a(null, null);
                    break;
            }
            AppMethodBeat.m2505o(24897);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$a */
    class C29011a extends C46692p<C13264n> {
        private LayoutInflater mInflater;

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$a$a */
        class C29012a {
            TextView iDT;
            TextView nSC;
            MMImageView qwz;

            C29012a() {
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(24902);
            C13264n c13264n = (C13264n) obj;
            if (c13264n == null) {
                c13264n = new C13264n();
            }
            c13264n.mo8995d(cursor);
            AppMethodBeat.m2505o(24902);
            return c13264n;
        }

        public C29011a(Context context) {
            super(context, new C13264n());
            AppMethodBeat.m2504i(24898);
            this.mInflater = LayoutInflater.from(context);
            AppMethodBeat.m2505o(24898);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C29012a c29012a;
            CharSequence charSequence;
            AppMethodBeat.m2504i(24899);
            if (view == null) {
                view = this.mInflater.inflate(2130970660, viewGroup, false);
                c29012a = new C29012a();
                c29012a.qwz = (MMImageView) view.findViewById(2131827531);
                c29012a.iDT = (TextView) view.findViewById(2131827532);
                c29012a.nSC = (TextView) view.findViewById(2131827533);
                view.setTag(c29012a);
            } else {
                c29012a = (C29012a) view.getTag();
            }
            C13264n c13264n = (C13264n) getItem(i);
            C43527e.m77787a(c29012a.qwz, c13264n.field_iconurl, 0, true);
            c29012a.iDT.setText(c13264n.field_title);
            TextView textView = c29012a.nSC;
            AppCompatActivity appCompatActivity = ShakeTvHistoryListUI.this.mController.ylL;
            long j = c13264n.field_createtime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                charSequence = "";
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis <= 0 || timeInMillis > 86400000) {
                        charSequence = C14835h.formatTime(appCompatActivity.getString(C25738R.string.bxe), j / 1000);
                    } else {
                        charSequence = appCompatActivity.getString(C25738R.string.byb);
                    }
                } else {
                    charSequence = C14835h.formatTime(appCompatActivity.getString(C25738R.string.bxq), j / 1000);
                }
            }
            textView.setText(charSequence);
            AppMethodBeat.m2505o(24899);
            return view;
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(24900);
            setCursor(C28987m.cjU().cky());
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(24900);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(24901);
            mo6869KC();
            AppMethodBeat.m2505o(24901);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$2 */
    class C397102 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$2$1 */
        class C132941 implements OnClickListener {
            C132941() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(24893);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(2);
                C46199o cjU = C28987m.cjU();
                ArrayList<C13264n> arrayList = new ArrayList();
                Cursor cky = cjU.cky();
                if (cky != null) {
                    while (cky.moveToNext()) {
                        C13264n c13264n = new C13264n();
                        c13264n.mo8995d(cky);
                        arrayList.add(c13264n);
                    }
                    cky.close();
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (C13264n c13264n2 : arrayList) {
                    stringBuilder.append(c13264n2.field_username);
                    stringBuilder.append("|");
                }
                objArr[1] = stringBuilder.toString();
                c7060h.mo8381e(12662, objArr);
                C28987m.cjU().bSd.delete("shaketvhistory", null, null);
                C9638aw.m17182Rg().mo14541a(new C7087c(2, null), 0);
                ShakeTvHistoryListUI.this.qwv.mo6869KC();
                ShakeTvHistoryListUI.this.enableOptionMenu(false);
                AppMethodBeat.m2505o(24893);
            }
        }

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$2$2 */
        class C132952 implements OnClickListener {
            C132952() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C397102() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24894);
            C30379h.m48453a(ShakeTvHistoryListUI.this.mController.ylL, true, ShakeTvHistoryListUI.this.getString(C25738R.string.egj), "", ShakeTvHistoryListUI.this.getString(C25738R.string.dx2), ShakeTvHistoryListUI.this.getString(C25738R.string.f9076or), new C132941(), new C132952());
            AppMethodBeat.m2505o(24894);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI$1 */
    class C462001 implements OnMenuItemClickListener {
        C462001() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24892);
            ShakeTvHistoryListUI.this.aqX();
            ShakeTvHistoryListUI.this.finish();
            AppMethodBeat.m2505o(24892);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShakeTvHistoryListUI() {
        AppMethodBeat.m2504i(24903);
        AppMethodBeat.m2505o(24903);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24904);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(24904);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24905);
        this.qwv.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(24905);
    }

    public final void initView() {
        AppMethodBeat.m2504i(24906);
        setMMTitle((int) C25738R.string.egk);
        setBackBtn(new C462001());
        addTextOptionMenu(0, getString(C25738R.string.f9078ou), new C397102());
        this.qww = (ListView) findViewById(2131827534);
        this.qwv = new C29011a(this);
        this.qww.setAdapter(this.qwv);
        this.qww.setOnItemClickListener(new C218423());
        final C46696j c46696j = new C46696j(this);
        this.qww.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(24896);
                if (i < ShakeTvHistoryListUI.this.qww.getHeaderViewsCount()) {
                    AppMethodBeat.m2505o(24896);
                } else {
                    c46696j.mo75004a(view, i, j, ShakeTvHistoryListUI.this.mController.ylL, ShakeTvHistoryListUI.this.jKa);
                    AppMethodBeat.m2505o(24896);
                }
                return true;
            }
        });
        AppMethodBeat.m2505o(24906);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(24907);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.username = ((C13264n) this.qwv.getItem(adapterContextMenuInfo.position)).field_username;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, C25738R.string.f9088p4);
        AppMethodBeat.m2505o(24907);
    }

    public final int getLayoutId() {
        return 2130970661;
    }
}
