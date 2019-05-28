package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcelable;
import android.support.v4.app.ab.a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.api.Scope;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Locale;

public class GmsIntents {
    public static final String ACTION_FITNESS_APP_DISCONNECTED = "com.google.android.gms.fitness.app_disconnected";
    public static final String ACTION_ICING_CONTACT_CHANGED = "com.google.android.gms.icing.action.CONTACT_CHANGED";
    public static final String ACTION_SET_GMS_ACCOUNT = "com.google.android.gms.common.SET_GMS_ACCOUNT";
    public static final String ACTION_UDC_SETTING_CHANGED = "com.google.android.gms.udc.action.SETTING_CHANGED";
    public static final String BROADCAST_CIRCLES_CHANGED = "com.google.android.gms.people.BROADCAST_CIRCLES_CHANGED";
    public static final String COMMON_SIGN_IN_EXTRA_PACKAGE_NAME = "SIGN_IN_PACKAGE_NAME";
    public static final String COMMON_SIGN_IN_EXTRA_SAVE_DEFAULT_ACCOUNT = "SIGN_IN_SAVE_DEFAULT_ACCOUNT";
    public static final String COMMON_SIGN_IN_EXTRA_SCOPE_ARRAY = "SIGN_IN_SCOPE_ARRAY";
    public static final String EXTRA_ACCOUNT = "com.google.android.gms.fitness.disconnected_account";
    public static final String EXTRA_APP = "com.google.android.gms.fitness.disconnected_app";
    public static final String EXTRA_ICING_CONTACT_CHANGED_IS_SIGNIFICANT = "com.google.android.gms.icing.extra.isSignificant";
    public static final String EXTRA_SET_GMS_ACCOUNT_NAME = "ACCOUNT_NAME";
    public static final String EXTRA_SET_GMS_ACCOUNT_PACKAGE_NAME = "PACKAGE_NAME";
    public static final String EXTRA_UDC_ACCOUNT_NAME = "com.google.android.gms.udc.extra.accountName";
    public static final String EXTRA_UDC_SETTING_ID_LIST = "com.google.android.gms.udc.extra.settingIdList";
    public static final String GOOGLE_NOW_PACKAGE_NAME = "com.google.android.googlequicksearchbox";
    public static final String MIME_ACTIVITY_DISCONNECT_TYPE = "vnd.google.android.fitness/app_disconnect";
    public static final String PERMISSION_GMS_INTERNAL_BROADCAST = "com.google.android.gms.permission.INTERNAL_BROADCAST";
    private static final Uri zztz;
    private static final Uri zzua;

    static {
        AppMethodBeat.i(89641);
        Uri parse = Uri.parse("https://plus.google.com/");
        zztz = parse;
        zzua = parse.buildUpon().appendPath("circles").appendPath("find").build();
        AppMethodBeat.o(89641);
    }

    private GmsIntents() {
    }

    public static Intent createAndroidWearUpdateIntent() {
        AppMethodBeat.i(89628);
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        AppMethodBeat.o(89628);
        return intent;
    }

    public static Intent createChooseGmsAccountIntent() {
        AppMethodBeat.i(89636);
        Intent newChooseAccountIntent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"}, true, null, null, null, null, true);
        AppMethodBeat.o(89636);
        return newChooseAccountIntent;
    }

    public static Intent createChooseGmsAccountWithConsentIntent(String str, Scope[] scopeArr, boolean z) {
        AppMethodBeat.i(89637);
        Intent intent = new Intent("com.google.android.gms.signin.action.SIGN_IN");
        intent.putExtra(COMMON_SIGN_IN_EXTRA_PACKAGE_NAME, str);
        intent.putExtra(COMMON_SIGN_IN_EXTRA_SCOPE_ARRAY, scopeArr);
        intent.putExtra(COMMON_SIGN_IN_EXTRA_SAVE_DEFAULT_ACCOUNT, z);
        AppMethodBeat.o(89637);
        return intent;
    }

    public static Intent createDateSettingsIntent() {
        AppMethodBeat.i(89622);
        Intent intent = new Intent("android.settings.DATE_SETTINGS");
        AppMethodBeat.o(89622);
        return intent;
    }

    public static Intent createFindPeopleIntent(Context context) {
        AppMethodBeat.i(89632);
        Intent zza = zza(context, zzua);
        AppMethodBeat.o(89632);
        return zza;
    }

    public static Intent createPlayStoreGamesIntent(Context context) {
        AppMethodBeat.i(89627);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(GooglePlayServicesUtilLight.GOOGLE_PLAY_STORE_GAMES_URI_STRING));
        intent.addFlags(SQLiteGlobal.journalSizeLimit);
        intent.setPackage("com.android.vending");
        if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
            Intent intent2 = new Intent(intent.getAction(), intent.getData());
            intent2.setFlags(intent.getFlags());
            AppMethodBeat.o(89627);
            return intent2;
        }
        AppMethodBeat.o(89627);
        return intent;
    }

    public static Intent createPlayStoreIntent(String str) {
        AppMethodBeat.i(89624);
        Intent createPlayStoreIntent = createPlayStoreIntent(str, null);
        AppMethodBeat.o(89624);
        return createPlayStoreIntent;
    }

    public static Intent createPlayStoreIntent(String str, String str2) {
        AppMethodBeat.i(89625);
        Intent intent = new Intent("android.intent.action.VIEW");
        Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(appendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(SQLiteGlobal.journalSizeLimit);
        AppMethodBeat.o(89625);
        return intent;
    }

    public static Intent createPlayStoreLightPurchaseFlowIntent(Context context, String str, String str2) {
        AppMethodBeat.i(89626);
        Intent intent = new Intent("com.android.vending.billing.PURCHASE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage("com.android.vending");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("authAccount", str);
        }
        intent.putExtra("backend", 3);
        intent.putExtra("document_type", 1);
        intent.putExtra("full_docid", str2);
        intent.putExtra("backend_docid", str2);
        intent.putExtra("offer_type", 1);
        if (!isIntentResolvable(context.getPackageManager(), intent)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format(Locale.US, "https://play.google.com/store/apps/details?id=%1$s&rdid=%1$s&rdot=%2$d", new Object[]{str2, Integer.valueOf(1)})));
            intent.setPackage("com.android.vending");
            intent.putExtra("use_direct_purchase", true);
        }
        AppMethodBeat.o(89626);
        return intent;
    }

    public static Intent createSettingsIntent(String str) {
        AppMethodBeat.i(89621);
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        AppMethodBeat.o(89621);
        return intent;
    }

    public static Intent createShowProfileIntent(Context context, String str) {
        AppMethodBeat.i(89633);
        Intent zza = zza(context, Uri.parse(String.format("https://plus.google.com/%s/about", new Object[]{str})));
        AppMethodBeat.o(89633);
        return zza;
    }

    public static Intent getFitnessAppDisconnectedIntent(String str, String str2) {
        AppMethodBeat.i(89640);
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(ACTION_FITNESS_APP_DISCONNECTED);
        intent.setType(MIME_ACTIVITY_DISCONNECT_TYPE);
        intent.putExtra(EXTRA_APP, str);
        intent.putExtra(EXTRA_ACCOUNT, str2);
        AppMethodBeat.o(89640);
        return intent;
    }

    public static Uri getPlayStoreUri(String str) {
        AppMethodBeat.i(89623);
        Uri build = Uri.parse("https://play.google.com/store/apps/details").buildUpon().appendQueryParameter("id", str).build();
        AppMethodBeat.o(89623);
        return build;
    }

    public static boolean isIntentResolvable(PackageManager packageManager, Intent intent) {
        AppMethodBeat.i(89639);
        if (packageManager.resolveActivity(intent, 65536) != null) {
            AppMethodBeat.o(89639);
            return true;
        }
        AppMethodBeat.o(89639);
        return false;
    }

    public static void sendIcingContactChangedBroadcast(Context context, boolean z) {
        AppMethodBeat.i(89631);
        Intent putExtra = new Intent(ACTION_ICING_CONTACT_CHANGED).setPackage("com.google.android.gms").putExtra(EXTRA_ICING_CONTACT_CHANGED_IS_SIGNIFICANT, z);
        if (Log.isLoggable("GmsIntents", 2)) {
            String action = putExtra.getAction();
            new StringBuilder(String.valueOf(action).length() + 98).append("Icing detected contact change, broadcasting it with intent action: ").append(action).append(" and isSignificant extra: ").append(z);
        }
        context.sendBroadcast(putExtra);
        AppMethodBeat.o(89631);
    }

    public static void sendSetGmsAccountIntent(Context context, String str, String str2) {
        AppMethodBeat.i(89638);
        Intent intent = new Intent(ACTION_SET_GMS_ACCOUNT);
        intent.putExtra(EXTRA_SET_GMS_ACCOUNT_NAME, str);
        intent.putExtra(EXTRA_SET_GMS_ACCOUNT_PACKAGE_NAME, str2);
        intent.setPackage("com.google.android.gms");
        context.sendBroadcast(intent, PERMISSION_GMS_INTERNAL_BROADCAST);
        AppMethodBeat.o(89638);
    }

    public static void sendUdcSettingsChangedBroadcast(Context context, String str, int[] iArr) {
        AppMethodBeat.i(89629);
        zza("com.google.android.gms", context, str, iArr);
        if (GoogleSignatureVerifier.getInstance(context).isPackageGoogleSigned(GOOGLE_NOW_PACKAGE_NAME)) {
            zza(GOOGLE_NOW_PACKAGE_NAME, context, str, iArr);
            AppMethodBeat.o(89629);
            return;
        }
        Log.isLoggable("GmsIntents", 5);
        AppMethodBeat.o(89629);
    }

    private static Intent zza(Context context, Uri uri) {
        AppMethodBeat.i(89634);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setPackage("com.google.android.apps.plus");
        if (isIntentResolvable(context.getPackageManager(), intent)) {
            AppMethodBeat.o(89634);
            return intent;
        }
        intent = createPlayStoreIntent("com.google.android.apps.plus");
        AppMethodBeat.o(89634);
        return intent;
    }

    private static void zza(String str, Context context, String str2, int[] iArr) {
        AppMethodBeat.i(89630);
        Intent putExtra = new Intent(ACTION_UDC_SETTING_CHANGED).setPackage(str).putExtra(EXTRA_UDC_ACCOUNT_NAME, str2).putExtra(EXTRA_UDC_SETTING_ID_LIST, iArr);
        if (Log.isLoggable("GmsIntents", 3)) {
            String action = putExtra.getAction();
            new StringBuilder((String.valueOf(str).length() + 72) + String.valueOf(action).length()).append("UDC settings changed, sending broadcast to package ").append(str).append(" with intent action: ").append(action);
        }
        context.sendBroadcast(putExtra);
        AppMethodBeat.o(89630);
    }

    public static Intent createShareOnPlusIntent(Activity activity, String str, String str2) {
        AppMethodBeat.i(89635);
        a aVar = new a(activity);
        aVar.mIntent.putExtra("android.intent.extra.SUBJECT", str);
        aVar.mIntent.putExtra("android.intent.extra.TEXT", str2);
        aVar.mIntent.setType("text/plain");
        if (aVar.FZ != null) {
            aVar.a("android.intent.extra.EMAIL", aVar.FZ);
            aVar.FZ = null;
        }
        if (aVar.Ga != null) {
            aVar.a("android.intent.extra.CC", aVar.Ga);
            aVar.Ga = null;
        }
        if (aVar.Gb != null) {
            aVar.a("android.intent.extra.BCC", aVar.Gb);
            aVar.Gb = null;
        }
        int i = (aVar.Gc == null || aVar.Gc.size() <= 1) ? 0 : 1;
        boolean equals = aVar.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if (i == 0 && equals) {
            aVar.mIntent.setAction("android.intent.action.SEND");
            if (aVar.Gc == null || aVar.Gc.isEmpty()) {
                aVar.mIntent.removeExtra("android.intent.extra.STREAM");
            } else {
                aVar.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) aVar.Gc.get(0));
            }
            aVar.Gc = null;
        }
        if (!(i == 0 || equals)) {
            aVar.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            if (aVar.Gc == null || aVar.Gc.isEmpty()) {
                aVar.mIntent.removeExtra("android.intent.extra.STREAM");
            } else {
                aVar.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", aVar.Gc);
            }
        }
        Intent intent = aVar.mIntent;
        intent.setPackage("com.google.android.apps.plus");
        if (isIntentResolvable(activity.getPackageManager(), intent)) {
            AppMethodBeat.o(89635);
            return intent;
        }
        intent = createPlayStoreIntent("com.google.android.apps.plus");
        AppMethodBeat.o(89635);
        return intent;
    }
}
