package com.facebook.internal;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FetchedAppSettings {
    private boolean IAPAutomaticLoggingEnabled;
    private boolean automaticLoggingEnabled;
    private boolean codelessEventsEnabled;
    private boolean codelessSetupEnabled;
    private boolean customTabsEnabled;
    private Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap;
    private FacebookRequestErrorClassification errorClassification;
    private JSONArray eventBindings;
    private String nuxContent;
    private boolean nuxEnabled;
    private String sdkUpdateMessage;
    private int sessionTimeoutInSeconds;
    private String smartLoginBookmarkIconURL;
    private String smartLoginMenuIconURL;
    private EnumSet<SmartLoginOption> smartLoginOptions;
    private boolean supportsImplicitLogging;
    private boolean trackUninstallEnabled;

    public static class DialogFeatureConfig {
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        private String dialogName;
        private Uri fallbackUrl;
        private String featureName;
        private int[] featureVersionSpec;

        public static DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
            Uri uri = null;
            AppMethodBeat.i(72301);
            String optString = jSONObject.optString("name");
            if (Utility.isNullOrEmpty(optString)) {
                AppMethodBeat.o(72301);
                return null;
            }
            String[] split = optString.split(DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
            if (split.length != 2) {
                AppMethodBeat.o(72301);
                return null;
            }
            String str = split[0];
            String str2 = split[1];
            if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                AppMethodBeat.o(72301);
                return null;
            }
            optString = jSONObject.optString("url");
            if (!Utility.isNullOrEmpty(optString)) {
                uri = Uri.parse(optString);
            }
            DialogFeatureConfig dialogFeatureConfig = new DialogFeatureConfig(str, str2, uri, parseVersionSpec(jSONObject.optJSONArray(DIALOG_CONFIG_VERSIONS_KEY)));
            AppMethodBeat.o(72301);
            return dialogFeatureConfig;
        }

        private static int[] parseVersionSpec(JSONArray jSONArray) {
            AppMethodBeat.i(72302);
            int[] iArr = null;
            if (jSONArray != null) {
                int length = jSONArray.length();
                int[] iArr2 = new int[length];
                for (int i = 0; i < length; i++) {
                    int optInt = jSONArray.optInt(i, -1);
                    if (optInt == -1) {
                        String optString = jSONArray.optString(i);
                        if (!Utility.isNullOrEmpty(optString)) {
                            try {
                                optInt = Integer.parseInt(optString);
                            } catch (NumberFormatException e) {
                                Utility.logd("FacebookSDK", e);
                                optInt = -1;
                            }
                        }
                    }
                    iArr2[i] = optInt;
                }
                iArr = iArr2;
            }
            AppMethodBeat.o(72302);
            return iArr;
        }

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.featureVersionSpec = iArr;
        }

        public String getDialogName() {
            return this.dialogName;
        }

        public String getFeatureName() {
            return this.featureName;
        }

        public Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public int[] getVersionSpec() {
            return this.featureVersionSpec;
        }
    }

    public FetchedAppSettings(boolean z, String str, boolean z2, boolean z3, int i, EnumSet<SmartLoginOption> enumSet, Map<String, Map<String, DialogFeatureConfig>> map, boolean z4, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z5, boolean z6, JSONArray jSONArray, String str4, boolean z7, boolean z8) {
        this.supportsImplicitLogging = z;
        this.nuxContent = str;
        this.nuxEnabled = z2;
        this.customTabsEnabled = z3;
        this.dialogConfigMap = map;
        this.errorClassification = facebookRequestErrorClassification;
        this.sessionTimeoutInSeconds = i;
        this.automaticLoggingEnabled = z4;
        this.smartLoginOptions = enumSet;
        this.smartLoginBookmarkIconURL = str2;
        this.smartLoginMenuIconURL = str3;
        this.IAPAutomaticLoggingEnabled = z5;
        this.codelessEventsEnabled = z6;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = str4;
        this.trackUninstallEnabled = z7;
        this.codelessSetupEnabled = z8;
    }

    public final boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }

    public final String getNuxContent() {
        return this.nuxContent;
    }

    public final boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    public final boolean getCustomTabsEnabled() {
        return this.customTabsEnabled;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public final EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    public final Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigMap;
    }

    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public final String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    public final String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.IAPAutomaticLoggingEnabled;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public final boolean getCodelessSetupEnabled() {
        return this.codelessSetupEnabled;
    }

    public final JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public final boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public static DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        AppMethodBeat.i(72303);
        if (Utility.isNullOrEmpty(str2) || Utility.isNullOrEmpty(str3)) {
            AppMethodBeat.o(72303);
            return null;
        }
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(str);
        if (appSettingsWithoutQuery != null) {
            Map map = (Map) appSettingsWithoutQuery.getDialogConfigurations().get(str2);
            if (map != null) {
                DialogFeatureConfig dialogFeatureConfig = (DialogFeatureConfig) map.get(str3);
                AppMethodBeat.o(72303);
                return dialogFeatureConfig;
            }
        }
        AppMethodBeat.o(72303);
        return null;
    }
}
