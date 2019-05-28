package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class n {
    boolean gwZ = true;
    Runnable ykE;

    public final boolean ao(Activity activity) {
        AppMethodBeat.i(29512);
        if (this.gwZ) {
            ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")));
            if (b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")) {
                ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(b.a(activity, "android.permission.READ_PHONE_STATE", 97, "", "")));
                if (!b.a(activity, "android.permission.READ_PHONE_STATE", 97, "", "")) {
                    AppMethodBeat.o(29512);
                    return false;
                }
            }
            AppMethodBeat.o(29512);
            return false;
        }
        AppMethodBeat.o(29512);
        return true;
    }

    public final boolean c(Activity activity, Runnable runnable) {
        AppMethodBeat.i(29513);
        ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")));
        if (b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")) {
            ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(b.a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")));
            if (b.a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")) {
                ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - LauncherUI.yjH));
                g.jG(LauncherUI.yjH);
                AppMethodBeat.o(29513);
                return true;
            }
            this.ykE = runnable;
            AppMethodBeat.o(29513);
            return false;
        }
        this.ykE = runnable;
        AppMethodBeat.o(29513);
        return false;
    }

    public final boolean a(final Activity activity, final int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(29514);
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.LauncherUI.LauncherUICheckPermissionHelper";
            String str2 = "onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bo.dpG();
            ab.w(str, str2, objArr);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29506);
                    if (n.this.ykE != null) {
                        n.this.ykE.run();
                    }
                    AppMethodBeat.o(29506);
                }

                public final String toString() {
                    AppMethodBeat.i(29507);
                    String str = super.toString() + "|onInitDelay";
                    AppMethodBeat.o(29507);
                    return str;
                }
            }, 500);
            AppMethodBeat.o(29514);
            return true;
        }
        ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        int i2;
        switch (i) {
            case 32:
            case 64:
            case 96:
                i2 = R.string.dc6;
                if (i == 96) {
                    i2 = R.string.dc1;
                } else if (i == 64) {
                    i2 = R.string.dby;
                }
                if (iArr[0] == 0) {
                    if (i == 32) {
                        e.pXa.a(462, 0, 1, true);
                    } else if (i == 96) {
                        e.pXa.a(462, 1, 1, true);
                        q.bH(true);
                    } else {
                        e.pXa.a(462, 2, 1, true);
                    }
                    if (this.ykE != null) {
                        this.ykE.run();
                    }
                } else {
                    h.a((Context) activity, activity.getString(i2), activity.getString(R.string.dc8), activity.getString(R.string.ckr), activity.getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29508);
                            if (i == 32) {
                                e.pXa.a(462, 3, 1, true);
                            } else if (i == 96) {
                                e.pXa.a(462, 4, 1, true);
                            } else {
                                e.pXa.a(462, 5, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(268435456);
                            activity.startActivity(intent);
                            dialogInterface.dismiss();
                            MMAppMgr.bd(activity);
                            activity.finish();
                            AppMethodBeat.o(29508);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29509);
                            if (i == 32) {
                                e.pXa.a(462, 6, 1, true);
                            } else if (i == 96) {
                                e.pXa.a(462, 7, 1, true);
                            } else {
                                e.pXa.a(462, 8, 1, true);
                            }
                            dialogInterface.dismiss();
                            MMAppMgr.bd(activity);
                            activity.finish();
                            AppMethodBeat.o(29509);
                        }
                    });
                }
                AppMethodBeat.o(29514);
                return true;
            case 33:
            case 70:
            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                i2 = R.string.dc6;
                if (i == 97) {
                    i2 = R.string.dc1;
                } else if (i == 70) {
                    i2 = R.string.dby;
                }
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    h.a((Context) activity, activity.getString(i2), activity.getString(R.string.dc8), activity.getString(R.string.ckr), activity.getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29510);
                            if (i == 33) {
                                e.pXa.a(462, 12, 1, true);
                            } else if (i == 97) {
                                e.pXa.a(462, 13, 1, true);
                            } else {
                                e.pXa.a(462, 14, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(268435456);
                            activity.startActivity(intent);
                            dialogInterface.dismiss();
                            n.this.gwZ = true;
                            MMAppMgr.bd(activity);
                            activity.finish();
                            AppMethodBeat.o(29510);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29511);
                            if (i == 33) {
                                e.pXa.a(462, 15, 1, true);
                            } else if (i == 97) {
                                e.pXa.a(462, 16, 1, true);
                            } else {
                                e.pXa.a(462, 17, 1, true);
                            }
                            dialogInterface.dismiss();
                            n.this.gwZ = true;
                            MMAppMgr.bd(activity);
                            activity.finish();
                            AppMethodBeat.o(29511);
                        }
                    });
                } else if (i == 33) {
                    e.pXa.a(462, 9, 1, true);
                } else if (i == 97) {
                    e.pXa.a(462, 10, 1, true);
                } else {
                    e.pXa.a(462, 11, 1, true);
                }
                AppMethodBeat.o(29514);
                return true;
            default:
                AppMethodBeat.o(29514);
                return false;
        }
    }
}
