package android.support.p069v7.widget;

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

/* renamed from: android.support.v7.widget.e */
class C41538e extends DataSetObservable {
    static final String LOG_TAG = C41538e.class.getSimpleName();
    private static final Object ael = new Object();
    private static final Map<String, C41538e> aem = new HashMap();
    final Object aen;
    final List<C37145a> aeo;
    private final List<C31890c> aep;
    final String aeq;
    private C31889b aer;
    private int aes;
    boolean aet;
    private boolean aeu;
    private boolean aev;
    private boolean aew;
    private C31891d aex;
    final Context mContext;
    private Intent mIntent;

    /* renamed from: android.support.v7.widget.e$e */
    final class C0712e extends AsyncTask<Object, Void, Void> {
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1578b(objArr);
        }

        C0712e() {
        }

        /* renamed from: b */
        private Void m1578b(Object... objArr) {
            String str;
            int i = 0;
            List list = (List) objArr[0];
            try {
                FileOutputStream openFileOutput = C41538e.this.mContext.openFileOutput((String) objArr[1], 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.TRUE);
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C31890c c31890c = (C31890c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c31890c.aey.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c31890c.time));
                        newSerializer.attribute(null, "weight", String.valueOf(c31890c.weight));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    C41538e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    str = C41538e.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(C41538e.this.aeq);
                    C41538e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IllegalStateException e4) {
                    str = C41538e.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(C41538e.this.aeq);
                    C41538e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    str = C41538e.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(C41538e.this.aeq);
                    C41538e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th) {
                    C41538e.this.aet = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                }
            } catch (FileNotFoundException e9) {
                str = C41538e.LOG_TAG;
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.e$b */
    public interface C31889b {
    }

    /* renamed from: android.support.v7.widget.e$c */
    public static final class C31890c {
        public final ComponentName aey;
        public final long time;
        public final float weight;

        public C31890c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C31890c(ComponentName componentName, long j, float f) {
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
            C31890c c31890c = (C31890c) obj;
            if (this.aey == null) {
                if (c31890c.aey != null) {
                    return false;
                }
            } else if (!this.aey.equals(c31890c.aey)) {
                return false;
            }
            if (this.time != c31890c.time) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(c31890c.weight)) {
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

    /* renamed from: android.support.v7.widget.e$d */
    public interface C31891d {
        /* renamed from: hp */
        boolean mo51986hp();
    }

    /* renamed from: android.support.v7.widget.e$a */
    public static final class C37145a implements Comparable<C37145a> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((C37145a) obj).weight) - Float.floatToIntBits(this.weight);
        }

        public C37145a(ResolveInfo resolveInfo) {
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
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((C37145a) obj).weight)) {
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

    /* renamed from: hg */
    public final int mo66557hg() {
        int size;
        synchronized (this.aen) {
            mo66559hj();
            size = this.aeo.size();
        }
        return size;
    }

    /* renamed from: bu */
    public final ResolveInfo mo66554bu(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.aen) {
            mo66559hj();
            resolveInfo = ((C37145a) this.aeo.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    /* renamed from: a */
    public final int mo66552a(ResolveInfo resolveInfo) {
        synchronized (this.aen) {
            mo66559hj();
            List list = this.aeo;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C37145a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: bv */
    public final Intent mo66555bv(int i) {
        synchronized (this.aen) {
            if (this.mIntent == null) {
                return null;
            }
            mo66559hj();
            C37145a c37145a = (C37145a) this.aeo.get(i);
            ComponentName componentName = new ComponentName(c37145a.resolveInfo.activityInfo.packageName, c37145a.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.aex != null) {
                Intent intent2 = new Intent(intent);
                if (this.aex.mo51986hp()) {
                    return null;
                }
            }
            mo66553a(new C31890c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: hh */
    public final ResolveInfo mo66558hh() {
        synchronized (this.aen) {
            mo66559hj();
            if (this.aeo.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C37145a) this.aeo.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    /* renamed from: hi */
    private void m72693hi() {
        if (!this.aeu) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.aev) {
            this.aev = false;
            if (!TextUtils.isEmpty(this.aeq)) {
                new C0712e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.aep), this.aeq});
            }
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.aen) {
            mo66559hj();
            size = this.aep.size();
        }
        return size;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hj */
    public final void mo66559hj() {
        int hl = m72695hl() | m72696hm();
        m72697hn();
        if (hl != 0) {
            m72694hk();
            notifyChanged();
        }
    }

    /* renamed from: hk */
    private boolean m72694hk() {
        if (this.aer == null || this.mIntent == null || this.aeo.isEmpty() || this.aep.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.aep);
        return true;
    }

    /* renamed from: hl */
    private boolean m72695hl() {
        if (!this.aew || this.mIntent == null) {
            return false;
        }
        this.aew = false;
        this.aeo.clear();
        List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.aeo.add(new C37145a((ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: hm */
    private boolean m72696hm() {
        if (!this.aet || !this.aev || TextUtils.isEmpty(this.aeq)) {
            return false;
        }
        this.aet = false;
        this.aeu = true;
        m72698ho();
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo66553a(C31890c c31890c) {
        boolean add = this.aep.add(c31890c);
        if (add) {
            this.aev = true;
            m72697hn();
            m72693hi();
            m72694hk();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: hn */
    private void m72697hn() {
        int size = this.aep.size() - this.aes;
        if (size > 0) {
            this.aev = true;
            for (int i = 0; i < size; i++) {
                this.aep.remove(0);
            }
        }
    }

    /* renamed from: ho */
    private void m72698ho() {
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
                                    list.add(new C31890c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
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
