package com.google.android.gms.common.server;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseApi {

    public static class FieldCollection<Parent> {
        private final Collector zzvw;
        private final Parent zzwc;

        protected FieldCollection(Parent parent, Collector collector) {
            Object parent2;
            AppMethodBeat.i(61431);
            if (parent2 == null) {
                parent2 = this;
            }
            this.zzwc = parent2;
            this.zzvw = collector;
            AppMethodBeat.o(61431);
        }

        /* Access modifiers changed, original: protected */
        public Collector getCollector() {
            return this.zzvw;
        }

        /* Access modifiers changed, original: protected */
        public Parent getParent() {
            return this.zzwc;
        }
    }

    public static abstract class BaseApiaryOptions<DerivedClassType extends BaseApiaryOptions<DerivedClassType>> {
        private final ArrayList<String> zzvt = new ArrayList();
        private final HashMap<String, String> zzvu = new HashMap();
        private String zzvv;
        private final Collector zzvw = new Collector();

        public final class Collector {
            private boolean zzvx;
            private boolean zzvy;
            private int zzvz;
            private StringBuilder zzwa = new StringBuilder();

            public Collector() {
                AppMethodBeat.i(61415);
                AppMethodBeat.o(61415);
            }

            private final void append(String str) {
                AppMethodBeat.i(61416);
                if (this.zzvx) {
                    this.zzvx = false;
                    this.zzwa.append(",");
                } else if (this.zzvy) {
                    this.zzvy = false;
                    this.zzwa.append("/");
                }
                this.zzwa.append(str);
                AppMethodBeat.o(61416);
            }

            public final void addPiece(String str) {
                AppMethodBeat.i(61417);
                append(str);
                this.zzvy = true;
                AppMethodBeat.o(61417);
            }

            public final void beginSubCollection(String str) {
                AppMethodBeat.i(61419);
                append(str);
                this.zzwa.append("(");
                this.zzvz++;
                AppMethodBeat.o(61419);
            }

            public final void endSubCollection() {
                AppMethodBeat.i(61420);
                this.zzwa.append(")");
                this.zzvz--;
                if (this.zzvz == 0) {
                    BaseApiaryOptions.this.addField(this.zzwa.toString());
                    this.zzwa.setLength(0);
                    this.zzvx = false;
                    this.zzvy = false;
                    AppMethodBeat.o(61420);
                    return;
                }
                this.zzvx = true;
                AppMethodBeat.o(61420);
            }

            public final void finishPiece(String str) {
                AppMethodBeat.i(61418);
                append(str);
                if (this.zzvz == 0) {
                    BaseApiaryOptions.this.addField(this.zzwa.toString());
                    this.zzwa.setLength(0);
                    AppMethodBeat.o(61418);
                    return;
                }
                this.zzvx = true;
                AppMethodBeat.o(61418);
            }
        }

        public BaseApiaryOptions() {
            AppMethodBeat.i(61421);
            AppMethodBeat.o(61421);
        }

        private static String zzcy() {
            AppMethodBeat.i(61430);
            String valueOf = String.valueOf(!DeviceProperties.isUserBuild());
            AppMethodBeat.o(61430);
            return valueOf;
        }

        public final DerivedClassType addField(String str) {
            AppMethodBeat.i(61423);
            this.zzvt.add(str);
            AppMethodBeat.o(61423);
            return this;
        }

        @Deprecated
        public final String appendParametersToUrl(String str) {
            AppMethodBeat.i(61428);
            String append = BaseApi.append(str, "prettyPrint", zzcy());
            if (this.zzvv != null) {
                append = BaseApi.append(append, "trace", getTrace());
            }
            if (!this.zzvt.isEmpty()) {
                append = BaseApi.append(append, GraphRequest.FIELDS_PARAM, TextUtils.join(",", getFields().toArray()));
            }
            AppMethodBeat.o(61428);
            return append;
        }

        public void appendParametersToUrl(StringBuilder stringBuilder) {
            AppMethodBeat.i(61429);
            BaseApi.append(stringBuilder, "prettyPrint", zzcy());
            if (this.zzvv != null) {
                BaseApi.append(stringBuilder, "trace", getTrace());
            }
            if (!this.zzvt.isEmpty()) {
                BaseApi.append(stringBuilder, GraphRequest.FIELDS_PARAM, TextUtils.join(",", getFields().toArray()));
            }
            AppMethodBeat.o(61429);
        }

        public final DerivedClassType buildFrom(BaseApiaryOptions<?> baseApiaryOptions) {
            AppMethodBeat.i(61422);
            if (baseApiaryOptions.zzvv != null) {
                this.zzvv = baseApiaryOptions.zzvv;
            }
            if (!baseApiaryOptions.zzvt.isEmpty()) {
                this.zzvt.clear();
                this.zzvt.addAll(baseApiaryOptions.zzvt);
            }
            AppMethodBeat.o(61422);
            return this;
        }

        /* Access modifiers changed, original: protected|final */
        public final Collector getCollector() {
            return this.zzvw;
        }

        public final List<String> getFields() {
            return this.zzvt;
        }

        public final Map<String, String> getHeaders() {
            return this.zzvu;
        }

        public final String getTrace() {
            return this.zzvv;
        }

        public final DerivedClassType setEtag(String str) {
            AppMethodBeat.i(61425);
            BaseApiaryOptions header = setHeader("ETag", str);
            AppMethodBeat.o(61425);
            return header;
        }

        public final DerivedClassType setHeader(String str, String str2) {
            AppMethodBeat.i(61424);
            this.zzvu.put(str, str2);
            AppMethodBeat.o(61424);
            return this;
        }

        public final DerivedClassType setTraceByLdap(String str) {
            AppMethodBeat.i(61426);
            String valueOf = String.valueOf("email:");
            String valueOf2 = String.valueOf(str);
            this.zzvv = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            AppMethodBeat.o(61426);
            return this;
        }

        public final DerivedClassType setTraceByToken(String str) {
            AppMethodBeat.i(61427);
            String valueOf = String.valueOf("token:");
            String valueOf2 = String.valueOf(str);
            this.zzvv = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            AppMethodBeat.o(61427);
            return this;
        }
    }

    @Deprecated
    public static String append(String str, String str2, String str3) {
        AppMethodBeat.i(61434);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (str.indexOf("?") != -1) {
            stringBuilder.append('&');
        } else {
            stringBuilder.append('?');
        }
        stringBuilder.append(str2);
        stringBuilder.append('=');
        stringBuilder.append(str3);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(61434);
        return stringBuilder2;
    }

    public static void append(StringBuilder stringBuilder, String str, String str2) {
        AppMethodBeat.i(61435);
        if (stringBuilder.indexOf("?") != -1) {
            stringBuilder.append('&');
        } else {
            stringBuilder.append('?');
        }
        stringBuilder.append(str);
        stringBuilder.append('=');
        stringBuilder.append(str2);
        AppMethodBeat.o(61435);
    }

    public static String enc(String str) {
        AppMethodBeat.i(61432);
        Preconditions.checkNotNull(str, "Encoding a null parameter!");
        String encode = Uri.encode(str);
        AppMethodBeat.o(61432);
        return encode;
    }

    protected static List<String> enc(List<String> list) {
        AppMethodBeat.i(61433);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(enc((String) list.get(i)));
        }
        AppMethodBeat.o(61433);
        return arrayList;
    }
}
