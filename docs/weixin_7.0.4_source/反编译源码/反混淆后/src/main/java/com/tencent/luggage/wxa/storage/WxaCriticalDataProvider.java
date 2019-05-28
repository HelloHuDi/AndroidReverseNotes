package com.tencent.luggage.wxa.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.p177mm.plugin.appbrand.config.C10183o;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.C27158ac;
import com.tencent.p177mm.protocal.protobuf.axr;
import com.tencent.p177mm.protocal.protobuf.cwx;
import com.tencent.p177mm.protocal.protobuf.cwy;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class WxaCriticalDataProvider extends ContentProvider {
    private static final UriMatcher bSb = new UriMatcher(-1);
    private static final SparseArray<String> bSc;
    private volatile C4927e bSd;
    private final Map<Class<?>, Object> bSe = new HashMap();

    /* renamed from: yo */
    public abstract C4927e mo67857yo();

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
                bSb.addURI(C41714a.AUTHORITY, (String) bSc.valueAt(i2), bSc.keyAt(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: yn */
    private boolean m82944yn() {
        if (this.bSd == null) {
            this.bSd = mo67857yo();
        }
        return this.bSd != null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo72937b(Class<?> cls, Object obj) {
        this.bSe.put(cls, obj);
    }

    /* renamed from: E */
    private <T> T m82943E(Class<T> cls) {
        return this.bSe.get(cls);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!m82944yn()) {
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
        if (m82944yn()) {
            switch (bSb.match(uri)) {
                case 1:
                    try {
                        CharSequence charSequence;
                        String str;
                        String asString = contentValues.getAsString("CONTENT_KEY_APPID");
                        C10183o c10183o = (C10183o) m82943E(C10183o.class);
                        cwy cwy = (cwy) new cwy().parseFrom(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO"));
                        if (C5046bo.isNullOrNil(asString)) {
                            charSequence = null;
                        } else {
                            WxaAttributes e = c10183o.mo21573e(asString, "username");
                            charSequence = e == null ? null : e.field_username;
                        }
                        if (TextUtils.isEmpty(charSequence)) {
                            Iterator it = cwy.vMT.iterator();
                            while (it.hasNext()) {
                                cwx cwx = (cwx) it.next();
                                if ("UserName".equalsIgnoreCase(cwx.vMU)) {
                                    str = cwx.pXM;
                                    if (TextUtils.isEmpty(str)) {
                                        C4990ab.m7413e("MicroMsg.WxaAttrStorage", "updateAttrsWithProto appId=%s, username EMPTY", asString);
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
                        c10183o.mo21570a(str2, cwy.vMS, cwy.vMT);
                        break;
                    } catch (Exception e2) {
                        C45124d.m82928e("Luggage.WxaCriticalDataProvider", "insert WxaAttributes, e = %s", e2);
                        break;
                    }
                case 2:
                    try {
                        ((C27158ac) m82943E(C27158ac.class)).mo44832b(contentValues.getAsString("CONTENT_KEY_APPID"), (axr) new axr().parseFrom(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO")));
                        break;
                    } catch (Exception e22) {
                        C45124d.m82928e("Luggage.WxaCriticalDataProvider", "insert LaunchWxaAppPB, e = %s", e22);
                        break;
                    }
            }
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (m82944yn()) {
            return 0;
        }
        return -1;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (m82944yn()) {
            return 0;
        }
        return -1;
    }
}
