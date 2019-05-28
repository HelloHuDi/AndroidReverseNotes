package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.o;
import java.util.List;

public class MobileFriendUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private TextView emptyTipTv = null;
    private ListView gtT;
    b gtU;
    private View gtV;
    private al gtW;
    String gtX;
    private TextView gtY = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void h(MobileFriendUI mobileFriendUI) {
        AppMethodBeat.i(13745);
        mobileFriendUI.getData();
        AppMethodBeat.o(13745);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13734);
        super.onCreate(bundle);
        setMMTitle((int) R.string.d0a);
        ((b) ((a) g.M(a.class)).getAddrUploadStg()).fni.hY("qqlist", "update addr_upload2 set reserved4=0");
        g.Rg().a(32, (f) this);
        g.Rg().a((int) e.CTRL_INDEX, (f) this);
        initView();
        ab.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts(android.Manifest.permission.READ_CONTACTS)[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null)));
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            aps();
            AppMethodBeat.o(13734);
            return;
        }
        AppMethodBeat.o(13734);
    }

    private void aps() {
        AppMethodBeat.i(13735);
        if (com.tencent.luggage.g.b.iW(26)) {
            ab.i("MicroMsg.MobileFriendUI", "onCreateAfterMPermissionGranted() checkContacts(android.Manifest.permission.WRITE_CONTACTS)[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)));
            if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)) {
                AppMethodBeat.o(13735);
                return;
            }
        }
        getData();
        AppMethodBeat.o(13735);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(13736);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(13736);
            return;
        }
        ab.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13719);
                            MobileFriendUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            MobileFriendUI.this.finish();
                            AppMethodBeat.o(13719);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13726);
                            MobileFriendUI.this.finish();
                            AppMethodBeat.o(13726);
                        }
                    });
                    break;
                }
                aps();
                AppMethodBeat.o(13736);
                return;
        }
        AppMethodBeat.o(13736);
    }

    private void getData() {
        AppMethodBeat.i(13737);
        if (!l.apR()) {
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(context, getString(R.string.d09), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(13727);
                    if (MobileFriendUI.this.gtW != null) {
                        g.Rg().c(MobileFriendUI.this.gtW);
                    }
                    AppMethodBeat.o(13727);
                }
            });
            if (this.gtU.getCount() == 0) {
                if (!(((a) g.M(a.class)).syncAddrBook(new com.tencent.mm.plugin.account.a.a.b() {
                    public final void cN(boolean z) {
                        AppMethodBeat.i(13728);
                        ab.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
                        if (z) {
                            System.currentTimeMillis();
                            l.apX();
                            g.Rg().a(new al(l.aqb(), l.aqa()), 0);
                            AppMethodBeat.o(13728);
                            return;
                        }
                        if (MobileFriendUI.this.ehJ != null) {
                            MobileFriendUI.this.ehJ.dismiss();
                            MobileFriendUI.this.ehJ = null;
                        }
                        AppMethodBeat.o(13728);
                    }
                }) || this.ehJ == null)) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                AppMethodBeat.o(13737);
                return;
            }
            List aqb = l.aqb();
            List aqa = l.aqa();
            if (aqb.size() == 0 && aqa.size() == 0) {
                g.Rg().a(new com.tencent.mm.plugin.account.friend.a.ab(), 0);
            } else {
                this.gtW = new al(l.aqb(), l.aqa());
                g.Rg().a(this.gtW, 0);
                AppMethodBeat.o(13737);
                return;
            }
        }
        AppMethodBeat.o(13737);
    }

    public void onResume() {
        AppMethodBeat.i(13738);
        super.onResume();
        this.gtU.notifyDataSetChanged();
        AppMethodBeat.o(13738);
    }

    public void onPause() {
        AppMethodBeat.i(13739);
        super.onPause();
        AppMethodBeat.o(13739);
    }

    public void onDestroy() {
        AppMethodBeat.i(13740);
        com.tencent.mm.model.a.f.oU("2");
        g.Rg().b(32, (f) this);
        g.Rg().b((int) e.CTRL_INDEX, (f) this);
        this.gtU.bIf();
        super.onDestroy();
        AppMethodBeat.o(13740);
    }

    public final int getLayoutId() {
        return R.layout.ah1;
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.i(13741);
        this.emptyTipTv = (TextView) findViewById(R.id.bt4);
        this.emptyTipTv.setText(R.string.d07);
        this.gtY = (TextView) findViewById(R.id.bt5);
        this.gtY.setText(R.string.d0p);
        this.gtV = findViewById(R.id.bss);
        this.gtT = (ListView) findViewById(R.id.bsq);
        o oVar = new o((byte) 0);
        oVar.zHa = new o.b() {
            public final boolean vN(String str) {
                return false;
            }

            public final void vO(String str) {
                AppMethodBeat.i(13729);
                MobileFriendUI.this.gtX = bo.vA(str);
                MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                if (mobileFriendUI.gtU != null) {
                    mobileFriendUI.gtU.vM(mobileFriendUI.gtX);
                }
                AppMethodBeat.o(13729);
            }

            public final void apo() {
            }

            public final void app() {
            }

            public final void apq() {
            }

            public final void apr() {
            }
        };
        a(oVar);
        if (com.tencent.mm.model.a.g.aaK().oP("2") != null) {
            String str = com.tencent.mm.model.a.g.aaK().oP("2").value;
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            com.tencent.mm.model.a.f.oT("2");
        } else {
            z = true;
        }
        ab.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", Boolean.valueOf(z));
        if (z) {
            this.gtU = new d(this, new p.a() {
                public final void apt() {
                    AppMethodBeat.i(13731);
                    MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                    MobileFriendUI.this.gtU.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                    AppMethodBeat.o(13731);
                }
            });
        } else {
            this.gtU = new c(this, new p.a() {
                public final void apt() {
                    AppMethodBeat.i(13730);
                    MobileFriendUI mobileFriendUI = MobileFriendUI.this;
                    MobileFriendUI.this.gtU.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                    AppMethodBeat.o(13730);
                }
            });
        }
        this.gtT.setAdapter(this.gtU);
        this.gtT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(13732);
                if (i < MobileFriendUI.this.gtT.getHeaderViewsCount()) {
                    AppMethodBeat.o(13732);
                    return;
                }
                com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) MobileFriendUI.this.gtU.getItem(i - MobileFriendUI.this.gtT.getHeaderViewsCount());
                if (aVar.status == 1 || aVar.status == 2) {
                    MobileFriendUI.this.b(aVar);
                }
                if (aVar.status == 0) {
                    Intent intent = new Intent(MobileFriendUI.this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 1);
                    intent.putExtra("friend_user_name", aVar.getUsername());
                    intent.putExtra("friend_num", aVar.apG());
                    intent.putExtra("friend_nick", aVar.apA());
                    intent.putExtra("friend_weixin_nick", aVar.apD());
                    intent.putExtra("friend_scene", 13);
                    MobileFriendUI.this.startActivity(intent);
                }
                AppMethodBeat.o(13732);
            }
        });
        this.gtU.a(new b.a() {
            public final void mT(int i) {
                AppMethodBeat.i(13733);
                if (i > 0) {
                    MobileFriendUI.this.gtY.setVisibility(8);
                    AppMethodBeat.o(13733);
                    return;
                }
                MobileFriendUI.this.gtY.setVisibility(0);
                AppMethodBeat.o(13733);
            }
        });
        if (!(l.apS() == l.a.SUCC || l.apS() == l.a.SUCC_UNLOAD)) {
            this.gtV = findViewById(R.id.bss);
            this.gtV.setVisibility(0);
            this.gtV.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(13720);
                    Intent intent = new Intent(MobileFriendUI.this.mController.ylL, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 6);
                    MMWizardActivity.J(MobileFriendUI.this, intent);
                    AppMethodBeat.o(13720);
                }
            });
            this.gtT.setVisibility(8);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13721);
                MobileFriendUI.this.aqX();
                MobileFriendUI.this.finish();
                AppMethodBeat.o(13721);
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13722);
                c.a(MobileFriendUI.this.gtT);
                AppMethodBeat.o(13722);
            }
        };
        if (!r.Zc() || l.apR()) {
            h.a((Context) this, (int) R.string.a64, (int) R.string.tz, (int) R.string.s6, (int) R.string.or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13723);
                    com.tencent.mm.plugin.report.service.h.pYm.e(11438, Integer.valueOf(6));
                    ab.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(6));
                    g.RP().Ry().set(12322, Boolean.TRUE);
                    ((a) g.M(a.class)).syncUploadMContactStatus(true, true);
                    MobileFriendUI.h(MobileFriendUI.this);
                    AppMethodBeat.o(13723);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13724);
                    g.RP().Ry().set(12322, Boolean.FALSE);
                    ((a) g.M(a.class)).syncUploadMContactStatus(false, true);
                    MobileFriendUI.this.finish();
                    AppMethodBeat.o(13724);
                }
            });
        }
        AppMethodBeat.o(13741);
    }

    public final void b(com.tencent.mm.plugin.account.friend.a.a aVar) {
        AppMethodBeat.i(13742);
        if (bo.isNullOrNil(aVar.getUsername())) {
            ab.e("MicroMsg.MobileFriendUI", "username is null");
            AppMethodBeat.o(13742);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", aVar.getUsername());
        intent.putExtra("Contact_Nick", aVar.apD());
        intent.putExtra("Contact_Mobile_MD5", aVar.Aq());
        intent.putExtra("Contact_Alias", aVar.guS);
        intent.putExtra("Contact_Sex", aVar.guN);
        intent.putExtra("Contact_Signature", aVar.guQ);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(aVar.guW, aVar.guO, aVar.guP));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        com.tencent.mm.plugin.account.a.a.gkE.c(intent, this);
        AppMethodBeat.o(13742);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(13743);
        ab.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() == 32 && this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!(i == 0 && i2 == 0)) {
            ab.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
        if (mVar.getType() == e.CTRL_INDEX) {
            g.Rg().a(new com.tencent.mm.plugin.account.friend.a.ab(), 0);
        }
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 32) {
                ((a) g.M(a.class)).updateAllContact();
            }
            this.gtU.a(null, null);
            AppMethodBeat.o(13743);
            return;
        }
        if (mVar.getType() == 32) {
            Toast.makeText(this, R.string.d08, 0).show();
        }
        AppMethodBeat.o(13743);
    }

    static /* synthetic */ void e(MobileFriendUI mobileFriendUI) {
        AppMethodBeat.i(13744);
        if (l.apS() != l.a.SUCC && l.apS() != l.a.SUCC_UNLOAD) {
            mobileFriendUI.gtV.setVisibility(0);
            mobileFriendUI.gtV.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(13725);
                    MMWizardActivity.J(MobileFriendUI.this, new Intent(MobileFriendUI.this, BindMContactIntroUI.class));
                    AppMethodBeat.o(13725);
                }
            });
            mobileFriendUI.gtT.setVisibility(8);
            mobileFriendUI.emptyTipTv.setVisibility(8);
            AppMethodBeat.o(13744);
        } else if (mobileFriendUI.gtU.getCount() <= 0) {
            mobileFriendUI.emptyTipTv.setVisibility(0);
            mobileFriendUI.gtT.setVisibility(8);
            mobileFriendUI.gtV.setVisibility(8);
            AppMethodBeat.o(13744);
        } else {
            mobileFriendUI.emptyTipTv.setVisibility(8);
            mobileFriendUI.gtT.setVisibility(0);
            mobileFriendUI.gtV.setVisibility(8);
            AppMethodBeat.o(13744);
        }
    }
}
