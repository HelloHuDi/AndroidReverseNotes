package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class e extends DataSetObservable {
    static final String LOG_TAG = e.class.getSimpleName();
    private static final Object ael = new Object();
    private static final Map<String, e> aem = new HashMap();
    final Object aen;
    final List<a> aeo;
    private final List<c> aep;
    final String aeq;
    private b aer;
    private int aes;
    boolean aet;
    private boolean aeu;
    private boolean aev;
    private boolean aew;
    private d aex;
    final Context mContext;
    private Intent mIntent;

    final class e extends AsyncTask<Object, Void, Void> {
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return b(objArr);
        }

        e() {
        }

        private Void b(Object... objArr) {
            String str;
            int i = 0;
            List list = (List) objArr[0];
            try {
                FileOutputStream openFileOutput = e.this.mContext.openFileOutput((String) objArr[1], 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.TRUE);
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        c cVar = (c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", cVar.aey.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(cVar.time));
                        newSerializer.attribute(null, "weight", String.valueOf(cVar.weight));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    str = e.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(e.this.aeq);
                    e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IllegalStateException e4) {
                    str = e.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(e.this.aeq);
                    e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    str = e.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(e.this.aeq);
                    e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th) {
                    e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                }
            } catch (FileNotFoundException e9) {
                str = e.LOG_TAG;
            }
            return null;
        }
    }

    public interface b {
    }

    public static final class c {
        public final ComponentName aey;
        public final long time;
        public final float weight;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.aey = componentName;
            this.time = j;
            this.weight = f;
        }

        public final int hashCode() {
            return (((((this.aey == null ? 0 : this.aey.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.aey == null) {
                if (cVar.aey != null) {
                    return false;
                }
            } else if (!this.aey.equals(cVar.aey)) {
                return false;
            }
            if (this.time != cVar.time) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(cVar.weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.aey);
            stringBuilder.append("; time:").append(this.time);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface d {
        boolean hp();
    }

    public static final class a implements Comparable<a> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((a) obj).weight) - Float.floatToIntBits(this.weight);
        }

        public a(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((a) obj).weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public final int hg() {
        int size;
        synchronized (this.aen) {
            hj();
            size = this.aeo.size();
        }
        return size;
    }

    public final ResolveInfo bu(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.aen) {
            hj();
            resolveInfo = ((a) this.aeo.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.aen) {
            hj();
            List list = this.aeo;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent bv(int i) {
        synchronized (this.aen) {
            if (this.mIntent == null) {
                return null;
            }
            hj();
            a aVar = (a) this.aeo.get(i);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.aex != null) {
                Intent intent2 = new Intent(intent);
                if (this.aex.hp()) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo hh() {
        synchronized (this.aen) {
            hj();
            if (this.aeo.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.aeo.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    private void hi() {
        if (!this.aeu) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.aev) {
            this.aev = false;
            if (!TextUtils.isEmpty(this.aeq)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.aep), this.aeq});
            }
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.aen) {
            hj();
            size = this.aep.size();
        }
        return size;
    }

    /* Access modifiers changed, original: final */
    public final void hj() {
        int hl = hl() | hm();
        hn();
        if (hl != 0) {
            hk();
            notifyChanged();
        }
    }

    private boolean hk() {
        if (this.aer == null || this.mIntent == null || this.aeo.isEmpty() || this.aep.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.aep);
        return true;
    }

    private boolean hl() {
        if (!this.aew || this.mIntent == null) {
            return false;
        }
        this.aew = false;
        this.aeo.clear();
        List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.aeo.add(new a((ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean hm() {
        if (!this.aet || !this.aev || TextUtils.isEmpty(this.aeq)) {
            return false;
        }
        this.aet = false;
        this.aeu = true;
        ho();
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(c cVar) {
        boolean add = this.aep.add(cVar);
        if (add) {
            this.aev = true;
            hn();
            hi();
            hk();
            notifyChanged();
        }
        return add;
    }

    private void hn() {
        int size = this.aep.size() - this.aes;
        if (size > 0) {
            this.aev = true;
            for (int i = 0; i < size; i++) {
                this.aep.remove(0);
            }
        }
    }

    private void ho() {
        try {
            FileInputStream openFileInput = this.mContext.openFileInput(this.aeq);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.aep;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next != 1) {
                            if (!(next == 3 || next == 4)) {
                                if ("historical-record".equals(newPullParser.getName())) {
                                    list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                                } else {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                            }
                        } else if (openFileInput != null) {
                            try {
                                openFileInput.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (XmlPullParserException e2) {
                new StringBuilder("Error reading historical recrod file: ").append(this.aeq);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                new StringBuilder("Error reading historical recrod file: ").append(this.aeq);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (FileNotFoundException e7) {
        }
    }
}
