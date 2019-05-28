package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.EventBinding.ActionType;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class CodelessLoggingEventListener {
    private static final String TAG = CodelessLoggingEventListener.class.getCanonicalName();

    public static class AutoLoggingAccessibilityDelegate extends AccessibilityDelegate {
        private int accessibilityEventType;
        private AccessibilityDelegate existingDelegate;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        protected boolean supportButtonIndexing = false;
        private boolean supportCodelessLogging = false;

        public AutoLoggingAccessibilityDelegate(EventBinding eventBinding, View view, View view2) {
            AppMethodBeat.i(72042);
            if (eventBinding == null || view == null || view2 == null) {
                AppMethodBeat.o(72042);
                return;
            }
            this.existingDelegate = ViewHierarchy.getExistingDelegate(view2);
            this.mapping = eventBinding;
            this.hostView = new WeakReference(view2);
            this.rootView = new WeakReference(view);
            ActionType type = eventBinding.getType();
            switch (eventBinding.getType()) {
                case CLICK:
                    this.accessibilityEventType = 1;
                    break;
                case SELECTED:
                    this.accessibilityEventType = 4;
                    break;
                case TEXT_CHANGED:
                    this.accessibilityEventType = 16;
                    break;
                default:
                    FacebookException facebookException = new FacebookException("Unsupported action type: " + type.toString());
                    AppMethodBeat.o(72042);
                    throw facebookException;
            }
            this.supportCodelessLogging = true;
            AppMethodBeat.o(72042);
        }

        public void sendAccessibilityEvent(View view, int i) {
            AppMethodBeat.i(72043);
            if (i == -1) {
                CodelessLoggingEventListener.TAG;
            }
            if (i != this.accessibilityEventType) {
                AppMethodBeat.o(72043);
                return;
            }
            if (!(this.existingDelegate == null || (this.existingDelegate instanceof AutoLoggingAccessibilityDelegate))) {
                this.existingDelegate.sendAccessibilityEvent(view, i);
            }
            logEvent();
            AppMethodBeat.o(72043);
        }

        private void logEvent() {
            AppMethodBeat.i(72044);
            final String eventName = this.mapping.getEventName();
            final Bundle parameters = CodelessMatcher.getParameters(this.mapping, (View) this.rootView.get(), (View) this.hostView.get());
            if (parameters.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
                parameters.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(parameters.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
            }
            parameters.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    AppMethodBeat.i(72041);
                    AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
                    AppMethodBeat.o(72041);
                }
            });
            AppMethodBeat.o(72044);
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        public boolean getSupportButtonIndexing() {
            return this.supportButtonIndexing;
        }
    }

    static {
        AppMethodBeat.i(72046);
        AppMethodBeat.o(72046);
    }

    public static AutoLoggingAccessibilityDelegate getAccessibilityDelegate(EventBinding eventBinding, View view, View view2) {
        AppMethodBeat.i(72045);
        AutoLoggingAccessibilityDelegate autoLoggingAccessibilityDelegate = new AutoLoggingAccessibilityDelegate(eventBinding, view, view2);
        AppMethodBeat.o(72045);
        return autoLoggingAccessibilityDelegate;
    }
}
