package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodelessMatcher {
    private static final String CURRENT_CLASS_NAME = ".";
    private static final String PARENT_CLASS_NAME = "..";
    private static final String TAG = CodelessMatcher.class.getCanonicalName();
    private Set<Activity> activitiesSet = new HashSet();
    private HashMap<String, String> delegateMap = new HashMap();
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<ViewMatcher> viewMatchers = new HashSet();

    protected static class ViewMatcher implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        private final String activityName;
        private HashMap<String, String> delegateMap;
        private List<EventBinding> eventBindings;
        private final Handler handler;
        private WeakReference<View> rootView;

        public ViewMatcher(View view, Handler handler, HashMap<String, String> hashMap, String str) {
            AppMethodBeat.m2504i(72050);
            this.rootView = new WeakReference(view);
            this.handler = handler;
            this.delegateMap = hashMap;
            this.activityName = str;
            this.handler.postDelayed(this, 200);
            AppMethodBeat.m2505o(72050);
        }

        public void run() {
            AppMethodBeat.m2504i(72051);
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                AppMethodBeat.m2505o(72051);
                return;
            }
            this.eventBindings = EventBinding.parseArray(appSettingsWithoutQuery.getEventBindings());
            if (this.eventBindings != null) {
                View view = (View) this.rootView.get();
                if (view == null) {
                    AppMethodBeat.m2505o(72051);
                    return;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                    viewTreeObserver.addOnScrollChangedListener(this);
                }
                startMatch();
            }
            AppMethodBeat.m2505o(72051);
        }

        public void onGlobalLayout() {
            AppMethodBeat.m2504i(72052);
            startMatch();
            AppMethodBeat.m2505o(72052);
        }

        public void onScrollChanged() {
            AppMethodBeat.m2504i(72053);
            startMatch();
            AppMethodBeat.m2505o(72053);
        }

        private void startMatch() {
            AppMethodBeat.m2504i(72054);
            if (this.eventBindings != null && this.rootView.get() != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.eventBindings.size()) {
                        break;
                    }
                    findView((EventBinding) this.eventBindings.get(i2), (View) this.rootView.get());
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(72054);
        }

        public void findView(EventBinding eventBinding, View view) {
            AppMethodBeat.m2504i(72055);
            if (eventBinding == null || view == null) {
                AppMethodBeat.m2505o(72055);
            } else if (TextUtils.isEmpty(eventBinding.getActivityName()) || eventBinding.getActivityName().equals(this.activityName)) {
                List viewPath = eventBinding.getViewPath();
                if (viewPath.size() > 25) {
                    AppMethodBeat.m2505o(72055);
                    return;
                }
                for (MatchedView attachListener : findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName)) {
                    attachListener(attachListener, view, eventBinding);
                }
                AppMethodBeat.m2505o(72055);
            } else {
                AppMethodBeat.m2505o(72055);
            }
        }

        public static List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            int i3 = 0;
            AppMethodBeat.m2504i(72056);
            String str2 = str + CodelessMatcher.CURRENT_CLASS_NAME + String.valueOf(i2);
            ArrayList arrayList = new ArrayList();
            if (view == null) {
                AppMethodBeat.m2505o(72056);
                return arrayList;
            }
            List findVisibleChildren;
            int size;
            if (i >= list.size()) {
                arrayList.add(new MatchedView(view, str2));
            } else {
                PathComponent pathComponent = (PathComponent) list.get(i);
                if (pathComponent.className.equals(CodelessMatcher.PARENT_CLASS_NAME)) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        findVisibleChildren = findVisibleChildren((ViewGroup) parent);
                        size = findVisibleChildren.size();
                        while (i3 < size) {
                            arrayList.addAll(findViewByPath(eventBinding, (View) findVisibleChildren.get(i3), list, i + 1, i3, str2));
                            i3++;
                        }
                    }
                    AppMethodBeat.m2505o(72056);
                    return arrayList;
                } else if (pathComponent.className.equals(CodelessMatcher.CURRENT_CLASS_NAME)) {
                    arrayList.add(new MatchedView(view, str2));
                    AppMethodBeat.m2505o(72056);
                    return arrayList;
                } else if (!isTheSameView(view, pathComponent, i2)) {
                    AppMethodBeat.m2505o(72056);
                    return arrayList;
                } else if (i == list.size() - 1) {
                    arrayList.add(new MatchedView(view, str2));
                }
            }
            if (view instanceof ViewGroup) {
                findVisibleChildren = findVisibleChildren((ViewGroup) view);
                size = findVisibleChildren.size();
                while (i3 < size) {
                    arrayList.addAll(findViewByPath(eventBinding, (View) findVisibleChildren.get(i3), list, i + 1, i3, str2));
                    i3++;
                }
            }
            AppMethodBeat.m2505o(72056);
            return arrayList;
        }

        private static boolean isTheSameView(View view, PathComponent pathComponent, int i) {
            AppMethodBeat.m2504i(72057);
            if (pathComponent.index == -1 || i == pathComponent.index) {
                if (!view.getClass().getCanonicalName().equals(pathComponent.className)) {
                    if (pathComponent.className.matches(".*android\\..*")) {
                        String[] split = pathComponent.className.split("\\.");
                        if (split.length > 0) {
                            if (!view.getClass().getSimpleName().equals(split[split.length - 1])) {
                                AppMethodBeat.m2505o(72057);
                                return false;
                            }
                        }
                        AppMethodBeat.m2505o(72057);
                        return false;
                    }
                    AppMethodBeat.m2505o(72057);
                    return false;
                }
                if ((pathComponent.matchBitmask & MatchBitmaskType.ID.getValue()) > 0 && pathComponent.f1029id != view.getId()) {
                    AppMethodBeat.m2505o(72057);
                    return false;
                } else if ((pathComponent.matchBitmask & MatchBitmaskType.TEXT.getValue()) <= 0 || pathComponent.text.equals(ViewHierarchy.getTextOfView(view))) {
                    String str;
                    Object obj;
                    if ((pathComponent.matchBitmask & MatchBitmaskType.DESCRIPTION.getValue()) > 0) {
                        str = pathComponent.description;
                        if (view.getContentDescription() == null) {
                            obj = "";
                        } else {
                            obj = String.valueOf(view.getContentDescription());
                        }
                        if (!str.equals(obj)) {
                            AppMethodBeat.m2505o(72057);
                            return false;
                        }
                    }
                    if ((pathComponent.matchBitmask & MatchBitmaskType.HINT.getValue()) <= 0 || pathComponent.hint.equals(ViewHierarchy.getHintOfView(view))) {
                        if ((pathComponent.matchBitmask & MatchBitmaskType.TAG.getValue()) > 0) {
                            str = pathComponent.tag;
                            if (view.getTag() == null) {
                                obj = "";
                            } else {
                                obj = String.valueOf(view.getTag());
                            }
                            if (!str.equals(obj)) {
                                AppMethodBeat.m2505o(72057);
                                return false;
                            }
                        }
                        AppMethodBeat.m2505o(72057);
                        return true;
                    }
                    AppMethodBeat.m2505o(72057);
                    return false;
                } else {
                    AppMethodBeat.m2505o(72057);
                    return false;
                }
            }
            AppMethodBeat.m2505o(72057);
            return false;
        }

        private static List<View> findVisibleChildren(ViewGroup viewGroup) {
            AppMethodBeat.m2504i(72058);
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            AppMethodBeat.m2505o(72058);
            return arrayList;
        }

        private void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            AppMethodBeat.m2504i(72059);
            if (eventBinding == null) {
                AppMethodBeat.m2505o(72059);
                return;
            }
            try {
                View view2 = matchedView.getView();
                if (view2 == null) {
                    AppMethodBeat.m2505o(72059);
                } else if (ViewHierarchy.isRCTButton(view2)) {
                    attachRCTListener(matchedView, view, eventBinding);
                    AppMethodBeat.m2505o(72059);
                } else {
                    Object obj;
                    String viewMapKey = matchedView.getViewMapKey();
                    AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view2);
                    Object obj2 = existingDelegate != null ? 1 : null;
                    if (obj2 == null || !(existingDelegate instanceof AutoLoggingAccessibilityDelegate)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    Object obj3;
                    if (obj == null || !((AutoLoggingAccessibilityDelegate) existingDelegate).getSupportCodelessLogging()) {
                        obj3 = null;
                    } else {
                        obj3 = 1;
                    }
                    if (!this.delegateMap.containsKey(viewMapKey) && (obj2 == null || obj == null || obj3 == null)) {
                        view2.setAccessibilityDelegate(CodelessLoggingEventListener.getAccessibilityDelegate(eventBinding, view, view2));
                        this.delegateMap.put(viewMapKey, eventBinding.getEventName());
                    }
                    AppMethodBeat.m2505o(72059);
                }
            } catch (FacebookException e) {
                CodelessMatcher.TAG;
                AppMethodBeat.m2505o(72059);
            }
        }

        private void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            AppMethodBeat.m2504i(72060);
            if (eventBinding == null) {
                AppMethodBeat.m2505o(72060);
                return;
            }
            View view2 = matchedView.getView();
            if (view2 == null || !ViewHierarchy.isRCTButton(view2)) {
                AppMethodBeat.m2505o(72060);
                return;
            }
            Object obj;
            String viewMapKey = matchedView.getViewMapKey();
            OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
            Object obj2 = existingOnTouchListener != null ? 1 : null;
            if (obj2 == null || !(existingOnTouchListener instanceof AutoLoggingOnTouchListener)) {
                obj = null;
            } else {
                obj = 1;
            }
            Object obj3;
            if (obj == null || !((AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (!this.delegateMap.containsKey(viewMapKey) && (obj2 == null || obj == null || obj3 == null)) {
                view2.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view2));
                this.delegateMap.put(viewMapKey, eventBinding.getEventName());
            }
            AppMethodBeat.m2505o(72060);
        }
    }

    public static class MatchedView {
        private WeakReference<View> view;
        private String viewMapKey;

        public MatchedView(View view, String str) {
            AppMethodBeat.m2504i(72048);
            this.view = new WeakReference(view);
            this.viewMapKey = str;
            AppMethodBeat.m2505o(72048);
        }

        public View getView() {
            AppMethodBeat.m2504i(72049);
            if (this.view == null) {
                AppMethodBeat.m2505o(72049);
                return null;
            }
            View view = (View) this.view.get();
            AppMethodBeat.m2505o(72049);
            return view;
        }

        public String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    /* renamed from: com.facebook.appevents.codeless.CodelessMatcher$1 */
    class C254821 implements Runnable {
        C254821() {
        }

        public void run() {
            AppMethodBeat.m2504i(72047);
            CodelessMatcher.access$000(CodelessMatcher.this);
            AppMethodBeat.m2505o(72047);
        }
    }

    static /* synthetic */ void access$000(CodelessMatcher codelessMatcher) {
        AppMethodBeat.m2504i(72067);
        codelessMatcher.matchViews();
        AppMethodBeat.m2505o(72067);
    }

    static {
        AppMethodBeat.m2504i(72068);
        AppMethodBeat.m2505o(72068);
    }

    public CodelessMatcher() {
        AppMethodBeat.m2504i(72061);
        AppMethodBeat.m2505o(72061);
    }

    public void add(Activity activity) {
        AppMethodBeat.m2504i(72062);
        if (InternalSettings.isUnityApp()) {
            AppMethodBeat.m2505o(72062);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            FacebookException facebookException = new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
            AppMethodBeat.m2505o(72062);
            throw facebookException;
        } else {
            this.activitiesSet.add(activity);
            this.delegateMap.clear();
            startTracking();
            AppMethodBeat.m2505o(72062);
        }
    }

    public void remove(Activity activity) {
        AppMethodBeat.m2504i(72063);
        if (InternalSettings.isUnityApp()) {
            AppMethodBeat.m2505o(72063);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            FacebookException facebookException = new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
            AppMethodBeat.m2505o(72063);
            throw facebookException;
        } else {
            this.activitiesSet.remove(activity);
            this.viewMatchers.clear();
            this.delegateMap.clear();
            AppMethodBeat.m2505o(72063);
        }
    }

    public static Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        AppMethodBeat.m2504i(72064);
        Bundle bundle = new Bundle();
        if (eventBinding == null) {
            AppMethodBeat.m2505o(72064);
            return bundle;
        }
        List<ParameterComponent> viewParameters = eventBinding.getViewParameters();
        if (viewParameters != null) {
            for (ParameterComponent parameterComponent : viewParameters) {
                if (parameterComponent.value != null && parameterComponent.value.length() > 0) {
                    bundle.putString(parameterComponent.name, parameterComponent.value);
                } else if (parameterComponent.path.size() > 0) {
                    List findViewByPath;
                    if (parameterComponent.pathType.equals(Constants.PATH_TYPE_RELATIVE)) {
                        findViewByPath = ViewMatcher.findViewByPath(eventBinding, view2, parameterComponent.path, 0, -1, view2.getClass().getSimpleName());
                    } else {
                        findViewByPath = ViewMatcher.findViewByPath(eventBinding, view, parameterComponent.path, 0, -1, view.getClass().getSimpleName());
                    }
                    for (MatchedView matchedView : findViewByPath) {
                        if (matchedView.getView() != null) {
                            String textOfView = ViewHierarchy.getTextOfView(matchedView.getView());
                            if (textOfView.length() > 0) {
                                bundle.putString(parameterComponent.name, textOfView);
                                break;
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(72064);
        return bundle;
    }

    private void startTracking() {
        AppMethodBeat.m2504i(72065);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            matchViews();
            AppMethodBeat.m2505o(72065);
            return;
        }
        this.uiThreadHandler.post(new C254821());
        AppMethodBeat.m2505o(72065);
    }

    private void matchViews() {
        AppMethodBeat.m2504i(72066);
        for (Activity activity : this.activitiesSet) {
            this.viewMatchers.add(new ViewMatcher(activity.getWindow().getDecorView().getRootView(), this.uiThreadHandler, this.delegateMap, activity.getClass().getSimpleName()));
        }
        AppMethodBeat.m2505o(72066);
    }
}
