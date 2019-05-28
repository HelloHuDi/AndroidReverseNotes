package com.tencent.p177mm.plugin.account.friend.p273ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26203mx;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.account.friend.p272a.C26586k;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C45496ap;
import com.tencent.p177mm.plugin.account.friend.p272a.C6716ac;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.account.friend.p272a.C9879j;
import com.tencent.p177mm.plugin.account.friend.p273ui.C38040d.C18835a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.amw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.QQFriendUI */
public class QQFriendUI extends MMActivity implements C1202f {
    /* renamed from: Zb */
    private int f15025Zb;
    private ProgressDialog ehJ = null;
    private C5601o elS;
    private ListView gtT;
    String gtX;
    private TextView gtY = null;
    C38040d gxU;
    private boolean gxV = false;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.QQFriendUI$3 */
    class C246803 implements C18835a {
        C246803() {
        }

        /* renamed from: mT */
        public final void mo34111mT(int i) {
            AppMethodBeat.m2504i(108615);
            if (QQFriendUI.this.gxV) {
                if (i > 0) {
                    QQFriendUI.this.gtY.setVisibility(8);
                } else {
                    QQFriendUI.this.gtY.setVisibility(0);
                }
            }
            QQFriendUI.this.gxV = false;
            AppMethodBeat.m2505o(108615);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.QQFriendUI$2 */
    class C265942 implements C5600b {
        C265942() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(108614);
            QQFriendUI.this.gtX = C5046bo.m7586vA(str);
            QQFriendUI.this.gxV = true;
            QQFriendUI qQFriendUI = QQFriendUI.this;
            if (qQFriendUI.gxU != null) {
                qQFriendUI.gxU.mo21261vM(qQFriendUI.gtX);
            }
            AppMethodBeat.m2505o(108614);
        }

        public final void apo() {
        }

        public final void app() {
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.QQFriendUI$4 */
    class C329714 implements OnItemClickListener {
        C329714() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(108616);
            if (i < QQFriendUI.this.gtT.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(108616);
                return;
            }
            C4990ab.m7417i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", Integer.valueOf(i - QQFriendUI.this.gtT.getHeaderViewsCount()), Integer.valueOf(QQFriendUI.this.gtT.getHeaderViewsCount()));
            C9878ao c9878ao = (C9878ao) QQFriendUI.this.gxU.getItem(r0);
            Intent intent;
            if (QQFriendUI.this.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                C26203mx c26203mx = new C26203mx();
                c26203mx.cIO.opType = 0;
                c26203mx.cIO.cIQ = c9878ao.gwC + "@qqim";
                c26203mx.cIO.cIR = c9878ao.getDisplayName();
                C4879a.xxA.mo10055m(c26203mx);
                if (c26203mx.cIP.cvi) {
                    intent = new Intent();
                    intent.putExtra("Chat_User", c9878ao.gwC + "@qqim");
                    intent.putExtra("key_need_send_video", false);
                    C24679a.gkE.mo38915d(intent, QQFriendUI.this);
                }
                AppMethodBeat.m2505o(108616);
            } else if (c9878ao.gwD == 1 || c9878ao.gwD == 2) {
                C9879j c9879j;
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c9878ao.getUsername());
                if (aoO != null && aoO.dsf()) {
                    C7060h.pYm.mo8374X(10298, c9878ao.getUsername() + ",12");
                }
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", c9878ao.getUsername());
                intent2.putExtra("Contact_Nick", c9878ao.mo21224Hs());
                intent2.putExtra("Contact_Uin", c9878ao.gwC);
                intent2.putExtra("Contact_QQNick", c9878ao.getDisplayName());
                intent2.putExtra("Contact_Scene", 12);
                intent2.putExtra("Contact_RemarkName", c9878ao.aqr());
                C26586k c26586k = (C26586k) ((C7599a) C1720g.m3530M(C7599a.class)).getFrdExtStg();
                Cursor a = c26586k.fni.mo10104a("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + C5046bo.m7586vA(String.valueOf(c9878ao.getUsername())) + "\"", null, 2);
                if (a == null) {
                    c9879j = null;
                } else {
                    c9879j = null;
                    if (a.moveToFirst()) {
                        c9879j = new C9879j();
                        c9879j.username = a.getString(0);
                        c9879j.dtS = a.getInt(1);
                        c9879j.dub = a.getInt(2);
                        c9879j.duc = a.getString(3);
                        c9879j.dud = a.getString(4);
                        c9879j.signature = a.getString(5);
                    }
                    a.close();
                }
                if (c9879j != null) {
                    intent2.putExtra("Contact_Sex", c9879j.dtS);
                }
                intent2.putExtra("Contact_ShowUserName", false);
                if (C5046bo.isNullOrNil(c9878ao.getUsername())) {
                    C4990ab.m7413e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", c9878ao.toString());
                    AppMethodBeat.m2505o(108616);
                    return;
                }
                C24679a.gkE.mo38912c(intent2, QQFriendUI.this);
                AppMethodBeat.m2505o(108616);
            } else {
                if (c9878ao.gwD == 0) {
                    intent = new Intent(QQFriendUI.this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 0);
                    intent.putExtra("friend_user_name", c9878ao.getUsername());
                    intent.putExtra("friend_num", c9878ao.gwC);
                    intent.putExtra("friend_nick", c9878ao.getDisplayName());
                    intent.putExtra("friend_weixin_nick", c9878ao.mo21224Hs());
                    intent.putExtra("friend_scene", 12);
                    QQFriendUI.this.startActivity(intent);
                }
                AppMethodBeat.m2505o(108616);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.QQFriendUI$6 */
    class C329726 implements OnClickListener {
        C329726() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(108618);
            C4978c.m7375a(QQFriendUI.this.gtT);
            AppMethodBeat.m2505o(108618);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.QQFriendUI$5 */
    class C329735 implements OnMenuItemClickListener {
        C329735() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(108617);
            QQFriendUI.this.aqX();
            QQFriendUI.this.finish();
            AppMethodBeat.m2505o(108617);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(108619);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a((int) ErrorCode.NEEDDOWNLOAD_4, (C1202f) this);
        String stringExtra = getIntent().getStringExtra("qqgroup_name");
        this.f15025Zb = getIntent().getIntExtra("qqgroup_id", -1);
        C45496ap c45496ap = (C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg();
        int i = this.f15025Zb;
        C4990ab.m7410d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
        c45496ap.fni.mo10108hY("qqlist", "update qqlist set reserved4=0 where groupid=".concat(String.valueOf(i)));
        if (C38033l.m64349mX(this.f15025Zb)) {
            final C1207m c6716ac = new C6716ac(this.f15025Zb);
            C1720g.m3540Rg().mo14541a(c6716ac, 0);
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.df7), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(108613);
                    C1720g.m3540Rg().mo14547c(c6716ac);
                    AppMethodBeat.m2505o(108613);
                }
            });
        }
        setMMTitle(stringExtra);
        initView();
        AppMethodBeat.m2505o(108619);
    }

    public void onResume() {
        AppMethodBeat.m2504i(108620);
        super.onResume();
        C17884o.acd().mo67502d(this.gxU);
        this.gxU.notifyDataSetChanged();
        AppMethodBeat.m2505o(108620);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(108621);
        C18608f.m29045oU("2");
        ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo10121b(this.gxU);
        C1720g.m3540Rg().mo14546b((int) ErrorCode.NEEDDOWNLOAD_4, (C1202f) this);
        this.gxU.bIf();
        C17884o.acv().cancel();
        super.onDestroy();
        AppMethodBeat.m2505o(108621);
    }

    public void onPause() {
        AppMethodBeat.m2504i(108622);
        C17884o.acd().mo67503e(this.gxU);
        super.onPause();
        AppMethodBeat.m2505o(108622);
    }

    public final int getLayoutId() {
        return 2130970419;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(108623);
        C4990ab.m7418v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(108623);
        return onKeyDown;
    }

    public final void initView() {
        byte b;
        AppMethodBeat.m2504i(108624);
        this.gtT = (ListView) findViewById(2131826675);
        this.gtY = (TextView) findViewById(2131826676);
        this.gtY.setText(C25738R.string.dff);
        this.elS = new C5601o((byte) 0);
        this.elS.zHa = new C265942();
        mo17380a(this.elS);
        if (C26407g.aaK().mo60654oP("2") != null) {
            String str = C26407g.aaK().mo60654oP("2").value;
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                b = (byte) 0;
            } else if (str.equals("1")) {
                b = (byte) 1;
            } else {
                b = (byte) 1;
            }
            C18608f.m29044oT("2");
        } else {
            b = (byte) 1;
        }
        if (b == (byte) 0) {
            this.gxU = new C32974e(this, this.f15025Zb);
        } else {
            this.gxU = new C9903f(this, this.f15025Zb);
        }
        this.gxU.mo21259a(new C246803());
        this.gtT.setAdapter(this.gxU);
        this.gtT.setOnItemClickListener(new C329714());
        ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo10118a(this.gxU);
        setBackBtn(new C329735());
        C329726 c329726 = new C329726();
        AppMethodBeat.m2505o(108624);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(108625);
        C4990ab.m7410d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + configuration.orientation);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.m2505o(108625);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(108626);
        C4990ab.m7416i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((amw) ((C6716ac) c1207m).ehh.fsG.fsP).nbk != 1) {
            AppMethodBeat.m2505o(108626);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            this.gxU.mo6869KC();
            AppMethodBeat.m2505o(108626);
            return;
        }
        Toast.makeText(this, C25738R.string.df6, 0).show();
        AppMethodBeat.m2505o(108626);
    }
}
