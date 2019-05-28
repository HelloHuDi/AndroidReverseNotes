package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p057v4.content.C37116d;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context context) {
        AppMethodBeat.m2504i(72244);
        this.applicationContext = context.getApplicationContext();
        AppMethodBeat.m2505o(72244);
    }

    private void open() {
        AppMethodBeat.m2504i(72245);
        C37116d.m62125S(this.applicationContext).mo59171a(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
        AppMethodBeat.m2505o(72245);
    }

    private void close() {
        AppMethodBeat.m2504i(72246);
        C37116d.m62125S(this.applicationContext).unregisterReceiver(this);
        AppMethodBeat.m2505o(72246);
    }

    public static BoltsMeasurementEventListener getInstance(Context context) {
        AppMethodBeat.m2504i(72247);
        BoltsMeasurementEventListener boltsMeasurementEventListener;
        if (_instance != null) {
            boltsMeasurementEventListener = _instance;
            AppMethodBeat.m2505o(72247);
            return boltsMeasurementEventListener;
        }
        boltsMeasurementEventListener = new BoltsMeasurementEventListener(context);
        _instance = boltsMeasurementEventListener;
        boltsMeasurementEventListener.open();
        boltsMeasurementEventListener = _instance;
        AppMethodBeat.m2505o(72247);
        return boltsMeasurementEventListener;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(72248);
        try {
            close();
        } finally {
            super.finalize();
            AppMethodBeat.m2505o(72248);
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(72249);
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        String stringBuilder = new StringBuilder(BOLTS_MEASUREMENT_EVENT_PREFIX).append(intent.getStringExtra(MEASUREMENT_EVENT_NAME_KEY)).toString();
        Bundle bundleExtra = intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
        Bundle bundle = new Bundle();
        for (String str : bundleExtra.keySet()) {
            bundle.putString(str.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str));
        }
        newLogger.logEvent(stringBuilder, bundle);
        AppMethodBeat.m2505o(72249);
    }
}
