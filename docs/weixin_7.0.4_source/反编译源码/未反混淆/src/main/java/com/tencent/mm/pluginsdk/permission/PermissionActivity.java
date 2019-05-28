package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public class PermissionActivity extends AppCompatActivity {
    private Intent intent;
    private String key;
    private int requestCode;
    private int scene;
    private String[] vdl;
    private boolean vdm;
    private String vdn;
    private String vdo;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79431);
        super.onCreate(bundle);
        if (getIntent() == null || !getIntent().hasExtra("scene")) {
            finish();
            AppMethodBeat.o(79431);
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
            if (!bo.Q(this.vdl)) {
                ab.i("MicroMsg.PermissionActivity", "scene: %d, permission: %s, requestCode: %d", Integer.valueOf(this.scene), this.vdl.toString(), Integer.valueOf(this.requestCode));
                AppMethodBeat.o(79431);
                return;
            }
        } else if (this.scene == 2) {
            this.intent = getIntent().getSelector();
            this.vdn = getIntent().getStringExtra("reasonTitle");
            this.vdo = getIntent().getStringExtra("reasonMsg");
            if (!(bo.isNullOrNil(this.vdn) || bo.isNullOrNil(this.vdo))) {
                ab.i("MicroMsg.PermissionActivity", "scene: %d, reasonTitle: %s, reasonMsg: %s", Integer.valueOf(this.scene), this.vdn, this.vdo);
                AppMethodBeat.o(79431);
                return;
            }
        } else if (this.scene == 3) {
            this.intent = getIntent().getSelector();
            if (this.intent != null) {
                ab.i("MicroMsg.PermissionActivity", "scene: %d, intent: %s", Integer.valueOf(this.scene), this.intent.toString());
                AppMethodBeat.o(79431);
                return;
            }
        } else if (this.scene == 4) {
            ab.i("MicroMsg.PermissionActivity", "scene: %d", Integer.valueOf(this.scene));
        }
        AppMethodBeat.o(79431);
    }

    public void onResume() {
        AppMethodBeat.i(79432);
        ab.i("MicroMsg.PermissionActivity", "onResume(), scene=%d", Integer.valueOf(this.scene));
        super.onResume();
        if (this.vdm) {
            if (this.scene == 1) {
                b.a(this, this.vdl, this.requestCode);
            } else if (this.scene == 2) {
                if (bo.isNullOrNil(this.vdo) && bo.isNullOrNil(this.vdn)) {
                    try {
                        startActivityForResult(this.intent, 1);
                    } catch (Exception e) {
                        ab.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(this.scene), e.getMessage());
                    }
                } else {
                    h.a((Context) this, false, this.vdo, this.vdn, getString(R.string.ckr), getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(79427);
                            try {
                                ab.i("MicroMsg.PermissionActivity", "START_SETTINGS_REQUEST click ok");
                                PermissionActivity.this.startActivityForResult(PermissionActivity.this.intent, 1);
                                AppMethodBeat.o(79427);
                            } catch (Exception e) {
                                ab.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(PermissionActivity.this.scene), e.getMessage());
                                AppMethodBeat.o(79427);
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(79428);
                            PermissionActivity.this.finish();
                            AppMethodBeat.o(79428);
                        }
                    });
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
                        ab.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(this.scene), e2.getMessage());
                    }
                }
            } else if (this.scene == 4) {
                if (as.amF("service_launch_way").getBoolean("954_95_first", true)) {
                    e.pXa.a(954, 95, 1, false);
                    as.amF("service_launch_way").edit().putBoolean("954_95_first", false);
                }
                e.pXa.a(954, 96, 1, false);
                h.a((Context) this, false, getString(R.string.dbx), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(79429);
                        ab.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations ");
                        PermissionActivity.c(PermissionActivity.this);
                        AppMethodBeat.o(79429);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(79430);
                        ab.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations app_cancel");
                        PermissionActivity.this.finish();
                        AppMethodBeat.o(79430);
                    }
                });
            }
            this.vdm = false;
            AppMethodBeat.o(79432);
            return;
        }
        this.vdm = true;
        AppMethodBeat.o(79432);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(79433);
        ab.i("MicroMsg.PermissionActivity", "onRequestPermissionsResult(),  scene=%d, requestCode=%d, permissions=%s, grantResults=%s", Integer.valueOf(this.scene), Integer.valueOf(i), strArr.toString(), iArr.toString());
        if (this.scene == 1) {
            c aiT = b.aiT(this.key);
            if (aiT != null) {
                aiT.r(iArr);
            }
        }
        finish();
        AppMethodBeat.o(79433);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(79434);
        ab.i("MicroMsg.PermissionActivity", "onActivityResult(),  scene=%d, requestCode=%d, resultCode=%d", Integer.valueOf(this.scene), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.scene == 2) {
            d aiU = b.aiU(this.key);
            if (aiU != null) {
                aiU.Cp(i2);
            }
            finish();
            AppMethodBeat.o(79434);
        } else if (this.scene == 3) {
            if (i2 == -1) {
                startActivity(this.intent);
            } else {
                Toast.makeText(ah.getContext(), R.string.d7j, 1).show();
            }
            finish();
            AppMethodBeat.o(79434);
        } else {
            if (this.scene == 4) {
                if (VERSION.SDK_INT >= 23) {
                    if (c.bn(this)) {
                        if (as.amF("service_launch_way").getBoolean("954_84_first", true)) {
                            e.pXa.a(954, 84, 1, false);
                            as.amF("service_launch_way").edit().putBoolean("954_84_first", false);
                        }
                        c.bu(true);
                    }
                    ab.i("MicroMsg.PermissionActivity", "onActivityResult ADD_IGNORING_BATTERY_OPTIMIZATIONS result=%s", Boolean.valueOf(r0));
                }
                AppMethodBeat.o(79434);
            }
            finish();
            AppMethodBeat.o(79434);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(79435);
        ab.i("MicroMsg.PermissionActivity", "onDestroy(), scene=%d", Integer.valueOf(this.scene));
        if (this.scene == 1) {
            b.aiT(this.key);
        } else if (this.scene == 2) {
            b.aiU(this.key);
        }
        super.onDestroy();
        AppMethodBeat.o(79435);
    }

    static /* synthetic */ void c(PermissionActivity permissionActivity) {
        AppMethodBeat.i(79436);
        ab.i("MicroMsg.PermissionActivity", "goIgnoreBatteryOptimizations()");
        try {
            permissionActivity.startActivityForResult(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + permissionActivity.getPackageName())), 1);
            if (as.amF("service_launch_way").getBoolean("954_93_first", true)) {
                e.pXa.a(954, 93, 1, false);
                as.amF("service_launch_way").edit().putBoolean("954_93_first", false);
            }
            e.pXa.a(954, 94, 1, false);
            AppMethodBeat.o(79436);
        } catch (Exception e) {
            ab.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", Integer.valueOf(permissionActivity.scene), e.getMessage());
            AppMethodBeat.o(79436);
        }
    }
}
