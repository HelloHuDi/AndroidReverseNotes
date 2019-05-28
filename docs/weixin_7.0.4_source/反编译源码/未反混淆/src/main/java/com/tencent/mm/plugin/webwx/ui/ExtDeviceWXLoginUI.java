package com.tencent.mm.plugin.webwx.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class ExtDeviceWXLoginUI extends MMActivity implements f {
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26528);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        initView();
        overridePendingTransition(R.anim.cg, R.anim.s);
        AppMethodBeat.o(26528);
    }

    public void onResume() {
        AppMethodBeat.i(26529);
        super.onResume();
        AppMethodBeat.o(26529);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x014e  */
    /* JADX WARNING: Missing block: B:38:0x022e, code skipped:
            if (((java.lang.Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, java.lang.Boolean.TRUE)).booleanValue() == false) goto L_0x0230;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        AppMethodBeat.i(26530);
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
        ab.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s", Integer.valueOf(this.type), stringExtra, stringExtra2, stringExtra4);
        setMMTitle("");
        if (!bo.isNullOrNil(stringExtra)) {
            ((TextView) findViewById(R.id.b9v)).setText(stringExtra);
        }
        ka kaVar = new ka();
        com.tencent.mm.sdk.b.a.xxA.m(kaVar);
        int i = kaVar.cFo.cFp;
        int i2 = kaVar.cFo.cFq;
        int i3 = kaVar.cFo.cFr;
        switch (this.fOZ) {
            case 1:
                aw.ZK();
                c.Ry().set(ac.a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(3));
                break;
            case 2:
                aw.ZK();
                c.Ry().set(ac.a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(4));
                break;
            default:
                aw.ZK();
                c.Ry().set(ac.a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(0));
                break;
        }
        if (!bo.isNullOrNil(stringExtra4)) {
            ((CheckBox) findViewById(R.id.b9w)).setVisibility(8);
            ((TextView) findViewById(R.id.b9x)).setVisibility(0);
            ((TextView) findViewById(R.id.b9x)).setText(stringExtra4);
        } else if (i >= 0) {
            ab.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", Boolean.valueOf((this.uLq & 1) > 0), Integer.valueOf(this.fOZ));
            if ((this.fOZ == 1 && this.uLp >= i2) || (this.fOZ == 2 && this.uLp >= i3)) {
                this.uLe = true;
                ((TextView) findViewById(R.id.b9x)).setVisibility(8);
                ((CheckBox) findViewById(R.id.b9w)).setVisibility(0);
                ((CheckBox) findViewById(R.id.b9w)).setText(R.string.fzv);
                if (r1) {
                    aw.ZK();
                }
                ((CheckBox) findViewById(R.id.b9w)).setChecked(false);
                ((ImageView) findViewById(R.id.b9t)).setImageResource(R.raw.connect_icon_help);
                ((ImageView) findViewById(R.id.b9t)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26521);
                        Intent intent = new Intent();
                        intent.putExtra("title", ExtDeviceWXLoginUI.this.getString(R.string.fzv));
                        intent.putExtra("rawUrl", ExtDeviceWXLoginUI.this.getString(R.string.g7c, new Object[]{aa.dor()}));
                        intent.putExtra("showShare", false);
                        intent.putExtra("neverGetA8Key", true);
                        d.b(ExtDeviceWXLoginUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(26521);
                    }
                });
            }
        }
        ImageView imageView = (ImageView) findViewById(R.id.b9u);
        if (this.fOZ != 1) {
            if (this.fOZ == 2) {
                imageView.setImageResource(R.raw.connect_mac);
            } else if (this.fOZ == 3) {
                imageView.setImageResource(R.raw.connect_ipad);
            } else if (this.fOZ == 5) {
                imageView.setImageResource(R.raw.connect_wx_album);
            }
            this.uLt = (TextView) findViewById(R.id.b9z);
            this.uLt.setText(stringExtra3);
            this.uLt.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(26522);
                    ExtDeviceWXLoginUI.a(ExtDeviceWXLoginUI.this);
                    AppMethodBeat.o(26522);
                }
            });
            this.uLs = (Button) findViewById(R.id.b9y);
            if (bo.isNullOrNil(stringExtra2)) {
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
            this.uLs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(26523);
                    if (ExtDeviceWXLoginUI.this.type != 0) {
                        if (ExtDeviceWXLoginUI.this.type == -2) {
                            Intent intent = new Intent();
                            intent.putExtra("BaseScanUI_select_scan_mode", 1);
                            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                            intent.putExtra("from_album", false);
                            intent.putExtra("show_intro", false);
                            intent.setFlags(65536);
                            d.b(ExtDeviceWXLoginUI.this, "scanner", ".ui.BaseScanUI", intent);
                            ExtDeviceWXLoginUI.this.finish();
                        }
                        AppMethodBeat.o(26523);
                    } else if (ExtDeviceWXLoginUI.this.uLe) {
                        boolean z;
                        boolean isChecked = ((CheckBox) ExtDeviceWXLoginUI.this.findViewById(R.id.b9w)).isChecked();
                        ExtDeviceWXLoginUI.this.cFv = false;
                        if (isChecked) {
                            aw.ZK();
                            c.Ry().set(ac.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.TRUE);
                        } else {
                            aw.ZK();
                            if (((Boolean) c.Ry().get(ac.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                                ExtDeviceWXLoginUI.this.cFv = true;
                            }
                            aw.ZK();
                            c.Ry().set(ac.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.FALSE);
                        }
                        ExtDeviceWXLoginUI extDeviceWXLoginUI = ExtDeviceWXLoginUI.this;
                        if (ExtDeviceWXLoginUI.this.uLe && isChecked) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ExtDeviceWXLoginUI.b(extDeviceWXLoginUI, z);
                        AppMethodBeat.o(26523);
                    } else {
                        ExtDeviceWXLoginUI.b(ExtDeviceWXLoginUI.this, false);
                        AppMethodBeat.o(26523);
                    }
                }
            });
            this.mController.contentView.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26524);
                    ExtDeviceWXLoginUI.d(ExtDeviceWXLoginUI.this);
                    AppMethodBeat.o(26524);
                }
            });
            ((TextView) findViewById(R.id.b9s)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(26525);
                    ExtDeviceWXLoginUI.this.finish();
                    AppMethodBeat.o(26525);
                }
            });
            aw.Rg().a(972, (f) this);
            aw.Rg().a(973, (f) this);
            AppMethodBeat.o(26530);
        }
        imageView.setImageResource(R.raw.connect_pc);
        this.uLt = (TextView) findViewById(R.id.b9z);
        this.uLt.setText(stringExtra3);
        this.uLt.setOnClickListener(/* anonymous class already generated */);
        this.uLs = (Button) findViewById(R.id.b9y);
        if (bo.isNullOrNil(stringExtra2)) {
        }
        this.uLs.setOnClickListener(/* anonymous class already generated */);
        this.mController.contentView.post(/* anonymous class already generated */);
        ((TextView) findViewById(R.id.b9s)).setOnClickListener(/* anonymous class already generated */);
        aw.Rg().a(972, (f) this);
        aw.Rg().a(973, (f) this);
        AppMethodBeat.o(26530);
    }

    public void onPause() {
        AppMethodBeat.i(26531);
        super.onPause();
        if (this.uLr && aw.RK()) {
            act act = new act();
            act.wkw = 27;
            act.pvD = r.ku(r.YF()) ? 1 : 2;
            aw.ZK();
            c.XL().c(new j.a(23, act));
            this.uLr = false;
        }
        AppMethodBeat.o(26531);
    }

    public final int getLayoutId() {
        return R.layout.se;
    }

    public void finish() {
        AppMethodBeat.i(26532);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.ce);
        AppMethodBeat.o(26532);
    }

    public void onDestroy() {
        AppMethodBeat.i(26533);
        super.onDestroy();
        aw.Rg().b(972, (f) this);
        aw.Rg().b(973, (f) this);
        AppMethodBeat.o(26533);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26534);
        if (this.nEK != null) {
            this.nEK.dismiss();
            this.nEK = null;
        }
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i2), Integer.valueOf(i));
            aw.Rg().b(972, (f) this);
            if (mVar.getType() == 972) {
                e eVar = (e) mVar;
                if (eVar.uLe || this.cFv) {
                    byte[] bArr;
                    zp zpVar = (zp) eVar.fAT.fsH.fsP;
                    if (zpVar == null || zpVar.weU == null) {
                        bArr = null;
                    } else {
                        bArr = zpVar.weU.toByteArray();
                    }
                    kb kbVar = new kb();
                    kbVar.cFs.cFt = bArr;
                    kbVar.cFs.cFu = this.fOZ;
                    kbVar.cFs.cFv = this.cFv;
                    com.tencent.mm.sdk.b.a.xxA.m(kbVar);
                }
            } else {
                mVar.getType();
            }
            this.type = 0;
            finish();
            AppMethodBeat.o(26534);
            return;
        }
        if (i2 == -1) {
            this.type = -1;
        } else if (i2 == -2) {
            this.type = -2;
        }
        if (!bo.isNullOrNil(str)) {
            ((CheckBox) findViewById(R.id.b9w)).setVisibility(8);
            ((TextView) findViewById(R.id.b9x)).setVisibility(0);
            ((TextView) findViewById(R.id.b9x)).setText(str);
        }
        if (this.type == -1) {
            if (this.uLs != null) {
                this.uLs.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.uLs != null) {
                this.uLs.setEnabled(true);
                this.uLs.setText(R.string.fzz);
            }
            if (this.uLt != null) {
                this.uLt.setVisibility(4);
            }
        }
        ab.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.o(26534);
    }

    static /* synthetic */ boolean a(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        AppMethodBeat.i(26535);
        final m cVar = new com.tencent.mm.plugin.webwx.a.c(extDeviceWXLoginUI.cLY);
        aw.Rg().a(cVar, 0);
        extDeviceWXLoginUI.nEK = h.b(extDeviceWXLoginUI.mController.ylL, extDeviceWXLoginUI.getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26527);
                aw.Rg().c(cVar);
                if (ExtDeviceWXLoginUI.this.nEK != null) {
                    ExtDeviceWXLoginUI.this.nEK.cancel();
                }
                AppMethodBeat.o(26527);
            }
        });
        AppMethodBeat.o(26535);
        return true;
    }

    static /* synthetic */ boolean b(ExtDeviceWXLoginUI extDeviceWXLoginUI, boolean z) {
        AppMethodBeat.i(26536);
        final m eVar = new e(extDeviceWXLoginUI.cLY, extDeviceWXLoginUI.uLo, z);
        aw.Rg().a(eVar, 0);
        extDeviceWXLoginUI.nEK = h.b(extDeviceWXLoginUI.mController.ylL, extDeviceWXLoginUI.getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26526);
                aw.Rg().c(eVar);
                if (ExtDeviceWXLoginUI.this.nEK != null) {
                    ExtDeviceWXLoginUI.this.nEK.cancel();
                }
                AppMethodBeat.o(26526);
            }
        });
        AppMethodBeat.o(26536);
        return true;
    }

    static /* synthetic */ void d(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        AppMethodBeat.i(26537);
        int[] iArr = new int[2];
        View findViewById = extDeviceWXLoginUI.findViewById(R.id.b9r);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        ab.i("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height));
        extDeviceWXLoginUI.findViewById(R.id.b9u).setPadding(0, (((int) (((double) r1) / 4.0d)) - i) - height, 0, 0);
        AppMethodBeat.o(26537);
    }
}
