package com.tencent.tinker.loader.hotplug;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Xml;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class IncrementComponentManager {
    private static final Map<String, ActivityInfo> ADo = new HashMap();
    private static final Map<String, IntentFilter> ADp = new HashMap();
    private static final AttrTranslator<ActivityInfo> ADq = new AttrTranslator<ActivityInfo>() {
        /* Access modifiers changed, original: final|synthetic */
        public final /* synthetic */ void a(Context context, String str, String str2, Object obj) {
            int i = 1;
            int i2 = 0;
            ActivityInfo activityInfo = (ActivityInfo) obj;
            if ("name".equals(str)) {
                if (str2.charAt(i2) == '.') {
                    activityInfo.name = context.getPackageName() + str2;
                } else {
                    activityInfo.name = str2;
                }
            } else if ("parentActivityName".equals(str)) {
                if (VERSION.SDK_INT < 16) {
                    return;
                }
                if (str2.charAt(i2) == '.') {
                    activityInfo.parentActivityName = context.getPackageName() + str2;
                } else {
                    activityInfo.parentActivityName = str2;
                }
            } else if ("exported".equals(str)) {
                activityInfo.exported = "true".equalsIgnoreCase(str2);
            } else if ("launchMode".equals(str)) {
                if (!"standard".equalsIgnoreCase(str2)) {
                    if (!"singleTop".equalsIgnoreCase(str2)) {
                        if ("singleTask".equalsIgnoreCase(str2)) {
                            i = 2;
                        } else if ("singleInstance".equalsIgnoreCase(str2)) {
                            i = 3;
                        }
                    }
                    activityInfo.launchMode = i;
                }
                i = i2;
                activityInfo.launchMode = i;
            } else if ("theme".equals(str)) {
                activityInfo.theme = context.getResources().getIdentifier(str2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName());
            } else if ("uiOptions".equals(str)) {
                if (VERSION.SDK_INT >= 14) {
                    activityInfo.uiOptions = Integer.decode(str2).intValue();
                }
            } else if ("permission".equals(str)) {
                activityInfo.permission = str2;
            } else if ("taskAffinity".equals(str)) {
                activityInfo.taskAffinity = str2;
            } else if ("multiprocess".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 1;
                } else {
                    activityInfo.flags &= -2;
                }
            } else if ("finishOnTaskLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2;
                } else {
                    activityInfo.flags &= -3;
                }
            } else if ("clearTaskOnLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4;
                } else {
                    activityInfo.flags &= -5;
                }
            } else if ("noHistory".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 128;
                } else {
                    activityInfo.flags &= -129;
                }
            } else if ("alwaysRetainTaskState".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8;
                } else {
                    activityInfo.flags &= -9;
                }
            } else if ("stateNotNeeded".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16;
                } else {
                    activityInfo.flags &= -17;
                }
            } else if ("excludeFromRecents".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 32;
                } else {
                    activityInfo.flags &= -33;
                }
            } else if ("allowTaskReparenting".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 64;
                } else {
                    activityInfo.flags &= -65;
                }
            } else if ("finishOnCloseSystemDialogs".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 256;
                } else {
                    activityInfo.flags &= -257;
                }
            } else if ("showOnLockScreen".equals(str) || "showForAllUsers".equals(str)) {
                if (VERSION.SDK_INT >= 23) {
                    i = ShareReflectUtil.e(ActivityInfo.class, "FLAG_SHOW_FOR_ALL_USERS");
                    if ("true".equalsIgnoreCase(str2)) {
                        activityInfo.flags = i | activityInfo.flags;
                        return;
                    }
                    activityInfo.flags = (i ^ -1) & activityInfo.flags;
                }
            } else if ("immersive".equals(str)) {
                if (VERSION.SDK_INT < 18) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2048;
                } else {
                    activityInfo.flags &= -2049;
                }
            } else if ("hardwareAccelerated".equals(str)) {
                if (VERSION.SDK_INT < 11) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 512;
                } else {
                    activityInfo.flags &= -513;
                }
            } else if ("documentLaunchMode".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.documentLaunchMode = Integer.decode(str2).intValue();
                }
            } else if ("maxRecents".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.maxRecents = Integer.decode(str2).intValue();
                }
            } else if ("configChanges".equals(str)) {
                activityInfo.configChanges = Integer.decode(str2).intValue();
            } else if ("windowSoftInputMode".equals(str)) {
                activityInfo.softInputMode = Integer.decode(str2).intValue();
            } else if ("persistableMode".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.persistableMode = Integer.decode(str2).intValue();
                }
            } else if ("allowEmbedded".equals(str)) {
                i = ShareReflectUtil.e(ActivityInfo.class, "FLAG_ALLOW_EMBEDDED");
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags = i | activityInfo.flags;
                    return;
                }
                activityInfo.flags = (i ^ -1) & activityInfo.flags;
            } else if ("autoRemoveFromRecents".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                } else {
                    activityInfo.flags &= -8193;
                }
            } else if ("relinquishTaskIdentity".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4096;
                } else {
                    activityInfo.flags &= -4097;
                }
            } else if ("resumeWhilePausing".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16384;
                } else {
                    activityInfo.flags &= -16385;
                }
            } else if ("screenOrientation".equals(str)) {
                if (!"unspecified".equalsIgnoreCase(str2)) {
                    if ("behind".equalsIgnoreCase(str2)) {
                        i2 = 3;
                    } else if (!"landscape".equalsIgnoreCase(str2)) {
                        if ("portrait".equalsIgnoreCase(str2)) {
                            i2 = 1;
                        } else if ("reverseLandscape".equalsIgnoreCase(str2)) {
                            i2 = 8;
                        } else if ("reversePortrait".equalsIgnoreCase(str2)) {
                            i2 = 9;
                        } else if ("sensorLandscape".equalsIgnoreCase(str2)) {
                            i2 = 6;
                        } else if ("sensorPortrait".equalsIgnoreCase(str2)) {
                            i2 = 7;
                        } else if ("sensor".equalsIgnoreCase(str2)) {
                            i2 = 4;
                        } else if ("fullSensor".equalsIgnoreCase(str2)) {
                            i2 = 10;
                        } else if ("nosensor".equalsIgnoreCase(str2)) {
                            i2 = 5;
                        } else if ("user".equalsIgnoreCase(str2)) {
                            i2 = 2;
                        } else if (VERSION.SDK_INT >= 18 && "fullUser".equalsIgnoreCase(str2)) {
                            i2 = 13;
                        } else if (VERSION.SDK_INT >= 18 && "locked".equalsIgnoreCase(str2)) {
                            i2 = 14;
                        } else if (VERSION.SDK_INT >= 18 && "userLandscape".equalsIgnoreCase(str2)) {
                            i2 = 11;
                        } else if (VERSION.SDK_INT >= 18 && "userPortrait".equalsIgnoreCase(str2)) {
                            i2 = 12;
                        }
                    }
                    activityInfo.screenOrientation = i2;
                }
                i2 = -1;
                activityInfo.screenOrientation = i2;
            } else if ("label".equals(str)) {
                try {
                    i2 = context.getResources().getIdentifier(str2, "string", IncrementComponentManager.sPackageName);
                } catch (Throwable th) {
                }
                if (i2 != 0) {
                    activityInfo.labelRes = i2;
                } else {
                    activityInfo.nonLocalizedLabel = str2;
                }
            } else if ("icon".equals(str)) {
                try {
                    activityInfo.icon = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                } catch (Throwable th2) {
                }
            } else if ("banner".equals(str)) {
                if (VERSION.SDK_INT >= 20) {
                    try {
                        activityInfo.banner = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                    } catch (Throwable th3) {
                    }
                }
            } else if ("logo".equals(str)) {
                try {
                    activityInfo.logo = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                } catch (Throwable th4) {
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void j(XmlPullParser xmlPullParser) {
            try {
                if (xmlPullParser.getEventType() != 2 || !"activity".equals(xmlPullParser.getName())) {
                    throw new IllegalStateException("unexpected xml parser state when parsing incremental component manifest.");
                }
            } catch (XmlPullParserException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private static volatile boolean eIC = false;
    private static Context sContext = null;
    private static String sPackageName = null;

    static abstract class AttrTranslator<T_RESULT> {
        public abstract void a(Context context, String str, String str2, T_RESULT t_result);

        private AttrTranslator() {
        }

        /* synthetic */ AttrTranslator(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void a(Context context, XmlPullParser xmlPullParser, T_RESULT t_result) {
            j(xmlPullParser);
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                if ("android".equals(xmlPullParser.getAttributePrefix(i))) {
                    a(context, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i), t_result);
                }
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void j(XmlPullParser xmlPullParser) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0099 A:{Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }, Splitter:B:15:0x003b, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:48:0x0099, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:60:0x00ae, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:61:0x00af, code skipped:
            r2 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(Context context, ShareSecurityCheck shareSecurityCheck) {
        StringReader stringReader;
        boolean z;
        Throwable e;
        XmlPullParser xmlPullParser;
        XmlPullParser xmlPullParser2 = null;
        synchronized (IncrementComponentManager.class) {
            if (shareSecurityCheck.AFg.containsKey("assets/inc_component_meta.txt")) {
                Context context2 = context;
                while (context2 instanceof ContextWrapper) {
                    context = ((ContextWrapper) context2).getBaseContext();
                    if (context == null) {
                        break;
                    }
                    context2 = context;
                }
                sContext = context2;
                sPackageName = context2.getPackageName();
                stringReader = new StringReader((String) shareSecurityCheck.AFg.get("assets/inc_component_meta.txt"));
                try {
                    xmlPullParser2 = Xml.newPullParser();
                    xmlPullParser2.setInput(stringReader);
                    for (int eventType = xmlPullParser2.getEventType(); eventType != 1; eventType = xmlPullParser2.next()) {
                        switch (eventType) {
                            case 2:
                                String name = xmlPullParser2.getName();
                                if (!"activity".equalsIgnoreCase(name)) {
                                    if (!("service".equalsIgnoreCase(name) || "receiver".equalsIgnoreCase(name))) {
                                        "provider".equalsIgnoreCase(name);
                                        break;
                                    }
                                }
                                ActivityInfo a = a(context2, xmlPullParser2);
                                ADo.put(a.name, a);
                                break;
                            default:
                                break;
                        }
                    }
                    eIC = true;
                    if (xmlPullParser2 != null) {
                        try {
                            xmlPullParser2.setInput(null);
                        } catch (Throwable th) {
                        }
                    }
                    SharePatchFileUtil.ah(stringReader);
                    z = true;
                } catch (XmlPullParserException e2) {
                    e = e2;
                    xmlPullParser = xmlPullParser2;
                } catch (Throwable th2) {
                }
            } else {
                z = false;
            }
        }
        return z;
        try {
            throw new IOException(e);
        } catch (Throwable th3) {
            e = th3;
            xmlPullParser2 = xmlPullParser;
            if (xmlPullParser2 != null) {
                try {
                    xmlPullParser2.setInput(null);
                } catch (Throwable th4) {
                }
            }
            SharePatchFileUtil.ah(stringReader);
            throw e;
        }
    }

    private static synchronized ActivityInfo a(Context context, XmlPullParser xmlPullParser) {
        ActivityInfo activityInfo;
        synchronized (IncrementComponentManager.class) {
            activityInfo = new ActivityInfo();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            activityInfo.applicationInfo = applicationInfo;
            activityInfo.packageName = sPackageName;
            activityInfo.processName = applicationInfo.processName;
            activityInfo.launchMode = 0;
            activityInfo.permission = applicationInfo.permission;
            activityInfo.screenOrientation = -1;
            activityInfo.taskAffinity = applicationInfo.taskAffinity;
            if (VERSION.SDK_INT >= 11 && (applicationInfo.flags & 536870912) != 0) {
                activityInfo.flags |= 512;
            }
            if (VERSION.SDK_INT >= 21) {
                activityInfo.documentLaunchMode = 0;
            }
            if (VERSION.SDK_INT >= 14) {
                activityInfo.uiOptions = applicationInfo.uiOptions;
            }
            ADq.a(context, xmlPullParser, activityInfo);
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if ("intent-filter".equalsIgnoreCase(name)) {
                        b(activityInfo.name, xmlPullParser);
                    } else if ("meta-data".equalsIgnoreCase(name)) {
                        a(activityInfo, xmlPullParser);
                    }
                }
            }
        }
        return activityInfo;
    }

    private static synchronized void b(String str, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            IntentFilter intentFilter = new IntentFilter();
            String attributeValue = xmlPullParser.getAttributeValue(null, DownloadInfo.PRIORITY);
            if (!TextUtils.isEmpty(attributeValue)) {
                intentFilter.setPriority(Integer.decode(attributeValue).intValue());
            }
            if (!TextUtils.isEmpty(xmlPullParser.getAttributeValue(null, "autoVerify"))) {
                try {
                    ShareReflectUtil.c(IntentFilter.class, "setAutoVerify", Boolean.TYPE).invoke(intentFilter, new Object[]{Boolean.valueOf("true".equalsIgnoreCase(attributeValue))});
                } catch (Throwable th) {
                }
            }
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                    ADp.put(str, intentFilter);
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if (NativeProtocol.WEB_DIALOG_ACTION.equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "name");
                        if (name != null) {
                            intentFilter.addAction(name);
                        }
                    } else if ("category".equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "name");
                        if (name != null) {
                            intentFilter.addCategory(name);
                        }
                    } else if ("data".equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "mimeType");
                        if (name != null) {
                            try {
                                intentFilter.addDataType(name);
                            } catch (MalformedMimeTypeException e) {
                                throw new XmlPullParserException("bad mimeType", xmlPullParser, e);
                            }
                        }
                        name = xmlPullParser.getAttributeValue(null, "scheme");
                        if (name != null) {
                            intentFilter.addDataScheme(name);
                        }
                        if (VERSION.SDK_INT >= 19) {
                            name = xmlPullParser.getAttributeValue(null, "ssp");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 0);
                            }
                            name = xmlPullParser.getAttributeValue(null, "sspPrefix");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 1);
                            }
                            name = xmlPullParser.getAttributeValue(null, "sspPattern");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 2);
                            }
                        }
                        name = xmlPullParser.getAttributeValue(null, "host");
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, "port");
                        if (name != null) {
                            intentFilter.addDataAuthority(name, attributeValue2);
                        }
                        name = xmlPullParser.getAttributeValue(null, "path");
                        if (name != null) {
                            intentFilter.addDataPath(name, 0);
                        }
                        name = xmlPullParser.getAttributeValue(null, "pathPrefix");
                        if (name != null) {
                            intentFilter.addDataPath(name, 1);
                        }
                        name = xmlPullParser.getAttributeValue(null, "pathPattern");
                        if (name != null) {
                            intentFilter.addDataPath(name, 2);
                        }
                    }
                    i(xmlPullParser);
                }
            }
            ADp.put(str, intentFilter);
        }
    }

    private static synchronized void a(ActivityInfo activityInfo, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            ClassLoader classLoader = IncrementComponentManager.class.getClassLoader();
            String attributeValue = xmlPullParser.getAttributeValue(null, "name");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
            if (!TextUtils.isEmpty(attributeValue)) {
                if (activityInfo.metaData == null) {
                    activityInfo.metaData = new Bundle(classLoader);
                }
                activityInfo.metaData.putString(attributeValue, attributeValue2);
            }
        }
    }

    private static void i(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    private static synchronized void ensureInitialized() {
        synchronized (IncrementComponentManager.class) {
            if (eIC) {
            } else {
                throw new IllegalStateException("Not initialized!!");
            }
        }
    }

    public static boolean aum(String str) {
        ensureInitialized();
        return str != null && ADo.containsKey(str);
    }

    public static ActivityInfo aun(String str) {
        ensureInitialized();
        return str != null ? (ActivityInfo) ADo.get(str) : null;
    }

    public static ResolveInfo bc(Intent intent) {
        Object className;
        ensureInitialized();
        int i = -1;
        IntentFilter intentFilter = null;
        int i2 = 0;
        ComponentName component = intent.getComponent();
        if (component != null) {
            className = component.getClassName();
            if (ADo.containsKey(className)) {
                i = 0;
            } else {
                className = null;
            }
        } else {
            int i3;
            Iterator it = ADp.entrySet().iterator();
            String str = null;
            while (true) {
                i3 = i;
                if (!it.hasNext()) {
                    break;
                }
                Object obj;
                Entry entry = (Entry) it.next();
                String str2 = (String) entry.getKey();
                IntentFilter intentFilter2 = (IntentFilter) entry.getValue();
                int match = intentFilter2.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "Tinker.IncrementCompMgr");
                if (match == -3 || match == -4 || match == -2 || match == -1) {
                    obj = null;
                } else {
                    obj = 1;
                }
                i = intentFilter2.getPriority();
                if (obj == null || i <= i3) {
                    match = i2;
                    intentFilter2 = intentFilter;
                    str2 = str;
                    i = i3;
                }
                i2 = match;
                intentFilter = intentFilter2;
                str = str2;
            }
            String className2 = str;
            i = i3;
        }
        if (className2 == null) {
            return null;
        }
        ResolveInfo resolveInfo = new ResolveInfo();
        resolveInfo.activityInfo = (ActivityInfo) ADo.get(className2);
        resolveInfo.filter = intentFilter;
        resolveInfo.match = i2;
        resolveInfo.priority = i;
        resolveInfo.resolvePackageName = sPackageName;
        resolveInfo.icon = resolveInfo.activityInfo.icon;
        resolveInfo.labelRes = resolveInfo.activityInfo.labelRes;
        return resolveInfo;
    }

    private IncrementComponentManager() {
        throw new UnsupportedOperationException();
    }
}
