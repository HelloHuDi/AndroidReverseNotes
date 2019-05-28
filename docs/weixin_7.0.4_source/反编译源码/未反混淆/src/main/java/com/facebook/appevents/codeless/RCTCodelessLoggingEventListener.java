package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class RCTCodelessLoggingEventListener {
    private static final String TAG = RCTCodelessLoggingEventListener.class.getCanonicalName();

    public static class AutoLoggingOnTouchListener implements OnTouchListener {
        private OnTouchListener existingOnTouchListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging = false;

        public AutoLoggingOnTouchListener(EventBinding eventBinding, View view, View view2) {
            AppMethodBeat.i(72070);
            if (eventBinding == null || view == null || view2 == null) {
                AppMethodBeat.o(72070);
                return;
            }
            this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
            this.mapping = eventBinding;
            this.hostView = new WeakReference(view2);
            this.rootView = new WeakReference(view);
            this.supportCodelessLogging = true;
            AppMethodBeat.o(72070);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(72071);
            if (motionEvent.getAction() == 1) {
                logEvent();
            }
            if (this.existingOnTouchListener == null || !this.existingOnTouchListener.onTouch(view, motionEvent)) {
                AppMethodBeat.o(72071);
                return false;
            }
            AppMethodBeat.o(72071);
            return true;
        }

        private void logEvent() {
            AppMethodBeat.i(72072);
            final String eventName = this.mapping.getEventName();
            final Bundle parameters = CodelessMatcher.getParameters(this.mapping, (View) this.rootView.get(), (View) this.hostView.get());
            if (parameters.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
                parameters.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(parameters.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
            }
            parameters.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    AppMethodBeat.i(72069);
                    AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
                    AppMethodBeat.o(72069);
                }
            });
            AppMethodBeat.o(72072);
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }
    }

    static {
        AppMethodBeat.i(72074);
        AppMethodBeat.o(72074);
    }

    public static AutoLoggingOnTouchListener getOnTouchListener(EventBinding eventBinding, View view, View view2) {
        AppMethodBeat.i(72073);
        AutoLoggingOnTouchListener autoLoggingOnTouchListener = new AutoLoggingOnTouchListener(eventBinding, view, view2);
        AppMethodBeat.o(72073);
        return autoLoggingOnTouchListener;
    }
}
