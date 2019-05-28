package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.g.a.mx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.j;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public class QQFriendUI extends MMActivity implements f {
    private int Zb;
    private ProgressDialog ehJ = null;
    private o elS;
    private ListView gtT;
    String gtX;
    private TextView gtY = null;
    d gxU;
    private boolean gxV = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108619);
        super.onCreate(bundle);
        g.Rg().a((int) ErrorCode.NEEDDOWNLOAD_4, (f) this);
        String stringExtra = getIntent().getStringExtra("qqgroup_name");
        this.Zb = getIntent().getIntExtra("qqgroup_id", -1);
        ap apVar = (ap) ((a) g.M(a.class)).getQQListStg();
        int i = this.Zb;
        ab.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
        apVar.fni.hY("qqlist", "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i)));
        if (l.mX(this.Zb)) {
            final m acVar = new ac(this.Zb);
            g.Rg().a(acVar, 0);
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(context, getString(R.string.df7), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(108613);
                    g.Rg().c(acVar);
                    AppMethodBeat.o(108613);
                }
            });
        }
        setMMTitle(stringExtra);
        initView();
        AppMethodBeat.o(108619);
    }

    public void onResume() {
        AppMethodBeat.i(108620);
        super.onResume();
        com.tencent.mm.ah.o.acd().d(this.gxU);
        this.gxU.notifyDataSetChanged();
        AppMethodBeat.o(108620);
    }

    public void onDestroy() {
        AppMethodBeat.i(108621);
        com.tencent.mm.model.a.f.oU("2");
        ((ap) ((a) g.M(a.class)).getQQListStg()).b(this.gxU);
        g.Rg().b((int) ErrorCode.NEEDDOWNLOAD_4, (f) this);
        this.gxU.bIf();
        com.tencent.mm.ah.o.acv().cancel();
        super.onDestroy();
        AppMethodBeat.o(108621);
    }

    public void onPause() {
        AppMethodBeat.i(108622);
        com.tencent.mm.ah.o.acd().e(this.gxU);
        super.onPause();
        AppMethodBeat.o(108622);
    }

    public final int getLayoutId() {
        return R.layout.alz;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(108623);
        ab.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(108623);
        return onKeyDown;
    }

    public final void initView() {
        byte b;
        AppMethodBeat.i(108624);
        this.gtT = (ListView) findViewById(R.id.dqq);
        this.gtY = (TextView) findViewById(R.id.dqr);
        this.gtY.setText(R.string.dff);
        this.elS = new o((byte) 0);
        this.elS.zHa = new b() {
            public final boolean vN(String str) {
                return false;
            }

            public final void vO(String str) {
                AppMethodBeat.i(108614);
                QQFriendUI.this.gtX = bo.vA(str);
                QQFriendUI.this.gxV = true;
                QQFriendUI qQFriendUI = QQFriendUI.this;
                if (qQFriendUI.gxU != null) {
                    qQFriendUI.gxU.vM(qQFriendUI.gtX);
                }
                AppMethodBeat.o(108614);
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
        a(this.elS);
        if (com.tencent.mm.model.a.g.aaK().oP("2") != null) {
            String str = com.tencent.mm.model.a.g.aaK().oP("2").value;
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                b = (byte) 0;
            } else if (str.equals("1")) {
                b = (byte) 1;
            } else {
                b = (byte) 1;
            }
            com.tencent.mm.model.a.f.oT("2");
        } else {
            b = (byte) 1;
        }
        if (b == (byte) 0) {
            this.gxU = new e(this, this.Zb);
        } else {
            this.gxU = new f(this, this.Zb);
        }
        this.gxU.a(new d.a() {
            public final void mT(int i) {
                AppMethodBeat.i(108615);
                if (QQFriendUI.this.gxV) {
                    if (i > 0) {
                        QQFriendUI.this.gtY.setVisibility(8);
                    } else {
                        QQFriendUI.this.gtY.setVisibility(0);
                    }
                }
                QQFriendUI.this.gxV = false;
                AppMethodBeat.o(108615);
            }
        });
        this.gtT.setAdapter(this.gxU);
        this.gtT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(108616);
                if (i < QQFriendUI.this.gtT.getHeaderViewsCount()) {
                    AppMethodBeat.o(108616);
                    return;
                }
                ab.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", Integer.valueOf(i - QQFriendUI.this.gtT.getHeaderViewsCount()), Integer.valueOf(QQFriendUI.this.gtT.getHeaderViewsCount()));
                ao aoVar = (ao) QQFriendUI.this.gxU.getItem(r0);
                Intent intent;
                if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                    mx mxVar = new mx();
                    mxVar.cIO.opType = 0;
                    mxVar.cIO.cIQ = aoVar.gwC + "@qqim";
                    mxVar.cIO.cIR = aoVar.getDisplayName();
                    com.tencent.mm.sdk.b.a.xxA.m(mxVar);
                    if (mxVar.cIP.cvi) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", aoVar.gwC + "@qqim");
                        intent.putExtra("key_need_send_video", false);
                        com.tencent.mm.plugin.account.a.a.gkE.d(intent, QQFriendUI.this);
                    }
                    AppMethodBeat.o(108616);
                } else if (aoVar.gwD == 1 || aoVar.gwD == 2) {
                    j jVar;
                    ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(aoVar.getUsername());
                    if (aoO != null && aoO.dsf()) {
                        com.tencent.mm.plugin.report.service.h.pYm.X(10298, aoVar.getUsername() + ",12");
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", aoVar.getUsername());
                    intent2.putExtra("Contact_Nick", aoVar.Hs());
                    intent2.putExtra("Contact_Uin", aoVar.gwC);
                    intent2.putExtra("Contact_QQNick", aoVar.getDisplayName());
                    intent2.putExtra("Contact_Scene", 12);
                    intent2.putExtra("Contact_RemarkName", aoVar.aqr());
                    k kVar = (k) ((a) g.M(a.class)).getFrdExtStg();
                    Cursor a = kVar.fni.a("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bo.vA(String.valueOf(aoVar.getUsername())) + "\"", null, 2);
                    if (a == null) {
                        jVar = null;
                    } else {
                        jVar = null;
                        if (a.moveToFirst()) {
                            jVar = new j();
                            jVar.username = a.getString(0);
                            jVar.dtS = a.getInt(1);
                            jVar.dub = a.getInt(2);
                            jVar.duc = a.getString(3);
                            jVar.dud = a.getString(4);
                            jVar.signature = a.getString(5);
                        }
                        a.close();
                    }
                    if (jVar != null) {
                        intent2.putExtra("Contact_Sex", jVar.dtS);
                    }
                    intent2.putExtra("Contact_ShowUserName", false);
                    if (bo.isNullOrNil(aoVar.getUsername())) {
                        ab.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", aoVar.toString());
                        AppMethodBeat.o(108616);
                        return;
                    }
                    com.tencent.mm.plugin.account.a.a.gkE.c(intent2, QQFriendUI.this);
                    AppMethodBeat.o(108616);
                } else {
                    if (aoVar.gwD == 0) {
                        intent = new Intent(QQFriendUI.this, InviteFriendUI.class);
                        intent.putExtra("friend_type", 0);
                        intent.putExtra("friend_user_name", aoVar.getUsername());
                        intent.putExtra("friend_num", aoVar.gwC);
                        intent.putExtra("friend_nick", aoVar.getDisplayName());
                        intent.putExtra("friend_weixin_nick", aoVar.Hs());
                        intent.putExtra("friend_scene", 12);
                        QQFriendUI.this.startActivity(intent);
                    }
                    AppMethodBeat.o(108616);
                }
            }
        });
        ((ap) ((a) g.M(a.class)).getQQListStg()).a(this.gxU);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108617);
                QQFriendUI.this.aqX();
                QQFriendUI.this.finish();
                AppMethodBeat.o(108617);
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108618);
                c.a(QQFriendUI.this.gtT);
                AppMethodBeat.o(108618);
            }
        };
        AppMethodBeat.o(108624);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(108625);
        ab.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + configuration.orientation);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(108625);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(108626);
        ab.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((amw) ((ac) mVar).ehh.fsG.fsP).nbk != 1) {
            AppMethodBeat.o(108626);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            this.gxU.KC();
            AppMethodBeat.o(108626);
            return;
        }
        Toast.makeText(this, R.string.df6, 0).show();
        AppMethodBeat.o(108626);
    }
}
