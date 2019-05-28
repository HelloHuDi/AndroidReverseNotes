package com.tencent.p177mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C45270c;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.permission.PermissionActivity */
public class PermissionActivity extends AppCompatActivity {
    private Intent intent;
    private String key;
    private int requestCode;
    private int scene;
    private String[] vdl;
    private boolean vdm;
    private String vdn;
    private String vdo;

    /* renamed from: com.tencent.mm.pluginsdk.permission.PermissionActivity$2 */
    class C148992 implements OnClickListener {
        C148992() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79428);
            PermissionActivity.this.finish();
            AppMethodBeat.m2505o(79428);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.permission.PermissionActivity$1 */
    class C300901 implements OnClickListener {
        C300901() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79427);
            try {
                C4990ab.m7416i("MicroMsg.PermissionActivity", "START_SETTINGS_REQUEST click ok");
                PermissionActivity.this.startActivityForResult(PermissionActivity.this.intent, 1);
                AppMethodBeat.m2505o(79427);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(PermissionActivity.this.scene), e.getMessage());
                AppMethodBeat.m2505o(79427);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.permission.PermissionActivity$4 */
    class C404474 implements OnClickListener {
        C404474() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79430);
            C4990ab.m7416i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations app_cancel");
            PermissionActivity.this.finish();
            AppMethodBeat.m2505o(79430);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.permission.PermissionActivity$3 */
    class C440693 implements OnClickListener {
        C440693() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(79429);
            C4990ab.m7416i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations ");
            PermissionActivity.m79214c(PermissionActivity.this);
            AppMethodBeat.m2505o(79429);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(79431);
        super.onCreate(bundle);
        if (getIntent() == null || !getIntent().hasExtra("scene")) {
            finish();
            AppMethodBeat.m2505o(79431);
            return;
        }
        getWindow().addFlags(67108864);
        Window window = getWindow();
        window.setGravity(51);
        LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        this.vdm = true;
        this.scene = getIntent().getIntExtra("scene", 1);
        this.key = getIntent().getStringExtra("key");
        if (this.scene == 1) {
            this.vdl = getIntent().getStringArrayExtra("permission");
            this.requestCode = getIntent().getIntExtra("requestCode", 0);
            if (!C5046bo.m7510Q(this.vdl)) {
                C4990ab.m7417i("MicroMsg.PermissionActivity", "scene: %d, permission: %s, requestCode: %d", Integer.valueOf(this.scene), this.vdl.toString(), Integer.valueOf(this.requestCode));
                AppMethodBeat.m2505o(79431);
                return;
            }
        } else if (this.scene == 2) {
            this.intent = getIntent().getSelector();
            this.vdn = getIntent().getStringExtra("reasonTitle");
            this.vdo = getIntent().getStringExtra("reasonMsg");
            if (!(C5046bo.isNullOrNil(this.vdn) || C5046bo.isNullOrNil(this.vdo))) {
                C4990ab.m7417i("MicroMsg.PermissionActivity", "scene: %d, reasonTitle: %s, reasonMsg: %s", Integer.valueOf(this.scene), this.vdn, this.vdo);
                AppMethodBeat.m2505o(79431);
                return;
            }
        } else if (this.scene == 3) {
            this.intent = getIntent().getSelector();
            if (this.intent != null) {
                C4990ab.m7417i("MicroMsg.PermissionActivity", "scene: %d, intent: %s", Integer.valueOf(this.scene), this.intent.toString());
                AppMethodBeat.m2505o(79431);
                return;
            }
        } else if (this.scene == 4) {
            C4990ab.m7417i("MicroMsg.PermissionActivity", "scene: %d", Integer.valueOf(this.scene));
        }
        AppMethodBeat.m2505o(79431);
    }

    public void onResume() {
        AppMethodBeat.m2504i(79432);
        C4990ab.m7417i("MicroMsg.PermissionActivity", "onResume(), scene=%d", Integer.valueOf(this.scene));
        super.onResume();
        if (this.vdm) {
            if (this.scene == 1) {
                C35805b.m58703a(this, this.vdl, this.requestCode);
            } else if (this.scene == 2) {
                if (C5046bo.isNullOrNil(this.vdo) && C5046bo.isNullOrNil(this.vdn)) {
                    try {
                        startActivityForResult(this.intent, 1);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(this.scene), e.getMessage());
                    }
                } else {
                    C30379h.m48453a((Context) this, false, this.vdo, this.vdn, getString(C25738R.string.ckr), getString(C25738R.string.f9076or), new C300901(), new C148992());
                }
            } else if (this.scene == 3) {
                if (VERSION.SDK_INT < 26) {
                    startActivity(this.intent);
                } else if (getPackageManager().canRequestPackageInstalls()) {
                    startActivity(this.intent);
                } else {
                    try {
                        startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 1);
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(this.scene), e2.getMessage());
                    }
                }
            } else if (this.scene == 4) {
                if (C5018as.amF("service_launch_way").getBoolean("954_95_first", true)) {
                    C7053e.pXa.mo8378a(954, 95, 1, false);
                    C5018as.amF("service_launch_way").edit().putBoolean("954_95_first", false);
                }
                C7053e.pXa.mo8378a(954, 96, 1, false);
                C30379h.m48453a((Context) this, false, getString(C25738R.string.dbx), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), new C440693(), new C404474());
            }
            this.vdm = false;
            AppMethodBeat.m2505o(79432);
            return;
        }
        this.vdm = true;
        AppMethodBeat.m2505o(79432);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(79433);
        C4990ab.m7417i("MicroMsg.PermissionActivity", "onRequestPermissionsResult(),  scene=%d, requestCode=%d, permissions=%s, grantResults=%s", Integer.valueOf(this.scene), Integer.valueOf(i), strArr.toString(), iArr.toString());
        if (this.scene == 1) {
            C35807c aiT = C35805b.aiT(this.key);
            if (aiT != null) {
                aiT.mo54547r(iArr);
            }
        }
        finish();
        AppMethodBeat.m2505o(79433);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(79434);
        C4990ab.m7417i("MicroMsg.PermissionActivity", "onActivityResult(),  scene=%d, requestCode=%d, resultCode=%d", Integer.valueOf(this.scene), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.scene == 2) {
            C35808d aiU = C35805b.aiU(this.key);
            if (aiU != null) {
                aiU.mo8477Cp(i2);
            }
            finish();
            AppMethodBeat.m2505o(79434);
        } else if (this.scene == 3) {
            if (i2 == -1) {
                startActivity(this.intent);
            } else {
                Toast.makeText(C4996ah.getContext(), C25738R.string.d7j, 1).show();
            }
            finish();
            AppMethodBeat.m2505o(79434);
        } else {
            if (this.scene == 4) {
                if (VERSION.SDK_INT >= 23) {
                    if (C45270c.m83435bn(this)) {
                        if (C5018as.amF("service_launch_way").getBoolean("954_84_first", true)) {
                            C7053e.pXa.mo8378a(954, 84, 1, false);
                            C5018as.amF("service_launch_way").edit().putBoolean("954_84_first", false);
                        }
                        C45270c.m83436bu(true);
                    }
                    C4990ab.m7417i("MicroMsg.PermissionActivity", "onActivityResult ADD_IGNORING_BATTERY_OPTIMIZATIONS result=%s", Boolean.valueOf(r0));
                }
                AppMethodBeat.m2505o(79434);
            }
            finish();
            AppMethodBeat.m2505o(79434);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(79435);
        C4990ab.m7417i("MicroMsg.PermissionActivity", "onDestroy(), scene=%d", Integer.valueOf(this.scene));
        if (this.scene == 1) {
            C35805b.aiT(this.key);
        } else if (this.scene == 2) {
            C35805b.aiU(this.key);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(79435);
    }

    /* renamed from: c */
    static /* synthetic */ void m79214c(PermissionActivity permissionActivity) {
        AppMethodBeat.m2504i(79436);
        C4990ab.m7416i("MicroMsg.PermissionActivity", "goIgnoreBatteryOptimizations()");
        try {
            permissionActivity.startActivityForResult(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + permissionActivity.getPackageName())), 1);
            if (C5018as.amF("service_launch_way").getBoolean("954_93_first", true)) {
                C7053e.pXa.mo8378a(954, 93, 1, false);
                C5018as.amF("service_launch_way").edit().putBoolean("954_93_first", false);
            }
            C7053e.pXa.mo8378a(954, 94, 1, false);
            AppMethodBeat.m2505o(79436);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(permissionActivity.scene), e.getMessage());
            AppMethodBeat.m2505o(79436);
        }
    }
}
