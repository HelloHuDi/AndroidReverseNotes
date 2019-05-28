package com.tencent.mm.plugin.appbrand.widget.b;

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
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c extends b {
    private final String hBX;
    private AuthorizeItemListView jbH;
    private LinearLayout jbJ;
    private b jbK;
    private final String mAppName;
    private Context mContext;

    static final class b extends BaseAdapter {
        private LinkedList<c> jbN;

        static final class a {
            TextView jbS;
            ImageView jbT;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(102356);
            c qv = qv(i);
            AppMethodBeat.o(102356);
            return qv;
        }

        b(LinkedList<c> linkedList) {
            this.jbN = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.i(102353);
            if (this.jbN == null) {
                AppMethodBeat.o(102353);
                return 0;
            }
            int size = this.jbN.size();
            AppMethodBeat.o(102353);
            return size;
        }

        private c qv(int i) {
            AppMethodBeat.i(102354);
            c cVar = (c) this.jbN.get(i);
            AppMethodBeat.o(102354);
            return cVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(102355);
            if (this.jbN == null || this.jbN.size() <= 0) {
                AppMethodBeat.o(102355);
                return null;
            }
            a aVar;
            final c qv = qv(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.layout.ez, null);
                aVar2.jbT = (ImageView) view.findViewById(R.id.a02);
                aVar2.jbS = (TextView) view.findViewById(R.id.a03);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (qv.state == 1) {
                aVar.jbT.setImageResource(R.drawable.b87);
            } else if (qv.state == 3) {
                aVar.jbT.setImageResource(R.drawable.b86);
            } else {
                aVar.jbT.setImageResource(R.drawable.b85);
            }
            aVar.jbS.setText(qv.desc);
            final ImageView imageView = aVar.jbT;
            aVar.jbT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(102352);
                    if (qv.state == 2) {
                        imageView.setImageResource(R.drawable.b87);
                        qv.state = 1;
                        AppMethodBeat.o(102352);
                        return;
                    }
                    if (qv.state == 1) {
                        imageView.setImageResource(R.drawable.b85);
                        qv.state = 2;
                    }
                    AppMethodBeat.o(102352);
                }
            });
            AppMethodBeat.o(102355);
            return view;
        }
    }

    public interface a {
        void b(int i, ArrayList<String> arrayList);
    }

    public static class c {
        public String desc;
        public String scope;
        public int state;
    }

    public c(Context context, final LinkedList<c> linkedList, String str, String str2, final a aVar) {
        super(context, (byte) 0);
        AppMethodBeat.i(102357);
        this.mContext = context;
        this.mAppName = bo.nullAsNil(str);
        this.hBX = str2;
        if (linkedList == null || linkedList.size() <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scopeInfoList is empty or null");
            AppMethodBeat.o(102357);
            throw illegalArgumentException;
        }
        View view = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.bl, null);
        setContentView(view);
        com.tencent.mm.modelappbrand.a.b.abR().a((ImageView) view.findViewById(R.id.pb), this.hBX, (int) R.drawable.bbn, f.fqH);
        ((TextView) view.findViewById(R.id.pc)).setText(this.mContext.getString(R.string.co1, new Object[]{this.mAppName}));
        this.jbH = (AuthorizeItemListView) view.findViewById(R.id.pe);
        this.jbK = new b(linkedList);
        this.jbH.setAdapter(this.jbK);
        if (linkedList.size() > 5) {
            this.jbH.afg = linkedList.size();
            this.jbJ = (LinearLayout) view.findViewById(R.id.pd);
            LayoutParams layoutParams = (LayoutParams) this.jbJ.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.a3y);
            this.jbJ.setLayoutParams(layoutParams);
        }
        ((Button) view.findViewById(R.id.ph)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(102349);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((c) linkedList.get(i2)).state == 2 || ((c) linkedList.get(i2)).state == 3) {
                            arrayList.add(((c) linkedList.get(i2)).scope);
                        }
                        i = i2 + 1;
                    } else {
                        ab.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                        aVar.b(1, arrayList);
                        this.dismiss();
                        AppMethodBeat.o(102349);
                        return;
                    }
                }
            }
        });
        ((Button) view.findViewById(R.id.pg)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(102350);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((c) linkedList.get(i2)).state == 2 || ((c) linkedList.get(i2)).state == 3) {
                            arrayList.add(((c) linkedList.get(i2)).scope);
                        }
                        i = i2 + 1;
                    } else {
                        ab.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                        aVar.b(2, arrayList);
                        this.dismiss();
                        AppMethodBeat.o(102350);
                        return;
                    }
                }
            }
        });
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(102351);
                ab.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.b(3, null);
                AppMethodBeat.o(102351);
            }
        });
        AppMethodBeat.o(102357);
    }
}
