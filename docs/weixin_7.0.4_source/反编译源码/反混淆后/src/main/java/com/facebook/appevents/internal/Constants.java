package com.facebook.appevents.internal;

public class Constants {
    public static final String AA_TIME_SPENT_EVENT_NAME = "fb_aa_time_spent_on_view";
    public static final String AA_TIME_SPENT_SCREEN_PARAMETER_NAME = "fb_aa_time_spent_view_name";
    public static final String EVENT_NAME_EVENT_KEY = "_eventName";
    public static final String EVENT_NAME_MD5_EVENT_KEY = "_eventName_md5";
    public static final String EVENT_PARAM_PRODUCT_AVAILABILITY = "fb_product_availability";
    public static final String EVENT_PARAM_PRODUCT_BRAND = "fb_product_brand";
    public static final String EVENT_PARAM_PRODUCT_CONDITION = "fb_product_condition";
    public static final String EVENT_PARAM_PRODUCT_DESCRIPTION = "fb_product_description";
    public static final String EVENT_PARAM_PRODUCT_GTIN = "fb_product_gtin";
    public static final String EVENT_PARAM_PRODUCT_IMAGE_LINK = "fb_product_image_link";
    public static final String EVENT_PARAM_PRODUCT_ITEM_ID = "fb_product_item_id";
    public static final String EVENT_PARAM_PRODUCT_LINK = "fb_product_link";
    public static final String EVENT_PARAM_PRODUCT_MPN = "fb_product_mpn";
    public static final String EVENT_PARAM_PRODUCT_PRICE_AMOUNT = "fb_product_price_amount";
    public static final String EVENT_PARAM_PRODUCT_PRICE_CURRENCY = "fb_product_price_currency";
    public static final String EVENT_PARAM_PRODUCT_TITLE = "fb_product_title";
    public static final String IAP_FREE_TRIAL_PERIOD = "fb_free_trial_period";
    public static final String IAP_INTRO_PRICE_AMOUNT_MICROS = "fb_intro_price_amount_micros";
    public static final String IAP_INTRO_PRICE_CYCLES = "fb_intro_price_cycles";
    public static final String IAP_PACKAGE_NAME = "fb_iap_package_name";
    public static final String IAP_PRODUCT_DESCRIPTION = "fb_iap_product_description";
    public static final String IAP_PRODUCT_ID = "fb_iap_product_id";
    public static final String IAP_PRODUCT_TITLE = "fb_iap_product_title";
    public static final String IAP_PRODUCT_TYPE = "fb_iap_product_type";
    public static final String IAP_PURCHASE_TIME = "fb_iap_purchase_time";
    public static final String IAP_PURCHASE_TOKEN = "fb_iap_purchase_token";
    public static final String IAP_SUBSCRIPTION_AUTORENEWING = "fb_iap_subs_auto_renewing";
    public static final String IAP_SUBSCRIPTION_PERIOD = "fb_iap_subs_period";
    public static final String LOG_TIME_APP_EVENT_KEY = "_logTime";

    public static int getDefaultAppEventsSessionTimeoutInSeconds() {
        return 60;
    }
}
