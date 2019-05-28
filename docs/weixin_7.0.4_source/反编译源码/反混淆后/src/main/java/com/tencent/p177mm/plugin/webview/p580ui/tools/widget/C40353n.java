package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p057v4.p058a.p059a.C37112d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p612ui.base.AuthorizeItemListView;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.protocal.protobuf.buj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.n */
public final class C40353n {
    private Context context;
    private String hBX;
    AuthorizeItemListView jbH;
    private LinearLayout jbJ;
    private String mAppName = "";
    private C29968b uKa;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.n$a */
    public interface C23160a {
        /* renamed from: f */
        void mo5953f(int i, Bundle bundle);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.n$b */
    class C29968b extends BaseAdapter {
        private LinkedList<buj> jbN;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.n$b$a */
        class C29969a {
            TextView jbS;
            ImageView usE;

            private C29969a() {
            }

            /* synthetic */ C29969a(C29968b c29968b, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(79182);
            buj JT = m47415JT(i);
            AppMethodBeat.m2505o(79182);
            return JT;
        }

        public C29968b(LinkedList<buj> linkedList) {
            this.jbN = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(79179);
            if (this.jbN == null) {
                AppMethodBeat.m2505o(79179);
                return 0;
            }
            int size = this.jbN.size();
            AppMethodBeat.m2505o(79179);
            return size;
        }

        /* renamed from: JT */
        private buj m47415JT(int i) {
            AppMethodBeat.m2504i(79180);
            buj buj = (buj) this.jbN.get(i);
            AppMethodBeat.m2505o(79180);
            return buj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(79181);
            if (this.jbN == null || this.jbN.size() <= 0) {
                AppMethodBeat.m2505o(79181);
                return null;
            }
            C29969a c29969a;
            final buj JT = m47415JT(i);
            if (view == null) {
                C29969a c29969a2 = new C29969a(this, (byte) 0);
                view = View.inflate(viewGroup.getContext(), 2130968786, null);
                c29969a2.usE = (ImageView) view.findViewById(2131821546);
                c29969a2.jbS = (TextView) view.findViewById(2131821547);
                view.setTag(c29969a2);
                c29969a = c29969a2;
            } else {
                c29969a = (C29969a) view.getTag();
            }
            if (JT.wWa == 1) {
                c29969a.usE.setImageResource(C1318a.login_auth_state_not_selected);
            } else if (JT.wWa == 3) {
                c29969a.usE.setImageResource(C1318a.login_auth_state_must_select);
            } else {
                c29969a.usE.setImageResource(C1318a.login_auth_state_default_select);
            }
            c29969a.jbS.setText(JT.Desc);
            final ImageView imageView = c29969a.usE;
            c29969a.usE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(79178);
                    if (JT.wWa == 2) {
                        imageView.setImageResource(C1318a.login_auth_state_not_selected);
                        JT.wWa = 1;
                        AppMethodBeat.m2505o(79178);
                        return;
                    }
                    if (JT.wWa == 1) {
                        imageView.setImageResource(C1318a.login_auth_state_default_select);
                        JT.wWa = 2;
                    }
                    AppMethodBeat.m2505o(79178);
                }
            });
            AppMethodBeat.m2505o(79181);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.n$3 */
    class C403523 implements OnDismissListener {
        C403523() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(79176);
            if (C40353n.this.jbH != null) {
                C40353n.this.jbH.setAdapter(null);
            }
            AppMethodBeat.m2505o(79176);
        }
    }

    public C40353n(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public final boolean mo63720a(LinkedList<buj> linkedList, String str, String str2, String str3, C23160a c23160a) {
        AppMethodBeat.m2504i(79183);
        C4990ab.m7410d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
        this.mAppName = str;
        this.hBX = str2;
        boolean a = m69190a(str3, linkedList, c23160a);
        AppMethodBeat.m2505o(79183);
        return a;
    }

    /* renamed from: a */
    public final boolean mo63719a(LinkedList<buj> linkedList, String str, String str2, C23160a c23160a) {
        AppMethodBeat.m2504i(79184);
        boolean a = mo63720a(linkedList, str, str2, null, c23160a);
        AppMethodBeat.m2505o(79184);
        return a;
    }

    /* renamed from: a */
    private boolean m69190a(String str, final LinkedList<buj> linkedList, final C23160a c23160a) {
        AppMethodBeat.m2504i(79185);
        if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            AppMethodBeat.m2505o(79185);
            return false;
        }
        final C15532i c15532i = new C15532i(this.context, C25738R.style.f11417zv);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(2130968785, null);
        TextView textView = (TextView) linearLayout.findViewById(2131821136);
        if (!C5046bo.isNullOrNil(str)) {
            textView.setText(str);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(2131821137);
        Drawable a = C37112d.m62123a(C4996ah.getResources(), C1434a.decodeResource(C4996ah.getResources(), C1318a.default_avatar));
        a.mo59157dA();
        if (imageView != null) {
            C37926b.abR().mo60683a(imageView, this.hBX, a, C42201f.fqH);
        }
        textView = (TextView) linearLayout.findViewById(2131821138);
        if (this.mAppName == null) {
            this.mAppName = "";
        }
        textView.setText(this.context.getString(C25738R.string.co1, new Object[]{this.mAppName}));
        this.jbH = (AuthorizeItemListView) linearLayout.findViewById(2131821140);
        this.uKa = new C29968b(linkedList);
        this.jbH.setAdapter(this.uKa);
        if (linkedList.size() > 5) {
            this.jbH.afg = linkedList.size();
            this.jbJ = (LinearLayout) linearLayout.findViewById(2131821139);
            LayoutParams layoutParams = (LayoutParams) this.jbJ.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(C25738R.dimen.a3y);
            this.jbJ.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(2131821143)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(79174);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((buj) linkedList.get(i2)).wWa == 2 || ((buj) linkedList.get(i2)).wWa == 3) {
                            arrayList.add(((buj) linkedList.get(i2)).vOF);
                        }
                        i = i2 + 1;
                    } else {
                        C4990ab.m7410d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_scope", arrayList);
                        c23160a.mo5953f(1, bundle);
                        c15532i.dismiss();
                        AppMethodBeat.m2505o(79174);
                        return;
                    }
                }
            }
        });
        ((Button) linearLayout.findViewById(2131821142)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(79175);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((buj) linkedList.get(i2)).wWa == 2 || ((buj) linkedList.get(i2)).wWa == 3) {
                            arrayList.add(((buj) linkedList.get(i2)).vOF);
                        }
                        i = i2 + 1;
                    } else {
                        C4990ab.m7410d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_scope", arrayList);
                        c23160a.mo5953f(2, bundle);
                        c15532i.dismiss();
                        AppMethodBeat.m2505o(79175);
                        return;
                    }
                }
            }
        });
        c15532i.setCanceledOnTouchOutside(false);
        c15532i.setOnDismissListener(new C403523());
        c15532i.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(79177);
                C4990ab.m7410d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                c23160a.mo5953f(3, null);
                AppMethodBeat.m2505o(79177);
            }
        });
        c15532i.setContentView(linearLayout);
        try {
            c15532i.show();
            AppMethodBeat.m2505o(79185);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", e.getMessage());
            AppMethodBeat.m2505o(79185);
            return false;
        }
    }
}
