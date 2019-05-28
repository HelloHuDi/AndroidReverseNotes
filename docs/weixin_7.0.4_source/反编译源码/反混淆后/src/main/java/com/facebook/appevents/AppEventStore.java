package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventStore.class.getName();

    static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        /* Access modifiers changed, original: protected */
        public ObjectStreamClass readClassDescriptor() {
            AppMethodBeat.m2504i(71900);
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(SerializationProxyV1.class);
            } else if (readClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(SerializationProxyV1.class);
            }
            AppMethodBeat.m2505o(71900);
            return readClassDescriptor;
        }
    }

    AppEventStore() {
    }

    static {
        AppMethodBeat.m2504i(71905);
        AppMethodBeat.m2505o(71905);
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            AppMethodBeat.m2504i(71901);
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            if (readAndClearStore.containsKey(accessTokenAppIdPair)) {
                readAndClearStore.get(accessTokenAppIdPair).addAll(sessionEventsState.getEventsToPersist());
            } else {
                readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
            AppMethodBeat.m2505o(71901);
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            AppMethodBeat.m2504i(71902);
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
                readAndClearStore.addEvents(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair).getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
            AppMethodBeat.m2505o(71902);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A:{SYNTHETIC, Splitter:B:14:0x0037} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A:{SYNTHETIC, Splitter:B:14:0x0037} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A:{SYNTHETIC, Splitter:B:14:0x0037} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A:{SYNTHETIC, Splitter:B:14:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized PersistedEvents readAndClearStore() {
        PersistedEvents persistedEvents;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        synchronized (AppEventStore.class) {
            AppMethodBeat.m2504i(71903);
            AppEventUtility.assertIsNotMainThread();
            Context applicationContext = FacebookSdk.getApplicationContext();
            Closeable movedClassObjectInputStream;
            try {
                movedClassObjectInputStream = new MovedClassObjectInputStream(new BufferedInputStream(applicationContext.openFileInput(PERSISTED_EVENTS_FILENAME)));
                try {
                    persistedEvents = (PersistedEvents) movedClassObjectInputStream.readObject();
                    Utility.closeQuietly(movedClassObjectInputStream);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e) {
                    }
                } catch (FileNotFoundException e2) {
                    closeable = movedClassObjectInputStream;
                    Utility.closeQuietly(closeable);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        persistedEvents = null;
                    } catch (Exception e3) {
                        persistedEvents = null;
                    }
                    if (persistedEvents == null) {
                    }
                    AppMethodBeat.m2505o(71903);
                    return persistedEvents;
                } catch (Exception e4) {
                    Utility.closeQuietly(movedClassObjectInputStream);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        persistedEvents = null;
                    } catch (Exception e5) {
                        persistedEvents = null;
                    }
                    if (persistedEvents == null) {
                    }
                    AppMethodBeat.m2505o(71903);
                    return persistedEvents;
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = movedClassObjectInputStream;
                    Utility.closeQuietly(closeable2);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e6) {
                    }
                    AppMethodBeat.m2505o(71903);
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                closeable = null;
                Utility.closeQuietly(closeable);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                persistedEvents = null;
                if (persistedEvents == null) {
                }
                AppMethodBeat.m2505o(71903);
                return persistedEvents;
            } catch (Exception e8) {
                movedClassObjectInputStream = null;
                Utility.closeQuietly(movedClassObjectInputStream);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                persistedEvents = null;
                if (persistedEvents == null) {
                }
                AppMethodBeat.m2505o(71903);
                return persistedEvents;
            } catch (Throwable th3) {
                th = th3;
                Utility.closeQuietly(closeable2);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                AppMethodBeat.m2505o(71903);
                throw th;
            }
            if (persistedEvents == null) {
                persistedEvents = new PersistedEvents();
            }
            AppMethodBeat.m2505o(71903);
        }
        return persistedEvents;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A:{PHI: r0 , Splitter:B:3:0x001d, ExcHandler: all (r1_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0044, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x0045, code skipped:
            r2 = r1;
            r3 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void saveEventsToDisk(PersistedEvents persistedEvents) {
        AppMethodBeat.m2504i(71904);
        Context applicationContext = FacebookSdk.getApplicationContext();
        Closeable objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream);
                AppMethodBeat.m2505o(71904);
            } catch (Exception e) {
            } catch (Throwable th) {
            }
        } catch (Exception e2) {
            objectOutputStream = null;
            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            Utility.closeQuietly(objectOutputStream);
            AppMethodBeat.m2505o(71904);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            Closeable closeable = null;
            Utility.closeQuietly(closeable);
            AppMethodBeat.m2505o(71904);
            throw th3;
        }
    }
}
