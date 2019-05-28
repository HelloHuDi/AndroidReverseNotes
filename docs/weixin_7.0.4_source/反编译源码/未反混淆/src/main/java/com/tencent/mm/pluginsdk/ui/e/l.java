package com.tencent.mm.pluginsdk.ui.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class l {
    static String vsa;

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$3 */
    public static class AnonymousClass3 implements OnCreateContextMenuListener {
        final /* synthetic */ List vsd;

        public AnonymousClass3(List list) {
            this.vsd = list;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(28133);
            for (String add : this.vsd) {
                contextMenu.add(0, 0, 0, add);
            }
            AppMethodBeat.o(28133);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$4 */
    public static class AnonymousClass4 implements d {
        final /* synthetic */ Context val$context;

        public AnonymousClass4(Context context) {
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(28134);
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(menuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")))));
            intent.addFlags(268435456);
            if (bo.k(this.val$context, intent)) {
                this.val$context.startActivity(intent);
            }
            AppMethodBeat.o(28134);
        }
    }

    static class a extends BaseAdapter {
        private Bundle Et = null;
        private Context mContext = null;
        private List<String> ngC = null;
        private OnDismissListener vsh = null;
        a vsi = null;

        class c {
            TextView gsf;

            private c() {
            }

            /* synthetic */ c(a aVar, byte b) {
                this();
            }
        }

        public interface a {
            void iv(boolean z);
        }

        class b {
            TextView gsf;
            Button mlF;
            TextView vsk;

            private b() {
            }

            /* synthetic */ b(a aVar, byte b) {
                this();
            }
        }

        public a(List<String> list, Context context, OnDismissListener onDismissListener, Bundle bundle) {
            AppMethodBeat.i(28141);
            Assert.assertTrue(context != null);
            this.ngC = list;
            this.mContext = context;
            this.vsh = onDismissListener;
            this.Et = bundle;
            AppMethodBeat.o(28141);
        }

        public final int getCount() {
            AppMethodBeat.i(28142);
            if (this.ngC == null) {
                AppMethodBeat.o(28142);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.o(28142);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(28143);
            Object obj = this.ngC.get(i);
            AppMethodBeat.o(28143);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(28144);
            if (this.mContext.getString(R.string.anc).equals((String) this.ngC.get(i))) {
                AppMethodBeat.o(28144);
                return 1;
            }
            AppMethodBeat.o(28144);
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            Object obj;
            AppMethodBeat.i(28145);
            String str = (String) getItem(i);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                Object bVar;
                LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
                View inflate;
                if (itemViewType == 1) {
                    inflate = layoutInflater.inflate(R.layout.mw, viewGroup, false);
                    bVar = new b(this, (byte) 0);
                    ((b) bVar).gsf = (TextView) inflate.findViewById(R.id.cx);
                    ((b) bVar).mlF = (Button) inflate.findViewById(R.id.at4);
                    ((b) bVar).vsk = (TextView) inflate.findViewById(R.id.asn);
                    view2 = inflate;
                } else {
                    inflate = layoutInflater.inflate(R.layout.mx, viewGroup, false);
                    bVar = new c(this, (byte) 0);
                    ((c) bVar).gsf = (TextView) inflate.findViewById(R.id.cx);
                    view2 = inflate;
                }
                view2.setTag(bVar);
                obj = bVar;
            } else {
                obj = view.getTag();
                view2 = view;
            }
            switch (itemViewType) {
                case 0:
                    c cVar = (c) obj;
                    cVar.gsf.setText(j.b(this.mContext, bo.nullAsNil(str), cVar.gsf.getTextSize()));
                    break;
                case 1:
                    b bVar2 = (b) obj;
                    bVar2.gsf.setText(j.b(this.mContext, bo.nullAsNil(str), bVar2.gsf.getTextSize()));
                    bVar2.vsk.setText(this.mContext.getString(R.string.ani));
                    bVar2.mlF.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(28140);
                            if (C2Java.isNetworkConnected()) {
                                q.h(a.this.mContext, a.this.Et);
                                if (a.this.vsi != null) {
                                    a.this.vsi.iv(true);
                                }
                            } else {
                                ab.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
                                t.makeText(a.this.mContext, a.this.mContext.getString(R.string.bx9), 0).show();
                                if (a.this.vsi != null) {
                                    a.this.vsi.iv(false);
                                    AppMethodBeat.o(28140);
                                    return;
                                }
                            }
                            AppMethodBeat.o(28140);
                        }
                    });
                    break;
                default:
                    ab.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                    break;
            }
            AppMethodBeat.o(28145);
            return view2;
        }
    }

    public static void b(final Context context, final String str, final OnDismissListener onDismissListener) {
        AppMethodBeat.i(28146);
        if (((r.YK() & 1) == 0 ? 1 : 0) != 0) {
            h.a(context, str, context.getResources().getStringArray(R.array.g), "", new c() {
                public final void iE(int i) {
                    AppMethodBeat.i(28131);
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", "").replace("#", "@");
                    switch (i) {
                        case 0:
                            Context context = context;
                            Intent intent = new Intent();
                            intent.putExtra("composeType", 4);
                            String substring = replace.substring(0, replace.indexOf(64));
                            intent.putExtra("toList", new String[]{substring + " " + replace});
                            com.tencent.mm.bp.d.b(context, "qqmail", ".ui.ComposeUI", intent);
                            AppMethodBeat.o(28131);
                            return;
                        case 1:
                            l.bC(context, replace);
                            break;
                    }
                    AppMethodBeat.o(28131);
                }
            });
            AppMethodBeat.o(28146);
            return;
        }
        h.a(context, str, new String[]{context.getResources().getString(R.string.ake)}, "", new c() {
            public final void iE(int i) {
                AppMethodBeat.i(28132);
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
                String replace = str.replace(" ", "").replace("#", "@");
                switch (i) {
                    case 0:
                        l.bC(context, replace);
                        break;
                }
                AppMethodBeat.o(28132);
            }
        });
        AppMethodBeat.o(28146);
    }

    public static void a(Context context, String str, final OnDismissListener onDismissListener, Bundle bundle) {
        boolean booleanValue;
        List P;
        AppMethodBeat.i(28147);
        if (!(context instanceof Activity)) {
            ab.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", bo.dpG());
        }
        if (g.RN().QY()) {
            booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
        } else {
            booleanValue = false;
        }
        final int i = bundle != null ? bundle.getInt("fromScene") : 0;
        if (dlf()) {
            String[] strArr;
            String nullAsNil = bo.nullAsNil(bundle == null ? "" : bundle.getString("Contact_User"));
            if (nullAsNil == null || nullAsNil == "" || r.mG(nullAsNil) || ad.aox(nullAsNil)) {
                strArr = booleanValue ? new String[]{context.getResources().getString(R.string.ang), context.getResources().getString(R.string.anh), context.getResources().getString(R.string.ana), context.getResources().getString(R.string.an9)} : new String[]{context.getResources().getString(R.string.ang), context.getResources().getString(R.string.ana), context.getResources().getString(R.string.an9)};
            } else {
                ad aoO = ((j) g.K(j.class)).XM().aoO(nullAsNil);
                if (aoO == null) {
                    AppMethodBeat.o(28147);
                    return;
                }
                String Oj = aoO.Oj();
                vsa = context.getResources().getString(R.string.an_, new Object[]{Oj});
                strArr = booleanValue ? new String[]{context.getResources().getString(R.string.ang), context.getResources().getString(R.string.anh), vsa, context.getResources().getString(R.string.ana), context.getResources().getString(R.string.an9)} : new String[]{context.getResources().getString(R.string.ang), vsa, context.getResources().getString(R.string.ana), context.getResources().getString(R.string.an9)};
            }
            P = bo.P(strArr);
        } else {
            P = bo.P(new String[]{context.getResources().getString(R.string.ang), context.getResources().getString(R.string.ana)});
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(11621, Integer.valueOf(i), Integer.valueOf(2));
        if (q.BX()) {
            P.add(context.getResources().getString(R.string.anc));
            com.tencent.mm.plugin.report.service.h.pYm.e(11621, Integer.valueOf(i), Integer.valueOf(3));
            if (C2Java.isNetworkConnected()) {
                q.dli();
            }
        }
        final k kVar = new k(context);
        kVar.setTitle(str);
        a aVar = new a(P, context, onDismissListener, bundle);
        aVar.vsi = new a() {
            public final void iv(boolean z) {
                AppMethodBeat.i(28135);
                if (z) {
                    kVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                }
                AppMethodBeat.o(28135);
            }
        };
        kVar.khG = aVar;
        h.a(context, kVar);
        kVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(28136);
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
                AppMethodBeat.o(28136);
            }
        });
        final String str2 = str;
        final Context context2 = context;
        final OnDismissListener onDismissListener2 = onDismissListener;
        final Bundle bundle2 = bundle;
        kVar.vtI = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(28139);
                final String replace = str2.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
                String str = (String) P.get(i);
                ab.i("MicroMsg.MailPhoneMenuHelper", str);
                Intent intent;
                if (context2.getString(R.string.ang).equals(str)) {
                    intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(replace))));
                    intent.addFlags(268435456);
                    if (bo.k(context2, intent)) {
                        context2.startActivity(intent);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.X(10112, "1");
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    AppMethodBeat.o(28139);
                } else if (context2.getString(R.string.anh).equals(str)) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", replace);
                    com.tencent.mm.bp.d.b(context2, "ipcall", ".ui.IPCallDialUI", intent);
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    AppMethodBeat.o(28139);
                } else if (context2.getString(R.string.an9).equals(str)) {
                    String[] stringArray;
                    if (l.dlg() && l.dlh()) {
                        stringArray = context2.getResources().getStringArray(R.array.a8);
                    } else {
                        stringArray = l.dlg() ? new String[]{context2.getResources().getString(R.string.an8)} : new String[]{context2.getResources().getString(R.string.anf)};
                    }
                    context2.getResources().getString(R.string.ane);
                    h.a(context2, str2, stringArray, "", new c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(28137);
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                            switch (i) {
                                case 0:
                                    if (l.dlg()) {
                                        Context context = context2;
                                        String str = replace;
                                        Intent intent = new Intent("android.intent.action.INSERT");
                                        intent.setType("vnd.android.cursor.dir/contact");
                                        intent.putExtra("phone", str);
                                        context.startActivity(intent);
                                        com.tencent.mm.plugin.report.service.h.pYm.X(10113, "1");
                                        AppMethodBeat.o(28137);
                                        return;
                                    }
                                    l.bD(context2, replace);
                                    com.tencent.mm.plugin.report.service.h.pYm.X(10114, "1");
                                    AppMethodBeat.o(28137);
                                    return;
                                case 1:
                                    l.bD(context2, replace);
                                    com.tencent.mm.plugin.report.service.h.pYm.X(10114, "1");
                                    break;
                            }
                            AppMethodBeat.o(28137);
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(28138);
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                            AppMethodBeat.o(28138);
                        }
                    });
                    kVar.dismiss();
                    AppMethodBeat.o(28139);
                } else if (context2.getString(R.string.ana).equals(str)) {
                    com.tencent.mm.pluginsdk.f.a.b(replace, replace);
                    com.tencent.mm.plugin.report.service.h.pYm.X(10115, "1");
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    kVar.dismiss();
                    Toast.makeText(context2, context2.getString(R.string.oz), 1).show();
                    AppMethodBeat.o(28139);
                } else if (context2.getString(R.string.anc).equals(str)) {
                    ab.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                    AppMethodBeat.o(28139);
                } else {
                    if (l.vsa.equals(str)) {
                        l.a((Activity) context2, str2, bundle2);
                        kVar.dismiss();
                        if (onDismissListener2 != null) {
                            onDismissListener2.onDismiss(null);
                            AppMethodBeat.o(28139);
                            return;
                        }
                    }
                    ab.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    AppMethodBeat.o(28139);
                }
            }
        };
        kVar.show();
        AppMethodBeat.o(28147);
    }

    private static boolean dlf() {
        AppMethodBeat.i(28148);
        if (dlg() || dlh()) {
            AppMethodBeat.o(28148);
            return true;
        }
        AppMethodBeat.o(28148);
        return false;
    }

    static boolean dlg() {
        AppMethodBeat.i(28149);
        Context context = ah.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        boolean k = bo.k(context, intent);
        AppMethodBeat.o(28149);
        return k;
    }

    static boolean dlh() {
        AppMethodBeat.i(28150);
        boolean k = bo.k(ah.getContext(), new Intent("android.intent.action.PICK", Contacts.CONTENT_URI));
        AppMethodBeat.o(28150);
        return k;
    }

    private static void a(Activity activity, ad adVar, String str, ArrayList<String> arrayList) {
        String str2;
        AppMethodBeat.i(28151);
        bck bck = new bck();
        bck.wGA = str;
        bkg bkg = new bkg();
        bkg.jBv = arrayList.size();
        bkg.wNu = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            bkf bkf = new bkf();
            bkf.wNt = str2;
            bkg.wNu.add(bkf);
        }
        bck.wGw = bkg;
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(60, bck));
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
            String str3;
            str2 = "";
            Iterator it2 = arrayList.iterator();
            while (true) {
                str3 = str2;
                if (!it2.hasNext()) {
                    break;
                }
                str2 = (str3 + ((String) it2.next())) + ",";
            }
            adVar.jd(str3);
            ((j) g.K(j.class)).XM().Y(adVar);
        }
        Toast.makeText(activity, activity.getString(R.string.eto), 0).show();
        AppMethodBeat.o(28151);
    }

    static /* synthetic */ void bC(Context context, String str) {
        AppMethodBeat.i(28152);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (bo.k(context, intent)) {
            context.startActivity(intent);
            AppMethodBeat.o(28152);
            return;
        }
        h.a(context, (int) R.string.an6, (int) R.string.tz, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(28152);
    }

    static /* synthetic */ void bD(Context context, String str) {
        AppMethodBeat.i(28153);
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (bo.k(context, intent)) {
            context.startActivity(intent);
        }
        AppMethodBeat.o(28153);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(Activity activity, String str, Bundle bundle) {
        AppMethodBeat.i(28154);
        String nullAsNil = bo.nullAsNil(bundle.getString("Contact_User"));
        if (nullAsNil == null) {
            ab.e("MicroMsg.MailPhoneMenuHelper", "username is null");
            AppMethodBeat.o(28154);
            return;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(nullAsNil);
        if (aoO == null) {
            ab.e("MicroMsg.MailPhoneMenuHelper", "contact is null");
            AppMethodBeat.o(28154);
            return;
        }
        int i;
        ArrayList arrayList;
        String string = bundle.getString("Contact_Mobile_MD5");
        String str2 = aoO.dur;
        if (!bo.isNullOrNil(string)) {
            if (string == str) {
                i = 0;
            } else if (!aoO.Of()) {
                i = 1;
            }
            arrayList = new ArrayList();
            if (!bo.isNullOrNil(str2)) {
                String[] split = str2.split(",");
                for (Object add : split) {
                    arrayList.add(add);
                }
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
            }
            arrayList.add(str);
            if (arrayList.size() + i > 5) {
                a(activity, aoO, nullAsNil, arrayList);
                com.tencent.mm.plugin.report.service.h.pYm.e(12040, aoO.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
                AppMethodBeat.o(28154);
                return;
            }
            Toast.makeText(activity, activity.getString(R.string.d1k), 0).show();
            AppMethodBeat.o(28154);
            return;
        }
        i = 0;
        arrayList = new ArrayList();
        if (bo.isNullOrNil(str2)) {
        }
        arrayList.add(str);
        if (arrayList.size() + i > 5) {
        }
    }
}
