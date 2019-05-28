package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;

public class IPCallUserProfileUI extends MMActivity {
    private String cMQ;
    private String cOz;
    private ImageView eks;
    private boolean nBq = false;
    private TextView nFZ;
    private TextView nGa;
    private LinearLayout nGb;
    private LinearLayout nGc;
    private TextView nGd;
    private TextView nGe;
    private TextView nGf;
    private TextView nGg;
    private TextView nGh;
    private Button nGi;
    private String nGj;
    private String nGk;
    private Bitmap nGl;
    private boolean nGm;
    private Cursor nGn = null;
    private boolean nGo = false;
    private e nGp = new e();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallUserProfileUI() {
        AppMethodBeat.i(22384);
        AppMethodBeat.o(22384);
    }

    static /* synthetic */ String Pl(String str) {
        AppMethodBeat.i(22398);
        String Pk = Pk(str);
        AppMethodBeat.o(22398);
        return Pk;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22385);
        super.onCreate(bundle);
        h.pYm.e(12061, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22371);
                IPCallUserProfileUI.this.finish();
                AppMethodBeat.o(22371);
                return true;
            }
        });
        setMMTitle((int) R.string.che);
        this.eks = (ImageView) findViewById(R.id.qk);
        this.nFZ = (TextView) findViewById(R.id.cl8);
        this.nGa = (TextView) findViewById(R.id.cl9);
        this.nGb = (LinearLayout) findViewById(R.id.clb);
        this.nGd = (TextView) findViewById(R.id.cle);
        this.nGf = (TextView) findViewById(R.id.cld);
        this.nGe = (TextView) findViewById(R.id.clc);
        this.nGc = (LinearLayout) findViewById(R.id.cla);
        this.nGg = (TextView) findViewById(R.id.cl_);
        this.nGh = (TextView) findViewById(R.id.clg);
        this.nGi = (Button) findViewById(R.id.clf);
        this.cOz = getIntent().getStringExtra("IPCallProfileUI_contactid");
        this.nGj = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
        this.nGk = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
        this.cMQ = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
        this.nGo = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
        if (!bo.isNullOrNil(this.cOz)) {
            this.nGl = a.aH(this, this.cOz);
            if (this.nGl != null) {
                this.eks.setImageBitmap(this.nGl);
            }
        }
        if (this.nGl == null && !bo.isNullOrNil(this.nGk)) {
            this.nGl = b.a(this.nGk, false, -1);
            if (this.nGl != null) {
                this.eks.setImageBitmap(this.nGl);
            }
        }
        if (!bo.isNullOrNil(this.nGj)) {
            this.nFZ.setText(this.nGj);
        } else if (!bo.isNullOrNil(this.cMQ)) {
            this.nFZ.setText(a.Pw(this.cMQ));
        }
        if (bo.isNullOrNil(this.nGk) || this.nGk.endsWith("@stranger")) {
            this.nGa.setVisibility(8);
        } else {
            this.nGa.setText(j.b((Context) this, getString(R.string.chf, new Object[]{s.mJ(this.nGk)})));
        }
        if (!bo.isNullOrNil(this.cOz)) {
            if (com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS")) {
                this.nGn = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{this.cOz}, null);
                this.nBq = this.nGn.getCount() <= 1;
            } else {
                ab.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
                AppMethodBeat.o(22385);
                return;
            }
        }
        bIx();
        this.nGf.setVisibility(8);
        this.nGe.setVisibility(8);
        this.nGd.setVisibility(8);
        this.nGi.setVisibility(8);
        this.nGh.setVisibility(8);
        if (!bo.isNullOrNil(this.nGk) && !bo.isNullOrNil(this.nGj)) {
            aw.ZK();
            ad aoO = c.XM().aoO(this.nGk);
            if (!(aoO == null || com.tencent.mm.n.a.jh(aoO.field_type))) {
                this.nGi.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(22380);
                        h.pYm.e(12766, Integer.valueOf(3));
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(IPCallUserProfileUI.this, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                            public final void a(boolean z, boolean z2, String str, String str2) {
                                AppMethodBeat.i(22378);
                                ab.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                                if (z) {
                                    IPCallUserProfileUI.this.nGi.setVisibility(8);
                                    IPCallUserProfileUI.this.nGh.setVisibility(8);
                                    IPCallUserProfileUI.b(IPCallUserProfileUI.this, str);
                                }
                                AppMethodBeat.o(22378);
                            }
                        });
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(86));
                        aVar.vjI = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                            public final boolean vQ(String str) {
                                AppMethodBeat.i(22379);
                                Intent intent = new Intent();
                                intent.putExtra("Contact_User", IPCallUserProfileUI.this.nGk);
                                intent.putExtra("Contact_Scene", 13);
                                intent.putExtra(com.tencent.mm.ui.e.b.yfT, str);
                                d.b(IPCallUserProfileUI.this, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent);
                                AppMethodBeat.o(22379);
                                return true;
                            }
                        };
                        aVar.b(IPCallUserProfileUI.this.nGk, linkedList, true);
                        AppMethodBeat.o(22380);
                    }
                });
                this.nGi.setText(R.string.ch8);
                this.nGi.setVisibility(0);
            }
        } else if (!bo.isNullOrNil(this.cOz) && !bo.isNullOrNil(this.nGj)) {
            bIw();
            this.nGi.setText(R.string.chc);
        } else if (!bo.isNullOrNil(this.cMQ)) {
            this.nGe.setVisibility(0);
            this.nGf.setVisibility(0);
            Context context = ah.getContext();
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/contact");
            intent.putExtra("phone", "10086");
            if (bo.k(context, intent)) {
                this.nGd.setVisibility(0);
            }
            this.nGd.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(22382);
                    try {
                        h.pYm.e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                        Intent intent = new Intent("android.intent.action.INSERT");
                        intent.setType("vnd.android.cursor.dir/contact");
                        intent.putExtra("phone", IPCallUserProfileUI.this.cMQ);
                        IPCallUserProfileUI.this.startActivity(intent);
                        AppMethodBeat.o(22382);
                    } catch (Exception e) {
                        ab.e("MicroMsg.IPCallUserProfileUI", e.getMessage());
                        AppMethodBeat.o(22382);
                    }
                }
            });
            this.nGe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(22383);
                    IPCallUserProfileUI.a(IPCallUserProfileUI.this, IPCallUserProfileUI.this.cMQ);
                    AppMethodBeat.o(22383);
                }
            });
            this.nGf.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(22372);
                    h.pYm.e(12766, Integer.valueOf(4));
                    com.tencent.mm.plugin.ipcall.b.c.PB(IPCallUserProfileUI.this.cMQ);
                    Toast.makeText(IPCallUserProfileUI.this, R.string.ch7, 0).show();
                    AppMethodBeat.o(22372);
                }
            });
            bIw();
            this.nGi.setText(R.string.chc);
        }
        bIv();
        AppMethodBeat.o(22385);
    }

    public final int getLayoutId() {
        return R.layout.a8q;
    }

    private void bIv() {
        int i = 0;
        AppMethodBeat.i(22386);
        ArrayList arrayList = new ArrayList();
        if (this.nGn == null || this.nGn.getCount() <= 0) {
            this.nGb.setVisibility(8);
            AppMethodBeat.o(22386);
            return;
        }
        try {
            if (this.nGn.moveToFirst()) {
                while (!this.nGn.isAfterLast()) {
                    i++;
                    String string = this.nGn.getString(this.nGn.getColumnIndex("data1"));
                    int i2 = this.nGn.getInt(this.nGn.getColumnIndex("data2"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                        if (i == this.nGn.getCount()) {
                            o(string, i2, false);
                        } else {
                            o(string, i2, true);
                        }
                    }
                    this.nGn.moveToNext();
                }
            }
            this.nGn.close();
            AppMethodBeat.o(22386);
        } catch (Exception e) {
            ab.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", e.getMessage());
            this.nGn.close();
            AppMethodBeat.o(22386);
        } catch (Throwable th) {
            this.nGn.close();
            AppMethodBeat.o(22386);
            throw th;
        }
    }

    private void o(final String str, int i, boolean z) {
        AppMethodBeat.i(22387);
        View inflate = LayoutInflater.from(this).inflate(R.layout.als, this.nGb, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.dqg);
        if (z) {
            linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.a_q));
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.dqh);
        final TextView textView2 = (TextView) inflate.findViewById(R.id.ckk);
        textView2.setText(a.Pw(com.tencent.mm.plugin.ipcall.b.c.PA(str)));
        textView.setText(a.xx(i));
        inflate.setClickable(true);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22374);
                IPCallUserProfileUI.a(IPCallUserProfileUI.this, str);
                AppMethodBeat.o(22374);
            }
        });
        inflate.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(22375);
                IPCallUserProfileUI.a(IPCallUserProfileUI.this, textView2);
                AppMethodBeat.o(22375);
                return true;
            }
        });
        this.nGb.addView(inflate);
        AppMethodBeat.o(22387);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String Pk(String str) {
        Exception e;
        AppMethodBeat.i(22388);
        String str2 = "";
        if (com.tencent.mm.pluginsdk.permission.b.o(ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                AppMethodBeat.o(22388);
                return null;
            }
            String str3;
            try {
                if (query.moveToFirst()) {
                    str3 = str2;
                    while (!query.isAfterLast()) {
                        try {
                            str3 = str3 + query.getString(query.getColumnIndex("data1")) + ",";
                            query.moveToNext();
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.e("MicroMsg.IPCallUserProfileUI", "extractAddressItemFromCursor, error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                                query.close();
                                if (str3.lastIndexOf(",") >= 0) {
                                }
                                AppMethodBeat.o(22388);
                                return str3;
                            } catch (Throwable th) {
                                query.close();
                                AppMethodBeat.o(22388);
                            }
                        }
                    }
                } else {
                    str3 = str2;
                }
                query.close();
            } catch (Exception e3) {
                e = e3;
                str3 = str2;
            }
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            AppMethodBeat.o(22388);
            return str3;
        }
        ab.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
        AppMethodBeat.o(22388);
        return null;
    }

    private void bIw() {
        AppMethodBeat.i(22389);
        this.nGi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22381);
                IPCallUserProfileUI.this.nGp.start();
                IPCallUserProfileUI.this.nGp.nyP = 1;
                IPCallUserProfileUI.this.nGp.nyQ = 5;
                IPCallUserProfileUI.this.nGp.finish();
                h.pYm.e(12766, Integer.valueOf(3));
                Intent intent;
                if (bo.isNullOrNil(IPCallUserProfileUI.this.cOz)) {
                    if (!bo.isNullOrNil(IPCallUserProfileUI.this.cMQ)) {
                        intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.this.cMQ));
                        intent.putExtra("sms_body", IPCallUserProfileUI.this.getString(R.string.cgw, new Object[]{r.Zd().Oi()}));
                        IPCallUserProfileUI.this.startActivity(intent);
                    }
                    AppMethodBeat.o(22381);
                    return;
                }
                intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.Pl(IPCallUserProfileUI.this.cOz)));
                intent.putExtra("sms_body", IPCallUserProfileUI.this.getString(R.string.cgw, new Object[]{r.Zd().Oi()}));
                IPCallUserProfileUI.this.startActivity(intent);
                AppMethodBeat.o(22381);
            }
        });
        AppMethodBeat.o(22389);
    }

    private void bIx() {
        Cursor OU;
        AppMethodBeat.i(22390);
        if (!this.nGo) {
            this.nGc.setVisibility(8);
            this.nGg.setVisibility(8);
        }
        if (bo.isNullOrNil(this.cOz)) {
            OU = i.bHx().OU(this.cMQ);
        } else {
            OU = m.OW(this.cOz);
        }
        if (OU == null || OU.getCount() <= 0) {
            this.nGc.setVisibility(8);
            this.nGg.setVisibility(8);
            AppMethodBeat.o(22390);
            return;
        }
        try {
            if (OU.moveToFirst()) {
                int i = 0;
                while (!OU.isAfterLast()) {
                    boolean z;
                    k kVar = new k();
                    kVar.d(OU);
                    i++;
                    if (i >= 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(kVar, z, OU.getCount());
                    if (z) {
                        break;
                    }
                    OU.moveToNext();
                }
                if (i <= 0) {
                    this.nGc.setVisibility(8);
                } else if (OU.getCount() >= 4) {
                    bIy();
                }
            }
            OU.close();
            AppMethodBeat.o(22390);
        } catch (Exception e) {
            ab.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", e.getMessage());
            OU.close();
            AppMethodBeat.o(22390);
        } catch (Throwable th) {
            OU.close();
            AppMethodBeat.o(22390);
            throw th;
        }
    }

    private void a(k kVar, boolean z, int i) {
        AppMethodBeat.i(22391);
        View inflate = LayoutInflater.from(this).inflate(R.layout.alu, this.nGc, false);
        TextView textView = (TextView) inflate.findViewById(R.id.cm9);
        TextView textView2 = (TextView) inflate.findViewById(R.id.cma);
        ((TextView) inflate.findViewById(R.id.cm_)).setText(a.Pw(kVar.field_phonenumber));
        if (kVar.field_duration > 0) {
            textView2.setText(com.tencent.mm.plugin.ipcall.b.c.jc(kVar.field_duration));
        } else {
            textView2.setText(com.tencent.mm.plugin.ipcall.b.c.xy(kVar.field_status));
        }
        textView.setText(com.tencent.mm.plugin.ipcall.b.c.iY(kVar.field_calltime));
        if (z) {
            inflate.setBackgroundDrawable(getResources().getDrawable(R.drawable.x_));
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cb);
            inflate.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        if (1 == i) {
            LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
            layoutParams.height = com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.a76);
            inflate.setLayoutParams(layoutParams);
        }
        this.nGc.addView(inflate);
        AppMethodBeat.o(22391);
    }

    private void bIy() {
        AppMethodBeat.i(22392);
        View inflate = LayoutInflater.from(this).inflate(R.layout.alv, this.nGc, false);
        this.nGc.addView(inflate);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22373);
                Intent intent = new Intent(IPCallUserProfileUI.this, IPCallAllRecordUI.class);
                if (!bo.isNullOrNil(IPCallUserProfileUI.this.cOz)) {
                    intent.putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.this.cOz);
                } else if (!bo.isNullOrNil(IPCallUserProfileUI.this.cMQ)) {
                    intent.putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.this.cMQ);
                }
                intent.putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.this.nBq);
                IPCallUserProfileUI.this.startActivity(intent);
                AppMethodBeat.o(22373);
            }
        });
        AppMethodBeat.o(22392);
    }

    public void onResume() {
        AppMethodBeat.i(22393);
        super.onResume();
        if (this.nGm) {
            this.nGm = false;
            this.nGc.removeAllViews();
            bIx();
        }
        AppMethodBeat.o(22393);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22394);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(22394);
    }

    static /* synthetic */ void b(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        AppMethodBeat.i(22397);
        if (!(bo.isNullOrNil(iPCallUserProfileUI.cOz) || bo.isNullOrNil(str) || str.endsWith("@stranger"))) {
            com.tencent.mm.plugin.ipcall.a.g.c OQ = i.bHw().OQ(iPCallUserProfileUI.cOz);
            if (OQ.xDa > 0) {
                OQ.field_wechatUsername = str;
                i.bHw().a(OQ.xDa, (com.tencent.mm.sdk.e.c) OQ);
            }
        }
        AppMethodBeat.o(22397);
    }
}
