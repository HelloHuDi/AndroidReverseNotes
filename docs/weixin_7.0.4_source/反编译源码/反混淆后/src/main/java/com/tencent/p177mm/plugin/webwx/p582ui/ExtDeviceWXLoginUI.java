package com.tencent.p177mm.plugin.webwx.p582ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26178kb;
import com.tencent.p177mm.p230g.p231a.C9392ka;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.webwx.p1071a.C23161e;
import com.tencent.p177mm.plugin.webwx.p1071a.C43992c;
import com.tencent.p177mm.protocal.protobuf.C30253zp;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI */
public class ExtDeviceWXLoginUI extends MMActivity implements C1202f {
    private boolean cFv = false;
    private String cLY = null;
    private int fOZ = 0;
    private ProgressDialog nEK = null;
    private int type = 0;
    private boolean uLe = false;
    private String uLo = null;
    private int uLp;
    private int uLq;
    private boolean uLr = false;
    private Button uLs;
    private TextView uLt;

    /* renamed from: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$1 */
    class C147101 implements OnClickListener {
        C147101() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26521);
            Intent intent = new Intent();
            intent.putExtra("title", ExtDeviceWXLoginUI.this.getString(C25738R.string.fzv));
            intent.putExtra("rawUrl", ExtDeviceWXLoginUI.this.getString(C25738R.string.g7c, new Object[]{C4988aa.dor()}));
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            C25985d.m41467b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(26521);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$2 */
    class C147112 implements OnClickListener {
        C147112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26522);
            ExtDeviceWXLoginUI.m78972a(ExtDeviceWXLoginUI.this);
            AppMethodBeat.m2505o(26522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$3 */
    class C357313 implements OnClickListener {
        C357313() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26523);
            if (ExtDeviceWXLoginUI.this.type != 0) {
                if (ExtDeviceWXLoginUI.this.type == -2) {
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                    intent.putExtra("from_album", false);
                    intent.putExtra("show_intro", false);
                    intent.setFlags(65536);
                    C25985d.m41467b(ExtDeviceWXLoginUI.this, "scanner", ".ui.BaseScanUI", intent);
                    ExtDeviceWXLoginUI.this.finish();
                }
                AppMethodBeat.m2505o(26523);
            } else if (ExtDeviceWXLoginUI.this.uLe) {
                boolean z;
                boolean isChecked = ((CheckBox) ExtDeviceWXLoginUI.this.findViewById(2131823278)).isChecked();
                ExtDeviceWXLoginUI.this.cFv = false;
                if (isChecked) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.TRUE);
                } else {
                    C9638aw.m17190ZK();
                    if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                        ExtDeviceWXLoginUI.this.cFv = true;
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.FALSE);
                }
                ExtDeviceWXLoginUI extDeviceWXLoginUI = ExtDeviceWXLoginUI.this;
                if (ExtDeviceWXLoginUI.this.uLe && isChecked) {
                    z = true;
                } else {
                    z = false;
                }
                ExtDeviceWXLoginUI.m78975b(extDeviceWXLoginUI, z);
                AppMethodBeat.m2505o(26523);
            } else {
                ExtDeviceWXLoginUI.m78975b(ExtDeviceWXLoginUI.this, false);
                AppMethodBeat.m2505o(26523);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$4 */
    class C403574 implements Runnable {
        C403574() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26524);
            ExtDeviceWXLoginUI.m78977d(ExtDeviceWXLoginUI.this);
            AppMethodBeat.m2505o(26524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$5 */
    class C439945 implements OnClickListener {
        C439945() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26525);
            ExtDeviceWXLoginUI.this.finish();
            AppMethodBeat.m2505o(26525);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26528);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        initView();
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8293s);
        AppMethodBeat.m2505o(26528);
    }

    public void onResume() {
        AppMethodBeat.m2504i(26529);
        super.onResume();
        AppMethodBeat.m2505o(26529);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x014e  */
    /* JADX WARNING: Missing block: B:38:0x022e, code skipped:
            if (((java.lang.Boolean) com.tencent.p177mm.model.C18628c.m29072Ry().get(com.tencent.p177mm.storage.C5128ac.C5127a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, java.lang.Boolean.TRUE)).booleanValue() == false) goto L_0x0230;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        AppMethodBeat.m2504i(26530);
        this.cLY = getIntent().getStringExtra("intent.key.login.url");
        this.type = getIntent().getIntExtra("intent.key.type", 0);
        String stringExtra = getIntent().getStringExtra("intent.key.title.string");
        this.fOZ = getIntent().getIntExtra("intent.key.icon.type", 0);
        String stringExtra2 = getIntent().getStringExtra("intent.key.ok.string");
        String stringExtra3 = getIntent().getStringExtra("intent.key.cancel.string");
        String stringExtra4 = getIntent().getStringExtra("intent.key.content.string");
        this.uLo = getIntent().getStringExtra("intent.key.ok.session.list");
        this.uLp = getIntent().getIntExtra("intent.key.login.client.version", 0);
        this.uLq = getIntent().getIntExtra("intent.key.function.control", 0);
        C4990ab.m7417i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s", Integer.valueOf(this.type), stringExtra, stringExtra2, stringExtra4);
        setMMTitle("");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            ((TextView) findViewById(2131823277)).setText(stringExtra);
        }
        C9392ka c9392ka = new C9392ka();
        C4879a.xxA.mo10055m(c9392ka);
        int i = c9392ka.cFo.cFp;
        int i2 = c9392ka.cFo.cFq;
        int i3 = c9392ka.cFo.cFr;
        switch (this.fOZ) {
            case 1:
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(3));
                break;
            case 2:
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(4));
                break;
            default:
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(0));
                break;
        }
        if (!C5046bo.isNullOrNil(stringExtra4)) {
            ((CheckBox) findViewById(2131823278)).setVisibility(8);
            ((TextView) findViewById(2131823279)).setVisibility(0);
            ((TextView) findViewById(2131823279)).setText(stringExtra4);
        } else if (i >= 0) {
            C4990ab.m7417i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", Boolean.valueOf((this.uLq & 1) > 0), Integer.valueOf(this.fOZ));
            if ((this.fOZ == 1 && this.uLp >= i2) || (this.fOZ == 2 && this.uLp >= i3)) {
                this.uLe = true;
                ((TextView) findViewById(2131823279)).setVisibility(8);
                ((CheckBox) findViewById(2131823278)).setVisibility(0);
                ((CheckBox) findViewById(2131823278)).setText(C25738R.string.fzv);
                if (r1) {
                    C9638aw.m17190ZK();
                }
                ((CheckBox) findViewById(2131823278)).setChecked(false);
                ((ImageView) findViewById(2131823275)).setImageResource(C1318a.connect_icon_help);
                ((ImageView) findViewById(2131823275)).setOnClickListener(new C147101());
            }
        }
        ImageView imageView = (ImageView) findViewById(2131823276);
        if (this.fOZ != 1) {
            if (this.fOZ == 2) {
                imageView.setImageResource(C1318a.connect_mac);
            } else if (this.fOZ == 3) {
                imageView.setImageResource(C1318a.connect_ipad);
            } else if (this.fOZ == 5) {
                imageView.setImageResource(C1318a.connect_wx_album);
            }
            this.uLt = (TextView) findViewById(2131823281);
            this.uLt.setText(stringExtra3);
            this.uLt.setOnClickListener(new C147112());
            this.uLs = (Button) findViewById(2131823280);
            if (C5046bo.isNullOrNil(stringExtra2)) {
                this.uLs.setText(stringExtra2);
                if (this.type == 0) {
                    this.uLs.setEnabled(true);
                } else if (this.type == -1) {
                    this.uLs.setEnabled(false);
                    if (this.fOZ == 5) {
                        this.uLt.setVisibility(8);
                    }
                } else if (this.type == -2) {
                    this.uLs.setEnabled(true);
                }
            } else {
                this.uLs.setVisibility(4);
            }
            this.uLs.setOnClickListener(new C357313());
            this.mController.contentView.post(new C403574());
            ((TextView) findViewById(2131823274)).setOnClickListener(new C439945());
            C9638aw.m17182Rg().mo14539a(972, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(973, (C1202f) this);
            AppMethodBeat.m2505o(26530);
        }
        imageView.setImageResource(C1318a.connect_pc);
        this.uLt = (TextView) findViewById(2131823281);
        this.uLt.setText(stringExtra3);
        this.uLt.setOnClickListener(new C147112());
        this.uLs = (Button) findViewById(2131823280);
        if (C5046bo.isNullOrNil(stringExtra2)) {
        }
        this.uLs.setOnClickListener(new C357313());
        this.mController.contentView.post(new C403574());
        ((TextView) findViewById(2131823274)).setOnClickListener(new C439945());
        C9638aw.m17182Rg().mo14539a(972, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(973, (C1202f) this);
        AppMethodBeat.m2505o(26530);
    }

    public void onPause() {
        AppMethodBeat.m2504i(26531);
        super.onPause();
        if (this.uLr && C9638aw.m17179RK()) {
            act act = new act();
            act.wkw = 27;
            act.pvD = C1853r.m3855ku(C1853r.m3824YF()) ? 1 : 2;
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C3465a(23, act));
            this.uLr = false;
        }
        AppMethodBeat.m2505o(26531);
    }

    public final int getLayoutId() {
        return 2130969285;
    }

    public void finish() {
        AppMethodBeat.m2504i(26532);
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(26532);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26533);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(972, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(973, (C1202f) this);
        AppMethodBeat.m2505o(26533);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26534);
        if (this.nEK != null) {
            this.nEK.dismiss();
            this.nEK = null;
        }
        if (i == 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i2), Integer.valueOf(i));
            C9638aw.m17182Rg().mo14546b(972, (C1202f) this);
            if (c1207m.getType() == 972) {
                C23161e c23161e = (C23161e) c1207m;
                if (c23161e.uLe || this.cFv) {
                    byte[] bArr;
                    C30253zp c30253zp = (C30253zp) c23161e.fAT.fsH.fsP;
                    if (c30253zp == null || c30253zp.weU == null) {
                        bArr = null;
                    } else {
                        bArr = c30253zp.weU.toByteArray();
                    }
                    C26178kb c26178kb = new C26178kb();
                    c26178kb.cFs.cFt = bArr;
                    c26178kb.cFs.cFu = this.fOZ;
                    c26178kb.cFs.cFv = this.cFv;
                    C4879a.xxA.mo10055m(c26178kb);
                }
            } else {
                c1207m.getType();
            }
            this.type = 0;
            finish();
            AppMethodBeat.m2505o(26534);
            return;
        }
        if (i2 == -1) {
            this.type = -1;
        } else if (i2 == -2) {
            this.type = -2;
        }
        if (!C5046bo.isNullOrNil(str)) {
            ((CheckBox) findViewById(2131823278)).setVisibility(8);
            ((TextView) findViewById(2131823279)).setVisibility(0);
            ((TextView) findViewById(2131823279)).setText(str);
        }
        if (this.type == -1) {
            if (this.uLs != null) {
                this.uLs.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.uLs != null) {
                this.uLs.setEnabled(true);
                this.uLs.setText(C25738R.string.fzz);
            }
            if (this.uLt != null) {
                this.uLt.setVisibility(4);
            }
        }
        C4990ab.m7417i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.m2505o(26534);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m78972a(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        AppMethodBeat.m2504i(26535);
        final C1207m c43992c = new C43992c(extDeviceWXLoginUI.cLY);
        C9638aw.m17182Rg().mo14541a(c43992c, 0);
        extDeviceWXLoginUI.nEK = C30379h.m48458b(extDeviceWXLoginUI.mController.ylL, extDeviceWXLoginUI.getString(C25738R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(26527);
                C9638aw.m17182Rg().mo14547c(c43992c);
                if (ExtDeviceWXLoginUI.this.nEK != null) {
                    ExtDeviceWXLoginUI.this.nEK.cancel();
                }
                AppMethodBeat.m2505o(26527);
            }
        });
        AppMethodBeat.m2505o(26535);
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m78975b(ExtDeviceWXLoginUI extDeviceWXLoginUI, boolean z) {
        AppMethodBeat.m2504i(26536);
        final C1207m c23161e = new C23161e(extDeviceWXLoginUI.cLY, extDeviceWXLoginUI.uLo, z);
        C9638aw.m17182Rg().mo14541a(c23161e, 0);
        extDeviceWXLoginUI.nEK = C30379h.m48458b(extDeviceWXLoginUI.mController.ylL, extDeviceWXLoginUI.getString(C25738R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(26526);
                C9638aw.m17182Rg().mo14547c(c23161e);
                if (ExtDeviceWXLoginUI.this.nEK != null) {
                    ExtDeviceWXLoginUI.this.nEK.cancel();
                }
                AppMethodBeat.m2505o(26526);
            }
        });
        AppMethodBeat.m2505o(26536);
        return true;
    }

    /* renamed from: d */
    static /* synthetic */ void m78977d(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        AppMethodBeat.m2504i(26537);
        int[] iArr = new int[2];
        View findViewById = extDeviceWXLoginUI.findViewById(2131823273);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        C4990ab.m7417i("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height));
        extDeviceWXLoginUI.findViewById(2131823276).setPadding(0, (((int) (((double) r1) / 4.0d)) - i) - height, 0, 0);
        AppMethodBeat.m2505o(26537);
    }
}
