package com.google.android.gms.stats;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CodePackage {
    public static final String COMMON = "COMMON";
    public static final String DRIVE = "DRIVE";
    public static final String FITNESS = "FITNESS";
    public static final String GCM = "GCM";
    public static final String ICING = "ICING";
    public static final String LOCATION = "LOCATION";
    public static final String LOCATION_SHARING = "LOCATION_SHARING";
    public static final String OTA = "OTA";
    public static final String REMINDERS = "REMINDERS";
    public static final String SECURITY = "SECURITY";
}
