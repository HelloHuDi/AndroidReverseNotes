package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.a.a.d;
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
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class n {
    private Context context;
    private String hBX;
    AuthorizeItemListView jbH;
    private LinearLayout jbJ;
    private String mAppName = "";
    private b uKa;

    public interface a {
        void f(int i, Bundle bundle);
    }

    class b extends BaseAdapter {
        private LinkedList<buj> jbN;

        class a {
            TextView jbS;
            ImageView usE;

            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(79182);
            buj JT = JT(i);
            AppMethodBeat.o(79182);
            return JT;
        }

        public b(LinkedList<buj> linkedList) {
            this.jbN = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.i(79179);
            if (this.jbN == null) {
                AppMethodBeat.o(79179);
                return 0;
            }
            int size = this.jbN.size();
            AppMethodBeat.o(79179);
            return size;
        }

        private buj JT(int i) {
            AppMethodBeat.i(79180);
            buj buj = (buj) this.jbN.get(i);
            AppMethodBeat.o(79180);
            return buj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(79181);
            if (this.jbN == null || this.jbN.size() <= 0) {
                AppMethodBeat.o(79181);
                return null;
            }
            a aVar;
            final buj JT = JT(i);
            if (view == null) {
                a aVar2 = new a(this, (byte) 0);
                view = View.inflate(viewGroup.getContext(), R.layout.ez, null);
                aVar2.usE = (ImageView) view.findViewById(R.id.a02);
                aVar2.jbS = (TextView) view.findViewById(R.id.a03);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (JT.wWa == 1) {
                aVar.usE.setImageResource(R.raw.login_auth_state_not_selected);
            } else if (JT.wWa == 3) {
                aVar.usE.setImageResource(R.raw.login_auth_state_must_select);
            } else {
                aVar.usE.setImageResource(R.raw.login_auth_state_default_select);
            }
            aVar.jbS.setText(JT.Desc);
            final ImageView imageView = aVar.usE;
            aVar.usE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(79178);
                    if (JT.wWa == 2) {
                        imageView.setImageResource(R.raw.login_auth_state_not_selected);
                        JT.wWa = 1;
                        AppMethodBeat.o(79178);
                        return;
                    }
                    if (JT.wWa == 1) {
                        imageView.setImageResource(R.raw.login_auth_state_default_select);
                        JT.wWa = 2;
                    }
                    AppMethodBeat.o(79178);
                }
            });
            AppMethodBeat.o(79181);
            return view;
        }
    }

    public n(Context context) {
        this.context = context;
    }

    public final boolean a(LinkedList<buj> linkedList, String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(79183);
        ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
        this.mAppName = str;
        this.hBX = str2;
        boolean a = a(str3, linkedList, aVar);
        AppMethodBeat.o(79183);
        return a;
    }

    public final boolean a(LinkedList<buj> linkedList, String str, String str2, a aVar) {
        AppMethodBeat.i(79184);
        boolean a = a(linkedList, str, str2, null, aVar);
        AppMethodBeat.o(79184);
        return a;
    }

    private boolean a(String str, final LinkedList<buj> linkedList, final a aVar) {
        AppMethodBeat.i(79185);
        if (linkedList == null || linkedList.size() <= 0) {
            ab.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            AppMethodBeat.o(79185);
            return false;
        }
        final i iVar = new i(this.context, R.style.zv);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.ey, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.pa);
        if (!bo.isNullOrNil(str)) {
            textView.setText(str);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.pb);
        Drawable a = d.a(ah.getResources(), com.tencent.mm.compatible.g.a.decodeResource(ah.getResources(), R.raw.default_avatar));
        a.dA();
        if (imageView != null) {
            com.tencent.mm.modelappbrand.a.b.abR().a(imageView, this.hBX, a, f.fqH);
        }
        textView = (TextView) linearLayout.findViewById(R.id.pc);
        if (this.mAppName == null) {
            this.mAppName = "";
        }
        textView.setText(this.context.getString(R.string.co1, new Object[]{this.mAppName}));
        this.jbH = (AuthorizeItemListView) linearLayout.findViewById(R.id.pe);
        this.uKa = new b(linkedList);
        this.jbH.setAdapter(this.uKa);
        if (linkedList.size() > 5) {
            this.jbH.afg = linkedList.size();
            this.jbJ = (LinearLayout) linearLayout.findViewById(R.id.pd);
            LayoutParams layoutParams = (LayoutParams) this.jbJ.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(R.dimen.a3y);
            this.jbJ.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(R.id.ph)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(79174);
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
                        ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_scope", arrayList);
                        aVar.f(1, bundle);
                        iVar.dismiss();
                        AppMethodBeat.o(79174);
                        return;
                    }
                }
            }
        });
        ((Button) linearLayout.findViewById(R.id.pg)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(79175);
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
                        ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_scope", arrayList);
                        aVar.f(2, bundle);
                        iVar.dismiss();
                        AppMethodBeat.o(79175);
                        return;
                    }
                }
            }
        });
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(79176);
                if (n.this.jbH != null) {
                    n.this.jbH.setAdapter(null);
                }
                AppMethodBeat.o(79176);
            }
        });
        iVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(79177);
                ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.f(3, null);
                AppMethodBeat.o(79177);
            }
        });
        iVar.setContentView(linearLayout);
        try {
            iVar.show();
            AppMethodBeat.o(79185);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", e.getMessage());
            AppMethodBeat.o(79185);
            return false;
        }
    }
}
