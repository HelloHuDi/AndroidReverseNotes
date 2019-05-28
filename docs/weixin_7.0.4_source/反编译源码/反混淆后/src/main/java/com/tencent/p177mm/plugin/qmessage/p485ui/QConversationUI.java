package com.tencent.p177mm.plugin.qmessage.p485ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.qmessage.C46143a;
import com.tencent.p177mm.plugin.qmessage.p739a.C7026c;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.aju;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI */
public class QConversationUI extends MMActivity implements C1202f {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private C5279d jKa = new C78205();
    private C7616ad ldh;
    private boolean ooX = false;
    private ListView ptc;
    private C28727c ptd;
    private C7026c pte;
    private boolean ptf = false;
    private String ptg;
    private String pth;
    private boolean pti = false;
    private String ptj;

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$13 */
    class C781413 implements OnMenuItemClickListener {
        C781413() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24139);
            if (!C5046bo.isNullOrNil(QConversationUI.this.ptg)) {
                QConversationUI.m13875a(QConversationUI.this, QConversationUI.this.ptg, QConversationUI.this.pth);
            }
            AppMethodBeat.m2505o(24139);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$1 */
    class C78151 implements C30723a {
        C78151() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(24126);
            QConversationUI qConversationUI = QConversationUI.this;
            String Oi = QConversationUI.this.ldh.mo16706Oi();
            int nR = C32798u.m53585nR(C1855t.fkS);
            if (nR <= 0) {
                qConversationUI.setMMTitle(Oi);
            } else {
                qConversationUI.setMMTitle(Oi + "(" + nR + ")");
            }
            QConversationUI.m13873a(QConversationUI.this, QConversationUI.this.ptd.getCount());
            AppMethodBeat.m2505o(24126);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$3 */
    class C78163 implements OnCancelListener {
        C78163() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(24128);
            QConversationUI.this.isDeleteCancel = true;
            AppMethodBeat.m2505o(24128);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$12 */
    class C781712 implements OnClickListener {
        C781712() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24138);
            C4978c.m7375a(QConversationUI.this.ptc);
            AppMethodBeat.m2505o(24138);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$2 */
    class C78182 implements OnMenuItemClickListener {
        C78182() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24127);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", QConversationUI.this.ldh.field_username);
            intent.putExtra("Chat_Readonly", true);
            C46143a.gkE.mo38912c(intent, QConversationUI.this.mController.ylL);
            AppMethodBeat.m2505o(24127);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$5 */
    class C78205 implements C5279d {
        C78205() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(24131);
            QConversationUI.m13874a(QConversationUI.this, QConversationUI.this.ptj);
            AppMethodBeat.m2505o(24131);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$11 */
    class C782111 implements OnMenuItemClickListener {
        C782111() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24137);
            QConversationUI.m13880e(QConversationUI.this);
            AppMethodBeat.m2505o(24137);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$6 */
    class C78226 implements C15521c {
        C78226() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(24132);
            int positionForView = QConversationUI.this.ptc.getPositionForView(view);
            AppMethodBeat.m2505o(24132);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$8 */
    class C78238 implements C23599f {
        C78238() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(24134);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.QConversationUI", "onItemDel object null");
                AppMethodBeat.m2505o(24134);
                return;
            }
            QConversationUI.m13874a(QConversationUI.this, obj.toString());
            AppMethodBeat.m2505o(24134);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$7 */
    class C78247 implements C23600g {
        C78247() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(24133);
            QConversationUI.this.ptc.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(24133);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.QConversationUI$9 */
    class C78269 implements OnItemClickListener {
        C78269() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(24135);
            C7617ak c7617ak = (C7617ak) QConversationUI.this.ptd.getItem(i);
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", c7617ak.field_username);
            intent.putExtra("key_need_send_video", false);
            C46143a.gkE.mo38915d(intent, QConversationUI.this.mController.ylL);
            AppMethodBeat.m2505o(24135);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public QConversationUI() {
        AppMethodBeat.m2504i(24140);
        AppMethodBeat.m2505o(24140);
    }

    /* renamed from: e */
    static /* synthetic */ void m13880e(QConversationUI qConversationUI) {
        AppMethodBeat.m2504i(24159);
        qConversationUI.goBack();
        AppMethodBeat.m2505o(24159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24141);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(24141);
    }

    public final int getLayoutId() {
        return 2130970930;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24142);
        this.ptd.bIf();
        if (this.pte != null) {
            C9638aw.m17182Rg().mo14547c(this.pte);
            C9638aw.m17182Rg().mo14546b(this.pte.getType(), (C1202f) this);
            this.pte = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(24142);
    }

    public void onResume() {
        AppMethodBeat.m2504i(24143);
        super.onResume();
        QConversationUI.cch();
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10118a(this.ptd);
        this.ptd.mo5248a(null, null);
        AppMethodBeat.m2505o(24143);
    }

    private static void cch() {
        AppMethodBeat.m2504i(24144);
        C9638aw.m17190ZK();
        C7620bi yw = C18628c.m29080XO().mo15355yw(2);
        if (yw != null && yw.field_msgId > 0) {
            C4990ab.m7410d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + yw.field_createTime);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(12295, Long.valueOf(yw.field_createTime));
        }
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ("qmessage");
        if (aoZ == null || C5046bo.nullAsNil(aoZ.field_username).length() <= 0) {
            C4990ab.m7412e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            AppMethodBeat.m2505o(24144);
            return;
        }
        aoZ.mo14748hM(0);
        C9638aw.m17190ZK();
        if (C18628c.m29083XR().mo15767a(aoZ, aoZ.field_username) == -1) {
            C4990ab.m7412e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
        AppMethodBeat.m2505o(24144);
    }

    public void onPause() {
        AppMethodBeat.m2504i(24145);
        C4990ab.m7418v("MicroMsg.QConversationUI", "on pause");
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10121b(this.ptd);
        QConversationUI.cch();
        this.ptd.onPause();
        super.onPause();
        AppMethodBeat.m2505o(24145);
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.m2504i(24146);
        this.ooX = getIntent().getBooleanExtra("finish_direct", false);
        C4990ab.m7410d("MicroMsg.QConversationUI", "isFromSearch  " + this.ooX);
        C9638aw.m17190ZK();
        this.ldh = C18628c.m29078XM().aoO("qmessage");
        String str = "can not find qmessage";
        if (this.ldh != null && ((int) this.ldh.ewQ) > 0) {
            z = true;
        }
        Assert.assertTrue(str, z);
        this.ptc = (ListView) findViewById(2131823620);
        this.emptyTipTv = (TextView) findViewById(2131821807);
        this.emptyTipTv.setText(C25738R.string.bd9);
        this.ptd = new C28727c(this, new C78151());
        this.ptd.setGetViewPositionCallback(new C78226());
        this.ptd.setPerformItemClickListener(new C78247());
        this.ptd.mo46876a(new C78238());
        this.ptc.setAdapter(this.ptd);
        this.ptc.setOnItemClickListener(new C78269());
        final C24088a c24088a = new C24088a(this);
        this.ptc.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(24136);
                if (i < QConversationUI.this.ptc.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.QConversationUI", "on header view long click, ignore");
                    AppMethodBeat.m2505o(24136);
                    return true;
                }
                c24088a.mo39885a(view, i, j, QConversationUI.this, QConversationUI.this.jKa, 0, 0);
                AppMethodBeat.m2505o(24136);
                return true;
            }
        });
        C46143a.psH.mo38869gk(1010);
        setBackBtn(new C782111());
        C781712 c781712 = new C781712();
        cck();
        ccj();
        QConversationUI.ccm();
        AppMethodBeat.m2505o(24146);
    }

    /* renamed from: aO */
    private static String m13876aO(Context context, String str) {
        String str2;
        AppMethodBeat.m2504i(24147);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.m2505o(24147);
                return str2;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.m2505o(24147);
        return str2;
    }

    private void cci() {
        AppMethodBeat.m2504i(24148);
        if (C5046bo.isNullOrNil(this.ptg)) {
            AppMethodBeat.m2505o(24148);
            return;
        }
        this.ptf = true;
        addIconOptionMenu(0, C25738R.string.f8695ca, C1318a.f1222qq, new C781413());
        AppMethodBeat.m2505o(24148);
    }

    private void cck() {
        AppMethodBeat.m2504i(24150);
        C9638aw.m17190ZK();
        this.ptg = (String) C18628c.m29072Ry().get(77, (Object) "");
        C9638aw.m17190ZK();
        this.pth = (String) C18628c.m29072Ry().get(78, (Object) "");
        ccl();
        AppMethodBeat.m2505o(24150);
    }

    private void ccl() {
        AppMethodBeat.m2504i(24151);
        if (this.pte == null) {
            this.pte = new C7026c();
            C9638aw.m17182Rg().mo14539a(this.pte.getType(), (C1202f) this);
        }
        C9638aw.m17182Rg().mo14541a(this.pte, 0);
        AppMethodBeat.m2505o(24151);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(24153);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(24153);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(24153);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(24154);
        if (this.ooX) {
            finish();
            AppMethodBeat.m2505o(24154);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        C46143a.gkE.mo38931p(intent, this);
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8367c9);
        AppMethodBeat.m2505o(24154);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(24155);
        C7617ak c7617ak = (C7617ak) this.ptd.getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
        C9638aw.m17190ZK();
        contextMenu.setHeaderTitle(C18628c.m29078XM().aoO(c7617ak.field_username).mo16707Oj());
        contextMenu.add(0, 0, 0, C25738R.string.cvq);
        this.ptj = c7617ak.field_username;
        AppMethodBeat.m2505o(24155);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        Object obj = null;
        AppMethodBeat.m2504i(24156);
        C4990ab.m7411d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (c1207m.getType()) {
            case 630:
                if (i == 0 && i2 == 0) {
                    Object obj2;
                    Object obj3;
                    String obj32;
                    C7026c c7026c = (C7026c) c1207m;
                    if (c7026c.fSY != null) {
                        aju aju = (aju) c7026c.fSY.fsH.fsP;
                        if (aju != null) {
                            obj2 = aju.wpt;
                            if (c7026c.fSY != null) {
                                aju = (aju) c7026c.fSY.fsH.fsP;
                                if (aju != null) {
                                    obj32 = aju.vMJ;
                                    if (c7026c.fSY != null) {
                                        aju = (aju) c7026c.fSY.fsH.fsP;
                                        if (aju != null) {
                                            obj = aju.wpu;
                                        }
                                    }
                                    if (!C5046bo.isNullOrNil(obj)) {
                                        this.ptg = obj;
                                        C9638aw.m17190ZK();
                                        C18628c.m29072Ry().set(77, obj);
                                    }
                                    this.pth = obj32;
                                    C9638aw.m17190ZK();
                                    C18628c.m29072Ry().set(78, obj32);
                                    if (!this.ptf) {
                                        ccj();
                                    }
                                    C4990ab.m7411d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj2, obj32, obj);
                                    break;
                                }
                            }
                            obj32 = null;
                            if (c7026c.fSY != null) {
                            }
                            if (C5046bo.isNullOrNil(obj)) {
                            }
                            this.pth = obj32;
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(78, obj32);
                            if (this.ptf) {
                            }
                            C4990ab.m7411d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj2, obj32, obj);
                        }
                    }
                    String obj22 = null;
                    if (c7026c.fSY != null) {
                    }
                    obj32 = null;
                    if (c7026c.fSY != null) {
                    }
                    if (C5046bo.isNullOrNil(obj)) {
                    }
                    this.pth = obj32;
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(78, obj32);
                    if (this.ptf) {
                    }
                    C4990ab.m7411d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj22, obj32, obj);
                }
        }
        AppMethodBeat.m2505o(24156);
    }

    private void ccj() {
        AppMethodBeat.m2504i(24149);
        this.mController.removeAllOptionMenu();
        cci();
        addIconOptionMenu(2, C25738R.string.f8697cd, C1318a.actionbar_setting_icon, new C78182());
        AppMethodBeat.m2505o(24149);
    }

    private static void ccm() {
        AppMethodBeat.m2504i(24152);
        C46143a.psH.mo38869gk(1010);
        AppMethodBeat.m2505o(24152);
    }

    /* renamed from: a */
    static /* synthetic */ void m13875a(QConversationUI qConversationUI, String str, String str2) {
        AppMethodBeat.m2504i(24160);
        if (str == null) {
            C4990ab.m7410d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            AppMethodBeat.m2505o(24160);
            return;
        }
        C40439f bT = C46494g.m87739bT(str, true);
        if (bT == null || !C35799p.m58695u(qConversationUI.mController.ylL, bT.field_packageName)) {
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C35799p.m58685C(qConversationUI.mController.ylL, str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            C25985d.m41467b(qConversationUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(24160);
        } else if (bT.field_status == 3) {
            C4990ab.m7412e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + bT.field_packageName);
            AppMethodBeat.m2505o(24160);
        } else if (C35799p.m58689b(qConversationUI.mController.ylL, bT)) {
            int i;
            C4990ab.m7410d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(268435456);
            intent2.setClassName(bT.field_packageName, QConversationUI.m13876aO(qConversationUI.mController.ylL, bT.field_packageName));
            intent2.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            C9638aw.m17190ZK();
            Object obj = C18628c.m29072Ry().get(9, null);
            if (obj == null || !(obj instanceof Integer)) {
                i = 0;
            } else {
                i = ((Integer) obj).intValue();
            }
            if (i != 0) {
                try {
                    byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    i = 0;
                    int i2 = 0;
                    while (i < length) {
                        byte b = bytes2[i];
                        if (i2 >= bytes.length) {
                            break;
                        }
                        int i3 = i2 + 1;
                        bytes[i2] = (byte) (b ^ bytes[i2]);
                        i++;
                        i2 = i3;
                    }
                    intent2.putExtra("tencent_gif", bytes);
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
                }
            }
            try {
                qConversationUI.startActivity(intent2);
                AppMethodBeat.m2505o(24160);
            } catch (Exception e2) {
                AppMethodBeat.m2505o(24160);
            }
        } else {
            C4990ab.m7413e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", bT.field_appName);
            Toast.makeText(qConversationUI.mController.ylL, qConversationUI.getString(C25738R.string.c62, new Object[]{C46494g.m87733b(qConversationUI.mController.ylL, bT, null)}), 1).show();
            AppMethodBeat.m2505o(24160);
        }
    }
}
