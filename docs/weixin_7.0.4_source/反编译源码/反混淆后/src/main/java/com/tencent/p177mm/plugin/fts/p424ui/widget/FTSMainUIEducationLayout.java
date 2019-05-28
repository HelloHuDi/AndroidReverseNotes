package com.tencent.p177mm.plugin.fts.p424ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.service.C19734i;
import com.tencent.p177mm.plugin.appbrand.service.C19734i.C10734c;
import com.tencent.p177mm.plugin.appbrand.service.C19734i.C19733b;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout */
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
        AppMethodBeat.m2504i(62144);
        initView();
        AppMethodBeat.m2505o(62144);
    }

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62145);
        initView();
        AppMethodBeat.m2505o(62145);
    }

    private void initView() {
        AppMethodBeat.m2504i(62146);
        setOrientation(1);
        this.mMf = new ArrayList();
        AppMethodBeat.m2505o(62146);
    }

    public void setNeedHotWord(boolean z) {
        this.mMl = z;
    }

    /* renamed from: cu */
    public final void mo36197cu() {
        LinearLayout linearLayout;
        AppMethodBeat.m2504i(62147);
        bBu();
        try {
            if (!mo36194T(C29736ac.adL("educationTab"))) {
                bBv();
            }
        } catch (Exception e) {
            bBv();
        }
        try {
            if (this.mMl) {
                String optString = C29736ac.adL("educationHotword").optJSONArray("items").optJSONObject(0).optString("hotword");
                if (!C5046bo.isNullOrNil(optString)) {
                    linearLayout = (LinearLayout) FTSMainUIEducationLayout.inflate(getContext(), 2130969632, null);
                    ((TextView) linearLayout.findViewById(2131824251)).setText(optString);
                    linearLayout.setOnClickListener(this.mMn);
                    linearLayout.setTag(optString);
                    addView(linearLayout);
                    this.mMf.add(linearLayout);
                }
            }
        } catch (Exception e2) {
        }
        if (this.mMm) {
            C19733b axP = ((C19734i) C1720g.m3528K(C19734i.class)).axP();
            if (axP.items != null && axP.items.size() > 0) {
                String str;
                linearLayout = (LinearLayout) FTSMainUIEducationLayout.inflate(getContext(), 2130969633, null);
                ((TextView) linearLayout.findViewById(2131821185)).setText(axP.cEh);
                ImageView[] imageViewArr = new ImageView[]{(ImageView) linearLayout.findViewById(2131824253), (ImageView) linearLayout.findViewById(2131824254), (ImageView) linearLayout.findViewById(2131824255), (ImageView) linearLayout.findViewById(2131824256)};
                ImageView imageView = (ImageView) linearLayout.findViewById(2131824257);
                int i = 0;
                while (i < axP.items.size() && i < 4) {
                    C10734c c10734c = (C10734c) axP.items.get(i);
                    C17927a c17927a = new C17927a();
                    c17927a.ePT = C1318a.default_avatar;
                    c17927a.eQf = true;
                    C32291o.ahp().mo43766a(c10734c.haO, imageViewArr[i], c17927a.ahG());
                    imageViewArr[i].setVisibility(0);
                    imageViewArr[i].setTag(c10734c);
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
                    str2 = str + ((C10734c) it.next()).username + ";";
                }
                C7060h.pYm.mo8381e(14630, C3163e.mCM, axP.cEh, str, Integer.valueOf(axP.iDI), Long.valueOf(System.currentTimeMillis() / 1000));
            }
        }
        AppMethodBeat.m2505o(62147);
    }

    public void setNeedWXAPP(boolean z) {
        this.mMm = z;
    }

    /* renamed from: S */
    public final void mo36193S(JSONObject jSONObject) {
        AppMethodBeat.m2504i(62148);
        bBu();
        try {
            if (!mo36194T(jSONObject)) {
                bBv();
            }
            AppMethodBeat.m2505o(62148);
        } catch (Exception e) {
            bBv();
            AppMethodBeat.m2505o(62148);
        }
    }

    private void bBu() {
        AppMethodBeat.m2504i(62149);
        for (LinearLayout removeView : this.mMf) {
            removeView(removeView);
        }
        this.mMf.clear();
        this.mMg.clear();
        this.mMh = "";
        AppMethodBeat.m2505o(62149);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: T */
    public boolean mo36194T(JSONObject jSONObject) {
        AppMethodBeat.m2504i(62150);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(62150);
            return false;
        }
        jSONObject.optString("title");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            AppMethodBeat.m2505o(62150);
            return false;
        }
        int al;
        if (C4988aa.m7403gw(C4996ah.getContext()).equalsIgnoreCase("en")) {
            al = C1338a.m2856al(getContext(), C25738R.dimen.f9730dw);
        } else {
            al = C1338a.m2856al(getContext(), C25738R.dimen.f9980m5);
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
                mo36195a(str2, obj2, str, obj3, optJSONObject.optString("hotword"), optJSONObject, al);
                obj3 = null;
                obj2 = null;
                str = null;
                str2 = null;
            }
        }
        if (!(str2 == null || obj2 == null)) {
            mo36195a(str2, obj2, str, obj3, null, null, al);
        }
        AppMethodBeat.m2505o(62150);
        return true;
    }

    private void bBv() {
        AppMethodBeat.m2504i(62151);
        mo36195a(getContext().getString(C25738R.string.e0f), null, getContext().getString(C25738R.string.e0b), null, getContext().getString(C25738R.string.e0c), null, C1338a.m2856al(getContext(), C25738R.dimen.f9980m5));
        bBw();
        AppMethodBeat.m2505o(62151);
    }

    /* Access modifiers changed, original: protected */
    public void bBw() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo36195a(String str, Object obj, String str2, Object obj2, String str3, Object obj3, int i) {
        AppMethodBeat.m2504i(62152);
        C4990ab.m7417i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", str, str2, str3);
        if (!C5046bo.isNullOrNil(str)) {
            LinearLayout linearLayout = (LinearLayout) FTSMainUIEducationLayout.inflate(getContext(), 2130969630, null);
            TextView textView = (TextView) linearLayout.findViewById(2131824245);
            textView.setText(str);
            textView.setTag(obj);
            textView.setVisibility(0);
            textView.setOnClickListener(this.mJH);
            textView.setClickable(this.mMj);
            this.mMg.put(Integer.valueOf(C3201m.m5497a((JSONObject) obj, str, getContext())), textView);
            m32135bU(obj);
            if (!C5046bo.isNullOrNil(str2)) {
                textView = (TextView) linearLayout.findViewById(2131824247);
                textView.setText(str2);
                textView.setTag(obj2);
                textView.setVisibility(0);
                textView.setOnClickListener(this.mJH);
                textView.setClickable(this.mMj);
                View findViewById = linearLayout.findViewById(2131824246);
                findViewById.getLayoutParams().height = i;
                findViewById.setVisibility(0);
                this.mMg.put(Integer.valueOf(C3201m.m5497a((JSONObject) obj2, str2, getContext())), textView);
                m32135bU(obj2);
                if (!C5046bo.isNullOrNil(str3)) {
                    textView = (TextView) linearLayout.findViewById(2131824249);
                    textView.setText(str3);
                    textView.setTag(obj3);
                    textView.setVisibility(0);
                    textView.setOnClickListener(this.mJH);
                    textView.setClickable(this.mMj);
                    findViewById = linearLayout.findViewById(2131824248);
                    findViewById.getLayoutParams().height = i;
                    findViewById.setVisibility(0);
                    this.mMg.put(Integer.valueOf(C3201m.m5497a((JSONObject) obj3, str3, getContext())), textView);
                    m32135bU(obj3);
                }
            }
            this.mMf.add(linearLayout);
            addView(linearLayout);
        }
        AppMethodBeat.m2505o(62152);
    }

    /* renamed from: bU */
    private void m32135bU(Object obj) {
        AppMethodBeat.m2504i(62153);
        if (obj != null && (obj instanceof JSONObject)) {
            String optString = ((JSONObject) obj).optString("businessType");
            if (!C5046bo.isNullOrNil(optString)) {
                this.mMh = this.mMh == null ? "" : this.mMh;
                if (this.mMh.length() > 0) {
                    this.mMh += "|";
                }
                this.mMh += optString;
            }
        }
        AppMethodBeat.m2505o(62153);
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
        AppMethodBeat.m2504i(62154);
        for (Entry entry : this.mMg.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == i) {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
            } else {
                ((TextView) entry.getValue()).setTextColor(getContext().getResources().getColor(C25738R.color.a61));
            }
        }
        AppMethodBeat.m2505o(62154);
    }

    /* renamed from: wg */
    public final String mo36206wg(int i) {
        AppMethodBeat.m2504i(62155);
        TextView textView = (TextView) this.mMg.get(Integer.valueOf(i));
        String str;
        if (textView == null) {
            str = "";
            AppMethodBeat.m2505o(62155);
            return str;
        }
        str = textView.getText().toString();
        AppMethodBeat.m2505o(62155);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: H */
    public final void mo36192H(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(62156);
        C4990ab.m7419v("MicroMsg.FTS.FTSMainUIEducationLayout", "action %d", Integer.valueOf(motionEvent.getAction()));
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
                            AppMethodBeat.m2505o(62156);
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
                    C4990ab.m7419v("MicroMsg.FTS.FTSMainUIEducationLayout", "action up deltaX %f, deltaY %f, time interval %d", Float.valueOf(motionEvent.getRawX() - this.hke), Float.valueOf(motionEvent.getRawY() - this.hkf), Long.valueOf(System.currentTimeMillis() - this.mMi));
                    if (Math.abs(motionEvent.getRawX() - this.hke) <= this.ibD && Math.abs(r2) <= this.ibD && System.currentTimeMillis() - this.mMi < 200 && this.mJH != null) {
                        this.mJH.onClick(this.mMk);
                    }
                    this.mMk = null;
                    AppMethodBeat.m2505o(62156);
                    return;
                }
                break;
            case 3:
                this.mMk = null;
                break;
        }
        AppMethodBeat.m2505o(62156);
    }

    public void setCellClickable(boolean z) {
        this.mMj = z;
    }
}
