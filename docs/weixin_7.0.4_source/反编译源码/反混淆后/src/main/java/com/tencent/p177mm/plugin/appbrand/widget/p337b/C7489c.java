package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p612ui.base.AuthorizeItemListView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.c */
public final class C7489c extends C6789b {
    private final String hBX;
    private AuthorizeItemListView jbH;
    private LinearLayout jbJ;
    private C7490b jbK;
    private final String mAppName;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.c$b */
    static final class C7490b extends BaseAdapter {
        private LinkedList<C7494c> jbN;

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.c$b$a */
        static final class C7491a {
            TextView jbS;
            ImageView jbT;

            private C7491a() {
            }

            /* synthetic */ C7491a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(102356);
            C7494c qv = m13045qv(i);
            AppMethodBeat.m2505o(102356);
            return qv;
        }

        C7490b(LinkedList<C7494c> linkedList) {
            this.jbN = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(102353);
            if (this.jbN == null) {
                AppMethodBeat.m2505o(102353);
                return 0;
            }
            int size = this.jbN.size();
            AppMethodBeat.m2505o(102353);
            return size;
        }

        /* renamed from: qv */
        private C7494c m13045qv(int i) {
            AppMethodBeat.m2504i(102354);
            C7494c c7494c = (C7494c) this.jbN.get(i);
            AppMethodBeat.m2505o(102354);
            return c7494c;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(102355);
            if (this.jbN == null || this.jbN.size() <= 0) {
                AppMethodBeat.m2505o(102355);
                return null;
            }
            C7491a c7491a;
            final C7494c qv = m13045qv(i);
            if (view == null) {
                C7491a c7491a2 = new C7491a();
                view = View.inflate(viewGroup.getContext(), 2130968786, null);
                c7491a2.jbT = (ImageView) view.findViewById(2131821546);
                c7491a2.jbS = (TextView) view.findViewById(2131821547);
                view.setTag(c7491a2);
                c7491a = c7491a2;
            } else {
                c7491a = (C7491a) view.getTag();
            }
            if (qv.state == 1) {
                c7491a.jbT.setImageResource(C25738R.drawable.b87);
            } else if (qv.state == 3) {
                c7491a.jbT.setImageResource(C25738R.drawable.b86);
            } else {
                c7491a.jbT.setImageResource(C25738R.drawable.b85);
            }
            c7491a.jbS.setText(qv.desc);
            final ImageView imageView = c7491a.jbT;
            c7491a.jbT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(102352);
                    if (qv.state == 2) {
                        imageView.setImageResource(C25738R.drawable.b87);
                        qv.state = 1;
                        AppMethodBeat.m2505o(102352);
                        return;
                    }
                    if (qv.state == 1) {
                        imageView.setImageResource(C25738R.drawable.b85);
                        qv.state = 2;
                    }
                    AppMethodBeat.m2505o(102352);
                }
            });
            AppMethodBeat.m2505o(102355);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.c$a */
    public interface C7493a {
        /* renamed from: b */
        void mo16722b(int i, ArrayList<String> arrayList);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.c$c */
    public static class C7494c {
        public String desc;
        public String scope;
        public int state;
    }

    public C7489c(Context context, final LinkedList<C7494c> linkedList, String str, String str2, final C7493a c7493a) {
        super(context, (byte) 0);
        AppMethodBeat.m2504i(102357);
        this.mContext = context;
        this.mAppName = C5046bo.nullAsNil(str);
        this.hBX = str2;
        if (linkedList == null || linkedList.size() <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scopeInfoList is empty or null");
            AppMethodBeat.m2505o(102357);
            throw illegalArgumentException;
        }
        View view = (ViewGroup) LayoutInflater.from(this.mContext).inflate(2130968661, null);
        setContentView(view);
        C37926b.abR().mo60682a((ImageView) view.findViewById(2131821137), this.hBX, (int) C25738R.drawable.bbn, C42201f.fqH);
        ((TextView) view.findViewById(2131821138)).setText(this.mContext.getString(C25738R.string.co1, new Object[]{this.mAppName}));
        this.jbH = (AuthorizeItemListView) view.findViewById(2131821140);
        this.jbK = new C7490b(linkedList);
        this.jbH.setAdapter(this.jbK);
        if (linkedList.size() > 5) {
            this.jbH.afg = linkedList.size();
            this.jbJ = (LinearLayout) view.findViewById(2131821139);
            LayoutParams layoutParams = (LayoutParams) this.jbJ.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.a3y);
            this.jbJ.setLayoutParams(layoutParams);
        }
        ((Button) view.findViewById(2131821143)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(102349);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((C7494c) linkedList.get(i2)).state == 2 || ((C7494c) linkedList.get(i2)).state == 3) {
                            arrayList.add(((C7494c) linkedList.get(i2)).scope);
                        }
                        i = i2 + 1;
                    } else {
                        C4990ab.m7416i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                        c7493a.mo16722b(1, arrayList);
                        this.dismiss();
                        AppMethodBeat.m2505o(102349);
                        return;
                    }
                }
            }
        });
        ((Button) view.findViewById(2131821142)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(102350);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((C7494c) linkedList.get(i2)).state == 2 || ((C7494c) linkedList.get(i2)).state == 3) {
                            arrayList.add(((C7494c) linkedList.get(i2)).scope);
                        }
                        i = i2 + 1;
                    } else {
                        C4990ab.m7416i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                        c7493a.mo16722b(2, arrayList);
                        this.dismiss();
                        AppMethodBeat.m2505o(102350);
                        return;
                    }
                }
            }
        });
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(102351);
                C4990ab.m7416i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                c7493a.mo16722b(3, null);
                AppMethodBeat.m2505o(102351);
            }
        });
        AppMethodBeat.m2505o(102357);
    }
}
