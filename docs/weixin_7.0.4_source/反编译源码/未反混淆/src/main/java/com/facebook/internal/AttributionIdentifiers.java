package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.FacebookException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public final IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() {
            AppMethodBeat.i(72232);
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
                AppMethodBeat.o(72232);
            }
        }

        public final boolean isTrackingLimited() {
            boolean z = true;
            AppMethodBeat.i(72233);
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                AppMethodBeat.o(72233);
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                AppMethodBeat.o(72233);
            }
        }
    }

    static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        private GoogleAdServiceConnection() {
            AppMethodBeat.i(72234);
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
            AppMethodBeat.o(72234);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(72235);
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException e) {
                    AppMethodBeat.o(72235);
                    return;
                }
            }
            AppMethodBeat.o(72235);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        public final IBinder getBinder() {
            AppMethodBeat.i(72236);
            if (this.consumed.compareAndSet(true, true)) {
                IllegalStateException illegalStateException = new IllegalStateException("Binder already consumed");
                AppMethodBeat.o(72236);
                throw illegalStateException;
            }
            IBinder iBinder = (IBinder) this.queue.take();
            AppMethodBeat.o(72236);
            return iBinder;
        }
    }

    static {
        AppMethodBeat.i(72243);
        AppMethodBeat.o(72243);
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AppMethodBeat.i(72237);
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection == null) {
            androidIdViaReflection = getAndroidIdViaService(context);
            if (androidIdViaReflection == null) {
                androidIdViaReflection = new AttributionIdentifiers();
            }
        }
        AppMethodBeat.o(72237);
        return androidIdViaReflection;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        AppMethodBeat.i(72238);
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                FacebookException facebookException = new FacebookException("getAndroidId cannot be called on the main thread.");
                AppMethodBeat.o(72238);
                throw facebookException;
            }
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (methodQuietly == null) {
                AppMethodBeat.o(72238);
                return null;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if ((invokeMethodQuietly instanceof Integer) && ((Integer) invokeMethodQuietly).intValue() == 0) {
                methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
                if (methodQuietly == null) {
                    AppMethodBeat.o(72238);
                    return null;
                }
                Object invokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly, context);
                if (invokeMethodQuietly2 == null) {
                    AppMethodBeat.o(72238);
                    return null;
                }
                methodQuietly = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "getId", new Class[0]);
                Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                if (methodQuietly == null || methodQuietly2 == null) {
                    AppMethodBeat.o(72238);
                    return null;
                }
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly, new Object[0]);
                attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly2, new Object[0])).booleanValue();
                AppMethodBeat.o(72238);
                return attributionIdentifiers;
            }
            AppMethodBeat.o(72238);
            return null;
        } catch (Exception e) {
            Utility.logd("android_id", e);
            AppMethodBeat.o(72238);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        AppMethodBeat.i(72239);
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                context.unbindService(googleAdServiceConnection);
                AppMethodBeat.o(72239);
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.logd("android_id", e);
                context.unbindService(googleAdServiceConnection);
            } catch (Throwable th) {
                context.unbindService(googleAdServiceConnection);
                AppMethodBeat.o(72239);
            }
        }
        AppMethodBeat.o(72239);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static AttributionIdentifiers getAttributionIdentifiers(Context context) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(72240);
        Looper.myLooper();
        Looper.getMainLooper();
        AttributionIdentifiers cacheAndReturnIdentifiers;
        if (recentlyFetchedIdentifiers == null || System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime >= IDENTIFIER_REFRESH_INTERVAL_MILLIS) {
            AttributionIdentifiers androidId = getAndroidId(context);
            Cursor query;
            try {
                Uri parse;
                String[] strArr = new String[]{ATTRIBUTION_ID_COLUMN_NAME, ANDROID_ID_COLUMN_NAME, LIMIT_TRACKING_COLUMN_NAME};
                if (context.getPackageManager().resolveContentProvider(ATTRIBUTION_ID_CONTENT_PROVIDER, 0) != null) {
                    parse = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                } else if (context.getPackageManager().resolveContentProvider(ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI, 0) != null) {
                    parse = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                } else {
                    parse = null;
                }
                String installerPackageName = getInstallerPackageName(context);
                if (installerPackageName != null) {
                    androidId.androidInstallerPackage = installerPackageName;
                }
                if (parse == null) {
                    cacheAndReturnIdentifiers = cacheAndReturnIdentifiers(androidId);
                    AppMethodBeat.o(72240);
                    return cacheAndReturnIdentifiers;
                }
                query = context.getContentResolver().query(parse, strArr, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            int columnIndex = query.getColumnIndex(ATTRIBUTION_ID_COLUMN_NAME);
                            int columnIndex2 = query.getColumnIndex(ANDROID_ID_COLUMN_NAME);
                            int columnIndex3 = query.getColumnIndex(LIMIT_TRACKING_COLUMN_NAME);
                            androidId.attributionId = query.getString(columnIndex);
                            if (columnIndex2 > 0 && columnIndex3 > 0 && androidId.getAndroidAdvertiserId() == null) {
                                androidId.androidAdvertiserId = query.getString(columnIndex2);
                                androidId.limitTracking = Boolean.parseBoolean(query.getString(columnIndex3));
                            }
                            if (query != null) {
                                query.close();
                            }
                            cacheAndReturnIdentifiers = cacheAndReturnIdentifiers(androidId);
                            AppMethodBeat.o(72240);
                            return cacheAndReturnIdentifiers;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            Utility.logd(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
                            if (query != null) {
                            }
                            AppMethodBeat.o(72240);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(72240);
                            throw th;
                        }
                    }
                }
                cacheAndReturnIdentifiers = cacheAndReturnIdentifiers(androidId);
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(72240);
                return cacheAndReturnIdentifiers;
            } catch (Exception e3) {
                e = e3;
                query = null;
                Utility.logd(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(72240);
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                }
                AppMethodBeat.o(72240);
                throw th;
            }
        }
        cacheAndReturnIdentifiers = recentlyFetchedIdentifiers;
        AppMethodBeat.o(72240);
        return cacheAndReturnIdentifiers;
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        AppMethodBeat.i(72241);
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        AppMethodBeat.o(72241);
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    private static String getInstallerPackageName(Context context) {
        AppMethodBeat.i(72242);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            AppMethodBeat.o(72242);
            return installerPackageName;
        }
        AppMethodBeat.o(72242);
        return null;
    }
}
