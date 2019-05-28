package com.google.android.gms.common.internal.constants;

public interface ListAppsActivityContract {
    public static final String ACTION_APPS = "com.google.android.gms.plus.action.MANAGE_APPS";
    public static final String ACTION_LOG = "com.google.android.gms.plus.action.VIEW_ACTIVITY_LOG";
    public static final String EXTRA_ACCOUNT_NAME = "com.google.android.gms.extras.ACCOUNT_NAME";
    public static final String EXTRA_ALL_APPS = "com.google.android.gms.extras.ALL_APPS";
    @Deprecated
    public static final String EXTRA_APP_ICON_URL = "com.google.android.gms.extras.APP_ICON_URL";
    public static final String EXTRA_APP_ID = "com.google.android.gms.extras.APP_ID";
    @Deprecated
    public static final String EXTRA_APP_NAME = "com.google.android.gms.extras.APP_NAME";
    public static final String EXTRA_COLLECTION_FILTER = "com.google.android.gms.extras.COLLECTION_FILTER";
    public static final String EXTRA_PRESELECTED_FILTER = "com.google.android.gms.extras.PRESELECTED_FILTER";
    public static final int PRESELECTED_FILTER_ALL_APPS = 0;
    public static final int PRESELECTED_FILTER_ASPEN_APPS = 1;
    public static final int PRESELECTED_FILTER_FITNESS_APPS = 2;
}
