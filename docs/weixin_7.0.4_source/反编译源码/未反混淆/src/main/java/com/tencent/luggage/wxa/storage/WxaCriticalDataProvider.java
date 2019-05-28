package com.tencent.luggage.wxa.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.luggage.g.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.launching.ac;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WxaCriticalDataProvider extends ContentProvider {
    private static final UriMatcher bSb = new UriMatcher(-1);
    private static final SparseArray<String> bSc;
    private volatile e bSd;
    private final Map<Class<?>, Object> bSe = new HashMap();

    public abstract e yo();

    static {
        SparseArray sparseArray = new SparseArray();
        bSc = sparseArray;
        sparseArray.put(1, "WxaAttributesTable");
        bSc.put(2, "LaunchWxaAppPBTable");
        bSc.put(3, "WxaAppPackageModelTable");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bSc.size()) {
                bSb.addURI(a.AUTHORITY, (String) bSc.valueAt(i2), bSc.keyAt(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean yn() {
        if (this.bSd == null) {
            this.bSd = yo();
        }
        return this.bSd != null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(Class<?> cls, Object obj) {
        this.bSe.put(cls, obj);
    }

    private <T> T E(Class<T> cls) {
        return this.bSe.get(cls);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!yn()) {
            return null;
        }
        String str3 = (String) bSc.get(bSb.match(uri));
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return this.bSd.query(str3, strArr, str, strArr2, null, null, str2);
    }

    public String getType(Uri uri) {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069 A:{Catch:{ Exception -> 0x0079 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (yn()) {
            switch (bSb.match(uri)) {
                case 1:
                    try {
                        CharSequence charSequence;
                        String str;
                        String asString = contentValues.getAsString("CONTENT_KEY_APPID");
                        o oVar = (o) E(o.class);
                        cwy cwy = (cwy) new cwy().parseFrom(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO"));
                        if (bo.isNullOrNil(asString)) {
                            charSequence = null;
                        } else {
                            WxaAttributes e = oVar.e(asString, "username");
                            charSequence = e == null ? null : e.field_username;
                        }
                        if (TextUtils.isEmpty(charSequence)) {
                            Iterator it = cwy.vMT.iterator();
                            while (it.hasNext()) {
                                cwx cwx = (cwx) it.next();
                                if ("UserName".equalsIgnoreCase(cwx.vMU)) {
                                    str = cwx.pXM;
                                    if (TextUtils.isEmpty(str)) {
                                        ab.e("MicroMsg.WxaAttrStorage", "updateAttrsWithProto appId=%s, username EMPTY", asString);
                                        break;
                                    }
                                }
                            }
                            CharSequence str2 = charSequence;
                            if (TextUtils.isEmpty(str2)) {
                            }
                        } else {
                            str2 = charSequence;
                        }
                        oVar.a(str2, cwy.vMS, cwy.vMT);
                        break;
                    } catch (Exception e2) {
                        d.e("Luggage.WxaCriticalDataProvider", "insert WxaAttributes, e = %s", e2);
                        break;
                    }
                case 2:
                    try {
                        ((ac) E(ac.class)).b(contentValues.getAsString("CONTENT_KEY_APPID"), (axr) new axr().parseFrom(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO")));
                        break;
                    } catch (Exception e22) {
                        d.e("Luggage.WxaCriticalDataProvider", "insert LaunchWxaAppPB, e = %s", e22);
                        break;
                    }
            }
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (yn()) {
            return 0;
        }
        return -1;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (yn()) {
            return 0;
        }
        return -1;
    }
}
