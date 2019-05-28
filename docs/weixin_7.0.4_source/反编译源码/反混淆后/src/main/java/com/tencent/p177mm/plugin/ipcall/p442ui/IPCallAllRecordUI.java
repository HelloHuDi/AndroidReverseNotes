package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28332k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI */
public class IPCallAllRecordUI extends MMActivity {
    private String cMQ;
    private String cOz;
    private ListView nBp;
    private boolean nBq = false;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI$a */
    class C3308a extends C46692p<C28332k> {

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI$a$a */
        class C3309a {
            TextView gnh;
            TextView nBs;
            TextView nBt;

            C3309a() {
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(22069);
            C28332k c28332k = (C28332k) obj;
            if (c28332k == null) {
                c28332k = new C28332k();
            }
            c28332k.mo8995d(cursor);
            AppMethodBeat.m2505o(22069);
            return c28332k;
        }

        public C3308a(Context context) {
            super(context, null);
            AppMethodBeat.m2504i(22065);
            mo74996pN(true);
            AppMethodBeat.m2505o(22065);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            Cursor cursor = null;
            AppMethodBeat.m2504i(22066);
            if (!C5046bo.isNullOrNil(IPCallAllRecordUI.this.cOz)) {
                String a = IPCallAllRecordUI.this.cOz;
                if (!C5046bo.isNullOrNil(a)) {
                    C21083c OQ = C21088i.bHw().mo36404OQ(a);
                    if (!(OQ == null || OQ.xDa == -1)) {
                        cursor = C21088i.bHx().mo46246iX(OQ.xDa);
                    }
                }
            } else if (!C5046bo.isNullOrNil(IPCallAllRecordUI.this.cMQ)) {
                cursor = C21088i.bHx().mo46244OV(IPCallAllRecordUI.this.cMQ);
            }
            setCursor(cursor);
            AppMethodBeat.m2505o(22066);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(22067);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(22067);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C3309a c3309a;
            AppMethodBeat.m2504i(22068);
            if (view == null) {
                view = IPCallAllRecordUI.this.getLayoutInflater().inflate(2130969895, viewGroup, false);
                c3309a = new C3309a();
                c3309a.nBs = (TextView) view.findViewById(2131825141);
                c3309a.nBt = (TextView) view.findViewById(2131825142);
                c3309a.gnh = (TextView) view.findViewById(2131825143);
                view.setTag(c3309a);
            }
            C28332k c28332k = (C28332k) getItem(i);
            c3309a = (C3309a) view.getTag();
            c3309a.nBt.setText(C46041a.m85637Pw(c28332k.field_phonenumber));
            if (c28332k.field_duration > 0) {
                c3309a.gnh.setText(C34382c.m56388jc(c28332k.field_duration));
            } else {
                c3309a.gnh.setText(C34382c.m56389xy(c28332k.field_status));
            }
            c3309a.nBs.setText(C34382c.m56384iY(c28332k.field_calltime));
            AppMethodBeat.m2505o(22068);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI$1 */
    class C343881 implements OnMenuItemClickListener {
        C343881() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22064);
            IPCallAllRecordUI.this.finish();
            AppMethodBeat.m2505o(22064);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22070);
        super.onCreate(bundle);
        this.cMQ = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.cOz = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.nBq = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        setMMTitle((int) C25738R.string.chp);
        setBackBtn(new C343881());
        this.nBp = (ListView) findViewById(2131825039);
        this.nBp.setAdapter(new C3308a(this));
        AppMethodBeat.m2505o(22070);
    }

    public final int getLayoutId() {
        return 2130969882;
    }
}
