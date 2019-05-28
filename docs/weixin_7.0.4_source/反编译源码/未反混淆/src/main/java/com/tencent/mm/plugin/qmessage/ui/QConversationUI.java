package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.plugin.qmessage.a.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.p.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import junit.framework.Assert;

public class QConversationUI extends MMActivity implements f {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(24131);
            QConversationUI.a(QConversationUI.this, QConversationUI.this.ptj);
            AppMethodBeat.o(24131);
        }
    };
    private ad ldh;
    private boolean ooX = false;
    private ListView ptc;
    private c ptd;
    private c pte;
    private boolean ptf = false;
    private String ptg;
    private String pth;
    private boolean pti = false;
    private String ptj;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QConversationUI() {
        AppMethodBeat.i(24140);
        AppMethodBeat.o(24140);
    }

    static /* synthetic */ void e(QConversationUI qConversationUI) {
        AppMethodBeat.i(24159);
        qConversationUI.goBack();
        AppMethodBeat.o(24159);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24141);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(24141);
    }

    public final int getLayoutId() {
        return R.layout.azr;
    }

    public void onDestroy() {
        AppMethodBeat.i(24142);
        this.ptd.bIf();
        if (this.pte != null) {
            aw.Rg().c(this.pte);
            aw.Rg().b(this.pte.getType(), (f) this);
            this.pte = null;
        }
        super.onDestroy();
        AppMethodBeat.o(24142);
    }

    public void onResume() {
        AppMethodBeat.i(24143);
        super.onResume();
        cch();
        aw.ZK();
        com.tencent.mm.model.c.XR().a(this.ptd);
        this.ptd.a(null, null);
        AppMethodBeat.o(24143);
    }

    private static void cch() {
        AppMethodBeat.i(24144);
        aw.ZK();
        bi yw = com.tencent.mm.model.c.XO().yw(2);
        if (yw != null && yw.field_msgId > 0) {
            ab.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + yw.field_createTime);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(12295, Long.valueOf(yw.field_createTime));
        }
        aw.ZK();
        ak aoZ = com.tencent.mm.model.c.XR().aoZ("qmessage");
        if (aoZ == null || bo.nullAsNil(aoZ.field_username).length() <= 0) {
            ab.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            AppMethodBeat.o(24144);
            return;
        }
        aoZ.hM(0);
        aw.ZK();
        if (com.tencent.mm.model.c.XR().a(aoZ, aoZ.field_username) == -1) {
            ab.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
        AppMethodBeat.o(24144);
    }

    public void onPause() {
        AppMethodBeat.i(24145);
        ab.v("MicroMsg.QConversationUI", "on pause");
        aw.ZK();
        com.tencent.mm.model.c.XR().b(this.ptd);
        cch();
        this.ptd.onPause();
        super.onPause();
        AppMethodBeat.o(24145);
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.i(24146);
        this.ooX = getIntent().getBooleanExtra("finish_direct", false);
        ab.d("MicroMsg.QConversationUI", "isFromSearch  " + this.ooX);
        aw.ZK();
        this.ldh = com.tencent.mm.model.c.XM().aoO("qmessage");
        String str = "can not find qmessage";
        if (this.ldh != null && ((int) this.ldh.ewQ) > 0) {
            z = true;
        }
        Assert.assertTrue(str, z);
        this.ptc = (ListView) findViewById(R.id.bi5);
        this.emptyTipTv = (TextView) findViewById(R.id.a74);
        this.emptyTipTv.setText(R.string.bd9);
        this.ptd = new c(this, new a() {
            public final void apt() {
                AppMethodBeat.i(24126);
                QConversationUI qConversationUI = QConversationUI.this;
                String Oi = QConversationUI.this.ldh.Oi();
                int nR = u.nR(t.fkS);
                if (nR <= 0) {
                    qConversationUI.setMMTitle(Oi);
                } else {
                    qConversationUI.setMMTitle(Oi + "(" + nR + ")");
                }
                QConversationUI.a(QConversationUI.this, QConversationUI.this.ptd.getCount());
                AppMethodBeat.o(24126);
            }
        });
        this.ptd.setGetViewPositionCallback(new MMSlideDelView.c() {
            public final int cZ(View view) {
                AppMethodBeat.i(24132);
                int positionForView = QConversationUI.this.ptc.getPositionForView(view);
                AppMethodBeat.o(24132);
                return positionForView;
            }
        });
        this.ptd.setPerformItemClickListener(new g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(24133);
                QConversationUI.this.ptc.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(24133);
            }
        });
        this.ptd.a(new MMSlideDelView.f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(24134);
                if (obj == null) {
                    ab.e("MicroMsg.QConversationUI", "onItemDel object null");
                    AppMethodBeat.o(24134);
                    return;
                }
                QConversationUI.a(QConversationUI.this, obj.toString());
                AppMethodBeat.o(24134);
            }
        });
        this.ptc.setAdapter(this.ptd);
        this.ptc.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24135);
                ak akVar = (ak) QConversationUI.this.ptd.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", akVar.field_username);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.qmessage.a.gkE.d(intent, QConversationUI.this.mController.ylL);
                AppMethodBeat.o(24135);
            }
        });
        final com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(this);
        this.ptc.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24136);
                if (i < QConversationUI.this.ptc.getHeaderViewsCount()) {
                    ab.w("MicroMsg.QConversationUI", "on header view long click, ignore");
                    AppMethodBeat.o(24136);
                    return true;
                }
                aVar.a(view, i, j, QConversationUI.this, QConversationUI.this.jKa, 0, 0);
                AppMethodBeat.o(24136);
                return true;
            }
        });
        com.tencent.mm.plugin.qmessage.a.psH.gk(1010);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24137);
                QConversationUI.e(QConversationUI.this);
                AppMethodBeat.o(24137);
                return true;
            }
        });
        AnonymousClass12 anonymousClass12 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24138);
                BackwardSupportUtil.c.a(QConversationUI.this.ptc);
                AppMethodBeat.o(24138);
            }
        };
        cck();
        ccj();
        ccm();
        AppMethodBeat.o(24146);
    }

    private static String aO(Context context, String str) {
        String str2;
        AppMethodBeat.i(24147);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                str2 = resolveInfo.activityInfo.name;
                AppMethodBeat.o(24147);
                return str2;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(24147);
        return str2;
    }

    private void cci() {
        AppMethodBeat.i(24148);
        if (bo.isNullOrNil(this.ptg)) {
            AppMethodBeat.o(24148);
            return;
        }
        this.ptf = true;
        addIconOptionMenu(0, R.string.ca, R.raw.qq, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24139);
                if (!bo.isNullOrNil(QConversationUI.this.ptg)) {
                    QConversationUI.a(QConversationUI.this, QConversationUI.this.ptg, QConversationUI.this.pth);
                }
                AppMethodBeat.o(24139);
                return true;
            }
        });
        AppMethodBeat.o(24148);
    }

    private void cck() {
        AppMethodBeat.i(24150);
        aw.ZK();
        this.ptg = (String) com.tencent.mm.model.c.Ry().get(77, (Object) "");
        aw.ZK();
        this.pth = (String) com.tencent.mm.model.c.Ry().get(78, (Object) "");
        ccl();
        AppMethodBeat.o(24150);
    }

    private void ccl() {
        AppMethodBeat.i(24151);
        if (this.pte == null) {
            this.pte = new c();
            aw.Rg().a(this.pte.getType(), (f) this);
        }
        aw.Rg().a(this.pte, 0);
        AppMethodBeat.o(24151);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(24153);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(24153);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(24153);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(24154);
        if (this.ooX) {
            finish();
            AppMethodBeat.o(24154);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.qmessage.a.gkE.p(intent, this);
        overridePendingTransition(R.anim.s, R.anim.c9);
        AppMethodBeat.o(24154);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(24155);
        ak akVar = (ak) this.ptd.getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
        aw.ZK();
        contextMenu.setHeaderTitle(com.tencent.mm.model.c.XM().aoO(akVar.field_username).Oj());
        contextMenu.add(0, 0, 0, R.string.cvq);
        this.ptj = akVar.field_username;
        AppMethodBeat.o(24155);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        Object obj = null;
        AppMethodBeat.i(24156);
        ab.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (mVar.getType()) {
            case 630:
                if (i == 0 && i2 == 0) {
                    Object obj2;
                    Object obj3;
                    String obj32;
                    c cVar = (c) mVar;
                    if (cVar.fSY != null) {
                        aju aju = (aju) cVar.fSY.fsH.fsP;
                        if (aju != null) {
                            obj2 = aju.wpt;
                            if (cVar.fSY != null) {
                                aju = (aju) cVar.fSY.fsH.fsP;
                                if (aju != null) {
                                    obj32 = aju.vMJ;
                                    if (cVar.fSY != null) {
                                        aju = (aju) cVar.fSY.fsH.fsP;
                                        if (aju != null) {
                                            obj = aju.wpu;
                                        }
                                    }
                                    if (!bo.isNullOrNil(obj)) {
                                        this.ptg = obj;
                                        aw.ZK();
                                        com.tencent.mm.model.c.Ry().set(77, obj);
                                    }
                                    this.pth = obj32;
                                    aw.ZK();
                                    com.tencent.mm.model.c.Ry().set(78, obj32);
                                    if (!this.ptf) {
                                        ccj();
                                    }
                                    ab.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj2, obj32, obj);
                                    break;
                                }
                            }
                            obj32 = null;
                            if (cVar.fSY != null) {
                            }
                            if (bo.isNullOrNil(obj)) {
                            }
                            this.pth = obj32;
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(78, obj32);
                            if (this.ptf) {
                            }
                            ab.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj2, obj32, obj);
                        }
                    }
                    String obj22 = null;
                    if (cVar.fSY != null) {
                    }
                    obj32 = null;
                    if (cVar.fSY != null) {
                    }
                    if (bo.isNullOrNil(obj)) {
                    }
                    this.pth = obj32;
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(78, obj32);
                    if (this.ptf) {
                    }
                    ab.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj22, obj32, obj);
                }
        }
        AppMethodBeat.o(24156);
    }

    private void ccj() {
        AppMethodBeat.i(24149);
        this.mController.removeAllOptionMenu();
        cci();
        addIconOptionMenu(2, R.string.cd, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24127);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", QConversationUI.this.ldh.field_username);
                intent.putExtra("Chat_Readonly", true);
                com.tencent.mm.plugin.qmessage.a.gkE.c(intent, QConversationUI.this.mController.ylL);
                AppMethodBeat.o(24127);
                return true;
            }
        });
        AppMethodBeat.o(24149);
    }

    private static void ccm() {
        AppMethodBeat.i(24152);
        com.tencent.mm.plugin.qmessage.a.psH.gk(1010);
        AppMethodBeat.o(24152);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, String str, String str2) {
        AppMethodBeat.i(24160);
        if (str == null) {
            ab.d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            AppMethodBeat.o(24160);
            return;
        }
        com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
        if (bT == null || !p.u(qConversationUI.mController.ylL, bT.field_packageName)) {
            if (bo.isNullOrNil(str2)) {
                str2 = p.C(qConversationUI.mController.ylL, str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.bp.d.b(qConversationUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(24160);
        } else if (bT.field_status == 3) {
            ab.e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + bT.field_packageName);
            AppMethodBeat.o(24160);
        } else if (p.b(qConversationUI.mController.ylL, bT)) {
            int i;
            ab.d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(268435456);
            intent2.setClassName(bT.field_packageName, aO(qConversationUI.mController.ylL, bT.field_packageName));
            intent2.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            aw.ZK();
            Object obj = com.tencent.mm.model.c.Ry().get(9, null);
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
                    ab.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
                }
            }
            try {
                qConversationUI.startActivity(intent2);
                AppMethodBeat.o(24160);
            } catch (Exception e2) {
                AppMethodBeat.o(24160);
            }
        } else {
            ab.e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", bT.field_appName);
            Toast.makeText(qConversationUI.mController.ylL, qConversationUI.getString(R.string.c62, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(qConversationUI.mController.ylL, bT, null)}), 1).show();
            AppMethodBeat.o(24160);
        }
    }
}
