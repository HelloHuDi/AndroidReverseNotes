package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a<q> {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    static final class a extends BaseAdapter {
        private final ArrayList<String> hUW;
        private final int hUX;

        static final class a {
            TextView gsf;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public a(ArrayList<String> arrayList, int i) {
            this.hUW = arrayList;
            this.hUX = i;
        }

        public final int getCount() {
            AppMethodBeat.i(74784);
            int size = this.hUW.size();
            AppMethodBeat.o(74784);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.i(74785);
            String str = (String) this.hUW.get(i);
            AppMethodBeat.o(74785);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(74786);
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), R.layout.dj, null);
                a aVar2 = new a();
                aVar2.gsf = (TextView) view.findViewById(R.id.cx);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.gsf.setText(getItem(i));
            aVar.gsf.setTextColor(this.hUX);
            AppMethodBeat.o(74786);
            return view;
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74788);
        final q qVar = (q) cVar;
        final u currentPageView = qVar.getCurrentPageView();
        if (currentPageView == null) {
            ab.w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74788);
            return;
        }
        String optString = jSONObject.optString("itemList");
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < jSONArray.length()) {
                    arrayList.add((String) jSONArray.get(i3));
                    i2 = i3 + 1;
                } else {
                    final JSONObject jSONObject2 = jSONObject;
                    final int i4 = i;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74783);
                            if (qVar.isRunning()) {
                                currentPageView.aAX().a(ah.ACTION_SHEET);
                                Activity ad = qVar.ad(Activity.class);
                                final com.tencent.mm.plugin.appbrand.widget.b.b bVar = new com.tencent.mm.plugin.appbrand.widget.b.b(ad);
                                bVar.setCanceledOnTouchOutside(true);
                                int by = g.by(jSONObject2.optString("itemColor", ""), Color.parseColor("#000000"));
                                View view = (ViewGroup) View.inflate(ad, R.layout.bh, null);
                                bVar.setContentView(view);
                                ListView listView = (ListView) view.findViewById(R.id.p5);
                                listView.setAdapter(new a(arrayList, by));
                                listView.setOnItemClickListener(new OnItemClickListener() {
                                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                        AppMethodBeat.i(74781);
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("tapIndex", Integer.valueOf(i));
                                        qVar.M(i4, b.this.j("ok", hashMap));
                                        bVar.dismiss();
                                        AppMethodBeat.o(74781);
                                    }
                                });
                                bVar.setOnCancelListener(new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(74782);
                                        qVar.M(i4, b.this.j("cancel", null));
                                        AppMethodBeat.o(74782);
                                    }
                                });
                                qVar.asF().b(bVar);
                                AppMethodBeat.o(74783);
                                return;
                            }
                            AppMethodBeat.o(74783);
                        }
                    });
                    AppMethodBeat.o(74788);
                    return;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiShowActionSheet", e.getMessage());
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74788);
        }
    }
}
