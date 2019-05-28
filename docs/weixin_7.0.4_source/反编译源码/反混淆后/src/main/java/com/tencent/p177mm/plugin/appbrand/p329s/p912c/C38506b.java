package com.tencent.p177mm.plugin.appbrand.p329s.p912c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings.Secure;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.appbrand.p329s.p912c.C45683a.C10726a;
import com.tencent.p177mm.plugin.appbrand.p329s.p912c.C45683a.C33524b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.s.c.b */
final class C38506b extends C10726a {
    private final Map<String, C33524b> iSi = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.s.c.b$1 */
    class C107271 extends C33524b {
        C107271() {
        }

        /* Access modifiers changed, original: protected|final */
        public final Intent aOg() {
            AppMethodBeat.m2504i(133601);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
            intent.putExtra("extra_pkgname", C4996ah.getPackageName());
            AppMethodBeat.m2505o(133601);
            return intent;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.c.b$3 */
    class C107283 extends C33524b {
        C107283() {
        }

        /* Access modifiers changed, original: protected|final */
        public final Intent aOg() {
            AppMethodBeat.m2504i(133603);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.installshortcut.PurviewActivity"));
            AppMethodBeat.m2505o(133603);
            return intent;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.c.b$2 */
    class C272882 extends C33524b {
        C272882() {
        }

        /* Access modifiers changed, original: protected|final */
        public final Intent aOg() {
            AppMethodBeat.m2504i(133602);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
            intent.setAction("coloros.intent.action.launcher.SHORTCUT_SETTINGS");
            AppMethodBeat.m2505o(133602);
            return intent;
        }
    }

    C38506b() {
        AppMethodBeat.m2504i(133604);
        this.iSi.put("xiaomi", new C107271());
        this.iSi.put("oppo", new C272882());
        this.iSi.put("vivo", new C107283());
        AppMethodBeat.m2505o(133604);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int aOd() {
        int i;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.m2504i(133605);
        Context context = C4996ah.getContext();
        String manufacturer = C38506b.getManufacturer();
        C4990ab.m7417i("MicroMsg.AppPermissionSettingAdapterFactory", "manufacturer = %s", manufacturer);
        switch (manufacturer.hashCode()) {
            case -1206476313:
                if (manufacturer.equals("huawei")) {
                    i = 1;
                    break;
                }
            case -759499589:
                if (manufacturer.equals("xiaomi")) {
                    i = 2;
                    break;
                }
            case 3418016:
                if (manufacturer.equals("oppo")) {
                    i = 3;
                    break;
                }
            case 3620012:
                if (manufacturer.equals("vivo")) {
                    i = 4;
                    break;
                }
            case 99462250:
                if (manufacturer.equals("honor")) {
                    i = 0;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
            case 1:
                AppMethodBeat.m2505o(133605);
                return -1;
            case 2:
                AppMethodBeat.m2505o(133605);
                return -1;
            case 3:
                try {
                    String[] split;
                    manufacturer = Secure.getString(context.getContentResolver(), "launcher_shortcut_permission_settings");
                    for (String str : String.valueOf(manufacturer.subSequence(1, manufacturer.length() - 1)).split("/")) {
                        if (str.startsWith(context.getPackageName())) {
                            split = str.split(",");
                            if (split != null) {
                                AppMethodBeat.m2505o(133605);
                                return -1;
                            } else if (Integer.valueOf(split[1].trim()).intValue() == 1) {
                                AppMethodBeat.m2505o(133605);
                                return 0;
                            } else {
                                AppMethodBeat.m2505o(133605);
                                return 1;
                            }
                        }
                    }
                    if (split != null) {
                    }
                } catch (Exception e2) {
                    AppMethodBeat.m2505o(133605);
                    return -1;
                }
            case 4:
                Cursor query;
                try {
                    query = context.getContentResolver().query(Uri.parse("content://com.bbk.launcher2.settings/favorites?notify=false"), new String[]{"intent", "shortcutPermission"}, "intent" + " LIKE '" + new ComponentName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI").flattenToString() + "%'", null, null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(133605);
                        return -1;
                    }
                    try {
                        i = query.getColumnIndex(r10);
                        query.moveToFirst();
                        i = query.getInt(i);
                        C4990ab.m7416i("MicroMsg.AppPermissionSettingAdapterFactory", "vivo statues on vivo = ".concat(String.valueOf(i)));
                        if (i == 16) {
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(133605);
                            return 0;
                        }
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(133605);
                        return 1;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            C4990ab.m7420w("MicroMsg.AppPermissionSettingAdapterFactory", "[checkPermissionStatus] vivooccur exception return unknown status : \n" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(133605);
                            return -1;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null) {
                            }
                            AppMethodBeat.m2505o(133605);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    query = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.m2505o(133605);
                    throw th;
                }
            default:
                AppMethodBeat.m2505o(133605);
                return -1;
        }
    }

    /* renamed from: dc */
    public final void mo22280dc(Context context) {
        AppMethodBeat.m2504i(133606);
        C4990ab.m7417i("MicroMsg.AppPermissionSettingAdapterFactory", "[jumpPermissionSettingPage] manufacturer = %s", C1427q.m3045bB(context).toLowerCase());
        C33524b c33524b = (C33524b) this.iSi.get(r0);
        if (c33524b != null) {
            c33524b.mo54001dd(context);
        }
        AppMethodBeat.m2505o(133606);
    }

    public final boolean aOe() {
        AppMethodBeat.m2504i(133607);
        String manufacturer = C38506b.getManufacturer();
        C4990ab.m7417i("MicroMsg.AppPermissionSettingAdapterFactory", "[canJumpSettingPage] manufacturer = %s", manufacturer);
        C33524b c33524b = (C33524b) this.iSi.get(manufacturer);
        if (this.iSi.containsKey(manufacturer) && c33524b.aOf()) {
            AppMethodBeat.m2505o(133607);
            return true;
        }
        AppMethodBeat.m2505o(133607);
        return false;
    }

    private static String getManufacturer() {
        AppMethodBeat.m2504i(133608);
        String toLowerCase = C1427q.m3045bB(C4996ah.getContext()).toLowerCase();
        AppMethodBeat.m2505o(133608);
        return toLowerCase;
    }
}
