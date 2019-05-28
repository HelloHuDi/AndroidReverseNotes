package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.plugin.account.friend.p272a.C45498n;
import com.tencent.p177mm.plugin.account.friend.p272a.C9875ae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.h */
public final class C6721h implements C1202f {
    private Context context;
    private ProgressDialog fsh;
    C2008a gym;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.h$a */
    public interface C2008a {
        /* renamed from: dn */
        void mo5749dn(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.h$3 */
    class C67223 implements OnClickListener {
        C67223() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(108654);
            C6721h.this.gym.mo5749dn(true);
            AppMethodBeat.m2505o(108654);
        }
    }

    public C6721h(Context context, C2008a c2008a) {
        this.context = context;
        this.gym = c2008a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo14951e(Cursor cursor) {
        AppMethodBeat.m2504i(108655);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                C45498n c45498n = new C45498n();
                c45498n.mo8995d(cursor);
                arrayList.add(c45498n.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(c45498n);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.context;
        String string = this.context.getResources().getString(C25738R.string.c8q);
        this.context.getResources().getString(C25738R.string.f9076or);
        C30379h.m48418a(context, string, arrayList, arrayList2, new C30382d() {
            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(108652);
                if (i2 != -1) {
                    C6721h.this.mo14952wm(((C45498n) arrayList3.get(i2)).field_googlegmail);
                }
                AppMethodBeat.m2505o(108652);
            }
        });
        AppMethodBeat.m2505o(108655);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wm */
    public final void mo14952wm(String str) {
        AppMethodBeat.m2504i(108656);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        final C1207m c9875ae = new C9875ae(arrayList);
        C1720g.m3540Rg().mo14541a(c9875ae, 0);
        Context context = this.context;
        this.context.getString(C25738R.string.cev);
        this.fsh = C30379h.m48458b(context, this.context.getString(C25738R.string.cet), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(108653);
                C1720g.m3540Rg().mo14547c(c9875ae);
                C6721h.this.gym.mo5749dn(false);
                AppMethodBeat.m2505o(108653);
            }
        });
        AppMethodBeat.m2505o(108656);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(108657);
        String str2 = "MicroMsg.SendInviteGoogleContact";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        C4990ab.m7417i(str2, str3, objArr);
        if (c1207m.getType() != 489) {
            AppMethodBeat.m2505o(108657);
            return;
        }
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        C1720g.m3540Rg().mo14546b(489, (C1202f) this);
        if (i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
            C30379h.m48431a(this.context, (int) C25738R.string.ces, (int) C25738R.string.f9238tz, new C67223());
            AppMethodBeat.m2505o(108657);
            return;
        }
        C4990ab.m7416i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
        this.gym.mo5749dn(false);
        AppMethodBeat.m2505o(108657);
    }
}
