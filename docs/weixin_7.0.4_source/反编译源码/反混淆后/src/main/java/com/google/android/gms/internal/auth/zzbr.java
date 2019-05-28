package com.google.android.gms.internal.auth;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum zzbr {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR(NativeProtocol.ERROR_NETWORK_ERROR),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED(NativeProtocol.ERROR_SERVICE_DISABLED),
    NEED_PERMISSION("NeedPermission"),
    NEED_REMOTE_CONSENT("NeedRemoteConsent"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED(NativeProtocol.ERROR_PERMISSION_DENIED),
    INVALID_AUDIENCE("INVALID_AUDIENCE"),
    UNREGISTERED_ON_API_CONSOLE("UNREGISTERED_ON_API_CONSOLE"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_SCREENLOCK_REQUIRED("DeviceManagementScreenlockRequired"),
    DM_REQUIRED("DeviceManagementRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");
    
    private final String zzho;

    static {
        AppMethodBeat.m2505o(77113);
    }

    private zzbr(String str) {
        this.zzho = str;
    }

    public static boolean zzd(zzbr zzbr) {
        AppMethodBeat.m2504i(77112);
        if (BAD_AUTHENTICATION.equals(zzbr) || CAPTCHA.equals(zzbr) || NEED_PERMISSION.equals(zzbr) || NEED_REMOTE_CONSENT.equals(zzbr) || NEEDS_BROWSER.equals(zzbr) || USER_CANCEL.equals(zzbr) || DEVICE_MANAGEMENT_REQUIRED.equals(zzbr) || DM_INTERNAL_ERROR.equals(zzbr) || DM_SYNC_DISABLED.equals(zzbr) || DM_ADMIN_BLOCKED.equals(zzbr) || DM_ADMIN_PENDING_APPROVAL.equals(zzbr) || DM_STALE_SYNC_REQUIRED.equals(zzbr) || DM_DEACTIVATED.equals(zzbr) || DM_REQUIRED.equals(zzbr) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(zzbr) || DM_SCREENLOCK_REQUIRED.equals(zzbr)) {
            AppMethodBeat.m2505o(77112);
            return true;
        }
        AppMethodBeat.m2505o(77112);
        return false;
    }

    public static final zzbr zzh(String str) {
        AppMethodBeat.m2504i(77111);
        zzbr zzbr = null;
        zzbr[] values = values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            zzbr zzbr2 = values[i];
            if (!zzbr2.zzho.equals(str)) {
                zzbr2 = zzbr;
            }
            i++;
            zzbr = zzbr2;
        }
        AppMethodBeat.m2505o(77111);
        return zzbr;
    }
}
