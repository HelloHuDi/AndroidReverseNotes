package com.tencent.wework.api.model;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.wework.api.util.ReflecterHelper;

public abstract class BaseMessage {
    protected Context mContext = null;

    public abstract boolean checkArgs();

    public abstract void toBundle(Bundle bundle);

    public final void setContext(Context context) {
        this.mContext = context;
    }

    /* renamed from: b */
    public static Bundle m25208b(BaseMessage baseMessage) {
        if (baseMessage == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        baseMessage.toBundle(bundle);
        bundle.putString("_wwobject_identifier_", baseMessage.getClass().getName());
        return bundle;
    }

    /* renamed from: x */
    public static BaseMessage m25209x(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter("wwoid");
            if (!TextUtils.isEmpty(queryParameter)) {
                return (BaseMessage) ReflecterHelper.newInstance(queryParameter);
            }
        } catch (Throwable th) {
        }
        return null;
    }
}
