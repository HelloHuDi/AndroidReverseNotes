package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;

public class ShakeSayHiListUI extends MMActivity {
    private ListView gtT;
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(24874);
            com.tencent.mm.bi.d.akR().QT(String.valueOf(ShakeSayHiListUI.this.jvz));
            ShakeSayHiListUI.this.qws.a(null, null);
            AppMethodBeat.o(24874);
        }
    };
    private long jvz;
    private int limit = 0;
    private int oQK = 0;
    private int oQL = 0;
    private bu qui = null;
    private int qwr = 0;
    private b qws;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeSayHiListUI() {
        AppMethodBeat.i(24884);
        AppMethodBeat.o(24884);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24885);
        super.onCreate(bundle);
        this.qwr = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.qwr == 1) {
            this.qui = com.tencent.mm.bi.d.akR();
            setMMTitle((int) R.string.dx7);
        } else {
            setMMTitle((int) R.string.dx5);
        }
        this.oQL = this.qui.baS();
        this.limit = this.oQL == 0 ? 8 : this.oQL;
        this.oQK = this.qui.getCount();
        bu buVar = this.qui;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (buVar.bSd.update(buVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            buVar.doNotify();
        }
        initView();
        AppMethodBeat.o(24885);
    }

    public void onResume() {
        AppMethodBeat.i(24886);
        super.onResume();
        if (this.oQK != this.qui.getCount()) {
            this.oQK = this.qui.getCount();
            if (this.oQK == 0) {
                TextView textView = (TextView) findViewById(R.id.a74);
                textView.setText(R.string.dx8);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.qws.KC();
        }
        this.qws.notifyDataSetChanged();
        AppMethodBeat.o(24886);
    }

    public void onDestroy() {
        AppMethodBeat.i(24887);
        this.qws.bIf();
        super.onDestroy();
        AppMethodBeat.o(24887);
    }

    public void onPause() {
        AppMethodBeat.i(24888);
        super.onPause();
        if (this.qws.jJR != null) {
            this.qws.jJR.bIp();
        }
        AppMethodBeat.o(24888);
    }

    public final int getLayoutId() {
        return R.layout.a9t;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(24889);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(24889);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.i(24890);
        final View inflate = getLayoutInflater().inflate(R.layout.ap5, null);
        this.gtT = (ListView) findViewById(R.id.cp9);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24873);
                ShakeSayHiListUI.this.limit = ShakeSayHiListUI.this.limit + 8;
                ab.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.this.limit);
                ShakeSayHiListUI.this.qws.CA(ShakeSayHiListUI.this.limit);
                if (ShakeSayHiListUI.this.oQK <= ShakeSayHiListUI.this.limit) {
                    ShakeSayHiListUI.this.gtT.removeFooterView(inflate);
                    ab.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.this.limit);
                }
                AppMethodBeat.o(24873);
            }
        });
        addTextOptionMenu(0, getString(R.string.ou), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24876);
                h.a(ShakeSayHiListUI.this.mController.ylL, true, ShakeSayHiListUI.this.getString(R.string.dx3), "", ShakeSayHiListUI.this.getString(R.string.dx2), ShakeSayHiListUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24875);
                        ShakeSayHiListUI.this.qui.axQ();
                        ShakeSayHiListUI.this.qws.KC();
                        TextView textView = (TextView) ShakeSayHiListUI.this.findViewById(R.id.a74);
                        textView.setText(R.string.dx8);
                        textView.setVisibility(0);
                        ShakeSayHiListUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(24875);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(24876);
                return true;
            }
        });
        if (this.oQK == 0) {
            TextView textView = (TextView) findViewById(R.id.a74);
            textView.setText(R.string.dx8);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oQK > 0 && this.limit < this.oQK) {
            this.gtT.addFooterView(inflate);
        }
        this.qws = new b(this, this.qui, this.limit);
        this.qws.setGetViewPositionCallback(new c() {
            public final int cZ(View view) {
                AppMethodBeat.i(24877);
                int positionForView = ShakeSayHiListUI.this.gtT.getPositionForView(view);
                AppMethodBeat.o(24877);
                return positionForView;
            }
        });
        this.qws.setPerformItemClickListener(new g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(24878);
                ShakeSayHiListUI.this.gtT.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(24878);
            }
        });
        this.qws.a(new f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(24879);
                if (obj == null) {
                    ab.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    AppMethodBeat.o(24879);
                    return;
                }
                com.tencent.mm.bi.d.akR().QT(obj.toString());
                ShakeSayHiListUI.this.qws.a(null, null);
                AppMethodBeat.o(24879);
            }
        });
        this.gtT.setAdapter(this.qws);
        this.gtT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24880);
                bt btVar = (bt) ShakeSayHiListUI.this.qws.getItem(i);
                if (btVar == null || btVar.field_content == null) {
                    AppMethodBeat.o(24880);
                    return;
                }
                bi.d apF = bi.d.apF(btVar.field_content);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", apF.svN);
                intent.putExtra("Contact_Encryptusername", apF.xZx);
                intent.putExtra("Contact_Alias", apF.dFl);
                intent.putExtra("Contact_Nick", apF.nickname);
                intent.putExtra("Contact_QuanPin", apF.gwG);
                intent.putExtra("Contact_PyInitial", apF.gwF);
                intent.putExtra("Contact_Sex", apF.dtS);
                intent.putExtra("Contact_Signature", apF.signature);
                intent.putExtra("Contact_Scene", apF.scene);
                intent.putExtra("Contact_FMessageCard", true);
                intent.putExtra("Contact_City", apF.getCity());
                intent.putExtra("Contact_Province", apF.getProvince());
                intent.putExtra("Contact_Content", bo.isNullOrNil(btVar.field_sayhicontent) ? ShakeSayHiListUI.this.getString(R.string.al3) : btVar.field_sayhicontent);
                intent.putExtra("Contact_verify_Scene", apF.scene);
                intent.putExtra("Contact_Uin", apF.pnz);
                intent.putExtra("Contact_QQNick", apF.gwH);
                intent.putExtra("Contact_Mobile_MD5", apF.xZi);
                intent.putExtra("User_From_Fmessage", true);
                intent.putExtra("Contact_from_msgType", 37);
                intent.putExtra("Verify_ticket", apF.mGZ);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("Contact_Source_FMessage", apF.scene);
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(apF.svN);
                if (!(aoO == null || ((int) aoO.ewQ) < 0 || a.jh(aoO.field_type))) {
                    int i2 = apF.cAd;
                    if (i2 == 0 || i2 == 2 || i2 == 5) {
                        intent.putExtra("User_Verify", true);
                    }
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Sns_from_Scene", 18);
                }
                com.tencent.mm.plugin.shake.a.gkE.c(intent, ShakeSayHiListUI.this);
                AppMethodBeat.o(24880);
            }
        });
        final j jVar = new j(this);
        this.gtT.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24881);
                if (i < ShakeSayHiListUI.this.gtT.getHeaderViewsCount()) {
                    ab.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                    AppMethodBeat.o(24881);
                } else {
                    jVar.a(view, i, j, ShakeSayHiListUI.this, ShakeSayHiListUI.this.jKa);
                    AppMethodBeat.o(24881);
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24882);
                ShakeSayHiListUI.this.aqX();
                ShakeSayHiListUI.this.finish();
                AppMethodBeat.o(24882);
                return true;
            }
        });
        AnonymousClass10 anonymousClass10 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24883);
                BackwardSupportUtil.c.a(ShakeSayHiListUI.this.gtT);
                AppMethodBeat.o(24883);
            }
        };
        AppMethodBeat.o(24890);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(24891);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jvz = ((bt) this.qws.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.p4);
        AppMethodBeat.o(24891);
    }
}
