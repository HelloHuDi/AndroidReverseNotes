package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.List;

public final class h implements f {
    private Context context;
    private ProgressDialog fsh;
    a gym;

    public interface a {
        void dn(boolean z);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.gym = aVar;
    }

    /* Access modifiers changed, original: final */
    public final void e(Cursor cursor) {
        AppMethodBeat.i(108655);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                n nVar = new n();
                nVar.d(cursor);
                arrayList.add(nVar.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(nVar);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.context;
        String string = this.context.getResources().getString(R.string.c8q);
        this.context.getResources().getString(R.string.or);
        com.tencent.mm.ui.base.h.a(context, string, arrayList, arrayList2, new d() {
            public final void bV(int i, int i2) {
                AppMethodBeat.i(108652);
                if (i2 != -1) {
                    h.this.wm(((n) arrayList3.get(i2)).field_googlegmail);
                }
                AppMethodBeat.o(108652);
            }
        });
        AppMethodBeat.o(108655);
    }

    /* Access modifiers changed, original: final */
    public final void wm(String str) {
        AppMethodBeat.i(108656);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        final m aeVar = new ae(arrayList);
        g.Rg().a(aeVar, 0);
        Context context = this.context;
        this.context.getString(R.string.cev);
        this.fsh = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.cet), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(108653);
                g.Rg().c(aeVar);
                h.this.gym.dn(false);
                AppMethodBeat.o(108653);
            }
        });
        AppMethodBeat.o(108656);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(108657);
        String str2 = "MicroMsg.SendInviteGoogleContact";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        ab.i(str2, str3, objArr);
        if (mVar.getType() != 489) {
            AppMethodBeat.o(108657);
            return;
        }
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        g.Rg().b(489, (f) this);
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
            com.tencent.mm.ui.base.h.a(this.context, (int) R.string.ces, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(108654);
                    h.this.gym.dn(true);
                    AppMethodBeat.o(108654);
                }
            });
            AppMethodBeat.o(108657);
            return;
        }
        ab.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
        this.gym.dn(false);
        AppMethodBeat.o(108657);
    }
}
