package com.tencent.mm.plugin.appbrand.s.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings.Secure;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.s.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

final class b extends a {
    private final Map<String, b> iSi = new HashMap();

    b() {
        AppMethodBeat.i(133604);
        this.iSi.put("xiaomi", new b() {
            /* Access modifiers changed, original: protected|final */
            public final Intent aOg() {
                AppMethodBeat.i(133601);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
                intent.putExtra("extra_pkgname", ah.getPackageName());
                AppMethodBeat.o(133601);
                return intent;
            }
        });
        this.iSi.put("oppo", new b() {
            /* Access modifiers changed, original: protected|final */
            public final Intent aOg() {
                AppMethodBeat.i(133602);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                intent.setAction("coloros.intent.action.launcher.SHORTCUT_SETTINGS");
                AppMethodBeat.o(133602);
                return intent;
            }
        });
        this.iSi.put("vivo", new b() {
            /* Access modifiers changed, original: protected|final */
            public final Intent aOg() {
                AppMethodBeat.i(133603);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.installshortcut.PurviewActivity"));
                AppMethodBeat.o(133603);
                return intent;
            }
        });
        AppMethodBeat.o(133604);
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
        AppMethodBeat.i(133605);
        Context context = ah.getContext();
        String manufacturer = getManufacturer();
        ab.i("MicroMsg.AppPermissionSettingAdapterFactory", "manufacturer = %s", manufacturer);
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
                AppMethodBeat.o(133605);
                return -1;
            case 2:
                AppMethodBeat.o(133605);
                return -1;
            case 3:
                try {
                    String[] split;
                    manufacturer = Secure.getString(context.getContentResolver(), "launcher_shortcut_permission_settings");
                    for (String str : String.valueOf(manufacturer.subSequence(1, manufacturer.length() - 1)).split("/")) {
                        if (str.startsWith(context.getPackageName())) {
                            split = str.split(",");
                            if (split != null) {
                                AppMethodBeat.o(133605);
                                return -1;
                            } else if (Integer.valueOf(split[1].trim()).intValue() == 1) {
                                AppMethodBeat.o(133605);
                                return 0;
                            } else {
                                AppMethodBeat.o(133605);
                                return 1;
                            }
                        }
                    }
                    if (split != null) {
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(133605);
                    return -1;
                }
            case 4:
                Cursor query;
                try {
                    query = context.getContentResolver().query(Uri.parse("content://com.bbk.launcher2.settings/favorites?notify=false"), new String[]{"intent", "shortcutPermission"}, "intent" + " LIKE '" + new ComponentName(ah.getContext(), "com.tencent.mm.ui.LauncherUI").flattenToString() + "%'", null, null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(133605);
                        return -1;
                    }
                    try {
                        i = query.getColumnIndex(r10);
                        query.moveToFirst();
                        i = query.getInt(i);
                        ab.i("MicroMsg.AppPermissionSettingAdapterFactory", "vivo statues on vivo = ".concat(String.valueOf(i)));
                        if (i == 16) {
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(133605);
                            return 0;
                        }
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(133605);
                        return 1;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            ab.w("MicroMsg.AppPermissionSettingAdapterFactory", "[checkPermissionStatus] vivooccur exception return unknown status : \n" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(133605);
                            return -1;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null) {
                            }
                            AppMethodBeat.o(133605);
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
                    AppMethodBeat.o(133605);
                    throw th;
                }
            default:
                AppMethodBeat.o(133605);
                return -1;
        }
    }

    public final void dc(Context context) {
        AppMethodBeat.i(133606);
        ab.i("MicroMsg.AppPermissionSettingAdapterFactory", "[jumpPermissionSettingPage] manufacturer = %s", q.bB(context).toLowerCase());
        b bVar = (b) this.iSi.get(r0);
        if (bVar != null) {
            bVar.dd(context);
        }
        AppMethodBeat.o(133606);
    }

    public final boolean aOe() {
        AppMethodBeat.i(133607);
        String manufacturer = getManufacturer();
        ab.i("MicroMsg.AppPermissionSettingAdapterFactory", "[canJumpSettingPage] manufacturer = %s", manufacturer);
        b bVar = (b) this.iSi.get(manufacturer);
        if (this.iSi.containsKey(manufacturer) && bVar.aOf()) {
            AppMethodBeat.o(133607);
            return true;
        }
        AppMethodBeat.o(133607);
        return false;
    }

    private static String getManufacturer() {
        AppMethodBeat.i(133608);
        String toLowerCase = q.bB(ah.getContext()).toLowerCase();
        AppMethodBeat.o(133608);
        return toLowerCase;
    }
}
