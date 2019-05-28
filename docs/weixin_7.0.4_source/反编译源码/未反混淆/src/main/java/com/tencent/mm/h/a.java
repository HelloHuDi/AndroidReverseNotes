package com.tencent.mm.h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class a {
    public String Title;
    public String desc;
    private c eeT;
    public int showType;
    public String url;

    public static a jY(String str) {
        AppMethodBeat.i(77627);
        c ka = c.ka(str);
        if (ka != null) {
            a aVar = new a();
            aVar.eeT = ka;
            aVar.url = ka.url;
            aVar.desc = ka.desc;
            aVar.showType = ka.showType;
            aVar.Title = ka.Title;
            AppMethodBeat.o(77627);
            return aVar;
        }
        AppMethodBeat.o(77627);
        return null;
    }

    public final boolean a(Context context, OnDismissListener onDismissListener) {
        AppMethodBeat.i(77629);
        String str = this.desc;
        String str2 = this.Title;
        if (!((Activity) context).isFinishing()) {
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
            aVar.asD(str2);
            aVar.asE(str);
            aVar.a(onDismissListener);
            aVar.rc(false);
            aVar.Qc(R.string.s6).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(106411);
                    dialogInterface.cancel();
                    AppMethodBeat.o(106411);
                }
            });
            c aMb = aVar.aMb();
            aMb.show();
            h.a(context, aMb);
        }
        AppMethodBeat.o(77629);
        return true;
    }

    public final boolean a(Context context, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(77628);
        if (this.showType == 3 || this.showType == 4) {
            String str = this.eeT.eff;
            String str2 = this.eeT.efg;
            if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
                str = context.getString(this.showType == 3 ? R.string.up : R.string.s6);
                str2 = context.getString(this.showType == 3 ? R.string.s2 : R.string.or);
            }
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                String str3 = this.desc;
                String str4 = this.Title;
                if (!bo.isNullOrNil(str)) {
                    str2 = str;
                }
                if (!bo.isNullOrNil(str)) {
                    onClickListener2 = onClickListener;
                }
                h.a(context, str3, str4, str2, onClickListener2);
            } else {
                h.d(context, this.desc, this.Title, str, str2, onClickListener, onClickListener2);
            }
            AppMethodBeat.o(77628);
            return true;
        } else if (this.showType == 1) {
            h.b(context, this.desc, this.Title, true);
            AppMethodBeat.o(77628);
            return true;
        } else if (this.showType == 5) {
            h.b(context, this.desc, this.Title, true);
            AppMethodBeat.o(77628);
            return true;
        } else {
            AppMethodBeat.o(77628);
            return false;
        }
    }
}
