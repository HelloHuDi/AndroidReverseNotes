package com.tencent.p177mm.plugin.appbrand.jsapi.p312n;

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
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C27220ah;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C6789b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.b */
public final class C19447b extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.b$a */
    static final class C10493a extends BaseAdapter {
        private final ArrayList<String> hUW;
        private final int hUX;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.b$a$a */
        static final class C10494a {
            TextView gsf;

            private C10494a() {
            }

            /* synthetic */ C10494a(byte b) {
                this();
            }
        }

        public C10493a(ArrayList<String> arrayList, int i) {
            this.hUW = arrayList;
            this.hUX = i;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(74784);
            int size = this.hUW.size();
            AppMethodBeat.m2505o(74784);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(74785);
            String str = (String) this.hUW.get(i);
            AppMethodBeat.m2505o(74785);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C10494a c10494a;
            AppMethodBeat.m2504i(74786);
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), 2130968733, null);
                C10494a c10494a2 = new C10494a();
                c10494a2.gsf = (TextView) view.findViewById(2131820678);
                view.setTag(c10494a2);
                c10494a = c10494a2;
            } else {
                c10494a = (C10494a) view.getTag();
            }
            c10494a.gsf.setText(getItem(i));
            c10494a.gsf.setTextColor(this.hUX);
            AppMethodBeat.m2505o(74786);
            return view;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74788);
        final C38492q c38492q = (C38492q) c2241c;
        final C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView == null) {
            C4990ab.m7420w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(74788);
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
                    C5004al.m7441d(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.b$1$2 */
                        class C194502 implements OnCancelListener {
                            C194502() {
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(74782);
                                c38492q.mo6107M(i4, C19447b.this.mo73394j("cancel", null));
                                AppMethodBeat.m2505o(74782);
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(74783);
                            if (c38492q.isRunning()) {
                                currentPageView.aAX().mo21649a(C27220ah.ACTION_SHEET);
                                Activity ad = c38492q.mo61197ad(Activity.class);
                                final C6789b c6789b = new C6789b(ad);
                                c6789b.setCanceledOnTouchOutside(true);
                                int by = C42668g.m75559by(jSONObject2.optString("itemColor", ""), Color.parseColor("#000000"));
                                View view = (ViewGroup) View.inflate(ad, 2130968657, null);
                                c6789b.setContentView(view);
                                ListView listView = (ListView) view.findViewById(2131821130);
                                listView.setAdapter(new C10493a(arrayList, by));
                                listView.setOnItemClickListener(new OnItemClickListener() {
                                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                        AppMethodBeat.m2504i(74781);
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("tapIndex", Integer.valueOf(i));
                                        c38492q.mo6107M(i4, C19447b.this.mo73394j("ok", hashMap));
                                        c6789b.dismiss();
                                        AppMethodBeat.m2505o(74781);
                                    }
                                });
                                c6789b.setOnCancelListener(new C194502());
                                c38492q.asF().mo6468b(c6789b);
                                AppMethodBeat.m2505o(74783);
                                return;
                            }
                            AppMethodBeat.m2505o(74783);
                        }
                    });
                    AppMethodBeat.m2505o(74788);
                    return;
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiShowActionSheet", e.getMessage());
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(74788);
        }
    }
}
