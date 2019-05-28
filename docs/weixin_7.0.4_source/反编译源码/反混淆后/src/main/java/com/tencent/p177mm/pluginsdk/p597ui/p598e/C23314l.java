package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C30394k;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14832a;
import com.tencent.p177mm.protocal.protobuf.bck;
import com.tencent.p177mm.protocal.protobuf.bkf;
import com.tencent.p177mm.protocal.protobuf.bkg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.l */
public final class C23314l {
    static String vsa;

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$3 */
    public static class C233083 implements OnCreateContextMenuListener {
        final /* synthetic */ List vsd;

        public C233083(List list) {
            this.vsd = list;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(28133);
            for (String add : this.vsd) {
                contextMenu.add(0, 0, 0, add);
            }
            AppMethodBeat.m2505o(28133);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$4 */
    public static class C233094 implements C5279d {
        final /* synthetic */ Context val$context;

        public C233094(Context context) {
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(28134);
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(menuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")))));
            intent.addFlags(268435456);
            if (C5046bo.m7572k(this.val$context, intent)) {
                this.val$context.startActivity(intent);
            }
            AppMethodBeat.m2505o(28134);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$8 */
    static class C233198 implements OnClickListener {
        C233198() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$a */
    static class C23320a extends BaseAdapter {
        /* renamed from: Et */
        private Bundle f4408Et = null;
        private Context mContext = null;
        private List<String> ngC = null;
        private OnDismissListener vsh = null;
        C23313a vsi = null;

        /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$a$c */
        class C14944c {
            TextView gsf;

            private C14944c() {
            }

            /* synthetic */ C14944c(C23320a c23320a, byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$a$1 */
        class C233121 implements View.OnClickListener {
            C233121() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(28140);
                if (C2Java.isNetworkConnected()) {
                    C46506q.m87790h(C23320a.this.mContext, C23320a.this.f4408Et);
                    if (C23320a.this.vsi != null) {
                        C23320a.this.vsi.mo39034iv(true);
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
                    C23639t.makeText(C23320a.this.mContext, C23320a.this.mContext.getString(C25738R.string.bx9), 0).show();
                    if (C23320a.this.vsi != null) {
                        C23320a.this.vsi.mo39034iv(false);
                        AppMethodBeat.m2505o(28140);
                        return;
                    }
                }
                AppMethodBeat.m2505o(28140);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$a$a */
        public interface C23313a {
            /* renamed from: iv */
            void mo39034iv(boolean z);
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$a$b */
        class C23321b {
            TextView gsf;
            Button mlF;
            TextView vsk;

            private C23321b() {
            }

            /* synthetic */ C23321b(C23320a c23320a, byte b) {
                this();
            }
        }

        public C23320a(List<String> list, Context context, OnDismissListener onDismissListener, Bundle bundle) {
            AppMethodBeat.m2504i(28141);
            Assert.assertTrue(context != null);
            this.ngC = list;
            this.mContext = context;
            this.vsh = onDismissListener;
            this.f4408Et = bundle;
            AppMethodBeat.m2505o(28141);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(28142);
            if (this.ngC == null) {
                AppMethodBeat.m2505o(28142);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.m2505o(28142);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(28143);
            Object obj = this.ngC.get(i);
            AppMethodBeat.m2505o(28143);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(28144);
            if (this.mContext.getString(C25738R.string.anc).equals((String) this.ngC.get(i))) {
                AppMethodBeat.m2505o(28144);
                return 1;
            }
            AppMethodBeat.m2505o(28144);
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            Object obj;
            AppMethodBeat.m2504i(28145);
            String str = (String) getItem(i);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                Object c23321b;
                LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
                View inflate;
                if (itemViewType == 1) {
                    inflate = layoutInflater.inflate(2130969080, viewGroup, false);
                    c23321b = new C23321b(this, (byte) 0);
                    ((C23321b) c23321b).gsf = (TextView) inflate.findViewById(2131820678);
                    ((C23321b) c23321b).mlF = (Button) inflate.findViewById(2131822658);
                    ((C23321b) c23321b).vsk = (TextView) inflate.findViewById(2131822641);
                    view2 = inflate;
                } else {
                    inflate = layoutInflater.inflate(2130969081, viewGroup, false);
                    c23321b = new C14944c(this, (byte) 0);
                    ((C14944c) c23321b).gsf = (TextView) inflate.findViewById(2131820678);
                    view2 = inflate;
                }
                view2.setTag(c23321b);
                obj = c23321b;
            } else {
                obj = view.getTag();
                view2 = view;
            }
            switch (itemViewType) {
                case 0:
                    C14944c c14944c = (C14944c) obj;
                    c14944c.gsf.setText(C44089j.m79293b(this.mContext, C5046bo.nullAsNil(str), c14944c.gsf.getTextSize()));
                    break;
                case 1:
                    C23321b c23321b2 = (C23321b) obj;
                    c23321b2.gsf.setText(C44089j.m79293b(this.mContext, C5046bo.nullAsNil(str), c23321b2.gsf.getTextSize()));
                    c23321b2.vsk.setText(this.mContext.getString(C25738R.string.ani));
                    c23321b2.mlF.setOnClickListener(new C233121());
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                    break;
            }
            AppMethodBeat.m2505o(28145);
            return view2;
        }
    }

    /* renamed from: b */
    public static void m35798b(final Context context, final String str, final OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(28146);
        if (((C1853r.m3829YK() & 1) == 0 ? 1 : 0) != 0) {
            C30379h.m48422a(context, str, context.getResources().getStringArray(C25738R.array.f12607g), "", new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    AppMethodBeat.m2504i(28131);
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
                            C25985d.m41467b(context, "qqmail", ".ui.ComposeUI", intent);
                            AppMethodBeat.m2505o(28131);
                            return;
                        case 1:
                            C23314l.m35799bC(context, replace);
                            break;
                    }
                    AppMethodBeat.m2505o(28131);
                }
            });
            AppMethodBeat.m2505o(28146);
            return;
        }
        C30379h.m48422a(context, str, new String[]{context.getResources().getString(C25738R.string.ake)}, "", new C30391c() {
            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(28132);
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
                String replace = str.replace(" ", "").replace("#", "@");
                switch (i) {
                    case 0:
                        C23314l.m35799bC(context, replace);
                        break;
                }
                AppMethodBeat.m2505o(28132);
            }
        });
        AppMethodBeat.m2505o(28146);
    }

    /* renamed from: a */
    public static void m35797a(Context context, String str, final OnDismissListener onDismissListener, Bundle bundle) {
        boolean booleanValue;
        List P;
        AppMethodBeat.m2504i(28147);
        if (!(context instanceof Activity)) {
            C4990ab.m7421w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", C5046bo.dpG());
        }
        if (C1720g.m3534RN().mo5161QY()) {
            booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
        } else {
            booleanValue = false;
        }
        final int i = bundle != null ? bundle.getInt("fromScene") : 0;
        if (C23314l.dlf()) {
            String[] strArr;
            String nullAsNil = C5046bo.nullAsNil(bundle == null ? "" : bundle.getString("Contact_User"));
            if (nullAsNil == null || nullAsNil == "" || C1853r.m3858mG(nullAsNil) || C7616ad.aox(nullAsNil)) {
                strArr = booleanValue ? new String[]{context.getResources().getString(C25738R.string.ang), context.getResources().getString(C25738R.string.anh), context.getResources().getString(C25738R.string.ana), context.getResources().getString(C25738R.string.an9)} : new String[]{context.getResources().getString(C25738R.string.ang), context.getResources().getString(C25738R.string.ana), context.getResources().getString(C25738R.string.an9)};
            } else {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(nullAsNil);
                if (aoO == null) {
                    AppMethodBeat.m2505o(28147);
                    return;
                }
                String Oj = aoO.mo16707Oj();
                vsa = context.getResources().getString(C25738R.string.an_, new Object[]{Oj});
                strArr = booleanValue ? new String[]{context.getResources().getString(C25738R.string.ang), context.getResources().getString(C25738R.string.anh), vsa, context.getResources().getString(C25738R.string.ana), context.getResources().getString(C25738R.string.an9)} : new String[]{context.getResources().getString(C25738R.string.ang), vsa, context.getResources().getString(C25738R.string.ana), context.getResources().getString(C25738R.string.an9)};
            }
            P = C5046bo.m7508P(strArr);
        } else {
            P = C5046bo.m7508P(new String[]{context.getResources().getString(C25738R.string.ang), context.getResources().getString(C25738R.string.ana)});
        }
        C7060h.pYm.mo8381e(11621, Integer.valueOf(i), Integer.valueOf(2));
        if (C46506q.m87789BX()) {
            P.add(context.getResources().getString(C25738R.string.anc));
            C7060h.pYm.mo8381e(11621, Integer.valueOf(i), Integer.valueOf(3));
            if (C2Java.isNetworkConnected()) {
                C46506q.dli();
            }
        }
        final C30394k c30394k = new C30394k(context);
        c30394k.setTitle(str);
        C23320a c23320a = new C23320a(P, context, onDismissListener, bundle);
        c23320a.vsi = new C23313a() {
            /* renamed from: iv */
            public final void mo39034iv(boolean z) {
                AppMethodBeat.m2504i(28135);
                if (z) {
                    c30394k.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                }
                AppMethodBeat.m2505o(28135);
            }
        };
        c30394k.khG = c23320a;
        C30379h.m48455a(context, c30394k);
        c30394k.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(28136);
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
                AppMethodBeat.m2505o(28136);
            }
        });
        final String str2 = str;
        final Context context2 = context;
        final OnDismissListener onDismissListener2 = onDismissListener;
        final Bundle bundle2 = bundle;
        c30394k.vtI = new OnItemClickListener() {

            /* renamed from: com.tencent.mm.pluginsdk.ui.e.l$7$2 */
            class C233112 implements OnCancelListener {
                C233112() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(28138);
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    AppMethodBeat.m2505o(28138);
                }
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(28139);
                final String replace = str2.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
                String str = (String) P.get(i);
                C4990ab.m7416i("MicroMsg.MailPhoneMenuHelper", str);
                Intent intent;
                if (context2.getString(C25738R.string.ang).equals(str)) {
                    intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(replace))));
                    intent.addFlags(268435456);
                    if (C5046bo.m7572k(context2, intent)) {
                        context2.startActivity(intent);
                    }
                    C7060h.pYm.mo8374X(10112, "1");
                    c30394k.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    AppMethodBeat.m2505o(28139);
                } else if (context2.getString(C25738R.string.anh).equals(str)) {
                    C7060h.pYm.mo8381e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", replace);
                    C25985d.m41467b(context2, "ipcall", ".ui.IPCallDialUI", intent);
                    c30394k.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    AppMethodBeat.m2505o(28139);
                } else if (context2.getString(C25738R.string.an9).equals(str)) {
                    String[] stringArray;
                    if (C23314l.dlg() && C23314l.dlh()) {
                        stringArray = context2.getResources().getStringArray(C25738R.array.f12624a8);
                    } else {
                        stringArray = C23314l.dlg() ? new String[]{context2.getResources().getString(C25738R.string.an8)} : new String[]{context2.getResources().getString(C25738R.string.anf)};
                    }
                    context2.getResources().getString(C25738R.string.ane);
                    C30379h.m48423a(context2, str2, stringArray, "", new C30391c() {
                        /* renamed from: iE */
                        public final void mo7700iE(int i) {
                            AppMethodBeat.m2504i(28137);
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                            switch (i) {
                                case 0:
                                    if (C23314l.dlg()) {
                                        Context context = context2;
                                        String str = replace;
                                        Intent intent = new Intent("android.intent.action.INSERT");
                                        intent.setType("vnd.android.cursor.dir/contact");
                                        intent.putExtra("phone", str);
                                        context.startActivity(intent);
                                        C7060h.pYm.mo8374X(10113, "1");
                                        AppMethodBeat.m2505o(28137);
                                        return;
                                    }
                                    C23314l.m35800bD(context2, replace);
                                    C7060h.pYm.mo8374X(10114, "1");
                                    AppMethodBeat.m2505o(28137);
                                    return;
                                case 1:
                                    C23314l.m35800bD(context2, replace);
                                    C7060h.pYm.mo8374X(10114, "1");
                                    break;
                            }
                            AppMethodBeat.m2505o(28137);
                        }
                    }, new C233112());
                    c30394k.dismiss();
                    AppMethodBeat.m2505o(28139);
                } else if (context2.getString(C25738R.string.ana).equals(str)) {
                    C14832a.m23084b(replace, replace);
                    C7060h.pYm.mo8374X(10115, "1");
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    c30394k.dismiss();
                    Toast.makeText(context2, context2.getString(C25738R.string.f9083oz), 1).show();
                    AppMethodBeat.m2505o(28139);
                } else if (context2.getString(C25738R.string.anc).equals(str)) {
                    C4990ab.m7410d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                    AppMethodBeat.m2505o(28139);
                } else {
                    if (C23314l.vsa.equals(str)) {
                        C23314l.m35796a((Activity) context2, str2, bundle2);
                        c30394k.dismiss();
                        if (onDismissListener2 != null) {
                            onDismissListener2.onDismiss(null);
                            AppMethodBeat.m2505o(28139);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                    c30394k.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    AppMethodBeat.m2505o(28139);
                }
            }
        };
        c30394k.show();
        AppMethodBeat.m2505o(28147);
    }

    private static boolean dlf() {
        AppMethodBeat.m2504i(28148);
        if (C23314l.dlg() || C23314l.dlh()) {
            AppMethodBeat.m2505o(28148);
            return true;
        }
        AppMethodBeat.m2505o(28148);
        return false;
    }

    static boolean dlg() {
        AppMethodBeat.m2504i(28149);
        Context context = C4996ah.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        boolean k = C5046bo.m7572k(context, intent);
        AppMethodBeat.m2505o(28149);
        return k;
    }

    static boolean dlh() {
        AppMethodBeat.m2504i(28150);
        boolean k = C5046bo.m7572k(C4996ah.getContext(), new Intent("android.intent.action.PICK", Contacts.CONTENT_URI));
        AppMethodBeat.m2505o(28150);
        return k;
    }

    /* renamed from: a */
    private static void m35795a(Activity activity, C7616ad c7616ad, String str, ArrayList<String> arrayList) {
        String str2;
        AppMethodBeat.m2504i(28151);
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
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(60, bck));
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
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
            c7616ad.mo14733jd(str3);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(c7616ad);
        }
        Toast.makeText(activity, activity.getString(C25738R.string.eto), 0).show();
        AppMethodBeat.m2505o(28151);
    }

    /* renamed from: bC */
    static /* synthetic */ void m35799bC(Context context, String str) {
        AppMethodBeat.m2504i(28152);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (C5046bo.m7572k(context, intent)) {
            context.startActivity(intent);
            AppMethodBeat.m2505o(28152);
            return;
        }
        C30379h.m48431a(context, (int) C25738R.string.an6, (int) C25738R.string.f9238tz, new C233198());
        AppMethodBeat.m2505o(28152);
    }

    /* renamed from: bD */
    static /* synthetic */ void m35800bD(Context context, String str) {
        AppMethodBeat.m2504i(28153);
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (C5046bo.m7572k(context, intent)) {
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(28153);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m35796a(Activity activity, String str, Bundle bundle) {
        AppMethodBeat.m2504i(28154);
        String nullAsNil = C5046bo.nullAsNil(bundle.getString("Contact_User"));
        if (nullAsNil == null) {
            C4990ab.m7412e("MicroMsg.MailPhoneMenuHelper", "username is null");
            AppMethodBeat.m2505o(28154);
            return;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(nullAsNil);
        if (aoO == null) {
            C4990ab.m7412e("MicroMsg.MailPhoneMenuHelper", "contact is null");
            AppMethodBeat.m2505o(28154);
            return;
        }
        int i;
        ArrayList arrayList;
        String string = bundle.getString("Contact_Mobile_MD5");
        String str2 = aoO.dur;
        if (!C5046bo.isNullOrNil(string)) {
            if (string == str) {
                i = 0;
            } else if (!aoO.mo16703Of()) {
                i = 1;
            }
            arrayList = new ArrayList();
            if (!C5046bo.isNullOrNil(str2)) {
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
                C23314l.m35795a(activity, aoO, nullAsNil, arrayList);
                C7060h.pYm.mo8381e(12040, aoO.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
                AppMethodBeat.m2505o(28154);
                return;
            }
            Toast.makeText(activity, activity.getString(C25738R.string.d1k), 0).show();
            AppMethodBeat.m2505o(28154);
            return;
        }
        i = 0;
        arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str2)) {
        }
        arrayList.add(str);
        if (arrayList.size() + i > 5) {
        }
    }
}
