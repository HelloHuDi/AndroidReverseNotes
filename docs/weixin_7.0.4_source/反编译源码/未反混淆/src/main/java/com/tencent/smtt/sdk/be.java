package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.f.a.a.a;
import com.tencent.f.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

class be {
    private static be e = null;
    bh a = null;
    Context b;
    b c;
    a d;

    private be(Context context) {
        AppMethodBeat.i(64624);
        this.b = context.getApplicationContext();
        this.a = new bh(this.b);
        AppMethodBeat.o(64624);
    }

    public static synchronized be a(Context context) {
        be beVar;
        synchronized (be.class) {
            AppMethodBeat.i(64623);
            if (e == null) {
                e = new be(context);
            }
            beVar = e;
            AppMethodBeat.o(64623);
        }
        return beVar;
    }

    public void a(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Activity activity, int i) {
        AppMethodBeat.i(64626);
        this.a.a(activity, i);
        AppMethodBeat.o(64626);
    }

    public boolean a() {
        AppMethodBeat.i(64627);
        this.a.a();
        boolean b = this.a.b();
        AppMethodBeat.o(64627);
        return b;
    }

    public boolean a(String str, Bundle bundle, b bVar) {
        Object thisR;
        AppMethodBeat.i(64625);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (bVar != null) {
            this.a.a();
            if (this.a.b()) {
                this.c = bVar;
                this.d = new bf(this);
                bundle.putInt("callMode", 3);
            } else {
                AppMethodBeat.o(64625);
                return false;
            }
        }
        bundle.putInt("callMode", 1);
        bh bhVar = this.a;
        if (bVar == null) {
            thisR = null;
        }
        bhVar.a(bundle, thisR);
        AppMethodBeat.o(64625);
        return true;
    }
}
