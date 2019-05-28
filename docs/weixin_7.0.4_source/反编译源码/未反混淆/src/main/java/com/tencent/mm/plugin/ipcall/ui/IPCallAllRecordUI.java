package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p;

public class IPCallAllRecordUI extends MMActivity {
    private String cMQ;
    private String cOz;
    private ListView nBp;
    private boolean nBq = false;

    class a extends p<k> {

        class a {
            TextView gnh;
            TextView nBs;
            TextView nBt;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(22069);
            k kVar = (k) obj;
            if (kVar == null) {
                kVar = new k();
            }
            kVar.d(cursor);
            AppMethodBeat.o(22069);
            return kVar;
        }

        public a(Context context) {
            super(context, null);
            AppMethodBeat.i(22065);
            pN(true);
            AppMethodBeat.o(22065);
        }

        public final void KC() {
            Cursor cursor = null;
            AppMethodBeat.i(22066);
            if (!bo.isNullOrNil(IPCallAllRecordUI.this.cOz)) {
                String a = IPCallAllRecordUI.this.cOz;
                if (!bo.isNullOrNil(a)) {
                    c OQ = i.bHw().OQ(a);
                    if (!(OQ == null || OQ.xDa == -1)) {
                        cursor = i.bHx().iX(OQ.xDa);
                    }
                }
            } else if (!bo.isNullOrNil(IPCallAllRecordUI.this.cMQ)) {
                cursor = i.bHx().OV(IPCallAllRecordUI.this.cMQ);
            }
            setCursor(cursor);
            AppMethodBeat.o(22066);
        }

        public final void KD() {
            AppMethodBeat.i(22067);
            bIf();
            KC();
            AppMethodBeat.o(22067);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(22068);
            if (view == null) {
                view = IPCallAllRecordUI.this.getLayoutInflater().inflate(R.layout.a8u, viewGroup, false);
                aVar = new a();
                aVar.nBs = (TextView) view.findViewById(R.id.cm9);
                aVar.nBt = (TextView) view.findViewById(R.id.cm_);
                aVar.gnh = (TextView) view.findViewById(R.id.cma);
                view.setTag(aVar);
            }
            k kVar = (k) getItem(i);
            aVar = (a) view.getTag();
            aVar.nBt.setText(com.tencent.mm.plugin.ipcall.b.a.Pw(kVar.field_phonenumber));
            if (kVar.field_duration > 0) {
                aVar.gnh.setText(com.tencent.mm.plugin.ipcall.b.c.jc(kVar.field_duration));
            } else {
                aVar.gnh.setText(com.tencent.mm.plugin.ipcall.b.c.xy(kVar.field_status));
            }
            aVar.nBs.setText(com.tencent.mm.plugin.ipcall.b.c.iY(kVar.field_calltime));
            AppMethodBeat.o(22068);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22070);
        super.onCreate(bundle);
        this.cMQ = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.cOz = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.nBq = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        setMMTitle((int) R.string.chp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22064);
                IPCallAllRecordUI.this.finish();
                AppMethodBeat.o(22064);
                return true;
            }
        });
        this.nBp = (ListView) findViewById(R.id.cjh);
        this.nBp.setAdapter(new a(this));
        AppMethodBeat.o(22070);
    }

    public final int getLayoutId() {
        return R.layout.a8h;
    }
}
