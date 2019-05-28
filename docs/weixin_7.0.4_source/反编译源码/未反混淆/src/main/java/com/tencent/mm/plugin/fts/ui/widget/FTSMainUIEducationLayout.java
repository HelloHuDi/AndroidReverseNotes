package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.appbrand.service.i.b;
import com.tencent.mm.plugin.appbrand.service.i.c;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayout extends LinearLayout {
    private float hke;
    private float hkf;
    private float ibD = ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
    protected OnClickListener mJH;
    protected List<LinearLayout> mMf;
    protected Map<Integer, TextView> mMg = new HashMap();
    private String mMh = "";
    private long mMi;
    private boolean mMj = true;
    private TextView mMk;
    protected boolean mMl = true;
    private boolean mMm;
    public OnClickListener mMn;
    private OnClickListener mMo;

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62144);
        initView();
        AppMethodBeat.o(62144);
    }

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62145);
        initView();
        AppMethodBeat.o(62145);
    }

    private void initView() {
        AppMethodBeat.i(62146);
        setOrientation(1);
        this.mMf = new ArrayList();
        AppMethodBeat.o(62146);
    }

    public void setNeedHotWord(boolean z) {
        this.mMl = z;
    }

    public final void cu() {
        LinearLayout linearLayout;
        AppMethodBeat.i(62147);
        bBu();
        try {
            if (!T(ac.adL("educationTab"))) {
                bBv();
            }
        } catch (Exception e) {
            bBv();
        }
        try {
            if (this.mMl) {
                String optString = ac.adL("educationHotword").optJSONArray("items").optJSONObject(0).optString("hotword");
                if (!bo.isNullOrNil(optString)) {
                    linearLayout = (LinearLayout) inflate(getContext(), R.layout.a1q, null);
                    ((TextView) linearLayout.findViewById(R.id.bz7)).setText(optString);
                    linearLayout.setOnClickListener(this.mMn);
                    linearLayout.setTag(optString);
                    addView(linearLayout);
                    this.mMf.add(linearLayout);
                }
            }
        } catch (Exception e2) {
        }
        if (this.mMm) {
            b axP = ((i) g.K(i.class)).axP();
            if (axP.items != null && axP.items.size() > 0) {
                String str;
                linearLayout = (LinearLayout) inflate(getContext(), R.layout.a1r, null);
                ((TextView) linearLayout.findViewById(R.id.qm)).setText(axP.cEh);
                ImageView[] imageViewArr = new ImageView[]{(ImageView) linearLayout.findViewById(R.id.bz9), (ImageView) linearLayout.findViewById(R.id.bz_), (ImageView) linearLayout.findViewById(R.id.bza), (ImageView) linearLayout.findViewById(R.id.bzb)};
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.bzc);
                int i = 0;
                while (i < axP.items.size() && i < 4) {
                    c cVar = (c) axP.items.get(i);
                    a aVar = new a();
                    aVar.ePT = R.raw.default_avatar;
                    aVar.eQf = true;
                    o.ahp().a(cVar.haO, imageViewArr[i], aVar.ahG());
                    imageViewArr[i].setVisibility(0);
                    imageViewArr[i].setTag(cVar);
                    if (this.mMo != null) {
                        imageViewArr[i].setOnClickListener(this.mMo);
                    }
                    i++;
                }
                if (axP.items.size() > 0) {
                    imageView.setVisibility(0);
                    imageView.setTag("more-click");
                    imageView.setOnClickListener(this.mMo);
                }
                addView(linearLayout);
                this.mMf.add(linearLayout);
                String str2 = "";
                Iterator it = axP.items.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + ((c) it.next()).username + ";";
                }
                h.pYm.e(14630, e.mCM, axP.cEh, str, Integer.valueOf(axP.iDI), Long.valueOf(System.currentTimeMillis() / 1000));
            }
        }
        AppMethodBeat.o(62147);
    }

    public void setNeedWXAPP(boolean z) {
        this.mMm = z;
    }

    public final void S(JSONObject jSONObject) {
        AppMethodBeat.i(62148);
        bBu();
        try {
            if (!T(jSONObject)) {
                bBv();
            }
            AppMethodBeat.o(62148);
        } catch (Exception e) {
            bBv();
            AppMethodBeat.o(62148);
        }
    }

    private void bBu() {
        AppMethodBeat.i(62149);
        for (LinearLayout removeView : this.mMf) {
            removeView(removeView);
        }
        this.mMf.clear();
        this.mMg.clear();
        this.mMh = "";
        AppMethodBeat.o(62149);
    }

    /* Access modifiers changed, original: protected */
    public boolean T(JSONObject jSONObject) {
        AppMethodBeat.i(62150);
        if (jSONObject == null) {
            AppMethodBeat.o(62150);
            return false;
        }
        jSONObject.optString("title");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            AppMethodBeat.o(62150);
            return false;
        }
        int al;
        if (aa.gw(ah.getContext()).equalsIgnoreCase("en")) {
            al = com.tencent.mm.bz.a.al(getContext(), R.dimen.dw);
        } else {
            al = com.tencent.mm.bz.a.al(getContext(), R.dimen.m5);
        }
        Object obj = null;
        Object obj2 = null;
        String str = null;
        String str2 = null;
        for (int i = 0; i < Math.min(optJSONArray.length(), 9); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
                obj2 = optJSONObject;
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject obj3 = optJSONObject;
            } else {
                a(str2, obj2, str, obj3, optJSONObject.optString("hotword"), optJSONObject, al);
                obj3 = null;
                obj2 = null;
                str = null;
                str2 = null;
            }
        }
        if (!(str2 == null || obj2 == null)) {
            a(str2, obj2, str, obj3, null, null, al);
        }
        AppMethodBeat.o(62150);
        return true;
    }

    private void bBv() {
        AppMethodBeat.i(62151);
        a(getContext().getString(R.string.e0f), null, getContext().getString(R.string.e0b), null, getContext().getString(R.string.e0c), null, com.tencent.mm.bz.a.al(getContext(), R.dimen.m5));
        bBw();
        AppMethodBeat.o(62151);
    }

    /* Access modifiers changed, original: protected */
    public void bBw() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, Object obj, String str2, Object obj2, String str3, Object obj3, int i) {
        AppMethodBeat.i(62152);
        ab.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", str, str2, str3);
        if (!bo.isNullOrNil(str)) {
            LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.layout.a1o, null);
            TextView textView = (TextView) linearLayout.findViewById(R.id.bz1);
            textView.setText(str);
            textView.setTag(obj);
            textView.setVisibility(0);
            textView.setOnClickListener(this.mJH);
            textView.setClickable(this.mMj);
            this.mMg.put(Integer.valueOf(m.a((JSONObject) obj, str, getContext())), textView);
            bU(obj);
            if (!bo.isNullOrNil(str2)) {
                textView = (TextView) linearLayout.findViewById(R.id.bz3);
                textView.setText(str2);
                textView.setTag(obj2);
                textView.setVisibility(0);
                textView.setOnClickListener(this.mJH);
                textView.setClickable(this.mMj);
                View findViewById = linearLayout.findViewById(R.id.bz2);
                findViewById.getLayoutParams().height = i;
                findViewById.setVisibility(0);
                this.mMg.put(Integer.valueOf(m.a((JSONObject) obj2, str2, getContext())), textView);
                bU(obj2);
                if (!bo.isNullOrNil(str3)) {
                    textView = (TextView) linearLayout.findViewById(R.id.bz5);
                    textView.setText(str3);
                    textView.setTag(obj3);
                    textView.setVisibility(0);
                    textView.setOnClickListener(this.mJH);
                    textView.setClickable(this.mMj);
                    findViewById = linearLayout.findViewById(R.id.bz4);
                    findViewById.getLayoutParams().height = i;
                    findViewById.setVisibility(0);
                    this.mMg.put(Integer.valueOf(m.a((JSONObject) obj3, str3, getContext())), textView);
                    bU(obj3);
                }
            }
            this.mMf.add(linearLayout);
            addView(linearLayout);
        }
        AppMethodBeat.o(62152);
    }

    private void bU(Object obj) {
        AppMethodBeat.i(62153);
        if (obj != null && (obj instanceof JSONObject)) {
            String optString = ((JSONObject) obj).optString("businessType");
            if (!bo.isNullOrNil(optString)) {
                this.mMh = this.mMh == null ? "" : this.mMh;
                if (this.mMh.length() > 0) {
                    this.mMh += "|";
                }
                this.mMh += optString;
            }
        }
        AppMethodBeat.o(62153);
    }

    public String getVertBizTypes() {
        return this.mMh == null ? "" : this.mMh;
    }

    public void setOnCellClickListener(OnClickListener onClickListener) {
        this.mJH = onClickListener;
    }

    public void setOnHotwordClickListener(OnClickListener onClickListener) {
        this.mMn = onClickListener;
    }

    public void setOnWxAppClickListener(OnClickListener onClickListener) {
        this.mMo = onClickListener;
    }

    public void setSelected(int i) {
        AppMethodBeat.i(62154);
        for (Entry entry : this.mMg.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == i) {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
            } else {
                ((TextView) entry.getValue()).setTextColor(getContext().getResources().getColor(R.color.a61));
            }
        }
        AppMethodBeat.o(62154);
    }

    public final String wg(int i) {
        AppMethodBeat.i(62155);
        TextView textView = (TextView) this.mMg.get(Integer.valueOf(i));
        String str;
        if (textView == null) {
            str = "";
            AppMethodBeat.o(62155);
            return str;
        }
        str = textView.getText().toString();
        AppMethodBeat.o(62155);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(MotionEvent motionEvent) {
        AppMethodBeat.i(62156);
        ab.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action %d", Integer.valueOf(motionEvent.getAction()));
        switch (motionEvent.getAction()) {
            case 0:
                for (TextView textView : this.mMg.values()) {
                    int[] iArr = new int[2];
                    textView.getLocationOnScreen(iArr);
                    if (new Rect(iArr[0], iArr[1], iArr[0] + textView.getWidth(), iArr[1] + textView.getHeight()).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        if (textView != null) {
                            this.mMk = textView;
                            this.hke = motionEvent.getRawX();
                            this.hkf = motionEvent.getRawY();
                            this.mMi = System.currentTimeMillis();
                            AppMethodBeat.o(62156);
                            return;
                        }
                    }
                }
                TextView textView2 = null;
                if (textView2 != null) {
                }
                break;
            case 1:
            case 9:
                if (this.mMk != null) {
                    ab.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action up deltaX %f, deltaY %f, time interval %d", Float.valueOf(motionEvent.getRawX() - this.hke), Float.valueOf(motionEvent.getRawY() - this.hkf), Long.valueOf(System.currentTimeMillis() - this.mMi));
                    if (Math.abs(motionEvent.getRawX() - this.hke) <= this.ibD && Math.abs(r2) <= this.ibD && System.currentTimeMillis() - this.mMi < 200 && this.mJH != null) {
                        this.mJH.onClick(this.mMk);
                    }
                    this.mMk = null;
                    AppMethodBeat.o(62156);
                    return;
                }
                break;
            case 3:
                this.mMk = null;
                break;
        }
        AppMethodBeat.o(62156);
    }

    public void setCellClickable(boolean z) {
        this.mMj = z;
    }
}
