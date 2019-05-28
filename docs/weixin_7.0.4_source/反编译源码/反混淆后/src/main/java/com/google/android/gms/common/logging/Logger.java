package com.google.android.gms.common.logging;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class Logger {
    private final String mTag;
    private final String zzud;
    private final GmsLogger zzvd;
    private final int zzve;

    private Logger(String str, String str2) {
        AppMethodBeat.m2504i(89880);
        this.zzud = str2;
        this.mTag = str;
        this.zzvd = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        this.zzve = i;
        AppMethodBeat.m2505o(89880);
    }

    public Logger(String str, String... strArr) {
        String str2;
        if (strArr.length == 0) {
            str2 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            for (String str3 : strArr) {
                if (stringBuilder.length() > 1) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str3);
            }
            stringBuilder.append(']').append(' ');
            str2 = stringBuilder.toString();
        }
        this(str, str2);
        AppMethodBeat.m2504i(89879);
        AppMethodBeat.m2505o(89879);
    }

    /* renamed from: d */
    public void mo59624d(String str, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(89886);
        if (isLoggable(3)) {
            format(str, objArr);
        }
        AppMethodBeat.m2505o(89886);
    }

    /* renamed from: d */
    public void mo59625d(String str, Object... objArr) {
        AppMethodBeat.m2504i(89885);
        if (isLoggable(3)) {
            format(str, objArr);
        }
        AppMethodBeat.m2505o(89885);
    }

    /* renamed from: e */
    public void mo59626e(String str, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(89892);
        format(str, objArr);
        AppMethodBeat.m2505o(89892);
    }

    /* renamed from: e */
    public void mo59627e(String str, Object... objArr) {
        AppMethodBeat.m2504i(89891);
        format(str, objArr);
        AppMethodBeat.m2505o(89891);
    }

    public String elidePii(Object obj) {
        AppMethodBeat.m2504i(89882);
        boolean canLogPii = this.zzvd.canLogPii();
        String str;
        if (obj == null) {
            str = "<NULL>";
            AppMethodBeat.m2505o(89882);
            return str;
        }
        str = obj.toString().trim();
        if (str.isEmpty()) {
            str = "<EMPTY>";
            AppMethodBeat.m2505o(89882);
            return str;
        } else if (canLogPii) {
            AppMethodBeat.m2505o(89882);
            return str;
        } else {
            str = String.format("<ELLIDED:%s>", new Object[]{Integer.valueOf(str.hashCode())});
            AppMethodBeat.m2505o(89882);
            return str;
        }
    }

    /* Access modifiers changed, original: protected|varargs */
    public String format(String str, Object... objArr) {
        AppMethodBeat.m2504i(89896);
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        String concat = this.zzud.concat(str);
        AppMethodBeat.m2505o(89896);
        return concat;
    }

    public String getTag() {
        return this.mTag;
    }

    /* renamed from: i */
    public void mo59631i(String str, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(89888);
        format(str, objArr);
        AppMethodBeat.m2505o(89888);
    }

    /* renamed from: i */
    public void mo59632i(String str, Object... objArr) {
        AppMethodBeat.m2504i(89887);
        format(str, objArr);
        AppMethodBeat.m2505o(89887);
    }

    public boolean isLoggable(int i) {
        return this.zzve <= i;
    }

    public boolean isPiiLoggable() {
        AppMethodBeat.m2504i(89881);
        boolean canLogPii = this.zzvd.canLogPii();
        AppMethodBeat.m2505o(89881);
        return canLogPii;
    }

    /* renamed from: v */
    public void mo59635v(String str, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(89884);
        if (isLoggable(2)) {
            format(str, objArr);
        }
        AppMethodBeat.m2505o(89884);
    }

    /* renamed from: v */
    public void mo59636v(String str, Object... objArr) {
        AppMethodBeat.m2504i(89883);
        if (isLoggable(2)) {
            format(str, objArr);
        }
        AppMethodBeat.m2505o(89883);
    }

    /* renamed from: w */
    public void mo59637w(String str, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(89890);
        format(str, objArr);
        AppMethodBeat.m2505o(89890);
    }

    /* renamed from: w */
    public void mo59638w(String str, Object... objArr) {
        AppMethodBeat.m2504i(89889);
        format(str, objArr);
        AppMethodBeat.m2505o(89889);
    }

    /* renamed from: w */
    public void mo59639w(Throwable th) {
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(89894);
        Log.wtf(this.mTag, format(str, objArr), th);
        AppMethodBeat.m2505o(89894);
    }

    @SuppressLint({"WtfWithoutException"})
    public void wtf(String str, Object... objArr) {
        AppMethodBeat.m2504i(89893);
        Log.wtf(this.mTag, format(str, objArr));
        AppMethodBeat.m2505o(89893);
    }

    public void wtf(Throwable th) {
        AppMethodBeat.m2504i(89895);
        Log.wtf(this.mTag, th);
        AppMethodBeat.m2505o(89895);
    }
}
