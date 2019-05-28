package com.tencent.p177mm.p612ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;

/* renamed from: com.tencent.mm.ui.n */
public final class C44376n {
    boolean gwZ = true;
    Runnable ykE;

    /* renamed from: com.tencent.mm.ui.n$1 */
    class C307221 implements Runnable {
        C307221() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29506);
            if (C44376n.this.ykE != null) {
                C44376n.this.ykE.run();
            }
            AppMethodBeat.m2505o(29506);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29507);
            String str = super.toString() + "|onInitDelay";
            AppMethodBeat.m2505o(29507);
            return str;
        }
    }

    /* renamed from: ao */
    public final boolean mo70240ao(Activity activity) {
        AppMethodBeat.m2504i(29512);
        if (this.gwZ) {
            C4990ab.m7417i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(C35805b.m58707a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")));
            if (C35805b.m58707a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")) {
                C4990ab.m7417i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(C35805b.m58707a(activity, "android.permission.READ_PHONE_STATE", 97, "", "")));
                if (!C35805b.m58707a(activity, "android.permission.READ_PHONE_STATE", 97, "", "")) {
                    AppMethodBeat.m2505o(29512);
                    return false;
                }
            }
            AppMethodBeat.m2505o(29512);
            return false;
        }
        AppMethodBeat.m2505o(29512);
        return true;
    }

    /* renamed from: c */
    public final boolean mo70241c(Activity activity, Runnable runnable) {
        AppMethodBeat.m2504i(29513);
        C4990ab.m7417i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(C35805b.m58707a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")));
        if (C35805b.m58707a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")) {
            C4990ab.m7417i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(C35805b.m58707a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")));
            if (C35805b.m58707a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")) {
                C4990ab.m7416i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - LauncherUI.yjH));
                C34830g.m57199jG(LauncherUI.yjH);
                AppMethodBeat.m2505o(29513);
                return true;
            }
            this.ykE = runnable;
            AppMethodBeat.m2505o(29513);
            return false;
        }
        this.ykE = runnable;
        AppMethodBeat.m2505o(29513);
        return false;
    }

    /* renamed from: a */
    public final boolean mo70239a(final Activity activity, final int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(29514);
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.LauncherUI.LauncherUICheckPermissionHelper";
            String str2 = "onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = C5046bo.dpG();
            C4990ab.m7421w(str, str2, objArr);
            C5004al.m7442n(new C307221(), 500);
            AppMethodBeat.m2505o(29514);
            return true;
        }
        C4990ab.m7417i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        int i2;
        switch (i) {
            case 32:
            case 64:
            case 96:
                i2 = C25738R.string.dc6;
                if (i == 96) {
                    i2 = C25738R.string.dc1;
                } else if (i == 64) {
                    i2 = C25738R.string.dby;
                }
                if (iArr[0] == 0) {
                    if (i == 32) {
                        C7053e.pXa.mo8378a(462, 0, 1, true);
                    } else if (i == 96) {
                        C7053e.pXa.mo8378a(462, 1, 1, true);
                        C1427q.m3047bH(true);
                    } else {
                        C7053e.pXa.mo8378a(462, 2, 1, true);
                    }
                    if (this.ykE != null) {
                        this.ykE.run();
                    }
                } else {
                    C30379h.m48445a((Context) activity, activity.getString(i2), activity.getString(C25738R.string.dc8), activity.getString(C25738R.string.ckr), activity.getString(C25738R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(29508);
                            if (i == 32) {
                                C7053e.pXa.mo8378a(462, 3, 1, true);
                            } else if (i == 96) {
                                C7053e.pXa.mo8378a(462, 4, 1, true);
                            } else {
                                C7053e.pXa.mo8378a(462, 5, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(268435456);
                            activity.startActivity(intent);
                            dialogInterface.dismiss();
                            MMAppMgr.m7905bd(activity);
                            activity.finish();
                            AppMethodBeat.m2505o(29508);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(29509);
                            if (i == 32) {
                                C7053e.pXa.mo8378a(462, 6, 1, true);
                            } else if (i == 96) {
                                C7053e.pXa.mo8378a(462, 7, 1, true);
                            } else {
                                C7053e.pXa.mo8378a(462, 8, 1, true);
                            }
                            dialogInterface.dismiss();
                            MMAppMgr.m7905bd(activity);
                            activity.finish();
                            AppMethodBeat.m2505o(29509);
                        }
                    });
                }
                AppMethodBeat.m2505o(29514);
                return true;
            case 33:
            case 70:
            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                i2 = C25738R.string.dc6;
                if (i == 97) {
                    i2 = C25738R.string.dc1;
                } else if (i == 70) {
                    i2 = C25738R.string.dby;
                }
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    C30379h.m48445a((Context) activity, activity.getString(i2), activity.getString(C25738R.string.dc8), activity.getString(C25738R.string.ckr), activity.getString(C25738R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(29510);
                            if (i == 33) {
                                C7053e.pXa.mo8378a(462, 12, 1, true);
                            } else if (i == 97) {
                                C7053e.pXa.mo8378a(462, 13, 1, true);
                            } else {
                                C7053e.pXa.mo8378a(462, 14, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(268435456);
                            activity.startActivity(intent);
                            dialogInterface.dismiss();
                            C44376n.this.gwZ = true;
                            MMAppMgr.m7905bd(activity);
                            activity.finish();
                            AppMethodBeat.m2505o(29510);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(29511);
                            if (i == 33) {
                                C7053e.pXa.mo8378a(462, 15, 1, true);
                            } else if (i == 97) {
                                C7053e.pXa.mo8378a(462, 16, 1, true);
                            } else {
                                C7053e.pXa.mo8378a(462, 17, 1, true);
                            }
                            dialogInterface.dismiss();
                            C44376n.this.gwZ = true;
                            MMAppMgr.m7905bd(activity);
                            activity.finish();
                            AppMethodBeat.m2505o(29511);
                        }
                    });
                } else if (i == 33) {
                    C7053e.pXa.mo8378a(462, 9, 1, true);
                } else if (i == 97) {
                    C7053e.pXa.mo8378a(462, 10, 1, true);
                } else {
                    C7053e.pXa.mo8378a(462, 11, 1, true);
                }
                AppMethodBeat.m2505o(29514);
                return true;
            default:
                AppMethodBeat.m2505o(29514);
                return false;
        }
    }
}
